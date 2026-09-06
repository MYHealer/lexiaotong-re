package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9441a;
    public final /* synthetic */ long b;
    public final /* synthetic */ m c;

    public u(m mVar, String str, long j) {
        this.c = mVar;
        this.f9441a = str;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (!this.c.f.isAutoTrackActivityAction()) {
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{120, 94, 0, 99, 67, 85, 2, 15, 47, 15, 65}, "70e714"), ijiami_1011.s.s.s.d(new byte[]{81, 11, 90, 94, 15, 95, 79, 5, 19, Ascii.SYN, 94, 49, SignedBytes.MAX_POWER_OF_TWO, 5, 87, 83, 39, 91, Ascii.NAK, 13, 16, 11, 69, Ascii.FS, 115, 7, SignedBytes.MAX_POWER_OF_TWO, 81, 9, 86, 65, 13, Ascii.NAK, 66, 87, 4, 94, Ascii.ETB, 81, Ascii.DC4, 70, 81, 6, 10, 9, 16, 84, 69, 93, 10, 81, 76, Ascii.DC4, 89, 2, 15, 57, Ascii.DC2, 80, 69, 66, 5, 65, 75, 3, Ascii.CAN, 4, Ascii.DC2, 3, 12, 69}, "2d48f8"));
                return;
            }
            com.xiaomi.onetrack.util.aa.i(h.a(this.f9441a, ijiami_1011.s.s.s.d(new byte[]{13, 11, 6, Ascii.ETB, 75, 85, 2, 15, 57, Ascii.DC2, 80}, "becc94"), this.b, this.c.f, this.c.h, this.c.f(ijiami_1011.s.s.s.d(new byte[]{87, 8, 6, SignedBytes.MAX_POWER_OF_TWO, 75, 5, 2, 15, 57, Ascii.DC2, 80}, "8fc49d")), this.c.i, this.c.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{120, 10, 86, 101, 70, 2, 2, 15, 47, 15, 65}, "7d314c"), ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 85, 69, 82, 102, 89, 6, 1, 35, 12, 85, 33, 7, SignedBytes.MAX_POWER_OF_TWO, 82, Ascii.ETB, 83, 74, 19, 11, Ascii.DC4, 88}, "f43768") + e.toString());
        }
    }
}
