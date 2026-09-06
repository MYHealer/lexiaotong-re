package com.fancy;

import android.net.Uri;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cj {
    public String _a;
    public String _b;
    public boolean _c;
    public int _d;
    public int _e;
    public int _f;
    public long _g;
    public int _h;
    public boolean _y;
    public LinkedHashMap _i = new LinkedHashMap();
    public LinkedHashMap _j = new LinkedHashMap();
    public LinkedHashSet _w = new LinkedHashSet();
    public HashMap _x = new HashMap();
    public Set<String> _k = new LinkedHashSet();
    public Set<String> _l = new LinkedHashSet();
    public Set<String> _m = new LinkedHashSet();
    public Set<String> _n = new LinkedHashSet();
    public Set<String> _o = new LinkedHashSet();
    public Set<String> _p = new LinkedHashSet();
    public Set<String> _q = new LinkedHashSet();
    public Set<String> _r = new LinkedHashSet();
    public Set<String> _s = new LinkedHashSet();
    public Set<String> _t = new LinkedHashSet();
    public Set<String> _u = new LinkedHashSet();
    public LinkedHashSet _v = new LinkedHashSet();

    public final void _a(JSONObject jSONObject, _ck _ckVar) {
        JSONArray jSONArrayNames;
        try {
            this._a = jSONObject.optString("slotId");
            this._b = jSONObject.optString("interactionAdvUrl");
            this._c = jSONObject.optBoolean("isConcurrent");
            this._d = jSONObject.optInt("priorityPolicy", 0);
            this._e = jSONObject.optInt("policyFrequency", 0);
            this._f = jSONObject.optInt("priorityPolicyPacingTargetV2");
            this._g = jSONObject.optLong("creativeAliveDuration");
            this._h = jSONObject.optInt("bidCreativeQuantity");
            this._y = jSONObject.optBoolean("twicePrompt");
            String str = this._b;
            if (str != null) {
                try {
                    this._b = Uri.parse(str).buildUpon().appendQueryParameter("slotId", this._a).build().toString();
                } catch (Exception unused) {
                }
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("whitelist");
            this._i.clear();
            if (_ckVar._n == null) {
                _ckVar._n = new LinkedHashMap();
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(_ckVar._n);
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        _aw _awVar_a = new _aw()._a(jSONObject2);
                        if (_awVar_a._a()) {
                            linkedHashMap.put(_awVar_a._b, _awVar_a);
                        }
                    }
                }
            }
            this._i.putAll(linkedHashMap);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("blockPacket");
            this._j.clear();
            if (_ckVar._o == null) {
                _ckVar._o = new LinkedHashMap();
            }
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(_ckVar._o);
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    JSONObject jSONObject3 = jSONArrayOptJSONArray2.getJSONObject(i2);
                    if (jSONObject3 != null) {
                        _aw _awVar_a2 = new _aw()._a(jSONObject3);
                        if (_awVar_a2._a()) {
                            linkedHashMap2.put(_awVar_a2._b, _awVar_a2);
                        }
                    }
                }
            }
            this._j.putAll(linkedHashMap2);
            Set<String> hashSet = _ckVar._F;
            if (hashSet == null) {
                hashSet = new HashSet<>();
            }
            this._p = hashSet;
            Set<String> hashSet2 = _ckVar._E;
            if (hashSet2 == null) {
                hashSet2 = new HashSet<>();
            }
            this._o = hashSet2;
            Set<String> hashSet3 = _ckVar._z;
            if (hashSet3 == null) {
                hashSet3 = new HashSet<>();
            }
            this._k = hashSet3;
            Set<String> hashSet4 = _ckVar._B;
            if (hashSet4 == null) {
                hashSet4 = new HashSet<>();
            }
            this._m = hashSet4;
            Set<String> hashSet5 = _ckVar._G;
            if (hashSet5 == null) {
                hashSet5 = new HashSet<>();
            }
            this._q = hashSet5;
            Set<String> hashSet6 = _ckVar._D;
            if (hashSet6 == null) {
                hashSet6 = new HashSet<>();
            }
            this._n = hashSet6;
            Set<String> hashSet7 = _ckVar._A;
            if (hashSet7 == null) {
                hashSet7 = new HashSet<>();
            }
            this._l = hashSet7;
            Set<String> hashSet8 = _ckVar._H;
            if (hashSet8 == null) {
                hashSet8 = new HashSet<>();
            }
            this._r = hashSet8;
            Set<String> hashSet9 = _ckVar._I;
            if (hashSet9 == null) {
                hashSet9 = new HashSet<>();
            }
            this._s = hashSet9;
            Set<String> hashSet10 = _ckVar._J;
            if (hashSet10 == null) {
                hashSet10 = new HashSet<>();
            }
            this._t = hashSet10;
            Set<String> hashSet11 = _ckVar._K;
            if (hashSet11 == null) {
                hashSet11 = new HashSet<>();
            }
            this._u = hashSet11;
            JSONArray jSONArray = jSONObject.getJSONArray("slotBidding");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                _ci _ciVar = new _ci();
                if (!_ciVar._a(jSONObjectOptJSONObject, this, _ckVar)) {
                    return;
                }
                if (!_ciVar._p) {
                    _ciVar._a = this._a;
                    this._w.add(_ciVar);
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("slotBiddingV2");
            if (jSONObjectOptJSONObject2 == null || (jSONArrayNames = jSONObjectOptJSONObject2.names()) == null || jSONArrayNames.length() <= 0) {
                return;
            }
            int length = jSONArrayNames.length();
            for (int i4 = 0; i4 < length; i4++) {
                int iOptInt = jSONArrayNames.optInt(i4);
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject2.optJSONArray(String.valueOf(iOptInt));
                if (jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                    LinkedList linkedList = new LinkedList();
                    for (int i5 = 0; i5 < jSONArrayOptJSONArray3.length(); i5++) {
                        JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray3.optJSONObject(i5);
                        _ci _ciVar2 = new _ci();
                        if (!_ciVar2._a(jSONObjectOptJSONObject3, this, _ckVar)) {
                            return;
                        }
                        if (!_ciVar2._p) {
                            _ciVar2._a = this._a;
                            linkedList.add(_ciVar2);
                        }
                    }
                    this._x.put(Integer.valueOf(iOptInt), linkedList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.e("parse DispatchPolicySlotItem error: " + e.getMessage());
        }
    }
}
