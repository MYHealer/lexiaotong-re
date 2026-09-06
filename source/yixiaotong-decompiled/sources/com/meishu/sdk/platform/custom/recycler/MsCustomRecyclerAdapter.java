package com.meishu.sdk.platform.custom.recycler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class MsCustomRecyclerAdapter extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private static final String TAG = "MsCustomRecyclerAdapter";

    public MsCustomRecyclerAdapter(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((RecyclerMixAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        loadCustomAd(getSdkAdInfo().getApp_id(), getSdkAdInfo().getApp_key(), getSdkAdInfo().getPid(), getSdkAdInfo().getCustom_ext());
    }

    public abstract void loadCustomAd(String str, String str2, String str3, String str4);

    public void onError(int i, String str) {
        getLoaderListener().onAdPlatformError(new AdPlatformError(str, Integer.valueOf(i)));
    }

    public void onExpressAdClicked(MsCustomRecyclerExpressAd msCustomRecyclerExpressAd) {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            com.meishu.sdk.core.loader.a.a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), f.a(getSdkAdInfo().getClk(), msCustomRecyclerExpressAd));
        }
        if (msCustomRecyclerExpressAd.getRecylcerAdInteractionListener() != null) {
            msCustomRecyclerExpressAd.getRecylcerAdInteractionListener().onAdClicked();
        }
    }

    public void onExpressAdClosed(MsCustomRecyclerExpressAd msCustomRecyclerExpressAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdClosed();
            View adView = msCustomRecyclerExpressAd.getAdView();
            if (adView != null && adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            if (msCustomRecyclerExpressAd.getRecylcerAdInteractionListener() != null) {
                msCustomRecyclerExpressAd.getRecylcerAdInteractionListener().onAdClosed();
            }
        }
    }

    public void onExpressAdExposure(MsCustomRecyclerExpressAd msCustomRecyclerExpressAd) {
        if (getLoaderListener() == null || msCustomRecyclerExpressAd.isHasExposed()) {
            return;
        }
        msCustomRecyclerExpressAd.setHasExposed(true);
        getLoaderListener().onAdExposure();
        if (msCustomRecyclerExpressAd.getRecylcerAdInteractionListener() != null) {
            msCustomRecyclerExpressAd.getRecylcerAdInteractionListener().onAdExposure();
        }
    }

    public void onExpressAdRenderSuccess(MsCustomRecyclerExpressAd msCustomRecyclerExpressAd) {
        if (getLoaderListener() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(msCustomRecyclerExpressAd);
            getLoaderListener().onAdReady(arrayList);
        }
    }

    public void onFeedAdClicked(MsCustomRecyclerFeedAd msCustomRecyclerFeedAd) {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            com.meishu.sdk.core.loader.a.a(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), f.a(getSdkAdInfo().getClk(), msCustomRecyclerFeedAd));
        }
        if (msCustomRecyclerFeedAd.getRecylcerAdInteractionListener() != null) {
            msCustomRecyclerFeedAd.getRecylcerAdInteractionListener().onAdClicked();
        }
    }

    public void onFeedAdExposure(MsCustomRecyclerFeedAd msCustomRecyclerFeedAd) {
        if (getLoaderListener() == null || msCustomRecyclerFeedAd.isHasExposed()) {
            return;
        }
        msCustomRecyclerFeedAd.setHasExposed(true);
        getLoaderListener().onAdExposure();
        if (msCustomRecyclerFeedAd.getRecylcerAdInteractionListener() != null) {
            msCustomRecyclerFeedAd.getRecylcerAdInteractionListener().onAdExposure();
        }
    }

    public void onFeedAdLoad(List<RecyclerAdData> list) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdLoaded(list);
            getLoaderListener().onAdReady(list);
        }
    }

    public void onNativeExpressAdLoad(List<RecyclerAdData> list) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdLoaded(list);
        }
    }

    public void onRenderFail(int i, String str) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdError();
            getLoaderListener().onAdRenderFail(str, i);
        }
    }
}
