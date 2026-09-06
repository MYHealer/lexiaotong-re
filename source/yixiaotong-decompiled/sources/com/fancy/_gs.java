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
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.widgets.PtgShakeView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gs extends _aq {
    public TextView _s;

    public class _a implements _d0 {
        public _a() {
        }

        @Override // com.fancy._d0
        public final void _a() {
            _gs.this.setVisibility(0);
            _v _vVar = _gs.this._a;
            if (_vVar != null) {
                _vVar._a();
            }
        }

        @Override // com.fancy._d0
        public final void _a(Exception exc) {
            _gs _gsVar = _gs.this;
            _v _vVar = _gsVar._a;
            if (_vVar != null) {
                _vVar._a(_gsVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }
    }

    public class _b implements _d0 {
        public _b() {
        }

        @Override // com.fancy._d0
        public final void _a() {
            _gs.this.setVisibility(0);
            _v _vVar = _gs.this._a;
            if (_vVar != null) {
                _vVar._a();
            }
        }

        @Override // com.fancy._d0
        public final void _a(Exception exc) {
            _gs _gsVar = _gs.this;
            _v _vVar = _gsVar._a;
            if (_vVar != null) {
                _vVar._a(_gsVar, PtgErrorCode.SDK_RESOURCE_ERROR, exc);
            }
        }
    }

    public _gs(Context context) {
        super(context);
    }

    @Override // com.fancy._aq
    public final void _a(int i) {
        AdvertRatioLayout advertRatioLayout = this._f;
        if (advertRatioLayout != null) {
            advertRatioLayout.setLayoutParams(new FrameLayout.LayoutParams(i - ScreenUtils.dp2px(20.0f), -2));
        }
    }

    @Override // com.fancy._ap
    public final void _a(Context context) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.fancy_native_view_text_float, (ViewGroup) null);
        this._e = (ViewGroup) viewInflate.findViewById(R.id.ptgRootView);
        this._d = viewInflate.findViewById(R.id.ptgImgClose);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ptgShakeLayout);
        this._k = linearLayout;
        this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
        AdvertRatioLayout advertRatioLayout = (AdvertRatioLayout) viewInflate.findViewById(R.id.ptgCoverLayout);
        this._f = advertRatioLayout;
        advertRatioLayout.setRatio(this._m);
        this._s = (TextView) viewInflate.findViewById(R.id.ptgTvTitle);
        this._i = (ImageView) viewInflate.findViewById(R.id.ptgImgCover);
        PtgVideoView ptgVideoView = (PtgVideoView) viewInflate.findViewById(R.id.ptgVideoView);
        this._j = ptgVideoView;
        ptgVideoView.setVideoRatio(this._m);
        this._j.setSoundGravity(85);
        _p5._a((ImageView) viewInflate.findViewById(R.id.ptg_sdk_ad_logo_iv));
        addView(viewInflate, -1, -2);
    }

    @Override // com.fancy._ap
    public void setAd(_f _fVar) {
        try {
            setVisibility(8);
            _aq._a(_fVar, this._s, false);
            if (_fVar._u()) {
                _a(_fVar, this._m, new _a());
            } else {
                _a(_fVar, 0, this._i, this._f, new _b());
            }
        } catch (Exception e) {
            _v _vVar = this._a;
            if (_vVar != null) {
                _vVar._a(this, PtgErrorCode.SDK_RESOURCE_ERROR, e);
            }
        }
    }
}
