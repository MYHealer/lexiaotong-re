package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ac implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f9402a;

    public ac(m mVar) {
        this.f9402a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f9402a.b.a(ijiami_1011.s.s.s.d(new byte[]{14, 12, 84, 66, 68, 0, 2, 15, 57, 1, 69, 4, 62, 17, 69, 87, 66, Ascii.DC4, Ascii.DC2}, "ab166a"), h.a(this.f9402a.f, this.f9402a.h, this.f9402a.i, this.f9402a.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{124, 8, 85, 55, 71, 80, 2, 15, 47, 15, 65}, "3f0c51"), ijiami_1011.s.s.s.d(new byte[]{80, Ascii.DC2, 7, 65, 7, Ascii.NAK, 4, 10, Ascii.DC2, 66, 84, Ascii.ETB, 65, 9, Ascii.DC4, 91, 66}, "3ffabc") + e.toString());
        }
    }
}
