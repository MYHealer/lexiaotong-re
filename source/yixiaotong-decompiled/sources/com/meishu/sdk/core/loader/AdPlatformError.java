package com.meishu.sdk.core.loader;

import com.google.gson.GsonBuilder;
import com.meishu.sdk.core.domain.SdkAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdPlatformError {
    public SdkAdInfo adInfo;
    public Integer code;
    public String message;
    public String platform;

    public AdPlatformError() {
        this.code = -1;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPlatform() {
        return this.platform;
    }

    public SdkAdInfo getSdkInfo() {
        return this.adInfo;
    }

    public void post(IAdLoadListener iAdLoadListener) {
        if (iAdLoadListener != null) {
            iAdLoadListener.onAdPlatformError(this);
            iAdLoadListener.onAdError();
        }
    }

    public String toString() {
        return new GsonBuilder().serializeNulls().create().toJson(this);
    }

    public AdPlatformError(String str, Integer num) {
        Integer.valueOf(-1);
        this.message = str;
        this.code = num;
    }
}
