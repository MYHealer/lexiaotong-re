package com.fancy;

import android.app.Activity;
import android.widget.FrameLayout;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ms implements Runnable {
    public final /* synthetic */ FrameLayout _a;
    public final /* synthetic */ Activity _b;
    public final /* synthetic */ _me _c;

    public _ms(_me _meVar, FrameLayout frameLayout, Activity activity) {
        this._c = _meVar;
        this._a = frameLayout;
        this._b = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _n1._a(this._a, this._c._b);
        AtomicBoolean atomicBoolean = this._c._a7;
        if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true)) {
            _m8._a()._a(this._c._a4);
        }
        _jd _jdVar = this._c._F;
        if (_jdVar != null) {
            _jdVar._a(this._b);
        }
        _me _meVar = this._c;
        if (_meVar._a9 != null || _meVar._a5 <= 0) {
            return;
        }
        _me _meVar2 = this._c;
        _meVar._a9 = new _me._i(_meVar2, _meVar2._a5);
        this._c._a(true);
    }
}
