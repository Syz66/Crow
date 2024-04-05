package me.zircta.crow.modules.impl.other;

import me.zircta.crow.modules.api.Category;
import me.zircta.crow.modules.api.Module;
import me.zircta.crow.modules.impl.combat.AutoClicker;
import me.zircta.crow.modules.impl.combat.Reach;
import me.zircta.crow.modules.impl.combat.Velocity;
import me.zircta.crow.modules.settings.impl.CheckBox;

public class AutoConfig extends Module {
    public static CheckBox a1, a2, a3, a4;

    public static boolean a5, a6;
    public static int a7;

    public AutoConfig() {
        super("AutoConfig", Category.Other, 0);
        this.registerSetting(a1 = new CheckBox("Consider Ping", true));
        this.registerSetting(a2 = new CheckBox("Configure Reach", true));
        this.registerSetting(a3 = new CheckBox("Configure Velocity", true));
        this.registerSetting(a4 = new CheckBox("Configure AutoClicker", true));
    }

    @Override
    public void onEnable() {
        if (mc.isSingleplayer()) {
            mc.displayGuiScreen(null);
            a6 = true;
        } else {
            mc.displayGuiScreen(null);
            a5 = true;
        }
    }

    @Override
    public void onDisable() {
        a6 = false;
        a7 = 0;
        a5 = false;
    }

    public static void a(int p, String s) {
        if (s.toLowerCase().contains("hypixel.net") || s.toLowerCase().contains("mineplex.com")) {
            Module.getModule(Reach.class).enable();
            Reach.d.disable();
            if (a1.isToggled()) {
                if (p > 200) {
                    Reach.a.setValue(3.6);
                    Reach.b.setValue(3.8);
                }
                if (p > 170 && p < 200) {
                    Reach.a.setValue(3.5);
                    Reach.b.setValue(3.8);
                }
                if (p > 120 && p < 170) {
                    Reach.a.setValue(3.5);
                    Reach.b.setValue(3.7);
                }
                if (p > 100 && p < 120) {
                    Reach.a.setValue(3.3);
                    Reach.b.setValue(3.5);
                }
                if (p > 40 && p < 100) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.4);
                }
                if (p >= 0 && p < 40) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.3);
                }
            } else {
                Reach.a.setValue(3.3);
                Reach.b.setValue(3.5);
            }
        } else if (s.toLowerCase().contains("minemen.club") || s.toLowerCase().contains("pvptemple.com") || s.toLowerCase().contains("arcane.cc") || s.toLowerCase().contains("syuu.net")) {
            Module.getModule(Reach.class).enable();
            Reach.d.disable();
            if (a1.isToggled()) {
                if (p > 170) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.5);
                }
                if (p > 65 && p < 170) {
                    Reach.a.setValue(3.1);
                    Reach.b.setValue(3.3);
                }
                if (p > 30 && p < 65) {
                    Reach.a.setValue(3.0);
                    Reach.b.setValue(3.2);
                }
                if (p >= 0 && p < 30) {
                    Reach.a.setValue(3.0);
                    Reach.b.setValue(3.15);
                }
            } else {
                Reach.a.setValue(3.0);
                Reach.b.setValue(3.15);
            }
        } else if (s.toLowerCase().contains("invadedlands.net") || s.toLowerCase().contains("faithfulmc.com")) {
            Module.getModule(Reach.class).enable();
            Reach.d.disable();
            if (a1.isToggled()) {
                if (p > 170) {
                    Reach.a.setValue(3.3);
                    Reach.b.setValue(3.5);
                }
                if (p > 150 && p < 170) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.5);
                }
                if (p > 100 && p < 150) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.4);
                }
                if (p >= 0 && p < 100) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.3);
                }
            } else {
                Reach.a.setValue(3.2);
                Reach.b.setValue(3.3);
            }
        } else {
            Module.getModule(Reach.class).enable();
            Reach.d.disable();
            if (a1.isToggled()) {
                if (p > 170) {
                    Reach.a.setValue(3.3);
                    Reach.b.setValue(3.5);
                }
                if (p > 150 && p < 170) {
                    Reach.a.setValue(3.3);
                    Reach.b.setValue(3.4);
                }
                if (p > 100 && p < 150) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.4);
                }
                if (p >= 0 && p < 100) {
                    Reach.a.setValue(3.2);
                    Reach.b.setValue(3.3);
                }
            } else {
                Reach.a.setValue(3.2);
                Reach.b.setValue(3.3);
            }
        }
    }

    public static void b(int p, String s) {
        if (s.toLowerCase().contains("hypixel.net") || s.toLowerCase().contains("mineplex.com")) {
            Module.getModule(Velocity.class).enable();
            if (a1.isToggled()) {
                if (p > 170) {
                    Velocity.horizontal.setValue(85.0);
                    Velocity.vertical.setValue(97.0);
                }
                if (p > 120 && p < 170) {
                    Velocity.horizontal.setValue(88.0);
                    Velocity.vertical.setValue(98.0);
                }
                if (p > 20 && p < 120) {
                    Velocity.horizontal.setValue(91.0);
                    Velocity.vertical.setValue(99.0);
                }
                if (p >= 0 && p < 20) {
                    Velocity.horizontal.setValue(93.0);
                    Velocity.vertical.setValue(99.0);
                }
            } else {
                Velocity.horizontal.setValue(90.0);
                Velocity.vertical.setValue(99.0);
            }
        } else if (s.toLowerCase().contains("minemen.club") || s.toLowerCase().contains("pvptemple.com") || s.toLowerCase().contains("faithfulmc.com") || s.toLowerCase().contains("syuu.net")) {
            Module.getModule(Velocity.class).enable();
            if (a1.isToggled()) {
                if (p > 170) {
                    Velocity.horizontal.setValue(87.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 150 && p < 170) {
                    Velocity.horizontal.setValue(89.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 120 && p < 150) {
                    Velocity.horizontal.setValue(91.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 80 && p < 120) {
                    Velocity.horizontal.setValue(93.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 40 && p < 80) {
                    Velocity.horizontal.setValue(94.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    Velocity.horizontal.setValue(95.0);
                    Velocity.vertical.setValue(100.0);
                }
            } else {
                Velocity.horizontal.setValue(93.0);
                Velocity.vertical.setValue(100.0);
            }
        } else if (s.toLowerCase().contains("invadedlands.net")) {
            Module.getModule(Velocity.class).enable();
            if (a1.isToggled()) {
                if (p > 170) {
                    Velocity.horizontal.setValue(83.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 150 && p < 170) {
                    Velocity.horizontal.setValue(85.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 120 && p < 150) {
                    Velocity.horizontal.setValue(87.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 80 && p < 120) {
                    Velocity.horizontal.setValue(90.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 40 && p < 80) {
                    Velocity.horizontal.setValue(93.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    Velocity.horizontal.setValue(95.0);
                    Velocity.vertical.setValue(100.0);
                }
            } else {
                Velocity.horizontal.setValue(92.0);
                Velocity.vertical.setValue(100.0);
            }
        } else {
            Module.getModule(Velocity.class).enable();
            if (a1.isToggled()) {
                if (p > 170) {
                    Velocity.horizontal.setValue(87.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 150 && p < 170) {
                    Velocity.horizontal.setValue(89.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 120 && p < 150) {
                    Velocity.horizontal.setValue(91.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 80 && p < 120) {
                    Velocity.horizontal.setValue(94.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p > 40 && p < 80) {
                    Velocity.horizontal.setValue(95.0);
                    Velocity.vertical.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    Velocity.horizontal.setValue(96.0);
                    Velocity.vertical.setValue(100.0);
                }
            } else {
                Velocity.horizontal.setValue(96.0);
                Velocity.vertical.setValue(100.0);
            }
        }
    }

    public static void c(int p, String s) {
        Module.getModule(AutoClicker.class).enable();
        if (s.toLowerCase().contains("hypixel.net") || s.toLowerCase().contains("mineplex.com")) {
            AutoClicker.minCPS.setValue(10.5);
            AutoClicker.maxCPS.setValue(16.0);
            AutoClicker.jitter.setValue(0.1);
        } else if (s.toLowerCase().contains("minemen.club") || s.toLowerCase().contains("invadedlands.net") || s.toLowerCase().contains("pvptemple.com") || s.toLowerCase().contains("faithfulmc.com") || s.toLowerCase().contains("syuu.net")) {
            AutoClicker.minCPS.setValue(8.0);
            AutoClicker.maxCPS.setValue(12.0);
            AutoClicker.jitter.setValue(0.3);
        } else {
            AutoClicker.minCPS.setValue(9.0);
            AutoClicker.maxCPS.setValue(14.0);
            AutoClicker.jitter.setValue(0.1);
        }
    }

    static {
        a5 = false;
        a6 = false;
        a7 = 0;
    }
}
