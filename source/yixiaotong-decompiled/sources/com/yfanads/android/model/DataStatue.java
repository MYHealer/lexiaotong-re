package com.yfanads.android.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public enum DataStatue {
    NORMAL(YFAdError.ERROR_EMPTY),
    HIT_FREQUENCY(YFAdError.ERROR_OVER_NUM),
    HIT_HOUR(YFAdError.ERROR_OVER_HOUR),
    HIT_DAY(YFAdError.ERROR_OVER_DAY);

    String errorCode;

    DataStatue(String str) {
        this.errorCode = str;
    }

    public String getValue() {
        return this.errorCode;
    }
}
