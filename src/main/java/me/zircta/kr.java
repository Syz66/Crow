package me.zircta;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.weavemc.loader.api.event.RenderHandEvent;
import net.weavemc.loader.api.event.SubscribeEvent;

import java.awt.*;

public class kr {
    private static final int[] a = new int[]{0xFFFFFF, 0xFF0000, 65280, 255, 0xFFFF00, 0xAA00AA};
    private Minecraft mc = Minecraft.getMinecraft();
    private ke[] b = new ke[4];
    private m4[] c = new m4[2];

    public kr() {
        this.b[0] = new ke(this.mc.gameSettings.keyBindForward, 26, 2);
        this.b[1] = new ke(this.mc.gameSettings.keyBindBack, 26, 26);
        this.b[2] = new ke(this.mc.gameSettings.keyBindLeft, 2, 26);
        this.b[3] = new ke(this.mc.gameSettings.keyBindRight, 50, 26);
        this.c[0] = new m4(0, 2, 50);
        this.c[1] = new m4(1, 38, 50);
    }

    @SubscribeEvent
    public void d(RenderHandEvent e) {
        if (this.mc.currentScreen != null) {
            if (this.mc.currentScreen instanceof gsk) {
                this.mc.currentScreen.handleInput();
            }
            return;
        }
        if (!this.mc.inGameHasFocus || this.mc.gameSettings.showDebugInfo) {
            return;
        }
        this.renderKeystrokes();
    }

    public void renderKeystrokes() {
        int height;
        ks f = w.d2();
        if (!f.isEnabled()) {
            return;
        }
        int x = f.getX();
        int y = f.getY();
        int g = this.getColor(f.getTextColor());
        boolean h = f.isShowingMouseButtons();
        ScaledResolution res = new ScaledResolution(this.mc);
        int width = 74;
        int n = height = h ? 74 : 50;
        if (x < 0) {
            f.setX(0);
            x = f.getX();
        } else if (x > res.getScaledWidth() - width) {
            f.setX(res.getScaledWidth() - width);
            x = f.getX();
        }
        if (y < 0) {
            f.setY(0);
            y = f.getY();
        } else if (y > res.getScaledHeight() - height) {
            f.setY(res.getScaledHeight() - height);
            y = f.getY();
        }
        this.drawMovementKeys(x, y, g);
        if (h) {
            this.drawMouseButtons(x, y, g);
        }
    }

    private int getColor(int index) {
        if (index == 6) {
            return Color.HSBtoRGB((float)(System.currentTimeMillis() % 1000L) / 1000.0f, 0.8f, 0.8f);
        }
        return a[index];
    }

    private void drawMovementKeys(int x, int y, int textColor) {
        for (ke key : this.b) {
            key.renderKey(x, y, textColor);
        }
    }

    private void drawMouseButtons(int x, int y, int textColor) {
        for (m4 button : this.c) {
            button.n(x, y, textColor);
        }
    }
}
