package me.zircta.modules.impl.player;

import me.zircta.modules.impl.other.SelfDestruct;
import me.zircta.utils.PlayerUtils;
import me.zircta.modules.api.Module;
import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

import java.lang.reflect.Field;

public class FastPlace extends Module {
    public FastPlace() {
        super("FastPlace", Module.category.player, 0);
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
