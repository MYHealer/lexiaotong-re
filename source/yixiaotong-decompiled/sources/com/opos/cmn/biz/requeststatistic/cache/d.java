package com.opos.cmn.biz.requeststatistic.cache;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {
    private static d g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6012a;
    private com.opos.cmn.biz.requeststatistic.cache.b b;
    private ReadWriteLock c = new ReentrantReadWriteLock();
    private LinkedBlockingQueue<com.opos.cmn.biz.requeststatistic.cache.c> d = new LinkedBlockingQueue<>();
    private com.opos.cmn.biz.requeststatistic.cache.a e;
    private com.opos.cmn.biz.requeststatistic.cache.a f;

    class a implements com.opos.cmn.biz.requeststatistic.cache.a.c {
        a() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.cache.a.c
        public void a(com.opos.cmn.biz.requeststatistic.cache.a.b bVar) {
            d.this.c(bVar);
        }
    }

    class b implements com.opos.cmn.biz.requeststatistic.cache.a.c {
        b() {
        }

        @Override // com.opos.cmn.biz.requeststatistic.cache.a.c
        public void a(com.opos.cmn.biz.requeststatistic.cache.a.b bVar) {
            d.this.a(bVar);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.biz.requeststatistic.cache.a.b f6015a;

        c(com.opos.cmn.biz.requeststatistic.cache.a.b bVar) {
            this.f6015a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c.writeLock().lock();
            try {
                com.opos.cmn.an.f.a.a("CacheModel", "startWrite db begin");
                LinkedList linkedList = new LinkedList();
                Object objPoll = d.this.d.poll();
                while (true) {
                    com.opos.cmn.biz.requeststatistic.cache.c cVar = (com.opos.cmn.biz.requeststatistic.cache.c) objPoll;
                    if (cVar == null) {
                        break;
                    }
                    linkedList.add(cVar);
                    objPoll = d.this.d.poll();
                }
                d.this.b.a(linkedList);
            } catch (Throwable th) {
                try {
                    com.opos.cmn.an.f.a.c("CacheModel", "write fail", th);
                    com.opos.cmn.biz.requeststatistic.cache.a.b bVar = this.f6015a;
                    if (bVar != null) {
                        bVar.onFail();
                        com.opos.cmn.an.f.a.a("CacheModel", "startWrite db end");
                        d.this.c.writeLock().unlock();
                        return;
                    }
                } catch (Throwable th2) {
                    com.opos.cmn.an.f.a.a("CacheModel", "startWrite db end");
                    d.this.c.writeLock().unlock();
                    throw th2;
                }
            }
            com.opos.cmn.an.f.a.a("CacheModel", "startWrite db end");
            d.this.c.writeLock().unlock();
            com.opos.cmn.biz.requeststatistic.cache.a.b bVar2 = this.f6015a;
            if (bVar2 != null) {
                bVar2.onSuccess();
            }
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.biz.requeststatistic.cache.d$d, reason: collision with other inner class name */
    class RunnableC0879d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.biz.requeststatistic.cache.c f6016a;

        RunnableC0879d(com.opos.cmn.biz.requeststatistic.cache.c cVar) {
            this.f6016a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.c.writeLock().lock();
            try {
                try {
                    d.this.b.a(this.f6016a);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.c("CacheModel", "delete fail", e);
                }
            } finally {
                d.this.c.writeLock().unlock();
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.biz.requeststatistic.cache.a.b f6017a;

        class a implements com.opos.cmn.biz.requeststatistic.cache.a.b {
            a() {
            }

            @Override // com.opos.cmn.biz.requeststatistic.cache.a.b
            public void onFail() {
                d.this.b();
                com.opos.cmn.biz.requeststatistic.cache.a.b bVar = e.this.f6017a;
                if (bVar != null) {
                    bVar.onFail();
                }
            }

            @Override // com.opos.cmn.biz.requeststatistic.cache.a.b
            public void onSuccess() {
                d.this.b();
                com.opos.cmn.biz.requeststatistic.cache.a.b bVar = e.this.f6017a;
                if (bVar != null) {
                    bVar.onSuccess();
                }
            }
        }

        e(com.opos.cmn.biz.requeststatistic.cache.a.b bVar) {
            this.f6017a = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(new a());
        }
    }

    class f implements com.opos.cmn.biz.requeststatistic.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f6019a;
        final /* synthetic */ com.opos.cmn.biz.requeststatistic.cache.a.b b;

        f(List list, com.opos.cmn.biz.requeststatistic.cache.a.b bVar) {
            this.f6019a = list;
            this.b = bVar;
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.b
        public void onFail() {
            com.opos.cmn.an.f.a.b("CacheModel", "report cache fail");
            com.opos.cmn.biz.requeststatistic.cache.a.b bVar = this.b;
            if (bVar != null) {
                bVar.onFail();
            }
        }

        @Override // com.opos.cmn.biz.requeststatistic.a.b
        public void onSuccess() {
            com.opos.cmn.biz.requeststatistic.cache.a.b bVar;
            com.opos.cmn.an.f.a.b("CacheModel", "report cache success");
            if (!d.this.a((List<com.opos.cmn.biz.requeststatistic.cache.c>) this.f6019a) && (bVar = this.b) != null) {
                bVar.onFail();
            } else if (d.this.d()) {
                d.this.b(this.b);
            } else {
                this.b.onSuccess();
            }
        }
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.cmn.biz.requeststatistic.cache.a.b bVar) {
        com.opos.cmn.an.j.b.a().execute(new e(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(List<com.opos.cmn.biz.requeststatistic.cache.c> list) {
        ReadWriteLock readWriteLock;
        Lock lockWriteLock;
        this.c.writeLock().lock();
        try {
            this.b.b(list);
            return true;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.c("CacheModel", "delete data", e2);
            return false;
        } finally {
            this.c.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.c.writeLock().lock();
        try {
            try {
                this.b.a(System.currentTimeMillis() - 604800000);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("CacheModel", "delete cache expired fail", e2);
            }
        } finally {
            this.c.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.opos.cmn.biz.requeststatistic.cache.a.b bVar) {
        this.c.readLock().lock();
        long jCurrentTimeMillis = System.currentTimeMillis() - 604800000;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - 60000;
        com.opos.cmn.an.f.a.b("CacheModel", "do report cache with start Time:" + jCurrentTimeMillis + ", endTime:" + jCurrentTimeMillis2);
        try {
            try {
                List<com.opos.cmn.biz.requeststatistic.cache.c> listA = this.b.a(jCurrentTimeMillis, jCurrentTimeMillis2, 100);
                this.c.readLock().unlock();
                if (listA == null || listA.size() <= 0) {
                    if (bVar != null) {
                        bVar.onSuccess();
                        return;
                    }
                    return;
                }
                JSONArray jSONArray = new JSONArray();
                Iterator<com.opos.cmn.biz.requeststatistic.cache.c> it = listA.iterator();
                while (it.hasNext()) {
                    try {
                        jSONArray.put(new JSONObject(it.next().b));
                    } catch (JSONException e2) {
                        com.opos.cmn.an.f.a.b("CacheModel", "parse data fail", e2);
                    }
                }
                if (jSONArray.length() > 0) {
                    com.opos.cmn.biz.requeststatistic.a.b(this.f6012a, jSONArray.toString(), new f(listA, bVar));
                    return;
                }
                if (a(listA)) {
                    if (bVar != null) {
                        bVar.onSuccess();
                    }
                } else if (bVar != null) {
                    bVar.onFail();
                }
            } catch (Exception e3) {
                com.opos.cmn.an.f.a.c("CacheModel", "get cache fail", e3);
                if (bVar != null) {
                    bVar.onFail();
                }
                this.c.readLock().unlock();
            }
        } catch (Throwable th) {
            this.c.readLock().unlock();
            throw th;
        }
    }

    public static d c() {
        d dVar;
        d dVar2 = g;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            if (g == null) {
                g = new d();
            }
            dVar = g;
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.opos.cmn.biz.requeststatistic.cache.a.b bVar) {
        com.opos.cmn.an.j.b.a().execute(new c(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f6012a.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public void a() {
        com.opos.cmn.biz.requeststatistic.cache.a aVar = this.f;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(Context context) {
        if (this.f6012a != null) {
            return;
        }
        this.f6012a = context;
        this.b = new com.opos.cmn.biz.requeststatistic.cache.b(context);
        this.e = new com.opos.cmn.biz.requeststatistic.cache.a(new a(), Integer.MAX_VALUE);
        this.f = new com.opos.cmn.biz.requeststatistic.cache.a(new b(), Integer.MAX_VALUE, 1800000);
    }

    public void a(com.opos.cmn.biz.requeststatistic.cache.c cVar) {
        if (this.d.size() < 1000) {
            this.d.offer(cVar);
        } else {
            com.opos.cmn.an.f.a.d("CacheModel", "cacheEntity is more than 1000");
        }
        com.opos.cmn.biz.requeststatistic.cache.a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void b(com.opos.cmn.biz.requeststatistic.cache.c cVar) {
        if (this.d.remove(cVar)) {
            return;
        }
        com.opos.cmn.an.j.b.a().execute(new RunnableC0879d(cVar));
    }
}
