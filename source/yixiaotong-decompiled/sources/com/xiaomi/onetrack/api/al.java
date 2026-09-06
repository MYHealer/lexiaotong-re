package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.xiaomi.onetrack.OneTrack;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class al implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9411a;
    public final /* synthetic */ OneTrack.UserIdType b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Map d;
    public final /* synthetic */ m e;

    public al(m mVar, String str, OneTrack.UserIdType userIdType, boolean z, Map map) {
        this.e = mVar;
        this.f9411a = str;
        this.b = userIdType;
        this.c = z;
        this.d = map;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            com.xiaomi.onetrack.util.aa.g(this.f9411a);
            com.xiaomi.onetrack.util.aa.h(this.b.getUserIdType());
            if (this.c) {
                return;
            }
            JSONObject jSONObjectA = com.xiaomi.onetrack.util.r.a((Map<String, Object>) this.d, false);
            if (!this.e.j) {
                jSONObjectA.put(ijiami_1011.s.s.s.d(new byte[]{69, 81, 85}, "0817d5"), this.f9411a);
                jSONObjectA.put(ijiami_1011.s.s.s.d(new byte[]{69, 80, 85, 106, Ascii.DC2, SignedBytes.MAX_POWER_OF_TWO, 17, 1}, "0915f9"), this.b.getUserIdType());
            }
            this.e.b.a(ijiami_1011.s.s.s.d(new byte[]{11, 71, 108, 13, 94, 4, 8, 10}, "d33a1c"), h.c(jSONObjectA, this.e.f, this.e.h, this.e.f(ijiami_1011.s.s.s.d(new byte[]{86, Ascii.DC2, 109, 88, 95, 94, 8, 10}, "9f2409")), this.e.i, this.e.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{46, 13, 86, 49, Ascii.ETB, 7, 2, 15, 47, 15, 65}, "ac3eef"), ijiami_1011.s.s.s.d(new byte[]{88, 10, 83, 13, 8, 17, 4, Ascii.SYN, Ascii.DC4, 13, 67, 95}, "4e4df1") + e.toString());
        }
    }
}
