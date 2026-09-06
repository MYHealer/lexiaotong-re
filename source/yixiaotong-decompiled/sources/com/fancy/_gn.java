package com.fancy;

import com.fancy.adsdk.lib.interf.PtgVideoAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gn implements _l7 {
    public final /* synthetic */ _gl _a;

    public _gn(_gl _glVar) {
        this._a = _glVar;
    }

    @Override // com.fancy._l7
    public final void onVideoPause() {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoPause();
        }
    }

    @Override // com.fancy._l7
    public final void onVideoResume() {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoResume();
        }
    }

    @Override // com.fancy._l7
    public final void onVideoStart() {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoStart();
        }
    }
}
