package com.yfanads.android.custom;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.yfanads.ads.R;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.d;
import com.yfanads.android.core.e;
import com.yfanads.android.core.h;
import com.yfanads.android.core.k;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.custom.receiver.OrientationBroadcastReceiver;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.lifecycle.BFLifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.ReflectionUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class SplashCustomAdapter extends k implements BFLifecycleListener {
    private boolean isLifecycleRegistered;
    public YFSplashSetting mSplashSetting;
    private OrientationBroadcastReceiver receiver;
    private CountDownTimer showCloseTimer;
    protected int showTime;
    private String tips;

    public SplashCustomAdapter(YFSplashSetting yFSplashSetting) {
        super(yFSplashSetting);
        this.isLifecycleRegistered = false;
        this.mSplashSetting = yFSplashSetting;
    }

    private void closeAdsDelay() {
        Util.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.SplashCustomAdapter$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1232x2e9d5fa5();
            }
        }, 200L);
    }

    private boolean needRegisterReceiver(Activity activity) {
        return YFAdsPhone.getInstance().isTablet() && this.receiver == null && ReflectionUtils.checkActivityConfigChangesUsingReflection(activity);
    }

    public void complianceView(AdBaseViewHolder adBaseViewHolder, final DownloadAppInfo downloadAppInfo) {
        adBaseViewHolder.complianceContent.setVisibility(0);
        String str = String.format(getContext().getString(R.string.yf_compliance_content), downloadAppInfo.appName, downloadAppInfo.versionCode, downloadAppInfo.developerName);
        SpannableString spannableString = new SpannableString(str);
        String string = getContext().getString(R.string.yf_function);
        int iIndexOf = str.indexOf(string);
        String string2 = getContext().getString(R.string.yf_permission);
        int iIndexOf2 = str.indexOf(string2);
        String string3 = getContext().getString(R.string.yf_privacy);
        int iIndexOf3 = str.indexOf(string3);
        int length = spannableString.length();
        YFLog.debug(this.tag + " complianceView index = " + iIndexOf + " , " + iIndexOf2 + " , " + iIndexOf3 + " , maxLength = " + length);
        if (isInMaxLength(iIndexOf3, string.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.SplashCustomAdapter.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), SplashCustomAdapter.this.tag, " function onClick ");
                    Util.openLink(SplashCustomAdapter.this.getContext(), downloadAppInfo.functionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf, string.length() + iIndexOf, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf, string.length() + iIndexOf, 34);
        }
        if (isInMaxLength(iIndexOf2, string2.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.SplashCustomAdapter.3
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), SplashCustomAdapter.this.tag, " permission onClick ");
                    Util.openLink(SplashCustomAdapter.this.getContext(), downloadAppInfo.appPermissionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf2, string2.length() + iIndexOf2, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf2, string2.length() + iIndexOf2, 34);
        }
        if (isInMaxLength(iIndexOf3, string3.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.SplashCustomAdapter.4
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), SplashCustomAdapter.this.tag, " privacy onClick ");
                    Util.openLink(SplashCustomAdapter.this.getContext(), downloadAppInfo.appPrivacyLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf3, string3.length() + iIndexOf3, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf3, string3.length() + iIndexOf3, 34);
        }
        adBaseViewHolder.complianceContent.setText(spannableString);
        adBaseViewHolder.complianceContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void countDownTimerOnFinish() {
        e.a(new StringBuilder(), this.tag, " countDownTimerOnFinish -- ");
    }

    public void countDownTimerOnTick(String str, int i) {
        YFLog.high(this.tag + " onTick showTime " + i);
    }

    public void doShowAD(Activity activity) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        if (Util.isActivityDestroyed(activity)) {
            handleShowFailed(this.tag + " doShowAD but activity is isActivityDestroyed.");
        } else if (isNative()) {
            showNativeSplashAd(activity, viewGroup);
        } else {
            showSplashAD(activity, viewGroup);
        }
    }

    public int getCountDownTime() {
        return 5;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void handleClick() {
        super.handleClick();
    }

    public void handleClose(boolean z) {
        YFLog.high(this.tag + " handleClose isSkip " + z + " isDestroy " + this.isDestroy);
        if (this.isDestroy) {
            d.a(new StringBuilder(), this.tag, " handleClose isDestroy ,return.");
        } else {
            unRegisterBFListener();
            handleClose();
        }
    }

    public boolean isFullScreen() {
        int i;
        Context context = getContext();
        YFSplashSetting yFSplashSetting = this.mSplashSetting;
        if (yFSplashSetting == null) {
            return true;
        }
        int[] size = yFSplashSetting.getSize();
        return size == null || size.length < 2 || (i = size[1]) == 0 || ((double) i) >= ((double) ScreenUtil.px2dip(context, (float) ScreenUtil.getScreenHeight(context))) * 0.9d;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isNative() {
        return this.sdkSupplier.getRenderId(1) == 2;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    /* JADX INFO: renamed from: lambda$closeAdsDelay$1$com-yfanads-android-custom-SplashCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1232x2e9d5fa5() {
        try {
            handleClose(true);
        } catch (Exception e) {
            YFLog.warn(this.tag + " adapterDid " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: lambda$showNativeSplashAd$0$com-yfanads-android-custom-SplashCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1233x55bcf999(Activity activity, ViewGroup viewGroup, boolean z) {
        YFLog.high(this.tag + " showNativeSplashAd onOrientationChanged isLandscape " + z);
        showNativeSplashAd(activity, viewGroup);
    }

    public void loadNativeSplashAd(Context context) {
    }

    public void loadSplashAd(Context context) {
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToBackground() {
        YFLog.high(this.tag + " onBackToBackground " + this.showTime);
        cancelShowCloseTimer();
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToForeground() {
        YFLog.high(this.tag + " onBackToForeground " + this.showTime);
        startCloutDown(this.showTime, this.tips);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFSplashSetting) {
            this.mSplashSetting = (YFSplashSetting) baseAdapterEvent;
        }
    }

    public void setHBackground(RelativeLayout relativeLayout) {
        relativeLayout.setBackgroundResource(android.R.color.white);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = 10;
        layoutParams.rightMargin = 10;
        layoutParams.addRule(15);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setPadding(5, 5, 5, 5);
    }

    public void showNativeSplashAd(final Activity activity, final ViewGroup viewGroup) {
        if (needRegisterReceiver(activity)) {
            this.receiver = new OrientationBroadcastReceiver(new OrientationBroadcastReceiver.OrientationCallback() { // from class: com.yfanads.android.custom.SplashCustomAdapter$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.custom.receiver.OrientationBroadcastReceiver.OrientationCallback
                public final void onOrientationChanged(boolean z) {
                    this.f$0.m1233x55bcf999(activity, viewGroup, z);
                }
            });
            getContext().registerReceiver(this.receiver, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            e.a(new StringBuilder(), this.tag, " showNativeSplashAd registerReceiver");
        }
    }

    public void showSplashAD(Activity activity, ViewGroup viewGroup) {
        doShowAD(activity);
    }

    public void startCloutDown(int i, final String str) {
        cancelShowCloseTimer();
        if (i <= 0) {
            handleClose(false);
            return;
        }
        registerBFListener();
        this.tips = str;
        CountDownTimer countDownTimer = new CountDownTimer(1000 * ((long) i), 1000L) { // from class: com.yfanads.android.custom.SplashCustomAdapter.1
            @Override // android.os.CountDownTimer
            public void onFinish() {
                YFLog.high(SplashCustomAdapter.this.tag + " onFinish showTime " + SplashCustomAdapter.this.showTime);
                SplashCustomAdapter splashCustomAdapter = SplashCustomAdapter.this;
                if (splashCustomAdapter.showTime != 0) {
                    splashCustomAdapter.cancelShowCloseTimer();
                    SplashCustomAdapter.this.handleClose(false);
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                SplashCustomAdapter splashCustomAdapter = SplashCustomAdapter.this;
                int i2 = (int) (j / 1000);
                splashCustomAdapter.showTime = i2;
                splashCustomAdapter.countDownTimerOnTick(str, i2);
                SplashCustomAdapter splashCustomAdapter2 = SplashCustomAdapter.this;
                if (splashCustomAdapter2.showTime == 0) {
                    splashCustomAdapter2.cancelShowCloseTimer();
                    SplashCustomAdapter.this.handleClose(false);
                }
            }
        };
        this.showCloseTimer = countDownTimer;
        countDownTimer.start();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (isNative()) {
            loadNativeSplashAd(context);
        } else {
            loadSplashAd(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelShowCloseTimer() {
        if (this.showCloseTimer != null) {
            e.a(new StringBuilder(), this.tag, " cancelShowCloseTimer");
            this.showCloseTimer.cancel();
            this.showCloseTimer = null;
        }
    }

    public int[] getSizeDp() {
        YFSplashSetting yFSplashSetting = this.mSplashSetting;
        return yFSplashSetting != null ? yFSplashSetting.getSize() : ScreenUtil.getScreenSize(getContext(), true);
    }

    public int[] getSizePx() {
        YFSplashSetting yFSplashSetting = this.mSplashSetting;
        if (yFSplashSetting == null) {
            return ScreenUtil.getScreenSize(getContext(), false);
        }
        int[] size = yFSplashSetting.getSize();
        Context context = getContext();
        return new int[]{ScreenUtil.dip2px(context, size[0]), ScreenUtil.dip2px(context, size[1])};
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.mSplashSetting != null) {
            this.mSplashSetting = null;
        }
        if (this.receiver != null) {
            getContext().unregisterReceiver(this.receiver);
            this.receiver = null;
        }
        cancelShowCloseTimer();
        unRegisterBFListener();
    }

    public void registerBFListener() {
        if (this.isLifecycleRegistered) {
            return;
        }
        this.isLifecycleRegistered = true;
        LifecycleObserver.getInstance().registerLifecycleListener(this);
        e.a(new StringBuilder(), this.tag, " registerBFListener");
    }

    public void unRegisterBFListener() {
        if (this.isLifecycleRegistered) {
            this.isLifecycleRegistered = false;
            LifecycleObserver.getInstance().unRegisterLifecycleListener(this);
            e.a(new StringBuilder(), this.tag, " unRegisterLifecycleListener");
        }
    }

    public void doShowAD(ViewGroup viewGroup, View view) {
        if (viewGroup != null) {
            YFLog.high(this.tag + " doShowAD -- isDestroy:" + this.isDestroy + " adView:" + view);
            this.isDestroy = false;
            viewGroup.removeAllViews();
            viewGroup.addView(view);
            return;
        }
        h.a(new StringBuilder(), this.tag, " doShowAD -- but setting or viewGroup is empty");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter, com.yfanads.android.core.render.api.YFNativeCall
    public void handleClose() {
        super.handleClose();
    }
}
