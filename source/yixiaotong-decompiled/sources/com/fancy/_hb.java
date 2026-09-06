package com.fancy;

import android.media.MediaPlayer;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hb implements Callable<Boolean> {
    public final /* synthetic */ NiceVideoPlayer _a;

    public _hb(NiceVideoPlayer niceVideoPlayer) {
        this._a = niceVideoPlayer;
    }

    @Override // java.util.concurrent.Callable
    public final Boolean call() {
        NiceVideoPlayer niceVideoPlayer = this._a;
        if (niceVideoPlayer._d == null) {
            niceVideoPlayer._d = new MediaPlayer();
            this._a._d.reset();
            this._a._d.setAudioStreamType(3);
            this._a._d.setOnPreparedListener(new _h5(this));
            this._a._d.setOnVideoSizeChangedListener(new _h6(this));
            this._a._d.setOnCompletionListener(new _h7(this));
            this._a._d.setOnInfoListener(new _h8(this));
            this._a._d.setOnBufferingUpdateListener(new _h9(this));
            this._a._d.setOnErrorListener(new _ha(this));
        }
        return Boolean.TRUE;
    }
}
