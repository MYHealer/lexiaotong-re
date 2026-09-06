package com.adprof.sdk;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class bg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f1092a = true;

    public static boolean a() {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) AdprofSdk.getInstance().getContext().getSystemService("connectivity")).getNetworkInfo(0);
            return (networkInfo != null && networkInfo.isConnected()) || b();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b() {
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) AdprofSdk.getInstance().getContext().getSystemService("connectivity")).getNetworkInfo(1);
            return networkInfo != null && networkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }
}
