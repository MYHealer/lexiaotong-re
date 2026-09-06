package com.fancy.adsdk.lib.model;

import android.os.Parcelable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface AdError extends Parcelable {
    public static final int ERROR_NETWORK = 1003;
    public static final String ERROR_NO_AD_STR = "没有获取到广告";
    public static final int ERROR_NO_INIT = 1001;
    public static final String ERROR_NO_INIT_STR = "未传入PtgAppId";
    public static final int ERROR_OTHER = 1006;
    public static final int ERROR_RESPONSE = 1004;
    public static final int ERROR_UNKOWN = 1005;

    int getConsumerErrCode();

    String getConsumerErrMsg();

    String getConsumerType();

    int getErrorCode();

    String getMessage();

    Throwable getThrowable();
}
