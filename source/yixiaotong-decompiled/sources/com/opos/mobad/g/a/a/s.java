package com.opos.mobad.g.a.a;

import com.opos.mobad.ad.b;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class s<T extends com.opos.mobad.ad.b, P> extends h<T> implements q<T, P> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final HashMap<Integer, List<P>> f6942a;

    public s(String str, int i, com.opos.mobad.g.a.c.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.c<T> cVar, com.opos.mobad.ad.b.a aVar3) {
        super(str, i, aVar, list, aVar2, j, cVar, aVar3);
        this.f6942a = new HashMap<>();
    }

    @Override // com.opos.mobad.g.a.a.q
    public List<P> g() {
        return this.f6942a.remove(Integer.valueOf(i()));
    }

    @Override // com.opos.mobad.g.a.a.h
    protected boolean g(int i) {
        return this.f6942a.containsKey(Integer.valueOf(i));
    }
}
