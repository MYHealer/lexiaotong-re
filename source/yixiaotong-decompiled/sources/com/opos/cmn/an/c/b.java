package com.opos.cmn.an.c;

import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Locale f5878a;

    public static String a() {
        String language = c().getLanguage();
        return language == null ? "" : language;
    }

    public static String b() {
        String country = c().getCountry();
        return country == null ? "" : country;
    }

    private static Locale c() {
        if (f5878a == null) {
            f5878a = Locale.getDefault();
        }
        return f5878a;
    }
}
