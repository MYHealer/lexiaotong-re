package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class s implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f9439a;

    public s(m mVar) {
        this.f9439a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (com.xiaomi.onetrack.util.ac.d(com.xiaomi.onetrack.util.aa.t())) {
                return;
            }
            com.xiaomi.onetrack.util.aa.m(System.currentTimeMillis());
            this.f9439a.b.a(ijiami_1011.s.s.s.d(new byte[]{89, 87, 6, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 88, 2, 15, 57, 6, 80, 16}, "69c4d9"), h.a(this.f9439a.f, this.f9439a.h, this.f9439a.f(ijiami_1011.s.s.s.d(new byte[]{14, 92, 93, 77, 74, 83, 2, 15, 57, 6, 80, 16}, "a28982")), this.f9439a.i, this.f9439a.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{127, 94, 86, 54, 69, 87, 2, 15, 47, 15, 65}, "003b76"), ijiami_1011.s.s.s.d(new byte[]{69, 65, 2, 1, 90, 113, 0, 17, 70, 7, 67, Ascii.ETB, 94, 65, 67, 66, 84, 15}, "13cb15") + e.toString());
        }
    }
}
