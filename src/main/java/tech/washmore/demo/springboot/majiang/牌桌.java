package tech.washmore.demo.springboot.majiang;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class 牌桌 {
    public static List<麻将> majiangLeft = new ArrayList<>();

    public static final boolean 是否包含红中牌型作为赖子 = false;

    public static void 洗牌() {
        for (麻将 m : 麻将.values()) {
            if (!是否包含红中牌型作为赖子 && m == 麻将.红中) {
                continue;
            }
            majiangLeft.add(m);
            majiangLeft.add(m);
            majiangLeft.add(m);
            majiangLeft.add(m);
        }
    }

    public static 麻将 发牌() {
        if (majiangLeft.size() == 0) {
            throw new IllegalArgumentException("已经没有剩余牌了");

        }
        return majiangLeft.remove(new Random().nextInt(majiangLeft.size()));
    }

    public static 麻将 发指定牌(麻将 m) {
        for (麻将 leftM : majiangLeft) {
            if (leftM == m) {
                majiangLeft.remove(m);
                return m;
            }
        }
        throw new IllegalArgumentException("没有这种牌了");
    }

}
