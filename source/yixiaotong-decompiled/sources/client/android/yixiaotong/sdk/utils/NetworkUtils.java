package client.android.yixiaotong.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class NetworkUtils {
    private NetworkUtils() {
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1)) == null) {
            return false;
        }
        return networkInfo.isConnectedOrConnecting();
    }

    public static boolean isMobileConnected(Context context) {
        NetworkInfo networkInfo;
        if (context == null || (networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0)) == null) {
            return false;
        }
        return networkInfo.isConnectedOrConnecting();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.isConnectedOrConnecting()) {
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static NetworkInfo getAvailableNetwork(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return networkInfo;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.isConnectedOrConnecting()) {
            return networkInfo2;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return null;
        }
        return activeNetworkInfo;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x0085  */
    /* JADX WARN: Code duplicated, block: B:57:0x0087  */
    public static int getNetworkType(Context context) {
        NetworkInfo availableNetwork;
        if (context == null || (availableNetwork = getAvailableNetwork(context)) == null || !availableNetwork.isAvailable()) {
            return 0;
        }
        int type = availableNetwork.getType();
        if (type != 0) {
            return type == 1 ? 1 : 0;
        }
        int subtype = availableNetwork.getSubtype();
        String subtypeName = availableNetwork.getSubtypeName();
        int i = 4;
        if (subtype == 4 || subtype == 1 || subtype == 2 || subtype == 7 || subtype == 11) {
            i = 2;
        } else if (subtype == 3 || subtype == 8 || subtype == 10 || subtype == 15 || subtype == 9 || subtype == 14 || subtype == 5 || subtype == 6 || subtype == 12) {
            i = 3;
        } else if (subtype != 13) {
            if (subtypeName != null && (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) {
                i = 3;
            } else if (subtypeName == null || !(subtypeName.equalsIgnoreCase("FDD-LTE") || subtypeName.equalsIgnoreCase("TDD-LTE"))) {
                i = 2;
            } else {
                i = 5;
            }
        }
        return i;
    }

    public static String getSimOperatorInfo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 || telephonyManager.getSimState() != 5) {
            return "其它";
        }
        String simOperator = telephonyManager.getSimOperator();
        if (TextUtils.isEmpty(simOperator)) {
            return "其它";
        }
        if (simOperator.equals("46000") || simOperator.equals("46002") || simOperator.equals("46007")) {
            return "中国移动";
        }
        if (simOperator.equals("46001") || simOperator.equals("46006")) {
            return "中国联通";
        }
        if (simOperator.equals("46003") || simOperator.equals("46005")) {
            return "中国电信";
        }
        if (simOperator.equals("46020")) {
            return "中国铁通";
        }
        if (simOperator.equals("45400") || simOperator.equals("45402") || simOperator.equals("45410") || simOperator.equals("45418")) {
            return "CSL Limited";
        }
        if (simOperator.equals("45401")) {
            return "CITIC Telecom 1616";
        }
        if (simOperator.equals("45403") || simOperator.equals("45404") || simOperator.equals("45405")) {
            return "Hutchison Telecom";
        }
        if (simOperator.equals("45406") || simOperator.equals("45415") || simOperator.equals("45417")) {
            return "SmarTone Mobile Communications Limited";
        }
        if (simOperator.equals("45407")) {
            return "China Unicom (Hong Kong) Limited";
        }
        if (simOperator.equals("45408")) {
            return "Trident Telecom";
        }
        if (simOperator.equals("45411")) {
            return "China-Hong Kong Telecom";
        }
        if (simOperator.equals("45412")) {
            return "China Mobile Hong Kong Company Limited";
        }
        if (simOperator.equals("45414")) {
            return "Hutchison Telecom";
        }
        if (simOperator.equals("45416") || simOperator.equals("45419") || simOperator.equals("45429")) {
            return "PCCW Limited";
        }
        if (simOperator.equals("46601")) {
            return "FarEasTone";
        }
        if (simOperator.equals("46605")) {
            return "APTG";
        }
        if (simOperator.equals("46606")) {
            return "Tuntex";
        }
        if (simOperator.equals("46611")) {
            return "Chunghwa LDM";
        }
        if (simOperator.equals("46688")) {
            return "KG Telecom";
        }
        if (simOperator.equals("46689")) {
            return "VIBO";
        }
        if (simOperator.equals("46692")) {
            return "Chungwa";
        }
        if (simOperator.equals("46693")) {
            return "MobiTai";
        }
        if (simOperator.equals("46697")) {
            return "Taiwan Mobile";
        }
        return simOperator.equals("46699") ? "TransAsia" : "其它";
    }
}
