package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f7543a;

    g() {
    }

    public static g a() {
        if (f7543a == null) {
            synchronized (g.class) {
                if (f7543a == null) {
                    f7543a = new g();
                }
            }
        }
        return f7543a;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i == 2123) {
            return new com.opos.mobad.template.e.c.c.f(context, b());
        }
        if (i == 2128 || i == 2129) {
            return new com.opos.mobad.template.e.c.b.c(context, b());
        }
        return null;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.TILT;
    }
}
