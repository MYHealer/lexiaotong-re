package com.hihonor.adsdk.base.api;

import android.view.View;
import com.hihonor.adsdk.base.bean.Style;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.callback.DislikeItemClickListener;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface BaseExpressAd {
    int getAdFlag();

    String getAdId();

    AdListener getAdListener();

    int getAdSpecTemplateType();

    int getAdType();

    String getAdnId();

    String getAdnType();

    String getAppIntro();

    String getAppPackage();

    String getAppVersion();

    String getBrand();

    String getButtonText();

    String getChannelInfo();

    int getCloseFlag();

    int getCreativeTemplateId();

    int getDataType();

    int getDetailPageOpenMode();

    String getDeveloperName();

    String getDpPackageName();

    long getEcpm();

    View getExpressAdView();

    String getExtraJson();

    String getHomePage();

    List<String> getImages();

    int getImgHeight();

    int getImgWidth();

    List<Integer> getIncentivePoints();

    int getInstallPkgType();

    int getInteractType();

    String getIntroUrl();

    int getItemPosition();

    String getLandingPageUrl();

    int getLevel();

    String getLogo();

    String getPermissionsUrl();

    String getPkgSign();

    long getPkgSizeBytes();

    int getPkgType();

    String getPrivacyAgreementUrl();

    int getPromotionPurpose();

    float getProportion();

    String getRequestId();

    int getSequence();

    String getStoreChannel();

    Style getStyle();

    String getSubChannel();

    int getSubType();

    String getTemplateId();

    String getTitle();

    TrackUrl getTrackUrl();

    String getUnInstallFilter();

    long getUseTime();

    boolean isDownload();

    void release();

    void sendLossNotification(long j, int i, String str);

    void sendWinNotification(long j);

    void setAdListener(AdListener adListener);

    void setAdnId(String str);

    void setDislikeClickListener(DislikeItemClickListener dislikeItemClickListener);

    void setItemPosition(int i);

    void setLevel(int i);

    void setRenderType(int i);

    void setUseTime(long j);

    void unUseAd(int i, String str);
}
