package com.fancy.mpsdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.fancy._ad;
import com.fancy._f2;
import com.fancy._f5;
import com.fancy._fc;
import com.fancy._fg;
import com.fancy._jd;
import com.fancy._k4;
import com.fancy._ng;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgInteractionPortraitActivity extends Activity {
    public static final /* synthetic */ int _f = 0;
    public String _a;
    public _k4 _b;
    public _ad _c;
    public FrameLayout _d;
    public final _a _e = new _a();

    public class _a implements _f2 {
        public _a() {
        }
    }

    public class _b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public interface _c {
    }

    public interface _d {
        void _a();
    }

    static {
        StubApp.interface11(25501);
    }

    public void _a() {
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        _k4 _k4Var = this._b;
        if (_k4Var != null) {
            _fc _fcVar = _k4Var._a;
            if (_fcVar == null || _fcVar._f) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public final void onDestroy() {
        _fc _fcVar;
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        super.onDestroy();
        _fg _fgVar_a = _fg._a();
        String str = this._a;
        _fgVar_a.getClass();
        if (!TextUtils.isEmpty(str) && _fgVar_a._f.contains(str)) {
            _fgVar_a._f.remove(str);
        }
        _fg _fgVar_a2 = _fg._a();
        String str2 = this._a;
        _fgVar_a2.getClass();
        if (!TextUtils.isEmpty(str2) && (adInteractionListener = _fgVar_a2._d.get(str2)) != null) {
            adInteractionListener.onAdDismiss();
        }
        _fg._a()._a(this._a);
        _k4 _k4Var = this._b;
        if (_k4Var != null && (_fcVar = _k4Var._a) != null) {
            _jd _jdVar = _fcVar._g;
            if (_jdVar != null) {
                _jdVar._c();
                _jdVar._c = null;
                _jdVar._d = null;
                _jdVar._o = null;
                _fcVar._g = null;
            }
            _f5 _f5Var = _fcVar._l;
            if (_f5Var != null) {
                _f5Var._a = null;
                PtgVideoView ptgVideoView = _f5Var._h;
                if (ptgVideoView != null) {
                    ptgVideoView._b();
                    _f5Var._h = null;
                }
                _fcVar._l = null;
            }
            _fcVar._k = null;
            _k4Var._a = null;
        }
        _ad _adVar = this._c;
        if (_adVar != null) {
            _adVar._b();
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        _fc _fcVar;
        _jd _jdVar;
        super.onPause();
        _k4 _k4Var = this._b;
        if (_k4Var == null || (_fcVar = _k4Var._a) == null || (_jdVar = _fcVar._g) == null) {
            return;
        }
        _ng._a(_jdVar._b);
    }

    @Override // android.app.Activity
    public final void onResume() {
        _fc _fcVar;
        _jd _jdVar;
        super.onResume();
        _k4 _k4Var = this._b;
        if (_k4Var == null || (_fcVar = _k4Var._a) == null || (_jdVar = _fcVar._g) == null) {
            return;
        }
        _jdVar._a(_fcVar._h);
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
