package com.fancy;

import android.content.Context;
import android.graphics.Bitmap;
import com.fancy.adsdk.lib.constants.PtgErrorCode;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _nq implements _lr {
    public final /* synthetic */ _f _a;
    public final /* synthetic */ _nr _b;

    public _nq(_nr _nrVar, _f _fVar) {
        this._b = _nrVar;
        this._a = _fVar;
    }

    @Override // com.fancy._lr
    public final void _a(Bitmap bitmap) {
        _nr _nrVar;
        _v _vVar;
        Exception exc;
        if (bitmap != null) {
            _f _fVar = this._a;
            if (_fVar != null) {
                _nr _nrVar2 = this._b;
                if (_nrVar2._g != null) {
                    _i9 _i9Var_a = _m5._a(_fVar, _nrVar2.getWidth(), this._b.getHeight());
                    this._b._g.setLayoutParams(_i9Var_a._a);
                    this._b._g.setImageBitmap(bitmap);
                    this._b._g.setVisibility(0);
                    if (_i9Var_a._b) {
                        _ax._a(this._b.getContext(), bitmap, this._b._f);
                    }
                }
                _v _vVar2 = this._b._c;
                if (_vVar2 != null) {
                    _vVar2._a();
                }
                Context context = this._b.getContext();
                _nr _nrVar3 = this._b;
                _b3._a(context, _nrVar3, this._a, _nrVar3._f, _nrVar3._j, _nrVar3._h, _nrVar3._b);
                return;
            }
            _nrVar = this._b;
            _vVar = _nrVar._c;
            if (_vVar == null) {
                return;
            } else {
                exc = new Exception("广告数据为空");
            }
        } else {
            _nrVar = this._b;
            _vVar = _nrVar._c;
            if (_vVar == null) {
                return;
            } else {
                exc = new Exception("图片加载失败");
            }
        }
        _vVar._a(_nrVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
    }
}
