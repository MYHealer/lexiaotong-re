package com.yfanads.android.custom;

import android.app.Activity;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.yfanads.ads.R;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.banner.YFBannerSetting;
import com.yfanads.android.core.d;
import com.yfanads.android.core.k;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class BannerCustomAdapter extends k {
    public YFBannerSetting setting;

    public BannerCustomAdapter(YFBannerSetting yFBannerSetting) {
        super(yFBannerSetting);
        this.setting = yFBannerSetting;
    }

    private void updateShowContentArea(AdBaseViewHolder adBaseViewHolder, BannerTemplateData bannerTemplateData) {
        if (bannerTemplateData.isTemplateV3_W610() && (adBaseViewHolder instanceof AdBannerViewHolder)) {
            RelativeLayout relativeLayout = ((AdBannerViewHolder) adBaseViewHolder).titleBtnArea;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.addRule(10);
            layoutParams.topMargin = ScreenUtil.dip2px(relativeLayout.getContext(), 12.0f);
        }
    }

    public boolean addView(Activity activity, ViewGroup viewGroup) {
        return addView(activity, viewGroup, null);
    }

    public abstract void bindData(Activity activity, BannerTemplateData bannerTemplateData, ViewGroup viewGroup, AdBannerViewHolder adBannerViewHolder);

    public void closeAds(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        handleClose();
    }

    public void complianceView(AdBaseViewHolder adBaseViewHolder, BannerTemplateData bannerTemplateData, final DownloadAppInfo downloadAppInfo) {
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
        YFLog.debug(" complianceView index = " + iIndexOf + " , " + iIndexOf2 + " , " + iIndexOf3 + " , maxLength = " + length);
        if (isInMaxLength(iIndexOf3, string.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.BannerCustomAdapter.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), BannerCustomAdapter.this.tag, "function onClick ");
                    Util.openLink(BannerCustomAdapter.this.getContext(), downloadAppInfo.functionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf, string.length() + iIndexOf, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf, string.length() + iIndexOf, 34);
        }
        if (isInMaxLength(iIndexOf2, string2.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.BannerCustomAdapter.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), BannerCustomAdapter.this.tag, "permission onClick ");
                    Util.openLink(BannerCustomAdapter.this.getContext(), downloadAppInfo.appPermissionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf2, string2.length() + iIndexOf2, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf2, string2.length() + iIndexOf2, 34);
        }
        if (isInMaxLength(iIndexOf3, string3.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.BannerCustomAdapter.3
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), BannerCustomAdapter.this.tag, "privacy onClick ");
                    Util.openLink(BannerCustomAdapter.this.getContext(), downloadAppInfo.appPrivacyLink);
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
        adBaseViewHolder.complianceContent.setTextColor(bannerTemplateData.getComplianceColor(getContext()));
        updateShowContentArea(adBaseViewHolder, bannerTemplateData);
    }

    public BannerTemplateData createTemplateData(String str, TemplateConf templateConf, int i, int i2) {
        return createTemplateData(str, templateConf, i, i2, false);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(Context context) {
    }

    public void doShowAD(Activity activity) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        doShowAD(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter, com.yfanads.android.core.render.api.YFNativeCall
    public void handleClose() {
        removeListener();
        super.handleClose();
    }

    public boolean isDownloadType() {
        return false;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isInMaxLength(int i, int i2, int i3) {
        return i >= 0 && i + i2 <= i3;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFBannerSetting) {
            this.setting = (YFBannerSetting) baseAdapterEvent;
        }
    }

    public boolean addView(Activity activity, ViewGroup viewGroup, ViewGroup viewGroup2) {
        String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.BANNER_WH640);
        int template = TemplateRes.getTemplate(templateKey);
        if (template == 0) {
            YFLog.error("addView error has no id");
            return false;
        }
        View viewInflate = LayoutInflater.from(activity).inflate(template, viewGroup, false);
        YFLog.debug("addView key " + templateKey);
        BannerTemplateData bannerTemplateDataCreateTemplateData = createTemplateData(templateKey, this.sdkSupplier.getTemplateConf(), this.setting.getViewWidth(), this.setting.getViewHeight(), isDownloadType());
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(bannerTemplateDataCreateTemplateData.popWidth, bannerTemplateDataCreateTemplateData.popHeight));
        if (viewGroup2 != null) {
            viewGroup2.addView(viewInflate);
        }
        bindData(activity, bannerTemplateDataCreateTemplateData, viewGroup, new AdBannerViewHolder(viewInflate, bannerTemplateDataCreateTemplateData, viewGroup2));
        addViewLister(viewInflate);
        if (viewGroup2 != null) {
            viewGroup.removeAllViews();
            viewGroup.addView(viewGroup2);
        } else {
            viewGroup.removeAllViews();
            viewGroup.addView(viewInflate);
        }
        handleApiExposure();
        return true;
    }

    public BannerTemplateData createTemplateData(String str, TemplateConf templateConf, int i, int i2, boolean z) {
        BannerTemplateData bannerTemplateData = new BannerTemplateData(getContext(), str, i, i2, z);
        bannerTemplateData.setConf(templateConf);
        return bannerTemplateData;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.setting != null) {
            this.setting = null;
        }
        removeListener();
    }
}
