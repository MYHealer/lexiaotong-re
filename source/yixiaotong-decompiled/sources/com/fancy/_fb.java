package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fb implements _l7 {
    public final /* synthetic */ _f5 _a;

    public _fb(_f5 _f5Var) {
        this._a = _f5Var;
    }

    @Override // com.fancy._l7
    public final void onVideoPause() {
        PtgVideoAdListener ptgVideoAdListener;
        _fg _fgVar_a = _fg._a();
        String str = this._a._b;
        _fgVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fgVar_a._e.get(str)) == null) {
            return;
        }
        ptgVideoAdListener.onVideoPause();
    }

    @Override // com.fancy._l7
    public final void onVideoResume() {
        PtgVideoAdListener ptgVideoAdListener;
        _fg _fgVar_a = _fg._a();
        String str = this._a._b;
        _fgVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fgVar_a._e.get(str)) == null) {
            return;
        }
        ptgVideoAdListener.onVideoResume();
    }

    @Override // com.fancy._l7
    public final void onVideoStart() {
        PtgVideoAdListener ptgVideoAdListener;
        _fg _fgVar_a = _fg._a();
        String str = this._a._b;
        _fgVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fgVar_a._e.get(str)) == null) {
            return;
        }
        ptgVideoAdListener.onVideoStart();
    }
}
