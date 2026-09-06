package com.meishu.sdk.platform.csj;

import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJPlatformError extends AdPlatformError {
    public CSJPlatformError(String str, Integer num, SdkAdInfo sdkAdInfo) {
        this.platform = MSAdConfig.PLATFORM_CSJ;
        this.message = str;
        this.code = num;
        this.adInfo = sdkAdInfo;
    }
}
