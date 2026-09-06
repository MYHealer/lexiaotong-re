package com.opos.exoplayer.core.i;

import java.util.PriorityQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f6512a;
    private final PriorityQueue<Integer> b;
    private int c;

    public void a(int i) {
        synchronized (this.f6512a) {
            this.b.add(Integer.valueOf(i));
            this.c = Math.max(this.c, i);
        }
    }

    public void b(int i) {
        synchronized (this.f6512a) {
            this.b.remove(Integer.valueOf(i));
            this.c = this.b.isEmpty() ? Integer.MIN_VALUE : this.b.peek().intValue();
            this.f6512a.notifyAll();
        }
    }
}
