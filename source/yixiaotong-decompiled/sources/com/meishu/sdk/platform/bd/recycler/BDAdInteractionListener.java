package com.meishu.sdk.platform.bd.recycler;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDAdInteractionListener implements NativeResponse.AdInteractionListener {
    private static final String TAG = "BDAdInteractionListener";
    private BDRecyclerAd adData;
    private BDRecyclerLoader bdRecyclerLoader;
    private a recyclerAdListener;

    public BDAdInteractionListener(a aVar, BDRecyclerLoader bDRecyclerLoader, BDRecyclerAd bDRecyclerAd) {
        this.recyclerAdListener = aVar;
        this.bdRecyclerLoader = bDRecyclerLoader;
        this.adData = bDRecyclerAd;
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void adActReward(int i) {
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void adActRewardSuccess() {
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADExposed() {
        try {
            h0.a(this.bdRecyclerLoader.getSdkAdInfo(), this.adData.getAdView());
            if (this.recyclerAdListener == null || this.adData.isHasExposed()) {
                return;
            }
            this.adData.setHasExposed(true);
            this.recyclerAdListener.onAdExposure();
            BDRecyclerAd bDRecyclerAd = this.adData;
            if (bDRecyclerAd == null || bDRecyclerAd.getRecylcerAdInteractionListener() == null) {
                return;
            }
            this.adData.getRecylcerAdInteractionListener().onAdExposure();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADExposureFailed(int i) {
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onADStatusChanged() {
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onAdClick() {
        try {
            if (this.bdRecyclerLoader.getSdkAdInfo() != null && !TextUtils.isEmpty(this.bdRecyclerLoader.getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onClick");
                z.a(StubApp.getOrigApplicationContext(this.bdRecyclerLoader.getContext().getApplicationContext()), f.a(this.bdRecyclerLoader.getSdkAdInfo().getClk(), this.adData), new i());
                this.bdRecyclerLoader.getSdkAdInfo().getMsLoadedTime();
                this.bdRecyclerLoader.getAdLoader().getPosId();
            }
            BDRecyclerAd bDRecyclerAd = this.adData;
            if (bDRecyclerAd == null || bDRecyclerAd.getRecylcerAdInteractionListener() == null) {
                return;
            }
            this.adData.getRecylcerAdInteractionListener().onAdClicked();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
    public void onAdUnionClick() {
    }
}
