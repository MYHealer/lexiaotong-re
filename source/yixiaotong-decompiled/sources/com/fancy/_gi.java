package com.fancy;

import android.media.MediaPlayer;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gi implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ _gl _a;

    public _gi(_gl _glVar) {
        this._a = _glVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoComplete();
        }
    }
}
