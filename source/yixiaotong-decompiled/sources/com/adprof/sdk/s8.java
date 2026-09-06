package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class s8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static h9 f1415a;

    public static h9 a() {
        if (f1415a == null) {
            synchronized (s8.class) {
                if (f1415a == null && ig.b != null) {
                    f1415a = new h9(ig.b, 3);
                }
            }
        }
        return f1415a;
    }
}
