package me.zircta;

import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiScreen;

public class m extends GuiScreen {
    public static ArrayList<cm> c4tL1st;
    public static int c;

    public m() {
        c4tL1st = new ArrayList<>();
        int y = 5;
        for (bb.category c : bb.category.values()) {
            cm f = new cm(c);
            f.y(y);
            c4tL1st.add(f);
            y += 20;
        }
    }

    public void initGui() {
        super.initGui();
    }

    public void drawScreen(int x, int y, float p) {
        this.drawCenteredString(this.fontRendererObj, "r", this.width / 2 + 1, this.height / 4 - 25, Color.HSBtoRGB((float)((System.currentTimeMillis() + 1500L) % 5000L) / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "a", this.width / 2, this.height / 4 - 15, Color.HSBtoRGB((float)((System.currentTimeMillis() + 1200L) % 5000L) / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "v", this.width / 2, this.height / 4 - 5, Color.HSBtoRGB((float)((System.currentTimeMillis() + 900L) % 5000L) / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "e", this.width / 2, this.height / 4 + 5, Color.HSBtoRGB((float)((System.currentTimeMillis() + 600L) % 5000L) / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "n", this.width / 2, this.height / 4 + 15, Color.HSBtoRGB((float)((System.currentTimeMillis() + 300L) % 5000L) / 4750.0f, 0.8f, 0.8f));
        this.drawCenteredString(this.fontRendererObj, "b1", this.width / 2 + 1, this.height / 4 + 30, Color.HSBtoRGB((float)((System.currentTimeMillis() + 0L) % 5000L) / 4750.0f, 0.8f, 0.8f));
        for (cm c4t : c4tL1st) {
            c4t.rf(this.fontRendererObj);
            c4t.up(x, y);
            for (b m0d3 : c4t.gc()) {
                m0d3.uu(x, y);
            }
        }
    }

    public void mouseClicked(int x, int y, int m2) {
        for (cm c4t : c4tL1st) {
            if (c4t.v(x, y) && !c4t.i(x, y) && !c4t.d(x, y) && m2 == 0) {
                c4t.d(true);
                c4t.xx = x - c4t.gx();
                c4t.yy = y - c4t.gy();
            }
            if (c4t.d(x, y) && m2 == 0) {
                c4t.oo(!c4t.fv());
            }
            if (c4t.i(x, y) && m2 == 0) {
                c4t.cv(!c4t.p());
            }
            if (!c4t.fv() || c4t.gc().isEmpty()) continue;
            for (b c : c4t.gc()) {
                c.onCl1ck(x, y, m2);
            }
        }
    }

    public void keyTyped(char t, int k) {
        for (cm c4t : c4tL1st) {
            if (!c4t.fv() || k == 1 || c4t.gc().isEmpty()) continue;
            for (b c : c4t.gc()) {
                c.ky(t, k);
            }
        }
        if (k == 1) {
            this.mc.displayGuiScreen(null);
        }
    }

    public void mouseReleased(int x, int y, int s) {
        if (s == 0) {
            for (cm c4t : c4tL1st) {
                c4t.d(false);
            }
            for (cm c4t : c4tL1st) {
                if (!c4t.fv() || c4t.gc().isEmpty()) continue;
                for (b c : c4t.gc()) {
                    c.mr(x, y, s);
                }
            }
        }
    }

    public boolean doesGuiPauseGame() {
        return false;
    }

    static {
        c = -10110371;
    }
}
