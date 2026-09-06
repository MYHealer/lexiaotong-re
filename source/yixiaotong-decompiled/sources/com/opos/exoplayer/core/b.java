package com.opos.exoplayer.core;

import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6270a;
    public static final UUID b;
    public static final UUID c;
    public static final UUID d;
    public static final UUID e;
    public static final UUID f;

    static {
        f6270a = com.opos.exoplayer.core.i.y.f6517a < 23 ? 1020 : 6396;
        b = new UUID(0L, 0L);
        c = new UUID(1186680826959645954L, -5988876978535335093L);
        d = new UUID(-2129748144642739255L, 8654423357094679310L);
        e = new UUID(-1301668207276963122L, -6645017420763422227L);
        f = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long a(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }

    public static long b(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }
}
