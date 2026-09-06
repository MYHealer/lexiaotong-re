package com.yfanads.android.model;

import android.text.TextUtils;
import com.yfanads.android.core.f;
import com.yfanads.android.libs.thirdpart.gson.annotations.Expose;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.utils.YFListUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class StrategyModel implements Serializable {

    @Expose
    private AB ab;

    @Expose
    private AdControl adControl;

    @Expose
    private Section section;

    @Expose
    private List<SdkSupplier> waterfall = new ArrayList();

    @Expose
    private List<SdkSupplier> copyWaterfall = new ArrayList();

    @Expose(serialize = false)
    private List<SdkSupplier> biddingList = new ArrayList();

    public static class AB implements Serializable {

        @Expose
        @SerializedName("abID")
        public String abId;

        @Expose
        @SerializedName("groupID")
        public String groupId;
    }

    public static class Section implements Serializable {

        @Expose
        @SerializedName("sectionID")
        public String sectionId;
    }

    public static StrategyModel covertModel(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return (StrategyModel) Util.GSON.fromJson(str, StrategyModel.class);
        } catch (Exception e) {
            f.a(e, new StringBuilder("string covert object error "));
            return null;
        }
    }

    public static String covertString(StrategyModel strategyModel) {
        if (strategyModel == null) {
            return null;
        }
        try {
            return Util.GSON.toJson(strategyModel);
        } catch (Exception e) {
            f.a(e, new StringBuilder("string covert object error "));
            return null;
        }
    }

    public AB getAb() {
        return this.ab;
    }

    public AdControl getAdControl() {
        return this.adControl;
    }

    public List<SdkSupplier> getBiddingList() {
        return this.biddingList;
    }

    public BindInfo getBindInfo() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getBindInfo();
        }
        return null;
    }

    public int getCarouselCount() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getCarouselCount();
        }
        return 0;
    }

    public int getCarouselInterval() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getCarouselInterval();
        }
        return 2000;
    }

    public List<SdkSupplier> getCopyWaterfall() {
        return !YFListUtils.isEmpty(this.copyWaterfall) ? this.copyWaterfall : new ArrayList(0);
    }

    public int getRefresh() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getBannerRefresh();
        }
        return 0;
    }

    public List<SdkSupplier> getSdkSupplierList() {
        return !YFListUtils.isEmpty(this.waterfall) ? this.waterfall : new ArrayList(0);
    }

    public Section getSection() {
        return this.section;
    }

    public SdkSupplier getTopSdkSupplier() {
        if (YFListUtils.isEmpty(this.waterfall)) {
            return null;
        }
        return this.waterfall.get(0);
    }

    public long getTotalReqTime() {
        return this.adControl.totalRequestTimeout;
    }

    public int getVer() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getResourceVersion();
        }
        return 0;
    }

    public boolean hasBiddingList() {
        List<SdkSupplier> list = this.biddingList;
        return (list == null || list.isEmpty()) ? false : true;
    }

    public boolean hasSdkSupplier() {
        return !YFListUtils.isEmpty(this.waterfall);
    }

    public boolean isAdControlEmpty() {
        return this.adControl == null;
    }

    public boolean isBiddingEmpty() {
        return YFListUtils.isEmpty(this.biddingList);
    }

    public boolean isDataValid() {
        return !YFListUtils.isEmpty(getSdkSupplierList());
    }

    public boolean isLogSwitch() {
        AdControl adControl = this.adControl;
        return adControl != null && adControl.isLogSwitch();
    }

    public boolean isSdkSupplierEmpty() {
        return YFListUtils.isEmpty(this.waterfall);
    }

    public void removeTopSdkSupplier() {
        if (YFListUtils.isEmpty(this.waterfall)) {
            return;
        }
        this.waterfall.remove(0);
    }

    public void setAb(AB ab) {
        this.ab = ab;
    }

    public void setAdControl(AdControl adControl) {
        this.adControl = adControl;
    }

    public void setBiddingList(List<SdkSupplier> list) {
        this.biddingList = list;
    }

    public void setSdkSupplierList(List<SdkSupplier> list) {
        if (YFListUtils.isEmpty(list)) {
            return;
        }
        this.waterfall = list;
        this.copyWaterfall = new ArrayList(list);
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getAbId() {
        AB ab = this.ab;
        return ab != null ? ab.abId : "";
    }

    public String getAdId() {
        AdControl adControl = this.adControl;
        return adControl != null ? adControl.adId : "";
    }

    public String[] getBiddingReport() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getBiddingReport();
        }
        return null;
    }

    public int getCType() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.type;
        }
        return -1;
    }

    public int getCacheMax() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getCacheMax();
        }
        return 0;
    }

    public long getCacheTimeout() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getCacheTimeout();
        }
        return 0L;
    }

    public String getGId() {
        AB ab = this.ab;
        return ab != null ? ab.groupId : "";
    }

    public String getIP() {
        AdControl adControl = this.adControl;
        return adControl != null ? adControl.ip : "";
    }

    public int getParallelCnt() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.getParallelCnt();
        }
        return 2;
    }

    public String getSectionID() {
        Section section = this.section;
        return section != null ? section.sectionId : "";
    }

    public boolean hasTotalReqTime() {
        AdControl adControl = this.adControl;
        return adControl != null && adControl.totalRequestTimeout > 0;
    }

    public boolean isBFSerial() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.isBFSerial();
        }
        return false;
    }

    public boolean isTotalTimeout() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.isTotalRequestTimeout();
        }
        return false;
    }

    public boolean isValid() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            return adControl.isValid();
        }
        return false;
    }

    public void setTotalTimeout(boolean z) {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            adControl.setTotalRequestTimeout(z);
        }
    }

    public void updateTimeFromServer() {
        AdControl adControl = this.adControl;
        if (adControl != null) {
            adControl.updateTimeFromServer();
        }
    }
}
