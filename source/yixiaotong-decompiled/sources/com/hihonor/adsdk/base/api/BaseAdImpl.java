package com.hihonor.adsdk.base.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.DetailPageCtrl;
import com.hihonor.adsdk.base.bean.Style;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.callback.AdListener;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BaseAdImpl implements BaseAd, Parcelable {
    public static final Parcelable.Creator<BaseAdImpl> CREATOR = new a();
    private final List<String> DEFAULT_IMAGES = new ArrayList();
    private final TrackUrl DEFAULT_TRACK_URL = new TrackUrl();
    protected BaseAdInfo hnadsd;
    protected transient AdListener hnadse;
    protected int hnadsf;

    class a implements Parcelable.Creator<BaseAdImpl> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public BaseAdImpl createFromParcel(Parcel parcel) {
            return new BaseAdImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public BaseAdImpl[] newArray(int i) {
            return new BaseAdImpl[i];
        }
    }

    public BaseAdImpl(BaseAdInfo baseAdInfo) {
        this.hnadsd = baseAdInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public AdListener getAdListener() {
        return this.hnadse;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getDetailPageOpenMode() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return (baseAdInfo == null || baseAdInfo.getDetailPageOpenMode() != 1) ? 0 : 1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public List<String> getImages() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return (baseAdInfo == null || baseAdInfo.getImgUrls() == null) ? this.DEFAULT_IMAGES : this.hnadsd.getImgUrls();
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getItemPosition() {
        return this.hnadsf;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public float getProportion() {
        if (getImgHeight() == 0 || getImgWidth() == 0) {
            return 0.0f;
        }
        return (getImgWidth() * 1.0f) / getImgHeight();
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getTitle() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return (baseAdInfo == null || baseAdInfo.getTitle() == null) ? "" : this.hnadsd.getTitle();
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public TrackUrl getTrackUrl() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return (baseAdInfo == null || baseAdInfo.getTrackUrl() == null) ? this.DEFAULT_TRACK_URL : this.hnadsd.getTrackUrl();
    }

    public BaseAdInfo hnadsa() {
        return this.hnadsd;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public boolean isMediaUseCustomVideo() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public void setAdListener(AdListener adListener) {
        com.hihonor.adsdk.common.b.b.hnadsc("BaseAdImpl", "BaseAdImpl setAdListener " + adListener, new Object[0]);
        this.hnadse = adListener;
    }

    public void setItemPosition(int i) {
        this.hnadsf = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.hnadsf);
        parcel.writeParcelable(this.hnadsd, 0);
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getActionTips() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getActionTips() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getActionType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getActionType() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getAdFlag() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getAdFlag();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getAdFlagFontSize() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getAdFlagFontSize();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getAdId() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getAdId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getAdSpecTemplateType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getAdSpecTemplateType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getAdType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getAdType();
        }
        return -1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getAdUnitId() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getAdUnitId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getAppIntro() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getAppIntro() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getAppPackage() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getAppPackage() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getAppVersion() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getAppVersion() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getBrand() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getBrand() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getBrandFontSize() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getBrandFontSize();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getButtonText() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getButtonText() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getChannelInfo() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getChannelInfo() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getCloseFlag() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getCloseFlag();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getCreativeTemplateId() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getCreativeTemplateId();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getDataType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getDataType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getDeeplinkUrl() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getDeeplinkUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public DetailPageCtrl getDetailPageCtrl() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getDetailPageCtrl();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getDetailType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getDetailType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getDeveloperName() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getDeveloperName();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getDownloadType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getDownloadType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getDpPackageName() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getDpPackageName();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getExtraJson() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getExtraJson() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getForwardInterval() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getForwardInterval();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getHomePage() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getHomePage() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getImgHeight() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getImgHeight();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getImgWidth() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getImgWidth();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getImpDuration() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getImpDuration();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getInstallPkgType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getInstallPkgType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getInteractType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getInteractType();
        }
        return -1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getIntroUrl() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getIntroUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getLandingPageType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getLandingPageType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getLandingPageUrl() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getLandingPageUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getLogo() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getLogo() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getMiniProgramId() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getMiniProgramId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getMiniProgramPath() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getMiniProgramPath() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getMiniProgramType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getMiniProgramType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getNewLandingPageType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getNewLandingPageType();
        }
        return -1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getOrientation() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getOrientation();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getPackageUrl() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getPackageUrl() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getPartner() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getPartner() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getPermissionsUrl() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getPermissionsUrl();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getPkgSign() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getPkgSign() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public long getPkgSizeBytes() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getPkgSizeBytes();
        }
        return 0L;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getPkgType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getPkgType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getPrivacyAgreementUrl() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getPrivacyAgreementUrl();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getPromotionPurpose() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getPromotionPurpose();
        }
        return -1;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getRequestId() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getAdRequestId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getSequence() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getSequence();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public double getShakeAcc() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getShakeAcc();
        }
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public double getShakeAngle() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getShakeAngle();
        }
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public double getShakeDuration() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getShakeDuration();
        }
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getSifSign() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getSifSign() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getSkipFontSize() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getSkipFontSize();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getStoreChannel() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getStoreChannel() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public Style getStyle() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getStyle();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getSubChannel() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getSubChannel() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public int getSubType() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getSubType();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getTargetTips() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getTargetTips() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getTemplateId() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? baseAdInfo.getTemplateId() : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public long getTs() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getTs();
        }
        return 0L;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getUnInstallFilter() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null ? String.valueOf(baseAdInfo.getUninstalleFilter()) : "";
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public Video getVideo() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getVideo();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public String getWechatExtInfo() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        if (baseAdInfo != null) {
            return baseAdInfo.getWechatExtInfo();
        }
        return null;
    }

    @Override // com.hihonor.adsdk.base.api.BaseAd
    public boolean isCarousel() {
        BaseAdInfo baseAdInfo = this.hnadsd;
        return baseAdInfo != null && baseAdInfo.getIsCarousel() == 1;
    }

    protected BaseAdImpl(Parcel parcel) {
        this.hnadsf = parcel.readInt();
        this.hnadsd = (BaseAdInfo) parcel.readParcelable(BaseAdImpl.class.getClassLoader());
    }
}
