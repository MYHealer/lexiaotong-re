package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f9437a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ m c;

    public q(m mVar, boolean z, Map map) {
        this.c = mVar;
        this.f9437a = z;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (!this.f9437a) {
                JSONObject jSONObjectA = com.xiaomi.onetrack.util.r.a((Map<String, Object>) this.b, false);
                if (!this.c.j) {
                    String strU = com.xiaomi.onetrack.util.aa.u();
                    String strW = com.xiaomi.onetrack.util.aa.w();
                    jSONObjectA.put(ijiami_1011.s.s.s.d(new byte[]{77, 11, 92}, "8b8114"), strU);
                    jSONObjectA.put(ijiami_1011.s.s.s.d(new byte[]{67, 94, 93, 109, Ascii.NAK, Ascii.GS, 17, 1}, "6792ad"), strW);
                }
                this.c.b.a(ijiami_1011.s.s.s.d(new byte[]{95, 65, 111, 90, 93, 80, 14, 17, Ascii.DC2}, "050627"), h.d(jSONObjectA, this.c.f, this.c.h, this.c.f(ijiami_1011.s.s.s.d(new byte[]{9, Ascii.DC2, 103, 90, 86, 84, 14, 17, Ascii.DC2}, "ff8693")), this.c.i, this.c.j));
            }
            com.xiaomi.onetrack.util.aa.v();
            com.xiaomi.onetrack.util.aa.x();
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{46, 89, 1, 102, 68, 82, 2, 15, 47, 15, 65}, "a7d263"), ijiami_1011.s.s.s.d(new byte[]{93, 94, 1, 92, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 65, 1, Ascii.DC4, 16, 94, Ascii.ETB, 11}, "11f3b4") + e.toString());
        }
    }
}
