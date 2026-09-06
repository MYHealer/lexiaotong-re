package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _h9 implements MediaPlayer.OnBufferingUpdateListener {
    public final /* synthetic */ _hb _a;

    public _h9(_hb _hbVar) {
        this._a = _hbVar;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this._a._a.onBufferingUpdate(mediaPlayer, i);
    }
}
