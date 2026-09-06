package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f7538a;

    b() {
    }

    public static b a() {
        if (f7538a == null) {
            synchronized (b.class) {
                if (f7538a == null) {
                    f7538a = new b();
                }
            }
        }
        return f7538a;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i == 2122) {
            return new com.opos.mobad.template.e.c.c.b(context, b());
        }
        if (i == 2130 || i == 2131) {
            return new com.opos.mobad.template.e.c.b.a(context, b());
        }
        return null;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.FORWARD;
    }
}
