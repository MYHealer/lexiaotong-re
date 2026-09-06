package com.opos.cmn.biz.monitor.a;

import android.content.Context;
import com.opos.cmn.biz.monitor.b.e;
import com.stub.StubApp;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5978a = "c";
    private static c b;
    private Context d;
    private b e;
    private LinkedBlockingQueue<d> c = new LinkedBlockingQueue<>();
    private Object f = new Object();
    private a g = new a(new a.b() { // from class: com.opos.cmn.biz.monitor.a.c.1
        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(final a.InterfaceC0872a interfaceC0872a) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.1.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(interfaceC0872a);
                }
            });
        }
    }, Integer.MAX_VALUE, 60000);
    private a h = new a(new a.b() { // from class: com.opos.cmn.biz.monitor.a.c.2
        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(final a.InterfaceC0872a interfaceC0872a) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.2.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.a(interfaceC0872a);
                }
            });
        }
    }, Integer.MAX_VALUE, 0);

    private int a(List<d> list) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < list.size(); i++) {
            final d dVar = list.get(i);
            new e(this.d, dVar.c, 3, com.opos.cmn.biz.monitor.a.a().b(), new e.a() { // from class: com.opos.cmn.biz.monitor.a.c.5
                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a() {
                    countDownLatch.countDown();
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a(byte[] bArr) {
                    if (!com.opos.cmn.biz.monitor.e.a(dVar.c) || e.a(bArr)) {
                        atomicInteger.incrementAndGet();
                        c.this.c(dVar);
                    }
                    countDownLatch.countDown();
                }
            }).a();
        }
        try {
            if (countDownLatch.await(60000L, TimeUnit.MILLISECONDS)) {
                return atomicInteger.get();
            }
            return 0;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b(f5978a, "send cache request error:" + e);
            return 0;
        }
    }

    public static c a() {
        c cVar;
        c cVar2 = b;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            if (b == null) {
                b = new c();
            }
            cVar = b;
        }
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.InterfaceC0872a interfaceC0872a) {
        c(new a.InterfaceC0872a() { // from class: com.opos.cmn.biz.monitor.a.c.3
            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0872a
            public void a() {
                a.InterfaceC0872a interfaceC0872a2 = interfaceC0872a;
                if (interfaceC0872a2 != null) {
                    interfaceC0872a2.a();
                }
                if (c.this.c.isEmpty()) {
                    return;
                }
                c.this.h.a();
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0872a
            public void b() {
                a.InterfaceC0872a interfaceC0872a2 = interfaceC0872a;
                if (interfaceC0872a2 != null) {
                    interfaceC0872a2.b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final a.InterfaceC0872a interfaceC0872a) {
        d(new a.InterfaceC0872a() { // from class: com.opos.cmn.biz.monitor.a.c.4
            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0872a
            public void a() {
                c.this.c();
                a.InterfaceC0872a interfaceC0872a2 = interfaceC0872a;
                if (interfaceC0872a2 != null) {
                    interfaceC0872a2.a();
                }
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0872a
            public void b() {
                c.this.c();
                a.InterfaceC0872a interfaceC0872a2 = interfaceC0872a;
                if (interfaceC0872a2 != null) {
                    interfaceC0872a2.b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int iA;
        try {
            synchronized (this.f) {
                iA = this.e.a(System.currentTimeMillis() - 604800000);
            }
            com.opos.cmn.an.f.a.b(f5978a, "remove expired data size:" + iA);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b(f5978a, "remove expired data fail");
        }
    }

    private void c(a.InterfaceC0872a interfaceC0872a) {
        LinkedList linkedList = new LinkedList();
        while (true) {
            d dVarPoll = this.c.poll();
            if (dVarPoll == null) {
                break;
            } else {
                linkedList.add(dVarPoll);
            }
        }
        if (linkedList.size() > 0) {
            synchronized (this.f) {
                this.e.a(linkedList);
            }
        }
        if (interfaceC0872a != null) {
            interfaceC0872a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        synchronized (this.f) {
            com.opos.cmn.an.f.a.b(f5978a, "delete num:" + this.e.a(dVar));
        }
    }

    private void d(a.InterfaceC0872a interfaceC0872a) {
        List<d> listA;
        int iA;
        com.opos.cmn.an.f.a.b(f5978a, "pickResendMonitorAndSend");
        do {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - 604800000;
            long j2 = jCurrentTimeMillis - 60000;
            String str = f5978a;
            com.opos.cmn.an.f.a.b(str, "pick monitor from:" + j + ",to:" + j2);
            synchronized (this.f) {
                listA = this.e.a(j, j2, 5);
            }
            if (listA == null || listA.size() <= 0) {
                com.opos.cmn.an.f.a.b(str, "cacheList empty");
                a(false);
                if (interfaceC0872a != null) {
                    interfaceC0872a.a();
                    return;
                }
                return;
            }
            a(true);
            com.opos.cmn.an.f.a.b(str, "send cacheNum:" + listA.size());
            iA = a(listA);
            com.opos.cmn.an.f.a.b(str, "send cache success num:" + iA);
        } while (iA > 0);
        if (interfaceC0872a != null) {
            interfaceC0872a.b();
        }
    }

    public void a(Context context) {
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.e = new b(context);
    }

    public void a(d dVar) {
        this.c.offer(dVar);
        this.h.a();
    }

    public void a(boolean z) {
        com.opos.cmn.an.f.a.b(f5978a, "setCacheEnable value:" + z);
        Context context = this.d;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ads_monitor_cache", 4).edit().putBoolean("has_monitor_cache", z).commit();
    }

    public void b() {
        this.g.a();
    }

    public void b(final d dVar) {
        if (this.c.remove(dVar)) {
            return;
        }
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                c.this.c(dVar);
            }
        });
    }
}
