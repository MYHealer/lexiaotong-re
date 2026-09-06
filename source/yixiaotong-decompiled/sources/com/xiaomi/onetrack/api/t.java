package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9440a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ m c;

    public t(m mVar, String str, boolean z) {
        this.c = mVar;
        this.f9440a = str;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (!this.c.f.isAutoTrackActivityAction()) {
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{118, 8, 92, 102, 69, 0, 2, 15, 47, 15, 65}, "9f927a"), ijiami_1011.s.s.s.d(new byte[]{2, 13, 8, 7, 92, 95, 79, 5, 19, Ascii.SYN, 94, 49, 19, 3, 5, 10, 116, 91, Ascii.NAK, 13, 16, 11, 69, Ascii.FS, 32, 1, Ascii.DC2, 8, 90, 86, 65, 13, Ascii.NAK, 66, 87, 4, 13, 17, 3, 77, Ascii.NAK, 81, 6, 10, 9, 16, 84, 69, 14, 12, 3, Ascii.NAK, 71, 89, 2, 15, 57, Ascii.DC2, 80, 69, 19, 7, Ascii.NAK, Ascii.DC4, 88, 93, 65, 1, 16, 7, 95, 17}, "abfa58"));
                return;
            }
            this.c.b.a(ijiami_1011.s.s.s.d(new byte[]{13, 93, 0, 65, Ascii.DC4, 4, 2, 15, 57, Ascii.DC2, 80}, "b3e5fe"), h.a(this.f9440a, ijiami_1011.s.s.s.d(new byte[]{12, 95, 87, Ascii.NAK, 69, 82, 2, 15, 57, Ascii.DC2, 80}, "c12a73"), this.c.f, this.c.h, this.c.f(ijiami_1011.s.s.s.d(new byte[]{92, 11, 3, 67, Ascii.SYN, 7, 2, 15, 57, Ascii.DC2, 80}, "3ef7df")), this.b, this.c.i, this.c.j));
            if (com.xiaomi.onetrack.util.p.f9551a) {
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{46, 87, 0, 48, 67, 89, 2, 15, 47, 15, 65}, "a9ed18"), ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 66, 80, 86, 14, 54, 0, 3, 3, 49, 69, 4, Ascii.DC4, 68, 112, SignedBytes.MAX_POWER_OF_TWO, 17, 9}, "f015ef"));
            }
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{125, 12, 3, 96, Ascii.DC4, 4, 2, 15, 47, 15, 65}, "2bf4fe"), ijiami_1011.s.s.s.d(new byte[]{85, 69, 70, 92, 65, SignedBytes.MAX_POWER_OF_TWO, 19, 5, 5, 9, 97, 4, 83, 85, 97, 71, 0, 70, Ascii.NAK, 37, 19, Ascii.SYN, 94, 69, 81, 66, SignedBytes.MAX_POWER_OF_TWO, 92, 19, 14, 65}, "4023a4") + e.toString());
        }
    }
}
