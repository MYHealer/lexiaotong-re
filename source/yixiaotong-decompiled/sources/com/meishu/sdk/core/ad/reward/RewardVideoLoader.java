package com.meishu.sdk.core.ad.reward;

import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.nativ.f;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardVideoLoader extends com.meishu.sdk.core.ad.b<a> {
    private static final String TAG = "RewardVideoLoader";
    private b rewardVideoAdListenerAdapter;

    public RewardVideoLoader(Context context, MsAdSlot msAdSlot, RewardAdEventListener rewardAdEventListener) {
        if (msAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.accept_ad_width = Integer.valueOf(msAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(msAdSlot.getHeight());
        setVideoIsMute(msAdSlot.getIsMute());
        this.channel = msAdSlot.getChannel();
        this.rewardVideoAdListenerAdapter = new b(this, rewardAdEventListener);
        init(context, msAdSlot.getPid(), this.rewardVideoAdListenerAdapter);
    }

    @Override // com.meishu.sdk.core.loader.c
    public d createDelegate(SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (AdSdk.isTestMode) {
            setVideoIsMute(meishuAdInfo.isVideoMute());
        }
        if (sdkAdInfo != null) {
            return !TextUtils.isEmpty(sdkAdInfo.getCls()) ? com.meishu.sdk.core.a.a("CUSTOM").rewardLoader(this, sdkAdInfo, meishuAdInfo) : com.meishu.sdk.core.a.a(sdkAdInfo.getSdk()).rewardLoader(this, sdkAdInfo, meishuAdInfo);
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.b
    public d createMeishuAdDelegateInternal(f fVar) {
        if (AdSdk.isTestMode) {
            setVideoIsMute(fVar.A);
        }
        return new com.meishu.sdk.platform.ms.reward.b(this, fVar);
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(com.meishu.sdk.core.loader.c.KEY_TOKEN, str);
        super.loadAd(map);
    }

    @Override // com.meishu.sdk.core.loader.c
    public void clearErrorState() {
        b bVar = this.rewardVideoAdListenerAdapter;
        if (bVar != null) {
            bVar.b = false;
            bVar.d = false;
        }
    }
}
