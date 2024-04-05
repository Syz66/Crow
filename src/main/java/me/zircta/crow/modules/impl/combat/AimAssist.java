package me.zircta.crow.modules.impl.combat;

import me.zircta.crow.modules.api.Category;
import me.zircta.crow.modules.api.Module;
import me.zircta.crow.modules.settings.impl.Slider;
import me.zircta.crow.utils.PlayerUtils;
import me.zircta.crow.modules.impl.other.SelfDestruct;
import me.zircta.crow.modules.settings.impl.CheckBox;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;

// TODO: Clean up
public class AimAssist extends Module {
    public static Slider a;
    public static Slider b;
    public static Slider c;
    public static CheckBox d;
    public static CheckBox e;
    public static CheckBox f;
    public static CheckBox g;

    public AimAssist() {
        super("AimAssist", Category.Combat, 0);
        a = new Slider("Speed", 45.0, 10.0, 100.0, 1.0);
        b = new Slider("FOV", 90.0, 15.0, 180.0, 1.0);
        c = new Slider("Distance", 4.5, 1.0, 10.0, 0.5);
        d = new CheckBox("ClickAim", true);
        e = new CheckBox("Weapon Only", false);
        f = new CheckBox("Aim Invis", false);
        g = new CheckBox("Blatant Mode", false);
        this.registerSetting(a);
        this.registerSetting(b);
        this.registerSetting(c);
        this.registerSetting(d);
        this.registerSetting(e);
        this.registerSetting(f);
        this.registerSetting(g);
    }

    @Override
    public void update() {
        if (PlayerUtils.e() && !SelfDestruct.a) {
            if (e.isToggled()) {
                if (mc.thePlayer.getCurrentEquippedItem() == null) {
                    return;
                }
                if (!(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                    return;
                }
            }
            if (d.isToggled() && !mc.gameSettings.keyBindAttack.isKeyDown()) {
                return;
            }
            Entity h = this.j();
            if (!g.isToggled()) {
                if (h != null && (n(h) > 1.0 || n(h) < -1.0)) {
                    boolean i = n(h) > 0.0;
                    mc.thePlayer.rotationYaw = mc.thePlayer.rotationYaw + (float)(i ? -(Math.abs(n(h)) / a.getInput()) : Math.abs(n(h)) / a.getInput());
                }
            } else {
                r(h);
            }
        }
    }

    public Entity j() {
        Entity k = null;
        int f = (int)b.getInput();
        for (Entity loadedEntites : mc.theWorld.loadedEntityList) {
            if (!loadedEntites.isEntityAlive() || loadedEntites == mc.thePlayer || !((double)mc.thePlayer.getDistanceToEntity(loadedEntites) <= c.getInput()) || !(loadedEntites instanceof EntityLivingBase)) continue;
            if (!g.isToggled()) {
                if (!o(loadedEntites, f)) continue;
                if (AimAssist.f.isToggled()) {
                    k = loadedEntites;
                    f = (int)n(loadedEntites);
                    continue;
                }
                if (loadedEntites.isInvisible()) continue;
                k = loadedEntites;
                f = (int)n(loadedEntites);
                continue;
            }
            if (AimAssist.f.isToggled()) {
                k = loadedEntites;
                f = (int)n(loadedEntites);
                continue;
            }
            if (loadedEntites.isInvisible()) continue;
            k = loadedEntites;
            f = (int)n(loadedEntites);
        }
        return k;
    }

    public static double m(Entity ent) {
        double x = ent.posX - mc.thePlayer.posX;
        double z = ent.posZ - mc.thePlayer.posZ;
        double yaw = Math.atan2(x, z) * 57.2957795;
        yaw = -yaw;
        return yaw;
    }

    public static double n(Entity en) {
        return ((mc.thePlayer.rotationYaw - m(en)) % 360.0 + 540.0) % 360.0 - 180.0;
    }

    public static boolean o(Entity entity, float b) {
        b = (float)((double)b * 0.5);
        double v = ((mc.thePlayer.rotationYaw - m(entity)) % 360.0 + 540.0) % 360.0 - 180.0;
        return v > 0.0 && v < (double)b || (double)(-b) < v && v < 0.0;
    }

    public static float[] p(Entity q) {
        double diffY;
        if (q == null) {
            return null;
        }
        double diffX = q.posX - mc.thePlayer.posX;
        if (q instanceof EntityLivingBase EntityLivingBase2) {
            diffY = EntityLivingBase2.posY + (double)EntityLivingBase2.getEyeHeight() * 0.9 - (mc.thePlayer.posY + (double)mc.thePlayer.getEyeHeight());
        } else {
            diffY = (q.getEntityBoundingBox().minY + q.getEntityBoundingBox().maxY) / 2.0 - (mc.thePlayer.posY + (double)mc.thePlayer.getEyeHeight());
        }
        double diffZ = q.posZ - mc.thePlayer.posZ;
        double dist = MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
        float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0 / Math.PI) - 90.0f;
        float pitch = (float)(-(Math.atan2(diffY, dist) * 180.0 / Math.PI));
        return new float[]{mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float(yaw - mc.thePlayer.rotationYaw), mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float(pitch - mc.thePlayer.rotationPitch)};
    }

    public static void r(Entity s) {
        float[] t = p(s);
        if (t != null) {
            mc.thePlayer.rotationYaw = t[0];
            mc.thePlayer.rotationPitch = t[1] + 4.0f;
        }
    }
}
