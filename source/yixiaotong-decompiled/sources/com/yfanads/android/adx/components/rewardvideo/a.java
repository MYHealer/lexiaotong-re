package com.yfanads.android.adx.components.rewardvideo;

import android.view.View;
import com.yfanads.android.adx.components.base.i;
import com.yfanads.android.adx.core.impl.AbstractNativeAd;
import com.yfanads.android.adx.core.model.AdxNativeAd;

/* JADX INFO: compiled from: AdxRewardVideoActivity.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements AdxNativeAd.VideoPlayListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f9581a;
    public final /* synthetic */ AbstractNativeAd b;
    public final /* synthetic */ View c;
    public final /* synthetic */ AdxRewardVideoActivity d;

    public a(AdxRewardVideoActivity adxRewardVideoActivity, i iVar, AbstractNativeAd abstractNativeAd, View view) {
        this.d = adxRewardVideoActivity;
        this.f9581a = iVar;
        this.b = abstractNativeAd;
        this.c = view;
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayComplete() {
        AdxRewardVideoActivity adxRewardVideoActivity = this.d;
        AbstractNativeAd abstractNativeAd = this.b;
        int i = AdxRewardVideoActivity.w;
        adxRewardVideoActivity.a(abstractNativeAd);
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayError(int i, int i2) {
    }

    @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
    public final void onVideoPlayStart() {
        com.yfanads.android.adx.utils.a.a("AdxRewardVideoActivity onVideoPlayStart ");
        AdxRewardVideoActivity adxRewardVideoActivity = this.d;
        i iVar = this.f9581a;
        AbstractNativeAd abstractNativeAd = this.b;
        View view = this.c;
        int i = AdxRewardVideoActivity.w;
        adxRewardVideoActivity.b(abstractNativeAd, iVar, view);
    }
}
