package com.meishu.sdk.platform.ks.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsFeedAd;
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
public class KSExpressFeedAd extends a implements RecyclerAdData {
    private static final String TAG = "KSExpressFeedAd";
    private KSRecyclerAdWrapper adWrapper;
    private KsFeedAd ksFeedAd;
    private RecylcerAdInteractionListener recylcerAdInteractionListener;

    public KSExpressFeedAd(KsFeedAd ksFeedAd, KSRecyclerAdWrapper kSRecyclerAdWrapper) {
        super(kSRecyclerAdWrapper, "KS");
        this.ksFeedAd = ksFeedAd;
        this.adWrapper = kSRecyclerAdWrapper;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, final RecylcerAdInteractionListener recylcerAdInteractionListener) {
        try {
            KSRecyclerAdWrapper kSRecyclerAdWrapper = this.adWrapper;
            if (kSRecyclerAdWrapper != null && kSRecyclerAdWrapper.getSdkAdInfo() != null) {
                o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
            }
            this.recylcerAdInteractionListener = recylcerAdInteractionListener;
            this.ksFeedAd.render(new KsFeedAd.AdRenderListener() { // from class: com.meishu.sdk.platform.ks.recycler.KSExpressFeedAd.1
                @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
                public void onAdRenderSuccess(View view) {
                }

                @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
                public void onAdRenderFailed(int i, String str) {
                    RecylcerAdInteractionListener recylcerAdInteractionListener2 = recylcerAdInteractionListener;
                    if (recylcerAdInteractionListener2 != null) {
                        recylcerAdInteractionListener2.onAdRenderFailed();
                    }
                }
            });
            if (viewGroup == null || getAdView() == null) {
                return;
            }
            viewGroup.removeAllViews();
            viewGroup.addView(getAdView());
            KSRecyclerAdWrapper kSRecyclerAdWrapper2 = this.adWrapper;
            if (kSRecyclerAdWrapper2 != null) {
                o1.a(viewGroup, kSRecyclerAdWrapper2.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
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
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public View getAdView() {
        try {
            if (this.adView == null) {
                this.adView = this.ksFeedAd.getFeedView(this.adWrapper.getContext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        return new String[0];
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
    public String getPlatform() {
        return "KS";
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
    public int getAdPatternType() {
        KsFeedAd ksFeedAd = this.ksFeedAd;
        if (ksFeedAd == null) {
            return 12;
        }
        int materialType = ksFeedAd.getMaterialType();
        if (materialType != 1) {
            return materialType != 3 ? 12 : 13;
        }
        return 2;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        if (this.ksFeedAd != null) {
            return this.ksFeedAd.getECPM() + "";
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        try {
            KSRecyclerAdWrapper kSRecyclerAdWrapper = this.adWrapper;
            if (kSRecyclerAdWrapper != null) {
                int adPatternType = kSRecyclerAdWrapper.getAdLoader().getAdPatternType();
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
}
