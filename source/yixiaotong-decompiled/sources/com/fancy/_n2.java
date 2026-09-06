package com.fancy;

import android.view.MotionEvent;
import android.view.View;
import com.fancy.adsdk.lib.R;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _n2 {
    public final Random _a = new Random();

    public class _a implements View.OnTouchListener {
        public final /* synthetic */ View _a;

        public _a(View view) {
            this._a = view;
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                _n2._a(this._a, view, motionEvent);
                return false;
            }
            if (action != 1) {
                return false;
            }
            _n2._b(this._a, view, motionEvent);
            return false;
        }
    }

    public static void _a(View view, View view2, MotionEvent motionEvent) {
        Object tag = view2.getTag(R.id.fancy_native_view_tag);
        if (view == null || !(tag instanceof _ok)) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = (int) (rawX - iArr[0]);
        int i2 = (int) (rawY - iArr[1]);
        _ok _okVar = (_ok) tag;
        _okVar._a = i;
        _okVar._b = i2;
        _okVar._c = System.currentTimeMillis();
    }

    public static void _b(View view, View view2, MotionEvent motionEvent) {
        Object tag = view2.getTag(R.id.fancy_native_view_tag);
        if (view == null || !(tag instanceof _ok)) {
            return;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i = (int) (rawX - iArr[0]);
        int i2 = (int) (rawY - iArr[1]);
        _ok _okVar = (_ok) tag;
        _okVar._d = i;
        _okVar._e = i2;
        _okVar._f = System.currentTimeMillis();
    }

    public final void _a(View view, View view2, View view3) {
        if (view == null || view2 == null) {
            return;
        }
        view2.setTag(R.id.fancy_native_view_tag, new _ok(view3));
        view2.setOnTouchListener(new _a(view));
    }

    public final void _a(View view, _f _fVar, int i) {
        String str;
        String str2;
        String str3;
        String strValueOf;
        Map<String, String> map;
        if (view == null || _fVar == null) {
            return;
        }
        try {
            _lt _ltVar = _fVar._u;
            if (_ltVar == null || (map = _ltVar._a) == null) {
                str = "0";
                str2 = str;
            } else {
                str = map.get("__HW_W__");
                str2 = _fVar._u._a.get("__HW_H__");
            }
            HashMap map2 = new HashMap();
            map2.put("__HW_W__", str);
            map2.put("__HW_H__", str2);
            map2.put("__HW_DENSITY__", String.valueOf(ScreenUtils.getDensity()));
            map2.put("\\$acw\\$", str);
            map2.put("\\$ach\\$", str2);
            Map<String, String> map3 = _fVar._t;
            if (map3 != null) {
                map2.put("iReportM", map3.get("iReportM"));
            }
            _oj _ojVar = _fVar._v;
            if (_ojVar != null) {
                map2.put("__MP_SPEED_ACC__", String.valueOf(_ojVar._d));
                map2.put("__MP_DEGREE__", String.valueOf(_ojVar._e));
            }
            if (i == 1 || i == 5 || i == 7) {
                map2.put("__HW_SLD__", "2");
                map2.put("\\$itm\\$", "2");
                if (_ojVar != null) {
                    map2.put("__MP_X_MAX_ACC__", String.valueOf(_ojVar._a));
                    map2.put("__MP_Y_MAX_ACC__", String.valueOf(_ojVar._b));
                    map2.put("__MP_Z_MAX_ACC__", String.valueOf(_ojVar._c));
                    map2.put("__HW_X_MAX_ACC__", String.valueOf(_ojVar._a));
                    map2.put("__HW_Y_MAX_ACC__", String.valueOf(_ojVar._b));
                    map2.put("__HW_Z_MAX_ACC__", String.valueOf(_ojVar._c));
                    map2.put("\\$xma\\$", String.valueOf(_ojVar._a));
                    map2.put("\\$yma\\$", String.valueOf(_ojVar._b));
                    str3 = "\\$zma\\$";
                    strValueOf = String.valueOf(_ojVar._c);
                    map2.put(str3, strValueOf);
                }
            } else {
                map2.put("__HW_SLD__", "0");
                map2.put("\\$itm\\$", "1");
                Object tag = view.getTag(R.id.fancy_native_view_tag);
                if (tag instanceof _ok) {
                    _ok _okVar = (_ok) tag;
                    int i2 = _okVar._g;
                    int i3 = -999;
                    if (i2 <= 0 && (i2 = _okVar._a) == 0) {
                        i2 = -999;
                    }
                    map2.put("__HW_DOWN_X__", String.valueOf(i2));
                    int i4 = _okVar._h;
                    if (i4 <= 0 && (i4 = _okVar._b) == 0) {
                        i4 = -999;
                    }
                    map2.put("__HW_DOWN_Y__", String.valueOf(i4));
                    map2.put("__HW_DOWN_TIME__", String.valueOf(_okVar._c));
                    int i5 = _okVar._i;
                    if (i5 <= 0 && (i5 = _okVar._d) == 0) {
                        i5 = -999;
                    }
                    map2.put("__HW_UP_X__", String.valueOf(i5));
                    int i6 = _okVar._j;
                    if (i6 <= 0 && (i6 = _okVar._e) == 0) {
                        i6 = -999;
                    }
                    map2.put("__HW_UP_Y__", String.valueOf(i6));
                    map2.put("__HW_UP_TIME__", String.valueOf(_okVar._f));
                    int i7 = _okVar._g;
                    if (i7 <= 0 && (i7 = _okVar._a) == 0) {
                        i7 = -999;
                    }
                    map2.put("\\$dx\\$", String.valueOf(i7));
                    int i8 = _okVar._h;
                    if (i8 <= 0 && (i8 = _okVar._b) == 0) {
                        i8 = -999;
                    }
                    map2.put("\\$dy\\$", String.valueOf(i8));
                    int i9 = _okVar._i;
                    if (i9 <= 0 && (i9 = _okVar._d) == 0) {
                        i9 = -999;
                    }
                    map2.put("\\$ux\\$", String.valueOf(i9));
                    str3 = "\\$uy\\$";
                    int i10 = _okVar._j;
                    if (i10 > 0) {
                        i3 = i10;
                    } else {
                        int i11 = _okVar._e;
                        if (i11 != 0) {
                            i3 = i11;
                        }
                    }
                    strValueOf = String.valueOf(i3);
                    map2.put(str3, strValueOf);
                } else {
                    map2.put("__HW_DOWN_X__", "-999");
                    map2.put("__HW_DOWN_Y__", "-999");
                    map2.put("__HW_UP_X__", "-999");
                    map2.put("__HW_UP_Y__", "-999");
                }
            }
            map2.putAll(_i._a(_fVar._s));
            if (_fVar._u == null) {
                _fVar._u = new _lt();
            }
            _fVar._u._b = map2;
        } catch (Exception unused) {
        }
    }
}
