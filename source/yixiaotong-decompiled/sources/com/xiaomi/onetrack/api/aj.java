package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class aj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f9409a;
    public final /* synthetic */ m b;

    public aj(m mVar, Map map) {
        this.b = mVar;
        this.f9409a = map;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            this.b.b.a(ijiami_1011.s.s.s.d(new byte[]{11, 70, 62, SignedBytes.MAX_POWER_OF_TWO, 17, 88, 7, 13, 10, 7, 110, Ascii.SYN, 1, 70}, "d2a0c7"), h.a(com.xiaomi.onetrack.util.r.a((Map<String, Object>) this.f9409a, false), this.b.f, this.b.h, this.b.f(ijiami_1011.s.s.s.d(new byte[]{14, 66, 62, 66, 69, 86, 7, 13, 10, 7, 110, Ascii.SYN, 4, 66}, "a6a279")), this.b.i, this.b.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{41, 90, 3, 98, Ascii.SYN, 5, 2, 15, 47, 15, 65}, "f4f6dd"), ijiami_1011.s.s.s.d(new byte[]{67, 6, Ascii.ETB, 108, Ascii.DC2, 93, 19, 52, Ascii.DC4, 13, 87, 12, 92, 6, 67, 84, 0, 72, 65, 1, Ascii.DC4, 16, 94, Ascii.ETB, 10}, "0cc9a8") + e.toString());
        }
    }
}
