package com.yhao.floatwindow;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
abstract class FloatView {
    abstract void dismiss();

    int getX() {
        return 0;
    }

    int getY() {
        return 0;
    }

    abstract void init();

    abstract void setGravity(int i, int i2, int i3);

    abstract void setSize(int i, int i2);

    abstract void setView(View view);

    void updateX(int i) {
    }

    void updateXY(int i, int i2) {
    }

    void updateY(int i) {
    }

    FloatView() {
    }
}
