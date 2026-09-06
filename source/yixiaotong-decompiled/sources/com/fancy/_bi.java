package com.fancy;

import android.os.Handler;
import android.os.Looper;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.PtgInteractionAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bi extends _bg implements PtgAdNative.InteractionExpressAdListener {
    public PtgInteractionAd _h;
    public PtgAdNative.InteractionExpressAdListener _i;
    public Integer _j;

    public class _a implements Runnable {
        public _a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Logger.e("TrackingManager:", "doOnLoad--" + _bi.this._b());
                _bi _biVar = _bi.this;
                PtgInteractionAd ptgInteractionAd = _biVar._h;
                if (ptgInteractionAd != null) {
                    _biVar._i.onInteractionAdLoad(ptgInteractionAd);
                } else {
                    _biVar._i.onError(new AdErrorImpl(10001, "no ad in concurrent", (Object) null));
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public _bi(SortedSet sortedSet, _ci _ciVar, AtomicInteger atomicInteger, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        super(sortedSet, _ciVar, atomicInteger);
        this._i = interactionExpressAdListener;
    }

    @Override // com.fancy._bg
    public final void _a() {
        new Handler(Looper.getMainLooper()).post(new _a());
    }

    @Override // com.fancy._bg
    public final void _a(AdErrorImpl adErrorImpl) {
        Logger.e("TrackingManager:", _ie._a("onError--").append(_b()).append("--onError:").append(adErrorImpl._a).append("|message:").append(adErrorImpl._b).toString());
        this._i.onError(adErrorImpl);
    }

    @Override // com.fancy._bg
    public final boolean _f() {
        return this._j != null;
    }

    @Override // com.fancy._bg
    public final boolean _g() {
        return this._h != null;
    }

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        Logger.e("TrackingManager:", _ie._a("onError--").append(_b()).append("--onError:").append(adError.getErrorCode()).append("|message:").append(adError.getMessage()).toString());
        this._j = Integer.valueOf(adError.getErrorCode());
        adError.getMessage();
        this._a.add(this);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative.InteractionExpressAdListener
    public final void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd) {
        Logger.e("TrackingManager:", _ie._a("onInteractionAdLoad--").append(_b()).toString());
        this._h = ptgInteractionAd;
        this._a.add(this);
    }
}
