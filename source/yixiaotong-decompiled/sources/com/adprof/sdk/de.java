package com.adprof.sdk;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class de implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f1127a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final transient di f212a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final transient q6 f213a;

    public de(di diVar, q6 q6Var) {
        if (diVar == null) {
            throw new NullPointerException("adapter == null");
        }
        if (q6Var == null) {
            throw new NullPointerException("unknownFields == null");
        }
        this.f212a = diVar;
        this.f213a = q6Var;
    }

    public final q6 a() {
        q6 q6Var = this.f213a;
        return q6Var != null ? q6Var : q6.f1379a;
    }

    public final Object writeReplace() throws ObjectStreamException {
        return new ee(this.f212a.m609a((Object) this), getClass());
    }
}
