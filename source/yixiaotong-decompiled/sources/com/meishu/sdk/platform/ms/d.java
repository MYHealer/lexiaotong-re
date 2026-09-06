package com.meishu.sdk.platform.ms;

import com.meishu.sdk.core.loader.AdPlatformError;

/* JADX INFO: compiled from: MSPlatformError.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends AdPlatformError {
    public d(String str, Integer num) {
        this.platform = "MS";
        this.message = str;
        this.code = num;
    }
}
