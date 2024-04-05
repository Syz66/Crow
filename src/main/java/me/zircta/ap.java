package me.zircta;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ap extends b9 {
    private String n;
    private double v;
    private double a;
    private double m;
    private double i;

    public ap(String settingName, double defaultValue, double min, double max, double intervals) {
        super(settingName);
        this.n = settingName;
        this.v = defaultValue;
        this.m = min;
        this.a = max;
        this.i = intervals;
    }

    @Override
    public String get() {
        return this.n;
    }

    public double getInput() {
        return ap.r(this.v, 2);
    }

    public double g3ti() {
        return this.m;
    }

    public double g3ta() {
        return this.a;
    }

    public void setValue(double n) {
        n = ap.c(n, this.m, this.a);
        this.v = n = (double)Math.round(n * (1.0 / this.i)) / (1.0 / this.i);
    }

    public static double c(double v, double i, double a) {
        v = Math.max(i, v);
        v = Math.min(a, v);
        return v;
    }

    public static double r(double v, int p) {
        if (p < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(v);
        bd = bd.setScale(p, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

