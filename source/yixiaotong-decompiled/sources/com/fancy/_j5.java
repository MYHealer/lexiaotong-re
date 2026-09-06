package com.fancy;

import android.media.MediaPlayer;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j5 implements Callable<Boolean> {
    public final /* synthetic */ PtgCoreVideo _a;

    public _j5(PtgCoreVideo ptgCoreVideo) {
        this._a = ptgCoreVideo;
    }

    @Override // java.util.concurrent.Callable
    public final Boolean call() {
        PtgCoreVideo ptgCoreVideo = this._a;
        if (ptgCoreVideo._f == null) {
            ptgCoreVideo._f = new MediaPlayer();
            this._a._f.setAudioStreamType(3);
            this._a._f.setScreenOnWhilePlaying(true);
            this._a._f.setOnPreparedListener(new _iy(this));
            this._a._f.setOnVideoSizeChangedListener(new _iz(this));
            this._a._f.setOnCompletionListener(new _j0(this));
            this._a._f.setOnErrorListener(new _j1(this));
            this._a._f.setOnInfoListener(new _j2(this));
            this._a._f.setOnBufferingUpdateListener(new _j3(this));
            this._a._f.setOnSeekCompleteListener(new _j4(this));
            PtgCoreVideo ptgCoreVideo2 = this._a;
            ptgCoreVideo2._f.setVolume(ptgCoreVideo2._m, ptgCoreVideo2._n);
            Logger.d("PtgCoreVideo", "mMediaPlayer initMediaPlayer: setVolume(" + this._a._m + ", " + this._a._n + ")");
        }
        return Boolean.TRUE;
    }
}
