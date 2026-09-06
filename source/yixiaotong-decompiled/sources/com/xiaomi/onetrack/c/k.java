package com.xiaomi.onetrack.c;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.xiaomi.onetrack.api.j f9472a;

    public k(com.xiaomi.onetrack.api.j jVar) {
        this.f9472a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            List<JSONObject> listC = i.c();
            if (listC != null && listC.size() > 0) {
                for (JSONObject jSONObject : listC) {
                    this.f9472a.a(jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{4, 71, 6, 93, 17, 120, 0, 9, 3}, "a1c3e6")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{1, 89, SignedBytes.MAX_POWER_OF_TWO, 0}, "e84a27")));
                }
            }
            i.c(true);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{121, 7, 68, Ascii.SYN, 13, 74, 10, 37, 5, 1, 84, Ascii.SYN, 68, 47, 81, 15, 3, 95, 4, Ascii.SYN}, "7b0ab8"), ijiami_1011.s.s.s.d(new byte[]{81, 76, 7, 17, 87, 78, 4, 10, Ascii.DC2, 66, 84, Ascii.ETB, SignedBytes.MAX_POWER_OF_TWO, 87, Ascii.DC4, 11, Ascii.DC2}, "28f128") + e.toString());
        }
        boolean unused = i.l = false;
    }
}
