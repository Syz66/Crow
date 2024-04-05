package me.zircta.modules.impl.other;

import me.zircta.modules.api.Module;

// TODO: Remove
public class SelfDestruct extends Module {
    public static boolean a = false;

    public SelfDestruct() {
        super("SelfDestruct", Module.category.other, 0);
    }

    @Override
    public void update() {
        a = true;
    }
}

