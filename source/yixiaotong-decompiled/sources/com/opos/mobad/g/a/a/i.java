package com.opos.mobad.g.a.a;

import com.opos.mobad.ad.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i<T extends com.opos.mobad.ad.b> extends com.opos.mobad.q.j implements p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6933a;
    protected Map<Integer, T> b;
    protected HashMap<Integer, com.opos.mobad.c.a.d.a> c;
    private int d;
    private int g;
    private v<com.opos.mobad.c.a.d.a> h;
    private j i;
    private Map<Integer, com.opos.mobad.c.a.d.a> j;
    private com.opos.mobad.c.a.d.a k;
    private CountDownLatch l;
    private com.opos.mobad.g.a.c.a m;
    private w n;
    private Map<Integer, m> o;
    private com.opos.mobad.g.a.o<com.opos.mobad.g.a.c.a.C0966a> p;
    private int q;
    private String r;
    private int s;

    public i(String str, int i, com.opos.mobad.g.a.c.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, int i2, com.opos.mobad.g.a.b.a<T> aVar3, com.opos.mobad.ad.b.a aVar4) {
        super(aVar4);
        this.g = -1;
        this.l = null;
        this.q = -1;
        this.r = "unknown error.";
        this.m = aVar;
        this.n = new w(str, i2, j);
        this.o = new HashMap();
        this.f6933a = str;
        this.s = i2;
        this.d = i;
        this.b = new ConcurrentHashMap(list.size());
        this.c = new HashMap<>(list.size());
        this.j = new HashMap(list.size());
        a(list, aVar3);
        if (aVar2 != null) {
            a(aVar2, aVar3);
        }
        this.p = new com.opos.mobad.g.a.o<>(new com.opos.mobad.g.a.o.a<com.opos.mobad.g.a.c.a.C0966a>() { // from class: com.opos.mobad.g.a.a.i.1
            @Override // com.opos.mobad.g.a.o.a
            public void a(com.opos.mobad.g.a.c.a.C0966a c0966a) {
                if (c0966a == null) {
                    return;
                }
                i.this.c(c0966a.b, "" + c0966a.c);
            }
        });
    }

    private void a(com.opos.mobad.c.a.d.a aVar, com.opos.mobad.g.a.b.a<T> aVar2) {
        if (this.b.containsKey(Integer.valueOf(aVar.m))) {
            this.k = aVar;
            return;
        }
        T tB = aVar2.b(aVar, this);
        if (tB == null) {
            com.opos.cmn.an.f.a.d("BaseRankDispatcher", "disable main");
        } else {
            a(aVar, tB);
            this.k = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, boolean z, List<String> list) {
        w wVar;
        int i;
        if (c() == 5) {
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", "dealResult but destroy");
            return;
        }
        com.opos.mobad.c.a.d.a aVarD = d(list);
        if (aVarD != null) {
            d(str, aVarD.m, list);
            return;
        }
        com.opos.cmn.an.f.a.a("BaseRankDispatcher", "deal rank but fail,deal percent");
        com.opos.mobad.c.a.d.a aVarG = g();
        if (aVarG != null) {
            d(str, aVarG.m, list);
            return;
        }
        com.opos.cmn.an.f.a.a("BaseRankDispatcher", "deal fail ,posid=" + this.f6933a);
        if (z) {
            int i2 = this.q;
            if (i2 == -1) {
                c(11007, this.q + "," + this.r);
            } else {
                c(i2, this.r);
            }
            wVar = this.n;
            i = -7;
        } else {
            f_();
            wVar = this.n;
            i = -2;
        }
        wVar.b(i);
    }

    private void a(List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.g.a.b.a<T> aVar) {
        StringBuilder sbAppend;
        ArrayList arrayList = new ArrayList();
        v.a aVar2 = new v.a();
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "channel size:" + list.size());
        for (int i = 0; i < list.size(); i++) {
            com.opos.mobad.c.a.d.a aVar3 = list.get(i);
            this.j.put(Integer.valueOf(aVar3.m), aVar3);
            T tB = aVar.b(aVar3, this);
            if (tB == null) {
                sbAppend = new StringBuilder("ad null with channel:").append(aVar3);
            } else {
                a(aVar3, tB);
                arrayList.add(aVar3);
                if (aVar3.r <= 0) {
                    sbAppend = new StringBuilder("percent fail with channel:").append(aVar3.m);
                } else {
                    aVar2.a(aVar3, aVar3.r);
                }
            }
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", sbAppend.toString());
        }
        this.h = aVar2.a();
        this.i = new j(arrayList);
    }

    private boolean a(com.opos.mobad.c.a.d.a aVar) {
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", "check to select but entity is null");
            return false;
        }
        if (f(aVar.m)) {
            return true;
        }
        g(aVar.m);
        return false;
    }

    private Map<Integer, T> c(List<String> list) {
        if (this.b == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (Map.Entry<Integer, T> entry : this.b.entrySet()) {
            Integer key = entry.getKey();
            if (b(key.intValue(), list)) {
                map.put(key, entry.getValue());
            }
        }
        return map;
    }

    private com.opos.mobad.c.a.d.a d(List<String> list) {
        this.n.b();
        return b(list);
    }

    private void d(final String str, final int i, List<String> list) {
        this.p.a();
        com.opos.mobad.g.a.c.a.C0966a c0966aA = this.m.a(this.f6933a, i, list != null);
        if (c0966aA.f6961a) {
            c(new Callable<Boolean>() { // from class: com.opos.mobad.g.a.a.i.3
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Boolean call() {
                    i.this.c(str, i);
                    return true;
                }
            });
        } else {
            c(c0966aA.b, c0966aA.c);
            this.n.b(c0966aA.b);
        }
    }

    private com.opos.mobad.c.a.d.a g() {
        this.n.a();
        this.h.b();
        for (int i = 0; i < this.b.size(); i++) {
            com.opos.mobad.c.a.d.a aVarA = this.h.a();
            if (a(aVarA)) {
                return aVarA;
            }
        }
        return null;
    }

    private void g(int i) {
        int i2;
        m mVar = this.o.get(Integer.valueOf(i));
        if (mVar != null) {
            i = mVar.b;
            i2 = mVar.d;
        } else {
            i2 = -2;
        }
        this.n.a(i, i2);
    }

    protected void a(com.opos.mobad.c.a.d.a aVar, T t) {
        this.b.put(Integer.valueOf(aVar.m), t);
    }

    @Override // com.opos.mobad.g.a.a.p
    public final void a(m mVar) {
        com.opos.cmn.an.f.a.a("BaseRankDispatcher", "onChannelRankFailed:", mVar);
        if (mVar == null || c() == 5) {
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", "channel fail but destroy");
            return;
        }
        this.q = mVar.c;
        this.r = mVar.e;
        this.o.put(Integer.valueOf(mVar.f6940a), mVar);
        CountDownLatch countDownLatch = this.l;
        if (countDownLatch != null) {
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("BaseRankDispatcher", "fail:" + mVar.f6940a, e);
            }
        }
    }

    protected void a(String str, List<Integer> list, int i, List<String> list2) {
        if (list == null || list.isEmpty()) {
            com.opos.cmn.an.f.a.a("SyncStateController", "error Map to load");
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            T t = this.b.get(Integer.valueOf(iIntValue));
            if (t != null) {
                if (iIntValue != com.opos.mobad.c.a.d.a.f6704a) {
                    t.b(str);
                } else if (list2 == null) {
                    t.a(str, i);
                } else {
                    t.a(str, i, list2);
                }
            }
        }
    }

    protected boolean a(T t, int i) {
        if (t == null) {
            return false;
        }
        return t.d();
    }

    protected boolean a(Map.Entry<Integer, T> entry, T t, List<String> list) {
        if (entry.getKey().intValue() != com.opos.mobad.c.a.d.a.f6704a && this.g != entry.getKey().intValue() && t.c() == 2 && t.d()) {
            return false;
        }
        com.opos.mobad.g.a.c.a.C0966a c0966aA = this.m.a(entry.getKey().intValue(), list != null);
        return c0966aA != null && c0966aA.f6961a;
    }

    protected com.opos.mobad.c.a.d.a b(List<String> list) {
        Map<Integer, T> mapC = c(list);
        if (mapC == null || mapC.size() <= 0) {
            return null;
        }
        return this.i.a(mapC);
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        if (this.n != null && c() == 1) {
            this.n.b(-6);
        }
        this.h.b();
        super.b();
        Iterator<T> it = this.b.values().iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    protected boolean b(int i, List<String> list) {
        if (f(i)) {
            com.opos.mobad.g.a.c.a.C0966a c0966aA = this.m.a(i, list != null);
            if (c0966aA.f6961a) {
                return true;
            }
            com.opos.cmn.an.f.a.a("BaseRankDispatcher", "rank disable ad:" + i + ", code = " + c0966aA.b);
            this.n.a(i, c0966aA.b);
        } else {
            g(i);
        }
        return false;
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i) {
        return b(str, i, null);
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list) {
        return b(str, i, null, "");
    }

    @Override // com.opos.mobad.q.j
    protected boolean b(String str, int i, List<String> list, String str2) {
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "doload:" + str);
        this.n.a(str, str2);
        com.opos.mobad.g.a.c.a.C0966a c0966aA = this.m.a(this.f6933a);
        if (c0966aA.f6961a) {
            this.p.a();
            this.h.b();
            this.o.clear();
            c(str, Math.min(i, this.d), list);
            return true;
        }
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "intercept " + c0966aA.c);
        this.p.a(500L, c0966aA);
        if (c0966aA.b != -4) {
            this.n.c(c0966aA.b);
        }
        return true;
    }

    protected void c(String str, int i) {
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "select:" + i);
        this.g = i;
        this.n.a(i);
    }

    protected void c(final String str, final int i, final List<String> list) {
        List<Integer> arrayList = new ArrayList<>();
        for (Map.Entry<Integer, T> entry : this.b.entrySet()) {
            T value = entry.getValue();
            if (value == null) {
                com.opos.cmn.an.f.a.b("BaseRankDispatcher", "error disable ad");
            } else if (a(entry, value, list)) {
                com.opos.cmn.an.f.a.a("SyncStateController", "add load ad channel:" + entry.getKey());
                arrayList.add(entry.getKey());
            }
        }
        this.g = -1;
        final int size = arrayList.size();
        if (size <= 0) {
            com.opos.cmn.an.f.a.a("SyncStateController", "not need to load");
            a(str, true, list);
        } else {
            this.l = new CountDownLatch(size);
            a(str, arrayList, i, list);
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.g.a.a.i.2
                @Override // java.lang.Runnable
                public void run() {
                    com.opos.cmn.an.f.a.a("SyncStateController", "countdown:" + size + "," + i + ",posid=" + i.this.f6933a);
                    try {
                        if (i.this.c() == 5) {
                            com.opos.cmn.an.f.a.a("SyncStateController", "wait but destroy");
                        } else {
                            final boolean zAwait = i.this.l.await(i, TimeUnit.MILLISECONDS);
                            com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.g.a.a.i.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    i.this.a(str, zAwait, (List<String>) list);
                                }
                            });
                        }
                    } catch (InterruptedException e) {
                        com.opos.cmn.an.f.a.b("", "", e);
                        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.g.a.a.i.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                i.this.a(str, false, (List<String>) list);
                            }
                        });
                    }
                }
            });
        }
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        return true;
    }

    @Override // com.opos.mobad.g.a.a.p
    public final void d(int i) {
        com.opos.cmn.an.f.a.b("BaseRankDispatcher", "onChannelRankSucc channel:" + i);
        if (c() == 5) {
            com.opos.cmn.an.f.a.b("BaseRankDispatcher", "channel suc but destroy");
            return;
        }
        CountDownLatch countDownLatch = this.l;
        if (countDownLatch != null) {
            try {
                countDownLatch.countDown();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("BaseRankDispatcher", "succ:" + i, e);
            }
        }
    }

    @Override // com.opos.mobad.q.j, com.opos.mobad.ad.b
    public boolean d() {
        if (2 != c()) {
            return false;
        }
        return a(this.b.get(Integer.valueOf(this.g)), this.g);
    }

    @Override // com.opos.mobad.g.a.a.p
    public void e(int i) {
        if (i == i()) {
            m();
        }
    }

    protected boolean f(int i) {
        return a(this.b.get(Integer.valueOf(i)), i);
    }

    @Override // com.opos.mobad.g.a.a.p
    public T h() {
        return this.b.get(Integer.valueOf(this.g));
    }

    @Override // com.opos.mobad.g.a.a.p
    public int i() {
        int i;
        if (2 != c() || (i = this.g) == -1) {
            return -1;
        }
        return i;
    }

    @Override // com.opos.mobad.g.a.a.p
    public com.opos.mobad.c.a.d.a j() {
        return this.j.get(Integer.valueOf(i()));
    }
}
