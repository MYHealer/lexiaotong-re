package com.meishu.sdk.platform.gdt.splash;

import android.text.TextUtils;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.comm.util.AdError;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTSplashADListenerImpl {
    private static final String TAG = "GDTSplashADListenerImpl";
    private boolean isAdClicked;
    private boolean isAdLoaded;
    private long leftMilliseconds;
    private d splashADListener;
    private GDTSplashAd splashAd;
    private GDTSplashAdWrapper splashAdWrapper;

    public GDTSplashADListenerImpl(GDTSplashAdWrapper gDTSplashAdWrapper, d dVar, GDTSplashAd gDTSplashAd) {
        this.splashAdWrapper = gDTSplashAdWrapper;
        this.splashADListener = dVar;
        this.splashAd = gDTSplashAd;
    }

    public Object createListenerProxy() {
        Class<?> cls;
        try {
            cls = Class.forName("com.qq.e.ads.splash.SplashADListener");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            try {
                cls = Class.forName("com.qq.e.ads.splash.SplashADZoomOutListener");
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashADListenerImpl.1
            /* JADX WARN: Code duplicated, block: B:29:0x005d  */
            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object[] objArr) {
                try {
                    switch (method.getName()) {
                        case "onADClicked":
                            GDTSplashADListenerImpl.this.onADClicked();
                            return null;
                        case "onADExposure":
                            GDTSplashADListenerImpl.this.onADExposure();
                            return null;
                        case "onADLoaded":
                            GDTSplashADListenerImpl.this.onADLoaded(((Long) objArr[0]).longValue());
                            return null;
                        case "onADTick":
                            GDTSplashADListenerImpl.this.onADTick(((Long) objArr[0]).longValue());
                            return null;
                        case "onADDismissed":
                            GDTSplashADListenerImpl.this.onADDismissed();
                            return null;
                        case "onNoAD":
                            GDTSplashADListenerImpl.this.onNoAD((AdError) objArr[0]);
                            return null;
                        case "onADPresent":
                            GDTSplashADListenerImpl.this.onADPresent();
                            return null;
                        case "isSupportZoomOut":
                            return Boolean.FALSE;
                        default:
                            return null;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    return null;
                }
            }
        });
    }

    public void onADExposure() {
        try {
            LogUtil.d(TAG, "send onADExposure");
            h0.a(this.splashAdWrapper.getSdkAdInfo(), this.splashAdWrapper.getAdLoader().getAdContainer());
            d dVar = this.splashADListener;
            if (dVar != null) {
                dVar.onAdExposure();
            }
            GDTSplashAd gDTSplashAd = this.splashAd;
            if (gDTSplashAd == null || gDTSplashAd.getInteractionListener() == null) {
                return;
            }
            this.splashAd.getInteractionListener().onAdExposure();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onADLoaded(long j) {
        LogUtil.d(TAG, "load GDT  succ------------------------");
        try {
            if (this.splashADListener != null) {
                if (this.splashAdWrapper.getSdkAdInfo() != null) {
                    this.splashAdWrapper.getSdkAdInfo().setEcpm(String.valueOf(this.splashAd.getSplashAd().getECPM()));
                }
                this.splashADListener.onAdLoaded(this.splashAd);
                this.splashADListener.onAdReady(this.splashAd);
                this.isAdLoaded = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onNoAD(AdError adError) {
        try {
            LogUtil.e(TAG, "onNoAD, code: " + adError.getErrorCode() + ", msg: " + adError.getErrorMsg());
            if (this.isAdLoaded) {
                d dVar = this.splashADListener;
                if (dVar != null) {
                    dVar.onAdRenderFail(adError.getErrorMsg(), adError.getErrorCode());
                }
            } else {
                new GDTPlatformError(adError, this.splashAdWrapper.getSdkAdInfo()).post(this.splashADListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onADClicked() {
        try {
            this.isAdClicked = true;
            if (this.splashAdWrapper.getSdkAdInfo() != null && !TextUtils.isEmpty(this.splashAdWrapper.getSdkAdInfo().getClk())) {
                LogUtil.d(TAG, "send onADClicked");
                z.a(this.splashAdWrapper.getContext(), f.a(this.splashAdWrapper.getSdkAdInfo().getClk(), this.splashAd), new i());
                this.splashAdWrapper.getSdkAdInfo().getMsLoadedTime();
                this.splashAdWrapper.getAdLoader().getPosId();
            }
            GDTSplashAd gDTSplashAd = this.splashAd;
            if (gDTSplashAd == null || gDTSplashAd.getInteractionListener() == null) {
                return;
            }
            this.splashAd.getInteractionListener().onAdClicked();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onADPresent() {
        d dVar = this.splashADListener;
        if (dVar != null) {
            dVar.onAdPresent(this.splashAd);
        }
    }

    public void onADDismissed() {
        try {
            d dVar = this.splashADListener;
            if (dVar != null) {
                if (!this.isAdClicked) {
                    if (this.leftMilliseconds < 800) {
                        dVar.onAdTimeOver(this.splashAd);
                    } else {
                        dVar.onAdSkip(this.splashAd);
                    }
                }
                this.splashADListener.onAdClosed();
            }
            GDTSplashAd gDTSplashAd = this.splashAd;
            if (gDTSplashAd == null || gDTSplashAd.getInteractionListener() == null) {
                return;
            }
            this.splashAd.getInteractionListener().onAdClosed();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onADTick(long j) {
        try {
            this.leftMilliseconds = j;
            d dVar = this.splashADListener;
            if (dVar != null) {
                dVar.onAdTick(j);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
