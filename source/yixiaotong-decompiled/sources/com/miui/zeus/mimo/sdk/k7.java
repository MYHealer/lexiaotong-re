package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.view.MimoGiftBoxView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k7 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i8 f5510a;
    public final /* synthetic */ MimoGiftBoxView b;

    public k7(MimoGiftBoxView mimoGiftBoxView, i8 i8Var) {
        this.b = mimoGiftBoxView;
        this.f5510a = i8Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i8 i8Var = this.f5510a;
        MimoGiftBoxView mimoGiftBoxView = this.b;
        i8Var.onClick(mimoGiftBoxView.b, mimoGiftBoxView.getClickAreaType());
    }
}
