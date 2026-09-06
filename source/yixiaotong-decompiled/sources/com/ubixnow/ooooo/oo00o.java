package com.ubixnow.ooooo;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class oo00o<T> {
    public static final String trackingExtraInfo = "tracking_extra_info";
    private T absBaseAdapter;
    public String adType;
    public int auctionPrice;
    public int bannerAdapterHashCode;
    private o00O000 baseAdConfig;
    public o0O0o0 material;
    public oO00OOOo materialStatus;
    public int renderType;
    public String requestToken;
    public int checkMaterialStatus = -1;
    public HashMap<String, Object> extraInfo = new HashMap<>();
    public String csjPriceMethod = "";
    public boolean isRepeatClick = false;
    public boolean isCf = false;
    public OooO00o dsInfo = new OooO00o();
    public boolean isMuteIndependent = false;
    public boolean isAutoPlayIndependent = false;

    public static class OooO00o {
        public boolean OooO00o;
        public int OooO0O0;
    }

    public T getAbsBaseAdapter() {
        return this.absBaseAdapter;
    }

    public o00O000 getBaseAdConfig() {
        return this.baseAdConfig;
    }

    public int getBiddingEcpm() {
        return this.baseAdConfig.OooO0o;
    }

    public int getShowEcpm() {
        return this.baseAdConfig.OooOO0O;
    }

    public void setAbsBaseAdapter(T t) {
        this.absBaseAdapter = t;
    }

    public void setBaseAdConfig(o00O000 o00o000) {
        this.baseAdConfig = o00o000;
    }

    public void setBiddingEcpm(int i) {
        this.baseAdConfig.OooO0o = i;
    }

    public void setShowEcpm(int i) {
        this.baseAdConfig.OooOO0O = i;
    }

    public String toString() {
        return "AbsUbixInfo{, absBaseAdapter=" + this.absBaseAdapter.getClass() + ", baseAdConfig=" + this.baseAdConfig.OooO00o.toString() + '}';
    }
}
