package com.byazt.pct;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 15})
public abstract class uj<P, R> extends com.byazt.pct.tt<P, R> {
    public boolean c = true;
    public c tt;
    public a ve;

    interface c {
        void c(Object obj);

        void c(Throwable th);
    }

    public interface tt {
        uj c();
    }

    public abstract void c(P p, a aVar) throws Exception;

    public void n() {
        this.c = false;
        this.ve = null;
    }

    public abstract void uj();

    @Override // com.byazt.pct.tt
    public /* bridge */ /* synthetic */ String c() {
        return super.c();
    }

    public final void c(R r) {
        if (sp()) {
            this.tt.c(r);
            n();
        }
    }

    public final void c(Throwable th) {
        if (sp()) {
            this.tt.c(th);
            n();
        }
    }

    public final void ve() {
        c((Throwable) null);
    }

    public void c(P p, a aVar, c cVar) throws Exception {
        this.ve = aVar;
        this.tt = cVar;
        c(p, aVar);
    }

    public void a() {
        uj();
        n();
    }

    private boolean sp() {
        if (this.c) {
            return true;
        }
        i.c(new IllegalStateException("Jsb async call already finished: " + c() + ", hashcode: " + hashCode()));
        return false;
    }
}
