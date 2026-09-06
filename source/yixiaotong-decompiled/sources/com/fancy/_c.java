package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.hihonor.adsdk.base.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c implements Runnable {
    public final /* synthetic */ String _a;
    public final /* synthetic */ String _b;
    public final /* synthetic */ ActionTrackManager _c;

    public _c(ActionTrackManager actionTrackManager, String str, String str2) {
        this._c = actionTrackManager;
        this._a = str;
        this._b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = _if._f._a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strReplace = str.replace("__ACTION__", "openDeep");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("reqId", this._a);
            jSONObject.putOpt(c.r1.hnadse, this._b);
        } catch (Exception unused) {
        }
        String str_a = _hr._a(strReplace.replace("__DATA__", com.fancy.adsdk.lib.utils._a._b(jSONObject.toString())), ActionTrackManager._a(this._c));
        _ou _ouVar_a = _ou._a();
        _m1 _m1Var = _ouVar_a._b;
        if (_m1Var != null) {
            _m1Var._a(str_a);
            return;
        }
        _m1 _m1Var2 = new _m1();
        _ouVar_a._b = _m1Var2;
        _m1Var2._a(str_a);
    }
}
