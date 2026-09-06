package com.fancy;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _oj implements Serializable {
    public int _a;
    public int _b;
    public int _c;
    public double _d;
    public float _e;

    public static _oj _a(float f, float f2, float f3, double d, float f4, boolean z) {
        _oj _ojVar = new _oj();
        _ojVar._d = d;
        _ojVar._e = f4;
        int i = (int) (f * 100.0f);
        int i2 = (int) (f2 * 100.0f);
        int i3 = (int) (f3 * 100.0f);
        if (z) {
            float fNextFloat = (com.fancy.adsdk.lib.utils._a._a.nextFloat() * 60.0f) - 30.0f;
            float fAbs = 5.0f - (Math.abs(fNextFloat) / 10.0f);
            float fNextFloat2 = (fAbs * 2.0f * com.fancy.adsdk.lib.utils._a._a.nextFloat()) + (-fAbs);
            float fAbs2 = (12.0f - (Math.abs(fNextFloat) / 10.0f)) - (Math.abs(fNextFloat2) / 10.0f);
            if (fAbs2 < 5.0f) {
                fAbs2 = 5.0f;
            }
            float fNextFloat3 = (com.fancy.adsdk.lib.utils._a._a.nextFloat() * fAbs2) + 5.0f;
            _ojVar._a = (int) (fNextFloat * 100.0f);
            _ojVar._b = (int) (fNextFloat2 * 100.0f);
            _ojVar._c = (int) (fNextFloat3 * 100.0f);
        } else {
            _ojVar._a = i;
            _ojVar._b = i2;
            _ojVar._c = i3;
        }
        return _ojVar;
    }
}
