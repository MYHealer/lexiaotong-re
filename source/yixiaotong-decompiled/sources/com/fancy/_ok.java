package com.fancy;

import android.view.View;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ok implements Serializable {
    public int _a;
    public int _b;
    public long _c;
    public int _d;
    public int _e;
    public long _f;
    public int _g;
    public int _h;
    public int _i;
    public int _j;
    public int _k;

    public _ok(int i, int i2, long j) {
        this._a = i;
        this._b = i2;
        this._c = j;
    }

    public _ok(View view) {
        _n1._a(this, view);
    }

    public final String toString() {
        return _ie._a("TInfo{downX=").append(this._a).append(", downY=").append(this._b).append(", downTime=").append(this._c).append(", upX=").append(this._d).append(", upY=").append(this._e).append(", upTime=").append(this._f).append(", mDx=").append(this._g).append(", mDy=").append(this._h).append(", mUx=").append(this._i).append(", mUy=").append(this._j).append('}').toString();
    }
}
