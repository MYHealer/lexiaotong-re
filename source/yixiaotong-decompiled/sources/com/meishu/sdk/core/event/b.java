package com.meishu.sdk.core.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: compiled from: LocalBroadcastHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f4793a;

    static {
        boolean z;
        try {
            Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        f4793a = z;
    }

    public static void a(Context context, Intent intent) {
        try {
            if (f4793a) {
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
            } else {
                a.d.a(context, intent);
            }
        } catch (Throwable th) {
            LogUtil.e("LocalBroadcastHelper", "sendBroadcast error.", th);
        }
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (context != null && broadcastReceiver != null) {
            try {
                if (f4793a) {
                    LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
                    return;
                }
                int iCountActions = intentFilter.countActions();
                if (iCountActions <= 0) {
                    LogUtil.e("LocalBroadcastHelper", "registerReceiver skip: filter has no action");
                    return;
                }
                String[] strArr = new String[iCountActions];
                for (int i = 0; i < iCountActions; i++) {
                    strArr[i] = intentFilter.getAction(i);
                }
                a.d.a(broadcastReceiver, strArr);
                return;
            } catch (Throwable th) {
                LogUtil.e("LocalBroadcastHelper", "registerReceiver error.", th);
                return;
            }
        }
        LogUtil.e("LocalBroadcastHelper", "registerReceiver skip: context, receiver or filter is null");
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver) {
        if (context != null && broadcastReceiver != null) {
            try {
                if (f4793a) {
                    LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
                } else {
                    a.d.a(broadcastReceiver);
                }
                return;
            } catch (Throwable th) {
                LogUtil.e("LocalBroadcastHelper", "unregisterReceiver error.", th);
                return;
            }
        }
        LogUtil.e("LocalBroadcastHelper", "unregisterReceiver skip: context or receiver is null");
    }
}
