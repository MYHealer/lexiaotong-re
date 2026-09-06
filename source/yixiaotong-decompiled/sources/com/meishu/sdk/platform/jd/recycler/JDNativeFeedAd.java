package com.meishu.sdk.platform.jd.recycler;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.ad.recycler.d;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDNativeFeedAd extends a implements RecyclerAdData {
    private static final String TAG = "JDNativeFeedAd";
    private JDFeedAdWrapper adWrapper;
    private JADMaterialData feedAd;
    private boolean hasExposed;
    private JADNative nativeAd;

    public JDNativeFeedAd(JDFeedAdWrapper jDFeedAdWrapper) {
        super(jDFeedAdWrapper, "JD");
        this.hasExposed = false;
        this.adWrapper = jDFeedAdWrapper;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0073 A[PHI: r0
  0x0073: PHI (r0v6 android.view.ViewGroup) = (r0v5 android.view.ViewGroup), (r0v8 android.view.ViewGroup) binds: [B:12:0x0034, B:14:0x003f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, final RecylcerAdInteractionListener recylcerAdInteractionListener) {
        ViewGroup viewGroup2;
        if (!Activity.class.isInstance(context)) {
            LogUtil.e(TAG, "jd native click need Activity");
            return;
        }
        JDFeedAdWrapper jDFeedAdWrapper = this.adWrapper;
        if (jDFeedAdWrapper != null && jDFeedAdWrapper.getSdkAdInfo() != null) {
            o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
        }
        ViewGroup[] viewGroupArrA = d.a(viewGroup, getClass(), TouchAdContainer.class);
        ViewGroup viewGroup3 = viewGroupArrA[1];
        if (viewGroup3 == null) {
            viewGroup3 = viewGroupArrA[0];
            ViewGroup viewGroup4 = (ViewGroup) viewGroup3.getParent();
            if (viewGroup4 == null) {
                viewGroup2 = viewGroup3;
            } else {
                int iIndexOfChild = viewGroup4.indexOfChild(viewGroup3);
                ViewGroup.LayoutParams layoutParams = viewGroup3.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                viewGroup4.removeView(viewGroup3);
                TouchAdContainer touchAdContainer = new TouchAdContainer(viewGroup3.getContext());
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(this));
                touchAdContainer.addView(viewGroup3, layoutParams2);
                touchAdContainer.setId(viewGroup3.getId());
                viewGroup4.addView(touchAdContainer, iIndexOfChild, layoutParams);
                viewGroup2 = touchAdContainer;
            }
        } else {
            viewGroup2 = viewGroup3;
        }
        JADNative jADNative = this.nativeAd;
        if (jADNative != null) {
            jADNative.registerNativeView((Activity) context, viewGroup2, list, null, new JADNativeInteractionListener() { // from class: com.meishu.sdk.platform.jd.recycler.JDNativeFeedAd.1
                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onClick(View view) {
                    LogUtil.d(JDNativeFeedAd.TAG, "send onADClicked");
                    try {
                        z.a(JDNativeFeedAd.this.adWrapper.getContext(), JDNativeFeedAd.this.adWrapper.getSdkAdInfo().getClk(), new i());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    try {
                        RecylcerAdInteractionListener recylcerAdInteractionListener2 = recylcerAdInteractionListener;
                        if (recylcerAdInteractionListener2 != null) {
                            recylcerAdInteractionListener2.onAdClicked();
                        }
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onClose(View view) {
                    LogUtil.d(JDNativeFeedAd.TAG, "send onAdClosed");
                    try {
                        JDNativeFeedAd.this.adWrapper.getLoaderListener().onAdClosed();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.jd.ad.sdk.nativead.JADNativeInteractionListener
                public void onExposure() {
                    if (JDNativeFeedAd.this.hasExposed) {
                        return;
                    }
                    LogUtil.d(JDNativeFeedAd.TAG, "send onAdExposure");
                    try {
                        JDNativeFeedAd.this.adWrapper.getLoaderListener().onAdExposure();
                        JDNativeFeedAd.this.hasExposed = true;
                        RecylcerAdInteractionListener recylcerAdInteractionListener2 = recylcerAdInteractionListener;
                        if (recylcerAdInteractionListener2 != null) {
                            recylcerAdInteractionListener2.onAdExposure();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        return (this.feedAd.getImageUrls() == null || 1 >= this.feedAd.getImageUrls().size()) ? 12 : 13;
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
    public String getDeveloper() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        return null;
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
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        try {
            return (String[]) this.feedAd.getImageUrls().toArray(new String[this.feedAd.getImageUrls().size()]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        return 0;
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
        JADNative jADNative = this.nativeAd;
        if (jADNative == null || jADNative.getJADExtra() == null) {
            return null;
        }
        return this.nativeAd.getJADExtra().getPrice() + "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return "JD";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        return "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        return null;
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

    public void setFeedAd(JADMaterialData jADMaterialData, JADNative jADNative) {
        this.feedAd = jADMaterialData;
        this.nativeAd = jADNative;
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
    public String getDesc() {
        JADMaterialData jADMaterialData = this.feedAd;
        return jADMaterialData != null ? jADMaterialData.getDescription() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        JADMaterialData jADMaterialData = this.feedAd;
        return jADMaterialData != null ? jADMaterialData.getResource() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        JADMaterialData jADMaterialData = this.feedAd;
        return jADMaterialData != null ? jADMaterialData.getTitle() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
        JADNative jADNative = this.nativeAd;
        if (jADNative != null) {
            this.feedAd = null;
            jADNative.destroy();
            this.nativeAd = null;
        }
    }
}
