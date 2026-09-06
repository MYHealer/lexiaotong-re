package com.yfanads.android.custom;

import android.app.Activity;
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
import com.yfanads.android.core.d;
import com.yfanads.android.core.h;
import com.yfanads.android.core.k;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.custom.view.AdBannerViewHolder;
import com.yfanads.android.custom.view.AdBaseViewHolder;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFExpView;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class NativeExpressCustomAdapter extends k {
    public List<YFNativeAd> developAds;
    public YFNativeExpressSetting setting;
    public List<ExpView> viewList;

    public static class ExpViewListener<T> {
        protected SoftReference<T> natAdapter;

        public ExpViewListener(T t) {
            this.natAdapter = new SoftReference<>(t);
        }

        public T getAdapter() {
            return this.natAdapter.get();
        }
    }

    public NativeExpressCustomAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
        this.viewList = new ArrayList();
        this.developAds = new ArrayList();
        this.setting = yFNativeExpressSetting;
    }

    private void changeNewSupplier(ExpView expView) {
        SdkSupplier sdkSupplier;
        if (expView == null || (sdkSupplier = this.sdkSupplier) == null) {
            h.a(new StringBuilder(), this.tag, " changeNewSupplier expView error");
        } else {
            sdkSupplier.setCustom(expView);
        }
    }

    private ExpView getAdView(int i) {
        if (!YFListUtils.isEmpty(this.viewList) && i < this.viewList.size() && i >= 0) {
            return this.viewList.get(i);
        }
        YFLog.error(this.tag + " getAdView error " + i);
        return null;
    }

    private void removeView(ExpView expView) {
        if (expView != null) {
            try {
                if (expView.getView() == null || !(expView.getView().getParent() instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) expView.getView().getParent()).removeAllViews();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void updateShowContentArea(AdBaseViewHolder adBaseViewHolder, BannerTemplateData bannerTemplateData) {
        if (bannerTemplateData.isTemplateV3_W610() && (adBaseViewHolder instanceof AdBannerViewHolder)) {
            RelativeLayout relativeLayout = ((AdBannerViewHolder) adBaseViewHolder).titleBtnArea;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.addRule(10);
            layoutParams.topMargin = ScreenUtil.dip2px(relativeLayout.getContext(), 12.0f);
        }
    }

    public void bindData(Activity activity, BannerTemplateData bannerTemplateData, int i, AdBannerViewHolder adBannerViewHolder) {
    }

    public void closeAds(int i) {
        handleClose(getAdView(i));
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
        YFLog.debug(this.tag + " complianceView index = " + iIndexOf + " , " + iIndexOf2 + " , " + iIndexOf3 + " , maxLength = " + length);
        if (isInMaxLength(iIndexOf3, string.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.NativeExpressCustomAdapter.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), NativeExpressCustomAdapter.this.tag, " function onClick ");
                    Util.openLink(NativeExpressCustomAdapter.this.getContext(), downloadAppInfo.functionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf, string.length() + iIndexOf, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf, string.length() + iIndexOf, 34);
        }
        if (isInMaxLength(iIndexOf2, string2.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.NativeExpressCustomAdapter.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), NativeExpressCustomAdapter.this.tag, " permission onClick ");
                    Util.openLink(NativeExpressCustomAdapter.this.getContext(), downloadAppInfo.appPermissionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf2, string2.length() + iIndexOf2, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf2, string2.length() + iIndexOf2, 34);
        }
        if (isInMaxLength(iIndexOf3, string3.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.NativeExpressCustomAdapter.3
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    d.a(new StringBuilder(), NativeExpressCustomAdapter.this.tag, " privacy onClick ");
                    Util.openLink(NativeExpressCustomAdapter.this.getContext(), downloadAppInfo.appPrivacyLink);
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

    public void doShowAD(Activity activity) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        doShowAD(activity);
    }

    public void doShowNativeAd(Activity activity) {
        boolean zIsDevelop = isDevelop();
        int size = zIsDevelop ? this.developAds.size() : getSize();
        YFLog.debug(this.tag + " doShowNativeAd isDevelop: " + zIsDevelop + " size: " + size);
        if (size <= 0) {
            handleRenderFailed();
        }
        this.viewList.clear();
        for (int i = 0; i < size; i++) {
            ExpView yFExpView = zIsDevelop ? new YFExpView(getYFNativeAd(i), getAdType(), i) : getView(activity, i, getNativeAdContainer());
            if (yFExpView != null) {
                this.viewList.add(yFExpView);
            }
        }
        YFNativeExpressSetting yFNativeExpressSetting = this.setting;
        if (yFNativeExpressSetting != null) {
            yFNativeExpressSetting.adapterRenderSuccess(this.sdkSupplier, this.viewList);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        if (!isDevelop() || YFListUtils.isEmpty(this.developAds)) {
            return null;
        }
        return InitUtils.getAdInfo(this.developAds.get(0), getRequestId());
    }

    public int getAdType() {
        return -1;
    }

    public ViewGroup getNativeAdContainer() {
        return null;
    }

    public int getSize() {
        return 0;
    }

    public YFNativeAd getYFNativeAd(int i) {
        if (i < 0 || i >= this.developAds.size()) {
            return null;
        }
        return this.developAds.get(i);
    }

    public void handleClick(ExpView expView) {
        changeNewSupplier(expView);
        super.handleClickByIndex(false, expView != null ? expView.getViewIndex() : 0);
    }

    public void handleClose(ExpView expView) {
        removeView(expView);
        changeNewSupplier(expView);
        super.handleClose();
    }

    public void handleExposure(int i) {
        changeNewSupplier(getAdView(i));
        super.handleExposureByIndex(i);
    }

    public void handleRenderFailed(int i) {
        changeNewSupplier(getAdView(i));
        super.handleRenderFailed();
    }

    public boolean isDownloadType(int i) {
        return false;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFNativeExpressSetting) {
            this.setting = (YFNativeExpressSetting) baseAdapterEvent;
        }
    }

    public void closeAds(ViewGroup viewGroup, int i) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        handleClose(getAdView(i));
    }

    public BannerTemplateData createTemplateData(String str, TemplateConf templateConf, int i, int i2, boolean z) {
        BannerTemplateData bannerTemplateData = new BannerTemplateData(getContext(), str, i, i2, z);
        bannerTemplateData.setConf(templateConf);
        return bannerTemplateData;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        List<ExpView> list = this.viewList;
        if (list != null) {
            list.clear();
        }
        if (!YFListUtils.isEmpty(this.developAds)) {
            Iterator<YFNativeAd> it = this.developAds.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
            this.developAds.clear();
        }
        if (this.setting != null) {
            this.setting = null;
        }
    }

    public int getView() {
        YFNativeExpressSetting yFNativeExpressSetting = this.setting;
        if (yFNativeExpressSetting != null) {
            return yFNativeExpressSetting.getViewWidth();
        }
        return 0;
    }

    public ExpView getView(Activity activity, int i, ViewGroup viewGroup) {
        String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.BANNER_WH640);
        int template = TemplateRes.getTemplate(templateKey);
        if (template == 0) {
            h.a(new StringBuilder(), this.tag, " addView error has no id");
            return null;
        }
        View viewInflate = LayoutInflater.from(activity).inflate(template, (ViewGroup) null, false);
        YFLog.debug(this.tag + " getView key " + templateKey + " , index = " + i);
        BannerTemplateData bannerTemplateDataCreateTemplateData = createTemplateData(templateKey, this.sdkSupplier.getTemplateConf(), this.setting.getViewWidth(), this.setting.getViewHeight(), isDownloadType(i));
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(bannerTemplateDataCreateTemplateData.popWidth, bannerTemplateDataCreateTemplateData.popHeight));
        if (viewGroup != null) {
            viewGroup.addView(viewInflate);
        }
        AdBannerViewHolder adBannerViewHolder = new AdBannerViewHolder(viewInflate, bannerTemplateDataCreateTemplateData, viewGroup);
        if (viewGroup != null) {
            bindData(activity, bannerTemplateDataCreateTemplateData, i, adBannerViewHolder);
            addViewLister(viewInflate);
            return new YFExpView(viewGroup, getAdType(), i);
        }
        addViewLister(viewInflate);
        bindData(activity, bannerTemplateDataCreateTemplateData, i, adBannerViewHolder);
        return new YFExpView(viewInflate, getAdType(), i);
    }

    public void handleClick(int i, boolean z) {
        changeNewSupplier(getAdView(i));
        super.handleClickByIndex(z, i);
    }

    public void handleExposure(ExpView expView) {
        changeNewSupplier(expView);
        super.handleExposureByIndex(expView != null ? expView.getViewIndex() : 0);
    }

    public void handleRenderFailed(ExpView expView) {
        changeNewSupplier(expView);
        super.handleRenderFailed();
    }
}
