package com.opos.mobad.g.a.a;

import android.content.Context;
import com.opos.mobad.ad.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f<T extends com.opos.mobad.ad.b> extends h<T> implements n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.opos.mobad.g.a.b.a<T> f6925a;
    private List<T> c;
    private T d;
    private int g;
    private int h;
    private Context i;
    private AtomicBoolean j;

    public f(Context context, String str, int i, com.opos.mobad.g.a.c.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.b<T> bVar, com.opos.mobad.ad.b.a aVar3) {
        super(str, i, aVar, list, aVar2, j, bVar, aVar3);
        this.d = null;
        this.g = 0;
        this.h = 0;
        this.j = new AtomicBoolean(false);
        this.i = context;
        this.f6925a = bVar;
        this.c = new ArrayList(list.size());
        this.g = com.opos.cmn.an.h.f.a.b(context);
        this.h = com.opos.cmn.an.h.f.a.a(context, 57.0f);
    }

    private void g() {
        com.opos.cmn.an.f.a.b("BasePercentDispatcher", "clearCacheDestroyAd size =" + this.c.size());
        if (this.c.isEmpty()) {
            return;
        }
        Iterator<T> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.c.clear();
    }

    private boolean i(int i) {
        return i == com.opos.mobad.c.a.d.a.b && this.j.get();
    }

    @Override // com.opos.mobad.g.a.a.n
    public void a(int i, int i2) {
        if (i == this.g && i2 == this.h) {
            return;
        }
        this.h = i2;
        this.g = i;
        this.j.compareAndSet(false, true);
        h(com.opos.mobad.c.a.d.a.b);
    }

    @Override // com.opos.mobad.g.a.a.h
    protected void a(String str, com.opos.mobad.c.a.d.a aVar, List<String> list) {
        com.opos.cmn.an.f.a.b("SyncStateController", "loadChannelAd channel =" + aVar.m);
        T tB = this.b.get(Integer.valueOf(aVar.m));
        if (tB == null || c() == 5) {
            com.opos.cmn.an.f.a.b("BasePercentDispatcher", "loadChannelAd but null ad:" + tB);
            return;
        }
        if (i(aVar.m) || tB.c() == 2) {
            com.opos.cmn.an.f.a.b("SyncStateController", "channel =" + aVar.m + " has loaded, need to reNew:" + this.f6925a);
            com.opos.mobad.g.a.b.a<T> aVar2 = this.f6925a;
            if (aVar2 == null) {
                return;
            }
            tB = aVar2.b(aVar, this);
            if (aVar.m == com.opos.mobad.c.a.d.a.b && (tB instanceof com.opos.mobad.ad.a.b)) {
                this.j.compareAndSet(true, false);
                ((com.opos.mobad.ad.a.b) tB).a(com.opos.cmn.an.h.f.a.b(this.i, this.g), com.opos.cmn.an.h.f.a.b(this.i, this.h));
            }
            this.b.put(Integer.valueOf(aVar.m), tB);
        }
        if (aVar.m != com.opos.mobad.c.a.d.a.f6704a) {
            tB.b(str);
        } else if (list == null) {
            tB.a(str, (int) aVar.o);
        } else {
            tB.a(str, (int) aVar.o, list);
        }
    }

    @Override // com.opos.mobad.g.a.a.h
    protected boolean a(int i, int i2, String str) {
        if (!i(i)) {
            return super.a(i, i2, str);
        }
        com.opos.cmn.an.f.a.a("BasePercentDispatcher", "interceptToStartNext :" + i + ",code: " + i2 + ", msg:" + str);
        a(m.a(i, i, i2, str));
        return true;
    }

    @Override // com.opos.mobad.g.a.a.h
    protected boolean a(T t, int i) {
        if (!i(i)) {
            return super.a(t, i);
        }
        com.opos.cmn.an.f.a.b("SyncStateController", "is channel enable but size change");
        return false;
    }

    @Override // com.opos.mobad.g.a.a.h, com.opos.mobad.q.j, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.f6925a = null;
        g();
    }

    @Override // com.opos.mobad.g.a.a.h
    protected void f(int i) {
        g();
        T t = this.d;
        if (t != null) {
            this.c.add(t);
        }
        this.d = this.b.get(Integer.valueOf(i));
        super.f(i);
    }
}
