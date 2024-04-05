package me.zircta.crow.modules.impl.other;

import me.zircta.crow.Main;
import me.zircta.crow.modules.api.Category;
import me.zircta.crow.modules.api.Module;
import me.zircta.crow.utils.PlayerUtils;

// Named "GuiModule" because Gui is a Minecraft class.
public class GuiModule extends Module {
    public GuiModule() {
        super("Gui", Category.Other, 27);
    }

    @Override
    public void onEnable() {
        if (PlayerUtils.e() && !SelfDestruct.a) {
            mc.displayGuiScreen(Main.clickGui);
            this.toggle();
        }
    }
}

