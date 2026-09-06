package com.yfanads.android.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.stub.StubApp;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: OAIDService.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class n implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9670a;
    public final com.yfanads.android.oaid.ifs.a b;
    public final a c;

    /* JADX INFO: compiled from: OAIDService.java */
    @FunctionalInterface
    public interface a {
        String a(IBinder iBinder) throws com.yfanads.android.oaid.a, RemoteException;
    }

    public n(Context context, com.yfanads.android.oaid.ifs.a aVar, a aVar2) {
        if (context instanceof Application) {
            this.f9670a = context;
        } else {
            this.f9670a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.b = aVar;
        this.c = aVar2;
    }

    public static void a(Context context, Intent intent, com.yfanads.android.oaid.ifs.a aVar, a aVar2) {
        n nVar = new n(context, aVar, aVar2);
        try {
            if (!nVar.f9670a.bindService(intent, nVar, 1)) {
                throw new com.yfanads.android.oaid.a("Service binding failed");
            }
            YFLog.debug("Service has been bound: " + intent);
        } catch (Exception e) {
            nVar.b.onOAIDGetFail(e);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.d(Util.TAG, "Service has been connected: " + componentName.getClassName());
        try {
            try {
                String strA = this.c.a(iBinder);
                if (TextUtils.isEmpty(strA)) {
                    throw new com.yfanads.android.oaid.a("OAID/AAID acquire failed");
                }
                Log.i(Util.TAG, "OAID/AAID acquire success: " + strA);
                this.b.onOAIDGetSuccess(strA);
                try {
                    this.f9670a.unbindService(this);
                    YFLog.debug("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e) {
                    YFLog.debug("unbindService " + e.getMessage());
                }
            } catch (Exception e2) {
                Log.w(Util.TAG, "onOAIDGet " + e2.getMessage());
                this.b.onOAIDGetFail(e2);
                try {
                    this.f9670a.unbindService(this);
                    YFLog.debug("Service has been unbound: " + componentName.getClassName());
                } catch (Exception e3) {
                    YFLog.debug("unbindService " + e3.getMessage());
                }
            }
        } catch (Throwable th) {
            try {
                this.f9670a.unbindService(this);
                YFLog.debug("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e4) {
                YFLog.debug("unbindService " + e4.getMessage());
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        YFLog.debug("Service has been disconnected: " + componentName.getClassName());
    }
}
