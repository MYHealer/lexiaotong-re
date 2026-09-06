package com.miui.zeus.mimo.sdk.utils;

import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.b;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ApkTools {
    private ApkTools() {
    }

    public static boolean a() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (b.a(s.d(new byte[]{5, 94, 7, 67, 14, 95, 5, 74, 16, 11, 84, Ascii.DC2, 74, 102, 10, 84, Ascii.SYN, Ascii.DC2, 49, 1, Ascii.DC4, 4, 94, Ascii.ETB, 9, 115, 15, 88, 2, 93}, "d0c1a6"), stackTraceElement.getClassName()) && b.a(stackTraceElement.getFileName(), s.d(new byte[]{97, 10, 6, 66, Ascii.GS, 11, 0, Ascii.DC2, 7}, "7cc53a")) && b.a(stackTraceElement.getMethodName(), s.d(new byte[]{Ascii.DC4, Ascii.SYN, 88}, "fc610a"))) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i = 0;
            while (true) {
                if (i >= stackTrace.length) {
                    i = 0;
                    break;
                }
                if (b.a(stackTrace[i].getMethodName(), s.d(new byte[]{2, 8, Ascii.ETB, 65, 2, 77, 2, 12, 50, 13, 68, 6, 14, 36, Ascii.DC2, 84, 13, 77}, "fad1c9"))) {
                    break;
                }
                i++;
            }
            int i2 = i + 1;
            if (i2 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                if (b.a(s.d(new byte[]{5, 88, 83, 19, 89, 10, 5, 74, 16, 11, 84, Ascii.DC2, 74, 96, 94, 4, 65, 36, 19, 11, 19, Ascii.DC2}, "d67a6c"), stackTraceElement.getClassName()) && b.a(stackTraceElement.getFileName(), s.d(new byte[]{48, 94, 86, 68, 126, Ascii.SYN, 14, 17, Ascii.SYN, 76, 91, 4, 16, 86}, "f7339d")) && b.a(stackTraceElement.getMethodName(), s.d(new byte[]{84, 8, 75, 19, 5, 68, 2, 12, 50, 16, 80, 11, 67, 7, 87, 17, 9, 85, 5, 48, 9, Ascii.ETB, 82, 13, 117, Ascii.ETB, 93, 13, 16}, "0a8cd0"))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
