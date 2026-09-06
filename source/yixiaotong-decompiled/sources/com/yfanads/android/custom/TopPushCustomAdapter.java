package com.yfanads.android.custom;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import com.yfanads.ads.R;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.d;
import com.yfanads.android.core.h;
import com.yfanads.android.core.k;
import com.yfanads.android.core.toppush.YFTopPushSetting;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.custom.view.AdTopPushViewHolder;
import com.yfanads.android.custom.view.AnimationType;
import com.yfanads.android.custom.view.CustomCountDownTimer;
import com.yfanads.android.custom.view.TopPushDialog;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.lifecycle.LifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TopPushTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class TopPushCustomAdapter extends k implements LifecycleListener {
    private boolean actualExposeCloseAd;
    private CustomCountDownTimer countDownTimer;
    public TopPushDialog customDialog;
    private boolean hasClose;
    protected TopPushTemplateData interModeTemplateData;
    private boolean isClickClose;
    public YFTopPushSetting setting;

    public TopPushCustomAdapter(YFTopPushSetting yFTopPushSetting) {
        super(yFTopPushSetting);
        this.setting = yFTopPushSetting;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void actualExposeCloseAd() {
        YFLog.high("actualExposure close " + this.isClickClose);
        this.actualExposeCloseAd = true;
        if (this.isClickClose) {
            closeAdsDelay();
        }
    }

    private TopPushTemplateData createTopPushTemplateData(TemplateConf templateConf) {
        return new TopPushTemplateData(getContext(), this.sdkSupplier.getTemplateKey(TemplateRes.TOP_PUSH_1), templateConf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCountDown(BaseTemplateData baseTemplateData, AdBaseViewHolder adBaseViewHolder, int i) {
        adBaseViewHolder.updateCountDown(baseTemplateData, i);
    }

    public boolean addView(Activity activity) {
        return addView(activity, null, 0);
    }

    public abstract void bindData(Activity activity, TopPushTemplateData topPushTemplateData, AdBaseViewHolder adBaseViewHolder);

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void closeAds() {
        super.closeAds();
        try {
            if (this.hasClose) {
                YFLog.debug(this.tag + " closeAds hasClose, return");
                return;
            }
            YFLog.debug(this.tag + " closeAds");
            this.hasClose = true;
            cancelCountDown();
            closeCustomDialog();
            removeListener();
            handleClose();
        } catch (Exception e) {
            e.printStackTrace();
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
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.TopPushCustomAdapter.3
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), TopPushCustomAdapter.this.tag, " function onClick ");
                    Util.openLink(TopPushCustomAdapter.this.getContext(), downloadAppInfo.functionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf, string.length() + iIndexOf, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf, string.length() + iIndexOf, 34);
        }
        if (isInMaxLength(iIndexOf2, string2.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.TopPushCustomAdapter.4
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), TopPushCustomAdapter.this.tag, " permission onClick ");
                    Util.openLink(TopPushCustomAdapter.this.getContext(), downloadAppInfo.appPermissionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf2, string2.length() + iIndexOf2, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf2, string2.length() + iIndexOf2, 34);
        }
        if (isInMaxLength(iIndexOf3, string3.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.TopPushCustomAdapter.5
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), TopPushCustomAdapter.this.tag, " privacy onClick ");
                    Util.openLink(TopPushCustomAdapter.this.getContext(), downloadAppInfo.appPrivacyLink);
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        doShowAD(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void handleExposure() {
        super.handleExposure();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isInMaxLength(int i, int i2, int i3) {
        return i >= 0 && i + i2 <= i3;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFTopPushSetting) {
            this.setting = (YFTopPushSetting) baseAdapterEvent;
        }
    }

    public void startCountDown(final AdBaseViewHolder adBaseViewHolder, final BaseTemplateData baseTemplateData) {
        if (adBaseViewHolder.startCountDown(baseTemplateData)) {
            LifecycleObserver.getInstance().registerLifecycleListener(this);
            int autoCloseTime = baseTemplateData.getAutoCloseTime();
            updateCountDown(baseTemplateData, adBaseViewHolder, autoCloseTime);
            YFLog.debug(this.tag + " startCountDown " + autoCloseTime);
            CustomCountDownTimer customCountDownTimer = new CustomCountDownTimer(((long) (autoCloseTime + 1)) * 1000, 1000L, new CustomCountDownTimer.CountDownListener() { // from class: com.yfanads.android.custom.TopPushCustomAdapter.2
                @Override // com.yfanads.android.custom.view.CustomCountDownTimer.CountDownListener
                public void onFinishAction() {
                    d.a(new StringBuilder(), TopPushCustomAdapter.this.tag, " onFinishAction ");
                    TopPushCustomAdapter.this.cancelCountDown();
                    TopPushCustomAdapter.this.closeAds();
                }

                @Override // com.yfanads.android.custom.view.CustomCountDownTimer.CountDownListener
                public void updateCountDownUI(int i) {
                    YFLog.debug(TopPushCustomAdapter.this.tag + " startCountDown " + i);
                    TopPushCustomAdapter.this.updateCountDown(baseTemplateData, adBaseViewHolder, i);
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

    public void closeAdsDelay(int i) {
        if (this.actualExposeCloseAd) {
            YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.TopPushCustomAdapter$$ExternalSyntheticLambda0
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
            TopPushDialog topPushDialog = this.customDialog;
            if (topPushDialog != null) {
                topPushDialog.dismiss();
                this.customDialog = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToBackground() {
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.pause();
        }
    }

    @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
    public void onBackToForeground() {
        CustomCountDownTimer customCountDownTimer = this.countDownTimer;
        if (customCountDownTimer != null) {
            customCountDownTimer.start();
        }
    }

    public boolean addView(final Activity activity, final ViewGroup viewGroup, int... iArr) {
        closeCustomDialog();
        String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.TOP_PUSH_1);
        final String str = TextUtils.isEmpty(templateKey) ? TemplateRes.TOP_PUSH_1 : templateKey;
        YFLog.debug(this.tag + " addView key " + str);
        int template = TemplateRes.getTemplate(str);
        if (template == 0) {
            handleRenderFailed(0, " addView error has no id");
            return false;
        }
        if (activity == null) {
            h.a(new StringBuilder(), this.tag, " addView activity null");
            reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), YFAdError.ERROR_INTER_SHOW_FAILED, getAType());
            return false;
        }
        final TopPushTemplateData topPushTemplateDataCreateTopPushTemplateData = createTopPushTemplateData(this.sdkSupplier.getTemplateConf());
        try {
            TopPushDialog topPushDialogBindData = new TopPushDialog.Builder(activity).setLayoutId(template).setCloseId(R.id.ad_close).setOffsetTop(ScreenUtil.dip2px(activity, 50.0f)).setTag("top_push").setSize(topPushTemplateDataCreateTopPushTemplateData.popWidth, topPushTemplateDataCreateTopPushTemplateData.popHeight).setAnimationType(topPushTemplateDataCreateTopPushTemplateData.getShowLoc() == 2 ? AnimationType.FROM_BOTTOM : AnimationType.FROM_TOP).setClickClose(topPushTemplateDataCreateTopPushTemplateData.isClickClose()).build().bindData(new TopPushDialog.DialogBindData() { // from class: com.yfanads.android.custom.TopPushCustomAdapter.1
                AdBaseViewHolder adBaseViewHolder;

                @Override // com.yfanads.android.custom.view.TopPushDialog.DialogBindData
                public void actualExposureTime() {
                    TopPushCustomAdapter.this.actualExposeCloseAd();
                }

                @Override // com.yfanads.android.custom.view.TopPushDialog.DialogBindData
                public void bindViewData(View view) {
                    TemplateRes.TOP_PUSH_1.equals(str);
                    AdTopPushViewHolder adTopPushViewHolder = new AdTopPushViewHolder(view, topPushTemplateDataCreateTopPushTemplateData, viewGroup);
                    this.adBaseViewHolder = adTopPushViewHolder;
                    TopPushCustomAdapter.this.bindData(activity, topPushTemplateDataCreateTopPushTemplateData, adTopPushViewHolder);
                    TopPushCustomAdapter.this.addViewLister(this.adBaseViewHolder.convertView);
                }

                @Override // com.yfanads.android.custom.view.TopPushDialog.DialogBindData
                public ViewGroup getRootView() {
                    return viewGroup;
                }
            });
            this.customDialog = topPushDialogBindData;
            topPushDialogBindData.setCancelable(topPushTemplateDataCreateTopPushTemplateData.isPhyClose());
            this.customDialog.show(activity);
            this.customDialog.setOnDismissListener(new TopPushDialog.OnDismissListener() { // from class: com.yfanads.android.custom.TopPushCustomAdapter$$ExternalSyntheticLambda1
                @Override // com.yfanads.android.custom.view.TopPushDialog.OnDismissListener
                public final void onDismiss() {
                    this.f$0.closeAds();
                }
            });
            handleApiExposure();
            return true;
        } catch (Exception e) {
            reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), YFAdError.ERROR_INTER_SHOW_FAILED, getAType());
            e.printStackTrace();
            return true;
        }
    }

    public void doShowAD(Activity activity) {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        if (sdkSupplier != null) {
            this.interModeTemplateData = createTopPushTemplateData(sdkSupplier.getTemplateConf());
        }
    }

    public void closeAdsDelay() {
        closeAdsDelay(200);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.setting != null) {
            this.setting = null;
        }
        if (this.interModeTemplateData != null) {
            this.interModeTemplateData = null;
        }
        removeListener();
        closeCustomDialog();
    }
}
