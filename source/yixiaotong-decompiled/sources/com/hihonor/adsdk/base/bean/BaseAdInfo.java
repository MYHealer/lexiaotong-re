package com.hihonor.adsdk.base.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BaseAdInfo implements Parcelable {
    public static final Parcelable.Creator<BaseAdInfo> CREATOR = new a();
    protected String actionTips;
    protected String actionType;
    protected int adFlag;
    protected int adFlagFontSize;
    protected String adId;
    protected List<Integer> adPositionSets;
    protected String adRequestId;
    protected int adSpecTemplateType;
    protected int adType;
    protected String adUnitId;
    protected String appIconUrl;
    protected String appIntro;
    protected String appName;
    protected String appPackage;
    protected String appVersion;
    protected String brand;
    protected int brandFontSize;
    protected String buttonText;
    protected String channelInfo;
    protected int closeFlag;
    protected int creativeTemplateId;
    protected int dataType;
    protected String deeplinkUrl;
    protected DetailPageCtrl detailPageCtrl;
    protected int detailPageOpenMode;
    protected int detailType;
    protected String developerName;
    protected int downloadType;
    protected String dpPackageName;
    protected long expirationTime;
    protected String extraJson;
    protected int forwardInterval;
    protected String homePage;
    protected long id;
    protected int imgHeight;
    protected List<String> imgUrls;
    protected int imgWidth;
    protected int impDuration;
    protected int incentiveFlag;
    protected List<Integer> incentivePoints;
    protected int installPkgType;
    protected int interactType;
    protected String introUrl;
    protected int isCarousel;
    protected int landingPageType;
    protected String landingPageUrl;
    protected String logo;
    protected String miniProgramId;
    protected String miniProgramPath;
    protected int miniProgramType;
    protected int newLandingPageType;
    protected int orientation;
    protected String packageUrl;
    protected String partner;
    protected String permissionsUrl;
    protected String pkgSign;
    protected long pkgSizeBytes;
    protected int pkgType;
    protected long price;
    protected String privacyAgreementUrl;
    protected int promotionPurpose;
    protected long responseTimeMillis;
    protected int sequence;
    protected double shakeAcc;
    protected double shakeAngle;
    protected double shakeDuration;
    protected String sifSign;
    protected int skipFontSize;
    protected String storeChannel;
    protected Style style;
    protected String subChannel;
    protected String subTitle;
    protected int subType;
    protected String targetTips;
    protected String templateId;
    protected String title;
    protected TrackUrl trackUrl;
    protected long ts;
    protected int uninstalleFilter;
    protected Video video;
    protected String videoUrl;
    public String wechatExtInfo;

    class a implements Parcelable.Creator<BaseAdInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public BaseAdInfo createFromParcel(Parcel parcel) {
            return new BaseAdInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
        public BaseAdInfo[] newArray(int i) {
            return new BaseAdInfo[i];
        }
    }

    public BaseAdInfo() {
        this.pkgType = 0;
        this.landingPageType = 2;
        this.newLandingPageType = -1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActionTips() {
        return this.actionTips;
    }

    public String getActionType() {
        return this.actionType;
    }

    public int getAdFlag() {
        return this.adFlag;
    }

    public int getAdFlagFontSize() {
        return this.adFlagFontSize;
    }

    public String getAdId() {
        return this.adId;
    }

    public List<Integer> getAdPositionSets() {
        return this.adPositionSets;
    }

    public String getAdRequestId() {
        return this.adRequestId;
    }

    public int getAdSpecTemplateType() {
        return this.adSpecTemplateType;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getAppIconUrl() {
        return this.appIconUrl;
    }

    public String getAppIntro() {
        return this.appIntro;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getBrandFontSize() {
        return this.brandFontSize;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getChannelInfo() {
        return this.channelInfo;
    }

    public int getCloseFlag() {
        return this.closeFlag;
    }

    public int getCreativeTemplateId() {
        return this.creativeTemplateId;
    }

    public int getDataType() {
        return this.dataType;
    }

    public String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public DetailPageCtrl getDetailPageCtrl() {
        return this.detailPageCtrl;
    }

    public int getDetailPageOpenMode() {
        return this.detailPageOpenMode;
    }

    public int getDetailType() {
        return this.detailType;
    }

    public String getDeveloperName() {
        return this.developerName;
    }

    public int getDownloadType() {
        return this.downloadType;
    }

    public String getDpPackageName() {
        return this.dpPackageName;
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public String getExtraJson() {
        return this.extraJson;
    }

    public int getForwardInterval() {
        return this.forwardInterval;
    }

    public String getHomePage() {
        return this.homePage;
    }

    public long getId() {
        return this.id;
    }

    public int getImgHeight() {
        return this.imgHeight;
    }

    public List<String> getImgUrls() {
        return this.imgUrls;
    }

    public int getImgWidth() {
        return this.imgWidth;
    }

    public int getImpDuration() {
        return this.impDuration;
    }

    public int getIncentiveFlag() {
        return this.incentiveFlag;
    }

    public List<Integer> getIncentivePoints() {
        return this.incentivePoints;
    }

    public int getInstallPkgType() {
        return this.installPkgType;
    }

    public int getInteractType() {
        return this.interactType;
    }

    public String getIntroUrl() {
        return this.introUrl;
    }

    public int getIsCarousel() {
        return this.isCarousel;
    }

    public int getLandingPageType() {
        return this.landingPageType;
    }

    public String getLandingPageUrl() {
        return this.landingPageUrl;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getMiniProgramId() {
        return this.miniProgramId;
    }

    public String getMiniProgramPath() {
        return this.miniProgramPath;
    }

    public int getMiniProgramType() {
        return this.miniProgramType;
    }

    public int getNewLandingPageType() {
        return this.newLandingPageType;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public String getPackageUrl() {
        return this.packageUrl;
    }

    public String getPartner() {
        return this.partner;
    }

    public String getPermissionsUrl() {
        return this.permissionsUrl;
    }

    public String getPkgSign() {
        return this.pkgSign;
    }

    public long getPkgSizeBytes() {
        return this.pkgSizeBytes;
    }

    public int getPkgType() {
        return this.pkgType;
    }

    public long getPrice() {
        return this.price;
    }

    public String getPrivacyAgreementUrl() {
        return this.privacyAgreementUrl;
    }

    public int getPromotionPurpose() {
        return this.promotionPurpose;
    }

    public long getResponseTimeMillis() {
        return this.responseTimeMillis;
    }

    public int getSequence() {
        return this.sequence;
    }

    public double getShakeAcc() {
        return this.shakeAcc;
    }

    public double getShakeAngle() {
        return this.shakeAngle;
    }

    public double getShakeDuration() {
        return this.shakeDuration;
    }

    public String getSifSign() {
        return this.sifSign;
    }

    public int getSkipFontSize() {
        return this.skipFontSize;
    }

    public String getStoreChannel() {
        return this.storeChannel;
    }

    public Style getStyle() {
        return this.style;
    }

    public String getSubChannel() {
        return this.subChannel;
    }

    public String getSubTitle() {
        return this.subTitle;
    }

    public int getSubType() {
        return this.subType;
    }

    public String getTargetTips() {
        return this.targetTips;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public String getTitle() {
        return this.title;
    }

    public TrackUrl getTrackUrl() {
        return this.trackUrl;
    }

    public long getTs() {
        return this.ts;
    }

    public int getUninstalleFilter() {
        return this.uninstalleFilter;
    }

    public Video getVideo() {
        return this.video;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }

    public String getWechatExtInfo() {
        return this.wechatExtInfo;
    }

    public boolean isExpired(long j) {
        return this.expirationTime * 1000 < j;
    }

    public void setActionTips(String str) {
        this.actionTips = str;
    }

    public void setActionType(String str) {
        this.actionType = str;
    }

    public void setAdFlag(int i) {
        this.adFlag = i;
    }

    public void setAdFlagFontSize(int i) {
        this.adFlagFontSize = i;
    }

    public void setAdId(String str) {
        this.adId = str;
    }

    public void setAdPositionSets(List<Integer> list) {
        this.adPositionSets = list;
    }

    public void setAdRequestId(String str) {
        this.adRequestId = str;
    }

    public void setAdSpecTemplateType(int i) {
        this.adSpecTemplateType = i;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAdUnitId(String str) {
        this.adUnitId = str;
    }

    public void setAppIconUrl(String str) {
        this.appIconUrl = str;
    }

    public void setAppIntro(String str) {
        this.appIntro = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setBrandFontSize(int i) {
        this.brandFontSize = i;
    }

    public void setButtonText(String str) {
        this.buttonText = str;
    }

    public void setChannelInfo(String str) {
        this.channelInfo = str;
    }

    public void setCloseFlag(int i) {
        this.closeFlag = i;
    }

    public void setCreativeTemplateId(int i) {
        this.creativeTemplateId = i;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }

    public void setDeeplinkUrl(String str) {
        this.deeplinkUrl = str;
    }

    public void setDetailPageCtrl(DetailPageCtrl detailPageCtrl) {
        this.detailPageCtrl = detailPageCtrl;
    }

    public void setDetailPageOpenMode(int i) {
        this.detailPageOpenMode = i;
    }

    public void setDetailType(int i) {
        this.detailType = i;
    }

    public void setDeveloperName(String str) {
        this.developerName = str;
    }

    public void setDownloadType(int i) {
        this.downloadType = i;
    }

    public void setDpPackageName(String str) {
        this.dpPackageName = str;
    }

    public void setExpirationTime(long j) {
        this.expirationTime = j;
    }

    public void setExtraJson(String str) {
        this.extraJson = str;
    }

    public void setForwardInterval(int i) {
        this.forwardInterval = i;
    }

    public void setHomePage(String str) {
        this.homePage = str;
    }

    public void setId(long j) {
        this.id = j;
    }

    public void setImgHeight(int i) {
        this.imgHeight = i;
    }

    public void setImgUrls(List<String> list) {
        this.imgUrls = list;
    }

    public void setImgWidth(int i) {
        this.imgWidth = i;
    }

    public void setImpDuration(int i) {
        this.impDuration = i;
    }

    public void setIncentiveFlag(int i) {
        this.incentiveFlag = i;
    }

    public void setIncentivePoints(List<Integer> list) {
        this.incentivePoints = list;
    }

    public void setInstallPkgType(int i) {
        this.installPkgType = i;
    }

    public void setInteractType(int i) {
        this.interactType = i;
    }

    public void setIntroUrl(String str) {
        this.introUrl = str;
    }

    public void setIsCarousel(int i) {
        this.isCarousel = i;
    }

    public void setLandingPageType(int i) {
        this.landingPageType = i;
    }

    public void setLandingPageUrl(String str) {
        this.landingPageUrl = str;
    }

    public void setLogo(String str) {
        this.logo = str;
    }

    public void setMiniProgramId(String str) {
        this.miniProgramId = str;
    }

    public void setMiniProgramPath(String str) {
        this.miniProgramPath = str;
    }

    public void setMiniProgramType(int i) {
        this.miniProgramType = i;
    }

    public void setNewLandingPageType(int i) {
        this.newLandingPageType = i;
    }

    public void setOrientation(int i) {
        this.orientation = i;
    }

    public void setPackageUrl(String str) {
        this.packageUrl = str;
    }

    public void setPartner(String str) {
        this.partner = str;
    }

    public void setPermissionsUrl(String str) {
        this.permissionsUrl = str;
    }

    public void setPkgSign(String str) {
        this.pkgSign = str;
    }

    public void setPkgSizeBytes(long j) {
        this.pkgSizeBytes = j;
    }

    public void setPkgType(int i) {
        this.pkgType = i;
    }

    public void setPrice(long j) {
        this.price = j;
    }

    public void setPrivacyAgreementUrl(String str) {
        this.privacyAgreementUrl = str;
    }

    public void setPromotionPurpose(int i) {
        this.promotionPurpose = i;
    }

    public void setResponseTimeMillis(long j) {
        this.responseTimeMillis = j;
    }

    public void setSequence(int i) {
        this.sequence = i;
    }

    public void setShakeAcc(double d) {
        this.shakeAcc = d;
    }

    public void setShakeAngle(double d) {
        this.shakeAngle = d;
    }

    public void setShakeDuration(double d) {
        this.shakeDuration = d;
    }

    public void setSifSign(String str) {
        this.sifSign = str;
    }

    public void setSkipFontSize(int i) {
        this.skipFontSize = i;
    }

    public void setStoreChannel(String str) {
        this.storeChannel = str;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public void setSubChannel(String str) {
        this.subChannel = str;
    }

    public void setSubTitle(String str) {
        this.subTitle = str;
    }

    public void setSubType(int i) {
        this.subType = i;
    }

    public void setTargetTips(String str) {
        this.targetTips = str;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTrackUrl(TrackUrl trackUrl) {
        this.trackUrl = trackUrl;
    }

    public void setTs(long j) {
        this.ts = j;
    }

    public void setUninstalleFilter(int i) {
        this.uninstalleFilter = i;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    public void setWechatExtInfo(String str) {
        this.wechatExtInfo = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.adRequestId);
        parcel.writeString(this.adUnitId);
        parcel.writeString(this.adId);
        parcel.writeString(this.appPackage);
        parcel.writeString(this.appVersion);
        parcel.writeString(this.permissionsUrl);
        parcel.writeString(this.privacyAgreementUrl);
        parcel.writeString(this.developerName);
        parcel.writeInt(this.interactType);
        parcel.writeInt(this.adType);
        parcel.writeParcelable(this.trackUrl, i);
        parcel.writeString(this.landingPageUrl);
        parcel.writeString(this.packageUrl);
        parcel.writeString(this.logo);
        parcel.writeInt(this.sequence);
        parcel.writeString(this.storeChannel);
        parcel.writeInt(this.imgWidth);
        parcel.writeInt(this.imgHeight);
        parcel.writeStringList(this.imgUrls);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.title);
        parcel.writeString(this.subTitle);
        parcel.writeString(this.brand);
        parcel.writeString(this.appName);
        parcel.writeString(this.homePage);
        parcel.writeString(this.appIntro);
        parcel.writeString(this.introUrl);
        parcel.writeString(this.appIconUrl);
        parcel.writeLong(this.pkgSizeBytes);
        parcel.writeInt(this.installPkgType);
        parcel.writeInt(this.subType);
        parcel.writeInt(this.promotionPurpose);
        parcel.writeInt(this.uninstalleFilter);
        parcel.writeInt(this.adFlag);
        parcel.writeInt(this.closeFlag);
        parcel.writeString(this.deeplinkUrl);
        parcel.writeParcelable(this.style, i);
        parcel.writeInt(this.miniProgramType);
        parcel.writeString(this.miniProgramId);
        parcel.writeString(this.miniProgramPath);
        parcel.writeString(this.pkgSign);
        parcel.writeInt(this.adSpecTemplateType);
        parcel.writeLong(this.expirationTime);
        parcel.writeLong(this.responseTimeMillis);
        parcel.writeString(this.actionType);
        parcel.writeString(this.actionTips);
        parcel.writeString(this.targetTips);
        parcel.writeInt(this.impDuration);
        parcel.writeInt(this.brandFontSize);
        parcel.writeInt(this.adFlagFontSize);
        parcel.writeInt(this.skipFontSize);
        parcel.writeDouble(this.shakeAngle);
        parcel.writeDouble(this.shakeAcc);
        parcel.writeDouble(this.shakeDuration);
        parcel.writeParcelable(this.video, i);
        parcel.writeInt(this.pkgType);
        parcel.writeInt(this.landingPageType);
        parcel.writeInt(this.newLandingPageType);
        parcel.writeLong(this.price);
        parcel.writeInt(this.forwardInterval);
        parcel.writeInt(this.orientation);
        parcel.writeInt(this.creativeTemplateId);
        parcel.writeInt(this.incentiveFlag);
        parcel.writeList(this.incentivePoints);
        parcel.writeInt(this.detailPageOpenMode);
        parcel.writeInt(this.isCarousel);
        parcel.writeString(this.channelInfo);
        parcel.writeString(this.extraJson);
        parcel.writeString(this.subChannel);
        parcel.writeInt(this.detailType);
        parcel.writeInt(this.downloadType);
        parcel.writeString(this.partner);
        parcel.writeLong(this.ts);
        parcel.writeString(this.sifSign);
        parcel.writeList(this.adPositionSets);
        parcel.writeInt(this.dataType);
        parcel.writeString(this.buttonText);
        parcel.writeParcelable(this.detailPageCtrl, i);
        parcel.writeString(this.wechatExtInfo);
        parcel.writeString(this.dpPackageName);
        parcel.writeString(this.templateId);
    }

    protected BaseAdInfo(Parcel parcel) {
        this.pkgType = 0;
        this.landingPageType = 2;
        this.newLandingPageType = -1;
        this.id = parcel.readLong();
        this.adRequestId = parcel.readString();
        this.adUnitId = parcel.readString();
        this.adId = parcel.readString();
        this.appPackage = parcel.readString();
        this.appVersion = parcel.readString();
        this.permissionsUrl = parcel.readString();
        this.privacyAgreementUrl = parcel.readString();
        this.developerName = parcel.readString();
        this.interactType = parcel.readInt();
        this.adType = parcel.readInt();
        this.trackUrl = (TrackUrl) parcel.readParcelable(TrackUrl.class.getClassLoader());
        this.landingPageUrl = parcel.readString();
        this.packageUrl = parcel.readString();
        this.logo = parcel.readString();
        this.sequence = parcel.readInt();
        this.storeChannel = parcel.readString();
        this.imgWidth = parcel.readInt();
        this.imgHeight = parcel.readInt();
        this.imgUrls = parcel.createStringArrayList();
        this.videoUrl = parcel.readString();
        this.title = parcel.readString();
        this.subTitle = parcel.readString();
        this.brand = parcel.readString();
        this.appName = parcel.readString();
        this.homePage = parcel.readString();
        this.appIntro = parcel.readString();
        this.introUrl = parcel.readString();
        this.appIconUrl = parcel.readString();
        this.pkgSizeBytes = parcel.readLong();
        this.installPkgType = parcel.readInt();
        this.subType = parcel.readInt();
        this.promotionPurpose = parcel.readInt();
        this.uninstalleFilter = parcel.readInt();
        this.adFlag = parcel.readInt();
        this.closeFlag = parcel.readInt();
        this.deeplinkUrl = parcel.readString();
        this.style = (Style) parcel.readParcelable(Style.class.getClassLoader());
        this.miniProgramType = parcel.readInt();
        this.miniProgramId = parcel.readString();
        this.miniProgramPath = parcel.readString();
        this.pkgSign = parcel.readString();
        this.adSpecTemplateType = parcel.readInt();
        this.expirationTime = parcel.readLong();
        this.responseTimeMillis = parcel.readLong();
        this.actionType = parcel.readString();
        this.actionTips = parcel.readString();
        this.targetTips = parcel.readString();
        this.impDuration = parcel.readInt();
        this.brandFontSize = parcel.readInt();
        this.adFlagFontSize = parcel.readInt();
        this.skipFontSize = parcel.readInt();
        this.shakeAngle = parcel.readDouble();
        this.shakeAcc = parcel.readDouble();
        this.shakeDuration = parcel.readDouble();
        this.video = (Video) parcel.readParcelable(Video.class.getClassLoader());
        this.pkgType = parcel.readInt();
        this.landingPageType = parcel.readInt();
        this.newLandingPageType = parcel.readInt();
        this.price = parcel.readLong();
        this.forwardInterval = parcel.readInt();
        this.orientation = parcel.readInt();
        this.creativeTemplateId = parcel.readInt();
        this.incentiveFlag = parcel.readInt();
        this.incentivePoints = parcel.readArrayList(Integer.class.getClassLoader());
        this.detailPageOpenMode = parcel.readInt();
        this.isCarousel = parcel.readInt();
        this.channelInfo = parcel.readString();
        this.extraJson = parcel.readString();
        this.subChannel = parcel.readString();
        this.detailType = parcel.readInt();
        this.downloadType = parcel.readInt();
        this.partner = parcel.readString();
        this.ts = parcel.readLong();
        this.sifSign = parcel.readString();
        this.adPositionSets = parcel.readArrayList(Integer.class.getClassLoader());
        this.dataType = parcel.readInt();
        this.buttonText = parcel.readString();
        this.detailPageCtrl = (DetailPageCtrl) parcel.readParcelable(DetailPageCtrl.class.getClassLoader());
        this.wechatExtInfo = parcel.readString();
        this.dpPackageName = parcel.readString();
        this.templateId = parcel.readString();
    }
}
