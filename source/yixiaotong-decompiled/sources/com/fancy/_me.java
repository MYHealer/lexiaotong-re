package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgAppDownloadListener;
import com.fancy.adsdk.lib.interf.PtgRewardVideoAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.mpsdk.activity.PtgBaseVideoActivity;
import com.fancy.mpsdk.activity.PtgRewardVideoPortraitActivity;
import com.fancy.mpsdk.activity.PtgWebActivity;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import com.fancy.mpsdk.component.widgets.PlaceholderImageView;
import com.fancy.mpsdk.component.widgets.PtgShakeView;
import com.fancy.mpsdk.provider.PtgApiProvider;
import com.fancy.mpsdk.widget.PtgRoundLinearLayout;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _me implements _md {
    public static int _ae;
    public TextView _0;
    public TextView _1;
    public LinearLayout _2;
    public TextView _3;
    public TextView _4;
    public TextView _5;
    public TextView _6;
    public TextView _7;
    public TextView _8;
    public LinearLayout _9;
    public FrameLayout _B;
    public _l4 _C;
    public NiceVideoPlayer _D;
    public _l6 _E;
    public _jd _F;
    public ProgressBar _G;
    public FrameLayout _H;
    public ImageView _I;
    public TextView _J;
    public ImageView _K;
    public PtgRoundLinearLayout _L;
    public ImageView _M;
    public LinearLayout _N;
    public PlaceholderImageView _O;
    public TextView _P;
    public TextView _Q;
    public LinearLayout _R;
    public TextView _S;
    public TextView _T;
    public TextView _U;
    public TextView _V;
    public TextView _W;
    public TextView _X;
    public LinearLayout _Y;
    public PlaceholderImageView _Z;
    public _f0 _a;
    public LinearLayout _a0;
    public PtgShakeView _a1;
    public PtgShakeView _a2;
    public boolean _a3;
    public String _a4;
    public boolean _a6;
    public AtomicBoolean _a7;
    public _i _a9;
    public boolean _ab;
    public _b9 _ad;
    public com.fancy._f _b;
    public AdSlot _c;
    public int _d;
    public int _e;
    public int _g;
    public String _h;
    public String _i;
    public String _j;
    public String _k;
    public String _l;
    public String _m;
    public String _n;
    public String _o;
    public String _p;
    public String _q;
    public boolean _r;
    public int _u;
    public int _v;
    public String _w;
    public boolean _f = true;
    public int _s = 0;
    public int _t = 0;
    public boolean _x = false;
    public boolean _y = false;
    public boolean _z = false;
    public boolean _A = false;
    public int _a5 = 0;
    public final _a _a8 = new _a();
    public final AtomicBoolean _aa = new AtomicBoolean();
    public final _c _ac = new _c();

    public class _b implements _b4<Boolean> {
        public _b() {
        }

        @Override // com.fancy._b4
        public final void onError(AdError adError) {
            _me _meVar = _me.this;
            _meVar._A = false;
            _meVar._a(adError.getErrorCode(), adError.getMessage(), false);
        }

        @Override // com.fancy._b4
        public final void _a(Boolean bool) {
            PtgRewardConstant.ServerErr serverErr;
            String msg;
            boolean z;
            int code;
            Boolean bool2 = bool;
            _me _meVar = _me.this;
            _meVar._A = false;
            if (bool2 != null) {
                if (bool2.booleanValue()) {
                    _meVar = _me.this;
                    PtgRewardConstant.ServerErr serverErr2 = PtgRewardConstant.ServerErr.SUC;
                    code = serverErr2.getCode();
                    msg = serverErr2.getMsg();
                    z = true;
                } else {
                    _meVar = _me.this;
                    serverErr = PtgRewardConstant.ServerErr.SUC_ERR;
                }
                _meVar._a(code, msg, z);
            }
            serverErr = PtgRewardConstant.ServerErr.ERR_DATA;
            int code2 = serverErr.getCode();
            msg = serverErr.getMsg();
            z = false;
            code = code2;
            _meVar._a(code, msg, z);
        }
    }

    public class _c implements PtgAppDownloadListener {
        public _c() {
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadActive(long j, long j2, String str) {
            Logger.d("RewardVideoManagerTag", "onDownloadActive totalBytes:" + j + " currBytes: " + j2 + " appName: " + str);
            _m8._a()._a(_me.this._a4, j, j2, str);
            _me._a(_me.this, j, j2);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadCancel() {
            Logger.d("RewardVideoManagerTag", "onDownloadCancel");
            _m8._a()._c(_me.this._a4);
            _me _meVar = _me.this;
            _meVar._a(_meVar._X);
            _me _meVar2 = _me.this;
            _meVar2._a(_meVar2._8);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadFailed(String str) {
            Logger.d("RewardVideoManagerTag", "onDownloadFailed: " + str);
            _m8._a()._a(_me.this._a4, str);
            _me _meVar = _me.this;
            _meVar._a(_meVar._X);
            _me _meVar2 = _me.this;
            _meVar2._a(_meVar2._8);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadFinished(String str) {
            Logger.d("RewardVideoManagerTag", "onDownloadFinished appName: " + str);
            _m8._a()._b(_me.this._a4, str);
            _me _meVar = _me.this;
            _meVar._a(_meVar._X);
            _me _meVar2 = _me.this;
            _meVar2._a(_meVar2._8);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onDownloadPaused(long j, long j2, String str) {
            Logger.d("RewardVideoManagerTag", "onDownloadPaused totalBytes:" + j + " currBytes: " + j2 + " appName: " + str);
            _m8._a()._b(_me.this._a4, j, j2, str);
            _me._a(_me.this, j, j2);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onIdle() {
            Logger.d("RewardVideoManagerTag", "onIdle");
            _m8._a()._d(_me.this._a4);
        }

        @Override // com.fancy.adsdk.lib.interf.PtgAppDownloadListener
        public final void onInstalled(String str) {
            Logger.d("RewardVideoManagerTag", "onInstalled");
            _m8._a()._c(_me.this._a4, str);
            _me _meVar = _me.this;
            _meVar._a(_meVar._X);
            _me _meVar2 = _me.this;
            _meVar2._a(_meVar2._8);
        }
    }

    public class _e implements View.OnClickListener {
        public _e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (com.fancy.adsdk.lib.utils._a._f() || _me.this._b == null) {
                return;
            }
            int i_a = _p5._a(view);
            if (i_a != 6 && i_a != 4) {
                _me.this._a(view, 0, null, false);
                return;
            }
            _me _meVar = _me.this;
            _meVar._a(view, _p5._a(view), null, true);
            _n1._a(_meVar._B, view, (View) null);
        }
    }

    public class _f implements View.OnClickListener {
        public _f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = view.getContext();
            String str = _me.this._p;
            int i = PtgWebActivity._g;
            _s _sVar = new _s();
            _sVar._a = str;
            try {
                Intent intent = new Intent(context, (Class<?>) PtgWebActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("playerInfo", _sVar);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public class _g implements View.OnClickListener {
        public _g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = view.getContext();
            String str = _me.this._o;
            int i = PtgWebActivity._g;
            _s _sVar = new _s();
            _sVar._a = str;
            try {
                Intent intent = new Intent(context, (Class<?>) PtgWebActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("playerInfo", _sVar);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public class _h implements View.OnClickListener {
        public _h() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Context context = view.getContext();
            String str = _me.this._q;
            int i = PtgWebActivity._g;
            _s _sVar = new _s();
            _sVar._a = str;
            try {
                Intent intent = new Intent(context, (Class<?>) PtgWebActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("playerInfo", _sVar);
                context.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static class _i extends Handler {
        public final WeakReference<_me> _a;
        public int _b;

        public _i(_me _meVar, int i) {
            super(Looper.getMainLooper());
            this._a = new WeakReference<>(_meVar);
            this._b = i;
            _me._ae = (int) (Math.floor(((double) i) / 1000.0d) * 1000.0d);
            Logger.d("RewardVideo", "SafeHandler countDownTime:" + this._b);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            _me _meVar = this._a.get();
            if (_meVar != null) {
                int i = this._b;
                int i2 = _me._ae;
                if (i2 > 0) {
                    long j = i - i2;
                    _l6 _l6Var = _meVar._E;
                    if (_l6Var != null) {
                        _l6Var._a(_meVar._b, j);
                    }
                    long j2 = i;
                    _meVar._a(j2, i - _me._ae);
                    if (!_meVar._r) {
                        _m8._a()._a(j2, i - _me._ae, _meVar._a4);
                    }
                    _i _iVar = _meVar._a9;
                    if (_iVar != null) {
                        _iVar.sendEmptyMessageDelayed(0, 1000L);
                    }
                } else {
                    long j3 = i;
                    _meVar._a(j3, j3);
                    _l6 _l6Var2 = _meVar._E;
                    if (_l6Var2 != null) {
                        _l6Var2._a(_meVar._b, -1L);
                    }
                    if (!_meVar._r) {
                        _m8._a()._a(j3, i - _me._ae, _meVar._a4);
                        _m8._a()._e(_meVar._a4);
                        _meVar._x = true;
                        _meVar._e();
                    }
                }
                _me._ae -= 1000;
            }
        }
    }

    public static void _a(_me _meVar, long j, long j2) {
        if (_meVar._X == null || _meVar._8 == null) {
            return;
        }
        String str = (j <= 0 || j2 <= 0) ? "已下载 0%" : String.format(Locale.CHINA, "已下载 %d%%", Integer.valueOf((int) ((j2 / j) * 100.0f)));
        _meVar._X.setText(str);
        _meVar._8.setText(str);
    }

    @Override // com.fancy._md
    public final void _a() {
        _jd _jdVar = this._F;
        if (_jdVar != null) {
            _jdVar._a(this._a6);
        }
        _cv._a(PtgAdSdk.getContext(), this._b);
    }

    @Override // com.fancy._md
    public final void _b() {
    }

    public final void _b(int i) {
        String rewardName;
        int rewardAmount;
        if (i != 0 || this._y || this._A) {
            return;
        }
        if (1 != this._v) {
            PtgRewardConstant.ServerErr serverErr = PtgRewardConstant.ServerErr.DEF;
            _a(serverErr.getCode(), serverErr.getMsg(), true);
            return;
        }
        this._A = true;
        AdSlot adSlot = this._c;
        _f0 _f0Var = this._a;
        if (adSlot == null || TextUtils.isEmpty(adSlot.getRewardName())) {
            rewardName = (_f0Var == null || TextUtils.isEmpty(_f0Var._d)) ? "" : _f0Var._d;
        } else {
            rewardName = adSlot.getRewardName();
        }
        AdSlot adSlot2 = this._c;
        _f0 _f0Var2 = this._a;
        if (adSlot2 != null && adSlot2.getRewardAmount() > 0) {
            rewardAmount = adSlot2.getRewardAmount();
        } else if (_f0Var2 == null || (rewardAmount = _f0Var2._e) <= 0) {
            rewardAmount = 0;
        }
        _m7._a(this._w, this._c, rewardName, rewardAmount, new _b());
    }

    public final void _b(boolean z) {
        ImageView imageView;
        int i;
        NiceVideoPlayer niceVideoPlayer = this._D;
        if (niceVideoPlayer != null) {
            this._f = z;
            if (z) {
                niceVideoPlayer.setMediaVolume(0);
                imageView = this._M;
                if (imageView == null) {
                    return;
                } else {
                    i = R.drawable.fancy_ic_player_mute;
                }
            } else {
                niceVideoPlayer.setMediaVolume(7);
                imageView = this._M;
                if (imageView == null) {
                    return;
                } else {
                    i = R.drawable.fancy_ic_player_unmute;
                }
            }
            imageView.setImageResource(i);
        }
    }

    @Override // com.fancy._md
    public final void _c() {
        _jd _jdVar = this._F;
        if (_jdVar != null) {
            _ng._a(_jdVar._b);
        }
    }

    @Override // com.fancy._md
    public final void _d() {
        _jd _jdVar = this._F;
        if (_jdVar != null) {
            _jdVar._c();
            _jdVar._c = null;
            _jdVar._d = null;
            _jdVar._o = null;
            this._F = null;
        }
        _ae = 0;
        com.fancy._f _fVar = this._b;
        if (_fVar != null && _fVar._a == 0) {
            String str = _fVar._i;
            HashMap map = _cv._a;
            if (!TextUtils.isEmpty(str)) {
                _cv._a.remove(com.fancy.adsdk.lib.utils._a._c(str));
            }
        }
        if (_hg._a == null) {
            synchronized (_hg.class) {
                if (_hg._a == null) {
                    _hg._a = new _hg();
                }
            }
        }
        _hg._a.getClass();
        this._B = null;
        this._C = null;
        NiceVideoPlayer niceVideoPlayer = this._D;
        if (niceVideoPlayer != null) {
            niceVideoPlayer._c();
            this._D = null;
        }
        this._G = null;
        this._H = null;
        this._I = null;
        this._J = null;
        this._L = null;
        this._M = null;
        this._N = null;
        this._O = null;
        this._P = null;
        this._Q = null;
        this._R = null;
        this._S = null;
        this._T = null;
        this._U = null;
        this._V = null;
        this._W = null;
        this._X = null;
        this._Y = null;
        this._Z = null;
        this._0 = null;
        this._1 = null;
        this._2 = null;
        this._3 = null;
        this._4 = null;
        this._5 = null;
        this._6 = null;
        this._7 = null;
        this._8 = null;
        this._9 = null;
        this._a0 = null;
        this._K = null;
        PtgShakeView ptgShakeView = this._a1;
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
            this._a1 = null;
        }
        PtgShakeView ptgShakeView2 = this._a2;
        if (ptgShakeView2 != null) {
            ImageView imageView2 = ptgShakeView2._a;
            if (imageView2 != null) {
                imageView2.clearAnimation();
            }
            _mz _mzVar2 = ptgShakeView2._d;
            if (_mzVar2 != null) {
                _mzVar2.cancel();
                ptgShakeView2._d = null;
            }
            this._a2 = null;
        }
        _i _iVar = this._a9;
        if (_iVar != null) {
            _iVar.removeCallbacksAndMessages(null);
        }
        _m8 _m8Var_a = _m8._a();
        String str2 = this._a4;
        if (str2 == null) {
            _m8Var_a.getClass();
        } else {
            List list = (List) _m8Var_a._c.get(str2);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onAdClose();
                }
            }
        }
        _m8._a()._b(this._a4);
    }

    public final void _e() {
        ImageView imageView = this._I;
        if (imageView == null || this._N == null || this._Y == null) {
            return;
        }
        imageView.setVisibility(0);
        this._N.setVisibility(8);
        this._Y.setVisibility(0);
        PlaceholderImageView placeholderImageView = this._Z;
        if (placeholderImageView != null) {
            _ev._a(this._j, placeholderImageView);
        }
        TextView textView = this._0;
        if (textView != null) {
            textView.setText(this._k);
        }
        TextView textView2 = this._1;
        if (textView2 != null) {
            textView2.setText(this._l);
        }
        _a(this._8);
        if (this._g == 0) {
            LinearLayout linearLayout = this._2;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            TextView textView3 = this._3;
            if (textView3 != null) {
                textView3.setText(this._m);
            }
            TextView textView4 = this._4;
            if (textView4 != null) {
                textView4.setText(this._n);
            }
            TextView textView5 = this._5;
            if (textView5 != null) {
                textView5.setOnClickListener(new _g());
            }
            TextView textView6 = this._6;
            if (textView6 != null) {
                textView6.setOnClickListener(new _f());
            }
            TextView textView7 = this._7;
            if (textView7 != null) {
                textView7.setOnClickListener(new _h());
            }
        } else {
            LinearLayout linearLayout2 = this._2;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
        }
        TextView textView8 = this._8;
        if (textView8 != null) {
            textView8.setOnClickListener(new _e());
            _n1._a(this._B, this._8, (View) null);
        }
        this._a3 = true;
        _f();
    }

    public final void _f() {
        LinearLayout linearLayout;
        if (!this._ab) {
            LinearLayout linearLayout2 = this._9;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            linearLayout = this._a0;
            if (linearLayout == null) {
                return;
            }
        } else if (this._s != 0) {
            LinearLayout linearLayout3 = this._9;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            linearLayout = this._a0;
            if (linearLayout == null) {
                return;
            }
        } else {
            if (this._a3) {
                LinearLayout linearLayout4 = this._9;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(8);
                }
                LinearLayout linearLayout5 = this._a0;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                    return;
                }
                return;
            }
            LinearLayout linearLayout6 = this._9;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            linearLayout = this._a0;
            if (linearLayout == null) {
                return;
            }
        }
        linearLayout.setVisibility(8);
    }

    @Override // com.fancy._md
    public final void onWindowFocusChanged(boolean z) {
        NiceVideoPlayer niceVideoPlayer;
        NiceVideoPlayer niceVideoPlayer2;
        if (z) {
            if (this._r && (niceVideoPlayer2 = this._D) != null && !this._x) {
                NiceVideoPlayer._a(new _hf(niceVideoPlayer2));
            }
            _a(false);
            return;
        }
        if (this._r && (niceVideoPlayer = this._D) != null) {
            NiceVideoPlayer._a(new _he(niceVideoPlayer));
        }
        if (_ae > 0 && !this._r) {
            _m8._a()._f(this._a4);
        }
        _i _iVar = this._a9;
        if (_iVar != null) {
            _iVar.removeMessages(0);
        }
    }

    public class _a implements _jd._b {
        public _a() {
        }

        @Override // com.fancy._jd._b
        public final void _a(View view, int i, _oj _ojVar) {
            _me _meVar = _me.this;
            _meVar._a(view, i, _ojVar, true);
            _n1._a(_meVar._B, view, (View) null);
        }

        @Override // com.fancy._jd._b
        public final void _b(View view, int i, _oj _ojVar) {
            _me.this._a(view, i, _ojVar, false);
        }

        @Override // com.fancy._jd._b
        public final void _a(boolean z) {
            _me _meVar = _me.this;
            _meVar._ab = z;
            _meVar._f();
        }
    }

    public class _d implements _eq {
        public _d() {
        }

        @Override // com.fancy._eq
        public final void _a() {
        }

        @Override // com.fancy._eq
        public final void _a(int i) {
            _me _meVar = _me.this;
            _jd _jdVar = _meVar._F;
            if (_jdVar != null) {
                _jdVar._a(_meVar._a6);
            }
        }

        @Override // com.fancy._eq
        public final void _a(String str) {
            _m8._a()._a(_me.this._a4, PtgErrorCode.SDK_RESOURCE_ERROR, str);
        }
    }

    public final void _a(int i, String str, boolean z) {
        int rewardAmount;
        String rewardName;
        _m8 _m8Var_a = _m8._a();
        String str2 = this._a4;
        Bundle bundle = new Bundle();
        bundle.putInt(PtgRewardConstant.REWARD_PARAMS.SERVER_CODE, i);
        bundle.putString(PtgRewardConstant.REWARD_PARAMS.SERVER_MSG, str);
        AdSlot adSlot = this._c;
        _f0 _f0Var = this._a;
        if (adSlot != null && adSlot.getRewardAmount() > 0) {
            rewardAmount = adSlot.getRewardAmount();
        } else if (_f0Var == null || (rewardAmount = _f0Var._e) <= 0) {
            rewardAmount = 0;
        }
        bundle.putInt("reward_amount", rewardAmount);
        AdSlot adSlot2 = this._c;
        _f0 _f0Var2 = this._a;
        if (adSlot2 == null || TextUtils.isEmpty(adSlot2.getRewardName())) {
            rewardName = (_f0Var2 == null || TextUtils.isEmpty(_f0Var2._d)) ? "" : _f0Var2._d;
        } else {
            rewardName = adSlot2.getRewardName();
        }
        bundle.putString("reward_name", rewardName);
        bundle.putInt("reward_type", this._z ? 3 : 1);
        AdSlot adSlot3 = this._c;
        if (adSlot3 != null) {
            bundle.putString("extra", adSlot3.getMediaExtra());
            bundle.putString(PtgRewardConstant.REWARD_PARAMS.USER_ID, this._c.getUserID());
        } else {
            bundle.putString("extra", "");
            bundle.putString(PtgRewardConstant.REWARD_PARAMS.USER_ID, "");
        }
        if (str2 == null) {
            _m8Var_a.getClass();
        } else {
            List list = (List) _m8Var_a._c.get(str2);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onRewardVerify(z, bundle);
                }
            }
        }
        this._y = true;
    }

    public final void _b(Activity activity) {
        ProgressBar progressBar = this._G;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        if (!this._r) {
            String str = this._h;
            _mr _mrVar = new _mr(this, activity);
            AtomicBoolean atomicBoolean = _ev._a;
            if (!TextUtil.isEmpty(str)) {
                com.fancy.adsdk.lib.utils._d._b(new _ey(_mrVar, str));
            }
        } else {
            _l4 _l4Var = new _l4(activity);
            this._C = _l4Var;
            NiceVideoPlayer niceVideoPlayer = this._D;
            int i = this._s;
            int i2 = this._d;
            int i3 = this._e;
            niceVideoPlayer._x = i;
            niceVideoPlayer._y = i2;
            niceVideoPlayer._z = i3;
            niceVideoPlayer.setController(_l4Var);
            String str_a = _i5._a(StubApp.getOrigApplicationContext(activity.getApplicationContext()))._a(this._h, true);
            this._C.setVisibility(8);
            this._C.setUrl(str_a);
            this._C.setPlayStateChanged(new _mm(this));
            this._C.setProgressListener(new _mn(this));
            this._D.setOnPreparedListener(new _mo(this, activity));
            this._D.setOnCompletionListener(new _mp(this));
            this._D.setOnErrorListener(new _mq(this));
            this._D._d();
            String str2 = TextUtil.isNotEmpty(this._i) ? this._i : this._h;
            _mg _mgVar = new _mg(this, activity);
            AtomicBoolean atomicBoolean2 = _ev._a;
            if (!TextUtil.isEmpty(str2)) {
                com.fancy.adsdk.lib.utils._d._b(new _ex(str2, _mgVar));
            }
        }
        LinearLayout linearLayout = this._N;
        if (linearLayout == null || this._Y == null) {
            return;
        }
        linearLayout.setVisibility(0);
        this._Y.setVisibility(8);
        if (TextUtils.isEmpty(this._j)) {
            PlaceholderImageView placeholderImageView = this._O;
            if (placeholderImageView != null) {
                placeholderImageView.setVisibility(8);
            }
        } else {
            PlaceholderImageView placeholderImageView2 = this._O;
            if (placeholderImageView2 != null) {
                placeholderImageView2.setVisibility(0);
            }
            PlaceholderImageView placeholderImageView3 = this._O;
            if (placeholderImageView3 != null) {
                _ev._a(this._j, placeholderImageView3);
            }
        }
        TextView textView = this._P;
        if (textView != null) {
            textView.setText(this._k);
        }
        TextView textView2 = this._Q;
        if (textView2 != null) {
            textView2.setText(this._l);
        }
        _a(this._X);
        if (this._g == 0) {
            LinearLayout linearLayout2 = this._R;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            TextView textView3 = this._S;
            if (textView3 != null) {
                textView3.setText(this._m);
            }
            TextView textView4 = this._T;
            if (textView4 != null) {
                textView4.setText(this._n);
            }
            TextView textView5 = this._U;
            if (textView5 != null) {
                textView5.setOnClickListener(new _g());
            }
            TextView textView6 = this._V;
            if (textView6 != null) {
                textView6.setOnClickListener(new _f());
            }
            TextView textView7 = this._W;
            if (textView7 != null) {
                textView7.setOnClickListener(new _h());
            }
        } else {
            LinearLayout linearLayout3 = this._R;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
        }
        TextView textView8 = this._X;
        if (textView8 != null) {
            textView8.setOnClickListener(new _e());
            _n1._a(this._B, this._X, (View) null);
        }
    }

    public final void _a(boolean z) {
        _i _iVar;
        if (!z && _ae > 0 && !this._r) {
            _m8 _m8Var_a = _m8._a();
            String str = this._a4;
            if (str == null) {
                _m8Var_a.getClass();
            } else {
                List list = (List) _m8Var_a._c.get(str);
                if (list != null && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onVideoResume();
                    }
                }
            }
        }
        _i _iVar2 = this._a9;
        if (_iVar2 != null) {
            _iVar2.removeMessages(0);
        }
        com.fancy._f _fVar = this._b;
        if (_fVar == null || !_fVar._A || (_iVar = this._a9) == null) {
            return;
        }
        _iVar.sendEmptyMessage(0);
    }

    public final void _a(View view, int i, _oj _ojVar, boolean z) {
        com.fancy._f _fVar;
        if (view == null || this._b == null) {
            return;
        }
        AdSlot adSlot = this._c;
        if (adSlot != null) {
            adSlot._e(i);
        }
        com.fancy._f _fVar2 = this._b;
        if (_fVar2 != null) {
            _fVar2._v = _ojVar;
        }
        this._a6 = true;
        _de._a(_fVar2);
        boolean z2 = z && (_fVar = this._b) != null && _fVar._r();
        com.fancy._f _fVar3 = this._b;
        if (z2) {
            i = 0;
        }
        _n1._a(view, _fVar3, i);
        _m8 _m8Var_a = _m8._a();
        String str = this._a4;
        if (str == null) {
            _m8Var_a.getClass();
        } else {
            List list = (List) _m8Var_a._c.get(str);
            if (list != null && !list.isEmpty()) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((PtgRewardVideoAd.RewardAdInteractionListener) it.next()).onAdVideoBarClick();
                }
            }
        }
        _b3._a(view.getContext(), this._b, this._c, new _d());
        _jd _jdVar = this._F;
        if (_jdVar != null) {
            _kr._a(_jdVar._j, _jdVar._l);
            this._F._c();
        }
    }

    @Override // com.fancy._md
    public final void _a(PtgBaseVideoActivity ptgBaseVideoActivity, PtgRewardVideoPortraitActivity._a _aVar, AtomicBoolean atomicBoolean) {
        _m8 _m8Var_a;
        AdErrorImpl adErrorImpl;
        String str;
        this._a7 = atomicBoolean;
        if (ptgBaseVideoActivity == null || _aVar == null) {
            return;
        }
        try {
            if (_a(ptgBaseVideoActivity)) {
                PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity = PtgRewardVideoPortraitActivity.this;
                if (ptgRewardVideoPortraitActivity._I instanceof _me) {
                    ptgRewardVideoPortraitActivity._b();
                }
                _a(_aVar);
                if (this._L != null) {
                    _jd _jdVar = new _jd(this._b, this._a8);
                    this._F = _jdVar;
                    FrameLayout frameLayout = this._B;
                    _jdVar._c = frameLayout;
                    _jdVar._d = frameLayout;
                    _n1._a(frameLayout, frameLayout, (View) null);
                    _b(this._t == 0);
                    PtgRoundLinearLayout ptgRoundLinearLayout = this._L;
                    if (ptgRoundLinearLayout != null) {
                        ptgRoundLinearLayout.setOnClickListener(new _mk(this, _aVar, ptgBaseVideoActivity));
                    }
                    ImageView imageView = this._M;
                    if (imageView != null) {
                        imageView.setOnClickListener(new _ml(this, ptgBaseVideoActivity));
                    }
                    _b(ptgBaseVideoActivity);
                    return;
                }
                _m8Var_a = _m8._a();
                str = this._a4;
                adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_9;
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_9;
            } else {
                _m8Var_a = _m8._a();
                String str2 = this._a4;
                adErrorImpl = new AdErrorImpl();
                adErrorImpl._c = PtgApiProvider.providerName;
                adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._e = PtgErrorCode.SDK_RENDER_ERROR_4;
                adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
                adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_4;
                str = str2;
            }
            _m8Var_a._a(str, adErrorImpl);
            ptgBaseVideoActivity._a();
        } catch (Exception e) {
            _m8 _m8Var_a2 = _m8._a();
            String str3 = this._a4;
            AdErrorImpl adErrorImpl2 = new AdErrorImpl();
            adErrorImpl2._c = PtgApiProvider.providerName;
            adErrorImpl2._d = PtgErrorCode.SDK_RENDER_ERROR;
            adErrorImpl2._e = PtgErrorCode.SDK_RENDER_ERROR_1;
            adErrorImpl2._a = PtgErrorCode.SDK_RENDER_ERROR;
            adErrorImpl2._b = e.getMessage();
            _m8Var_a2._a(str3, adErrorImpl2);
            ptgBaseVideoActivity._a();
        }
    }

    public final boolean _a(Activity activity) {
        _m8 _m8Var_a;
        String str;
        String str2;
        this._a4 = activity.getIntent().getStringExtra("VIDEO_ADVERT_ID");
        this._b = (com.fancy._f) _m8._a()._a.get(this._a4);
        this._c = (AdSlot) _m8._a()._b.get(this._a4);
        com.fancy._f _fVar = this._b;
        boolean z = false;
        if (_fVar != null) {
            _f0 _f0Var = _fVar._E;
            this._a = _f0Var;
            if (_f0Var != null) {
                this._s = _f0Var._a;
                this._t = _f0Var._b;
                this._u = _f0Var._c;
                this._v = _f0Var._f;
                this._w = _f0Var._g;
            }
            this._E = new _l6();
            this._a4 = String.valueOf(this._b.hashCode());
            com.fancy._f _fVar2 = this._b;
            this._g = _fVar2._a;
            this._r = _fVar2._u();
            this._k = this._b._l();
            this._l = this._b._d();
            if (this._r) {
                _l3 _l3Var_m = this._b._m();
                if (_l3Var_m != null) {
                    this._d = _l3Var_m._c;
                    this._e = _l3Var_m._d;
                    this._h = _l3Var_m._a;
                    this._i = _l3Var_m._b;
                }
            } else {
                _jz _jzVar_f = this._b._f();
                if (_jzVar_f != null) {
                    this._d = _jzVar_f._b;
                    this._e = _jzVar_f._c;
                    String str3 = _jzVar_f._a;
                    this._h = str3;
                    this._i = str3;
                }
                this._t = 0;
            }
            this._j = this._b._i();
            AppInfo appInfo = this._b._c;
            if (appInfo != null) {
                if (!TextUtils.isEmpty(appInfo.getName())) {
                    this._k = appInfo.getName();
                }
                if (!TextUtils.isEmpty(appInfo.getIcon_url())) {
                    this._j = appInfo.getIcon_url();
                }
                this._m = appInfo.getDevelopers();
                this._n = _ie._a("版本号：").append(appInfo.getAppVersion()).toString();
                this._o = appInfo.getFunctionDescUrl();
                this._p = appInfo.getPermissionProtocolUrl();
                this._q = appInfo.getPrivacyProtocolUrl();
            }
            float f_e = this._b._e() * 0.7f;
            if (this._u > f_e) {
                this._u = (int) Math.floor(f_e);
            }
            com.fancy._f _fVar3 = this._b;
            if (_fVar3 != null && _fVar3._a == 0) {
                String str4 = _fVar3._i;
                _c _cVar = this._ac;
                HashMap map = _cv._a;
                if (!TextUtils.isEmpty(str4) && _cVar != null) {
                    String str_c = com.fancy.adsdk.lib.utils._a._c(str4);
                    HashMap map2 = _cv._a;
                    if (map2.containsKey(str_c)) {
                        map2.remove(str_c);
                    }
                    map2.put(str_c, _cVar);
                }
            }
        }
        if (this._a == null) {
            _m8Var_a = _m8._a();
            str = this._a4;
            str2 = "advert params exception![videoConfig]";
        } else if (this._b == null) {
            _m8Var_a = _m8._a();
            str = this._a4;
            str2 = "advert params exception![advertInfo]";
        } else {
            if (this._c != null) {
                if (TextUtils.isEmpty(this._h)) {
                    _m8Var_a = _m8._a();
                    str = this._a4;
                    str2 = "advert params exception![videoUrl]";
                }
                return !z;
            }
            _m8Var_a = _m8._a();
            str = this._a4;
            str2 = "advert params exception![adSlot]";
        }
        _m8Var_a._a(str, PtgErrorCode.SDK_VIDEO_PLAY_ERROR, str2);
        z = true;
        return !z;
    }

    public final void _a(PtgRewardVideoPortraitActivity._a _aVar) {
        try {
            PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity = PtgRewardVideoPortraitActivity.this;
            this._B = ptgRewardVideoPortraitActivity._a;
            this._D = ptgRewardVideoPortraitActivity._b;
            this._G = ptgRewardVideoPortraitActivity._c;
            this._H = ptgRewardVideoPortraitActivity._d;
            this._I = ptgRewardVideoPortraitActivity._e;
            this._L = ptgRewardVideoPortraitActivity._f;
            this._K = ptgRewardVideoPortraitActivity._g;
            this._J = ptgRewardVideoPortraitActivity._h;
            this._M = ptgRewardVideoPortraitActivity._i;
            this._N = ptgRewardVideoPortraitActivity._j;
            this._O = ptgRewardVideoPortraitActivity._k;
            this._P = ptgRewardVideoPortraitActivity._l;
            this._Q = ptgRewardVideoPortraitActivity._m;
            this._R = ptgRewardVideoPortraitActivity._n;
            this._S = ptgRewardVideoPortraitActivity._o;
            this._T = ptgRewardVideoPortraitActivity._p;
            this._U = ptgRewardVideoPortraitActivity._q;
            this._V = ptgRewardVideoPortraitActivity._r;
            this._W = ptgRewardVideoPortraitActivity._s;
            this._X = ptgRewardVideoPortraitActivity._t;
            this._Y = ptgRewardVideoPortraitActivity._v;
            this._Z = ptgRewardVideoPortraitActivity._w;
            this._0 = ptgRewardVideoPortraitActivity._x;
            this._1 = ptgRewardVideoPortraitActivity._y;
            this._2 = ptgRewardVideoPortraitActivity._z;
            PtgRewardVideoPortraitActivity ptgRewardVideoPortraitActivity2 = PtgRewardVideoPortraitActivity.this;
            this._3 = ptgRewardVideoPortraitActivity2._A;
            this._4 = ptgRewardVideoPortraitActivity2._B;
            this._5 = ptgRewardVideoPortraitActivity2._C;
            this._6 = ptgRewardVideoPortraitActivity2._D;
            this._7 = ptgRewardVideoPortraitActivity2._E;
            this._8 = ptgRewardVideoPortraitActivity2._F;
            LinearLayout linearLayout = ptgRewardVideoPortraitActivity2._u;
            this._9 = linearLayout;
            this._a0 = ptgRewardVideoPortraitActivity2._G;
            if (linearLayout != null) {
                this._a1 = (PtgShakeView) linearLayout.findViewById(R.id.ptgShakeIv);
            }
            LinearLayout linearLayout2 = this._a0;
            if (linearLayout2 != null) {
                this._a2 = (PtgShakeView) linearLayout2.findViewById(R.id.ptgShakeIv);
            }
        } catch (Exception unused) {
        }
    }

    public final void _a(long j, long j2) {
        if (j < j2 || this._J == null) {
            return;
        }
        int iFloor = ((int) Math.floor((j - j2) / 1000.0f)) - ((int) ((j - Math.min((int) (j * 0.7f), 30000L)) / 1000.0f));
        if (iFloor < 0) {
            iFloor = 0;
        }
        this._J.setText("奖励发放时长倒计时 " + iFloor + "s");
        this._J.setTag(Integer.valueOf(iFloor));
        ImageView imageView = this._K;
        if (imageView != null && this._J != null) {
            int i = iFloor <= 0 ? 8 : 0;
            imageView.setVisibility(i);
            this._J.setVisibility(i);
        }
        _b(iFloor);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0065  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    public final void _a(TextView textView) {
        String str;
        if (textView == null) {
            return;
        }
        if (this._g == 0) {
            Context context = textView.getContext();
            com.fancy._f _fVar = this._b;
            if (context != null && _fVar != null) {
                try {
                    AppInfo appInfo = _fVar._c;
                    if (_c9._a(context, (appInfo == null || TextUtils.isEmpty(appInfo.getPackage_name())) ? "" : _fVar._c.getPackage_name())) {
                        str = "查看详情";
                    }
                } catch (Exception unused) {
                }
            }
            Context context2 = textView.getContext();
            com.fancy._f _fVar2 = this._b;
            if (context2 == null || _fVar2 == null) {
                str = "立即下载";
            } else {
                try {
                    AppInfo appInfo2 = _fVar2._c;
                    if (_d6._a(_d6._a(context2, _d6._a((appInfo2 == null || TextUtils.isEmpty(appInfo2.getName())) ? "应用" : _fVar2._c.getName(), ".apk")))) {
                        str = "立即安装";
                    } else {
                        str = "立即下载";
                    }
                } catch (Exception unused2) {
                }
            }
        } else {
            str = "查看详情";
        }
        textView.setText(str);
    }
}
