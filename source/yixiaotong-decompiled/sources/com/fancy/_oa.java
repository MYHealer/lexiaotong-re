package com.fancy;

import android.content.Context;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.PtgSDKConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _oa implements Runnable {
    public final /* synthetic */ Context _a;
    public final /* synthetic */ PtgSDKConfig _b;

    public _oa(Context context, PtgSDKConfig ptgSDKConfig) {
        this._a = context;
        this._b = ptgSDKConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ArrayList arrayList = _oc._a;
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_ep) it.next())._a(this._a, this._b);
            }
            _of _ofVar = _oc._b;
            if (_ofVar != null) {
                Context context = this._a;
                PtgSDKConfig ptgSDKConfig = this._b;
                try {
                    if (PtgAdSdk.getConfig().getSdkLogoId() == 0) {
                        String sdkLogoUrl = PtgAdSdk.getConfig().getSdkLogoUrl();
                        if (!TextUtils.isEmpty(sdkLogoUrl)) {
                            _ev._a(sdkLogoUrl, (_ig) null);
                        }
                    }
                } catch (Exception unused) {
                }
                _hp _hpVar = new _hp();
                _ofVar.getClass();
                _hpVar._a(context, ptgSDKConfig);
            }
        } catch (Exception unused2) {
        }
    }
}
