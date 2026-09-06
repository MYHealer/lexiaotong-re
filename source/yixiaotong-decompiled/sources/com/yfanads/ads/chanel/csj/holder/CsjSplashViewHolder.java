package com.yfanads.ads.chanel.csj.holder;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.yfanads.ads.chanel.csj.template.CsjSplashTemplateData;
import com.yfanads.android.custom.view.AdSplashViewHolder;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjSplashViewHolder extends AdSplashViewHolder {
    public CsjSplashViewHolder(View view, CsjSplashTemplateData csjSplashTemplateData) {
        super(view, csjSplashTemplateData);
    }

    public void updateShowView(Context context, CsjSplashTemplateData csjSplashTemplateData, boolean z) {
        updateTopView(csjSplashTemplateData, z);
        updateContentView(context, z);
        super.updateInteraction(context, csjSplashTemplateData);
        updateClose(context, csjSplashTemplateData, z);
        updateFeedView(csjSplashTemplateData);
    }

    @Override // com.yfanads.android.custom.view.AdSplashViewHolder
    public void setTevCountdown(String str) {
        this.tevCountdown.setVisibility(0);
        this.tevCountdown.setText(str);
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
