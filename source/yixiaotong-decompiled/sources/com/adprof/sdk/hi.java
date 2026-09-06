package com.adprof.sdk;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class hi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BroadcastReceiver f1213a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final IntentFilter f361a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f362a;
    public boolean b;

    public hi(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f361a = intentFilter;
        this.f1213a = broadcastReceiver;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.f1213a);
        sb.append(" filter=");
        sb.append(this.f361a);
        if (this.b) {
            sb.append(" DEAD");
        }
        sb.append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }
}
