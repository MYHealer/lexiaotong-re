package com.fancy;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.mpsdk.component.base.AdvertRatioLayout;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import com.fancy.mpsdk.component.widgets.PtgShakeView;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _aq extends _ap {
    public _jw _c;
    public View _d;
    public ViewGroup _e;
    public AdvertRatioLayout _f;
    public AdvertRatioLayout _g;
    public AdvertRatioLayout _h;
    public ImageView _i;
    public PtgVideoView _j;
    public LinearLayout _k;
    public PtgShakeView _l;
    public float _m;
    public _i9 _n;
    public _l4._b _o;
    public _l7 _p;
    public MediaPlayer.OnCompletionListener _q;
    public NiceVideoPlayer._i _r;

    public class _a implements View.OnClickListener {
        public _a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _jw _jwVar = _aq.this._c;
            if (_jwVar != null) {
                _do._a _aVar = (_do._a) _jwVar;
                _f _fVar = _do.this._c;
                if (_fVar != null && _fVar._A) {
                    int i_a = _p5._a(view);
                    if (i_a == 6 || i_a == 4) {
                        _do.this._b(view, _p5._a(view), null);
                    } else {
                        _do.this._a(view, 0, null);
                    }
                }
            }
        }
    }

    public class _c implements View.OnClickListener {
        public _c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            PtgNativeExpressAd.AdInteractionListener adInteractionListener;
            _aq _aqVar = _aq.this;
            PtgVideoView ptgVideoView = _aqVar._j;
            if (ptgVideoView != null) {
                ptgVideoView._b();
                _aqVar._j.setOnErrorListener(null);
                _aqVar._j = null;
            }
            _jw _jwVar = _aq.this._c;
            if (_jwVar == null || (adInteractionListener = _do.this._a) == null) {
                return;
            }
            adInteractionListener.onAdDismiss();
        }
    }

    public class _d implements AdvertRatioLayout._a {
        public _d() {
        }

        @Override // com.fancy.mpsdk.component.base.AdvertRatioLayout._a
        public final void _a(int i, int i2) {
            ImageView imageView;
            PtgShakeView ptgShakeView = _aq.this._l;
            if (ptgShakeView == null || (imageView = ptgShakeView._a) == null) {
                return;
            }
            imageView.post(new _kt(ptgShakeView, i, i2));
        }
    }

    public _aq(Context context) {
        super(context);
        new AtomicBoolean(false);
        this._m = 0.55f;
        _c();
        _d();
    }

    public static void _a(_f _fVar, TextView textView, boolean z) {
        int i;
        if (_fVar == null || textView == null) {
            return;
        }
        if (TextUtils.isEmpty(_fVar._l())) {
            i = z ? 8 : 4;
        } else {
            textView.setText(_fVar._l());
            i = 0;
        }
        textView.setVisibility(i);
    }

    public void _a(int i) {
    }

    public final void _a(_f _fVar, float f, _d0 _d0Var) {
        PtgVideoView ptgVideoView;
        if (_fVar == null || (ptgVideoView = this._j) == null) {
            _d0Var._a(new Exception("广告信息为空"));
            return;
        }
        ptgVideoView.setSizeCallback(new _d());
        this._j._a(_fVar, f, this._o);
        this._j.setShowPlayButton(true);
        this._j.setVideoStateListener(this._p);
        this._j.setOnCompletionListener(this._q);
        this._j.setOnErrorListener(this._r);
        this._j._a(_d0Var);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0039 A[PHI: r2
  0x0039: PHI (r2v3 int) = (r2v2 int), (r2v1 int) binds: [B:24:0x0045, B:19:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    public final void _a(_f _fVar, int i, ImageView imageView, AdvertRatioLayout advertRatioLayout, _d0 _d0Var) {
        _jz _jzVar;
        String str;
        int iDp2px;
        int iDp2px2;
        if (_fVar == null || advertRatioLayout == null || imageView == null) {
            return;
        }
        if (!_fVar._u()) {
            List<_jz> list_h = _fVar._h();
            if (list_h == null || list_h.isEmpty()) {
                str = "";
            } else {
                int i2 = 1;
                if (i != 1) {
                    i2 = 2;
                    if (i != 2 || list_h.size() <= 2) {
                        _jzVar = list_h.get(0);
                    } else {
                        _jzVar = list_h.get(i2);
                    }
                } else if (list_h.size() > 1) {
                    _jzVar = list_h.get(i2);
                } else {
                    _jzVar = list_h.get(0);
                }
                str = _jzVar._a;
            }
        } else if (_fVar._m() != null) {
            str = _fVar._m()._a;
        } else {
            str = "";
        }
        String str2 = str;
        AdSlot adSlot = this._b;
        if (adSlot != null) {
            iDp2px = ScreenUtils.dp2px(adSlot.getExpressViewAcceptedWidth());
            iDp2px2 = ScreenUtils.dp2px(this._b.getExpressViewAcceptedHeight());
        } else {
            iDp2px = 0;
            iDp2px2 = 0;
        }
        advertRatioLayout.setSizeCallback(new _ar(this, _fVar, imageView, str2, iDp2px, iDp2px2, advertRatioLayout, _d0Var));
        _as _asVar = new _as(this, advertRatioLayout, imageView, _d0Var);
        AtomicBoolean atomicBoolean = _ev._a;
        _m3 _m3VarLoad = Doodle.load(str2);
        _m3VarLoad._d = iDp2px;
        _m3VarLoad._e = iDp2px2;
        _m3VarLoad._h = false;
        _m3VarLoad._n = new _eu(_asVar);
        _m3VarLoad._a(iDp2px, iDp2px2);
    }

    public final void _c() {
        View view = this._d;
        if (view != null) {
            view.setOnClickListener(new _c());
        }
    }

    public final void _d() {
        ViewGroup viewGroup = this._e;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(new _a());
            setAdRenderListener(new _b());
        }
    }

    public ViewGroup getAdRootView() {
        return this._e;
    }

    public View getShakeLayout() {
        return this._k;
    }

    @Override // com.fancy._ap, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this._d == null) {
            throw new IllegalStateException("确实 dislike 组件");
        }
        if (this._e == null) {
            throw new IllegalStateException("缺失指定 click 组件");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:? A[RETURN, SYNTHETIC] */
    public void setAdLayoutParams(AdSlot adSlot) {
        int iDp2px;
        int iDp2px2;
        int iDp2px3;
        ViewGroup viewGroup;
        float f = 0.0f;
        int iDp2px4 = 0;
        try {
            int iDp2px5 = ScreenUtils.dp2px(adSlot.getExpressViewAcceptedWidth());
            int iDp2px6 = ScreenUtils.dp2px(adSlot.getExpressViewAcceptedHeight());
            iDp2px = ScreenUtils.dp2px(adSlot.getExpressViewPaddingLeft());
            try {
                iDp2px2 = ScreenUtils.dp2px(adSlot.getExpressViewPaddingTop());
                try {
                    iDp2px3 = ScreenUtils.dp2px(adSlot.getExpressViewPaddingRight());
                    try {
                        iDp2px4 = ScreenUtils.dp2px(adSlot.getExpressViewPaddingBottom());
                        int i = (iDp2px5 - iDp2px) - iDp2px3;
                        int i2 = (iDp2px6 - iDp2px2) - iDp2px4;
                        if (i > 0 && i2 > 0) {
                            f = i2 / i;
                        }
                    } catch (Exception unused) {
                        Logger.e("realWidth or realHeight is 0");
                    }
                } catch (Exception unused2) {
                    iDp2px3 = 0;
                }
            } catch (Exception unused3) {
                iDp2px2 = 0;
                iDp2px3 = iDp2px2;
                Logger.e("realWidth or realHeight is 0");
                setNativeRatio(f);
                viewGroup = this._e;
                if (viewGroup == null) {
                    return;
                }
                viewGroup.setPadding(iDp2px, iDp2px2, iDp2px3, iDp2px4);
            }
        } catch (Exception unused4) {
            iDp2px = 0;
            iDp2px2 = 0;
        }
        setNativeRatio(f);
        viewGroup = this._e;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setPadding(iDp2px, iDp2px2, iDp2px3, iDp2px4);
    }

    public void setExpressAdInteractionListener(_jw _jwVar) {
        this._c = _jwVar;
    }

    public void setNativeRatio(float f) {
        this._m = f;
        AdvertRatioLayout advertRatioLayout = this._f;
        if (advertRatioLayout != null) {
            advertRatioLayout.setRatio(f);
        }
        AdvertRatioLayout advertRatioLayout2 = this._g;
        if (advertRatioLayout2 != null) {
            advertRatioLayout2.setRatio(f);
        }
        AdvertRatioLayout advertRatioLayout3 = this._h;
        if (advertRatioLayout3 != null) {
            advertRatioLayout3.setRatio(f);
        }
        PtgVideoView ptgVideoView = this._j;
        if (ptgVideoView != null) {
            ptgVideoView.setVideoRatio(f);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this._q = onCompletionListener;
    }

    public void setOnErrorListener(NiceVideoPlayer._i _iVar) {
        this._r = _iVar;
    }

    public void setVideoProgressListener(_l4._b _bVar) {
        this._o = _bVar;
    }

    public void setVideoStateListener(_l7 _l7Var) {
        this._p = _l7Var;
    }

    @Override // com.fancy._ap
    public void setVisibilityChanged(_an._a _aVar) {
    }

    public class _b implements _v {
        public _b() {
        }

        @Override // com.fancy._v
        public final void _a(View view, int i, Exception exc) {
            _jw _jwVar = _aq.this._c;
            if (_jwVar != null) {
                AdErrorImpl adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_RESOURCE_ERROR, exc.getMessage(), (Object) null);
                PtgNativeExpressAd.AdInteractionListener adInteractionListener = _do.this._a;
                if (adInteractionListener != null) {
                    adInteractionListener.onRenderFail(adErrorImpl);
                }
            }
        }

        @Override // com.fancy._v
        public final void _a() {
            _jw _jwVar = _aq.this._c;
            if (_jwVar != null) {
                _do._a _aVar = (_do._a) _jwVar;
                _do _doVar = _do.this;
                if (_doVar._a != null) {
                    if (!_doVar._M) {
                        _do.this._M = true;
                        _do _doVar2 = _do.this;
                        _doVar2._a.onRenderSuccess(_doVar2);
                    }
                    _do.this._f();
                }
            }
        }
    }
}
