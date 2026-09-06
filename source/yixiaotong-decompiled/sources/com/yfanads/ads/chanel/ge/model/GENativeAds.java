package com.yfanads.ads.chanel.ge.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.fancy.adsdk.lib.interf.NativeAdvertData;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AppInfo;
import com.yfanads.ads.chanel.ge.R;
import com.yfanads.android.core.render.api.YFAdVideoPlayConfig;
import com.yfanads.android.core.render.api.YFAppDownloadListener;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class GENativeAds extends YFAbsNativeAd {
    private NativeAdvertData adResponse;
    private PtgNativeExpressAd nativeExpressAd;

    public String getAdReqId() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    public GENativeAds(PtgNativeExpressAd ptgNativeExpressAd, YFNativeCall yFNativeCall) {
        super(yFNativeCall, 0);
        this.nativeExpressAd = ptgNativeExpressAd;
        this.adResponse = ptgNativeExpressAd.getAdvertData();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        return this.adResponse.getDesc();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        return this.adResponse.getTitle();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        return R.mipmap.ad_logo_ge_v1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        NativeAdvertData nativeAdvertData = this.adResponse;
        if (nativeAdvertData != null && !YFListUtils.isEmpty(nativeAdvertData.getImageList())) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.adResponse.getImageList().get(0).getImageUrl());
            return arrayList;
        }
        return new ArrayList();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        return this.adResponse.getLogo();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        AppInfo app = this.adResponse.getApp();
        if (app == null) {
            return "";
        }
        app.getDevelopers();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        AppInfo app = this.adResponse.getApp();
        if (app == null) {
            return "";
        }
        app.getPermissionProtocolUrl();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        AppInfo app = this.adResponse.getApp();
        if (app == null) {
            return "";
        }
        app.getFunctionDescUrl();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        AppInfo app = this.adResponse.getApp();
        if (app == null) {
            return "";
        }
        app.getPrivacyProtocolUrl();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        AppInfo app = this.adResponse.getApp();
        if (app == null) {
            return "";
        }
        app.getName();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        AppInfo app = this.adResponse.getApp();
        if (app == null) {
            return "";
        }
        app.getAppVersion();
        return "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(final YFNativeAd.VideoPlayListener videoPlayListener) {
        this.nativeExpressAd.setVideoAdListener(new PtgVideoAdListener() { // from class: com.yfanads.ads.chanel.ge.model.GENativeAds.1
            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public void onVideoProgressUpdate(long j, long j2) {
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public void onVideoStart() {
                videoPlayListener.onVideoPlayStart();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public void onVideoPause() {
                videoPlayListener.onVideoPlayPause();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public void onVideoResume() {
                videoPlayListener.onVideoPlayResume();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public void onVideoComplete() {
                videoPlayListener.onVideoPlayComplete();
            }

            @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
            public void onVideoError(int i, String str) {
                videoPlayListener.onVideoPlayError(i, -1);
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        return this.nativeExpressAd.getMediaView();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        return this.adResponse.getVideoCover();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        return this.adResponse.getWidth();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        return this.adResponse.getHeight();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        return this.adResponse.getButtonText();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        return this.nativeExpressAd.isVideo() ? 1 : 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        return this.nativeExpressAd.getInteractionType() == 0 ? 1 : 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        return (int) this.nativeExpressAd.getEcpm();
    }

    public void sendWinNotification(int i, int i2) {
        try {
            this.nativeExpressAd.notifyBidWin(i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendLossNotification(int i) {
        try {
            AdBidLossReason adBidLossReason = new AdBidLossReason();
            adBidLossReason.setLossCode(BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB);
            adBidLossReason.setWinPrice(i);
            adBidLossReason.setWinAdnId(BiddingConst.ADN_ID.LOSE_TO_OTHER_ADN);
            this.nativeExpressAd.notifyBidLoss(adBidLossReason);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, YFNativeAd.AdInteractionListener adInteractionListener) {
        YFLog.high("YlhNativeAds registerViewForInteraction " + hashCode() + "|size:" + (map != null ? map.size() : 0));
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<View> it = map.keySet().iterator();
        View next = null;
        while (true) {
            View view = next;
            while (true) {
                if (it.hasNext()) {
                    next = it.next();
                    Integer num = map.get(next);
                    YFLog.debug("YlhNativeAds registerViewForInteraction view:" + next + "|" + num);
                    if (num != null) {
                        int iIntValue = num.intValue();
                        if (iIntValue == 0) {
                            arrayList.add(next);
                        } else if (iIntValue == 1) {
                            arrayList2.add(next);
                        } else if (iIntValue != 2) {
                            if (iIntValue == 3) {
                                onFeedBack(activity.getFragmentManager(), next);
                            }
                        }
                    }
                } else {
                    registerXUViewForInteraction(viewGroup, arrayList, arrayList2, view, adInteractionListener);
                    return;
                }
            }
            handleClose(next, adInteractionListener);
        }
    }

    private void registerXUViewForInteraction(ViewGroup viewGroup, List<View> list, List<View> list2, View view, final YFNativeAd.AdInteractionListener adInteractionListener) {
        this.nativeExpressAd.setExpressInteractionListener(new PtgNativeExpressAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.ge.model.GENativeAds.2
            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public void onAdDismiss() {
                YFLog.debug("xu native onAdDismiss");
                GENativeAds.this.handleClose(adInteractionListener);
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked() {
                YFLog.debug("xu native onAdClicked");
                GENativeAds.this.handleClick(adInteractionListener);
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow() {
                YFLog.debug("xu native onAdShow");
                GENativeAds.this.handleExposure(adInteractionListener);
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(AdError adError) {
                YFLog.debug("xu native onRenderFail " + adError.getMessage());
            }

            @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view2) {
                YFLog.debug("xu native onRenderSuccess " + view2);
            }
        });
        this.nativeExpressAd.registerAdvertViews(viewGroup, list, list2, view);
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
        NativeAdvertData nativeAdvertData = this.adResponse;
        if (nativeAdvertData != null) {
            nativeAdvertData.destroy();
            this.adResponse = null;
        }
        PtgNativeExpressAd ptgNativeExpressAd = this.nativeExpressAd;
        if (ptgNativeExpressAd != null) {
            ptgNativeExpressAd.destroy();
            this.nativeExpressAd = null;
        }
    }
}
