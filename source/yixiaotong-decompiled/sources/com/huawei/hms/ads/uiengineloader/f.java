package com.huawei.hms.ads.uiengineloader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3903a = "StringUtils";

    public static int a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            af.c(f3903a, "parseIntOrDefault exception: " + e.getClass().getSimpleName());
            return 0;
        }
    }

    private static boolean b(String str) {
        return str == null || str.trim().length() == 0;
    }
}
