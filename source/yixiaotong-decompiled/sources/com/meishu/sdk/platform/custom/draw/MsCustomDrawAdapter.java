package com.meishu.sdk.platform.custom.draw;

import android.text.TextUtils;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.draw.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class MsCustomDrawAdapter extends BasePlatformLoader<DrawAdLoader, a> {
    private static final String TAG = "MsCustomDrawAdapter";

    public MsCustomDrawAdapter(DrawAdLoader drawAdLoader, SdkAdInfo sdkAdInfo) {
        super(drawAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((DrawAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        loadCustomAd(getSdkAdInfo().getApp_id(), getSdkAdInfo().getApp_key(), getSdkAdInfo().getPid(), getSdkAdInfo().getCustom_ext());
    }

    public abstract void loadCustomAd(String str, String str2, String str3, String str4);

    public void onAdClick(MsCustomDrawAd msCustomDrawAd) {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            com.meishu.sdk.core.loader.a.a(getContext(), f.a(getSdkAdInfo().getClk(), msCustomDrawAd));
        }
        if (msCustomDrawAd.getInteractionListener() != null) {
            msCustomDrawAd.getInteractionListener().onAdClicked();
        }
    }

    public void onAdClosed(MsCustomDrawAd msCustomDrawAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdClosed();
        }
        if (msCustomDrawAd.getInteractionListener() != null) {
            msCustomDrawAd.getInteractionListener().onAdClosed();
        }
    }

    public void onAdExposure(MsCustomDrawAd msCustomDrawAd) {
        h0.a(getSdkAdInfo(), msCustomDrawAd.getAdView());
        if (getLoaderListener() != null) {
            getLoaderListener().onAdExposure();
        }
        if (msCustomDrawAd.getInteractionListener() != null) {
            msCustomDrawAd.getInteractionListener().onAdExposure();
        }
    }

    public void onError(int i, String str) {
        getLoaderListener().onAdPlatformError(new AdPlatformError(str, Integer.valueOf(i)));
    }

    public void onRenderFail(int i, String str) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdError();
            getLoaderListener().onAdRenderFail(str, i);
        }
    }

    public void onRenderSuccess(MsCustomDrawAd msCustomDrawAd) {
        if (getLoaderListener() != null) {
            getLoaderListener().onAdLoaded(msCustomDrawAd);
            getLoaderListener().onAdReady(msCustomDrawAd);
        }
    }

    public void onVideoCompleted(MsCustomDrawAd msCustomDrawAd) {
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        msCustomDrawAd.getDrawVideoListener().playCompletion();
    }

    public void onVideoError(MsCustomDrawAd msCustomDrawAd, int i, String str) {
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        msCustomDrawAd.getDrawVideoListener().onVideoError(i, 0);
    }

    public void onVideoPause(MsCustomDrawAd msCustomDrawAd) {
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        msCustomDrawAd.getDrawVideoListener().playPause();
    }

    public void onVideoResume(MsCustomDrawAd msCustomDrawAd) {
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        msCustomDrawAd.getDrawVideoListener().playResume();
    }

    public void onVideoStart(MsCustomDrawAd msCustomDrawAd) {
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        msCustomDrawAd.getDrawVideoListener().playRenderingStart();
    }

    public void setEcpm(int i) {
        if (getSdkAdInfo() == null || !"bidding".equals(getSdkAdInfo().getOtype())) {
            return;
        }
        getSdkAdInfo().setEcpm(String.valueOf(i));
    }
}
