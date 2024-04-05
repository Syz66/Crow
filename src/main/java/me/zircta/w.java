package me.zircta;

import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.command.CommandBus;
import net.weavemc.loader.api.event.EventBus;
import net.weavemc.loader.api.event.StartGameEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

public class w implements ModInitializer {
    public static int a = 1;
    public static int b = 0;
    public static Minecraft mc;
    public static aw c;
    private static ks a2;
    private static kr b2;
    private static boolean c2;

    @Override
    public void preInit() {
        EventBus.subscribe(StartGameEvent.Post.class, e -> { init(); });
        System.out.println("ravenb1 preinited");
    }

    public void init() {
        mc = Minecraft.getMinecraft();
        c = new aw();
        CommandBus.register(new cm2());
        a2 = new ks();
        b2 = new kr();
        EventBus.subscribe(this);
        EventBus.subscribe(new r());
        EventBus.subscribe(new cl());
        EventBus.subscribe(b2);
        c.getm0dmanager().r3g1st3r();
        aw.b = new m();
        System.out.println("ravenb1 inited");
    }

    @SubscribeEvent
    public void f(TickEvent g) {
        if (ay.e() && w.mc.currentScreen == null) {
            for (bb h : c.getm0dmanager().listofmods()) {
                h.keybind();
                System.out.println("ravenb1 keybinding");
                if (!h.isEnabled()) continue;
                h.update();
                System.out.println("ravenb1 update");
            }
        }
        if (c2) {
            mc.displayGuiScreen(new gsk());
            c2 = false;
        }
    }

    public static ks d2() {
        return a2;
    }

    public static kr e2() {
        return b2;
    }

    public static void f2() {
        c2 = true;
    }
}
