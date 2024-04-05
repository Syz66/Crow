package me.zircta;

public class ax extends bb {
    public static boolean a = false;

    public ax() {
        super("SelfDestruct", bb.category.other, 0);
    }

    @Override
    public void update() {
        a = true;
    }
}

