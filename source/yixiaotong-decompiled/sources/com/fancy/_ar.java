package com.fancy;

import android.widget.ImageView;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.widgets.PtgShakeView;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ar implements AdvertRatioLayout._a {
    public final /* synthetic */ _f _a;
    public final /* synthetic */ ImageView _b;
    public final /* synthetic */ String _c;
    public final /* synthetic */ int _d;
    public final /* synthetic */ int _e;
    public final /* synthetic */ AdvertRatioLayout _f;
    public final /* synthetic */ _d0 _g;
    public final /* synthetic */ _aq _h;

    public _ar(_aq _aqVar, _f _fVar, ImageView imageView, String str, int i, int i2, AdvertRatioLayout advertRatioLayout, _d0 _d0Var) {
        this._h = _aqVar;
        this._a = _fVar;
        this._b = imageView;
        this._c = str;
        this._d = i;
        this._e = i2;
        this._f = advertRatioLayout;
        this._g = _d0Var;
    }

    @Override // com.fancy.mpsdk.component.base.AdvertRatioLayout._a
    public final void _a(int i, int i2) {
        ImageView imageView;
        _aq _aqVar;
        PtgVideoView ptgVideoView;
        this._h._n = _m5._a(this._a, i, i2);
        _i9 _i9Var = this._h._n;
        if (_i9Var != null) {
            ImageView imageView2 = this._b;
            if (imageView2 != null) {
                imageView2.setLayoutParams(_i9Var._a);
            }
            if (this._a._u() && (ptgVideoView = (_aqVar = this._h)._j) != null) {
                ptgVideoView.setVideoLayoutParams(_aqVar._n._a);
                this._h._j.setVisibility(0);
            }
            if (this._h._n._b) {
                _m3 _m3VarLoad = Doodle.load(this._c);
                int i3 = this._d;
                int i4 = this._e;
                _m3VarLoad._d = i3;
                _m3VarLoad._e = i4;
                _m3VarLoad._i = true;
                _m3VarLoad._h = false;
                _ax._a(this._h.getContext(), _m3VarLoad._a(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS), this._f);
            }
            PtgShakeView ptgShakeView = this._h._l;
            if (ptgShakeView == null || this._g == null || (imageView = ptgShakeView._a) == null) {
                return;
            }
            imageView.post(new _kt(ptgShakeView, i, i2));
        }
    }
}
