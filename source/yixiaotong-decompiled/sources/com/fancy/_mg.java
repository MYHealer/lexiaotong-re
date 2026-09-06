package com.fancy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mg implements _lr {
    public final /* synthetic */ Activity _a;
    public final /* synthetic */ _me _b;

    public _mg(_me _meVar, Activity activity) {
        this._b = _meVar;
        this._a = activity;
    }

    @Override // com.fancy._lr
    public final void _a(Bitmap bitmap) {
        if (bitmap == null) {
            this._b._aa.set(false);
            return;
        }
        _f _fVar = this._b._b;
        if (_fVar != null) {
            _fVar._K = System.currentTimeMillis();
        }
        ImageView imageView = this._b._I;
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        ProgressBar progressBar = this._b._G;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
        _me _meVar = this._b;
        Activity activity = this._a;
        if (_meVar._aa.get()) {
            return;
        }
        _meVar._aa.set(true);
        FrameLayout frameLayout = _meVar._H;
        if (frameLayout != null) {
            frameLayout.post(new _ms(_meVar, frameLayout, activity));
        }
    }
}
