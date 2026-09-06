package com.adprof.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.stub.StubApp;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class qg implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final eb f678a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final pg f679a;

    public qg(Context context, eb ebVar, pg pgVar) {
        this.f1386a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f678a = ebVar;
        this.f679a = pgVar;
    }

    public static void a(Context context, Intent intent, eb ebVar, pg pgVar) {
        qg qgVar = new qg(context, ebVar, pgVar);
        try {
            if (!qgVar.f1386a.bindService(intent, qgVar, 1)) {
                throw new mg("Service binding failed");
            }
            Objects.toString(intent);
        } catch (Exception e) {
            qgVar.f678a.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        componentName.getClassName();
        try {
            try {
                String strA = this.f679a.a(iBinder);
                if (strA == null || strA.length() == 0) {
                    throw new mg("OAID/AAID acquire failed");
                }
                this.f678a.a(strA);
                try {
                    this.f1386a.unbindService(this);
                    componentName.getClassName();
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                try {
                    this.f1386a.unbindService(this);
                    componentName.getClassName();
                } catch (Exception unused2) {
                }
                throw th;
            }
        } catch (Exception e) {
            this.f678a.a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
