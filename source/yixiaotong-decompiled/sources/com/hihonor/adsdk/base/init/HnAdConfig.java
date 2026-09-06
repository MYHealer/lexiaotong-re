package com.hihonor.adsdk.base.init;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnAdConfig {
    private String appId;
    private String appKey;
    private String appName;
    private HnCustomController customController;
    private boolean isAllowShowNotify;
    private final HnRewardListener mHnRewardListener;
    private int networkType;
    private boolean supportMultiProcess;
    private boolean useDyeing;
    private boolean useMock;
    private boolean useTestTools;
    private String wxOpenAppId;

    static /* synthetic */ class a {
    }

    /* synthetic */ HnAdConfig(Builder builder, a aVar) {
        this(builder);
    }

    public String getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppName() {
        return this.appName;
    }

    public HnCustomController getCustomController() {
        return this.customController;
    }

    public HnRewardListener getHnRewardListener() {
        return this.mHnRewardListener;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public String getWxOpenAppId() {
        return this.wxOpenAppId;
    }

    public boolean isAllowShowNotify() {
        return this.isAllowShowNotify;
    }

    public boolean isSupportMultiProcess() {
        return this.supportMultiProcess;
    }

    public boolean isUseDyeing() {
        return this.useDyeing;
    }

    public boolean isUseMock() {
        return this.useMock;
    }

    public boolean isUseTestTools() {
        return this.useTestTools;
    }

    public static class Builder {
        String appId;
        String appKey;
        String appName;
        HnCustomController customController;
        boolean isAllowShowNotify;
        HnRewardListener mHnRewardListener;
        int networkType;
        boolean supportMultiProcess;
        boolean useDyeing;
        boolean useMock;
        boolean useTestTools;
        String wxOpenAppId;

        public Builder() {
            this.supportMultiProcess = false;
        }

        public HnAdConfig build() {
            return new HnAdConfig(this, null);
        }

        public Builder setAllowShowNotify(boolean z) {
            this.isAllowShowNotify = z;
            return this;
        }

        public Builder setAppId(String str) {
            this.appId = str;
            return this;
        }

        public Builder setAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setCustomController(HnCustomController hnCustomController) {
            this.customController = hnCustomController;
            return this;
        }

        public Builder setNetworkType(int i) {
            this.networkType = i;
            return this;
        }

        public Builder setRewardListener(HnRewardListener hnRewardListener) {
            this.mHnRewardListener = hnRewardListener;
            return this;
        }

        public Builder setSupportMultiProcess(boolean z) {
            this.supportMultiProcess = z;
            return this;
        }

        public Builder setUseDyeing(boolean z) {
            this.useDyeing = z;
            return this;
        }

        public Builder setUseMock(boolean z) {
            this.useMock = z;
            return this;
        }

        public Builder setWxOpenAppId(String str) {
            this.wxOpenAppId = str;
            return this;
        }

        public Builder useTestTools(boolean z) {
            this.useTestTools = z;
            return this;
        }

        public Builder(HnAdConfig hnAdConfig) {
            this.supportMultiProcess = false;
            this.appId = hnAdConfig.appId;
            this.appName = hnAdConfig.appName;
            this.isAllowShowNotify = hnAdConfig.isAllowShowNotify;
            this.useMock = hnAdConfig.useMock;
            this.networkType = hnAdConfig.networkType;
            this.customController = hnAdConfig.customController;
            this.appKey = hnAdConfig.appKey;
            this.wxOpenAppId = hnAdConfig.wxOpenAppId;
            this.useTestTools = hnAdConfig.useTestTools;
            this.supportMultiProcess = hnAdConfig.supportMultiProcess;
            this.mHnRewardListener = hnAdConfig.mHnRewardListener;
            this.useDyeing = hnAdConfig.useDyeing;
        }
    }

    private HnAdConfig(Builder builder) {
        this.supportMultiProcess = false;
        this.appId = builder.appId;
        this.appKey = builder.appKey;
        this.appName = builder.appName;
        this.isAllowShowNotify = builder.isAllowShowNotify;
        this.useMock = builder.useMock;
        this.networkType = builder.networkType;
        this.customController = builder.customController;
        this.wxOpenAppId = builder.wxOpenAppId;
        this.useTestTools = builder.useTestTools;
        this.supportMultiProcess = builder.supportMultiProcess;
        this.mHnRewardListener = builder.mHnRewardListener;
        this.useDyeing = builder.useDyeing;
    }
}
