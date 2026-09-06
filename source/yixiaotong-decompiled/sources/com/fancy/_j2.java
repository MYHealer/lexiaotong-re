package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j2 implements MediaPlayer.OnInfoListener {
    public final /* synthetic */ _j5 _a;

    public _j2(_j5 _j5Var) {
        this._a = _j5Var;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return this._a._a.onInfo(mediaPlayer, i, i2);
    }
}
