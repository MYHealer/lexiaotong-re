package com.opos.mobad.model.c;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, com.opos.mobad.l.a> f7180a;

    public ConcurrentHashMap<String, com.opos.mobad.l.a> a() {
        return this.f7180a;
    }

    public void a(ConcurrentHashMap<String, com.opos.mobad.l.a> concurrentHashMap) {
        this.f7180a = concurrentHashMap;
    }

    public String toString() {
        return "FetchMaterialRequest{downloadRequestMap=" + this.f7180a + '}';
    }
}
