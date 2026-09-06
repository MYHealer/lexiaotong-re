package com.yfanads.android.custom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.yfanads.ads.R;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.act.YFInterstitialActivity;
import com.yfanads.android.core.act.a;
import com.yfanads.android.core.d;
import com.yfanads.android.core.e;
import com.yfanads.android.core.f;
import com.yfanads.android.core.h;
import com.yfanads.android.core.inter.YFAdInterEventCallback;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.core.k;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdInterV2ViewHolder;
import com.yfanads.android.custom.view.AdInterV3ViewHolder;
import com.yfanads.android.custom.view.AdInterstitialCloseView;
import com.yfanads.android.custom.view.CustomCountDownTimer;
import com.yfanads.android.custom.view.NewCustomStyleDialog;
import com.yfanads.android.libs.utils.ActivityUtils;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.libs.utils.WindowUtils;
import com.yfanads.android.lifecycle.LifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterModeTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.upload.b;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.lang.ref.SoftReference;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class InterstitialCustomAdapter extends k implements LifecycleListener, YFAdInterEventCallback {
    private boolean actualExposeCloseAd;
    private CustomCountDownTimer countDownTimer;
    public NewCustomStyleDialog customDialog;
    private final String instanceId;
    protected InterModeTemplateData interModeTemplateData;
    private boolean isClickClose;
    protected boolean isNeedActivity;
    public YFInterstitialSetting setting;
    private SoftReference<Activity> softActivity;
    protected long startTime;

    public InterstitialCustomAdapter(YFInterstitialSetting yFInterstitialSetting) {
        super(yFInterstitialSetting);
        this.isNeedActivity = false;
        String string = UUID.randomUUID().toString();
        this.instanceId = string;
        this.setting = yFInterstitialSetting;
        if (this.isNeedActivity) {
            a.a().a(string, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actualExposeCloseAd() {
        YFLog.high("actualExposure close " + this.isClickClose);
        this.actualExposeCloseAd = true;
        if (this.isClickClose) {
            closeAdsDelay();
        }
    }

    private InterModeTemplateData createInterModeTemplateData(TemplateConf templateConf) {
        return new InterModeTemplateData(getContext(), templateConf);
    }

    private void handleCloseView(final Activity activity) {
        Util.MAIN_HANDLER.post(new Runnable() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1225x6b1395f5(activity);
            }
        });
    }

    private boolean isCloseWithClick() {
        SoftReference<Activity> softReference;
        InterModeTemplateData interModeTemplateData;
        return (isNative() || (softReference = this.softActivity) == null || softReference.get() == null || (interModeTemplateData = this.interModeTemplateData) == null || !interModeTemplateData.isClickClose()) ? false : true;
    }

    private boolean isNeedShowCloseView() {
        SoftReference<Activity> softReference;
        InterModeTemplateData interModeTemplateData;
        return (isNative() || (softReference = this.softActivity) == null || softReference.get() == null || (interModeTemplateData = this.interModeTemplateData) == null || !interModeTemplateData.isShowClose()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountDown(BaseTemplateData baseTemplateData, AdBaseViewHolder adBaseViewHolder, int i) {
        adBaseViewHolder.updateCountDown(baseTemplateData, i);
    }

    public boolean addView(Activity activity) {
        return addView(activity, null, 0);
    }

    public abstract void bindData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder);

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void closeAds() {
        YFLog.debug(this.tag + " closeAds");
        closeAds(true);
    }

    public void closeAdsWithoutEvent() {
        closeAds(false);
    }

    /* JADX INFO: renamed from: closeSelf, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m1224x50f81756(Activity activity) {
        try {
            Activity topActivity = ActivityUtils.getTopActivity();
            YFLog.debug("handleCloseView closeSelf " + topActivity + "|" + activity);
            if (topActivity == null) {
                YFLog.error(this.tag + " closeSelf topActivity is null , return.");
                return;
            }
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
            if (topActivity.getComponentName().getClassName().equals(activity.getComponentName().getClassName())) {
                ViewGroup viewGroup = (ViewGroup) WindowUtils.getAboveDecorView(topActivity);
                if (viewGroup != null) {
                    YFLog.high(this.tag + " start closeSelf time:" + iCurrentTimeMillis);
                    topActivity.getWindowManager().removeView(viewGroup);
                } else {
                    YFLog.error(this.tag + " closeSelf error aboveDecorView is null.");
                }
            } else {
                YFLog.high(this.tag + " start closeSelf time:" + iCurrentTimeMillis);
                topActivity.finish();
            }
            boolean z = b.e;
            b.a.f9685a.a(this.sdkSupplier, YFAdsConst.ReportETypeValue.CUSTOM_CLOSE.getValue(), iCurrentTimeMillis);
            handleClose();
        } catch (Exception unused) {
            h.a(new StringBuilder(), this.tag, " closeSelf error.");
        }
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
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter.3
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), InterstitialCustomAdapter.this.tag, " function onClick ");
                    Util.openLink(InterstitialCustomAdapter.this.getContext(), downloadAppInfo.functionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf, string.length() + iIndexOf, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf, string.length() + iIndexOf, 34);
        }
        if (isInMaxLength(iIndexOf2, string2.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter.4
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), InterstitialCustomAdapter.this.tag, " permission onClick ");
                    Util.openLink(InterstitialCustomAdapter.this.getContext(), downloadAppInfo.appPermissionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf2, string2.length() + iIndexOf2, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf2, string2.length() + iIndexOf2, 34);
        }
        if (isInMaxLength(iIndexOf3, string3.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter.5
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), InterstitialCustomAdapter.this.tag, " privacy onClick ");
                    Util.openLink(InterstitialCustomAdapter.this.getContext(), downloadAppInfo.appPrivacyLink);
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

    public InterTemplateData createTemplateData(String str, TemplateConf templateConf, int i) {
        return Objects.equals(str, TemplateRes.INT_V_3) ? new InterV3TemplateData(getContext(), str, templateConf, i) : new InterTemplateData(getContext(), str, templateConf, i);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        doShowAD(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void handleClick() {
        super.handleClick();
        if (!isCloseWithClick() || isSupportAutoClick()) {
            return;
        }
        e.a(new StringBuilder(), this.tag, " close view");
        m1224x50f81756(this.softActivity.get());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void handleExposure() {
        super.handleExposure();
        if (isNeedShowCloseView()) {
            e.a(new StringBuilder(), this.tag, " handleExposure show close View");
            handleCloseView(this.softActivity.get());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isInMaxLength(int i, int i2, int i3) {
        return i >= 0 && i + i2 <= i3;
    }

    public boolean isSupportAutoClick() {
        return false;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    /* JADX INFO: renamed from: lambda$handleCloseView$2$com-yfanads-android-custom-InterstitialCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1225x6b1395f5(final Activity activity) {
        try {
            Activity topActivity = ActivityUtils.getTopActivity();
            YFLog.debug("handleCloseView add " + topActivity + "|" + activity);
            if (topActivity == null) {
                YFLog.debug(this.tag + " handleCloseView topActivity is null , return.");
                return;
            }
            this.startTime = System.currentTimeMillis();
            if (!topActivity.getComponentName().getClassName().equals(activity.getComponentName().getClassName())) {
                ((ViewGroup) topActivity.getWindow().getDecorView()).addView(new AdInterstitialCloseView(topActivity, this.interModeTemplateData, new AdInterstitialCloseView.ICloseInterstitialAd() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter$$ExternalSyntheticLambda3
                    @Override // com.yfanads.android.custom.view.AdInterstitialCloseView.ICloseInterstitialAd
                    public final void closeInterstitialAd() {
                        this.f$0.m1224x50f81756(activity);
                    }
                }), -1, -1);
            } else {
                ViewGroup viewGroup = (ViewGroup) WindowUtils.getAboveDecorView(topActivity);
                if (viewGroup != null) {
                    viewGroup.addView(new AdInterstitialCloseView(topActivity, this.interModeTemplateData, new AdInterstitialCloseView.ICloseInterstitialAd() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter$$ExternalSyntheticLambda2
                        @Override // com.yfanads.android.custom.view.AdInterstitialCloseView.ICloseInterstitialAd
                        public final void closeInterstitialAd() {
                            this.f$0.m1223x36dc98b7(activity);
                        }
                    }), -1, -1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            h.a(new StringBuilder(), this.tag, " handleCloseView error.");
        }
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.yfanads.android.lifecycle.LifecycleListener
    public void onActivityResumed(Activity activity) {
    }

    public void onAdapterConfigurationChanged(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, int i) {
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToBackground() {
        pauseCountDown();
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToForeground() {
        reStartCountDown();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFInterstitialSetting) {
            this.setting = (YFInterstitialSetting) baseAdapterEvent;
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

    public void startCountDown(final AdBaseViewHolder adBaseViewHolder, final BaseTemplateData baseTemplateData) {
        if (adBaseViewHolder.startCountDown(baseTemplateData)) {
            LifecycleObserver.getInstance().registerLifecycleListener(this);
            int autoCloseTime = baseTemplateData.getAutoCloseTime();
            updateCountDown(baseTemplateData, adBaseViewHolder, autoCloseTime);
            YFLog.debug(this.tag + " startCountDown " + autoCloseTime);
            CustomCountDownTimer customCountDownTimer = new CustomCountDownTimer(((long) (autoCloseTime + 1)) * 1000, 1000L, new CustomCountDownTimer.CountDownListener() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter.2
                @Override // com.yfanads.android.custom.view.CustomCountDownTimer.CountDownListener
                public void onFinishAction() {
                    d.a(new StringBuilder(), InterstitialCustomAdapter.this.tag, " onFinishAction ");
                    InterstitialCustomAdapter.this.cancelCountDown();
                    InterstitialCustomAdapter.this.closeAds();
                }

                @Override // com.yfanads.android.custom.view.CustomCountDownTimer.CountDownListener
                public void updateCountDownUI(int i) {
                    YFLog.debug(InterstitialCustomAdapter.this.tag + " startCountDown " + i);
                    InterstitialCustomAdapter.this.updateCountDown(baseTemplateData, adBaseViewHolder, i);
                }
            });
            this.countDownTimer = customCountDownTimer;
            customCountDownTimer.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelCountDown() {
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.cancel();
            this.countDownTimer = null;
        }
        LifecycleObserver.getInstance().unRegisterLifecycleListener(this);
    }

    public boolean addView(Activity activity, ViewGroup viewGroup) {
        return addView(activity, viewGroup, 0);
    }

    @Override // com.yfanads.android.core.inter.YFAdInterEventCallback
    public void bindAdData(Activity activity, InterTemplateData interTemplateData, AdBaseViewHolder adBaseViewHolder) {
        if (this.isNeedActivity) {
            bindData(activity, interTemplateData, adBaseViewHolder);
        }
    }

    public void closeAdsDelay(int i) {
        if (this.actualExposeCloseAd) {
            YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.closeAds();
                }
            }, i);
        } else {
            this.isClickClose = true;
        }
    }

    public void closeCustomDialog() {
        try {
            if (this.isNeedActivity) {
                YFInterstitialActivity.closeByInstanceId(this.instanceId);
            }
            NewCustomStyleDialog newCustomStyleDialog = this.customDialog;
            if (newCustomStyleDialog != null) {
                newCustomStyleDialog.hide();
                this.customDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.isNeedActivity) {
            a aVar = a.b;
            aVar.f9637a.remove(this.instanceId);
        }
        if (this.setting != null) {
            this.setting = null;
        }
        if (this.interModeTemplateData != null) {
            this.interModeTemplateData = null;
        }
        removeListener();
        closeCustomDialog();
    }

    @Override // com.yfanads.android.core.inter.YFAdInterEventCallback
    public void onAdConfigurationChanged(AdBaseViewHolder adBaseViewHolder, InterTemplateData interTemplateData, int i) {
        if (this.isNeedActivity) {
            onAdapterConfigurationChanged(adBaseViewHolder, interTemplateData, i);
        }
    }

    @Override // com.yfanads.android.core.inter.YFAdInterEventCallback
    public void onAdExposed() {
        if (this.isNeedActivity) {
            actualExposeCloseAd();
        }
    }

    public void pauseCountDown() {
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.pause();
        }
    }

    public void reStartCountDown() {
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.start();
        }
    }

    public boolean addView(final Activity activity, final ViewGroup viewGroup, int... iArr) {
        closeCustomDialog();
        final String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.INT_V_2);
        YFLog.debug(this.tag + " addView key " + templateKey);
        int template = TemplateRes.getTemplate(templateKey);
        int i = 0;
        if (template == 0) {
            handleRenderFailed(0, " addView error has no id");
            return false;
        }
        if (activity == null) {
            h.a(new StringBuilder(), this.tag, " addView activity null");
            reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), YFAdError.ERROR_INTER_SHOW_FAILED, getAType());
            return false;
        }
        int i2 = (activity.getResources() == null || activity.getResources().getConfiguration() == null) ? 1 : activity.getResources().getConfiguration().orientation;
        if (this.isNeedActivity) {
            Intent intent = new Intent(activity, (Class<?>) YFInterstitialActivity.class);
            intent.putExtra(YFInterstitialActivity.EXTRA_TEMPLATE_KEY, templateKey);
            intent.putExtra(YFInterstitialActivity.EXTRA_LAYOUT_ID, template);
            intent.putExtra("orientation", i2);
            intent.putExtra(YFInterstitialActivity.EXTRA_OFFSET_TOP, iArr != null ? iArr[0] : 0);
            intent.putExtra(YFInterstitialActivity.EXTRA_TEMPLATE_CONF, this.sdkSupplier.getTemplateConf());
            intent.putExtra(YFInterstitialActivity.EXTRA_INSTANCE_ID, this.instanceId);
            activity.startActivity(intent);
            handleApiExposure();
        } else {
            final InterTemplateData interTemplateDataCreateTemplateData = createTemplateData(templateKey, this.sdkSupplier.getTemplateConf(), i2);
            try {
                NewCustomStyleDialog.CustomDialogBuilder gravity = new NewCustomStyleDialog.CustomDialogBuilder().setLayoutId(template).setCloseId(R.id.ad_close).setTag(MediationConstant.RIT_TYPE_INTERSTITIAL).setSize(interTemplateDataCreateTemplateData.popWidth, interTemplateDataCreateTemplateData.popHeight).setGravity(17);
                if (iArr != null) {
                    i = iArr[0];
                }
                NewCustomStyleDialog newCustomStyleDialogBindData = gravity.setOffsetTop(i).setClickClose(interTemplateDataCreateTemplateData.isClickClose()).setTablet(YFAdsPhone.getInstance().isTablet).setAnimation(com.yfanads.ads.libs.R.style.DialogFadeAnimation).build().bindData(new NewCustomStyleDialog.NewDialogBindData() { // from class: com.yfanads.android.custom.InterstitialCustomAdapter.1
                    AdBaseViewHolder adBaseViewHolder;

                    @Override // com.yfanads.android.custom.view.NewCustomStyleDialog.NewDialogBindData
                    public void actualExposureTime() {
                        InterstitialCustomAdapter.this.actualExposeCloseAd();
                    }

                    @Override // com.yfanads.android.custom.view.BaseDialogFragment.DialogBindData
                    public void bindViewData(View view) {
                        if (TemplateRes.INT_V_3.equals(templateKey)) {
                            this.adBaseViewHolder = new AdInterV3ViewHolder(view, viewGroup);
                        } else {
                            this.adBaseViewHolder = new AdInterV2ViewHolder(view, viewGroup);
                        }
                        InterstitialCustomAdapter.this.bindData(activity, interTemplateDataCreateTemplateData, this.adBaseViewHolder);
                        InterstitialCustomAdapter.this.addViewLister(this.adBaseViewHolder.convertView);
                    }

                    @Override // com.yfanads.android.custom.view.NewCustomStyleDialog.NewDialogBindData
                    public ViewGroup getRootView() {
                        return viewGroup;
                    }

                    @Override // com.yfanads.android.custom.view.NewCustomStyleDialog.NewDialogBindData
                    public void onConfigurationChanged(Context context, int i3) {
                        interTemplateDataCreateTemplateData.updNativeSize(context, i3, false);
                        NewCustomStyleDialog newCustomStyleDialog = InterstitialCustomAdapter.this.customDialog;
                        if (newCustomStyleDialog != null) {
                            InterTemplateData interTemplateData = interTemplateDataCreateTemplateData;
                            newCustomStyleDialog.adjustWindow(interTemplateData.popWidth, interTemplateData.popHeight);
                        }
                        AdBaseViewHolder adBaseViewHolder = this.adBaseViewHolder;
                        if (adBaseViewHolder != null) {
                            adBaseViewHolder.updateNativeView(interTemplateDataCreateTemplateData);
                            this.adBaseViewHolder.updateShowView(context, interTemplateDataCreateTemplateData);
                        }
                        InterstitialCustomAdapter.this.onAdapterConfigurationChanged(this.adBaseViewHolder, interTemplateDataCreateTemplateData, i3);
                    }
                });
                this.customDialog = newCustomStyleDialogBindData;
                newCustomStyleDialogBindData.setCancelable(interTemplateDataCreateTemplateData.isPhyClose());
                this.customDialog.show(activity);
                handleApiExposure();
                return true;
            } catch (Exception e) {
                reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), YFAdError.ERROR_INTER_SHOW_FAILED, getAType());
                e.printStackTrace();
            }
        }
        return true;
    }

    public void closeAds(boolean z) {
        try {
            cancelCountDown();
            closeCustomDialog();
            removeListener();
            if (z) {
                handleClose();
            }
        } catch (Exception e) {
            e.printStackTrace();
            f.a(e, new StringBuilder().append(this.tag).append(" closeAds error:"));
        }
    }

    public void doShowAD(Activity activity) {
        SdkSupplier sdkSupplier;
        if (isNative() || (sdkSupplier = this.sdkSupplier) == null) {
            return;
        }
        InterModeTemplateData interModeTemplateDataCreateInterModeTemplateData = createInterModeTemplateData(sdkSupplier.getTemplateConf());
        this.interModeTemplateData = interModeTemplateDataCreateInterModeTemplateData;
        if (interModeTemplateDataCreateInterModeTemplateData.isShowClose()) {
            this.softActivity = new SoftReference<>(activity);
        }
    }

    public void closeAdsDelay() {
        closeAdsDelay(200);
    }
}
