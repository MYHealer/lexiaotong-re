package com.meishu.sdk.platform.ks.recycler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsFeedAd;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSExpressListener implements KsFeedAd.AdInteractionListener {
    private static final String TAG = "KSExpressListener";
    private KSRecyclerAdWrapper adWrapper;
    private KSExpressFeedAd ksExpressFeedAd;

    public KSExpressListener(KSRecyclerAdWrapper kSRecyclerAdWrapper, KSExpressFeedAd kSExpressFeedAd) {
        this.adWrapper = kSRecyclerAdWrapper;
        this.ksExpressFeedAd = kSExpressFeedAd;
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdClicked() {
        try {
            if (this.adWrapper.getSdkAdInfo() != null && !TextUtils.isEmpty(this.adWrapper.getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onADClicked");
                z.a(this.adWrapper.getContext(), f.a(this.adWrapper.getSdkAdInfo().getClk(), this.ksExpressFeedAd), new i());
                this.adWrapper.getSdkAdInfo().getMsLoadedTime();
                this.adWrapper.getAdLoader().getPosId();
            }
            KSExpressFeedAd kSExpressFeedAd = this.ksExpressFeedAd;
            if (kSExpressFeedAd == null || kSExpressFeedAd.getRecylcerAdInteractionListener() == null) {
                return;
            }
            this.ksExpressFeedAd.getRecylcerAdInteractionListener().onAdClicked();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onAdShow() {
        try {
            h0.a(this.adWrapper.getSdkAdInfo(), this.ksExpressFeedAd.getAdView());
            if (this.adWrapper.getLoaderListener() != null) {
                this.adWrapper.getLoaderListener().onAdExposure();
            }
            KSExpressFeedAd kSExpressFeedAd = this.ksExpressFeedAd;
            if (kSExpressFeedAd == null || kSExpressFeedAd.getRecylcerAdInteractionListener() == null) {
                return;
            }
            this.ksExpressFeedAd.getRecylcerAdInteractionListener().onAdExposure();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDislikeClicked() {
        try {
            if (this.adWrapper.getLoaderListener() != null) {
                this.adWrapper.getLoaderListener().onAdClosed();
            }
            KSExpressFeedAd kSExpressFeedAd = this.ksExpressFeedAd;
            if (kSExpressFeedAd != null && kSExpressFeedAd.getRecylcerAdInteractionListener() != null) {
                this.ksExpressFeedAd.getRecylcerAdInteractionListener().onAdClosed();
            }
            View adView = this.ksExpressFeedAd.getAdView();
            if (adView != null && adView.getParent() != null && (adView.getParent() instanceof ViewGroup)) {
                ((ViewGroup) adView.getParent()).removeView(adView);
            }
            this.ksExpressFeedAd.destroy();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDownloadTipsDialogDismiss() {
    }

    @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
    public void onDownloadTipsDialogShow() {
    }
}
