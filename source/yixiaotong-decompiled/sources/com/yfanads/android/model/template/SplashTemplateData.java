package com.yfanads.android.model.template;

import android.content.Context;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class SplashTemplateData extends BaseTemplateData {
    private static final Map<Integer, String[]> ACTIVITY_STYLES_V2;
    private boolean isFullScreen;

    static {
        HashMap map = new HashMap();
        ACTIVITY_STYLES_V2 = map;
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.NONE.value), new String[]{"", ""});
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.CLICK_V3.value), new String[]{"", "click/bar_splash.json"});
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.CLICK.value), new String[]{"", "click/bar_splash.json"});
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.SHAKE.value), new String[]{"shake/action_inter_v3.json", ""});
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.CLICK_SHAKE.value), new String[]{"shake/action_inter_v3.json", ""});
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.TWIST.value), new String[]{"shake/action_inter_v3.json", ""});
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.CLICK_TWIST.value), new String[]{"shake/action_inter_v3.json", ""});
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.SLIDE.value), new String[]{"slide/action_splash.json", ""});
        map.put(Integer.valueOf(BaseTemplateData.InteractiveStyle.CLICK_SLIDE.value), new String[]{"slide/action_splash.json", ""});
    }

    public SplashTemplateData(String str, boolean z) {
        super(str);
        this.isFullScreen = z;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public String[] getActiveStylePath() {
        if (!isTemplateV2()) {
            return super.getActiveStylePath();
        }
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return new String[]{"", ""};
        }
        String[] strArr = ACTIVITY_STYLES_V2.get(Integer.valueOf(templateConf.is));
        return (strArr == null || strArr.length <= 1) ? new String[]{"", ""} : strArr;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public int getCloseLoc() {
        int i;
        TemplateConf templateConf = this.conf;
        if (templateConf == null || (i = templateConf.cbp) == 0) {
            return 1;
        }
        return i;
    }

    public int getSplashCloseStyle() {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return 1;
        }
        return templateConf.sbs;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public int getV3AutoCloseSP() {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return 14;
        }
        int i = templateConf.cbs;
        if (i == 1) {
            return 4;
        }
        if (i == 2) {
            return 5;
        }
        if (i != 3) {
            return i != 4 ? 14 : 10;
        }
        return 7;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public int getV3CloseSize(Context context) {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return ScreenUtil.dip2px(context, 30.0f);
        }
        int i = templateConf.cbs;
        if (i == 1) {
            return ScreenUtil.dip2px(context, 7.5f);
        }
        if (i == 2) {
            return ScreenUtil.dip2px(context, 11.2f);
        }
        if (i != 3) {
            return i != 4 ? ScreenUtil.dip2px(context, 30.0f) : ScreenUtil.dip2px(context, 22.5f);
        }
        return ScreenUtil.dip2px(context, 15.0f);
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public boolean isBigStyle() {
        TemplateConf templateConf;
        return isTemplateV2() && (templateConf = this.conf) != null && templateConf.bs == 2;
    }

    public boolean isShowTopArea(boolean z) {
        if (YFAdsPhone.getInstance().isTablet()) {
            return false;
        }
        return this.isFullScreen;
    }

    public boolean isTemplateV1() {
        return TemplateRes.SPLASH_V1.equals(this.type);
    }

    public boolean isTemplateV2() {
        return TemplateRes.SPLASH_V2.equals(this.type);
    }
}
