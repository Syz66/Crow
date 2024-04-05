package me.zircta;

import me.zircta.gui.ClickGui;
import me.zircta.modules.api.Module;
import me.zircta.utils.GuiUtils;
import me.zircta.utils.MouseManager;
import me.zircta.utils.IdkUtils;
import me.zircta.utils.PlayerUtils;
import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.event.EventBus;
import net.weavemc.loader.api.event.StartGameEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

public class Raven implements ModInitializer {
    public static int a = 1;
    public static int b = 0;
    public static Minecraft mc;
    public static IdkUtils c;

    @Override
    public void preInit() {
        EventBus.subscribe(StartGameEvent.Post.class, e -> { init(); });
    }

    public void init() {
        mc = Minecraft.getMinecraft();
        c = new IdkUtils();
        EventBus.subscribe(this);
        EventBus.subscribe(new GuiUtils());
        EventBus.subscribe(new MouseManager());
        c.getm0dmanager().r3g1st3r();
        IdkUtils.b = new ClickGui();
    }

    @SubscribeEvent
    public void f(TickEvent g) {
        if (PlayerUtils.e() && Raven.mc.currentScreen == null) {
            for (Module h : c.getm0dmanager().listofmods()) {
                h.keybind();
                if (!h.isEnabled()) continue;
                h.update();
            }
        }
    }
}
