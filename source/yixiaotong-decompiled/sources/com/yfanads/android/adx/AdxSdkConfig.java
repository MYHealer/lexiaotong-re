package com.yfanads.android.adx;

import com.yfanads.android.utils.YFAdsConst;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdxSdkConfig {
    public String appID;
    public String appId;
    public String appName;
    public String appPageName;
    public String appVersion;
    public CustomController customController;
    public boolean enableDebug;
    public Map<String, Object> extDefine;
    public InitCallback initCallback;
    public String ip;
    public boolean isAutoListPackage;
    public int videoType;
    public String wxAppId;

    public static class Builder {
        private String appID;
        private String appId;
        private String appName;
        private String appPageName;
        private String appVersion;
        private CustomController customController;
        private boolean enableDebug;
        private Map<String, Object> extDefine;
        private InitCallback initCallback;
        public String ip;
        private boolean isAutoListPackage;
        private boolean showNotification;
        private int videoType;
        private String wxAppId;

        public AdxSdkConfig build() {
            return new AdxSdkConfig(this, null);
        }

        public Builder setAppID(String str) {
            this.appID = str;
            return this;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setAppPageName(String str) {
            this.appPageName = str;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setAutoListPackage(boolean z) {
            this.isAutoListPackage = z;
            return this;
        }

        public Builder setCustomController(CustomController customController) {
            this.customController = customController;
            return this;
        }

        public Builder setEnableDebug(boolean z) {
            this.enableDebug = z;
            return this;
        }

        public Builder setExtDefine(Map<String, Object> map) {
            this.extDefine = map;
            return this;
        }

        public Builder setInitCallback(InitCallback initCallback) {
            this.initCallback = initCallback;
            return this;
        }

        public Builder setIp(String str) {
            this.ip = str;
            return this;
        }

        public Builder setShowNotification(boolean z) {
            this.showNotification = z;
            return this;
        }

        public Builder setVideoType(int i) {
            this.videoType = i;
            return this;
        }

        public Builder setWxAppId(String str) {
            this.wxAppId = str;
            return this;
        }
    }

    public static /* synthetic */ class a {
    }

    public /* synthetic */ AdxSdkConfig(Builder builder, a aVar) {
        this(builder);
    }

    public static AdxSdkConfig create(String str) {
        Builder builder = new Builder();
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.enableDebug = jSONObject.optBoolean("enableDebug");
            builder.appId = jSONObject.optString("appId");
            builder.appID = jSONObject.optString(YFAdsConst.REPORT_APPID);
            builder.appName = jSONObject.optString("appName");
            builder.appVersion = jSONObject.optString("appVersion");
            builder.appPageName = jSONObject.optString("appPageName");
            builder.ip = jSONObject.optString("ip");
            builder.isAutoListPackage = jSONObject.optBoolean("isAutoListPackage");
            builder.wxAppId = jSONObject.optString("wxAppId");
            builder.videoType = jSONObject.optInt("videoType");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return builder.build();
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enableDebug", this.enableDebug);
            jSONObject.put("appId", this.appId);
            jSONObject.put(YFAdsConst.REPORT_APPID, this.appID);
            jSONObject.put("appName", this.appName);
            jSONObject.put("appVersion", this.appVersion);
            jSONObject.put("appPageName", this.appPageName);
            jSONObject.put("ip", this.ip);
            jSONObject.put("isAutoListPackage", this.isAutoListPackage);
            jSONObject.put("wxAppId", this.wxAppId);
            jSONObject.put("videoType", this.videoType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    private AdxSdkConfig(Builder builder) {
        this.enableDebug = builder.enableDebug;
        this.appId = builder.appId;
        this.appName = builder.appName;
        this.appVersion = builder.appVersion;
        this.appPageName = builder.appPageName;
        this.ip = builder.ip;
        this.customController = builder.customController;
        this.initCallback = builder.initCallback;
        this.isAutoListPackage = builder.isAutoListPackage;
        this.wxAppId = builder.wxAppId;
        this.appID = builder.appID;
        this.videoType = builder.videoType;
        this.extDefine = builder.extDefine;
    }
}
