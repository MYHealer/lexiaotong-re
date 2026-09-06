package com.byazt.zz;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 1844})
public class SqlDownloadCacheService extends Service {
    public static final String c = "SqlDownloadCacheService";

    static {
        StubApp.interface11(22384);
    }

    public static void c(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, (Class<?>) SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                com.byazt.nr.m.tt(c, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ve.c(StubApp.getOrigApplicationContext(getApplicationContext()));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        gt gtVarA;
        da daVarZm = ve.zm();
        if (daVarZm instanceof com.byazt.b.uj) {
            gtVarA = ((com.byazt.b.uj) daVarZm).a();
        } else {
            gtVarA = daVarZm instanceof gt ? (gt) daVarZm : null;
        }
        if (gtVarA instanceof IBinder) {
            return (IBinder) gtVarA;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int iOnStartCommand = super.onStartCommand(intent, i, i2);
        if (ve.da()) {
            return 2;
        }
        return iOnStartCommand;
    }
}
