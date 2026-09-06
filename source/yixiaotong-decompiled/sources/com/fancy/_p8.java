package com.fancy;

import android.content.Context;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.fancy.adsdk.lib.utils.Logger;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _p8 {
    public static void _a(_f _fVar, AdSlot adSlot, String str) {
        _ci _ciVar_i;
        List<String> list;
        if (adSlot != null) {
            try {
                if (adSlot._t() != null && adSlot._i() != null && adSlot._i()._f() != null && (!adSlot._i()._f().isEmpty()) && (_ciVar_i = adSlot._i()) != null) {
                    _ou._a()._a(_ciVar_i._f(), "", adSlot._t(), null);
                }
            } catch (Exception unused) {
                return;
            }
        }
        if (_fVar != null && (list = _fVar._f) != null && !list.isEmpty()) {
            List<String> list2 = _fVar._f;
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(_fVar._r)) {
                map.put("User-Agent", _fVar._r);
                map.put("Referer", "");
            }
            NetUtils._a(list2, (HashMap<String, String>) map);
            Logger.d("PtgAdTrackManager", "AdTrackManager do clk ", _fVar._f);
        }
        ActionTrackManager actionTrackManager_a = ActionTrackManager._a();
        String str_a = _hr._a(_fVar);
        actionTrackManager_a.getClass();
        com.fancy.adsdk.lib.utils._d._b(new _c(actionTrackManager_a, str_a, str));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0091 A[Catch: all -> 0x009d, TryCatch #1 {all -> 0x009d, blocks: (B:20:0x0041, B:22:0x004f, B:23:0x0053, B:25:0x0059, B:27:0x005f, B:36:0x0078, B:38:0x0091, B:39:0x0093), top: B:54:0x0041 }] */
    public static boolean _a(Context context, _f _fVar, AdSlot adSlot) {
        String str;
        int i;
        String str_b;
        WXLaunchMiniProgram.Req req;
        if (!_lx._a(_lv._a("MU5hfFVpPEJpPFUiP0wiPVFpPFJoOQ9jIkRiM1FlfHZUE3FFFEBvJk5+Kw=="))) {
            str = "call program, media wechat not support";
        } else if (context == null || _fVar == null) {
            str = "call program, context or ad is null";
        } else {
            String str_a = _lv._a("MU5hfFVpPEJpPFUiP0w=");
            if (!_c9._a(context, str_a)) {
                str = "call program, wechat not installed";
            } else if (_fVar._b() == null) {
                str = "call program, app is null";
            } else {
                _pd wechatExt = _fVar._b().getWechatExt();
                if (wechatExt != null) {
                    IWXAPI iwxapi = null;
                    try {
                        String wechatAppId = PtgAdSdk.getConfig().getWechatAppId();
                        if (TextUtils.isEmpty(wechatAppId)) {
                            wechatAppId = wechatExt._a();
                        }
                        if (TextUtils.isEmpty(wechatAppId)) {
                            Logger.e("call program, weChatAppId is null");
                            return false;
                        }
                        String str_c = wechatExt._c();
                        String str_d = wechatExt._d();
                        int i_e = wechatExt._e();
                        if (i_e != 0) {
                            if (i_e == 1) {
                                i = 1;
                            } else {
                                i = 2;
                                if (i_e == 2) {
                                }
                            }
                            str_b = wechatExt._b();
                            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, wechatAppId);
                            req = new WXLaunchMiniProgram.Req();
                            req.userName = str_c;
                            req.path = str_d;
                            req.miniprogramType = i;
                            if (!TextUtils.isEmpty(str_b)) {
                                req.extData = str_b;
                            }
                            iwxapiCreateWXAPI.sendReq(req);
                            _a(_fVar, adSlot, str_a);
                            iwxapiCreateWXAPI.detach();
                            return true;
                        }
                        i = 0;
                        str_b = wechatExt._b();
                        IWXAPI iwxapiCreateWXAPI2 = WXAPIFactory.createWXAPI(context, wechatAppId);
                        req = new WXLaunchMiniProgram.Req();
                        req.userName = str_c;
                        req.path = str_d;
                        req.miniprogramType = i;
                        if (!TextUtils.isEmpty(str_b)) {
                            req.extData = str_b;
                        }
                        iwxapiCreateWXAPI2.sendReq(req);
                        _a(_fVar, adSlot, str_a);
                        iwxapiCreateWXAPI2.detach();
                        return true;
                    } catch (Throwable th) {
                        try {
                            Logger.e("call program, wechat error " + th.getMessage());
                            return false;
                        } finally {
                            if (0 != 0) {
                                iwxapi.detach();
                            }
                        }
                    }
                }
                str = "call program, wechatExt is null";
            }
        }
        Logger.e(str);
        return false;
    }
}
