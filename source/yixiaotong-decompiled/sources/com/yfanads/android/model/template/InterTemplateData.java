package com.yfanads.android.model.template;

import android.content.Context;
import com.yfanads.ads.R;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class InterTemplateData extends BaseTemplateData {
    protected boolean autoAnimator;
    protected boolean isPortrait;
    public InteractiveSize size;

    public enum InteractiveSize {
        SMALL,
        NORMAL,
        BIG,
        BIGGEST
    }

    public InterTemplateData(Context context, String str, TemplateConf templateConf) {
        super(str);
        this.autoAnimator = true;
        this.type = str;
        this.conf = templateConf;
        updNativeSize(context, 1);
    }

    private double getScale() {
        TemplateConf templateConf = this.conf;
        int i = templateConf == null ? 2 : templateConf.ts;
        if (i == 1) {
            this.size = InteractiveSize.SMALL;
            return 0.552d;
        }
        if (i == 3) {
            this.size = InteractiveSize.BIG;
            return 0.792d;
        }
        if (i != 4) {
            this.size = InteractiveSize.NORMAL;
            return 0.684d;
        }
        this.size = InteractiveSize.BIGGEST;
        return 0.9d;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public int getCloseLoc() {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return 2;
        }
        return templateConf.cbp;
    }

    public int getComplianceColor(Context context) {
        String str = this.type;
        str.getClass();
        return !str.equals(TemplateRes.INT_V_3) ? context.getResources().getColor(R.color.ad_color_66ffffff) : context.getResources().getColor(R.color.ad_color_66000000);
    }

    public int getTextSizeSP() {
        String str = this.type;
        str.getClass();
        if (str.equals(TemplateRes.INT_V_3)) {
            return this.isPortrait ? 6 : 4;
        }
        return this.isPortrait ? 8 : 6;
    }

    public boolean isClickClose() {
        TemplateConf templateConf = this.conf;
        return templateConf != null && templateConf.jc == 1;
    }

    public boolean isCloseBottom() {
        TemplateConf templateConf = this.conf;
        return templateConf != null && templateConf.cbp == 3;
    }

    public boolean isPhyClose() {
        TemplateConf templateConf = this.conf;
        return templateConf != null && templateConf.pkb == 1;
    }

    public boolean isPortrait() {
        return this.isPortrait;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public void resetActivityStyle(int i) {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return;
        }
        templateConf.is = i;
    }

    public void updNativeSize(Context context, int i, boolean z) {
        this.autoAnimator = z;
        updNativeSize(context, i);
    }

    public void updNativeSize(Context context, int i) {
        if (YFAdsPhone.getInstance().isLandscape(context, i, 1.68f)) {
            this.isPortrait = false;
            int windowHeight = (int) (((double) ScreenUtil.getWindowHeight(context)) * 0.8d);
            this.popHeight = windowHeight;
            this.popWidth = (windowHeight * 9) / 16;
            return;
        }
        this.isPortrait = true;
        int windowWidth = (int) (((double) ScreenUtil.getWindowWidth(context)) * getScale());
        this.popWidth = windowWidth;
        this.popHeight = (windowWidth * 16) / 9;
    }

    public InterTemplateData(Context context, String str, TemplateConf templateConf, int i) {
        super(str);
        this.autoAnimator = true;
        this.type = str;
        this.conf = templateConf;
        updNativeSize(context, i);
    }
}
