package com.xiaomi.onetrack.c;

import com.google.common.base.Ascii;
import com.xiaomi.onetrack.api.ar;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9475a;
    public final /* synthetic */ l b;

    public n(l lVar, String str) {
        this.b = lVar;
        this.f9475a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            List<JSONObject> listB = l.b(this.f9475a);
            if (listB != null && listB.size() > 0) {
                for (JSONObject jSONObject : listB) {
                    ar.a().a(this.f9475a, jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{4, 66, 80, 15, 69, 126, 0, 9, 3}, "a45a10")), jSONObject.optString(ijiami_1011.s.s.s.d(new byte[]{2, 84, 69, 86}, "f517d6")));
                }
            }
            this.b.a(this.f9475a);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{96, 76, 74, 17, 0, 14, 40, 9, Ascii.SYN, 33, 80, 6, 91, 80, 116, 4, 11, 2, 6, 1, Ascii.DC4}, "359eec"), ijiami_1011.s.s.s.d(new byte[]{67, 71, 84, 87, 82, 107, Ascii.CAN, Ascii.ETB, Ascii.DC2, 7, 92, 44, 90, 69, 118, 85, 90, 80, 4, 68, 3, Ascii.DC4, 84, 11, 67, Ascii.NAK, 80, 70, 75, 87, 19, 94, 70}, "755498") + e.toString());
        }
    }
}
