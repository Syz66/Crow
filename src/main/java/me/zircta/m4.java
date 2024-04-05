package me.zircta;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

public class m4 {
    private static String[] a = new String[]{"LMB", "RMB"};
    private Minecraft b = Minecraft.getMinecraft();
    private int c;
    private int d;
    private int e;
    private List<Long> f = new ArrayList<Long>();
    private boolean g = true;
    private long h = 0L;
    private int i = 255;
    private double j = 1.0;

    public m4(int k, int l, int m) {
        this.c = k;
        this.d = l;
        this.e = m;
    }

    public void n(int o, int p, int q) {
        boolean r = Mouse.isButtonDown((int)this.c);
        String s = a[this.c];
        if (r != this.g) {
            this.g = r;
            this.h = System.currentTimeMillis();
            if (r) {
                this.f.add(this.h);
            }
        }
        if (r) {
            this.i = Math.min(255, (int)(2L * (System.currentTimeMillis() - this.h)));
            this.j = Math.max(0.0, 1.0 - (double)(System.currentTimeMillis() - this.h) / 20.0);
        } else {
            this.i = Math.max(0, 255 - (int)(2L * (System.currentTimeMillis() - this.h)));
            this.j = Math.min(1.0, (double)(System.currentTimeMillis() - this.h) / 20.0);
        }
        int t = q >> 16 & 0xFF;
        int u = q >> 8 & 0xFF;
        int v = q & 0xFF;
        Gui.drawRect((int)(o + this.d), (int)(p + this.e), (int)(o + this.d + 34), (int)(p + this.e + 22), (int)(0x78000000 + (this.i << 16) + (this.i << 8) + this.i));
        this.b.fontRendererObj.drawString(s, o + this.d + 8, p + this.e + 4, -16777216 + ((int)((double)t * this.j) << 16) + ((int)((double)u * this.j) << 8) + (int)((double)v * this.j));
        String w = cl.f() + " CPS";
        String x = cl.i() + " CPS";
        int y = this.b.fontRendererObj.getStringWidth(w);
        int z = this.b.fontRendererObj.getStringWidth(x);
        boolean a2 = this.c == 0;
        int b2 = a2 ? y : z;
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        this.b.fontRendererObj.drawString(a2 ? w : x, (o + this.d + 17) * 2 - b2 / 2, (p + this.e + 14) * 2, -16777216 + ((int)(255.0 * this.j) << 16) + ((int)(255.0 * this.j) << 8) + (int)(255.0 * this.j));
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
    }
}
