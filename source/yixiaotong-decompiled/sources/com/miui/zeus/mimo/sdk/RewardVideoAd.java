package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.reward.RewardVideoAdImpl;
import com.miui.zeus.mimo.sdk.base.BaseAd;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.diagnosis.DiagnosisStep;
import com.miui.zeus.mimo.sdk.utils.MimoSdkInitHolder;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class RewardVideoAd extends BaseAd<RewardVideoAdImpl> {

    public interface RewardVideoDownloadListener extends r3 {
        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadCancel();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadFailed(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadFinished();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadPaused();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadProgressUpdated(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadStarted();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallFailed(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallStart();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallSuccess();
    }

    public interface RewardVideoInteractionListener {
        void onAdClick();

        void onAdDismissed();

        void onAdFailed(String str);

        void onAdPresent();

        void onPicAdEnd();

        void onReward();

        void onVideoComplete();

        void onVideoPause();

        void onVideoSkip();

        void onVideoStart();
    }

    public interface RewardVideoLoadListener {
        void onAdLoadFailed(int i, String str);

        void onAdLoadSuccess();

        void onAdRequestSuccess();
    }

    public RewardVideoAd() {
        this.mAdImpl = new RewardVideoAdImpl();
    }

    public void destroy() {
        ((RewardVideoAdImpl) this.mAdImpl).b();
    }

    public void loadAd(ADParams aDParams, RewardVideoLoadListener rewardVideoLoadListener) {
        ((RewardVideoAdImpl) this.mAdImpl).a(aDParams, rewardVideoLoadListener);
    }

    @Deprecated
    public void loadAd(String str, RewardVideoLoadListener rewardVideoLoadListener) {
        ((RewardVideoAdImpl) this.mAdImpl).a(new ADParams.Builder().setUpId(str).build(), rewardVideoLoadListener);
    }

    @Deprecated
    public void recycle() {
        ((RewardVideoAdImpl) this.mAdImpl).b();
    }

    public void setDownloadListener(RewardVideoDownloadListener rewardVideoDownloadListener) {
        ((RewardVideoAdImpl) this.mAdImpl).e = rewardVideoDownloadListener;
    }

    public void showAd(Activity activity, RewardVideoInteractionListener rewardVideoInteractionListener) {
        MimoAdError mimoAdError;
        m4 m4VarA;
        DiagnosisStep diagnosisStep;
        MimoAdError mimoAdError2;
        RewardVideoAdImpl rewardVideoAdImpl = (RewardVideoAdImpl) this.mAdImpl;
        rewardVideoAdImpl.getClass();
        try {
            String str = RewardVideoAdImpl.r;
            m.a(str, ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, Ascii.DC2, 83, 75, 69, 69, Ascii.DC2, 12, 9, Ascii.NAK, 17, Ascii.ETB, 0, 17, 83, 75, 85, 51, 8, 0, 3, 13, 112, 1}, "ef291e"));
            b.c();
            rewardVideoAdImpl.p = System.currentTimeMillis();
            rewardVideoAdImpl.o = rewardVideoInteractionListener;
            if (!MimoSdkInitHolder.isHasInit()) {
                mimoAdError2 = MimoAdError.ERROR_1001;
            } else {
                if (MimoSdkInitHolder.isInitSuccess()) {
                    if (!b.a(activity)) {
                        if (rewardVideoAdImpl.f5377a == null) {
                            mimoAdError = MimoAdError.ERROR_2003;
                            diagnosisStep = DiagnosisStep.KEY_EXCEPTION_WHEN_SHOW_AD;
                        } else {
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            long jAbs = Math.abs(jUptimeMillis - RewardVideoAdImpl.s);
                            MimoAdInfo mimoAdInfo = rewardVideoAdImpl.f5377a;
                            if (jAbs <= mimoAdInfo.R0) {
                                return;
                            }
                            if (mimoAdInfo.A() && b.g(rewardVideoAdImpl.f5377a.f()) && b.g(rewardVideoAdImpl.f5377a.B) && b.g(rewardVideoAdImpl.f5377a.p()) && b.g(rewardVideoAdImpl.f5377a.A)) {
                                mimoAdError = MimoAdError.ERROR_2009;
                                m4VarA = m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_SHOW_AD, mimoAdError);
                            } else {
                                if (!rewardVideoAdImpl.f5377a.A() || ((!rewardVideoAdImpl.f5377a.z() && !rewardVideoAdImpl.f5377a.t()) || !TextUtils.isEmpty(rewardVideoAdImpl.f5377a.A))) {
                                    RewardVideoAdImpl.s = jUptimeMillis;
                                    e4.a(rewardVideoAdImpl.q, rewardVideoAdImpl.f5377a);
                                    e4.a(rewardVideoAdImpl.q + ijiami_1011.s.s.s.d(new byte[]{58, 82, 67, 92, 88, 77}, "e75969"), rewardVideoAdImpl);
                                    e4.a(rewardVideoAdImpl.q + ijiami_1011.s.s.s.d(new byte[]{62, 87, 93, 70, 13, 90, 14, 5, 2}, "a321c6"), rewardVideoAdImpl.e);
                                    if (rewardVideoAdImpl.j != null) {
                                        e4.a(rewardVideoAdImpl.q + ijiami_1011.s.s.s.d(new byte[]{60, 3, 91, 17, 92, 5, 17}, "ca2e1d"), rewardVideoAdImpl.j);
                                    }
                                    rewardVideoAdImpl.a(activity, rewardVideoAdImpl.q, rewardVideoAdImpl.f5377a.A() || rewardVideoAdImpl.f5377a.y());
                                    activity.startActivity(rewardVideoAdImpl.n);
                                    ADParams aDParams = rewardVideoAdImpl.g;
                                    if (aDParams == null) {
                                        m.b(str, ijiami_1011.s.s.s.d(new byte[]{83, 10, 85, 84, 13, 91, Ascii.DC2, 13, Ascii.NAK, 35, 85, 54, 95, 12, 67, 19, 14, 117, 37, 52, 7, 16, 80, 8, 68, 67, 93, SignedBytes.MAX_POWER_OF_TWO, 67, 90, Ascii.DC4, 8, 10}, "7c43c4"));
                                        return;
                                    }
                                    String upId = aDParams.getUpId();
                                    b.a(TextUtils.isEmpty(upId) ? null : upId, (s3) null, ijiami_1011.s.s.s.d(new byte[]{119, 115, 38, 112, 126, 102, 50, 44, 41, 53, 110, 36, 113}, "56a909"), ijiami_1011.s.s.s.d(new byte[]{71, 1, 65, 4, 17, 2, 62, 5, 2}, "5d6ecf"), rewardVideoAdImpl.p, ijiami_1011.s.s.s.d(new byte[]{90, 92, 3, 11, 92, 102, Ascii.DC2, 12, 9, Ascii.NAK, 110, 4, 92}, "89db29"));
                                    return;
                                }
                                mimoAdError = MimoAdError.ERROR_2010;
                                m4VarA = m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_SHOW_AD, mimoAdError);
                            }
                        }
                        rewardVideoAdImpl.c(mimoAdError, m4VarA);
                        return;
                    }
                    mimoAdError = MimoAdError.ERROR_9002;
                    diagnosisStep = DiagnosisStep.KEY_EXCEPTION_WHEN_SHOW_AD;
                    m4VarA = m4.a(diagnosisStep, mimoAdError);
                    rewardVideoAdImpl.c(mimoAdError, m4VarA);
                    return;
                }
                mimoAdError2 = MimoAdError.ERROR_1002;
            }
            rewardVideoAdImpl.c(mimoAdError2, null);
        } catch (Exception e) {
            b.b(rewardVideoAdImpl.g.getUpId(), m4.a(DiagnosisStep.KEY_EXCEPTION_WHEN_CREATE_ACTIVITY, e));
            m.b(RewardVideoAdImpl.r, ijiami_1011.s.s.s.d(new byte[]{75, 13, 92, Ascii.DC4, 37, 87, 65, 1, Ascii.RS, 1, 84, Ascii.NAK, 76, 12, 92, 13, 68, 19, 91, 68}, "8e3cd3"), e);
        }
    }
}
