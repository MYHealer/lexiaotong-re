package com.fancy;

import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.provider.arb.ArbitraryManger;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.kuaishou.weapon.p0.t;
import java.util.Collection;
import java.util.List;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _aa {
    public static void _a(String str, String str2, Long l, long j, long j2, long j3, long j4) {
        String string;
        _u _uVar_b = _ia._b();
        if (_uVar_b == null || !_uVar_b._l) {
            return;
        }
        try {
            List<Long> priceList = ArbitraryManger.getPriceList(str);
            if (priceList == null || priceList.isEmpty()) {
                string = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                try {
                    string = new JSONArray((Collection) priceList).toString();
                } catch (Exception unused) {
                    string = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                }
            }
            boolean z = j4 != j;
            _os _osVar = new _os(_n4._a);
            _osVar._c = "apd";
            _osVar._h = str2;
            _osVar._b()._i(PtgAdSdk.config.getMediaId());
            _or _orVar = _osVar._t;
            _orVar._a.put("reqKey", str != null ? str : "");
            _orVar._a.put("reqId", str2 != null ? str2 : "");
            _orVar._a.put("omav", l);
            _orVar._a.put("sdv", j);
            _orVar._a.put("frv", j2);
            _orVar._a.put("cgv", j3);
            _orVar._a.put(LiveConfigKey.FLV, j4);
            _orVar._a.put("isAdjusted", z);
            _orVar._a.put("otherPrices", string);
            String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
            if (TextUtil.isNotEmpty(str_a)) {
                NetUtils._a(str_a);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void _a(_u _uVar, int i, int i2) {
        if (_uVar == null || !_uVar._k) {
            return;
        }
        try {
            _os _osVar = new _os(_n4._a);
            _osVar._c = t.p;
            _osVar._b()._i(PtgAdSdk.config.getMediaId());
            _or _orVar = _osVar._t;
            _orVar._a.put("status", i == 2);
            _orVar._a.put("errorCode", i2);
            String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
            if (TextUtil.isNotEmpty(str_a)) {
                NetUtils._a(str_a);
            }
        } catch (Throwable unused) {
        }
    }
}
