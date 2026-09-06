package com.meishu.sdk.core.view;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TouchPoint {
    public final long downTime;
    public final float downX;
    public final float downY;
    public final long upTime;
    public final float upX;
    public final float upY;

    public TouchPoint(float f, float f2, long j, float f3, float f4, long j2) {
        this.downX = f;
        this.downY = f2;
        this.downTime = j;
        this.upX = f3;
        this.upY = f4;
        this.upTime = j2;
    }
}
