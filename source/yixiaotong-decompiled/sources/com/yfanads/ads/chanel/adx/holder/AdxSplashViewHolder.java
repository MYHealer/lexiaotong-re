package com.yfanads.ads.chanel.adx.holder;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.yfanads.ads.chanel.adx.template.AdxSplashTemplateData;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.core.model.AdxNativeAd;
import com.yfanads.android.custom.view.AdSplashViewHolder;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.SplashTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class AdxSplashViewHolder extends AdSplashViewHolder {
    private static final String TAG = "AdxSplashViewHolder";

    public AdxSplashViewHolder(View view, SplashTemplateData splashTemplateData) {
        super(view, splashTemplateData);
    }

    private void updateClickSize(Context context, BaseTemplateData baseTemplateData) {
        float clickRatio = baseTemplateData.getClickRatio();
        int screenWidth = (int) (ScreenUtil.getScreenWidth(context) * clickRatio);
        int screenHeight = (int) (ScreenUtil.getScreenHeight(context) * clickRatio);
        YFLog.debug("updateClickSize width = " + screenWidth + " , height = " + screenHeight + " , clickRatio " + clickRatio);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenWidth, screenHeight);
        layoutParams.addRule(13);
        this.dyClickView.setLayoutParams(layoutParams);
    }

    public void complianceContent(Context context, AdxNativeAd adxNativeAd, boolean z) {
        if (adxNativeAd.getInteractionType() != 1) {
            setComplianceGone();
            return;
        }
        complianceView(context, new DownloadAppInfo(adxNativeAd.getAppName(), adxNativeAd.getAppVersion(), adxNativeAd.getCorporationName(), adxNativeAd.getIntroductionInfoUrl(), adxNativeAd.getPermissionInfoUrl(), adxNativeAd.getAppPrivacyUrl()));
        if (z) {
            setComplianceContentColor(context.getResources().getColor(R.color.ad_color_80000000));
        }
    }

    public int getActionClickType(BaseTemplateData.InteractiveStyle interactiveStyle) {
        return (interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SHAKE || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_TWIST || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE || interactiveStyle == BaseTemplateData.InteractiveStyle.NONE) ? 4 : 0;
    }

    public void updateShowView(Context context, AdxSplashTemplateData adxSplashTemplateData, boolean z) {
        if (adxSplashTemplateData.isTemplateV1()) {
            updateInteraction(context, adxSplashTemplateData);
            updateAnimaMargin(context, adxSplashTemplateData);
            showJumpStyle(context, adxSplashTemplateData);
            updateClickSize(context, adxSplashTemplateData);
            updateFeedView(adxSplashTemplateData);
            return;
        }
        updateContentView(context, z);
        updateInteraction(context, adxSplashTemplateData);
        updateClose(context, adxSplashTemplateData, z);
        updateFeedView(adxSplashTemplateData);
        updateTopView(adxSplashTemplateData, z);
    }
}
