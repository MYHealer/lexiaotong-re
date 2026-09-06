package com.meishu.sdk.core.ad.banner;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BannerAdLoader extends com.meishu.sdk.core.loader.c<b> {
    private static final String TAG = "BannerAdLoader";
    private Integer acceptHeight;
    private Integer acceptWidth;
    private c bannerAdListenerAdapter;

    public BannerAdLoader(Activity activity, MsAdSlot msAdSlot, BannerAdEventListener bannerAdEventListener) {
        if (msAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.acceptWidth = Integer.valueOf(msAdSlot.getWidth());
        this.acceptHeight = Integer.valueOf(msAdSlot.getHeight());
        this.accept_ad_width = Integer.valueOf(msAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(msAdSlot.getHeight());
        this.channel = msAdSlot.getChannel();
        this.bannerAdListenerAdapter = new c(this, bannerAdEventListener);
        init(activity, msAdSlot.getPid(), this.bannerAdListenerAdapter);
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createDelegate(SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (sdkAdInfo != null) {
            return !TextUtils.isEmpty(sdkAdInfo.getCls()) ? com.meishu.sdk.core.a.a("CUSTOM").bannerLoader(this, sdkAdInfo, meishuAdInfo) : com.meishu.sdk.core.a.a(sdkAdInfo.getSdk()).bannerLoader(this, sdkAdInfo, meishuAdInfo);
        }
        return null;
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createMeishuAdDelegate(Context context, MeishuAdInfo meishuAdInfo) {
        return new com.meishu.sdk.platform.ms.banner.b(this, com.meishu.sdk.meishu_ad.banner.a.this);
    }

    public Integer getAcceptHeight() {
        return this.acceptHeight;
    }

    public Integer getAcceptWidth() {
        return this.acceptWidth;
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(com.meishu.sdk.core.loader.c.KEY_TOKEN, str);
        super.loadAd(map);
    }

    @Override // com.meishu.sdk.core.loader.c
    public void clearErrorState() {
        c cVar = this.bannerAdListenerAdapter;
        if (cVar != null) {
            cVar.b = false;
            cVar.c = false;
        }
    }
}
