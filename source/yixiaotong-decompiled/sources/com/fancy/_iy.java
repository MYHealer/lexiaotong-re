package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _iy implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ _j5 _a;

    public class _a implements Runnable {
        public final /* synthetic */ MediaPlayer _a;

        public _a(MediaPlayer mediaPlayer) {
            this._a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _iy.this._a._a.onPrepared(this._a);
        }
    }

    public _iy(_j5 _j5Var) {
        this._a = _j5Var;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        this._a._a._i.post(new _a(mediaPlayer));
    }
}
