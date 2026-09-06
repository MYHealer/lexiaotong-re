package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.interf.PtgAd;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _i6 implements PtgAdNative {
    public final PtgAdNative _a;
    public final String _b;

    public class _a implements PtgAdNative.NativeExpressAdListener {
        public final /* synthetic */ PtgAdNative.NativeExpressAdListener _a;
        public final /* synthetic */ AdSlot _b;
        public final /* synthetic */ Context _c;

        public _a(PtgAdNative.NativeExpressAdListener nativeExpressAdListener, AdSlot adSlot, Context context) {
            this._a = nativeExpressAdListener;
            this._b = adSlot;
            this._c = context;
        }

        @Override // com.fancy.adsdk.lib.interf.Error
        public final void onError(AdError adError) {
            this._a.onError(adError);
        }

        @Override // com.fancy.adsdk.lib.provider.PtgAdNative.NativeExpressAdListener
        public final void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd) {
            Collection<PtgAd> collection_c;
            if (ptgNativeExpressAd == null) {
                _c4._a(10001, "no ad", null, this._a);
                return;
            }
            this._a.onNativeExpressAdLoad(ptgNativeExpressAd);
            ArrayList<PtgAd> arrayList = new ArrayList();
            if ((ptgNativeExpressAd instanceof _b2) && (collection_c = ((_b2) ptgNativeExpressAd)._c()) != null) {
                for (PtgAd ptgAd : collection_c) {
                    if (ptgAd instanceof PtgNativeExpressAd) {
                        arrayList.add((PtgNativeExpressAd) ptgAd);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            String str = this._b._i()._c;
            _id _idVar = _id._c;
            Context context = this._c;
            AdSlot adSlot = this._b;
            synchronized (_idVar._b) {
                List<_i7> list_a = _idVar._a(context, str, adSlot);
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (PtgAd ptgAd2 : arrayList) {
                    list_a.add(new _i7(ptgAd2, adSlot, ptgAd2 instanceof _b2 ? (_b2) ptgAd2 : null, adSlot._i()._o + jCurrentTimeMillis));
                }
            }
        }
    }

    public _i6(String str, com.fancy.adsdk.lib.provider._b _bVar) {
        this._b = str;
        this._a = _bVar;
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        return "";
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final String getName() {
        return this._a.getName();
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void init(Context context) {
        this._a.init(context);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this._a.loadBannerExpressAd(context, adSlot, nativeExpressAdListener);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        this._a.loadDrawExpressAd(context, adSlot, nativeExpressAdListener);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        this._a.loadInteractionExpressAd(context, adSlot, interactionExpressAdListener);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        _i7 _i7VarRemove;
        _id _idVar = _id._c;
        String str = this._b;
        synchronized (_idVar._b) {
            List<_i7> list_a = _idVar._a(context, str, adSlot);
            _i7VarRemove = !list_a.isEmpty() ? list_a.remove(0) : null;
        }
        if (_i7VarRemove != null) {
            PtgAd ptgAd = _i7VarRemove._a;
            if (ptgAd instanceof PtgNativeExpressAd) {
                PtgNativeExpressAd ptgNativeExpressAd = (PtgNativeExpressAd) ptgAd;
                boolean z = ptgNativeExpressAd instanceof _b2;
                if (z) {
                    ((_b2) ptgNativeExpressAd)._a();
                }
                nativeExpressAdListener.onNativeExpressAdLoad((PtgNativeExpressAd) _i7VarRemove._a);
                if (z) {
                    ((_b2) ptgNativeExpressAd)._b();
                }
                Logger.i("loadNativeExpressAd from cache");
                return;
            }
        }
        Logger.i("loadNativeExpressAd from network");
        int i = adSlot._i()._n;
        if (i > 1) {
            adSlot.setAdCount(i);
        }
        this._a.loadNativeExpressAd(context, adSlot, new _a(nativeExpressAdListener, adSlot, context));
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        this._a.loadRewardVideoAd(context, adSlot, rewardVideoAdListener);
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        this._a.loadSplashAd(context, adSlot, splashAdListener);
    }
}
