package com.opos.mobad.model.c;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, com.opos.mobad.l.b> f7181a = new ConcurrentHashMap<>();

    public ConcurrentHashMap<String, com.opos.mobad.l.b> a() {
        return this.f7181a;
    }

    public void a(String str, com.opos.mobad.l.b bVar) {
        this.f7181a.put(str, bVar);
    }

    public String toString() {
        return "FetchMaterialResponse{downloadResponseMap=" + this.f7181a + '}';
    }
}
