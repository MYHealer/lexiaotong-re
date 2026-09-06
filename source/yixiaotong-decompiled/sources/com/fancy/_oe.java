package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.PtgSDKConfig;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _oe implements _ep {
    @Override // com.fancy._ep
    public final void _a(Context context, _ck _ckVar) {
        _ej _ejVar = _du._a;
        if (_ejVar == null) {
            return;
        }
        _ejVar._b();
    }

    @Override // com.fancy._ep
    public final void _a(Context context, PtgSDKConfig ptgSDKConfig) {
        Random random = com.fancy.adsdk.lib.utils._a._a;
        if (!ScreenUtils.GUBED) {
            _ca._f();
            if (_ca._g) {
                return;
            }
            _ca._f();
            if (_ca._h) {
                return;
            }
            _ca._f();
            if (_ca._i) {
                return;
            }
        }
        _ej _ejVar = _du._a;
        if (_ejVar == null) {
            return;
        }
        _ejVar._a();
    }
}
