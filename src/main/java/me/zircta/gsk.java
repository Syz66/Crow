package me.zircta;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class gsk extends GuiScreen {
    private static final String[] cn = new String[]{"White", "Red", "Green", "Blue", "Yellow", "Purple", "Rainbow"};
    private GuiButton b1;
    private GuiButton b2;
    private GuiButton b3;
    private boolean d = false;
    private int lx;
    private int ly;

    public void initGui() {
        ks settings = w.d2();
        this.b1 = new GuiButton(0, this.width / 2 - 70, this.height / 2 - 28, 140, 20, settings.isEnabled() ? "Enabled" : "Disabled");
        this.buttonList.add(this.b1);
        this.b2 = new GuiButton(1, this.width / 2 - 70, this.height / 2 - 6, 140, 20, "Show mouse buttons: " + (settings.isShowingMouseButtons() ? "On" : "Off"));
        this.buttonList.add(this.b2);
        this.b3 = new GuiButton(2, this.width / 2 - 70, this.height / 2 + 16, 140, 20, "Text color: " + cn[settings.getTextColor()]);
        this.buttonList.add(this.b3);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        w.e2().renderKeystrokes();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void actionPerformed(GuiButton button) {
        ks settings = w.d2();
        if (button == this.b1) {
            settings.setEnabled(!settings.isEnabled());
            this.b1.displayString = settings.isEnabled() ? "Enabled" : "Disabled";
        } else if (button == this.b2) {
            settings.setShowingMouseButtons(!settings.isShowingMouseButtons());
            this.b2.displayString = "Show mouse buttons: " + (settings.isShowingMouseButtons() ? "On" : "Off");
        } else if (button == this.b3) {
            settings.setTextColor(settings.getTextColor() == 6 ? 0 : settings.getTextColor() + 1);
            this.b3.displayString = "Text color: " + cn[settings.getTextColor()];
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int button) {
        super.mouseClicked(mouseX, mouseY, button);
        if (button != 0) {
            return;
        }
        ks settings = w.d2();
        int startX = settings.getX();
        int startY = settings.getY();
        int endX = startX + 74;
        int endY = startY + (settings.isShowingMouseButtons() ? 74 : 50);
        if (mouseX >= startX && mouseX <= endX && mouseY >= startY && mouseY <= endY) {
            this.d = true;
            this.lx = mouseX;
            this.ly = mouseY;
        }
    }

    public void mouseReleased(int mouseX, int mouseY, int action) {
        super.mouseReleased(mouseX, mouseY, action);
        this.d = false;
    }

    public void mouseClickMove(int mouseX, int mouseY, int lastButtonClicked, long timeSinceMouseClick) {
        super.mouseClickMove(mouseX, mouseY, lastButtonClicked, timeSinceMouseClick);
        if (!this.d) {
            return;
        }
        ks settings = w.d2();
        settings.setX(settings.getX() + mouseX - this.lx);
        settings.setY(settings.getY() + mouseY - this.ly);
        this.lx = mouseX;
        this.ly = mouseY;
    }

    public boolean doesGuiPauseGame() {
        return false;
    }
}
