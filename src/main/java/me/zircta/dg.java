package me.zircta;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class dg extends b {
    private boolean h;
    private ap v;
    private m3 p;
    private int o;
    private int x;
    private int y;
    private boolean d = false;
    private double w;

    public dg(ap v, m3 b2, int o) {
        this.v = v;
        this.p = b2;
        this.x = b2.c4t.gx() + b2.c4t.gw();
        this.y = b2.c4t.gy() + b2.o;
        this.o = o;
    }

    @Override
    public void r3nd3r() {
        Gui.drawRect((int)(this.p.c4t.gx() + 4), (int)(this.p.c4t.gy() + this.o + 11), (int)(this.p.c4t.gx() + 4 + this.p.c4t.gw() - 8), (int)(this.p.c4t.gy() + this.o + 15), (int)-12302777);
        Gui.drawRect((int)(this.p.c4t.gx() + 4), (int)(this.p.c4t.gy() + this.o + 11), (int)(this.p.c4t.gx() + 4 + (int)this.w), (int)(this.p.c4t.gy() + this.o + 15), (int) Color.getHSBColor((float)(System.currentTimeMillis() % 11000L) / 11000.0f, 0.75f, 0.9f).getRGB());
        GL11.glPushMatrix();
        GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(String.valueOf(this.v.get()) + ": " + this.v.getInput(), (float)((int)((float)(this.p.c4t.gx() + 4) * 2.0f)), (float)((int)((float)(this.p.c4t.gy() + this.o + 3) * 2.0f)), -1);
        GL11.glPopMatrix();
    }

    @Override
    public void so(int n) {
        this.o = n;
    }

    @Override
    public void uu(int x, int y) {
        this.h = this.u(x, y) || this.i(x, y);
        this.y = this.p.c4t.gy() + this.o;
        this.x = this.p.c4t.gx();
        double d = Math.min(this.p.c4t.gw() - 8, Math.max(0, x - this.x));
        this.w = (double)(this.p.c4t.gw() - 8) * (this.v.getInput() - this.v.g3ti()) / (this.v.g3ta() - this.v.g3ti());
        if (this.d) {
            if (d == 0.0) {
                this.v.setValue(this.v.g3ti());
            } else {
                double n = dg.r(d / (double)(this.p.c4t.gw() - 8) * (this.v.g3ta() - this.v.g3ti()) + this.v.g3ti(), 2);
                this.v.setValue(n);
            }
        }
    }

    private static double r(double v, int p) {
        if (p < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(p, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public void onCl1ck(int x, int y, int b2) {
        if (this.u(x, y) && b2 == 0 && this.p.po) {
            this.d = true;
        }
        if (this.i(x, y) && b2 == 0 && this.p.po) {
            this.d = true;
        }
    }

    @Override
    public void mr(int x, int y, int m) {
        this.d = false;
    }

    public boolean u(int x, int y) {
        return x > this.x && x < this.x + (this.p.c4t.gw() / 2 + 1) && y > this.y && y < this.y + 16;
    }

    public boolean i(int x, int y) {
        return x > this.x + this.p.c4t.gw() / 2 && x < this.x + this.p.c4t.gw() && y > this.y && y < this.y + 16;
    }
}
