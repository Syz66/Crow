package me.zircta.crow.modules.api;

import me.zircta.crow.modules.impl.combat.AimAssist;
import me.zircta.crow.modules.impl.combat.AutoClicker;
import me.zircta.crow.modules.impl.combat.Reach;
import me.zircta.crow.modules.impl.combat.Velocity;
import me.zircta.crow.modules.impl.movement.Fly;
import me.zircta.crow.modules.impl.other.AutoConfig;
import me.zircta.crow.modules.impl.other.GuiModule;
import me.zircta.crow.modules.impl.other.SelfDestruct;
import me.zircta.crow.modules.impl.player.FastPlace;
import me.zircta.crow.modules.impl.render.HUD;
import me.zircta.crow.modules.impl.world.AntiBot;

import java.util.ArrayList;
import java.util.List;

// TODO: Clean up
public class ModuleManager {
    public static List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        this.register(new HUD());
        this.register(new AutoConfig());
        this.register(new GuiModule());
        this.register(new SelfDestruct());
        this.register(new Reach());
        this.register(new Velocity());
        this.register(new AutoClicker());
        this.register(new AimAssist());
        this.register(new FastPlace());
        this.register(new Fly());
        this.register(new AntiBot());
    }

    private void register(Module mod) {
        modules.add(mod);
    }

    public static List<Module> getModules() {
        return modules;
    }

    public List<Module> inCategory(Category category) {
        ArrayList<Module> perCategoryModList = new ArrayList<>();
        for (Module mod : getModules()) {
            if (!mod.moduleCategory().equals(category)) continue;
            perCategoryModList.add(mod);
        }
        return perCategoryModList;
    }
}

