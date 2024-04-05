package me.zircta;

public class ao extends bb {
    private static float a;
    int b;

    public ao() {
        super("Fly", bb.category.movement, 0);
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

