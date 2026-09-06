package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class cr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile cr f1790a;

    private cr() {
    }

    public static cr a() {
        if (f1790a == null) {
            synchronized (cr.class) {
                if (f1790a == null) {
                    f1790a = new cr();
                }
            }
        }
        return f1790a;
    }

    public Boolean a(Context context) {
        try {
            boolean z = true;
            if (bn.a(context).a() < 29) {
                NetworkInfo networkInfoB = b(context);
                if (networkInfoB == null || !networkInfoB.isConnected() || networkInfoB.getType() != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            NetworkCapabilities networkCapabilitiesC = c(context);
            if (networkCapabilitiesC == null || !networkCapabilitiesC.hasCapability(12) || !networkCapabilitiesC.hasCapability(16) || !networkCapabilitiesC.hasTransport(1)) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return false;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.b) == 0) {
                return ((ConnectivityManager) origApplicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private NetworkCapabilities c(Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.b) != 0) {
                return null;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) origApplicationContext.getSystemService("connectivity");
            return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        } catch (Throwable unused) {
            return null;
        }
    }
}
