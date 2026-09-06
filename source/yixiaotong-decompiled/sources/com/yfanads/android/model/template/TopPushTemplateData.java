package com.yfanads.android.model.template;

import android.content.Context;
import android.text.TextUtils;
import com.yfanads.ads.R;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TopPushTemplateData extends BaseTemplateData {
    protected boolean autoAnimator;
    public InteractiveSize size;

    public enum InteractiveSize {
        SMALL,
        NORMAL,
        BIG,
        BIGGEST
    }

    public TopPushTemplateData(Context context, String str, TemplateConf templateConf) {
        super(str);
        this.autoAnimator = true;
        this.conf = templateConf;
        updNativeSize(context);
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

    public String getReplaceDesc() {
        TemplateConf templateConf = this.conf;
        return templateConf == null ? "" : templateConf.rc;
    }

    public String getReplaceTitle() {
        TemplateConf templateConf = this.conf;
        return templateConf == null ? "" : templateConf.rt;
    }

    public int getShowLoc() {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return 1;
        }
        return templateConf.dtsp;
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

    public boolean isReplaceTitle() {
        TemplateConf templateConf = this.conf;
        return templateConf != null && templateConf.rcs == 1;
    }

    public boolean isView(String str) {
        return !TextUtils.isEmpty(str) && this.type.equals(str);
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public void resetActivityStyle(int i) {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return;
        }
        templateConf.is = i;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public void updAdLog(int i) {
        if (isHideAdLogo()) {
            i = com.yfanads.ads.libs.R.mipmap.yf_ad_logo_no;
        }
        this.adLogo = i;
    }

    public void updNativeSize(Context context, boolean z) {
        this.autoAnimator = z;
        updNativeSize(context);
    }

    public void updNativeSize(Context context) {
        int windowWidth = ScreenUtil.getWindowWidth(context) - ScreenUtil.dip2px(context, 20.0f);
        this.popWidth = windowWidth;
        this.popHeight = windowWidth / 6;
    }
}
