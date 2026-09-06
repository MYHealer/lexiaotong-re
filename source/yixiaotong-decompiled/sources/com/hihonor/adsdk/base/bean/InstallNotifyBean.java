package com.hihonor.adsdk.base.bean;

import com.hihonor.adsdk.base.download.g;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InstallNotifyBean {
    private final String adId;
    private final String adRequestId;
    private final String adUnitId;
    private final int dataType;
    private final List<String> imgUrls;
    private final String logo;
    private final int mAdType;
    private final String mAppPackage;
    private final String mAppVersion;
    private final String mBrand;
    private String mChannelInfo;
    private List<String> mCommonUrls;
    private final int mPkgType;
    private final String mRequestId;
    private final int mSequence;
    private String mTemplateId;
    private final int promotionPurpose;
    private int status = -1;
    private final String title;

    public InstallNotifyBean(BaseAdInfo baseAdInfo) {
        this.mCommonUrls = null;
        this.mBrand = baseAdInfo.getBrand();
        this.title = baseAdInfo.getTitle();
        this.logo = baseAdInfo.getLogo();
        this.imgUrls = baseAdInfo.getImgUrls();
        this.mAppPackage = baseAdInfo.getAppPackage();
        this.mPkgType = baseAdInfo.getPkgType();
        this.adRequestId = baseAdInfo.getAdRequestId();
        this.adUnitId = baseAdInfo.getAdUnitId();
        this.adId = baseAdInfo.getAdId();
        this.mAdType = baseAdInfo.getAdType();
        this.mRequestId = baseAdInfo.getAdRequestId();
        this.promotionPurpose = baseAdInfo.getPromotionPurpose();
        this.dataType = baseAdInfo.getDataType();
        this.mAppVersion = baseAdInfo.getAppVersion();
        TrackUrl trackUrl = baseAdInfo.getTrackUrl();
        if (trackUrl != null) {
            this.mCommonUrls = trackUrl.getCommons();
        }
        this.mSequence = baseAdInfo.getSequence();
        this.mChannelInfo = baseAdInfo.getChannelInfo();
        this.mTemplateId = baseAdInfo.getTemplateId();
    }

    public String getAdId() {
        return this.adId;
    }

    public String getAdRequestId() {
        return this.adRequestId;
    }

    public int getAdType() {
        return this.mAdType;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public String getBrand() {
        return this.mBrand;
    }

    public String getChannelInfo() {
        return this.mChannelInfo;
    }

    public List<String> getCommonUrls() {
        return this.mCommonUrls;
    }

    public int getDataType() {
        return this.dataType;
    }

    public List<String> getImgUrls() {
        return this.imgUrls;
    }

    public String getLogo() {
        return this.logo;
    }

    public int getPkgType() {
        return this.mPkgType;
    }

    public int getPromotionPurpose() {
        return this.promotionPurpose;
    }

    public String getRequestId() {
        return this.mRequestId;
    }

    public int getSequence() {
        return this.mSequence;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTemplateId() {
        return this.mTemplateId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public InstallNotifyBean(g gVar) {
        this.mCommonUrls = null;
        this.mBrand = gVar.hnadsf();
        this.title = gVar.o();
        this.logo = gVar.hnadsw();
        this.imgUrls = gVar.hnadsr();
        this.mAppPackage = gVar.hnadsd();
        this.mPkgType = gVar.d();
        this.adRequestId = gVar.g();
        this.adUnitId = gVar.hnadsc();
        this.adId = gVar.hnadsa();
        this.mAdType = gVar.hnadsb();
        this.mRequestId = gVar.g();
        this.promotionPurpose = gVar.f();
        this.dataType = gVar.hnadsk();
        this.mAppVersion = gVar.hnadse();
        this.mCommonUrls = gVar.hnadsj();
        this.mSequence = gVar.i();
        this.mChannelInfo = gVar.hnadsg();
        this.mTemplateId = gVar.n();
    }
}
