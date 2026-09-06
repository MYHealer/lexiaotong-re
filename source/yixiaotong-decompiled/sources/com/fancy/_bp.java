package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import com.fancy.adsdk.lib.R;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bp {
    public static volatile boolean _a;
    public static final LinkedHashMap<View, _m3> _b = new LinkedHashMap<>();
    public static final _a _c = new _a();

    public static class _a implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            _bp._a(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            _bp._c(view);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    public static void _a(View view) {
        Animatable animatable;
        Object obj;
        try {
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (drawable instanceof Animatable) {
                    obj = drawable;
                    obj = view;
                    animatable = (Animatable) obj;
                } else {
                    obj = view;
                    animatable = null;
                }
            } else if (view instanceof Animatable) {
                obj = view;
                animatable = (Animatable) obj;
            } else {
                obj = view;
                animatable = null;
            }
            if (animatable == null || animatable.isRunning()) {
                return;
            }
            animatable.start();
        } catch (Throwable th) {
            _fq._a("Controller", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void _a(View view, Drawable drawable) {
        if (drawable != null) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(drawable);
            } else if (view instanceof _bv) {
                ((_bv) view)._b();
            }
        }
    }

    public static void _b(View view) {
        Object tag = view.getTag(R.id.fancy_doodle_view_tag);
        if (tag instanceof _m3) {
            _m3 _m3Var = (_m3) tag;
            WeakReference<com.fancy.adsdk.lib.doodle._f> weakReference = _m3Var._p;
            if (weakReference != null) {
                _m3Var._p = null;
                com.fancy.adsdk.lib.doodle._f _fVar = weakReference.get();
                if (_fVar != null && !_fVar._d.get()) {
                    _fVar._d.set(true);
                    try {
                        _fVar._a.cancel(true);
                    } catch (Throwable unused) {
                    }
                }
            }
            view.setTag(R.id.fancy_doodle_view_tag, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0016  */
    public static void _c(View view) {
        Animatable animatable;
        Object obj;
        try {
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (drawable instanceof Animatable) {
                    obj = drawable;
                    obj = view;
                    animatable = (Animatable) obj;
                } else {
                    obj = view;
                    animatable = null;
                }
            } else if (view instanceof Animatable) {
                obj = view;
                animatable = (Animatable) obj;
            } else {
                obj = view;
                animatable = null;
            }
            if (animatable == null || !animatable.isRunning()) {
                return;
            }
            animatable.stop();
        } catch (Throwable th) {
            _fq._a("Controller", th);
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002c  */
    /* JADX WARN: Code duplicated, block: B:21:0x0038 A[PHI: r1
  0x0038: PHI (r1v3 android.content.Context) = (r1v2 android.content.Context), (r1v22 android.content.Context), (r1v25 android.content.Context) binds: [B:12:0x0016, B:20:0x0036, B:18:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Multi-variable type inference failed */
    public static void _a(_m3 _m3Var, View view, Object obj, boolean z) {
        Activity activity;
        Animatable animatable;
        if (_m3Var._m != null) {
            return;
        }
        _nk _nkVar = _m3Var._n;
        if (_nkVar != null) {
            _nkVar._a(obj);
            return;
        }
        if (view == 0) {
            return;
        }
        Context context = view.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else if (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                context = contextWrapper.getBaseContext();
            } else {
                context = view.getRootView().getContext();
                if (context instanceof Activity) {
                    activity = null;
                }
            }
            activity = (Activity) context;
        } else {
            context = view.getRootView().getContext();
            if (context instanceof Activity) {
                activity = null;
            } else {
                activity = (Activity) context;
            }
        }
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || obj == null) {
            return;
        }
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            Boolean.valueOf(z).booleanValue();
            if (view instanceof ImageView) {
                ((ImageView) view).setImageBitmap(bitmap);
                return;
            } else {
                if (view instanceof _bv) {
                    new BitmapDrawable(_p3._a.getResources(), bitmap);
                    ((_bv) view)._b();
                    return;
                }
                return;
            }
        }
        if (obj instanceof Drawable) {
            _a(view, (Drawable) obj);
            if (!(obj instanceof Animatable)) {
                return;
            } else {
                animatable = (Animatable) obj;
            }
        } else {
            if (!(view instanceof _bv)) {
                return;
            }
            ((_bv) view)._a();
            if (!(view instanceof Animatable)) {
                return;
            } else {
                animatable = (Animatable) view;
            }
        }
        animatable.start();
        view.addOnAttachStateChangeListener(_c);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0036 A[PHI: r3
  0x0036: PHI (r3v22 android.content.Context) = (r3v21 android.content.Context), (r3v42 android.content.Context), (r3v45 android.content.Context) binds: [B:7:0x0014, B:15:0x0034, B:13:0x0025] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:17:0x0039  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.View, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v17 */
    public static void _a(_m3 _m3Var) {
        ?? r0;
        Object obj;
        boolean z;
        Activity activity;
        WeakReference<View> weakReference = _m3Var._o;
        Object obj_c = null;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != 0) {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    r0 = view;
                    activity = (Activity) context;
                } else if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext() instanceof Activity) {
                        r0 = view;
                        context = contextWrapper.getBaseContext();
                    } else {
                        r0 = view;
                        r0 = view;
                        context = view.getRootView().getContext();
                        if (context instanceof Activity) {
                            activity = null;
                        }
                    }
                    r0 = view;
                    activity = (Activity) context;
                } else {
                    r0 = view;
                    r0 = view;
                    context = view.getRootView().getContext();
                    if (context instanceof Activity) {
                        activity = null;
                    } else {
                        r0 = view;
                        activity = (Activity) context;
                    }
                }
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    if (_m3Var._l == 0) {
                        _m3Var._l = System.identityHashCode(activity);
                    }
                    Object tag = view.getTag(R.id.fancy_doodle_view_tag);
                    if (tag instanceof _m3) {
                        _m3 _m3Var2 = (_m3) tag;
                        if (!_m3Var._a().equals(_m3Var2._a())) {
                            WeakReference<View> weakReference2 = _m3Var2._o;
                            if (weakReference2 != null) {
                                _c(weakReference2.get());
                                _m3Var2._o = null;
                            }
                            WeakReference<com.fancy.adsdk.lib.doodle._f> weakReference3 = _m3Var2._p;
                            if (weakReference3 != null) {
                                _m3Var2._p = null;
                                com.fancy.adsdk.lib.doodle._f _fVar = weakReference3.get();
                                if (_fVar != null && !_fVar._d.get()) {
                                    _fVar._d.set(true);
                                    try {
                                        _fVar._a.cancel(true);
                                    } catch (Throwable unused) {
                                    }
                                }
                            }
                        }
                    } else if (tag != null) {
                        throw new IllegalArgumentException("Invalid tag type");
                    }
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageDrawable(null);
                    } else if (view instanceof _bv) {
                        ((_bv) view)._b();
                    }
                    view.setTag(R.id.fancy_doodle_view_tag, null);
                    r0 = view;
                } else {
                    _fq._a("Controller", new Exception("Activity not available"));
                }
                r0 = 0;
            }
            if (r0 == 0) {
                return;
            }
        } else {
            r0 = 0;
        }
        if (TextUtils.isEmpty(_m3Var._b)) {
            _nk _nkVar = _m3Var._n;
            if (_nkVar != null) {
                _nkVar._a(null);
                return;
            }
            return;
        }
        Bitmap bitmap_a = _g1._a(_m3Var._a());
        _m3._a _aVar = _m3Var._m;
        if (_aVar != null && (bitmap_a != null || _aVar._b == 0)) {
            _aVar._a = bitmap_a;
            return;
        }
        if (bitmap_a == null) {
            _p9 _p9Var = _g1._d;
            _b0 _b0Var_a = _m3Var._a();
            synchronized (_p9Var) {
                _p9Var._a();
                _p9._a _aVar2 = (_p9._a) _p9Var._a.get(_b0Var_a);
                obj = _aVar2 != null ? _aVar2.get() : null;
            }
            if (obj != null) {
                _a(_m3Var, r0, obj, true);
                return;
            }
            if (r0 != 0) {
                if (r0 instanceof ImageView) {
                    obj_c = ((ImageView) r0).getDrawable();
                } else if (r0 instanceof _bv) {
                    obj_c = ((_bv) r0)._c();
                }
                if ((obj_c instanceof Animatable) && !_a) {
                    ((Animatable) obj_c).start();
                    r0.addOnAttachStateChangeListener(_c);
                }
            }
            if (r0 != 0 && _a) {
                synchronized (_bp.class) {
                    _b.put((View) r0, _m3Var);
                }
                return;
            }
            boolean z2 = false;
            if (_m3Var._b.startsWith("http")) {
                _b0 _b0Var_a2 = _m3Var._a();
                com.fancy.adsdk.lib.doodle._a _aVar3 = com.fancy.adsdk.lib.doodle._b._a;
                synchronized (_aVar3) {
                    HashMap map = _aVar3._h;
                    z = map != null && map.containsKey(_b0Var_a2);
                }
                if (!z) {
                    z2 = true;
                }
            }
            com.fancy.adsdk.lib.doodle._f _fVar2 = new com.fancy.adsdk.lib.doodle._f(_m3Var, r0, z2);
            int i = _m3Var._l;
            if (_fVar2._c == 1) {
                if (i != 0) {
                    synchronized (_fm.class) {
                        SparseArray<_fm._a> sparseArray = _fm._a;
                        _fm._a _aVar4 = sparseArray.get(i);
                        if (_aVar4 == null) {
                            _aVar4 = new _fm._a();
                            sparseArray.put(i, _aVar4);
                        }
                        Iterator<WeakReference<com.fancy.adsdk.lib.doodle._c>> it = _aVar4._a.iterator();
                        do {
                            if (!it.hasNext()) {
                                _aVar4._a.add(new WeakReference<>(_fVar2));
                                break;
                            }
                        } while (it.next().get() != _fVar2);
                    }
                }
                _fVar2._f = i;
                _fVar2._c = 2;
                com.fancy.adsdk.lib.doodle._d._b _bVar = com.fancy.adsdk.lib.doodle._d._c;
                _b0 _b0Var_d = _fVar2._d();
                com.fancy.adsdk.lib.doodle._c._a _aVar5 = _fVar2._a;
                boolean z3 = _fVar2._g;
                synchronized (_bVar) {
                    if (_aVar5 != null) {
                        com.fancy.adsdk.lib.doodle._e _eVar = new com.fancy.adsdk.lib.doodle._e(_bVar, _aVar5, z3, _b0Var_d);
                        HashSet hashSet = com.fancy.adsdk.lib.doodle._d._b._a;
                        if (!hashSet.contains(_b0Var_d)) {
                            hashSet.add(_b0Var_d);
                            (z3 ? com.fancy.adsdk.lib.doodle._d._b : com.fancy.adsdk.lib.doodle._d._a).execute(_eVar);
                        } else {
                            HashMap map2 = com.fancy.adsdk.lib.doodle._d._b._b;
                            LinkedList linkedList = (LinkedList) map2.get(_b0Var_d);
                            if (linkedList == null) {
                                linkedList = new LinkedList();
                                map2.put(_b0Var_d, linkedList);
                            }
                            linkedList.offer(_eVar);
                        }
                    }
                }
            }
            if (_aVar == null || _fVar2._b || _fVar2._d.get()) {
                return;
            }
            try {
                _aVar._a = (Bitmap) _fVar2._a.get(Long.valueOf(_aVar._b).longValue(), TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                _fq._a("Controller", th);
            }
            if (_fVar2._b) {
                return;
            }
            _fVar2._d.set(true);
            try {
                _fVar2._a.cancel(true);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        _a(_m3Var, r0, bitmap_a, true);
    }
}
