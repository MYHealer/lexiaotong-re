package com.miui.zeus.jni;

import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class NativeUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f5268a = null;

    static {
        NCall.IV(new Object[]{0});
    }

    public static String a(String str) {
        return (String) NCall.IL(new Object[]{1, str});
    }

    public static String a(String str, int i) {
        return (String) NCall.IL(new Object[]{2, str, Integer.valueOf(i)});
    }

    public static String a(String str, String str2) {
        return (String) NCall.IL(new Object[]{3, str, str2});
    }

    public static String a(byte[] bArr) {
        return (String) NCall.IL(new Object[]{4, bArr});
    }

    public static String b(String str) {
        return (String) NCall.IL(new Object[]{5, str});
    }

    public static String decrypt(String str, boolean z) {
        return (String) NCall.IL(new Object[]{6, str, Boolean.valueOf(z)});
    }

    public static String encrypt(String str) {
        return (String) NCall.IL(new Object[]{7, str});
    }

    public static String sign(String str, String str2) {
        return (String) NCall.IL(new Object[]{8, str, str2});
    }
}
