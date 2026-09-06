package com.hihonor.updater.installsdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.hihonor.updater.installsdk.api.AppStatusInfo;
import com.hihonor.updater.installsdk.api.DownloadInstallListener;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g {
    public static final String q = "RemoteClient";
    private static final int r = 50;
    public static final long s = TimeUnit.SECONDS.toMillis(30);
    public static final long t = TimeUnit.MINUTES.toMillis(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3741a;
    private String b;
    private volatile boolean c;
    private com.hihonor.updater.installsdk.a.a d;
    private final com.hihonor.updater.installsdk.a.a e;
    private final IBinder.DeathRecipient f;
    private HandlerThread g;
    private HandlerThread h;
    private e i;
    private d j;
    private final LinkedList<com.hihonor.updater.installsdk.b.c> k;
    private DownloadInstallListener l;
    private com.hihonor.updater.installsdk.e m;
    private volatile long n;
    private final Runnable o;
    private final ServiceConnection p;

    class a implements ServiceConnection {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            g.this.j();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(IBinder iBinder) {
            g.this.a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            com.hihonor.updater.installsdk.c.b.a(new Runnable() { // from class: com.hihonor.updater.installsdk.g$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(iBinder);
                }
            });
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.hihonor.updater.installsdk.c.b.a(new Runnable() { // from class: com.hihonor.updater.installsdk.g$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a();
                }
            });
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static g f3743a = new g(null);

        private b() {
        }
    }

    private class c extends com.hihonor.updater.installsdk.a.a.b {
        public c() {
        }

        @Override // com.hihonor.updater.installsdk.a.a
        public String a(String str, int i, String str2) throws RemoteException {
            if (i == 6007) {
                g.this.b(str2);
                return null;
            }
            if (i != 6010) {
                return null;
            }
            g.this.a(str2);
            return null;
        }

        @Override // com.hihonor.updater.installsdk.a.a
        public void a(String str, int i, String str2, com.hihonor.updater.installsdk.a.b bVar) throws RemoteException {
        }

        @Override // com.hihonor.updater.installsdk.a.a
        public void a(String str, com.hihonor.updater.installsdk.a.a aVar) throws RemoteException {
        }
    }

    private class d extends Handler {
        public static final int b = 1;
        public static final int c = 2;

        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            g.a().a(g.t);
            int i = message.what;
            if (1 == i) {
                if (message.obj == null || g.this.m == null) {
                    return;
                }
                String str = (String) message.obj;
                AppStatusInfo appStatusInfo = new AppStatusInfo();
                appStatusInfo.readFromJSON(str);
                com.hihonor.updater.installsdk.a.b(appStatusInfo);
                g.this.m.b(appStatusInfo);
                return;
            }
            if (2 != i || message.obj == null || g.this.m == null) {
                return;
            }
            String str2 = (String) message.obj;
            AppStatusInfo appStatusInfo2 = new AppStatusInfo();
            appStatusInfo2.readFromJSON(str2);
            com.hihonor.updater.installsdk.a.b(appStatusInfo2);
            g.this.m.a(appStatusInfo2);
        }
    }

    private class e extends Handler {
        public static final int b = 1;
        public static final int c = 2;

        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i = message.what;
            if ((1 != i && 2 != i) || message.obj == null || g.this.d == null) {
                return;
            }
            com.hihonor.updater.installsdk.b.c cVar = (com.hihonor.updater.installsdk.b.c) message.obj;
            int iB = cVar.b();
            String str = (String) cVar.c();
            com.hihonor.updater.installsdk.a.b bVarA = cVar.a();
            int i2 = message.what;
            if (1 == i2) {
                try {
                    g.this.d.a(g.this.b, iB, str);
                    return;
                } catch (Throwable th) {
                    com.hihonor.updater.installsdk.c.a.d(g.q, "doCommand error " + th.getMessage());
                    return;
                }
            }
            if (2 == i2) {
                try {
                    g.this.d.a(g.this.b, iB, str, bVarA);
                } catch (Throwable th2) {
                    com.hihonor.updater.installsdk.c.a.d(g.q, "doCommandWithCallback error " + th2.getMessage());
                    g.this.a(bVarA, 3005, th2.toString());
                }
            }
        }
    }

    private g() {
        this.o = new Runnable() { // from class: com.hihonor.updater.installsdk.g$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f();
            }
        };
        this.p = new a();
        this.f = new IBinder.DeathRecipient() { // from class: com.hihonor.updater.installsdk.g$$ExternalSyntheticLambda2
            @Override // android.os.IBinder.DeathRecipient
            public final void binderDied() {
                this.f$0.g();
            }
        };
        this.k = new LinkedList<>();
        d();
        this.e = new c();
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    public static g a() {
        return b.f3743a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IBinder iBinder) {
        try {
            synchronized (this) {
                if (this.c) {
                    return;
                }
                com.hihonor.updater.installsdk.c.a.c(q, "onConnected service=" + iBinder);
                com.hihonor.updater.installsdk.a.a aVarA = com.hihonor.updater.installsdk.a.a.b.a(iBinder);
                if (aVarA == null) {
                    return;
                }
                this.c = true;
                this.d = aVarA;
                aVarA.a(this.b, this.e);
                h();
                c();
                DownloadInstallListener downloadInstallListener = this.l;
                if (downloadInstallListener != null) {
                    downloadInstallListener.onServiceConnected();
                }
                com.hihonor.updater.installsdk.c.b().a(null, false, com.hihonor.updater.installsdk.a.a(), null);
            }
        } catch (Throwable th) {
            com.hihonor.updater.installsdk.c.a.b(q, "onConnected error " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.hihonor.updater.installsdk.a.b bVar, int i, String str) {
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(i, str);
        } catch (RemoteException e2) {
            com.hihonor.updater.installsdk.c.a.b(q, "setResult error " + e2);
        }
    }

    private void a(com.hihonor.updater.installsdk.b.c cVar) {
        synchronized (this) {
            if (this.k.size() >= 50) {
                this.k.removeFirst();
            }
            this.k.add(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.j == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = str;
        messageObtain.what = 2;
        this.j.sendMessage(messageObtain);
    }

    private boolean a(Context context) {
        if (context != null) {
            try {
                if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
                    Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    this.f3741a = origApplicationContext;
                    this.b = com.hihonor.updater.installsdk.c.c.b(origApplicationContext);
                    com.hihonor.updater.installsdk.c.a.c(q, "bindService  process = " + this.b);
                    boolean zBindService = this.f3741a.bindService(b(), this.p, 1);
                    com.hihonor.updater.installsdk.c.a.c(q, "bindResult =" + zBindService);
                    return zBindService;
                }
            } catch (Throwable th) {
                com.hihonor.updater.installsdk.c.a.b(q, "bindService error =" + th);
            }
        }
        return false;
    }

    private Intent b() {
        Intent intent = new Intent(com.hihonor.updater.installsdk.b.b.b);
        intent.setPackage(com.hihonor.updater.installsdk.b.b.f3727a);
        intent.putExtra(com.hihonor.updater.installsdk.b.b.c, this.b);
        intent.putExtra(com.hihonor.updater.installsdk.b.b.d, String.valueOf(BuildConfig.versionCode));
        return intent;
    }

    private void b(com.hihonor.updater.installsdk.b.c cVar) {
        if (this.i == null || cVar == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = cVar;
        messageObtain.what = cVar.d();
        this.i.sendMessage(messageObtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        if (this.j == null) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.obj = str;
        messageObtain.what = 1;
        this.j.sendMessage(messageObtain);
    }

    private void c() {
        if (this.c) {
            synchronized (this) {
                if (this.k.isEmpty()) {
                    return;
                }
                Iterator<com.hihonor.updater.installsdk.b.c> it = this.k.iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
                this.k.clear();
            }
        }
    }

    private synchronized void d() {
        if (this.m == null) {
            this.m = new com.hihonor.updater.installsdk.e();
        }
        this.m.b();
        if (this.g == null) {
            this.g = new HandlerThread("send message thread");
        }
        if (!this.g.isAlive()) {
            this.g.start();
        }
        if (this.i == null && this.g.getLooper() != null) {
            this.i = new e(this.g.getLooper());
        }
        if (this.h == null) {
            this.h = new HandlerThread("receive message thread");
        }
        if (!this.h.isAlive()) {
            this.h.start();
        }
        if (this.j == null && this.h.getLooper() != null) {
            this.j = new d(this.h.getLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        try {
            com.hihonor.updater.installsdk.a.a aVar = this.d;
            if (aVar == null) {
                return;
            }
            aVar.asBinder().linkToDeath(this.f, 0);
        } catch (Throwable th) {
            com.hihonor.updater.installsdk.c.a.b(q, "linkToDeath  error " + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.n == t && com.hihonor.updater.installsdk.c.b().a() && com.hihonor.updater.installsdk.a.b()) {
            com.hihonor.updater.installsdk.c.a.c(q, "had incomplete task, cancel unbind");
        } else {
            a().k();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        com.hihonor.updater.installsdk.c.a.c(q, "binderDied");
        j();
    }

    private void h() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hihonor.updater.installsdk.g$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    private void i() {
        synchronized (this) {
            if (this.k.isEmpty()) {
                return;
            }
            Iterator<com.hihonor.updater.installsdk.b.c> it = this.k.iterator();
            while (it.hasNext()) {
                com.hihonor.updater.installsdk.a.b bVarA = it.next().a();
                if (bVarA != null) {
                    try {
                        bVarA.a(3004, "bind result is false");
                    } catch (Throwable unused) {
                        com.hihonor.updater.installsdk.c.a.b(q, "set result error");
                    }
                }
            }
            this.k.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Bottom block not found for handler: all -> 0x001e */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j() {
        synchronized (this) {
            try {
                if (this.c) {
                    com.hihonor.updater.installsdk.c.a.c(q, "onDisconnected");
                    this.c = false;
                    this.d = null;
                    DownloadInstallListener downloadInstallListener = this.l;
                    if (downloadInstallListener != null) {
                        downloadInstallListener.onServiceShutdown();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void n() {
        if (this.f3741a == null) {
            com.hihonor.updater.installsdk.c.a.c(q, "unbindService context is invalid");
            return;
        }
        try {
            com.hihonor.updater.installsdk.c.a.c(q, "unbindService " + com.hihonor.updater.installsdk.c.c.b(this.f3741a));
            this.f3741a.unbindService(this.p);
            j();
        } catch (Throwable th) {
            com.hihonor.updater.installsdk.c.a.c(q, "unbindService  error " + th.getMessage());
        }
    }

    public String a(Context context, int i, String str) {
        synchronized (this) {
            com.hihonor.updater.installsdk.c.a.c(q, "doCommand command=" + i);
            d();
            l();
            com.hihonor.updater.installsdk.b.c cVar = new com.hihonor.updater.installsdk.b.c(i, str, null, 1);
            if (this.c) {
                b(cVar);
            } else {
                a(cVar);
                if (!a(context)) {
                    i();
                }
            }
        }
        return null;
    }

    public void a(long j) {
        try {
            if (this.i == null) {
                com.hihonor.updater.installsdk.c.a.d(q, "mMessageSender is null");
                return;
            }
            if (j > this.n) {
                this.n = j;
            }
            com.hihonor.updater.installsdk.c.a.c(q, "delayMillis=" + this.n);
            this.i.removeCallbacks(this.o);
            this.i.postDelayed(this.o, this.n);
        } catch (Throwable th) {
            com.hihonor.updater.installsdk.c.a.b(q, "send unbind message error " + th.getMessage());
        }
    }

    public void a(Context context, int i, String str, com.hihonor.updater.installsdk.a.b bVar) {
        synchronized (this) {
            com.hihonor.updater.installsdk.c.a.c(q, "doCommand command=" + i);
            d();
            l();
            com.hihonor.updater.installsdk.b.c cVar = new com.hihonor.updater.installsdk.b.c(i, str, bVar, 2);
            if (this.c) {
                b(cVar);
            } else {
                a(cVar);
                if (!a(context)) {
                    i();
                }
            }
        }
    }

    public void a(DownloadInstallListener downloadInstallListener) {
        synchronized (this) {
            this.l = downloadInstallListener;
        }
    }

    public synchronized void k() {
        try {
            com.hihonor.updater.installsdk.c.a.c(q, "releaseAndUnbind");
            this.n = 0L;
            n();
            this.k.clear();
            com.hihonor.updater.installsdk.e eVar = this.m;
            if (eVar != null) {
                eVar.a();
            }
            e eVar2 = this.i;
            if (eVar2 != null) {
                eVar2.removeCallbacksAndMessages(null);
                this.i = null;
            }
            HandlerThread handlerThread = this.g;
            if (handlerThread != null) {
                handlerThread.quit();
                this.g = null;
            }
            d dVar = this.j;
            if (dVar != null) {
                dVar.removeCallbacksAndMessages(null);
                this.j = null;
            }
            HandlerThread handlerThread2 = this.h;
            if (handlerThread2 != null) {
                handlerThread2.quit();
                this.h = null;
            }
        } catch (Throwable th) {
            com.hihonor.updater.installsdk.c.a.b(q, "releaseAndUnbind error " + th);
        }
    }

    public void l() {
        try {
            e eVar = this.i;
            if (eVar != null) {
                eVar.removeCallbacks(this.o);
            }
        } catch (Throwable th) {
            com.hihonor.updater.installsdk.c.a.b(q, "removeUnbindAction error " + th.getMessage());
        }
    }

    public void m() {
        String str;
        Context context = this.f3741a;
        if (context == null) {
            str = "tryRebindService context is null";
        } else {
            str = "tryRebindService " + a(context);
        }
        com.hihonor.updater.installsdk.c.a.d(q, str);
    }
}
