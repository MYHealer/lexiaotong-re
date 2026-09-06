package com.meishu.sdk.platform.ks.splash;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.meishu.sdk.core.ad.splash.c;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSSplashAd extends c {
    private static final String TAG = "KSSplashAd";
    private KSSplashAdWrapper adWrapper;
    private boolean hasShown;
    private KsSplashScreenAd splashAD;
    private View view;

    public KSSplashAd(KSSplashAdWrapper kSSplashAdWrapper) {
        super(kSSplashAdWrapper, "KS");
        this.hasShown = false;
        this.view = null;
        this.adWrapper = kSSplashAdWrapper;
    }

    public d getApiAdListener() {
        return this.adWrapper.getLoaderListener();
    }

    public SdkAdInfo getSdkAdInfo() {
        return this.adWrapper.getSdkAdInfo();
    }

    public void setSplashAD(KsSplashScreenAd ksSplashScreenAd) {
        this.splashAD = ksSplashScreenAd;
    }

    @Override // com.meishu.sdk.core.ad.splash.c, com.meishu.sdk.core.ad.splash.ISplashAd
    public void showAd(ViewGroup viewGroup) {
        try {
            if (this.hasShown) {
                return;
            }
            super.showAd(viewGroup);
            final Context context = viewGroup.getContext();
            View view = this.splashAD.getView(context, new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.meishu.sdk.platform.ks.splash.KSSplashAd.1
                private boolean hasReportExposure = false;

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onAdClicked() {
                    try {
                        if (KSSplashAd.this.getSdkAdInfo() != null && !TextUtils.isEmpty(KSSplashAd.this.getSdkAdInfo().getClk())) {
                            LogUtil.d(KSSplashAd.TAG, "send onAdClicked");
                            z.a(context, f.a(KSSplashAd.this.getSdkAdInfo().getClk(), KSSplashAd.this), new i());
                            KSSplashAd.this.getSdkAdInfo().getMsLoadedTime();
                            KSSplashAd.this.adWrapper.getAdLoader().getPosId();
                        }
                        if (KSSplashAd.this.getInteractionListener() != null) {
                            KSSplashAd.this.getInteractionListener().onAdClicked();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onAdShowEnd() {
                    try {
                        LogUtil.d(KSSplashAd.TAG, "onAdShowEnd");
                        if (KSSplashAd.this.getApiAdListener() != null) {
                            KSSplashAd.this.getApiAdListener().onAdTimeOver(KSSplashAd.this);
                            KSSplashAd.this.getApiAdListener().onAdClosed();
                        }
                        if (KSSplashAd.this.getInteractionListener() != null) {
                            KSSplashAd.this.getInteractionListener().onAdClosed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onAdShowError(int i, String str) {
                    try {
                        LogUtil.e(KSSplashAd.TAG, "onNoAD, code: " + i + ", msg: " + str);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onAdShowStart() {
                    try {
                        LogUtil.d(KSSplashAd.TAG, "onAdShowStart");
                        if (this.hasReportExposure) {
                            return;
                        }
                        this.hasReportExposure = true;
                        h0.a(KSSplashAd.this.getSdkAdInfo(), KSSplashAd.this.view);
                        if (KSSplashAd.this.getApiAdListener() != null) {
                            KSSplashAd.this.getApiAdListener().onAdPresent(KSSplashAd.this);
                            KSSplashAd.this.getApiAdListener().onAdExposure();
                        }
                        if (KSSplashAd.this.getInteractionListener() != null) {
                            KSSplashAd.this.getInteractionListener().onAdExposure();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onDownloadTipsDialogCancel() {
                    if (KSSplashAd.this.downloadDialogListener != null) {
                        KSSplashAd.this.downloadDialogListener.onDownloadTipsDialogCancel();
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                    if (KSSplashAd.this.downloadDialogListener != null) {
                        KSSplashAd.this.downloadDialogListener.a();
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onDownloadTipsDialogShow() {
                    if (KSSplashAd.this.downloadDialogListener != null) {
                        KSSplashAd.this.downloadDialogListener.b();
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onSkippedAd() {
                    try {
                        LogUtil.d(KSSplashAd.TAG, "onSkippedAd");
                        if (KSSplashAd.this.getApiAdListener() != null) {
                            KSSplashAd.this.getApiAdListener().onAdSkip(KSSplashAd.this);
                            KSSplashAd.this.getApiAdListener().onAdClosed();
                        }
                        if (KSSplashAd.this.getInteractionListener() != null) {
                            KSSplashAd.this.getInteractionListener().onAdClosed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.view = view;
            if (view != null && !((Activity) context).isFinishing()) {
                viewGroup.removeAllViews();
                viewGroup.addView(this.view, -1, -1);
                o1.a(viewGroup, this.adWrapper.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
            }
            this.hasShown = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
