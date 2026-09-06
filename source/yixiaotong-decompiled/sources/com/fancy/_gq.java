package com.fancy;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gq {
    public final Context _a;
    public final AdSlot _b;
    public final _f _c;
    public final String _d;
    public PtgNativeExpressAd.AdInteractionListener _e;
    public boolean _f;
    public ViewGroup _g;
    public List<View> _h;
    public _i _i;
    public boolean _j;
    public boolean _k;
    public boolean _l;
    public boolean _m;
    public boolean _n;
    public int _o;
    public boolean _p;
    public long _q;
    public boolean _r = true;
    public final AtomicBoolean _s = new AtomicBoolean(false);
    public final AtomicBoolean _t = new AtomicBoolean(false);
    public final AtomicBoolean _u = new AtomicBoolean(false);
    public final AtomicBoolean _v = new AtomicBoolean(false);
    public final Handler _w = new Handler(Looper.getMainLooper());
    public final _a _x = new _a();
    public final _b _y = new _b();
    public final _c _z = new _c();
    public final AtomicBoolean _A = new AtomicBoolean(false);

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                _gq _gqVar = _gq.this;
                List<View> list = _gqVar._h;
                View view = (list == null || list.isEmpty()) ? null : _gqVar._h.get(0);
                if (view != null && view.hasWindowFocus() && _gq.this._a()) {
                    _gq.this._s.set(true);
                    _p5._a(view, 6);
                }
            } catch (Exception unused) {
            }
        }
    }

    public class _b implements View.OnTouchListener {
        public _b() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            _gq.this._z.onTouch(view, motionEvent);
            return false;
        }
    }

    public class _c implements View.OnTouchListener {
        public long _a = 0;
        public long _b = 0;
        public int _c;
        public int _d;
        public int _e;
        public int _f;
        public int _g;
        public int _h;
        public int _i;
        public int _j;

        public class _a implements Runnable {
            public final /* synthetic */ View _a;

            public _a(View view) {
                this._a = view;
            }

            @Override // java.lang.Runnable
            public final void run() {
                View view = this._a;
                if (view != null) {
                    _gq.this._a(view);
                }
            }
        }

        public _c() {
        }

        /* JADX WARN: Code duplicated, block: B:18:0x008a  */
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            _gq _gqVar = _gq.this;
            if (_gqVar._g == null || _gq._a(_gqVar, view)) {
                return true;
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 && _gq._a(_gq.this, view, motionEvent)) {
                    this._b = System.currentTimeMillis();
                    this._e = (int) motionEvent.getRawX();
                    this._f = (int) motionEvent.getRawY();
                    int[] iArr = new int[2];
                    _gq.this._g.getLocationOnScreen(iArr);
                    this._i = this._e - iArr[0];
                    this._j = this._f - iArr[1];
                    Object tag = view.getTag(R.id.fancy_native_view_tag);
                    if (tag instanceof _ok) {
                        _ok _okVar = (_ok) tag;
                        if (_okVar._k > 0) {
                            _gq.this._t.set(true);
                            _ok _okVar2 = new _ok(this._g, this._h, this._a);
                            _okVar2._f = this._b;
                            _okVar2._d = this._i;
                            _okVar2._e = this._j;
                            _okVar2._k = _okVar._k;
                            view.setTag(R.id.fancy_native_view_tag, _okVar2);
                            _gq.this._a(view);
                        } else {
                            _gq.this._t.set(true);
                            _ok _okVar3 = new _ok(this._g, this._h, this._a);
                            _okVar3._f = this._b;
                            _okVar3._d = this._i;
                            _okVar3._e = this._j;
                            _okVar3._k = 0;
                            view.setTag(R.id.fancy_native_view_tag, _okVar3);
                            _gq.this._a(view);
                        }
                    } else {
                        _gq.this._t.set(true);
                        _ok _okVar4 = new _ok(this._g, this._h, this._a);
                        _okVar4._f = this._b;
                        _okVar4._d = this._i;
                        _okVar4._e = this._j;
                        _okVar4._k = 0;
                        view.setTag(R.id.fancy_native_view_tag, _okVar4);
                        _gq.this._a(view);
                    }
                }
                return true;
            }
            if (_gq._a(_gq.this, view, motionEvent)) {
                this._a = System.currentTimeMillis();
                this._c = (int) motionEvent.getRawX();
                this._d = (int) motionEvent.getRawY();
                int[] iArr2 = new int[2];
                _gq.this._g.getLocationOnScreen(iArr2);
                this._g = this._c - iArr2[0];
                this._h = this._d - iArr2[1];
                _gq _gqVar2 = _gq.this;
                if (_gqVar2._j && !_gqVar2._t.get() && _gqVar2._p && _io._a(_gqVar2._d) && !_gq.this._a()) {
                    _gq.this.getClass();
                    if (_p5._a(view) != 6) {
                        _gq.this._t.set(true);
                        _gq _gqVar3 = _gq.this;
                        int i = this._g;
                        int i2 = this._h;
                        _gqVar3.getClass();
                        _ok _okVar5 = new _ok(i, i2, System.currentTimeMillis());
                        _okVar5._k = 2;
                        _gq.this.getClass();
                        long jNextInt = com.fancy.adsdk.lib.utils._a._d.nextInt(31) + 50;
                        int i3 = _okVar5._g;
                        if (i3 <= 0 && (i3 = _okVar5._a) == 0) {
                            i3 = -999;
                        }
                        _okVar5._d = i3;
                        int i4 = _okVar5._h;
                        _okVar5._e = (i4 > 0 || (i4 = _okVar5._b) != 0) ? i4 : -999;
                        _okVar5._f = _okVar5._c + jNextInt;
                        view.setTag(R.id.fancy_native_view_tag, _okVar5);
                        view.postDelayed(new _a(view), jNextInt);
                    }
                }
            }
            return true;
        }
    }

    public _gq(Context context, _f _fVar, AdSlot adSlot) {
        this._a = context;
        this._b = adSlot;
        this._c = _fVar;
        this._d = _fVar._a();
        _b();
    }

    public static boolean _a(_gq _gqVar, View view) {
        boolean z = false;
        if (view == null) {
            _gqVar.getClass();
            return false;
        }
        ViewGroup viewGroup = _gqVar._g;
        if (viewGroup == null || view != viewGroup || _gqVar._r) {
            return false;
        }
        if (_gqVar._j && !_gqVar._t.get() && _gqVar._p && _io._a(_gqVar._d)) {
            z = true;
        }
        return !z;
    }

    public final void _b(View view, int i, _oj _ojVar, PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        ViewGroup viewGroup;
        _a _aVar;
        if (_io._a(this._d)) {
            Handler handler = this._w;
            if (handler != null && (_aVar = this._x) != null) {
                handler.removeCallbacks(_aVar);
            }
            _io._b(this._d);
            _ng._a(this._d);
        }
        _de._a(this._c);
        _kr._a(this._j, this._n);
        this._j = false;
        this._n = false;
        this._k = false;
        this._m = false;
        this._p = false;
        this._t.set(true);
        this._s.set(true);
        this._u.set(true);
        if (!this._r && (viewGroup = this._g) != null) {
            viewGroup.setOnTouchListener(null);
        }
        _a(view, i, _ojVar, adInteractionListener);
        List<View> list = this._h;
        if (list != null) {
            for (View view2 : list) {
                view2.setTag(R.id.fancy_native_view_tag, new _ok(view2));
            }
        }
    }

    public final void _c() {
        List<View> list;
        ViewGroup viewGroup = this._g;
        this._r = (viewGroup == null || (list = this._h) == null || !list.contains(viewGroup)) ? false : true;
        ViewGroup viewGroup2 = this._g;
        if (viewGroup2 != null && (this._m || this._p)) {
            viewGroup2.setEnabled(true);
            this._g.setClickable(true);
            this._g.setOnTouchListener(this._y);
        }
        List<View> list2 = this._h;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        for (View view : this._h) {
            view.setTag(R.id.fancy_native_view_tag, new _ok(view));
            view.setEnabled(true);
            view.setClickable(true);
            view.setOnTouchListener(this._y);
        }
    }

    public final boolean _d() {
        return this._j && !this._u.get() && (this._k || this._n) && _io._a(this._d);
    }

    public static boolean _a(_gq _gqVar, View view, MotionEvent motionEvent) {
        _gqVar.getClass();
        if (motionEvent.getX() >= 0.0f && motionEvent.getX() <= view.getWidth() && motionEvent.getY() >= 0.0f && motionEvent.getY() <= view.getHeight()) {
            return true;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (motionEvent.getX() >= iArr[0]) {
            if (motionEvent.getX() <= view.getWidth() + iArr[0] && motionEvent.getY() >= iArr[1]) {
                if (motionEvent.getY() <= view.getHeight() + iArr[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void _a(View view) {
        int i_a = _p5._a(view);
        if (i_a == 0 || i_a == 1) {
            _a(view, 0, null, this._e);
        } else {
            _b(view, _p5._a(view), null, this._e);
        }
    }

    public final void _a(View view, int i, _oj _ojVar, PtgNativeExpressAd.AdInteractionListener adInteractionListener) {
        ViewGroup viewGroup;
        if (com.fancy.adsdk.lib.utils._a._f() || this._b == null || this._c == null || view == null) {
            return;
        }
        this._j = false;
        this._n = false;
        this._k = false;
        this._m = false;
        this._p = false;
        this._t.set(true);
        this._s.set(true);
        this._u.set(true);
        if (!this._r && (viewGroup = this._g) != null) {
            viewGroup.setOnTouchListener(null);
        }
        this._f = true;
        this._b._e(i);
        _f _fVar = this._c;
        _fVar._v = _ojVar;
        boolean z_r = _fVar._r();
        _f _fVar2 = this._c;
        if (z_r) {
            i = 0;
        }
        _n1._a(view, _fVar2, i);
        if (this._c._A && adInteractionListener != null) {
            adInteractionListener.onAdClicked();
        }
        _b3._a(view.getContext(), this._c, this._b);
    }

    public final void _b() {
        List<Integer> list;
        _f _fVar = this._c;
        if (_fVar == null) {
            return;
        }
        _i _iVar = _fVar._s;
        this._i = _iVar;
        if (_iVar == null) {
            return;
        }
        boolean z_d = _iVar._d();
        this._j = z_d;
        this._k = this._i._b(z_d);
        List<Integer> list2 = this._i._g;
        this._l = list2 != null && list2.contains(5);
        this._i.getClass();
        this._m = this._i._d(this._j);
        this._n = this._i._c(this._j);
        _i _iVar2 = this._i;
        this._o = _iVar2._j;
        this._p = this._j && (list = _iVar2._g) != null && list.contains(4);
    }

    public final boolean _a() {
        return this._j && !this._s.get() && this._n && _io._a(this._d);
    }

    public final void _a(Context context, boolean z) {
        if (_d()) {
            ConcurrentHashMap<String, Long> concurrentHashMap = _io._a;
            if (!(!concurrentHashMap.isEmpty())) {
                String str = this._d;
                if (!TextUtils.isEmpty(str)) {
                    concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
                }
            }
            _nf _nfVar_a = _nf._a(this._d, z, this._i);
            this._A.set(true);
            _ng._a(context, new _gr(this, _nfVar_a, true), _nfVar_a);
            return;
        }
        if (this._l) {
            _i _iVar = this._i;
            if (_iVar == null || _iVar._n || !this._v.get()) {
                _i _iVar2 = this._i;
                if ((_iVar2 == null || !_iVar2._n) && !(!this._f)) {
                    return;
                }
                _nf _nfVar_a2 = _nf._a(this._d, this._i);
                this._A.set(true);
                _ng._a(context, new _gr(this, _nfVar_a2, false), _nfVar_a2);
                return;
            }
            return;
        }
        _io._b(this._d);
        _ng._a(this._d);
    }
}
