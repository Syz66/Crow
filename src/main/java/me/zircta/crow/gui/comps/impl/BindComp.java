package me.zircta.crow.gui.comps.impl;

import me.zircta.crow.gui.comps.api.Comp;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class BindComp extends Comp {
    private boolean h;
    private boolean isBinding;
    private ModuleComp p;
    private int o;
    private int x;
    private int y;

    public BindComp(ModuleComp b2, int o) {
        this.p = b2;
        this.x = b2.c4t.gx() + b2.c4t.gw();
        this.y = b2.c4t.gy() + b2.o;
        this.o = o;
    }

    @Override
    public void so(int n) {
        this.o = n;
    }

    @Override
    public void r3nd3r() {
        if (this.p.mod.g3tN4m3().equalsIgnoreCase("AutoConfig")) {
            GL11.glPushMatrix();
            GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
            Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("Auto-configurate modules.", (float)((this.p.c4t.gx() + 4) * 2), (float)((this.p.c4t.gy() + this.o + 3) * 2), Color.HSBtoRGB((float)(System.currentTimeMillis() % 3750L) / 3750.0f, 0.8f, 0.8f));
            GL11.glPopMatrix();
            return;
        }
        GL11.glPushMatrix();
        GL11.glScaled((double)0.5, (double)0.5, (double)0.5);
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(this.isBinding ? "Press a key..." : "Bind: " + Keyboard.getKeyName((int)this.p.mod.getKeycode()), (float)((this.p.c4t.gx() + 4) * 2), (float)((this.p.c4t.gy() + this.o + 3) * 2), Color.HSBtoRGB((float)(System.currentTimeMillis() % 3750L) / 3750.0f, 0.8f, 0.8f));
        GL11.glPopMatrix();
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
            this.isBinding = !this.isBinding;
        }
    }

    @Override
    public void ky(char t, int keybind) {
        if (this.isBinding) {
            if (keybind == 11) {
                this.p.mod.setbind(0);
                this.isBinding = false;
            } else {
                this.p.mod.setbind(keybind);
                this.isBinding = false;
            }
        }
    }

    public boolean i(int x, int y) {
        return x > this.x && x < this.x + this.p.c4t.gw() && y > this.y - 1 && y < this.y + 12;
    }

    @Override
    public int gh() {
        return 16;
    }
}

