package com.yhao.floatwindow;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class IFloatWindow {
    abstract void dismiss();

    public abstract View getView();

    public abstract int getX();

    public abstract int getY();

    public abstract void hide();

    public abstract boolean isShowing();

    public abstract void show();

    public abstract void updateX(int i);

    public abstract void updateX(int i, float f);

    public abstract void updateY(int i);

    public abstract void updateY(int i, float f);
}
