package com.meishu.sdk.platform.sigmob.custom.feed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd;
import com.sigmob.sdk.base.models.SigImage;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.natives.NativeADEventListener;
import com.sigmob.windad.natives.WindNativeAdData;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomNativeAd extends MsCustomRecyclerFeedAd {
    private MsCustomRecyclerAdapter adWrapper;
    private WindNativeAdData windNativeAdData;

    public SigmobCustomNativeAd(MsCustomRecyclerAdapter msCustomRecyclerAdapter, WindNativeAdData windNativeAdData) {
        super(msCustomRecyclerAdapter);
        this.adWrapper = msCustomRecyclerAdapter;
        this.windNativeAdData = windNativeAdData;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return null;
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData == null || windNativeAdData.getAdAppInfo() == null) {
            return null;
        }
        return this.windNativeAdData.getAdAppInfo().getDescriptionUrl();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData == null || windNativeAdData.getAdAppInfo() == null) {
            return null;
        }
        return this.windNativeAdData.getAdAppInfo().getAppName();
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData == null || windNativeAdData.getAdAppInfo() == null) {
            return null;
        }
        return this.windNativeAdData.getAdAppInfo().getPrivacyAgreementUrl();
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData == null || windNativeAdData.getAdAppInfo() == null) {
            return null;
        }
        return ((this.windNativeAdData.getAdAppInfo().getAppSize() / 1024) * 1024) + "MB";
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData == null || windNativeAdData.getAdAppInfo() == null) {
            return null;
        }
        return this.windNativeAdData.getAdAppInfo().getVersionName();
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData == null || windNativeAdData.getAdAppInfo() == null) {
            return null;
        }
        return this.windNativeAdData.getAdAppInfo().getAuthorName();
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
    public int getInteractionType() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        return null;
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd, com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData == null || windNativeAdData.getAdAppInfo() == null) {
            return null;
        }
        return this.windNativeAdData.getAdAppInfo().getPrivacyAgreement();
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
    public void replay() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
    }

    @Override // com.meishu.sdk.platform.custom.recycler.MsCustomRecyclerFeedAd
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list) {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            windNativeAdData.bindViewForInteraction(viewGroup, list, list, (View) null, new NativeADEventListener() { // from class: com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomNativeAd.2
                public void onAdClicked() {
                    if (SigmobCustomNativeAd.this.adWrapper != null) {
                        SigmobCustomNativeAd.this.adWrapper.onFeedAdClicked(SigmobCustomNativeAd.this);
                    }
                }

                public void onAdDetailDismiss() {
                }

                public void onAdDetailShow() {
                }

                public void onAdError(WindAdError windAdError) {
                }

                public void onAdExposed() {
                    if (SigmobCustomNativeAd.this.adWrapper != null) {
                        SigmobCustomNativeAd.this.adWrapper.onFeedAdExposure(SigmobCustomNativeAd.this);
                    }
                }
            });
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            windNativeAdData.bindMediaView(viewGroup, new WindNativeAdData.NativeADMediaListener() { // from class: com.meishu.sdk.platform.sigmob.custom.feed.SigmobCustomNativeAd.1
                public void onVideoCompleted() {
                }

                public void onVideoError(WindAdError windAdError) {
                }

                public void onVideoLoad() {
                }

                public void onVideoPause() {
                }

                public void onVideoResume() {
                }

                public void onVideoStart() {
                }
            });
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            windNativeAdData.destroy();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            int adPatternType = windNativeAdData.getAdPatternType();
            if (adPatternType == 1) {
                return 2;
            }
            if (adPatternType != 2 && adPatternType == 3) {
                return 13;
            }
        }
        return 12;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            return windNativeAdData.getDesc();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            return windNativeAdData.getDesc();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            return windNativeAdData.getIconUrl();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        try {
            WindNativeAdData windNativeAdData = this.windNativeAdData;
            if (windNativeAdData != null && windNativeAdData.getImageList() != null) {
                try {
                    Class.forName("com.sigmob.sdk.base.models.SigImage");
                    List imageList = this.windNativeAdData.getImageList();
                    String[] strArr = new String[imageList.size()];
                    for (int i = 0; i < imageList.size(); i++) {
                        strArr[i] = ((SigImage) imageList.get(i)).getImageUrl();
                    }
                    return strArr;
                } catch (ClassNotFoundException unused) {
                    return (String[]) this.windNativeAdData.getImageList().toArray(new String[0]);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new String[0];
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            return windNativeAdData.getTitle();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            windNativeAdData.pauseVideo();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            windNativeAdData.resumeVideo();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void startVideo() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            windNativeAdData.startVideo();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
        WindNativeAdData windNativeAdData = this.windNativeAdData;
        if (windNativeAdData != null) {
            windNativeAdData.stopVideo();
        }
    }
}
