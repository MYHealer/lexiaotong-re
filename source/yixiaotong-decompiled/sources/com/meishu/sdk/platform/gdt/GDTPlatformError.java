package com.meishu.sdk.platform.gdt;

import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTPlatformError extends AdPlatformError {
    public GDTPlatformError(AdError adError, SdkAdInfo sdkAdInfo) {
        this.platform = MSAdConfig.PLATFORM_GDT;
        this.message = adError.getErrorMsg();
        this.code = Integer.valueOf(adError.getErrorCode());
        this.adInfo = sdkAdInfo;
    }
}
