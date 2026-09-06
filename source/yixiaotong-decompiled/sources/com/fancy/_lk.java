package com.fancy;

import android.media.MediaPlayer;
import com.alipay.sdk.tid.b;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lk implements MediaPlayer.OnCompletionListener {
    public final /* synthetic */ _lp _a;

    public _lk(_lp _lpVar) {
        this._a = _lpVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        Logger.d("RewardVideoWeb", "视频播放完成");
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt._d _dVar = (_mt._d) _cVar;
            _mt _mtVar = _mt.this;
            _mtVar.getClass();
            _mtVar._a("onVideoStateChanged", _mt._a(new String[][]{new String[]{"state", "completed"}, new String[]{b.f, String.valueOf(System.currentTimeMillis())}}));
            _m8._a()._e(_mt.this._e);
        }
    }
}
