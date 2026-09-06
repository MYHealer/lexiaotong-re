package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5415a;
    public boolean b = true;
    public s3 c;

    public static e5 a(MimoAdInfo mimoAdInfo) {
        e5 e5Var = new e5();
        if (mimoAdInfo != null) {
            e5Var.f5415a = mimoAdInfo.u;
            e5Var.b = mimoAdInfo.F0;
            e5Var.c = mimoAdInfo.e0;
        }
        return e5Var;
    }
}
