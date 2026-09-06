package com.fancy;

import com.fancy.adsdk.lib.interf.PtgVideoAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gm implements _l4._b {
    public final /* synthetic */ _gl _a;

    public _gm(_gl _glVar) {
        this._a = _glVar;
    }

    @Override // com.fancy._l4._b
    public final void _a(long j, long j2) {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoProgressUpdate(j, j2);
        }
    }
}
