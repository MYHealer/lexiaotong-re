package com.fancy;

import android.media.MediaPlayer;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gj implements NiceVideoPlayer._i {
    public final /* synthetic */ _gl _a;

    public _gj(_gl _glVar) {
        this._a = _glVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener == null) {
            return false;
        }
        ptgVideoAdListener.onVideoError(i, String.valueOf(i2));
        return false;
    }

    @Override // com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer._i
    public final void onTimeout() {
        PtgVideoAdListener ptgVideoAdListener = this._a._h;
        if (ptgVideoAdListener != null) {
            ptgVideoAdListener.onVideoError(PtgErrorCode.SDK_VIDEO_PLAY_ERROR, "Video Play Timeout!");
        }
    }
}
