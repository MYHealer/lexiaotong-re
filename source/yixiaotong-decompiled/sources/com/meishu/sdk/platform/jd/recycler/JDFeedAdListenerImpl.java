package com.meishu.sdk.platform.jd.recycler;

import android.text.TextUtils;
import android.view.View;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.feed.JADFeedListener;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.platform.jd.JDPlatformError;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDFeedAdListenerImpl implements JADFeedListener {
    private static final String TAG = "JDFeedAdListenerImpl";
    private JDExpressFeedAd jdFeedAd;
    private JDFeedAdWrapper jdFeedAdWrapper;
    private a loadListener;

    public JDFeedAdListenerImpl(JDFeedAdWrapper jDFeedAdWrapper, a aVar, JDExpressFeedAd jDExpressFeedAd) {
        this.jdFeedAdWrapper = jDFeedAdWrapper;
        this.loadListener = aVar;
        this.jdFeedAd = jDExpressFeedAd;
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onClick() {
        if (this.jdFeedAdWrapper.getSdkAdInfo() != null && !TextUtils.isEmpty(this.jdFeedAdWrapper.getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onADClicked");
            com.meishu.sdk.core.loader.a.a(this.jdFeedAdWrapper.getContext(), f.a(this.jdFeedAdWrapper.getSdkAdInfo().getClk(), this.jdFeedAd));
        }
        JDExpressFeedAd jDExpressFeedAd = this.jdFeedAd;
        if (jDExpressFeedAd == null || jDExpressFeedAd.getRecylcerAdInteractionListener() == null) {
            return;
        }
        this.jdFeedAd.getRecylcerAdInteractionListener().onAdClicked();
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onExposure() {
        h0.a(this.jdFeedAdWrapper.getSdkAdInfo(), this.jdFeedAd.getAdView());
        a aVar = this.loadListener;
        if (aVar != null) {
            aVar.onAdExposure();
        }
        JDExpressFeedAd jDExpressFeedAd = this.jdFeedAd;
        if (jDExpressFeedAd == null || jDExpressFeedAd.getRecylcerAdInteractionListener() == null) {
            return;
        }
        this.jdFeedAd.getRecylcerAdInteractionListener().onAdExposure();
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onLoadFailure(int i, String str) {
        LogUtil.e(TAG, "onNoAD, code: " + i + ", msg: " + str);
        new JDPlatformError(str, Integer.valueOf(i), this.jdFeedAdWrapper.getSdkAdInfo()).post(this.loadListener);
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onLoadSuccess() {
        JDExpressFeedAd jDExpressFeedAd = this.jdFeedAd;
        if (jDExpressFeedAd != null && jDExpressFeedAd.getFeedAd() != null) {
            this.jdFeedAdWrapper.getSdkAdInfo().getRsp();
            this.jdFeedAdWrapper.getSdkAdInfo().getImp();
            JADFeed feedAd = this.jdFeedAd.getFeedAd();
            if (feedAd.getExtra() != null) {
                this.jdFeedAdWrapper.getSdkAdInfo().setEcpm(String.valueOf(feedAd.getExtra().getPrice()));
            }
        }
        if (this.loadListener != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.jdFeedAd);
            this.loadListener.onAdLoaded(arrayList);
        }
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onClose() {
        a aVar = this.loadListener;
        if (aVar != null) {
            aVar.onAdClosed();
        }
        JDExpressFeedAd jDExpressFeedAd = this.jdFeedAd;
        if (jDExpressFeedAd == null || jDExpressFeedAd.getRecylcerAdInteractionListener() == null) {
            return;
        }
        this.jdFeedAd.getRecylcerAdInteractionListener().onAdClosed();
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onRenderFailure(int i, String str) {
        a aVar = this.loadListener;
        if (aVar != null) {
            aVar.onAdRenderFail(str, i);
        }
        JDExpressFeedAd jDExpressFeedAd = this.jdFeedAd;
        if (jDExpressFeedAd != null && jDExpressFeedAd.getRecylcerAdInteractionListener() != null) {
            this.jdFeedAd.getRecylcerAdInteractionListener().onAdRenderFailed();
        }
        LogUtil.e(TAG, "onAdRenderFailed, code: " + i + ", msg: " + str);
        new JDPlatformError(str, Integer.valueOf(i), this.jdFeedAdWrapper.getSdkAdInfo()).post(this.loadListener);
    }

    @Override // com.jd.ad.sdk.feed.JADFeedListener
    public void onRenderSuccess(View view) {
        if (view == null || this.loadListener == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.jdFeedAd.setAdView(view);
        arrayList.add(this.jdFeedAd);
        this.loadListener.onAdReady(arrayList);
    }
}
