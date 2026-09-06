package com.yfanads.android.adx.components.fullscreen;

import android.view.View;
import com.yfanads.android.adx.components.base.i;
import com.yfanads.android.adx.core.impl.AbstractNativeAd;
import com.yfanads.android.adx.core.model.AdxNativeAd;

/* JADX INFO: compiled from: AdxFullScreenVideoActivity.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements AdxNativeAd.VideoPlayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f9575a;
    public final /* synthetic */ AbstractNativeAd b;
    public final /* synthetic */ View c;
    public final /* synthetic */ AdxFullScreenVideoActivity d;

    public a(AdxFullScreenVideoActivity adxFullScreenVideoActivity, i iVar, AbstractNativeAd abstractNativeAd, View view) {
        this.d = adxFullScreenVideoActivity;
        this.f9575a = iVar;
        this.b = abstractNativeAd;
        this.c = view;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayComplete() {
        AdxFullScreenVideoActivity adxFullScreenVideoActivity = this.d;
        AbstractNativeAd abstractNativeAd = this.b;
        int i = AdxFullScreenVideoActivity.q;
        adxFullScreenVideoActivity.a(abstractNativeAd);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayError(int i, int i2) {
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayStart() {
        com.yfanads.android.adx.utils.a.a("AdxFullScreenVideoActivity onVideoPlayStart ");
        AdxFullScreenVideoActivity adxFullScreenVideoActivity = this.d;
        i iVar = this.f9575a;
        AbstractNativeAd abstractNativeAd = this.b;
        View view = this.c;
        int i = AdxFullScreenVideoActivity.q;
        adxFullScreenVideoActivity.a(abstractNativeAd, iVar, view);
    }
}
