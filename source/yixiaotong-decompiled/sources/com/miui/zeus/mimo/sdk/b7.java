package com.miui.zeus.mimo.sdk;

import com.bumptech.glide.Glide;
import com.miui.zeus.mimo.sdk.video.BaseVideoAdView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b7 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5375a;
    public final /* synthetic */ BaseVideoAdView b;

    public b7(BaseVideoAdView baseVideoAdView, String str) {
        this.b = baseVideoAdView;
        this.f5375a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        Glide.with(y8.f5752a).load(this.f5375a).into(this.b.c);
    }
}
