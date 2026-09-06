package com.umeng.analytics.pro;

import com.j256.ormlite.stmt.query.SimpleComparison;

/* JADX INFO: compiled from: TMessage.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9131a;
    public final byte b;
    public final int c;

    public bs() {
        this("", (byte) 0, 0);
    }

    public bs(String str, byte b, int i) {
        this.f9131a = str;
        this.b = b;
        this.c = i;
    }

    public String toString() {
        return "<TMessage name:'" + this.f9131a + "' type: " + ((int) this.b) + " seqid:" + this.c + SimpleComparison.GREATER_THAN_OPERATION;
    }

    public boolean equals(Object obj) {
        if (obj instanceof bs) {
            return a((bs) obj);
        }
        return false;
    }

    public boolean a(bs bsVar) {
        return this.f9131a.equals(bsVar.f9131a) && this.b == bsVar.b && this.c == bsVar.c;
    }
}
