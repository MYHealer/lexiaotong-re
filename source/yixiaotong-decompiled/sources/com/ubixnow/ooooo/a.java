package com.ubixnow.ooooo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    private static final int OooO00o = 307;
    private static String OooO0O0 = null;
    private static final String OooO0OO = "---.NetworkUtils";
    private static OooO0O0 OooO0Oo = null;
    public static final int OooO0o = 20;
    private static OooO0OO OooO0o0 = null;
    public static final int OooO0oO = 29;
    public static int OooO0oo;

    public static /* synthetic */ class OooO00o {
    }

    public static class OooO0O0 extends BroadcastReceiver {
        private OooO0O0() {
        }

        public /* synthetic */ OooO0O0(OooO00o oooO00o) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                a.OooO00o();
                ooooO0O0.OooOoO().OooOo0O();
                oOO0O0O.OooO0O0(a.OooO0OO, "UbixBroadcastReceiver is receiving ConnectivityManager.CONNECTIVITY_ACTION broadcast");
            }
        }
    }

    public static class OooO0OO extends ConnectivityManager.NetworkCallback {
        private OooO0OO() {
        }

        public /* synthetic */ OooO0OO(OooO00o oooO00o) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            a.OooO00o();
            ooooO0O0.OooOoO().OooOo0O();
            oOO0O0O.OooO0O0(a.OooO0OO, "onAvailable is calling");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            a.OooO00o();
            oOO0O0O.OooO0O0(a.OooO0OO, "onCapabilitiesChanged is calling");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            a.OooO00o();
            oOO0O0O.OooO0O0(a.OooO0OO, "onLost is calling");
        }
    }

    public static int OooO00o(Context context) {
        int networkType;
        try {
            ooooO000.OooO0O0("--调用系统方法获取：", "net type");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int iOooO0O0 = OooO0O0();
            if (iOooO0O0 == -1) {
                networkType = telephonyManager.getNetworkType();
            } else {
                try {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDataNetworkType", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    networkType = ((Integer) declaredMethod.invoke(telephonyManager, Integer.valueOf(iOooO0O0))).intValue();
                } catch (Throwable unused) {
                    networkType = telephonyManager.getNetworkType();
                }
            }
            return networkType == 13 ? OooO00o(context, networkType) : networkType;
        } catch (Throwable unused2) {
            return 0;
        }
    }

    private static int OooO00o(Context context, int i) {
        ServiceState serviceState;
        if (Build.VERSION.SDK_INT < 29 || context.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int iOooO0O0 = OooO0O0();
            if (iOooO0O0 == -1) {
                serviceState = telephonyManager.getServiceState();
            } else {
                try {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(iOooO0O0));
                } catch (Throwable unused) {
                    serviceState = telephonyManager.getServiceState();
                }
            }
            if (serviceState == null || !OooO00o(serviceState.toString())) {
                return i;
            }
            return 20;
        } catch (Exception unused2) {
            return i;
        }
    }

    public static String OooO00o(HttpURLConnection httpURLConnection, String str) throws MalformedURLException {
        if (httpURLConnection == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String headerField = httpURLConnection.getHeaderField("Location");
        if (TextUtils.isEmpty(headerField)) {
            headerField = httpURLConnection.getHeaderField("location");
        }
        if (TextUtils.isEmpty(headerField)) {
            return null;
        }
        if (headerField.startsWith("http://") || headerField.startsWith("https://")) {
            return headerField;
        }
        URL url = new URL(str);
        return url.getProtocol() + "://" + url.getHost() + headerField;
    }

    public static void OooO00o() {
        OooO0O0 = null;
    }

    public static boolean OooO00o(int i) {
        return i == 301 || i == 302 || i == 307;
    }

    private static boolean OooO00o(ConnectivityManager connectivityManager) {
        if (connectivityManager == null) {
            return false;
        }
        try {
            OooO0oo = 4;
            Network activeNetwork = connectivityManager.getActiveNetwork();
            if (activeNetwork == null) {
                return false;
            }
            OooO0oo = 7;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null) {
                return false;
            }
            OooO0oo = 8;
            return OooO00o(networkCapabilities);
        } catch (Exception e) {
            OooO0oo = 6;
            e.printStackTrace();
            return false;
        }
    }

    public static boolean OooO00o(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        OooO0oo = 9;
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(7) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
    }

    private static boolean OooO00o(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    private static int OooO0O0() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    public static boolean OooO0O0(Context context) {
        if (!f.OooO00o(context, com.kuaishou.weapon.p0.g.b)) {
            OooO0oo = 1;
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            OooO0oo = 2;
            return OooO00o(connectivityManager);
        } catch (Exception e) {
            OooO0oo = 3;
            oOO0O0O.OooO00o(e);
            return false;
        }
    }

    public static void OooO0OO(Context context) {
        try {
            if (OooO0o0 == null) {
                OooO0o0 = new OooO0OO(null);
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(networkRequestBuild, OooO0o0);
            }
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }

    public static void OooO0Oo(Context context) {
        ConnectivityManager connectivityManager;
        try {
            if (OooO0o0 == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return;
            }
            connectivityManager.unregisterNetworkCallback(OooO0o0);
        } catch (Exception e) {
            oOO0O0O.OooO00o(e);
        }
    }
}
