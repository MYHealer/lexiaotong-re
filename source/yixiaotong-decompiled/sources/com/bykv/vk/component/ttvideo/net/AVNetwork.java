package com.bykv.vk.component.ttvideo.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class AVNetwork {
    public static final int IS_MOBILE_NETWORK = 2;
    public static final int IS_UNKOWN_NETWORK = 0;
    public static final int IS_WIFF_NETWORK = 1;

    public static int getNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo == null) {
                return 0;
            }
            int type = activeNetworkInfo.getType();
            if (type == 1) {
                return 1;
            }
            if (type == 0) {
                return 2;
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
