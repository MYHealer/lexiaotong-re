package com.hihonor.adsdk.base.net;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ApiResult<T> {
    public T data;

    @SerializedName("code")
    @Expose
    public String errorCode;

    @SerializedName(CrashHianalyticsData.MESSAGE)
    @Expose
    public String errorMessage;

    public boolean hnadsa() {
        return "0".equals(this.errorCode);
    }
}
