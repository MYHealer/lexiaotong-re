package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GroMoreNativeExpressAdapter extends CsjNativeExpressAdapter implements TTAdNative.FeedAdListener {
    public GroMoreNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initGroMore(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.GroMoreNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                GroMoreNativeExpressAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                GroMoreNativeExpressAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        TTAdNative tTAdNativeCreateAdNative = CsjUtil.getADManger().createAdNative(context);
        int screenWidth = ScreenUtil.getScreenWidth(context);
        if (this.setting != null && this.setting.getViewWidth() > 0) {
            screenWidth = ScreenUtil.dip2px(context, this.setting.getViewWidth());
        }
        tTAdNativeCreateAdNative.loadFeedAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setImageAcceptedSize(screenWidth, 0).setMediationAdSlot(new MediationAdSlot.Builder().setExtraObject("show_adn_load_error_detail", true).build()).build(), this);
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter, com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        if (YFListUtils.isEmpty(this.nativeAds2)) {
            return;
        }
        int size = getSize();
        if (size > 0) {
            this.viewList.clear();
            for (int i = 0; i < size; i++) {
                this.viewList.add(getView(activity, i, null));
            }
            if (this.setting != null) {
                this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
                return;
            }
            return;
        }
        if (this.setting != null) {
            this.setting.adapterRenderFailed(this.sdkSupplier);
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public ExpView getView(Activity activity, final int i, ViewGroup viewGroup) {
        TTFeedAd adNative = getAdNative(i);
        FrameLayout frameLayout = new FrameLayout(getContext());
        View adView = adNative.getAdView();
        if (adView != null && adView.getParent() == null) {
            frameLayout.removeAllViews();
            frameLayout.addView(adView);
        }
        YFExpView yFExpView = new YFExpView(frameLayout, getAdType(), i);
        adNative.setExpressRenderListener(new ExpressRenderListener(this, yFExpView));
        adNative.setDislikeCallback(activity, new TTAdDislike.DislikeInteractionCallback() { // from class: com.yfanads.ads.chanel.csj.GroMoreNativeExpressAdapter.2
            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onCancel() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onShow() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdDislike.DislikeInteractionCallback
            public void onSelected(int i2, String str, boolean z) {
                GroMoreNativeExpressAdapter.this.closeAds(i);
            }
        });
        adNative.render();
        return yFExpView;
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter, com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ_GROMORE.getValue();
    }

    private static class ExpressRenderListener extends NativeExpressCustomAdapter.ExpViewListener<GroMoreNativeExpressAdapter> implements MediationExpressRenderListener {
        private YFExpView expView;

        public ExpressRenderListener(GroMoreNativeExpressAdapter groMoreNativeExpressAdapter, YFExpView yFExpView) {
            super(groMoreNativeExpressAdapter);
            this.expView = yFExpView;
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
        public void onRenderFail(View view, String str, int i) {
            if (getAdapter() != null) {
                YFLog.error(getAdapter().tag + " onRenderFail msg: " + str + "_" + i);
                getAdapter().handleRenderFailed(this.expView);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
        public void onAdClick() {
            YFLog.debug("GroMoreNativeExpressAdapter onAdClick");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.mediation.ad.MediationExpressRenderListener
        public void onAdShow() {
            YFLog.debug("GroMoreNativeExpressAdapter onAdShow");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTNativeAd.ExpressRenderListener
        public void onRenderSuccess(View view, float f, float f2, boolean z) {
            YFLog.debug("GroMoreNativeExpressAdapter onRenderSuccess");
        }
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        YFLog.high(this.tag + "onNativeAdLoad");
        if (list != null) {
            try {
                if (list.size() != 0 && list.get(0) != null) {
                    this.nativeAds2 = list;
                    try {
                        double d = Double.parseDouble(this.nativeAds2.get(0).getMediationManager().getBestEcpm().getEcpm());
                        YFLog.high(this.tag + "onNativeAdLoad ep_" + d);
                        setEcpm((long) d);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    handleSucceed();
                    return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                return;
            }
        }
        handleFailed(YFAdError.ERROR_DATA_NULL, "");
    }

    @Override // com.yfanads.ads.chanel.csj.CsjNativeExpressAdapter, com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        if (isTemplate()) {
            return (YFListUtils.isEmpty(this.nativeAds) || i >= this.nativeAds.size() || this.nativeAds.get(i) == null) ? "" : CsjUtil.getMReqId(this.nativeAds.get(i).getMediationManager().getBestEcpm());
        }
        return (!isNative() || YFListUtils.isEmpty(this.nativeAds2) || i >= this.nativeAds2.size() || this.nativeAds2.get(i) == null) ? "" : CsjUtil.getMReqId(this.nativeAds2.get(i).getMediationManager().getBestEcpm());
    }
}
