package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class DownloadService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SVSD f8488a;
    private boolean b = false;
    private LinkedList<b> c = new LinkedList<>();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.managers.a f8489a;

        /* JADX INFO: renamed from: com.qq.e.comm.DownloadService$a$a, reason: collision with other inner class name */
        class RunnableC1049a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ SVSD f8490a;

            RunnableC1049a(SVSD svsd) {
                this.f8490a = svsd;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f8490a.onCreate();
                    while (true) {
                        b bVar = (b) DownloadService.this.c.poll();
                        if (bVar == null) {
                            DownloadService.this.f8488a = this.f8490a;
                            return;
                        }
                        this.f8490a.onStartCommand(bVar.f8491a, bVar.b, bVar.c);
                    }
                } catch (Throwable th) {
                    GDTLogger.w("DownloadService初始化异常", th);
                }
            }
        }

        a(com.qq.e.comm.managers.a aVar) {
            this.f8489a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SVSD aPKDownloadServiceDelegate = this.f8489a.c().getPOFactory().getAPKDownloadServiceDelegate(DownloadService.this);
                if (aPKDownloadServiceDelegate == null) {
                    GDTLogger.w("DownloadService初始化异常");
                } else {
                    new Handler(Looper.getMainLooper()).post(new RunnableC1049a(aPKDownloadServiceDelegate));
                }
            } catch (Throwable th) {
                GDTLogger.w("DownloadService初始化异常", th);
            }
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Intent f8491a;
        private final int b;
        private final int c;

        private b(Intent intent, int i, int i2) {
            this.f8491a = intent;
            this.b = i;
            this.c = i2;
        }

        /* synthetic */ b(Intent intent, int i, int i2, a aVar) {
            this(intent, i, i2);
        }
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("GDT_APPID", com.qq.e.comm.managers.a.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        SVSD svsd = this.f8488a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID")) || !a(true)) {
            return null;
        }
        return this.f8488a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f8488a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.f8488a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f8488a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f8488a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            stopSelf(i2);
            return 2;
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID"))) {
            GDTLogger.w("Service onStartCommand 出现异常");
            return 2;
        }
        if (a(false)) {
            return this.f8488a.onStartCommand(intent, i, i2);
        }
        this.c.add(new b(intent, i, i2, null));
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f8488a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        SVSD svsd = this.f8488a;
        if (svsd != null) {
            svsd.onTrimMemory(i);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f8488a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }

    private boolean a(boolean z) {
        if (this.f8488a != null) {
            return true;
        }
        com.qq.e.comm.managers.a aVarB = com.qq.e.comm.managers.a.b();
        if (!aVarB.d()) {
            return false;
        }
        if (!z) {
            if (this.b) {
                return false;
            }
            this.b = true;
            com.qq.e.comm.managers.a.g.submit(new a(aVarB));
            return false;
        }
        try {
            SVSD aPKDownloadServiceDelegate = aVarB.c().getPOFactory().getAPKDownloadServiceDelegate(this);
            this.f8488a = aPKDownloadServiceDelegate;
            aPKDownloadServiceDelegate.onCreate();
            return true;
        } catch (Throwable th) {
            GDTLogger.w("DownloadService初始化异常", th);
            return false;
        }
    }
}
