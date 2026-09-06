package com.fancy;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ow implements Runnable {
    public final /* synthetic */ Context _a;
    public final /* synthetic */ _ox._a _b;

    public _ow(Context context, _ov _ovVar) {
        this._a = context;
        this._b = _ovVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            try {
                _ox._b.incrementAndGet();
                String str_a = _ox._a(this._a);
                _ox._c = str_a;
                _kr._a(this._a, "ptg_ua", str_a);
                _ox._a(this._b, str_a);
            } catch (Exception unused) {
                _ox._a(this._b, "");
            }
        } finally {
            _ox._a.set(false);
        }
    }
}
