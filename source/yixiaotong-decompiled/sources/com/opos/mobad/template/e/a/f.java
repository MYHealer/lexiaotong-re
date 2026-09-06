package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f7542a;

    f() {
    }

    public static f a() {
        if (f7542a == null) {
            synchronized (f.class) {
                if (f7542a == null) {
                    f7542a = new f();
                }
            }
        }
        return f7542a;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i != 27) {
            if (i == 28 || i == 2029) {
                return new com.opos.mobad.template.e.c.e(context, b(), false);
            }
            if (i != 2030) {
                return null;
            }
        }
        return new com.opos.mobad.template.e.c.e(context, b(), true);
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.SLIDE_LAYER;
    }
}
