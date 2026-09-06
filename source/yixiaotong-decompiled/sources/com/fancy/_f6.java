package com.fancy;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _f6 implements _d0 {
    public final /* synthetic */ _f5 _a;

    public _f6(_f5 _f5Var) {
        this._a = _f5Var;
    }

    @Override // com.fancy._d0
    public final void _a(Exception exc) {
        _f5 _f5Var = this._a;
        _4 _4 = _f5Var._a;
        if (_4 != null) {
            View view = _f5Var._f;
            _fe _feVar = (_fe) _4;
            _f _fVar = _feVar._c._d;
            if (_fVar != null) {
                _fVar._K = System.currentTimeMillis();
            }
            view.post(new _fd(_feVar, view));
        }
    }

    @Override // com.fancy._d0
    public final void _a() {
        try {
            this._a.setVisibility(0);
            _f5 _f5Var = this._a;
            _4 _4 = _f5Var._a;
            if (_4 != null) {
                View view = _f5Var._f;
                _fe _feVar = (_fe) _4;
                _f _fVar = _feVar._c._d;
                if (_fVar != null) {
                    _fVar._K = System.currentTimeMillis();
                }
                view.post(new _fd(_feVar, view));
            }
        } catch (Exception e) {
            _4 _5 = this._a._a;
            if (_5 != null) {
                ((_fe) _5)._a(_ie._a("渲染失败：").append(e.getMessage()).toString());
            }
        }
    }
}
