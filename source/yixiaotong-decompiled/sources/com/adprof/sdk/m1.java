package com.adprof.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1297a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f456a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f457b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f458c;
    public int d;
    public int e;

    public m1(int i, int i2, int i3, long j, long j2, long j3, int i4, int i5) {
        this.f1297a = i;
        this.b = i2;
        this.c = i3;
        this.f456a = j;
        this.f457b = j2;
        this.f458c = j3;
        this.d = i4;
        this.e = i5;
    }

    public /* synthetic */ m1(int i, int i2, int i3, long j, long j2, long j3, int i4, int i5, int i6) {
        this((i6 & 1) != 0 ? 0 : i, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? 0L : j, (i6 & 16) != 0 ? 0L : j2, (i6 & 32) == 0 ? j3 : 0L, (i6 & 64) != 0 ? 0 : i4, (i6 & 128) == 0 ? i5 : 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return this.f1297a == m1Var.f1297a && this.b == m1Var.b && this.c == m1Var.c && this.f456a == m1Var.f456a && this.f457b == m1Var.f457b && this.f458c == m1Var.f458c && this.d == m1Var.d && this.e == m1Var.e;
    }

    public int hashCode() {
        return (((((((((((((Integer.hashCode(this.f1297a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Long.hashCode(this.f456a)) * 31) + Long.hashCode(this.f457b)) * 31) + Long.hashCode(this.f458c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e);
    }

    public String toString() {
        return "AdRecord(slotCodeDayShowCount=" + this.f1297a + ", slotCodeHourShowCount=" + this.b + ", slotCodeLastShowHour=" + this.c + ", slotCodeLastShowTime=" + this.f456a + ", slotLastShowTime=" + this.f457b + ", slotLastReqTime=" + this.f458c + ", slotDayReqCount=" + this.d + ", slotDayShowCount=" + this.e + ')';
    }
}
