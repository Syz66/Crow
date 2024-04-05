package me.zircta;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.weavemc.loader.api.event.RenderGameOverlayEvent;
import net.weavemc.loader.api.event.SubscribeEvent;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class r extends Gui {
    private static Minecraft mc = Minecraft.getMinecraft();
    private static int c1;
    private static int c2;
    private static int c3;

    @SubscribeEvent
    public void a(RenderGameOverlayEvent.Post ev) {
        if (ay.e() && !ax.a) {
            int h;
            if (aq.a) {
                if (r.mc.currentScreen == null && !r.mc.gameSettings.showDebugInfo) {
                    GL11.glPushMatrix();
                    int y = 62;
                    long rnbw = 0L;
                    for (bb m3 : m2.modsList) {
                        if (m3 == null || m3.getClass().equals(aq.class) || m3.getClass().equals(aj.class) || !m3.isEnabled()) continue;
                        r.mc.fontRendererObj.drawString(m3.g3tN4m3(), 2, y, Color.HSBtoRGB((float)((System.currentTimeMillis() + rnbw) % 5000L) / 4750.0f, 0.8f, 0.8f));
                        y += 12;
                        rnbw += 300L;
                    }
                    GL11.glPopMatrix();
                }
            }
            if (aj.a5) {
                if (r.mc.currentScreen == null && !r.mc.gameSettings.showDebugInfo) {
                    ScaledResolution s = new ScaledResolution(mc);
                    int w = s.getScaledWidth();
                    h = s.getScaledHeight();
                    int p = ay.f();
                    String s3 = r.mc.getCurrentServerData().serverIP;
                    this.drawCenteredString(r.mc.fontRendererObj, "Ping: " + p, w / 2, h / 4 - 2, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    this.drawCenteredString(r.mc.fontRendererObj, "Server IP: " + s3, w / 2, h / 4 + 10, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    if (c2 >= 255) {
                        c1 = 100;
                        if (c3 < 50) {
                            this.drawCenteredString(r.mc.fontRendererObj, "Task Finished!", w / 2, h / 4 + 22, new Color(50, 255, 0).getRGB());
                            ++c3;
                        }
                        if (c3 == 25 || c3 == 26) {
                            if (aj.a2.isToggled()) {
                                aj.a(p, s3);
                            }
                            if (aj.a3.isToggled()) {
                                aj.b(p, s3);
                            }
                            if (aj.a4.isToggled()) {
                                aj.c(p, s3);
                            }
                            ++c3;
                        }
                        if (c3 > 26) {
                            bb.getModule(aj.class).disable();
                            c3 = 0;
                            c2 = 0;
                            c1 = 0;
                        }
                    } else {
                        ++c1;
                        ++c2;
                    }
                    if (c1 <= 25) {
                        this.drawCenteredString(r.mc.fontRendererObj, "Configuring", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (c1 <= 45 && c1 > 25) {
                        this.drawCenteredString(r.mc.fontRendererObj, "Configuring.", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (c1 < 65 && c1 > 45) {
                        this.drawCenteredString(r.mc.fontRendererObj, "Configuring..", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (c1 < 85 && c1 > 65) {
                        this.drawCenteredString(r.mc.fontRendererObj, "Configuring...", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                    }
                    if (c1 >= 85 && c1 < 90) {
                        this.drawCenteredString(r.mc.fontRendererObj, "Configuring...", w / 2, h / 4 + 22, Color.getHSBColor((float)(System.currentTimeMillis() % 1500L) / 1500.0f, 1.0f, 1.0f).getRGB());
                        c1 = 0;
                    }
                }
            }
            if (aj.a6) {
                if (r.mc.currentScreen == null && !r.mc.gameSettings.showDebugInfo) {
                    if (aj.a7 < 105) {
                        ScaledResolution s = new ScaledResolution(mc);
                        int w = s.getScaledWidth();
                        h = s.getScaledHeight();
                        this.drawCenteredString(r.mc.fontRendererObj, "You must be on a multiplier server to execute AutoConfig!", w / 2, h / 4 + 10, new Color(255, 0, 0).getRGB());
                        ++aj.a7;
                    } else {
                        bb.getModule(aj.class).disable();
                    }
                }
            }
        }
    }
}
