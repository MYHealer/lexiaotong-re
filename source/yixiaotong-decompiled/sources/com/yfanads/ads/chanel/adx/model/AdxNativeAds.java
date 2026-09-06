package com.yfanads.ads.chanel.adx.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.stub.StubApp;
import com.yfanads.ads.R;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.core.model.AdxImage;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.adx.service.a;
import com.yfanads.android.core.render.YFNativeAdView;
import com.yfanads.android.core.render.api.YFAdVideoPlayConfig;
import com.yfanads.android.core.render.api.YFAppDownloadListener;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.YFConfigUtils;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxNativeAds extends YFAbsNativeAd {
    private boolean isDownloadDialogShow;
    private boolean isShakeAction;
    private boolean isShakeActionOne;
    private AdxNativeAd nativeAd;
    private TemplateConf templateConf;
    private YFNativeAd.VideoPlayListener videoPlayListener;

    public AdxNativeAds(AdxNativeAd adxNativeAd, TemplateConf templateConf, YFNativeCall yFNativeCall) {
        super(yFNativeCall);
        this.templateConf = templateConf;
        this.nativeAd = adxNativeAd;
    }

    private boolean isVideo() {
        return getMaterialType() == 1;
    }

    private boolean needUpdateAction() {
        return this.isShakeAction && this.isShakeActionOne;
    }

    private void registerAdxViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, final YFNativeAd.AdInteractionListener adInteractionListener) {
        final BaseTemplateData baseTemplateData = new BaseTemplateData("");
        baseTemplateData.setConf(this.templateConf);
        updateShakeAction(baseTemplateData);
        View childAt = viewGroup.getChildCount() > 0 ? viewGroup.getChildAt(0) : null;
        boolean booleanValue = YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true);
        boolean z = childAt instanceof YFNativeAdView;
        if (z && booleanValue) {
            if (baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.SHAKE) {
                map.put(childAt, 1);
            } else if (baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.TWIST) {
                map.put(childAt, 2);
            }
        }
        YFLog.debug("registerAdxViewForInteraction " + baseTemplateData.getActiveStyle() + " isSupportShake " + (z && booleanValue));
        final Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        this.nativeAd.registerViewForInteraction(activity, a.NATIVE, viewGroup, map, new AdxNativeAd.InteractionConf(false, baseTemplateData), new AdxNativeAd.AdInteractionListener() { // from class: com.yfanads.ads.chanel.adx.model.AdxNativeAds.2
            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onAdClickedSuccess(boolean z2, boolean z3, boolean z4) {
                if (!z3 || AdxNativeAds.this.isDownloadDialogShow) {
                    return;
                }
                AdxNativeAds.this.downLoadToast(origApplicationContext);
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onAdHide() {
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onAdShakeCancel() {
                AdxNativeAds.this.updActionShake(baseTemplateData);
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onAdShakeSuccess(boolean z2, boolean z3, boolean z4) {
                YFLog.high("onAdClickedSuccess " + z2 + "|" + z3);
                AdxNativeAds.this.updActionShake(baseTemplateData);
                if (!z3 || AdxNativeAds.this.isDownloadDialogShow) {
                    return;
                }
                AdxNativeAds.this.downLoadToast(origApplicationContext);
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onAdShow() {
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onDownloadTipsDismiss() {
                AdxNativeAds.this.isDownloadDialogShow = false;
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onDownloadTipsShow() {
                AdxNativeAds.this.isDownloadDialogShow = true;
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onExposure(boolean z2) {
                if (z2) {
                    AdxNativeAds.this.handleExposure(adInteractionListener);
                } else {
                    AdxNativeAds.this.handleFailed(YFAdError.ERROR_ADX_EXPOSURE, "exposure url empty");
                }
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.AdInteractionListener
            public void onHandleClick(boolean z2) {
                AdxNativeAds.this.handleClick(adInteractionListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updActionShake(BaseTemplateData baseTemplateData) {
        try {
            if (needUpdateAction()) {
                baseTemplateData.resetActivityStyle(BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER.getValue());
                updateShakeAction(baseTemplateData);
                this.nativeAd.unRegisterViewAction();
            }
        } catch (Exception e) {
            YFLog.error(" updActionShake error" + e.getMessage());
        }
    }

    private void updateShakeAction(BaseTemplateData baseTemplateData) {
        this.isShakeActionOne = baseTemplateData.isActionOne();
        this.isShakeAction = baseTemplateData.isShake() || baseTemplateData.isTwist();
    }

    public void downLoadToast(Context context) {
        try {
            Toast.makeText(context, context.getString(R.string.yf_download_toast), 0).show();
        } catch (Exception e) {
            YFLog.error(" downLoadToast error" + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getActionDescription() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getActionDescription() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdDescription() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getAdDescription() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getAdSourceLogo() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getAdSourceLogoUrl(0) : com.yfanads.android.adx.R.mipmap.yf_ad_logo_v1;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAdTitle() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getTitle() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppIconUrl() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getAppIconUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppName() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getAppName() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppPrivacyUrl() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getAppPrivacyUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getAppVersion() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getAppVersion() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getBrandName() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getProductName() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getCorporationName() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getCorporationName() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getECPM() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd != null) {
            return adxNativeAd.getECPM();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public List<String> getImageList() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd == null || YFListUtils.isEmpty(adxNativeAd.getImageList())) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<AdxImage> it = this.nativeAd.getImageList().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getImageUrl());
        }
        return arrayList;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getInteractionType() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd != null) {
            return adxNativeAd.getInteractionType();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getIntroductionInfoUrl() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getIntroductionInfoUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getMaterialType() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd != null) {
            return adxNativeAd.getMaterialType();
        }
        return 2;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getPermissionInfoUrl() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return adxNativeAd != null ? adxNativeAd.getPermissionInfoUrl() : "";
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public String getVideoCoverImage() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        return (adxNativeAd == null || adxNativeAd.getVideoCoverImage() == null) ? "" : this.nativeAd.getVideoCoverImage().getImageUrl();
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoHeight() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd != null) {
            return adxNativeAd.getVideoHeight();
        }
        return 0;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public View getVideoView(Context context, YFAdVideoPlayConfig yFAdVideoPlayConfig) {
        AdVideoPlayConfig adVideoPlayConfigBuild = new AdVideoPlayConfig.Builder().videoAutoPlayType(1).videoSoundEnable(yFAdVideoPlayConfig != null && yFAdVideoPlayConfig.isVideoSoundEnable()).build();
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd != null) {
            return adxNativeAd.getVideoView(context, adVideoPlayConfigBuild);
        }
        return null;
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public int getVideoWidth() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd != null) {
            return adxNativeAd.getVideoWidth();
        }
        return 0;
    }

    /* JADX INFO: renamed from: lambda$registerViewForInteraction$0$com-yfanads-ads-chanel-adx-model-AdxNativeAds, reason: not valid java name */
    /* synthetic */ void m1042x7e14964a(YFNativeAd.AdInteractionListener adInteractionListener, View view) {
        AdxNativeAd adxNativeAd;
        if (isVideo() && (adxNativeAd = this.nativeAd) != null) {
            adxNativeAd.reportAdInfo(18, null);
        }
        handleClose(adInteractionListener);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void registerViewForInteraction(Activity activity, ViewGroup viewGroup, Map<View, Integer> map, final YFNativeAd.AdInteractionListener adInteractionListener) {
        if (YFListUtils.isMapEmpty(map)) {
            return;
        }
        HashMap map2 = new HashMap();
        for (View view : map.keySet()) {
            Integer num = map.get(view);
            if (num != null) {
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    map2.put(view, 4);
                } else if (iIntValue == 1) {
                    map2.put(view, 5);
                } else if (iIntValue == 2) {
                    view.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.ads.chanel.adx.model.AdxNativeAds$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            this.f$0.m1042x7e14964a(adInteractionListener, view2);
                        }
                    });
                } else if (iIntValue == 3) {
                    onFeedBack(activity.getFragmentManager(), view);
                }
            }
        }
        registerAdxViewForInteraction(activity, viewGroup, map2, adInteractionListener);
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setBidEcpm(long j) {
        try {
            this.nativeAd.setBidEcpm(j, j);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setDownloadListener(YFAppDownloadListener yFAppDownloadListener) {
    }

    @Override // com.yfanads.android.core.render.api.BaseKSAd
    public void onDestroy() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd != null) {
            adxNativeAd.destroy(a.NATIVE);
            this.nativeAd = null;
        }
    }

    public void reportAdInfo() {
        AdxNativeAd adxNativeAd = this.nativeAd;
        if (adxNativeAd != null) {
            adxNativeAd.reportAdInfo(19, null);
        }
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void setVideoPlayListener(final YFNativeAd.VideoPlayListener videoPlayListener) {
        this.videoPlayListener = videoPlayListener;
        this.nativeAd.setVideoPlayListener(new AdxNativeAd.VideoPlayListener() { // from class: com.yfanads.ads.chanel.adx.model.AdxNativeAds.1
            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayComplete() {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayComplete();
                }
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayError(int i, int i2) {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayError(i, i2);
                }
            }

            @Override // com.yfanads.android.adx.core.model.AdxNativeAd.VideoPlayListener
            public void onVideoPlayStart() {
                YFNativeAd.VideoPlayListener videoPlayListener2 = videoPlayListener;
                if (videoPlayListener2 != null) {
                    videoPlayListener2.onVideoPlayStart();
                }
            }
        });
    }
}
