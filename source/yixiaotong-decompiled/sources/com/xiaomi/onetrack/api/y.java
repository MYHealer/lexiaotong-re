package com.xiaomi.onetrack.api;

import com.google.common.base.Ascii;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f9445a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ String c;
    public final /* synthetic */ m d;

    public y(m mVar, String str, Map map, String str2) {
        this.d = mVar;
        this.f9445a = str;
        this.b = map;
        this.c = str2;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            if (this.d.d(this.f9445a)) {
                return;
            }
            this.d.b.a(this.f9445a, h.a(this.c, this.f9445a, com.xiaomi.onetrack.util.r.a((Map<String, Object>) this.b, true), this.d.f, this.d.h, this.d.f(this.f9445a), this.d.i, this.d.j));
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{120, 10, 3, 97, 67, 89, 2, 15, 47, 15, 65}, "7df518"), ijiami_1011.s.s.s.d(new byte[]{77, 75, 7, 90, 13, 70, 11, Ascii.ETB, 9, 12, 17, 0, 75, 75, 9, 75, 92}, "99f9ff") + e.toString());
        }
    }
}
