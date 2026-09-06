package com.meishu.sdk.core.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.meishu.sdk.core.oaid.OAIDException;
import com.stub.StubApp;
import java.util.Objects;

/* JADX INFO: compiled from: OAIDService.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4838a;
    public final com.meishu.sdk.core.oaid.a b;
    public final a c;

    /* JADX INFO: compiled from: OAIDService.java */
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws OAIDException, RemoteException;
    }

    public m(Context context, com.meishu.sdk.core.oaid.a aVar, a aVar2) {
        if (context instanceof Application) {
            this.f4838a = context;
        } else {
            this.f4838a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.b = aVar;
        this.c = aVar2;
    }

    public static void a(Context context, Intent intent, com.meishu.sdk.core.oaid.a aVar, a aVar2) {
        m mVar = new m(context, aVar, aVar2);
        try {
            if (!mVar.f4838a.bindService(intent, mVar, 1)) {
                throw new OAIDException("Service binding failed");
            }
            Objects.toString(intent);
        } catch (Exception e) {
            ((com.meishu.sdk.core.utils.l) mVar.b).a(e);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            try {
                try {
                    String strA = this.c.a(iBinder);
                    if (strA == null || strA.length() == 0) {
                        throw new OAIDException("OAID acquire failed");
                    }
                    ((com.meishu.sdk.core.utils.l) this.b).a(strA);
                    this.f4838a.unbindService(this);
                    componentName.getClassName();
                } catch (Throwable th) {
                    try {
                        this.f4838a.unbindService(this);
                        componentName.getClassName();
                    } catch (Exception unused) {
                    }
                    throw th;
                }
            } catch (Exception e) {
                ((com.meishu.sdk.core.utils.l) this.b).a(e);
                this.f4838a.unbindService(this);
            }
        } catch (Exception unused2) {
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        componentName.getClassName();
    }
}
