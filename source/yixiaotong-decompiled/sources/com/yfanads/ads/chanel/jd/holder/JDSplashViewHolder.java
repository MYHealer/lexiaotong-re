package com.yfanads.ads.chanel.jd.holder;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.jd.ad.sdk.nativead.JADNativeWidget;
import com.yfanads.ads.chanel.jd.R;
import com.yfanads.ads.chanel.jd.template.JDSplashTemplateData;
import com.yfanads.android.custom.view.AdSplashViewHolder;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.SplashTemplateData;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class JDSplashViewHolder extends AdSplashViewHolder {
    private FrameLayout actionLayout;

    public JDSplashViewHolder(View view, JDSplashTemplateData jDSplashTemplateData) {
        super(view, jDSplashTemplateData);
        this.actionLayout = (FrameLayout) view.findViewById(R.id.action_layout);
    }

    public void updateShowView(Context context, int i, JDSplashTemplateData jDSplashTemplateData, boolean z) {
        if (jDSplashTemplateData.isTemplateV1()) {
            updateInteraction(context, jDSplashTemplateData, i);
            updateAnimaMargin(context, jDSplashTemplateData);
            showJumpStyle(context, jDSplashTemplateData);
            updateClickSize(context, jDSplashTemplateData);
            updateFeedView(jDSplashTemplateData);
            return;
        }
        updateTopView(jDSplashTemplateData, z);
        updateContentView(context, z);
        updateInteraction(context, jDSplashTemplateData, i);
        updateClose(context, jDSplashTemplateData, z);
        updateFeedView(jDSplashTemplateData);
    }

    private void updateInteraction(Context context, SplashTemplateData splashTemplateData, int i) {
        super.updateInteraction(context, splashTemplateData);
        String[] activeStylePath = splashTemplateData.getActiveStylePath();
        if (activeStylePath == null || activeStylePath.length < 2) {
            return;
        }
        addAnimationAction(context, splashTemplateData.isTemplateV2(), i);
    }

    private void addAnimationAction(Context context, boolean z, int i) {
        if (i == 1) {
            addJingdongAnimationAction(context, z, false, JADNativeWidget.getShakeAnimationView(context));
        } else if (i == 2) {
            addJingdongAnimationAction(context, z, true, JADNativeWidget.getSwipeAnimationView(context));
        }
    }

    private void addJingdongAnimationAction(Context context, boolean z, boolean z2, View view) {
        FrameLayout.LayoutParams layoutParams;
        if (z && z2) {
            layoutParams = new FrameLayout.LayoutParams(-1, ScreenUtil.getScreenHeight(context) / 3);
        } else {
            layoutParams = new FrameLayout.LayoutParams(ScreenUtil.dip2px(context, 360.0f), ScreenUtil.dip2px(context, 350.0f));
            layoutParams.bottomMargin = ScreenUtil.dip2px(context, 20.0f);
        }
        this.actionLayout.addView(view, layoutParams);
        view.setVisibility(4);
        this.actionLayout.setVisibility(0);
    }

    @Override // com.yfanads.android.custom.view.AdSplashViewHolder
    public void setTevCountdown(String str) {
        if (this.tevCountdown != null) {
            this.tevCountdown.setVisibility(0);
            this.tevCountdown.setText(str);
        }
    }

    @Override // com.yfanads.android.custom.view.AdSplashViewHolder
    public void destroy() {
        super.destroy();
        FrameLayout frameLayout = this.actionLayout;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            this.actionLayout = null;
        }
    }

    public void setTevComplianceGone() {
        this.comlianceArea.setVisibility(8);
    }

    private void updateClickSize(Context context, BaseTemplateData baseTemplateData) {
        float clickRatio = baseTemplateData.getClickRatio();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (ScreenUtil.getScreenWidth(context) * clickRatio), (int) (ScreenUtil.getScreenHeight(context) * clickRatio));
        layoutParams.addRule(13);
        this.dyClickView.setLayoutParams(layoutParams);
    }

    public enum InteractiveStyle {
        CLICK(0),
        SHAKE(1),
        SLIDE(2);

        private int value;

        public int getValue() {
            return this.value;
        }

        InteractiveStyle(int i) {
            this.value = i;
        }
    }
}
