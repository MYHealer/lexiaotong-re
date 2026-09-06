package com.meishu.sdk.platform.pangle.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGMediaView;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGVideoAdListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleFeedAd extends MsCustomRecyclerFeedAd {
    private PangleNativeAdapter adWrapper;
    private PAGNativeAd pagNativeAd;

    public PangleFeedAd(PangleNativeAdapter pangleNativeAdapter, PAGNativeAd pAGNativeAd) {
        super(pangleNativeAdapter);
        this.adWrapper = pangleNativeAdapter;
        this.pagNativeAd = pAGNativeAd;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        try {
            return this.pagNativeAd.getNativeAdData().getButtonText();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        try {
            return this.pagNativeAd.getNativeAdData().getDescription();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        try {
            return this.pagNativeAd.getNativeAdData().getDescription();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
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
        try {
            return this.pagNativeAd.getNativeAdData().getIcon().getImageUrl();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
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
    public String getPackageName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        try {
            return this.pagNativeAd.getNativeAdData().getTitle();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
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
        return false;
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
    public void startVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        PAGNativeAd pAGNativeAd = this.pagNativeAd;
        if (pAGNativeAd != null) {
            pAGNativeAd.registerViewForInteraction(viewGroup, list, (List) null, (View) null, new PAGNativeAdInteractionListener() { // from class: com.meishu.sdk.platform.pangle.feed.PangleFeedAd.2
                public void onAdClicked() {
                    if (PangleFeedAd.this.adWrapper != null) {
                        PangleFeedAd.this.adWrapper.onFeedAdClicked(PangleFeedAd.this);
                    }
                }

                public void onAdDismissed() {
                }

                public void onAdShowed() {
                    if (PangleFeedAd.this.adWrapper != null) {
                        PangleFeedAd.this.adWrapper.onFeedAdExposure(PangleFeedAd.this);
                    }
                }
            });
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, final RecyclerAdMediaListener recyclerAdMediaListener) {
        PAGMediaView mediaView;
        try {
            PAGNativeAd pAGNativeAd = this.pagNativeAd;
            if (pAGNativeAd == null || (mediaView = pAGNativeAd.getNativeAdData().getMediaView()) == null) {
                return;
            }
            mediaView.setVideoAdListener(new PAGVideoAdListener() { // from class: com.meishu.sdk.platform.pangle.feed.PangleFeedAd.1
                public void onVideoAdComplete() {
                    RecyclerAdMediaListener recyclerAdMediaListener2 = recyclerAdMediaListener;
                    if (recyclerAdMediaListener2 != null) {
                        recyclerAdMediaListener2.onVideoCompleted();
                    }
                }

                public void onVideoAdPaused() {
                    RecyclerAdMediaListener recyclerAdMediaListener2 = recyclerAdMediaListener;
                    if (recyclerAdMediaListener2 != null) {
                        recyclerAdMediaListener2.onVideoPause();
                    }
                }

                public void onVideoAdPlay() {
                    RecyclerAdMediaListener recyclerAdMediaListener2 = recyclerAdMediaListener;
                    if (recyclerAdMediaListener2 != null) {
                        recyclerAdMediaListener2.onVideoStart();
                    }
                }

                public void onVideoError() {
                    RecyclerAdMediaListener recyclerAdMediaListener2 = recyclerAdMediaListener;
                    if (recyclerAdMediaListener2 != null) {
                        recyclerAdMediaListener2.onVideoError();
                    }
                }
            });
            viewGroup.removeAllViews();
            viewGroup.addView(mediaView);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        PAGNativeAdData.PAGNativeMediaType mediaType;
        try {
            PAGNativeAd pAGNativeAd = this.pagNativeAd;
            return (pAGNativeAd == null || (mediaType = pAGNativeAd.getNativeAdData().getMediaType()) == PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeImage || mediaType != PAGNativeAdData.PAGNativeMediaType.PAGNativeMediaTypeVideo) ? 12 : 2;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        try {
            PAGNativeAd pAGNativeAd = this.pagNativeAd;
            if (pAGNativeAd != null) {
                return pAGNativeAd.getNativeAdData().getMediaView();
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
