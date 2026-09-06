package com.fancy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mr implements _lr {
    public final /* synthetic */ Activity _a;
    public final /* synthetic */ _me _b;

    public class _a implements Runnable {
        public final /* synthetic */ FrameLayout _a;

        public _a(FrameLayout frameLayout) {
            this._a = frameLayout;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _f _fVar = _mr.this._b._b;
            if (_fVar != null) {
                _fVar._K = System.currentTimeMillis();
            }
            _n1._a(this._a, _mr.this._b._b);
            AtomicBoolean atomicBoolean = _mr.this._b._a7;
            if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true)) {
                _m8._a()._a(_mr.this._b._a4);
            }
            _me _meVar = _mr.this._b;
            if (_meVar._a9 == null) {
                _meVar._a9 = new _me._i(_mr.this._b, 10000);
                _mr.this._b._a(true);
            }
            _m8._a()._g(_mr.this._b._a4);
            _mr _mrVar = _mr.this;
            _jd _jdVar = _mrVar._b._F;
            if (_jdVar != null) {
                _jdVar._a(_mrVar._a);
            }
        }
    }

    public _mr(_me _meVar, Activity activity) {
        this._b = _meVar;
        this._a = activity;
    }

    @Override // com.fancy._lr
    public final void _a(Bitmap bitmap) {
        ImageView imageView;
        if (bitmap == null) {
            ProgressBar progressBar = this._b._G;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            this._b._e();
            _m8._a()._a(this._b._a4, PtgErrorCode.SDK_RESOURCE_ERROR, "load image error!");
            _me _meVar = this._b;
            _meVar._z = true;
            _meVar._b(0);
            return;
        }
        _me _meVar2 = this._b;
        FrameLayout frameLayout = _meVar2._H;
        if (frameLayout == null || (imageView = _meVar2._I) == null) {
            return;
        }
        imageView.setImageBitmap(bitmap);
        ProgressBar progressBar2 = this._b._G;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        frameLayout.post(new _a(frameLayout));
    }
}
