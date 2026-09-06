package com.ubix.ssp.ad.e.a0.y.e;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements com.ubix.ssp.ad.e.a0.y.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f8740a;
    private static ScheduledExecutorService b;
    private C1088c c = new C1088c();
    private ConcurrentHashMap<Integer, com.ubix.ssp.ad.e.a0.y.e.b> d = new ConcurrentHashMap<>();
    private b e = new b();

    static /* synthetic */ class a {
    }

    private final class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                com.ubix.ssp.ad.e.a0.y.e.a aVar = (com.ubix.ssp.ad.e.a0.y.e.a) message.obj;
                if (aVar != null) {
                    int i = message.what;
                    if (i == 1) {
                        aVar.a(message.arg1);
                    } else if (i == 2 || i == 3) {
                        aVar.b(message.arg1);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.y.e.c$c, reason: collision with other inner class name */
    class C1088c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f8742a;
        private float b;
        private int c;

        public C1088c() {
            this.f8742a = 100;
            this.b = 0.5f;
            this.c = -1;
        }

        public C1088c(float f, int i, int i2) {
            this.b = f;
            this.f8742a = i;
            this.c = i2;
        }
    }

    private final class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(c cVar, a aVar) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                for (Map.Entry entry : (Map.Entry[]) c.this.d.entrySet().toArray(new Map.Entry[0])) {
                    com.ubix.ssp.ad.e.a0.y.e.b bVar = (com.ubix.ssp.ad.e.a0.y.e.b) entry.getValue();
                    if (bVar != null) {
                        bVar.b();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private c() {
        ScheduledExecutorService scheduledExecutorService = b;
        if (scheduledExecutorService == null || scheduledExecutorService.isTerminated()) {
            b = Executors.newScheduledThreadPool(1);
        }
    }

    public static c a() {
        if (f8740a == null) {
            f8740a = new c();
        }
        return f8740a;
    }

    public c a(float f) {
        this.c.b = f;
        return this;
    }

    @Override // com.ubix.ssp.ad.e.a0.y.e.a
    public void a(int i) {
        ConcurrentHashMap<Integer, com.ubix.ssp.ad.e.a0.y.e.b> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            com.ubix.ssp.ad.e.a0.y.e.b bVar = concurrentHashMap.get(Integer.valueOf(i));
            this.d.remove(Integer.valueOf(i));
            if (bVar == null || bVar.a() == null) {
                return;
            }
            Message message = new Message();
            message.what = 1;
            message.obj = bVar.a();
            message.arg1 = i;
            this.e.sendMessage(message);
        }
    }

    public void a(int i, View view, com.ubix.ssp.ad.e.a0.y.e.a aVar) {
        synchronized (this) {
            if (this.d == null) {
                this.d = new ConcurrentHashMap<>();
            }
            if (this.d.get(Integer.valueOf(i)) == null) {
                this.d.put(Integer.valueOf(i), new com.ubix.ssp.ad.e.a0.y.e.b(i, view, this.c.b, this.c.c, aVar, this));
            }
            if (((ScheduledThreadPoolExecutor) b).getTaskCount() == 0) {
                b.scheduleAtFixedRate(new d(this, null), 0L, this.c.f8742a, TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.ubix.ssp.ad.e.a0.y.e.a
    public void b(int i) {
        ConcurrentHashMap<Integer, com.ubix.ssp.ad.e.a0.y.e.b> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            com.ubix.ssp.ad.e.a0.y.e.b bVar = concurrentHashMap.get(Integer.valueOf(i));
            this.d.remove(Integer.valueOf(i));
            if (bVar == null || bVar.a() == null) {
                return;
            }
            Message message = new Message();
            message.what = 2;
            message.obj = bVar.a();
            message.arg1 = i;
            this.e.sendMessage(message);
        }
    }

    public void c(int i) {
        try {
            ConcurrentHashMap<Integer, com.ubix.ssp.ad.e.a0.y.e.b> concurrentHashMap = this.d;
            if (concurrentHashMap == null) {
                return;
            }
            concurrentHashMap.remove(Integer.valueOf(i));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
