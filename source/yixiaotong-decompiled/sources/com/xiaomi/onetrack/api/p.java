package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9436a;
    public final /* synthetic */ Number b;
    public final /* synthetic */ m c;

    public p(m mVar, String str, Number number) {
        this.c = mVar;
        this.f9436a = str;
        this.b = number;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            this.c.b.a(ijiami_1011.s.s.s.d(new byte[]{89, 16, 105, 65, 66, 86, 7, 13, 10, 7, 110, 12, 88, 7, 68, 84, 93, 92, 15, 16}, "6d6109"), h.b(new JSONObject().put(this.f9436a, this.b), this.c.f, this.c.h, this.c.f(ijiami_1011.s.s.s.d(new byte[]{10, 71, 59, Ascii.DC2, 71, 92, 7, 13, 10, 7, 110, 12, 11, 80, Ascii.SYN, 7, 88, 86, 15, 16}, "e3db53")), this.c.i, this.c.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{46, 12, 4, 53, 67, 82, 2, 15, 47, 15, 65}, "abaa13"), ijiami_1011.s.s.s.d(new byte[]{19, 69, 85, 68, 96, 66, 14, 2, 15, 14, 84, 44, 8, 85, 66, 83, 93, 85, 15, 16, 70, 17, 88, 11, 1, 90, 85, Ascii.SYN, 85, 66, 19, 11, Ascii.DC4, 88}, "f60600") + e.toString());
        }
    }
}
