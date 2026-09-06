package com.fancy;

import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.mpsdk.provider.PtgApiProvider;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fx {
    public static void _a(AdError adError, AdSlot adSlot) {
        if (adError == null || adSlot == null || adError.getErrorCode() == 10001) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("code = ");
        stringBuffer.append(adError.getErrorCode()).append(",message = ");
        stringBuffer.append(adError.getMessage()).append(",domain = ");
        stringBuffer.append(adSlot._i()._c);
        String string = stringBuffer.toString();
        _os _osVar = new _os("", adSlot.getCodeId(), adSlot);
        _osVar._h = _osVar._h;
        _or _orVar = _osVar._t;
        int errorCode = adError.getErrorCode();
        String str = adSlot._i()._c;
        int i = 1;
        boolean z = errorCode == 10001;
        boolean z2 = errorCode == 10001;
        boolean z3 = !PtgApiProvider.providerName.equals(str) || errorCode == 10001;
        if (!z2) {
            if (z) {
                i = 2;
            } else {
                i = z3 ? 4 : 3;
            }
        }
        _orVar._f(i);
        _osVar._t._e(10001);
        _osVar._t._g(string);
        _osVar._t._m(adSlot.getPtgSlotID());
        _osVar._t._a(adSlot._j());
        _osVar._t._c(PtgAdSdk.getConfig().getAppVersionName());
        _osVar._t._b(PtgAdSdk.getConfig().getAppVersionCode());
        _osVar._t._l(PtgAdSdk.getConfig().getSdkVersionName());
        _osVar._t._k(PtgAdSdk.getConfig().getSdkVersionCode());
        _osVar._t._i(PtgAdSdk.getConfig().getMediaId());
        _osVar._t._j(PtgAdSdk.getConfig().getPolicyVersion());
        _osVar._t._c(adSlot._i()._S);
        _ou._a()._a(adSlot._i()._g(), "inAppErr", _osVar, null);
    }
}
