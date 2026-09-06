package com.alipay.android.phone.mrpc.core;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class a implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Method f1567a;
    protected byte[] b;
    protected String c;
    protected int d;
    protected String e;
    protected boolean f;

    public a(Method method, int i, String str, byte[] bArr, String str2, boolean z) {
        this.f1567a = method;
        this.d = i;
        this.c = str;
        this.b = bArr;
        this.e = str2;
        this.f = z;
    }
}
