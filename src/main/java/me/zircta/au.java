package me.zircta;

public class au extends bb {
    public au() {
        super("Gui", bb.category.other, 27);
    }

    @Override
    public void onEnable() {
        if (ay.e() && !ax.a) {
            mc.displayGuiScreen(aw.b);
            this.toggle();
        }
    }
}

