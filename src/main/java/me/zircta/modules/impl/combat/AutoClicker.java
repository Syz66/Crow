package me.zircta.modules.impl.combat;

import me.zircta.modules.api.Module;
import me.zircta.modules.impl.other.SelfDestruct;
import me.zircta.modules.settings.impl.CheckBox;
import me.zircta.modules.settings.impl.Slider;
import me.zircta.utils.PlayerUtils;
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

// TODO: Finish refactor
public class AutoClicker extends Module
{
    public static Slider minCPS, maxCPS, jitter;
    public static CheckBox weapons, breakBlocks;

    private static final Field f, g, h;
    private long i, j, k, l;
    private double m;
    private boolean n;
    private final Random rand = new Random();

    public AutoClicker() {
        super("AutoClicker", Module.category.combat, 0);
        this.registerSetting(minCPS = new Slider("Min CPS", 9.0, 1.0, 25.0, 0.5));
        this.registerSetting(maxCPS = new Slider("Max CPS", 12.0, 1.0, 25.0, 0.5));
        this.registerSetting(jitter = new Slider("Jitter", 0.0, 0.0, 3.0, 0.1));
        this.registerSetting(weapons = new CheckBox("Weapon Only", false));
        this.registerSetting(breakBlocks = new CheckBox("Break Blocks", true));
    }

    @SubscribeEvent
    public void onRenderHand(RenderHandEvent ev) {
        if (PlayerUtils.e() && !SelfDestruct.a) {
            if (mc.currentScreen != null) {
                return;
            }
            PlayerUtils.b(minCPS, maxCPS);
            Mouse.poll();
            if (Mouse.isButtonDown(0)) {
                BlockPos p;
                if (!mc.inGameHasFocus) {
                    return;
                }
                if (weapons.isToggled()) {
                    if (mc.thePlayer.getCurrentEquippedItem() == null) {
                        return;
                    }
                    if (!(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) && !(mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemAxe)) {
                        return;
                    }
                }
                if (breakBlocks.isToggled() && mc.objectMouseOver != null && (p = mc.objectMouseOver.getBlockPos()) != null) {
                    if (mc.theWorld.getBlockState(p).getBlock() != Blocks.air) {
                        int a2 = mc.gameSettings.keyBindAttack.getKeyCode();
                        KeyBinding.setKeyBindState(a2, true);
                        KeyBinding.onTick(a2);
                        return;
                    }
                    int a3 = mc.gameSettings.keyBindAttack.getKeyCode();
                    KeyBinding.setKeyBindState(a3, false);
                }
                if (jitter.getInput() > 0.0) {
                    float a4 = (float)jitter.getInput() * 0.45f;
                    mc.thePlayer.rotationYaw = this.rand.nextBoolean() ? (mc.thePlayer.rotationYaw + this.rand.nextFloat() * a4) : (mc.thePlayer.rotationYaw - this.rand.nextFloat() * a4);
                    mc.thePlayer.rotationPitch = this.rand.nextBoolean() ? (mc.thePlayer.rotationPitch + this.rand.nextFloat() * (a4 * 0.45f)) : (mc.thePlayer.rotationPitch - this.rand.nextFloat() * (a4 * 0.45f));
                }
                if (this.j > 0L && this.i > 0L) {
                    if (System.currentTimeMillis() > this.j) {
                        int a5 = mc.gameSettings.keyBindAttack.getKeyCode();
                        KeyBinding.setKeyBindState(a5, true);
                        KeyBinding.onTick(a5);
                        click(0, true);
                        this.gd();
                    } else if (System.currentTimeMillis() > this.i) {
                        int a6 = mc.gameSettings.keyBindAttack.getKeyCode();
                        KeyBinding.setKeyBindState(a6, false);
                        click(0, false);
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
        double a2 = minCPS.getInput();
        double b = maxCPS.getInput();
        double c = a2 + this.rand.nextDouble() * (b - a2);
        long d = (int)Math.round(1000.0 / c);
        if (System.currentTimeMillis() > this.k) {
            if (!this.n && this.rand.nextInt(100) >= 85) {
                this.n = true;
                this.m = 1.1 + this.rand.nextDouble() * 0.15;
            } else {
                this.n = false;
            }
            this.k = System.currentTimeMillis() + 500L + (long)this.rand.nextInt(1500);
        }
        if (this.n) {
            d = (long)((double)d * this.m);
        }
        if (System.currentTimeMillis() > this.l) {
            if (this.rand.nextInt(100) >= 80) {
                d += 50L + (long)this.rand.nextInt(100);
            }
            this.l = System.currentTimeMillis() + 500L + (long)this.rand.nextInt(100);
        }
        this.j = System.currentTimeMillis() + d;
        this.i = System.currentTimeMillis() + d / 2L - (long)this.rand.nextInt(10);
    }

    public void click(int button, boolean state) {
        try {
            MouseEvent m = new MouseEvent();
            g.set(m, button);
            f.set(m, state);
            EventBus.subscribe(m);
            ByteBuffer buffer = (ByteBuffer) h.get(null);
            buffer.put(button, (byte) (state ? 1 : 0));
        } catch (IllegalAccessException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void onEnable() {
        g.setAccessible(true);
        f.setAccessible(true);
        h.setAccessible(true);
    }


    @Override
    public void onDisable() {
        g.setAccessible(false);
        f.setAccessible(false);
        h.setAccessible(false);
    }

    static {
        try {
            g = MouseEvent.class.getDeclaredField("button");
            f = MouseEvent.class.getDeclaredField("buttonState");
            h = Mouse.class.getDeclaredField("buttons");
        } catch (NoSuchFieldException ex) {
            throw new RuntimeException(ex);
        }
    }
}