package com.fancy;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.hihonor.adsdk.base.c;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lu {
    public static byte[] _a = {33, 12, 82};

    public static String _a(String str, String str2, String str3) {
        return (str3 == null || str3.trim().isEmpty()) ? str : str.replaceAll(str2, com.fancy.adsdk.lib.utils._a._b(str3));
    }

    public static synchronized List<String> _a(List<String> list, Map<String, String> map, AdSlot adSlot) {
        List<String> list2;
        try {
            if (list == null) {
                return Collections.emptyList();
            }
            String sdkVersionCode = PtgAdSdk.getConfig().getSdkVersionCode();
            String str_a = map != null ? _a(map, adSlot) : "";
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String str_a2 = _a(_a(_a(it.next(), "__FTX_TS__", String.valueOf(jCurrentTimeMillis / 1000)), "__FTX_TMS__", String.valueOf(jCurrentTimeMillis)), "__SDK_VERSION__", sdkVersionCode);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        str_a2 = _a(str_a2, entry.getKey(), entry.getValue());
                    }
                }
                Random random = com.fancy.adsdk.lib.utils._a._a;
                if (!TextUtils.isEmpty(str_a2) && (list2 = _if._f._e) != null && !list2.isEmpty()) {
                    try {
                        if (list2.contains(new URL(str_a2).getHost())) {
                            str_a2 = _a(str_a2, "__DATA__", str_a);
                        }
                    } catch (Exception unused) {
                    }
                }
                arrayList.add(str_a2);
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static String _a(Map<String, String> map, AdSlot adSlot) {
        _a7 _a7Var;
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("env", Integer.valueOf(com.fancy.adsdk.lib.utils._a._b()));
            if (adSlot != null) {
                jSONObject.putOpt("ct", Integer.valueOf(adSlot._u()));
                _os _osVar_t = adSlot._t();
                if (_osVar_t != null) {
                    _or _orVar = _osVar_t._t;
                    if (_orVar != null) {
                        jSONObject.putOpt("appVersion", _orVar._a("appVersion"));
                        jSONObject.putOpt("appVersionCode", _orVar._a("appVersionCode"));
                        jSONObject.putOpt("mpSdkVersion", _orVar._a("sdkVersion"));
                        jSONObject.putOpt("mpSdkVersionName", _orVar._a("sdkVersionName"));
                    }
                    if (TextUtils.isEmpty(_osVar_t._m) && (_a7Var = _osVar_t._e) != null && !TextUtils.isEmpty(_a7Var._d)) {
                        str = _osVar_t._e._d;
                    } else {
                        str = _osVar_t._m;
                    }
                    jSONObject.putOpt(c.r1.hnadse, str);
                }
            }
            if (map != null) {
                jSONObject.putOpt("cpSx", map.get("__HW_SLOT_SCREEN_X__"));
                jSONObject.putOpt("cpSy", map.get("__HW_SLOT_SCREEN_Y__"));
                jSONObject.putOpt("cpW", map.get("__HW_W__"));
                jSONObject.putOpt("cpH", map.get("__HW_H__"));
                jSONObject.putOpt("cpDx", map.get("__HW_DOWN_X__"));
                jSONObject.putOpt("cpDy", map.get("__HW_DOWN_Y__"));
                jSONObject.putOpt("cpUx", map.get("__HW_UP_X__"));
                jSONObject.putOpt("cpUy", map.get("__HW_UP_Y__"));
                jSONObject.putOpt("cpDt", map.get("__HW_DOWN_TIME__"));
                jSONObject.putOpt("cpUt", map.get("__HW_UP_TIME__"));
                jSONObject.putOpt("cpAX", map.get("__MP_X_MAX_ACC__"));
                jSONObject.putOpt("cpAY", map.get("__MP_Y_MAX_ACC__"));
                jSONObject.putOpt("cpAZ", map.get("__MP_Z_MAX_ACC__"));
                jSONObject.putOpt("st", map.get("__MP_SPEED_ACC__"));
                jSONObject.putOpt(LiveConfigKey.STANDARD, map.get("__MP_DEGREE__"));
                jSONObject.putOpt("enh", map.get("__MP_ENH__"));
                jSONObject.putOpt("enhRea", map.get("__MP_ENH_REA__"));
                jSONObject.putOpt("enhC", map.get("__MP_ENH_C__"));
                jSONObject.putOpt("enhCRea", map.get("__MP_ENH_C_REA__"));
                jSONObject.putOpt("expCt", map.get("__MP_ENH_EXP_CT__"));
                jSONObject.putOpt("iRm", map.get("iReportM"));
            }
            return com.fancy.adsdk.lib.utils._a._a(jSONObject.toString(), _oi._a());
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized List<String> _a(List<String> list, Map<String, String> map, _f _fVar) {
        List<String> list2;
        try {
            if (list == null) {
                return Collections.emptyList();
            }
            String sdkVersionCode = PtgAdSdk.getConfig().getSdkVersionCode();
            String str_a = map != null ? _a(map, null) : "";
            long jCurrentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String str_a2 = _a(_a(_a(it.next(), "__FTX_TS__", String.valueOf(jCurrentTimeMillis / 1000)), "__FTX_TMS__", String.valueOf(jCurrentTimeMillis)), "__SDK_VERSION__", sdkVersionCode);
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        str_a2 = _a(str_a2, entry.getKey(), entry.getValue());
                    }
                }
                if (_fVar != null && !TextUtil.isEmpty(_fVar._x)) {
                    str_a2 = _a(str_a2, "__WIN__PRICE__", _fVar._x);
                }
                Random random = com.fancy.adsdk.lib.utils._a._a;
                if (!TextUtils.isEmpty(str_a2) && (list2 = _if._f._e) != null && !list2.isEmpty()) {
                    try {
                        if (list2.contains(new URL(str_a2).getHost())) {
                            str_a2 = _a(str_a2, "__DATA__", str_a);
                        }
                    } catch (Exception unused) {
                    }
                }
                arrayList.add(str_a2);
            }
            return arrayList;
        } catch (Throwable th) {
            throw th;
        }
    }
}
