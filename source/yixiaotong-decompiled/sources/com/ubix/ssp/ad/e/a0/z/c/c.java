package com.ubix.ssp.ad.e.a0.z.c;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends com.ubix.ssp.ad.e.a0.z.b {
    @Override // com.ubix.ssp.ad.e.a0.z.b
    public String a() {
        return "HarmonyOS";
    }

    @Override // com.ubix.ssp.ad.e.a0.z.b
    public String b() {
        String strA = com.ubix.ssp.ad.e.a0.z.b.a("ro.build.display.id", "");
        return TextUtils.isEmpty(strA) ? com.ubix.ssp.ad.e.a0.z.b.a("ro.build.ver.physical", "") : strA;
    }
}
