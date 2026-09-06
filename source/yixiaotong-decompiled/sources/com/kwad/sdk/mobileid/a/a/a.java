package com.kwad.sdk.mobileid.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private ConnectivityManager aoL;
    private ConnectivityManager.NetworkCallback biZ;
    private volatile boolean bja = false;

    /* JADX INFO: renamed from: com.kwad.sdk.mobileid.a.a.a$a, reason: collision with other inner class name */
    public interface InterfaceC0764a {
        void Sl();
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.bja = true;
        return true;
    }

    public final void a(Context context, final InterfaceC0764a interfaceC0764a) {
        synchronized (this) {
            this.aoL = cF(context);
            try {
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(0).addCapability(12).build();
                if (this.biZ == null) {
                    this.biZ = new ConnectivityManager.NetworkCallback() { // from class: com.kwad.sdk.mobileid.a.a.a.1
                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onAvailable(Network network) {
                            a.this.aoL.bindProcessToNetwork(network);
                            if (interfaceC0764a != null && !a.this.bja) {
                                interfaceC0764a.Sl();
                            }
                            a.a(a.this, true);
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onUnavailable() {
                            a.this.aoL.bindProcessToNetwork(null);
                            c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onUnavailable unbindNetwork");
                            a.this.Sg();
                        }

                        @Override // android.net.ConnectivityManager.NetworkCallback
                        public final void onLost(Network network) {
                            a.this.aoL.bindProcessToNetwork(null);
                            c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "onLost unbindNetwork");
                            a.this.Sg();
                        }
                    };
                }
                if (!this.bja) {
                    this.aoL.requestNetwork(networkRequestBuild, this.biZ);
                } else {
                    c.d("MobileIdManager.RequestMobileDataOnWifiHelper", "isRequestUaidToken is true unbindNetwork");
                    Sg();
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
        }
    }

    public final void Sg() {
        synchronized (this) {
            if (this.biZ == null) {
                return;
            }
            try {
                ConnectivityManager connectivityManager = this.aoL;
                if (connectivityManager != null) {
                    connectivityManager.unregisterNetworkCallback(this.biZ);
                }
            } catch (Exception e) {
                ServiceProvider.reportSdkCaughtException(e);
            }
            this.aoL.bindProcessToNetwork(null);
            this.biZ = null;
        }
    }

    private static ConnectivityManager cF(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }
}
