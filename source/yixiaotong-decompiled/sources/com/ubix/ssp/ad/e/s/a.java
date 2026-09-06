package com.ubix.ssp.ad.e.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.n;
import com.ubix.ssp.open.comm.AdActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f8848a;

    public a() {
    }

    public a(String str) {
        this.f8848a = str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        com.ubix.ssp.ad.d.a aVar;
        try {
            if (!new String(n.a().a(AdActivity.INSTALL_ACTION)).equals(intent.getAction()) || intent.getData() == null) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (!schemeSpecificPart.equals(this.f8848a) || (aVar = b.b.get(schemeSpecificPart)) == null) {
                return;
            }
            b.b.remove(schemeSpecificPart);
            b.c().a(StubApp.getOrigApplicationContext(context.getApplicationContext()), schemeSpecificPart, aVar, "bro", "");
        } catch (Throwable unused) {
        }
    }
}
