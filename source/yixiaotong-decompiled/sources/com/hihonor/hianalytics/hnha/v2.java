package com.hihonor.hianalytics.hnha;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class v2 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<p0> f3693a;
    private final int b;

    public v2(List<p0> list, int i) {
        this.f3693a = list;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        p2.c().a(this.f3693a, this.b);
    }
}
