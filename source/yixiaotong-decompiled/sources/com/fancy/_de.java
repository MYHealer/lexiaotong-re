package com.fancy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _de {
    public static void _a(_f _fVar) {
        _i _iVar;
        if (_fVar == null || (_iVar = _fVar._s) == null) {
            return;
        }
        String str = "0";
        if (!_iVar._d) {
            _iVar._y = "0";
            _iVar._z = "0";
            _iVar._A = "0";
            _iVar._B = "0";
        } else if (com.fancy.adsdk.lib.utils._a._a(_iVar._q)) {
            boolean z = _kr._a("sdk_local_enhance_limit", "enhanceLimit") < ((long) _iVar._e);
            boolean z2 = System.currentTimeMillis() - _kr._a("sdk_local_enhance_last_time", "enhanceLastTime") > ((long) _iVar._f) * 1000;
            if (z && z2) {
                _iVar._y = "2";
                _iVar._z = "0";
                _iVar._C = _iVar._a(true);
                if (!_iVar._i) {
                    _iVar._A = "0";
                } else if (_kr._a("sdk_local_enhance_f_click_limit", "fClickLimit") < _iVar._l) {
                    _iVar._A = "2";
                } else {
                    _iVar._A = "1";
                    str = "3";
                }
                _iVar._B = str;
                return;
            }
            if (z) {
                _iVar._y = "1";
                _iVar._z = "2";
                _iVar._A = "1";
                _iVar._B = "2";
            } else {
                _iVar._y = "1";
                _iVar._z = "3";
                _iVar._A = "1";
                _iVar._B = "3";
            }
        } else {
            _iVar._y = "1";
            _iVar._z = "1";
            _iVar._A = "1";
            _iVar._B = "1";
        }
        _iVar._C = _iVar._a(false);
    }
}
