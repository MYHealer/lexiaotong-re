package com.fancy;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.fancy.adsdk.lib.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _je implements View.OnTouchListener {
    public final /* synthetic */ Context _a;
    public final /* synthetic */ _jd _b;

    public class _a implements Runnable {
        public final /* synthetic */ View _a;

        public _a(View view) {
            this._a = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _jd._b _bVar = _je.this._b._o;
            if (_bVar != null) {
                _bVar._a(this._a, 2, null);
            }
        }
    }

    public _je(_jd _jdVar, Activity activity) {
        this._b = _jdVar;
        this._a = activity;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        _ok _okVar;
        if (this._a != null) {
            _jd _jdVar = this._b;
            if (_io._a(_jdVar._b) && _jdVar._j && !_jdVar._q.get() && _jdVar._m) {
                this._b.getClass();
                if (_p5._a(view) != 6 && motionEvent.getAction() == 0) {
                    this._b._q.set(true);
                    if (view != null) {
                        _jd _jdVar2 = this._b;
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        View view2 = _jdVar2._c;
                        if (view2 != null) {
                            int[] iArr = new int[2];
                            view2.getLocationOnScreen(iArr);
                            _okVar = new _ok(rawX - iArr[0], rawY - iArr[1], System.currentTimeMillis());
                        } else {
                            _okVar = new _ok(-999, -999, 0L);
                        }
                        this._b.getClass();
                        long jNextInt = com.fancy.adsdk.lib.utils._a._d.nextInt(31) + 50;
                        int i = _okVar._g;
                        if (i <= 0 && (i = _okVar._a) == 0) {
                            i = -999;
                        }
                        _okVar._d = i;
                        int i2 = _okVar._h;
                        _okVar._e = (i2 > 0 || (i2 = _okVar._b) != 0) ? i2 : -999;
                        _okVar._f = _okVar._c + jNextInt;
                        view.setTag(R.id.fancy_native_view_tag, _okVar);
                        view.postDelayed(new _a(view), jNextInt);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
