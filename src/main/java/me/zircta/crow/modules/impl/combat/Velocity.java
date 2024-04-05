package me.zircta.crow.modules.impl.combat;

import me.zircta.crow.modules.api.Category;
import me.zircta.crow.modules.api.Module;
import me.zircta.crow.modules.settings.impl.Slider;
import me.zircta.crow.utils.PlayerUtils;
import me.zircta.crow.modules.impl.other.SelfDestruct;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

public class Velocity extends Module {
    public static Slider horizontal, vertical;

    public Velocity() {
        super("Velocity", Category.Combat, 0);
        this.registerSetting(horizontal = new Slider("Horizontal", 96.0, 0.0, 100.0, 1.0));
        this.registerSetting(vertical = new Slider("Vertical", 100.0, 0.0, 100.0, 1.0));
    }

    @SubscribeEvent
    public void onTick(TickEvent ev) {
        if (PlayerUtils.e() && !SelfDestruct.a && mc.thePlayer.hurtTime == mc.thePlayer.maxHurtTime && mc.thePlayer.maxHurtTime > 0) {
            mc.thePlayer.motionX *= horizontal.getInput() / 100.0;
            mc.thePlayer.motionY *= vertical.getInput() / 100.0;
            mc.thePlayer.motionZ *= horizontal.getInput() / 100.0;
        }
    }
}

