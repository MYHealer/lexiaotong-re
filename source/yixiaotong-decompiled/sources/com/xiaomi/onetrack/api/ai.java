package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ai implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9408a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ long f;
    public final /* synthetic */ m g;

    public ai(m mVar, String str, String str2, String str3, String str4, String str5, long j) {
        this.g = mVar;
        this.f9408a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = j;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            this.g.b.a(ijiami_1011.s.s.s.d(new byte[]{88, 11, 84, 65, 66, 86, 2, 15, 57, 0, 68, 2, 104, Ascii.ETB, 84, 69, 95, 69, Ascii.NAK}, "7e1507"), h.a(this.f9408a, this.b, this.c, this.d, this.e, this.f, this.g.f, this.g.h, this.g.f(ijiami_1011.s.s.s.d(new byte[]{10, 86, 84, 68, 65, 80, 2, 15, 57, 0, 68, 2, 58, 74, 84, SignedBytes.MAX_POWER_OF_TWO, 92, 67, Ascii.NAK}, "e81031")), this.g.i, this.g.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{121, 95, 85, 103, 17, 2, 2, 15, 47, 15, 65}, "6103cc"), ijiami_1011.s.s.s.d(new byte[]{68, 66, 80, 85, 10, 36, Ascii.EM, 7, 3, Ascii.DC2, 69, 12, 95, 94, 17, 83, 19, 19, 14, Ascii.SYN, 92, 66}, "0016aa") + e.toString());
        }
    }
}
