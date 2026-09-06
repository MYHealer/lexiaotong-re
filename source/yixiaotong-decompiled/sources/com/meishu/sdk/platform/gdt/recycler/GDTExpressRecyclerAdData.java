package com.meishu.sdk.platform.gdt.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
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
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.util.AdError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTExpressRecyclerAdData extends a implements RecyclerAdData {
    private static final String TAG = "GDTExpressRecyclerAdData";
    private NativeExpressADView adView;
    private GDTRecyclerAdWrapper adWrapper;
    private RecylcerAdInteractionListener recylcerAdInteractionListener;

    public GDTExpressRecyclerAdData(GDTRecyclerAdWrapper gDTRecyclerAdWrapper, NativeExpressADView nativeExpressADView) {
        super(gDTRecyclerAdWrapper, MSAdConfig.PLATFORM_GDT);
        this.adWrapper = gDTRecyclerAdWrapper;
        this.adView = nativeExpressADView;
        nativeExpressADView.render();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        try {
            GDTRecyclerAdWrapper gDTRecyclerAdWrapper = this.adWrapper;
            if (gDTRecyclerAdWrapper != null && gDTRecyclerAdWrapper.getSdkAdInfo() != null) {
                o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
            }
            NativeExpressADView nativeExpressADView = this.adView;
            if (nativeExpressADView != null) {
                nativeExpressADView.sendWinNotification(nativeExpressADView.getECPM());
            }
            this.recylcerAdInteractionListener = recylcerAdInteractionListener;
            View adView = getAdView();
            if (viewGroup == null || adView == null) {
                return;
            }
            viewGroup.removeAllViews();
            if (adView.getParent() instanceof ViewGroup) {
                ((ViewGroup) adView.getParent()).removeAllViews();
            }
            viewGroup.addView(adView);
            GDTRecyclerAdWrapper gDTRecyclerAdWrapper2 = this.adWrapper;
            if (gDTRecyclerAdWrapper2 != null) {
                o1.a(viewGroup, gDTRecyclerAdWrapper2.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
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
        try {
            viewGroup.removeAllViews();
            viewGroup.addView(new MediaView(viewGroup.getContext()));
            VideoOption.Builder builder = new VideoOption.Builder();
            builder.setAutoPlayPolicy(0);
            builder.setAutoPlayMuted(false);
            builder.setNeedCoverImage(true);
            builder.setNeedProgressBar(true);
            builder.setEnableDetailPage(false);
            builder.setEnableUserControl(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        try {
            NativeExpressADView nativeExpressADView = this.adView;
            if (nativeExpressADView == null || nativeExpressADView.getBoundData() == null) {
                return 100000;
            }
            int adPatternType = this.adView.getBoundData().getAdPatternType();
            if (adPatternType != 2) {
                return adPatternType != 3 ? 12 : 13;
            }
            return 2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 100000;
        }
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
        try {
            return this.adView.getBoundData().getDesc();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
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
    public int getInteractionType() {
        return 1;
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
    public String getPlatform() {
        return MSAdConfig.PLATFORM_GDT;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
    }

    public RecylcerAdInteractionListener getRecylcerAdInteractionListener() {
        return this.recylcerAdInteractionListener;
    }

    @Override // com.meishu.sdk.core.ad.a
    public Object getSdkAd() {
        return this.adView;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        try {
            return this.adView.getBoundData().getTitle();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
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
        try {
            NativeExpressADView nativeExpressADView = this.adView;
            if (nativeExpressADView != null) {
                ViewParent parent = nativeExpressADView.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(this.adView);
                }
                this.adView.setMediaListener(null);
                this.adView.destroy();
                this.adView = null;
            }
            this.recylcerAdInteractionListener = null;
            this.adWrapper = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        if (this.adView != null) {
            return this.adView.getECPM() + "";
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        NativeExpressADView nativeExpressADView = this.adView;
        return nativeExpressADView != null ? nativeExpressADView.isValid() : super.isAdValid();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        try {
            GDTRecyclerAdWrapper gDTRecyclerAdWrapper = this.adWrapper;
            if (gDTRecyclerAdWrapper != null) {
                int adPatternType = gDTRecyclerAdWrapper.getAdLoader().getAdPatternType();
                if (adPatternType == 200000) {
                    return 2 == this.adWrapper.getSdkAdInfo().getDrawing();
                }
                return adPatternType == 100000;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(final ExpressMediaListener expressMediaListener) {
        NativeExpressADView nativeExpressADView = this.adView;
        if (nativeExpressADView == null) {
            return;
        }
        nativeExpressADView.setMediaListener(new NativeExpressMediaListener() { // from class: com.meishu.sdk.platform.gdt.recycler.GDTExpressRecyclerAdData.1
            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoCached(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoInit(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                ExpressMediaListener expressMediaListener2 = expressMediaListener;
                if (expressMediaListener2 != null) {
                    expressMediaListener2.onVideoCompleted();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                try {
                    ExpressMediaListener expressMediaListener2 = expressMediaListener;
                    if (expressMediaListener2 != null) {
                        expressMediaListener2.onVideoError(adError.getErrorCode(), adError.getErrorMsg());
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                ExpressMediaListener expressMediaListener2 = expressMediaListener;
                if (expressMediaListener2 != null) {
                    expressMediaListener2.onVideoPause();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoReady(NativeExpressADView nativeExpressADView2, long j) {
                ExpressMediaListener expressMediaListener2 = expressMediaListener;
                if (expressMediaListener2 != null) {
                    expressMediaListener2.onVideoLoaded();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                ExpressMediaListener expressMediaListener2 = expressMediaListener;
                if (expressMediaListener2 != null) {
                    expressMediaListener2.onVideoStart();
                }
            }
        });
    }
}
