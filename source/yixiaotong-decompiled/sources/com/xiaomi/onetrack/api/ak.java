package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ak implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f9410a;
    public final /* synthetic */ String b;
    public final /* synthetic */ m c;

    public ak(m mVar, Object obj, String str) {
        this.c = mVar;
        this.f9410a = obj;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (!com.xiaomi.onetrack.util.r.b(this.f9410a)) {
                com.xiaomi.onetrack.util.r.a(ijiami_1011.s.s.s.d(new byte[]{45, 95, 6, 49, 19, 7, 2, 15, 47, 15, 65}, "b1ceaf"), this.b);
            } else {
                this.c.b.a(ijiami_1011.s.s.s.d(new byte[]{14, 67, 107, 72, 70, 90, 7, 13, 10, 7, 110, Ascii.SYN, 4, 67}, "a74845"), h.a(new JSONObject().put(this.b, this.f9410a), this.c.f, this.c.h, this.c.f(ijiami_1011.s.s.s.d(new byte[]{10, 65, 62, 72, 66, 89, 7, 13, 10, 7, 110, Ascii.SYN, 0, 65}, "e5a806")), this.c.i, this.c.j));
            }
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{44, 13, 1, 109, SignedBytes.MAX_POWER_OF_TWO, 7, 2, 15, 47, 15, 65}, "ccd92f"), ijiami_1011.s.s.s.d(new byte[]{17, 4, 71, 103, 17, 81, 19, 52, Ascii.DC4, 13, 87, 12, 14, 4, 19, 65, 11, 90, 6, 8, 3, 66, 84, Ascii.ETB, 16, 14, 65, 8}, "ba32b4") + e.toString());
        }
    }
}
