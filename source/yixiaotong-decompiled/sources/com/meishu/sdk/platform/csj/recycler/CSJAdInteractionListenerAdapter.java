package com.meishu.sdk.platform.csj.recycler;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJAdInteractionListenerAdapter implements TTNativeAd.AdInteractionListener {
    private final String TAG = "CSJAdInteractionListenerAdapter";
    private CSJRecyclerAdDataAdapter adData;
    private CSJTTAdNativeWrapper adWrapper;
    private RecylcerAdInteractionListener meishuInteractionListener;

    public CSJAdInteractionListenerAdapter(CSJRecyclerAdDataAdapter cSJRecyclerAdDataAdapter, RecylcerAdInteractionListener recylcerAdInteractionListener, CSJTTAdNativeWrapper cSJTTAdNativeWrapper) {
        this.adData = cSJRecyclerAdDataAdapter;
        this.meishuInteractionListener = recylcerAdInteractionListener;
        this.adWrapper = cSJTTAdNativeWrapper;
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdClicked(View view, TTNativeAd tTNativeAd) {
        try {
            if (this.adData.getAdWrapper() != null && !TextUtils.isEmpty(this.adData.getAdWrapper().getSdkAdInfo().getClk())) {
                LogUtil.d("CSJAdInteractionListenerAdapter", "send onAdClicked");
                z.a(StubApp.getOrigApplicationContext(this.adData.getAdWrapper().getContext().getApplicationContext()), f.a(this.adData.getAdWrapper().getSdkAdInfo().getClk(), this.adData), new i());
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.meishuInteractionListener;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdClicked();
            }
            CSJTTAdNativeWrapper cSJTTAdNativeWrapper = this.adWrapper;
            if (cSJTTAdNativeWrapper != null) {
                cSJTTAdNativeWrapper.getSdkAdInfo().getMsLoadedTime();
                this.adWrapper.getAdLoader().getPosId();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdCreativeClick(View view, TTNativeAd tTNativeAd) {
        onAdClicked(view, tTNativeAd);
    }

    @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
    public void onAdShow(TTNativeAd tTNativeAd) {
        MediationAdEcpmInfo showEcpm;
        try {
            MediationNativeManager mediationManager = tTNativeAd.getMediationManager();
            if (mediationManager != null && (showEcpm = mediationManager.getShowEcpm()) != null) {
                this.adWrapper.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
            }
            h0.a(this.adWrapper.getSdkAdInfo(), tTNativeAd.getAdView());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            if (this.adData.getAdListener() == null || this.adData.isHasExposed()) {
                return;
            }
            this.adData.setHasExposed(true);
            this.adData.getAdListener().onAdExposure();
            RecylcerAdInteractionListener recylcerAdInteractionListener = this.meishuInteractionListener;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdExposure();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
