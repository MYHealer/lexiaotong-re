package com.fancy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.alipay.sdk.sys.a;
import com.cdo.oaps.ad.OapsKey;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.stub.StubApp;
import com.ubix.ssp.open.comm.AdActivity;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g4 implements _a5 {
    public static final CopyOnWriteArraySet<String> _h = new CopyOnWriteArraySet<>();
    public boolean _a;
    public boolean _b;
    public IntentFilter _d;
    public _a _e;
    public boolean _f;
    public boolean _c = true;
    public Handler _g = new Handler(Looper.getMainLooper());

    public class _a extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            int i;
            if (intent.getAction() == null || intent.getData() == null) {
                return;
            }
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            if (com.fancy.adsdk.lib.utils._a._a(AdActivity.INSTALL_ACTION).equals(intent.getAction())) {
                i = 1;
            } else {
                i = com.fancy.adsdk.lib.utils._a._a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVQTEFDRUQ=").equals(intent.getAction()) ? 2 : 0;
            }
            CopyOnWriteArraySet<String> copyOnWriteArraySet = _g4._h;
            if (copyOnWriteArraySet.contains(schemeSpecificPart)) {
                return;
            }
            copyOnWriteArraySet.add(schemeSpecificPart);
            _os _osVar = new _os(_n4._a);
            _osVar._c = "ain";
            _or _orVar_b = _osVar._b();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(OapsKey.KEY_PKG, schemeSpecificPart);
                jSONObject.put("type", i);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(a.k, (Object) null);
                _orVar_b._a.put("ain", jSONObject);
            } catch (Exception unused) {
            }
            _orVar_b._i(PtgAdSdk.config.getMediaId());
            String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
            if (TextUtil.isNotEmpty(str_a)) {
                NetUtils._a(str_a);
            }
        }
    }

    public static class _b {
        public static final _g4 _a = new _g4();
    }

    @Override // com.fancy._a5
    public final void _a() {
        this._c = true;
        _c();
    }

    @Override // com.fancy._a5
    public final void _b() {
        this._c = false;
        if (this._e == null || !this._b || this._a || !this._f) {
            return;
        }
        PtgAdSdk.getContext().unregisterReceiver(this._e);
        this._b = false;
    }

    public final void _c() {
        if (this._d == null) {
            IntentFilter intentFilter = new IntentFilter();
            this._d = intentFilter;
            intentFilter.addAction(com.fancy.adsdk.lib.utils._a._a(AdActivity.INSTALL_ACTION));
            this._d.addAction(com.fancy.adsdk.lib.utils._a._a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVQTEFDRUQ="));
            this._d.addDataScheme("package");
        }
        if (this._e == null) {
            this._e = new _a();
        }
        if ((this._a || this._c) && !this._b && this._f) {
            StubApp.getOrigApplicationContext(PtgAdSdk.getContext().getApplicationContext()).registerReceiver(this._e, this._d);
            this._b = true;
        }
    }
}
