package com.heytap.msp.opos.sv.a.b;

import android.content.Context;
import android.os.Bundle;
import com.heytap.mspsdk.constants.Constants;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Integer f3453a;
    private static Object b = new Object();

    public static int a(Context context) {
        synchronized (b) {
            if (f3453a != null) {
                return f3453a.intValue();
            }
            try {
                Bundle bundle = context.getPackageManager().getApplicationInfo("com.heytap.htms", 128).metaData;
                if (bundle != null) {
                    f3453a = Integer.valueOf(bundle.getInt("opos_sv_kit_ver_code"));
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.c("KitUtils", "", th);
            }
            if (f3453a == null) {
                f3453a = 0;
            }
            com.opos.cmn.an.f.a.a("KitUtils", "getKitVersion:" + f3453a);
            return f3453a.intValue();
        }
    }

    public static void a(Bundle bundle) {
        bundle.putInt(Constants.BUNDLE_KEY_APP_MIN_VERSIONCODE, 1);
        bundle.putString(Constants.BUNDLE_KEY_MSP_SDK_KIT_NAME, "opos_sv");
    }
}
