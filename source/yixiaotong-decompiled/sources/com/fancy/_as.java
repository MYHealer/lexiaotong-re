package com.fancy;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _as implements _fo {
    public final /* synthetic */ AdvertRatioLayout _a;
    public final /* synthetic */ ImageView _b;
    public final /* synthetic */ _d0 _c;
    public final /* synthetic */ _aq _d;

    public _as(_aq _aqVar, AdvertRatioLayout advertRatioLayout, ImageView imageView, _d0 _d0Var) {
        this._d = _aqVar;
        this._a = advertRatioLayout;
        this._b = imageView;
        this._c = _d0Var;
    }

    @Override // com.fancy._fo
    public final void _a() {
        _d0 _d0Var = this._c;
        if (_d0Var != null) {
            _d0Var._a(new Exception("图片加载失败"));
        }
    }

    @Override // com.fancy._fo
    public final void _a(Bitmap bitmap) {
        if (bitmap != null) {
            _aq _aqVar = this._d;
            _i9 _i9Var = _aqVar._n;
            if (_i9Var != null && _i9Var._b) {
                _ax._a(_aqVar.getContext(), bitmap, this._a);
            }
            ImageView imageView = this._b;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            _d0 _d0Var = this._c;
            if (_d0Var != null) {
                _d0Var._a();
            }
        }
    }
}
