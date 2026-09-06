package com.byazt.kt;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 158})
public abstract class sl extends RecyclerView.a {
    public boolean x = true;

    public abstract boolean c(RecyclerView.gu guVar);

    public abstract boolean c(RecyclerView.gu guVar, int i, int i2, int i3, int i4);

    public abstract boolean c(RecyclerView.gu guVar, RecyclerView.gu guVar2, int i, int i2, int i3, int i4);

    public abstract boolean tt(RecyclerView.gu guVar);

    @Override // com.byazt.kt.RecyclerView.a
    public boolean sp(RecyclerView.gu guVar) {
        return !this.x || guVar.yp();
    }

    @Override // com.byazt.kt.RecyclerView.a
    public boolean c(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2) {
        int i = ttVar.c;
        int i2 = ttVar.tt;
        View view = guVar.c;
        int left = ttVar2 == null ? view.getLeft() : ttVar2.c;
        int top = ttVar2 == null ? view.getTop() : ttVar2.tt;
        if (guVar.nu() || (i == left && i2 == top)) {
            return c(guVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return c(guVar, i, i2, left, top);
    }

    @Override // com.byazt.kt.RecyclerView.a
    public boolean tt(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2) {
        return (ttVar == null || (ttVar.c == ttVar2.c && ttVar.tt == ttVar2.tt)) ? tt(guVar) : c(guVar, ttVar.c, ttVar.tt, ttVar2.c, ttVar2.tt);
    }

    @Override // com.byazt.kt.RecyclerView.a
    public boolean ve(RecyclerView.gu guVar, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2) {
        if (ttVar.c == ttVar2.c && ttVar.tt == ttVar2.tt) {
            i(guVar);
            return false;
        }
        return c(guVar, ttVar.c, ttVar.tt, ttVar2.c, ttVar2.tt);
    }

    @Override // com.byazt.kt.RecyclerView.a
    public boolean c(RecyclerView.gu guVar, RecyclerView.gu guVar2, RecyclerView.a.tt ttVar, RecyclerView.a.tt ttVar2) {
        int i;
        int i2;
        int i3 = ttVar.c;
        int i4 = ttVar.tt;
        if (guVar2.R_()) {
            int i5 = ttVar.c;
            i2 = ttVar.tt;
            i = i5;
        } else {
            i = ttVar2.c;
            i2 = ttVar2.tt;
        }
        return c(guVar, guVar2, i3, i4, i, i2);
    }

    public final void x(RecyclerView.gu guVar) {
        a(guVar);
    }

    public final void i(RecyclerView.gu guVar) {
        a(guVar);
    }

    public final void da(RecyclerView.gu guVar) {
        a(guVar);
    }

    public final void c(RecyclerView.gu guVar, boolean z) {
        a(guVar);
    }
}
