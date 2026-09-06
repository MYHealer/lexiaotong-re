package com.hihonor.adsdk.base.net;

import android.net.ConnectivityManager;
import android.net.Network;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.o;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {
    private static boolean hnadsa = true;
    private static boolean hnadsb = false;
    private static final String hnadsc = "NetWorkMonitor";
    private static final Set<a> hnadsd = new HashSet();
    private static b hnadse = null;

    public interface a {
        void hnadsa();
    }

    public static class b extends ConnectivityManager.NetworkCallback {
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            super.onAvailable(network);
            com.hihonor.adsdk.common.b.b.hnadsc(i.hnadsc, "onAvailable", new Object[0]);
            com.hihonor.adsdk.base.g.i.hnadsa("Net work Available", 0L);
            if (!com.hihonor.adsdk.base.init.h.hnadsb()) {
                com.hihonor.adsdk.base.init.h.hnadsa("onAvailable");
            }
            i.hnadsg();
            i.hnadse();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            super.onLost(network);
            com.hihonor.adsdk.common.b.b.hnadsc(i.hnadsc, "onLost", new Object[0]);
            i.hnadsg();
            i.hnadse();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            super.onUnavailable();
            com.hihonor.adsdk.common.b.b.hnadsc(i.hnadsc, "onUnavailable", new Object[0]);
            i.hnadse();
            boolean unused = i.hnadsa = false;
            boolean unused2 = i.hnadsb = false;
        }
    }

    public static synchronized void hnadse() {
        for (a aVar : hnadsd) {
            if (aVar != null) {
                aVar.hnadsa();
            }
        }
    }

    public static synchronized void hnadsf() {
        hnadsd.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hnadsg() {
        hnadsa = o.hnadse(HnAds.get().getContext());
        hnadsb = o.hnadsf(HnAds.get().getContext());
    }

    public static boolean hnadsc() {
        if (!hnadsa) {
            hnadsa = o.hnadse(HnAds.get().getContext());
        }
        return hnadsa;
    }

    public static boolean hnadsd() {
        if (!hnadsb) {
            hnadsb = o.hnadsf(HnAds.get().getContext());
        }
        return hnadsb;
    }

    public static synchronized void hnadsa(a aVar) {
        hnadsd.add(aVar);
    }

    public static void hnadsb() {
        if (hnadse != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "init ConnectivityManager already register", new Object[0]);
            return;
        }
        try {
            hnadse = new b();
            ConnectivityManager connectivityManager = (ConnectivityManager) HnAds.get().getContext().getSystemService("connectivity");
            if (connectivityManager != null) {
                connectivityManager.registerDefaultNetworkCallback(hnadse);
            }
            hnadsg();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "init ConnectivityManager error e = " + e.getMessage(), new Object[0]);
        }
    }

    public static synchronized void hnadsb(a aVar) {
        Set<a> set = hnadsd;
        if (set.contains(aVar)) {
            set.remove(aVar);
        }
    }
}
