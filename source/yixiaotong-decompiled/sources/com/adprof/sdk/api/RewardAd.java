package com.adprof.sdk.api;

import android.app.Activity;
import android.util.Log;
import com.adprof.sdk.AdprofSdk;
import com.adprof.sdk.fn;
import com.adprof.sdk.h;
import com.adprof.sdk.i2;
import com.adprof.sdk.oh;
import com.adprof.sdk.pc;
import com.adprof.sdk.pk;
import com.adprof.sdk.q1;
import com.adprof.sdk.z1;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RewardAd extends InterstitialAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RewardAdListener f1056a;

    public RewardAd(AdRequest adRequest, RewardAdListener rewardAdListener) {
        super(adRequest, null);
        a(adRequest, rewardAdListener);
    }

    public void a(AdRequest adRequest, RewardAdListener rewardAdListener) {
        pk.a(String.format("RewardAd init: %s l: %s", adRequest, rewardAdListener));
        if (rewardAdListener != null) {
            this.f1056a = rewardAdListener;
        }
        pc pcVar = new pc(adRequest, null, rewardAdListener, 5);
        ((InterstitialAd) this).f74a = pcVar;
        ((h) this).f325a = pcVar;
    }

    @Override // com.adprof.sdk.api.InterstitialAd
    public void destroyAd() {
        super.destroyAd();
    }

    @Override // com.adprof.sdk.api.InterstitialAd
    public boolean loadAd() {
        try {
            pk.a("RewardAd loadAd");
            final AdError adErrorA = a();
            fn.a(new fn.b() { // from class: com.adprof.sdk.api.RewardAd.1
                @Override // com.adprof.sdk.fn.a
                public void callback(Exception exc) {
                    RewardAdListener rewardAdListener;
                    RewardAdListener rewardAdListener2;
                    AdError adError = adErrorA;
                    if (adError != null && (rewardAdListener2 = RewardAd.this.f1056a) != null) {
                        rewardAdListener2.onRewardAdLoadError(adError);
                    }
                    if (!RewardAd.this.isReady() || (rewardAdListener = RewardAd.this.f1056a) == null) {
                        return;
                    }
                    rewardAdListener.onRewardAdLoadSuccess();
                }
            });
            if (adErrorA != null) {
                return false;
            }
            if (isReady()) {
                return true;
            }
            q1.m710a().a(((h) this).f326a);
            ((h) this).f324a = i2.AdStatusLoading;
            pc pcVar = ((InterstitialAd) this).f74a;
            pcVar.getClass();
            z1.a().getClass();
            pcVar.a(SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
            return true;
        } catch (Exception e) {
            oh.b(e);
            pk.d("InterstitialAd loadAd = " + Log.getStackTraceString(e));
            return false;
        }
    }

    @Override // com.adprof.sdk.api.InterstitialAd
    public void showAd(Activity activity) {
        try {
            pk.a(String.format("RewardAd showAd: %s", activity));
            if (!AdprofSdk.getInstance().isInit()) {
                this.f1056a.onRewardAdShowError(AdError.ERROR_AD_NOT_INIT);
                return;
            }
            if (!isReady()) {
                this.f1056a.onRewardAdShowError(AdError.ERROR_AD_NOT_READY);
                return;
            }
            if (!q1.a(activity)) {
                activity = q1.a();
            }
            if (!q1.a(activity)) {
                this.f1056a.onRewardAdShowError(AdError.ERROR_AD_ACTIVITY_IS_NULL);
            } else {
                ((InterstitialAd) this).f74a.f(activity);
                ((h) this).f324a = i2.AdStatusPlaying;
            }
        } catch (Exception e) {
            oh.a(getClass().getSimpleName() + PPSLabelView.Code + e);
        }
    }
}
