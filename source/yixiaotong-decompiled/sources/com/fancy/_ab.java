package com.fancy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ab implements Runnable {
    public final /* synthetic */ Bitmap _a;
    public final /* synthetic */ View _b;
    public final /* synthetic */ Context _c;

    public class _a implements Runnable {
        public final /* synthetic */ Bitmap _a;

        public _a(Bitmap bitmap) {
            this._a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view;
            if (this._a == null || (view = _ab.this._b) == null) {
                return;
            }
            view.setBackground(new BitmapDrawable(_ab.this._c.getResources(), this._a));
        }
    }

    public _ab(Context context, Bitmap bitmap, AdvertRatioLayout advertRatioLayout) {
        this._a = bitmap;
        this._b = advertRatioLayout;
        this._c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap bitmap_a;
        try {
            bitmap_a = _ac._a(this._a);
        } catch (Exception unused) {
            bitmap_a = null;
        }
        if (bitmap_a == null) {
            return;
        }
        _fv._a.post(new _a(bitmap_a));
    }
}
