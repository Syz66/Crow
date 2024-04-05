package me.zircta.crow.utils;

import me.zircta.crow.modules.settings.impl.Slider;
import net.minecraft.client.Minecraft;

public class PlayerUtils {
    private static Minecraft a = Minecraft.getMinecraft();

    public static void b(Slider c, Slider d) {
        if (c.getInput() > d.getInput()) {
            double prevMIN = c.getInput();
            c.setValue(d.getInput());
            d.setValue(prevMIN);
        }
    }

    public static boolean e() {
        return PlayerUtils.a.thePlayer != null && PlayerUtils.a.theWorld != null;
    }

    public static int f() {
        int g = a.getNetHandler().getPlayerInfo(PlayerUtils.a.thePlayer.getUniqueID()).getResponseTime();
        return g;
    }
}
