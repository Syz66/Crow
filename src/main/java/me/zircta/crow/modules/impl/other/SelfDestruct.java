package me.zircta.crow.modules.impl.other;

import me.zircta.crow.modules.api.Category;
import me.zircta.crow.modules.api.Module;

// TODO: Remove
public class SelfDestruct extends Module {
    public static boolean a = false;

    public SelfDestruct() {
        super("SelfDestruct", Category.Other, 0);
    }

    @Override
    public void update() {
        a = true;
    }
}

