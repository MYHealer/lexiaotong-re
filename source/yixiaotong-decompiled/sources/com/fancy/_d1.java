package com.fancy;

import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _d1 implements Serializable {
    public String _a;
    public String _b;
    public long _e = -1;
    public File _c = null;
    public String _d = "";

    public _d1(String str, String str2) {
        this._b = str;
        this._a = str2;
    }

    public final File _a() {
        return this._c;
    }

    public final String _b() {
        StringBuilder sbAppend = new StringBuilder().append(this._b);
        File file = this._c;
        return sbAppend.append(file == null ? "" : file.getAbsolutePath()).toString();
    }

    public final String _c() {
        return this._b;
    }
}
