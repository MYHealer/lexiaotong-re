package com.fancy;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _l9 implements View.OnLayoutChangeListener {
    public int _a;
    public int _b;
    public final /* synthetic */ PtgVideoView _c;

    public _l9(PtgVideoView ptgVideoView) {
        this._c = ptgVideoView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        FrameLayout.LayoutParams layoutParams;
        int i9 = i3 - i;
        int i10 = i4 - i2;
        if ((i9 <= 0 || i10 <= 0 || i9 == this._a) && i10 == this._b) {
            return;
        }
        this._a = i9;
        this._b = i10;
        PtgVideoView ptgVideoView = this._c;
        _f _fVar = ptgVideoView._l;
        if (_fVar == null) {
            return;
        }
        _i9 _i9Var_a = _m5._a(_fVar, i9, i10);
        ptgVideoView._t = _i9Var_a;
        if (_i9Var_a == null || (layoutParams = _i9Var_a._a) == null) {
            return;
        }
        ImageView imageView = ptgVideoView._g;
        if (imageView != null) {
            imageView.post(new _lc(ptgVideoView, layoutParams));
        }
        if (ptgVideoView._t._b) {
            if (TextUtils.isEmpty(ptgVideoView._l._n())) {
                AdvertRatioLayout advertRatioLayout = ptgVideoView._f;
                ImageView imageView2 = ptgVideoView._g;
                if (advertRatioLayout != null && imageView2 != null) {
                    Drawable drawable = imageView2.getDrawable();
                    if (drawable instanceof BitmapDrawable) {
                        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                        Context context = imageView2.getContext();
                        if (bitmap != null) {
                            com.fancy.adsdk.lib.utils._d._b(new _ab(context, bitmap, advertRatioLayout));
                        }
                    }
                }
            } else {
                _m3 _m3VarLoad = Doodle.load(ptgVideoView._l._n());
                _m3VarLoad._i = true;
                _m3VarLoad._h = false;
                _ax._a(ptgVideoView.getContext(), _m3VarLoad._a(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS), ptgVideoView._f);
            }
        }
        PtgCoreVideo ptgCoreVideo = ptgVideoView._j;
        if (ptgCoreVideo != null) {
            ptgCoreVideo.setLayoutParams(layoutParams);
            ptgVideoView._j.setVisibility(0);
        }
        if (ptgVideoView._h != null) {
            int iMax = Math.max(ScreenUtils.dp2px(20.0f), Math.min(ScreenUtils.dp2px(50.0f), (int) (Math.min(i9, i10) * 0.35f)));
            ViewGroup.LayoutParams layoutParams2 = ptgVideoView._h.getLayoutParams();
            layoutParams2.width = iMax;
            layoutParams2.height = iMax;
            ptgVideoView._h.setLayoutParams(layoutParams2);
        }
        AdvertRatioLayout._a _aVar = ptgVideoView._u;
        if (_aVar != null) {
            _aVar._a(i9, i10);
        }
    }
}
