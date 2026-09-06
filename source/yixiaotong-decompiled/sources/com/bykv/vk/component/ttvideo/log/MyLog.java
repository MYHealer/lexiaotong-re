package com.bykv.vk.component.ttvideo.log;

import com.byazt.nr.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class MyLog {
    private static final boolean DEBUG = false;
    private static final boolean INFO = true;

    public static void d(String str, String str2) {
    }

    private MyLog() {
    }

    public static void i(String str, String str2) {
        m.tt(str, str2);
    }

    public static void w(String str, String str2) {
        m.tt(str, str2);
    }

    public static void e(String str, String str2) {
        m.uj(str, str2);
    }

    public static void t(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return;
        }
        if (str2.length() > 3072) {
            while (str2.length() > 3072) {
                String strSubstring = str2.substring(0, 3072);
                str2 = str2.replace(strSubstring, "");
                m.uj(str, strSubstring);
            }
        }
        m.uj(str, str2);
    }
}
