package com.fancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.widgets.PtgShakeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ns extends _an {
    public PtgVideoView _f;
    public LinearLayout _g;
    public PtgShakeView _h;
    public TextView _i;

    public class _a implements _d0 {
        public boolean _a;
        public final /* synthetic */ _f _b;

        public _a(_f _fVar) {
            this._b = _fVar;
        }

        @Override // com.fancy._d0
        public final void _a() {
            _v _vVar = _ns.this._c;
            if (_vVar != null) {
                _vVar._a();
            }
            Context context = _ns.this.getContext();
            _ns _nsVar = _ns.this;
            _b3._a(context, _nsVar, this._b, _nsVar._f, _nsVar._i, _nsVar._g, _nsVar._b);
        }

        @Override // com.fancy._d0
        public final void _a(Exception exc) {
            _ns _nsVar = _ns.this;
            _v _vVar = _nsVar._c;
            if (_vVar == null || this._a) {
                return;
            }
            this._a = true;
            _vVar._a(_nsVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
        }
    }

    public _ns(Context context) {
        super(context);
    }

    @Override // com.fancy._an
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.fancy_splash_video_view, (ViewGroup) null);
        this._a = viewInflate;
        PtgVideoView ptgVideoView = (PtgVideoView) viewInflate.findViewById(R.id.ptgVideoView);
        this._f = ptgVideoView;
        ptgVideoView.setShowPlayButton(false);
        this._f.setSoundMarginTop(ScreenUtils.dp2px(30.0f));
        this._i = (TextView) this._a.findViewById(R.id.ptgSplashHotArea);
        this._g = (LinearLayout) this._a.findViewById(R.id.ptgSplashShakeLayout);
        this._h = (PtgShakeView) this._a.findViewById(R.id.ptgSplashShakeIv);
        _db._a(this._i);
        addView(this._a, -1, -1);
    }

    @Override // com.fancy._an
    public final void _c() {
        super._c();
        PtgShakeView ptgShakeView = this._h;
        if (ptgShakeView != null) {
            ImageView imageView = ptgShakeView._a;
            if (imageView != null) {
                imageView.clearAnimation();
            }
            _mz _mzVar = ptgShakeView._d;
            if (_mzVar != null) {
                _mzVar.cancel();
                ptgShakeView._d = null;
            }
        }
        PtgVideoView ptgVideoView = this._f;
        if (ptgVideoView != null) {
            ptgVideoView._b();
            this._f = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PtgVideoView ptgVideoView = this._f;
        if (ptgVideoView != null) {
            ptgVideoView._b();
            this._f = null;
        }
    }

    @Override // com.fancy._an
    public void setAd(_f _fVar) {
        Exception exc;
        _a _aVar = new _a(_fVar);
        if (_fVar == null || this._f == null) {
            exc = new Exception("广告数据异常");
        } else {
            if (_fVar._u()) {
                this._f._a(_fVar, 0.0f, new _nt());
                this._f.setOnErrorListener(new _nu());
                this._f.setOnCompletionListener(new _nv());
                this._f.setVideoStateListener(new _nw());
                this._f._a(_aVar);
                return;
            }
            exc = new Exception("广告类型异常");
        }
        _aVar._a(exc);
    }
}
