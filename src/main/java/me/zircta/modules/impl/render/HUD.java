package me.zircta.modules.impl.render;

import me.zircta.modules.impl.other.SelfDestruct;
import me.zircta.utils.PlayerUtils;
import me.zircta.modules.api.Module;

// TODO: Rewrite
public class HUD extends Module {
    public static boolean a;

    public HUD() {
        super("HUD", Module.category.render, 0);
    }

    @Override
    public void onEnable() {
        if (PlayerUtils.e() && !SelfDestruct.a) {
            a = true;
        }
    }

    @Override
    public void onDisable() {
        a = false;
    }
}

