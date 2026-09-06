package com.ubixnow.network.kuaishou;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.constant.br;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.ubixnow.adtype.banner.api.UMNBannerParams;
import com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooO0o;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o00OO0OO;
import com.ubixnow.ooooo.oO0000O;
import com.ubixnow.ooooo.oOO00000;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class KsBannerAdapter extends UMNCustomBannerAdapter {
    private WeakReference<Context> OooO0O0;
    private KsBannerAd OooO0OO;
    private View OooO0Oo;
    private AdExposureFailedReason OooO0o0;
    private final String OooO00o = this.customTag + KsInitManager.getInstance().getName();
    private KsBannerAd.BannerAdInteractionListener OooO0o = new KsBannerAd.BannerAdInteractionListener() { // from class: com.ubixnow.network.kuaishou.KsBannerAdapter.1
        @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
        public void onAdClicked() {
            KsBannerAdapter ksBannerAdapter = KsBannerAdapter.this;
            ksBannerAdapter.showLog(ksBannerAdapter.OooO00o, "onAdClicked");
            if (KsBannerAdapter.this.eventListener != null) {
                KsBannerAdapter.this.eventListener.onAdClick(KsBannerAdapter.this.absUbixInfo);
            }
        }

        @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
        public void onAdClose() {
            KsBannerAdapter ksBannerAdapter = KsBannerAdapter.this;
            ksBannerAdapter.showLog(ksBannerAdapter.OooO00o, "onAdClose");
            if (KsBannerAdapter.this.eventListener != null) {
                KsBannerAdapter.this.eventListener.onAdDismiss(KsBannerAdapter.this.absUbixInfo);
            }
        }

        @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
        public void onAdShow() {
            KsBannerAdapter ksBannerAdapter = KsBannerAdapter.this;
            ksBannerAdapter.showLog(ksBannerAdapter.OooO00o, "onAdShow");
            if (KsBannerAdapter.this.eventListener != null) {
                KsBannerAdapter.this.eventListener.onAdShow(KsBannerAdapter.this.absUbixInfo);
            }
        }

        @Override // com.kwad.sdk.api.KsBannerAd.BannerAdInteractionListener
        public void onAdShowError(int i, String str) {
            KsBannerAdapter ksBannerAdapter = KsBannerAdapter.this;
            ksBannerAdapter.showLog(ksBannerAdapter.OooO00o, "onAdShowError");
            if (KsBannerAdapter.this.eventListener != null) {
                KsBannerAdapter.this.eventListener.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, i + "", str).setInfo((Object) KsBannerAdapter.this.absUbixInfo));
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(o00O000 o00o000) {
        this.absUbixInfo.bannerAdapterHashCode = hashCode();
        UMNBannerParams uMNBannerParams = (UMNBannerParams) o00o000.OooO0o0;
        showLog(this.OooO00o, "--------loadAd width: " + uMNBannerParams.width + PPSLabelView.Code + oOO00000.OooO0o(this.OooO0O0.get()));
        KsAdSDK.getLoadManager().loadBannerAd(new KsScene.Builder(KsInitManager.getKSLongValue(this.adsSlotid)).width(oO0000O.OooO00o(uMNBannerParams.width)).height(oO0000O.OooO00o(uMNBannerParams.height)).build(), new KsLoadManager.BannerAdListener() { // from class: com.ubixnow.network.kuaishou.KsBannerAdapter.3
            @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
            public void onBannerAdLoad(KsBannerAd ksBannerAd) {
                KsBannerAdapter ksBannerAdapter = KsBannerAdapter.this;
                ksBannerAdapter.showLog(ksBannerAdapter.OooO00o, "onBannerAdLoad: ");
                if (ksBannerAd == null) {
                    o00O00o0 o00o00o0 = KsBannerAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg).setInfo((Object) KsBannerAdapter.this.absUbixInfo));
                        return;
                    }
                    return;
                }
                KsBannerAdapter.this.OooO0OO = ksBannerAd;
                KsAdVideoPlayConfig ksAdVideoPlayConfigBuild = new KsAdVideoPlayConfig.Builder().build();
                ksAdVideoPlayConfigBuild.setVideoSoundEnable(!KsBannerAdapter.this.getVideoPlayMute());
                KsBannerAdapter ksBannerAdapter2 = KsBannerAdapter.this;
                ksBannerAdapter2.OooO0Oo = ksBannerAdapter2.OooO0OO.getView(BaseUtils.getContext(), KsBannerAdapter.this.OooO0o, ksAdVideoPlayConfigBuild);
                KsBannerAdapter ksBannerAdapter3 = KsBannerAdapter.this;
                if (ksBannerAdapter3.loadListener != null) {
                    if (ksBannerAdapter3.mBaseAdConfig.OooO00o.OooOO0O == 1) {
                        ksBannerAdapter3.showLog(ksBannerAdapter3.OooO00o, "price:" + KsBannerAdapter.this.OooO0OO.getECPM());
                        KsBannerAdapter ksBannerAdapter4 = KsBannerAdapter.this;
                        ksBannerAdapter4.absUbixInfo.setBiddingEcpm(ksBannerAdapter4.OooO0OO.getECPM());
                    }
                    KsBannerAdapter.this.absUbixInfo.bannerAdapterHashCode = hashCode();
                    KsBannerAdapter ksBannerAdapter5 = KsBannerAdapter.this;
                    ksBannerAdapter5.loadListener.onAdCacheSuccess(ksBannerAdapter5.absUbixInfo);
                }
            }

            @Override // com.kwad.sdk.api.KsLoadManager.BannerAdListener
            public void onError(int i, String str) {
                KsBannerAdapter ksBannerAdapter = KsBannerAdapter.this;
                ksBannerAdapter.showLog(ksBannerAdapter.OooO00o, "onError code:" + i + " msg:" + str);
                o00O00o0 o00o00o0 = KsBannerAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) KsBannerAdapter.this.absUbixInfo));
                }
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O
    public void destory() {
        showLog(this.OooO00o, "destroy");
        this.OooO0o = null;
        this.OooO0OO = null;
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public View getView() {
        return this.OooO0Oo;
    }

    @Override // com.ubixnow.ooooo.o00O
    public boolean isValid() {
        return (this.OooO0OO == null || this.OooO0Oo == null) ? false : true;
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void loadBannerAd(Context context, final o00O000 o00o000) {
        createADInfo(o00o000);
        this.OooO0O0 = new WeakReference<>(context);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            KsInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.kuaishou.KsBannerAdapter.2
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = KsBannerAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", th.getMessage()).setInfo((Object) KsBannerAdapter.this.absUbixInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    KsBannerAdapter.this.loadAd(o00o000);
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
    public void notifyClick() {
        try {
            KsBiddingUtils.notifyClick(this.adsSlotid, this.OooO0o0, this.OooO0OO);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyLoss(o00OO0OO o00oo0oo) {
        try {
            this.OooO0o0 = KsBiddingUtils.notifyLoss(this.adsSlotid, o00oo0oo, this.OooO0OO);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyShow() {
        try {
            KsBiddingUtils.notifyShow(this.adsSlotid, this.OooO0o0, this.OooO0OO);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    @Override // com.ubixnow.ooooo.o00OO000
    public void notifyWin(o00OO0OO o00oo0oo) {
        try {
            KsBiddingUtils.notifyWin(o00oo0oo, this.OooO0OO);
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    @Override // com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter
    public void show(ViewGroup viewGroup) {
        showLog(this.OooO00o, "prepare show");
        if (viewGroup != null && this.OooO0Oo != null) {
            showLog(this.OooO00o, br.b.V);
            viewGroup.addView(this.OooO0Oo, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        showLog(this.OooO00o, "showError");
        OooO0o oooO0o = this.eventListener;
        if (oooO0o != null) {
            oooO0o.onShowError(new ErrorInfo(oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg, oOO00O0.ubix_show_error, oOO00O0.ubix_show_error_msg).setInfo((Object) this.absUbixInfo));
        }
    }
}
