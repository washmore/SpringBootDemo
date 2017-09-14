package tech.washmore.demo.springboot.majiang;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class 牌局 {
    public List<麻将> majiangLeft = new ArrayList<>();

    private 牌局() {

    }

    public static 牌局 开始牌局() {
        return new 牌局();
    }

    public void 洗牌() {
        if (CollectionUtils.isNotEmpty(majiangLeft)) {
            throw new IllegalArgumentException("一局牌只能洗牌一次!");
        }
        Arrays.stream(麻将.values()).forEach(m -> {
            majiangLeft.add(m);
            majiangLeft.add(m);
            majiangLeft.add(m);
            majiangLeft.add(m);
        });
    }

    public 麻将 发牌() {
        if (majiangLeft.size() == 0) {
            throw new IllegalArgumentException("已经没有剩余牌了");
        }
        return majiangLeft.remove(new Random().nextInt(majiangLeft.size()));
    }

    public 麻将 发指定牌(麻将 m) {
        for (麻将 leftM : majiangLeft) {
            if (leftM == m) {
                majiangLeft.remove(m);
                return m;
            }
        }
        throw new IllegalArgumentException("没有这种牌了");
    }
}
