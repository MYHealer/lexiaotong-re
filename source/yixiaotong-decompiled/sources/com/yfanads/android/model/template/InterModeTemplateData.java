package com.yfanads.android.model.template;

import android.content.Context;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class InterModeTemplateData extends InterTemplateData {
    static final String U_TYPE = "InterModeType";

    public InterModeTemplateData(Context context, TemplateConf templateConf) {
        super(context, U_TYPE, templateConf);
    }

    public int getBottomHeight(Context context) {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return 0;
        }
        int i = templateConf.cbs;
        if (i == 1) {
            return ScreenUtil.dip2px(context, 17.5f);
        }
        if (i == 2) {
            return ScreenUtil.dip2px(context, 21.25f);
        }
        if (i != 4) {
            return i != 5 ? ScreenUtil.dip2px(context, 25.0f) : ScreenUtil.dip2px(context, 40.0f);
        }
        return ScreenUtil.dip2px(context, 32.5f);
    }

    public boolean isShowClose() {
        TemplateConf templateConf = this.conf;
        return (templateConf == null || templateConf.cbm == 0) ? false : true;
    }

    public boolean isShowCountdown() {
        TemplateConf templateConf = this.conf;
        return templateConf != null && templateConf.cbm == 1;
    }
}
