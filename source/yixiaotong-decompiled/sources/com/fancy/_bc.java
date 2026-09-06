package com.fancy;

import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.sys.a;
import com.cdo.oaps.ad.OapsKey;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.utils.TextUtil;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bc implements Runnable {
    public final /* synthetic */ Intent _a;
    public final /* synthetic */ _bd _b;

    public _bc(_bd _bdVar, Intent intent) {
        this._b = _bdVar;
        this._a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _m6 _m6Var_a;
        _bd _bdVar = this._b;
        Intent intent = this._a;
        _bdVar.getClass();
        try {
            Uri data = intent.getData();
            if (data != null && (_m6Var_a = _bd._a(_bdVar._a, data)) != null) {
                CopyOnWriteArraySet<String> copyOnWriteArraySet = _g4._h;
                if (copyOnWriteArraySet.contains(_m6Var_a._a)) {
                    return;
                }
                copyOnWriteArraySet.add(_m6Var_a._a);
                _os _osVar = new _os(_n4._a);
                _osVar._c = "ain";
                _or _orVar_b = _osVar._b();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(OapsKey.KEY_PKG, _m6Var_a._a);
                    jSONObject.put("type", _m6Var_a._c);
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(a.k, _m6Var_a._b);
                    _orVar_b._a.put("ain", jSONObject);
                } catch (Exception unused) {
                }
                _orVar_b._i(PtgAdSdk.config.getMediaId());
                String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
                if (TextUtil.isNotEmpty(str_a)) {
                    NetUtils._a(str_a);
                }
            }
        } catch (Exception unused2) {
        }
    }
}
