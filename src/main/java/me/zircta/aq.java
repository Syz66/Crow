package me.zircta;

public class aq extends bb {
    public static boolean a;

    public aq() {
        super("HUD", bb.category.render, 0);
    }

    @Override
    public void onEnable() {
        if (ay.e() && !ax.a) {
            a = true;
        }
    }

    @Override
    public void onDisable() {
        a = false;
    }
}

