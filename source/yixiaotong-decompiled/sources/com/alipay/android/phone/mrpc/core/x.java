package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g f1589a;
    private z b = new z(this);

    public x(g gVar) {
        this.f1589a = gVar;
    }

    public final g a() {
        return this.f1589a;
    }

    public final <T> T a(Class<T> cls) {
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new y(this.f1589a, cls, this.b));
    }
}
