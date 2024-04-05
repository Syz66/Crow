package me.zircta.crow;

import me.zircta.crow.gui.ClickGui;
import me.zircta.crow.modules.api.Module;
import me.zircta.crow.modules.api.ModuleManager;
import me.zircta.crow.utils.GuiUtils;
import me.zircta.crow.utils.MouseManager;
import me.zircta.crow.utils.PlayerUtils;
import net.minecraft.client.Minecraft;
import net.weavemc.loader.api.ModInitializer;
import net.weavemc.loader.api.event.EventBus;
import net.weavemc.loader.api.event.StartGameEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import net.weavemc.loader.api.event.TickEvent;

public class Main implements ModInitializer {
    public static Minecraft mc;

    public static ModuleManager moduleManager;
    public static ClickGui clickGui;

    @Override
    public void preInit() {
        EventBus.subscribe(StartGameEvent.Post.class, e -> init());
    }

    public void init() {
        mc = Minecraft.getMinecraft();
        moduleManager = new ModuleManager();
        clickGui = new ClickGui();

        EventBus.subscribe(this);
        EventBus.subscribe(new GuiUtils());
        EventBus.subscribe(new MouseManager());
    }

    @SubscribeEvent
    public void f(TickEvent g) {
        if (PlayerUtils.e() && Main.mc.currentScreen == null) {
            for (Module h : ModuleManager.getModules()) {
                h.keybind();
                if (!h.isEnabled()) continue;
                h.update();
            }
        }
    }
}
