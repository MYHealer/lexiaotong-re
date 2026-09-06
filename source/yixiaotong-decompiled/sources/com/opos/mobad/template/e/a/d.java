package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f7540a;

    d() {
    }

    public static d a() {
        if (f7540a == null) {
            synchronized (d.class) {
                if (f7540a == null) {
                    f7540a = new d();
                }
            }
        }
        return f7540a;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i == 2120) {
            return new com.opos.mobad.template.e.c.c.c(context, true, b());
        }
        if (i != 2121) {
            return null;
        }
        return new com.opos.mobad.template.e.c.c.c(context, false, b());
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.SHAKE_AND_UP_SLIDE;
    }
}
