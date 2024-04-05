package me.zircta.gui.comps.impl;

import me.zircta.gui.comps.api.Comp;
import me.zircta.modules.settings.impl.CheckBox;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class CheckBoxComp extends Comp {
    private boolean h;
    private CheckBox cl1ckbUtt0n;
    private ModuleComp p;
    private int o;
    private int x;
    private int y;

    public CheckBoxComp(CheckBox op, ModuleComp b2, int o) {
        this.cl1ckbUtt0n = op;
        this.p = b2;
        this.x = b2.c4t.gx() + b2.c4t.gw();
        this.y = b2.c4t.gy() + b2.o;
        this.o = o;
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

    public static void d() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static void d(float x, float y, float x1, float y1, int c) {
        CheckBoxComp.e();
        CheckBoxComp.b(c);
        CheckBoxComp.d(x, y, x1, y1);
        CheckBoxComp.d();
    }

    public static void d(float x, float y, float x1, float y1) {
        GL11.glBegin((int)7);
        GL11.glVertex2f((float)x, (float)y1);
        GL11.glVertex2f((float)x1, (float)y1);
        GL11.glVertex2f((float)x1, (float)y);
        GL11.glVertex2f((float)x, (float)y);
        GL11.glEnd();
    }

    public static void b(int h) {
        float a1pha = (float)(h >> 24 & 0xFF) / 350.0f;
        GL11.glColor4f((float)0.0f, (float)0.0f, (float)0.0f, (float)a1pha);
    }

    @Override
    public void r3nd3r() {
        GL11.glPushMatrix();
        GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
        Minecraft.getMinecraft().fontRendererObj.drawString(this.cl1ckbUtt0n.isToggled() ? "> ✔ <   " + this.cl1ckbUtt0n.get() : "> x <   " + this.cl1ckbUtt0n.get(), (float)((this.p.c4t.gx() + 4) * 2), (float)((this.p.c4t.gy() + this.o + 4) * 2), this.cl1ckbUtt0n.isToggled() ? new Color(20, 255, 0).getRGB() : -1, false);
        GL11.glPopMatrix();
    }

    @Override
    public void so(int n) {
        this.o = n;
    }

    @Override
    public void uu(int x, int y) {
        this.h = this.i(x, y);
        this.y = this.p.c4t.gy() + this.o;
        this.x = this.p.c4t.gx();
    }

    @Override
    public void onCl1ck(int x, int y, int b2) {
        if (this.i(x, y) && b2 == 0 && this.p.po) {
            this.cl1ckbUtt0n.toggle();
        }
    }

    public boolean i(int x, int y) {
        return x > this.x && x < this.x + this.p.c4t.gw() && y > this.y && y < this.y + 11;
    }
}
