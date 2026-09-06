package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j3 implements MediaPlayer.OnBufferingUpdateListener {
    public final /* synthetic */ _j5 _a;

    public _j3(_j5 _j5Var) {
        this._a = _j5Var;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this._a._a.onBufferingUpdate(mediaPlayer, i);
    }
}
