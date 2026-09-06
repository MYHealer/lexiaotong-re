package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class aa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9400a;
    public final /* synthetic */ m b;

    public aa(m mVar, String str) {
        this.b = mVar;
        this.f9400a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.xiaomi.onetrack.util.o.a().a(this.f9400a);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{122, 13, 83, 53, Ascii.DC4, 81, 2, 15, 47, 15, 65}, "5c6af0"), ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 82, 69, 121, 8, 74, Ascii.NAK, 5, 8, 1, 84, 44, 2, Ascii.ETB, 84, 66, Ascii.DC4, 86, 19, 94, 70}, "f710f9") + e.toString());
        }
    }
}
