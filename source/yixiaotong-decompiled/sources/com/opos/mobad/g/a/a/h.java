package com.opos.mobad.g.a.a;

import com.opos.mobad.ad.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class h<T extends com.opos.mobad.ad.b> extends com.opos.mobad.q.j implements p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6927a;
    protected Map<Integer, T> b;
    private List<String> c;
    private String d;
    private int g;
    private int h;
    private int i;
    private com.opos.mobad.g.a.o<com.opos.mobad.g.a.c.a.C0966a> j;
    private com.opos.mobad.g.a.p k;
    private v<com.opos.mobad.c.a.d.a> l;
    private Map<Integer, Boolean> m;
    private Map<Integer, com.opos.mobad.c.a.d.a> n;
    private com.opos.mobad.c.a.d.a o;
    private com.opos.mobad.g.a.c.a p;
    private x q;
    private int r;
    private String s;

    public h(String str, int i, com.opos.mobad.g.a.c.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.a<T> aVar3, com.opos.mobad.ad.b.a aVar4) {
        this(str, i, aVar, list, aVar2, j, aVar3, aVar4, null);
    }

    public h(final String str, int i, com.opos.mobad.g.a.c.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.a<T> aVar3, com.opos.mobad.ad.b.a aVar4, x xVar) {
        super(aVar4);
        this.h = -1;
        this.i = -1;
        this.d = str;
        this.g = i;
        this.p = aVar;
        if (xVar == null) {
            this.q = new x(str, j);
        } else {
            this.q = xVar;
        }
        this.j = new com.opos.mobad.g.a.o<>(new com.opos.mobad.g.a.o.a<com.opos.mobad.g.a.c.a.C0966a>() { // from class: com.opos.mobad.g.a.a.h.1
            @Override // com.opos.mobad.g.a.o.a
            public void a(com.opos.mobad.g.a.c.a.C0966a c0966a) {
                if (c0966a == null) {
                    return;
                }
                h.this.c(c0966a.b, "" + c0966a.c);
            }
        });
        this.k = new com.opos.mobad.g.a.p(new Runnable() { // from class: com.opos.mobad.g.a.a.h.2
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.an.f.a.a("BasePercentDispatcher", "timeout for next =" + str);
                if (1 != h.this.c()) {
                    com.opos.cmn.an.f.a.b("BasePercentDispatcher", "start with error state");
                } else {
                    h.this.q.a(h.this.i, -2);
                    h.this.a(-1, com.opos.mobad.ad.a.a(-1), h.this.c);
                }
            }
        });
        this.b = new ConcurrentHashMap(list.size());
        this.m = new ConcurrentHashMap(list.size());
        this.n = new HashMap(list.size());
        a(list, aVar3);
        if (aVar2 != null) {
            a(aVar2, aVar3);
        }
    }

    private void a(com.opos.mobad.c.a.d.a aVar, com.opos.mobad.g.a.b.a<T> aVar2) {
        if (this.b.containsKey(Integer.valueOf(aVar.m))) {
            this.o = aVar;
            return;
        }
        T tB = aVar2.b(aVar, this);
        if (tB == null) {
            com.opos.cmn.an.f.a.d("BasePercentDispatcher", "disable reserve");
        } else {
            this.b.put(Integer.valueOf(aVar.m), tB);
            this.o = aVar;
        }
    }

    private void a(List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.g.a.b.a<T> aVar) {
        StringBuilder sbAppend;
        v.a aVar2 = new v.a();
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "channel size:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            com.opos.mobad.c.a.d.a aVar3 = list.get(i);
            this.n.put(Integer.valueOf(aVar3.m), aVar3);
            if (aVar3.r <= 0) {
                sbAppend = new StringBuilder("percent fail with channel:").append(aVar3.m);
            } else {
                T tB = aVar.b(aVar3, this);
                if (tB == null) {
                    sbAppend = new StringBuilder("ad null with channel:").append(aVar3);
                } else {
                    this.b.put(Integer.valueOf(aVar3.m), tB);
                    aVar2.a(aVar3, aVar3.r);
                }
            }
            com.opos.cmn.an.f.a.a("BasePercentDispatcher", sbAppend.toString());
        }
        this.l = aVar2.a();
    }

    private void b(int i, String str, List<String> list) {
        this.r = i;
        this.s = str;
        com.opos.mobad.c.a.d.a aVarA = this.l.a();
        if (aVarA == null) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "reserve:" + this.o + ",current:" + this.i);
            com.opos.mobad.c.a.d.a aVar = this.o;
            if (aVar == null || this.i == aVar.m) {
                c(i, str);
                j(-7);
                return;
            }
            aVarA = this.o;
        }
        this.i = aVarA.m;
        com.opos.mobad.g.a.c.a.C0966a c0966aA = this.p.a(aVarA.m, list != null);
        if (c0966aA != null && !c0966aA.f6961a) {
            this.q.a(aVarA.m, c0966aA.b);
            b(i, str, list);
            return;
        }
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "start:" + aVarA.m);
        if (aVarA.m != com.opos.mobad.c.a.d.a.f6704a && this.m.containsKey(Integer.valueOf(aVarA.m)) && this.m.get(Integer.valueOf(aVarA.m)).booleanValue() && g(aVarA.m)) {
            final int i2 = aVarA.m;
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "cache");
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.g.a.a.h.4
                @Override // java.lang.Runnable
                public void run() {
                    h.this.i(i2);
                }
            });
        } else {
            a(this.f6927a, aVarA, list);
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "timeout:" + aVarA.o);
            this.k.a(aVarA.o);
        }
    }

    private void g() {
        this.i = -1;
        this.k.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final int i) {
        this.j.a();
        this.k.a();
        com.opos.mobad.g.a.c.a.C0966a c0966aA = this.p.a(this.d, i, this.c != null);
        if (c0966aA.f6961a) {
            c(new Callable<Boolean>() { // from class: com.opos.mobad.g.a.a.h.5
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    h.this.f(i);
                    return true;
                }
            });
        } else {
            c(c0966aA.b, c0966aA.c);
            j(c0966aA.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(int i) {
        g();
        this.q.b(i);
    }

    protected final void a(int i, String str, List<String> list) {
        if (1 != c()) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "start with error state");
        } else {
            b(i, str, list);
        }
    }

    @Override // com.opos.mobad.g.a.a.p
    public final void a(m mVar) {
        com.opos.cmn.an.f.a.a("BasePercentDispatcher", "onChannelPercentFailed :", mVar, "curChannel:" + this.i);
        if (mVar == null || mVar.f6940a != this.i) {
            return;
        }
        if (1 != c()) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "start with error state");
        } else {
            this.q.a(mVar.b, mVar.d);
            a(mVar.c, mVar.e, this.c);
        }
    }

    protected void a(String str, com.opos.mobad.c.a.d.a aVar, List<String> list) {
        T t = this.b.get(Integer.valueOf(aVar.m));
        if (aVar.m != com.opos.mobad.c.a.d.a.f6704a) {
            t.b(str);
        } else if (list == null) {
            t.a(str, (int) aVar.o);
        } else {
            t.a(str, (int) aVar.o, list);
        }
    }

    protected boolean a(int i, int i2, String str) {
        return false;
    }

    protected boolean a(T t, int i) {
        if (t == null) {
            return false;
        }
        return t.d();
    }

    @Override // com.opos.mobad.q.j
    protected boolean a(String str, List<String> list) {
        return a(str, (List<String>) null, "");
    }

    @Override // com.opos.mobad.q.j
    protected boolean a(String str, List<String> list, String str2) {
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "doload:" + str);
        com.opos.mobad.g.a.c.a.C0966a c0966aA = this.p.a(this.d);
        this.q.a(str, str2);
        this.q.a();
        if (!c0966aA.f6961a) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "intercept " + c0966aA.c);
            this.j.a(500L, c0966aA);
            if (c0966aA.b == -4) {
                return true;
            }
            this.q.c(c0966aA.b);
            return true;
        }
        this.h = -1;
        this.i = -1;
        this.f6927a = str;
        this.c = list;
        this.j.a();
        this.k.a();
        this.l.b();
        b(-1, com.opos.mobad.ad.a.a(-1), list);
        return true;
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        this.j.b();
        this.k.b();
        g();
        if (this.q != null && c() == 1) {
            this.q.b(-6);
        }
        this.l.b();
        super.b();
        Iterator<Integer> it = this.b.keySet().iterator();
        while (it.hasNext()) {
            this.b.get(it.next()).b();
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b(String str) {
        a(str, this.g);
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return a(str, (List<String>) null);
    }

    @Override // com.opos.mobad.g.a.a.p
    public final void d(int i) {
        com.opos.cmn.an.f.a.a("BasePercentDispatcher", "onChannelPercentSucc :" + i + ",cur:" + this.i);
        this.m.put(Integer.valueOf(i), true);
        if (c() == 1 && i == this.i && !a(i, this.r, this.s)) {
            i(i);
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public boolean d() {
        return a(this.b.get(Integer.valueOf(this.h)), this.h);
    }

    @Override // com.opos.mobad.g.a.a.p
    public void e(int i) {
        if (i == i()) {
            m();
        }
    }

    protected void f(int i) {
        com.opos.cmn.an.f.a.a("BasePercentDispatcher", "percent select:" + i);
        g();
        this.q.a(i);
        this.m.put(Integer.valueOf(i), false);
        this.h = i;
    }

    @Override // com.opos.mobad.q.j
    protected void f_() {
        a(new Callable<Boolean>() { // from class: com.opos.mobad.g.a.a.h.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                h.this.j.a();
                h.this.k.a();
                if (h.this.i != -1) {
                    h.this.q.a(h.this.i, -2);
                }
                h.this.j(-2);
                return true;
            }
        });
    }

    protected boolean g(int i) {
        return a(this.b.get(Integer.valueOf(i)), i);
    }

    @Override // com.opos.mobad.g.a.a.p
    public T h() {
        return this.b.get(Integer.valueOf(this.h));
    }

    protected void h(int i) {
        this.m.put(Integer.valueOf(i), false);
    }

    @Override // com.opos.mobad.g.a.a.p
    public int i() {
        int i;
        if (2 != c() || (i = this.h) == -1) {
            return -1;
        }
        return i;
    }

    @Override // com.opos.mobad.g.a.a.p
    public com.opos.mobad.c.a.d.a j() {
        return this.n.get(Integer.valueOf(i()));
    }
}
