package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.PtgSDKConfig;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.utils.Logger;
import java.net.URLDecoder;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e9 implements _hw {
    public Error _a;
    public String _b;
    public final AtomicBoolean _c;

    public _e9() {
        com.fancy.adsdk.lib._a.C0371_a c0371_a = com.fancy.adsdk.lib._a._a;
        this._c = new AtomicBoolean(false);
        this._a = c0371_a;
        try {
            this._b = URLDecoder.decode("https%3A%2F%2Fmpcfg.fancydsp.com%2FinAppBidding%2Fv5%2Fcdn%3Fplatform%3D5", "UTF-8");
        } catch (Exception unused) {
        }
    }

    @Override // com.fancy._hw
    public final void _a(_hx _hxVar) {
        _b(_hxVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fancy._hw
    public final void _b(_hx _hxVar) {
        int iIntValue;
        if (this._c.get()) {
            return;
        }
        String policyUrl = TextUtils.isEmpty(this._b) ? PtgAdSdk.getConfig().getPolicyUrl() : this._b;
        if (TextUtils.isEmpty(policyUrl)) {
            Error error = this._a;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, "Policy url无效", (Object) null));
            }
            _hxVar._c("Policy url无效");
            return;
        }
        StringBuilder sb = new StringBuilder();
        try {
            PtgSDKConfig config = PtgAdSdk.getConfig();
            if (config != null) {
                String strTrim = config.getMediaId().trim();
                if (TextUtils.isEmpty(strTrim) || !TextUtils.isDigitsOnly(strTrim)) {
                    Logger.e("buildUrlWithParams MediaID is invalid");
                } else {
                    String keyToken = config.getKeyToken();
                    if (TextUtils.isEmpty(keyToken)) {
                        Logger.e("buildUrlWithParams keyToken is null");
                    } else {
                        _c7 _c7Var = _n4._a;
                        _c7Var.getClass();
                        String sdkVersionName = PtgAdSdk.getConfig().getSdkVersionName();
                        String str = _c7Var._r;
                        String str2 = _c7Var._g;
                        String str3 = _c7Var._i;
                        String str4 = _c7Var._t;
                        sb.append("&i=").append(com.fancy.adsdk.lib.utils._a._d(strTrim));
                        StringBuilder sbAppend = sb.append("&tk=");
                        if (keyToken == null) {
                            keyToken = "";
                        }
                        sbAppend.append(com.fancy.adsdk.lib.utils._a._d(keyToken));
                        StringBuilder sbAppend2 = sb.append("&sv=");
                        if (sdkVersionName == null) {
                            sdkVersionName = "";
                        }
                        sbAppend2.append(com.fancy.adsdk.lib.utils._a._d(sdkVersionName));
                        sb.append("&svc=").append(com.fancy.adsdk.lib.utils._a._d(PtgAdSdk.getConfig().getSdkVersionCode()));
                        sb.append("&avc=").append(com.fancy.adsdk.lib.utils._a._d(_c7Var._s));
                        StringBuilder sbAppend3 = sb.append("&av=");
                        if (str == null) {
                            str = "";
                        }
                        sbAppend3.append(com.fancy.adsdk.lib.utils._a._d(str));
                        StringBuilder sbAppend4 = sb.append("&md=");
                        if (str2 == null) {
                            str2 = "";
                        }
                        sbAppend4.append(com.fancy.adsdk.lib.utils._a._d(str2));
                        StringBuilder sbAppend5 = sb.append("&osv=");
                        if (str3 == null) {
                            str3 = "";
                        }
                        sbAppend5.append(com.fancy.adsdk.lib.utils._a._d(str3));
                        sb.append("&ts=").append(System.currentTimeMillis());
                        StringBuilder sbAppend6 = sb.append("&d=");
                        String str5 = _c7Var._d;
                        if (str5 == null) {
                            str5 = "";
                        }
                        sbAppend6.append(com.fancy.adsdk.lib.utils._a._d(str5));
                        sb.append("&b=").append(_c7Var._y);
                        sb.append("&w=").append(_c7Var._n);
                        sb.append("&h=").append(_c7Var._o);
                        sb.append("&n=").append(_gx._a(PtgAdSdk.getContext()));
                        StringBuilder sbAppend7 = sb.append("&mcc=");
                        if (str4 == null) {
                            str4 = "";
                        }
                        sbAppend7.append(com.fancy.adsdk.lib.utils._a._d(str4));
                        sb.append("&aa=").append(com.fancy.adsdk.lib.utils._a._d(com.fancy.adsdk.lib.utils._a._a()));
                        sb.append("&pb=").append(com.fancy.adsdk.lib.utils._a._d());
                        sb.append("&sp=").append(config.isSupport());
                        StringBuilder sbAppend8 = sb.append("&sh=");
                        Boolean supportHttp = PtgAdSdk.getConfig().getSupportHttp();
                        if (supportHttp != null) {
                            iIntValue = supportHttp.booleanValue();
                        } else {
                            if (com.fancy.adsdk.lib.utils._b._a == null) {
                                com.fancy.adsdk.lib.utils._b._a();
                            }
                            iIntValue = com.fancy.adsdk.lib.utils._b._a.intValue();
                        }
                        sbAppend8.append(iIntValue);
                        StringBuilder sbAppend9 = sb.append("&sg=");
                        String str6 = _c7Var._A;
                        if (str6 == null) {
                            str6 = "";
                        }
                        sbAppend9.append(com.fancy.adsdk.lib.utils._a._d(str6));
                        sb.append("&ch=").append(com.fancy.adsdk.lib.utils._a._d(config.getChannel() != null ? config.getChannel() : ""));
                        sb.append("&os=2");
                        policyUrl = policyUrl + sb.toString();
                    }
                }
            }
        } catch (Exception e) {
            Logger.e(_ie._a("buildUrlWithParams error: ").append(e.getMessage()).toString());
            policyUrl = policyUrl + sb.toString();
        }
        if (TextUtils.isEmpty(policyUrl)) {
            Error error2 = this._a;
            if (error2 != null) {
                error2.onError(new AdErrorImpl(10019, "Policy url参数拼接失败", (Object) null));
            }
            _hxVar._c("Policy url参数拼接失败");
            return;
        }
        this._c.set(true);
        _e8 _e8Var = new _e8(this, _hxVar, policyUrl);
        NetUtils._f _fVar = NetUtils._a;
        com.fancy.adsdk.lib.core.net._a _aVar = new com.fancy.adsdk.lib.core.net._a(policyUrl);
        _aVar._d = "GET";
        _aVar._h = _e8Var;
        NetUtils._b.offer(_aVar);
    }
}
