package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ff implements Runnable {
    public final /* synthetic */ _fc _a;

    public _ff(_fc _fcVar) {
        this._a = _fcVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        _fc _fcVar = this._a;
        if (com.fancy.adsdk.lib.utils._a._a(_fcVar._d, _fcVar._i)) {
            _fg _fgVar_a = _fg._a();
            String str = this._a._c;
            _fgVar_a.getClass();
            if (TextUtils.isEmpty(str) || (adInteractionListener = _fgVar_a._d.get(str)) == null) {
                return;
            }
            adInteractionListener.onAdShow();
        }
    }
}
