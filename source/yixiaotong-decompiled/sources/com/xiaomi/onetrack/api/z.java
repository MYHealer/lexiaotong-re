package com.xiaomi.onetrack.api;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9446a;
    public final /* synthetic */ m b;

    public z(m mVar, String str) {
        this.b = mVar;
        this.f9446a = str;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            String strA = com.xiaomi.onetrack.util.k.a(com.xiaomi.onetrack.util.r.a(this.b.f));
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(strA);
            jSONObject.remove(this.f9446a);
            com.xiaomi.onetrack.util.k.a(com.xiaomi.onetrack.util.r.a(this.b.f), jSONObject.toString());
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{125, 90, 82, 49, 71, 87, 2, 15, 47, 15, 65}, "247e56"), ijiami_1011.s.s.s.d(new byte[]{16, 86, 15, 10, 69, 82, 34, 11, 11, 15, 94, 11, 50, 65, 13, Ascii.NAK, 86, 69, Ascii.NAK, Ascii.GS, 70, 7, 67, Ascii.ETB, 13, 65, 88}, "b3be37") + e.toString());
        }
    }
}
