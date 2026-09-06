package com.yfanads.android.adx.core.impl;

import com.yfanads.android.adx.core.model.AdxNativeAd;

/* JADX INFO: compiled from: NativeAdImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class f implements com.yfanads.android.adx.download.dialog.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9593a;
    public final /* synthetic */ NativeAdImpl b;

    public f(NativeAdImpl nativeAdImpl, String str) {
        this.b = nativeAdImpl;
        this.f9593a = str;
    }

    @Override // com.yfanads.android.adx.download.dialog.a
    public final void a() {
        this.b.reportAdInfo(4, null);
        this.b.reportAdInfo(5, null);
        com.yfanads.android.adx.utils.b.c(this.f9593a);
        AdxNativeAd.AdInteractionListener adInteractionListener = this.b.f9586a;
        if (adInteractionListener != null) {
            adInteractionListener.onDownloadTipsDismiss();
        }
    }

    @Override // com.yfanads.android.adx.download.dialog.a
    public final void a(int i, int i2) {
    }

    @Override // com.yfanads.android.adx.download.dialog.a
    public final void a(boolean z) {
    }
}
