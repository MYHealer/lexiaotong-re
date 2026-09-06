package com.meishu.sdk.platform.mimo;

import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.AdPlatformError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoPlatformError extends AdPlatformError {
    public MimoPlatformError(String str, Integer num, SdkAdInfo sdkAdInfo) {
        this.platform = "MIMO";
        this.message = str;
        this.code = num;
        this.adInfo = sdkAdInfo;
    }
}
