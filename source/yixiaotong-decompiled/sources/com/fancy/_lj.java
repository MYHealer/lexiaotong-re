package com.fancy;

import android.media.MediaPlayer;
import android.widget.ImageView;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lj implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ _lp _a;

    public _lj(_lp _lpVar) {
        this._a = _lpVar;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        Logger.d("RewardVideoWeb", "视频准备完成");
        this._a._i = true;
        ImageView imageView = this._a._d;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt._d _dVar = (_mt._d) _cVar;
            _mt.this._r = true;
            _m8._a()._g(_mt.this._e);
            _mt._b(_mt.this);
            _mt _mtVar = _mt.this;
            if (!_mtVar._f || (_mtVar._r && _mtVar._q)) {
                _mtVar._a("startTime", null);
            }
        }
    }
}
