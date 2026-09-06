package com.fancy.mpsdk.provider;

import android.content.Context;
import com.fancy._c4;
import com.fancy._is;
import com.fancy._it;
import com.fancy._k2;
import com.fancy._k3;
import com.fancy._kb;
import com.fancy._kc;
import com.fancy._kl;
import com.fancy._km;
import com.fancy._kw;
import com.fancy._kx;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.PtgAdProxy;
import com.stub.StubApp;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgApiProvider implements PtgAdNative {
    public static final String providerName = "ptgapi";
    private final String TAG = "PtgApiProvider";
    private AtomicBoolean mHasInit = new AtomicBoolean();

    private void checkInit() {
        if (this.mHasInit.get()) {
            return;
        }
        init(PtgAdSdk.getContext());
    }

    private boolean checkInitConditions(Error error) {
        if (PtgAdSdk.getContext() != null) {
            return true;
        }
        if (error == null) {
            return false;
        }
        Logger.d("PtgApiProvider", "checkInitConditions context unInitialize");
        error.onError(new AdErrorImpl(10007, "context unInitialize", (Object) null));
        return false;
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public String getBiddingToken(AdSlot adSlot, int i) {
        return "";
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public String getName() {
        return providerName;
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public void init(Context context) {
        if (this.mHasInit.compareAndSet(false, true)) {
            PtgAdProxy.initialize(context);
            Logger.d("PtgApiProvider", "init PtgApiProvider");
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (checkInitConditions(nativeExpressAdListener)) {
            checkInit();
            PtgAdProxy.getBannerAd(context, adSlot, new _is(new _it(), nativeExpressAdListener, adSlot, context));
        } else {
            Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
            if (nativeExpressAdListener != null) {
                _c4._a(10007, "PtgApi 初始化条件失败", null, nativeExpressAdListener);
            }
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (checkInitConditions(nativeExpressAdListener)) {
            checkInit();
            if (nativeExpressAdListener != null) {
                _c4._a(PtgErrorCode.SDK_NOT_SUPPORT, "Ptgapi does not support DrawFeedAd ", null, nativeExpressAdListener);
                return;
            }
            return;
        }
        Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
        if (nativeExpressAdListener != null) {
            _c4._a(10007, "PtgApi 初始化条件失败", null, nativeExpressAdListener);
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        if (checkInitConditions(interactionExpressAdListener)) {
            checkInit();
            _k3 _k3Var = new _k3();
            Logger.d("PtgInteractionAdLoader", "loadInteractionAd start loading...");
            PtgAdProxy.getInteractionAd(context, adSlot, new _k2(_k3Var, interactionExpressAdListener, adSlot));
            return;
        }
        Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
        if (interactionExpressAdListener != null) {
            interactionExpressAdListener.onError(new AdErrorImpl(10007, "PtgApi 初始化条件失败", (Object) null));
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (checkInitConditions(nativeExpressAdListener)) {
            checkInit();
            PtgAdProxy.getFeedAd(context, adSlot, new _kb(new _kc(), nativeExpressAdListener, adSlot, context));
        } else {
            Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
            if (nativeExpressAdListener != null) {
                _c4._a(10007, "PtgApi 初始化条件失败", null, nativeExpressAdListener);
            }
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (checkInitConditions(rewardVideoAdListener)) {
            checkInit();
            PtgAdProxy.getRewardVideoAd(context, adSlot, new _kl(new _km(), rewardVideoAdListener, adSlot, context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : null));
        } else {
            Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
            if (rewardVideoAdListener != null) {
                rewardVideoAdListener.onError(new AdErrorImpl(10007, "PtgApi 初始化条件失败", (Object) null));
            }
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        if (!checkInitConditions(splashAdListener)) {
            Logger.d("PtgApiProvider", "PtgApi 初始化条件失败");
            if (splashAdListener != null) {
                splashAdListener.onError(new AdErrorImpl(10007, "PtgApi 初始化条件失败", (Object) null));
                return;
            }
            return;
        }
        checkInit();
        _kx _kxVar = new _kx();
        if (context != null) {
            PtgAdProxy.getSplashAd(context, adSlot, new _kw(_kxVar, splashAdListener, adSlot, context));
        } else if (splashAdListener != null) {
            splashAdListener.onError(new AdErrorImpl(10007, "Context unavailable", (Object) null));
        }
    }
}
