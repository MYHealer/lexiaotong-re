package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.model.AdBidLossReason;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.google.android.material.timepicker.TimeModel;
import com.hihonor.adsdk.base.g.j.e.a;
import com.hihonor.adsdk.base.g.j.e.c;
import com.opos.acs.st.utils.ErrorContants;
import com.umeng.analytics.pro.am;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _m1 {
    public static String _a(String str, String str2, String str3) {
        return TextUtils.isEmpty(str3) ? str : str.replaceAll(str2, com.fancy.adsdk.lib.utils._a._b(str3));
    }

    public static JSONObject _b() {
        JSONObject jSONObject = new JSONObject();
        if (PtgAdSdk.getConfig() == null) {
            return jSONObject;
        }
        try {
            jSONObject.put("mediaId", PtgAdSdk.getConfig().getMediaId());
            jSONObject.put("ptgAppId", PtgAdSdk.getConfig().getVendorId());
            jSONObject.put("policyVersion", PtgAdSdk.getConfig().getPolicyVersion());
            jSONObject.put("policyUrl", PtgAdSdk.getConfig().getPolicyUrl());
            jSONObject.put("sdkVersion", PtgAdSdk.getConfig().getSdkVersionCode());
            jSONObject.put("support", PtgAdSdk.getConfig().isSupport());
            jSONObject.put("channel", PtgAdSdk.getConfig().getChannel());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static JSONObject _c() {
        JSONObject jSONObject = new JSONObject();
        try {
            _c7 _c7Var = _n4._a;
            jSONObject.put("width", _c7Var._n);
            jSONObject.put("height", _c7Var._o);
            jSONObject.put("oaid", _c7Var._a);
            jSONObject.put(a.hnadsv, _c7Var._b);
            jSONObject.put("imei", _c7Var._c);
            jSONObject.put("androidId", _c7Var._d);
            jSONObject.put("udid", (Object) null);
            jSONObject.put(Constant.KEY_MAC, _c7Var._e);
            jSONObject.put("vendor", _c7Var._f);
            jSONObject.put("model", _c7Var._g);
            jSONObject.put(am.x, _c7Var._h);
            jSONObject.put("osVersion", _c7Var._i);
            jSONObject.put("network", _c7Var._j);
            jSONObject.put("operator", _c7Var._k);
            jSONObject.put("operatorCode", _c7Var._l);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void _a(long j) {
        com.fancy.adsdk.lib.utils._d._b(new _m0(this, j));
    }

    public final void _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        NetUtils._a(str);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x009d  */
    public final void _a(Collection<String> collection, String str, _os _osVar, String str2) {
        try {
            if (TextUtils.isEmpty(_osVar._t._a("layer"))) {
                System.out.println();
            }
        } catch (Exception unused) {
        }
        if (str != null && _osVar != null) {
            ArrayList arrayList = new ArrayList();
            synchronized (_ou._a()._a) {
                if (_ou._a()._a != null) {
                    arrayList.addAll(_ou._a()._a);
                }
                if (!arrayList.isEmpty()) {
                    switch (str) {
                        case "inAppBid":
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((_oq) it.next())._h(_osVar);
                            }
                            break;
                        case "inAppBidSuc":
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                ((_oq) it2.next())._c(_osVar);
                            }
                            break;
                        case "bidSel":
                            Iterator it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                ((_oq) it3.next())._f(_osVar);
                            }
                            break;
                        case "inAppImp":
                            Iterator it4 = arrayList.iterator();
                            while (it4.hasNext()) {
                                ((_oq) it4.next())._e(_osVar);
                            }
                            break;
                        case "inAppClick":
                            Iterator it5 = arrayList.iterator();
                            while (it5.hasNext()) {
                                ((_oq) it5.next())._g(_osVar);
                            }
                            break;
                        case "inAppErr":
                            Iterator it6 = arrayList.iterator();
                            while (it6.hasNext()) {
                                ((_oq) it6.next())._d(_osVar);
                            }
                            break;
                        case "inAppVp":
                            Iterator it7 = arrayList.iterator();
                            while (it7.hasNext()) {
                                ((_oq) it7.next())._b(_osVar);
                            }
                            break;
                        case "inAppBidLoss":
                            Iterator it8 = arrayList.iterator();
                            while (it8.hasNext()) {
                                ((_oq) it8.next())._i(_osVar);
                            }
                            break;
                        case "inAppBidWin":
                            Iterator it9 = arrayList.iterator();
                            while (it9.hasNext()) {
                                ((_oq) it9.next())._a(_osVar);
                            }
                            break;
                    }
                }
            }
        }
        if (collection == null || collection.isEmpty()) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            if (!collection.isEmpty()) {
                _osVar._c = str;
                ArrayList arrayList2 = new ArrayList();
                Iterator<String> it10 = collection.iterator();
                while (it10.hasNext()) {
                    String str_a = _a(it10.next(), _osVar);
                    if (!TextUtils.isEmpty(str_a)) {
                        arrayList2.add(str_a);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    Logger.d("TrackingManager:", String.format("DoTracking url [get] action :%s", str));
                    NetUtils._a(arrayList2, (HashMap<String, String>) null);
                }
            }
        } else if (!collection.isEmpty()) {
            _osVar._c = str;
            HashSet<String> hashSet = new HashSet();
            Iterator<String> it11 = collection.iterator();
            while (it11.hasNext()) {
                String str_a2 = _a(it11.next(), _osVar);
                if (!TextUtils.isEmpty(str_a2)) {
                    hashSet.add(str_a2);
                }
            }
            if (!hashSet.isEmpty()) {
                Logger.d("TrackingManager:", String.format("DoTracking url [post] action :%s", str));
                hashSet.toArray(new String[hashSet.size()]);
                for (String str3 : hashSet) {
                    NetUtils._f _fVar = NetUtils._a;
                    com.fancy.adsdk.lib.core.net._a _aVar = new com.fancy.adsdk.lib.core.net._a(str3);
                    if (!TextUtils.isEmpty(str2)) {
                        _aVar._e = str2;
                        _aVar._d = "POST";
                    }
                    _aVar._h = _fVar;
                    NetUtils._b.offer(_aVar);
                }
            }
        }
        if (!"inAppBidSuc".equals(str) || _osVar == null) {
            return;
        }
        _or _orVar = _osVar._t;
        _orVar.getClass();
        try {
            synchronized (_orVar._a) {
                JSONObject jSONObject = _orVar._a;
                if (jSONObject != null) {
                    jSONObject.remove("successType");
                }
            }
        } catch (Exception unused2) {
        }
    }

    public final void _b(_f _fVar) {
        ArrayList arrayList;
        if (_fVar == null) {
            Logger.d("Frequency api win err ad is null");
            return;
        }
        Logger.d("Frequency api win");
        List arrayList2 = _fVar._I;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        int i = _fVar._m;
        synchronized (_lu.class) {
            arrayList = new ArrayList();
            if (TextUtil.isNotEmpty(arrayList2)) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(_lu._a((String) it.next(), "__WIN__PRICE__", String.valueOf(i)));
                }
            }
        }
        NetUtils._a(arrayList, (HashMap<String, String>) null);
    }

    public final void _a(_f _fVar, AdSlot adSlot) {
        Map<String, String> map;
        if (_fVar != null && adSlot != null) {
            Logger.d("Frequency api clk");
            _lt _ltVar = _fVar._u;
            List<String> list_a = (_ltVar == null || (map = _ltVar._b) == null || map.isEmpty()) ? _lu._a(_fVar._g, (Map<String, String>) null, adSlot) : _lu._a(_fVar._g, _fVar._u._b, adSlot);
            if (list_a != null) {
                NetUtils._a(list_a, (HashMap<String, String>) null);
                return;
            } else {
                NetUtils._f _fVar2 = NetUtils._a;
                Logger.e(Logger.ILogger.TAG, "reportUrlList is null");
                return;
            }
        }
        Logger.d("Frequency api clk err ad is null");
    }

    public final void _a(_f _fVar) {
        Map<String, String> map;
        if (_fVar != null) {
            Logger.d("Frequency api imp");
            _lt _ltVar = _fVar._u;
            List<String> list_a = (_ltVar == null || (map = _ltVar._a) == null || map.isEmpty()) ? _lu._a(_fVar._o, (Map<String, String>) null, _fVar) : _lu._a(_fVar._o, _fVar._u._a, _fVar);
            if (list_a != null) {
                NetUtils._a(list_a, (HashMap<String, String>) null);
            } else {
                NetUtils._f _fVar2 = NetUtils._a;
                Logger.e(Logger.ILogger.TAG, "reportUrlList is null");
            }
            Map<Long, List<String>> map2 = _fVar._p;
            if (map2 == null || map2.isEmpty() || map2.isEmpty()) {
                return;
            }
            for (Map.Entry entry : new HashMap(map2).entrySet()) {
                Long l = (Long) entry.getKey();
                List list = (List) entry.getValue();
                if (l != null && l.longValue() >= 0) {
                    _fv._a.postDelayed(new NetUtils._e(list), l.longValue());
                }
            }
            return;
        }
        Logger.d("Frequency api imp err ad is null");
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0072 A[Catch: all -> 0x0098, TryCatch #0 {, blocks: (B:9:0x0014, B:25:0x0067, B:27:0x0072, B:28:0x0076, B:30:0x007c, B:13:0x0028, B:16:0x0037, B:19:0x0046, B:22:0x0055, B:24:0x0061), top: B:39:0x0014 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x007c A[Catch: all -> 0x0098, LOOP:0: B:28:0x0076->B:30:0x007c, LOOP_END, TRY_LEAVE, TryCatch #0 {, blocks: (B:9:0x0014, B:25:0x0067, B:27:0x0072, B:28:0x0076, B:30:0x007c, B:13:0x0028, B:16:0x0037, B:19:0x0046, B:22:0x0055, B:24:0x0061), top: B:39:0x0014 }] */
    public final void _a(_f _fVar, AdBidLossReason adBidLossReason) {
        String str;
        ArrayList arrayList;
        Iterator it;
        if (_fVar == null) {
            Logger.d("Frequency api fail err ad is null");
            return;
        }
        Logger.d("Frequency api fail");
        List arrayList2 = _fVar._H;
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        synchronized (_lu.class) {
            String str2 = "";
            String lossOtherReason = "";
            if ("1001".equals(adBidLossReason.getLossCode())) {
                str = ErrorContants.INIT_LOADAD_ERROR;
            } else if (BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB.equals(adBidLossReason.getLossCode())) {
                str = "203";
            } else if (BiddingConst.BIDDING_LOSS.WITH_BIDDING_TIMEOUT.equals(adBidLossReason.getLossCode())) {
                str = "100";
            } else {
                if ("1004".equals(adBidLossReason.getLossCode())) {
                    str = ErrorContants.REALTIME_LOADAD_ERROR;
                } else if ("1005".equals(adBidLossReason.getLossCode())) {
                    str2 = "900";
                    lossOtherReason = adBidLossReason.getLossOtherReason();
                }
                arrayList = new ArrayList();
                if (TextUtil.isNotEmpty(arrayList2)) {
                    it = arrayList2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(_lu._a(_lu._a((String) it.next(), "__REASON__", str2), c.hnadso, lossOtherReason));
                    }
                }
            }
            str2 = str;
            arrayList = new ArrayList();
            if (TextUtil.isNotEmpty(arrayList2)) {
                it = arrayList2.iterator();
                while (it.hasNext()) {
                    arrayList.add(_lu._a(_lu._a((String) it.next(), "__REASON__", str2), c.hnadso, lossOtherReason));
                }
            }
        }
        NetUtils._a(arrayList, (HashMap<String, String>) null);
    }

    public static JSONObject _a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_version", _ca._b()._a);
            jSONObject.put("app_version_code", _ca._b()._b);
            jSONObject.put("app_name", _ca._b()._c);
            jSONObject.put(com.hihonor.adsdk.base.download.marketdownload.a.hnadse, _ca._b()._d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static String _a(String str, _os _osVar) {
        _c7 _c7Var;
        _c7 _c7Var2;
        String str2;
        _a7 _a7Var;
        String str3;
        _c7 _c7Var3;
        String str4;
        _c7 _c7Var4;
        _dz _dzVar;
        String str_a;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        _osVar._b();
        String str_a2 = _a(_a(_a(str, "__SDK_VERSION__", PtgAdSdk.getConfig().getSdkVersionCode()), "__ERR__", String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(_osVar._f))), "__OS__", "1");
        TextUtils.isEmpty(_osVar._i);
        String str_a3 = _a(str_a2, "__IMEI__", _osVar._i);
        String str_a4 = (!TextUtils.isEmpty(_osVar._j) || (_c7Var = _osVar._d) == null || TextUtils.isEmpty(_c7Var._e)) ? _osVar._j : _os._a(_osVar._d._e);
        String str_a5 = _a(str_a3, "__MAC__", str_a4);
        if (TextUtils.isEmpty(_osVar._k) && (_c7Var2 = _osVar._d) != null && !TextUtils.isEmpty(_c7Var2._d)) {
            str2 = _osVar._d._d;
        } else {
            str2 = _osVar._k;
        }
        String str_a6 = _a(_a(str_a5, "__ANDROIDID__", str2), "__REQUESTID__", _osVar._h);
        if (TextUtils.isEmpty(_osVar._m) && (_a7Var = _osVar._e) != null && !TextUtils.isEmpty(_a7Var._d)) {
            str3 = _osVar._e._d;
        } else {
            str3 = _osVar._m;
        }
        String str_a7 = _a(_a(_a(_a(_a(str_a6, "__APP__", str3), "__AD__", String.format(TimeModel.NUMBER_FORMAT, Long.valueOf(_osVar._o))), "__TS__", String.format(TimeModel.NUMBER_FORMAT, Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue()))), "__SLOTID__", _osVar._a), "__CID__", _osVar._b);
        if (TextUtils.isEmpty(_osVar._l) && (_c7Var3 = _osVar._d) != null && !TextUtils.isEmpty(_c7Var3._a)) {
            str4 = _osVar._d._a;
        } else {
            str4 = _osVar._l;
        }
        String str_a8 = _a(_a(str_a7, c.hnadsk, str4), "__ACTION__", _osVar._c);
        String str5 = (!TextUtils.isEmpty(_osVar._n) || (_c7Var4 = _osVar._d) == null || (_dzVar = _c7Var4._m) == null) ? _osVar._n : String.format("%fx%f", Double.valueOf(_dzVar._a), Double.valueOf(_dzVar._b));
        String str_a9 = _a(_a(_a(str_a8, "__LBS__", str5), "__IP__", "127.0.0.1"), "__CLIENTTYPE__", "2");
        _or _orVar = _osVar._t;
        _orVar.getClass();
        try {
            synchronized (_orVar._a) {
                JSONObject jSONObject = _orVar._a;
                str_a = com.fancy.adsdk.lib.utils._a._a(jSONObject == null ? "" : jSONObject.toString(), _oi._a());
            }
        } catch (Exception unused) {
            str_a = "";
        }
        return _a(str_a9, "__DATA__", str_a);
    }
}
