package me.zircta;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.MathHelper;

public class al extends bb {
    public static ap a;
    public static ap b;
    public static ap c;
    public static cb d;
    public static cb e;
    public static cb f;
    public static cb g;

    public al() {
        super("AimAssist", bb.category.combat, 0);
        a = new ap("Speed", 45.0, 10.0, 100.0, 1.0);
        b = new ap("FOV", 90.0, 15.0, 180.0, 1.0);
        c = new ap("Distance", 4.5, 1.0, 10.0, 0.5);
        d = new cb("ClickAim", true);
        e = new cb("Weapon Only", false);
        f = new cb("Aim Invis", false);
        g = new cb("Blatant Mode", false);
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
        if (ay.e() && !ax.a) {
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
        for (Object loadedEntites : mc.theWorld.loadedEntityList) {
            Entity l = (Entity)loadedEntites;
            if (!l.isEntityAlive() || l == mc.thePlayer || !((double)mc.thePlayer.getDistanceToEntity(l) <= c.getInput()) || !(l instanceof EntityLivingBase)) continue;
            if (!g.isToggled()) {
                if (!o(l, f)) continue;
                if (al.f.isToggled()) {
                    k = l;
                    f = (int)n(l);
                    continue;
                }
                if (l.isInvisible()) continue;
                k = l;
                f = (int)n(l);
                continue;
            }
            if (al.f.isToggled()) {
                k = l;
                f = (int)n(l);
                continue;
            }
            if (l.isInvisible()) continue;
            k = l;
            f = (int)n(l);
        }
        return k;
    }

    public static float m(Entity ent) {
        double x = ent.posX - mc.thePlayer.posX;
        double y = ent.posY - mc.thePlayer.posY;
        double z = ent.posZ - mc.thePlayer.posZ;
        double yaw = Math.atan2(x, z) * 57.2957795;
        yaw = -yaw;
        double pitch = Math.asin(y / Math.sqrt(x * x + y * y + z * z)) * 57.2957795;
        pitch = -pitch;
        return (float)yaw;
    }

    public static double n(Entity en) {
        return ((double)(mc.thePlayer.rotationYaw - m(en)) % 360.0 + 540.0) % 360.0 - 180.0;
    }

    public static boolean o(Entity entity, float b) {
        b = (float)((double)b * 0.5);
        double v = ((double)(mc.thePlayer.rotationYaw - m(entity)) % 360.0 + 540.0) % 360.0 - 180.0;
        return v > 0.0 && v < (double)b || (double)(-b) < v && v < 0.0;
    }

    public static float[] p(Entity q) {
        double diffY;
        if (q == null) {
            return null;
        }
        double diffX = q.posX - mc.thePlayer.posX;
        if (q instanceof EntityLivingBase) {
            EntityLivingBase EntityLivingBase2 = (EntityLivingBase)q;
            diffY = EntityLivingBase2.posY + (double)EntityLivingBase2.getEyeHeight() * 0.9 - (mc.thePlayer.posY + (double)mc.thePlayer.getEyeHeight());
        } else {
            diffY = (q.getEntityBoundingBox().minY + q.getEntityBoundingBox().maxY) / 2.0 - (mc.thePlayer.posY + (double)mc.thePlayer.getEyeHeight());
        }
        double diffZ = q.posZ - mc.thePlayer.posZ;
        double dist = MathHelper.sqrt_double((double)(diffX * diffX + diffZ * diffZ));
        float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0 / Math.PI) - 90.0f;
        float pitch = (float)(-(Math.atan2(diffY, dist) * 180.0 / Math.PI));
        return new float[]{mc.thePlayer.rotationYaw + MathHelper.wrapAngleTo180_float((float)(yaw - mc.thePlayer.rotationYaw)), mc.thePlayer.rotationPitch + MathHelper.wrapAngleTo180_float((float)(pitch - mc.thePlayer.rotationPitch))};
    }

    public static void r(Entity s) {
        float[] t = p(s);
        if (t != null) {
            mc.thePlayer.rotationYaw = t[0];
            mc.thePlayer.rotationPitch = t[1] + 4.0f;
        }
    }

    public static String own3r() {
        return "blowsy";
    }
}
