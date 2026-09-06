package com.hihonor.adsdk.common.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.huawei.openalliance.ad.constant.as;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class o {
    private static final String hnadsa = "NetWorkUtil";
    public static final int hnadsb = 0;
    public static final int hnadsc = 1;
    public static final int hnadsd = 2;
    public static final int hnadse = 4;
    public static final int hnadsf = 5;
    public static final int hnadsg = 6;
    public static final int hnadsh = 7;
    public static String hnadsi = "China Mobile";
    public static String hnadsj = "China Telecom";
    public static String hnadsk = "China Unicom";
    public static String hnadsl = "Unknown";

    private o() {
    }

    private static NetworkInfo hnadsa(Context context) {
        try {
            return ((ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getActiveNetworkInfo, Exception: " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x007c A[RETURN, SYNTHETIC] */
    public static int hnadsb(Context context) {
        NetworkInfo networkInfoHnadsa = hnadsa(context);
        if (networkInfoHnadsa == null || !networkInfoHnadsa.isAvailable()) {
            return 0;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getNetworkType type: " + networkInfoHnadsa.getType() + ", subtype: " + networkInfoHnadsa.getSubtype() + ", SubtypeName: " + networkInfoHnadsa.getSubtypeName(), new Object[0]);
        if (networkInfoHnadsa.getType() == 1) {
            return 2;
        }
        if (networkInfoHnadsa.getType() != 0) {
            return networkInfoHnadsa.getType() == 9 ? 1 : 0;
        }
        switch (networkInfoHnadsa.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 4;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 5;
            case 13:
            case 18:
                return 6;
            case 19:
            default:
                String subtypeName = networkInfoHnadsa.getSubtypeName();
                if ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) {
                    return 5;
                }
                return 0;
            case 20:
                return 7;
        }
    }

    public static String hnadsc(Context context) {
        try {
            String simOperator = ((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getSimOperator();
            if ("46000".equalsIgnoreCase(simOperator) || "46002".equalsIgnoreCase(simOperator) || "46004".equalsIgnoreCase(simOperator) || "46007".equalsIgnoreCase(simOperator) || "46008".equalsIgnoreCase(simOperator)) {
                return hnadsi;
            }
            if ("46001".equalsIgnoreCase(simOperator) || "46006".equalsIgnoreCase(simOperator) || "46009".equalsIgnoreCase(simOperator)) {
                return hnadsk;
            }
            return ("46003".equalsIgnoreCase(simOperator) || "46005".equalsIgnoreCase(simOperator) || "46011".equalsIgnoreCase(simOperator)) ? hnadsj : hnadsl;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getSimOperator, Exception: " + e.getMessage(), new Object[0]);
            return "";
        }
    }

    public static boolean hnadsd(Context context) {
        return hnadsb(context) > 2;
    }

    public static boolean hnadse(Context context) {
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "context is null", new Object[0]);
            return false;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        boolean z = true;
        if (!r.hnadsa(origApplicationContext, com.kuaishou.weapon.p0.g.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, as.C, new Object[0]);
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) origApplicationContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "connectivity is null", new Object[0]);
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                AtomicReference atomicReference = new AtomicReference(Boolean.FALSE);
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities == null || !networkCapabilities.hasCapability(12)) {
                    z = false;
                }
                atomicReference.set(Boolean.valueOf(z));
                return ((Boolean) atomicReference.get()).booleanValue();
            }
            return false;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isNetWorkEnable, Exception: " + e.getMessage(), new Object[0]);
        }
    }

    public static boolean hnadsf(Context context) {
        NetworkInfo networkInfoHnadsa = hnadsa(context);
        return networkInfoHnadsa != null && networkInfoHnadsa.getType() == 1;
    }
}
