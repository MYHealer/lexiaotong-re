package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mp implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ _me _a;

    public _mp(_me _meVar) {
        this._a = _meVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        _m8._a()._e(this._a._a4);
        _me _meVar = this._a;
        _meVar._x = true;
        _meVar._e();
    }
}
