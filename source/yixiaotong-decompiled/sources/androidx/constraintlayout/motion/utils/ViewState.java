package androidx.constraintlayout.motion.utils;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }

    public void getState(View view) {
        this.left = view.getLeft();
        this.top = view.getTop();
        this.right = view.getRight();
        this.bottom = view.getBottom();
        this.rotation = view.getRotation();
    }
}
