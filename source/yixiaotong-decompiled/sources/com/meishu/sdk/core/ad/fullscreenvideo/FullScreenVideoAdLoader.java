package com.meishu.sdk.core.ad.fullscreenvideo;

import android.app.Activity;
import android.text.TextUtils;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.nativ.f;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class FullScreenVideoAdLoader extends com.meishu.sdk.core.ad.b<c> {
    public static final String KEY_HEIGHT = "KEY_HEIGHT";
    public static final String KEY_WIDTH = "KEY_WIDTH";
    private static final String TAG = "FullScreenVideoAdLoader";
    private a fullScreenAdListenerAdapter;

    public FullScreenVideoAdLoader(Activity activity, MsAdSlot msAdSlot, FullScreenAdEventListener fullScreenAdEventListener) {
        if (msAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.accept_ad_width = Integer.valueOf(msAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(msAdSlot.getHeight());
        this.channel = msAdSlot.getChannel();
        this.fullScreenAdListenerAdapter = new a(this, fullScreenAdEventListener);
        init(activity, msAdSlot.getPid(), this.fullScreenAdListenerAdapter);
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createDelegate(SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (sdkAdInfo != null) {
            return !TextUtils.isEmpty(sdkAdInfo.getCls()) ? com.meishu.sdk.core.a.a("CUSTOM").fullScreenVideoLoader(this, sdkAdInfo, meishuAdInfo) : com.meishu.sdk.core.a.a(sdkAdInfo.getSdk()).fullScreenVideoLoader(this, sdkAdInfo, meishuAdInfo);
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.b
    public com.meishu.sdk.core.loader.d createMeishuAdDelegateInternal(f fVar) {
        return new com.meishu.sdk.platform.ms.fullscreenvideo.a(this, fVar);
    }

    public void loadAd(float f, float f2) {
        HashMap map = new HashMap();
        map.put("KEY_WIDTH", Float.valueOf(f));
        map.put("KEY_HEIGHT", Float.valueOf(f2));
        loadAd(map);
    }

    @Override // com.meishu.sdk.core.loader.c
    public void clearErrorState() {
        a aVar = this.fullScreenAdListenerAdapter;
        if (aVar != null) {
            aVar.b = false;
            aVar.c = false;
        }
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(com.meishu.sdk.core.loader.c.KEY_TOKEN, str);
        super.loadAd(map);
    }
}
