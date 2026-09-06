package com.ubix.ssp.open.comm;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.stub.StubApp;
import com.ubix.ssp.ad.e.a0.m;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.s.f;
import com.ubix.ssp.ad.e.s.g.c;
import com.ubix.ssp.ad.e.s.i.a;
import com.ubix.ssp.ad.e.s.i.b;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class DownloadService extends Service {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final long KEEP_ALIVE_TIME = 0;
    private static final int MAX_POOL_SIZE;
    public static final String TAG = "DownloadService";
    public static boolean canRequest = true;
    private a mExecutor = new a(CORE_POOL_SIZE, MAX_POOL_SIZE, 0, TimeUnit.MILLISECONDS, new LinkedBlockingDeque());
    private HashMap<String, b> mTasks = new HashMap<>();
    private DownloadBinder binder = new DownloadBinder(this);

    public static class DownloadBinder extends Binder {
        DownloadService downloadService;

        DownloadBinder(DownloadService downloadService) {
            this.downloadService = downloadService;
        }

        public b getDownloadTask(int i, int i2) {
            return (b) this.downloadService.mTasks.get(i2 + "");
        }

        public void pauseTask(int i, int i2) {
            b bVar = (b) this.downloadService.mTasks.get(i2 + "");
            if (bVar != null) {
                bVar.f();
            }
        }

        public void resumeTask(int i, int i2) {
            b bVar = (b) this.downloadService.mTasks.get(i2 + "");
            if (bVar != null) {
                bVar.g();
            }
        }

        public void runTask(Intent intent) {
            try {
                final c cVarA = com.ubix.ssp.ad.e.s.b.c().a(intent.getIntExtra("service_intent_notify_id", -1));
                if (cVarA != null) {
                    cVarA.b().a(f.a(this.downloadService, cVarA.b()));
                    this.downloadService.mExecutor.execute(new Runnable() { // from class: com.ubix.ssp.open.comm.DownloadService.DownloadBinder.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DownloadBinder.this.downloadService.executeDownload(cVarA);
                        }
                    });
                }
            } catch (Exception e) {
                u.d(DownloadService.TAG, "onStartCommand()-> 接受数据,启动线程中发生异常");
                e.printStackTrace();
            }
        }
    }

    static {
        StubApp.interface11(52563);
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        int iMax = Math.max(3, iAvailableProcessors / 2);
        CORE_POOL_SIZE = iMax;
        MAX_POOL_SIZE = iMax * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void executeDownload(c cVar) {
        a aVar;
        com.ubix.ssp.ad.e.s.g.a aVarB = cVar.b();
        b bVar = this.mTasks.get(aVarB.f() + "");
        com.ubix.ssp.ad.e.s.h.a aVar2 = new com.ubix.ssp.ad.e.s.h.a(getBaseContext());
        com.ubix.ssp.ad.e.s.g.b bVarB = aVar2.b(aVarB.f() + "");
        if (bVar != null) {
            com.ubix.ssp.ad.e.s.g.b bVarB2 = aVarB.b();
            com.ubix.ssp.ad.e.s.g.a aVarB2 = bVar.b();
            com.ubix.ssp.ad.e.s.g.b bVarB3 = aVarB2.b();
            if (bVarB2.b() == 45) {
                if (bVarB == null) {
                    bVar.b().b().b(42);
                }
                bVar.g();
                this.mExecutor.a(bVar);
                Intent intent = new Intent();
                intent.putExtra("service_intent_unique_id", aVarB2.f());
                intent.putExtra("service_intent_notify_id", aVarB2.d());
                intent.setAction("ACTION_RESUME");
                m.a(StubApp.getOrigApplicationContext(getApplicationContext())).b(intent);
            } else if (bVarB2.b() == 46) {
                if (aVarB2.a().exists()) {
                    if (aVarB2.d() != -1) {
                        this.mTasks.remove(aVarB2.f() + "");
                        Intent intent2 = new Intent();
                        aVarB2.a(bVarB3);
                        intent2.setAction("ACTION_COMPLETE");
                        intent2.putExtra("service_intent_unique_id", aVarB2.f());
                        intent2.putExtra("service_intent_notify_id", aVarB2.d());
                        m.a(StubApp.getOrigApplicationContext(getApplicationContext())).b(intent2);
                    }
                    return;
                }
                bVar.c().b(42);
                aVar = this.mExecutor;
            } else if (this.mExecutor.a(bVar) != 0) {
                Intent intent3 = new Intent();
                intent3.setAction("ACTION_BIND");
                intent3.putExtra("service_intent_unique_id", bVar.b().f());
                intent3.putExtra("service_intent_notify_id", cVar.c());
                intent3.putExtra("service_intent_fellow_notify_ids", bVar.b().f());
                bVar.a(intent3);
            }
        }
        if (bVarB != null && bVarB.b() == 46) {
            aVarB.b();
            if (aVarB.a().exists()) {
                if (aVarB.d() != -1) {
                    Intent intent4 = new Intent();
                    aVarB.a(bVarB);
                    intent4.setAction("ACTION_COMPLETE");
                    intent4.putExtra("service_intent_unique_id", aVarB.f());
                    intent4.putExtra("service_intent_notify_id", aVarB.d());
                    m.a(StubApp.getOrigApplicationContext(getApplicationContext())).b(intent4);
                }
                return;
            }
        }
        aVarB.b().b(42);
        bVar = new b(this, aVarB, aVar2, cVar.d());
        this.mTasks.put(aVarB.f() + "", bVar);
        aVar = this.mExecutor;
        aVar.a(bVar);
    }

    private boolean isAllStopped() {
        HashMap<String, b> map = this.mTasks;
        if (map == null || map.size() <= 0) {
            return true;
        }
        for (b bVar : this.mTasks.values()) {
            if (bVar != null && bVar.d() == 44) {
                return false;
            }
        }
        return true;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return 1;
        }
        try {
            if (intent.getAction() == null || !intent.getAction().equals("ACTION_USER_OPERATION")) {
                return 1;
            }
            m.a(this).b(intent);
            return 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }
}
