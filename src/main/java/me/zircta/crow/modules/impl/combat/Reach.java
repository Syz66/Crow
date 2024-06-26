package me.zircta.crow.modules.impl.combat;

import me.zircta.crow.modules.api.Category;
import me.zircta.crow.modules.api.Module;
import me.zircta.crow.modules.settings.impl.Slider;
import me.zircta.crow.utils.PlayerUtils;
import me.zircta.crow.modules.impl.other.SelfDestruct;
import me.zircta.crow.modules.settings.impl.CheckBox;
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

public class Reach extends Module {
    public static Slider a;
    public static Slider b;
    public static CheckBox c;
    public static CheckBox d;
    public Random e = new Random();

    public Reach() {
        super("Reach", Category.Combat, 0);
        a = new Slider("Min", 3.1, 3.0, 6.0, 0.05);
        b = new Slider("Max", 3.3, 3.0, 6.0, 0.05);
        c = new CheckBox("Weapon Only", false);
        d = new CheckBox("Hit Through Blocks", false);
        this.registerSetting(a);
        this.registerSetting(b);
        this.registerSetting(c);
        this.registerSetting(d);
    }

    @SubscribeEvent
    public void e(MouseEvent f) {
        if (PlayerUtils.e() && !SelfDestruct.a) {
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
            PlayerUtils.b(a, b);
            double R4V3NR4V3NR4V3NR4V3NR4V3ND2 = a.getInput() + this.e.nextDouble() * (b.getInput() - a.getInput());
            Object[] R4V3NR4V3NR4V3NR4V3NR4V3NN = Reach.R4V3NR4V3NR4V3NR4V3NR4V3N(R4V3NR4V3NR4V3NR4V3NR4V3ND2, 0.0, 0.0f);
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
        List<Entity> R4V3NR4V3NR4V3NR4V3NR4V3N8 = mc.theWorld.getEntitiesWithinAABBExcludingEntity(R4V3NR4V3NR4V3NR4V3NR4V3N2, R4V3NR4V3NR4V3NR4V3NR4V3N2.getEntityBoundingBox().addCoord(R4V3NR4V3NR4V3NR4V3NR4V3N4.xCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND, R4V3NR4V3NR4V3NR4V3NR4V3N4.yCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND, R4V3NR4V3NR4V3NR4V3NR4V3N4.zCoord * R4V3NR4V3NR4V3NR4V3NR4V3ND).expand(1.0, 1.0, 1.0));
        double R4V3NR4V3NR4V3NR4V3NR4V3N9 = R4V3NR4V3NR4V3NR4V3NR4V3ND;
        for (Entity value : R4V3NR4V3NR4V3NR4V3NR4V3N8) {
            double R4V3NR4V3NR4V3NR4V3NR4V3N15;
            if (!value.canBeCollidedWith()) continue;
            float R4V3NR4V3NR4V3NR4V3NR4V3N12 = value.getCollisionBorderSize();
            AxisAlignedBB R4V3NR4V3NR4V3NR4V3NR4V3N13 = value.getEntityBoundingBox().expand(R4V3NR4V3NR4V3NR4V3NR4V3N12, R4V3NR4V3NR4V3NR4V3NR4V3N12, R4V3NR4V3NR4V3NR4V3NR4V3N12);
            R4V3NR4V3NR4V3NR4V3NR4V3N13 = R4V3NR4V3NR4V3NR4V3NR4V3N13.expand(R4V3NR4V3NR4V3NR4V3NR4V3NE, R4V3NR4V3NR4V3NR4V3NR4V3NE, R4V3NR4V3NR4V3NR4V3NR4V3NE);
            MovingObjectPosition R4V3NR4V3NR4V3NR4V3NR4V3N14 = R4V3NR4V3NR4V3NR4V3NR4V3N13.calculateIntercept(R4V3NR4V3NR4V3NR4V3NR4V3N3, R4V3NR4V3NR4V3NR4V3NR4V3N5);
            if (R4V3NR4V3NR4V3NR4V3NR4V3N13.isVecInside(R4V3NR4V3NR4V3NR4V3NR4V3N3)) {
                if (!(0.0 < R4V3NR4V3NR4V3NR4V3NR4V3N9) && R4V3NR4V3NR4V3NR4V3NR4V3N9 != 0.0) continue;
                entity = value;
                R4V3NR4V3NR4V3NR4V3NR4V3N6 = R4V3NR4V3NR4V3NR4V3NR4V3N14 == null ? R4V3NR4V3NR4V3NR4V3NR4V3N3 : R4V3NR4V3NR4V3NR4V3NR4V3N14.hitVec;
                R4V3NR4V3NR4V3NR4V3NR4V3N9 = 0.0;
                continue;
            }
            if (R4V3NR4V3NR4V3NR4V3NR4V3N14 == null || !((R4V3NR4V3NR4V3NR4V3NR4V3N15 = R4V3NR4V3NR4V3NR4V3NR4V3N3.distanceTo(R4V3NR4V3NR4V3NR4V3NR4V3N14.hitVec)) < R4V3NR4V3NR4V3NR4V3NR4V3N9) && R4V3NR4V3NR4V3NR4V3NR4V3N9 != 0.0)
                continue;
            if (value == R4V3NR4V3NR4V3NR4V3NR4V3N2.ridingEntity) {
                if (R4V3NR4V3NR4V3NR4V3NR4V3N9 != 0.0) continue;
                entity = value;
                R4V3NR4V3NR4V3NR4V3NR4V3N6 = R4V3NR4V3NR4V3NR4V3NR4V3N14.hitVec;
                continue;
            }
            entity = value;
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
