package com.alipay.sdk.app;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1625a;
    private static String b;

    public static String a() {
        return b;
    }

    public static void a(String str) {
        b = str;
    }

    public static void a(boolean z) {
        f1625a = z;
    }

    public static boolean b() {
        return f1625a;
    }

    public static String c() {
        k kVarB = k.b(k.CANCELED.a());
        return a(kVarB.a(), kVarB.b(), "");
    }

    public static String d() {
        k kVarB = k.b(k.DOUBLE_REQUEST.a());
        return a(kVarB.a(), kVarB.b(), "");
    }

    public static String e() {
        k kVarB = k.b(k.PARAMS_ERROR.a());
        return a(kVarB.a(), kVarB.b(), "");
    }

    public static String a(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder("resultStatus={");
        sb.append(i).append("};memo={").append(str).append("};result={").append(str2).append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }
}
