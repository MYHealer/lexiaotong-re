package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f5 implements d5 {
    public static final String c = ijiami_1011.s.s.s.d(new byte[]{4, 84}, "ba6470");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap<String, u4.b> f5425a = new ConcurrentHashMap<>();
    public u4 b;

    public String a(String str) {
        u4.b bVarA;
        String absolutePath;
        try {
            u4 u4Var = this.b;
            if (u4Var != null && (bVarA = u4Var.a(z8.a(str))) != null && this.f5425a.putIfAbsent(str, bVarA) == null) {
                synchronized (u4.this) {
                    u4.c cVar = bVarA.f5630a;
                    if (cVar.d != bVarA) {
                        throw new IllegalStateException();
                    }
                    absolutePath = cVar.b(0).getAbsolutePath();
                }
                return absolutePath;
            }
        } catch (Exception e) {
            m.b(c, ijiami_1011.s.s.s.d(new byte[]{32, 5, 88, 95, 92, 87, 65, 16, 9, 66, 86, 0, Ascii.DC2, 68, 84, 87, 80, 71, 65, 2, 15, 14, 84, 11, 7, 9, 84}, "fd1393"), e);
        }
        return null;
    }

    public String b(String str) {
        String str2 = null;
        try {
            u4 u4Var = this.b;
            if (u4Var == null) {
                return null;
            }
            u4.d dVarB = u4Var.b(z8.a(str));
            if (dVarB != null) {
                str2 = dVarB.b[0];
                dVarB.close();
                u4 u4Var2 = this.b;
                synchronized (u4Var2) {
                    u4Var2.a();
                    u4Var2.f();
                    u4Var2.l.flush();
                }
            }
        } catch (Exception e) {
            m.b(c, ijiami_1011.s.s.s.d(new byte[]{81, 6, SignedBytes.MAX_POWER_OF_TWO, 103, 87, 85, 5, 34, 15, 14, 84, 43, 87, 14, 81, Ascii.NAK, 123, 123, 36, Ascii.FS, 5, 7, 65, 17, 95, 12, 90, 15}, "6c4524"), e);
        }
        return str2;
    }
}
