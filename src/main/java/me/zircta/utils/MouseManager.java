package me.zircta.utils;

import net.weavemc.loader.api.event.MouseEvent;
import net.weavemc.loader.api.event.SubscribeEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MouseManager {
    private static List<Long> a;
    private static List<Long> b;

    public MouseManager() {
        a = new ArrayList<Long>();
        b = new ArrayList<Long>();
    }

    @SubscribeEvent
    public void c(MouseEvent d) {
        if (d.getButton() == 0 && d.getButtonState()) {
            MouseManager.e();
        }
        if (d.getButton() == 1 && d.getButtonState()) {
            MouseManager.h();
        }
    }

    public static void e() {
        a.add(System.currentTimeMillis());
    }

    public static int f() {
        Iterator<Long> g = a.iterator();
        while (g.hasNext()) {
            if (g.next() >= System.currentTimeMillis() - 1000L) continue;
            g.remove();
        }
        return a.size();
    }

    public static void h() {
        b.add(System.currentTimeMillis());
    }

    public static int i() {
        Iterator<Long> j = b.iterator();
        while (j.hasNext()) {
            if (j.next() >= System.currentTimeMillis() - 1000L) continue;
            j.remove();
        }
        return b.size();
    }
}
