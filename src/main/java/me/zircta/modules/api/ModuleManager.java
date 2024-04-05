package me.zircta.modules.api;

import me.zircta.modules.impl.combat.AimAssist;
import me.zircta.modules.impl.combat.AutoClicker;
import me.zircta.modules.impl.combat.Reach;
import me.zircta.modules.impl.combat.Velocity;
import me.zircta.modules.impl.movement.Fly;
import me.zircta.modules.impl.other.AutoConfig;
import me.zircta.modules.impl.other.GuiModule;
import me.zircta.modules.impl.other.SelfDestruct;
import me.zircta.modules.impl.player.FastPlace;
import me.zircta.modules.impl.render.HUD;
import me.zircta.modules.impl.world.AntiBot;

import java.util.ArrayList;
import java.util.List;

// TODO: Clean up
public class ModuleManager {
    public static List<Module> modsList;

    public ModuleManager() {
        modsList = new ArrayList<>();
    }

    public void r3g1st3r() {
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
        modsList.add(mod);
    }

    public List<Module> listofmods() {
        return modsList;
    }

    public List<Module> inCategory(Module.category theCategories) {
        ArrayList<Module> perCategoryModList = new ArrayList<Module>();
        for (Module mod : this.listofmods()) {
            if (!mod.moduleCategory().equals((Object)theCategories)) continue;
            perCategoryModList.add(mod);
        }
        return perCategoryModList;
    }
}

