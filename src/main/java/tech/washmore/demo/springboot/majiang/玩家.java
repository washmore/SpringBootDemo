package tech.washmore.demo.springboot.majiang;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 玩家 {
    private List<麻将> 手牌;

    private int 红中数量;
    private List<麻将> 非红中赖子牌;
    private List<List<麻将>> 归类的手牌;
    private List<List<麻将>> 归类去除掌门的手牌;

    private List<List<麻将>> 红中可能替换的牌型;

    public void 顺牌() {
        if (CollectionUtils.isEmpty(手牌)) {
            return;
        }
        手牌.sort(new Comparator<麻将>() {
            @Override
            public int compare(麻将 m1, 麻将 m2) {
                if (m1.get花色() == m2.get花色()) {
                    return m1.get点数() - m2.get点数() > 0 ? 1 : -1;
                }
                return m1.get花色() - m2.get花色();
            }
        });
    }

    public boolean 判断是否胡牌() {
        this.顺牌();
        this.标记红中赖子();
        if (红中数量 == 4) {
            return true;
        } else if (红中数量 > 0) {
            return 判断包含红中的手牌是否胡牌();
        } else {
            return 判断不包含红中的手牌是否胡牌();
        }
    }

    private void 标记红中赖子() {
        for (麻将 m : 手牌) {
            if (麻将.红中 == m) {
                红中数量++;
            } else {
                非红中赖子牌.add(m);
            }
        }
    }

    public boolean 判断包含红中的手牌是否胡牌() {
        this.汇总红中可替代牌型();
        for (List<麻将> 赖子牌型 : 红中可能替换的牌型) {
            赖子牌型.addAll(非红中赖子牌);
            手牌 = 赖子牌型;
            if (判断不包含红中的手牌是否胡牌()) {
                return true;
            }
        }
        return false;
    }

    private void 汇总红中可替代牌型() {
        if (红中数量-- > 0) {
            for (麻将 m : 麻将.values()) {
                if (CollectionUtils.isEmpty(红中可能替换的牌型)) {
                    红中可能替换的牌型 = new ArrayList<>();
                }
                for (List<麻将> temp : 红中可能替换的牌型) {
                    temp.add(m);
                }
            }
            汇总红中可替代牌型();
        }
    }

    public boolean 判断不包含红中的手牌是否胡牌() {
        if (!归类手牌()) {
            return false;
        }

        归类去除掌门的手牌();
        //TODO 未完待续;
        return false;

    }

    private void 归类去除掌门的手牌() {
        for (List<麻将> temp : 归类的手牌) {
            if (CollectionUtils.size(temp) >= 2) {
                归类去除掌门的手牌 = new ArrayList<>();
                for (List<麻将> temp2 : 归类的手牌) {

                }
            }
        }
    }

    private boolean 归类手牌() {
        for (麻将 m : 手牌) {
            if (CollectionUtils.isEmpty(归类的手牌)) {
                归类的手牌 = new ArrayList<>();
            }
            boolean 经过红中赖子替换后某一个牌型超过四个 = false;
            boolean 手牌是否归类 = false;
            for (List<麻将> temp : 归类的手牌) {
                if (temp.contains(m)) {
                    temp.add(m);
                    手牌是否归类 = true;
                }
                if (CollectionUtils.size(temp) > 4) {
                    经过红中赖子替换后某一个牌型超过四个 = true;
                }
            }
            if (经过红中赖子替换后某一个牌型超过四个) {
                return false;
            }
            if (!手牌是否归类) {
                List<麻将> 新牌型 = Arrays.asList(m);
                归类的手牌.add(新牌型);
            }
        }
        return true;
    }


}
