package com.yfanads.android;

import com.yfanads.android.adx.BuildConfig;
import com.yfanads.android.model.YFLocation;
import com.yfanads.android.utils.YFLog;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class YFAdsConfig {
    private String appId;
    private String appName;
    private String appPackage;
    private String appVer;
    private boolean canUseAndroidId;
    private boolean canUseAppList;
    private boolean canUseLocation;
    private boolean canUseOaid;
    private boolean canUsePhoneState;
    private boolean canUseWifiState;
    private boolean canUseWriteExternal;
    private boolean closeAppReceiver;
    private Map<String, Object> customDefine;
    private String devAndroidId;
    private List<String> devAppList;
    private String devImei;
    private String devMacAddress;
    private String devOaid;
    private Map<String, Object> extDefine;
    private String ip;
    private boolean limitPersonal;
    private Map<String, Object> userDefine;
    private YFLocation yfLocation;

    /* JADX INFO: renamed from: com.yfanads.android.YFAdsConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class YFAdsConfigBuilder {
        private final YFAdsConfig config;

        public YFAdsConfigBuilder(String str) {
            YFAdsConfig yFAdsConfig = new YFAdsConfig(null);
            this.config = yFAdsConfig;
            yFAdsConfig.setAppId(str);
        }

        public YFAdsConfig builder() {
            return this.config;
        }

        public YFAdsConfigBuilder setCanUseAndroidId(boolean z) {
            this.config.setCanUseAndroidId(z);
            return this;
        }

        public YFAdsConfigBuilder setCanUseAppList(boolean z) {
            this.config.setCanUseAppList(z);
            return this;
        }

        public YFAdsConfigBuilder setCanUseLocation(boolean z) {
            this.config.setCanUseLocation(z);
            return this;
        }

        public YFAdsConfigBuilder setCanUseOaid(boolean z) {
            this.config.setCanUseOaid(z);
            return this;
        }

        public YFAdsConfigBuilder setCanUsePhoneState(boolean z) {
            this.config.setCanUsePhoneState(z);
            return this;
        }

        public YFAdsConfigBuilder setCanUseWifiState(boolean z) {
            this.config.setCanUseWifiState(z);
            return this;
        }

        public YFAdsConfigBuilder setCanUseWriteExternal(boolean z) {
            this.config.setCanUseWriteExternal(z);
            return this;
        }

        public YFAdsConfigBuilder setCloseAppReceiver(boolean z) {
            this.config.setCloseAppReceiver(z);
            return this;
        }

        public YFAdsConfigBuilder setCustomDefine(Map<String, Object> map) {
            this.config.setCustomDefine(map);
            return this;
        }

        @Deprecated
        public YFAdsConfigBuilder setDebug(boolean z) {
            return this;
        }

        public YFAdsConfigBuilder setDevAndroidId(String str) {
            this.config.setDevAndroidId(str);
            return this;
        }

        public YFAdsConfigBuilder setDevAppList(List<String> list) {
            this.config.setDevAppList(list);
            return this;
        }

        public YFAdsConfigBuilder setDevImei(String str) {
            this.config.setDevImei(str);
            return this;
        }

        public YFAdsConfigBuilder setDevMacAddress(String str) {
            this.config.setDevMacAddress(str);
            return this;
        }

        public YFAdsConfigBuilder setDevOaid(String str) {
            this.config.setDevOaid(str);
            return this;
        }

        public YFAdsConfigBuilder setExtDefine(Map<String, Object> map) {
            this.config.setExtDefine(map);
            return this;
        }

        public YFAdsConfigBuilder setLimitPersonal(boolean z) {
            this.config.setLimitPersonal(z);
            return this;
        }

        public YFAdsConfigBuilder setUserDefine(Map<String, Object> map) {
            this.config.setUserDefine(map);
            return this;
        }

        public YFAdsConfigBuilder setYFLocation(YFLocation yFLocation) {
            this.config.setYLLocation(yFLocation);
            return this;
        }
    }

    public /* synthetic */ YFAdsConfig(AnonymousClass1 anonymousClass1) {
        this();
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public String getAppVer() {
        return this.appVer;
    }

    public Map<String, Object> getCustomDefine() {
        return this.customDefine;
    }

    public String getDevAndroidId() {
        return this.devAndroidId;
    }

    public List<String> getDevAppList() {
        return this.devAppList;
    }

    public String getDevImei() {
        return this.devImei;
    }

    public String getDevMacAddress() {
        return this.devMacAddress;
    }

    public String getDevOaid() {
        return this.devOaid;
    }

    public Map<String, Object> getExtDefine() {
        return this.extDefine;
    }

    public String getIp() {
        return this.ip;
    }

    public YFLocation getLocation() {
        return this.yfLocation;
    }

    public Map<String, Object> getUserDefine() {
        return this.userDefine;
    }

    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public YFLocation getYfLocation() {
        return this.yfLocation;
    }

    public boolean isCanUseAndroidId() {
        return this.canUseAndroidId;
    }

    public boolean isCanUseAppList() {
        return this.canUseAppList;
    }

    public boolean isCanUseLocation() {
        return this.canUseLocation;
    }

    public boolean isCanUseOaid() {
        return this.canUseOaid;
    }

    public boolean isCanUsePhoneState() {
        return this.canUsePhoneState;
    }

    public boolean isCanUseWifiState() {
        return this.canUseWifiState;
    }

    public boolean isCanUseWriteExternal() {
        return this.canUseWriteExternal;
    }

    public boolean isCloseAppReceiver() {
        return this.closeAppReceiver;
    }

    public boolean isDebug() {
        return YFLog.isDebug();
    }

    public boolean isLimitPersonal() {
        return this.limitPersonal;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppPackage(String str) {
        this.appPackage = str;
    }

    public void setAppVer(String str) {
        this.appVer = str;
    }

    public void setCanUseAndroidId(boolean z) {
        this.canUseAndroidId = z;
    }

    public void setCanUseAppList(boolean z) {
        this.canUseAppList = z;
    }

    public void setCanUseLocation(boolean z) {
        this.canUseLocation = z;
    }

    public void setCanUseOaid(boolean z) {
        this.canUseOaid = z;
    }

    public void setCanUsePhoneState(boolean z) {
        this.canUsePhoneState = z;
    }

    public void setCanUseWifiState(boolean z) {
        this.canUseWifiState = z;
    }

    public void setCanUseWriteExternal(boolean z) {
        this.canUseWriteExternal = z;
    }

    public void setCloseAppReceiver(boolean z) {
        this.closeAppReceiver = z;
    }

    public void setCustomDefine(Map<String, Object> map) {
        this.customDefine = map;
    }

    public void setDevAndroidId(String str) {
        this.devAndroidId = str;
    }

    public void setDevAppList(List<String> list) {
        this.devAppList = list;
    }

    public void setDevImei(String str) {
        this.devImei = str;
    }

    public void setDevMacAddress(String str) {
        this.devMacAddress = str;
    }

    public void setDevOaid(String str) {
        this.devOaid = str;
    }

    public void setExtDefine(Map<String, Object> map) {
        this.extDefine = map;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setLimitPersonal(boolean z) {
        this.limitPersonal = z;
    }

    public void setUserDefine(Map<String, Object> map) {
        this.userDefine = map;
    }

    public void setYLLocation(YFLocation yFLocation) {
        this.yfLocation = yFLocation;
    }

    private YFAdsConfig() {
        this.canUseLocation = true;
        this.canUsePhoneState = true;
        this.canUseWifiState = true;
        this.canUseWriteExternal = true;
        this.canUseOaid = true;
        this.canUseAndroidId = true;
        this.canUseAppList = true;
        this.limitPersonal = false;
        this.closeAppReceiver = false;
    }
}
