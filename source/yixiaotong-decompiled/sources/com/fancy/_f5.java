package com.fancy;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.mpsdk.activity.PtgInteractionPortraitActivity;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.widgets.PlaceholderImageView;
import com.fancy.mpsdk.component.widgets.PtgConfirmBtn;
import com.fancy.mpsdk.component.widgets.PtgShakeView;
import com.fancy.mpsdk.widget.PtgRoundFrameLayout;
import com.google.android.exoplayer2.C;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _f5 extends FrameLayout {
    public _4 _a;
    public String _b;
    public _f _c;
    public int _d;
    public int _e;
    public View _f;
    public FrameLayout _g;
    public PtgVideoView _h;
    public RelativeLayout _i;
    public ImageView _j;
    public LinearLayout _k;
    public PtgShakeView _l;
    public TextView _m;
    public TextView _n;
    public PlaceholderImageView _o;
    public int _p;
    public int _q;
    public float _r;

    public class _a implements View.OnClickListener {
        public final /* synthetic */ PtgConfirmBtn _a;

        public _a(PtgConfirmBtn ptgConfirmBtn) {
            this._a = ptgConfirmBtn;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _4 _4 = _f5.this._a;
            if (_4 != null) {
                PtgConfirmBtn ptgConfirmBtn = this._a;
                _fc _fcVar = ((_fe) _4)._c;
                _f _fVar = _fcVar._d;
                if (_fVar != null && _fVar._A) {
                    _fcVar._a(ptgConfirmBtn, 0, null, false);
                }
            }
        }
    }

    public class _b implements View.OnClickListener {
        public _b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            _4 _4 = _f5.this._a;
            if (_4 != null) {
                _fe _feVar = (_fe) _4;
                _feVar._c._f = true;
                _f2 _f2Var = _feVar._a;
                if (_f2Var != null) {
                    PtgInteractionPortraitActivity.this.onBackPressed();
                }
            }
        }
    }

    public class _c implements Runnable {
        public _c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Exception exc;
            _f5 _f5Var = _f5.this;
            _f5Var._p = _f5Var._g.getWidth();
            _f5 _f5Var2 = _f5.this;
            _f5Var2._q = _f5Var2._g.getHeight();
            _f5.this._c();
            _f5 _f5Var3 = _f5.this;
            if (!_f5Var3._c._u()) {
                List<_jz> list_h = _f5Var3._c._h();
                String str = (list_h == null || list_h.isEmpty()) ? "" : list_h.get(0)._a;
                _f7 _f7Var = new _f7(_f5Var3, str);
                AtomicBoolean atomicBoolean = _ev._a;
                _m3 _m3VarLoad = Doodle.load(str);
                _m3VarLoad._h = false;
                _m3VarLoad._n = new _et(_f7Var);
                _m3VarLoad._a(_m3VarLoad._d, _m3VarLoad._e);
                return;
            }
            _f _fVar = _f5Var3._c;
            float f = _f5Var3._r;
            _f6 _f6Var = new _f6(_f5Var3);
            if (_fVar == null || _f5Var3._h == null) {
                exc = new Exception("广告数据异常");
            } else {
                if (_fVar._u()) {
                    _f5Var3._h._a(_fVar, f, new _f8(_f5Var3));
                    _f5Var3._h.setOnErrorListener(new _f9(_f5Var3));
                    _f5Var3._h.setOnCompletionListener(new _fa(_f5Var3));
                    _f5Var3._h.setVideoStateListener(new _fb(_f5Var3));
                    _f5Var3._h._a(_f6Var);
                    _f5Var3._h.setShowPlayButton(true);
                    return;
                }
                exc = new Exception("广告类型异常");
            }
            _f6Var._a(exc);
        }
    }

    public _f5(Context context) {
        super(context);
        this._d = 0;
        this._e = 0;
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0136  */
    public final View _a() {
        int screenRealWidth;
        int i_g;
        FrameLayout.LayoutParams layoutParams;
        int iDp2px;
        try {
            setVisibility(4);
            View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.fancy_layout_interaction, (ViewGroup) null);
            this._f = viewInflate;
            this._i = (RelativeLayout) viewInflate.findViewById(R.id.iconTextLayout);
            PtgConfirmBtn ptgConfirmBtn = (PtgConfirmBtn) this._f.findViewById(R.id.advertBtn);
            _n1._a(this._f, ptgConfirmBtn, (View) null);
            ptgConfirmBtn.setOnClickListener(new _a(ptgConfirmBtn));
            PtgRoundFrameLayout ptgRoundFrameLayout = (PtgRoundFrameLayout) this._f.findViewById(R.id.closeAdvertLayout);
            ptgRoundFrameLayout.setOnClickListener(new _b());
            this._g = (FrameLayout) this._f.findViewById(R.id.imageLayout);
            this._j = (ImageView) this._f.findViewById(R.id.advertIv);
            LinearLayout linearLayout = (LinearLayout) this._f.findViewById(R.id.ptg_shake_layout);
            this._k = linearLayout;
            this._l = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
            this._m = (TextView) this._f.findViewById(R.id.titleTv);
            this._n = (TextView) this._f.findViewById(R.id.subtitleTv);
            this._o = (PlaceholderImageView) this._f.findViewById(R.id.sourceIv);
            PtgVideoView ptgVideoView = (PtgVideoView) this._f.findViewById(R.id.ptgVideoView);
            this._h = ptgVideoView;
            ptgVideoView.setSoundMarginTop(ScreenUtils.dp2px(6.0f));
            if (this._e == 1 && (layoutParams = (FrameLayout.LayoutParams) ptgRoundFrameLayout.getLayoutParams()) != null) {
                if (this._d == 0) {
                    PtgVideoView ptgVideoView2 = this._h;
                    if (ptgVideoView2 != null) {
                        ptgVideoView2.setSoundMarginTop(ScreenUtils.dp2px(6.0f));
                    }
                    layoutParams.topMargin = ScreenUtils.dp2px(15.0f);
                    iDp2px = ScreenUtils.dp2px(15.0f);
                } else {
                    PtgVideoView ptgVideoView3 = this._h;
                    if (ptgVideoView3 != null) {
                        ptgVideoView3.setSoundMarginTop(ScreenUtils.dp2px(11.0f));
                    }
                    layoutParams.topMargin = ScreenUtils.dp2px(30.0f);
                    iDp2px = ScreenUtils.dp2px(38.0f);
                }
                layoutParams.rightMargin = iDp2px;
                ptgRoundFrameLayout.setLayoutParams(layoutParams);
            }
            _p5._a((ImageView) this._f.findViewById(R.id.ptg_sdk_ad_logo_iv));
            int screenRealWidth2 = -1;
            if (this._e == 1) {
                screenRealWidth = -1;
            } else if (this._d == 0) {
                screenRealWidth2 = (int) (ScreenUtils.getScreenRealWidth(getContext()) * 0.8f);
                this._p = screenRealWidth2;
                _f _fVar = this._c;
                if (_fVar != null) {
                    i_g = (int) (((double) screenRealWidth2) * (((double) _fVar._g()) / ((double) this._c._p())));
                    if (i_g > screenRealWidth2) {
                        i_g = screenRealWidth2;
                    }
                } else {
                    i_g = screenRealWidth2;
                }
                this._q = i_g;
                this._g.setLayoutParams(new LinearLayout.LayoutParams(this._p, this._q));
                screenRealWidth = -2;
            } else {
                screenRealWidth = (int) (ScreenUtils.getScreenRealWidth(getContext()) * 0.85f);
                ((LinearLayout) this._f.findViewById(R.id.advertRootLayout)).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                screenRealWidth2 = (int) (screenRealWidth * 1.0f);
            }
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(screenRealWidth2, screenRealWidth);
            layoutParams2.gravity = 17;
            addView(this._f, layoutParams2);
            _b();
            _c();
            this._g.post(new _c());
        } catch (Exception e) {
            _4 _4 = this._a;
            if (_4 != null) {
                ((_fe) _4)._a(_ie._a("布局初始失败：").append(e.getMessage()).toString());
            }
        }
        return this._f;
    }

    public final void _b() {
        try {
            String str_l = this._c._l();
            String str_d = this._c._d();
            String str_i = this._c._i();
            boolean z = TextUtils.isEmpty(str_l) && TextUtils.isEmpty(str_d);
            if (this._m != null) {
                if (TextUtils.isEmpty(str_l)) {
                    this._m.setVisibility(8);
                } else {
                    this._m.setText(str_l);
                    this._m.setVisibility(0);
                }
            }
            if (this._n != null) {
                if (TextUtils.isEmpty(str_d)) {
                    this._n.setVisibility(8);
                } else {
                    this._n.setText(str_d);
                    this._n.setVisibility(0);
                }
            }
            if (this._o != null) {
                if (TextUtils.isEmpty(str_i)) {
                    this._o.setVisibility(8);
                } else {
                    _ev._a(str_i, this._o);
                    this._o.setVisibility(0);
                }
            }
            RelativeLayout relativeLayout = this._i;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(z ? 8 : 0);
            }
        } catch (Exception e) {
            _4 _4 = this._a;
            if (_4 != null) {
                ((_fe) _4)._a(_ie._a("渲染失败：").append(e.getMessage()).toString());
            }
        }
    }

    public final void _c() {
        int i;
        _i9 _i9Var_a;
        int i2 = this._p;
        if (i2 <= 0 || (i = this._q) <= 0) {
            return;
        }
        this._r = i / i2;
        if (this._j != null && (_i9Var_a = _m5._a(this._c, i2, i)) != null) {
            this._j.setLayoutParams(_i9Var_a._a);
            if (_i9Var_a._b) {
                List<_jz> list_h = this._c._h();
                _m3 _m3VarLoad = Doodle.load((list_h == null || list_h.isEmpty()) ? "" : list_h.get(0)._a);
                _m3VarLoad._i = true;
                _m3VarLoad._h = false;
                _ax._a(getContext(), _m3VarLoad._a(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS), this._g);
            }
        }
        PtgShakeView ptgShakeView = this._l;
        if (ptgShakeView != null) {
            int i3 = this._p;
            int i4 = this._q;
            ImageView imageView = ptgShakeView._a;
            if (imageView == null) {
                return;
            }
            imageView.post(new _kt(ptgShakeView, i3, i4));
        }
    }

    public void setAdvertActionCallback(_4 _4) {
        this._a = _4;
    }

    public void setAdvertHashCode(String str) {
        this._b = str;
    }

    public void setAdvertInfo(_f _fVar) {
        this._c = _fVar;
    }

    public void setInteractionCallback(_f2 _f2Var) {
    }

    public void setScreenMode(int i) {
        this._e = i;
    }

    public void setScreenType(int i) {
        this._d = i;
    }

    public void setShakeLayoutVisible(boolean z) {
        LinearLayout linearLayout = this._k;
        if (linearLayout != null) {
            linearLayout.setVisibility(z ? 0 : 8);
        }
    }
}
