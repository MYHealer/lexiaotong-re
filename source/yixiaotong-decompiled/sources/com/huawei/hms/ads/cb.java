package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.DislikeAdReason;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cb implements DislikeAdReason {
    private String Code;

    cb(String str) {
        this.Code = str;
    }

    @Override // com.huawei.hms.ads.nativead.DislikeAdReason
    public String getDescription() {
        return this.Code;
    }
}
