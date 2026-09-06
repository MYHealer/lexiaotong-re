package com.meishu.sdk.platform.mimo.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.loader.InteractionListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import com.miui.zeus.mimo.sdk.NativeAd;
import com.miui.zeus.mimo.sdk.NativeAdData;
import com.miui.zeus.mimo.sdk.TemplateAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoRecyclerAd extends a implements RecyclerAdData {
    private static final String TAG = "MimoRecyclerAd";
    private MimoRecyclerLoader adWrapper;
    private boolean binded;
    private TemplateAd mimoAd;
    private NativeAd mimoNativeAd;
    private NativeAdData mimoNativeAdData;
    private TouchAdContainer touchAdContainer;

    public MimoRecyclerAd(NativeAd nativeAd, NativeAdData nativeAdData, MimoRecyclerLoader mimoRecyclerLoader) {
        super(mimoRecyclerLoader, "MIMO");
        this.mimoNativeAd = nativeAd;
        this.mimoNativeAdData = nativeAdData;
        init(mimoRecyclerLoader);
    }

    private void init(MimoRecyclerLoader mimoRecyclerLoader) {
        this.touchAdContainer = new TouchAdContainer(AdSdk.getContext());
        this.touchAdContainer.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.adView = this.touchAdContainer;
        this.adWrapper = mimoRecyclerLoader;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public View getAdView() {
        return this.adView;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        NativeAdData nativeAdData = this.mimoNativeAdData;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getDesc();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        return "MIMO";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        NativeAdData nativeAdData = this.mimoNativeAdData;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getAdMark();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        NativeAdData nativeAdData = this.mimoNativeAdData;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getIconUrl();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        NativeAdData nativeAdData = this.mimoNativeAdData;
        List<String> imageList = nativeAdData == null ? null : nativeAdData.getImageList();
        if (imageList == null) {
            return new String[0];
        }
        String[] strArr = new String[imageList.size()];
        imageList.toArray(strArr);
        return strArr;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return "MIMO";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        NativeAdData nativeAdData = this.mimoNativeAdData;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getTitle();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        return "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        int adPatternType = this.adWrapper.getAdLoader().getAdPatternType();
        if (adPatternType == 200000) {
            return 2 == this.adWrapper.getSdkAdInfo().getDrawing();
        }
        return adPatternType == 100000;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void mute() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void replay() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setDownloadStatusListener(DownloadStatusListener downloadStatusListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void startVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        NativeAdData nativeAdData = this.mimoNativeAdData;
        if (nativeAdData != null) {
            return nativeAdData.getVideoUrl();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        if (this.mimoAd != null) {
            return 100000;
        }
        int adStyle = this.mimoNativeAdData.getAdStyle();
        if (adStyle != 212) {
            return adStyle != 214 ? 12 : 2;
        }
        return 11;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        return (this.mimoAd == null && this.mimoNativeAdData.getAdType() == 2) ? 1 : 0;
    }

    public MimoRecyclerAd(TemplateAd templateAd, MimoRecyclerLoader mimoRecyclerLoader) {
        super(mimoRecyclerLoader, "MIMO");
        this.mimoAd = templateAd;
        init(mimoRecyclerLoader);
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, final RecylcerAdInteractionListener recylcerAdInteractionListener) {
        if (this.binded) {
            return;
        }
        TemplateAd templateAd = this.mimoAd;
        if (templateAd != null) {
            templateAd.show(this.touchAdContainer, new TemplateAd.TemplateAdInteractionListener() { // from class: com.meishu.sdk.platform.mimo.recycler.MimoRecyclerAd.1
                @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
                public void onAdClick() {
                    LogUtil.i(MimoRecyclerAd.TAG, "TemplateAd.onAdClick");
                    com.meishu.sdk.core.loader.a.a(MimoRecyclerAd.this.adWrapper.getContext(), f.a(MimoRecyclerAd.this.adWrapper.getSdkAdInfo().getClk(), MimoRecyclerAd.this));
                    InteractionListener interactionListener = MimoRecyclerAd.this.getInteractionListener();
                    if (interactionListener != null) {
                        interactionListener.onAdClicked();
                    }
                }

                @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
                public void onAdDismissed() {
                    LogUtil.i(MimoRecyclerAd.TAG, "TemplateAd.onAdDismissed");
                    if (MimoRecyclerAd.this.adWrapper.getLoaderListener() != null) {
                        MimoRecyclerAd.this.adWrapper.getLoaderListener().onAdClosed();
                    }
                }

                @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
                public void onAdRenderFailed(int i, String str) {
                    LogUtil.i(MimoRecyclerAd.TAG, "TemplateAd.onAdRenderFailed " + i + ": " + str);
                    if (MimoRecyclerAd.this.adWrapper.getLoaderListener() != null) {
                        MimoRecyclerAd.this.adWrapper.getLoaderListener().onAdError();
                    }
                }

                @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdInteractionListener
                public void onAdShow() {
                    MimoRecyclerAd.this.binded = true;
                    LogUtil.i(MimoRecyclerAd.TAG, "TemplateAd.onAdShow");
                    if (MimoRecyclerAd.this.adWrapper.getLoaderListener() != null) {
                        MimoRecyclerAd.this.adWrapper.getLoaderListener().onAdExposure();
                    }
                }
            });
        } else {
            this.mimoNativeAd.registerAdView(viewGroup, new NativeAd.NativeAdInteractionListener() { // from class: com.meishu.sdk.platform.mimo.recycler.MimoRecyclerAd.2
                @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
                public void onAdClick() {
                    LogUtil.i(MimoRecyclerAd.TAG, "NativeAd.onAdClick");
                    com.meishu.sdk.core.loader.a.a(MimoRecyclerAd.this.adWrapper.getContext(), f.a(MimoRecyclerAd.this.adWrapper.getSdkAdInfo().getClk(), MimoRecyclerAd.this));
                    RecylcerAdInteractionListener recylcerAdInteractionListener2 = recylcerAdInteractionListener;
                    if (recylcerAdInteractionListener2 != null) {
                        recylcerAdInteractionListener2.onAdClicked();
                    }
                }

                @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
                public void onAdShow() {
                    LogUtil.i(MimoRecyclerAd.TAG, "NativeAd.onAdShow");
                    if (MimoRecyclerAd.this.adWrapper.getLoaderListener() != null) {
                        MimoRecyclerAd.this.adWrapper.getLoaderListener().onAdExposure();
                    }
                }
            });
        }
    }
}
