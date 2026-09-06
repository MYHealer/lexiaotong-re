package com.fancy;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.mpsdk.PtgAdProxy;
import com.fancy.mpsdk.activity.PtgWebActivity;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _b3 {
    public static void _a(Context context, _an _anVar, _f _fVar, FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, _h _hVar) {
        _i _iVar;
        _o8 _o8Var;
        String str;
        _i _iVar2;
        _o8 _o8Var2;
        _o8 _o8Var3 = new _o8();
        if (_fVar == null) {
            return;
        }
        _i _iVar3 = _fVar._s;
        if (_iVar3 != null) {
            int i = _iVar3._a;
            _o8Var3._a = i == 0 || i == 2;
            _o8Var3._c = _iVar3._c();
            List<Integer> list = _iVar3._g;
            _o8Var3._f = list != null && list.contains(5);
            _o8Var3._e = _iVar3._j;
            boolean z_d = _iVar3._d();
            _o8Var3._g = _iVar3._n;
            _o8Var3._b = _iVar3._d(z_d);
            _o8Var3._d = _iVar3._b(z_d);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        String strValueOf = String.valueOf(_fVar.hashCode());
        if (textView != null) {
            _n1._a(frameLayout, textView, (View) null);
            textView.setVisibility(_o8Var3._a ? 0 : 4);
            textView.setOnClickListener(new _o3(_o8Var3, _anVar, _fVar, strValueOf, _hVar, linearLayout));
        }
        if (frameLayout != null) {
            _n1._a(frameLayout, frameLayout, textView);
            frameLayout.setEnabled(_o8Var3._b);
            if (_o8Var3._b) {
                frameLayout.setOnClickListener(new _o4(_o8Var3, _anVar, _fVar, strValueOf, _hVar, linearLayout));
            }
        }
        if (linearLayout != null) {
            linearLayout.setVisibility(_o8Var3._c ? 0 : 8);
        }
        if (!_o8Var3._a(_iVar3)) {
            _iVar = _iVar3;
            _o8Var = _o8Var3;
            str = strValueOf;
            if (_o8Var._f || _o8Var._d) {
                _nf _nfVar_a = _nf._a(str, r10, _iVar);
                strValueOf = str;
                _iVar2 = _iVar;
                _ng._a(context, new _o6(_o8Var, linearLayout, _nfVar_a, jCurrentTimeMillis, _anVar, _fVar, str, _iVar, false, _hVar), _nfVar_a);
                _o8Var2 = _o8Var;
            } else {
                strValueOf = str;
                _o8Var2 = _o8Var;
                _iVar2 = _iVar;
            }
        } else if (1 == _o8Var3._e) {
            _nf _nfVar_a2 = _nf._a(strValueOf, true, _iVar3);
            _o8Var = _o8Var3;
            _ng._a(context, new _o6(_o8Var3, linearLayout, _nfVar_a2, jCurrentTimeMillis, _anVar, _fVar, strValueOf, _iVar3, true, _hVar), _nfVar_a2);
            _iVar2 = _iVar3;
            _o8Var2 = _o8Var;
        } else {
            _iVar = _iVar3;
            _o8Var = _o8Var3;
            str = strValueOf;
            if (_iVar != null) {
                if (_o8Var._j == null) {
                    _o8Var._j = new _o7(_o8Var, _iVar, textView);
                }
                _o8Var._i.removeCallbacks(_o8Var._j);
                _o8Var._i.postDelayed(_o8Var._j, _iVar._a());
            }
            strValueOf = str;
            _o8Var2 = _o8Var;
            _iVar2 = _iVar;
        }
        if (_anVar != null) {
            _anVar.setVisibilityChanged(new _o5(_o8Var2, _iVar2, context, _fVar, _anVar, linearLayout, _hVar, strValueOf, jCurrentTimeMillis));
        }
    }

    public static void _a(Context context, _f _fVar, AdSlot adSlot) {
        int i;
        if (_fVar._A) {
            PtgAdProxy.onAdClicked(_fVar, adSlot);
        }
        int i2 = _fVar._a;
        boolean z = true;
        if (i2 == 1) {
            _op._a(context, _fVar, adSlot);
            return;
        }
        if (i2 == 2) {
            if (_fVar._Q) {
                try {
                    AtomicBoolean atomicBoolean = _cl._a;
                    atomicBoolean.set(false);
                    _cl._b();
                    if (_cl._b) {
                        int iCheckConfigApply = Doodle.checkConfigApply(PtgAdSdk.getContext());
                        if (iCheckConfigApply != 0) {
                            z = false;
                        }
                        atomicBoolean.set(z);
                        i = iCheckConfigApply;
                    } else {
                        i = -3;
                    }
                } catch (Throwable unused) {
                    _cl._a.set(false);
                    i = -4;
                }
                _op._a(_fVar, adSlot, i);
            }
            if (!_p8._a(context, _fVar, adSlot) && !TextUtils.isEmpty(_fVar._i)) {
                PtgWebActivity._a(context, _fVar);
            }
            _cl._a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        if (com.fancy._c9._a(r3, (r0 == null || android.text.TextUtils.isEmpty(r0.getPackage_name())) ? "" : r4._c.getPackage_name()) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void _a(Context context, _f _fVar, AdSlot adSlot, _eq _eqVar) {
        int i;
        if (_fVar._A) {
            PtgAdProxy.onAdClicked(_fVar, adSlot);
        }
        int i2 = _fVar._a;
        boolean z = true;
        if (i2 != 1) {
            if (i2 == 0) {
                if (context != null) {
                    try {
                        AppInfo appInfo = _fVar._c;
                    } catch (Exception unused) {
                    }
                }
                _cv._a(context, _fVar, adSlot, _eqVar);
                return;
            }
            if (i2 == 2) {
                _eqVar._a();
                if (_fVar._Q) {
                    try {
                        AtomicBoolean atomicBoolean = _cl._a;
                        atomicBoolean.set(false);
                        _cl._b();
                        if (_cl._b) {
                            int iCheckConfigApply = Doodle.checkConfigApply(PtgAdSdk.getContext());
                            if (iCheckConfigApply != 0) {
                                z = false;
                            }
                            atomicBoolean.set(z);
                            i = iCheckConfigApply;
                        } else {
                            i = -3;
                        }
                    } catch (Throwable unused2) {
                        _cl._a.set(false);
                        i = -4;
                    }
                    _op._a(_fVar, adSlot, i);
                }
                if (!_p8._a(context, _fVar, adSlot) && !TextUtils.isEmpty(_fVar._i)) {
                    PtgWebActivity._a(context, _fVar);
                }
                _cl._a();
                return;
            }
            _eqVar._a(PtgErrorCode.SDK_CLICK_ERR_MSG1);
            return;
        }
        _eqVar._a();
        _op._a(context, _fVar, adSlot);
    }
}
