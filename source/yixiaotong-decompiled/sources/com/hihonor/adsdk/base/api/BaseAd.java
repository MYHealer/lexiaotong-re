package com.hihonor.adsdk.base.api;

import android.os.Parcelable;
import com.hihonor.adsdk.base.bean.DetailPageCtrl;
import com.hihonor.adsdk.base.bean.Style;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.callback.AdListener;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface BaseAd extends Parcelable {
    String getActionTips();

    String getActionType();

    int getAdFlag();

    int getAdFlagFontSize();

    String getAdId();

    AdListener getAdListener();

    int getAdSpecTemplateType();

    int getAdType();

    String getAdUnitId();

    String getAppIntro();

    String getAppPackage();

    String getAppVersion();

    String getBrand();

    int getBrandFontSize();

    String getButtonText();

    String getChannelInfo();

    int getCloseFlag();

    int getCreativeTemplateId();

    int getDataType();

    String getDeeplinkUrl();

    DetailPageCtrl getDetailPageCtrl();

    int getDetailPageOpenMode();

    int getDetailType();

    String getDeveloperName();

    int getDownloadType();

    String getDpPackageName();

    String getExtraJson();

    int getForwardInterval();

    String getHomePage();

    List<String> getImages();

    int getImgHeight();

    int getImgWidth();

    int getImpDuration();

    int getInstallPkgType();

    int getInteractType();

    String getIntroUrl();

    int getItemPosition();

    int getLandingPageType();

    String getLandingPageUrl();

    String getLogo();

    String getMiniProgramId();

    String getMiniProgramPath();

    int getMiniProgramType();

    int getNewLandingPageType();

    int getOrientation();

    String getPackageUrl();

    String getPartner();

    String getPermissionsUrl();

    String getPkgSign();

    long getPkgSizeBytes();

    int getPkgType();

    String getPrivacyAgreementUrl();

    int getPromotionPurpose();

    float getProportion();

    String getRequestId();

    int getSequence();

    double getShakeAcc();

    double getShakeAngle();

    double getShakeDuration();

    String getSifSign();

    int getSkipFontSize();

    String getStoreChannel();

    Style getStyle();

    String getSubChannel();

    int getSubType();

    String getTargetTips();

    String getTemplateId();

    String getTitle();

    TrackUrl getTrackUrl();

    long getTs();

    String getUnInstallFilter();

    Video getVideo();

    String getWechatExtInfo();

    boolean isCarousel();

    boolean isMediaUseCustomVideo();

    void setAdListener(AdListener adListener);
}
