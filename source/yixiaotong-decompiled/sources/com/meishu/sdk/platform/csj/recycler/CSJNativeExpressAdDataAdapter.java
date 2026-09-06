package com.meishu.sdk.platform.csj.recycler;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJNativeExpressAdDataAdapter extends a implements RecyclerAdData {
    private static final String TAG = "CSJNativeExpressAdDataAdapter";
    private com.meishu.sdk.core.ad.recycler.a adListener;
    private CSJTTAdNativeWrapper adWrapper;
    private volatile boolean hasExposed;
    private RecylcerAdInteractionListener recylcerAdInteractionListener;
    private TTNativeExpressAd ttNativeExpressAd;

    public CSJNativeExpressAdDataAdapter(CSJTTAdNativeWrapper cSJTTAdNativeWrapper, TTNativeExpressAd tTNativeExpressAd) {
        super(cSJTTAdNativeWrapper, MSAdConfig.PLATFORM_CSJ);
        this.adWrapper = cSJTTAdNativeWrapper;
        this.adListener = cSJTTAdNativeWrapper.getAdListener();
        this.ttNativeExpressAd = tTNativeExpressAd;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        Activity activity;
        TTNativeExpressAd tTNativeExpressAd;
        try {
            CSJTTAdNativeWrapper cSJTTAdNativeWrapper = this.adWrapper;
            if (cSJTTAdNativeWrapper != null && cSJTTAdNativeWrapper.getSdkAdInfo() != null) {
                o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
            }
            this.recylcerAdInteractionListener = recylcerAdInteractionListener;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = viewGroup.getContext() instanceof Activity ? (Activity) viewGroup.getContext() : null;
            }
            if (activity != null) {
                try {
                    if (!activity.isFinishing() && (tTNativeExpressAd = this.ttNativeExpressAd) != null) {
                        tTNativeExpressAd.setDislikeCallback(activity, new CSJRecyclerExpressDisLikeCallback(this.adWrapper, tTNativeExpressAd, recylcerAdInteractionListener));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            View adView = getAdView();
            if (viewGroup == null || adView == null) {
                return;
            }
            viewGroup.removeAllViews();
            if (adView.getParent() instanceof ViewGroup) {
                ((ViewGroup) adView.getParent()).removeAllViews();
            }
            viewGroup.addView(adView);
            CSJTTAdNativeWrapper cSJTTAdNativeWrapper2 = this.adWrapper;
            if (cSJTTAdNativeWrapper2 != null) {
                o1.a(viewGroup, cSJTTAdNativeWrapper2.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
            }
        } catch (Throwable th) {
            th.printStackTrace();
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

    public com.meishu.sdk.core.ad.recycler.a getAdListener() {
        return this.adListener;
    }

    public CSJTTAdNativeWrapper getAdWrapper() {
        return this.adWrapper;
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
    public String getFrom() {
        return null;
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
        return null;
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
        return MSAdConfig.PLATFORM_CSJ;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    public RecylcerAdInteractionListener getRecylcerAdInteractionListener() {
        return this.recylcerAdInteractionListener;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
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

    public boolean isHasExposed() {
        return this.hasExposed;
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

    public void setHasExposed(boolean z) {
        this.hasExposed = z;
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
    public void destroy() {
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.destroy();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
            if (tTNativeExpressAd == null) {
                return 12;
            }
            int imageMode = tTNativeExpressAd.getImageMode();
            if (imageMode != 15) {
                if (imageMode == 2) {
                    return 11;
                }
                if (imageMode == 3) {
                    return 12;
                }
                if (imageMode == 4) {
                    return 13;
                }
                if (imageMode != 5) {
                    return 12;
                }
            }
            return 2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 12;
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public View getAdView() {
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            return tTNativeExpressAd.getExpressAdView();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        int interactionType;
        try {
            TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
            return (tTNativeExpressAd == null || (interactionType = tTNativeExpressAd.getInteractionType()) == 2 || interactionType == 3 || interactionType != 4) ? 0 : 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        try {
            CSJTTAdNativeWrapper cSJTTAdNativeWrapper = this.adWrapper;
            if (cSJTTAdNativeWrapper != null) {
                int adPatternType = cSJTTAdNativeWrapper.getAdLoader().getAdPatternType();
                if (adPatternType == 200000) {
                    return 2 == this.adWrapper.getSdkAdInfo().getDrawing();
                }
                return adPatternType == 100000;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return true;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(final ExpressMediaListener expressMediaListener) {
        TTNativeExpressAd tTNativeExpressAd = this.ttNativeExpressAd;
        if (tTNativeExpressAd != null) {
            tTNativeExpressAd.setVideoAdListener(new TTNativeExpressAd.ExpressVideoAdListener() { // from class: com.meishu.sdk.platform.csj.recycler.CSJNativeExpressAdDataAdapter.1
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onClickRetry() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onProgressUpdate(long j, long j2) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdComplete() {
                    ExpressMediaListener expressMediaListener2 = expressMediaListener;
                    if (expressMediaListener2 != null) {
                        expressMediaListener2.onVideoCompleted();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdContinuePlay() {
                    ExpressMediaListener expressMediaListener2 = expressMediaListener;
                    if (expressMediaListener2 != null) {
                        expressMediaListener2.onVideoResume();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdPaused() {
                    ExpressMediaListener expressMediaListener2 = expressMediaListener;
                    if (expressMediaListener2 != null) {
                        expressMediaListener2.onVideoPause();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoAdStartPlay() {
                    ExpressMediaListener expressMediaListener2 = expressMediaListener;
                    if (expressMediaListener2 != null) {
                        expressMediaListener2.onVideoStart();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoError(int i, int i2) {
                    ExpressMediaListener expressMediaListener2 = expressMediaListener;
                    if (expressMediaListener2 != null) {
                        expressMediaListener2.onVideoError(i, "错误信息 " + i2);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressVideoAdListener
                public void onVideoLoad() {
                    ExpressMediaListener expressMediaListener2 = expressMediaListener;
                    if (expressMediaListener2 != null) {
                        expressMediaListener2.onVideoLoaded();
                    }
                }
            });
        }
    }
}
