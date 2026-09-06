package com.huawei.hms.hatool;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class r0 {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x0022 A[ORIG_RETURN, RETURN] */
    private static String a(int i, String str) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                if (str.equalsIgnoreCase("TD-SCDMA") || str.equalsIgnoreCase("WCDMA") || str.equalsIgnoreCase("CDMA2000")) {
                    return "3G";
                }
                return str;
        }
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || context.getPackageManager().checkPermission(com.kuaishou.weapon.p0.g.b, context.getPackageName()) != 0) {
            v.f("hmsSdk", "not have network state phone permission!");
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0) {
            String subtypeName = activeNetworkInfo.getSubtypeName();
            v.c("hmsSdk", "Network getSubtypeName : " + subtypeName);
            return a(activeNetworkInfo.getSubtype(), subtypeName);
        }
        if (activeNetworkInfo.getType() == 16) {
            v.f("hmsSdk", "type name = COMPANION_PROXY");
            return "COMPANION_PROXY";
        }
        if (activeNetworkInfo.getType() == 9) {
            v.c("hmsSdk", "type name = ETHERNET");
            return "ETHERNET";
        }
        v.c("hmsSdk", "type name = " + activeNetworkInfo.getType());
        return "OTHER_NETWORK_TYPE";
    }
}
