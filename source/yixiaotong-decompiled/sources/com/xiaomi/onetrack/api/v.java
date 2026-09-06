package com.xiaomi.onetrack.api;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f9442a;
    public final /* synthetic */ m b;

    public v(m mVar, boolean z) {
        this.b = mVar;
        this.f9442a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String strZ = com.xiaomi.onetrack.util.aa.z();
            if (TextUtils.isEmpty(strZ)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strZ);
            this.b.b.a(ijiami_1011.s.s.s.d(new byte[]{87, 87, 87, Ascii.ETB, 16, 5, 2, 15, 57, Ascii.DC2, 80}, "892cbd"), jSONObject.put(ijiami_1011.s.s.s.d(new byte[]{39}, "e6a53c"), jSONObject.optJSONObject(ijiami_1011.s.s.s.d(new byte[]{35}, "a14dd9")).put(ijiami_1011.s.s.s.d(new byte[]{85, Ascii.DC4, SignedBytes.MAX_POWER_OF_TWO, 105, 7, 94, 5}, "4d06b0"), this.f9442a)).toString());
            if (com.xiaomi.onetrack.util.p.f9551a) {
                com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{45, 8, 81, 97, 74, 5, 2, 15, 47, 15, 65}, "bf458d"), ijiami_1011.s.s.s.d(new byte[]{66, 19, 86, 81, 89, 101, 0, 3, 3, 39, 95, 1, 119, Ascii.DC4, 67, 93}, "6a7225"));
            }
            com.xiaomi.onetrack.util.aa.i("");
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{46, 10, 85, 55, Ascii.ETB, 86, 2, 15, 47, 15, 65}, "ad0ce7"), ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, SignedBytes.MAX_POWER_OF_TWO, 84, 5, 10, 100, 0, 3, 3, 39, 95, 1, 117, 71, 65, 9, 65, 81, 19, Ascii.SYN, 9, 16, 11}, "425fa4") + e.toString());
        }
    }
}
