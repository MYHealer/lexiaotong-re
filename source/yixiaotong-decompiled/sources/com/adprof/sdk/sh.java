package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class sh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile sh f1422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f722a;

    public static sh a() {
        if (f1422a == null) {
            synchronized (sh.class) {
                if (f1422a == null) {
                    f1422a = new sh();
                }
            }
        }
        return f1422a;
    }
}
