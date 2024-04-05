package me.zircta;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.weavemc.loader.api.event.MouseEvent;
import net.weavemc.loader.api.event.SubscribeEvent;

import java.util.Random;
import java.util.List;

public class a8 extends bb {
    public static ap a;
    public static ap b;
    public static cb c;
    public static cb d;
    public Random e = new Random();

    public a8() {
        super("Reach", bb.category.combat, 0);
        a = new ap("Min", 3.1, 3.0, 6.0, 0.05);
        b = new ap("Max", 3.3, 3.0, 6.0, 0.05);
        c = new cb("Weapon Only", false);
        d = new cb("Hit Through Blocks", false);
        this.registerSetting(a);
        this.registerSetting(b);
        this.registerSetting(c);
        this.registerSetting(d);
    }

    @SubscribeEvent
    public void e(MouseEvent f) {
        if (ay.e() && !ax.a) {
            BlockPos R4V3NR4V3NR4V3NR4V3NR4V3N;
            if (c.isToggled()) {
                if (mc.thePlayer.getCurrentEquippedItem() == null) {
                    return;
                }
                if (!(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                    return;
                }
            }
            if (!d.isToggled() && mc.objectMouseOver != null && (R4V3NR4V3NR4V3NR4V3NR4V3N = mc.objectMouseOver.getBlockPos()) != null && mc.theWorld.getBlockState(R4V3NR4V3NR4V3NR4V3NR4V3N).getBlock() != Blocks.air) {
                return;
            }
            ay.b(a, b);
            double R4V3NR4V3NR4V3NR4V3NR4V3ND2 = a.getInput() + this.e.nextDouble() * (b.getInput() - a.getInput());
            Object[] R4V3NR4V3NR4V3NR4V3NR4V3NN = a8.R4V3NR4V3NR4V3NR4V3NR4V3N(R4V3NR4V3NR4V3NR4V3NR4V3ND2, 0.0, 0.0f);
            if (R4V3NR4V3NR4V3NR4V3NR4V3NN == null) {
                return;
            }
            mc.objectMouseOver = new MovingObjectPosition((Entity)R4V3NR4V3NR4V3NR4V3NR4V3NN[0], (Vec3)R4V3NR4V3NR4V3NR4V3NR4V3NN[1]);
            mc.pointedEntity = (Entity)R4V3NR4V3NR4V3NR4V3NR4V3NN[0];
        }
    }

    public static Object[] R4V3NR4V3NR4V3NR4V3NR4V3N(double R4V3NR4V3NR4V3NR4V3NR4V3ND, double R4V3NR4V3NR4V3NR4V3NR4V3NE, float R4V3NR4V3NR4V3NR4V3NR4V3NPT) {
        Entity R4V3NR4V3NR4V3NR4V3NR4V3N2 = mc.getRenderViewEntity();
        Entity entity = null;
        if (R4V3NR4V3NR4V3NR4V3NR4V3N2 == null || mc.theWorld == null) {
            return null;
        }
        mc.mcProfiler.startSection("pick");
        Vec3 R4V3NR4V3NR4V3NR4V3NR4V3N3 = R4V3NR4V3NR4V3NR4V3NR4V3N2.getPositionEyes(0.0f);
        Vec3 R4V3NR4V3NR4V3NR4V3NR4V3N4 = R4V3NR4V3NR4V3NR4V3NR4V3N2.getLook(0.0f);
        Vec3 R4V3NR4V3NR4V3NR4V3NR4V3N5 = R4V3NR4V3NR4V3NR4V3NR4V3N3.addVector(R4V3NR4V3NR4V3NR4V3NR4V3N4.xCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND, R4V3NR4V3NR4V3NR4V3NR4V3N4.yCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND, R4V3NR4V3NR4V3NR4V3NR4V3N4.zCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND);
        Vec3 R4V3NR4V3NR4V3NR4V3NR4V3N6 = null;
        float R4V3NR4V3NR4V3NR4V3NR4V3N7 = 1.0f;
        List<Entity> R4V3NR4V3NR4V3NR4V3NR4V3N8 = mc.theWorld.getEntitiesWithinAABBExcludingEntity(R4V3NR4V3NR4V3NR4V3NR4V3N2, R4V3NR4V3NR4V3NR4V3NR4V3N2.getEntityBoundingBox().addCoord(R4V3NR4V3NR4V3NR4V3NR4V3N4.xCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND, R4V3NR4V3NR4V3NR4V3NR4V3N4.yCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND, R4V3NR4V3NR4V3NR4V3NR4V3N4.zCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND).expand(1.0, 1.0, 1.0));
        double R4V3NR4V3NR4V3NR4V3NR4V3N9 = R4V3NR4V3NR4V3NR4V3NR4V3ND;
        for (int R4V3NR4V3NR4V3NR4V3NR4V3N10 = 0; R4V3NR4V3NR4V3NR4V3NR4V3N10 < R4V3NR4V3NR4V3NR4V3NR4V3N8.size(); ++R4V3NR4V3NR4V3NR4V3NR4V3N10) {
            double R4V3NR4V3NR4V3NR4V3NR4V3N15;
            Entity R4V3NR4V3NR4V3NR4V3NR4V3N11 = (Entity)R4V3NR4V3NR4V3NR4V3NR4V3N8.get(R4V3NR4V3NR4V3NR4V3NR4V3N10);
            if (!R4V3NR4V3NR4V3NR4V3NR4V3N11.canBeCollidedWith()) continue;
            float R4V3NR4V3NR4V3NR4V3NR4V3N12 = R4V3NR4V3NR4V3NR4V3NR4V3N11.getCollisionBorderSize();
            AxisAlignedBB R4V3NR4V3NR4V3NR4V3NR4V3N13 = R4V3NR4V3NR4V3NR4V3NR4V3N11.getEntityBoundingBox().expand((double)R4V3NR4V3NR4V3NR4V3NR4V3N12, (double)R4V3NR4V3NR4V3NR4V3NR4V3N12, (double)R4V3NR4V3NR4V3NR4V3NR4V3N12);
            R4V3NR4V3NR4V3NR4V3NR4V3N13 = R4V3NR4V3NR4V3NR4V3NR4V3N13.expand(R4V3NR4V3NR4V3NR4V3NR4V3NE, R4V3NR4V3NR4V3NR4V3NR4V3NE, R4V3NR4V3NR4V3NR4V3NR4V3NE);
            MovingObjectPosition R4V3NR4V3NR4V3NR4V3NR4V3N14 = R4V3NR4V3NR4V3NR4V3NR4V3N13.calculateIntercept(R4V3NR4V3NR4V3NR4V3NR4V3N3, R4V3NR4V3NR4V3NR4V3NR4V3N5);
            if (R4V3NR4V3NR4V3NR4V3NR4V3N13.isVecInside(R4V3NR4V3NR4V3NR4V3NR4V3N3)) {
                if (!(0.0 < R4V3NR4V3NR4V3NR4V3NR4V3N9) && R4V3NR4V3NR4V3NR4V3NR4V3N9 != 0.0) continue;
                entity = R4V3NR4V3NR4V3NR4V3NR4V3N11;
                R4V3NR4V3NR4V3NR4V3NR4V3N6 = R4V3NR4V3NR4V3NR4V3NR4V3N14 == null ? R4V3NR4V3NR4V3NR4V3NR4V3N3 : R4V3NR4V3NR4V3NR4V3NR4V3N14.hitVec;
                R4V3NR4V3NR4V3NR4V3NR4V3N9 = 0.0;
                continue;
            }
            if (R4V3NR4V3NR4V3NR4V3NR4V3N14 == null || !((R4V3NR4V3NR4V3NR4V3NR4V3N15 = R4V3NR4V3NR4V3NR4V3NR4V3N3.distanceTo(R4V3NR4V3NR4V3NR4V3NR4V3N14.hitVec)) < R4V3NR4V3NR4V3NR4V3NR4V3N9) && R4V3NR4V3NR4V3NR4V3NR4V3N9 != 0.0) continue;
            boolean canRiderInteract = false;
            if (R4V3NR4V3NR4V3NR4V3NR4V3N11 == R4V3NR4V3NR4V3NR4V3NR4V3N2.ridingEntity) {
                if (R4V3NR4V3NR4V3NR4V3NR4V3N9 != 0.0) continue;
                entity = R4V3NR4V3NR4V3NR4V3NR4V3N11;
                R4V3NR4V3NR4V3NR4V3NR4V3N6 = R4V3NR4V3NR4V3NR4V3NR4V3N14.hitVec;
                continue;
            }
            entity = R4V3NR4V3NR4V3NR4V3NR4V3N11;
            R4V3NR4V3NR4V3NR4V3NR4V3N6 = R4V3NR4V3NR4V3NR4V3NR4V3N14.hitVec;
            R4V3NR4V3NR4V3NR4V3NR4V3N9 = R4V3NR4V3NR4V3NR4V3NR4V3N15;
        }
        if (R4V3NR4V3NR4V3NR4V3NR4V3N9 < R4V3NR4V3NR4V3NR4V3NR4V3ND && !(entity instanceof EntityLivingBase) && !(entity instanceof EntityItemFrame)) {
            entity = null;
        }
        mc.mcProfiler.endSection();
        if (entity == null || R4V3NR4V3NR4V3NR4V3NR4V3N6 == null) {
            return null;
        }
        return new Object[]{entity, R4V3NR4V3NR4V3NR4V3NR4V3N6};
    }
}
