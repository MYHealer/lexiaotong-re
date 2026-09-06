package com.fancy;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.hihonor.adsdk.common.video.g.a;
import com.stub.StubApp;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ev {
    public static final AtomicBoolean _a = new AtomicBoolean(false);
    public static final Handler _b = new Handler(Looper.getMainLooper());

    public class _a implements _nk {
        public final /* synthetic */ ImageView _a;

        public _a(ImageView imageView) {
            this._a = imageView;
        }

        @Override // com.fancy._nk
        public final void _a(Object obj) {
            if (obj instanceof Bitmap) {
                this._a.setImageBitmap((Bitmap) obj);
            }
        }
    }

    public static void _a(Context context) {
        if (_a.compareAndSet(false, true)) {
            _p3._a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            File file = new File(context.getCacheDir(), "ptg_ad_cache");
            if (!file.exists() && !file.mkdirs()) {
                file = context.getCacheDir();
            }
            Doodle.config().getClass();
            _bn._b = a.hnadsb;
            if (20971520 <= Runtime.getRuntime().maxMemory() / 2) {
                _bn._c = 20971520L;
            }
            _fq._a = _cm._a;
            _bn._a = file.getPath();
            com.fancy.adsdk.lib.utils._d._b _bVar = com.fancy.adsdk.lib.utils._d._a;
            if (_bVar != null) {
                com.fancy.adsdk.lib.doodle._d._e = _bVar;
            } else {
                com.fancy.adsdk.lib.doodle._d._a _aVar = com.fancy.adsdk.lib.doodle._d._a;
            }
            _dy _dyVar = _dy._a;
            if (_bn._d == null) {
                _bn._d = new ArrayList(1);
            }
            _bn._d.add(_dyVar);
            _a1 _a1Var = _a1._a;
            if (_bn._d == null) {
                _bn._d = new ArrayList(1);
            }
            _bn._d.add(_a1Var);
        }
    }

    public static void _a(String str, _ig _igVar) {
        if (str == null || str.isEmpty()) {
            return;
        }
        _m3 _m3VarLoad = Doodle.load(str);
        _m3VarLoad._j = 1;
        _m3VarLoad._n = new _ez(_igVar);
        _m3VarLoad._a(_m3VarLoad._d, _m3VarLoad._e);
    }

    public static void _a(String str, ImageView imageView) {
        int i;
        int i2;
        int i3;
        _b5 _b5Var;
        if (imageView == null || str == null || str.isEmpty()) {
            return;
        }
        _m3 _m3VarLoad = Doodle.load(str);
        if (_m3VarLoad._f == _b5.NOT_SET) {
            switch (_b5._a._a[imageView.getScaleType().ordinal()]) {
                case 1:
                    _b5Var = _b5.MATRIX;
                    break;
                case 2:
                    _b5Var = _b5.CENTER;
                    break;
                case 3:
                case 4:
                case 5:
                    _b5Var = _b5.FIT_CENTER;
                    break;
                case 6:
                    _b5Var = _b5.CENTER_CROP;
                    break;
                default:
                    _b5Var = _b5.CENTER_INSIDE;
                    break;
            }
            _m3VarLoad._f = _b5Var;
        }
        _m3VarLoad._o = new WeakReference<>(imageView);
        if (_m3VarLoad._f != _b5.NO_CLIP) {
            int i4 = _m3VarLoad._d;
            if (i4 > 0 && (i3 = _m3VarLoad._e) > 0) {
                _m3VarLoad._a(i4, i3);
                return;
            }
            if (imageView.getWidth() > 0 && imageView.getHeight() > 0) {
                _m3VarLoad._a(imageView.getWidth(), imageView.getHeight());
                return;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            if (layoutParams != null && (((i = layoutParams.width) > 0 || i == -2) && ((i2 = layoutParams.height) > 0 || i2 == -2))) {
                ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
                int i5 = layoutParams2.width;
                int i6 = layoutParams2.height;
                if (i5 >= 0 || i6 >= 0) {
                    if (i5 <= 0) {
                        if (_p3._d == null) {
                            synchronized (_p3.class) {
                                if (_p3._d == null) {
                                    _p3._a();
                                }
                            }
                        }
                        i5 = _p3._d.x;
                    }
                    if (i6 <= 0) {
                        if (_p3._d == null) {
                            synchronized (_p3.class) {
                                if (_p3._d == null) {
                                    _p3._a();
                                }
                            }
                        }
                        i6 = _p3._d.y;
                    }
                    _m3VarLoad._a(i5, i6);
                    return;
                }
            } else if (imageView.getWindowToken() == null) {
                imageView.getViewTreeObserver().addOnPreDrawListener(new _m2(_m3VarLoad));
                return;
            }
        }
        _m3VarLoad._a(0, 0);
    }

    public static void _a(ImageView imageView, String str, int i, int i2) {
        if (imageView == null || str == null || str.isEmpty()) {
            return;
        }
        _m3 _m3VarLoad = Doodle.load(str);
        _m3VarLoad._d = i;
        _m3VarLoad._e = i2;
        _m3VarLoad._h = false;
        _m3VarLoad._n = new _a(imageView);
        _m3VarLoad._a(i, i2);
    }
}
