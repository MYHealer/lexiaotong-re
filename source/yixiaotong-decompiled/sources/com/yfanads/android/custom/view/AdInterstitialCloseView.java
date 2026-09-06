package com.yfanads.android.custom.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.ads.R;
import com.yfanads.android.core.d;
import com.yfanads.android.lifecycle.LifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.template.InterModeTemplateData;
import com.yfanads.android.utils.CountDownTimerExt;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdInterstitialCloseView extends LinearLayout implements LifecycleListener {
    String TAG;
    private boolean closeEnable;
    private CountDownTimerExt countDownTimer;
    private final int countdownTime;
    private int currentCountDownTime;
    private final boolean isCountdownClose;
    private ICloseInterstitialAd mCloseClick;
    private final ImageView overAdClose;
    private final RelativeLayout overCloseArea;
    private final TextView overTevCountDown;

    public interface ICloseInterstitialAd {
        void closeInterstitialAd();
    }

    public AdInterstitialCloseView(Context context, InterModeTemplateData interModeTemplateData, ICloseInterstitialAd iCloseInterstitialAd) {
        super(context);
        this.TAG = "AdInterstitialCloseView";
        this.closeEnable = true;
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.inter_template_close, this);
        this.overCloseArea = (RelativeLayout) viewInflate.findViewById(R.id.ad_close_over_area);
        this.overTevCountDown = (TextView) viewInflate.findViewById(R.id.over_tev_countdown);
        this.overAdClose = (ImageView) viewInflate.findViewById(R.id.over_ad_close);
        this.mCloseClick = iCloseInterstitialAd;
        this.isCountdownClose = interModeTemplateData != null && interModeTemplateData.isShowCountdown();
        this.countdownTime = (interModeTemplateData == null || interModeTemplateData.getAutoCloseTime() <= 0) ? 5 : interModeTemplateData.getAutoCloseTime();
        updateClose(context, interModeTemplateData);
        initView();
    }

    private void initView() {
        this.overAdClose.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.view.AdInterstitialCloseView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1238x8350271c(view);
            }
        });
        this.overTevCountDown.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.view.AdInterstitialCloseView$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1239xa8e4301d(view);
            }
        });
    }

    private void pauseCD() {
        try {
            CountDownTimerExt countDownTimerExt = this.countDownTimer;
            if (countDownTimerExt != null && countDownTimerExt.isRunning()) {
                this.countDownTimer.pause();
            }
            YFLog.debug("pauseCD pause success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTevCountdown(String str) {
        this.overTevCountDown.setText(str);
    }

    private void startCD() {
        try {
            CountDownTimerExt countDownTimerExt = this.countDownTimer;
            if (countDownTimerExt != null && countDownTimerExt.isTimerPaused()) {
                this.countDownTimer.start();
            }
            YFLog.debug("startCD pause success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startInterstitialCountDown() {
        cancelCountDown("startCountDown");
        if (this.countdownTime <= 0 || this.countDownTimer != null) {
            return;
        }
        final String string = getContext().getString(R.string.close_tips);
        setTevCountdown(String.format(string, Integer.valueOf(this.countdownTime)));
        CountDownTimerExt countDownTimerExt = new CountDownTimerExt(((long) this.countdownTime) * 1000, 1000L) { // from class: com.yfanads.android.custom.view.AdInterstitialCloseView.1
            @Override // com.yfanads.android.utils.CountDownTimerExt
            public void onTimerFinish() {
                YFLog.debug(AdInterstitialCloseView.this.TAG + " onTimerFinish " + AdInterstitialCloseView.this.currentCountDownTime);
                if (AdInterstitialCloseView.this.currentCountDownTime != 0) {
                    AdInterstitialCloseView.this.cancelCountDown("onTimerFinish");
                    if (AdInterstitialCloseView.this.mCloseClick != null) {
                        AdInterstitialCloseView.this.mCloseClick.closeInterstitialAd();
                        AdInterstitialCloseView.this.mCloseClick = null;
                    }
                }
            }

            @Override // com.yfanads.android.utils.CountDownTimerExt
            public void onTimerTick(long j) {
                AdInterstitialCloseView.this.currentCountDownTime = (int) (j / 1000);
                YFLog.debug(AdInterstitialCloseView.this.TAG + " onTimerTick " + AdInterstitialCloseView.this.currentCountDownTime);
                AdInterstitialCloseView adInterstitialCloseView = AdInterstitialCloseView.this;
                adInterstitialCloseView.setTevCountdown(String.format(string, Integer.valueOf(adInterstitialCloseView.currentCountDownTime)));
                if (AdInterstitialCloseView.this.currentCountDownTime == 0) {
                    AdInterstitialCloseView.this.cancelCountDown("onTimerTick");
                    if (AdInterstitialCloseView.this.mCloseClick != null) {
                        AdInterstitialCloseView.this.mCloseClick.closeInterstitialAd();
                        AdInterstitialCloseView.this.mCloseClick = null;
                    }
                }
            }
        };
        this.countDownTimer = countDownTimerExt;
        countDownTimerExt.start();
    }

    private void updOverClose(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.overCloseArea.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = i;
    }

    private void updateClose(Context context, InterModeTemplateData interModeTemplateData) {
        if (interModeTemplateData == null) {
            return;
        }
        if (interModeTemplateData.isSupportClose()) {
            this.closeEnable = false;
            YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdInterstitialCloseView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1240xb86c575b();
                }
            }, interModeTemplateData.getCloseDelay());
        } else {
            this.closeEnable = true;
        }
        updOverClose(interModeTemplateData.getBottomHeight(context));
        if (!this.isCountdownClose) {
            this.overAdClose.setVisibility(0);
            this.overTevCountDown.setVisibility(8);
            this.overAdClose.setImageResource(interModeTemplateData.getBlackCloseRes());
            return;
        }
        this.overAdClose.setVisibility(8);
        this.overTevCountDown.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.overTevCountDown.getLayoutParams()).height = interModeTemplateData.getV3CloseSize(context);
        int[] v3ClosePadding = interModeTemplateData.getV3ClosePadding(context);
        this.overTevCountDown.setPadding(v3ClosePadding[0], v3ClosePadding[1], v3ClosePadding[2], v3ClosePadding[3]);
        this.overTevCountDown.setTextSize(interModeTemplateData.getV3AutoCloseSP());
        startInterstitialCountDown();
    }

    /* JADX INFO: renamed from: lambda$updateClose$0$com-yfanads-android-custom-view-AdInterstitialCloseView, reason: not valid java name */
    /* synthetic */ void m1240xb86c575b() {
        this.closeEnable = true;
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityPaused(Activity activity) {
        YFLog.debug("onActivityPaused " + activity);
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityResumed(Activity activity) {
        YFLog.debug("onActivityResumed " + activity);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        LifecycleObserver.getInstance().registerLifecycleListener(this);
        d.a(new StringBuilder(), this.TAG, " onAttachedToWindow");
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToBackground() {
        pauseCD();
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToForeground() {
        startCD();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cancelCountDown("onDetachedFromWindow");
        LifecycleObserver.getInstance().unRegisterLifecycleListener(this);
        d.a(new StringBuilder(), this.TAG, " onDetachedFromWindow");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelCountDown(String str) {
        if (this.countDownTimer != null) {
            YFLog.debug(this.TAG + " cancelCountDown " + str);
            this.countDownTimer.stop();
            this.countDownTimer = null;
        }
    }

    /* JADX INFO: renamed from: lambda$initView$1$com-yfanads-android-custom-view-AdInterstitialCloseView, reason: not valid java name */
    /* synthetic */ void m1238x8350271c(View view) {
        if (this.mCloseClick == null || !this.closeEnable) {
            return;
        }
        cancelCountDown("overAdClose");
        this.mCloseClick.closeInterstitialAd();
        this.mCloseClick = null;
    }

    /* JADX INFO: renamed from: lambda$initView$2$com-yfanads-android-custom-view-AdInterstitialCloseView, reason: not valid java name */
    /* synthetic */ void m1239xa8e4301d(View view) {
        if (this.mCloseClick == null || !this.closeEnable) {
            return;
        }
        cancelCountDown("overTevCountDown");
        this.mCloseClick.closeInterstitialAd();
        this.mCloseClick = null;
    }
}
