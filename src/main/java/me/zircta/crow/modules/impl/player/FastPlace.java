package me.zircta.crow.modules.impl.player;

import me.zircta.crow.modules.api.Category;
import me.zircta.crow.modules.api.Module;
import me.zircta.crow.utils.PlayerUtils;
import me.zircta.crow.modules.impl.other.SelfDestruct;
import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

import java.lang.reflect.Field;

public class FastPlace extends Module {
    public FastPlace() {
        super("FastPlace", Category.Player, 0);
    }

    @SubscribeEvent
    public void onTick(TickEvent.Pre ev) {
        if (PlayerUtils.e() && !SelfDestruct.a) {
            try {
                Field c = Minecraft.class.getDeclaredField("rightClickDelayTimer");
                c.setAccessible(true);
                c.set(mc, 0);
            } catch (Exception ignored) {
            }
        }
    }
}
