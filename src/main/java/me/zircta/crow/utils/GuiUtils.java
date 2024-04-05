package me.zircta.crow.utils;

import me.zircta.crow.modules.api.Module;
import me.zircta.crow.modules.api.ModuleManager;
import me.zircta.crow.modules.impl.other.AutoConfig;
import me.zircta.crow.modules.impl.render.HUD;
import me.zircta.crow.modules.impl.other.SelfDestruct;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.weavemc.loader.api.event.RenderGameOverlayEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class GuiUtils extends Gui {
    private static final Minecraft mc = Minecraft.getMinecraft();
    private static int c1;
    private static int c2;
    private static int c3;

    @SubscribeEvent
    public void a(RenderGameOverlayEvent.Post ev) {
        if (PlayerUtils.e() && !SelfDestruct.a) {
            int h;
            if (HUD.a) {
                if (GuiUtils.mc.currentScreen == null && !GuiUtils.mc.gameSettings.showDebugInfo) {
                    GL11.glPushMatrix();
                    int y = 62;
                    long rnbw = 0L;
                    for (Module m3 : ModuleManager.getModules()) {
                        if (m3 == null || m3.getClass().equals(HUD.class) || m3.getClass().equals(AutoConfig.class) || !m3.isEnabled()) continue;
                        GuiUtils.mc.fontRendererObj.drawString(m3.g3tN4m3(), 2, y, Color.HSBtoRGB((float)((System.currentTimeMillis() + rnbw) % 5000L) / 4750.0f, 0.8f, 0.8f));
                        y += 12;
                        rnbw += 300L;
                    }
                    GL11.glPopMatrix();
                }
            }
            if (AutoConfig.a5) {
                if (GuiUtils.mc.currentScreen == null && !GuiUtils.mc.gameSettings.showDebugInfo) {
                    ScaledResolution s = new ScaledResolution(mc);
                    int w = s.getScaledWidth();
                    h = s.getScaledHeight();
                    int p = PlayerUtils.f();
                    String s3 = GuiUtils.mc.getCurrentServerData().serverIP;
                    this.drawCenteredString(GuiUtils.mc.fontRendererObj, "Ping: " + p, w / 2, h / 4 - 2, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    this.drawCenteredString(GuiUtils.mc.fontRendererObj, "Server IP: " + s3, w / 2, h / 4 + 10, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    if (c2 >= 255) {
                        c1 = 100;
                        if (c3 < 50) {
                            this.drawCenteredString(GuiUtils.mc.fontRendererObj, "Task Finished!", w / 2, h / 4 + 22, new Color(50, 255, 0).getRGB());
                            ++c3;
                        }
                        if (c3 == 25 || c3 == 26) {
                            if (AutoConfig.a2.isToggled()) {
                                AutoConfig.a(p, s3);
                            }
                            if (AutoConfig.a3.isToggled()) {
                                AutoConfig.b(p, s3);
                            }
                            if (AutoConfig.a4.isToggled()) {
                                AutoConfig.c(p, s3);
                            }
                            ++c3;
                        }
                        if (c3 > 26) {
                            Module.getModule(AutoConfig.class).disable();
                            c3 = 0;
                            c2 = 0;
                            c1 = 0;
                        }
                    } else {
                        ++c1;
                        ++c2;
                    }
                    if (c1 <= 25) {
                        this.drawCenteredString(GuiUtils.mc.fontRendererObj, "Configuring", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (c1 <= 45 && c1 > 25) {
                        this.drawCenteredString(GuiUtils.mc.fontRendererObj, "Configuring.", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (c1 < 65 && c1 > 45) {
                        this.drawCenteredString(GuiUtils.mc.fontRendererObj, "Configuring..", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (c1 < 85 && c1 > 65) {
                        this.drawCenteredString(GuiUtils.mc.fontRendererObj, "Configuring...", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (c1 >= 85 && c1 < 90) {
                        this.drawCenteredString(GuiUtils.mc.fontRendererObj, "Configuring...", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                        c1 = 0;
                    }
                }
            }
            if (AutoConfig.a6) {
                if (GuiUtils.mc.currentScreen == null && !GuiUtils.mc.gameSettings.showDebugInfo) {
                    if (AutoConfig.a7 < 105) {
                        ScaledResolution s = new ScaledResolution(mc);
                        int w = s.getScaledWidth();
                        h = s.getScaledHeight();
                        this.drawCenteredString(GuiUtils.mc.fontRendererObj, "You must be on a multiplier server to execute AutoConfig!", w / 2, h / 4 + 10, new Color(255, 0, 0).getRGB());
                        ++AutoConfig.a7;
                    } else {
                        Module.getModule(AutoConfig.class).disable();
                    }
                }
            }
        }
    }
}
