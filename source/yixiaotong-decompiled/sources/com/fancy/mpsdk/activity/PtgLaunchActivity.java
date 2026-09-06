package com.fancy.mpsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import com.fancy._fj;
import com.fancy._k7;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgLaunchActivity extends Activity {
    public static final /* synthetic */ int _d = 0;
    public _k7 _a;
    public final Handler _b = new Handler(Looper.getMainLooper());
    public final _a _c = new _a();

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (PtgLaunchActivity.this.isFinishing()) {
                return;
            }
            PtgLaunchActivity ptgLaunchActivity = PtgLaunchActivity.this;
            _k7 _k7Var = ptgLaunchActivity._a;
            if (_k7Var == null) {
                ptgLaunchActivity.finish();
                return;
            }
            _fj _fjVar = _k7Var._a;
            if (_fjVar != null) {
                try {
                    _fjVar._f = false;
                    _fjVar._j = -4105;
                    _fjVar._a(ptgLaunchActivity);
                } catch (Throwable unused) {
                    if (ptgLaunchActivity.isFinishing()) {
                        return;
                    }
                    ptgLaunchActivity.finish();
                }
            }
        }
    }

    static {
        StubApp.interface11(25503);
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        this._b.removeCallbacks(this._c);
        _k7 _k7Var = this._a;
        if (_k7Var != null) {
            _fj _fjVar = _k7Var._a;
            if (_fjVar != null) {
                _fjVar._a = null;
                _fjVar._b = null;
                _k7Var._a = null;
            }
            this._a = null;
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        _fj _fjVar;
        super.onPause();
        this._b.removeCallbacks(this._c);
        _k7 _k7Var = this._a;
        if (_k7Var == null || (_fjVar = _k7Var._a) == null) {
            return;
        }
        _fjVar._d = true;
    }

    @Override // android.app.Activity
    public final void onResume() {
        _fj _fjVar;
        super.onResume();
        _k7 _k7Var = this._a;
        if (_k7Var == null || (_fjVar = _k7Var._a) == null) {
            return;
        }
        try {
            if (_fjVar._d) {
                if (!_fjVar._e) {
                    _fjVar._f = false;
                    _fjVar._j = -4104;
                    _fjVar._a(this);
                } else if (!isFinishing()) {
                    finish();
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        _fj _fjVar;
        super.onStop();
        _k7 _k7Var = this._a;
        if (_k7Var == null || (_fjVar = _k7Var._a) == null) {
            return;
        }
        try {
            _fjVar._e = true;
            if (_fjVar._f) {
                _fjVar._f = false;
                _fjVar._b();
            }
            if (isFinishing()) {
                return;
            }
            finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 0 || motionEvent.getAction() == 1) && !isFinishing()) {
            finish();
        }
        return super.onTouchEvent(motionEvent);
    }
}
