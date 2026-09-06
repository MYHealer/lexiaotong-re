package com.fancy;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _kq implements Runnable {
    public final /* synthetic */ Context _a;
    public final /* synthetic */ String _b = "fancy_sdk_config";
    public final /* synthetic */ String _c;
    public final /* synthetic */ long _d;

    public _kq(Context context, String str, long j) {
        this._a = context;
        this._c = str;
        this._d = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SharedPreferences sharedPreferences_c = _kr._c(this._a, this._b);
        if (sharedPreferences_c == null) {
            return;
        }
        try {
            SharedPreferences.Editor editorEdit = sharedPreferences_c.edit();
            editorEdit.putLong(this._c, this._d);
            _kr._a(editorEdit);
        } catch (Exception e) {
            e.getMessage();
            Map map = (Map) _kr._b.get(this._b);
            if (map != null) {
                map.remove(this._c);
            }
        }
    }
}
