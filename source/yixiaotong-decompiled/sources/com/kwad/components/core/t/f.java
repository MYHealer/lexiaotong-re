package com.kwad.components.core.t;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f {
    public static boolean bl(String str) {
        if (str == null) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder();
        sb.append(stackTraceElement.getClassName()).append(".").append(stackTraceElement.getMethodName());
        return sb.toString();
    }
}
