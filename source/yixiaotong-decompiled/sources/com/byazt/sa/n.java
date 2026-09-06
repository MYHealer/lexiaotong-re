package com.byazt.sa;

import android.content.Context;
import com.byazt.pm.da;
import com.byazt.pm.x;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 795, 46})
public class n {
    public static volatile n c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.dq.uj f2686a;
    public com.byazt.wj.c n;
    public com.byazt.lv.c sp;
    public List<com.byazt.sz.tt> tt;
    public c uj;
    public com.byazt.sz.ve ve;

    public void c(com.byazt.dq.uj ujVar) {
        this.f2686a = ujVar;
    }

    public void c(com.byazt.lv.c cVar) {
        this.sp = cVar;
    }

    public void c(com.byazt.wj.c cVar) {
        this.n = cVar;
    }

    public com.byazt.lv.c n() {
        return this.sp;
    }

    public c tt() {
        return this.uj;
    }

    public com.byazt.dq.uj uj() {
        return this.f2686a;
    }

    public com.byazt.wj.c ve() {
        return this.n;
    }

    public static n c() {
        if (c == null) {
            synchronized (n.class) {
                if (c == null) {
                    c = new n();
                }
            }
        }
        return c;
    }

    private n() {
    }

    public void c(Context context, com.byazt.sz.ve veVar, c cVar) {
        this.ve = veVar;
        this.uj = cVar;
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList();
        this.tt = arrayList;
        com.byazt.sz.ve veVar = this.ve;
        if (veVar != null) {
            arrayList.addAll(veVar.c());
        }
        com.byazt.sz.uj.c(this.tt);
    }

    public void c(x xVar) {
        ArrayList arrayList = new ArrayList(new com.byazt.pm.c().c());
        if (xVar != null) {
            arrayList.addAll(xVar.c());
        }
        da.c(arrayList);
    }

    public void c(com.byazt.pm.ve veVar) {
        ArrayList arrayList = new ArrayList(new com.byazt.pm.n().c());
        if (veVar != null) {
            arrayList.addAll(veVar.c());
        }
        com.byazt.pm.uj.c(arrayList);
    }
}
