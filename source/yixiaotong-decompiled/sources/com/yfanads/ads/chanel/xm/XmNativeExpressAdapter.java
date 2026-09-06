package com.yfanads.ads.chanel.xm;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.cdo.oaps.ad.OapsKey;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.TemplateAd;
import com.yfanads.ads.chanel.xm.utils.XmUtil;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.custom.NativeExpressCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class XmNativeExpressAdapter extends NativeExpressCustomAdapter {
    private TemplateAd templateAd;

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public int getAdType() {
        return 7;
    }

    public XmNativeExpressAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        XmUtil.initXm(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.xm.XmNativeExpressAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                XmNativeExpressAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                XmNativeExpressAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
            return;
        }
        this.templateAd = new TemplateAd();
        ADParams.Builder builder = new ADParams.Builder();
        builder.setUpId(this.sdkSupplier.getPotId());
        this.templateAd.setMute(this.sdkSupplier.isMute());
        this.templateAd.loadAd(builder.build(), new TemplateAd.TemplateAdLoadListener() { // from class: com.yfanads.ads.chanel.xm.XmNativeExpressAdapter.2
            @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdLoadListener
            public void onAdLoaded() {
                if (XmNativeExpressAdapter.this.templateAd != null) {
                    XmNativeExpressAdapter xmNativeExpressAdapter = XmNativeExpressAdapter.this;
                    xmNativeExpressAdapter.setEcpm(xmNativeExpressAdapter.getPrice());
                }
                XmNativeExpressAdapter.this.handleSucceed();
            }

            @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdLoadListener
            public void onAdLoadFailed(int i, String str) {
                XmNativeExpressAdapter.this.handleFailed(i, str);
            }
        });
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            if (this.templateAd != null) {
                ArrayList arrayList = new ArrayList();
                if (isBidding()) {
                    this.templateAd.setPrice(getPrice());
                }
                if (this.setting != null) {
                    FrameLayout frameLayout = new FrameLayout(activity);
                    frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
                    YFExpView yFExpView = new YFExpView(frameLayout, getAdType());
                    arrayList.add(yFExpView);
                    this.setting.adapterRenderSuccess(this.sdkSupplier, arrayList);
                    this.templateAd.show(frameLayout, new XMExpViewListener(yFExpView, this));
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        TemplateAd templateAd = this.templateAd;
        if (templateAd != null) {
            templateAd.win(XmUtil.getWinParams(this.sdkSupplier, sdkSupplier));
            String shortString = "";
            StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
            if (UrlConst.isTestEnv() && sdkSupplier != null) {
                shortString = sdkSupplier.toShortString();
            }
            YFLog.high(sbAppend.append(shortString).toString());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        TemplateAd templateAd = this.templateAd;
        if (templateAd != null) {
            templateAd.loss(XmUtil.getLossParams(sdkSupplier));
            YFLog.high(this.tag + " sendBiddingLossResult current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class XMExpViewListener extends NativeExpressCustomAdapter.ExpViewListener<XmNativeExpressAdapter> implements TemplateAd.TemplateAdInteractionListener {
        private final ExpView expView;

        public XMExpViewListener(ExpView expView, XmNativeExpressAdapter xmNativeExpressAdapter) {
            super(xmNativeExpressAdapter);
            this.expView = expView;
        }

        @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
        public void onAdShow() {
            YFLog.debug("XmNativeExpressAdapter onAdShow");
            if (getAdapter() != null) {
                getAdapter().handleExposure(this.expView);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
        public void onAdClick() {
            YFLog.debug("XmNativeExpressAdapter onAdClick");
            if (getAdapter() != null) {
                getAdapter().handleClick(this.expView);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
        public void onAdDismissed() {
            YFLog.debug("XmNativeExpressAdapter onAdDismissed");
            if (getAdapter() != null) {
                YFUtil.switchMainThread("onAdDismissed", new BaseEnsureListener() { // from class: com.yfanads.ads.chanel.xm.XmNativeExpressAdapter$XMExpViewListener$$ExternalSyntheticLambda0
                    @Override // com.yfanads.android.callback.BaseEnsureListener
                    public final void ensure() {
                        this.f$0.m1163x42d3775a();
                    }
                });
            }
        }

        /* JADX INFO: renamed from: lambda$onAdDismissed$0$com-yfanads-ads-chanel-xm-XmNativeExpressAdapter$XMExpViewListener, reason: not valid java name */
        /* synthetic */ void m1163x42d3775a() {
            getAdapter().handleClose(this.expView);
        }

        @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
        public void onAdRenderFailed(int i, String str) {
            YFLog.debug("XmNativeExpressAdapter onAdRenderFailed");
            if (getAdapter() != null) {
                YFLog.error(getAdapter().tag + " onAdRenderFailed, msg:" + str + "_" + i);
                getAdapter().handleRenderFailed(this.expView);
            }
        }
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        TemplateAd templateAd = this.templateAd;
        if (templateAd != null) {
            templateAd.destroy();
            this.templateAd = null;
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
}
