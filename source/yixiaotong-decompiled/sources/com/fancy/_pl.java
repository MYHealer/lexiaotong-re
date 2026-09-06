package com.fancy;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _pl implements _eg {
    public Context _a;
    public Class<?> _b;
    public Object _c;

    public _pl(Context context) {
        this._a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this._b = cls;
            this._c = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        String str = "";
        try {
            try {
                str = (String) this._b.getMethod("getOAID", Context.class).invoke(this._c, this._a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (_a4Var != null) {
                _a4Var._a(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
