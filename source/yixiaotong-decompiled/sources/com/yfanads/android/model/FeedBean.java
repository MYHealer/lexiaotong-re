package com.yfanads.android.model;

import android.text.TextUtils;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.model.template.BaseTemplateData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FeedBean {
    public String actBtnString;
    public String apiLevel;
    public String appName;
    public String appVersion;
    public String brand;
    public String contextName;
    public String county;
    public float density;
    public int densityDPI;
    public String des;
    public int devHeight;
    public int devWidth;
    public String imageUrl;
    public boolean isDownload;
    public boolean isFullScreen;
    public boolean isVideo;
    public String language;
    public String model;
    public String oaId;
    public String os;
    public int popHeight;
    public int popWidth;
    public String publish;
    public String reqId;
    public String sdkVersion;
    public String source;
    public TemplateConf templateConf;
    public String title;
    public String type;

    public FeedBean(String str, String str2, boolean z, BaseTemplateData baseTemplateData) {
        this.title = str;
        this.des = str2;
        this.isVideo = z;
        if (baseTemplateData != null) {
            this.templateConf = baseTemplateData.conf;
            this.popWidth = baseTemplateData.popWidth;
            this.popHeight = baseTemplateData.popHeight;
            this.type = baseTemplateData.type;
        }
        updateCommonInfo();
    }

    public void updateAppInfo(String str, String str2, String str3) {
        this.isDownload = true;
        this.appName = str;
        this.appVersion = str2;
        this.publish = str3;
    }

    public void updateCommonInfo() {
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
        this.oaId = TextUtils.isEmpty(DeviceUtils.getCacheOAID()) ? DeviceUtils.getClientId() : DeviceUtils.getCacheOAID();
        this.sdkVersion = yFAdsPhone.getSDKVersion();
    }

    public void updateSupplerInfo(SdkSupplier sdkSupplier) {
        if (sdkSupplier == null) {
            return;
        }
        this.source = sdkSupplier.getSourceByLog();
        this.reqId = sdkSupplier.getReqId();
    }
}
