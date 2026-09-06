package com.fancy;

import android.text.TextUtils;
import com.alipay.sdk.packet.e;
import com.baidu.mobads.sdk.internal.bn;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _m0 implements Runnable {
    public final /* synthetic */ long _a;
    public final /* synthetic */ _m1 _b;

    public _m0(_m1 _m1Var, long j) {
        this._b = _m1Var;
        this._a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String initTrackingUrl = PtgAdSdk.getConfig().getInitTrackingUrl();
        if (this._a < 0) {
            str = "TrackingManager: DoInitTracking fail, initialization is not complete";
        } else {
            if (!TextUtils.isEmpty(initTrackingUrl)) {
                if (!_ou._d.compareAndSet(false, true)) {
                    Logger.d("TrackingManager: DoInitTracking fail, reportUrl had report ");
                    return;
                }
                this._b.getClass();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(bn.g, _m1._b());
                    jSONObject.put(e.n, _m1._c());
                    jSONObject.put("app", _m1._a());
                } catch (JSONException unused) {
                }
                try {
                    jSONObject.put("initTime", this._a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                NetUtils._a(_m1._a(initTrackingUrl, "__DATA__", jSONObject.toString()));
                return;
            }
            str = "TrackingManager: DoInitTracking fail, reportUrl is null ";
        }
        Logger.d(str);
    }
}
