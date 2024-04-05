package me.zircta.utils;

import me.zircta.gui.ClickGui;
import me.zircta.modules.api.ModuleManager;

public class IdkUtils {
    public static ModuleManager a;
    public static ClickGui b;
    private static int c;

    public IdkUtils() {
        a = new ModuleManager();
    }

    public ModuleManager getm0dmanager() {
        return a;
    }

    public static int pF() {
        return c;
    }

    static {
        c = -1;
    }
}
