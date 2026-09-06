package com.fancy;

import android.view.View;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dl implements View.OnClickListener {
    public final /* synthetic */ _dm _a;

    public _dl(_dm _dmVar) {
        this._a = _dmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdDismiss();
        }
        this._a._a();
    }
}
