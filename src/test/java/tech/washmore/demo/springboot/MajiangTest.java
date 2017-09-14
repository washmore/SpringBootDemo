package tech.washmore.demo.springboot;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import tech.washmore.demo.springboot.majiang.牌局;
import tech.washmore.demo.springboot.majiang.麻将;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class MajiangTest {
    @Test
    public void play() {
        while (true) {
            牌局 station = 牌局.开始牌局();
            station.洗牌();
            List<麻将> 手牌 = new ArrayList<>();
            IntStream.rangeClosed(1, 14).forEach(i -> 手牌.add(station.发牌()));
//        手牌.add(station.发指定牌(麻将.一万));
//        手牌.add(station.发指定牌(麻将.一万));
//        手牌.add(station.发指定牌(麻将.一万));
//        手牌.add(station.发指定牌(麻将.二万));
//        手牌.add(station.发指定牌(麻将.三万));
//        手牌.add(station.发指定牌(麻将.四万));
//        手牌.add(station.发指定牌(麻将.五万));
//        手牌.add(station.发指定牌(麻将.六万));
//        手牌.add(station.发指定牌(麻将.七万));
//        手牌.add(station.发指定牌(麻将.八万));
//        手牌.add(station.发指定牌(麻将.九万));
//        手牌.add(station.发指定牌(麻将.九万));
//        手牌.add(station.发指定牌(麻将.九万));
//        手牌.add(station.发指定牌(麻将.九万));
            // System.out.println(手牌);
            List<List<麻将>> 分组牌 = 手牌.stream().collect(Collectors.groupingBy(x -> x.get花色() + ":" + x.get点数())).values().stream().sorted((l1, l2) -> {
                if (l1.get(0).get花色() == l2.get(0).get花色()) {
                    return l1.get(0).get点数() - l2.get(0).get点数();
                }
                return l1.get(0).get花色() - l2.get(0).get花色();
            }).collect(Collectors.toList());
            boolean 是否胡牌 = false;
            //验证将军
            if (分组牌.stream().filter(l -> CollectionUtils.size(l) >= 2).count() > 0) {
                for (int i = 0; i < 分组牌.size(); i++) {
                    List<麻将> t = 分组牌.get(i);
                    if (t.size() >= 2) {
                        List<List<麻将>> 分组牌副本 = 深度复制(分组牌);
                        分组牌副本.get(i).remove(0);
                        分组牌副本.get(i).remove(0);
                        if (验证3N(分组牌副本)) {
                            是否胡牌 = true;
                            break;
                        }
                    }
                }
            } else {
                System.out.println("没有掌门,无法胡牌...");
            }
            手牌.sort(Comparator.comparing(麻将::get花色).thenComparing(麻将::get点数));
            System.out.print("手牌:\t");
            System.out.println(手牌);
            System.out.print("分组:\t");
            System.out.println(分组牌);
            System.out.println("是否胡牌?" + 是否胡牌 + "\n");
            if (是否胡牌) {
                break;
            }
        }

    }

    private boolean 验证3N(List<List<麻将>> 分组牌副本) {
        List<List<麻将>> trimList = 分组牌副本.stream().filter(l -> l.size() > 0).collect(Collectors.toList());
        if (trimList == null || trimList.size() == 0) {
            return true;
        }
        List<麻将> check = trimList.get(0);
        if (check.size() > 3) {
            if (!处理顺子(trimList)) {
                return false;
            }
        } else if (check.size() == 1 || check.size() == 2) {
            if (!处理顺子(trimList)) {
                return false;
            }
        } else if (check.size() == 3) {
            trimList.get(0).removeAll(check);
        }
        return 验证3N(trimList);
    }

    public static boolean 处理顺子(List<List<麻将>> trimList) {
        if (trimList.size() < 3) {
            return false;
        }
        麻将 first = trimList.get(0).get(0);
        麻将 second = trimList.get(1).get(0);
        麻将 third = trimList.get(2).get(0);
        if (!(first.get花色() == second.get花色() && first.get花色() == third.get花色()//
                && first.get点数() == second.get点数() - 1 && first.get点数() == third.get点数() - 2)) {
            return false;
        }
        trimList.get(0).remove(0);
        trimList.get(1).remove(0);
        trimList.get(2).remove(0);
        return true;
    }

    public static List<List<麻将>> 深度复制(List<List<麻将>> source) {
        List<List<麻将>> target = new ArrayList<>();
        if (source == null || source.size() == 0) {
            return target;
        }
        for (List<麻将> l : source) {
            if (CollectionUtils.isEmpty(l)) {
                continue;
            }
            List<麻将> l2 = new ArrayList<>();
            for (麻将 m : l) {
                l2.add(麻将.获取指定牌型麻将(m.get花色(), m.get点数()));
            }
            target.add(l2);
        }
        return target;
    }
}
