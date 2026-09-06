package com.yfanads.android.model.template;

import android.content.Context;
import android.text.TextUtils;
import com.yfanads.ads.R;
import com.yfanads.android.model.TemplateConf;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ShopMallTemplateData extends BaseTemplateData {
    private String amount;
    private int redType;

    public ShopMallTemplateData(String str, TemplateConf templateConf) {
        super(str);
        this.amount = "";
        this.conf = templateConf;
    }

    public String getFloatingContentBottom(Context context) {
        String string = context.getString(R.string.yf_red_pocket);
        if (TextUtils.isEmpty(this.amount)) {
            return context.getString(R.string.yf_red_pocket_text2);
        }
        return this.amount.endsWith(string) ? context.getString(R.string.yf_red_pocket_text2) + this.amount : context.getString(R.string.yf_red_pocket_text2) + this.amount + string;
    }

    public int getFloatingLoc() {
        TemplateConf templateConf = this.conf;
        if (templateConf != null) {
            return templateConf.ip;
        }
        return 4;
    }

    public long getFloatingTime() {
        TemplateConf templateConf = this.conf;
        if (templateConf != null) {
            return templateConf.ccst;
        }
        return 0L;
    }

    public String getRedPocketMoney(Context context) {
        String string = context.getString(R.string.yf_red_pocket);
        if (isHideMoneyDes()) {
            return context.getString(R.string.yf_coupon_text_default);
        }
        return this.amount.endsWith(string) ? this.amount.replace(string, "") : this.amount;
    }

    public int getShopMallType() {
        return this.redType;
    }

    public boolean isHideMoneyDes() {
        return TextUtils.isEmpty(this.amount);
    }

    public boolean isRedPocketCops() {
        int i = this.redType;
        return (i == 1 || i == 2) ? false : true;
    }

    public void setAmount(int i, String str) {
        this.redType = i;
        this.amount = str;
    }

    public String getFloatingContentTop(Context context) {
        TemplateConf templateConf = this.conf;
        String str = templateConf != null ? templateConf.cc : "";
        return TextUtils.isEmpty(str) ? context.getString(R.string.yf_red_pocket_text1) : str;
    }

    public int getRedPocketBgRes() {
        int i = this.redType;
        if (i == 1) {
            return R.mipmap.yf_shopmall_new;
        }
        if (i != 2) {
            return R.mipmap.yf_shopmall_money;
        }
        return R.mipmap.yf_shopmall_cx;
    }
}
