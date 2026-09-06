package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.PtgSDKConfig;
import com.fancy.adsdk.lib.provider.arb.ArbitraryManger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _od implements _ep {
    public final AtomicBoolean _a = new AtomicBoolean();

    @Override // com.fancy._ep
    public final void _a(Context context, _ck _ckVar) {
        _u _uVar_b;
        if (this._a.get()) {
            return;
        }
        this._a.set(true);
        if (_a9._a == 0 && (_uVar_b = _ia._b()) != null && _uVar_b._f) {
            _a9._a(context, _uVar_b);
        }
    }

    @Override // com.fancy._ep
    public final void _a(Context context, PtgSDKConfig ptgSDKConfig) {
        ArbitraryManger.identifyPlatform();
    }
}
