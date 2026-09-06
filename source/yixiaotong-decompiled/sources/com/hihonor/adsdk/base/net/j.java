package com.hihonor.adsdk.base.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j {
    private static final String hnadsa = "NetworkType";
    public static final int hnadsb = 0;
    public static final int hnadsc = 3;
    public static final int hnadsd = 1;
    public static final int hnadse = 2;
    public static final int hnadsf = 4;
    public static final int hnadsg = 5;
    private static final String hnadsh = "wifi";
    private static final String hnadsi = "unknown";
    private static final String hnadsj = "2G";
    private static final String hnadsk = "3G";
    private static final String hnadsl = "4G";
    private static final String hnadsm = "5G";
    private static final int hnadsn = -101;

    private static int hnadsa(int i) {
        if (i == -101) {
            return 3;
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 1;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 2;
            case 13:
                return 4;
            default:
                return 5;
        }
    }

    public static String hnadsa(Context context) {
        int iHnadsb = hnadsb(context);
        if (iHnadsb == 1) {
            return hnadsj;
        }
        if (iHnadsb == 2) {
            return hnadsk;
        }
        if (iHnadsb == 3) {
            return hnadsh;
        }
        if (iHnadsb != 4) {
            return iHnadsb != 5 ? "unknown" : hnadsm;
        }
        return hnadsl;
    }

    public static int hnadsb(Context context) {
        int networkType = 0;
        if (context == null) {
            return 0;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext()).getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable() || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                networkType = -101;
            } else if (type == 0) {
                networkType = ((TelephonyManager) origApplicationContext.getSystemService("phone")).getNetworkType();
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getNetworkType, get Network Type error, Exception: " + e.getMessage(), new Object[0]);
        }
        return hnadsa(networkType);
    }

    public static boolean hnadsc(Context context) {
        return hnadsb(context) != 0;
    }

    public static boolean hnadsd(Context context) {
        return hnadsb(context) == 3;
    }
}
