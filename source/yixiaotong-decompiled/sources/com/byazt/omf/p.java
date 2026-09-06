package com.byazt.omf;

import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 350})
public final class p {
    public static final int tt = 7611;
    public static final Boolean c = Boolean.TRUE;
    public static boolean ve = false;
    public static int uj = 7611;
    public static String n = "7.6.1.1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2567a = 1000;
    public static boolean sp = true;
    public static String x = "main";
    public static boolean i = false;
    public static String da = "6.6.0.0";

    public static String c(String str, int i2) {
        return "";
    }

    public static boolean c() {
        return true;
    }

    public static boolean tt() {
        return false;
    }

    public static boolean uj() {
        return false;
    }

    public static boolean ve() {
        return com.byazt.bzd.sp.tt();
    }

    public static boolean n() {
        return com.byazt.btt.tt.c().isTTVideoOk();
    }

    public static String a() {
        return x + (c() ? "_plugin" : "") + (i ? "_open" : "_close");
    }

    public static String sp() {
        return c("com.byted.pangle", 7611);
    }

    public static boolean x() {
        return TextUtils.equals(UMModuleRegister.INNER, x);
    }
}
