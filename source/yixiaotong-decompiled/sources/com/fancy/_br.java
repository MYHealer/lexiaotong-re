package com.fancy;

import android.app.KeyguardManager;
import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _br implements _eg {
    public final Context _a;
    public final KeyguardManager _b;

    public _br(Context context) {
        this._a = context;
        this._b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        if (this._a == null) {
            if (_a4Var != null) {
                _a4Var._a("");
                return;
            }
            return;
        }
        KeyguardManager keyguardManager = this._b;
        if (keyguardManager == null) {
            _a4Var._a("");
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this._b, new Object[0]);
            if (objInvoke == null) {
                _a4Var._a("");
            } else {
                _a4Var._a(objInvoke.toString());
            }
        } catch (Exception unused) {
        }
    }
}
