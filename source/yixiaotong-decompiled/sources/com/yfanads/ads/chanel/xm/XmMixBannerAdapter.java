package com.yfanads.ads.chanel.xm;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.cdo.oaps.ad.OapsKey;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.BannerAd;
import com.miui.zeus.mimo.sdk.TemplateAd;
import com.yfanads.ads.chanel.xm.utils.XmUtil;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.custom.MixBannerCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class XmMixBannerAdapter extends MixBannerCustomAdapter {
    private BannerAd bannerAd;
    private TemplateAd templateAd;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 7;
    }

    public XmMixBannerAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        XmUtil.initXm(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.xm.XmMixBannerAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                XmMixBannerAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                XmMixBannerAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadNativeAd(Context context) {
        YFLog.warn(this.tag + " hw is not support load nativeAd ");
        handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadTemplateAd(Context context) {
        loadTemplate();
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void loadBannerAd(Context context) {
        loadBannerAd();
    }

    private void loadTemplate() {
        this.templateAd = new TemplateAd();
        ADParams.Builder builder = new ADParams.Builder();
        builder.setUpId(this.sdkSupplier.getPotId());
        this.templateAd.setMute(this.sdkSupplier.isMute());
        this.templateAd.loadAd(builder.build(), new TemplateAd.TemplateAdLoadListener() { // from class: com.yfanads.ads.chanel.xm.XmMixBannerAdapter.2
            @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdLoadListener
            public void onAdLoaded() {
                if (XmMixBannerAdapter.this.templateAd != null) {
                    XmMixBannerAdapter xmMixBannerAdapter = XmMixBannerAdapter.this;
                    xmMixBannerAdapter.setEcpm(xmMixBannerAdapter.getPrice());
                }
                XmMixBannerAdapter.this.handleSucceed();
            }

            @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdLoadListener
            public void onAdLoadFailed(int i, String str) {
                XmMixBannerAdapter.this.handleFailed(i, str);
            }
        });
    }

    private void loadBannerAd() {
        this.bannerAd = new BannerAd();
        ADParams.Builder builder = new ADParams.Builder();
        builder.setUpId(this.sdkSupplier.getPotId());
        this.bannerAd.setMute(this.sdkSupplier.isMute());
        this.bannerAd.loadAd(builder.build(), new BannerAd.BannerLoadListener() { // from class: com.yfanads.ads.chanel.xm.XmMixBannerAdapter.3
            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerLoadListener
            public void onBannerAdLoadSuccess() {
                if (XmMixBannerAdapter.this.bannerAd != null) {
                    XmMixBannerAdapter xmMixBannerAdapter = XmMixBannerAdapter.this;
                    xmMixBannerAdapter.setEcpm(xmMixBannerAdapter.getBannerPrice());
                }
                XmMixBannerAdapter.this.handleSucceed();
            }

            @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerLoadListener
            public void onAdLoadFailed(int i, String str) {
                YFLog.high(XmMixBannerAdapter.this.tag + " onError: code = " + i + " msg = " + str);
                XmMixBannerAdapter.this.handleFailed(i + "", str);
            }
        });
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowTemplateAd(Activity activity) {
        try {
            if (this.templateAd != null) {
                this.viewList.clear();
                if (isBidding()) {
                    this.templateAd.setPrice(getPrice());
                }
                if (this.setting != null) {
                    FrameLayout frameLayout = new FrameLayout(activity);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                    YFExpView yFExpView = new YFExpView(frameLayout, getAdType());
                    this.viewList.add(yFExpView);
                    this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
                    this.templateAd.show(frameLayout, new AnonymousClass4(yFExpView));
                    return;
                }
                return;
            }
            if (this.setting != null) {
                this.setting.adapterRenderFailed(this.sdkSupplier);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.yfanads.ads.chanel.xm.XmMixBannerAdapter$4, reason: invalid class name */
    class AnonymousClass4 implements TemplateAd.TemplateAdInteractionListener {
        final /* synthetic */ YFExpView val$view;

        AnonymousClass4(YFExpView yFExpView) {
            this.val$view = yFExpView;
        }

        @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
        public void onAdShow() {
            XmMixBannerAdapter.this.handleExposure(this.val$view);
        }

        @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
        public void onAdClick() {
            XmMixBannerAdapter.this.handleClick(this.val$view);
        }

        /* JADX INFO: renamed from: lambda$onAdDismissed$0$com-yfanads-ads-chanel-xm-XmMixBannerAdapter$4, reason: not valid java name */
        /* synthetic */ void m1161x8ba8431e(YFExpView yFExpView) {
            XmMixBannerAdapter.this.handleClose(yFExpView);
        }

        @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
        public void onAdDismissed() {
            final YFExpView yFExpView = this.val$view;
            YFUtil.switchMainThread("onAdDismissed", new BaseEnsureListener() { // from class: com.yfanads.ads.chanel.xm.XmMixBannerAdapter$4$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.callback.BaseEnsureListener
                public final void ensure() {
                    this.f$0.m1161x8ba8431e(yFExpView);
                }
            });
        }

        @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
        public void onAdRenderFailed(int i, String str) {
            YFLog.error(XmMixBannerAdapter.this.tag + " onRenderFail, msg:" + str + "_" + i);
            XmMixBannerAdapter.this.handleRenderFailed(this.val$view);
        }
    }

    @Override // com.yfanads.android.custom.MixBannerCustomAdapter
    public void doShowBannerAd(Activity activity) {
        try {
            if (this.bannerAd != null) {
                this.viewList.clear();
                if (isBidding()) {
                    this.bannerAd.setPrice(getBannerPrice());
                }
                if (this.setting != null) {
                    FrameLayout frameLayout = new FrameLayout(activity);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                    YFExpView yFExpView = new YFExpView(frameLayout, getAdType());
                    this.viewList.add(yFExpView);
                    this.setting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
                    this.bannerAd.showAd(activity, frameLayout, new AnonymousClass5(yFExpView));
                    return;
                }
                return;
            }
            if (this.setting != null) {
                this.setting.adapterRenderFailed(this.sdkSupplier);
            }
        } catch (Exception e) {
            e.printStackTrace();
            handleShowFailed();
        }
    }

    /* JADX INFO: renamed from: com.yfanads.ads.chanel.xm.XmMixBannerAdapter$5, reason: invalid class name */
    class AnonymousClass5 implements BannerAd.BannerInteractionListener {
        final /* synthetic */ YFExpView val$view;

        AnonymousClass5(YFExpView yFExpView) {
            this.val$view = yFExpView;
        }

        @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
        public void onAdClick() {
            YFLog.debug(XmMixBannerAdapter.this.tag + " onAdClick");
            XmMixBannerAdapter.this.handleClick(this.val$view);
        }

        @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
        public void onAdShow() {
            YFLog.debug(XmMixBannerAdapter.this.tag + " onAdShow");
            XmMixBannerAdapter.this.handleExposure(this.val$view);
        }

        @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
        public void onAdDismiss() {
            YFLog.debug(XmMixBannerAdapter.this.tag + " onAdDismiss");
            final YFExpView yFExpView = this.val$view;
            YFUtil.switchMainThread("onAdDismissed", new BaseEnsureListener() { // from class: com.yfanads.ads.chanel.xm.XmMixBannerAdapter$5$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.callback.BaseEnsureListener
                public final void ensure() {
                    this.f$0.m1162x8ed08b1e(yFExpView);
                }
            });
        }

        /* JADX INFO: renamed from: lambda$onAdDismiss$0$com-yfanads-ads-chanel-xm-XmMixBannerAdapter$5, reason: not valid java name */
        /* synthetic */ void m1162x8ed08b1e(YFExpView yFExpView) {
            XmMixBannerAdapter.this.handleClose(yFExpView);
        }

        @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
        public void onRenderSuccess() {
            YFLog.debug(XmMixBannerAdapter.this.tag + " onRenderSuccess");
        }

        @Override // com.miui.zeus.mimo.sdk.BannerAd.BannerInteractionListener
        public void onRenderFail(int i, String str) {
            YFLog.error(XmMixBannerAdapter.this.tag + " onRenderFail, msg:" + str + "_" + i);
            XmMixBannerAdapter.this.handleRenderFailed(this.val$view);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        BannerAd bannerAd = this.bannerAd;
        String shortString = "";
        if (bannerAd != null) {
            bannerAd.win(XmUtil.getWinParams(this.sdkSupplier, sdkSupplier));
            YFLog.high(this.tag + " sendBiddingSucResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + "  loss=" + ((!UrlConst.isTestEnv() || sdkSupplier == null) ? "" : sdkSupplier.toShortString()));
        }
        TemplateAd templateAd = this.templateAd;
        if (templateAd != null) {
            templateAd.win(XmUtil.getWinParams(this.sdkSupplier, sdkSupplier));
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        BannerAd bannerAd = this.bannerAd;
        if (bannerAd != null) {
            bannerAd.loss(XmUtil.getLossParams(sdkSupplier));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
        TemplateAd templateAd = this.templateAd;
        if (templateAd != null) {
            templateAd.loss(XmUtil.getLossParams(sdkSupplier));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowNativeAd(Activity activity) {
        YFLog.warn(this.tag + " hw is not support show nativeAd ");
        if (this.setting != null) {
            this.setting.adapterRenderFailed(this.sdkSupplier);
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        TemplateAd templateAd = this.templateAd;
        if (templateAd != null) {
            templateAd.destroy();
            this.templateAd = null;
        }
        BannerAd bannerAd = this.bannerAd;
        if (bannerAd != null) {
            bannerAd.destroy();
            this.bannerAd = null;
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.XM.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getPrice() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        TemplateAd templateAd = this.templateAd;
        if (templateAd == null || (mediaExtraInfo = templateAd.getMediaExtraInfo()) == null || mediaExtraInfo.isEmpty() || (obj = mediaExtraInfo.get(OapsKey.KEY_PRICE)) == null) {
            return 0L;
        }
        return ((Long) obj).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getBannerPrice() {
        Map<String, Object> mediaExtraInfo;
        Object obj;
        BannerAd bannerAd = this.bannerAd;
        if (bannerAd == null || (mediaExtraInfo = bannerAd.getMediaExtraInfo()) == null || mediaExtraInfo.isEmpty() || (obj = mediaExtraInfo.get(OapsKey.KEY_PRICE)) == null) {
            return 0L;
        }
        return ((Long) obj).longValue();
    }
}
