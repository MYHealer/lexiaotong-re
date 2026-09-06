package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class af implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9405a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ m c;

    public af(m mVar, String str, Map map) {
        this.c = mVar;
        this.f9405a = str;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (this.c.d(this.f9405a)) {
                return;
            }
            this.c.b.a(this.f9405a, h.a(this.f9405a, com.xiaomi.onetrack.util.r.a((Map<String, Object>) this.b, true), this.c.f, this.c.h, this.c.f(this.f9405a), this.c.i, this.c.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{124, 8, 80, 102, 65, 88, 2, 15, 47, 15, 65}, "3f5239"), ijiami_1011.s.s.s.d(new byte[]{17, 69, 82, 90, 15, Ascii.EM, 12, 5, Ascii.SYN, 66, 84, Ascii.ETB, Ascii.ETB, 88, 65, 3, 68}, "e739d9") + e.toString());
        }
    }
}
