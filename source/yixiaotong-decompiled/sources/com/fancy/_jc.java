package com.fancy;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jc implements View.OnClickListener {
    public final /* synthetic */ _jd _a;

    public _jc(_jd _jdVar) {
        this._a = _jdVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        _jd._b _bVar;
        int i_a = _p5._a(view);
        if (i_a == 6 || i_a == 4) {
            _jd._b _bVar2 = this._a._o;
            if (_bVar2 != null) {
                _bVar2._a(view, _p5._a(view), null);
                return;
            }
            return;
        }
        _jd _jdVar = this._a;
        if (!_jdVar._g || (_bVar = _jdVar._o) == null) {
            return;
        }
        _bVar._a(view, 4, null);
    }
}
