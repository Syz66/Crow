package me.zircta;

import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

import java.lang.reflect.Field;

public class aa extends bb {
    public aa() {
        super("FastPlace", bb.category.player, 0);
    }

    @SubscribeEvent
    public void a(TickEvent.Pre b) {
        if (ay.e() && !ax.a) {
            try {
                Field c = Minecraft.class.getDeclaredField("rightClickDelayTimer");
                c.setAccessible(true);
                c.set(mc, 0);
            } catch (Exception ignored) {
            }
        }
    }
}
