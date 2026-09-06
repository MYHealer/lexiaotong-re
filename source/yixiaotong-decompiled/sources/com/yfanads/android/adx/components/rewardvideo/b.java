package com.yfanads.android.adx.components.rewardvideo;

import android.text.TextUtils;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.libs.net.NetCallBack;

/* JADX INFO: compiled from: AdxRewardVideoActivity.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b extends NetCallBack.NetCallBackString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AdxNativeAd.AdInteractionListener2 f9582a;
    public final /* synthetic */ AdxRewardVideoActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(AdxRewardVideoActivity adxRewardVideoActivity, AdxNativeAd.AdInteractionListener2 adInteractionListener2) {
        super(true, false);
        this.b = adxRewardVideoActivity;
        this.f9582a = adInteractionListener2;
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onFailure */
    public final void m1259lambda$onError$0$comyfanadsandroidlibsnetNetCallBack(int i, String str) {
        ((AdxNativeAd.RewardAdInteractionListener) this.f9582a).onRewardVerify(false, "get reward fail " + i);
    }

    @Override // com.yfanads.android.libs.net.NetCallBack
    /* JADX INFO: renamed from: onResponse */
    public final void m1262lambda$onSuccess$3$comyfanadsandroidlibsnetNetCallBack(String str) {
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((AdxNativeAd.RewardAdInteractionListener) this.f9582a).onRewardVerify(((com.yfanads.android.adx.components.model.c) this.b.v.fromJson(str2, com.yfanads.android.adx.components.model.c.class)) != null, "success");
    }
}
