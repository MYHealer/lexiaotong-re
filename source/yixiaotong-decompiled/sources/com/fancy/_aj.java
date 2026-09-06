package com.fancy;

import android.content.Context;
import android.text.TextUtils;
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
public final class _aj extends _aq {
    public TextView _s;
    public TextView _t;
    public ImageView _u;

    public _aj(Context context) {
        super(context);
    }

    @Override // com.fancy._aq
    public final void _a(int i) {
        AdvertRatioLayout advertRatioLayout = this._f;
        if (advertRatioLayout != null) {
            advertRatioLayout.setLayoutParams(new LinearLayout.LayoutParams(i - ScreenUtils.dp2px(20.0f), -2));
        }
    }

    @Override // com.fancy._ap
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.fancy_banner_view_top_image, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        this._s = (TextView) viewInflate.findViewById(R.id.ptgTvTitle);
        this._t = (TextView) viewInflate.findViewById(R.id.ptgTvSource);
        this._u = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        _p5._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.fancy._ap
    public void setAd(_f _fVar) {
        try {
            setVisibility(8);
            _aq._a(_fVar, this._s, true);
            TextView textView = this._t;
            if (_fVar != null && textView != null) {
                if (TextUtils.isEmpty(_fVar._j())) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(_fVar._j());
                    textView.setVisibility(0);
                }
            }
            _a(_fVar, 0, this._u, this._f, new _a());
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
            _aj _ajVar = _aj.this;
            _v _vVar = _ajVar._a;
            if (_vVar != null) {
                _vVar._a(_ajVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }

        @Override // com.fancy._d0
        public final void _a() {
            _aj.this.setVisibility(0);
            _v _vVar = _aj.this._a;
            if (_vVar != null) {
                _vVar._a();
            }
        }
    }
}
