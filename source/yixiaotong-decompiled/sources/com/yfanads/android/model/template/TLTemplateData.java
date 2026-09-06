package com.yfanads.android.model.template;

import android.content.Context;
import android.text.TextUtils;
import com.yfanads.ads.libs.R;
import com.yfanads.android.core.textlink.TLParams;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.utils.ScreenUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class TLTemplateData extends BaseTemplateData {
    private final TLParams params;

    public TLTemplateData(Context context, String str, TLParams tLParams) {
        super(str);
        this.params = tLParams;
        updateParams(context);
    }

    public int getCloseRes() {
        TemplateConf templateConf = this.conf;
        if (templateConf == null) {
            return -1;
        }
        int i = templateConf.cbs;
        if (i == 1) {
            return R.mipmap.yf_tl_close_6;
        }
        if (i == 2) {
            return R.mipmap.yf_tl_close_9;
        }
        if (i != 4) {
            return i != 5 ? R.mipmap.yf_tl_close_12 : R.mipmap.yf_tl_close_18;
        }
        return R.mipmap.yf_tl_close_15;
    }

    public String getTitle() {
        TemplateConf templateConf = this.conf;
        return (templateConf == null || TextUtils.isEmpty(templateConf.cc)) ? "" : this.conf.cc;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public boolean isShake() {
        return isActionType(BaseTemplateData.InteractiveStyle.SHAKE.getValue(), BaseTemplateData.InteractiveStyle.CLICK_SHAKE.getValue());
    }

    public boolean isShowIcon() {
        TemplateConf templateConf = this.conf;
        return templateConf == null || templateConf.sai == 1;
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public void setConf(TemplateConf templateConf) {
        this.conf = templateConf;
    }

    private void updateParams(Context context) {
        TLParams tLParams = this.params;
        if (tLParams == null) {
            return;
        }
        this.popWidth = tLParams.getWidth() > 0 ? ScreenUtil.dip2px(context, this.params.getWidth()) : 0;
        this.popHeight = this.params.getHeight() > 0 ? ScreenUtil.dip2px(context, this.params.getHeight()) : 0;
    }

    public int getBgColor() {
        TLParams tLParams = this.params;
        if (tLParams == null) {
            return 687865856;
        }
        return tLParams.getBgColor();
    }

    public int getFontColor() {
        TLParams tLParams = this.params;
        if (tLParams == null) {
            return -12303292;
        }
        return tLParams.getFontColor();
    }

    public int getFontSize() {
        TLParams tLParams = this.params;
        if (tLParams == null) {
            return 19;
        }
        return tLParams.getFontSize();
    }

    public int getRadius() {
        TLParams tLParams = this.params;
        if (tLParams == null) {
            return 12;
        }
        return tLParams.getRadius();
    }
}
