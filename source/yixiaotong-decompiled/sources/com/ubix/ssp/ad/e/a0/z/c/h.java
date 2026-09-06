package com.ubix.ssp.ad.e.a0.z.c;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h extends com.ubix.ssp.ad.e.a0.z.b {
    @Override // com.ubix.ssp.ad.e.a0.z.b
    public String a() {
        return com.ubix.ssp.ad.e.a0.z.b.a("ro.vivo.os.build.display.id", "");
    }

    @Override // com.ubix.ssp.ad.e.a0.z.b
    public String b() {
        String strA = com.ubix.ssp.ad.e.a0.z.b.a("ro.build.display.id", "");
        if (TextUtils.isEmpty(strA)) {
            strA = com.ubix.ssp.ad.e.a0.z.b.a("ro.build.software.version", "");
        }
        return TextUtils.isEmpty(strA) ? com.ubix.ssp.ad.e.a0.z.b.a("ro.vivo.product.version", "") : strA;
    }
}
