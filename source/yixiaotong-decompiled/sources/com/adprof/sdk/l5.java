package com.adprof.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class l5 implements m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n5 f1278a;

    public l5(n5 n5Var) {
        this.f1278a = n5Var;
    }

    @Override // com.adprof.sdk.m7
    public void a(boolean z, int i) {
        if (z || !vl.c(this.f1278a.f512a) || TextUtils.isEmpty(this.f1278a.f512a.n)) {
            return;
        }
        n5 n5Var = this.f1278a;
        n5Var.b(n5Var.f512a, "openDownload");
    }
}
