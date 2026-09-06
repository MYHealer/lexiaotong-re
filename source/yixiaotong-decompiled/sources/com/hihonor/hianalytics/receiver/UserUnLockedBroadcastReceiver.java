package com.hihonor.hianalytics.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.util.SystemUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class UserUnLockedBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3713a = false;

    public synchronized void a() {
        j2.a("UserUnLockedBroadcastReceiver_TAG", "start, isStarted:" + this.f3713a);
        if (this.f3713a) {
            return;
        }
        this.f3713a = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.USER_UNLOCKED");
        a.a(SystemUtils.getContext(), this, intentFilter, false);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        j2.c("UserUnLockedBroadcastReceiver_TAG", "Received action: " + intent.getAction());
        p2.a().h();
    }
}
