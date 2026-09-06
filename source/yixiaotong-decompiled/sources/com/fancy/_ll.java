package com.fancy;

import android.media.MediaPlayer;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ll implements NiceVideoPlayer._i {
    public boolean _a;
    public final /* synthetic */ _lp _b;

    public _ll(_lp _lpVar) {
        this._b = _lpVar;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this._a) {
            return false;
        }
        this._a = true;
        Logger.e("RewardVideoWeb", "视频播放错误: what=" + i + ", extra=" + i2);
        _lp._c _cVar = this._b._f;
        if (_cVar == null) {
            return false;
        }
        ((_mt._d) _cVar)._a("播放错误: " + i);
        return false;
    }

    @Override // com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer._i
    public final void onTimeout() {
        if (this._a) {
            return;
        }
        this._a = true;
        Logger.e("RewardVideoWeb", "视频加载超时");
        _lp._c _cVar = this._b._f;
        if (_cVar != null) {
            ((_mt._d) _cVar)._a("加载超时");
        }
    }
}
