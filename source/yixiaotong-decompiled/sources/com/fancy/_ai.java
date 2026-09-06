package com.fancy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;
import com.fancy.mpsdk.component.widgets.PtgShakeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ai extends _aq {
    public TextView _s;
    public ImageView _t;
    public ImageView _u;
    public ImageView _v;

    public _ai(Context context) {
        super(context);
    }

    @Override // com.fancy._aq
    public final void _a(int i) {
        if (this._f == null || this._g == null || this._h == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((i - ScreenUtils.dp2px(30.0f)) / 3, -2);
        this._f.setLayoutParams(layoutParams);
        this._g.setLayoutParams(layoutParams);
        this._h.setLayoutParams(layoutParams);
    }

    @Override // com.fancy._ap
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.fancy_banner_view_three_image, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout1);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        AdvertRatioLayout advertRatioLayout2 = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout2);
        this._g = advertRatioLayout2;
        advertRatioLayout2.setRatio(this._m);
        AdvertRatioLayout advertRatioLayout3 = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout3);
        this._h = advertRatioLayout3;
        advertRatioLayout3.setRatio(this._m);
        this._s = (TextView) viewInflate.findViewById(R.id.ptgTvTitle);
        this._t = (ImageView) viewInflate.findViewById(R.id.ptgImgCover1);
        this._u = (ImageView) viewInflate.findViewById(R.id.ptgImgCover2);
        this._v = (ImageView) viewInflate.findViewById(R.id.ptgImgCover3);
        _p5._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.fancy._ap
    public void setAd(_f _fVar) {
        try {
            setVisibility(8);
            _aq._a(_fVar, this._s, true);
            _a(_fVar, 0, this._t, this._f, new _a());
            _a(_fVar, 1, this._u, this._g, null);
            _a(_fVar, 2, this._v, this._h, null);
        } catch (Exception e) {
            _v _vVar = this._a;
            if (_vVar != null) {
                _vVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, e);
            }
        }
    }

    public class _a implements _d0 {
        public _a() {
        }

        @Override // com.fancy._d0
        public final void _a(Exception exc) {
            _ai _aiVar = _ai.this;
            _v _vVar = _aiVar._a;
            if (_vVar != null) {
                _vVar._a(_aiVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }

        @Override // com.fancy._d0
        public final void _a() {
            _ai.this.setVisibility(0);
            _v _vVar = _ai.this._a;
            if (_vVar != null) {
                _vVar._a();
            }
        }
    }
}
