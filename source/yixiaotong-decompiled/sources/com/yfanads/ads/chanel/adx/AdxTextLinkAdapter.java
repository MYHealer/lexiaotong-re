package com.yfanads.ads.chanel.adx;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.byazt.dyf.tt;
import com.yfanads.ads.chanel.adx.utils.AdxSdkUtil;
import com.yfanads.android.adx.AdxSDK;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.service.a;
import com.yfanads.android.adx.service.c;
import com.yfanads.android.core.textlink.YFTextLinkSetting;
import com.yfanads.android.custom.TextLinkCustomAdapter;
import com.yfanads.android.custom.view.AdTLViewHolder;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TLTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxTextLinkAdapter extends TextLinkCustomAdapter {
    private boolean isAuto;
    private boolean isShakeAction;
    private boolean isShakeActionOne;
    AdxNativeAd nativeAds;

    public static abstract class AdListener implements AdxNativeAd.AdInteractionListener {
        private AdListener() {
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
            return false;
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdHide() {
        }

        @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
        public void onAdShow() {
        }
    }

    public AdxTextLinkAdapter(YFTextLinkSetting yFTextLinkSetting) {
        super(yFTextLinkSetting);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeShake(AdTLViewHolder adTLViewHolder, TLTemplateData tLTemplateData) {
        YFOptional.ofNullable(adTLViewHolder).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.ads.chanel.adx.AdxTextLinkAdapter$$ExternalSyntheticLambda2
            @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
            public final void accept(Object obj) {
                ((AdTLViewHolder) obj).shakeArea.setVisibility(8);
            }
        });
        YFOptional.ofNullable(this.nativeAds).ifPresentRun(new AdxNativeExpressAdapter$$ExternalSyntheticLambda9());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadByNative() {
        AdxSDK.getLoadManager().loadNativeAd(new AdxScene.Builder(AdxSdkUtil.getAdId(this.sdkSupplier)).setEcpm(getEcpm()).setReqId(getRequestId()).adStyle(2).build(), new LoadManager.NativeAdListener() { // from class: com.yfanads.ads.chanel.adx.AdxTextLinkAdapter.2
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onError(int i, String str) {
                YFLog.high(AdxTextLinkAdapter.this.tag + " onError " + i + str);
                AdxTextLinkAdapter.this.handleFailed(i, str);
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0048 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:4:0x001e, B:6:0x0024, B:9:0x002c, B:10:0x0048), top: B:16:0x001e }] */
            @Override // com.yfanads.android.adx.api.LoadManager.NativeAdListener
            public void onNativeAdLoad(List<AdxNativeAd> list) {
                YFLog.high(AdxTextLinkAdapter.this.tag + "onNativeAdLoad");
                if (list != null) {
                    try {
                        if (list.isEmpty() || list.get(0) == null) {
                            AdxTextLinkAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                        } else {
                            AdxTextLinkAdapter.this.nativeAds = list.get(0);
                            AdxTextLinkAdapter adxTextLinkAdapter = AdxTextLinkAdapter.this;
                            adxTextLinkAdapter.setEcpm(adxTextLinkAdapter.nativeAds.getECPM());
                            AdxTextLinkAdapter.this.handleSucceed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        AdxTextLinkAdapter.this.handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
                    }
                } else {
                    AdxTextLinkAdapter.this.handleFailed(YFAdError.ERROR_DATA_NULL, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needUpdateAction() {
        return this.isShakeAction && this.isShakeActionOne;
    }

    private void registerViewForInteraction(Activity activity, final AdTLViewHolder adTLViewHolder, boolean z, final TLTemplateData tLTemplateData, AdxNativeAd adxNativeAd) {
        HashMap map = new HashMap();
        BaseTemplateData.InteractiveStyle activeStyle = tLTemplateData.getActiveStyle();
        if (activeStyle == BaseTemplateData.InteractiveStyle.CLICK_SHAKE) {
            adTLViewHolder.shakeArea.setVisibility(0);
            map.put(adTLViewHolder.adCard, 4);
            map.put(adTLViewHolder.shakeArea, 1);
        } else if (activeStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE) {
            map.put(adTLViewHolder.adCard, 6);
        } else {
            map.put(adTLViewHolder.adCard, 4);
        }
        map.put(adTLViewHolder.adCloseDelay, 4);
        if (activity != null) {
            adxNativeAd.registerViewForInteraction(activity, a.TEXT_LINK, adTLViewHolder.adCard, map, new AdxNativeAd.InteractionConf(this.isAuto, tLTemplateData), new AdListener() { // from class: com.yfanads.ads.chanel.adx.AdxTextLinkAdapter.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onAdShakeSuccess(boolean z2, boolean z3, boolean z4) {
                    super.onAdShakeSuccess(z2, z3, z4);
                    if (AdxTextLinkAdapter.this.needUpdateAction()) {
                        tLTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
                        AdxTextLinkAdapter.this.updateShakeAction(tLTemplateData);
                        AdxTextLinkAdapter.this.closeShake(adTLViewHolder, tLTemplateData);
                    }
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onExposure(boolean z2) {
                    if (z2) {
                        AdxTextLinkAdapter.this.handleExposure();
                    } else {
                        AdxTextLinkAdapter.this.handleFailed(YFAdError.ERROR_ADX_EXPOSURE, "exposure url empty");
                    }
                }

                @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
                public void onHandleClick(boolean z2) {
                    YFLog.high(" onHandleClick");
                    AdxTextLinkAdapter.this.handleClick(z2);
                }
            });
        }
        if (!z || adxNativeAd == null) {
            return;
        }
        adxNativeAd.reportAdInfo(11, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateShakeAction(TLTemplateData tLTemplateData) {
        this.isShakeActionOne = tLTemplateData.isActionOne();
        this.isShakeAction = tLTemplateData.isShake() || tLTemplateData.isTwist();
    }

    @Override // com.yfanads.android.custom.TextLinkCustomAdapter
    public void bindData(Activity activity, TLTemplateData tLTemplateData, final ViewGroup viewGroup, AdTLViewHolder adTLViewHolder) {
        final boolean z = this.nativeAds.getMaterialType() == 1;
        if (!this.isSupportShake && tLTemplateData.isAction()) {
            if (tLTemplateData.isOnlyAction()) {
                tLTemplateData.setWholeClick();
            }
            tLTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_V3.getValue());
        }
        updateShakeAction(tLTemplateData);
        tLTemplateData.setAdx(true);
        tLTemplateData.updAdLog(R.mipmap.yf_ad_logo);
        adTLViewHolder.updateShowView(getContext(), tLTemplateData);
        String adDescription = TextUtils.isEmpty(this.nativeAds.getTitle()) ? this.nativeAds.getAdDescription() : this.nativeAds.getTitle();
        if (TextUtils.isEmpty(adDescription)) {
            adDescription = tLTemplateData.getTitle();
        }
        if (!TextUtils.isEmpty(adDescription)) {
            adTLViewHolder.title.setText(adDescription);
        }
        adTLViewHolder.loadAdIcon(true ^ tLTemplateData.isShowIcon(), this.nativeAds.getAppIconUrl(), tLTemplateData.popHeight);
        adTLViewHolder.getCloseView(tLTemplateData).setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxTextLinkAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1035lambda$bindData$0$comyfanadsadschaneladxAdxTextLinkAdapter(z, viewGroup, view);
            }
        });
        registerViewForInteraction(activity, adTLViewHolder, z, tLTemplateData, this.nativeAds);
        final FragmentManager fragmentManager = activity.getFragmentManager();
        adTLViewHolder.dislikeBtn.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxTextLinkAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1036lambda$bindData$1$comyfanadsadschaneladxAdxTextLinkAdapter(fragmentManager, view);
            }
        });
        com.yfanads.android.adx.utils.a.a(this.tag + " bindData success " + z);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
        AdxSdkUtil.initAD(this.tag, context, getInitBean(), isListPackage(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.adx.AdxTextLinkAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                AdxTextLinkAdapter.this.handleFailed(str, str2);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                AdxTextLinkAdapter.this.loadByNative();
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.TextLinkCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        super.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
        showNativeADs(activity, viewGroup);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return AdxSdkUtil.getAdInfo(this.nativeAds, getRequestId());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.ADX.getValue();
    }

    /* JADX INFO: renamed from: lambda$bindData$1$com-yfanads-ads-chanel-adx-AdxTextLinkAdapter, reason: not valid java name */
    /* synthetic */ void m1036lambda$bindData$1$comyfanadsadschaneladxAdxTextLinkAdapter(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new OnFeedClickListener() { // from class: com.yfanads.ads.chanel.adx.AdxTextLinkAdapter.3
            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onDismiss() {
            }

            @Override // com.yfanads.android.custom.view.OnFeedClickListener
            public void onTraceFeed() {
                if (AdxTextLinkAdapter.this.nativeAds != null) {
                    FeedCom feedCom = new FeedCom(c.a.f9618a.e, AdxSdkUtil.getReqAdId(((TextLinkCustomAdapter) AdxTextLinkAdapter.this).sdkSupplier), AdxTextLinkAdapter.this.getRequestId());
                    AdxTextLinkAdapter adxTextLinkAdapter = AdxTextLinkAdapter.this;
                    adxTextLinkAdapter.nativeAds.traceData(((TextLinkCustomAdapter) adxTextLinkAdapter).sdkSupplier != null ? ((TextLinkCustomAdapter) AdxTextLinkAdapter.this).sdkSupplier.getTemplateConf() : null, feedCom, false);
                }
            }
        });
    }

    private void showNativeADs(Activity activity, ViewGroup viewGroup) {
        if (this.nativeAds == null) {
            YFLog.debug(this.tag + " nativeAds is null, return. ");
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_SHOW));
        } else {
            if (isBidding()) {
                AdxNativeAd adxNativeAd = this.nativeAds;
                adxNativeAd.setBidEcpm(adxNativeAd.getECPM(), 0L);
            }
            addView(activity, viewGroup);
        }
    }

    @Override // com.yfanads.android.custom.TextLinkCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            adxNativeAd.destroy(a.BANNER);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            adxNativeAd.reportAdInfo(19, null);
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=");
            SdkSupplier sdkSupplier2 = this.sdkSupplier;
            String shortString = "";
            StringBuilder sbAppend2 = sbAppend.append(sdkSupplier2 != null ? sdkSupplier2.toShortString() : "").append(" loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend2.append(shortString).toString());
        }
    }

    /* JADX INFO: renamed from: lambda$bindData$0$com-yfanads-ads-chanel-adx-AdxTextLinkAdapter, reason: not valid java name */
    /* synthetic */ void m1035lambda$bindData$0$comyfanadsadschaneladxAdxTextLinkAdapter(boolean z, ViewGroup viewGroup, View view) {
        AdxNativeAd adxNativeAd = this.nativeAds;
        if (adxNativeAd != null) {
            if (z) {
                adxNativeAd.reportAdInfo(18, null);
            }
            this.nativeAds.unRegisterViewAction();
        }
        closeAds(viewGroup);
    }
}
