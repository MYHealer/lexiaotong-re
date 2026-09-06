package com.ubixnow.network.ubix2;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.banner.UBiXBannerAdListener;
import com.ubix.ssp.open.banner.UBiXBannerManager;
import com.ubix.ssp.open.manager.UBiXAdManager;
import com.ubixnow.adtype.banner.api.UMNBannerParams;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UbixBannerAdapter extends UMNCustomBannerAdapter {
    private WeakReference<Context> OooO0O0;
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private final UBiXBannerManager OooO0OO = UBiXAdManager.createBannerAd();

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        this.OooO0OO.destroy();
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public View getView() {
        return this.OooO0OO.getBannerView();
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        try {
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(this.OooO00o, "isValid " + this.OooO0OO.isValid());
            }
            return this.OooO0OO.isValid();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return true;
        }
    }

    public void loadAd(o00O000 o00o000) {
        AdSize adSize;
        this.absUbixInfo.bannerAdapterHashCode = hashCode();
        UMNBannerParams uMNBannerParams = (UMNBannerParams) o00o000.OooO0o0;
        int i = uMNBannerParams.width;
        showLog(this.OooO00o, "---loadAd：mubixSlotId " + uMNBannerParams.slotId + " width: " + i);
        if (i > 0) {
            adSize = uMNBannerParams.height == 0 ? new AdSize(i, -2) : new AdSize(i, uMNBannerParams.height);
        } else {
            adSize = new AdSize(-1, -2);
        }
        this.OooO0OO.loadBannerAd(this.OooO0O0.get(), this.adsSlotid, adSize, new UBiXBannerAdListener() { // from class: com.ubixnow.network.ubix2.UbixBannerAdapter.2
            @Override // com.ubix.ssp.open.banner.UBiXBannerAdListener
            public void onAdClicked() {
                UbixBannerAdapter ubixBannerAdapter = UbixBannerAdapter.this;
                ubixBannerAdapter.showLog(ubixBannerAdapter.OooO00o, "onAdClicked");
                if (UbixBannerAdapter.this.eventListener != null) {
                    UbixBannerAdapter.this.eventListener.onAdClick(UbixBannerAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.banner.UBiXBannerAdListener
            public void onAdClosed() {
                UbixBannerAdapter ubixBannerAdapter = UbixBannerAdapter.this;
                ubixBannerAdapter.showLog(ubixBannerAdapter.OooO00o, "onAdClosed");
                try {
                    if (UbixBannerAdapter.this.OooO0OO.getBannerView() != null && UbixBannerAdapter.this.OooO0OO.getBannerView().getParent() != null) {
                        ((ViewGroup) UbixBannerAdapter.this.OooO0OO.getBannerView().getParent()).removeView(UbixBannerAdapter.this.OooO0OO.getBannerView());
                        UbixBannerAdapter.this.OooO0OO.destroy();
                    }
                    if (UbixBannerAdapter.this.eventListener != null) {
                        UbixBannerAdapter.this.eventListener.onAdDismiss(UbixBannerAdapter.this.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }

            @Override // com.ubix.ssp.open.banner.UBiXBannerAdListener
            public void onAdExposeFailed(AdError adError) {
                UbixBannerAdapter ubixBannerAdapter = UbixBannerAdapter.this;
                ubixBannerAdapter.showLog(ubixBannerAdapter.OooO00o, "onAdExposeFailed:" + adError.getErrorMessage());
                if (UbixBannerAdapter.this.eventListener != null) {
                    UbixBannerAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) UbixBannerAdapter.this.absUbixInfo));
                }
            }

            @Override // com.ubix.ssp.open.banner.UBiXBannerAdListener
            public void onAdExposed() {
                UbixBannerAdapter ubixBannerAdapter = UbixBannerAdapter.this;
                ubixBannerAdapter.showLog(ubixBannerAdapter.OooO00o, "onAdExposed");
                if (UbixBannerAdapter.this.eventListener != null) {
                    UbixBannerAdapter.this.eventListener.onAdShow(UbixBannerAdapter.this.absUbixInfo);
                }
            }

            @Override // com.ubix.ssp.open.banner.UBiXBannerAdListener
            public void onAdLoadFailed(AdError adError) {
                UbixBannerAdapter ubixBannerAdapter = UbixBannerAdapter.this;
                ubixBannerAdapter.showLog(ubixBannerAdapter.OooO00o, "onAdLoadFailed: code:" + adError.getErrorCode() + ",msg:" + adError.getErrorMessage());
                o00O00o0 o00o00o0 = UbixBannerAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, adError.getErrorCode() + "", adError.getErrorMessage()).setInfo((Object) UbixBannerAdapter.this.absUbixInfo));
                }
            }

            @Override // com.ubix.ssp.open.banner.UBiXBannerAdListener
            public void onAdLoadSucceed() {
                try {
                    UbixBannerAdapter ubixBannerAdapter = UbixBannerAdapter.this;
                    ubixBannerAdapter.showLog(ubixBannerAdapter.OooO00o, "onAdLoadSucceed");
                    UbixBannerAdapter ubixBannerAdapter2 = UbixBannerAdapter.this;
                    ubixBannerAdapter2.hasCallBack = true;
                    if (ubixBannerAdapter2.loadListener != null) {
                        if (ubixBannerAdapter2.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                            ubixBannerAdapter2.showLog(ubixBannerAdapter2.OooO00o, "price:" + UbixBannerAdapter.this.OooO0OO.getPrice());
                            UbixBannerAdapter ubixBannerAdapter3 = UbixBannerAdapter.this;
                            ubixBannerAdapter3.absUbixInfo.setBiddingEcpm((int) ubixBannerAdapter3.OooO0OO.getPrice());
                        }
                        UbixBannerAdapter.this.absUbixInfo.bannerAdapterHashCode = hashCode();
                        UbixBannerAdapter ubixBannerAdapter4 = UbixBannerAdapter.this;
                        ubixBannerAdapter4.absUbixInfo.material = UbixUtils.getMaterialInfo(ubixBannerAdapter4.OooO0OO);
                        UbixBannerAdapter.this.absUbixInfo.getBaseAdConfig().OooOOo0 = UbixUtils.getPR(UbixBannerAdapter.this.OooO0OO);
                        UbixBannerAdapter ubixBannerAdapter5 = UbixBannerAdapter.this;
                        ubixBannerAdapter5.loadListener.onAdCacheSuccess(ubixBannerAdapter5.absUbixInfo);
                    }
                } catch (Exception e) {
                    ooooO000.OooO00o(e);
                }
            }
        });
        this.OooO0OO.loadAd();
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void loadBannerAd(Context context, final o00O000 o00o000) {
        createADInfo(o00o000);
        this.OooO0O0 = new WeakReference<>(context);
        showLog(this.OooO00o, "adsSlotid " + this.adsSlotid);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(this.adsSlotid)) {
            Ubix2InitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.ubix2.UbixBannerAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = UbixBannerAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", th.getMessage()).setInfo((Object) UbixBannerAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    try {
                        UbixBannerAdapter.this.loadAd(o00o000);
                    } catch (Exception e) {
                        o00O00o0 o00o00o0 = UbixBannerAdapter.this.loadListener;
                        if (o00o00o0 != null) {
                            o00o00o0.onNoAdError(new ErrorInfo("500041", e.getMessage()).setInfo((Object) UbixBannerAdapter.this.absUbixInfo));
                        }
                    }
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            UBiXAdLossInfo failInfo = Ubix2BiddingUtils.getFailInfo(o00oo0oo);
            this.OooO0OO.lossNotice(failInfo);
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyLoss:" + failInfo.getInfo().toString());
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            this.OooO0OO.winNotice(Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
            if (ooooO000.OooO00o) {
                ooooO000.OooO0OO(this.OooO00o, "竞价回传_notifyWin:" + Ubix2BiddingUtils.getSecondPrice(o00oo0oo));
            }
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void show(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.addView(this.OooO0OO.getBannerView());
        }
    }
}
