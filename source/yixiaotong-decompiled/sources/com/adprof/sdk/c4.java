package com.adprof.sdk;

import android.os.Handler;
import android.view.View;
import com.adprof.sdk.api.BannerSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c4 implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BannerSize f1100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n4 f169a;

    public c4(n4 n4Var, BannerSize bannerSize) {
        this.f169a = n4Var;
        this.f1100a = bannerSize;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Handler handler = this.f169a.f497a;
        if (handler == null) {
            return;
        }
        handler.post(new b4(this));
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f169a.h();
    }
}
