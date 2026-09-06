package com.hihonor.updater.installsdk.api;

import com.hihonor.updater.installsdk.c.c;
import com.huawei.openalliance.ad.constant.ba;
import com.umeng.commonsdk.framework.UMModuleRegister;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class DIInfo implements JSONable {
    private String adID;
    private String apkIcon;
    private long apkSize;
    private String appName;
    private String channel;
    private String downloadUrl;
    private String extra;
    private boolean hideNotice;
    private String officialWebsiteUrl;
    private String packageName;
    private String process;
    private String sdkUser;
    private boolean showAgreement;
    private boolean showBannerNotice;
    private String sign;
    private boolean supportMobileNet;
    private String traceID;
    private String traceUrl;
    private String traceUrlData;
    private long versionCode;
    private String versionName;

    /* JADX INFO: renamed from: com.hihonor.updater.installsdk.api.DIInfo$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String adID;
        private String apkIcon;
        private long apkSize;
        private String appName;
        private String channel;
        private String downloadUrl;
        private String extra;
        private boolean hideNotice;
        private String officialWebsiteUrl;
        private String packageName;
        private String process;
        private String sdkUser;
        private boolean showAgreement;
        private boolean showBannerNotice;
        private String sign;
        private boolean supportMobileNet;
        private String traceID;
        private String traceUrl;
        private String traceUrlData;
        private long versionCode;
        private String versionName;

        public Builder(String str) {
            this.packageName = str;
        }

        public DIInfo build() {
            return new DIInfo(this, null);
        }

        public Builder setAdID(String str) {
            this.adID = str;
            return this;
        }

        public Builder setApkIcon(String str) {
            this.apkIcon = str;
            return this;
        }

        public Builder setApkSize(long j) {
            this.apkSize = j;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setDownloadUrl(String str) {
            this.downloadUrl = str;
            return this;
        }

        public Builder setExtra(String str) {
            this.extra = str;
            return this;
        }

        public Builder setHideNotice(boolean z) {
            this.hideNotice = z;
            return this;
        }

        public Builder setOfficialWebsiteUrl(String str) {
            this.officialWebsiteUrl = str;
            return this;
        }

        public Builder setPackageName(String str) {
            this.packageName = str;
            return this;
        }

        public Builder setSdkUser(String str) {
            this.sdkUser = str;
            return this;
        }

        public Builder setShowAgreement(boolean z) {
            this.showAgreement = z;
            return this;
        }

        public Builder setShowBannerNotice(boolean z) {
            this.showBannerNotice = z;
            return this;
        }

        public Builder setSign(String str) {
            this.sign = str;
            return this;
        }

        public Builder setSupportMobileNet(boolean z) {
            this.supportMobileNet = z;
            return this;
        }

        public Builder setTraceID(String str) {
            this.traceID = str;
            return this;
        }

        @Deprecated
        public Builder setTraceUrl(String str) {
            this.traceUrl = str;
            return this;
        }

        public Builder setTraceUrlData(TraceUrlData traceUrlData) {
            if (traceUrlData != null) {
                this.traceUrlData = traceUrlData.writeToJSON().toString();
            }
            return this;
        }

        public Builder setVersionCode(long j) {
            this.versionCode = j;
            return this;
        }

        public Builder setVersionName(String str) {
            this.versionName = str;
            return this;
        }
    }

    private DIInfo(Builder builder) {
        this.channel = builder.channel;
        this.packageName = builder.packageName;
        this.appName = builder.appName;
        this.traceUrl = builder.traceUrl;
        this.adID = builder.adID;
        this.downloadUrl = builder.downloadUrl;
        this.supportMobileNet = builder.supportMobileNet;
        this.sign = builder.sign;
        this.process = builder.process;
        this.apkSize = builder.apkSize;
        this.apkIcon = builder.apkIcon;
        this.versionName = builder.versionName;
        this.versionCode = builder.versionCode;
        this.officialWebsiteUrl = builder.officialWebsiteUrl;
        this.extra = builder.extra;
        this.sdkUser = builder.sdkUser;
        this.traceID = builder.traceID;
        this.traceUrlData = builder.traceUrlData;
        this.showBannerNotice = builder.showBannerNotice;
        this.hideNotice = builder.hideNotice;
        this.showAgreement = builder.showAgreement;
    }

    /* synthetic */ DIInfo(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public String getAdID() {
        return this.adID;
    }

    public String getApkIcon() {
        return this.apkIcon;
    }

    public long getApkSize() {
        return this.apkSize;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public String getExtra() {
        return this.extra;
    }

    public String getOfficialWebsiteUrl() {
        return this.officialWebsiteUrl;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProcess() {
        return this.process;
    }

    public String getSdkUser() {
        return this.sdkUser;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTraceID() {
        return this.traceID;
    }

    @Deprecated
    public String getTraceUrl() {
        return this.traceUrl;
    }

    public String getTraceUrlData() {
        return this.traceUrlData;
    }

    public long getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public boolean isHideNotice() {
        return this.hideNotice;
    }

    public boolean isShowAgreement() {
        return this.showAgreement;
    }

    public boolean isShowBannerNotice() {
        return this.showBannerNotice;
    }

    public boolean isSupportMobileNet() {
        return this.supportMobileNet;
    }

    @Override // com.hihonor.updater.installsdk.api.JSONable
    public void readFromJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.channel = c.d(jSONObject, "channel");
            this.packageName = c.d(jSONObject, "packageName");
            this.appName = c.d(jSONObject, "appName");
            this.traceUrl = c.d(jSONObject, "traceUrl");
            this.adID = c.d(jSONObject, "adID");
            this.downloadUrl = c.d(jSONObject, "downloadUrl");
            this.supportMobileNet = c.a(jSONObject, "supportMobileNet");
            this.downloadUrl = c.d(jSONObject, "sign");
            this.process = c.d(jSONObject, UMModuleRegister.PROCESS);
            this.apkSize = c.c(jSONObject, "apkSize");
            this.apkIcon = c.d(jSONObject, "apkIcon");
            this.versionName = c.d(jSONObject, "versionName");
            this.versionCode = c.c(jSONObject, ba.aX);
            this.officialWebsiteUrl = c.d(jSONObject, "officialWebsiteUrl");
            this.extra = c.d(jSONObject, "extra");
            this.sdkUser = c.d(jSONObject, "sdkUser");
            this.traceID = c.d(jSONObject, "traceID");
            this.traceUrlData = c.d(jSONObject, "traceUrlData");
            this.showBannerNotice = c.a(jSONObject, "showBannerNotice");
            this.hideNotice = c.a(jSONObject, "hideNotice");
            this.showAgreement = c.a(jSONObject, "showAgreement");
        } catch (Throwable unused) {
        }
    }

    public void setTraceUrl(String str) {
        this.traceUrl = str;
    }

    public void setTraceUrlData(String str) {
        this.traceUrlData = str;
    }

    @Override // com.hihonor.updater.installsdk.api.JSONable
    public JSONObject writeToJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", this.channel);
            jSONObject.put("packageName", this.packageName);
            jSONObject.put("appName", this.appName);
            jSONObject.put("traceUrl", this.traceUrl);
            jSONObject.put("adID", this.adID);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("supportMobileNet", this.supportMobileNet);
            jSONObject.put("sign", this.sign);
            jSONObject.put(UMModuleRegister.PROCESS, this.process);
            jSONObject.put("apkSize", this.apkSize);
            jSONObject.put("apkIcon", this.apkIcon);
            jSONObject.put("versionName", this.versionName);
            jSONObject.put(ba.aX, this.versionCode);
            jSONObject.put("officialWebsiteUrl", this.officialWebsiteUrl);
            jSONObject.put("extra", this.extra);
            jSONObject.put("sdkUser", this.sdkUser);
            jSONObject.put("traceID", this.traceID);
            jSONObject.put("traceUrlData", this.traceUrlData);
            jSONObject.put("showBannerNotice", this.showBannerNotice);
            jSONObject.put("hideNotice", this.hideNotice);
            jSONObject.put("showAgreement", this.showAgreement);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
