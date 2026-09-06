package com.yfanads.android.model.template;

import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TemplateV3Size {
    public int actionDesSP;
    public int actionSize;
    public int actionSlideHeight;
    public int actionSlideWidth;
    public int actionTitleSP;
    public int actionTop;
    public int adLogoIcon;
    public int animationBottom;
    public int barBottom;
    public int barHeight;
    public int barWidth;
    public int complianceBottom;
    public int desSP;
    public int desTopMargin;
    public int iconTopMargin;
    public int logoSize;
    public float templateScale;
    public int titleSP;
    public int titleTopMargin;

    public TemplateV3Size(float f, InterTemplateData.InteractiveSize interactiveSize, boolean z, float f2) {
        this.templateScale = f2;
        if (z) {
            landscapeSize(f);
        } else {
            portraitSize(f, interactiveSize);
        }
    }

    private void landscapeSize(float f) {
        this.animationBottom = (int) (ScreenUtil.dip2pxScale(f, 26.0f) * this.templateScale);
        this.logoSize = (int) (ScreenUtil.dip2pxScale(f, 27.0f) * this.templateScale);
        this.iconTopMargin = (int) (ScreenUtil.dip2pxScale(f, 16.0f) * this.templateScale);
        this.titleTopMargin = (int) (ScreenUtil.dip2pxScale(f, 3.0f) * this.templateScale);
        float fDip2pxScale = ScreenUtil.dip2pxScale(f, 2.0f);
        float f2 = this.templateScale;
        this.desTopMargin = (int) (fDip2pxScale * f2);
        this.titleSP = (int) (f2 * 12.0f);
        this.desSP = (int) (f2 * 7.0f);
        this.barWidth = (int) (ScreenUtil.dip2pxScale(f, 171.0f) * this.templateScale);
        this.barHeight = (int) (ScreenUtil.dip2pxScale(f, 38.0f) * this.templateScale);
        this.barBottom = (int) (ScreenUtil.dip2pxScale(f, 21.5f) * this.templateScale);
        this.actionTop = (int) (ScreenUtil.dip2pxScale(f, 12.0f) * this.templateScale);
        float fDip2pxScale2 = ScreenUtil.dip2pxScale(f, 64.0f);
        float f3 = this.templateScale;
        this.actionSize = (int) (fDip2pxScale2 * f3);
        this.actionTitleSP = (int) (10.0f * f3);
        this.actionDesSP = (int) (f3 * 7.0f);
        this.actionSlideWidth = (int) (ScreenUtil.dip2pxScale(f, 32.0f) * this.templateScale);
        this.actionSlideHeight = (int) (ScreenUtil.dip2pxScale(f, 31.0f) * this.templateScale);
        this.complianceBottom = (int) (ScreenUtil.dip2pxScale(f, 0.1f) * this.templateScale);
    }

    private void portraitSize(float f, InterTemplateData.InteractiveSize interactiveSize) {
        this.animationBottom = (int) (ScreenUtil.dip2pxScale(f, 40.0f) * this.templateScale);
        if (interactiveSize == InterTemplateData.InteractiveSize.SMALL) {
            this.logoSize = (int) (ScreenUtil.dip2pxScale(f, 34.0f) * this.templateScale);
            this.iconTopMargin = (int) (ScreenUtil.dip2pxScale(f, 20.0f) * this.templateScale);
            this.titleTopMargin = (int) (ScreenUtil.dip2pxScale(f, 3.8f) * this.templateScale);
            float fDip2pxScale = ScreenUtil.dip2pxScale(f, 1.0f);
            float f2 = this.templateScale;
            this.desTopMargin = (int) (fDip2pxScale * f2);
            int i = (int) f2;
            this.titleSP = i * 15;
            this.desSP = i * 9;
            this.barWidth = (int) (ScreenUtil.dip2pxScale(f, 192.0f) * this.templateScale);
            this.barHeight = (int) (ScreenUtil.dip2pxScale(f, 42.6f) * this.templateScale);
            this.barBottom = (int) (ScreenUtil.dip2pxScale(f, 25.0f) * this.templateScale);
            this.actionTop = (int) (ScreenUtil.dip2pxScale(f, 4.8f) * this.templateScale);
            float fDip2pxScale2 = ScreenUtil.dip2pxScale(f, 80.0f);
            float f3 = this.templateScale;
            this.actionSize = (int) (fDip2pxScale2 * f3);
            this.actionTitleSP = (int) (12.0f * f3);
            this.actionDesSP = (int) (f3 * 9.0f);
            this.actionSlideWidth = (int) (ScreenUtil.dip2pxScale(f, 40.0f) * this.templateScale);
            this.actionSlideHeight = (int) (ScreenUtil.dip2pxScale(f, 36.0f) * this.templateScale);
            this.complianceBottom = (int) (ScreenUtil.dip2pxScale(f, 1.0f) * this.templateScale);
            return;
        }
        if (interactiveSize == InterTemplateData.InteractiveSize.BIG) {
            this.logoSize = (int) (ScreenUtil.dip2pxScale(f, 50.0f) * this.templateScale);
            this.iconTopMargin = (int) (ScreenUtil.dip2pxScale(f, 30.0f) * this.templateScale);
            this.titleTopMargin = (int) (ScreenUtil.dip2pxScale(f, 5.0f) * this.templateScale);
            float fDip2pxScale3 = ScreenUtil.dip2pxScale(f, 7.0f);
            float f4 = this.templateScale;
            this.desTopMargin = (int) (fDip2pxScale3 * f4);
            this.titleSP = (int) (18.0f * f4);
            this.desSP = (int) (f4 * 12.0f);
            this.barWidth = (int) (ScreenUtil.dip2pxScale(f, 288.0f) * this.templateScale);
            this.barHeight = (int) (ScreenUtil.dip2pxScale(f, 64.0f) * this.templateScale);
            this.barBottom = (int) (ScreenUtil.dip2pxScale(f, 37.0f) * this.templateScale);
            this.actionTop = (int) (ScreenUtil.dip2pxScale(f, 7.2f) * this.templateScale);
            float fDip2pxScale4 = ScreenUtil.dip2pxScale(f, 120.0f);
            float f5 = this.templateScale;
            this.actionSize = (int) (fDip2pxScale4 * f5);
            this.actionTitleSP = (int) (16.0f * f5);
            this.actionDesSP = (int) (f5 * 13.0f);
            this.actionSlideWidth = (int) (ScreenUtil.dip2pxScale(f, 60.0f) * this.templateScale);
            this.actionSlideHeight = (int) (ScreenUtil.dip2pxScale(f, 55.0f) * this.templateScale);
            this.complianceBottom = (int) (ScreenUtil.dip2pxScale(f, 3.0f) * this.templateScale);
            return;
        }
        this.logoSize = (int) (ScreenUtil.dip2pxScale(f, 42.5f) * this.templateScale);
        this.iconTopMargin = (int) (ScreenUtil.dip2pxScale(f, 25.0f) * this.templateScale);
        this.titleTopMargin = (int) (ScreenUtil.dip2pxScale(f, 4.8f) * this.templateScale);
        float fDip2pxScale5 = ScreenUtil.dip2pxScale(f, 3.5f);
        float f6 = this.templateScale;
        this.desTopMargin = (int) (fDip2pxScale5 * f6);
        this.titleSP = (int) (16.0f * f6);
        this.desSP = (int) (f6 * 10.0f);
        this.barWidth = (int) (ScreenUtil.dip2pxScale(f, 240.0f) * this.templateScale);
        this.barHeight = (int) (ScreenUtil.dip2pxScale(f, 53.0f) * this.templateScale);
        this.barBottom = (int) (ScreenUtil.dip2pxScale(f, 31.0f) * this.templateScale);
        this.actionTop = (int) (ScreenUtil.dip2pxScale(f, 6.0f) * this.templateScale);
        float fDip2pxScale6 = ScreenUtil.dip2pxScale(f, 100.0f);
        float f7 = this.templateScale;
        this.actionSize = (int) (fDip2pxScale6 * f7);
        this.actionTitleSP = (int) (14.0f * f7);
        this.actionDesSP = (int) (f7 * 11.0f);
        this.actionSlideWidth = (int) (ScreenUtil.dip2pxScale(f, 50.0f) * this.templateScale);
        this.actionSlideHeight = (int) (ScreenUtil.dip2pxScale(f, 45.0f) * this.templateScale);
        this.complianceBottom = (int) (ScreenUtil.dip2pxScale(f, 2.0f) * this.templateScale);
    }

    public String toString() {
        return "TemplateV3Size{logoSize=" + this.logoSize + ", titleSP=" + this.titleSP + ", iconTopMargin=" + this.iconTopMargin + ", titleTopMargin=" + this.titleTopMargin + ", desTopMargin=" + this.desTopMargin + ", desSP=" + this.desSP + ", actionSize=" + this.actionSize + ", actionTitleSP=" + this.actionTitleSP + ", actionDesSP=" + this.actionDesSP + ", barWidth=" + this.barWidth + ", barHeight=" + this.barHeight + ", barBottom=" + this.barBottom + ", actionSlideWidth=" + this.actionSlideWidth + ", actionSlideHeight=" + this.actionSlideHeight + ", templateScale=" + this.templateScale + '}';
    }
}
