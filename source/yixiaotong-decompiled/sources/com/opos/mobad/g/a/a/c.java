package com.opos.mobad.g.a.a;

import android.os.SystemClock;
import com.opos.mobad.g.a.a.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c<T extends p> extends com.opos.mobad.q.j implements n, p, q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6920a;
    private T b;
    private volatile T c;
    private volatile boolean d;
    private volatile boolean g;
    private a<T> h;
    private int i;

    public interface a<T extends p> {
        int a(int i);

        T a(List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar, long j);

        T a(List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar, long j, int i);
    }

    public c(String str, int i, a<T> aVar) {
        super(null);
        this.d = false;
        this.g = false;
        this.f6920a = str;
        this.i = i;
        this.h = aVar;
        this.b = (T) q();
        p();
    }

    private static com.opos.mobad.c.a.d.a a(String str, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar, long j) {
        boolean z = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        for (com.opos.mobad.c.a.d.a aVar2 : list) {
            i2 = aVar2.p;
            i3 = aVar2.q;
            i += aVar2.r;
            z = z || com.opos.mobad.c.a.d.a.f6704a == aVar2.m;
            z2 = z2 || (aVar != null && aVar.m == aVar2.m && aVar2.r > 0);
        }
        if (!z && i < 100) {
            list.add(new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, 100 - i, j, i2, i3));
            z = true;
        }
        if (!z2 && aVar != null) {
            return aVar;
        }
        if (z) {
            return null;
        }
        return new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, 100, j, i2, i3);
    }

    private static com.opos.mobad.c.a.d.a a(List<com.opos.mobad.c.a.d.a> list, String str, long j) {
        if (list == null) {
            list = new ArrayList<>();
        }
        com.opos.mobad.c.a.d.a aVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (com.opos.mobad.c.a.d.a aVar2 : list) {
            if (com.opos.mobad.c.a.d.a.f6704a == aVar2.m) {
                aVar = aVar2;
            }
            i2 = aVar2.p;
            i3 = aVar2.q;
            i += aVar2.r;
        }
        if (aVar != null) {
            return aVar;
        }
        com.opos.mobad.c.a.d.a aVar3 = new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, Math.max(0, 100 - i), j, i2, i3);
        list.add(aVar3);
        return aVar3;
    }

    private boolean a(com.opos.mobad.c.a.d.b bVar) {
        String str;
        a<T> aVar = this.h;
        if (aVar != null) {
            for (com.opos.mobad.c.a.d.a aVar2 : bVar.f6705a) {
                if (aVar2 != null) {
                    int iA = aVar.a(aVar2.m);
                    if (iA == 0 || 2 == iA || 3 == iA) {
                        com.opos.cmn.an.f.a.b("dispatcherW", "has channel init " + aVar2.m);
                    } else {
                        str = "has channel not init " + aVar2.m;
                    }
                }
            }
            return true;
        }
        str = "check but has destroy";
        com.opos.cmn.an.f.a.b("dispatcherW", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.mobad.c.a.d.b b(com.opos.mobad.c.a.d.b bVar) {
        if (bVar == null) {
            return null;
        }
        if (bVar.f6705a == null || bVar.f6705a.size() <= 0) {
            return bVar;
        }
        ArrayList arrayList = new ArrayList();
        a<T> aVar = this.h;
        if (aVar != null) {
            for (com.opos.mobad.c.a.d.a aVar2 : bVar.f6705a) {
                if (aVar2 != null && aVar.a(aVar2.m) == 0) {
                    arrayList.add(aVar2);
                }
            }
        }
        return new com.opos.mobad.c.a.d.b(arrayList, bVar.e, bVar.b, bVar.c, bVar.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(com.opos.mobad.c.a.d.b bVar) {
        T t;
        com.opos.cmn.an.f.a.b("dispatcherW", "initDispatcher:" + this.g + "," + this.d, bVar);
        if (this.g) {
            return;
        }
        if (this.d) {
            return;
        }
        if (bVar.f6705a != null && bVar.f6705a.size() > 0) {
            a<T> aVar = this.h;
            if (aVar == null) {
                t = null;
            } else if (1 != bVar.e) {
                com.opos.mobad.c.a.d.a aVarA = a(bVar.f6705a, this.f6920a, bVar.c);
                com.opos.cmn.an.f.a.b("dispatcherW", "create ssp:", this.f6920a, bVar.f6705a, aVarA);
                t = (T) aVar.a(bVar.f6705a, aVarA, bVar.d, bVar.e);
            } else {
                com.opos.mobad.c.a.d.a aVarA2 = a(this.f6920a, bVar.f6705a, bVar.b, bVar.c);
                com.opos.cmn.an.f.a.b("dispatcherW", "create serial:", this.f6920a, bVar.f6705a, aVarA2);
                t = (T) aVar.a(bVar.f6705a, aVarA2, bVar.d);
            }
            this.d = true;
            com.opos.cmn.an.f.a.b("dispatcherW", "dispatcher succ");
            this.c = t;
            if (this.g && t != null) {
                t.b();
            }
            return;
        }
        com.opos.cmn.an.f.a.b("dispatcherW", "strategy size 0 ");
        this.d = true;
    }

    private void c(String str, int i, List<String> list, String str2) {
        T t = this.c;
        if (t != null) {
            com.opos.cmn.an.f.a.b("dispatcherW", "reset to target");
            T t2 = this.b;
            this.b = t;
            t2.b();
            this.c = null;
        }
        this.b.a(str, i, list, str2);
    }

    private static com.opos.mobad.c.a.d.a d(String str) {
        return new com.opos.mobad.c.a.d.a(com.opos.mobad.c.a.d.a.f6704a, str, 100, 30000L, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, int i, List<String> list, String str2) {
        try {
            c(str, i, list, str2);
        } finally {
            o();
        }
    }

    private void l() {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.g.a.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                c.this.p();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        com.opos.mobad.c.a.d.b bVarA = a(0L);
        if (bVarA != null) {
            c(bVarA);
        }
    }

    private T q() {
        return (T) this.h.a(new ArrayList(), d(this.f6920a), 0L);
    }

    public com.opos.mobad.c.a.d.b a(long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.mobad.c.a.d.b bVarA = com.opos.mobad.c.b.a().a(this.f6920a, true);
        com.opos.cmn.an.f.a.b("dispatcherW", "channelStrategy = " + bVarA);
        if (bVarA != null && a(bVarA)) {
            return bVarA;
        }
        if (j <= 0) {
            return null;
        }
        for (int i = 0; i < 10; i++) {
            bVarA = com.opos.mobad.c.b.a().a(this.f6920a, true);
            if (bVarA != null && a(bVarA)) {
                return bVarA;
            }
            int iElapsedRealtime = ((int) (j - (SystemClock.elapsedRealtime() - jElapsedRealtime))) / (10 - i);
            if (iElapsedRealtime <= 0) {
                return null;
            }
            try {
                Thread.sleep(iElapsedRealtime);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("dispatcherW", "sleep timeout", e);
            }
        }
        return b(bVarA);
    }

    @Override // com.opos.mobad.g.a.a.n
    public void a(int i, int i2) {
        T t = this.b;
        if (t instanceof n) {
            ((n) t).a(i, i2);
        }
    }

    @Override // com.opos.mobad.g.a.a.p
    public void a(m mVar) {
        this.b.a(mVar);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        com.opos.cmn.an.f.a.b("dispatcherW", "destroy");
        this.g = true;
        super.b();
        this.h = null;
        T t = this.b;
        if (t != null) {
            t.b();
        }
        if (this.c != null) {
            this.c.b();
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        return b(str, i, null);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(final String str, final int i, final List<String> list, final String str2) {
        if (!this.d) {
            if (this.i > 0) {
                com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.g.a.a.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.opos.mobad.c.a.d.b bVarB;
                        com.opos.cmn.an.f.a.b("dispatcherW", "init and load ad");
                        if (!c.this.d) {
                            FutureTask futureTask = new FutureTask(new Callable<com.opos.mobad.c.a.d.b>() { // from class: com.opos.mobad.g.a.a.c.1.1
                                @Override // java.util.concurrent.Callable
                                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                                public com.opos.mobad.c.a.d.b call() throws Exception {
                                    return c.this.a(c.this.i);
                                }
                            });
                            com.opos.cmn.an.j.b.c(futureTask);
                            try {
                                bVarB = (com.opos.mobad.c.a.d.b) futureTask.get(c.this.i, TimeUnit.MILLISECONDS);
                            } catch (Exception unused) {
                                com.opos.cmn.an.f.a.b("dispatcherW", "init timeout");
                                bVarB = c.this.b(com.opos.mobad.c.b.a().a(c.this.f6920a, true));
                            }
                            if (bVarB != null) {
                                c.this.c(bVarB);
                            }
                        }
                        c.this.e.post(new Runnable() { // from class: com.opos.mobad.g.a.a.c.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.d(str, i, list, str2);
                            }
                        });
                    }
                });
                return true;
            }
            l();
        }
        d(str, i, list, str2);
        return true;
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.g.a.a.p
    public void d(int i) {
        this.b.d(i);
    }

    @Override // com.opos.mobad.g.a.a.p
    public void e(int i) {
        this.b.e(i);
    }

    @Override // com.opos.mobad.g.a.a.q
    public List g() {
        T t = this.b;
        if (!(t instanceof q)) {
            return null;
        }
        ((q) t).g();
        return null;
    }

    @Override // com.opos.mobad.g.a.a.p
    public com.opos.mobad.ad.b h() {
        return this.b.h();
    }

    @Override // com.opos.mobad.g.a.a.p
    public int i() {
        return this.b.i();
    }

    @Override // com.opos.mobad.g.a.a.p
    public com.opos.mobad.c.a.d.a j() {
        return this.b.j();
    }
}
