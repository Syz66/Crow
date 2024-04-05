package me.zircta.modules.impl.other;

import me.zircta.modules.impl.other.SelfDestruct;
import me.zircta.utils.IdkUtils;
import me.zircta.utils.PlayerUtils;
import me.zircta.modules.api.Module;

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

