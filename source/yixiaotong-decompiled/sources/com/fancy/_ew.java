package com.fancy;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ew implements _nk {
    public final /* synthetic */ ImageView _a;
    public final /* synthetic */ int _b;

    public _ew(ImageView imageView, int i) {
        this._a = imageView;
        this._b = i;
    }

    @Override // com.fancy._nk
    public final void _a(Object obj) {
        if (obj instanceof Bitmap) {
            this._a.setImageBitmap((Bitmap) obj);
        } else {
            this._a.setImageResource(this._b);
        }
    }
}
