package com.huawei.hms.api;

import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class HuaweiServicesRepairableException extends UserRecoverableException {
    private final int statusCode;

    public HuaweiServicesRepairableException(int i, String str, Intent intent) {
        super(str, intent);
        this.statusCode = i;
    }

    public int getConnectionStatusCode() {
        return this.statusCode;
    }
}
