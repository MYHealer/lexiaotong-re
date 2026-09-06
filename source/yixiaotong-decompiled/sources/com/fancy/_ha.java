package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ha implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ _hb _a;

    public _ha(_hb _hbVar) {
        this._a = _hbVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return this._a._a.onError(mediaPlayer, i, i2);
    }
}
