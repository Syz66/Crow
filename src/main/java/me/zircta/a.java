package me.zircta;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;
import net.minecraft.util.BlockPos;
import net.weavemc.loader.api.event.EventBus;
import net.weavemc.loader.api.event.MouseEvent;
import net.weavemc.loader.api.event.RenderHandEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import org.lwjgl.input.Mouse;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Random;

public class a extends bb {
    public static ap a;
    public static ap b;
    public static ap c;
    public static cb d;
    public static cb e;
    private static Field f;
    private static Field g;
    private static Field h;
    private long i;
    private long j;
    private long k;
    private long l;
    private double m;
    private boolean n;
    private Random o;

    public a() {
        super("AutoClicker", bb.category.combat, 0);
        a = new ap("Min CPS", 9.0, 1.0, 25.0, 0.5);
        b = new ap("Max CPS", 12.0, 1.0, 25.0, 0.5);
        c = new ap("Jitter", 0.0, 0.0, 3.0, 0.1);
        d = new cb("Weapon Only", false);
        e = new cb("Break Blocks", true);
        this.registerSetting(a);
        this.registerSetting(b);
        this.registerSetting(c);
        this.registerSetting(d);
        this.registerSetting(e);
        this.o = new Random();
    }

    @SubscribeEvent
    public void k(RenderHandEvent ev) {
        if (ay.e() && !ax.a) {
            if (mc.currentScreen != null) {
                return;
            }
            ay.b(a, b);
            Mouse.poll();
            if (Mouse.isButtonDown((int)0)) {
                BlockPos p;
                if (!mc.inGameHasFocus) {
                    return;
                }
                if (d.isToggled()) {
                    if (mc.thePlayer.getCurrentEquippedItem() == null) {
                        return;
                    }
                    if (!(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                        return;
                    }
                }
                if (e.isToggled() && mc.objectMouseOver != null && (p = mc.objectMouseOver.getBlockPos()) != null) {
                    if (mc.theWorld.getBlockState(p).getBlock() != Blocks.air) {
                        int a2 = mc.gameSettings.keyBindAttack.getKeyCode();
                        KeyBinding.setKeyBindState((int)a2, (boolean)true);
                        KeyBinding.onTick((int)a2);
                        return;
                    }
                    int a3 = mc.gameSettings.keyBindAttack.getKeyCode();
                    KeyBinding.setKeyBindState((int)a3, (boolean)false);
                }
                if (c.getInput() > 0.0) {
                    double a4 = c.getInput() * 0.45;
                    mc.thePlayer.rotationYaw = this.o.nextBoolean() ? (float)((double)mc.thePlayer.rotationYaw + (double)this.o.nextFloat() * a4) : (float)((double)mc.thePlayer.rotationYaw - (double)this.o.nextFloat() * a4);
                    mc.thePlayer.rotationPitch = this.o.nextBoolean() ? (float)((double)mc.thePlayer.rotationPitch + (double)this.o.nextFloat() * (a4 * 0.45)) : (float)((double)mc.thePlayer.rotationPitch - (double)this.o.nextFloat() * (a4 * 0.45));
                }
                if (this.j > 0L && this.i > 0L) {
                    if (System.currentTimeMillis() > this.j) {
                        int a5 = mc.gameSettings.keyBindAttack.getKeyCode();
                        KeyBinding.setKeyBindState((int)a5, (boolean)true);
                        KeyBinding.onTick((int)a5);
                        this.c(0, true);
                        this.gd();
                    } else if (System.currentTimeMillis() > this.i) {
                        int a6 = mc.gameSettings.keyBindAttack.getKeyCode();
                        KeyBinding.setKeyBindState((int)a6, (boolean)false);
                        this.c(0, false);
                    }
                } else {
                    this.gd();
                }
            } else {
                this.i = 0L;
                this.j = 0L;
            }
        }
    }

    public void gd() {
        double a2 = a.getInput();
        double b = this.b.getInput();
        double c = a2 + this.o.nextDouble() * (b - a2);
        long d = (int)Math.round(1000.0 / c);
        if (System.currentTimeMillis() > this.k) {
            if (!this.n && this.o.nextInt(100) >= 85) {
                this.n = true;
                this.m = 1.1 + this.o.nextDouble() * 0.15;
            } else {
                this.n = false;
            }
            this.k = System.currentTimeMillis() + 500L + (long)this.o.nextInt(1500);
        }
        if (this.n) {
            d = (long)((double)d * this.m);
        }
        if (System.currentTimeMillis() > this.l) {
            if (this.o.nextInt(100) >= 80) {
                d += 50L + (long)this.o.nextInt(100);
            }
            this.l = System.currentTimeMillis() + 500L + (long)this.o.nextInt(100);
        }
        this.j = System.currentTimeMillis() + d;
        this.i = System.currentTimeMillis() + d / 2L - (long)this.o.nextInt(10);
    }

    public static void c(int keycode, boolean state) {
        MouseEvent m = new MouseEvent();
        g.setAccessible(true);
        try {
            g.set(m, keycode);
        }
        catch (IllegalAccessException er) {
            er.printStackTrace();
        }
        g.setAccessible(false);
        f.setAccessible(true);
        try {
            f.set(m, state);
        }
        catch (IllegalAccessException er) {
            er.printStackTrace();
        }
        f.setAccessible(false);
        EventBus.subscribe(m);
        try {
            h.setAccessible(true);
            ByteBuffer buffer = (ByteBuffer)h.get(null);
            h.setAccessible(false);
            buffer.put(keycode, (byte)(state ? 1 : 0));
        }
        catch (IllegalAccessException er) {
            er.printStackTrace();
        }
    }

    static {
        try {
            g = MouseEvent.class.getDeclaredField("button");
        }
        catch (NoSuchFieldException er) {
            er.printStackTrace();
        }
        try {
            f = MouseEvent.class.getDeclaredField("buttonState");
        }
        catch (NoSuchFieldException er) {
            er.printStackTrace();
        }
        try {
            h = Mouse.class.getDeclaredField("buttons");
        }
        catch (NoSuchFieldException er) {
            er.printStackTrace();
        }
    }
}