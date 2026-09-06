package com.yfanads.android.model;

import android.text.TextUtils;
import com.yfanads.android.libs.thirdpart.gson.annotations.Expose;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdControl implements Serializable {
    public static final int DEFAULT_PARALLEL_CNT = 2;
    private static final String LIST_SPLIT = ",";
    public static final int MODEL_CROSS_PARALLEL = 3;
    public static final int MODEL_PARALLEL = 2;
    public static final int MODEL_SERIAL = 1;

    @Expose
    @SerializedName("adID")
    public String adId;

    @Expose
    @SerializedName("bannerCarouselInterval")
    public int bannerRefresh;

    @Expose
    public int cacheMax;

    @Expose
    public long cacheTimeout;

    @Expose
    public long confCacheTimeout;

    @Expose
    public Config config;

    @Expose
    public String ip;
    private volatile boolean isTotalRequestTimeout = false;

    @Expose
    public LoadModelDTO loadModel;

    @Expose
    public int logSwitch;

    @Expose
    public int mixMode;

    @Expose
    public String name;

    @Expose
    public int numMaterialReturned;

    @Expose
    @SerializedName("resourceVersion")
    public int resourceVersion;

    @Expose
    public int showInterval;

    @Expose
    public int showLimitDay;

    @Expose
    public int showLimitHour;

    @Expose
    public long timeFromServer;

    @Expose
    public long totalRequestTimeout;

    @Expose
    public int type;

    @Expose
    public int useCache;

    public static class Config implements Serializable {

        @Expose
        @SerializedName("biddingReportAdn")
        public String biddingReportAdn;

        @Expose
        @SerializedName("dtr")
        public int dtr;

        @Expose
        @SerializedName("dts")
        public int dts;

        @Expose
        @SerializedName("dtt")
        public int dtt;

        @Expose
        @SerializedName("icc")
        public int icc;

        @Expose
        @SerializedName("ici")
        public int ici;

        @Expose
        @SerializedName("tpAdId")
        public String tpAdId;
    }

    public static class LoadModelDTO implements Serializable {

        @Expose
        public int model;

        @Expose
        public int parallelCnt;
    }

    public void closeCache() {
        this.useCache = 0;
    }

    public int getBannerRefresh() {
        return this.bannerRefresh;
    }

    public String[] getBiddingReport() {
        Config config = this.config;
        if (config == null || TextUtils.isEmpty(config.biddingReportAdn)) {
            return null;
        }
        return this.config.biddingReportAdn.split(",");
    }

    public int getCacheMax() {
        return this.cacheMax;
    }

    public long getCacheTimeout() {
        return this.cacheTimeout;
    }

    public int getCarouselCount() {
        Config config = this.config;
        if (config != null) {
            return config.icc;
        }
        return 0;
    }

    public int getCarouselInterval() {
        Config config = this.config;
        if (config != null) {
            return config.ici;
        }
        return 2000;
    }

    public int getResourceVersion() {
        return this.resourceVersion;
    }

    public boolean isBFSerial() {
        return this.mixMode == 1;
    }

    public boolean isCParallelStrategyModel() {
        LoadModelDTO loadModelDTO = this.loadModel;
        return loadModelDTO != null && 3 == loadModelDTO.model;
    }

    public boolean isLogSwitch() {
        return this.logSwitch == 1;
    }

    public boolean isParallelStrategyModel() {
        LoadModelDTO loadModelDTO = this.loadModel;
        return loadModelDTO != null && 2 == loadModelDTO.model;
    }

    public boolean isSerialModel() {
        LoadModelDTO loadModelDTO = this.loadModel;
        return loadModelDTO != null && 1 == loadModelDTO.model;
    }

    public boolean isTotalRequestTimeout() {
        return this.isTotalRequestTimeout;
    }

    public boolean isValid() {
        return System.currentTimeMillis() - this.timeFromServer < this.confCacheTimeout;
    }

    public void setTotalRequestTimeout(boolean z) {
        this.isTotalRequestTimeout = z;
    }

    public void updateTimeFromServer() {
        this.timeFromServer = System.currentTimeMillis();
    }

    public BindInfo getBindInfo() {
        Config config = this.config;
        if (config != null) {
            return new BindInfo(config.tpAdId, config.dtr, config.dts, config.dtt);
        }
        return null;
    }

    public int getParallelCnt() {
        LoadModelDTO loadModelDTO = this.loadModel;
        if (loadModelDTO == null) {
            return 2;
        }
        return loadModelDTO.parallelCnt;
    }
}
