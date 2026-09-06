package client.android.yixiaotong.util.android;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NetworkUtils {
    public static boolean isNetwork = true;

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

    private static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isConnectedOrConnecting();
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

    public static int getNetworkType(Context context) {
        NetworkInfo availableNetwork;
        if (context == null || (availableNetwork = getAvailableNetwork(context)) == null || !availableNetwork.isAvailable()) {
            return 0;
        }
        int type = availableNetwork.getType();
        int i = 1;
        if (type == 0) {
            int subtype = availableNetwork.getSubtype();
            if (subtype != 4 && subtype != 1 && subtype != 2 && subtype != 11) {
                i = 3;
                if (subtype != 3 && subtype != 8 && subtype != 10 && subtype != 15 && subtype != 9 && subtype != 14 && subtype != 5 && subtype != 6 && subtype != 12 && subtype != 3) {
                    if (subtype == 13) {
                        return 4;
                    }
                }
            }
            return 2;
        }
        if (type != 1) {
            return 0;
        }
        return i;
    }

    public static String getSimOperatorInfo(Context context) {
        String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        if (simOperator == null) {
            return "其它";
        }
        if (simOperator.equals("46000") || simOperator.equals("46002")) {
            return "中国移动";
        }
        if (simOperator.equals("46001")) {
            return "中国联通";
        }
        return simOperator.equals("46003") ? "中国电信" : "其它";
    }

    public static boolean isFlightModeEnabled(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
    }
}
