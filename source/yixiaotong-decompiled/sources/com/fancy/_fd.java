package com.fancy;

import android.text.TextUtils;
import android.view.View;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fd implements Runnable {
    public final /* synthetic */ View _a;
    public final /* synthetic */ _fe _b;

    public _fd(_fe _feVar, View view) {
        this._b = _feVar;
        this._a = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        _n1._a(this._a, this._b._c._d);
        if (this._b._c._i.compareAndSet(false, true)) {
            _fg _fgVar_a = _fg._a();
            String str = this._b._c._c;
            _fgVar_a.getClass();
            if (!TextUtils.isEmpty(str) && (adInteractionListener = _fgVar_a._d.get(str)) != null) {
                adInteractionListener.onAdShow();
            }
        }
        _fe _feVar = this._b;
        _jd _jdVar = _feVar._c._g;
        if (_jdVar != null) {
            _jdVar._a(_feVar._b);
        }
    }
}
