package com.ubixnow.core.api;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNAdConfig {
    public String appId;
    public String channel = "1";
    public UMNConfigUserInfo configUserInfo;
    public HashMap<String, String> extraMap;
    public boolean isDebug;
    public UMNPrivacyConfig privacyConfig;

    public static class Builder {
        private String appId = "";
        private String channel;
        private UMNConfigUserInfo configUserInfo;
        public HashMap<String, String> extraMap;
        private boolean isDebug;
        private UMNPrivacyConfig privacyConfig;

        public UMNAdConfig build() {
            UMNAdConfig uMNAdConfig = new UMNAdConfig();
            uMNAdConfig.appId = this.appId;
            uMNAdConfig.isDebug = this.isDebug;
            String str = this.channel;
            if (str == null) {
                str = Channel.OTHER;
            }
            uMNAdConfig.channel = str;
            uMNAdConfig.privacyConfig = this.privacyConfig;
            uMNAdConfig.configUserInfo = this.configUserInfo;
            uMNAdConfig.extraMap = this.extraMap;
            return uMNAdConfig;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        @Deprecated
        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setConfigUserInfo(UMNConfigUserInfo uMNConfigUserInfo) {
            this.configUserInfo = uMNConfigUserInfo;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.isDebug = z;
            return this;
        }

        public Builder setExtraMap(HashMap<String, String> map) {
            this.extraMap = map;
            return this;
        }

        public Builder setPrivacyConfig(UMNPrivacyConfig uMNPrivacyConfig) {
            this.privacyConfig = uMNPrivacyConfig;
            return this;
        }
    }

    public static class Channel {
        public static String BAIDU = "8";
        public static String HONOR = "6";
        public static String HUAWEI = "4";
        public static String KUAISHOU = "9";
        public static String OPPO = "2";
        public static String OTHER = "1";
        public static String TENCENT = "7";
        public static String VIVO = "3";
        public static String XIAOMI = "5";
    }
}
