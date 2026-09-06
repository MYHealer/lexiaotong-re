package com.jd.ad.sdk.jad_zk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_sf {
    public static volatile jad_sf jad_dq;
    public final jad_cp jad_an;
    public final Set<com.jd.ad.sdk.jad_zk.jad_cp.jad_an> jad_bo = new HashSet();
    public boolean jad_cp;

    public class jad_an implements com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<ConnectivityManager> {
        public final /* synthetic */ Context jad_an;

        public jad_an(jad_sf jad_sfVar, Context context) {
            this.jad_an = context;
        }

        @Override // com.jd.ad.sdk.jad_ir.jad_fs.jad_bo
        public ConnectivityManager get() {
            return (ConnectivityManager) this.jad_an.getSystemService("connectivity");
        }
    }

    public class jad_bo implements com.jd.ad.sdk.jad_zk.jad_cp.jad_an {
        public jad_bo() {
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_cp.jad_an
        public void jad_an(boolean z) {
            ArrayList arrayList;
            synchronized (jad_sf.this) {
                arrayList = new ArrayList(jad_sf.this.jad_bo);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.jd.ad.sdk.jad_zk.jad_cp.jad_an) it.next()).jad_an(z);
            }
        }
    }

    public interface jad_cp {
        void jad_an();

        boolean jad_bo();
    }

    public static final class jad_dq implements jad_cp {
        public boolean jad_an;
        public final com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_bo;
        public final com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<ConnectivityManager> jad_cp;
        public final ConnectivityManager.NetworkCallback jad_dq = new jad_an();

        public class jad_an extends ConnectivityManager.NetworkCallback {
            public jad_an() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                com.jd.ad.sdk.jad_ir.jad_ly.jad_bo().post(new jad_tg(this, true));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                com.jd.ad.sdk.jad_ir.jad_ly.jad_bo().post(new jad_tg(this, false));
            }
        }

        public jad_dq(com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<ConnectivityManager> jad_boVar, com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_anVar) {
            this.jad_cp = jad_boVar;
            this.jad_bo = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_sf.jad_cp
        public void jad_an() {
            this.jad_cp.get().unregisterNetworkCallback(this.jad_dq);
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_sf.jad_cp
        public boolean jad_bo() {
            this.jad_an = this.jad_cp.get().getActiveNetwork() != null;
            try {
                this.jad_cp.get().registerDefaultNetworkCallback(this.jad_dq);
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Logger.w("ConnectivityMonitor", "Failed to register callback", e);
                }
                return false;
            }
        }
    }

    public static final class jad_er implements jad_cp {
        public final Context jad_an;
        public final com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_bo;
        public final com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<ConnectivityManager> jad_cp;
        public boolean jad_dq;
        public final BroadcastReceiver jad_er = new jad_an();

        public class jad_an extends BroadcastReceiver {
            public jad_an() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                jad_er jad_erVar = jad_er.this;
                boolean z = jad_erVar.jad_dq;
                jad_erVar.jad_dq = jad_erVar.jad_cp();
                if (z != jad_er.this.jad_dq) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        Logger.d("ConnectivityMonitor", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("connectivity changed, isConnected: ").append(jad_er.this.jad_dq).toString());
                    }
                    jad_er jad_erVar2 = jad_er.this;
                    jad_erVar2.jad_bo.jad_an(jad_erVar2.jad_dq);
                }
            }
        }

        public jad_er(Context context, com.jd.ad.sdk.jad_ir.jad_fs.jad_bo<ConnectivityManager> jad_boVar, com.jd.ad.sdk.jad_zk.jad_cp.jad_an jad_anVar) {
            this.jad_an = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.jad_cp = jad_boVar;
            this.jad_bo = jad_anVar;
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_sf.jad_cp
        public void jad_an() {
            this.jad_an.unregisterReceiver(this.jad_er);
        }

        @Override // com.jd.ad.sdk.jad_zk.jad_sf.jad_cp
        public boolean jad_bo() {
            this.jad_dq = jad_cp();
            try {
                this.jad_an.registerReceiver(this.jad_er, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), null, null);
                return true;
            } catch (SecurityException e) {
                if (!Log.isLoggable("ConnectivityMonitor", 5)) {
                    return false;
                }
                Logger.w("ConnectivityMonitor", "Failed to register", e);
                return false;
            }
        }

        public boolean jad_cp() {
            try {
                NetworkInfo activeNetworkInfo = this.jad_cp.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Logger.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e);
                }
                return true;
            }
        }
    }

    public jad_sf(Context context) {
        this.jad_an = new jad_dq(com.jd.ad.sdk.jad_ir.jad_fs.jad_an(new jad_an(this, context)), new jad_bo());
    }

    public static jad_sf jad_an(Context context) {
        if (jad_dq == null) {
            synchronized (jad_sf.class) {
                if (jad_dq == null) {
                    jad_dq = new jad_sf(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return jad_dq;
    }
}
