package com.fancy;

import android.text.TextUtils;
import android.util.Base64;
import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.opos.acs.st.utils.ErrorContants;
import com.opos.mobad.activity.VideoActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _0 {

    public static class _a {
        public final boolean _a;
        public final _r _b;
        public final AdError _c;

        public _a(boolean z, _r _rVar, AdErrorImpl adErrorImpl) {
            this._a = z;
            this._b = _rVar;
            this._c = adErrorImpl;
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0064  */
    public static _ij _a(JSONObject jSONObject) {
        ArrayList arrayList;
        int length;
        _l3 _l3Var = null;
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._c("1"));
        if (jSONArrayOptJSONArray == null || (length = jSONArrayOptJSONArray.length()) <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
                String strOptString = jSONObjectOptJSONObject.optString(_z._d("1"));
                if (!TextUtils.isEmpty(strOptString)) {
                    _jz _jzVar = new _jz();
                    _jzVar._a = strOptString;
                    _jzVar._b = jSONObjectOptJSONObject.optInt(_z._d("2"));
                    _jzVar._c = jSONObjectOptJSONObject.optInt(_z._d("3"));
                    jSONObjectOptJSONObject.optString(_z._d("5"));
                    arrayList.add(_jzVar);
                }
            }
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(_z._c("2"));
        if (jSONObjectOptJSONObject2 != null) {
            String strOptString2 = jSONObjectOptJSONObject2.optString(_z._d("1"));
            if (!TextUtils.isEmpty(strOptString2)) {
                _l3Var = new _l3();
                _l3Var._a = strOptString2;
                _l3Var._c = jSONObjectOptJSONObject2.optInt(_z._d("2"));
                _l3Var._d = jSONObjectOptJSONObject2.optInt(_z._d("3"));
                _l3Var._e = jSONObjectOptJSONObject2.optInt(_z._d("4"));
                jSONObjectOptJSONObject2.optString(_z._d("5"));
                _l3Var._b = jSONObjectOptJSONObject2.optString(_z._d("6"));
            }
        }
        _ij _ijVar = new _ij();
        _ijVar._a = jSONObject.optString(_z._c("3"));
        _ijVar._b = jSONObject.optString(_z._c("4"));
        _ijVar._c = jSONObject.optString(_z._c("5"));
        _ijVar._d = jSONObject.optString(_z._c("6"));
        _ijVar._g = jSONObject.optString(_z._c("7"));
        _ijVar._h = jSONObject.optString(_z._c("8"));
        _ijVar._i = jSONObject.optString(_z._c("9"));
        _ijVar._e = arrayList;
        _ijVar._f = _l3Var;
        return _ijVar;
    }

    public static AppInfo _b(JSONObject jSONObject) {
        _pd _pdVar = null;
        if (jSONObject == null) {
            return null;
        }
        AppInfo appInfo = new AppInfo();
        appInfo.setIcon_url(jSONObject.optString(_z._e("1")));
        appInfo.setName(jSONObject.optString(_z._e("2")));
        appInfo.setPackage_name(jSONObject.optString(_z._e("3")));
        appInfo.setAppVersion(jSONObject.optString(_z._e("4")));
        appInfo.setDevelopers(jSONObject.optString(_z._e("5")));
        appInfo.setPrivacyProtocolUrl(jSONObject.optString(_z._e("6")));
        appInfo.setPermissionProtocolUrl(jSONObject.optString(_z._e("7")));
        appInfo.setFunctionDescUrl(jSONObject.optString(_z._e("8")));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(_z._e("9"));
        if (jSONObjectOptJSONObject != null) {
            _pdVar = new _pd();
            LinkedHashMap linkedHashMap = _z._g;
            int iOptInt = jSONObjectOptJSONObject.optInt(com.fancy.adsdk.lib.utils._a._a((String) linkedHashMap.get("1")));
            String strOptString = jSONObjectOptJSONObject.optString(com.fancy.adsdk.lib.utils._a._a((String) linkedHashMap.get("2")));
            String strOptString2 = jSONObjectOptJSONObject.optString(com.fancy.adsdk.lib.utils._a._a((String) linkedHashMap.get("3")));
            String strOptString3 = jSONObjectOptJSONObject.optString(com.fancy.adsdk.lib.utils._a._a((String) linkedHashMap.get("4")));
            String strOptString4 = jSONObjectOptJSONObject.optString(com.fancy.adsdk.lib.utils._a._a((String) linkedHashMap.get("5")));
            _pdVar._a = iOptInt;
            _pdVar._b = strOptString;
            _pdVar._c = strOptString2;
            _pdVar._d = strOptString3;
            _pdVar._e = strOptString4;
        }
        appInfo.setWechatExt(_pdVar);
        return appInfo;
    }

    public static HashMap _b(String str) {
        HashMap map = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("sundryParams");
                if (!TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject(strOptString);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject.optString(next));
                    }
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    public static _i _a(String str) {
        ArrayList arrayList;
        try {
            str = com.fancy.adsdk.lib.utils._a._a(_oi._a(), Base64.decode(str, 2));
        } catch (Exception unused) {
        }
        try {
            _i _iVar = new _i();
            JSONObject jSONObject = new JSONObject(str);
            _iVar._a = jSONObject.optInt(_z._f("1"));
            _iVar._b = jSONObject.optInt(_z._f("2"), 1501);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._f(BaseWrapper.ENTER_ID_19));
            HashMap map = null;
            if (jSONArrayOptJSONArray == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i)));
                }
            }
            _iVar._g = arrayList;
            _iVar._h = jSONObject.optInt(_z._f("3"), 1501);
            _iVar._d = jSONObject.optBoolean(_z._f("4"));
            _iVar._e = jSONObject.optInt(_z._f("5"));
            _iVar._f = jSONObject.optInt(_z._f("6"));
            _iVar._c = jSONObject.optInt(_z._f("7"), 1);
            _iVar._n = jSONObject.optBoolean(_z._f("25"), false);
            _iVar._i = jSONObject.optBoolean(_z._f("8"));
            _iVar._j = jSONObject.optInt(_z._f("9"));
            _iVar._k = jSONObject.optLong(_z._f("10"));
            _iVar._l = jSONObject.optInt(_z._f("11"));
            _iVar._m = jSONObject.optBoolean(_z._f("12"));
            _iVar._o = jSONObject.optBoolean(_z._f(BaseWrapper.ENTER_ID_GAME_CENTER));
            _iVar._p = jSONObject.optBoolean(_z._f(BaseWrapper.ENTER_ID_AD_SDK));
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(_z._f("15"));
            ArrayList arrayList2 = new ArrayList();
            if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
            _iVar._q = arrayList2;
            _iVar._r = (float) jSONObject.optDouble(_z._f(BaseWrapper.ENTER_ID_17), 36.0d);
            _iVar._s = (float) jSONObject.optDouble(_z._f(BaseWrapper.ENTER_ID_18), 36.0d);
            _iVar._t = (float) jSONObject.optDouble(_z._f(BaseWrapper.ENTER_ID_SHORTCUT), 3.0d);
            _iVar._u = (float) jSONObject.optDouble(_z._f("24"), 3.0d);
            _iVar._v = jSONObject.optBoolean(_z._f(BaseWrapper.ENTER_ID_SYSTEM_HELPER), false);
            _iVar._w = jSONObject.optBoolean(_z._f("21"), false);
            String strOptString = jSONObject.optString(_z._f(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
            try {
                if (!TextUtils.isEmpty(strOptString)) {
                    HashMap map2 = new HashMap();
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        map2.put(next, jSONObject2.optString(next));
                    }
                    map = map2;
                }
            } catch (Exception unused2) {
            }
            _iVar._x = map;
            return _iVar;
        } catch (Exception unused3) {
            return new _i();
        }
    }

    public static void _a(JSONObject jSONObject, _f _fVar) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("imp");
        if (jSONObjectOptJSONObject != null) {
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("0");
            ArrayList arrayList = new ArrayList();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            _fVar._o = arrayList;
            HashMap map = new HashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (TextUtils.isDigitsOnly(next) && Long.parseLong(next) != 0) {
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(next);
                    ArrayList arrayList2 = new ArrayList();
                    if (jSONArrayOptJSONArray2 != null) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                            arrayList2.add(jSONArrayOptJSONArray2.optString(i2));
                        }
                    }
                    map.put(Long.valueOf(next), arrayList2);
                }
            }
            _fVar._p = map;
        }
    }

    public static _a _a(_r _rVar, AdSlot adSlot) {
        String str_k;
        boolean z_u;
        if (adSlot == null) {
            AdErrorImpl adErrorImpl = new AdErrorImpl();
            adErrorImpl._a = 10010;
            adErrorImpl._b = PtgErrorCode.AD_SLOT_ERROR();
            return new _a(false, null, adErrorImpl);
        }
        List<_f> list = _rVar._a;
        if (list == null || list.isEmpty()) {
            AdErrorImpl adErrorImpl2 = new AdErrorImpl();
            adErrorImpl2._a = 10002;
            adErrorImpl2._b = PtgErrorCode.AD_DATA_ERROR();
            return new _a(false, null, adErrorImpl2);
        }
        int i_w = adSlot._w();
        _f _fVar = list.get(0);
        if (_fVar != null) {
            str_k = _fVar._k();
            z_u = _fVar._u();
        } else {
            str_k = "";
            z_u = false;
        }
        if (adSlot.isSelfRender()) {
            return new _a(true, _rVar, null);
        }
        if (6 == i_w) {
            if ("101".equals(str_k)) {
                return new _a(true, _rVar, null);
            }
            AdErrorImpl adErrorImpl3 = new AdErrorImpl();
            adErrorImpl3._a = PtgErrorCode.SDK_AD_STYLE_ERR;
            adErrorImpl3._b = PtgErrorCode.AD_STYLE_ERROR();
            return new _a(false, null, adErrorImpl3);
        }
        if (8 == i_w) {
            for (int i : _il._b(6)) {
                if (_im._a(i).equals(str_k)) {
                    if (!(z_u ? _im._c(i) : _im._b(i))) {
                        break;
                    }
                    return new _a(true, _rVar, null);
                }
            }
            AdErrorImpl adErrorImpl4 = new AdErrorImpl();
            adErrorImpl4._a = PtgErrorCode.SDK_AD_STYLE_ERR;
            adErrorImpl4._b = PtgErrorCode.AD_STYLE_ERROR();
            return new _a(false, null, adErrorImpl4);
        }
        if (5 == i_w) {
            for (int i2 : _il._b(7)) {
                if (_ik._a(i2).equals(str_k)) {
                    if (!(z_u ? _ik._c(i2) : _ik._b(i2))) {
                        break;
                    }
                    return new _a(true, _rVar, null);
                }
            }
            AdErrorImpl adErrorImpl5 = new AdErrorImpl();
            adErrorImpl5._a = PtgErrorCode.SDK_AD_STYLE_ERR;
            adErrorImpl5._b = PtgErrorCode.AD_STYLE_ERROR();
            return new _a(false, null, adErrorImpl5);
        }
        if (7 == i_w) {
            if (ErrorContants.REALTIME_LOADAD_ERROR.equals(str_k)) {
                return new _a(true, _rVar, null);
            }
            AdErrorImpl adErrorImpl6 = new AdErrorImpl();
            adErrorImpl6._a = PtgErrorCode.SDK_AD_STYLE_ERR;
            adErrorImpl6._b = PtgErrorCode.AD_STYLE_ERROR();
            return new _a(false, null, adErrorImpl6);
        }
        if (100 != i_w) {
            AdErrorImpl adErrorImpl7 = new AdErrorImpl();
            adErrorImpl7._a = PtgErrorCode.SDK_AD_STYLE_ERR;
            adErrorImpl7._b = PtgErrorCode.AD_STYLE_ERROR();
            return new _a(false, null, adErrorImpl7);
        }
        if ("401".equals(str_k)) {
            return new _a(true, _rVar, null);
        }
        AdErrorImpl adErrorImpl8 = new AdErrorImpl();
        adErrorImpl8._a = PtgErrorCode.SDK_AD_STYLE_ERR;
        adErrorImpl8._b = PtgErrorCode.AD_STYLE_ERROR();
        return new _a(false, null, adErrorImpl8);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02e4 A[Catch: Exception -> 0x060e, TRY_LEAVE, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:102:0x0342  */
    /* JADX WARN: Code duplicated, block: B:104:0x0347  */
    /* JADX WARN: Code duplicated, block: B:108:0x036e A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:109:0x0398  */
    /* JADX WARN: Code duplicated, block: B:112:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:115:0x03c7 A[Catch: Exception -> 0x060e, LOOP:1: B:113:0x03c1->B:115:0x03c7, LOOP_END, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:118:0x03e2  */
    /* JADX WARN: Code duplicated, block: B:121:0x03e9 A[Catch: Exception -> 0x060e, LOOP:2: B:119:0x03e3->B:121:0x03e9, LOOP_END, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0406  */
    /* JADX WARN: Code duplicated, block: B:127:0x040d A[Catch: Exception -> 0x060e, LOOP:3: B:125:0x0407->B:127:0x040d, LOOP_END, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:130:0x042a  */
    /* JADX WARN: Code duplicated, block: B:133:0x0431 A[Catch: Exception -> 0x060e, LOOP:4: B:131:0x042b->B:133:0x0431, LOOP_END, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:136:0x044f A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0459 A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:141:0x0472  */
    /* JADX WARN: Code duplicated, block: B:144:0x0479 A[Catch: Exception -> 0x060e, LOOP:6: B:142:0x0473->B:144:0x0479, LOOP_END, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:148:0x04c2  */
    /* JADX WARN: Code duplicated, block: B:151:0x04c9 A[Catch: Exception -> 0x060e, LOOP:7: B:149:0x04c3->B:151:0x04c9, LOOP_END, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:154:0x04e6  */
    /* JADX WARN: Code duplicated, block: B:157:0x04ed A[Catch: Exception -> 0x060e, LOOP:8: B:155:0x04e7->B:157:0x04ed, LOOP_END, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:160:0x054b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:161:0x054c  */
    /* JADX WARN: Code duplicated, block: B:167:0x057f A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0584  */
    /* JADX WARN: Code duplicated, block: B:170:0x0588  */
    /* JADX WARN: Code duplicated, block: B:174:0x05e1 A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:176:0x05e8 A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:178:0x05ec A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:180:0x05fd A[Catch: Exception -> 0x060e, TRY_LEAVE, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:239:0x0483 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x02b9 A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Code duplicated, block: B:98:0x02cb A[Catch: Exception -> 0x060e, TryCatch #2 {Exception -> 0x060e, blocks: (B:3:0x001b, B:5:0x0074, B:6:0x0081, B:8:0x00a1, B:12:0x00a8, B:94:0x02a8, B:96:0x02b9, B:98:0x02cb, B:100:0x02e4, B:106:0x034f, B:108:0x036e, B:110:0x039d, B:113:0x03c1, B:115:0x03c7, B:116:0x03d1, B:119:0x03e3, B:121:0x03e9, B:122:0x03f3, B:125:0x0407, B:127:0x040d, B:128:0x0417, B:131:0x042b, B:133:0x0431, B:134:0x043b, B:136:0x044f, B:137:0x0453, B:139:0x0459, B:142:0x0473, B:144:0x0479, B:145:0x0483, B:146:0x048f, B:149:0x04c3, B:151:0x04c9, B:152:0x04d3, B:155:0x04e7, B:157:0x04ed, B:158:0x04f7, B:163:0x0552, B:165:0x0565, B:167:0x057f, B:169:0x0585, B:171:0x05a7, B:164:0x055c, B:105:0x0349, B:172:0x05d5, B:174:0x05e1, B:176:0x05e8, B:178:0x05ec, B:180:0x05fd), top: B:198:0x001b }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 3 */
    public static _a _a(AdSlot adSlot, String str) {
        String str2;
        double d;
        String str3;
        String str4;
        String strOptString;
        boolean zOptBoolean;
        boolean zOptBoolean2;
        boolean zOptBoolean3;
        int iOptInt;
        float f;
        int i;
        _f0 _f0Var;
        String strOptString2;
        double d2;
        String str5;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        float f2;
        int i3;
        _f0 _f0Var2;
        _ba _baVar;
        String str6;
        _fi _fiVar;
        ArrayList arrayList;
        JSONArray jSONArrayOptJSONArray;
        ArrayList arrayList2;
        _r _rVar;
        _fi _fiVar2;
        long jCurrentTimeMillis;
        _f0 _f0Var3;
        int length;
        _ba _baVar2;
        int i4;
        _f _fVar;
        JSONObject jSONObjectOptJSONObject;
        String str7;
        String str8;
        HashMap map;
        float f3;
        String str9;
        String str10;
        String str11;
        _fi _fiVar3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i5;
        int i6;
        String strOptString3;
        String strDecode;
        JSONObject jSONObjectOptJSONObject2;
        _l _lVar;
        JSONArray jSONArrayOptJSONArray2;
        ArrayList arrayList3;
        JSONArray jSONArrayOptJSONArray3;
        ArrayList arrayList4;
        JSONArray jSONArrayOptJSONArray4;
        ArrayList arrayList5;
        JSONArray jSONArrayOptJSONArray5;
        ArrayList arrayList6;
        JSONObject jSONObjectOptJSONObject3;
        HashMap map2;
        JSONArray jSONArrayOptJSONArray6;
        ArrayList arrayList7;
        JSONArray jSONArrayOptJSONArray7;
        ArrayList arrayList8;
        boolean z_c;
        int i7;
        int i8;
        Iterator<String> itKeys;
        JSONArray jSONArrayOptJSONArray8;
        ArrayList arrayList9;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        String str12;
        _ba _baVar3;
        String str13 = "9";
        String str14 = "10";
        String str15 = "8";
        String str16 = "7";
        String str17 = "5";
        _r _rVar2 = new _r();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString4 = jSONObject.optString(_z._a("1"));
            _rVar2._d = strOptString4;
            _rVar2._e = jSONObject.optInt(_z._a("2"));
            _rVar2._f = jSONObject.optString(_z._a("3"));
            _rVar2._c = jSONObject.optLong(_z._a("4"));
            _rVar2._b = jSONObject.optString(_z._a("5"));
            _rVar2._h = jSONObject.optLong(_z._a("6"));
            _rVar2._i = jSONObject.optString(_z._a("7"));
            if (_rVar2._h == 0) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                _rVar2._h = jCurrentTimeMillis2;
                jSONObject.put(_z._a("6"), jCurrentTimeMillis2);
            }
            _rVar2._g = jSONObject.toString();
            _i _iVar_a = _a(jSONObject.optString(_z._a("8")));
            HashMap map_b = _b(_rVar2._i);
            map_b.put("iReportM", String.valueOf(_iVar_a._d() && _iVar_a._m));
            try {
                String strOptString5 = jSONObject.optString(_z._a("10"));
                if (TextUtils.isEmpty(strOptString5)) {
                    str2 = "";
                    _rVar2 = _rVar2;
                    d2 = 0.3d;
                    str5 = str2;
                    strOptString2 = str5;
                    str6 = strOptString2;
                    _baVar = null;
                    _f0Var2 = null;
                    _fiVar = null;
                    f2 = 0.1f;
                    z = false;
                    z2 = false;
                    z3 = false;
                    i2 = 0;
                    i3 = 0;
                } else {
                    JSONObject jSONObject2 = new JSONObject(strOptString5);
                    String strOptString6 = jSONObject2.optString(com.fancy.adsdk.lib.utils._a._a("bGlua01vZGU="));
                    str2 = "";
                    try {
                        strOptString2 = jSONObject2.optString(com.fancy.adsdk.lib.utils._a._a("bGlua1NpZ24="));
                        try {
                            strOptString = jSONObject2.optString("pms");
                            str12 = strOptString6;
                            try {
                                zOptBoolean = jSONObject2.optBoolean("reportDpState", false);
                                try {
                                    zOptBoolean2 = jSONObject2.optBoolean("applyConfig", false);
                                    try {
                                        zOptBoolean3 = jSONObject2.optBoolean("reportAcs", false);
                                        _rVar2 = _rVar2;
                                        double dOptDouble = 0.3d;
                                        try {
                                            dOptDouble = jSONObject2.optDouble("blurThreshold", 0.3d);
                                            d = dOptDouble;
                                            try {
                                                iOptInt = jSONObject2.optInt("loadExpose", 0);
                                                try {
                                                    float fOptDouble = (float) jSONObject2.optDouble("exposureArea", 0.1d);
                                                    try {
                                                        int iOptInt2 = jSONObject2.optInt("hideAdFeedBack", 0);
                                                        try {
                                                            _f0 _f0Var_a = _f0._a(jSONObject2.optJSONObject("incentiveVideoConfig"));
                                                            f = fOptDouble;
                                                            try {
                                                                JSONObject jSONObjectOptJSONObject4 = jSONObject2.optJSONObject("interstitialConfig");
                                                                i = iOptInt2;
                                                                try {
                                                                    _fi _fiVar4 = new _fi();
                                                                    if (jSONObjectOptJSONObject4 != null) {
                                                                        _f0Var = _f0Var_a;
                                                                        try {
                                                                            _fiVar4._a = jSONObjectOptJSONObject4.optInt("screenType");
                                                                            _fiVar4._b = jSONObjectOptJSONObject4.optInt(VideoActivity.EXTRA_KEY_SCREEN_MODE);
                                                                        } catch (Exception unused) {
                                                                            str3 = strOptString2;
                                                                            str4 = str12;
                                                                            strOptString2 = str3;
                                                                            d2 = d;
                                                                            str5 = strOptString;
                                                                            z = zOptBoolean;
                                                                            z2 = zOptBoolean2;
                                                                            z3 = zOptBoolean3;
                                                                            i2 = iOptInt;
                                                                            f2 = f;
                                                                            i3 = i;
                                                                            _f0Var2 = _f0Var;
                                                                            _baVar = null;
                                                                            str6 = str4;
                                                                            _fiVar = null;
                                                                        }
                                                                    } else {
                                                                        _f0Var = _f0Var_a;
                                                                    }
                                                                    try {
                                                                        _ba _baVar_a = _ba._a(jSONObject2.optJSONObject("commonConfig"));
                                                                        try {
                                                                            _ia._a(_u._a(jSONObject2.optJSONObject("pre")));
                                                                            if ("1".equals(jSONObject2.optString("updateConfig"))) {
                                                                                _fn _fnVar = _fn._b;
                                                                                _k _kVar = new _k();
                                                                                _baVar3 = _baVar_a;
                                                                                try {
                                                                                    CopyOnWriteArrayList<_hl<_k>> copyOnWriteArrayList = _fnVar._a.get("configUpdate");
                                                                                    if (!TextUtil.isEmpty(copyOnWriteArrayList)) {
                                                                                        Iterator<_hl<_k>> it = copyOnWriteArrayList.iterator();
                                                                                        while (it.hasNext()) {
                                                                                            it.next()._a(_kVar);
                                                                                        }
                                                                                    }
                                                                                } catch (Exception unused2) {
                                                                                }
                                                                            } else {
                                                                                _baVar3 = _baVar_a;
                                                                            }
                                                                        } catch (Exception unused3) {
                                                                        }
                                                                    } catch (Exception unused4) {
                                                                        _baVar3 = null;
                                                                    }
                                                                    _fiVar = _fiVar4;
                                                                    d2 = d;
                                                                    str5 = strOptString;
                                                                    str6 = str12;
                                                                    z = zOptBoolean;
                                                                    z2 = zOptBoolean2;
                                                                    z3 = zOptBoolean3;
                                                                    i2 = iOptInt;
                                                                    f2 = f;
                                                                    i3 = i;
                                                                    _f0Var2 = _f0Var;
                                                                    _baVar = _baVar3;
                                                                } catch (Exception unused5) {
                                                                    _f0Var = _f0Var_a;
                                                                    str3 = strOptString2;
                                                                    str4 = str12;
                                                                    strOptString2 = str3;
                                                                    d2 = d;
                                                                    str5 = strOptString;
                                                                    z = zOptBoolean;
                                                                    z2 = zOptBoolean2;
                                                                    z3 = zOptBoolean3;
                                                                    i2 = iOptInt;
                                                                    f2 = f;
                                                                    i3 = i;
                                                                    _f0Var2 = _f0Var;
                                                                    _baVar = null;
                                                                    str6 = str4;
                                                                    _fiVar = null;
                                                                    arrayList = new ArrayList();
                                                                    jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
                                                                    if (jSONArrayOptJSONArray != null) {
                                                                        _f0 _f0Var4 = _f0Var2;
                                                                        _fiVar2 = _fiVar;
                                                                        jCurrentTimeMillis = System.currentTimeMillis();
                                                                        _f0Var3 = _f0Var4;
                                                                        length = jSONArrayOptJSONArray.length();
                                                                        _baVar2 = _baVar;
                                                                        i4 = 0;
                                                                        while (i4 < length) {
                                                                            int i14 = length;
                                                                            _fVar = new _f();
                                                                            _fVar._w = strOptString4;
                                                                            _fVar._z = jCurrentTimeMillis;
                                                                            long j = jCurrentTimeMillis;
                                                                            _fVar._B = adSlot._w();
                                                                            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                                                            if (jSONObjectOptJSONObject != null) {
                                                                                _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                                                                                _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                                                                                _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                                                                                jSONObjectOptJSONObject.optString(_z._b("4"));
                                                                                _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                                                                                _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                                                                                _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                                                                                _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                                                                                jSONObjectOptJSONObject.optString(_z._b(str13));
                                                                                strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                                                                                if (strOptString3 == null) {
                                                                                    str7 = str13;
                                                                                } else {
                                                                                    str7 = str13;
                                                                                    try {
                                                                                        strDecode = URLDecoder.decode(strOptString3, "utf-8");
                                                                                    } catch (UnsupportedEncodingException unused6) {
                                                                                        strDecode = str2;
                                                                                    }
                                                                                    _fVar._r = strDecode;
                                                                                    _fVar._s = _iVar_a;
                                                                                    _fVar._t = map_b;
                                                                                    _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                                    jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                                    if (jSONObjectOptJSONObject2 != null) {
                                                                                        _lVar = new _l();
                                                                                        _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                                        _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                                        _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                                        _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                                    } else {
                                                                                        _lVar = null;
                                                                                    }
                                                                                    _fVar._q = _lVar;
                                                                                    _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                                    jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                                    arrayList3 = new ArrayList();
                                                                                    if (jSONArrayOptJSONArray2 != null) {
                                                                                        for (i13 = 0; i13 < jSONArrayOptJSONArray2.length(); i13++) {
                                                                                            arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                                        }
                                                                                    }
                                                                                    jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                                    arrayList4 = new ArrayList();
                                                                                    if (jSONArrayOptJSONArray3 != null) {
                                                                                        for (i12 = 0; i12 < jSONArrayOptJSONArray3.length(); i12++) {
                                                                                            arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                                        }
                                                                                    }
                                                                                    _fVar._f = arrayList4;
                                                                                    jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                                    arrayList5 = new ArrayList();
                                                                                    if (jSONArrayOptJSONArray4 != null) {
                                                                                        for (i11 = 0; i11 < jSONArrayOptJSONArray4.length(); i11++) {
                                                                                            arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                                        }
                                                                                    }
                                                                                    _fVar._g = arrayList5;
                                                                                    jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                                    arrayList6 = new ArrayList();
                                                                                    if (jSONArrayOptJSONArray5 != null) {
                                                                                        for (i10 = 0; i10 < jSONArrayOptJSONArray5.length(); i10++) {
                                                                                            arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                                        }
                                                                                    }
                                                                                    _a(jSONObjectOptJSONObject, _fVar);
                                                                                    jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                                    map2 = new HashMap();
                                                                                    if (jSONObjectOptJSONObject3 != null) {
                                                                                        itKeys = jSONObjectOptJSONObject3.keys();
                                                                                        while (itKeys.hasNext()) {
                                                                                            String next = itKeys.next();
                                                                                            Iterator<String> it2 = itKeys;
                                                                                            jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next);
                                                                                            JSONObject jSONObject3 = jSONObjectOptJSONObject3;
                                                                                            arrayList9 = new ArrayList();
                                                                                            String str18 = str17;
                                                                                            HashMap map3 = map_b;
                                                                                            if (jSONArrayOptJSONArray8 != null) {
                                                                                                for (i9 = 0; i9 < jSONArrayOptJSONArray8.length(); i9++) {
                                                                                                    arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                                                }
                                                                                            }
                                                                                            map2.put(next, arrayList9);
                                                                                            itKeys = it2;
                                                                                            jSONObjectOptJSONObject3 = jSONObject3;
                                                                                            str17 = str18;
                                                                                            map_b = map3;
                                                                                        }
                                                                                    }
                                                                                    str8 = str17;
                                                                                    map = map_b;
                                                                                    _fVar._h = map2;
                                                                                    _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                                    _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                                    jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                                    arrayList7 = new ArrayList();
                                                                                    if (jSONArrayOptJSONArray6 != null) {
                                                                                        for (i8 = 0; i8 < jSONArrayOptJSONArray6.length(); i8++) {
                                                                                            arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                                        }
                                                                                    }
                                                                                    _fVar._H = arrayList7;
                                                                                    jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                                    arrayList8 = new ArrayList();
                                                                                    if (jSONArrayOptJSONArray7 != null) {
                                                                                        for (i7 = 0; i7 < jSONArrayOptJSONArray7.length(); i7++) {
                                                                                            arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                                        }
                                                                                    }
                                                                                    _fVar._I = arrayList8;
                                                                                    _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                                    _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                                    _ba _baVar4 = _baVar2;
                                                                                    _fVar._G = _baVar4;
                                                                                    _f0 _f0Var5 = _f0Var3;
                                                                                    _fVar._E = _f0Var5;
                                                                                    _fiVar3 = _fiVar2;
                                                                                    _fVar._F = _fiVar3;
                                                                                    str11 = str6;
                                                                                    _fVar._N = str11;
                                                                                    str10 = strOptString2;
                                                                                    _fVar._O = str10;
                                                                                    str9 = str5;
                                                                                    _fVar._W = str9;
                                                                                    _baVar2 = _baVar4;
                                                                                    boolean z7 = z;
                                                                                    _fVar._P = z7;
                                                                                    z4 = z7;
                                                                                    boolean z8 = z2;
                                                                                    _fVar._Q = z8;
                                                                                    z5 = z8;
                                                                                    boolean z9 = z3;
                                                                                    _fVar._R = z9;
                                                                                    z6 = z9;
                                                                                    _f0Var3 = _f0Var5;
                                                                                    d2 = d2;
                                                                                    _fVar._S = d2;
                                                                                    if (f2 >= 0.0f) {
                                                                                        f3 = f2;
                                                                                        _fVar._U = f3;
                                                                                        int i15 = i3;
                                                                                        _fVar._V = i15;
                                                                                        i6 = i15;
                                                                                        int i16 = i2;
                                                                                        _fVar._T = i16;
                                                                                        i5 = i16;
                                                                                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                                        if (adSlot.isSelfRender()) {
                                                                                            z_c = _iVar_a._c();
                                                                                        } else {
                                                                                            z_c = false;
                                                                                        }
                                                                                        _fVar._L = z_c;
                                                                                    }
                                                                                    _fVar._U = 0.1f;
                                                                                    f3 = f2;
                                                                                    int i17 = i3;
                                                                                    _fVar._V = i17;
                                                                                    i6 = i17;
                                                                                    int i18 = i2;
                                                                                    _fVar._T = i18;
                                                                                    i5 = i18;
                                                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                                    if (adSlot.isSelfRender()) {
                                                                                        z_c = _iVar_a._c();
                                                                                    } else {
                                                                                        z_c = false;
                                                                                    }
                                                                                    _fVar._L = z_c;
                                                                                }
                                                                                strDecode = str2;
                                                                                _fVar._r = strDecode;
                                                                                _fVar._s = _iVar_a;
                                                                                _fVar._t = map_b;
                                                                                _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                                jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                                if (jSONObjectOptJSONObject2 != null) {
                                                                                    _lVar = new _l();
                                                                                    _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                                    _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                                    _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                                    _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                                } else {
                                                                                    _lVar = null;
                                                                                }
                                                                                _fVar._q = _lVar;
                                                                                _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                                arrayList3 = new ArrayList();
                                                                                if (jSONArrayOptJSONArray2 != null) {
                                                                                    while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                                        arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                                    }
                                                                                }
                                                                                jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                                arrayList4 = new ArrayList();
                                                                                if (jSONArrayOptJSONArray3 != null) {
                                                                                    while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                                        arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                                    }
                                                                                }
                                                                                _fVar._f = arrayList4;
                                                                                jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                                arrayList5 = new ArrayList();
                                                                                if (jSONArrayOptJSONArray4 != null) {
                                                                                    while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                                        arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                                    }
                                                                                }
                                                                                _fVar._g = arrayList5;
                                                                                jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                                arrayList6 = new ArrayList();
                                                                                if (jSONArrayOptJSONArray5 != null) {
                                                                                    while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                                        arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                                    }
                                                                                }
                                                                                _a(jSONObjectOptJSONObject, _fVar);
                                                                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                                map2 = new HashMap();
                                                                                if (jSONObjectOptJSONObject3 != null) {
                                                                                    itKeys = jSONObjectOptJSONObject3.keys();
                                                                                    while (itKeys.hasNext()) {
                                                                                        String next2 = itKeys.next();
                                                                                        Iterator<String> it3 = itKeys;
                                                                                        jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next2);
                                                                                        JSONObject jSONObject4 = jSONObjectOptJSONObject3;
                                                                                        arrayList9 = new ArrayList();
                                                                                        String str19 = str17;
                                                                                        HashMap map4 = map_b;
                                                                                        if (jSONArrayOptJSONArray8 != null) {
                                                                                            while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                                                arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                                            }
                                                                                        }
                                                                                        map2.put(next2, arrayList9);
                                                                                        itKeys = it3;
                                                                                        jSONObjectOptJSONObject3 = jSONObject4;
                                                                                        str17 = str19;
                                                                                        map_b = map4;
                                                                                    }
                                                                                }
                                                                                str8 = str17;
                                                                                map = map_b;
                                                                                _fVar._h = map2;
                                                                                _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                                _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                                jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                                arrayList7 = new ArrayList();
                                                                                if (jSONArrayOptJSONArray6 != null) {
                                                                                    while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                                        arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                                    }
                                                                                }
                                                                                _fVar._H = arrayList7;
                                                                                jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                                arrayList8 = new ArrayList();
                                                                                if (jSONArrayOptJSONArray7 != null) {
                                                                                    while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                                        arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                                    }
                                                                                }
                                                                                _fVar._I = arrayList8;
                                                                                _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                                _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                                _ba _baVar5 = _baVar2;
                                                                                _fVar._G = _baVar5;
                                                                                _f0 _f0Var6 = _f0Var3;
                                                                                _fVar._E = _f0Var6;
                                                                                _fiVar3 = _fiVar2;
                                                                                _fVar._F = _fiVar3;
                                                                                str11 = str6;
                                                                                _fVar._N = str11;
                                                                                str10 = strOptString2;
                                                                                _fVar._O = str10;
                                                                                str9 = str5;
                                                                                _fVar._W = str9;
                                                                                _baVar2 = _baVar5;
                                                                                boolean z10 = z;
                                                                                _fVar._P = z10;
                                                                                z4 = z10;
                                                                                boolean z11 = z2;
                                                                                _fVar._Q = z11;
                                                                                z5 = z11;
                                                                                boolean z12 = z3;
                                                                                _fVar._R = z12;
                                                                                z6 = z12;
                                                                                _f0Var3 = _f0Var6;
                                                                                d2 = d2;
                                                                                _fVar._S = d2;
                                                                                if (f2 >= 0.0f) {
                                                                                    f3 = f2;
                                                                                    _fVar._U = f3;
                                                                                    int i19 = i3;
                                                                                    _fVar._V = i19;
                                                                                    i6 = i19;
                                                                                    int i110 = i2;
                                                                                    _fVar._T = i110;
                                                                                    i5 = i110;
                                                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                                    if (adSlot.isSelfRender()) {
                                                                                        z_c = _iVar_a._c();
                                                                                    } else {
                                                                                        z_c = false;
                                                                                    }
                                                                                    _fVar._L = z_c;
                                                                                }
                                                                                _fVar._U = 0.1f;
                                                                                f3 = f2;
                                                                                int i111 = i3;
                                                                                _fVar._V = i111;
                                                                                i6 = i111;
                                                                                int i112 = i2;
                                                                                _fVar._T = i112;
                                                                                i5 = i112;
                                                                                _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                                if (adSlot.isSelfRender()) {
                                                                                    z_c = _iVar_a._c();
                                                                                } else {
                                                                                    z_c = false;
                                                                                }
                                                                                _fVar._L = z_c;
                                                                            } else {
                                                                                str7 = str13;
                                                                                str15 = str15;
                                                                                str16 = str16;
                                                                                str8 = str17;
                                                                                map = map_b;
                                                                                f3 = f2;
                                                                                str9 = str5;
                                                                                str10 = strOptString2;
                                                                                str11 = str6;
                                                                                _fiVar3 = _fiVar2;
                                                                                z4 = z;
                                                                                z5 = z2;
                                                                                z6 = z3;
                                                                                i5 = i2;
                                                                                i6 = i3;
                                                                            }
                                                                            ArrayList arrayList10 = arrayList;
                                                                            arrayList10.add(_fVar);
                                                                            i4++;
                                                                            arrayList = arrayList10;
                                                                            i3 = i6;
                                                                            z = z4;
                                                                            z2 = z5;
                                                                            z3 = z6;
                                                                            i2 = i5;
                                                                            length = i14;
                                                                            str13 = str7;
                                                                            f2 = f3;
                                                                            _fiVar2 = _fiVar3;
                                                                            str6 = str11;
                                                                            strOptString2 = str10;
                                                                            str5 = str9;
                                                                            str14 = str14;
                                                                            jCurrentTimeMillis = j;
                                                                            str15 = str15;
                                                                            str16 = str16;
                                                                            str17 = str8;
                                                                            map_b = map;
                                                                        }
                                                                    }
                                                                    arrayList2 = arrayList;
                                                                    _rVar = _rVar2;
                                                                    _rVar._a = arrayList2;
                                                                    if (!arrayList2.isEmpty()) {
                                                                        return _a(_rVar, adSlot);
                                                                    }
                                                                    if (_rVar._e != 0) {
                                                                        return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
                                                                    }
                                                                    return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                                                                }
                                                            } catch (Exception unused7) {
                                                                i = iOptInt2;
                                                            }
                                                        } catch (Exception unused8) {
                                                            f = fOptDouble;
                                                            i = iOptInt2;
                                                            str3 = strOptString2;
                                                            str4 = str12;
                                                            _f0Var = null;
                                                            strOptString2 = str3;
                                                            d2 = d;
                                                            str5 = strOptString;
                                                            z = zOptBoolean;
                                                            z2 = zOptBoolean2;
                                                            z3 = zOptBoolean3;
                                                            i2 = iOptInt;
                                                            f2 = f;
                                                            i3 = i;
                                                            _f0Var2 = _f0Var;
                                                            _baVar = null;
                                                            str6 = str4;
                                                            _fiVar = null;
                                                            arrayList = new ArrayList();
                                                            jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
                                                            if (jSONArrayOptJSONArray != null) {
                                                                _f0 _f0Var7 = _f0Var2;
                                                                _fiVar2 = _fiVar;
                                                                jCurrentTimeMillis = System.currentTimeMillis();
                                                                _f0Var3 = _f0Var7;
                                                                length = jSONArrayOptJSONArray.length();
                                                                _baVar2 = _baVar;
                                                                i4 = 0;
                                                                while (i4 < length) {
                                                                    int i113 = length;
                                                                    _fVar = new _f();
                                                                    _fVar._w = strOptString4;
                                                                    _fVar._z = jCurrentTimeMillis;
                                                                    long j2 = jCurrentTimeMillis;
                                                                    _fVar._B = adSlot._w();
                                                                    jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                                                    if (jSONObjectOptJSONObject != null) {
                                                                        _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                                                                        _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                                                                        _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                                                                        jSONObjectOptJSONObject.optString(_z._b("4"));
                                                                        _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                                                                        _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                                                                        _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                                                                        _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                                                                        jSONObjectOptJSONObject.optString(_z._b(str13));
                                                                        strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                                                                        if (strOptString3 == null) {
                                                                            str7 = str13;
                                                                        } else {
                                                                            str7 = str13;
                                                                            strDecode = URLDecoder.decode(strOptString3, "utf-8");
                                                                            _fVar._r = strDecode;
                                                                            _fVar._s = _iVar_a;
                                                                            _fVar._t = map_b;
                                                                            _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                            jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                            if (jSONObjectOptJSONObject2 != null) {
                                                                                _lVar = new _l();
                                                                                _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                                _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                                _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                                _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                            } else {
                                                                                _lVar = null;
                                                                            }
                                                                            _fVar._q = _lVar;
                                                                            _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                            arrayList3 = new ArrayList();
                                                                            if (jSONArrayOptJSONArray2 != null) {
                                                                                while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                                    arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                                }
                                                                            }
                                                                            jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                            arrayList4 = new ArrayList();
                                                                            if (jSONArrayOptJSONArray3 != null) {
                                                                                while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                                    arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                                }
                                                                            }
                                                                            _fVar._f = arrayList4;
                                                                            jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                            arrayList5 = new ArrayList();
                                                                            if (jSONArrayOptJSONArray4 != null) {
                                                                                while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                                    arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                                }
                                                                            }
                                                                            _fVar._g = arrayList5;
                                                                            jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                            arrayList6 = new ArrayList();
                                                                            if (jSONArrayOptJSONArray5 != null) {
                                                                                while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                                    arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                                }
                                                                            }
                                                                            _a(jSONObjectOptJSONObject, _fVar);
                                                                            jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                            map2 = new HashMap();
                                                                            if (jSONObjectOptJSONObject3 != null) {
                                                                                itKeys = jSONObjectOptJSONObject3.keys();
                                                                                while (itKeys.hasNext()) {
                                                                                    String next3 = itKeys.next();
                                                                                    Iterator<String> it4 = itKeys;
                                                                                    jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next3);
                                                                                    JSONObject jSONObject5 = jSONObjectOptJSONObject3;
                                                                                    arrayList9 = new ArrayList();
                                                                                    String str110 = str17;
                                                                                    HashMap map5 = map_b;
                                                                                    if (jSONArrayOptJSONArray8 != null) {
                                                                                        while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                                            arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                                        }
                                                                                    }
                                                                                    map2.put(next3, arrayList9);
                                                                                    itKeys = it4;
                                                                                    jSONObjectOptJSONObject3 = jSONObject5;
                                                                                    str17 = str110;
                                                                                    map_b = map5;
                                                                                }
                                                                            }
                                                                            str8 = str17;
                                                                            map = map_b;
                                                                            _fVar._h = map2;
                                                                            _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                            _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                            jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                            arrayList7 = new ArrayList();
                                                                            if (jSONArrayOptJSONArray6 != null) {
                                                                                while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                                    arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                                }
                                                                            }
                                                                            _fVar._H = arrayList7;
                                                                            jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                            arrayList8 = new ArrayList();
                                                                            if (jSONArrayOptJSONArray7 != null) {
                                                                                while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                                    arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                                }
                                                                            }
                                                                            _fVar._I = arrayList8;
                                                                            _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                            _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                            _ba _baVar6 = _baVar2;
                                                                            _fVar._G = _baVar6;
                                                                            _f0 _f0Var8 = _f0Var3;
                                                                            _fVar._E = _f0Var8;
                                                                            _fiVar3 = _fiVar2;
                                                                            _fVar._F = _fiVar3;
                                                                            str11 = str6;
                                                                            _fVar._N = str11;
                                                                            str10 = strOptString2;
                                                                            _fVar._O = str10;
                                                                            str9 = str5;
                                                                            _fVar._W = str9;
                                                                            _baVar2 = _baVar6;
                                                                            boolean z13 = z;
                                                                            _fVar._P = z13;
                                                                            z4 = z13;
                                                                            boolean z14 = z2;
                                                                            _fVar._Q = z14;
                                                                            z5 = z14;
                                                                            boolean z15 = z3;
                                                                            _fVar._R = z15;
                                                                            z6 = z15;
                                                                            _f0Var3 = _f0Var8;
                                                                            d2 = d2;
                                                                            _fVar._S = d2;
                                                                            if (f2 >= 0.0f) {
                                                                                f3 = f2;
                                                                                _fVar._U = f3;
                                                                                int i114 = i3;
                                                                                _fVar._V = i114;
                                                                                i6 = i114;
                                                                                int i115 = i2;
                                                                                _fVar._T = i115;
                                                                                i5 = i115;
                                                                                _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                                if (adSlot.isSelfRender()) {
                                                                                    z_c = _iVar_a._c();
                                                                                } else {
                                                                                    z_c = false;
                                                                                }
                                                                                _fVar._L = z_c;
                                                                            }
                                                                            _fVar._U = 0.1f;
                                                                            f3 = f2;
                                                                            int i116 = i3;
                                                                            _fVar._V = i116;
                                                                            i6 = i116;
                                                                            int i117 = i2;
                                                                            _fVar._T = i117;
                                                                            i5 = i117;
                                                                            _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                            if (adSlot.isSelfRender()) {
                                                                                z_c = _iVar_a._c();
                                                                            } else {
                                                                                z_c = false;
                                                                            }
                                                                            _fVar._L = z_c;
                                                                        }
                                                                        strDecode = str2;
                                                                        _fVar._r = strDecode;
                                                                        _fVar._s = _iVar_a;
                                                                        _fVar._t = map_b;
                                                                        _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                        if (jSONObjectOptJSONObject2 != null) {
                                                                            _lVar = new _l();
                                                                            _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                            _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                            _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                            _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                        } else {
                                                                            _lVar = null;
                                                                        }
                                                                        _fVar._q = _lVar;
                                                                        _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                        jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                        arrayList3 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray2 != null) {
                                                                            while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                                arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                            }
                                                                        }
                                                                        jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                        arrayList4 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray3 != null) {
                                                                            while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                                arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                            }
                                                                        }
                                                                        _fVar._f = arrayList4;
                                                                        jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                        arrayList5 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray4 != null) {
                                                                            while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                                arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                            }
                                                                        }
                                                                        _fVar._g = arrayList5;
                                                                        jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                        arrayList6 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray5 != null) {
                                                                            while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                                arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                            }
                                                                        }
                                                                        _a(jSONObjectOptJSONObject, _fVar);
                                                                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                        map2 = new HashMap();
                                                                        if (jSONObjectOptJSONObject3 != null) {
                                                                            itKeys = jSONObjectOptJSONObject3.keys();
                                                                            while (itKeys.hasNext()) {
                                                                                String next4 = itKeys.next();
                                                                                Iterator<String> it5 = itKeys;
                                                                                jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next4);
                                                                                JSONObject jSONObject6 = jSONObjectOptJSONObject3;
                                                                                arrayList9 = new ArrayList();
                                                                                String str111 = str17;
                                                                                HashMap map6 = map_b;
                                                                                if (jSONArrayOptJSONArray8 != null) {
                                                                                    while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                                        arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                                    }
                                                                                }
                                                                                map2.put(next4, arrayList9);
                                                                                itKeys = it5;
                                                                                jSONObjectOptJSONObject3 = jSONObject6;
                                                                                str17 = str111;
                                                                                map_b = map6;
                                                                            }
                                                                        }
                                                                        str8 = str17;
                                                                        map = map_b;
                                                                        _fVar._h = map2;
                                                                        _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                        _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                        jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                        arrayList7 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray6 != null) {
                                                                            while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                                arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                            }
                                                                        }
                                                                        _fVar._H = arrayList7;
                                                                        jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                        arrayList8 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray7 != null) {
                                                                            while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                                arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                            }
                                                                        }
                                                                        _fVar._I = arrayList8;
                                                                        _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                        _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                        _ba _baVar7 = _baVar2;
                                                                        _fVar._G = _baVar7;
                                                                        _f0 _f0Var9 = _f0Var3;
                                                                        _fVar._E = _f0Var9;
                                                                        _fiVar3 = _fiVar2;
                                                                        _fVar._F = _fiVar3;
                                                                        str11 = str6;
                                                                        _fVar._N = str11;
                                                                        str10 = strOptString2;
                                                                        _fVar._O = str10;
                                                                        str9 = str5;
                                                                        _fVar._W = str9;
                                                                        _baVar2 = _baVar7;
                                                                        boolean z16 = z;
                                                                        _fVar._P = z16;
                                                                        z4 = z16;
                                                                        boolean z17 = z2;
                                                                        _fVar._Q = z17;
                                                                        z5 = z17;
                                                                        boolean z18 = z3;
                                                                        _fVar._R = z18;
                                                                        z6 = z18;
                                                                        _f0Var3 = _f0Var9;
                                                                        d2 = d2;
                                                                        _fVar._S = d2;
                                                                        if (f2 >= 0.0f) {
                                                                            f3 = f2;
                                                                            _fVar._U = f3;
                                                                            int i118 = i3;
                                                                            _fVar._V = i118;
                                                                            i6 = i118;
                                                                            int i119 = i2;
                                                                            _fVar._T = i119;
                                                                            i5 = i119;
                                                                            _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                            if (adSlot.isSelfRender()) {
                                                                                z_c = _iVar_a._c();
                                                                            } else {
                                                                                z_c = false;
                                                                            }
                                                                            _fVar._L = z_c;
                                                                        }
                                                                        _fVar._U = 0.1f;
                                                                        f3 = f2;
                                                                        int i1110 = i3;
                                                                        _fVar._V = i1110;
                                                                        i6 = i1110;
                                                                        int i1111 = i2;
                                                                        _fVar._T = i1111;
                                                                        i5 = i1111;
                                                                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                        if (adSlot.isSelfRender()) {
                                                                            z_c = _iVar_a._c();
                                                                        } else {
                                                                            z_c = false;
                                                                        }
                                                                        _fVar._L = z_c;
                                                                    } else {
                                                                        str7 = str13;
                                                                        str15 = str15;
                                                                        str16 = str16;
                                                                        str8 = str17;
                                                                        map = map_b;
                                                                        f3 = f2;
                                                                        str9 = str5;
                                                                        str10 = strOptString2;
                                                                        str11 = str6;
                                                                        _fiVar3 = _fiVar2;
                                                                        z4 = z;
                                                                        z5 = z2;
                                                                        z6 = z3;
                                                                        i5 = i2;
                                                                        i6 = i3;
                                                                    }
                                                                    ArrayList arrayList11 = arrayList;
                                                                    arrayList11.add(_fVar);
                                                                    i4++;
                                                                    arrayList = arrayList11;
                                                                    i3 = i6;
                                                                    z = z4;
                                                                    z2 = z5;
                                                                    z3 = z6;
                                                                    i2 = i5;
                                                                    length = i113;
                                                                    str13 = str7;
                                                                    f2 = f3;
                                                                    _fiVar2 = _fiVar3;
                                                                    str6 = str11;
                                                                    strOptString2 = str10;
                                                                    str5 = str9;
                                                                    str14 = str14;
                                                                    jCurrentTimeMillis = j2;
                                                                    str15 = str15;
                                                                    str16 = str16;
                                                                    str17 = str8;
                                                                    map_b = map;
                                                                }
                                                            }
                                                            arrayList2 = arrayList;
                                                            _rVar = _rVar2;
                                                            _rVar._a = arrayList2;
                                                            if (!arrayList2.isEmpty()) {
                                                                return _a(_rVar, adSlot);
                                                            }
                                                            if (_rVar._e != 0) {
                                                                return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
                                                            }
                                                            return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                                                        }
                                                    } catch (Exception unused9) {
                                                        f = fOptDouble;
                                                        str3 = strOptString2;
                                                        str4 = str12;
                                                        i = 0;
                                                        _f0Var = null;
                                                        strOptString2 = str3;
                                                        d2 = d;
                                                        str5 = strOptString;
                                                        z = zOptBoolean;
                                                        z2 = zOptBoolean2;
                                                        z3 = zOptBoolean3;
                                                        i2 = iOptInt;
                                                        f2 = f;
                                                        i3 = i;
                                                        _f0Var2 = _f0Var;
                                                        _baVar = null;
                                                        str6 = str4;
                                                        _fiVar = null;
                                                        arrayList = new ArrayList();
                                                        jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
                                                        if (jSONArrayOptJSONArray != null) {
                                                            _f0 _f0Var10 = _f0Var2;
                                                            _fiVar2 = _fiVar;
                                                            jCurrentTimeMillis = System.currentTimeMillis();
                                                            _f0Var3 = _f0Var10;
                                                            length = jSONArrayOptJSONArray.length();
                                                            _baVar2 = _baVar;
                                                            i4 = 0;
                                                            while (i4 < length) {
                                                                int i1112 = length;
                                                                _fVar = new _f();
                                                                _fVar._w = strOptString4;
                                                                _fVar._z = jCurrentTimeMillis;
                                                                long j3 = jCurrentTimeMillis;
                                                                _fVar._B = adSlot._w();
                                                                jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                                                if (jSONObjectOptJSONObject != null) {
                                                                    _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                                                                    _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                                                                    _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                                                                    jSONObjectOptJSONObject.optString(_z._b("4"));
                                                                    _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                                                                    _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                                                                    _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                                                                    _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                                                                    jSONObjectOptJSONObject.optString(_z._b(str13));
                                                                    strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                                                                    if (strOptString3 == null) {
                                                                        str7 = str13;
                                                                    } else {
                                                                        str7 = str13;
                                                                        strDecode = URLDecoder.decode(strOptString3, "utf-8");
                                                                        _fVar._r = strDecode;
                                                                        _fVar._s = _iVar_a;
                                                                        _fVar._t = map_b;
                                                                        _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                        if (jSONObjectOptJSONObject2 != null) {
                                                                            _lVar = new _l();
                                                                            _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                            _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                            _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                            _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                        } else {
                                                                            _lVar = null;
                                                                        }
                                                                        _fVar._q = _lVar;
                                                                        _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                        jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                        arrayList3 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray2 != null) {
                                                                            while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                                arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                            }
                                                                        }
                                                                        jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                        arrayList4 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray3 != null) {
                                                                            while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                                arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                            }
                                                                        }
                                                                        _fVar._f = arrayList4;
                                                                        jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                        arrayList5 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray4 != null) {
                                                                            while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                                arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                            }
                                                                        }
                                                                        _fVar._g = arrayList5;
                                                                        jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                        arrayList6 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray5 != null) {
                                                                            while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                                arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                            }
                                                                        }
                                                                        _a(jSONObjectOptJSONObject, _fVar);
                                                                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                        map2 = new HashMap();
                                                                        if (jSONObjectOptJSONObject3 != null) {
                                                                            itKeys = jSONObjectOptJSONObject3.keys();
                                                                            while (itKeys.hasNext()) {
                                                                                String next5 = itKeys.next();
                                                                                Iterator<String> it6 = itKeys;
                                                                                jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next5);
                                                                                JSONObject jSONObject7 = jSONObjectOptJSONObject3;
                                                                                arrayList9 = new ArrayList();
                                                                                String str112 = str17;
                                                                                HashMap map7 = map_b;
                                                                                if (jSONArrayOptJSONArray8 != null) {
                                                                                    while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                                        arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                                    }
                                                                                }
                                                                                map2.put(next5, arrayList9);
                                                                                itKeys = it6;
                                                                                jSONObjectOptJSONObject3 = jSONObject7;
                                                                                str17 = str112;
                                                                                map_b = map7;
                                                                            }
                                                                        }
                                                                        str8 = str17;
                                                                        map = map_b;
                                                                        _fVar._h = map2;
                                                                        _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                        _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                        jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                        arrayList7 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray6 != null) {
                                                                            while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                                arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                            }
                                                                        }
                                                                        _fVar._H = arrayList7;
                                                                        jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                        arrayList8 = new ArrayList();
                                                                        if (jSONArrayOptJSONArray7 != null) {
                                                                            while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                                arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                            }
                                                                        }
                                                                        _fVar._I = arrayList8;
                                                                        _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                        _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                        _ba _baVar8 = _baVar2;
                                                                        _fVar._G = _baVar8;
                                                                        _f0 _f0Var11 = _f0Var3;
                                                                        _fVar._E = _f0Var11;
                                                                        _fiVar3 = _fiVar2;
                                                                        _fVar._F = _fiVar3;
                                                                        str11 = str6;
                                                                        _fVar._N = str11;
                                                                        str10 = strOptString2;
                                                                        _fVar._O = str10;
                                                                        str9 = str5;
                                                                        _fVar._W = str9;
                                                                        _baVar2 = _baVar8;
                                                                        boolean z19 = z;
                                                                        _fVar._P = z19;
                                                                        z4 = z19;
                                                                        boolean z110 = z2;
                                                                        _fVar._Q = z110;
                                                                        z5 = z110;
                                                                        boolean z111 = z3;
                                                                        _fVar._R = z111;
                                                                        z6 = z111;
                                                                        _f0Var3 = _f0Var11;
                                                                        d2 = d2;
                                                                        _fVar._S = d2;
                                                                        if (f2 >= 0.0f) {
                                                                            f3 = f2;
                                                                            _fVar._U = f3;
                                                                            int i1113 = i3;
                                                                            _fVar._V = i1113;
                                                                            i6 = i1113;
                                                                            int i1114 = i2;
                                                                            _fVar._T = i1114;
                                                                            i5 = i1114;
                                                                            _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                            if (adSlot.isSelfRender()) {
                                                                                z_c = _iVar_a._c();
                                                                            } else {
                                                                                z_c = false;
                                                                            }
                                                                            _fVar._L = z_c;
                                                                        }
                                                                        _fVar._U = 0.1f;
                                                                        f3 = f2;
                                                                        int i1115 = i3;
                                                                        _fVar._V = i1115;
                                                                        i6 = i1115;
                                                                        int i1116 = i2;
                                                                        _fVar._T = i1116;
                                                                        i5 = i1116;
                                                                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                        if (adSlot.isSelfRender()) {
                                                                            z_c = _iVar_a._c();
                                                                        } else {
                                                                            z_c = false;
                                                                        }
                                                                        _fVar._L = z_c;
                                                                    }
                                                                    strDecode = str2;
                                                                    _fVar._r = strDecode;
                                                                    _fVar._s = _iVar_a;
                                                                    _fVar._t = map_b;
                                                                    _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                    jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                    if (jSONObjectOptJSONObject2 != null) {
                                                                        _lVar = new _l();
                                                                        _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                        _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                        _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                        _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                    } else {
                                                                        _lVar = null;
                                                                    }
                                                                    _fVar._q = _lVar;
                                                                    _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                    jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                    arrayList3 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray2 != null) {
                                                                        while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                            arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                        }
                                                                    }
                                                                    jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                    arrayList4 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray3 != null) {
                                                                        while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                            arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                        }
                                                                    }
                                                                    _fVar._f = arrayList4;
                                                                    jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                    arrayList5 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray4 != null) {
                                                                        while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                            arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                        }
                                                                    }
                                                                    _fVar._g = arrayList5;
                                                                    jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                    arrayList6 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray5 != null) {
                                                                        while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                            arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                        }
                                                                    }
                                                                    _a(jSONObjectOptJSONObject, _fVar);
                                                                    jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                    map2 = new HashMap();
                                                                    if (jSONObjectOptJSONObject3 != null) {
                                                                        itKeys = jSONObjectOptJSONObject3.keys();
                                                                        while (itKeys.hasNext()) {
                                                                            String next6 = itKeys.next();
                                                                            Iterator<String> it7 = itKeys;
                                                                            jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next6);
                                                                            JSONObject jSONObject8 = jSONObjectOptJSONObject3;
                                                                            arrayList9 = new ArrayList();
                                                                            String str113 = str17;
                                                                            HashMap map8 = map_b;
                                                                            if (jSONArrayOptJSONArray8 != null) {
                                                                                while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                                    arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                                }
                                                                            }
                                                                            map2.put(next6, arrayList9);
                                                                            itKeys = it7;
                                                                            jSONObjectOptJSONObject3 = jSONObject8;
                                                                            str17 = str113;
                                                                            map_b = map8;
                                                                        }
                                                                    }
                                                                    str8 = str17;
                                                                    map = map_b;
                                                                    _fVar._h = map2;
                                                                    _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                    _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                    jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                    arrayList7 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray6 != null) {
                                                                        while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                            arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                        }
                                                                    }
                                                                    _fVar._H = arrayList7;
                                                                    jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                    arrayList8 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray7 != null) {
                                                                        while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                            arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                        }
                                                                    }
                                                                    _fVar._I = arrayList8;
                                                                    _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                    _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                    _ba _baVar9 = _baVar2;
                                                                    _fVar._G = _baVar9;
                                                                    _f0 _f0Var12 = _f0Var3;
                                                                    _fVar._E = _f0Var12;
                                                                    _fiVar3 = _fiVar2;
                                                                    _fVar._F = _fiVar3;
                                                                    str11 = str6;
                                                                    _fVar._N = str11;
                                                                    str10 = strOptString2;
                                                                    _fVar._O = str10;
                                                                    str9 = str5;
                                                                    _fVar._W = str9;
                                                                    _baVar2 = _baVar9;
                                                                    boolean z112 = z;
                                                                    _fVar._P = z112;
                                                                    z4 = z112;
                                                                    boolean z113 = z2;
                                                                    _fVar._Q = z113;
                                                                    z5 = z113;
                                                                    boolean z114 = z3;
                                                                    _fVar._R = z114;
                                                                    z6 = z114;
                                                                    _f0Var3 = _f0Var12;
                                                                    d2 = d2;
                                                                    _fVar._S = d2;
                                                                    if (f2 >= 0.0f) {
                                                                        f3 = f2;
                                                                        _fVar._U = f3;
                                                                        int i1117 = i3;
                                                                        _fVar._V = i1117;
                                                                        i6 = i1117;
                                                                        int i1118 = i2;
                                                                        _fVar._T = i1118;
                                                                        i5 = i1118;
                                                                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                        if (adSlot.isSelfRender()) {
                                                                            z_c = _iVar_a._c();
                                                                        } else {
                                                                            z_c = false;
                                                                        }
                                                                        _fVar._L = z_c;
                                                                    }
                                                                    _fVar._U = 0.1f;
                                                                    f3 = f2;
                                                                    int i1119 = i3;
                                                                    _fVar._V = i1119;
                                                                    i6 = i1119;
                                                                    int i11110 = i2;
                                                                    _fVar._T = i11110;
                                                                    i5 = i11110;
                                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                    if (adSlot.isSelfRender()) {
                                                                        z_c = _iVar_a._c();
                                                                    } else {
                                                                        z_c = false;
                                                                    }
                                                                    _fVar._L = z_c;
                                                                } else {
                                                                    str7 = str13;
                                                                    str15 = str15;
                                                                    str16 = str16;
                                                                    str8 = str17;
                                                                    map = map_b;
                                                                    f3 = f2;
                                                                    str9 = str5;
                                                                    str10 = strOptString2;
                                                                    str11 = str6;
                                                                    _fiVar3 = _fiVar2;
                                                                    z4 = z;
                                                                    z5 = z2;
                                                                    z6 = z3;
                                                                    i5 = i2;
                                                                    i6 = i3;
                                                                }
                                                                ArrayList arrayList12 = arrayList;
                                                                arrayList12.add(_fVar);
                                                                i4++;
                                                                arrayList = arrayList12;
                                                                i3 = i6;
                                                                z = z4;
                                                                z2 = z5;
                                                                z3 = z6;
                                                                i2 = i5;
                                                                length = i1112;
                                                                str13 = str7;
                                                                f2 = f3;
                                                                _fiVar2 = _fiVar3;
                                                                str6 = str11;
                                                                strOptString2 = str10;
                                                                str5 = str9;
                                                                str14 = str14;
                                                                jCurrentTimeMillis = j3;
                                                                str15 = str15;
                                                                str16 = str16;
                                                                str17 = str8;
                                                                map_b = map;
                                                            }
                                                        }
                                                        arrayList2 = arrayList;
                                                        _rVar = _rVar2;
                                                        _rVar._a = arrayList2;
                                                        if (!arrayList2.isEmpty()) {
                                                            return _a(_rVar, adSlot);
                                                        }
                                                        if (_rVar._e != 0) {
                                                            return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
                                                        }
                                                        return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                                                    }
                                                } catch (Exception unused10) {
                                                    str3 = strOptString2;
                                                    str4 = str12;
                                                    f = 0.1f;
                                                    i = 0;
                                                    _f0Var = null;
                                                    strOptString2 = str3;
                                                    d2 = d;
                                                    str5 = strOptString;
                                                    z = zOptBoolean;
                                                    z2 = zOptBoolean2;
                                                    z3 = zOptBoolean3;
                                                    i2 = iOptInt;
                                                    f2 = f;
                                                    i3 = i;
                                                    _f0Var2 = _f0Var;
                                                    _baVar = null;
                                                    str6 = str4;
                                                    _fiVar = null;
                                                    arrayList = new ArrayList();
                                                    jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
                                                    if (jSONArrayOptJSONArray != null) {
                                                        _f0 _f0Var13 = _f0Var2;
                                                        _fiVar2 = _fiVar;
                                                        jCurrentTimeMillis = System.currentTimeMillis();
                                                        _f0Var3 = _f0Var13;
                                                        length = jSONArrayOptJSONArray.length();
                                                        _baVar2 = _baVar;
                                                        i4 = 0;
                                                        while (i4 < length) {
                                                            int i11111 = length;
                                                            _fVar = new _f();
                                                            _fVar._w = strOptString4;
                                                            _fVar._z = jCurrentTimeMillis;
                                                            long j4 = jCurrentTimeMillis;
                                                            _fVar._B = adSlot._w();
                                                            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                                            if (jSONObjectOptJSONObject != null) {
                                                                _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                                                                _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                                                                _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                                                                jSONObjectOptJSONObject.optString(_z._b("4"));
                                                                _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                                                                _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                                                                _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                                                                _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                                                                jSONObjectOptJSONObject.optString(_z._b(str13));
                                                                strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                                                                if (strOptString3 == null) {
                                                                    str7 = str13;
                                                                } else {
                                                                    str7 = str13;
                                                                    strDecode = URLDecoder.decode(strOptString3, "utf-8");
                                                                    _fVar._r = strDecode;
                                                                    _fVar._s = _iVar_a;
                                                                    _fVar._t = map_b;
                                                                    _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                    jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                    if (jSONObjectOptJSONObject2 != null) {
                                                                        _lVar = new _l();
                                                                        _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                        _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                        _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                        _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                    } else {
                                                                        _lVar = null;
                                                                    }
                                                                    _fVar._q = _lVar;
                                                                    _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                    jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                    arrayList3 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray2 != null) {
                                                                        while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                            arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                        }
                                                                    }
                                                                    jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                    arrayList4 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray3 != null) {
                                                                        while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                            arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                        }
                                                                    }
                                                                    _fVar._f = arrayList4;
                                                                    jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                    arrayList5 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray4 != null) {
                                                                        while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                            arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                        }
                                                                    }
                                                                    _fVar._g = arrayList5;
                                                                    jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                    arrayList6 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray5 != null) {
                                                                        while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                            arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                        }
                                                                    }
                                                                    _a(jSONObjectOptJSONObject, _fVar);
                                                                    jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                    map2 = new HashMap();
                                                                    if (jSONObjectOptJSONObject3 != null) {
                                                                        itKeys = jSONObjectOptJSONObject3.keys();
                                                                        while (itKeys.hasNext()) {
                                                                            String next7 = itKeys.next();
                                                                            Iterator<String> it8 = itKeys;
                                                                            jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next7);
                                                                            JSONObject jSONObject9 = jSONObjectOptJSONObject3;
                                                                            arrayList9 = new ArrayList();
                                                                            String str114 = str17;
                                                                            HashMap map9 = map_b;
                                                                            if (jSONArrayOptJSONArray8 != null) {
                                                                                while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                                    arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                                }
                                                                            }
                                                                            map2.put(next7, arrayList9);
                                                                            itKeys = it8;
                                                                            jSONObjectOptJSONObject3 = jSONObject9;
                                                                            str17 = str114;
                                                                            map_b = map9;
                                                                        }
                                                                    }
                                                                    str8 = str17;
                                                                    map = map_b;
                                                                    _fVar._h = map2;
                                                                    _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                    _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                    jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                    arrayList7 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray6 != null) {
                                                                        while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                            arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                        }
                                                                    }
                                                                    _fVar._H = arrayList7;
                                                                    jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                    arrayList8 = new ArrayList();
                                                                    if (jSONArrayOptJSONArray7 != null) {
                                                                        while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                            arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                        }
                                                                    }
                                                                    _fVar._I = arrayList8;
                                                                    _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                    _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                    _ba _baVar10 = _baVar2;
                                                                    _fVar._G = _baVar10;
                                                                    _f0 _f0Var14 = _f0Var3;
                                                                    _fVar._E = _f0Var14;
                                                                    _fiVar3 = _fiVar2;
                                                                    _fVar._F = _fiVar3;
                                                                    str11 = str6;
                                                                    _fVar._N = str11;
                                                                    str10 = strOptString2;
                                                                    _fVar._O = str10;
                                                                    str9 = str5;
                                                                    _fVar._W = str9;
                                                                    _baVar2 = _baVar10;
                                                                    boolean z115 = z;
                                                                    _fVar._P = z115;
                                                                    z4 = z115;
                                                                    boolean z116 = z2;
                                                                    _fVar._Q = z116;
                                                                    z5 = z116;
                                                                    boolean z117 = z3;
                                                                    _fVar._R = z117;
                                                                    z6 = z117;
                                                                    _f0Var3 = _f0Var14;
                                                                    d2 = d2;
                                                                    _fVar._S = d2;
                                                                    if (f2 >= 0.0f) {
                                                                        f3 = f2;
                                                                        _fVar._U = f3;
                                                                        int i11112 = i3;
                                                                        _fVar._V = i11112;
                                                                        i6 = i11112;
                                                                        int i11113 = i2;
                                                                        _fVar._T = i11113;
                                                                        i5 = i11113;
                                                                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                        if (adSlot.isSelfRender()) {
                                                                            z_c = _iVar_a._c();
                                                                        } else {
                                                                            z_c = false;
                                                                        }
                                                                        _fVar._L = z_c;
                                                                    }
                                                                    _fVar._U = 0.1f;
                                                                    f3 = f2;
                                                                    int i11114 = i3;
                                                                    _fVar._V = i11114;
                                                                    i6 = i11114;
                                                                    int i11115 = i2;
                                                                    _fVar._T = i11115;
                                                                    i5 = i11115;
                                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                    if (adSlot.isSelfRender()) {
                                                                        z_c = _iVar_a._c();
                                                                    } else {
                                                                        z_c = false;
                                                                    }
                                                                    _fVar._L = z_c;
                                                                }
                                                                strDecode = str2;
                                                                _fVar._r = strDecode;
                                                                _fVar._s = _iVar_a;
                                                                _fVar._t = map_b;
                                                                _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                if (jSONObjectOptJSONObject2 != null) {
                                                                    _lVar = new _l();
                                                                    _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                    _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                    _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                    _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                } else {
                                                                    _lVar = null;
                                                                }
                                                                _fVar._q = _lVar;
                                                                _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                arrayList3 = new ArrayList();
                                                                if (jSONArrayOptJSONArray2 != null) {
                                                                    while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                        arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                    }
                                                                }
                                                                jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                arrayList4 = new ArrayList();
                                                                if (jSONArrayOptJSONArray3 != null) {
                                                                    while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                        arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                    }
                                                                }
                                                                _fVar._f = arrayList4;
                                                                jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                arrayList5 = new ArrayList();
                                                                if (jSONArrayOptJSONArray4 != null) {
                                                                    while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                        arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                    }
                                                                }
                                                                _fVar._g = arrayList5;
                                                                jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                arrayList6 = new ArrayList();
                                                                if (jSONArrayOptJSONArray5 != null) {
                                                                    while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                        arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                    }
                                                                }
                                                                _a(jSONObjectOptJSONObject, _fVar);
                                                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                map2 = new HashMap();
                                                                if (jSONObjectOptJSONObject3 != null) {
                                                                    itKeys = jSONObjectOptJSONObject3.keys();
                                                                    while (itKeys.hasNext()) {
                                                                        String next8 = itKeys.next();
                                                                        Iterator<String> it9 = itKeys;
                                                                        jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next8);
                                                                        JSONObject jSONObject10 = jSONObjectOptJSONObject3;
                                                                        arrayList9 = new ArrayList();
                                                                        String str115 = str17;
                                                                        HashMap map10 = map_b;
                                                                        if (jSONArrayOptJSONArray8 != null) {
                                                                            while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                                arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                            }
                                                                        }
                                                                        map2.put(next8, arrayList9);
                                                                        itKeys = it9;
                                                                        jSONObjectOptJSONObject3 = jSONObject10;
                                                                        str17 = str115;
                                                                        map_b = map10;
                                                                    }
                                                                }
                                                                str8 = str17;
                                                                map = map_b;
                                                                _fVar._h = map2;
                                                                _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                arrayList7 = new ArrayList();
                                                                if (jSONArrayOptJSONArray6 != null) {
                                                                    while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                        arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                    }
                                                                }
                                                                _fVar._H = arrayList7;
                                                                jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                arrayList8 = new ArrayList();
                                                                if (jSONArrayOptJSONArray7 != null) {
                                                                    while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                        arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                    }
                                                                }
                                                                _fVar._I = arrayList8;
                                                                _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                _ba _baVar11 = _baVar2;
                                                                _fVar._G = _baVar11;
                                                                _f0 _f0Var15 = _f0Var3;
                                                                _fVar._E = _f0Var15;
                                                                _fiVar3 = _fiVar2;
                                                                _fVar._F = _fiVar3;
                                                                str11 = str6;
                                                                _fVar._N = str11;
                                                                str10 = strOptString2;
                                                                _fVar._O = str10;
                                                                str9 = str5;
                                                                _fVar._W = str9;
                                                                _baVar2 = _baVar11;
                                                                boolean z118 = z;
                                                                _fVar._P = z118;
                                                                z4 = z118;
                                                                boolean z119 = z2;
                                                                _fVar._Q = z119;
                                                                z5 = z119;
                                                                boolean z1110 = z3;
                                                                _fVar._R = z1110;
                                                                z6 = z1110;
                                                                _f0Var3 = _f0Var15;
                                                                d2 = d2;
                                                                _fVar._S = d2;
                                                                if (f2 >= 0.0f) {
                                                                    f3 = f2;
                                                                    _fVar._U = f3;
                                                                    int i11116 = i3;
                                                                    _fVar._V = i11116;
                                                                    i6 = i11116;
                                                                    int i11117 = i2;
                                                                    _fVar._T = i11117;
                                                                    i5 = i11117;
                                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                    if (adSlot.isSelfRender()) {
                                                                        z_c = _iVar_a._c();
                                                                    } else {
                                                                        z_c = false;
                                                                    }
                                                                    _fVar._L = z_c;
                                                                }
                                                                _fVar._U = 0.1f;
                                                                f3 = f2;
                                                                int i11118 = i3;
                                                                _fVar._V = i11118;
                                                                i6 = i11118;
                                                                int i11119 = i2;
                                                                _fVar._T = i11119;
                                                                i5 = i11119;
                                                                _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                if (adSlot.isSelfRender()) {
                                                                    z_c = _iVar_a._c();
                                                                } else {
                                                                    z_c = false;
                                                                }
                                                                _fVar._L = z_c;
                                                            } else {
                                                                str7 = str13;
                                                                str15 = str15;
                                                                str16 = str16;
                                                                str8 = str17;
                                                                map = map_b;
                                                                f3 = f2;
                                                                str9 = str5;
                                                                str10 = strOptString2;
                                                                str11 = str6;
                                                                _fiVar3 = _fiVar2;
                                                                z4 = z;
                                                                z5 = z2;
                                                                z6 = z3;
                                                                i5 = i2;
                                                                i6 = i3;
                                                            }
                                                            ArrayList arrayList13 = arrayList;
                                                            arrayList13.add(_fVar);
                                                            i4++;
                                                            arrayList = arrayList13;
                                                            i3 = i6;
                                                            z = z4;
                                                            z2 = z5;
                                                            z3 = z6;
                                                            i2 = i5;
                                                            length = i11111;
                                                            str13 = str7;
                                                            f2 = f3;
                                                            _fiVar2 = _fiVar3;
                                                            str6 = str11;
                                                            strOptString2 = str10;
                                                            str5 = str9;
                                                            str14 = str14;
                                                            jCurrentTimeMillis = j4;
                                                            str15 = str15;
                                                            str16 = str16;
                                                            str17 = str8;
                                                            map_b = map;
                                                        }
                                                    }
                                                    arrayList2 = arrayList;
                                                    _rVar = _rVar2;
                                                    _rVar._a = arrayList2;
                                                    if (!arrayList2.isEmpty()) {
                                                        return _a(_rVar, adSlot);
                                                    }
                                                    if (_rVar._e != 0) {
                                                        return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
                                                    }
                                                    return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                                                }
                                            } catch (Exception unused11) {
                                                str3 = strOptString2;
                                                str4 = str12;
                                                iOptInt = 0;
                                                f = 0.1f;
                                                i = 0;
                                                _f0Var = null;
                                                strOptString2 = str3;
                                                d2 = d;
                                                str5 = strOptString;
                                                z = zOptBoolean;
                                                z2 = zOptBoolean2;
                                                z3 = zOptBoolean3;
                                                i2 = iOptInt;
                                                f2 = f;
                                                i3 = i;
                                                _f0Var2 = _f0Var;
                                                _baVar = null;
                                                str6 = str4;
                                                _fiVar = null;
                                                arrayList = new ArrayList();
                                                jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
                                                if (jSONArrayOptJSONArray != null) {
                                                    _f0 _f0Var16 = _f0Var2;
                                                    _fiVar2 = _fiVar;
                                                    jCurrentTimeMillis = System.currentTimeMillis();
                                                    _f0Var3 = _f0Var16;
                                                    length = jSONArrayOptJSONArray.length();
                                                    _baVar2 = _baVar;
                                                    i4 = 0;
                                                    while (i4 < length) {
                                                        int i111110 = length;
                                                        _fVar = new _f();
                                                        _fVar._w = strOptString4;
                                                        _fVar._z = jCurrentTimeMillis;
                                                        long j5 = jCurrentTimeMillis;
                                                        _fVar._B = adSlot._w();
                                                        jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                                        if (jSONObjectOptJSONObject != null) {
                                                            _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                                                            _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                                                            _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                                                            jSONObjectOptJSONObject.optString(_z._b("4"));
                                                            _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                                                            _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                                                            _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                                                            _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                                                            jSONObjectOptJSONObject.optString(_z._b(str13));
                                                            strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                                                            if (strOptString3 == null) {
                                                                str7 = str13;
                                                            } else {
                                                                str7 = str13;
                                                                strDecode = URLDecoder.decode(strOptString3, "utf-8");
                                                                _fVar._r = strDecode;
                                                                _fVar._s = _iVar_a;
                                                                _fVar._t = map_b;
                                                                _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                                jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                                if (jSONObjectOptJSONObject2 != null) {
                                                                    _lVar = new _l();
                                                                    _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                    _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                    _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                    _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                                } else {
                                                                    _lVar = null;
                                                                }
                                                                _fVar._q = _lVar;
                                                                _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                                arrayList3 = new ArrayList();
                                                                if (jSONArrayOptJSONArray2 != null) {
                                                                    while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                        arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                    }
                                                                }
                                                                jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                                arrayList4 = new ArrayList();
                                                                if (jSONArrayOptJSONArray3 != null) {
                                                                    while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                        arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                    }
                                                                }
                                                                _fVar._f = arrayList4;
                                                                jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                                arrayList5 = new ArrayList();
                                                                if (jSONArrayOptJSONArray4 != null) {
                                                                    while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                        arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                    }
                                                                }
                                                                _fVar._g = arrayList5;
                                                                jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                                arrayList6 = new ArrayList();
                                                                if (jSONArrayOptJSONArray5 != null) {
                                                                    while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                        arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                    }
                                                                }
                                                                _a(jSONObjectOptJSONObject, _fVar);
                                                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                                map2 = new HashMap();
                                                                if (jSONObjectOptJSONObject3 != null) {
                                                                    itKeys = jSONObjectOptJSONObject3.keys();
                                                                    while (itKeys.hasNext()) {
                                                                        String next9 = itKeys.next();
                                                                        Iterator<String> it10 = itKeys;
                                                                        jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next9);
                                                                        JSONObject jSONObject11 = jSONObjectOptJSONObject3;
                                                                        arrayList9 = new ArrayList();
                                                                        String str116 = str17;
                                                                        HashMap map11 = map_b;
                                                                        if (jSONArrayOptJSONArray8 != null) {
                                                                            while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                                arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                            }
                                                                        }
                                                                        map2.put(next9, arrayList9);
                                                                        itKeys = it10;
                                                                        jSONObjectOptJSONObject3 = jSONObject11;
                                                                        str17 = str116;
                                                                        map_b = map11;
                                                                    }
                                                                }
                                                                str8 = str17;
                                                                map = map_b;
                                                                _fVar._h = map2;
                                                                _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                                _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                                jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                                arrayList7 = new ArrayList();
                                                                if (jSONArrayOptJSONArray6 != null) {
                                                                    while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                        arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                    }
                                                                }
                                                                _fVar._H = arrayList7;
                                                                jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                                arrayList8 = new ArrayList();
                                                                if (jSONArrayOptJSONArray7 != null) {
                                                                    while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                        arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                    }
                                                                }
                                                                _fVar._I = arrayList8;
                                                                _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                                _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                                _ba _baVar12 = _baVar2;
                                                                _fVar._G = _baVar12;
                                                                _f0 _f0Var17 = _f0Var3;
                                                                _fVar._E = _f0Var17;
                                                                _fiVar3 = _fiVar2;
                                                                _fVar._F = _fiVar3;
                                                                str11 = str6;
                                                                _fVar._N = str11;
                                                                str10 = strOptString2;
                                                                _fVar._O = str10;
                                                                str9 = str5;
                                                                _fVar._W = str9;
                                                                _baVar2 = _baVar12;
                                                                boolean z1111 = z;
                                                                _fVar._P = z1111;
                                                                z4 = z1111;
                                                                boolean z1112 = z2;
                                                                _fVar._Q = z1112;
                                                                z5 = z1112;
                                                                boolean z1113 = z3;
                                                                _fVar._R = z1113;
                                                                z6 = z1113;
                                                                _f0Var3 = _f0Var17;
                                                                d2 = d2;
                                                                _fVar._S = d2;
                                                                if (f2 >= 0.0f) {
                                                                    f3 = f2;
                                                                    _fVar._U = f3;
                                                                    int i111111 = i3;
                                                                    _fVar._V = i111111;
                                                                    i6 = i111111;
                                                                    int i111112 = i2;
                                                                    _fVar._T = i111112;
                                                                    i5 = i111112;
                                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                    if (adSlot.isSelfRender()) {
                                                                        z_c = _iVar_a._c();
                                                                    } else {
                                                                        z_c = false;
                                                                    }
                                                                    _fVar._L = z_c;
                                                                }
                                                                _fVar._U = 0.1f;
                                                                f3 = f2;
                                                                int i111113 = i3;
                                                                _fVar._V = i111113;
                                                                i6 = i111113;
                                                                int i111114 = i2;
                                                                _fVar._T = i111114;
                                                                i5 = i111114;
                                                                _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                if (adSlot.isSelfRender()) {
                                                                    z_c = _iVar_a._c();
                                                                } else {
                                                                    z_c = false;
                                                                }
                                                                _fVar._L = z_c;
                                                            }
                                                            strDecode = str2;
                                                            _fVar._r = strDecode;
                                                            _fVar._s = _iVar_a;
                                                            _fVar._t = map_b;
                                                            _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                            jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                            if (jSONObjectOptJSONObject2 != null) {
                                                                _lVar = new _l();
                                                                _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                                _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                                _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                                _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                            } else {
                                                                _lVar = null;
                                                            }
                                                            _fVar._q = _lVar;
                                                            _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                            arrayList3 = new ArrayList();
                                                            if (jSONArrayOptJSONArray2 != null) {
                                                                while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                    arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                                }
                                                            }
                                                            jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                            arrayList4 = new ArrayList();
                                                            if (jSONArrayOptJSONArray3 != null) {
                                                                while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                    arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                                }
                                                            }
                                                            _fVar._f = arrayList4;
                                                            jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                            arrayList5 = new ArrayList();
                                                            if (jSONArrayOptJSONArray4 != null) {
                                                                while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                    arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                                }
                                                            }
                                                            _fVar._g = arrayList5;
                                                            jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                            arrayList6 = new ArrayList();
                                                            if (jSONArrayOptJSONArray5 != null) {
                                                                while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                    arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                                }
                                                            }
                                                            _a(jSONObjectOptJSONObject, _fVar);
                                                            jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                            map2 = new HashMap();
                                                            if (jSONObjectOptJSONObject3 != null) {
                                                                itKeys = jSONObjectOptJSONObject3.keys();
                                                                while (itKeys.hasNext()) {
                                                                    String next10 = itKeys.next();
                                                                    Iterator<String> it11 = itKeys;
                                                                    jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next10);
                                                                    JSONObject jSONObject12 = jSONObjectOptJSONObject3;
                                                                    arrayList9 = new ArrayList();
                                                                    String str117 = str17;
                                                                    HashMap map12 = map_b;
                                                                    if (jSONArrayOptJSONArray8 != null) {
                                                                        while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                            arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                        }
                                                                    }
                                                                    map2.put(next10, arrayList9);
                                                                    itKeys = it11;
                                                                    jSONObjectOptJSONObject3 = jSONObject12;
                                                                    str17 = str117;
                                                                    map_b = map12;
                                                                }
                                                            }
                                                            str8 = str17;
                                                            map = map_b;
                                                            _fVar._h = map2;
                                                            _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                            _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                            jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                            arrayList7 = new ArrayList();
                                                            if (jSONArrayOptJSONArray6 != null) {
                                                                while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                    arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                                }
                                                            }
                                                            _fVar._H = arrayList7;
                                                            jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                            arrayList8 = new ArrayList();
                                                            if (jSONArrayOptJSONArray7 != null) {
                                                                while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                    arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                                }
                                                            }
                                                            _fVar._I = arrayList8;
                                                            _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                            _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                            _ba _baVar13 = _baVar2;
                                                            _fVar._G = _baVar13;
                                                            _f0 _f0Var18 = _f0Var3;
                                                            _fVar._E = _f0Var18;
                                                            _fiVar3 = _fiVar2;
                                                            _fVar._F = _fiVar3;
                                                            str11 = str6;
                                                            _fVar._N = str11;
                                                            str10 = strOptString2;
                                                            _fVar._O = str10;
                                                            str9 = str5;
                                                            _fVar._W = str9;
                                                            _baVar2 = _baVar13;
                                                            boolean z1114 = z;
                                                            _fVar._P = z1114;
                                                            z4 = z1114;
                                                            boolean z1115 = z2;
                                                            _fVar._Q = z1115;
                                                            z5 = z1115;
                                                            boolean z1116 = z3;
                                                            _fVar._R = z1116;
                                                            z6 = z1116;
                                                            _f0Var3 = _f0Var18;
                                                            d2 = d2;
                                                            _fVar._S = d2;
                                                            if (f2 >= 0.0f) {
                                                                f3 = f2;
                                                                _fVar._U = f3;
                                                                int i111115 = i3;
                                                                _fVar._V = i111115;
                                                                i6 = i111115;
                                                                int i111116 = i2;
                                                                _fVar._T = i111116;
                                                                i5 = i111116;
                                                                _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                                if (adSlot.isSelfRender()) {
                                                                    z_c = _iVar_a._c();
                                                                } else {
                                                                    z_c = false;
                                                                }
                                                                _fVar._L = z_c;
                                                            }
                                                            _fVar._U = 0.1f;
                                                            f3 = f2;
                                                            int i111117 = i3;
                                                            _fVar._V = i111117;
                                                            i6 = i111117;
                                                            int i111118 = i2;
                                                            _fVar._T = i111118;
                                                            i5 = i111118;
                                                            _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                            if (adSlot.isSelfRender()) {
                                                                z_c = _iVar_a._c();
                                                            } else {
                                                                z_c = false;
                                                            }
                                                            _fVar._L = z_c;
                                                        } else {
                                                            str7 = str13;
                                                            str15 = str15;
                                                            str16 = str16;
                                                            str8 = str17;
                                                            map = map_b;
                                                            f3 = f2;
                                                            str9 = str5;
                                                            str10 = strOptString2;
                                                            str11 = str6;
                                                            _fiVar3 = _fiVar2;
                                                            z4 = z;
                                                            z5 = z2;
                                                            z6 = z3;
                                                            i5 = i2;
                                                            i6 = i3;
                                                        }
                                                        ArrayList arrayList14 = arrayList;
                                                        arrayList14.add(_fVar);
                                                        i4++;
                                                        arrayList = arrayList14;
                                                        i3 = i6;
                                                        z = z4;
                                                        z2 = z5;
                                                        z3 = z6;
                                                        i2 = i5;
                                                        length = i111110;
                                                        str13 = str7;
                                                        f2 = f3;
                                                        _fiVar2 = _fiVar3;
                                                        str6 = str11;
                                                        strOptString2 = str10;
                                                        str5 = str9;
                                                        str14 = str14;
                                                        jCurrentTimeMillis = j5;
                                                        str15 = str15;
                                                        str16 = str16;
                                                        str17 = str8;
                                                        map_b = map;
                                                    }
                                                }
                                                arrayList2 = arrayList;
                                                _rVar = _rVar2;
                                                _rVar._a = arrayList2;
                                                if (!arrayList2.isEmpty()) {
                                                    return _a(_rVar, adSlot);
                                                }
                                                if (_rVar._e != 0) {
                                                    return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
                                                }
                                                return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                                            }
                                        } catch (Exception unused12) {
                                            d = dOptDouble;
                                        }
                                    } catch (Exception unused13) {
                                        _rVar2 = _rVar2;
                                        d = 0.3d;
                                        str3 = strOptString2;
                                        str4 = str12;
                                        zOptBoolean3 = false;
                                        iOptInt = 0;
                                        f = 0.1f;
                                        i = 0;
                                        _f0Var = null;
                                        strOptString2 = str3;
                                        d2 = d;
                                        str5 = strOptString;
                                        z = zOptBoolean;
                                        z2 = zOptBoolean2;
                                        z3 = zOptBoolean3;
                                        i2 = iOptInt;
                                        f2 = f;
                                        i3 = i;
                                        _f0Var2 = _f0Var;
                                        _baVar = null;
                                        str6 = str4;
                                        _fiVar = null;
                                        arrayList = new ArrayList();
                                        jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
                                        if (jSONArrayOptJSONArray != null) {
                                            _f0 _f0Var19 = _f0Var2;
                                            _fiVar2 = _fiVar;
                                            jCurrentTimeMillis = System.currentTimeMillis();
                                            _f0Var3 = _f0Var19;
                                            length = jSONArrayOptJSONArray.length();
                                            _baVar2 = _baVar;
                                            i4 = 0;
                                            while (i4 < length) {
                                                int i111119 = length;
                                                _fVar = new _f();
                                                _fVar._w = strOptString4;
                                                _fVar._z = jCurrentTimeMillis;
                                                long j6 = jCurrentTimeMillis;
                                                _fVar._B = adSlot._w();
                                                jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                                if (jSONObjectOptJSONObject != null) {
                                                    _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                                                    _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                                                    _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                                                    jSONObjectOptJSONObject.optString(_z._b("4"));
                                                    _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                                                    _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                                                    _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                                                    _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                                                    jSONObjectOptJSONObject.optString(_z._b(str13));
                                                    strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                                                    if (strOptString3 == null) {
                                                        str7 = str13;
                                                    } else {
                                                        str7 = str13;
                                                        strDecode = URLDecoder.decode(strOptString3, "utf-8");
                                                        _fVar._r = strDecode;
                                                        _fVar._s = _iVar_a;
                                                        _fVar._t = map_b;
                                                        _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                        if (jSONObjectOptJSONObject2 != null) {
                                                            _lVar = new _l();
                                                            _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                            _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                            _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                            _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                        } else {
                                                            _lVar = null;
                                                        }
                                                        _fVar._q = _lVar;
                                                        _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                        jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                        arrayList3 = new ArrayList();
                                                        if (jSONArrayOptJSONArray2 != null) {
                                                            while (i13 < jSONArrayOptJSONArray2.length()) {
                                                                arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                            }
                                                        }
                                                        jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                        arrayList4 = new ArrayList();
                                                        if (jSONArrayOptJSONArray3 != null) {
                                                            while (i12 < jSONArrayOptJSONArray3.length()) {
                                                                arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                            }
                                                        }
                                                        _fVar._f = arrayList4;
                                                        jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                        arrayList5 = new ArrayList();
                                                        if (jSONArrayOptJSONArray4 != null) {
                                                            while (i11 < jSONArrayOptJSONArray4.length()) {
                                                                arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                            }
                                                        }
                                                        _fVar._g = arrayList5;
                                                        jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                        arrayList6 = new ArrayList();
                                                        if (jSONArrayOptJSONArray5 != null) {
                                                            while (i10 < jSONArrayOptJSONArray5.length()) {
                                                                arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                            }
                                                        }
                                                        _a(jSONObjectOptJSONObject, _fVar);
                                                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                        map2 = new HashMap();
                                                        if (jSONObjectOptJSONObject3 != null) {
                                                            itKeys = jSONObjectOptJSONObject3.keys();
                                                            while (itKeys.hasNext()) {
                                                                String next11 = itKeys.next();
                                                                Iterator<String> it12 = itKeys;
                                                                jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next11);
                                                                JSONObject jSONObject13 = jSONObjectOptJSONObject3;
                                                                arrayList9 = new ArrayList();
                                                                String str118 = str17;
                                                                HashMap map13 = map_b;
                                                                if (jSONArrayOptJSONArray8 != null) {
                                                                    while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                        arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                    }
                                                                }
                                                                map2.put(next11, arrayList9);
                                                                itKeys = it12;
                                                                jSONObjectOptJSONObject3 = jSONObject13;
                                                                str17 = str118;
                                                                map_b = map13;
                                                            }
                                                        }
                                                        str8 = str17;
                                                        map = map_b;
                                                        _fVar._h = map2;
                                                        _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                        _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                        jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                        arrayList7 = new ArrayList();
                                                        if (jSONArrayOptJSONArray6 != null) {
                                                            while (i8 < jSONArrayOptJSONArray6.length()) {
                                                                arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                            }
                                                        }
                                                        _fVar._H = arrayList7;
                                                        jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                        arrayList8 = new ArrayList();
                                                        if (jSONArrayOptJSONArray7 != null) {
                                                            while (i7 < jSONArrayOptJSONArray7.length()) {
                                                                arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                            }
                                                        }
                                                        _fVar._I = arrayList8;
                                                        _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                        _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                        _ba _baVar14 = _baVar2;
                                                        _fVar._G = _baVar14;
                                                        _f0 _f0Var110 = _f0Var3;
                                                        _fVar._E = _f0Var110;
                                                        _fiVar3 = _fiVar2;
                                                        _fVar._F = _fiVar3;
                                                        str11 = str6;
                                                        _fVar._N = str11;
                                                        str10 = strOptString2;
                                                        _fVar._O = str10;
                                                        str9 = str5;
                                                        _fVar._W = str9;
                                                        _baVar2 = _baVar14;
                                                        boolean z1117 = z;
                                                        _fVar._P = z1117;
                                                        z4 = z1117;
                                                        boolean z1118 = z2;
                                                        _fVar._Q = z1118;
                                                        z5 = z1118;
                                                        boolean z1119 = z3;
                                                        _fVar._R = z1119;
                                                        z6 = z1119;
                                                        _f0Var3 = _f0Var110;
                                                        d2 = d2;
                                                        _fVar._S = d2;
                                                        if (f2 >= 0.0f) {
                                                            f3 = f2;
                                                            _fVar._U = f3;
                                                            int i1111110 = i3;
                                                            _fVar._V = i1111110;
                                                            i6 = i1111110;
                                                            int i1111111 = i2;
                                                            _fVar._T = i1111111;
                                                            i5 = i1111111;
                                                            _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                            if (adSlot.isSelfRender()) {
                                                                z_c = _iVar_a._c();
                                                            } else {
                                                                z_c = false;
                                                            }
                                                            _fVar._L = z_c;
                                                        }
                                                        _fVar._U = 0.1f;
                                                        f3 = f2;
                                                        int i1111112 = i3;
                                                        _fVar._V = i1111112;
                                                        i6 = i1111112;
                                                        int i1111113 = i2;
                                                        _fVar._T = i1111113;
                                                        i5 = i1111113;
                                                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                        if (adSlot.isSelfRender()) {
                                                            z_c = _iVar_a._c();
                                                        } else {
                                                            z_c = false;
                                                        }
                                                        _fVar._L = z_c;
                                                    }
                                                    strDecode = str2;
                                                    _fVar._r = strDecode;
                                                    _fVar._s = _iVar_a;
                                                    _fVar._t = map_b;
                                                    _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                    jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                    if (jSONObjectOptJSONObject2 != null) {
                                                        _lVar = new _l();
                                                        _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                        _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                        _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                        _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                    } else {
                                                        _lVar = null;
                                                    }
                                                    _fVar._q = _lVar;
                                                    _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                    jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                    arrayList3 = new ArrayList();
                                                    if (jSONArrayOptJSONArray2 != null) {
                                                        while (i13 < jSONArrayOptJSONArray2.length()) {
                                                            arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                        }
                                                    }
                                                    jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                    arrayList4 = new ArrayList();
                                                    if (jSONArrayOptJSONArray3 != null) {
                                                        while (i12 < jSONArrayOptJSONArray3.length()) {
                                                            arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                        }
                                                    }
                                                    _fVar._f = arrayList4;
                                                    jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                    arrayList5 = new ArrayList();
                                                    if (jSONArrayOptJSONArray4 != null) {
                                                        while (i11 < jSONArrayOptJSONArray4.length()) {
                                                            arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                        }
                                                    }
                                                    _fVar._g = arrayList5;
                                                    jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                    arrayList6 = new ArrayList();
                                                    if (jSONArrayOptJSONArray5 != null) {
                                                        while (i10 < jSONArrayOptJSONArray5.length()) {
                                                            arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                        }
                                                    }
                                                    _a(jSONObjectOptJSONObject, _fVar);
                                                    jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                    map2 = new HashMap();
                                                    if (jSONObjectOptJSONObject3 != null) {
                                                        itKeys = jSONObjectOptJSONObject3.keys();
                                                        while (itKeys.hasNext()) {
                                                            String next12 = itKeys.next();
                                                            Iterator<String> it13 = itKeys;
                                                            jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next12);
                                                            JSONObject jSONObject14 = jSONObjectOptJSONObject3;
                                                            arrayList9 = new ArrayList();
                                                            String str119 = str17;
                                                            HashMap map14 = map_b;
                                                            if (jSONArrayOptJSONArray8 != null) {
                                                                while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                    arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                }
                                                            }
                                                            map2.put(next12, arrayList9);
                                                            itKeys = it13;
                                                            jSONObjectOptJSONObject3 = jSONObject14;
                                                            str17 = str119;
                                                            map_b = map14;
                                                        }
                                                    }
                                                    str8 = str17;
                                                    map = map_b;
                                                    _fVar._h = map2;
                                                    _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                    _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                    jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                    arrayList7 = new ArrayList();
                                                    if (jSONArrayOptJSONArray6 != null) {
                                                        while (i8 < jSONArrayOptJSONArray6.length()) {
                                                            arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                        }
                                                    }
                                                    _fVar._H = arrayList7;
                                                    jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                    arrayList8 = new ArrayList();
                                                    if (jSONArrayOptJSONArray7 != null) {
                                                        while (i7 < jSONArrayOptJSONArray7.length()) {
                                                            arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                        }
                                                    }
                                                    _fVar._I = arrayList8;
                                                    _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                    _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                    _ba _baVar15 = _baVar2;
                                                    _fVar._G = _baVar15;
                                                    _f0 _f0Var111 = _f0Var3;
                                                    _fVar._E = _f0Var111;
                                                    _fiVar3 = _fiVar2;
                                                    _fVar._F = _fiVar3;
                                                    str11 = str6;
                                                    _fVar._N = str11;
                                                    str10 = strOptString2;
                                                    _fVar._O = str10;
                                                    str9 = str5;
                                                    _fVar._W = str9;
                                                    _baVar2 = _baVar15;
                                                    boolean z11110 = z;
                                                    _fVar._P = z11110;
                                                    z4 = z11110;
                                                    boolean z11111 = z2;
                                                    _fVar._Q = z11111;
                                                    z5 = z11111;
                                                    boolean z11112 = z3;
                                                    _fVar._R = z11112;
                                                    z6 = z11112;
                                                    _f0Var3 = _f0Var111;
                                                    d2 = d2;
                                                    _fVar._S = d2;
                                                    if (f2 >= 0.0f) {
                                                        f3 = f2;
                                                        _fVar._U = f3;
                                                        int i1111114 = i3;
                                                        _fVar._V = i1111114;
                                                        i6 = i1111114;
                                                        int i1111115 = i2;
                                                        _fVar._T = i1111115;
                                                        i5 = i1111115;
                                                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                        if (adSlot.isSelfRender()) {
                                                            z_c = _iVar_a._c();
                                                        } else {
                                                            z_c = false;
                                                        }
                                                        _fVar._L = z_c;
                                                    }
                                                    _fVar._U = 0.1f;
                                                    f3 = f2;
                                                    int i1111116 = i3;
                                                    _fVar._V = i1111116;
                                                    i6 = i1111116;
                                                    int i1111117 = i2;
                                                    _fVar._T = i1111117;
                                                    i5 = i1111117;
                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                    if (adSlot.isSelfRender()) {
                                                        z_c = _iVar_a._c();
                                                    } else {
                                                        z_c = false;
                                                    }
                                                    _fVar._L = z_c;
                                                } else {
                                                    str7 = str13;
                                                    str15 = str15;
                                                    str16 = str16;
                                                    str8 = str17;
                                                    map = map_b;
                                                    f3 = f2;
                                                    str9 = str5;
                                                    str10 = strOptString2;
                                                    str11 = str6;
                                                    _fiVar3 = _fiVar2;
                                                    z4 = z;
                                                    z5 = z2;
                                                    z6 = z3;
                                                    i5 = i2;
                                                    i6 = i3;
                                                }
                                                ArrayList arrayList15 = arrayList;
                                                arrayList15.add(_fVar);
                                                i4++;
                                                arrayList = arrayList15;
                                                i3 = i6;
                                                z = z4;
                                                z2 = z5;
                                                z3 = z6;
                                                i2 = i5;
                                                length = i111119;
                                                str13 = str7;
                                                f2 = f3;
                                                _fiVar2 = _fiVar3;
                                                str6 = str11;
                                                strOptString2 = str10;
                                                str5 = str9;
                                                str14 = str14;
                                                jCurrentTimeMillis = j6;
                                                str15 = str15;
                                                str16 = str16;
                                                str17 = str8;
                                                map_b = map;
                                            }
                                        }
                                        arrayList2 = arrayList;
                                        _rVar = _rVar2;
                                        _rVar._a = arrayList2;
                                        if (!arrayList2.isEmpty()) {
                                            return _a(_rVar, adSlot);
                                        }
                                        if (_rVar._e != 0) {
                                            return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
                                        }
                                        return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                                    }
                                } catch (Exception unused14) {
                                    _rVar2 = _rVar2;
                                    d = 0.3d;
                                    str3 = strOptString2;
                                    str4 = str12;
                                    zOptBoolean2 = false;
                                    zOptBoolean3 = false;
                                    iOptInt = 0;
                                    f = 0.1f;
                                    i = 0;
                                    _f0Var = null;
                                    strOptString2 = str3;
                                    d2 = d;
                                    str5 = strOptString;
                                    z = zOptBoolean;
                                    z2 = zOptBoolean2;
                                    z3 = zOptBoolean3;
                                    i2 = iOptInt;
                                    f2 = f;
                                    i3 = i;
                                    _f0Var2 = _f0Var;
                                    _baVar = null;
                                    str6 = str4;
                                    _fiVar = null;
                                    arrayList = new ArrayList();
                                    jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
                                    if (jSONArrayOptJSONArray != null) {
                                        _f0 _f0Var112 = _f0Var2;
                                        _fiVar2 = _fiVar;
                                        jCurrentTimeMillis = System.currentTimeMillis();
                                        _f0Var3 = _f0Var112;
                                        length = jSONArrayOptJSONArray.length();
                                        _baVar2 = _baVar;
                                        i4 = 0;
                                        while (i4 < length) {
                                            int i1111118 = length;
                                            _fVar = new _f();
                                            _fVar._w = strOptString4;
                                            _fVar._z = jCurrentTimeMillis;
                                            long j7 = jCurrentTimeMillis;
                                            _fVar._B = adSlot._w();
                                            jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                            if (jSONObjectOptJSONObject != null) {
                                                _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                                                _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                                                _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                                                jSONObjectOptJSONObject.optString(_z._b("4"));
                                                _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                                                _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                                                _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                                                _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                                                jSONObjectOptJSONObject.optString(_z._b(str13));
                                                strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                                                if (strOptString3 == null) {
                                                    str7 = str13;
                                                } else {
                                                    str7 = str13;
                                                    strDecode = URLDecoder.decode(strOptString3, "utf-8");
                                                    _fVar._r = strDecode;
                                                    _fVar._s = _iVar_a;
                                                    _fVar._t = map_b;
                                                    _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                    jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                    if (jSONObjectOptJSONObject2 != null) {
                                                        _lVar = new _l();
                                                        _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                        _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                        _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                        _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                    } else {
                                                        _lVar = null;
                                                    }
                                                    _fVar._q = _lVar;
                                                    _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                    jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                    arrayList3 = new ArrayList();
                                                    if (jSONArrayOptJSONArray2 != null) {
                                                        while (i13 < jSONArrayOptJSONArray2.length()) {
                                                            arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                        }
                                                    }
                                                    jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                    arrayList4 = new ArrayList();
                                                    if (jSONArrayOptJSONArray3 != null) {
                                                        while (i12 < jSONArrayOptJSONArray3.length()) {
                                                            arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                        }
                                                    }
                                                    _fVar._f = arrayList4;
                                                    jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                    arrayList5 = new ArrayList();
                                                    if (jSONArrayOptJSONArray4 != null) {
                                                        while (i11 < jSONArrayOptJSONArray4.length()) {
                                                            arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                        }
                                                    }
                                                    _fVar._g = arrayList5;
                                                    jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                    arrayList6 = new ArrayList();
                                                    if (jSONArrayOptJSONArray5 != null) {
                                                        while (i10 < jSONArrayOptJSONArray5.length()) {
                                                            arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                        }
                                                    }
                                                    _a(jSONObjectOptJSONObject, _fVar);
                                                    jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                    map2 = new HashMap();
                                                    if (jSONObjectOptJSONObject3 != null) {
                                                        itKeys = jSONObjectOptJSONObject3.keys();
                                                        while (itKeys.hasNext()) {
                                                            String next13 = itKeys.next();
                                                            Iterator<String> it14 = itKeys;
                                                            jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next13);
                                                            JSONObject jSONObject15 = jSONObjectOptJSONObject3;
                                                            arrayList9 = new ArrayList();
                                                            String str1110 = str17;
                                                            HashMap map15 = map_b;
                                                            if (jSONArrayOptJSONArray8 != null) {
                                                                while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                    arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                                }
                                                            }
                                                            map2.put(next13, arrayList9);
                                                            itKeys = it14;
                                                            jSONObjectOptJSONObject3 = jSONObject15;
                                                            str17 = str1110;
                                                            map_b = map15;
                                                        }
                                                    }
                                                    str8 = str17;
                                                    map = map_b;
                                                    _fVar._h = map2;
                                                    _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                    _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                    jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                    arrayList7 = new ArrayList();
                                                    if (jSONArrayOptJSONArray6 != null) {
                                                        while (i8 < jSONArrayOptJSONArray6.length()) {
                                                            arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                        }
                                                    }
                                                    _fVar._H = arrayList7;
                                                    jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                    arrayList8 = new ArrayList();
                                                    if (jSONArrayOptJSONArray7 != null) {
                                                        while (i7 < jSONArrayOptJSONArray7.length()) {
                                                            arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                        }
                                                    }
                                                    _fVar._I = arrayList8;
                                                    _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                    _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                    _ba _baVar16 = _baVar2;
                                                    _fVar._G = _baVar16;
                                                    _f0 _f0Var113 = _f0Var3;
                                                    _fVar._E = _f0Var113;
                                                    _fiVar3 = _fiVar2;
                                                    _fVar._F = _fiVar3;
                                                    str11 = str6;
                                                    _fVar._N = str11;
                                                    str10 = strOptString2;
                                                    _fVar._O = str10;
                                                    str9 = str5;
                                                    _fVar._W = str9;
                                                    _baVar2 = _baVar16;
                                                    boolean z11113 = z;
                                                    _fVar._P = z11113;
                                                    z4 = z11113;
                                                    boolean z11114 = z2;
                                                    _fVar._Q = z11114;
                                                    z5 = z11114;
                                                    boolean z11115 = z3;
                                                    _fVar._R = z11115;
                                                    z6 = z11115;
                                                    _f0Var3 = _f0Var113;
                                                    d2 = d2;
                                                    _fVar._S = d2;
                                                    if (f2 >= 0.0f) {
                                                        f3 = f2;
                                                        _fVar._U = f3;
                                                        int i1111119 = i3;
                                                        _fVar._V = i1111119;
                                                        i6 = i1111119;
                                                        int i11111110 = i2;
                                                        _fVar._T = i11111110;
                                                        i5 = i11111110;
                                                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                        if (adSlot.isSelfRender()) {
                                                            z_c = _iVar_a._c();
                                                        } else {
                                                            z_c = false;
                                                        }
                                                        _fVar._L = z_c;
                                                    }
                                                    _fVar._U = 0.1f;
                                                    f3 = f2;
                                                    int i11111111 = i3;
                                                    _fVar._V = i11111111;
                                                    i6 = i11111111;
                                                    int i11111112 = i2;
                                                    _fVar._T = i11111112;
                                                    i5 = i11111112;
                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                    if (adSlot.isSelfRender()) {
                                                        z_c = _iVar_a._c();
                                                    } else {
                                                        z_c = false;
                                                    }
                                                    _fVar._L = z_c;
                                                }
                                                strDecode = str2;
                                                _fVar._r = strDecode;
                                                _fVar._s = _iVar_a;
                                                _fVar._t = map_b;
                                                _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                if (jSONObjectOptJSONObject2 != null) {
                                                    _lVar = new _l();
                                                    _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                    _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                    _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                    _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                } else {
                                                    _lVar = null;
                                                }
                                                _fVar._q = _lVar;
                                                _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                arrayList3 = new ArrayList();
                                                if (jSONArrayOptJSONArray2 != null) {
                                                    while (i13 < jSONArrayOptJSONArray2.length()) {
                                                        arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                    }
                                                }
                                                jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                arrayList4 = new ArrayList();
                                                if (jSONArrayOptJSONArray3 != null) {
                                                    while (i12 < jSONArrayOptJSONArray3.length()) {
                                                        arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                    }
                                                }
                                                _fVar._f = arrayList4;
                                                jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                arrayList5 = new ArrayList();
                                                if (jSONArrayOptJSONArray4 != null) {
                                                    while (i11 < jSONArrayOptJSONArray4.length()) {
                                                        arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                    }
                                                }
                                                _fVar._g = arrayList5;
                                                jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                arrayList6 = new ArrayList();
                                                if (jSONArrayOptJSONArray5 != null) {
                                                    while (i10 < jSONArrayOptJSONArray5.length()) {
                                                        arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                    }
                                                }
                                                _a(jSONObjectOptJSONObject, _fVar);
                                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                map2 = new HashMap();
                                                if (jSONObjectOptJSONObject3 != null) {
                                                    itKeys = jSONObjectOptJSONObject3.keys();
                                                    while (itKeys.hasNext()) {
                                                        String next14 = itKeys.next();
                                                        Iterator<String> it15 = itKeys;
                                                        jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next14);
                                                        JSONObject jSONObject16 = jSONObjectOptJSONObject3;
                                                        arrayList9 = new ArrayList();
                                                        String str1111 = str17;
                                                        HashMap map16 = map_b;
                                                        if (jSONArrayOptJSONArray8 != null) {
                                                            while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                            }
                                                        }
                                                        map2.put(next14, arrayList9);
                                                        itKeys = it15;
                                                        jSONObjectOptJSONObject3 = jSONObject16;
                                                        str17 = str1111;
                                                        map_b = map16;
                                                    }
                                                }
                                                str8 = str17;
                                                map = map_b;
                                                _fVar._h = map2;
                                                _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                arrayList7 = new ArrayList();
                                                if (jSONArrayOptJSONArray6 != null) {
                                                    while (i8 < jSONArrayOptJSONArray6.length()) {
                                                        arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                    }
                                                }
                                                _fVar._H = arrayList7;
                                                jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                arrayList8 = new ArrayList();
                                                if (jSONArrayOptJSONArray7 != null) {
                                                    while (i7 < jSONArrayOptJSONArray7.length()) {
                                                        arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                    }
                                                }
                                                _fVar._I = arrayList8;
                                                _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                _ba _baVar17 = _baVar2;
                                                _fVar._G = _baVar17;
                                                _f0 _f0Var114 = _f0Var3;
                                                _fVar._E = _f0Var114;
                                                _fiVar3 = _fiVar2;
                                                _fVar._F = _fiVar3;
                                                str11 = str6;
                                                _fVar._N = str11;
                                                str10 = strOptString2;
                                                _fVar._O = str10;
                                                str9 = str5;
                                                _fVar._W = str9;
                                                _baVar2 = _baVar17;
                                                boolean z11116 = z;
                                                _fVar._P = z11116;
                                                z4 = z11116;
                                                boolean z11117 = z2;
                                                _fVar._Q = z11117;
                                                z5 = z11117;
                                                boolean z11118 = z3;
                                                _fVar._R = z11118;
                                                z6 = z11118;
                                                _f0Var3 = _f0Var114;
                                                d2 = d2;
                                                _fVar._S = d2;
                                                if (f2 >= 0.0f) {
                                                    f3 = f2;
                                                    _fVar._U = f3;
                                                    int i11111113 = i3;
                                                    _fVar._V = i11111113;
                                                    i6 = i11111113;
                                                    int i11111114 = i2;
                                                    _fVar._T = i11111114;
                                                    i5 = i11111114;
                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                    if (adSlot.isSelfRender()) {
                                                        z_c = _iVar_a._c();
                                                    } else {
                                                        z_c = false;
                                                    }
                                                    _fVar._L = z_c;
                                                }
                                                _fVar._U = 0.1f;
                                                f3 = f2;
                                                int i11111115 = i3;
                                                _fVar._V = i11111115;
                                                i6 = i11111115;
                                                int i11111116 = i2;
                                                _fVar._T = i11111116;
                                                i5 = i11111116;
                                                _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                if (adSlot.isSelfRender()) {
                                                    z_c = _iVar_a._c();
                                                } else {
                                                    z_c = false;
                                                }
                                                _fVar._L = z_c;
                                            } else {
                                                str7 = str13;
                                                str15 = str15;
                                                str16 = str16;
                                                str8 = str17;
                                                map = map_b;
                                                f3 = f2;
                                                str9 = str5;
                                                str10 = strOptString2;
                                                str11 = str6;
                                                _fiVar3 = _fiVar2;
                                                z4 = z;
                                                z5 = z2;
                                                z6 = z3;
                                                i5 = i2;
                                                i6 = i3;
                                            }
                                            ArrayList arrayList16 = arrayList;
                                            arrayList16.add(_fVar);
                                            i4++;
                                            arrayList = arrayList16;
                                            i3 = i6;
                                            z = z4;
                                            z2 = z5;
                                            z3 = z6;
                                            i2 = i5;
                                            length = i1111118;
                                            str13 = str7;
                                            f2 = f3;
                                            _fiVar2 = _fiVar3;
                                            str6 = str11;
                                            strOptString2 = str10;
                                            str5 = str9;
                                            str14 = str14;
                                            jCurrentTimeMillis = j7;
                                            str15 = str15;
                                            str16 = str16;
                                            str17 = str8;
                                            map_b = map;
                                        }
                                    }
                                    arrayList2 = arrayList;
                                    _rVar = _rVar2;
                                    _rVar._a = arrayList2;
                                    if (!arrayList2.isEmpty()) {
                                        return _a(_rVar, adSlot);
                                    }
                                    if (_rVar._e != 0) {
                                        return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
                                    }
                                    return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                                }
                            } catch (Exception unused15) {
                                d = 0.3d;
                                str3 = strOptString2;
                                str4 = str12;
                                zOptBoolean = false;
                                zOptBoolean2 = false;
                                zOptBoolean3 = false;
                                iOptInt = 0;
                                f = 0.1f;
                                i = 0;
                                _f0Var = null;
                                strOptString2 = str3;
                                d2 = d;
                                str5 = strOptString;
                                z = zOptBoolean;
                                z2 = zOptBoolean2;
                                z3 = zOptBoolean3;
                                i2 = iOptInt;
                                f2 = f;
                                i3 = i;
                                _f0Var2 = _f0Var;
                                _baVar = null;
                                str6 = str4;
                                _fiVar = null;
                                arrayList = new ArrayList();
                                jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
                                if (jSONArrayOptJSONArray != null) {
                                    _f0 _f0Var115 = _f0Var2;
                                    _fiVar2 = _fiVar;
                                    jCurrentTimeMillis = System.currentTimeMillis();
                                    _f0Var3 = _f0Var115;
                                    length = jSONArrayOptJSONArray.length();
                                    _baVar2 = _baVar;
                                    i4 = 0;
                                    while (i4 < length) {
                                        int i11111117 = length;
                                        _fVar = new _f();
                                        _fVar._w = strOptString4;
                                        _fVar._z = jCurrentTimeMillis;
                                        long j8 = jCurrentTimeMillis;
                                        _fVar._B = adSlot._w();
                                        jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                        if (jSONObjectOptJSONObject != null) {
                                            _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                                            _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                                            _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                                            jSONObjectOptJSONObject.optString(_z._b("4"));
                                            _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                                            _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                                            _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                                            _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                                            jSONObjectOptJSONObject.optString(_z._b(str13));
                                            strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                                            if (strOptString3 == null) {
                                                str7 = str13;
                                            } else {
                                                str7 = str13;
                                                strDecode = URLDecoder.decode(strOptString3, "utf-8");
                                                _fVar._r = strDecode;
                                                _fVar._s = _iVar_a;
                                                _fVar._t = map_b;
                                                _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                                jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                                if (jSONObjectOptJSONObject2 != null) {
                                                    _lVar = new _l();
                                                    _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                    _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                    _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                    _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                                } else {
                                                    _lVar = null;
                                                }
                                                _fVar._q = _lVar;
                                                _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                                jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                                arrayList3 = new ArrayList();
                                                if (jSONArrayOptJSONArray2 != null) {
                                                    while (i13 < jSONArrayOptJSONArray2.length()) {
                                                        arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                    }
                                                }
                                                jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                                arrayList4 = new ArrayList();
                                                if (jSONArrayOptJSONArray3 != null) {
                                                    while (i12 < jSONArrayOptJSONArray3.length()) {
                                                        arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                    }
                                                }
                                                _fVar._f = arrayList4;
                                                jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                                arrayList5 = new ArrayList();
                                                if (jSONArrayOptJSONArray4 != null) {
                                                    while (i11 < jSONArrayOptJSONArray4.length()) {
                                                        arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                    }
                                                }
                                                _fVar._g = arrayList5;
                                                jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                                arrayList6 = new ArrayList();
                                                if (jSONArrayOptJSONArray5 != null) {
                                                    while (i10 < jSONArrayOptJSONArray5.length()) {
                                                        arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                    }
                                                }
                                                _a(jSONObjectOptJSONObject, _fVar);
                                                jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                                map2 = new HashMap();
                                                if (jSONObjectOptJSONObject3 != null) {
                                                    itKeys = jSONObjectOptJSONObject3.keys();
                                                    while (itKeys.hasNext()) {
                                                        String next15 = itKeys.next();
                                                        Iterator<String> it16 = itKeys;
                                                        jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next15);
                                                        JSONObject jSONObject17 = jSONObjectOptJSONObject3;
                                                        arrayList9 = new ArrayList();
                                                        String str1112 = str17;
                                                        HashMap map17 = map_b;
                                                        if (jSONArrayOptJSONArray8 != null) {
                                                            while (i9 < jSONArrayOptJSONArray8.length()) {
                                                                arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                            }
                                                        }
                                                        map2.put(next15, arrayList9);
                                                        itKeys = it16;
                                                        jSONObjectOptJSONObject3 = jSONObject17;
                                                        str17 = str1112;
                                                        map_b = map17;
                                                    }
                                                }
                                                str8 = str17;
                                                map = map_b;
                                                _fVar._h = map2;
                                                _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                                _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                                jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                                arrayList7 = new ArrayList();
                                                if (jSONArrayOptJSONArray6 != null) {
                                                    while (i8 < jSONArrayOptJSONArray6.length()) {
                                                        arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                    }
                                                }
                                                _fVar._H = arrayList7;
                                                jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                                arrayList8 = new ArrayList();
                                                if (jSONArrayOptJSONArray7 != null) {
                                                    while (i7 < jSONArrayOptJSONArray7.length()) {
                                                        arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                    }
                                                }
                                                _fVar._I = arrayList8;
                                                _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                                _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                                _ba _baVar18 = _baVar2;
                                                _fVar._G = _baVar18;
                                                _f0 _f0Var116 = _f0Var3;
                                                _fVar._E = _f0Var116;
                                                _fiVar3 = _fiVar2;
                                                _fVar._F = _fiVar3;
                                                str11 = str6;
                                                _fVar._N = str11;
                                                str10 = strOptString2;
                                                _fVar._O = str10;
                                                str9 = str5;
                                                _fVar._W = str9;
                                                _baVar2 = _baVar18;
                                                boolean z11119 = z;
                                                _fVar._P = z11119;
                                                z4 = z11119;
                                                boolean z111110 = z2;
                                                _fVar._Q = z111110;
                                                z5 = z111110;
                                                boolean z111111 = z3;
                                                _fVar._R = z111111;
                                                z6 = z111111;
                                                _f0Var3 = _f0Var116;
                                                d2 = d2;
                                                _fVar._S = d2;
                                                if (f2 >= 0.0f) {
                                                    f3 = f2;
                                                    _fVar._U = f3;
                                                    int i11111118 = i3;
                                                    _fVar._V = i11111118;
                                                    i6 = i11111118;
                                                    int i11111119 = i2;
                                                    _fVar._T = i11111119;
                                                    i5 = i11111119;
                                                    _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                    if (adSlot.isSelfRender()) {
                                                        z_c = _iVar_a._c();
                                                    } else {
                                                        z_c = false;
                                                    }
                                                    _fVar._L = z_c;
                                                }
                                                _fVar._U = 0.1f;
                                                f3 = f2;
                                                int i111111110 = i3;
                                                _fVar._V = i111111110;
                                                i6 = i111111110;
                                                int i111111111 = i2;
                                                _fVar._T = i111111111;
                                                i5 = i111111111;
                                                _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                if (adSlot.isSelfRender()) {
                                                    z_c = _iVar_a._c();
                                                } else {
                                                    z_c = false;
                                                }
                                                _fVar._L = z_c;
                                            }
                                            strDecode = str2;
                                            _fVar._r = strDecode;
                                            _fVar._s = _iVar_a;
                                            _fVar._t = map_b;
                                            _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                                            jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                                            if (jSONObjectOptJSONObject2 != null) {
                                                _lVar = new _l();
                                                _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                                _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                                _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                                _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                                            } else {
                                                _lVar = null;
                                            }
                                            _fVar._q = _lVar;
                                            _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                                            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                                            arrayList3 = new ArrayList();
                                            if (jSONArrayOptJSONArray2 != null) {
                                                while (i13 < jSONArrayOptJSONArray2.length()) {
                                                    arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                                }
                                            }
                                            jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                                            arrayList4 = new ArrayList();
                                            if (jSONArrayOptJSONArray3 != null) {
                                                while (i12 < jSONArrayOptJSONArray3.length()) {
                                                    arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                                }
                                            }
                                            _fVar._f = arrayList4;
                                            jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                                            arrayList5 = new ArrayList();
                                            if (jSONArrayOptJSONArray4 != null) {
                                                while (i11 < jSONArrayOptJSONArray4.length()) {
                                                    arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                                }
                                            }
                                            _fVar._g = arrayList5;
                                            jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                                            arrayList6 = new ArrayList();
                                            if (jSONArrayOptJSONArray5 != null) {
                                                while (i10 < jSONArrayOptJSONArray5.length()) {
                                                    arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                                }
                                            }
                                            _a(jSONObjectOptJSONObject, _fVar);
                                            jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                                            map2 = new HashMap();
                                            if (jSONObjectOptJSONObject3 != null) {
                                                itKeys = jSONObjectOptJSONObject3.keys();
                                                while (itKeys.hasNext()) {
                                                    String next16 = itKeys.next();
                                                    Iterator<String> it17 = itKeys;
                                                    jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next16);
                                                    JSONObject jSONObject18 = jSONObjectOptJSONObject3;
                                                    arrayList9 = new ArrayList();
                                                    String str1113 = str17;
                                                    HashMap map18 = map_b;
                                                    if (jSONArrayOptJSONArray8 != null) {
                                                        while (i9 < jSONArrayOptJSONArray8.length()) {
                                                            arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                                        }
                                                    }
                                                    map2.put(next16, arrayList9);
                                                    itKeys = it17;
                                                    jSONObjectOptJSONObject3 = jSONObject18;
                                                    str17 = str1113;
                                                    map_b = map18;
                                                }
                                            }
                                            str8 = str17;
                                            map = map_b;
                                            _fVar._h = map2;
                                            _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                                            _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                                            jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                                            arrayList7 = new ArrayList();
                                            if (jSONArrayOptJSONArray6 != null) {
                                                while (i8 < jSONArrayOptJSONArray6.length()) {
                                                    arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                                }
                                            }
                                            _fVar._H = arrayList7;
                                            jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                                            arrayList8 = new ArrayList();
                                            if (jSONArrayOptJSONArray7 != null) {
                                                while (i7 < jSONArrayOptJSONArray7.length()) {
                                                    arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                                }
                                            }
                                            _fVar._I = arrayList8;
                                            _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                                            _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                                            _ba _baVar19 = _baVar2;
                                            _fVar._G = _baVar19;
                                            _f0 _f0Var117 = _f0Var3;
                                            _fVar._E = _f0Var117;
                                            _fiVar3 = _fiVar2;
                                            _fVar._F = _fiVar3;
                                            str11 = str6;
                                            _fVar._N = str11;
                                            str10 = strOptString2;
                                            _fVar._O = str10;
                                            str9 = str5;
                                            _fVar._W = str9;
                                            _baVar2 = _baVar19;
                                            boolean z111112 = z;
                                            _fVar._P = z111112;
                                            z4 = z111112;
                                            boolean z111113 = z2;
                                            _fVar._Q = z111113;
                                            z5 = z111113;
                                            boolean z111114 = z3;
                                            _fVar._R = z111114;
                                            z6 = z111114;
                                            _f0Var3 = _f0Var117;
                                            d2 = d2;
                                            _fVar._S = d2;
                                            if (f2 >= 0.0f) {
                                                f3 = f2;
                                                _fVar._U = f3;
                                                int i111111112 = i3;
                                                _fVar._V = i111111112;
                                                i6 = i111111112;
                                                int i111111113 = i2;
                                                _fVar._T = i111111113;
                                                i5 = i111111113;
                                                _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                                if (adSlot.isSelfRender()) {
                                                    z_c = _iVar_a._c();
                                                } else {
                                                    z_c = false;
                                                }
                                                _fVar._L = z_c;
                                            }
                                            _fVar._U = 0.1f;
                                            f3 = f2;
                                            int i111111114 = i3;
                                            _fVar._V = i111111114;
                                            i6 = i111111114;
                                            int i111111115 = i2;
                                            _fVar._T = i111111115;
                                            i5 = i111111115;
                                            _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                                            if (adSlot.isSelfRender()) {
                                                z_c = _iVar_a._c();
                                            } else {
                                                z_c = false;
                                            }
                                            _fVar._L = z_c;
                                        } else {
                                            str7 = str13;
                                            str15 = str15;
                                            str16 = str16;
                                            str8 = str17;
                                            map = map_b;
                                            f3 = f2;
                                            str9 = str5;
                                            str10 = strOptString2;
                                            str11 = str6;
                                            _fiVar3 = _fiVar2;
                                            z4 = z;
                                            z5 = z2;
                                            z6 = z3;
                                            i5 = i2;
                                            i6 = i3;
                                        }
                                        ArrayList arrayList17 = arrayList;
                                        arrayList17.add(_fVar);
                                        i4++;
                                        arrayList = arrayList17;
                                        i3 = i6;
                                        z = z4;
                                        z2 = z5;
                                        z3 = z6;
                                        i2 = i5;
                                        length = i11111117;
                                        str13 = str7;
                                        f2 = f3;
                                        _fiVar2 = _fiVar3;
                                        str6 = str11;
                                        strOptString2 = str10;
                                        str5 = str9;
                                        str14 = str14;
                                        jCurrentTimeMillis = j8;
                                        str15 = str15;
                                        str16 = str16;
                                        str17 = str8;
                                        map_b = map;
                                    }
                                }
                                arrayList2 = arrayList;
                                _rVar = _rVar2;
                                _rVar._a = arrayList2;
                                if (!arrayList2.isEmpty()) {
                                    return _a(_rVar, adSlot);
                                }
                                if (_rVar._e != 0) {
                                    return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
                                }
                                return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
                            }
                        } catch (Exception unused16) {
                            str12 = strOptString6;
                            d = 0.3d;
                            str3 = strOptString2;
                            strOptString = str2;
                        }
                    } catch (Exception unused17) {
                        str12 = strOptString6;
                        d = 0.3d;
                        str3 = str2;
                        strOptString = str3;
                    }
                }
            } catch (Exception unused18) {
                str2 = "";
                _rVar2 = _rVar2;
                d = 0.3d;
                str3 = str2;
                str4 = str3;
                strOptString = str4;
            }
            arrayList = new ArrayList();
            jSONArrayOptJSONArray = jSONObject.optJSONArray(_z._a("9"));
            if (jSONArrayOptJSONArray != null) {
                _f0 _f0Var118 = _f0Var2;
                _fiVar2 = _fiVar;
                jCurrentTimeMillis = System.currentTimeMillis();
                _f0Var3 = _f0Var118;
                length = jSONArrayOptJSONArray.length();
                _baVar2 = _baVar;
                i4 = 0;
                while (i4 < length) {
                    int i111111116 = length;
                    _fVar = new _f();
                    _fVar._w = strOptString4;
                    _fVar._z = jCurrentTimeMillis;
                    long j9 = jCurrentTimeMillis;
                    _fVar._B = adSlot._w();
                    jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                    if (jSONObjectOptJSONObject != null) {
                        _fVar._a = jSONObjectOptJSONObject.optInt(_z._b("1"));
                        _fVar._b = jSONObjectOptJSONObject.optString(_z._b("2"));
                        _fVar._n = jSONObjectOptJSONObject.optInt(_z._b("3"));
                        jSONObjectOptJSONObject.optString(_z._b("4"));
                        _fVar._m = jSONObjectOptJSONObject.optInt(_z._b(str17));
                        _fVar._d = jSONObjectOptJSONObject.optString(_z._b("6"));
                        _fVar._e = jSONObjectOptJSONObject.optString(_z._b(str16));
                        _fVar._i = jSONObjectOptJSONObject.optString(_z._b(str15));
                        jSONObjectOptJSONObject.optString(_z._b(str13));
                        strOptString3 = jSONObjectOptJSONObject.optString(_z._b(str14));
                        if (strOptString3 == null) {
                            str7 = str13;
                        } else {
                            str7 = str13;
                            strDecode = URLDecoder.decode(strOptString3, "utf-8");
                            _fVar._r = strDecode;
                            _fVar._s = _iVar_a;
                            _fVar._t = map_b;
                            _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                            jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                            if (jSONObjectOptJSONObject2 != null) {
                                _lVar = new _l();
                                _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                                _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                                _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                                _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                            } else {
                                _lVar = null;
                            }
                            _fVar._q = _lVar;
                            _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                            jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                            arrayList3 = new ArrayList();
                            if (jSONArrayOptJSONArray2 != null) {
                                while (i13 < jSONArrayOptJSONArray2.length()) {
                                    arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                                }
                            }
                            jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                            arrayList4 = new ArrayList();
                            if (jSONArrayOptJSONArray3 != null) {
                                while (i12 < jSONArrayOptJSONArray3.length()) {
                                    arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                                }
                            }
                            _fVar._f = arrayList4;
                            jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                            arrayList5 = new ArrayList();
                            if (jSONArrayOptJSONArray4 != null) {
                                while (i11 < jSONArrayOptJSONArray4.length()) {
                                    arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                                }
                            }
                            _fVar._g = arrayList5;
                            jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                            arrayList6 = new ArrayList();
                            if (jSONArrayOptJSONArray5 != null) {
                                while (i10 < jSONArrayOptJSONArray5.length()) {
                                    arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                                }
                            }
                            _a(jSONObjectOptJSONObject, _fVar);
                            jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                            map2 = new HashMap();
                            if (jSONObjectOptJSONObject3 != null) {
                                itKeys = jSONObjectOptJSONObject3.keys();
                                while (itKeys.hasNext()) {
                                    String next17 = itKeys.next();
                                    Iterator<String> it18 = itKeys;
                                    jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next17);
                                    JSONObject jSONObject19 = jSONObjectOptJSONObject3;
                                    arrayList9 = new ArrayList();
                                    String str1114 = str17;
                                    HashMap map19 = map_b;
                                    if (jSONArrayOptJSONArray8 != null) {
                                        while (i9 < jSONArrayOptJSONArray8.length()) {
                                            arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                        }
                                    }
                                    map2.put(next17, arrayList9);
                                    itKeys = it18;
                                    jSONObjectOptJSONObject3 = jSONObject19;
                                    str17 = str1114;
                                    map_b = map19;
                                }
                            }
                            str8 = str17;
                            map = map_b;
                            _fVar._h = map2;
                            _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                            _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                            jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                            arrayList7 = new ArrayList();
                            if (jSONArrayOptJSONArray6 != null) {
                                while (i8 < jSONArrayOptJSONArray6.length()) {
                                    arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                                }
                            }
                            _fVar._H = arrayList7;
                            jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                            arrayList8 = new ArrayList();
                            if (jSONArrayOptJSONArray7 != null) {
                                while (i7 < jSONArrayOptJSONArray7.length()) {
                                    arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                                }
                            }
                            _fVar._I = arrayList8;
                            _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                            _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                            _ba _baVar110 = _baVar2;
                            _fVar._G = _baVar110;
                            _f0 _f0Var119 = _f0Var3;
                            _fVar._E = _f0Var119;
                            _fiVar3 = _fiVar2;
                            _fVar._F = _fiVar3;
                            str11 = str6;
                            _fVar._N = str11;
                            str10 = strOptString2;
                            _fVar._O = str10;
                            str9 = str5;
                            _fVar._W = str9;
                            _baVar2 = _baVar110;
                            boolean z111115 = z;
                            _fVar._P = z111115;
                            z4 = z111115;
                            boolean z111116 = z2;
                            _fVar._Q = z111116;
                            z5 = z111116;
                            boolean z111117 = z3;
                            _fVar._R = z111117;
                            z6 = z111117;
                            _f0Var3 = _f0Var119;
                            d2 = d2;
                            _fVar._S = d2;
                            if (f2 >= 0.0f && f2 <= 1.0f) {
                                f3 = f2;
                                _fVar._U = f3;
                            } else {
                                _fVar._U = 0.1f;
                                f3 = f2;
                            }
                            int i111111117 = i3;
                            _fVar._V = i111111117;
                            i6 = i111111117;
                            int i111111118 = i2;
                            _fVar._T = i111111118;
                            i5 = i111111118;
                            _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                            if (adSlot.isSelfRender()) {
                                z_c = _iVar_a._c();
                            } else {
                                z_c = false;
                            }
                            _fVar._L = z_c;
                        }
                        strDecode = str2;
                        _fVar._r = strDecode;
                        _fVar._s = _iVar_a;
                        _fVar._t = map_b;
                        _fVar._y = jSONObjectOptJSONObject.optLong(_z._b("11"));
                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(_z._b("12"));
                        if (jSONObjectOptJSONObject2 != null) {
                            _lVar = new _l();
                            _lVar._d = jSONObjectOptJSONObject2.optString("enprice");
                            _lVar._a = jSONObjectOptJSONObject2.optLong("mlt");
                            _lVar._b = jSONObjectOptJSONObject2.optLong("ae");
                            _lVar._c = jSONObjectOptJSONObject2.optLong("ie");
                        } else {
                            _lVar = null;
                        }
                        _fVar._q = _lVar;
                        _fVar._c = _b(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_GAME_CENTER)));
                        jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_AD_SDK));
                        arrayList3 = new ArrayList();
                        if (jSONArrayOptJSONArray2 != null) {
                            while (i13 < jSONArrayOptJSONArray2.length()) {
                                arrayList3.add(jSONArrayOptJSONArray2.optString(i13));
                            }
                        }
                        jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(_z._b("15"));
                        arrayList4 = new ArrayList();
                        if (jSONArrayOptJSONArray3 != null) {
                            while (i12 < jSONArrayOptJSONArray3.length()) {
                                arrayList4.add(jSONArrayOptJSONArray3.optString(i12));
                            }
                        }
                        _fVar._f = arrayList4;
                        jSONArrayOptJSONArray4 = jSONObjectOptJSONObject.optJSONArray(_z._b("16"));
                        arrayList5 = new ArrayList();
                        if (jSONArrayOptJSONArray4 != null) {
                            while (i11 < jSONArrayOptJSONArray4.length()) {
                                arrayList5.add(jSONArrayOptJSONArray4.optString(i11));
                            }
                        }
                        _fVar._g = arrayList5;
                        jSONArrayOptJSONArray5 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_17));
                        arrayList6 = new ArrayList();
                        if (jSONArrayOptJSONArray5 != null) {
                            while (i10 < jSONArrayOptJSONArray5.length()) {
                                arrayList6.add(jSONArrayOptJSONArray5.optString(i10));
                            }
                        }
                        _a(jSONObjectOptJSONObject, _fVar);
                        jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_18));
                        map2 = new HashMap();
                        if (jSONObjectOptJSONObject3 != null) {
                            itKeys = jSONObjectOptJSONObject3.keys();
                            while (itKeys.hasNext()) {
                                String next18 = itKeys.next();
                                Iterator<String> it19 = itKeys;
                                jSONArrayOptJSONArray8 = jSONObjectOptJSONObject3.optJSONArray(next18);
                                JSONObject jSONObject110 = jSONObjectOptJSONObject3;
                                arrayList9 = new ArrayList();
                                String str1115 = str17;
                                HashMap map110 = map_b;
                                if (jSONArrayOptJSONArray8 != null) {
                                    while (i9 < jSONArrayOptJSONArray8.length()) {
                                        arrayList9.add(jSONArrayOptJSONArray8.optString(i9));
                                    }
                                }
                                map2.put(next18, arrayList9);
                                itKeys = it19;
                                jSONObjectOptJSONObject3 = jSONObject110;
                                str17 = str1115;
                                map_b = map110;
                            }
                        }
                        str8 = str17;
                        map = map_b;
                        _fVar._h = map2;
                        _fVar._C = _a(jSONObjectOptJSONObject.optJSONObject(_z._b(BaseWrapper.ENTER_ID_19)));
                        _fVar._D = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SYSTEM_HELPER));
                        jSONArrayOptJSONArray6 = jSONObjectOptJSONObject.optJSONArray(_z._b("21"));
                        arrayList7 = new ArrayList();
                        if (jSONArrayOptJSONArray6 != null) {
                            while (i8 < jSONArrayOptJSONArray6.length()) {
                                arrayList7.add(jSONArrayOptJSONArray6.optString(i8));
                            }
                        }
                        _fVar._H = arrayList7;
                        jSONArrayOptJSONArray7 = jSONObjectOptJSONObject.optJSONArray(_z._b(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING));
                        arrayList8 = new ArrayList();
                        if (jSONArrayOptJSONArray7 != null) {
                            while (i7 < jSONArrayOptJSONArray7.length()) {
                                arrayList8.add(jSONArrayOptJSONArray7.optString(i7));
                            }
                        }
                        _fVar._I = arrayList8;
                        _fVar._M = jSONObjectOptJSONObject.optString(_z._b(BaseWrapper.ENTER_ID_SHORTCUT));
                        _fVar._j = jSONObjectOptJSONObject.optInt(_z._b("24"), 3000);
                        _ba _baVar111 = _baVar2;
                        _fVar._G = _baVar111;
                        _f0 _f0Var1110 = _f0Var3;
                        _fVar._E = _f0Var1110;
                        _fiVar3 = _fiVar2;
                        _fVar._F = _fiVar3;
                        str11 = str6;
                        _fVar._N = str11;
                        str10 = strOptString2;
                        _fVar._O = str10;
                        str9 = str5;
                        _fVar._W = str9;
                        _baVar2 = _baVar111;
                        boolean z111118 = z;
                        _fVar._P = z111118;
                        z4 = z111118;
                        boolean z111119 = z2;
                        _fVar._Q = z111119;
                        z5 = z111119;
                        boolean z1111110 = z3;
                        _fVar._R = z1111110;
                        z6 = z1111110;
                        _f0Var3 = _f0Var1110;
                        d2 = d2;
                        _fVar._S = d2;
                        if (f2 >= 0.0f) {
                            f3 = f2;
                            _fVar._U = f3;
                            int i111111119 = i3;
                            _fVar._V = i111111119;
                            i6 = i111111119;
                            int i1111111110 = i2;
                            _fVar._T = i1111111110;
                            i5 = i1111111110;
                            _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                            if (adSlot.isSelfRender()) {
                                z_c = _iVar_a._c();
                            } else {
                                z_c = false;
                            }
                            _fVar._L = z_c;
                        }
                        _fVar._U = 0.1f;
                        f3 = f2;
                        int i1111111111 = i3;
                        _fVar._V = i1111111111;
                        i6 = i1111111111;
                        int i1111111112 = i2;
                        _fVar._T = i1111111112;
                        i5 = i1111111112;
                        _fVar._l = jSONObjectOptJSONObject.optString(OapsKey.KEY_SUB_ID);
                        if (adSlot.isSelfRender()) {
                            z_c = _iVar_a._c();
                        } else {
                            z_c = false;
                        }
                        _fVar._L = z_c;
                    } else {
                        str7 = str13;
                        str15 = str15;
                        str16 = str16;
                        str8 = str17;
                        map = map_b;
                        f3 = f2;
                        str9 = str5;
                        str10 = strOptString2;
                        str11 = str6;
                        _fiVar3 = _fiVar2;
                        z4 = z;
                        z5 = z2;
                        z6 = z3;
                        i5 = i2;
                        i6 = i3;
                    }
                    ArrayList arrayList18 = arrayList;
                    arrayList18.add(_fVar);
                    i4++;
                    arrayList = arrayList18;
                    i3 = i6;
                    z = z4;
                    z2 = z5;
                    z3 = z6;
                    i2 = i5;
                    length = i111111116;
                    str13 = str7;
                    f2 = f3;
                    _fiVar2 = _fiVar3;
                    str6 = str11;
                    strOptString2 = str10;
                    str5 = str9;
                    str14 = str14;
                    jCurrentTimeMillis = j9;
                    str15 = str15;
                    str16 = str16;
                    str17 = str8;
                    map_b = map;
                }
            }
            arrayList2 = arrayList;
            _rVar = _rVar2;
            _rVar._a = arrayList2;
            if (!arrayList2.isEmpty()) {
                return _a(_rVar, adSlot);
            }
            if (_rVar._e != 0) {
                return new _a(false, null, new AdErrorImpl(_rVar._e, _rVar._f, (Object) null));
            }
            return new _a(false, null, new AdErrorImpl(10001, AdError.ERROR_NO_AD_STR, (Object) null));
        } catch (Exception e) {
            return new _a(false, null, new AdErrorImpl(1004, e.getMessage(), (Object) null));
        }
    }
}
