package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j1 implements MediaPlayer.OnErrorListener {
    public final /* synthetic */ _j5 _a;

    public _j1(_j5 _j5Var) {
        this._a = _j5Var;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return this._a._a.onError(mediaPlayer, i, i2);
    }
}
