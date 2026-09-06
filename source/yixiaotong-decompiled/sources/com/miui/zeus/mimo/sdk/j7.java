package com.miui.zeus.mimo.sdk;

import android.view.View;
import android.widget.ImageView;
import com.miui.zeus.mimo.sdk.view.MimoGiftBoxView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j7 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i8 f5501a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ MimoGiftBoxView c;

    public j7(MimoGiftBoxView mimoGiftBoxView, i8 i8Var, ImageView imageView) {
        this.c = mimoGiftBoxView;
        this.f5501a = i8Var;
        this.b = imageView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5501a.onClick(this.b, this.c.getClickAreaType());
    }
}
