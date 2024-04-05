package me.zircta;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class ke {
    private Minecraft a = Minecraft.getMinecraft();
    private KeyBinding b;
    private int c;
    private int d;
    private boolean e = true;
    private long f = 0L;
    private int g = 255;
    private double h = 1.0;

    public ke(KeyBinding i, int j, int k) {
        this.b = i;
        this.c = j;
        this.d = k;
    }

    public void renderKey(int l, int m, int n) {
        boolean o = this.b.isKeyDown();
        String p = Keyboard.getKeyName((int)this.b.getKeyCode());
        if (o != this.e) {
            this.e = o;
            this.f = System.currentTimeMillis();
        }
        if (o) {
            this.g = Math.min(255, (int)(2L * (System.currentTimeMillis() - this.f)));
            this.h = Math.max(0.0, 1.0 - (double)(System.currentTimeMillis() - this.f) / 20.0);
        } else {
            this.g = Math.max(0, 255 - (int)(2L * (System.currentTimeMillis() - this.f)));
            this.h = Math.min(1.0, (double)(System.currentTimeMillis() - this.f) / 20.0);
        }
        int q = n >> 16 & 0xFF;
        int r = n >> 8 & 0xFF;
        int s = n & 0xFF;
        Gui.drawRect((int)(l + this.c), (int)(m + this.d), (int)(l + this.c + 22), (int)(m + this.d + 22), (int)(0x78000000 + (this.g << 16) + (this.g << 8) + this.g));
        this.a.fontRendererObj.drawString(p, l + this.c + 8, m + this.d + 8, -16777216 + ((int)((double)q * this.h) << 16) + ((int)((double)r * this.h) << 8) + (int)((double)s * this.h));
    }
}
