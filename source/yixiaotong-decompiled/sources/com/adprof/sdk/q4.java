package com.adprof.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class q4 implements m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a2 f1377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d f659a;

    public q4(a2 a2Var, d dVar) {
        this.f1377a = a2Var;
        this.f659a = dVar;
    }

    @Override // com.adprof.sdk.m7
    public void a(boolean z, int i) {
        if (z) {
            a2 a2Var = this.f1377a;
            if (a2Var != null) {
                a2Var.a(this.f659a, "open_deeplink_success");
                return;
            }
            return;
        }
        a2 a2Var2 = this.f1377a;
        if (a2Var2 != null) {
            a2Var2.a(this.f659a, "open_deeplink_fail");
        }
        try {
            if (!vl.c(this.f659a) || TextUtils.isEmpty(this.f659a.n)) {
                return;
            }
            r4.a(this.f659a, "openDeeplink");
        } catch (Throwable unused) {
        }
    }
}
