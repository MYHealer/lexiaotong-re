package com.fancy;

import com.fancy.adsdk.lib.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cg {
    public String _f;
    public HashMap _e = new HashMap();
    public HashMap _d = new HashMap();
    public HashMap _a = new HashMap();
    public HashMap _b = new HashMap();
    public HashMap _c = new HashMap();

    public static class _a {
        public boolean _a;
        public int _b;

        public _a(boolean z, int i) {
            this._a = z;
            this._b = i;
        }
    }

    public final boolean _a(String str, _ck _ckVar) {
        try {
            JSONArray jSONArrayOptJSONArray = new JSONObject(str).optJSONArray("slotBiddings");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        _cj _cjVar = new _cj();
                        _cjVar._a(jSONObjectOptJSONObject, _ckVar);
                        String str2 = _cjVar._a;
                        this._c.put(str2, new _a(_cjVar._c, _cjVar._d));
                        this._d.put(str2, Integer.valueOf(_cjVar._f));
                        for (_ci _ciVar : _cjVar._w) {
                            List arrayList = (List) this._a.get(str2);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                this._a.put(str2, arrayList);
                            }
                            arrayList.add(_ciVar);
                        }
                        HashMap map = _cjVar._x;
                        if (map != null) {
                            this._b.put(str2, map);
                        }
                        this._e.put(str2, _cjVar);
                    }
                }
            }
            this._f = str;
            return true;
        } catch (JSONException e) {
            Logger.e(e.getMessage());
            return false;
        }
    }
}
