package com.fancy;

import android.app.Activity;
import android.media.MediaPlayer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mo implements MediaPlayer.OnPreparedListener {
    public final /* synthetic */ Activity _a;
    public final /* synthetic */ _me _b;

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            _m8._a()._g(_mo.this._b._a4);
        }
    }

    public _mo(_me _meVar, Activity activity) {
        this._b = _meVar;
        this._a = activity;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        _f _fVar;
        _me _meVar = this._b;
        _meVar._b(_meVar._t == 0);
        ProgressBar progressBar = this._b._G;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        _me _meVar2 = this._b;
        NiceVideoPlayer niceVideoPlayer = _meVar2._D;
        _meVar2._a5 = niceVideoPlayer != null ? (int) niceVideoPlayer.getDuration() : 0;
        _me _meVar3 = this._b;
        ImageView imageView = _meVar3._I;
        if (imageView != null) {
            imageView.postDelayed(new _mf(_meVar3), 500L);
        }
        _me _meVar4 = this._b;
        Activity activity = this._a;
        if (!_meVar4._aa.get()) {
            _meVar4._aa.set(true);
            FrameLayout frameLayout = _meVar4._H;
            if (frameLayout != null) {
                frameLayout.post(new _ms(_meVar4, frameLayout, activity));
            }
        }
        _me _meVar5 = this._b;
        if (_meVar5._a9 == null && (_fVar = _meVar5._b) != null && _fVar._A) {
            _me _meVar6 = this._b;
            _meVar5._a9 = new _me._i(_meVar6, _meVar6._a5);
            this._b._a(true);
        }
        _fu._a.post(new _a());
    }
}
