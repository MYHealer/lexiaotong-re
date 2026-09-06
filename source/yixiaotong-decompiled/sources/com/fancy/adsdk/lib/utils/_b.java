package com.fancy.adsdk.lib.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.security.NetworkSecurityPolicy;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _b {
    public static volatile Integer _a;

    public static void _a() {
        Context context = PtgAdSdk.getContext();
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.targetSdkVersion < 28) {
                _a = 1;
            } else if ((applicationInfo.flags & C.BUFFER_FLAG_FIRST_SAMPLE) != 0) {
                _a = 1;
            } else {
                _a = Integer.valueOf(NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() ? 1 : 0);
            }
        } catch (Exception e) {
            Logger.e("HttpChecker", "Error checking manifest config", e);
            _a = -1;
        }
    }

    public static boolean _b() {
        Boolean supportHttp = PtgAdSdk.getConfig().getSupportHttp();
        if (supportHttp != null) {
            return supportHttp.booleanValue();
        }
        if (_a == null) {
            _a();
        }
        return _a.intValue() == 1;
    }
}
