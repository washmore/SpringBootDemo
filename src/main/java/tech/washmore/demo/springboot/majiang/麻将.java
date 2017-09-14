package tech.washmore.demo.springboot.majiang;

public enum 麻将 {
    //红中(0, 0),
    一饼(1, 1),
    二饼(1, 2),
    三饼(1, 3),
    四饼(1, 4),
    五饼(1, 5),
    六饼(1, 6),
    七饼(1, 7),
    八饼(1, 8),
    九饼(1, 9),
    一条(2, 1),
    二条(2, 2),
    三条(2, 3),
    四条(2, 4),
    五条(2, 5),
    六条(2, 6),
    七条(2, 7),
    八条(2, 8),
    九条(2, 9),
    一万(3, 1),
    二万(3, 2),
    三万(3, 3),
    四万(3, 4),
    五万(3, 5),
    六万(3, 6),
    七万(3, 7),
    八万(3, 8),
    九万(3, 9);

    private int 花色;
    private int 点数;

    public int get花色() {
        return 花色;
    }

    public void set花色(int 花色) {
        this.花色 = 花色;
    }

    public int get点数() {
        return 点数;
    }

    public void set点数(int 点数) {
        this.点数 = 点数;
    }

    麻将(int 花色, int 点数) {
        this.花色 = 花色;
        this.点数 = 点数;
    }

    public static 麻将 获取指定牌型麻将(int 花色, int 点数) {
        for (麻将 pai : 麻将.values()) {
            if (pai.花色 == 花色 && pai.点数 == 点数) {
                return pai;
            }
        }
        throw new IllegalArgumentException("没有这样的牌型");
    }
}
