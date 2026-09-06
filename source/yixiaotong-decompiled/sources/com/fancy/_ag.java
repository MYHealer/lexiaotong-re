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
import com.fancy.mpsdk.component.base.AdvertRatioLayout;
import com.fancy.mpsdk.component.widgets.PtgShakeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ag extends _aq {
    public TextView _s;
    public ImageView _t;

    public _ag(Context context) {
        super(context);
    }

    @Override // com.fancy._ap
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.fancy_banner_view_left_image, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        this._s = (TextView) viewInflate.findViewById(R.id.ptgTvTitle);
        this._t = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        _p5._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.fancy._ap
    public void setAd(_f _fVar) {
        try {
            setVisibility(8);
            _aq._a(_fVar, this._s, false);
            _a(_fVar, 0, this._t, this._f, new _a());
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
            _ag _agVar = _ag.this;
            _v _vVar = _agVar._a;
            if (_vVar != null) {
                _vVar._a(_agVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }

        @Override // com.fancy._d0
        public final void _a() {
            _ag.this.setVisibility(0);
            _v _vVar = _ag.this._a;
            if (_vVar != null) {
                _vVar._a();
            }
        }
    }
}
