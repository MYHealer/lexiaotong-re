package com.hihonor.hianalytics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.hnha.r3;
import com.hihonor.hianalytics.hnha.t3;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.j;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MonitorReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3712a = false;
    private long b = 0;
    private String c = "";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Context context) {
        j2.a("MonitorReceiver", "onReceive action=" + str + ",context=" + context);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str)) {
            this.b = SystemClock.elapsedRealtime();
            this.c = j.a();
        }
        p2.e().c();
    }

    public String a(boolean z) throws IllegalAccessException, InvocationTargetException {
        if (!TextUtils.isEmpty(this.c) && !"2G".equals(this.c)) {
            return this.c;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.b;
        if (!z && jElapsedRealtime < 7200000) {
            return this.c;
        }
        this.b = SystemClock.elapsedRealtime();
        String strA = j.a();
        this.c = strA;
        return strA;
    }

    public synchronized void a() {
        if (this.f3712a) {
            return;
        }
        this.f3712a = true;
        this.c = j.a();
        this.b = SystemClock.elapsedRealtime();
        j2.a("MonitorReceiver", "start networkType=" + this.c);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
        intentFilter.addAction("android.intent.action.TIME_SET");
        a.a(SystemUtils.getContext(), this, intentFilter);
    }

    public boolean b(boolean z) throws IllegalAccessException, InvocationTargetException {
        if (!TextUtils.isEmpty(this.c) && !"2G".equals(this.c)) {
            return true;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.b;
        if (!z && jElapsedRealtime < 7200000) {
            return false;
        }
        this.b = SystemClock.elapsedRealtime();
        String strA = j.a();
        this.c = strA;
        return (TextUtils.isEmpty(strA) || "2G".equals(this.c)) ? false : true;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        final String action = intent == null ? null : intent.getAction();
        t3.f(new r3() { // from class: com.hihonor.hianalytics.receiver.MonitorReceiver$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(action, context);
            }
        });
    }
}
