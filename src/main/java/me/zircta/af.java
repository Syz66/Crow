package me.zircta;

import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

public class af extends bb {
    public static ap a;
    public static ap b;

    public af() {
        super("Velocity", bb.category.combat, 0);
        a = new ap("Horizontal", 96.0, 0.0, 100.0, 1.0);
        b = new ap("Vertical", 100.0, 0.0, 100.0, 1.0);
        this.registerSetting(a);
        this.registerSetting(b);
    }

    @SubscribeEvent
    public void c(TickEvent d) {
        if (ay.e() && !ax.a && mc.thePlayer.hurtTime == mc.thePlayer.maxHurtTime && mc.thePlayer.maxHurtTime > 0) {
            mc.thePlayer.motionX *= a.getInput() / 100.0;
            mc.thePlayer.motionY *= b.getInput() / 100.0;
            mc.thePlayer.motionZ *= a.getInput() / 100.0;
        }
    }
}

