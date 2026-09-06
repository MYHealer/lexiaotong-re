package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class Rect {
    public int bottom;
    public int left;
    public int right;
    public int top;

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}
