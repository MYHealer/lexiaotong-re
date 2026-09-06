package com.fancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.mpsdk.component.widgets.PtgShakeView;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _nr extends _an {
    public FrameLayout _f;
    public ImageView _g;
    public LinearLayout _h;
    public PtgShakeView _i;
    public TextView _j;

    public _nr(Context context) {
        super(context);
    }

    @Override // com.fancy._an
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.fancy_splash_image_layout, (ViewGroup) null);
        this._a = viewInflate;
        this._f = (FrameLayout) viewInflate.findViewById(R.id.ptgAdvertLayout);
        this._g = (ImageView) this._a.findViewById(R.id.ptgSplashIv);
        this._j = (TextView) this._a.findViewById(R.id.ptgSplashHotArea);
        this._h = (LinearLayout) this._a.findViewById(R.id.ptgSplashShakeLayout);
        this._i = (PtgShakeView) this._a.findViewById(R.id.ptgSplashShakeIv);
        _db._a(this._j);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this._a, layoutParams);
        setGravity(17);
    }

    @Override // com.fancy._an
    public final void _c() {
        super._c();
        PtgShakeView ptgShakeView = this._i;
        if (ptgShakeView != null) {
            ImageView imageView = ptgShakeView._a;
            if (imageView != null) {
                imageView.clearAnimation();
            }
            _mz _mzVar = ptgShakeView._d;
            if (_mzVar != null) {
                _mzVar.cancel();
                ptgShakeView._d = null;
            }
        }
    }

    @Override // com.fancy._an
    public void setAd(_f _fVar) {
        String str = _fVar._f() != null ? _fVar._f()._a : "";
        _nq _nqVar = new _nq(this, _fVar);
        AtomicBoolean atomicBoolean = _ev._a;
        if (TextUtil.isEmpty(str)) {
            return;
        }
        com.fancy.adsdk.lib.utils._d._b(new _ex(str, _nqVar));
    }
}
