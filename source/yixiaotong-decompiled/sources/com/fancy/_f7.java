package com.fancy;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _f7 implements _fo {
    public final /* synthetic */ String _a;
    public final /* synthetic */ _f5 _b;

    public _f7(_f5 _f5Var, String str) {
        this._b = _f5Var;
        this._a = str;
    }

    @Override // com.fancy._fo
    public final void _a() {
        _4 _4 = this._b._a;
        if (_4 != null) {
            ((_fe) _4)._a(_ie._a("资源下载异常: ").append(this._a).toString());
        }
    }

    @Override // com.fancy._fo
    public final void _a(Bitmap bitmap) {
        _4 _4;
        String str;
        try {
            this._b.setVisibility(0);
            if (bitmap != null) {
                _f5 _f5Var = this._b;
                ImageView imageView = _f5Var._j;
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                    _f5 _f5Var2 = this._b;
                    _4 _5 = _f5Var2._a;
                    if (_5 != null) {
                        View view = _f5Var2._f;
                        _fe _feVar = (_fe) _5;
                        _f _fVar = _feVar._c._d;
                        if (_fVar != null) {
                            _fVar._K = System.currentTimeMillis();
                        }
                        view.post(new _fd(_feVar, view));
                        return;
                    }
                    return;
                }
                _4 = _f5Var._a;
                if (_4 == null) {
                    return;
                } else {
                    str = "页面被销毁或布局丢失！";
                }
            } else {
                _4 = this._b._a;
                if (_4 == null) {
                    return;
                } else {
                    str = "资源下载异常,Bitmap异常！";
                }
            }
            ((_fe) _4)._a(str);
        } catch (Exception e) {
            _4 _6 = this._b._a;
            if (_6 != null) {
                ((_fe) _6)._a(_ie._a("渲染失败：").append(e.getMessage()).toString());
            }
        }
    }
}
