package com.kwad.sdk.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class q {
    public static long boL;
    public static long sLaunchTime;

    public static long UD() {
        return boL - sLaunchTime;
    }

    public static void setInitStartTime(long j) {
        boL = j;
    }

    public static void setLaunchTime(long j) {
        sLaunchTime = j;
    }

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName());
        return sb.toString();
    }
}
