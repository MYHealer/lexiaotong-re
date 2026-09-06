package com.yfanads.android.adx.core.model;

import android.text.TextUtils;
import com.yfanads.android.adx.service.c;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdxFeedBean {
    public int action;
    public String adId;
    public String apiLevel;
    public String appId;
    public String appName;
    public String appVer;
    public String brand;
    public String clickUrls;
    public TemplateConf conf;
    public String county;
    public float density;
    public int densityDPI;
    public int devHeight;
    public int devWidth;
    public String developerName;
    public String downloadUrl;
    public String dplUrl;
    public int duration;
    public String endImgUrl;
    public String exposureUrls;
    public long fileSize;
    public int h;
    public String imgUrl;
    public String intent;
    public boolean isFullScreen;
    public String landingUrl;
    public String language;
    public String merchant;
    public String mine;
    public String model;
    public String name;
    public String oaId;
    public String os;
    public String packageName;
    public int price;
    public String rId;
    public float ratio;
    public String screenSize;
    public String sdkVersion;
    public int size;
    public String text;
    public String title;
    public String type;
    public String url;
    public int videoKeepTime;
    public int w;
    public String winUrls;
    public String wxProgramId;
    public String wxProgramPath;

    public AdxFeedBean(NativeSourceNew nativeSourceNew, TemplateConf templateConf, boolean z) {
        updNativeSource(nativeSourceNew);
        updateOther();
        this.conf = templateConf;
        this.oaId = TextUtils.isEmpty(DeviceUtils.getCacheOAID()) ? DeviceUtils.getClientId() : DeviceUtils.getCacheOAID();
        this.isFullScreen = z;
    }

    private void updNativeSource(NativeSourceNew nativeSourceNew) {
        if (nativeSourceNew == null) {
            return;
        }
        this.rId = nativeSourceNew.rid;
        if (nativeSourceNew.hasAd()) {
            NativeSourceNew.NativeAd nativeAd = nativeSourceNew.ad;
            this.appId = nativeAd.appId;
            this.adId = nativeAd.adId;
            this.price = nativeAd.price;
            this.action = nativeAd.action;
            this.landingUrl = nativeAd.landingUrl;
            this.dplUrl = nativeAd.dplUrl;
            this.wxProgramId = nativeAd.wxProgramId;
            this.wxProgramPath = nativeAd.wxProgramPath;
            this.intent = nativeAd.intent;
            this.merchant = nativeAd.merchant;
            if (nativeSourceNew.hasAsset()) {
                this.type = nativeAd.asset.type == 1 ? "图片" : "视频";
                if (nativeSourceNew.isImgAsset()) {
                    NativeSourceNew.Image image = nativeAd.asset.image;
                    String[] strArr = image.urls;
                    this.url = (strArr == null || strArr.length <= 0) ? "" : strArr[0];
                    this.mine = image.mine;
                    this.w = image.w;
                    this.h = image.h;
                    this.title = image.title;
                    this.text = image.text;
                    this.name = image.name;
                }
                if (nativeSourceNew.isVideoAsset()) {
                    NativeSourceNew.Video video = nativeAd.asset.video;
                    this.url = video.url;
                    this.mine = video.mine;
                    this.w = video.w;
                    this.h = video.h;
                    this.title = video.title;
                    this.text = video.text;
                    this.name = video.name;
                    this.duration = video.duration;
                    this.imgUrl = video.imgUrl;
                    this.size = video.size;
                    this.ratio = video.ratio;
                    this.videoKeepTime = video.videoKeepTime;
                    this.endImgUrl = video.endImgUrl;
                }
            }
            if (nativeSourceNew.hasDownload()) {
                NativeSourceNew.Download download = nativeAd.download;
                this.downloadUrl = download.Url;
                this.packageName = download.packageName;
                this.appName = download.appName;
                this.developerName = download.developerName;
                this.appVer = download.appVer;
                this.fileSize = download.fileSize;
            }
            if (nativeSourceNew.hasMonitor()) {
                NativeSourceNew.Monitor monitor = nativeAd.monitor;
                this.exposureUrls = YFUtil.extractDomains(monitor.exposureUrls);
                this.clickUrls = YFUtil.extractDomains(monitor.clickUrls);
                this.winUrls = YFUtil.extractDomains(monitor.winUrls);
            }
        }
    }

    public void updateOther() {
        YFAdsPhone yFAdsPhone = YFAdsPhone.getInstance();
        if (yFAdsPhone == null) {
            return;
        }
        this.county = yFAdsPhone.county;
        this.language = yFAdsPhone.language;
        this.devWidth = yFAdsPhone.devWidth;
        this.devHeight = yFAdsPhone.devHeight;
        this.density = yFAdsPhone.density;
        this.densityDPI = yFAdsPhone.densityDPI;
        this.brand = yFAdsPhone.brand;
        this.model = yFAdsPhone.model;
        this.apiLevel = yFAdsPhone.apiLevel;
        this.os = yFAdsPhone.os;
        this.sdkVersion = yFAdsPhone.getSDKVersion();
        this.screenSize = c.a.f9618a.C;
    }
}
