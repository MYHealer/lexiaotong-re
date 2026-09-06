package com.fancy;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.tid.b;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.PtgCustomController;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.arb.ArbitraryManger;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.constant.bf;
import com.tencent.mm.opensdk.constants.Build;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.d;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _av {
    /* JADX WARN: Multi-variable type inference failed */
    public static LinkedHashMap _a(AdSlot adSlot) {
        String str_d;
        String str;
        boolean z;
        String str2;
        String string;
        int iIntValue;
        String str_b;
        String str_a;
        String strValueOf;
        String str3;
        String str_b2;
        String str_a2;
        String str_a3;
        long jElapsedRealtime;
        int i_a;
        Double dValueOf;
        Long l_b;
        int i_w = adSlot._w();
        String codeId = adSlot.getCodeId();
        long basePrice = adSlot.getBasePrice();
        _c7 _c7Var_m = adSlot._m();
        String ptgSlotID = adSlot.getPtgSlotID();
        String str_l = adSlot._l();
        boolean zIsCountdownVisibility = adSlot.isCountdownVisibility();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str_a4 = _a2._a("2");
        _c7Var_m.getClass();
        linkedHashMap.put(str_a4, "client");
        String str_a5 = _a2._a("3");
        if (TextUtils.isEmpty(_c7Var_m._z)) {
            str_d = _ox._c;
            if (TextUtils.isEmpty(str_d)) {
                str_d = _kr._d(PtgAdSdk.getContext(), "ptg_ua");
                Context context = PtgAdSdk.getContext();
                if (context != null && _ox._b.get() <= 3 && _ox._a.compareAndSet(false, true)) {
                    com.fancy.adsdk.lib.utils._d._b(new _ow(context, null));
                } else {
                    _ox._a(null, "");
                }
            }
            if (TextUtils.isEmpty(str_d)) {
                str_d = "";
            }
            _c7Var_m._z = str_d;
        } else {
            str_d = _c7Var_m._z;
        }
        linkedHashMap.put(str_a5, str_d);
        linkedHashMap.put(_a2._a("4"), String.valueOf(_c7Var_m._y));
        linkedHashMap.put(_a2._a("5"), "1");
        linkedHashMap.put(_a2._a("6"), "icon,mp4,img,video-icon");
        String str_a6 = _a2._a("7");
        _c7 _c7Var = _ca._a;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oaid", _c7Var_m._a);
            jSONObject.put(a.hnadsv, _c7Var_m._b);
            jSONObject.put("imei", _c7Var_m._c);
            jSONObject.put("android_id", _c7Var_m._d);
            jSONObject.put(Constant.KEY_MAC, _c7Var_m._e);
            jSONObject.put("vendor", _c7Var_m._f);
            jSONObject.put("model", _c7Var_m._g);
            jSONObject.put(am.x, _c7Var_m._h);
            jSONObject.put("os_version", _c7Var_m._i);
            jSONObject.put("network", _c7Var_m._j);
            jSONObject.put("operator", _c7Var_m._k);
            jSONObject.put("operator_code", _c7Var_m._l);
            jSONObject.put("width", _c7Var_m._n);
            jSONObject.put("height", _c7Var_m._o);
            _dz _dzVar = _c7Var_m._m;
            if (_dzVar != null) {
                JSONObject jSONObject2 = new JSONObject();
                str = str_l;
                z = zIsCountdownVisibility;
                try {
                    jSONObject2.put(d.C, _dzVar._a);
                    str2 = "";
                    try {
                        jSONObject2.put(d.D, _dzVar._b);
                        jSONObject2.put(b.f, _dzVar._c);
                        jSONObject.put("gps", jSONObject2);
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    str2 = "";
                }
            } else {
                str = str_l;
                z = zIsCountdownVisibility;
                str2 = "";
            }
            jSONObject.put("boot_mark", _c7Var_m._u);
            jSONObject.put("update_mark", _c7Var_m._v);
            jSONObject.put("vercode_of_hms", _c7Var_m._w);
            jSONObject.put("vercode_of_ag", _c7Var_m._x);
            jSONObject.put("hajs", com.fancy.adsdk.lib.utils._a._c());
            jSONObject.put("abiArr", _ca._a());
            jSONObject.put("procBit", _ca._e());
            if (PtgAdSdk.getConfig().getMediaStatus() == 1) {
                Long l_f = _mx._f();
                if (l_f != null) {
                    jSONObject.put("physicalMemoryKBytes", l_f);
                }
                PtgCustomController ptgCustomController = PtgAdSdk.tempPtgCustomController;
                if (ptgCustomController == null) {
                    ptgCustomController = PtgAdSdk.getConfig().getPtgCustomController();
                }
                if (ptgCustomController != null && ptgCustomController.isAllowHardDiskSizeKBytes() && (l_b = _mx._b()) != null) {
                    jSONObject.put("hardDiskSizeKBytes", l_b);
                }
                String str_a7 = _mx._a();
                if (str_a7 != null) {
                    jSONObject.put(am.O, str_a7);
                }
                String str_h = _mx._h();
                if (str_h != null) {
                    jSONObject.put("timeZone", str_h);
                }
                if (_mx._i) {
                    dValueOf = _mx._j;
                } else {
                    try {
                        dValueOf = Double.valueOf(Resources.getSystem().getDisplayMetrics().density);
                    } catch (Throwable unused3) {
                        dValueOf = null;
                    }
                    _mx._j = dValueOf;
                    _mx._i = true;
                }
                if (dValueOf != null) {
                    jSONObject.put(bf.ar, dValueOf);
                }
            }
        } catch (Exception unused4) {
            str = str_l;
            z = zIsCountdownVisibility;
        }
        linkedHashMap.put(str_a6, jSONObject.toString());
        linkedHashMap.put(_a2._a("8"), codeId);
        linkedHashMap.put(_a2._a("9"), String.valueOf(i_w));
        linkedHashMap.put(_a2._a("10"), _c7Var_m._q);
        linkedHashMap.put(_a2._a("11"), _c7Var_m._p);
        linkedHashMap.put(_a2._a("12"), _c7Var_m._r);
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_GAME_CENTER), _c7Var_m._s);
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_AD_SDK), PtgAdSdk.getConfig().getSdkVersionName());
        linkedHashMap.put(_a2._a("15"), PtgAdSdk.getConfig().getSdkVersionCode());
        linkedHashMap.put(_a2._a("16"), String.valueOf(PtgAdSdk.getConfig().isSupport()));
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_17), _c7Var_m._a);
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_18), _c7Var_m._b);
        String str_a8 = _a2._a(BaseWrapper.ENTER_ID_19);
        AtomicBoolean atomicBoolean = _p2._a;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("gender", 0);
            jSONObject3.put("age", 0);
            jSONObject3.put("tag", new JSONArray((Collection) _p2._f));
            string = jSONObject3.toString();
        } catch (Exception unused5) {
            string = str2;
        }
        linkedHashMap.put(str_a8, string);
        linkedHashMap.put(_a2._a("21"), String.valueOf(basePrice));
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_SYSTEM_SIM_SETTING), ptgSlotID);
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_SHORTCUT), str);
        linkedHashMap.put(_a2._a("24"), PtgAdSdk.getConfig().getChannel());
        linkedHashMap.put(_a2._a("25"), String.valueOf(PtgAdSdk.getConfig().isSensorStatus()));
        linkedHashMap.put(_a2._a("26"), String.valueOf(_c7Var_m._B));
        linkedHashMap.put(_a2._a("27"), String.valueOf(_c7Var_m._C));
        linkedHashMap.put(_a2._a("28"), String.valueOf(z));
        linkedHashMap.put(_a2._a("29"), String.valueOf(System.currentTimeMillis()));
        String str_a9 = _a2._a(BaseWrapper.ENTER_ID_TOOLKIT);
        Boolean supportHttp = PtgAdSdk.getConfig().getSupportHttp();
        if (supportHttp != null) {
            iIntValue = supportHttp.booleanValue();
        } else {
            if (com.fancy.adsdk.lib.utils._b._a == null) {
                com.fancy.adsdk.lib.utils._b._a();
            }
            iIntValue = com.fancy.adsdk.lib.utils._b._a.intValue();
        }
        linkedHashMap.put(str_a9, String.valueOf(iIntValue));
        if (8 == i_w) {
            linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_OAPS_DEMO), String.valueOf(adSlot.isSelfRender()));
        }
        linkedHashMap.put(_a2._a("32"), String.valueOf(PtgAdSdk.getConfig().isPersonalizedState()));
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_OAPS_ROAMING), String.valueOf(PtgAdSdk.getConfig().isProgrammaticRecommendState()));
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_OAPS_ASSISTANT_SCREEN), PtgAdSdk.getConfig().getPolicyVersion());
        linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_OAPS_PHONEMANAGER), ArbitraryManger.getPlatformList());
        if (_mx._l()) {
            String str_c = _mx._c();
            if (!TextUtils.isEmpty(str_c) && !"null".equalsIgnoreCase(str_c.trim())) {
                linkedHashMap.put(_a2._a("41"), str_c.trim());
            }
        }
        if (_mx._k()) {
            if (_mx._m) {
                str_b2 = _mx._n;
            } else {
                str_b2 = _mx._b("ro.vivo.os.version");
                if (str_b2 == null) {
                    str_b2 = _mx._b("ro.build.version.bbk");
                }
                if (str_b2 == null) {
                    str_b2 = "unknow";
                }
                _mx._n = str_b2;
                _mx._m = true;
            }
            if (!TextUtils.isEmpty(str_b2) && !"null".equalsIgnoreCase(str_b2.trim())) {
                linkedHashMap.put(_a2._a("42"), str_b2.trim());
            }
            if (_mx._o) {
                str_a2 = _mx._p;
            } else {
                str_a2 = _mx._a("com.bbk.appstore");
                _mx._p = str_a2;
                _mx._o = true;
            }
            if (!TextUtils.isEmpty(str_a2) && !"null".equalsIgnoreCase(str_a2.trim())) {
                linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_OAPS_CLOUD), str_a2.trim());
            }
            if (_mx._q) {
                str_a3 = _mx._r;
            } else {
                str_a3 = _mx._a("com.vivo.browser");
                _mx._r = str_a3;
                _mx._q = true;
            }
            if (!TextUtils.isEmpty(str_a3) && !"null".equalsIgnoreCase(str_a3.trim())) {
                linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_OAPS_SECUREPAY), str_a3.trim());
            }
            Integer num_g = _mx._g();
            if (num_g != null) {
                linkedHashMap.put(_a2._a(BaseWrapper.ENTER_ID_OAPS_RECENTS), String.valueOf(num_g));
            }
            String str_a10 = _a2._a(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP);
            long j = 0;
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
            } catch (Throwable unused6) {
                jElapsedRealtime = 0;
            }
            linkedHashMap.put(str_a10, String.valueOf(jElapsedRealtime));
            String str_a11 = _a2._a("47");
            try {
                Context context2 = PtgAdSdk.getContext();
                i_a = context2 == null ? -1 : _gx._a(context2);
            } catch (Throwable unused7) {
            }
            linkedHashMap.put(str_a11, String.valueOf(i_a));
            String str_a12 = _a2._a(com.huawei.openalliance.ad.beans.inner.a.Code);
            try {
                _dz _dzVar2 = _c7Var_m._m;
                if (_dzVar2 != null) {
                    long j2 = _dzVar2._c;
                    if (j2 > 0) {
                        j = 1000 * j2;
                    }
                }
            } catch (Throwable unused8) {
            }
            linkedHashMap.put(str_a12, String.valueOf(j));
        }
        if (_mx._j()) {
            String str_d2 = _mx._d();
            if (!TextUtils.isEmpty(str_d2) && !"null".equalsIgnoreCase(str_d2.trim())) {
                linkedHashMap.put(_a2._a(com.huawei.openalliance.ad.beans.inner.a.V), str_d2.trim());
            }
            if (_mx._w) {
                str_b = _mx._x;
            } else {
                str_b = _mx._b("ro.build.version.opporom");
                if (str_b == null) {
                    str_b = _mx._b("ro.build.version.oplusrom");
                }
                if (str_b == null) {
                    str_b = _mx._b("ro.oplus.version");
                }
                _mx._x = str_b;
                _mx._w = true;
            }
            if (!TextUtils.isEmpty(str_b) && !"null".equalsIgnoreCase(str_b.trim())) {
                linkedHashMap.put(_a2._a("50"), str_b.trim());
            }
            if (_mx._A) {
                str_a = _mx._B;
            } else {
                str_a = _mx._a("com.tencent.mm");
                _mx._B = str_a;
                _mx._A = true;
            }
            if (!TextUtils.isEmpty(str_a) && !"null".equalsIgnoreCase(str_a.trim())) {
                linkedHashMap.put(_a2._a("51"), str_a.trim());
            }
            if (_mx._C) {
                str3 = _mx._D;
            } else {
                try {
                    strValueOf = String.valueOf(Build.SDK_INT);
                } catch (Throwable unused9) {
                    strValueOf = null;
                }
                _mx._D = strValueOf;
                _mx._C = true;
                str3 = strValueOf;
            }
            if (!TextUtils.isEmpty(str3) && !"null".equalsIgnoreCase(str3.trim())) {
                linkedHashMap.put(_a2._a("52"), str3.trim());
            }
            String str_e = _mx._e();
            if (!TextUtils.isEmpty(str_e) && !"null".equalsIgnoreCase(str_e.trim())) {
                linkedHashMap.put(_a2._a("53"), str_e.trim());
            }
        }
        return linkedHashMap;
    }
}
