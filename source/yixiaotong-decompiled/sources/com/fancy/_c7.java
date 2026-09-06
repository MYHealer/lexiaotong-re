package com.fancy;

import android.util.Base64;
import com.cdo.oaps.ad.OapsKey;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.yfanads.android.utils.YFAdsConst;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c7 {
    public long _B;
    public long _C;
    public String _i;
    public int _j;
    public int _k;
    public String _l;
    public _dz _m;
    public int _n;
    public int _o;
    public String _t;
    public int _y;
    public String _a = "";
    public String _b = "";
    public String _c = "";
    public String _d = "";
    public String _e = "";
    public String _f = "";
    public String _g = "";
    public int _h = 1;
    public String _p = "";
    public String _q = "";
    public String _r = "";
    public String _s = "";
    public String _u = "";
    public String _v = "";
    public String _w = "";
    public String _x = "";
    public String _z = "";
    public String _A = "";

    public final String _a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("oaid", this._a);
            jSONObject.put("andid", this._d);
            jSONObject.put("appnm", this._p);
            jSONObject.put(OapsKey.KEY_PKG, this._q);
            jSONObject.put("appver", this._r);
            jSONObject.put("appvc", this._s);
            jSONObject.put(YFAdsConst.REPORT_DEV_TYPE, this._y);
            jSONObject.put("sdkVer", PtgAdSdk.getConfig().getSdkVersionName());
            jSONObject.put("sdkvc", PtgAdSdk.getConfig().getSdkVersionCode());
            return Base64.encodeToString(jSONObject.toString().getBytes(), 2);
        } catch (Exception unused) {
            return "";
        }
    }
}
