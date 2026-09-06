package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgSplashAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.mpsdk.component.widgets.PtgLogoView;
import com.fancy.mpsdk.widget.PtgRoundLinearLayout;
import com.fancy.mpsdk.widget.web.AdTemplateWebView;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _nx extends RelativeLayout implements _hl<_k> {
    public long _a;
    public long _b;
    public _an _c;
    public PtgLogoView _d;
    public TextView _e;
    public FrameLayout _f;
    public PtgRoundLinearLayout _g;
    public PtgAdNative.SplashAdListener _h;
    public PtgSplashAd.AdInteractionListener _i;
    public PtgVideoAdListener _j;
    public PtgAppDownloadListener _k;
    public String _l;
    public _f _m;
    public AdSlot _n;
    public AtomicBoolean _o;
    public boolean _p;
    public boolean _q;
    public volatile boolean _r;
    public volatile boolean _s;
    public volatile boolean _t;
    public _bu _u;
    public final _b _v;
    public final _c _w;
    public final _d _x;

    public class _a implements View.OnClickListener {
        public _a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (com.fancy.adsdk.lib.utils._a._f()) {
                return;
            }
            _nx _nxVar = _nx.this;
            ActionTrackManager._a()._a(_hr._a(_nx.this._m), (_nxVar._a - _nxVar._b) / 1000);
            PtgSplashAd.AdInteractionListener adInteractionListener = _nx.this._i;
            if (adInteractionListener != null) {
                adInteractionListener.onAdSkip();
            }
            PtgSplashAd.AdInteractionListener adInteractionListener2 = _nx.this._i;
            if (adInteractionListener2 != null) {
                adInteractionListener2.onDismiss(1);
            }
            _nx.this._a();
        }
    }

    public class _c implements PtgVideoAdListener {
        public _c() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
        public final void onVideoComplete() {
            PtgVideoAdListener ptgVideoAdListener = _nx.this._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoComplete();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
        public final void onVideoError(int i, String str) {
            PtgVideoAdListener ptgVideoAdListener = _nx.this._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoError(i, str);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
        public final void onVideoPause() {
            PtgVideoAdListener ptgVideoAdListener = _nx.this._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoPause();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
        public final void onVideoProgressUpdate(long j, long j2) {
            PtgVideoAdListener ptgVideoAdListener = _nx.this._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoProgressUpdate(j, j2);
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
        public final void onVideoResume() {
            PtgVideoAdListener ptgVideoAdListener = _nx.this._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoResume();
            }
        }

        @Override // com.fancy.adsdk.lib.interf.PtgVideoAdListener
        public final void onVideoStart() {
            PtgVideoAdListener ptgVideoAdListener = _nx.this._j;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoStart();
            }
        }
    }

    public class _d implements _h {
        public _d() {
        }
    }

    public class _e implements Runnable {
        public _e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            PtgSplashAd.AdInteractionListener adInteractionListener;
            _nx _nxVar = _nx.this;
            _n1._a(_nxVar, _nxVar._m);
            if (!_nx.this._o.compareAndSet(false, true) || (adInteractionListener = _nx.this._i) == null) {
                return;
            }
            adInteractionListener.onAdShow();
        }
    }

    public _nx(Context context) {
        super(context);
        this._a = 5000L;
        this._b = 5000L;
        this._o = new AtomicBoolean(false);
        this._p = true;
        this._q = false;
        this._v = new _b();
        this._w = new _c();
        this._x = new _d();
        _b();
    }

    public final void _a() {
        _an _anVar = this._c;
        if (_anVar != null) {
            _anVar._c();
        }
        _bu _buVar = this._u;
        if (_buVar != null && this._p) {
            if (_buVar._c) {
                _buVar._c = false;
                _buVar._d.removeMessages(1);
            }
            this._u._d.removeMessages(1);
        }
        _fn _fnVar = _fn._b;
        _fnVar.getClass();
        if (!TextUtil.isEmpty("splashAdDismiss")) {
            CopyOnWriteArrayList<_hl<_k>> copyOnWriteArrayList = _fnVar._a.get("splashAdDismiss");
            if (!TextUtil.isEmpty(copyOnWriteArrayList)) {
                copyOnWriteArrayList.remove(this);
            }
        }
        try {
            _ng._a(this._l);
        } catch (Exception unused) {
        }
        if (this._h != null) {
            this._h = null;
        }
        if (this._i != null) {
            this._i = null;
        }
        if (this._j != null) {
            this._j = null;
        }
        if (this._k != null) {
            this._k = null;
        }
    }

    public final void _b() {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View viewInflate = View.inflate(getContext(), R.layout.fancy_splash_view, this);
        this._d = (PtgLogoView) viewInflate.findViewById(R.id.ptg_ad_logo);
        this._g = (PtgRoundLinearLayout) viewInflate.findViewById(R.id.ptgSkipLayout);
        this._e = (TextView) viewInflate.findViewById(R.id.ptgSplashSec);
        this._f = (FrameLayout) viewInflate.findViewById(R.id.ptgSplashSkipFl);
        this._g.setOnClickListener(new _a());
    }

    public final void _c() {
        _bu _buVar;
        AdTemplateWebView adTemplateWebView;
        if (this._r && this._s && !this._t) {
            this._t = true;
            PtgLogoView ptgLogoView = this._d;
            if (ptgLogoView != null) {
                ptgLogoView.setVisibility(0);
            }
            if (this._q) {
                _an _anVar = this._c;
                if ((_anVar instanceof _o2) && (adTemplateWebView = ((_o2) _anVar)._g) != null) {
                    adTemplateWebView.post(new _2(adTemplateWebView, "startTime", null));
                }
            } else if (this._c != null && (_buVar = this._u) != null && this._p && !_buVar._c && _buVar._b == _buVar._a) {
                _buVar._c = true;
                _buVar._d.sendEmptyMessage(1);
            }
            _fn _fnVar = _fn._b;
            _fnVar.getClass();
            if (!TextUtil.isEmpty("splashAdDismiss")) {
                CopyOnWriteArrayList<_hl<_k>> copyOnWriteArrayList = _fnVar._a.get("splashAdDismiss");
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    _fnVar._a.put("splashAdDismiss", copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(this);
            }
            _fv._a.post(new _e());
        }
    }

    public PtgSplashAd.AdInteractionListener getAdInteractionListener() {
        return this._i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this._r = true;
        _c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this._r = false;
        _bu _buVar = this._u;
        if (_buVar != null && this._p) {
            if (_buVar._c) {
                _buVar._c = false;
                _buVar._d.removeMessages(1);
            }
            this._u._d.removeMessages(1);
        }
        _fn _fnVar = _fn._b;
        _fnVar.getClass();
        if (TextUtil.isEmpty("splashAdDismiss")) {
            return;
        }
        CopyOnWriteArrayList<_hl<_k>> copyOnWriteArrayList = _fnVar._a.get("splashAdDismiss");
        if (TextUtil.isEmpty(copyOnWriteArrayList)) {
            return;
        }
        copyOnWriteArrayList.remove(this);
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        _bu._a _aVar;
        super.onWindowFocusChanged(z);
        if (this._q) {
            _an _anVar = this._c;
            if (_anVar instanceof _o2) {
                _o2 _o2Var = (_o2) _anVar;
                if (z) {
                    AdTemplateWebView adTemplateWebView = _o2Var._g;
                    if (adTemplateWebView != null) {
                        adTemplateWebView.post(new _2(adTemplateWebView, "startTime", null));
                        return;
                    }
                    return;
                }
                AdTemplateWebView adTemplateWebView2 = _o2Var._g;
                if (adTemplateWebView2 != null) {
                    adTemplateWebView2.post(new _2(adTemplateWebView2, "stopTime", null));
                    return;
                }
                return;
            }
            return;
        }
        _bu _buVar = this._u;
        if (_buVar == null || !this._p) {
            return;
        }
        if (!z) {
            if (_buVar._c) {
                _buVar._c = false;
                _buVar._d.removeMessages(1);
                return;
            }
            return;
        }
        long j = _buVar._b;
        if (j > 0 && !_buVar._c) {
            _buVar._c = true;
            _buVar._d.sendEmptyMessage(1);
        } else {
            if (j != 0 || _buVar._c || (_aVar = _buVar._e) == null) {
                return;
            }
            ((_ny) _aVar)._a();
        }
    }

    public void setAdInteractionListener(PtgSplashAd.AdInteractionListener adInteractionListener) {
        this._i = adInteractionListener;
    }

    public void setAdListener(PtgAdNative.SplashAdListener splashAdListener) {
        this._h = splashAdListener;
    }

    public void setAdSlot(AdSlot adSlot) {
        this._n = adSlot;
        this._p = adSlot != null ? adSlot.isCountdownVisibility() : true;
    }

    public void setAdvertInfo(_f _fVar) {
        this._m = _fVar;
    }

    public void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener) {
        this._k = ptgAppDownloadListener;
    }

    @Override // android.view.View
    public final void setOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override // android.view.View
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
    }

    public void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._j = ptgVideoAdListener;
    }

    public class _b implements _v {
        public _b() {
        }

        @Override // com.fancy._v
        public final void _a(View view, int i, Exception exc) {
            _nx _nxVar = _nx.this;
            FrameLayout frameLayout = _nxVar._f;
            if (frameLayout != null) {
                frameLayout.setVisibility(_nxVar._p ? 0 : 8);
            }
            PtgSplashAd.AdInteractionListener adInteractionListener = _nx.this._i;
            if (adInteractionListener != null) {
                adInteractionListener.onRenderError(new AdErrorImpl(i, exc.getMessage(), (Object) null));
            }
        }

        @Override // com.fancy._v
        public final void _a() {
            _nx _nxVar = _nx.this;
            _f _fVar = _nxVar._m;
            if (_fVar != null) {
                _fVar._J = true;
            }
            if (_nxVar._i != null && !_nxVar._s) {
                _nx.this._i.onRenderSuccess();
            }
            _nx.this._s = true;
            _nx.this._c();
        }
    }

    @Override // com.fancy._hl
    public final void _a(_k _kVar) {
        _fv._a.post(new _nz(this, _kVar));
    }

    /* JADX WARN: Code duplicated, block: B:40:0x0078 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x0079  */
    /* JADX WARN: Code duplicated, block: B:44:0x0085  */
    /* JADX WARN: Code duplicated, block: B:46:0x0088  */
    /* JADX WARN: Code duplicated, block: B:48:0x0090  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:66:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:74:0x00fb  */
    public final void _a(_f _fVar, ViewGroup viewGroup, Activity activity) {
        ViewGroup.LayoutParams layoutParams;
        _b _bVar;
        Exception exc;
        Context context;
        FrameLayout frameLayout;
        long j_a;
        int i;
        PtgSplashAd.AdInteractionListener adInteractionListener;
        if (viewGroup == null) {
            return;
        }
        this._m = _fVar;
        if (_fVar != null) {
            this._l = String.valueOf(_fVar.hashCode());
            if (this._n == null) {
                _bVar = this._v;
                if (_bVar != null) {
                    exc = new Exception("adSlot is null.");
                    _bVar._a(this, PtgErrorCode.SDK_RENDER_ERROR, exc);
                }
            } else {
                layoutParams = getLayoutParams();
                if (layoutParams == null) {
                    _bVar = this._v;
                    if (_bVar != null) {
                        exc = new Exception("layoutParams is null.");
                        _bVar._a(this, PtgErrorCode.SDK_RENDER_ERROR, exc);
                    }
                } else {
                    ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                    if (layoutParams2 == null) {
                        _bVar = this._v;
                        if (_bVar != null) {
                            exc = new Exception("container layoutParams is null.");
                            _bVar._a(this, PtgErrorCode.SDK_RENDER_ERROR, exc);
                        }
                    } else {
                        try {
                            int i2 = layoutParams2.width;
                            if (i2 == 0) {
                                layoutParams.width = -1;
                            } else {
                                layoutParams.width = i2;
                            }
                            int i3 = layoutParams2.height;
                            if (i3 == 0) {
                                layoutParams.height = -1;
                            } else {
                                layoutParams.height = i3;
                            }
                        } catch (Exception e) {
                            _b _bVar2 = this._v;
                            if (_bVar2 != null) {
                                _bVar2._a(this, PtgErrorCode.SDK_RENDER_ERROR, e);
                            }
                            layoutParams = null;
                        }
                    }
                }
            }
            if (layoutParams == null) {
                return;
            }
            setLayoutParams(layoutParams);
            if (!(viewGroup.getContext() instanceof Activity)) {
                context = activity;
                context = viewGroup.getContext();
            } else if (activity == null) {
                if (getContext() instanceof Activity) {
                    context = getContext();
                } else {
                    context = activity;
                    context = viewGroup.getContext();
                }
            }
            if (com.fancy.adsdk.lib.utils._a._a(this._m, this._o) && (adInteractionListener = this._i) != null) {
                adInteractionListener.onAdShow();
            }
            if (_fVar._u()) {
                _ns _nsVar = new _ns(context);
                this._c = _nsVar;
                _nsVar.setVideoAdListener(this._w);
            } else if (TextUtil.isNotEmpty(_fVar._M)) {
                this._q = true;
                _o2 _o2Var = new _o2(context);
                this._c = _o2Var;
                _o2Var.setAdSlot(this._n);
            } else {
                this._c = new _nr(context);
            }
            if (!this._q) {
                frameLayout = this._f;
                if (frameLayout != null) {
                    if (this._p) {
                        i = 0;
                    } else {
                        i = 8;
                    }
                    frameLayout.setVisibility(i);
                }
                j_a = _io._a(_fVar, this._n);
                if (this._p) {
                    this._a = j_a;
                    this._b = j_a;
                    this._u = new _bu(j_a, new _ny(this));
                }
            }
            this._c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            this._c.setAdClickListener(this._x);
            this._c.setAdRenderListener(this._v);
            this._c.setAd(_fVar);
            addView(this._c, 0);
        }
        _b _bVar3 = this._v;
        if (_bVar3 != null) {
            _bVar3._a(this, PtgErrorCode.SDK_RENDER_ERROR, new Exception("ad is null."));
        }
        layoutParams = null;
        if (layoutParams == null) {
            return;
        }
        setLayoutParams(layoutParams);
        if (!(viewGroup.getContext() instanceof Activity)) {
            context = activity;
            context = viewGroup.getContext();
        } else if (activity == null) {
            if (getContext() instanceof Activity) {
                context = getContext();
            } else {
                context = activity;
                context = viewGroup.getContext();
            }
        }
        if (com.fancy.adsdk.lib.utils._a._a(this._m, this._o)) {
            adInteractionListener.onAdShow();
        }
        if (_fVar._u()) {
            _ns _nsVar2 = new _ns(context);
            this._c = _nsVar2;
            _nsVar2.setVideoAdListener(this._w);
        } else if (TextUtil.isNotEmpty(_fVar._M)) {
            this._q = true;
            _o2 _o2Var2 = new _o2(context);
            this._c = _o2Var2;
            _o2Var2.setAdSlot(this._n);
        } else {
            this._c = new _nr(context);
        }
        if (!this._q) {
            frameLayout = this._f;
            if (frameLayout != null) {
                if (this._p) {
                    i = 0;
                } else {
                    i = 8;
                }
                frameLayout.setVisibility(i);
            }
            j_a = _io._a(_fVar, this._n);
            if (this._p) {
                this._a = j_a;
                this._b = j_a;
                this._u = new _bu(j_a, new _ny(this));
            }
        }
        this._c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this._c.setAdClickListener(this._x);
        this._c.setAdRenderListener(this._v);
        this._c.setAd(_fVar);
        addView(this._c, 0);
    }
}
