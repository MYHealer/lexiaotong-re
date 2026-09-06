package com.adprof.sdk;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class di {
    public static final di b;
    public static final di c;
    public static final di d;
    public static final di e;
    public static final di f;
    public static final di g;
    public static final di h;
    public static final di i;
    public static final di j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b9 f1131a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public di f222a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Class f223a;

    static {
        b9 b9Var = b9.VARINT;
        b = new xh(b9Var, Boolean.class);
        c = new yh(b9Var, Integer.class);
        d = new zh(b9.FIXED32, Integer.class);
        e = new ai(b9Var, Long.class);
        f = new bi(b9Var, Long.class);
        b9 b9Var2 = b9.FIXED64;
        g = new ci(b9Var2, Long.class);
        h = new th(b9Var2, Double.class);
        b9 b9Var3 = b9.LENGTH_DELIMITED;
        i = new uh(b9Var3, String.class);
        j = new vh(b9Var3, q6.class);
    }

    public di(b9 b9Var, Class cls) {
        this.f1131a = b9Var;
        this.f223a = cls;
    }

    public abstract int a(Object obj);

    public final di a() {
        di diVar = this.f222a;
        if (diVar != null) {
            return diVar;
        }
        wh whVar = new wh(this, this.f1131a, List.class);
        this.f222a = whVar;
        return whVar;
    }

    public abstract Object a(ei eiVar) throws IOException;

    public abstract void a(fi fiVar, Object obj) throws IOException;

    public final Object a(byte[] bArr) throws IOException {
        if (bArr != null) {
            return a(new ei(new l6().a(bArr, 0, bArr.length)));
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final byte[] m609a(Object obj) {
        l6 l6Var = new l6();
        try {
            a(new fi(l6Var), obj);
            try {
                return l6Var.m672a(l6Var.f1279a);
            } catch (EOFException e2) {
                throw new AssertionError(e2);
            }
        } catch (IOException e3) {
            throw new AssertionError(e3);
        }
    }

    public void a(fi fiVar, int i2, Object obj) throws IOException {
        if (obj == null) {
            return;
        }
        b9 b9Var = this.f1131a;
        fiVar.getClass();
        fiVar.b((i2 << 3) | b9Var.f93a);
        if (this.f1131a == b9.LENGTH_DELIMITED) {
            fiVar.b(a(obj));
        }
        a(fiVar, obj);
    }

    public int a(int i2, Object obj) {
        if (obj == null) {
            return 0;
        }
        int iA = a(obj);
        if (this.f1131a == b9.LENGTH_DELIMITED) {
            iA += fi.a(iA);
        }
        return iA + fi.a(i2 << 3);
    }
}
