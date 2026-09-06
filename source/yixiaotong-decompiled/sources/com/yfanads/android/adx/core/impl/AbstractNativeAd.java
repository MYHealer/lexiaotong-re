package com.yfanads.android.adx.core.impl;

import android.content.Context;
import android.view.View;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.core.annotate.AdSdkDynamicApi;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.player.yfplayer.IPlayVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@AdSdkDynamicApi
public abstract class AbstractNativeAd implements AdxNativeAd {
    @Override // com.yfanads.android.adx.core.model.AdxNativeAd
    @AdSdkDynamicApi
    public abstract View getVideoView(Context context, AdVideoPlayConfig adVideoPlayConfig);

    @AdSdkDynamicApi
    public abstract IPlayVideo getVideoView2(Context context, AdVideoPlayConfig adVideoPlayConfig);
}
