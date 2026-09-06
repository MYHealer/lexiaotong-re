package com.byazt.hz;

import android.content.Context;
import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 701, 54})
public class ve extends tt implements com.byazt.ix.tt {
    public ve(Context context) {
        super(context);
    }

    @Override // com.byazt.ix.tt
    public void c(Context context, com.byazt.ll.tt ttVar, com.byazt.ix.uj.ve veVar) {
        c(ttVar);
        this.ve.ve(true);
        long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
        this.ve.c(jCurrentThreadTimeMillis);
        this.ve.c(veVar);
        com.byazt.ix.uj.c().c(this.n, jCurrentThreadTimeMillis);
        i();
    }

    @Override // com.byazt.ix.tt
    public int c() {
        if (this.ve != null) {
            return this.ve.h();
        }
        return 0;
    }

    @Override // com.byazt.ix.tt
    public ConcurrentHashMap<String, com.byazt.pp.tt> e_() {
        if (this.ve != null) {
            return this.ve.p();
        }
        return null;
    }

    @Override // com.byazt.ix.tt
    public com.byazt.iz.tt uj() {
        return this.ve;
    }
}
