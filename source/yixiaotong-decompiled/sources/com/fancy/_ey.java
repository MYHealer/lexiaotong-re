package com.fancy;

import android.graphics.Bitmap;
import com.fancy.adsdk.lib.doodle.Doodle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ey implements Runnable {
    public final /* synthetic */ String _b;
    public final /* synthetic */ _lr _d;
    public final /* synthetic */ int _a = 2;
    public final /* synthetic */ int _c = 3000;

    public class _a implements Runnable {
        public final /* synthetic */ Bitmap _a;

        public _a(Bitmap bitmap) {
            this._a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _lr _lrVar = _ey.this._d;
            if (_lrVar != null) {
                _lrVar._a(this._a);
            }
        }
    }

    public _ey(_lr _lrVar, String str) {
        this._b = str;
        this._d = _lrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap_a = null;
        for (int i = 0; i < this._a; i++) {
            _m3 _m3VarLoad = Doodle.load(this._b);
            _m3VarLoad._h = false;
            bitmap_a = _m3VarLoad._a(this._c);
            if (bitmap_a != null) {
                break;
            }
        }
        _ev._b.post(new _a(bitmap_a));
    }
}
