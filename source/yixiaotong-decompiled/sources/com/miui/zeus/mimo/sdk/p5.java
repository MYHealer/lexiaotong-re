package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.server.api.AdRequest;
import com.miui.zeus.mimo.sdk.server.api.AdResponse;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p5 {
    public static final String b = ijiami_1011.s.s.s.d(new byte[]{65, 2}, "170ef4");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r4 f5561a = new r4();

    public void a(AdRequest adRequest, l5<AdResponse> l5Var) {
        m.b(b, ijiami_1011.s.s.s.d(new byte[]{16, 81, 70, 16, 6, Ascii.DC2, Ascii.NAK, 68, 7, 6, 17, 77, Ascii.ETB, 68, 126, 1, 67, 92, 65}, "b47eca") + adRequest.b() + ijiami_1011.s.s.s.d(new byte[]{26, 67, 81, 7, 90, 10, 77, 68}, "3c7f3f") + l5Var.a());
        try {
            String strB = adRequest.b();
            i5 i5Var = l5Var.c;
            b.a(strB, m4.a(i5Var.f5460a, i5Var.c()));
        } catch (Exception unused) {
        }
        try {
            String strB2 = adRequest.b();
            adRequest.a();
            String strD = ijiami_1011.s.s.s.d(new byte[]{106, 38, 98, 54, 119, 103, 53}, "8c3c24");
            i5 i5Var2 = l5Var.c;
            b.a(strB2, null, strD, i5Var2 != null ? i5Var2.f5460a.name() : null, adRequest.g, l5.a(l5Var.c), l5.b(l5Var.c));
        } catch (Exception unused2) {
        }
    }
}
