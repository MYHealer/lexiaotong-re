package com.yfanads.android.model;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class BindInfo {
    public static final int REQ_REQ = 1;
    public static final int REQ_SHOW = 2;
    public static final int SHOW_CLOSE = 3;
    public static final int SHOW_SHOW = 2;
    public static final int SHOW_SUCCESS = 1;
    private final String adId;
    private final int requestType;
    private final int showDelayTime;
    private final int showType;

    public BindInfo(String str, int i, int i2, int i3) {
        this.adId = str;
        this.requestType = i;
        this.showType = i2;
        this.showDelayTime = i3;
    }

    public String getAdId() {
        return this.adId;
    }

    public int getShowDelayTime() {
        return this.showDelayTime;
    }

    public boolean hasTopPush() {
        return !TextUtils.isEmpty(this.adId);
    }

    public boolean isReqReady(int i) {
        return this.requestType == i;
    }

    public boolean isShowReady(int i) {
        return this.showType == i;
    }

    public String toString() {
        return "adId:" + this.adId + "|dtt:" + this.requestType + "|dts:" + this.showType + "|dtt:" + this.showDelayTime;
    }
}
