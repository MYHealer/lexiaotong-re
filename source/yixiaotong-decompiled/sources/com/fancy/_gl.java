package com.fancy;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.provider.PtgApiProvider;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gl implements _en {
    public final AtomicBoolean _a = new AtomicBoolean(false);
    public final AtomicBoolean _b = new AtomicBoolean(false);
    public com.fancy._f _c;
    public ViewGroup _d;
    public Boolean _e;
    public boolean _f;
    public PtgVideoView _g;
    public PtgVideoAdListener _h;
    public PtgNativeExpressAd.AdInteractionListener _i;
    public _b _j;
    public _c _k;
    public _d _l;
    public _e _m;
    public _g9 _n;
    public AtomicBoolean _o;
    public _l6 _p;
    public _f _q;

    public class _b implements View.OnAttachStateChangeListener {
        public _b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            if (_gl.this._b.get()) {
                return;
            }
            _gl _glVar = _gl.this;
            if (_glVar._b(_glVar._d)) {
                _gl.this._b.set(true);
                _gl _glVar2 = _gl.this;
                _glVar2.getClass();
                _fv._a.post(new _gk(_glVar2));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public class _c implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ViewTreeObserver _a;

        public _c(ViewTreeObserver viewTreeObserver) {
            this._a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (_gl.this._b.get()) {
                ViewTreeObserver viewTreeObserver = this._a;
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _gl _glVar = _gl.this;
                _glVar._e = _ks._a(_glVar._d);
                return;
            }
            _gl _glVar2 = _gl.this;
            if (_glVar2._b(_glVar2._d)) {
                ViewTreeObserver viewTreeObserver2 = this._a;
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _gl _glVar3 = _gl.this;
                _glVar3._e = _ks._a(_glVar3._d);
                if (_gl.this._b.get()) {
                    return;
                }
                _gl _glVar4 = _gl.this;
                if (_glVar4._b(_glVar4._d)) {
                    _gl.this._b.set(true);
                    _gl _glVar5 = _gl.this;
                    _glVar5.getClass();
                    _fv._a.post(new _gk(_glVar5));
                }
            }
        }
    }

    public class _d implements ViewTreeObserver.OnScrollChangedListener {
        public long _a = 0;

        public _d() {
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0052 A[PHI: r1
  0x0052: PHI (r1v6 com.fancy._gl) = (r1v5 com.fancy._gl), (r1v12 com.fancy._gl) binds: [B:21:0x0050, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:23:0x0059  */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            Boolean bool;
            _gl _glVar;
            int windowVisibility;
            if (System.currentTimeMillis() - this._a < 200) {
                return;
            }
            this._a = System.currentTimeMillis();
            _gl _glVar2 = _gl.this;
            if (_glVar2._d != null && _glVar2._n != null && (bool = _glVar2._e) != null) {
                if (bool.booleanValue()) {
                    boolean globalVisibleRect = _gl.this._d.getGlobalVisibleRect(new Rect());
                    _glVar = _gl.this;
                    if (_glVar._f != globalVisibleRect) {
                        _glVar._f = globalVisibleRect;
                        if (globalVisibleRect) {
                            windowVisibility = _glVar._d.getWindowVisibility();
                        } else {
                            windowVisibility = 8;
                        }
                        ((_dj) _gl.this._n)._a(windowVisibility);
                    }
                } else {
                    boolean zHasWindowFocus = _gl.this._d.hasWindowFocus();
                    _glVar = _gl.this;
                    if (_glVar._f != zHasWindowFocus) {
                        _glVar._f = zHasWindowFocus;
                        if (zHasWindowFocus) {
                            windowVisibility = _glVar._d.getWindowVisibility();
                        } else {
                            windowVisibility = 8;
                        }
                        ((_dj) _gl.this._n)._a(windowVisibility);
                    }
                }
            }
            if (_gl.this._b.get()) {
                return;
            }
            _gl _glVar3 = _gl.this;
            if (_glVar3._b(_glVar3._d)) {
                _gl.this._b.set(true);
                _gl _glVar4 = _gl.this;
                _glVar4.getClass();
                _fv._a.post(new _gk(_glVar4));
            }
        }
    }

    public class _e implements ViewTreeObserver.OnWindowFocusChangeListener {
        public _e() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            if (_gl.this._a.get()) {
                _gl _glVar = _gl.this;
                _glVar._f = z;
                ViewGroup viewGroup = _glVar._d;
                if (viewGroup == null || _glVar._n == null) {
                    return;
                }
                ((_dj) _gl.this._n)._a(z ? viewGroup.getWindowVisibility() : 8);
            }
        }
    }

    public class _f implements PtgNativeExpressAd.CustomizeVideo {
        public _f() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final String getCoverUrl() {
            com.fancy._f _fVar = _gl.this._c;
            return _fVar != null ? _fVar._n() : "";
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final String getVideoUrl() {
            com.fancy._f _fVar = _gl.this._c;
            return _fVar != null ? _fVar._o() : "";
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoComplete() {
            _gl _glVar = _gl.this;
            _l6 _l6Var = _glVar._p;
            if (_l6Var != null) {
                _l6Var._a(_glVar._c, -1L);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoError() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoPause() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoProgress(long j, long j2) {
            _gl _glVar = _gl.this;
            _l6 _l6Var = _glVar._p;
            if (_l6Var != null) {
                _l6Var._a(_glVar._c, j2);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoResume() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgNativeExpressAd.CustomizeVideo
        public final void reportVideoStart() {
        }
    }

    @Override // com.fancy._en
    public final void _a() {
        try {
            PtgVideoView ptgVideoView = this._g;
            if (ptgVideoView != null) {
                ptgVideoView._a();
                this._g._b();
                this._g = null;
            }
            this._h = null;
            this._p = null;
            this._q = null;
            ViewGroup viewGroup = this._d;
            if (viewGroup != null) {
                _b _bVar = this._j;
                if (_bVar != null) {
                    try {
                        viewGroup.removeOnAttachStateChangeListener(_bVar);
                    } catch (Exception unused) {
                    }
                }
                try {
                    ViewTreeObserver viewTreeObserver = this._d.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        _c _cVar = this._k;
                        if (_cVar != null) {
                            viewTreeObserver.removeOnGlobalLayoutListener(_cVar);
                        }
                        _d _dVar = this._l;
                        if (_dVar != null) {
                            viewTreeObserver.removeOnScrollChangedListener(_dVar);
                        }
                        _e _eVar = this._m;
                        if (_eVar != null) {
                            viewTreeObserver.removeOnWindowFocusChangeListener(_eVar);
                        }
                    }
                } catch (Exception unused2) {
                }
                this._d = null;
            }
        } catch (Exception unused3) {
        }
    }

    @Override // com.fancy._en
    public final void _a(Context context, com.fancy._f _fVar, AtomicBoolean atomicBoolean) {
        this._o = atomicBoolean;
        this._c = _fVar;
        PtgVideoView ptgVideoView = this._g;
        PtgVideoView ptgVideoView2 = null;
        if (ptgVideoView != null) {
            ptgVideoView._a();
            this._g._b();
            this._g = null;
        }
        if (context != null && _fVar != null && _fVar._u()) {
            ptgVideoView2 = new PtgVideoView(context);
            ptgVideoView2._a(_fVar, 0.0f, new _gm(this));
            ptgVideoView2.setShowPlayButton(true);
            ptgVideoView2.setVideoStateListener(new _gn(this));
            ptgVideoView2.setOnCompletionListener(new _gi(this));
            ptgVideoView2.setOnErrorListener(new _gj(this));
        }
        this._g = ptgVideoView2;
    }

    @Override // com.fancy._en
    public final void _a(ViewGroup viewGroup) {
        this._d = viewGroup;
    }

    @Override // com.fancy._en
    public final void _a(_dj _djVar) {
        this._n = _djVar;
    }

    @Override // com.fancy._en
    public final void _a(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        this._i = adInteractionListener;
    }

    public final boolean _b(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        com.fancy._f _fVar = this._c;
        return viewGroup.getWindowVisibility() == 0 && _m5._a(viewGroup, _fVar != null ? _fVar._U : 0.1f);
    }

    @Override // com.fancy._en
    public final View _c() {
        return this._g;
    }

    @Override // com.fancy._en
    public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
        if (this._p == null) {
            this._p = new _l6();
        }
        if (this._q == null) {
            this._q = new _f();
        }
        return this._q;
    }

    @Override // com.fancy._en
    public final void pauseVideo() {
        PtgVideoView ptgVideoView = this._g;
        if (ptgVideoView != null) {
            ptgVideoView._a();
        }
    }

    @Override // com.fancy._en
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._h = ptgVideoAdListener;
    }

    @Override // com.fancy._en
    public final void startVideo() {
        PtgVideoView ptgVideoView = this._g;
        if (ptgVideoView != null) {
            ptgVideoView._c();
        }
    }

    @Override // com.fancy._en
    public final void _b() {
        ViewTreeObserver viewTreeObserver;
        if (this._a.get()) {
            return;
        }
        this._a.set(true);
        PtgVideoView ptgVideoView = this._g;
        if (ptgVideoView != null) {
            ptgVideoView._a(new _a());
        }
        if (!this._b.get() && _b(this._d)) {
            this._b.set(true);
            _fv._a.post(new _gk(this));
        }
        if (this._b.get()) {
            return;
        }
        if (this._j == null) {
            this._j = new _b();
        }
        this._d.removeOnAttachStateChangeListener(this._j);
        this._d.addOnAttachStateChangeListener(this._j);
        if (_b(this._d) || (viewTreeObserver = this._d.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return;
        }
        if (this._k == null) {
            this._k = new _c(viewTreeObserver);
        }
        viewTreeObserver.removeOnGlobalLayoutListener(this._k);
        viewTreeObserver.addOnGlobalLayoutListener(this._k);
        if (this._l == null) {
            this._l = new _d();
        }
        viewTreeObserver.removeOnScrollChangedListener(this._l);
        viewTreeObserver.addOnScrollChangedListener(this._l);
        if (this._m == null) {
            this._m = new _e();
        }
        viewTreeObserver.removeOnWindowFocusChangeListener(this._m);
        viewTreeObserver.addOnWindowFocusChangeListener(this._m);
    }

    public class _a implements _d0 {
        public _a() {
        }

        @Override // com.fancy._d0
        public final void _a(Exception exc) {
            String message = exc.getMessage();
            PtgNativeExpressAd.AdInteractionListener adInteractionListener = _gl.this._i;
            if (adInteractionListener != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = message;
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = message;
                adInteractionListener.onRenderFail(adErrorImpl);
            }
        }

        @Override // com.fancy._d0
        public final void _a() {
            com.fancy._f _fVar = _gl.this._c;
            if (_fVar == null || _fVar._t()) {
                _gl _glVar = _gl.this;
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = _glVar._i;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderSuccess(_glVar._d);
                }
                if (_gl.this._b.get()) {
                    return;
                }
                _gl _glVar2 = _gl.this;
                if (_glVar2._b(_glVar2._d)) {
                    _gl.this._b.set(true);
                    _gl _glVar3 = _gl.this;
                    _glVar3.getClass();
                    _fv._a.post(new _gk(_glVar3));
                }
            }
        }
    }
}
