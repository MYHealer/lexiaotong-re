package com.hihonor.hianalytics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    public static String a(Intent intent, String str) {
        StringBuilder sbAppend;
        if (intent == null) {
            sbAppend = new StringBuilder("getStringExtra name=").append(str).append(" intent null");
        } else {
            try {
                return intent.getStringExtra(str);
            } catch (Exception e) {
                sbAppend = new StringBuilder("getStringExtra name=").append(str).append(",failE=").append(SystemUtils.getDesensitizedException(e));
            }
        }
        j2.b("HaBroadcastUtil", sbAppend.toString());
        return null;
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
            j2.b("HaBroadcastUtil", "registerReceiver failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                j2.a("HaBroadcastUtil", "registerReceiver new,type:" + z);
                context.registerReceiver(broadcastReceiver, intentFilter, z ? 2 : 4);
            } else {
                a(context, broadcastReceiver, intentFilter);
            }
        } catch (Throwable th) {
            j2.b("HaBroadcastUtil", "registerReceiver failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public static void a(Context context, Intent intent) {
        try {
            context.sendBroadcast(intent);
        } catch (Exception e) {
            j2.b("HaBroadcastUtil", "sendBroadcast fail=" + SystemUtils.getDesensitizedException(e));
        }
    }
}
