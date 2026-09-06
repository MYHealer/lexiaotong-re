package com.yfanads.android.model.template;

import android.content.Context;
import android.text.TextUtils;
import com.yfanads.ads.R;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class BannerTemplateData extends BaseTemplateData {
    public BannerTemplateData(Context context, String str, int i, int i2) {
        this(context, str, i, i2, false);
    }

    private int getExtHeight(Context context, boolean z) {
        String str = this.type;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "W600xH400":
                return ScreenUtil.dip2px(context, 40.0f);
            case "W600xH150_L_P_R_T":
                if (z) {
                    return ScreenUtil.dip2px(context, 10.0f);
                }
                return 0;
            case "VER_TD_BP":
                return ScreenUtil.dip2px(context, 52.0f);
            case "W600xH260_L_P_R_T":
                return ScreenUtil.dip2px(context, 20.0f);
            default:
                return 0;
        }
    }

    private int getHeight(Context context, int i, String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "640x100":
            case "W640xH100_L_P_R_T":
            case "640x100R":
                return i / 6;
            case "W600xH410_T_T_B_P":
                return (int) ((((double) i) * 4.1d) / 6.0d);
            case "W600xH400":
                return (i * 9) / 16;
            case "W600xH150_L_P_R_T":
            case "600x150R":
            case "600x150":
                return (i * 150) / 600;
            case "600x260R":
            case "600x260":
                return (i * 260) / 600;
            case "600x400D":
            case "600x400":
                return (i * 4) / 6;
            case "VER_TD_BP":
                return (i * 16) / 9;
            case "W600xH260_L_P_R_T":
                return ((i * 260) / 600) - ScreenUtil.dip2px(context, 30.0f);
            default:
                return 0;
        }
    }

    private int getMinWidth(Context context, String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "W600xH410_T_T_B_P":
            case "W640xH100_L_P_R_T":
            case "W600xH150_L_P_R_T":
            case "W600xH260_L_P_R_T":
                return ScreenUtil.dip2px(context, 220.0f);
            case "VER_TD_BP":
                return (int) (((double) ScreenUtil.getScreenWidth(context)) * 0.25d);
            default:
                return ScreenUtil.dip2px(context, 200.0f);
        }
    }

    private void updNativeSize(Context context, int i, int i2, boolean z) {
        int iDip2px = ScreenUtil.dip2px(context, i);
        int minWidth = getMinWidth(context, this.type);
        int screenWidth = ScreenUtil.getScreenWidth(context);
        if (iDip2px < minWidth) {
            YFLog.debug("updNativeSize Less than the minimum width widthPx_" + minWidth + " minWidthPx_" + minWidth);
            iDip2px = minWidth;
        }
        if (iDip2px > screenWidth) {
            YFLog.debug("updNativeSize Larger than the maximum width widthPx_" + screenWidth + " screenWidth_" + screenWidth);
            iDip2px = screenWidth;
        }
        if (screenWidth > 0) {
            this.scale = (iDip2px * 100) / screenWidth;
        }
        this.popWidth = iDip2px;
        int extHeight = getExtHeight(context, z);
        this.height = getHeight(context, iDip2px, this.type);
        int iDip2px2 = i2 == 0 ? 0 : ScreenUtil.dip2px(context, i2);
        if (TemplateRes.BANNER_VTB.equals(this.type) && iDip2px2 < this.height && iDip2px2 > 0 && iDip2px2 > extHeight) {
            this.height = iDip2px2;
        }
        this.popHeight = this.height + extHeight;
        YFLog.high("updNativeSize popWidth= " + iDip2px + " , popHeight= " + this.popHeight + " , height= " + this.height + " , scale=" + this.scale + ", screenWidth=" + screenWidth);
    }

    public int getCloseResV3() {
        String str = this.type;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "600x260R":
            case "600x400D":
            case "600x400":
                return getBlackCloseRes();
            default:
                return getWhiteCloseRes();
        }
    }

    public int getComplianceColor(Context context) {
        String str = this.type;
        str.getClass();
        str.hashCode();
        switch (str) {
            case "640x100":
            case "W600xH150_L_P_R_T":
            case "640x100R":
            case "600x150R":
            case "600x260R":
            case "600x400D":
            case "W600xH260_L_P_R_T":
            case "600x150":
            case "600x260":
            case "600x400":
                return context.getResources().getColor(R.color.ad_color_80000000);
            case "W640xH100_L_P_R_T":
                return context.getResources().getColor(R.color.ad_color_66666666);
            default:
                return context.getResources().getColor(R.color.ad_color_66ffffff);
        }
    }

    public boolean isClose2() {
        String str = this.type;
        str.getClass();
        return str.equals(TemplateRes.BANNER_WH615) || str.equals(TemplateRes.BANNER_WH626);
    }

    public boolean isClose3() {
        return this.type.equals(TemplateRes.BANNER_WH610);
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public boolean isShake() {
        return isActionType(BaseTemplateData.InteractiveStyle.SHAKE.getValue(), BaseTemplateData.InteractiveStyle.CLICK_SHAKE.getValue());
    }

    public boolean isShowAdIcon() {
        return TemplateRes.BANNER_WH641.equals(this.type) || isTemplateV3_W640();
    }

    public boolean isShowTitleAndDes() {
        return TemplateRes.BANNER_WH626.equals(this.type) || TemplateRes.BANNER_WH615.equals(this.type) || TemplateRes.BANNER_VTB.equals(this.type) || TemplateRes.BANNER_WH615_ZW_YT.equals(this.type) || TemplateRes.BANNER_WH615_ZT_YW.equals(this.type) || TemplateRes.BANNER_WH626_ZW_YT.equals(this.type) || TemplateRes.BANNER_WH626_ZT_YW.equals(this.type);
    }

    public boolean isTemplateV3() {
        return TemplateRes.BANNER_WH640_ST_XW.equals(this.type) || TemplateRes.BANNER_WH640_SW_XT.equals(this.type) || TemplateRes.BANNER_WH615_ZW_YT.equals(this.type) || TemplateRes.BANNER_WH615_ZT_YW.equals(this.type) || TemplateRes.BANNER_WH610_ZW_YT.equals(this.type) || TemplateRes.BANNER_WH610_ZT_YW.equals(this.type) || TemplateRes.BANNER_WH626_ZW_YT.equals(this.type) || TemplateRes.BANNER_WH626_ZT_YW.equals(this.type);
    }

    public boolean isTemplateV3_W610() {
        return TemplateRes.BANNER_WH610_ZW_YT.equals(this.type) || TemplateRes.BANNER_WH610_ZT_YW.equals(this.type);
    }

    public boolean isTemplateV3_W615() {
        return TemplateRes.BANNER_WH615_ZW_YT.equals(this.type) || TemplateRes.BANNER_WH615_ZT_YW.equals(this.type);
    }

    public boolean isTemplateV3_W626() {
        return TemplateRes.BANNER_WH626_ZW_YT.equals(this.type) || TemplateRes.BANNER_WH626_ZT_YW.equals(this.type);
    }

    public boolean isTemplateV3_W640() {
        return TemplateRes.BANNER_WH640_ST_XW.equals(this.type) || TemplateRes.BANNER_WH640_SW_XT.equals(this.type);
    }

    public boolean isView(String str) {
        return !TextUtils.isEmpty(str) && this.type.equals(str);
    }

    @Override // com.yfanads.android.model.template.BaseTemplateData
    public void setConf(TemplateConf templateConf) {
        this.conf = templateConf;
    }

    public boolean showDownloadBtn() {
        return TemplateRes.BANNER_WH626.equals(this.type) || TemplateRes.BANNER_WH640.equals(this.type) || TemplateRes.BANNER_WH610.equals(this.type) || TemplateRes.BANNER_WH641.equals(this.type) || isTemplateV3();
    }

    public BannerTemplateData(Context context, String str, int i, int i2, boolean z) {
        super(str);
        updNativeSize(context, i, i2, z);
    }
}
