package com.opos.exoplayer.core;

import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashSet<String> f6519a = new HashSet<>();
    private static String b = "goog.exo.core";

    public static synchronized String a() {
        return b;
    }

    public static synchronized void a(String str) {
        if (f6519a.add(str)) {
            b += ", " + str;
        }
    }
}
