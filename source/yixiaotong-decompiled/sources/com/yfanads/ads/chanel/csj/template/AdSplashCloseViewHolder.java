package com.yfanads.ads.chanel.csj.template;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.ads.R;
import com.yfanads.android.lifecycle.LifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.template.SplashTemplateData;
import com.yfanads.android.utils.CountDownTimerExt;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdSplashCloseViewHolder implements LifecycleListener {
    private String closeTips;
    private CountDownTimerExt countDownTimer;
    private final TextView tevCountdown;
    private final String TAG = "SplashCloseViewHolder";
    private int currentCountDownTime = 5;

    public AdSplashCloseViewHolder(ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.yf_splash_close_v1, (ViewGroup) null);
        viewInflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.tevCountdown = (TextView) viewInflate.findViewById(R.id.tev_countdown);
        viewGroup.addView(viewInflate);
        LifecycleObserver.getInstance().registerLifecycleListener(this);
    }

    public void updateClose(Context context, SplashTemplateData splashTemplateData, View.OnClickListener onClickListener) {
        this.currentCountDownTime = splashTemplateData.getAutoCloseTime(5);
        int closeLoc = splashTemplateData.getCloseLoc();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.tevCountdown.getLayoutParams();
        int iDip2px = ScreenUtil.dip2px(context, 15.0f);
        int iDip2px2 = ScreenUtil.dip2px(context, 35.0f);
        if (closeLoc == 2) {
            layoutParams.addRule(21);
            layoutParams.setMargins(0, iDip2px2, 0, 0);
            layoutParams.setMarginEnd(iDip2px);
        } else if (closeLoc == 6) {
            int iDip2px3 = ScreenUtil.dip2px(context, 55.0f);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, iDip2px3);
            layoutParams.setMarginStart(iDip2px);
        } else if (closeLoc == 7) {
            int iDip2px4 = ScreenUtil.dip2px(context, 55.0f);
            layoutParams.addRule(21);
            layoutParams.addRule(12);
            layoutParams.setMargins(0, 0, 0, iDip2px4);
            layoutParams.setMarginEnd(iDip2px);
        } else {
            layoutParams.addRule(20);
            layoutParams.setMargins(0, iDip2px2, 0, 0);
            layoutParams.setMarginStart(iDip2px);
        }
        layoutParams.height = splashTemplateData.getV3CloseSize(context);
        int[] v3ClosePadding = splashTemplateData.getV3ClosePadding(context);
        this.tevCountdown.setPadding(v3ClosePadding[0], v3ClosePadding[1], v3ClosePadding[2], v3ClosePadding[3]);
        this.tevCountdown.setTextSize(splashTemplateData.getV3AutoCloseSP());
        int autoCloseTime = splashTemplateData.getAutoCloseTime(5);
        this.closeTips = context.getString(R.string.yf_skip_tips);
        this.tevCountdown.setText(context.getString(R.string.yf_skip_tips, Integer.valueOf(autoCloseTime)));
        startCountDown(context, this.currentCountDownTime, onClickListener);
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        TextView textView = this.tevCountdown;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTevCountdown(String str) {
        this.tevCountdown.setText(str);
    }

    private void startCountDown(Context context, long j, final View.OnClickListener onClickListener) {
        cancelCountDown();
        if (j > 0 && this.countDownTimer == null) {
            final String string = TextUtils.isEmpty(this.closeTips) ? context.getString(R.string.jump_tip) : this.closeTips;
            setTevCountdown(String.format(string, Long.valueOf(j)));
            CountDownTimerExt countDownTimerExt = new CountDownTimerExt((j + 1) * 1000, 1000L) { // from class: com.yfanads.ads.chanel.csj.template.AdSplashCloseViewHolder.1
                @Override // com.yfanads.android.utils.CountDownTimerExt
                public void onTimerFinish() {
                }

                @Override // com.yfanads.android.utils.CountDownTimerExt
                public void onTimerTick(long j2) {
                    AdSplashCloseViewHolder.this.currentCountDownTime = (int) (j2 / 1000);
                    AdSplashCloseViewHolder adSplashCloseViewHolder = AdSplashCloseViewHolder.this;
                    adSplashCloseViewHolder.setTevCountdown(String.format(string, Integer.valueOf(adSplashCloseViewHolder.currentCountDownTime)));
                    if (AdSplashCloseViewHolder.this.currentCountDownTime == 0) {
                        AdSplashCloseViewHolder.this.cancelCountDown();
                        onClickListener.onClick(null);
                    }
                }
            };
            this.countDownTimer = countDownTimerExt;
            countDownTimerExt.start();
            return;
        }
        cancelCountDown();
        onClickListener.onClick(null);
    }

    public void destroy() {
        LifecycleObserver.getInstance().unRegisterLifecycleListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelCountDown() {
        CountDownTimerExt countDownTimerExt = this.countDownTimer;
        if (countDownTimerExt != null) {
            countDownTimerExt.stop();
            this.countDownTimer = null;
        }
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityCreated(Activity activity, Bundle bundle) {
        YFLog.debug("SplashCloseViewHolder onActivityCreated");
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityResumed(Activity activity) {
        YFLog.debug("SplashCloseViewHolder onActivityResumed");
        reStart("onActivityResumed");
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityPaused(Activity activity) {
        YFLog.debug("SplashCloseViewHolder onActivityPaused");
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityDestroyed(Activity activity) {
        YFLog.debug("SplashCloseViewHolder onActivityDestroyed");
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToForeground() {
        reStart("onBackToForeground");
    }

    private void reStart(String str) {
        try {
            CountDownTimerExt countDownTimerExt = this.countDownTimer;
            if (countDownTimerExt == null || !countDownTimerExt.isTimerPaused()) {
                return;
            }
            YFLog.debug("SplashCloseViewHolder " + str + " countDownTimer start");
            this.countDownTimer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToBackground() {
        YFLog.debug("SplashCloseViewHolder onBackToBackground");
        pauseTimer("onBackToBackground");
    }

    public void pauseTimer(String str) {
        try {
            CountDownTimerExt countDownTimerExt = this.countDownTimer;
            if (countDownTimerExt == null || !countDownTimerExt.isRunning()) {
                return;
            }
            YFLog.debug("SplashCloseViewHolder " + str + " countDownTimer pause");
            this.countDownTimer.pause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
