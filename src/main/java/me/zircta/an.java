package me.zircta;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class an extends bb {
    public an() {
        super("AntiBot", bb.category.world, 0);
    }

    @Override
    public void update() {
        if (ay.e()) {
            for (Entity a : mc.theWorld.loadedEntityList) {
                if (!(a instanceof EntityPlayer)) continue;
                EntityPlayer b = (EntityPlayer)a;
                if (b == mc.thePlayer || !b.isInvisible() || b.ticksExisted <= 105) continue;
                mc.theWorld.removeEntity(b);
            }
        }
    }
}

