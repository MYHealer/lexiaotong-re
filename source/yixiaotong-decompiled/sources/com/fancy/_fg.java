package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.mpsdk.activity.PtgInteractionPortraitActivity;
import com.fancy.mpsdk.provider.PtgApiProvider;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fg {
    public static _fg _g;
    public final ConcurrentHashMap<String, _fi> _a = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, _f> _b = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, AdSlot> _c = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, PtgInteractionAd.AdInteractionListener> _d = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, PtgVideoAdListener> _e = new ConcurrentHashMap<>();
    public final ConcurrentHashMap<String, PtgInteractionPortraitActivity._d> _f = new ConcurrentHashMap<>();

    public static _fg _a() {
        if (_g == null) {
            synchronized (_fg.class) {
                if (_g == null) {
                    _g = new _fg();
                }
            }
        }
        return _g;
    }

    public final void _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this._a.remove(str);
        this._b.remove(str);
        this._c.remove(str);
        this._d.remove(str);
        this._e.remove(str);
        this._f.remove(str);
    }

    public final void _a(String str, String str2) {
        PtgInteractionAd.AdInteractionListener adInteractionListener;
        if (TextUtils.isEmpty(str) || (adInteractionListener = this._d.get(str)) == null) {
            return;
        }
        AdErrorImpl adErrorImpl = new AdErrorImpl();
        adErrorImpl._c = PtgApiProvider.providerName;
        adErrorImpl._d = PtgErrorCode.SDK_RENDER_ERROR;
        adErrorImpl._e = str2;
        adErrorImpl._a = PtgErrorCode.SDK_RENDER_ERROR;
        adErrorImpl._b = PtgErrorCode.SDK_RENDER_ERROR_1;
        adInteractionListener.onRenderError(adErrorImpl);
    }
}
