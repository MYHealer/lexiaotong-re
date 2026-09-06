package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class u3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u3 f5627a;

    public void a() {
        u3 u3Var = this.f5627a;
        if (u3Var != null) {
            u3Var.a();
        }
    }

    public abstract void a(MimoAdInfo mimoAdInfo, ClickAreaType clickAreaType, v3 v3Var, boolean z);

    public void a(u3 u3Var) {
        this.f5627a = u3Var;
    }
}
