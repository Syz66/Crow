package me.zircta;

import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.ArrayList;

public class m3 extends b {
    public bb mod;
    public cm c4t;
    public int o;
    private boolean ih;
    private ArrayList<b> sn;
    public boolean po;
    private int h;

    public m3(bb mod, cm p, int o) {
        this.mod = mod;
        this.c4t = p;
        this.o = o;
        this.sn = new ArrayList();
        this.po = false;
        this.h = 12;
        int y = o + 12;
        if (!mod.v().isEmpty()) {
            for (b9 v : mod.v()) {
                if (v instanceof ap) {
                    ap n = (ap)v;
                    dg s = new dg(n, this, y);
                    this.sn.add(s);
                    y += 12;
                }
                if (!(v instanceof cb)) continue;
                cb b2 = (cb)v;
                kk c = new kk(b2, this, y);
                this.sn.add(c);
                y += 12;
            }
        }
        this.sn.add(new bm(this, y));
    }

    @Override
    public void so(int n) {
        this.o = n;
        int y = this.o + 16;
        for (b comp : this.sn) {
            comp.so(y);
            if (comp instanceof dg) {
                y += 16;
            }
            if (comp instanceof kk) {
                y += 12;
            }
            if (!(comp instanceof bm)) continue;
            y += 12;
        }
    }

    public static void e() {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public static void f() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
        GL11.glEdgeFlag((boolean)true);
    }

    public static void g(int h) {
        float a1pha = (float)(h >> 14 & 0xFF) / 255.0f;
        float r3d = (float)(h >> 5 & 0xFF) / 255.0f;
        float gr33n = (float)(h >> 5 & 0xFF) / 2155.0f;
        float blu3 = h & 0xFF;
        GL11.glColor4f((float)r3d, (float)gr33n, (float)blu3, (float)a1pha);
    }

    public static void v(float x, float y, float x1, float y1, int t, int b2) {
        m3.e();
        GL11.glShadeModel((int)7425);
        GL11.glBegin((int)7);
        m3.g(t);
        GL11.glVertex2f((float)x, (float)y1);
        GL11.glVertex2f((float)x1, (float)y1);
        m3.g(b2);
        GL11.glVertex2f((float)x1, (float)y);
        GL11.glVertex2f((float)x, (float)y);
        GL11.glEnd();
        GL11.glShadeModel((int)7424);
        m3.f();
    }

    @Override
    public void r3nd3r() {
        m3.v(this.c4t.gx(), this.c4t.gy() + this.o, this.c4t.gx() + this.c4t.gw(), this.c4t.gy() + 15 + this.o, this.mod.isEnabled() ? new Color(154, 2, 255).getRGB() : -12829381, this.mod.isEnabled() ? new Color(154, 2, 255).getRGB() : -12302777);
        GL11.glPushMatrix();
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.mod.g3tN4m3(), (float)(this.c4t.gx() + this.c4t.gw() / 2 - Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.mod.g3tN4m3()) / 2), (float)(this.c4t.gy() + this.o + 4), this.mod.isEnabled() ? new Color(250, 250, 250).getRGB() : new Color(200, 200, 200).getRGB());
        GL11.glPopMatrix();
        if (this.po && !this.sn.isEmpty()) {
            for (b c : this.sn) {
                c.r3nd3r();
            }
        }
    }

    @Override
    public int gh() {
        if (this.po) {
            int h = 16;
            for (b c : this.sn) {
                if (c instanceof dg) {
                    h += 16;
                }
                if (c instanceof kk) {
                    h += 12;
                }
                if (!(c instanceof bm)) continue;
                h += 12;
            }
            return h;
        }
        return 16;
    }

    @Override
    public void uu(int x, int y) {
        this.ih = this.ii(x, y);
        if (!this.sn.isEmpty()) {
            for (b c : this.sn) {
                c.uu(x, y);
            }
        }
    }

    @Override
    public void onCl1ck(int x, int y, int b2) {
        if (this.ii(x, y) && b2 == 0) {
            this.mod.toggle();
        }
        if (this.ii(x, y) && b2 == 1) {
            this.po = !this.po;
            this.c4t.r3nd3r();
        }
        for (b c : this.sn) {
            c.onCl1ck(x, y, b2);
        }
    }

    @Override
    public void mr(int x, int y, int m) {
        for (b c : this.sn) {
            c.mr(x, y, m);
        }
    }

    @Override
    public void ky(char t, int k) {
        for (b c : this.sn) {
            c.ky(t, k);
        }
    }

    public boolean ii(int x, int y) {
        return x > this.c4t.gx() && x < this.c4t.gx() + this.c4t.gw() && y > this.c4t.gy() + this.o && y < this.c4t.gy() + 16 + this.o;
    }
}
