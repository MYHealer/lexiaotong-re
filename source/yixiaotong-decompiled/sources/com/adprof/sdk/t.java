package com.adprof.sdk;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class t implements ke {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1430a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ f0 f727a;

    public t(f0 f0Var, View view) {
        this.f727a = f0Var;
        this.f1430a = view;
    }

    @Override // com.adprof.sdk.ke
    public void a() {
        f0 f0Var;
        int i;
        if (this.f1430a.getId() == 102060003) {
            f0Var = this.f727a;
            i = 1;
        } else {
            f0Var = this.f727a;
            i = 3;
        }
        f0Var.b(i);
    }
}
