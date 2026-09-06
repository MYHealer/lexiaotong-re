package com.unionpay.utils;

import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class k {
    private static k f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9365a = "";
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";

    public static k a() {
        if (f == null) {
            f = Locale.getDefault().toString().startsWith("zh") ? new l() : new m();
        }
        return f;
    }
}
