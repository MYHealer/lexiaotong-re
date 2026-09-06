package com.fancy;

import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.fancy.adsdk.lib.model.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mw implements _b4<Boolean> {
    public final /* synthetic */ _mt _a;

    public _mw(_mt _mtVar) {
        this._a = _mtVar;
    }

    @Override // com.fancy._b4
    public final void onError(AdError adError) {
        _mt _mtVar = this._a;
        _mtVar._l = false;
        _mtVar._a(adError.getErrorCode(), adError.getMessage(), false);
    }

    @Override // com.fancy._b4
    public final void _a(Boolean bool) {
        _mt _mtVar;
        String msg;
        boolean z;
        int code;
        this._a._l = false;
        if (bool.booleanValue()) {
            _mtVar = this._a;
            PtgRewardConstant.ServerErr serverErr = PtgRewardConstant.ServerErr.SUC;
            code = serverErr.getCode();
            msg = serverErr.getMsg();
            z = true;
        } else {
            _mtVar = this._a;
            PtgRewardConstant.ServerErr serverErr2 = PtgRewardConstant.ServerErr.SUC_ERR;
            int code2 = serverErr2.getCode();
            msg = serverErr2.getMsg();
            z = false;
            code = code2;
        }
        _mtVar._a(code, msg, z);
    }
}
