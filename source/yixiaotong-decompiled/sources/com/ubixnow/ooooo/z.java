package com.ubixnow.ooooo;

import android.app.Application;
import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class z {
    private static j OooO00o;

    private z() {
    }

    public static j OooO00o(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        j jVar = OooO00o;
        if (jVar != null) {
            return jVar;
        }
        j jVarOooO0O0 = OooO0O0(context);
        OooO00o = jVarOooO0O0;
        if (jVarOooO0O0 != null && jVarOooO0O0.OooO00o()) {
            l.OooO00o("Manufacturer interface has been found: " + OooO00o.getClass().getName());
            return OooO00o;
        }
        j jVarOooO0OO = OooO0OO(context);
        OooO00o = jVarOooO0OO;
        return jVarOooO0OO;
    }

    private static j OooO0O0(Context context) {
        if (m.OooO0oo() || m.OooOO0O()) {
            return new v(context);
        }
        if (m.OooO()) {
            return new w(context);
        }
        if (m.OooOO0o()) {
            return new y(context);
        }
        if (m.OooOOo() || m.OooOO0() || m.OooO0O0()) {
            return new e0(context);
        }
        if (m.OooOOOo()) {
            return new c0(context);
        }
        if (m.OooOOo0()) {
            return new d0(context);
        }
        if (m.OooO00o()) {
            return new n(context);
        }
        if (m.OooO0o()) {
            t tVar = new t(context);
            return tVar.OooO00o() ? tVar : new u(context);
        }
        if (m.OooO0oO() || m.OooO0Oo()) {
            return new u(context);
        }
        if (m.OooOOO() || m.OooOOO0()) {
            return new b0(context);
        }
        if (m.OooO00o(context)) {
            return new p(context);
        }
        if (m.OooO0OO()) {
            return new q(context);
        }
        if (m.OooO0o0()) {
            return new s(context);
        }
        return null;
    }

    private static j OooO0OO(Context context) {
        x xVar = new x(context);
        if (xVar.OooO00o()) {
            l.OooO00o("Mobile Security Alliance has been found: " + x.class.getName());
            return xVar;
        }
        r rVar = new r();
        l.OooO00o("OAID/AAID was not supported: " + r.class.getName());
        return rVar;
    }
}
