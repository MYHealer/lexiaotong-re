package com.miui.zeus.mimo.sdk;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i2 extends CustomTarget<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h2 f5458a;

    public i2(h2 h2Var) {
        this.f5458a = h2Var;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        h2 h2Var = this.f5458a;
        h2Var.f5445a.a((Bitmap) null, h2Var.o, h2Var);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object obj, Transition transition) {
        h2 h2Var = this.f5458a;
        h2Var.f5445a.a((Bitmap) obj, h2Var.o, h2Var);
    }
}
