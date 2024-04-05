package me.zircta.crow.modules.impl.render;

import me.zircta.crow.modules.api.Module;
import me.zircta.crow.modules.impl.other.SelfDestruct;
import me.zircta.crow.utils.PlayerUtils;

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

