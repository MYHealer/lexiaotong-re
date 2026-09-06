package com.fancy;

import android.graphics.Rect;
import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lh {
    public static final ConcurrentHashMap _p = new ConcurrentHashMap();
    public final PtgVideoView _a;
    public ViewGroup _b;
    public boolean _c;
    public int _d;
    public int _e;
    public boolean _f;
    public int _g;
    public int _h;
    public Runnable _l;
    public boolean _i = true;
    public final _a _j = new _a();
    public final Handler _k = new Handler();
    public final _b _m = new _b();
    public final AtomicInteger _n = new AtomicInteger();
    public final AtomicBoolean _o = new AtomicBoolean();

    public class _a implements ViewTreeObserver.OnGlobalLayoutListener {
        public _a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            _lh _lhVar = _lh.this;
            if (_lhVar._a != null) {
                _lhVar._a();
                _lh _lhVar2 = _lh.this;
                if (_lhVar2._d <= 0 || _lhVar2._e <= 0) {
                    return;
                }
                _lhVar2._a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        }
    }

    public class _b implements ViewTreeObserver.OnScrollChangedListener {

        public class _a implements Runnable {
            public _a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                _lh _lhVar = _lh.this;
                ConcurrentHashMap concurrentHashMap = _lh._p;
                _lhVar._a();
            }
        }

        public _b() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public final void onScrollChanged() {
            _lh _lhVar = _lh.this;
            if (_lhVar._a == null || _lhVar._b == null) {
                return;
            }
            Runnable runnable = _lhVar._l;
            if (runnable != null) {
                _lhVar._k.removeCallbacks(runnable);
            }
            _lh _lhVar2 = _lh.this;
            _a _aVar = new _a();
            _lhVar2._l = _aVar;
            _lhVar2._k.postDelayed(_aVar, 16L);
        }
    }

    public _lh(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    public final void _a(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = _p;
        synchronized (concurrentHashMap) {
            List<PtgVideoView> list = (List) concurrentHashMap.get(Integer.valueOf(System.identityHashCode(viewGroup)));
            if (list != null && !list.isEmpty()) {
                PtgVideoView ptgVideoView = null;
                int i = Integer.MAX_VALUE;
                for (PtgVideoView ptgVideoView2 : list) {
                    _lh _lhVar = ptgVideoView2._k;
                    int i2 = (_lhVar == null || !_lhVar._c) ? -1 : _lhVar._g;
                    if (i2 < i && i2 > -1) {
                        ptgVideoView = ptgVideoView2;
                        i = i2;
                    }
                }
                for (PtgVideoView ptgVideoView3 : list) {
                    if (ptgVideoView == ptgVideoView3) {
                        _a(ptgVideoView3);
                    } else if (ptgVideoView3 != null && 2 != ptgVideoView3.getLastState()) {
                        ptgVideoView3.setLastState(2);
                        ptgVideoView3._a();
                    }
                }
            }
        }
    }

    public final void _b() {
        try {
            if (this._a != null) {
                _a();
                if (this._b != null) {
                    this._a.getViewTreeObserver().addOnScrollChangedListener(this._m);
                } else {
                    this._a.getViewTreeObserver().removeOnScrollChangedListener(this._m);
                }
                this._a.getViewTreeObserver().addOnGlobalLayoutListener(this._j);
            }
        } catch (Exception unused) {
        }
    }

    public final void _c() {
        try {
            PtgVideoView ptgVideoView = this._a;
            if (ptgVideoView != null) {
                ViewTreeObserver viewTreeObserver = ptgVideoView.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    _b _bVar = this._m;
                    if (_bVar != null) {
                        viewTreeObserver.removeOnScrollChangedListener(_bVar);
                    }
                    _a _aVar = this._j;
                    if (_aVar != null) {
                        viewTreeObserver.removeOnGlobalLayoutListener(_aVar);
                    }
                }
                ViewGroup viewGroup = this._b;
                PtgVideoView ptgVideoView2 = this._a;
                if (viewGroup != null && ptgVideoView2 != null) {
                    ConcurrentHashMap concurrentHashMap = _p;
                    synchronized (concurrentHashMap) {
                        try {
                            List list = (List) concurrentHashMap.get(Integer.valueOf(System.identityHashCode(viewGroup)));
                            if (list != null && list.contains(ptgVideoView2)) {
                                list.remove(ptgVideoView2);
                                if (2 != ptgVideoView2.getLastState()) {
                                    ptgVideoView2.setLastState(2);
                                    ptgVideoView2._a();
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:144:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:160:0x00a7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:169:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:170:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:171:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x00ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:173:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:174:0x00b4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:35:0x0067 A[Catch: Exception -> 0x00bd, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bd, blocks: (B:8:0x0021, B:9:0x0025, B:11:0x0029, B:16:0x0033, B:21:0x003d, B:26:0x0047, B:57:0x00ba, B:35:0x0067, B:44:0x0087, B:56:0x00b4, B:24:0x0043, B:19:0x0039, B:14:0x002f), top: B:140:0x0021 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0087 A[Catch: Exception -> 0x00bd, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00bd, blocks: (B:8:0x0021, B:9:0x0025, B:11:0x0029, B:16:0x0033, B:21:0x003d, B:26:0x0047, B:57:0x00ba, B:35:0x0067, B:44:0x0087, B:56:0x00b4, B:24:0x0043, B:19:0x0039, B:14:0x002f), top: B:140:0x0021 }] */
    public final void _a() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        int i;
        int iSqrt;
        PtgVideoView ptgVideoView = this._a;
        if (ptgVideoView == null) {
            return;
        }
        this._f = ptgVideoView.hasWindowFocus();
        this._d = this._a.getWidth();
        this._e = this._a.getHeight();
        PtgVideoView ptgVideoView2 = this._a;
        if (ptgVideoView2 == null) {
            viewGroup = null;
        } else {
            try {
                ViewParent parent = ptgVideoView2.getParent();
                while (true) {
                    if (parent instanceof ViewGroup) {
                        ViewGroup viewGroup4 = (ViewGroup) parent;
                        if (viewGroup4 == null || !(viewGroup4 instanceof ScrollView)) {
                            ViewGroup viewGroup5 = (ViewGroup) parent;
                            if (viewGroup5 == null || !(viewGroup5 instanceof HorizontalScrollView)) {
                                ViewGroup viewGroup6 = (ViewGroup) parent;
                                if (viewGroup6 == null || !(viewGroup6 instanceof AbsListView)) {
                                    ViewGroup viewGroup7 = (ViewGroup) parent;
                                    if (viewGroup7 != null) {
                                        try {
                                            if (!Class.forName("androidx.recyclerview.widget.RecyclerView").isInstance(viewGroup7)) {
                                                try {
                                                    if (!Class.forName("android.support.v7.widget.RecyclerView").isInstance(viewGroup7)) {
                                                        viewGroup2 = (ViewGroup) parent;
                                                        if (viewGroup2 == null) {
                                                            if (Class.forName("androidx.core.widget.NestedScrollView").isInstance(viewGroup2)) {
                                                                if (Class.forName("android.support.v4.widget.NestedScrollView").isInstance(viewGroup2)) {
                                                                    viewGroup3 = (ViewGroup) parent;
                                                                    if (viewGroup3 == null) {
                                                                        if (Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup3)) {
                                                                            if (Class.forName("androidx.viewpager2.widget.ViewPager2").isInstance(viewGroup3)) {
                                                                                if (Class.forName("android.support.v4.view.ViewPager").isInstance(viewGroup3)) {
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    parent = parent.getParent();
                                                                }
                                                            }
                                                        } else {
                                                            viewGroup3 = (ViewGroup) parent;
                                                            if (viewGroup3 == null) {
                                                                if (Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup3)) {
                                                                    if (Class.forName("androidx.viewpager2.widget.ViewPager2").isInstance(viewGroup3)) {
                                                                        if (Class.forName("android.support.v4.view.ViewPager").isInstance(viewGroup3)) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            parent = parent.getParent();
                                                        }
                                                    }
                                                } catch (Exception unused) {
                                                }
                                            }
                                        } catch (Exception unused2) {
                                        }
                                    } else {
                                        viewGroup2 = (ViewGroup) parent;
                                        if (viewGroup2 == null) {
                                            try {
                                                if (Class.forName("androidx.core.widget.NestedScrollView").isInstance(viewGroup2)) {
                                                    try {
                                                        if (Class.forName("android.support.v4.widget.NestedScrollView").isInstance(viewGroup2)) {
                                                            viewGroup3 = (ViewGroup) parent;
                                                            if (viewGroup3 == null) {
                                                                if (Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup3)) {
                                                                    if (Class.forName("androidx.viewpager2.widget.ViewPager2").isInstance(viewGroup3)) {
                                                                        if (Class.forName("android.support.v4.view.ViewPager").isInstance(viewGroup3)) {
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            parent = parent.getParent();
                                                        }
                                                    } catch (Exception unused3) {
                                                    }
                                                }
                                            } catch (Exception unused4) {
                                            }
                                        } else {
                                            viewGroup3 = (ViewGroup) parent;
                                            if (viewGroup3 == null) {
                                                try {
                                                    if (Class.forName("androidx.viewpager.widget.ViewPager").isInstance(viewGroup3)) {
                                                        try {
                                                            if (Class.forName("androidx.viewpager2.widget.ViewPager2").isInstance(viewGroup3)) {
                                                                try {
                                                                    if (Class.forName("android.support.v4.view.ViewPager").isInstance(viewGroup3)) {
                                                                    }
                                                                } catch (Exception unused5) {
                                                                    continue;
                                                                }
                                                            }
                                                        } catch (Exception unused6) {
                                                        }
                                                    }
                                                } catch (Exception unused7) {
                                                }
                                            }
                                            parent = parent.getParent();
                                        }
                                    }
                                }
                            }
                        }
                        viewGroup = (ViewGroup) parent;
                    } else {
                        viewGroup = null;
                    }
                }
            } catch (Exception unused8) {
            }
        }
        this._b = viewGroup;
        int i2 = this._d;
        if (i2 <= 0 || (i = this._e) <= 0) {
            return;
        }
        if (this._a != null) {
            Rect rect = new Rect();
            if (this._a.getGlobalVisibleRect(rect)) {
                this._c = ((float) (rect.height() * rect.width())) > ((float) (i2 * i)) * 0.5f;
            } else {
                this._c = false;
            }
        }
        if (!this._o.get() && this._f && this._c) {
            this._o.set(true);
        }
        ViewGroup viewGroup8 = this._b;
        if (viewGroup8 == null) {
            _a(this._a);
            return;
        }
        if (!this._c) {
            PtgVideoView ptgVideoView3 = this._a;
            if (ptgVideoView3 == null) {
                return;
            }
            ConcurrentHashMap concurrentHashMap = _p;
            synchronized (concurrentHashMap) {
                List list = (List) concurrentHashMap.get(Integer.valueOf(System.identityHashCode(viewGroup8)));
                if (list != null && list.contains(ptgVideoView3)) {
                    list.remove(ptgVideoView3);
                    if (2 != ptgVideoView3.getLastState()) {
                        ptgVideoView3.setLastState(2);
                        ptgVideoView3._a();
                    }
                }
            }
            return;
        }
        PtgVideoView ptgVideoView4 = this._a;
        if (ptgVideoView4 != null && ptgVideoView4.getVisibility() == 0) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            try {
                viewGroup8.getLocationOnScreen(iArr);
                ptgVideoView4.getLocationOnScreen(iArr2);
                int width = (viewGroup8.getWidth() / 2) + iArr[0];
                int height = (viewGroup8.getHeight() / 2) + iArr[1];
                int width2 = ((ptgVideoView4.getWidth() / 2) + iArr2[0]) - width;
                int height2 = ((ptgVideoView4.getHeight() / 2) + iArr2[1]) - height;
                iSqrt = (int) Math.sqrt((height2 * height2) + (width2 * width2));
            } catch (Exception unused9) {
                iSqrt = 0;
            }
        } else {
            iSqrt = 0;
        }
        this._g = iSqrt;
        boolean z = iSqrt != this._h;
        this._h = iSqrt;
        ViewGroup viewGroup9 = this._b;
        PtgVideoView ptgVideoView5 = this._a;
        ConcurrentHashMap concurrentHashMap2 = _p;
        synchronized (concurrentHashMap2) {
            int iIdentityHashCode = System.identityHashCode(viewGroup9);
            List arrayList = (List) concurrentHashMap2.get(Integer.valueOf(iIdentityHashCode));
            if (arrayList == null) {
                arrayList = new ArrayList();
                concurrentHashMap2.put(Integer.valueOf(iIdentityHashCode), arrayList);
            }
            if (!arrayList.contains(ptgVideoView5)) {
                arrayList.add(ptgVideoView5);
            }
        }
        if (z) {
            _a(this._b);
        }
    }

    public final void _a(PtgVideoView ptgVideoView) {
        PtgCoreVideo ptgCoreVideo;
        if (!this._i || ptgVideoView == null || !_iq._a(ptgVideoView._b) || (ptgCoreVideo = ptgVideoView._j) == null || ptgCoreVideo.getCurrStatus() == 7 || ptgVideoView._j.getCurrStatus() == 3 || 1 == ptgVideoView.getLastState() || !ptgVideoView.hasWindowFocus()) {
            return;
        }
        ptgVideoView.setLastState(1);
        _fv._a.post(new _l8(ptgVideoView));
    }
}
