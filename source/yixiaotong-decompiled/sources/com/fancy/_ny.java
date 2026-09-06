package com.fancy;

import android.widget.TextView;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ny implements _bu._a {
    public final /* synthetic */ _nx _a;

    public _ny(_nx _nxVar) {
        this._a = _nxVar;
    }

    public final void _a() {
        _nx _nxVar = this._a;
        _nxVar._b = 0L;
        TextView textView = _nxVar._e;
        if (textView != null) {
            textView.setText("");
        }
        _nx _nxVar2 = this._a;
        ActionTrackManager._a()._a(_hr._a(this._a._m), (_nxVar2._a - _nxVar2._b) / 1000);
        PtgSplashAd.AdInteractionListener adInteractionListener = this._a._i;
        if (adInteractionListener != null) {
            adInteractionListener.onAdTimeOver();
        }
        PtgSplashAd.AdInteractionListener adInteractionListener2 = this._a._i;
        if (adInteractionListener2 != null) {
            adInteractionListener2.onDismiss(2);
        }
        this._a._a();
    }
}
