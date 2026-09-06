package com.fancy;

import android.media.MediaPlayer;
import android.widget.ProgressBar;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mq implements NiceVideoPlayer._i {
    public boolean _a;
    public final /* synthetic */ _me _b;

    public _mq(_me _meVar) {
        this._b = _meVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (!this._a) {
            this._a = true;
            _m8._a()._a(this._b._a4, PtgErrorCode.SDK_VIDEO_PLAY_ERROR, "Video play error! what: " + i);
        }
        ProgressBar progressBar = this._b._G;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this._b._e();
        _me _meVar = this._b;
        _meVar._x = true;
        _meVar._z = true;
        _meVar._b(0);
        return false;
    }

    @Override // com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer._i
    public final void onTimeout() {
        if (!this._a) {
            this._a = true;
            _m8._a()._a(this._b._a4, PtgErrorCode.SDK_RENDER_ERROR, "Video timeout");
        }
        ProgressBar progressBar = this._b._G;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        this._b._e();
        _me _meVar = this._b;
        _meVar._x = true;
        _meVar._z = true;
        _meVar._b(0);
    }
}
