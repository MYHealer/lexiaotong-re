package com.ubix.ssp.ad.e.x;

import android.content.Context;
import com.ubix.ssp.ad.e.a0.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f8924a = null;
    public static final String b = "b";

    private b(Context context) {
    }

    public static b a(Context context) {
        if (f8924a == null) {
            synchronized (b.class) {
                if (f8924a == null) {
                    f8924a = new b(context);
                }
            }
        }
        return f8924a;
    }

    public void a(String str, a.f fVar) {
        g.b().a(f.a(str), fVar);
        if (u.a()) {
            u.e(b, "appId:" + str + "loadInitUrl: " + f.a(str));
        }
    }

    public void a(String str, com.ubix.ssp.ad.e.y.a.d dVar, a.e eVar) {
        g.b().a(f.e(), str, dVar, eVar);
        if (u.a()) {
            u.e(b, "slot id:" + str + "   loadAdUrl: " + f.e());
        }
    }
}
