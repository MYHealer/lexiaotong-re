package com.alipay.sdk.widget;

import android.view.animation.Animation;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class l extends j.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewWindow f1679a;
    final /* synthetic */ j b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    l(j jVar, WebViewWindow webViewWindow) {
        super(jVar, null);
        this.b = jVar;
        this.f1679a = webViewWindow;
    }

    @Override // com.alipay.sdk.widget.j.a, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.f1679a.a();
        this.b.v = false;
    }
}
