package me.zircta.crow.modules.impl.other;

import me.zircta.crow.modules.api.Module;
import me.zircta.crow.utils.PlayerUtils;
import me.zircta.crow.utils.IdkUtils;

// Named "GuiModule" because Gui is a Minecraft class.
public class GuiModule extends Module {
    public GuiModule() {
        super("Gui", Module.category.other, 27);
    }

    @Override
    public void onEnable() {
        if (PlayerUtils.e() && !SelfDestruct.a) {
            mc.displayGuiScreen(IdkUtils.b);
            this.toggle();
        }
    }
}

