package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _h7 implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ _hb _a;

    public class _a implements Runnable {
        public final /* synthetic */ MediaPlayer _a;

        public _a(MediaPlayer mediaPlayer) {
            this._a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _h7.this._a._a.onCompletion(this._a);
        }
    }

    public _h7(_hb _hbVar) {
        this._a = _hbVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        this._a._a._h.post(new _a(mediaPlayer));
    }
}
