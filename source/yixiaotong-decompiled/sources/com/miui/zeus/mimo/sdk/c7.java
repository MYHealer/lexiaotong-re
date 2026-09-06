package com.miui.zeus.mimo.sdk;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c7 extends CustomTarget<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i8 f5388a;
    public final /* synthetic */ MimoMediaView b;

    public c7(MimoMediaView mimoMediaView, i8 i8Var) {
        this.b = mimoMediaView;
        this.f5388a = i8Var;
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(Drawable drawable) {
        this.b.A.a((Bitmap) null, true, this.f5388a);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Object obj, Transition transition) {
        this.b.A.a((Bitmap) obj, true, this.f5388a);
    }
}
