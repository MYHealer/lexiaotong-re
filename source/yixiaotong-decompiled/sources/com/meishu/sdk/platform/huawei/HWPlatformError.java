package com.meishu.sdk.platform.huawei;

import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWPlatformError extends AdPlatformError {
    public HWPlatformError(String str, int i, SdkAdInfo sdkAdInfo) {
        this.platform = "HW";
        this.message = str;
        this.code = Integer.valueOf(i);
        this.adInfo = sdkAdInfo;
    }
}
