package com.opos.exoplayer.core.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6516a;
    private long b;
    private volatile long c = -9223372036854775807L;

    public w(long j) {
        c(j);
    }

    public static long a(long j) {
        return (j * 1000000) / com.baidu.oauth.sdkbqt.auth.i.f1876a;
    }

    public static long b(long j) {
        return (j * com.baidu.oauth.sdkbqt.auth.i.f1876a) / 1000000;
    }

    public long a() {
        return this.f6516a;
    }

    public long b() {
        if (this.c != -9223372036854775807L) {
            return this.c;
        }
        long j = this.f6516a;
        if (j != Long.MAX_VALUE) {
            return j;
        }
        return -9223372036854775807L;
    }

    public long c() {
        if (this.f6516a == Long.MAX_VALUE) {
            return 0L;
        }
        if (this.c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.b;
    }

    public synchronized void c(long j) {
        a.b(this.c == -9223372036854775807L);
        this.f6516a = j;
    }

    public long d(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            long jB = b(this.c);
            long j2 = (4294967296L + jB) / 8589934592L;
            long j3 = ((j2 - 1) * 8589934592L) + j;
            j += j2 * 8589934592L;
            if (Math.abs(j3 - jB) < Math.abs(j - jB)) {
                j = j3;
            }
        }
        return e(a(j));
    }

    public void d() {
        this.c = -9223372036854775807L;
    }

    public long e(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.c != -9223372036854775807L) {
            this.c = j;
        } else {
            long j2 = this.f6516a;
            if (j2 != Long.MAX_VALUE) {
                this.b = j2 - j;
            }
            synchronized (this) {
                this.c = j;
                notifyAll();
            }
        }
        return j + this.b;
    }
}
