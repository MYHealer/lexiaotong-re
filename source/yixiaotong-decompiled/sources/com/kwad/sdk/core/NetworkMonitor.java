package com.kwad.sdk.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.stub.StubApp;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NetworkMonitor {
    private static volatile boolean aKO;
    private final List<a> aKP;
    private final WeakHashMap<a, AdTemplate> aKQ;
    private final Map<a, AdTemplate> aKR;
    private boolean aKS;
    private final BroadcastReceiver aKT;

    public enum NetworkState {
        NETWORK_NONE,
        NETWORK_MOBILE,
        NETWORK_WIFI
    }

    public interface a {
        void a(NetworkState networkState);
    }

    /* synthetic */ NetworkMonitor(byte b) {
        this();
    }

    private NetworkMonitor() {
        this.aKP = new CopyOnWriteArrayList();
        WeakHashMap<a, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aKQ = weakHashMap;
        this.aKR = Collections.synchronizedMap(weakHashMap);
        this.aKS = false;
        this.aKT = new BroadcastReceiver() { // from class: com.kwad.sdk.core.NetworkMonitor.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                ConnectivityManager connectivityManager;
                try {
                    if (ContextCompat.checkSelfPermission(context, g.b) != 0 || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                        return;
                    }
                    if (1 == activeNetworkInfo.getType()) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_WIFI);
                    } else if (activeNetworkInfo.getType() == 0) {
                        NetworkMonitor.this.b(NetworkState.NETWORK_MOBILE);
                    } else {
                        NetworkMonitor.this.b(NetworkState.NETWORK_NONE);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        };
    }

    public static NetworkMonitor getInstance() {
        return Holder.INSTANCE.getInstance();
    }

    public final void a(Context context, a aVar) {
        bK(context);
        if (this.aKP.contains(aVar)) {
            return;
        }
        this.aKP.add(aVar);
    }

    public final void a(Context context, a aVar, AdTemplate adTemplate) {
        bK(context);
        this.aKR.put(aVar, adTemplate);
    }

    public final void a(a aVar) {
        if (aVar == null) {
            return;
        }
        this.aKP.remove(aVar);
    }

    private synchronized void bK(Context context) {
        if (aKO || context == null) {
            return;
        }
        try {
            StubApp.getOrigApplicationContext(context.getApplicationContext()).registerReceiver(this.aKT, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            aKO = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NetworkState networkState) {
        Iterator<a> it = this.aKP.iterator();
        while (it.hasNext()) {
            it.next().a(networkState);
        }
    }

    enum Holder {
        INSTANCE;

        private final NetworkMonitor mInstance = new NetworkMonitor(0);

        final NetworkMonitor getInstance() {
            return this.mInstance;
        }

        Holder() {
        }
    }
}
