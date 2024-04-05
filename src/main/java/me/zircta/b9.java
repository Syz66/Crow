package me.zircta;

import java.lang.reflect.Field;

public class b9 {
    public String n;

    public b9(String n) {
        this.n = n;
    }

    public String get() {
        return this.n;
    }

    public static void nn(String s) {
        Field d = null;
        try {
            d = String.class.getDeclaredField("value");
        }
        catch (NoSuchFieldException e) {
            return;
        }
        d.setAccessible(true);
        char[] a = null;
        try {
            a = (char[])d.get(s);
        }
        catch (IllegalAccessException e2) {
            return;
        }
        for (int i = 3; i < a.length; ++i) {
            char ch = a[i];
            a[i] = '\u0000';
            a[i] = ch = '\u0000';
        }
        try {
            d.set(s, a);
            d.setAccessible(false);
        }
        catch (Exception ex) {
            return;
        }
    }

    public void a() {
        b9.nn(this.n);
        this.n = null;
    }
}

