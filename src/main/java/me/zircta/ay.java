package me.zircta;

import net.minecraft.client.Minecraft;

public class ay {
    private static Minecraft a = Minecraft.getMinecraft();

    public static void b(ap c, ap d) {
        if (c.getInput() > d.getInput()) {
            double prevMIN = c.getInput();
            c.setValue(d.getInput());
            d.setValue(prevMIN);
        }
    }

    public static boolean e() {
        return ay.a.thePlayer != null && ay.a.theWorld != null;
    }

    public static int f() {
        int g = a.getNetHandler().getPlayerInfo(ay.a.thePlayer.getUniqueID()).getResponseTime();
        return g;
    }
}
