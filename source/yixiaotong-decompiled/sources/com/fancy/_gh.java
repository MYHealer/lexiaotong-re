package com.fancy;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gh implements _en {
    public final AtomicBoolean _a = new AtomicBoolean(false);
    public final AtomicBoolean _b = new AtomicBoolean(false);
    public _f _c;
    public ViewGroup _d;
    public Boolean _e;
    public boolean _f;
    public PtgNativeExpressAd.AdInteractionListener _g;
    public _a _h;
    public _b _i;
    public _c _j;
    public _d _k;
    public _g9 _l;
    public AtomicBoolean _m;

    public class _a implements View.OnAttachStateChangeListener {
        public _a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            if (_gh.this._b.get()) {
                return;
            }
            _gh _ghVar = _gh.this;
            if (_ghVar._b(_ghVar._d)) {
                _gh.this._b.set(true);
                _gh _ghVar2 = _gh.this;
                _ghVar2.getClass();
                _fv._a.post(new _gg(_ghVar2));
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    public class _b implements ViewTreeObserver.OnGlobalLayoutListener {
        public final /* synthetic */ ViewTreeObserver _a;

        public _b(ViewTreeObserver viewTreeObserver) {
            this._a = viewTreeObserver;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (_gh.this._b.get()) {
                ViewTreeObserver viewTreeObserver = this._a;
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _gh _ghVar = _gh.this;
                _ghVar._e = _ks._a(_ghVar._d);
                return;
            }
            _gh _ghVar2 = _gh.this;
            if (_ghVar2._b(_ghVar2._d)) {
                ViewTreeObserver viewTreeObserver2 = this._a;
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    this._a.removeOnGlobalLayoutListener(this);
                }
                _gh _ghVar3 = _gh.this;
                _ghVar3._e = _ks._a(_ghVar3._d);
                if (_gh.this._b.get()) {
                    return;
                }
                _gh _ghVar4 = _gh.this;
                if (_ghVar4._b(_ghVar4._d)) {
                    _gh.this._b.set(true);
                    _gh _ghVar5 = _gh.this;
                    _ghVar5.getClass();
                    _fv._a.post(new _gg(_ghVar5));
                }
            }
        }
    }

    public class _c implements ViewTreeObserver.OnScrollChangedListener {
        public long _a = 0;

        public _c() {
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0052 A[PHI: r1
  0x0052: PHI (r1v6 com.fancy._gh) = (r1v5 com.fancy._gh), (r1v12 com.fancy._gh) binds: [B:21:0x0050, B:16:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:23:0x0059  */
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            Boolean bool;
            _gh _ghVar;
            int windowVisibility;
            if (System.currentTimeMillis() - this._a < 200) {
                return;
            }
            this._a = System.currentTimeMillis();
            _gh _ghVar2 = _gh.this;
            if (_ghVar2._d != null && _ghVar2._l != null && (bool = _ghVar2._e) != null) {
                if (bool.booleanValue()) {
                    boolean globalVisibleRect = _gh.this._d.getGlobalVisibleRect(new Rect());
                    _ghVar = _gh.this;
                    if (_ghVar._f != globalVisibleRect) {
                        _ghVar._f = globalVisibleRect;
                        if (globalVisibleRect) {
                            windowVisibility = _ghVar._d.getWindowVisibility();
                        } else {
                            windowVisibility = 8;
                        }
                        ((_dj) _gh.this._l)._a(windowVisibility);
                    }
                } else {
                    boolean zHasWindowFocus = _gh.this._d.hasWindowFocus();
                    _ghVar = _gh.this;
                    if (_ghVar._f != zHasWindowFocus) {
                        _ghVar._f = zHasWindowFocus;
                        if (zHasWindowFocus) {
                            windowVisibility = _ghVar._d.getWindowVisibility();
                        } else {
                            windowVisibility = 8;
                        }
                        ((_dj) _gh.this._l)._a(windowVisibility);
                    }
                }
            }
            if (_gh.this._b.get()) {
                return;
            }
            _gh _ghVar3 = _gh.this;
            if (_ghVar3._b(_ghVar3._d)) {
                _gh.this._b.set(true);
                _gh _ghVar4 = _gh.this;
                _ghVar4.getClass();
                _fv._a.post(new _gg(_ghVar4));
            }
        }
    }

    public class _d implements ViewTreeObserver.OnWindowFocusChangeListener {
        public _d() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean z) {
            if (_gh.this._a.get()) {
                _gh _ghVar = _gh.this;
                _ghVar._f = z;
                ViewGroup viewGroup = _ghVar._d;
                if (viewGroup == null || _ghVar._l == null) {
                    return;
                }
                ((_dj) _gh.this._l)._a(z ? viewGroup.getWindowVisibility() : 8);
            }
        }
    }

    @Override // com.fancy._en
    public final void _a() {
        try {
            ViewGroup viewGroup = this._d;
            if (viewGroup != null) {
                _a _aVar = this._h;
                if (_aVar != null) {
                    try {
                        viewGroup.removeOnAttachStateChangeListener(_aVar);
                    } catch (Exception unused) {
                    }
                }
                try {
                    ViewTreeObserver viewTreeObserver = this._d.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        _b _bVar = this._i;
                        if (_bVar != null) {
                            viewTreeObserver.removeOnGlobalLayoutListener(_bVar);
                        }
                        _c _cVar = this._j;
                        if (_cVar != null) {
                            viewTreeObserver.removeOnScrollChangedListener(_cVar);
                        }
                        _d _dVar = this._k;
                        if (_dVar != null) {
                            viewTreeObserver.removeOnWindowFocusChangeListener(_dVar);
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
    public final void _a(Context context, _f _fVar, AtomicBoolean atomicBoolean) {
        this._c = _fVar;
        this._m = atomicBoolean;
    }

    @Override // com.fancy._en
    public final void _a(ViewGroup viewGroup) {
        this._d = viewGroup;
    }

    @Override // com.fancy._en
    public final void _a(_dj _djVar) {
        this._l = _djVar;
    }

    @Override // com.fancy._en
    public final void _a(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        this._g = adInteractionListener;
    }

    public final boolean _b(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return false;
        }
        _f _fVar = this._c;
        return viewGroup.getWindowVisibility() == 0 && _m5._a(viewGroup, _fVar != null ? _fVar._U : 0.1f);
    }

    @Override // com.fancy._en
    public final View _c() {
        return null;
    }

    @Override // com.fancy._en
    public final PtgNativeExpressAd.CustomizeVideo getCustomizeVideo() {
        return null;
    }

    @Override // com.fancy._en
    public final void pauseVideo() {
    }

    @Override // com.fancy._en
    public final void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
    }

    @Override // com.fancy._en
    public final void startVideo() {
    }

    @Override // com.fancy._en
    public final void _b() {
        ViewTreeObserver viewTreeObserver;
        _f _fVar = this._c;
        if (_fVar == null || _fVar._t()) {
            if (!this._a.get()) {
                this._a.set(true);
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = this._g;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderSuccess(this._d);
                }
            }
            if (!this._b.get() && _b(this._d)) {
                this._b.set(true);
                _fv._a.post(new _gg(this));
            }
            if (this._b.get()) {
                return;
            }
            if (this._h == null) {
                this._h = new _a();
            }
            this._d.removeOnAttachStateChangeListener(this._h);
            this._d.addOnAttachStateChangeListener(this._h);
            if (_b(this._d) || (viewTreeObserver = this._d.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
                return;
            }
            if (this._i == null) {
                this._i = new _b(viewTreeObserver);
            }
            viewTreeObserver.removeOnGlobalLayoutListener(this._i);
            viewTreeObserver.addOnGlobalLayoutListener(this._i);
            if (this._j == null) {
                this._j = new _c();
            }
            viewTreeObserver.removeOnScrollChangedListener(this._j);
            viewTreeObserver.addOnScrollChangedListener(this._j);
            if (this._k == null) {
                this._k = new _d();
            }
            viewTreeObserver.removeOnWindowFocusChangeListener(this._k);
            viewTreeObserver.addOnWindowFocusChangeListener(this._k);
        }
    }
}
