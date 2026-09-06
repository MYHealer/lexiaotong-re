package com.fancy;

import android.view.View;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _n1 {
    public static _n2 _a;

    public class _a implements Runnable {
        public final /* synthetic */ _ok _a;
        public final /* synthetic */ View _b;

        public _a(_ok _okVar, View view) {
            this._a = _okVar;
            this._b = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view;
            _n2 _n2Var;
            _ok _okVar = this._a;
            if (_okVar == null || (view = this._b) == null || (_n2Var = _n1._a) == null) {
                return;
            }
            int[] iArr = new int[2];
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 && height == 0) {
                width = view.getMeasuredWidth();
                height = view.getMeasuredHeight();
            }
            iArr[0] = width;
            iArr[1] = height;
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int i = iArr2[0];
            int i2 = iArr2[1];
            int i3 = iArr[0];
            int i4 = iArr[1];
            int i5 = (i3 / 4) + i;
            int i6 = ((i3 * 3) / 4) + i;
            int i7 = (i4 / 4) + i2;
            int i8 = ((i4 * 3) / 4) + i2;
            int iNextInt = _n2Var._a.nextInt((i6 - i5) + 1) + i5;
            int iNextInt2 = _n2Var._a.nextInt((i8 - i7) + 1) + i7;
            if (iNextInt <= 0 || iNextInt2 <= 0) {
                return;
            }
            _okVar._i = iNextInt;
            _okVar._j = iNextInt2;
            _okVar._g = iNextInt;
            _okVar._h = iNextInt2;
        }
    }

    public static void _a(View view, View view2, View view3) {
        _n2 _n2Var = _a;
        if (_n2Var != null) {
            _n2Var._a(view, view2, view3);
        }
    }

    public static void _a(View view, _f _fVar) {
        if (_a == null || view == null || _fVar == null) {
            return;
        }
        _de._a(_fVar);
        try {
            int width = view.getWidth();
            int height = view.getHeight();
            if (width == 0 && height == 0) {
                view.measure(0, 0);
                width = view.getMeasuredWidth();
                height = view.getMeasuredHeight();
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int i = iArr[0];
            int i2 = iArr[1];
            HashMap map = new HashMap();
            map.put("__HW_W__", String.valueOf(width));
            map.put("__HW_H__", String.valueOf(height));
            map.put("__HW_SLOT_SCREEN_X__", String.valueOf(i));
            map.put("__HW_SLOT_SCREEN_Y__", String.valueOf(i2));
            map.put("__HW_SHOW_TIME__", AdnConfig.b.hnadsa);
            map.put("__HW_MAX_SHOW_RATIO__", "100");
            map.put("__HW_EVENT_TIME__", String.valueOf(System.currentTimeMillis()));
            map.putAll(_i._a(_fVar._s));
            if (_fVar._u == null) {
                _fVar._u = new _lt();
            }
            _fVar._u._a = map;
        } catch (Exception unused) {
        }
    }

    public static void _a(View view, _f _fVar, int i) {
        _n2 _n2Var = _a;
        if (_n2Var != null) {
            _n2Var._a(view, _fVar, i);
        }
    }

    public static void _a(_ok _okVar, View view) {
        if (view != null) {
            try {
                view.post(new _a(_okVar, view));
            } catch (Exception unused) {
            }
        }
    }
}
