package com.fancy;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;
import com.fancy.mpsdk.component.widgets.PtgShakeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _af extends _aq {
    public ImageView _s;

    public _af(Context context) {
        super(context);
    }

    @Override // com.fancy._ap
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.fancy_banner_view_image, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        this._s = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        _p5._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.fancy._ap
    public void setAd(_f _fVar) {
        try {
            setVisibility(8);
            AdSlot adSlot = this._b;
            if (adSlot != null) {
                setAdvertColor(adSlot.getExpressViewColor());
            }
            _a(_fVar, 0, this._s, this._f, new _a());
        } catch (Exception e) {
            _v _vVar = this._a;
            if (_vVar != null) {
                _vVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, e);
            }
        }
    }

    public void setAdvertColor(String str) {
        int color;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            color = Color.parseColor(str);
        } catch (Exception unused) {
            color = Color.parseColor("#FFFFFF");
        }
        this._e.setBackgroundColor(color);
    }

    public class _a implements _d0 {
        public _a() {
        }

        @Override // com.fancy._d0
        public final void _a(Exception exc) {
            _af _afVar = _af.this;
            _v _vVar = _afVar._a;
            if (_vVar != null) {
                _vVar._a(_afVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }

        @Override // com.fancy._d0
        public final void _a() {
            _af.this.setVisibility(0);
            _v _vVar = _af.this._a;
            if (_vVar != null) {
                _vVar._a();
            }
        }
    }
}
