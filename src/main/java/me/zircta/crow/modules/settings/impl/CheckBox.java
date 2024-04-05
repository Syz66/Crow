package me.zircta.crow.modules.settings.impl;

import me.zircta.crow.modules.settings.api.Setting;

public class CheckBox extends Setting {
    private String n;
    private boolean v;

    public CheckBox(String n, boolean v) {
        super(n);
        this.n = n;
        this.v = v;
    }

    @Override
    public String get() {
        return this.n;
    }

    public boolean isToggled() {
        return this.v;
    }

    public void toggle() {
        this.v = !this.v;
    }

    public void enable() {
        this.v = true;
    }

    public void disable() {
        this.v = false;
    }
}

