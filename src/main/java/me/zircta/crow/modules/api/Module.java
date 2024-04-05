package me.zircta.crow.modules.api;

import me.zircta.crow.modules.settings.api.Setting;
import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.event.EventBus;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;

public class Module {
    protected ArrayList<Setting> v;
    private final String n;
    private final Category moduleCategory;
    private boolean enabled;
    private int keycode;
    protected static Minecraft mc;
    private boolean p = false;

    public Module(String moduleName, Category moduleCategory, int keycode) {
        this.n = moduleName;
        this.moduleCategory = moduleCategory;
        this.keycode = keycode;
        this.enabled = false;
        mc = Minecraft.getMinecraft();
        this.v = new ArrayList<>();
    }

    public static Module getModule(Class<? extends Module> a) {
        for (Module module : ModuleManager.modules) {
            if (module.getClass() != a) continue;
            return module;
        }
        return null;
    }

    public Module(String n, Category moduleCategory) {
        this.n = n;
        this.moduleCategory = moduleCategory;
        this.keycode = 0;
        this.enabled = false;
    }

    public void keybind() {
        if (this.keycode == 0) {
            return;
        }
        if (!this.p && Keyboard.isKeyDown(this.keycode)) {
            this.toggle();
            this.p = true;
        }
        if (!Keyboard.isKeyDown(this.keycode)) {
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

    public ArrayList<Setting> v() {
        return this.v;
    }

    public void registerSetting(Setting Setting) {
        this.v.add(Setting);
    }

    public Category moduleCategory() {
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

}
