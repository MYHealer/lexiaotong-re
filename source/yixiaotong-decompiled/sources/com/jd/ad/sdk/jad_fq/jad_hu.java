package com.jd.ad.sdk.jad_fq;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.jd.ad.sdk.logger.Logger;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu {
    public static String jad_an() {
        String hostAddress;
        Matcher matcher;
        Pattern patternCompile = Pattern.compile("(^10\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^172\\.(1[6-9]|2\\d|3[0-1])\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)|(^192\\.168\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)\\.(\\d{1}|[1-9]\\d|1\\d{2}|2[0-4]\\d|25\\d)$)");
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (inetAddressNextElement != null && (matcher = patternCompile.matcher((hostAddress = inetAddressNextElement.getHostAddress()))) != null && matcher.matches()) {
                            return hostAddress;
                        }
                    }
                }
            }
            return "";
        } catch (Exception e) {
            Logger.w(com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while get ip: ").append(e.getMessage()).toString(), new Object[0]);
            return "";
        }
    }

    public static String jad_an(Context context) {
        TelephonyManager telephonyManager;
        int simState;
        try {
            telephonyManager = (TelephonyManager) context.getSystemService("phone");
        } catch (SecurityException e) {
            e.printStackTrace();
            telephonyManager = null;
        }
        if (telephonyManager == null || (simState = telephonyManager.getSimState()) == 0 || simState == 1) {
            return "";
        }
        String networkOperatorName = telephonyManager.getNetworkOperatorName();
        if (TextUtils.isEmpty(networkOperatorName)) {
            return "";
        }
        if (networkOperatorName.contains("移动")) {
            return "mobile";
        }
        if (networkOperatorName.contains("联通")) {
            return "unicom";
        }
        return networkOperatorName.contains("电信") ? "telecom" : "";
    }
}
