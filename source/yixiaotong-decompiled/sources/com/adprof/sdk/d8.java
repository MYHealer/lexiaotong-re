package com.adprof.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class d8 extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1124a;

    public d8(Context context) {
        this.f1124a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        pk.a("updateNetworkType registerNetworkCallback  onAvailable " + network.hashCode());
        super.onAvailable(network);
        g8.f313a.add(network);
        g8.m639a(this.f1124a);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        super.onCapabilitiesChanged(network, networkCapabilities);
        g8.m639a(this.f1124a);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        pk.a("updateNetworkType registerNetworkCallback onLost" + network.hashCode());
        super.onLost(network);
        g8.f311a = f8.UNKNOWN;
        String str = g8.f312a;
        try {
            g8.f309a = network;
            g8.f313a.remove(network);
            g8.m639a(this.f1124a);
        } catch (Throwable th) {
            pk.b("updateNetworkType onLost error: ", th);
        }
    }
}
