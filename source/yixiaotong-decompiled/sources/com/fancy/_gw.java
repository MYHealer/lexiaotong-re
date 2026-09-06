package com.fancy;

import java.net.HttpURLConnection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gw extends Exception {
    public HttpURLConnection _a;

    public _gw(String str) {
        super(str);
    }

    public _gw(String str, HttpURLConnection httpURLConnection) {
        super(str);
        this._a = httpURLConnection;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        StringBuilder sb = new StringBuilder(String.valueOf(super.getMessage()));
        try {
            if (this._a != null) {
                sb.append(' ');
                sb.append('[');
                sb.append(this._a.toString());
                sb.append(']');
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return getMessage();
    }
}
