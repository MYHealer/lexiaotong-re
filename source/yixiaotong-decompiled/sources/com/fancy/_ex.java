package com.fancy;

import android.graphics.Bitmap;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ex implements Runnable {
    public final /* synthetic */ String _a;
    public final /* synthetic */ _lr _b;

    public class _a implements Runnable {
        public final /* synthetic */ Bitmap _a;

        public _a(Bitmap bitmap) {
            this._a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _lr _lrVar = _ex.this._b;
            if (_lrVar != null) {
                _lrVar._a(this._a);
            }
        }
    }

    public _ex(String str, _lr _lrVar) {
        this._a = str;
        this._b = _lrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _m3 _m3VarLoad = Doodle.load(this._a);
        _m3VarLoad._h = false;
        _ev._b.post(new _a(_m3VarLoad._a(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)));
    }
}
