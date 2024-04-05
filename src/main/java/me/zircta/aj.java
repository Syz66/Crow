package me.zircta;

public class aj extends bb {
    public static cb a1;
    public static cb a2;
    public static cb a3;
    public static cb a4;
    public static boolean a5;
    public static boolean a6;
    public static int a7;

    public aj() {
        super("AutoConfig", bb.category.other, 0);
        a1 = new cb("Consider Ping", true);
        a2 = new cb("Configure Reach", true);
        a3 = new cb("Configure Velocity", true);
        a4 = new cb("Configure AutoClicker", true);
        this.registerSetting(a1);
        this.registerSetting(a2);
        this.registerSetting(a3);
        this.registerSetting(a4);
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
            bb.getModule(a8.class).enable();
            a8.d.disable();
            if (a1.isToggled()) {
                if (p > 200) {
                    a8.a.setValue(3.6);
                    a8.b.setValue(3.8);
                }
                if (p > 170 && p < 200) {
                    a8.a.setValue(3.5);
                    a8.b.setValue(3.8);
                }
                if (p > 120 && p < 170) {
                    a8.a.setValue(3.5);
                    a8.b.setValue(3.7);
                }
                if (p > 100 && p < 120) {
                    a8.a.setValue(3.3);
                    a8.b.setValue(3.5);
                }
                if (p > 40 && p < 100) {
                    a8.a.setValue(3.2);
                    a8.b.setValue(3.4);
                }
                if (p >= 0 && p < 40) {
                    a8.a.setValue(3.2);
                    a8.b.setValue(3.3);
                }
            } else {
                a8.a.setValue(3.3);
                a8.b.setValue(3.5);
            }
        } else if (s.toLowerCase().contains("minemen.club") || s.toLowerCase().contains("pvptemple.com") || s.toLowerCase().contains("arcane.cc") || s.toLowerCase().contains("syuu.net")) {
            bb.getModule(a8.class).enable();
            a8.d.disable();
            if (a1.isToggled()) {
                if (p > 170) {
                    a8.a.setValue(3.2);
                    a8.b.setValue(3.5);
                }
                if (p > 65 && p < 170) {
                    a8.a.setValue(3.1);
                    a8.b.setValue(3.3);
                }
                if (p > 30 && p < 65) {
                    a8.a.setValue(3.0);
                    a8.b.setValue(3.2);
                }
                if (p >= 0 && p < 30) {
                    a8.a.setValue(3.0);
                    a8.b.setValue(3.15);
                }
            } else {
                a8.a.setValue(3.0);
                a8.b.setValue(3.15);
            }
        } else if (s.toLowerCase().contains("invadedlands.net") || s.toLowerCase().contains("faithfulmc.com")) {
            bb.getModule(a8.class).enable();
            a8.d.disable();
            if (a1.isToggled()) {
                if (p > 170) {
                    a8.a.setValue(3.3);
                    a8.b.setValue(3.5);
                }
                if (p > 150 && p < 170) {
                    a8.a.setValue(3.2);
                    a8.b.setValue(3.5);
                }
                if (p > 100 && p < 150) {
                    a8.a.setValue(3.2);
                    a8.b.setValue(3.4);
                }
                if (p >= 0 && p < 100) {
                    a8.a.setValue(3.2);
                    a8.b.setValue(3.3);
                }
            } else {
                a8.a.setValue(3.2);
                a8.b.setValue(3.3);
            }
        } else {
            bb.getModule(a8.class).enable();
            a8.d.disable();
            if (a1.isToggled()) {
                if (p > 170) {
                    a8.a.setValue(3.3);
                    a8.b.setValue(3.5);
                }
                if (p > 150 && p < 170) {
                    a8.a.setValue(3.3);
                    a8.b.setValue(3.4);
                }
                if (p > 100 && p < 150) {
                    a8.a.setValue(3.2);
                    a8.b.setValue(3.4);
                }
                if (p >= 0 && p < 100) {
                    a8.a.setValue(3.2);
                    a8.b.setValue(3.3);
                }
            } else {
                a8.a.setValue(3.2);
                a8.b.setValue(3.3);
            }
        }
    }

    public static void b(int p, String s) {
        if (s.toLowerCase().contains("hypixel.net") || s.toLowerCase().contains("mineplex.com")) {
            bb.getModule(af.class).enable();
            if (a1.isToggled()) {
                if (p > 170) {
                    af.a.setValue(85.0);
                    af.b.setValue(97.0);
                }
                if (p > 120 && p < 170) {
                    af.a.setValue(88.0);
                    af.b.setValue(98.0);
                }
                if (p > 20 && p < 120) {
                    af.a.setValue(91.0);
                    af.b.setValue(99.0);
                }
                if (p >= 0 && p < 20) {
                    af.a.setValue(93.0);
                    af.b.setValue(99.0);
                }
            } else {
                af.a.setValue(90.0);
                af.b.setValue(99.0);
            }
        } else if (s.toLowerCase().contains("minemen.club") || s.toLowerCase().contains("pvptemple.com") || s.toLowerCase().contains("faithfulmc.com") || s.toLowerCase().contains("syuu.net")) {
            bb.getModule(af.class).enable();
            if (a1.isToggled()) {
                if (p > 170) {
                    af.a.setValue(87.0);
                    af.b.setValue(100.0);
                }
                if (p > 150 && p < 170) {
                    af.a.setValue(89.0);
                    af.b.setValue(100.0);
                }
                if (p > 120 && p < 150) {
                    af.a.setValue(91.0);
                    af.b.setValue(100.0);
                }
                if (p > 80 && p < 120) {
                    af.a.setValue(93.0);
                    af.b.setValue(100.0);
                }
                if (p > 40 && p < 80) {
                    af.a.setValue(94.0);
                    af.b.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    af.a.setValue(95.0);
                    af.b.setValue(100.0);
                }
            } else {
                af.a.setValue(93.0);
                af.b.setValue(100.0);
            }
        } else if (s.toLowerCase().contains("invadedlands.net")) {
            bb.getModule(af.class).enable();
            if (a1.isToggled()) {
                if (p > 170) {
                    af.a.setValue(83.0);
                    af.b.setValue(100.0);
                }
                if (p > 150 && p < 170) {
                    af.a.setValue(85.0);
                    af.b.setValue(100.0);
                }
                if (p > 120 && p < 150) {
                    af.a.setValue(87.0);
                    af.b.setValue(100.0);
                }
                if (p > 80 && p < 120) {
                    af.a.setValue(90.0);
                    af.b.setValue(100.0);
                }
                if (p > 40 && p < 80) {
                    af.a.setValue(93.0);
                    af.b.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    af.a.setValue(95.0);
                    af.b.setValue(100.0);
                }
            } else {
                af.a.setValue(92.0);
                af.b.setValue(100.0);
            }
        } else {
            bb.getModule(af.class).enable();
            if (a1.isToggled()) {
                if (p > 170) {
                    af.a.setValue(87.0);
                    af.b.setValue(100.0);
                }
                if (p > 150 && p < 170) {
                    af.a.setValue(89.0);
                    af.b.setValue(100.0);
                }
                if (p > 120 && p < 150) {
                    af.a.setValue(91.0);
                    af.b.setValue(100.0);
                }
                if (p > 80 && p < 120) {
                    af.a.setValue(94.0);
                    af.b.setValue(100.0);
                }
                if (p > 40 && p < 80) {
                    af.a.setValue(95.0);
                    af.b.setValue(100.0);
                }
                if (p >= 0 && p < 40) {
                    af.a.setValue(96.0);
                    af.b.setValue(100.0);
                }
            } else {
                af.a.setValue(96.0);
                af.b.setValue(100.0);
            }
        }
    }

    public static void c(int p, String s) {
        bb.getModule(a.class).enable();
        if (s.toLowerCase().contains("hypixel.net") || s.toLowerCase().contains("mineplex.com")) {
            a.a.setValue(10.5);
            a.b.setValue(16.0);
            a.c.setValue(0.1);
        } else if (s.toLowerCase().contains("minemen.club") || s.toLowerCase().contains("invadedlands.net") || s.toLowerCase().contains("pvptemple.com") || s.toLowerCase().contains("faithfulmc.com") || s.toLowerCase().contains("syuu.net")) {
            a.a.setValue(8.0);
            a.b.setValue(12.0);
            a.c.setValue(0.3);
        } else {
            a.a.setValue(9.0);
            a.b.setValue(14.0);
            a.c.setValue(0.1);
        }
    }

    static {
        a5 = false;
        a6 = false;
        a7 = 0;
    }
}
