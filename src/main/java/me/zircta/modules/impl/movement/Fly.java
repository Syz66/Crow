package me.zircta.modules.impl.movement;

import me.zircta.modules.api.Module;

// TODO: Improve
public class Fly extends Module {
    private static float a;
    private int b;

    public Fly() {
        super("Fly", Module.category.movement, 0);
    }

    @Override
    public void onEnable() {
        a = mc.thePlayer.stepHeight;
    }

    @Override
    public void onDisable() {
        mc.thePlayer.stepHeight = a;
    }

    @Override
    public void update() {
        if (mc.gameSettings.keyBindForward.isKeyDown()) {
            mc.thePlayer.stepHeight = 0.0f;
            ++this.b;
            if (this.b == 2) {
                mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + 1.0E-10, mc.thePlayer.posZ);
                this.b = 0;
            }
            mc.thePlayer.motionY = 0.0;
            mc.thePlayer.onGround = true;
        }
        if (mc.gameSettings.keyBindJump.isPressed()) {
            mc.thePlayer.setPosition(mc.thePlayer.posX, mc.thePlayer.posY + 0.4, mc.thePlayer.posZ);
        }
    }
}

