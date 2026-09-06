package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.utils.ot.LruDiskUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ni implements _hw {
    public final _hw _a;
    public _hv _b;

    public _ni(_g7 _g7Var, com.fancy.adsdk.lib._d _dVar) {
        this._a = _g7Var;
        this._b = _dVar;
    }

    @Override // com.fancy._hw
    public final void _a(_hx _hxVar) throws Throwable {
        _b(_hxVar);
    }

    @Override // com.fancy._hw
    public final void _b(_hx _hxVar) throws Throwable {
        String asString = LruDiskUtils.get(PtgAdSdk.getContext()).getAsString(LruDiskUtils.CACHE_CONFIG_KEY);
        if (TextUtils.isEmpty(asString)) {
            _hv _hvVar = this._b;
            if (_hvVar != null) {
                com.fancy.adsdk.lib.utils._d._c(new com.fancy.adsdk.lib._c((com.fancy.adsdk.lib._d) _hvVar));
                this._b = null;
            }
            _hw _hwVar = this._a;
            if (_hwVar == null) {
                return;
            }
            _hwVar._b(new _nh(_hxVar));
            return;
        }
        _cg _cgVar = new _cg();
        _ck _ckVar = new _ck();
        if (!_ckVar._c(asString) || !_cgVar._a(asString, _ckVar)) {
            _hv _hvVar2 = this._b;
            if (_hvVar2 != null) {
                com.fancy.adsdk.lib.utils._d._c(new com.fancy.adsdk.lib._c((com.fancy.adsdk.lib._d) _hvVar2));
                this._b = null;
            }
            _hw _hwVar2 = this._a;
            if (_hwVar2 == null) {
                return;
            }
            _hwVar2._b(new _nh(_hxVar));
            return;
        }
        _hxVar._a(_cgVar, _ckVar);
        _hv _hvVar3 = this._b;
        if (_hvVar3 != null) {
            com.fancy.adsdk.lib.utils._d._c(new com.fancy.adsdk.lib._c((com.fancy.adsdk.lib._d) _hvVar3));
            this._b = null;
        }
        _hw _hwVar3 = this._a;
        if (_hwVar3 == null) {
            return;
        }
        _hwVar3._b(new _nh(_hxVar));
    }
}
