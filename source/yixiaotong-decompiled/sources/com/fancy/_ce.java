package com.fancy;

import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ce implements _hx {
    public final /* synthetic */ _cf _a;
    public final /* synthetic */ _hx _b;
    public final /* synthetic */ _cf _c;

    public _ce(_cf _cfVar, _cf _cfVar2, _hx _hxVar) {
        this._c = _cfVar;
        this._a = _cfVar2;
        this._b = _hxVar;
    }

    @Override // com.fancy._hx
    public final void _a(_cg _cgVar, _ck _ckVar) {
        Logger.d(_ie._a("policy updated, version: ").append(_ckVar._g).toString());
        synchronized (this._c._e) {
            _cf _cfVar = this._a;
            _cfVar._c = _cgVar;
            _cfVar._d = _ckVar;
        }
        _hx _hxVar = this._b;
        if (_hxVar != null) {
            _hxVar._a(_cgVar, _ckVar);
        }
    }

    @Override // com.fancy._hx
    public final void _a(String str) {
        Logger.d("onSdkConfigRawData:");
        _hx _hxVar = this._b;
        if (_hxVar != null) {
            _hxVar._a(str);
        }
    }

    @Override // com.fancy._hx
    public final void _b(String str) {
        Logger.d("OnPolicyRawData:");
        _hx _hxVar = this._b;
        if (_hxVar != null) {
            _hxVar._b(str);
        }
    }

    @Override // com.fancy._hx
    public final void _c(String str) {
        Logger.d(String.format("Loader fail: %s", str));
        _hx _hxVar = this._b;
        if (_hxVar != null) {
            _hxVar._c(str);
        }
    }
}
