package com.fancy;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.fancy.mpsdk.component.video.PtgVideoView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lf implements _lr {
    public final /* synthetic */ PtgVideoView _a;

    public _lf(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // com.fancy._lr
    public final void _a(Bitmap bitmap) {
        PtgVideoView ptgVideoView;
        if (bitmap != null) {
            ImageView imageView = this._a._g;
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
            PtgVideoView ptgVideoView2 = this._a;
            _i9 _i9Var = ptgVideoView2._t;
            if (_i9Var != null && _i9Var._b) {
                _ax._a(ptgVideoView2.getContext(), bitmap, this._a._f);
            }
            if (this._a._q.get()) {
                return;
            }
            ptgVideoView = this._a;
            if (ptgVideoView._a == null) {
                return;
            }
        } else {
            if (this._a._q.get()) {
                return;
            }
            ptgVideoView = this._a;
            if (ptgVideoView._a == null) {
                return;
            }
        }
        ptgVideoView._q.set(true);
        this._a._a._a();
    }
}
