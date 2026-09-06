package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _f8 implements _l4._b {
    public final /* synthetic */ _f5 _a;

    public _f8(_f5 _f5Var) {
        this._a = _f5Var;
    }

    @Override // com.fancy._l4._b
    public final void _a(long j, long j2) {
        PtgVideoAdListener ptgVideoAdListener;
        _fg _fgVar_a = _fg._a();
        String str = this._a._b;
        _fgVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fgVar_a._e.get(str)) == null) {
            return;
        }
        ptgVideoAdListener.onVideoProgressUpdate(j, j2);
    }
}
