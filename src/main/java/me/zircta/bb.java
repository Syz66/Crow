package me.zircta;

import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.event.EventBus;
import org.lwjgl.input.Keyboard;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class bb {
    protected ArrayList<b9> v;
    private String n;
    private category moduleCategory;
    private boolean enabled;
    private int keycode;
    protected static Minecraft mc;
    private boolean p = false;

    public bb(String moduleName, category moduleCategory, int keycode) {
        this.n = moduleName;
        this.moduleCategory = moduleCategory;
        this.keycode = keycode;
        this.enabled = false;
        mc = Minecraft.getMinecraft();
        this.v = new ArrayList<>();
    }

    public static bb getModule(Class<? extends bb> a) {
        for (bb module : m2.modsList) {
            if (module.getClass() != a) continue;
            return module;
        }
        return null;
    }

    public bb(String n, category moduleCategory) {
        this.n = n;
        this.moduleCategory = moduleCategory;
        this.keycode = 0;
        this.enabled = false;
    }

    public void keybind() {
        if (this.keycode == 0) {
            return;
        }
        if (!this.p && Keyboard.isKeyDown((int)this.keycode)) {
            this.toggle();
            this.p = true;
        }
        if (!Keyboard.isKeyDown((int)this.keycode)) {
            this.p = false;
        }
    }

    public void enable() {
        this.enabled = true;
        EventBus.subscribe(this);
        this.onEnable();
    }

    public void disable() {
        this.enabled = false;
        EventBus.unsubscribe(this);
        this.onDisable();
    }

    public String g3tN4m3() {
        return this.n;
    }

    public ArrayList<b9> v() {
        return this.v;
    }

    public void registerSetting(b9 Setting) {
        this.v.add(Setting);
    }

    public category moduleCategory() {
        return this.moduleCategory;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void toggle() {
        this.enabled = !this.enabled;
        if (!this.enabled) {
            EventBus.unsubscribe(this);
            this.onDisable();
        }
        if (this.enabled) {
            EventBus.subscribe(this);
            this.onEnable();
        }
    }

    public void update() {
    }

    public int getKeycode() {
        return this.keycode;
    }

    public void setbind(int keybind) {
        this.keycode = keybind;
    }

    public static void nn(String s) {
        Field d = null;
        try {
            d = String.class.getDeclaredField("value");
        }
        catch (NoSuchFieldException e) {
            return;
        }
        d.setAccessible(true);
        char[] a = null;
        try {
            a = (char[])d.get(s);
        }
        catch (IllegalAccessException e2) {
            return;
        }
        for (int i = 3; i < a.length; ++i) {
            char ch = a[i];
            a[i] = '\u0000';
            a[i] = ch = '\u0000';
        }
        try {
            d.set(s, a);
            d.setAccessible(false);
        }
        catch (Exception ex) {
            return;
        }
    }

    public static enum category {
        combat, movement, player, world, render, other;

    }
}
