package me.zircta.modules.impl.world;

import me.zircta.utils.PlayerUtils;
import me.zircta.modules.api.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class AntiBot extends Module {
    public AntiBot() {
        super("AntiBot", Module.category.world, 0);
    }

    @Override
    public void update() {
        if (PlayerUtils.e()) {
            for (Entity a : mc.theWorld.loadedEntityList) {
                if (!(a instanceof EntityPlayer)) continue;
                EntityPlayer b = (EntityPlayer)a;
                if (b == mc.thePlayer || !b.isInvisible() || b.ticksExisted <= 105) continue;
                mc.theWorld.removeEntity(b);
            }
        }
    }
}

