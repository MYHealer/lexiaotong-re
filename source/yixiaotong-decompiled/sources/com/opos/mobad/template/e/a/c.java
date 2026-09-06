package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f7539a;

    c() {
    }

    public static c a() {
        if (f7539a == null) {
            synchronized (c.class) {
                if (f7539a == null) {
                    f7539a = new c();
                }
            }
        }
        return f7539a;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i == 21 || i == 60 || i == 62 || i == 2058) {
            return new com.opos.mobad.template.e.c.c.a(context, b());
        }
        return null;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.FULLSCREEN_SLIDE;
    }
}
