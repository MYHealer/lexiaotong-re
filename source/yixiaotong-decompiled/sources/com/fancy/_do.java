package com.fancy;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.mpsdk.component.video.PtgVideoView;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _do extends _gc {
    public _aq _J;
    public volatile boolean _K;
    public volatile boolean _L;
    public volatile boolean _M;
    public volatile boolean _N;
    public AtomicBoolean _O;
    public _b _P;
    public _c _Q;
    public final _a _R;

    public class _a implements _jw {
        public _a() {
        }
    }

    public class _b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ViewTreeObserver _a;

        public _b(ViewTreeObserver viewTreeObserver) {
            this._a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (_do.this._N) {
                ViewTreeObserver viewTreeObserver = this._a;
                if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                    return;
                }
                this._a.removeOnGlobalLayoutListener(this);
                return;
            }
            _do _doVar = _do.this;
            if (_doVar.getWindowVisibility() == 0) {
                _f _fVar = _doVar._c;
                if (_m5._a(_doVar, _fVar != null ? _fVar._U : 0.1f)) {
                    ViewTreeObserver viewTreeObserver2 = this._a;
                    if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                        this._a.removeOnGlobalLayoutListener(this);
                    }
                    _do _doVar2 = _do.this;
                    _doVar2._N = true;
                    _fv._a.post(new _dp(_doVar2));
                }
            }
        }
    }

    public class _c implements ViewTreeObserver.OnScrollChangedListener {
        public final /* synthetic */ ViewTreeObserver _a;

        public _c(ViewTreeObserver viewTreeObserver) {
            this._a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            if (_do.this._N) {
                ViewTreeObserver viewTreeObserver = this._a;
                if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                    return;
                }
                this._a.removeOnScrollChangedListener(this);
                return;
            }
            _do _doVar = _do.this;
            if (_doVar.getWindowVisibility() == 0) {
                _f _fVar = _doVar._c;
                if (_m5._a(_doVar, _fVar != null ? _fVar._U : 0.1f)) {
                    ViewTreeObserver viewTreeObserver2 = this._a;
                    if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                        this._a.removeOnScrollChangedListener(this);
                    }
                    _do _doVar2 = _do.this;
                    _doVar2._N = true;
                    _fv._a.post(new _dp(_doVar2));
                }
            }
        }
    }

    public _do(Context context) {
        super(context);
        this._O = new AtomicBoolean(false);
        this._R = new _a();
    }

    @Override // com.fancy._gc
    public final void _a(View view, int i, _oj _ojVar) {
        AdSlot adSlot;
        if (com.fancy.adsdk.lib.utils._a._f() || (adSlot = this._d) == null || this._c == null || view == null) {
            return;
        }
        this._p = true;
        this._g = false;
        this._h = false;
        this._j = false;
        this._l = false;
        this._m = false;
        this._n = false;
        adSlot._e(i);
        _f _fVar = this._c;
        _fVar._v = _ojVar;
        boolean z_r = _fVar._r();
        _f _fVar2 = this._c;
        if (z_r) {
            i = 0;
        }
        _n1._a(view, _fVar2, i);
        PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._a;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        _b3._a(view.getContext(), this._c, this._d);
    }

    @Override // com.fancy._gc
    public final void _b(View view, int i, _oj _ojVar) {
        super._b(view, i, _ojVar);
        _a(view, i, _ojVar);
        _aq _aqVar = this._J;
        if (_aqVar != null) {
            _n1._a(this, _aqVar.getAdRootView(), (View) null);
        }
    }

    @Override // com.fancy._gc
    public final void _d() {
        setBackgroundColor(-1);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        View.inflate(getContext(), R.layout.fancy_feed_view, this);
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new _dn(this));
    }

    public final void _e() {
        PtgVideoView ptgVideoView;
        _ga _gaVar;
        _gc._a _aVar;
        Handler handler = this._y;
        if (handler != null && (_aVar = this._z) != null) {
            handler.removeCallbacks(_aVar);
        }
        _io._b(this._e);
        _ng._a(this._e);
        try {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive() && (_gaVar = this._t) != null) {
                viewTreeObserver.removeOnScrollChangedListener(_gaVar);
            }
        } catch (Exception unused) {
        }
        if (this._a != null) {
            this._a = null;
        }
        if (this._b != null) {
            this._b = null;
        }
        _aq _aqVar = this._J;
        if (_aqVar != null && (ptgVideoView = _aqVar._j) != null) {
            ptgVideoView._b();
            _aqVar._j.setOnErrorListener(null);
            _aqVar._j = null;
        }
        this._b = null;
        try {
            ViewTreeObserver viewTreeObserver2 = getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                _b _bVar = this._P;
                if (_bVar != null) {
                    viewTreeObserver2.removeOnGlobalLayoutListener(_bVar);
                }
                _c _cVar = this._Q;
                if (_cVar != null) {
                    viewTreeObserver2.removeOnScrollChangedListener(_cVar);
                }
            }
        } catch (Exception unused2) {
        }
    }

    public final void _f() {
        if (this._K && this._L && this._M && !this._N) {
            if (getWindowVisibility() == 0) {
                _f _fVar = this._c;
                if (_m5._a(this, _fVar != null ? _fVar._U : 0.1f)) {
                    this._N = true;
                    _fv._a.post(new _dp(this));
                    return;
                }
            }
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive()) {
                return;
            }
            if (this._P == null) {
                this._P = new _b(viewTreeObserver);
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this._P);
            viewTreeObserver.addOnGlobalLayoutListener(this._P);
            if (this._Q == null) {
                this._Q = new _c(viewTreeObserver);
            }
            viewTreeObserver.removeOnScrollChangedListener(this._Q);
            viewTreeObserver.addOnScrollChangedListener(this._Q);
        }
    }

    @Override // com.fancy._gc
    public List<View> getAdvertViews() {
        ViewGroup adRootView;
        _aq _aqVar = this._J;
        if (_aqVar == null || (adRootView = _aqVar.getAdRootView()) == null) {
            return null;
        }
        return Collections.singletonList(adRootView);
    }

    @Override // com.fancy._gc
    public View getShakeLayout() {
        _aq _aqVar = this._J;
        if (_aqVar != null) {
            return _aqVar.getShakeLayout();
        }
        return null;
    }

    @Override // com.fancy._gc, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this._L = true;
        _f();
    }

    @Override // com.fancy._gc, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this._L = false;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        _aq _aqVar;
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 || i2 == i4 || (_aqVar = this._J) == null) {
            return;
        }
        _aqVar._a(i);
    }

    @Override // com.fancy._gc
    public void setAdvertInfo(_f _fVar) {
        super.setAdvertInfo(_fVar);
    }

    public void setExpressViewColor(String str) {
        _aq _aqVar = this._J;
        if (_aqVar == null || !(_aqVar instanceof _af)) {
            return;
        }
        ((_af) _aqVar).setAdvertColor(str);
    }

    @Override // com.fancy._gc
    public void setOnTouchAction(_ok _okVar) {
        View cView;
        super.setOnTouchAction(_okVar);
        if (_okVar == null || (cView = getCView()) == null) {
            return;
        }
        cView.setTag(R.id.fancy_native_view_tag, _okVar);
    }
}
