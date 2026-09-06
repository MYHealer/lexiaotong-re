package com.byazt.tjo;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 516, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f2743a;
    public final List<com.byazt.zh.uj> c;
    public long da;
    public long i;
    public final Runnable n;
    public long sl;
    public final AtomicBoolean sp;
    public final List<com.byazt.zh.uj> tt;
    public final Runnable uj;
    public final Handler ve;
    public long x;

    /* JADX INFO: renamed from: com.byazt.tjo.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 516, 44})
    private static class C0282c {
        public static final c c = new c();
    }

    private c() {
        this.c = new CopyOnWriteArrayList();
        this.tt = new CopyOnWriteArrayList();
        this.ve = com.byazt.nr.da.ve();
        this.uj = new Runnable() { // from class: com.byazt.tjo.c$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.n();
            }
        };
        this.n = new Runnable() { // from class: com.byazt.tjo.c$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.tt();
            }
        };
        this.f2743a = new AtomicBoolean(false);
        this.sp = new AtomicBoolean(false);
        this.x = Long.MIN_VALUE;
        this.i = Long.MIN_VALUE;
        this.da = Long.MIN_VALUE;
        this.sl = Long.MIN_VALUE;
    }

    public static c c() {
        return C0282c.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        c(true);
    }

    public void c(com.byazt.zh.uj ujVar) {
        if (ujVar == null) {
            return;
        }
        if (ujVar.c() == 3) {
            tt(ujVar);
        } else {
            ve(ujVar);
        }
    }

    private void ve(com.byazt.zh.uj ujVar) {
        long jQy = com.byazt.bp.tt.tt().qy();
        HashMap map = new HashMap();
        map.put("config_use_type", Integer.valueOf(com.byazt.bp.tt.tt().sl()));
        map.put("config_wait_duration", Long.valueOf(jQy));
        if (jQy == 0) {
            ujVar.c(false, map);
            return;
        }
        if (uj(ujVar)) {
            map.put("is_wait_success", 2);
            ujVar.c(false, map);
            return;
        }
        if (!this.c.contains(ujVar)) {
            if (this.i == Long.MIN_VALUE) {
                this.i = System.currentTimeMillis();
            }
            this.c.add(ujVar);
        }
        if (this.f2743a.compareAndSet(false, true)) {
            com.byazt.bp.tt.tt().qy();
            this.ve.postDelayed(this.uj, com.byazt.bp.tt.tt().qy());
        }
    }

    private boolean uj(com.byazt.zh.uj ujVar) {
        com.byazt.nbs.tt ttVarC = c(ujVar.tt(), ujVar.c(), 100);
        if (ttVarC == null || System.currentTimeMillis() - ttVarC.tt() >= com.byazt.bp.tt.tt().gt()) {
            return !com.byazt.vq.c.c().c(ujVar.tt(), ujVar.c(), com.byazt.qv.uj.c(ujVar.tt()));
        }
        com.byazt.bp.tt.tt().gt();
        return true;
    }

    public void c(final boolean z) {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.tjo.c.1
            @Override // java.lang.Runnable
            public void run() {
                c.this.tt(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(boolean z) {
        synchronized (this.c) {
            if (this.c.isEmpty()) {
                this.f2743a.set(false);
                return;
            }
            ArrayList<com.byazt.zh.uj> arrayList = new ArrayList(this.c);
            this.c.clear();
            long jQy = com.byazt.bp.tt.tt().qy();
            HashMap map = new HashMap();
            map.put("config_use_type", Integer.valueOf(com.byazt.bp.tt.tt().sl()));
            map.put("config_wait_duration", Long.valueOf(jQy));
            for (com.byazt.zh.uj ujVar : arrayList) {
                if (z) {
                    com.byazt.nbs.tt ttVarC = c(ujVar.tt(), ujVar.c(), 100);
                    map.put("is_wait_success", 0);
                    ujVar.c(ttVarC == null, map);
                } else {
                    if (this.sl == Long.MIN_VALUE) {
                        this.sl = System.currentTimeMillis() - this.i;
                    }
                    map.put("real_wait_duration", Long.valueOf(this.sl));
                    map.put("is_wait_success", 1);
                    ujVar.c(false, map);
                }
            }
            this.ve.removeCallbacks(this.uj);
            this.f2743a.set(false);
        }
    }

    public void tt(com.byazt.zh.uj ujVar) {
        long jRl = com.byazt.bp.tt.tt().rl();
        HashMap map = new HashMap();
        map.put("config_use_type", Integer.valueOf(com.byazt.bp.tt.tt().sl()));
        map.put("config_wait_duration", Long.valueOf(jRl));
        if (jRl == 0) {
            ujVar.c(false, map);
            return;
        }
        if (uj(ujVar)) {
            map.put("is_wait_success", 2);
            ujVar.c(false, map);
            return;
        }
        if (!this.tt.contains(ujVar)) {
            if (this.x == Long.MIN_VALUE) {
                this.x = System.currentTimeMillis();
            }
            this.tt.add(ujVar);
        }
        if (this.sp.compareAndSet(false, true)) {
            com.byazt.bp.tt.tt().rl();
            this.ve.postDelayed(this.n, com.byazt.bp.tt.tt().rl());
        }
    }

    public void tt() {
        com.byazt.eu.n.ve(new Runnable() { // from class: com.byazt.tjo.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.uj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        synchronized (this.tt) {
            if (this.tt.isEmpty()) {
                this.sp.set(false);
                return;
            }
            ArrayList arrayList = new ArrayList(this.tt);
            this.tt.clear();
            long jRl = com.byazt.bp.tt.tt().rl();
            HashMap map = new HashMap();
            map.put("config_use_type", Integer.valueOf(com.byazt.bp.tt.tt().sl()));
            map.put("config_wait_duration", Long.valueOf(jRl));
            map.put("is_wait_success", 1);
            if (this.da == Long.MIN_VALUE) {
                this.da = System.currentTimeMillis() - this.x;
            }
            map.put("real_wait_duration", Long.valueOf(this.da));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((com.byazt.zh.uj) it.next()).c(false, map);
            }
            this.ve.removeCallbacks(this.n);
            this.sp.set(false);
        }
    }

    private com.byazt.nbs.tt c(String str, int i, int i2) {
        com.byazt.nbs.tt ttVarC = com.byazt.bp.tt.tt().c(str, i, i2);
        return (ttVarC == null && i == 8) ? com.byazt.bp.tt.tt().c(str, 10, i2) : ttVarC;
    }

    public void ve() {
        tt();
        c(false);
    }
}
