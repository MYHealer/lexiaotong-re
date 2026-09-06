package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3679a = 0;
    private int b = 0;
    private long c = 0;
    private long d = 0;

    public long a() {
        int i = this.f3679a;
        if (i > 0) {
            return this.d / ((long) i);
        }
        return 0L;
    }

    public synchronized void a(boolean z, int i, long j) {
        this.f3679a++;
        if (!z) {
            this.b++;
        }
        this.c += (long) i;
        this.d += j;
    }

    public String toString() {
        return "TimeStatInfo#" + hashCode() + "{totalCount='" + this.f3679a + ",failCount=" + this.b + ",executeDataLen=" + this.c + ",executeTime=" + this.d + ",agvTime=" + a() + '}';
    }
}
