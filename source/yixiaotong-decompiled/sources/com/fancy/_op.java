package com.fancy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.mpsdk.activity.PtgLaunchActivity;
import com.fancy.mpsdk.activity.PtgWebActivity;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _op {
    public static final AtomicBoolean _a = new AtomicBoolean();

    public static void _a(Context context, _f _fVar, AdSlot adSlot) {
        int i;
        if (_fVar._Q) {
            try {
                AtomicBoolean atomicBoolean = _cl._a;
                atomicBoolean.set(false);
                _cl._b();
                if (_cl._b) {
                    int iCheckConfigApply = Doodle.checkConfigApply(PtgAdSdk.getContext());
                    atomicBoolean.set(iCheckConfigApply == 0);
                    i = iCheckConfigApply;
                } else {
                    i = -3;
                }
            } catch (Throwable unused) {
                _cl._a.set(false);
                i = -4;
            }
            _a(_fVar, adSlot, i);
        }
        if (!TextUtils.isEmpty(_fVar._d)) {
            int i2 = PtgLaunchActivity._d;
            try {
                String str_a = _k8._a(new _k6(_fVar, adSlot));
                Intent intent = new Intent(context, (Class<?>) PtgLaunchActivity.class);
                intent.setFlags(268435456);
                intent.putExtra("cache_id", str_a);
                context.startActivity(intent);
            } catch (Exception unused2) {
            }
        } else if (!TextUtils.isEmpty(_fVar._i)) {
            PtgWebActivity._a(context, _fVar);
        }
        _cl._a();
    }

    public static void _a(_f _fVar, AdSlot adSlot, int i) {
        _ci _ciVar_i;
        if (_fVar == null || !_fVar._R || adSlot == null || (_ciVar_i = adSlot._i()) == null || !_a.compareAndSet(false, true)) {
            return;
        }
        try {
            _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), adSlot);
            _osVar._c = "acs";
            _or _orVar_b = _osVar._b();
            _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
            _orVar_b._f(_ciVar_i._c);
            _orVar_b._e(_ciVar_i._e());
            _orVar_b._b(_ciVar_i._h);
            _orVar_b._a(_ciVar_i._i);
            _orVar_b._n(adSlot.getUserID());
            _orVar_b._m(adSlot.getPtgSlotID());
            _orVar_b._c(_ciVar_i._S);
            _orVar_b._d(_ciVar_i._e);
            try {
                synchronized (_orVar_b._a) {
                    try {
                        _orVar_b._a.put("applyResult", i);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (Exception e) {
                Error error = _orVar_b._b;
                if (error != null) {
                    error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
                }
            }
            String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
            if (TextUtil.isNotEmpty(str_a)) {
                NetUtils._a(str_a);
            }
        } catch (Exception unused) {
        }
    }
}
