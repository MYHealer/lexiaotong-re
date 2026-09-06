package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ah implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9407a;
    public final /* synthetic */ m b;

    public ah(m mVar, String str) {
        this.b = mVar;
        this.f9407a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            JSONArray jSONArray = new JSONArray(this.f9407a);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has(ijiami_1011.s.s.s.d(new byte[]{122}, "2c4241")) && jSONObjectOptJSONObject.has(ijiami_1011.s.s.s.d(new byte[]{119}, "5afec5"))) {
                    i iVar = new i(jSONObjectOptJSONObject.optJSONObject(ijiami_1011.s.s.s.d(new byte[]{44}, "d0bda9")));
                    if (!this.b.e(iVar.a())) {
                        this.b.b.a(iVar.a(), h.a(iVar, jSONObjectOptJSONObject.optJSONObject(ijiami_1011.s.s.s.d(new byte[]{118}, "41f93f")), this.b.f, this.b.h, this.b.f(iVar.a()), this.b.i, this.b.j));
                    }
                } else {
                    com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{122, 94, 4, 108, 19, 84, 2, 15, 47, 15, 65}, "50a8a5"), ijiami_1011.s.s.s.d(new byte[]{94, 87, 67, 90, Ascii.DC2, 13, 15, 68, 15, 17, 17, 0, 91, Ascii.DC2, Ascii.ETB, 73, 65, 13, 19, 68, 14, 3, 66, 69, 88, 13, 67, Ascii.DC2, 41, SignedBytes.MAX_POWER_OF_TWO, 65, 11, Ascii.DC4, 66, 19, 39, Ascii.DC4, 66}, "6bc0ab"));
                }
            }
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{127, 90, 7, 108, 16, 5, 2, 15, 47, 15, 65}, "04b8bd"), ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, Ascii.ETB, 81, 1, 89, 36, Ascii.ETB, 1, 8, Ascii.SYN, 119, Ascii.ETB, 13, 8, 120, 87, Ascii.DC2, 4, 19, Ascii.SYN, 9, 16, 11, 69}, "be0b2a") + e.toString());
        }
    }
}
