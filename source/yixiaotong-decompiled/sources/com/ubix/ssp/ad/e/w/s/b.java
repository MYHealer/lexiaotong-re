package com.ubix.ssp.ad.e.w.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import com.ubix.ssp.ad.e.w.h;
import com.ubix.ssp.ad.e.w.n;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f8919a;
    private static C1105b b;
    private static c c;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.w.s.b$b, reason: collision with other inner class name */
    private static class C1105b extends BroadcastReceiver {
        private C1105b() {
        }

        /* synthetic */ C1105b(a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                b.a();
                n.l().f();
                h.b("---.NetworkUtils", "UbixBroadcastReceiver is receiving ConnectivityManager.CONNECTIVITY_ACTION broadcast");
            }
        }
    }

    private static class c extends ConnectivityManager.NetworkCallback {
        private c() {
        }

        /* synthetic */ c(a aVar) {
            this();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            b.a();
            n.l().f();
            h.b("---.NetworkUtils", "onAvailable is calling");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            b.a();
            h.b("---.NetworkUtils", "onCapabilitiesChanged is calling");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            b.a();
            h.b("---.NetworkUtils", "onLost is calling");
        }
    }

    public static void a() {
        f8919a = null;
    }

    public static void a(Context context) {
        try {
            if (c == null) {
                c = new c(null);
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerNetworkCallback(networkRequestBuild, c);
            }
        } catch (Exception e) {
            h.a(e);
        }
    }
}
