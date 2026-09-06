package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum b9 {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    FIXED32(5);


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f93a;

    b9(int i) {
        this.f93a = i;
    }

    public di a() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return di.f;
        }
        if (iOrdinal == 1) {
            return di.g;
        }
        if (iOrdinal == 2) {
            return di.j;
        }
        if (iOrdinal == 3) {
            return di.d;
        }
        throw new AssertionError();
    }
}
