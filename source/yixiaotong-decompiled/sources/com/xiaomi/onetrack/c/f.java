package com.xiaomi.onetrack.c;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.xiaomi.onetrack.f.b f9467a;
    public final /* synthetic */ c b;

    public f(c cVar, com.xiaomi.onetrack.f.b bVar) {
        this.b = cVar;
        this.f9467a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.b.b(this.f9467a);
            com.xiaomi.onetrack.a.a.a().a(this.f9467a);
            com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{125, Ascii.DC2, 0, 89, SignedBytes.MAX_POWER_OF_TWO, 126, 0, 10, 7, 5, 84, Ascii.ETB}, "8de743"), ijiami_1011.s.s.s.d(new byte[]{84, 82, 85, 115, Ascii.DC2, 81, 15, 16, 92, 66}, "5616d4") + this.f9467a.e() + ijiami_1011.s.s.s.d(new byte[]{82, 2, 16, 7, 10}, "6cdf03") + this.f9467a.g().toString());
            s.a().a(this.f9467a.f(), false);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{115, Ascii.NAK, 80, 95, 70, 41, 0, 10, 7, 5, 84, Ascii.ETB}, "6c512d"), ijiami_1011.s.s.s.d(new byte[]{113, 66, 86, 88, 68, 126, 0, 10, 7, 5, 84, Ascii.ETB, 26, 85, 87, 82, 117, 69, 4, 10, Ascii.DC2, 66, 84, Ascii.GS, 87, 81, 67, 66, 89, 92, 15, 94, 70}, "443603"), e);
        }
    }
}
