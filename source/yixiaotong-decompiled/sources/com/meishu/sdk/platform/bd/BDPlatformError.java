package com.meishu.sdk.platform.bd;

import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDPlatformError extends AdPlatformError {
    public BDPlatformError(String str, SdkAdInfo sdkAdInfo) {
        this.message = str;
        this.adInfo = sdkAdInfo;
        this.platform = MSAdConfig.PLATFORM_BD;
    }
}
