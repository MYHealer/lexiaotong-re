package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _h6 implements MediaPlayer.OnVideoSizeChangedListener {
    public final /* synthetic */ _hb _a;

    public class _a implements Runnable {
        public final /* synthetic */ MediaPlayer _a;
        public final /* synthetic */ int _b;
        public final /* synthetic */ int _c;

        public _a(MediaPlayer mediaPlayer, int i, int i2) {
            this._a = mediaPlayer;
            this._b = i;
            this._c = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _h6.this._a._a.onVideoSizeChanged(this._a, this._b, this._c);
        }
    }

    public _h6(_hb _hbVar) {
        this._a = _hbVar;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this._a._a._h.post(new _a(mediaPlayer, i, i2));
    }
}
