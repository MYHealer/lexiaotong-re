package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f7544a;

    h() {
    }

    public static h a() {
        if (f7544a == null) {
            synchronized (h.class) {
                if (f7544a == null) {
                    f7544a = new h();
                }
            }
        }
        return f7544a;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i != 59 && i != 68 && i != 71 && i != 2024 && i != 2041 && i != 2053 && i != 2061) {
            if (i == 2071) {
                return new com.opos.mobad.template.e.c.a.a(context, b());
            }
            if (i != 2073) {
                return null;
            }
        }
        return new com.opos.mobad.template.e.c.c.g(context, b());
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.UP_SLIDE;
    }
}
