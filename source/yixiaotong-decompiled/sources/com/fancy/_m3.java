package com.fancy;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.util.UriUtil;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _m3 {
    public _b0 _a;
    public final String _b;
    public Uri _c;
    public int _d;
    public int _e;
    public _b5 _f;
    public int _g;
    public boolean _h;
    public boolean _i;
    public int _j;
    public int _k;
    public int _l;
    public _a _m;
    public _nk _n;
    public WeakReference<View> _o;
    public WeakReference<com.fancy.adsdk.lib.doodle._f> _p;

    public static class _a {
        public Bitmap _a;
        public long _b;

        public _a(long j) {
            this._b = j;
        }
    }

    public _m3(int i) {
        this._f = _b5.NOT_SET;
        this._g = 1;
        this._h = true;
        this._i = false;
        this._j = 3;
        this._k = 4;
        String str = _bn._a;
        String str_a = _p3._a(i);
        this._b = str_a;
        if (!str_a.isEmpty()) {
            this._c = Uri.parse(str_a);
        }
        this._k = 1;
    }

    public _m3(Uri uri) {
        String string;
        this._f = _b5.NOT_SET;
        this._g = 1;
        this._h = true;
        this._i = false;
        this._j = 3;
        this._k = 4;
        String str = _bn._a;
        this._c = uri;
        if (uri != null) {
            String scheme = uri.getScheme();
            string = (scheme == null || scheme.equals(UriUtil.LOCAL_FILE_SCHEME)) ? _ie._a("file://").append(uri.getPath()).toString() : uri.toString();
        } else {
            string = "";
        }
        this._b = string;
    }

    public _m3(String str) {
        this._f = _b5.NOT_SET;
        this._g = 1;
        this._h = true;
        this._i = false;
        this._j = 3;
        this._k = 4;
        String str2 = _bn._a;
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (!str.contains("://")) {
            str = "file://" + str;
        }
        this._b = str;
    }

    public final Bitmap _a(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Timeout can't be negative");
        }
        this._h = false;
        this._m = new _a(j);
        _a(this._d, this._e);
        return this._m._a;
    }

    public final _b0 _a() {
        if (this._a == null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append(TextUtils.isEmpty(null) ? this._b : null).append(":s").append(this._d).append('x').append(this._e).append(":c").append(this._f._a).append(":f").append(_c1._a(this._g)).append(":u0:d").append(this._h ? '1' : '0');
            this._a = new _b0(sb.toString());
        }
        return this._a;
    }

    public final void _a(int i, int i2) {
        View view;
        this._d = i;
        this._e = i2;
        _b5 _b5Var = this._f;
        _b5 _b5Var2 = _b5.NOT_SET;
        if (_b5Var == _b5Var2 && i > 0 && i2 > 0) {
            this._f = _b5.CENTER_INSIDE;
        }
        _b5 _b5Var3 = this._f;
        if (_b5Var3 == _b5Var2 || _b5Var3 == _b5.NO_CLIP || i <= 0 || i2 <= 0) {
            this._f = _b5.NO_CLIP;
            this._d = 0;
            this._e = 0;
        }
        WeakReference<View> weakReference = this._o;
        if (weakReference != null && (view = weakReference.get()) != null && this._f != _b5.NO_CLIP) {
            int paddingRight = view.getPaddingRight() + view.getPaddingLeft();
            int paddingBottom = view.getPaddingBottom() + view.getPaddingTop();
            int i3 = this._d;
            if (i3 > paddingRight) {
                this._d = i3 - paddingRight;
            }
            int i4 = this._e;
            if (i4 > paddingBottom) {
                this._e = i4 - paddingBottom;
            }
        }
        try {
            _bp._a(this);
        } catch (Throwable th) {
            _fq._a("Doodle", th);
        }
    }
}
