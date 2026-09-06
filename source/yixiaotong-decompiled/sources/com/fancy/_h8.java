package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _h8 implements MediaPlayer.OnInfoListener {
    public final /* synthetic */ _hb _a;

    public _h8(_hb _hbVar) {
        this._a = _hbVar;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return this._a._a.onInfo(mediaPlayer, i, i2);
    }
}
