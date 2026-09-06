package com.qq.e.comm.util;

import android.os.SystemClock;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f8515a;
    private final StringBuilder b = new StringBuilder();
    private long c;

    public void a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f8515a;
        this.c += jElapsedRealtime;
        this.b.append(jElapsedRealtime).append(",");
    }

    public void b() {
        a();
        c();
    }

    public void c() {
        this.f8515a = SystemClock.elapsedRealtime();
    }

    public String toString() {
        int length = this.b.length();
        return length <= 0 ? "" : this.b.deleteCharAt(length - 1).append(x.bQ).append(this.c).toString();
    }
}
