package com.hihonor.adsdk.base.net.q.c;

import android.content.Context;
import com.hihonor.adsdk.common.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsa = "PackageUtil";

    public static int hnadsa(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            b.hnadsb(hnadsa, "getVersionCode, Exception: " + e.getMessage(), new Object[0]);
            return 0;
        }
    }
}
