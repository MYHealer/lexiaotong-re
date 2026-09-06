package com.fancy;

import android.text.TextUtils;
import android.util.Base64;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.model.PtgAdLoadType;
import com.fancy.mpsdk.provider.PtgApiProvider;
import com.fancy.oaid.OaidManager;
import com.hihonor.adsdk.base.g.j.e.c;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _m4 {

    public class _a implements _a4 {
        public final /* synthetic */ AdSlot _a;
        public final /* synthetic */ _b4 _b;

        public _a(AdSlot adSlot, _b4 _b4Var) {
            this._a = adSlot;
            this._b = _b4Var;
        }

        @Override // com.fancy._a4
        public final void _a(String str) {
            _m4._a(this._a, this._b);
        }
    }

    public class _c implements _ih._a {
        public final /* synthetic */ _0._a _a;

        public _c(_0._a _aVar) {
            this._a = _aVar;
        }

        @Override // com.fancy._ih._a
        public final void _a() {
        }

        @Override // com.fancy._ih._a
        public final void _b() {
            _r _rVar;
            List<_f> list;
            _f _fVar;
            _0._a _aVar = this._a;
            if (_aVar == null || (_rVar = _aVar._b) == null || (list = _rVar._a) == null || list.isEmpty() || (_fVar = list.get(0)) == null) {
                return;
            }
            _fVar._J = true;
        }
    }

    public static void _a(_b4<_r> _b4Var, AdSlot adSlot, _0._a _aVar) {
        List<_f> list;
        _f _fVar;
        if ((adSlot != null ? adSlot.getAdLoadType() : PtgAdLoadType.UNKNOWN) == PtgAdLoadType.PRELOAD) {
            _ih _ihVar = _ih._b._a;
            _c _cVar = new _c(_aVar);
            _ihVar.getClass();
            try {
                _r _rVar = _aVar._b;
                int i = 0;
                _ij _ijVar = (_rVar == null || (list = _rVar._a) == null || list.isEmpty() || (_fVar = list.get(0)) == null) ? null : _fVar._C;
                if (_ijVar != null) {
                    if (_ijVar._a()) {
                        _l3 _l3Var = _ijVar._f;
                        String str = _l3Var._b;
                        if (TextUtils.isEmpty(str)) {
                            _ihVar._a(_l3Var._a, _cVar);
                        } else {
                            _ihVar._a(str, _cVar);
                        }
                    } else {
                        List<_jz> list2 = _ijVar._e;
                        if (list2 != null && !list2.isEmpty()) {
                            int size = list2.size();
                            while (i < size) {
                                _ihVar._a(list2.get(i)._a, i == 0 ? _cVar : null);
                                i++;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.getMessage();
            }
        }
        _b4Var._a(_aVar._b);
    }

    public static void _b(AdSlot adSlot, _b4<_r> _b4Var) {
        AdError adErrorImpl;
        if (TextUtils.isEmpty(adSlot.getCodeId()) && TextUtils.isEmpty(adSlot.getPtgSlotID())) {
            if (_b4Var != null) {
                AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                adErrorImpl2._a = 10003;
                adErrorImpl2._b = PtgErrorCode.APP_SLOT_ERROR();
                adErrorImpl2._c = PtgApiProvider.providerName;
                adErrorImpl2._d = 10003;
                adErrorImpl2._e = PtgErrorCode.APP_SLOT_ERROR();
                _b4Var.onError(adErrorImpl2);
                return;
            }
            return;
        }
        if (-1 == _gx._b(PtgAdSdk.getContext())) {
            if (_b4Var != null) {
                AdErrorImpl adErrorImpl3 = new AdErrorImpl();
                adErrorImpl3._a = 10005;
                adErrorImpl3._b = PtgErrorCode.APP_NETWORK_ERROR();
                adErrorImpl3._c = PtgApiProvider.providerName;
                adErrorImpl3._d = 10005;
                adErrorImpl3._e = PtgErrorCode.APP_NETWORK_ERROR();
                _b4Var.onError(adErrorImpl3);
                return;
            }
            return;
        }
        try {
            _au _auVar_c = adSlot._c();
            if (_auVar_c != null) {
                String str = _auVar_c._b;
                if (!TextUtils.isEmpty(str)) {
                    String str_a = com.fancy.adsdk.lib.utils._a._a(_oi._a(), Base64.decode(str, 2));
                    if (TextUtils.isEmpty(str_a)) {
                        if (_b4Var != null) {
                            AdErrorImpl adErrorImpl4 = new AdErrorImpl();
                            adErrorImpl4._a = 10002;
                            adErrorImpl4._b = "adm 数据异常！";
                            _b4Var.onError(adErrorImpl4);
                            return;
                        }
                        return;
                    }
                    String str2 = _auVar_c._c;
                    if (!c.hnadsv.equals(str2)) {
                        str_a = str_a.replaceAll(c.hnadsv, com.fancy.adsdk.lib.utils._a._b(str2));
                    }
                    _0._a _aVar_a = _0._a(adSlot, str_a);
                    if (_b4Var != null) {
                        if (_aVar_a._a) {
                            if (adSlot.getBasePrice() > 0) {
                                List<_f> list = _aVar_a._b._a;
                                int i = 0;
                                if (list != null && !list.isEmpty()) {
                                    i = list.get(0)._m;
                                }
                                if (i < adSlot.getBasePrice()) {
                                    adErrorImpl = new AdErrorImpl(PtgErrorCode.SDK_BELOW_BASE_PRICE, PtgErrorCode.SDK_BELOW_BASE_PRICE_STR, (Object) null);
                                }
                            }
                            _a(_b4Var, adSlot, _aVar_a);
                            return;
                        }
                        adErrorImpl = _aVar_a._c;
                        _b4Var.onError(adErrorImpl);
                        return;
                    }
                    return;
                }
            }
            if (adSlot._m() == null || !TextUtils.isEmpty(adSlot._m()._a)) {
                _a(adSlot, _b4Var);
            } else {
                OaidManager.getOaidAsync(PtgAdSdk.getContext(), new _a(adSlot, _b4Var));
            }
        } catch (Exception unused) {
            if (_b4Var != null) {
                AdErrorImpl adErrorImpl5 = new AdErrorImpl();
                adErrorImpl5._a = 10002;
                adErrorImpl5._b = "adm 数据异常！";
                _b4Var.onError(adErrorImpl5);
            }
        }
    }

    public class _b implements _e7 {
        public final /* synthetic */ String _a;
        public final /* synthetic */ _b4 _b;
        public final /* synthetic */ AdSlot _c;

        public _b(AdSlot adSlot, _b4 _b4Var, String str) {
            this._a = str;
            this._b = _b4Var;
            this._c = adSlot;
        }

        @Override // com.fancy._e7
        public final void _a(com.fancy.adsdk.lib.core.net._a _aVar) {
            com.fancy.adsdk.lib.core.net._b _bVar = com.fancy.adsdk.lib.core.net._b._b;
            String str = this._a;
            _bVar.getClass();
            if (str == null || _aVar == null) {
                return;
            }
            _bVar._a.put(str, _aVar);
        }

        /* JADX WARN: Code duplicated, block: B:37:0x00a0 A[Catch: all -> 0x00cb, TryCatch #1 {all -> 0x00cb, blocks: (B:2:0x0000, B:4:0x0006, B:6:0x0010, B:9:0x001a, B:13:0x0023, B:16:0x0038, B:18:0x003e, B:20:0x0042, B:23:0x0057, B:25:0x0061, B:27:0x0065, B:29:0x0071, B:31:0x0078, B:33:0x007e, B:34:0x0086, B:36:0x0091, B:37:0x00a0, B:38:0x00a8, B:41:0x00b2, B:43:0x00b6, B:7:0x0015), top: B:51:0x0000 }] */
        @Override // com.fancy._e7
        public final void _a(com.fancy.adsdk.lib.core.net._a _aVar, int i, String str) {
            String str_a;
            try {
                com.fancy.adsdk.lib.core.net._b _bVar = com.fancy.adsdk.lib.core.net._b._b;
                String str2 = this._a;
                if (str2 != null) {
                    com.fancy.adsdk.lib.core.net._a _aVar2 = (com.fancy.adsdk.lib.core.net._a) _bVar._a.remove(str2);
                    if (_aVar2 != null) {
                        _aVar2._h = NetUtils._a;
                    }
                } else {
                    _bVar.getClass();
                }
                if (i == 0 || TextUtils.isEmpty(str)) {
                    _b4 _b4Var = this._b;
                    if (_b4Var != null) {
                        AdErrorImpl adErrorImpl = new AdErrorImpl();
                        adErrorImpl._a = 10001;
                        adErrorImpl._b = PtgErrorCode.SDK_NO_AD_1;
                        _b4Var.onError(adErrorImpl);
                    }
                    return;
                }
                try {
                    str_a = com.fancy.adsdk.lib.utils._a._a(_oi._a(), Base64.decode(str.getBytes("UTF-8"), 2));
                } catch (Exception unused) {
                    str_a = null;
                }
                if (TextUtils.isEmpty(str_a)) {
                    _b4 _b4Var2 = this._b;
                    if (_b4Var2 != null) {
                        AdErrorImpl adErrorImpl2 = new AdErrorImpl();
                        adErrorImpl2._a = 10002;
                        adErrorImpl2._b = "解析失败";
                        _b4Var2.onError(adErrorImpl2);
                    }
                    return;
                }
                _0._a _aVar_a = _0._a(this._c, str_a);
                _b4 _b4Var3 = this._b;
                if (_b4Var3 != null) {
                    if (!_aVar_a._a) {
                        _b4Var3.onError(_aVar_a._c);
                    } else if (this._c.getBasePrice() > 0) {
                        List<_f> list = _aVar_a._b._a;
                        int i2 = 0;
                        if (list != null && !list.isEmpty()) {
                            i2 = list.get(0)._m;
                        }
                        if (i2 < this._c.getBasePrice()) {
                            this._b.onError(new AdErrorImpl(PtgErrorCode.SDK_BELOW_BASE_PRICE, PtgErrorCode.SDK_BELOW_BASE_PRICE_STR, (Object) null));
                        } else {
                            _m4._a(this._b, this._c, _aVar_a);
                        }
                    } else {
                        _m4._a(this._b, this._c, _aVar_a);
                    }
                }
            } finally {
                _aVar._h = NetUtils._a;
            }
        }
    }

    public static void _a(AdSlot adSlot, _b4<_r> _b4Var) {
        String ptgApiUrl = PtgAdSdk.getConfig().getPtgApiUrl();
        StringBuilder sb = new StringBuilder(ptgApiUrl);
        String str_p = adSlot._p();
        if (TextUtils.isEmpty(str_p) || "0".equals(str_p)) {
            str_p = PtgAdSdk.getConfig().getVendorId();
        }
        String str_a = "";
        StringBuilder sbAppend = sb.append(ptgApiUrl.contains("?") ? ptgApiUrl.endsWith("?") ? "" : "&" : "?").append("mid=");
        if (str_p == null) {
            str_p = "";
        }
        try {
            str_p = URLEncoder.encode(str_p, "UTF-8");
        } catch (Exception unused) {
        }
        sbAppend.append(str_p).append("&mt=1");
        String string = sb.toString();
        LinkedHashMap linkedHashMap_a = _av._a(adSlot);
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : linkedHashMap_a.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
            str_a = com.fancy.adsdk.lib.utils._a._a(jSONObject.toString(), _oi._a());
        } catch (Exception unused2) {
        }
        int timeoutMs = adSlot.getTimeoutMs();
        _b _bVar = new _b(adSlot, _b4Var, _ie._a("ad_request_").append(adSlot.hashCode()).toString());
        NetUtils._f _fVar = NetUtils._a;
        com.fancy.adsdk.lib.core.net._a _aVar = new com.fancy.adsdk.lib.core.net._a(string);
        if (!TextUtils.isEmpty(str_a)) {
            _aVar._e = str_a;
            _aVar._d = "POST";
        }
        _aVar._g = timeoutMs;
        _aVar._h = _bVar;
        NetUtils._b.offer(_aVar);
    }
}
