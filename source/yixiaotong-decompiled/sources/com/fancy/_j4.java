package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j4 implements MediaPlayer.OnSeekCompleteListener {
    public final /* synthetic */ _j5 _a;

    public class _a implements Runnable {
        public final /* synthetic */ MediaPlayer _a;

        public _a(MediaPlayer mediaPlayer) {
            this._a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _j4.this._a._a._q.onSeekComplete(this._a);
        }
    }

    public _j4(_j5 _j5Var) {
        this._a = _j5Var;
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public final void onSeekComplete(MediaPlayer mediaPlayer) {
        this._a._a._i.post(new _a(mediaPlayer));
    }
}
