package com.fancy;

import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ji extends _jj._b<_bg> {
    public final /* synthetic */ _ch _c;
    public final /* synthetic */ Error _d;
    public final /* synthetic */ _jj _e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public _ji(_jj _jjVar, _jj._c _cVar, _ch _chVar, _ch _chVar2, Error error) {
        super(_cVar, _chVar);
        this._e = _jjVar;
        this._c = _chVar2;
        this._d = error;
    }

    @Override // com.fancy._jj._b
    public final void _a() {
        try {
            _jj _jjVar = this._e;
            _jj._a(_jjVar, _jjVar._c, this._c, this, this._d);
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e("ConcurrentHolder", e.getMessage());
        }
    }
}
