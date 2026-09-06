package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class y implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected g f1590a;
    protected Class<?> b;
    protected z c;

    public y(g gVar, Class<?> cls, z zVar) {
        this.f1590a = gVar;
        this.b = cls;
        this.c = zVar;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        return this.c.a(method, objArr);
    }
}
