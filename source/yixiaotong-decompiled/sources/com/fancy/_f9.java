package com.fancy;

import android.media.MediaPlayer;
import android.text.TextUtils;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _f9 implements NiceVideoPlayer._i {
    public final /* synthetic */ _f5 _a;

    public _f9(_f5 _f5Var) {
        this._a = _f5Var;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        PtgVideoAdListener ptgVideoAdListener;
        _fg _fgVar_a = _fg._a();
        String str = this._a._b;
        String str2 = "Video Play Error! what: " + i;
        _fgVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fgVar_a._e.get(str)) == null) {
            return false;
        }
        ptgVideoAdListener.onVideoError(PtgErrorCode.SDK_VIDEO_PLAY_ERROR, str2);
        return false;
    }

    @Override // com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer._i
    public final void onTimeout() {
        PtgVideoAdListener ptgVideoAdListener;
        _fg _fgVar_a = _fg._a();
        String str = this._a._b;
        _fgVar_a.getClass();
        if (TextUtils.isEmpty(str) || (ptgVideoAdListener = _fgVar_a._e.get(str)) == null) {
            return;
        }
        ptgVideoAdListener.onVideoError(PtgErrorCode.SDK_VIDEO_PLAY_ERROR, "Video Play Timeout!");
    }
}
