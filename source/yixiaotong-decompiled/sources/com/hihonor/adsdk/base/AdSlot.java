package com.hihonor.adsdk.base;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdSlot {
    private String adContext;
    private int adCount;
    private Builder builder;
    private int dataType;
    private int height;
    private List<String> industryIds;
    private boolean isPreCacheVideo;
    private int loadType;
    private int renderType;
    private double rewardAmount;
    private String rewardName;
    private String slotId;
    private long timeOutMillis;
    private int width;

    public static final class Builder {
        private String adContext;
        private int adCount;
        private int dataType;
        private int height;
        private List<String> industryIds;
        private boolean isPreCacheVideo;
        private double rewardAmount;
        private String rewardName;
        private String slotId;
        private long timeOutMillis;
        private int width;
        private int renderType = 0;
        private int loadType = -1;

        public AdSlot build() {
            return new AdSlot(this);
        }

        public Builder setAdContext(String str) {
            this.adContext = str;
            return this;
        }

        public Builder setAdCount(int i) {
            this.adCount = i;
            return this;
        }

        public Builder setDataType(int i) {
            this.dataType = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setIndustryIds(List<String> list) {
            this.industryIds = list;
            return this;
        }

        public Builder setLoadType(int i) {
            this.loadType = i;
            return this;
        }

        public Builder setPreCacheVideo(boolean z) {
            this.isPreCacheVideo = z;
            return this;
        }

        public Builder setRenderType(int i) {
            this.renderType = i;
            return this;
        }

        public Builder setRewardAmount(double d) {
            this.rewardAmount = d;
            return this;
        }

        public Builder setRewardName(String str) {
            this.rewardName = str;
            return this;
        }

        public Builder setSlotId(String str) {
            this.slotId = str;
            return this;
        }

        public Builder setTimeOutMillis(long j) {
            this.timeOutMillis = j;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }
    }

    public AdSlot(Builder builder) {
        this.builder = builder;
        this.slotId = builder.slotId;
        this.adCount = builder.adCount;
        this.width = builder.width;
        this.height = builder.height;
        this.timeOutMillis = builder.timeOutMillis;
        this.adContext = builder.adContext;
        this.renderType = builder.renderType;
        this.loadType = builder.loadType;
        this.rewardAmount = builder.rewardAmount;
        this.rewardName = builder.rewardName;
        this.dataType = builder.dataType;
        this.isPreCacheVideo = builder.isPreCacheVideo;
        this.industryIds = builder.industryIds;
    }

    public String getAdContext() {
        return this.adContext;
    }

    public int getAdCount() {
        return this.adCount;
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public int getDataType() {
        return this.dataType;
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getIndustryIds() {
        return this.industryIds;
    }

    public int getLoadType() {
        return this.loadType;
    }

    public int getRenderType() {
        return this.renderType;
    }

    public double getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public String getSlotId() {
        return this.slotId;
    }

    public long getTimeOutMillis() {
        return this.timeOutMillis;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isPreCacheVideo() {
        return this.isPreCacheVideo;
    }

    public void setDataType(int i) {
        this.dataType = i;
    }
}
