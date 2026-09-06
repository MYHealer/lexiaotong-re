package com.byazt.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.SparseArray;
import com.byazt.t.DownloadTask;
import com.byazt.zz.CSJIndependentProcessDownloadService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 223, 215})
public class yp extends com.byazt.zz.c implements ServiceConnection {
    public static final String n = "yp";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.zz.i f1994a;
    public com.byazt.zz.yp sp;
    public int x = -1;

    @Override // com.byazt.zz.c, com.byazt.zz.z
    public void c(com.byazt.zz.yp ypVar) {
        this.sp = ypVar;
    }

    @Override // com.byazt.zz.c
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            com.byazt.x.c.tt(n, "bindService");
            Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
            if (com.byazt.w.a.c()) {
                intent.putExtra("fix_downloader_db_sigbus", com.byazt.k.c.ve().c("fix_sigbus_downloader_db"));
            }
            if (serviceConnection != null) {
                context.bindService(intent, serviceConnection, 1);
            }
            context.startService(intent);
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    @Override // com.byazt.zz.c
    public void stopService(Context context, ServiceConnection serviceConnection) {
        com.byazt.x.c.tt(n, "stopService");
        this.tt = false;
        Intent intent = new Intent(context, (Class<?>) CSJIndependentProcessDownloadService.class);
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
        }
        context.stopService(intent);
    }

    @Override // com.byazt.zz.c, com.byazt.zz.z
    public IBinder c(Intent intent) {
        if (intent != null && intent.getBooleanExtra("fix_downloader_db_sigbus", false)) {
            com.byazt.nr.m.tt(n, "downloader process sync database on main process!");
            com.byazt.k.c.c("fix_sigbus_downloader_db", true);
        }
        com.byazt.x.c.tt(n, "onBind IndependentDownloadBinder");
        return new u();
    }

    @Override // com.byazt.zz.c, com.byazt.zz.z
    public void tt(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.x.c.tt(n, "tryDownload aidlService == null:" + (this.f1994a == null));
        if (this.f1994a == null) {
            c(downloadTask);
            startService(com.byazt.zz.ve.ic(), this);
            return;
        }
        sp();
        try {
            this.f1994a.c(com.byazt.w.sp.c(downloadTask));
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    private void sp() {
        SparseArray<List<DownloadTask>> sparseArrayClone;
        try {
            synchronized (this.c) {
                sparseArrayClone = this.c.clone();
                this.c.clear();
            }
            if (sparseArrayClone == null || sparseArrayClone.size() <= 0 || com.byazt.zz.ve.d() == null) {
                return;
            }
            for (int i = 0; i < sparseArrayClone.size(); i++) {
                List<DownloadTask> list = sparseArrayClone.get(sparseArrayClone.keyAt(i));
                if (list != null) {
                    Iterator<DownloadTask> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            this.f1994a.c(com.byazt.w.sp.c(it.next()));
                        } catch (RemoteException e) {
                            com.byazt.nr.m.c(e);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            com.byazt.x.c.tt(n, "resumePendingTaskForIndependent failed", th);
        }
    }

    @Override // com.byazt.zz.c, com.byazt.zz.z
    public void ve(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.byazt.zz.uj.c().c(downloadTask.getDownloadId(), true);
        c cVarD = com.byazt.zz.ve.d();
        if (cVarD != null) {
            cVarD.c(downloadTask);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        String str = n;
        com.byazt.x.c.tt(str, "onServiceConnected ");
        this.f1994a = com.byazt.zz.i.c.c(iBinder);
        com.byazt.zz.yp ypVar = this.sp;
        if (ypVar != null) {
            ypVar.c(iBinder);
        }
        com.byazt.x.c.tt(str, "onServiceConnected aidlService!=null" + (this.f1994a != null) + " pendingTasks.size:" + this.c.size());
        if (this.f1994a != null) {
            com.byazt.zz.uj.c().tt();
            this.tt = true;
            this.uj = false;
            int i = this.x;
            if (i != -1) {
                try {
                    this.f1994a.t(i);
                } catch (RemoteException e) {
                    com.byazt.nr.m.c(e);
                }
            }
            if (this.f1994a != null) {
                sp();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.byazt.x.c.tt(n, "onServiceDisconnected ");
        this.f1994a = null;
        this.tt = false;
        com.byazt.zz.yp ypVar = this.sp;
        if (ypVar != null) {
            ypVar.x();
        }
    }

    @Override // android.content.ServiceConnection
    public void onBindingDied(ComponentName componentName) {
        this.f1994a = null;
        com.byazt.zz.yp ypVar = this.sp;
        if (ypVar != null) {
            ypVar.x();
        }
    }

    @Override // com.byazt.zz.c, com.byazt.zz.z
    public void c(int i) {
        com.byazt.zz.i iVar = this.f1994a;
        if (iVar == null) {
            this.x = i;
            return;
        }
        try {
            iVar.t(i);
        } catch (RemoteException e) {
            com.byazt.nr.m.c(e);
        }
    }

    @Override // com.byazt.zz.c, com.byazt.zz.z
    public void startService() {
        if (this.f1994a == null) {
            startService(com.byazt.zz.ve.ic(), this);
        }
    }
}
