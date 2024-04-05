package me.zircta;

import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import org.lwjgl.opengl.GL11;

public class cm {
    public ArrayList<b> c = new ArrayList();
    public bb.category categoryName;
    private boolean categoryOpened;
    private int k;
    private int y;
    private int x;
    private int bh;
    private boolean id;
    public int xx;
    public int yy;
    public boolean n4m = false;
    public String pvp;
    public boolean pin = false;
    private int chromaSpeed;

    public cm(bb.category category2) {
        this.categoryName = category2;
        this.k = 92;
        this.x = 5;
        this.y = 5;
        this.bh = 13;
        this.xx = 0;
        this.categoryOpened = false;
        this.id = false;
        this.chromaSpeed = 3;
        int tY = this.bh + 3;
        for (bb mod : w.c.getm0dmanager().inCategory(this.categoryName)) {
            m3 b2 = new m3(mod, this, tY);
            this.c.add(b2);
            tY += 16;
        }
    }

    public cm(String d) {
        this.k = 92;
        this.x = 5;
        this.y = 5;
        this.bh = 13;
        this.xx = 0;
        this.categoryOpened = false;
        this.id = false;
        int tY = this.bh;
        this.pvp = d;
        this.n4m = true;
    }

    public ArrayList<b> gc() {
        return this.c;
    }

    public void x(int n) {
        this.x = n;
    }

    public void y(int y) {
        this.y = y;
    }

    public void d(boolean d) {
        this.id = d;
    }

    public boolean p() {
        return this.pin;
    }

    public void cv(boolean on) {
        this.pin = on;
    }

    public boolean fv() {
        return this.categoryOpened;
    }

    public void oo(boolean on) {
        this.categoryOpened = on;
    }

    public void rf(FontRenderer renderer) {
        this.k = 92;
        if (!this.c.isEmpty() && this.categoryOpened) {
            int h = 0;
            for (b c : this.c) {
                h += c.gh();
            }
            Gui.drawRect((int)(this.x - 2), (int)this.y, (int)(this.x + this.k + 2), (int)(this.y + this.bh + h + 4), (int)0x44000000);
        }
        kk.d(this.x - 2, this.y, this.x + this.k + 2, this.y + this.bh + 3, -1);
        renderer.drawString(this.n4m ? this.pvp : this.categoryName.name(), (float)(this.x + 2), (float)(this.y + 4), Color.getHSBColor((float)(System.currentTimeMillis() % (7500L / (long)this.chromaSpeed)) / (7500.0f / (float)this.chromaSpeed), 1.0f, 1.0f).getRGB(), false);
        if (this.n4m) {
            return;
        }
        GL11.glPushMatrix();
        renderer.drawString(this.categoryOpened ? "-" : "+", (float)(this.x + 81 - 12), (float)((double)this.y + 4.5), -5592406, false);
        GL11.glPopMatrix();
        if (this.categoryOpened && !this.c.isEmpty()) {
            for (b c2 : this.c) {
                c2.r3nd3r();
            }
        }
    }

    public void r3nd3r() {
        int o = this.bh + 3;
        for (b c : this.c) {
            c.so(o);
            o += c.gh();
        }
    }

    public int gx() {
        return this.x;
    }

    public int gy() {
        return this.y;
    }

    public int gw() {
        return this.k;
    }

    public void up(int x, int y) {
        if (this.id) {
            this.x(x - this.xx);
            this.y(y - this.yy);
        }
    }

    public boolean i(int x, int y) {
        return x >= this.x + 92 - 13 && x <= this.x + this.k && (float)y >= (float)this.y + 2.0f && y <= this.y + this.bh + 1;
    }

    public boolean d(int x, int y) {
        return x >= this.x + 92 - 13 - 13 && x <= this.x + this.k - 14 && (float)y >= (float)this.y + 2.0f && y <= this.y + this.bh + 1;
    }

    public boolean v(int x, int y) {
        return x >= this.x && x <= this.x + this.k && y >= this.y && y <= this.y + this.bh;
    }
}
