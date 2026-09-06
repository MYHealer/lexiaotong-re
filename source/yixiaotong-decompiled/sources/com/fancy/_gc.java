package com.fancy;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _gc extends FrameLayout {
    public final AtomicBoolean _A;
    public final AtomicBoolean _B;
    public float _C;
    public float _D;
    public _ok _E;
    public final _c _F;
    public final _d _G;
    public final _e _H;
    public final _f _I;
    public PtgNativeExpressAd.AdInteractionListener _a;
    public PtgVideoAdListener _b;
    public com.fancy._f _c;
    public AdSlot _d;
    public String _e;
    public _i _f;
    public boolean _g;
    public boolean _h;
    public boolean _i;
    public boolean _j;
    public int _k;
    public boolean _l;
    public boolean _m;
    public boolean _n;
    public boolean _o;
    public boolean _p;
    public final AtomicBoolean _q;
    public final AtomicBoolean _r;
    public long _s;
    public _ga _t;
    public boolean _u;
    public final AtomicBoolean _v;
    public final AtomicBoolean _w;
    public final AtomicBoolean _x;
    public final Handler _y;
    public final _a _z;

    public class _a implements Runnable {
        public final /* synthetic */ _gc _a;

        public _a(_do _doVar) {
            this._a = _doVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view;
            if (this._a._a(true)) {
                this._a._x.set(true);
                List<View> advertViews = this._a.getAdvertViews();
                if (advertViews == null || advertViews.isEmpty() || (view = advertViews.get(0)) == null || !view.hasWindowFocus()) {
                    return;
                }
                _p5._a(view, 6);
            }
        }
    }

    public class _b implements Runnable {
        public _b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            _gc _gcVar = _gc.this;
            _gcVar._b(_gcVar.getCView(), 2, null);
        }
    }

    public class _c implements MediaPlayer.OnCompletionListener {
        public final /* synthetic */ _gc _a;

        public _c(_do _doVar) {
            this._a = _doVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoComplete();
            }
        }
    }

    public class _d implements NiceVideoPlayer._i {
        public final /* synthetic */ _gc _a;

        public _d(_do _doVar) {
            this._a = _doVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener == null) {
                return false;
            }
            ptgVideoAdListener.onVideoError(i, String.valueOf(i2));
            return false;
        }

        @Override // com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer._i
        public final void onTimeout() {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoError(PtgErrorCode.SDK_VIDEO_PLAY_ERROR, "Video Play Timeout!");
            }
        }
    }

    public class _e implements _l4._b {
        public final /* synthetic */ _gc _a;

        public _e(_do _doVar) {
            this._a = _doVar;
        }

        @Override // com.fancy._l4._b
        public final void _a(long j, long j2) {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoProgressUpdate(j, j2);
            }
        }
    }

    public class _f implements _l7 {
        public final /* synthetic */ _gc _a;

        public _f(_do _doVar) {
            this._a = _doVar;
        }

        @Override // com.fancy._l7
        public final void onVideoPause() {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoPause();
            }
        }

        @Override // com.fancy._l7
        public final void onVideoResume() {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoResume();
            }
        }

        @Override // com.fancy._l7
        public final void onVideoStart() {
            PtgVideoAdListener ptgVideoAdListener = this._a._b;
            if (ptgVideoAdListener != null) {
                ptgVideoAdListener.onVideoStart();
            }
        }
    }

    public _gc(Context context) {
        super(context);
        this._q = new AtomicBoolean(false);
        this._r = new AtomicBoolean(false);
        this._v = new AtomicBoolean(true);
        this._w = new AtomicBoolean();
        this._x = new AtomicBoolean(false);
        this._y = new Handler(Looper.getMainLooper());
        _do _doVar = (_do) this;
        this._z = new _a(_doVar);
        this._A = new AtomicBoolean();
        this._B = new AtomicBoolean(false);
        this._F = new _c(_doVar);
        this._G = new _d(_doVar);
        this._H = new _e(_doVar);
        this._I = new _f(_doVar);
        _d();
    }

    private View getRealRootView() {
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:42:0x00be  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:44:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:56:0x0109  */
    /* JADX WARN: Code duplicated, block: B:73:0x012d  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    public final void _a() {
        com.fancy._f _fVar;
        boolean z;
        View shakeLayout;
        _i _iVar;
        _i _iVar2;
        View realRootView;
        List<Integer> list;
        this._s = System.currentTimeMillis();
        ConcurrentHashMap<String, Long> concurrentHashMap = _io._a;
        if ((!concurrentHashMap.isEmpty()) || (_fVar = this._c) == null) {
            return;
        }
        _i _iVar3 = _fVar._s;
        this._f = _iVar3;
        if (_iVar3 == null) {
            return;
        }
        String str = this._e;
        if (!TextUtils.isEmpty(str)) {
            concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
        }
        this._g = this._f._d();
        this._i = this._f._c();
        List<Integer> list2 = this._f._g;
        int i = 0;
        this._o = list2 != null && list2.contains(5);
        this._h = this._f._b(this._g);
        this._j = this._f._c(this._g);
        _i _iVar4 = this._f;
        this._k = _iVar4._j;
        this._l = this._g && (list = _iVar4._g) != null && list.contains(3);
        _i _iVar5 = this._f;
        if (this._g) {
            List<Integer> list3 = _iVar5._g;
            if (list3 != null && list3.contains(4)) {
                z = true;
            }
            this._m = z;
            this._n = this._f._d(this._g);
            if (_a(true)) {
                _a(this._f, false);
            } else if (1 == this._k) {
                _a(this._f, true);
            } else {
                long j_a = this._f._a();
                this._y.removeCallbacks(this._z);
                this._y.postDelayed(this._z, j_a);
            }
            if (!this._w.get() && this._n && _io._a(this._e) && (realRootView = getRealRootView()) != null) {
                realRootView.setOnClickListener(new _gb((_do) this));
            }
            shakeLayout = getShakeLayout();
            if (shakeLayout != null) {
                if (this._i || (((_iVar = this._f) != null && !_iVar._n && this._q.get()) || (((_iVar2 = this._f) == null || !_iVar2._n) && !(true ^ this._p)))) {
                    i = 8;
                }
                shakeLayout.setVisibility(i);
            }
        }
        _iVar5.getClass();
        z = false;
        this._m = z;
        this._n = this._f._d(this._g);
        if (_a(true)) {
            _a(this._f, false);
        } else if (1 == this._k) {
            _a(this._f, true);
        } else {
            long j_a2 = this._f._a();
            this._y.removeCallbacks(this._z);
            this._y.postDelayed(this._z, j_a2);
        }
        if (!this._w.get()) {
            realRootView.setOnClickListener(new _gb((_do) this));
        }
        shakeLayout = getShakeLayout();
        if (shakeLayout != null) {
            if (this._i) {
                i = 8;
            } else {
                i = 8;
            }
            shakeLayout.setVisibility(i);
        }
    }

    public void _a(View view, int i, _oj _ojVar) {
    }

    public final boolean _a(boolean z) {
        if (z) {
            return this._g && !this._x.get() && this._j && _io._a(this._e);
        }
        return this._g && !this._x.get() && this._j;
    }

    public void _b(View view, int i, _oj _ojVar) {
        _ga _gaVar;
        _a _aVar;
        Handler handler = this._y;
        if (handler != null && (_aVar = this._z) != null) {
            handler.removeCallbacks(_aVar);
        }
        _io._b(this._e);
        _ng._a(this._e);
        _de._a(this._c);
        _kr._a(this._g, this._j);
        this._g = false;
        this._h = false;
        this._j = false;
        this._l = false;
        this._m = false;
        this._n = false;
        try {
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver == null || !viewTreeObserver.isAlive() || (_gaVar = this._t) == null) {
                return;
            }
            viewTreeObserver.removeOnScrollChangedListener(_gaVar);
        } catch (Exception unused) {
        }
    }

    public final boolean _b() {
        List<View> advertViews;
        boolean zHasWindowFocus = hasWindowFocus();
        if (zHasWindowFocus || (advertViews = getAdvertViews()) == null || advertViews.isEmpty()) {
            return zHasWindowFocus;
        }
        for (View view : advertViews) {
            if (view != null && view.hasWindowFocus()) {
                return true;
            }
        }
        return zHasWindowFocus;
    }

    public final boolean _b(boolean z) {
        if (z) {
            return (this._h || this._j) && this._r.get() && !this._A.get() && _io._a(this._e);
        }
        return (this._h || this._j) && this._r.get() && !this._A.get();
    }

    public final boolean _c() {
        boolean z = this._g && this._r.get() && !this._B.get() && (this._l || this._m) && _io._a(this._e);
        AdSlot adSlot = this._d;
        if (adSlot != null && adSlot._w() == 8 && this._d.isSelfRender() && this._d._n() == 1) {
            return z && this._n;
        }
        return z;
    }

    public void _d() {
        setBackgroundColor(-1);
    }

    public abstract List<View> getAdvertViews();

    public View getCView() {
        List<View> advertViews = getAdvertViews();
        return (advertViews == null || advertViews.isEmpty()) ? this : advertViews.get(0);
    }

    public abstract View getShakeLayout();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this._r.set(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        _a _aVar;
        super.onDetachedFromWindow();
        this._r.set(false);
        Handler handler = this._y;
        if (handler != null && (_aVar = this._z) != null) {
            handler.removeCallbacks(_aVar);
        }
        _io._b(this._e);
        _ng._a(this._e);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        long jNextInt;
        if (_c()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                int rawX = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this._E = new _ok(rawX - iArr[0], rawY - iArr[1], System.currentTimeMillis());
                this._C = motionEvent.getRawX();
                float rawY2 = motionEvent.getRawY();
                this._D = rawY2;
                if (this._m) {
                    if (_a((int) this._C, (int) rawY2)) {
                        return false;
                    }
                    this._B.set(true);
                    _ok _okVar = this._E;
                    if (_okVar != null) {
                        jNextInt = com.fancy.adsdk.lib.utils._a._d.nextInt(31) + 50;
                        int i = _okVar._g;
                        if (i <= 0 && (i = _okVar._a) == 0) {
                            i = -999;
                        }
                        _okVar._d = i;
                        int i2 = _okVar._h;
                        _okVar._e = (i2 > 0 || (i2 = _okVar._b) != 0) ? i2 : -999;
                        _okVar._f = _okVar._c + jNextInt;
                    } else {
                        jNextInt = 0;
                    }
                    setOnTouchAction(this._E);
                    _fv._a.postDelayed(new _b(), jNextInt);
                    return true;
                }
            } else if (action == 3 && this._l) {
                int iAbs = (int) Math.abs(motionEvent.getRawX() - this._C);
                int iAbs2 = (int) Math.abs(motionEvent.getRawY() - this._D);
                if (iAbs > 35 || iAbs2 > 35) {
                    if (_a(iAbs, iAbs2)) {
                        return false;
                    }
                    this._B.set(true);
                    _ok _okVar2 = this._E;
                    if (_okVar2 != null) {
                        long jNextInt2 = com.fancy.adsdk.lib.utils._a._d.nextInt(31) + 50;
                        int i3 = _okVar2._g;
                        if (i3 <= 0 && (i3 = _okVar2._a) == 0) {
                            i3 = -999;
                        }
                        _okVar2._d = i3;
                        int i4 = _okVar2._h;
                        _okVar2._e = (i4 > 0 || (i4 = _okVar2._b) != 0) ? i4 : -999;
                        _okVar2._f = _okVar2._c + jNextInt2;
                    }
                    setOnTouchAction(this._E);
                    _b(getCView(), 3, null);
                    return true;
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this._u = i == 0;
        _a(i);
    }

    public void setAdvertInfo(com.fancy._f _fVar) {
        this._c = _fVar;
        if (_fVar != null) {
            this._e = String.valueOf(_fVar.hashCode()) + hashCode();
        }
    }

    public void setAdvertSlot(AdSlot adSlot) {
        this._d = adSlot;
    }

    public void setExpressInteractionListener(PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        this._a = adInteractionListener;
    }

    public void setOnTouchAction(_ok _okVar) {
    }

    public void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._b = ptgVideoAdListener;
    }

    public final boolean _a(int i, int i2) {
        try {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt instanceof _aq) {
                    _aq _aqVar = (_aq) childAt;
                    _aqVar.getClass();
                    try {
                        View view = _aqVar._d;
                        if (view != null) {
                            int[] iArr = new int[2];
                            view.getLocationOnScreen(iArr);
                            int i3 = iArr[0];
                            int i4 = iArr[1];
                            int width = _aqVar._d.getWidth() + i3;
                            int height = _aqVar._d.getHeight() + i4;
                            if (i >= i3 && i <= width && i2 >= i4 && i2 <= height) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception unused) {
                        continue;
                    }
                }
            }
        } catch (Exception unused2) {
        }
        return false;
    }

    public final void _a(int i) {
        _i _iVar;
        _i _iVar2;
        try {
            View shakeLayout = getShakeLayout();
            if (shakeLayout != null) {
                if (!this._i || (!((_iVar = this._f) == null || _iVar._n || !this._q.get()) || (((_iVar2 = this._f) == null || !_iVar2._n) && !(!this._p)))) {
                    shakeLayout.setVisibility(8);
                } else {
                    shakeLayout.setVisibility(0);
                }
            }
            if (this._v.get()) {
                this._v.set(false);
                return;
            }
            if (i != 0) {
                _io._b(this._e);
                _ng._a(this._e);
                return;
            }
            if (_a(false) || _b(false)) {
                ConcurrentHashMap<String, Long> concurrentHashMap = _io._a;
                if (!(!concurrentHashMap.isEmpty())) {
                    String str = this._e;
                    if (!TextUtils.isEmpty(str)) {
                        concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
                    }
                }
            }
            if (!_a(true)) {
                _a(this._f, false);
            } else if (1 == this._k) {
                _a(this._f, true);
            }
        } catch (Exception unused) {
        }
    }

    public final void _a(_i _iVar, boolean z) {
        if (_b(true)) {
            try {
                ViewTreeObserver viewTreeObserver = getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    if (this._t == null) {
                        this._t = new _ga(this);
                    }
                    viewTreeObserver.removeOnScrollChangedListener(this._t);
                    viewTreeObserver.addOnScrollChangedListener(this._t);
                }
            } catch (Exception unused) {
            }
            _nf _nfVar_a = _nf._a(this._e, z, _iVar);
            _ng._a(getContext(), new _gd(this, _nfVar_a), _nfVar_a);
            return;
        }
        if (this._o) {
            try {
                ViewTreeObserver viewTreeObserver2 = getViewTreeObserver();
                if (viewTreeObserver2 != null && viewTreeObserver2.isAlive()) {
                    if (this._t == null) {
                        this._t = new _ga(this);
                    }
                    viewTreeObserver2.removeOnScrollChangedListener(this._t);
                    viewTreeObserver2.addOnScrollChangedListener(this._t);
                }
            } catch (Exception unused2) {
            }
            _i _iVar2 = this._f;
            if (_iVar2 == null || _iVar2._n || !this._q.get()) {
                _i _iVar3 = this._f;
                if ((_iVar3 == null || !_iVar3._n) && !(!this._p)) {
                    return;
                }
                _nf _nfVar_a2 = _nf._a(this._e, _iVar);
                _ng._a(getContext(), new _gd(this, _nfVar_a2), _nfVar_a2);
                return;
            }
            return;
        }
        _ng._a(this._e);
    }
}
