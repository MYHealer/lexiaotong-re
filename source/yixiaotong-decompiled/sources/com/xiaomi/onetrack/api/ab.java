package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.ServiceQualityEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ab implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ServiceQualityEvent f9401a;
    public final /* synthetic */ m b;

    public ab(m mVar, ServiceQualityEvent serviceQualityEvent) {
        this.b = mVar;
        this.f9401a = serviceQualityEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.b.a(ijiami_1011.s.s.s.d(new byte[]{10, Ascii.SYN, 105, Ascii.NAK, 3, 69, Ascii.ETB, 13, 5, 7, 110, Ascii.DC4, 16, 3, 90, 15, Ascii.DC2, 78}, "eb6ff7"), h.a(this.f9401a, this.b.f, this.b.h, this.b.i, this.b.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{118, 11, 80, 48, 65, 85, 2, 15, 47, 15, 65}, "9e5d34"), ijiami_1011.s.s.s.d(new byte[]{65, SignedBytes.MAX_POWER_OF_TWO, 87, 85, 8, 123, 4, 16, 39, Ascii.DC4, 80, 12, 89, 83, 84, 90, 6, 112, Ascii.ETB, 1, 8, Ascii.SYN, 17, 0, 71, SignedBytes.MAX_POWER_OF_TWO, 89, 68, 89, Ascii.NAK}, "5266c5") + e.toString());
        }
    }
}
