package com.ubix.ssp.ad.e.x;

import com.ubix.ssp.ad.e.a0.h;
import com.ubix.ssp.ad.e.a0.n;
import com.ubix.ssp.ad.e.a0.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ExecutorService f8928a;
    public static ExecutorService b;
    private static g c;

    class a implements ThreadFactory {
        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.RequestExecuteThread");
        }
    }

    class b implements ThreadFactory {
        b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Ubix.ReportExecuteThread");
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8931a;
        final /* synthetic */ Map b;
        final /* synthetic */ Map c;
        final /* synthetic */ com.ubix.ssp.ad.e.x.a d;

        c(String str, Map map, Map map2, com.ubix.ssp.ad.e.x.a aVar) {
            this.f8931a = str;
            this.b = map;
            this.c = map2;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.ubix.ssp.ad.e.x.d dVarA = new com.ubix.ssp.ad.e.x.c().a(g.this.a(this.f8931a, (Map<String, String>) this.b), this.c);
            if (dVarA.c == 200) {
                this.d.d(dVarA);
            } else {
                this.d.a(dVarA);
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f8932a;
        final /* synthetic */ HashMap b;
        final /* synthetic */ com.ubix.ssp.ad.e.x.a c;

        d(String str, HashMap map, com.ubix.ssp.ad.e.x.a aVar) {
            this.f8932a = str;
            this.b = map;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ubix.ssp.ad.e.x.d dVarA = new com.ubix.ssp.ad.e.x.c().a(this.f8932a, this.b);
                if (dVarA.c == 200) {
                    this.c.d(dVarA);
                } else {
                    this.c.a(dVarA);
                }
            } catch (Throwable unused) {
                this.c.a((com.ubix.ssp.ad.e.x.d) null);
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.y.a.d f8933a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;
        final /* synthetic */ com.ubix.ssp.ad.e.x.a d;

        e(com.ubix.ssp.ad.e.y.a.d dVar, String str, Map map, com.ubix.ssp.ad.e.x.a aVar) {
            this.f8933a = dVar;
            this.b = str;
            this.c = map;
            this.d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u.a()) {
                u.f("req： " + com.ubix.ssp.ad.e.a0.e.a(this.f8933a));
                u.f("reqBase： " + n.b().b(com.ubix.ssp.ad.e.y.c.f.a(this.f8933a)));
                u.f("reqUrl： " + this.b);
            }
            com.ubix.ssp.ad.e.x.d dVarA = new com.ubix.ssp.ad.e.x.c().a(this.b, com.ubix.ssp.ad.e.y.c.f.a(this.f8933a), this.c);
            if (dVarA.c == 200) {
                try {
                    com.ubix.ssp.ad.e.y.a.e eVarA = com.ubix.ssp.ad.e.y.a.e.a(dVarA.f);
                    if (u.a()) {
                        u.f(com.ubix.ssp.ad.e.a0.e.a(eVarA));
                    }
                    this.d.a(eVarA);
                    return;
                } catch (Throwable unused) {
                }
            }
            this.d.a(dVarA);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8934a;
        private com.ubix.ssp.ad.e.x.a<com.ubix.ssp.ad.e.x.d> b;
        private int c = 1;

        public f(String str, com.ubix.ssp.ad.e.x.a<com.ubix.ssp.ad.e.x.d> aVar) {
            this.f8934a = str;
            this.b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ubix.ssp.ad.e.x.d dVarA = new com.ubix.ssp.ad.e.x.c().a(this.f8934a, 5000);
                if (dVarA.c == 200) {
                    this.b.d(dVarA);
                } else {
                    u.c("--------reward uploadAction retry  " + this.c);
                    int i = this.c - 1;
                    this.c = i;
                    if (i < 0) {
                        this.b.a(dVarA);
                    } else {
                        run();
                    }
                }
            } catch (Throwable unused) {
                this.b.a((com.ubix.ssp.ad.e.x.d) null);
            }
        }
    }

    g() {
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str, Map<String, String> map) {
        if (map == null) {
            return str;
        }
        String str2 = str + "?";
        for (String str3 : map.keySet()) {
            str2 = str2 + str3 + "=" + map.get(str3) + "&";
        }
        return str2.substring(0, str2.length() - 1);
    }

    private HashMap<String, String> a(String str, String str2) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Content-Type", "application/octet-stream");
        map.put("X-U-Authorization", h.a(str2 + "+" + com.ubix.ssp.ad.d.b.q + "+" + str, "75eba40d7fa850ee"));
        map.put("User-Agent", com.ubix.ssp.ad.d.b.p);
        return map;
    }

    private void a() {
        ExecutorService executorService = f8928a;
        if (executorService == null || executorService.isTerminated() || f8928a.isShutdown()) {
            f8928a = new ThreadPoolExecutor(3, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new a());
        }
        ExecutorService executorService2 = b;
        if (executorService2 == null || executorService2.isTerminated() || b.isShutdown()) {
            b = new ThreadPoolExecutor(3, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());
        }
    }

    private void a(String str, com.ubix.ssp.ad.e.y.a.d dVar, Map<String, String> map, com.ubix.ssp.ad.e.x.a aVar) {
        f8928a.execute(new e(dVar, str, map, aVar));
    }

    private void a(String str, HashMap<String, String> map, com.ubix.ssp.ad.e.x.a<com.ubix.ssp.ad.e.x.d> aVar) {
        b.execute(new d(str, map, aVar));
    }

    public static g b() {
        g gVar = c;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g();
        c = gVar2;
        return gVar2;
    }

    private void b(String str, Map<String, String> map, Map<String, String> map2, com.ubix.ssp.ad.e.x.a aVar) {
        f8928a.execute(new c(str, map, map2, aVar));
    }

    public void a(String str, com.ubix.ssp.ad.e.x.a.c cVar) {
        HashMap<String, String> map = new HashMap<>();
        map.put("User-Agent", com.ubix.ssp.ad.d.b.p);
        a(str, map, (com.ubix.ssp.ad.e.x.a<com.ubix.ssp.ad.e.x.d>) cVar);
    }

    public void a(String str, com.ubix.ssp.ad.e.x.a aVar) {
        a(str, (HashMap<String, String>) null, (com.ubix.ssp.ad.e.x.a<com.ubix.ssp.ad.e.x.d>) aVar);
    }

    public void a(String str, String str2, com.ubix.ssp.ad.e.y.a.d dVar, com.ubix.ssp.ad.e.x.a aVar) {
        a(str, dVar, a(str2, dVar.b), aVar);
    }

    public void a(String str, Map<String, String> map, com.ubix.ssp.ad.e.x.a aVar) {
        HashMap map2 = new HashMap();
        map2.put("User-Agent", com.ubix.ssp.ad.d.b.p);
        a(str, map, map2, aVar);
    }

    public void a(String str, Map<String, String> map, Map<String, String> map2, com.ubix.ssp.ad.e.x.a aVar) {
        b(str, map, map2, aVar);
    }

    public void b(String str, com.ubix.ssp.ad.e.x.a<com.ubix.ssp.ad.e.x.d> aVar) {
        b.execute(new f(str, aVar));
    }
}
