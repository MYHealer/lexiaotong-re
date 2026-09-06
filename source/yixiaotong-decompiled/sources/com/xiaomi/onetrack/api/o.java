package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f9435a;
    public final /* synthetic */ m b;

    public o(m mVar, Map map) {
        this.b = mVar;
        this.f9435a = map;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            this.b.b.a(ijiami_1011.s.s.s.d(new byte[]{92, Ascii.NAK, 104, 73, 70, 10, 7, 13, 10, 7, 110, 12, 93, 2, 69, 92, 89, 0, 15, 16}, "3a794e"), h.b(new JSONObject(this.f9435a), this.b.f, this.b.h, this.b.f(ijiami_1011.s.s.s.d(new byte[]{92, 69, 105, 72, 74, 95, 7, 13, 10, 7, 110, 12, 93, 82, 68, 93, 85, 85, 15, 16}, "316880")), this.b.i, this.b.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{125, 11, 0, 109, Ascii.ETB, 88, 2, 15, 47, 15, 65}, "2ee9e9"), ijiami_1011.s.s.s.d(new byte[]{16, Ascii.ETB, 6, 66, 101, 75, 14, 2, 15, 14, 84, 44, 11, 7, 17, 85, 88, 92, 15, 16, 70, 15, 80, Ascii.NAK, 69, 1, 17, 66, 90, 75, 91}, "edc059") + e.toString());
        }
    }
}
