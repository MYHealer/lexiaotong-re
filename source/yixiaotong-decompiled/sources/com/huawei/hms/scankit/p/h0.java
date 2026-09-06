package com.huawei.hms.scankit.p;

import android.graphics.Rect;

/* JADX INFO: compiled from: CameraMeteringData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f4265a;
    private Rect b;

    /* JADX INFO: compiled from: CameraMeteringData.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Rect f4266a;
        public int b;

        public a(Rect rect, int i) {
            this.f4266a = rect;
            this.b = i;
        }
    }

    public h0(int i, Rect rect) {
        this.f4265a = i;
        this.b = new Rect(rect);
    }

    public int a() {
        return this.f4265a;
    }

    public Rect b() {
        return this.b;
    }
}
