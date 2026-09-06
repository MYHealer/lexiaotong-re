package com.baidu.mobads.sdk.internal;

import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class aw extends az.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1733a = "debug";

    @Override // com.baidu.mobads.sdk.internal.az.a
    String a() {
        return "debug";
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected boolean a(String str, int i) {
        return az.f1735a.equals(str);
    }

    @Override // com.baidu.mobads.sdk.internal.az.a
    protected void a(int i, String str, String str2, Throwable th) {
        a(i, str, str2);
    }

    private static void a(int i, String str, String str2) {
        try {
            if (i == 7) {
                Log.wtf(str, str2);
            } else {
                Log.println(i, str, str2);
            }
        } catch (Throwable unused) {
        }
    }
}
