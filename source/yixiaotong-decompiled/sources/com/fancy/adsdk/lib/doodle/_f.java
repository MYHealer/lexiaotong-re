package com.fancy.adsdk.lib.doodle;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.View;
import com.fancy._a0;
import com.fancy._b0;
import com.fancy._bn;
import com.fancy._bp;
import com.fancy._bz;
import com.fancy._c2;
import com.fancy._fq;
import com.fancy._g1;
import com.fancy._ie;
import com.fancy._il;
import com.fancy._m3;
import com.fancy._p3;
import com.fancy._p9;
import com.fancy.adsdk.lib.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _f extends _c {
    public static final _a _m = new _a(8192, _bn._b, "/doodle/result/");
    public static final AtomicInteger _n = new AtomicInteger();
    public final _m3 _i;
    public boolean _j = false;
    public boolean _k = false;
    public long _l;

    public _f(_m3 _m3Var, View view, boolean z) {
        this._i = _m3Var;
        this._g = z;
        if (_fq._a()) {
            Log.d("Worker", _ie._a("Loading start, count:").append(_n.incrementAndGet()).toString());
        }
        if (view != null) {
            _m3Var._p = new WeakReference<>(this);
            view.setTag(R.id.fancy_doodle_view_tag, _m3Var);
        }
    }

    public static Object _a(_c2 _c2Var) {
        Iterator it = _bn._d.iterator();
        while (it.hasNext()) {
            Object obj_a = ((_a0) it.next())._a(_c2Var);
            if (obj_a != null) {
                return obj_a instanceof BitmapDrawable ? ((BitmapDrawable) obj_a).getBitmap() : obj_a;
            }
        }
        return null;
    }

    public static void _a(_m3 _m3Var, final Bitmap bitmap, _bz _bzVar) {
        final _b0 _b0Var_a = _m3Var._a();
        int i_c = 1;
        final boolean z = _m3Var._g == 2;
        if (!z && _bzVar != null) {
            try {
                i_c = _bzVar._c();
            } catch (Throwable unused) {
            }
        }
        final Bitmap.CompressFormat compressFormat = (z || i_c == 7 || i_c == 9 || i_c == 11 || i_c == 13 || i_c == 2 || i_c == 3 || i_c == 4 || i_c == 5) ? Bitmap.CompressFormat.JPEG : Bitmap.CompressFormat.PNG;
        _d._d.execute(new Runnable() { // from class: com.fancy.adsdk.lib.doodle._f$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                _f._a(_b0Var_a, bitmap, compressFormat, z);
            }
        });
    }

    public final Bitmap _a(_a.C0372_a c0372_a) {
        Bitmap bitmapDecodeFile;
        try {
            bitmapDecodeFile = Decoder.decodeFile(c0372_a._a, c0372_a._b ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888);
        } catch (Throwable th) {
            _fq._a("Worker", th);
            bitmapDecodeFile = null;
        }
        if (bitmapDecodeFile == null) {
            this._k = false;
            _m._a(this._i._a());
        }
        return bitmapDecodeFile;
    }

    /* JADX WARN: Not initialized variable reg: 11, insn: 0x01b4: IF  (r11 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:132:0x01bb, block:B:130:0x01b4 */
    @Override // com.fancy.adsdk.lib.doodle._c
    public final Object _a() {
        _c2 _c2Var;
        _c2 _c2Var2;
        Object obj;
        boolean z;
        Object obj_a;
        View view;
        long jNanoTime = System.nanoTime();
        _b0 _b0Var_a = this._i._a();
        try {
            try {
                WeakReference<View> weakReference = this._i._o;
                if (weakReference != null) {
                    if (weakReference == null || (view = weakReference.get()) == null || view.getTag(R.id.fancy_doodle_view_tag) != this._i) {
                        view = null;
                    }
                    if (view == null) {
                        this._l = (System.nanoTime() - jNanoTime) / 1000000;
                        return null;
                    }
                }
                Bitmap bitmap_a = _g1._a(_b0Var_a);
                boolean z2 = true;
                if (bitmap_a != null) {
                    this._j = true;
                    this._l = (System.nanoTime() - jNanoTime) / 1000000;
                    return bitmap_a;
                }
                _p9 _p9Var = _g1._d;
                synchronized (_p9Var) {
                    _p9Var._a();
                    _p9._a _aVar = (_p9._a) _p9Var._a.get(_b0Var_a);
                    obj = _aVar != null ? _aVar.get() : null;
                }
                if (obj != null) {
                    this._j = true;
                    this._l = (System.nanoTime() - jNanoTime) / 1000000;
                    return obj;
                }
                _g1._a();
                _a.C0372_a c0372_a_b = _m._b(_b0Var_a);
                boolean z3 = c0372_a_b != null;
                this._k = z3;
                if (z3) {
                    bitmap_a = _a(c0372_a_b);
                }
                if (bitmap_a == null) {
                    _c2Var = new _c2(this._i);
                    try {
                        this._i.getClass();
                        if (bitmap_a == null && this._i._h && _bn._d != null && (obj_a = _a(_c2Var)) != null) {
                            if (!(obj_a instanceof Bitmap)) {
                                if (this._i._j != 1) {
                                    synchronized (_p9Var) {
                                        _p9Var._a();
                                        _p9._a _aVar2 = (_p9._a) _p9Var._a.get(_b0Var_a);
                                        if (_aVar2 == null || _aVar2.get() != obj_a) {
                                            _p9Var._a.put(_b0Var_a, new _p9._a(_b0Var_a, obj_a, _p9Var._b));
                                        }
                                    }
                                }
                                _p3._a(_c2Var._d);
                                this._l = (System.nanoTime() - jNanoTime) / 1000000;
                                return obj_a;
                            }
                            bitmap_a = Decoder.handleScaleAndCrop((Bitmap) obj_a, this._i);
                        }
                        if (bitmap_a == null) {
                            String str = _bn._a;
                        }
                        if (bitmap_a == null) {
                            bitmap_a = Decoder.decode(_c2Var._a(), this._i);
                        }
                    } catch (InterruptedIOException e) {
                        e = e;
                    } catch (Throwable th) {
                        th = th;
                        _bz _bzVar = _c2Var != null ? _c2Var._d : null;
                        if (_bzVar != null && _bzVar._c) {
                            _b._a._a(_b0Var_a);
                        }
                        _fq._a("Worker", new Exception("Load bitmap failed, path: " + this._i._b, th));
                        if (_c2Var != null) {
                            _p3._a(_c2Var._d);
                        }
                        this._l = (System.nanoTime() - jNanoTime) / 1000000;
                        return null;
                    }
                } else {
                    _c2Var = null;
                }
                if (bitmap_a != null && !(z = this._k)) {
                    _m3 _m3Var = this._i;
                    if (!z) {
                        _m3Var.getClass();
                    }
                }
                if (bitmap_a != null) {
                    int i = this._i._j;
                    if (i != 1) {
                        if (i != 2) {
                            z2 = false;
                        }
                        _g1._a(_b0Var_a, bitmap_a, z2);
                    }
                    if (!this._k) {
                        int i2 = this._i._k;
                        _il._a(i2);
                        if (i2 == 4 || i2 == 3) {
                            _a(this._i, bitmap_a, _c2Var != null ? _c2Var._d : null);
                        }
                    }
                }
                if (_c2Var != null) {
                    _p3._a(_c2Var._d);
                }
                this._l = (System.nanoTime() - jNanoTime) / 1000000;
                return bitmap_a;
            } catch (Throwable th2) {
                if (_c2Var2 != null) {
                    _p3._a(_c2Var2._d);
                }
                this._l = (System.nanoTime() - jNanoTime) / 1000000;
                throw th2;
            }
        } catch (InterruptedIOException e2) {
            e = e2;
            _c2Var = null;
        } catch (Throwable th3) {
            th = th3;
            _c2Var = null;
        }
        if (_fq._a()) {
            Log.d("Worker", "Interrupted reason: " + e.getClass().getSimpleName());
        }
        if (_c2Var != null) {
            _p3._a(_c2Var._d);
        }
        this._l = (System.nanoTime() - jNanoTime) / 1000000;
        return null;
    }

    @Override // com.fancy.adsdk.lib.doodle._c
    public final void _b(Object obj) {
        View view;
        if (_fq._a()) {
            Log.d("Worker", "Loading finish, path:" + this._i._b + ", time:" + this._l + "ms, remain:" + _n.decrementAndGet());
        }
        WeakReference<View> weakReference = this._i._o;
        if (weakReference == null || (view = weakReference.get()) == null || view.getTag(R.id.fancy_doodle_view_tag) != this._i) {
            view = null;
        }
        if (view != null) {
            view.setTag(R.id.fancy_doodle_view_tag, null);
            _bp._c(view);
        }
        try {
            _bp._a(this._i, view, obj, this._j);
        } catch (Throwable th) {
            _fq._a("Worker", th);
        }
    }

    @Override // com.fancy.adsdk.lib.doodle._c
    public final void _c() {
        View view;
        if (_fq._a()) {
            Log.d("Worker", "Loading cancel, path:" + this._i._b + ", time:" + this._l + "ms, remain:" + _n.decrementAndGet());
        }
        WeakReference<View> weakReference = this._i._o;
        if (weakReference == null || (view = weakReference.get()) == null || view.getTag(R.id.fancy_doodle_view_tag) != this._i) {
            view = null;
        }
        if (view != null) {
            view.setTag(R.id.fancy_doodle_view_tag, null);
            _bp._c(view);
        }
        _m3 _m3Var = this._i;
        _m3Var._n = null;
        _m3Var._o = null;
        _m3Var._p = null;
    }

    public final _b0 _d() {
        return this._i._b.startsWith("http") ? new _b0(this._i._b) : this._i._a();
    }

    public static void _a(_b0 _b0Var, Bitmap bitmap, Bitmap.CompressFormat compressFormat, boolean z) {
        boolean z2;
        try {
            _a _aVar = _m;
            synchronized (_aVar) {
                z2 = _aVar._a() && !_aVar._h.containsKey(_b0Var);
            }
            if (z2) {
                String str_c = _aVar._c(_b0Var);
                File file = new File(str_c + ".tmp");
                if (!file.isFile()) {
                    File parentFile = file.getParentFile();
                    if (parentFile == null) {
                        return;
                    }
                    if ((!parentFile.isDirectory() && !parentFile.mkdirs()) || !file.createNewFile()) {
                        return;
                    }
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    bitmap.compress(compressFormat, compressFormat == Bitmap.CompressFormat.WEBP ? 100 : 95, bufferedOutputStream);
                    bufferedOutputStream.flush();
                    fileOutputStream.getFD().sync();
                    _p3._a(bufferedOutputStream);
                    File file2 = new File(str_c);
                    if (file2.exists()) {
                        _p3._a(file2);
                    }
                    if (file.renameTo(file2)) {
                        _aVar._a(_b0Var, file2, z);
                    }
                } catch (Throwable th) {
                    _p3._a(bufferedOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            _fq._a("Worker", th2);
        }
    }
}
