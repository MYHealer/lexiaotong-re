package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k0 implements i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f5504a;

    public k0(j0 j0Var) {
        this.f5504a = j0Var;
    }

    @Override // com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        j0 j0Var = this.f5504a;
        k8 k8Var = j0Var.l;
        if (k8Var != null) {
            j0Var.m = k8Var.getExtShakeInfo();
            this.f5504a.removeShakeView();
        }
        i8 i8Var = this.f5504a.j;
        if (i8Var != null) {
            i8Var.onClick(view, clickAreaType);
        }
    }
}
