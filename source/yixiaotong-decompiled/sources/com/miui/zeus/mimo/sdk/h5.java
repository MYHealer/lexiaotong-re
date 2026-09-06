package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.server.cache.MsaDiskLruCacheProxyService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5451a;
    public final /* synthetic */ g5 b;

    public h5(g5 g5Var, String str) {
        this.b = g5Var;
        this.f5451a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            MsaDiskLruCacheProxyService msaDiskLruCacheProxyService = new MsaDiskLruCacheProxyService(y8.f5752a);
            d5 d5Var = this.b.d;
            String str = this.f5451a;
            ((f5) d5Var).getClass();
            int iA = msaDiskLruCacheProxyService.a(z8.a(str) + ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 8}, "3815ef"));
            if (iA == 0) {
                m.d(ijiami_1011.s.s.s.d(new byte[]{113, 86, Ascii.DC2, 86, 95, 95, 0, 0, 3, 16}, "59e830"), ijiami_1011.s.s.s.d(new byte[]{32, 86, 66, SignedBytes.MAX_POWER_OF_TWO, Ascii.ETB, 90, 0, 7, 14, 7, 17, Ascii.ETB, 6, 74, 93, 76, 69, 90, 4, 68, Ascii.DC2, 13, 17, 8, 16, 88, Ascii.DC2, 74, 66, 90, 2, 1, Ascii.NAK, 17}, "c92979"));
            } else {
                m.d(ijiami_1011.s.s.s.d(new byte[]{113, 91, Ascii.DC4, 95, 13, 10, 0, 0, 3, 16}, "54c1ae"), ijiami_1011.s.s.s.d(new byte[]{33, 86, 68, 26, Ascii.SYN, 83, 0, 7, 14, 7, 17, Ascii.ETB, 7, 74, 91, Ascii.SYN, 68, 83, 4, 68, Ascii.DC2, 13, 17, 8, 17, 88, Ascii.DC4, 5, 87, 89, 13, 72, 70}, "b94c60") + iA);
            }
        } catch (Throwable th) {
            m.d(ijiami_1011.s.s.s.d(new byte[]{113, 11, Ascii.NAK, 91, 94, 93, 0, 0, 3, 16}, "5db522"), ijiami_1011.s.s.s.d(new byte[]{33, 14, SignedBytes.MAX_POWER_OF_TWO, 73, Ascii.EM, 80, 0, 7, 14, 7, 17, Ascii.ETB, 7, Ascii.DC2, 95, 69, 75, 80, 4, 68, Ascii.DC2, 13, 17, 8, 17, 0, 16, 86, 88, 90, 13, 72, 70}, "ba0093") + th.getMessage());
        }
    }
}
