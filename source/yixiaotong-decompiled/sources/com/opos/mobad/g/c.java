package com.opos.mobad.g;

import android.content.Context;
import com.opos.mobad.n;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f7010a;

    private c() {
    }

    private com.opos.mobad.ad.c a(Context context, int i, boolean z) {
        return new n(context, i);
    }

    public static final void b(Context context) {
        synchronized (c.class) {
            c cVar = f7010a;
            if (cVar == null) {
                return;
            }
            cVar.d();
            f7010a = null;
        }
    }

    public static c e() {
        c cVar;
        c cVar2 = f7010a;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            if (f7010a == null) {
                f7010a = new c();
            }
            cVar = f7010a;
        }
        return cVar;
    }

    public void a(Context context, String str, int i, boolean z, boolean z2) {
        com.opos.cmn.an.f.a.b("", "tourist mode = " + z2);
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        a(origApplicationContext, Integer.valueOf(com.opos.mobad.c.a.d.a.f6704a), a(origApplicationContext, i, z2));
        a(origApplicationContext, z);
    }
}
