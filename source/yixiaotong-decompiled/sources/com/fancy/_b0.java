package com.fancy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _b0 {
    public static final char[] _c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public final long _a;
    public final long _b;

    public _b0(long j, long j2) {
        this._a = j;
        this._b = j2;
    }

    public _b0(String str) {
        long j;
        if (str == null) {
            j = 0;
            this._a = 0L;
        } else {
            long[] jArr_a = _ft._a(str.getBytes());
            this._a = jArr_a[0];
            j = jArr_a[1];
        }
        this._b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        _b0 _b0Var = (_b0) obj;
        return this._a == _b0Var._a && this._b == _b0Var._b;
    }

    public final int hashCode() {
        return (int) (this._a ^ this._b);
    }
}
