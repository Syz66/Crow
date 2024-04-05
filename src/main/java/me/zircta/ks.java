package me.zircta;

public class ks {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private boolean d = false;
    private boolean e = true;

    public int getX() {
        return this.a;
    }

    public void setX(int x) {
        this.a = x;
    }

    public int getY() {
        return this.b;
    }

    public void setY(int y) {
        this.b = y;
    }

    public int getTextColor() {
        return this.c;
    }

    public void setTextColor(int textColor) {
        this.c = textColor;
    }

    public boolean isEnabled() {
        return this.e;
    }

    public void setEnabled(boolean enabled) {
        this.e = enabled;
    }

    public boolean isShowingMouseButtons() {
        return this.d;
    }

    public void setShowingMouseButtons(boolean showingMouseButtons) {
        this.d = showingMouseButtons;
    }
}
