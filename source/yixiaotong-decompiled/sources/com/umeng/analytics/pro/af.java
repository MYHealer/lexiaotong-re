package com.umeng.analytics.pro;

import android.content.Context;
import org.repackage.com.meizu.flyme.openidsdk.OpenIdHelper;

/* JADX INFO: compiled from: MeizuDeviceIdSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class af implements z {
    af() {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = OpenIdHelper.a();
        al.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return OpenIdHelper.b(context);
        }
        return null;
    }
}
