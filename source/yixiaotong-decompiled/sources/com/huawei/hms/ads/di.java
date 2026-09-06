package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class di extends dh {
    private ej Code;

    public di(Context context) {
        this.Code = ej.Code(context);
    }

    @Override // com.huawei.hms.ads.dh
    public boolean Code() {
        if (this.Code.j() >= com.huawei.openalliance.ad.utils.z.Code()) {
            return true;
        }
        return V();
    }
}
