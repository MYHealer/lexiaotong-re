package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.stub.StubApp;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class b {
    private static final Pattern bvm = Pattern.compile("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");

    private static boolean iP(String str) {
        if (str == null) {
            return false;
        }
        return bvm.matcher(str).matches();
    }

    public static String iQ(String str) {
        if (str == null) {
            return "";
        }
        String[] strArrSplit = str.split("\\s+");
        return (strArrSplit.length >= 5 && iP(strArrSplit[4])) ? strArrSplit[4] : "";
    }

    public static String gs(int i) {
        return String.format("%d.%d.%d.%d", Integer.valueOf(i & 255), Integer.valueOf((i >> 8) & 255), Integer.valueOf((i >> 16) & 255), Integer.valueOf((i >> 24) & 255));
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity")).getNetworkInfo(1);
            return networkInfo != null && networkInfo.isConnected();
        } catch (Exception unused) {
        }
    }
}
