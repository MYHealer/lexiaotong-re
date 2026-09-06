package com.kwad.sdk.utils;

import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ca {
    private View brz;
    public Point bry = new Point();
    public Rect brw = new Rect();
    public Rect brx = new Rect();

    public ca(View view) {
        this.brz = view;
    }

    public final boolean Xh() {
        boolean globalVisibleRect = this.brz.getGlobalVisibleRect(this.brw, this.bry);
        if (this.bry.x == 0 && this.bry.y == 0 && this.brw.height() == this.brz.getHeight() && this.brx.height() != 0 && Math.abs(this.brw.top - this.brx.top) > this.brz.getHeight() / 2) {
            this.brw.set(this.brx);
        }
        this.brx.set(this.brw);
        return globalVisibleRect;
    }
}
