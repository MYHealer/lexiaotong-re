package com.yfanads.android.custom;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.stub.StubApp;
import com.yfanads.android.core.h;
import com.yfanads.android.core.k;
import com.yfanads.android.core.textlink.YFTextLinkSetting;
import com.yfanads.android.custom.view.AdTLViewHolder;
import com.yfanads.android.model.template.TLTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class TextLinkCustomAdapter extends k {
    public YFTextLinkSetting setting;

    public TextLinkCustomAdapter(YFTextLinkSetting yFTextLinkSetting) {
        super(yFTextLinkSetting);
        this.setting = yFTextLinkSetting;
    }

    public void bindData(Activity activity, TLTemplateData tLTemplateData, ViewGroup viewGroup, AdTLViewHolder adTLViewHolder) {
    }

    public void closeAds(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        handleClose();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.setting != null) {
            this.setting = null;
        }
    }

    public int getAdType() {
        return -1;
    }

    public ViewGroup getNativeAdContainer() {
        return null;
    }

    public int getSize() {
        return 0;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    public void addView(Activity activity, ViewGroup viewGroup) {
        YFLog.debug(this.tag + " addView key TL_V_1");
        int template = TemplateRes.getTemplate(TemplateRes.TL_V_1);
        if (template == 0) {
            handleRenderFailed(0, " addView error has no id");
            return;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
        TLTemplateData tLTemplateData = new TLTemplateData(origApplicationContext, TemplateRes.TL_V_1, this.setting.getConfig());
        tLTemplateData.setConf(this.sdkSupplier.getTemplateConf());
        View viewInflate = LayoutInflater.from(activity).inflate(template, (ViewGroup) null, false);
        int i = tLTemplateData.popWidth;
        if (i <= 0) {
            i = -2;
        }
        int i2 = tLTemplateData.popHeight;
        int i3 = i2 > 0 ? i2 : -2;
        int screenWidth = ScreenUtil.getScreenWidth(origApplicationContext);
        if (i > screenWidth) {
            i = screenWidth;
        }
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(i, i3));
        if (viewGroup == null) {
            h.a(new StringBuilder(), this.tag, " viewGroup is null");
            return;
        }
        viewGroup.addView(viewInflate);
        bindData(activity, tLTemplateData, viewGroup, new AdTLViewHolder(viewInflate));
        addViewLister(viewInflate);
        handleApiExposure();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        if (this.setting == null) {
            h.a(new StringBuilder(), this.tag, " setting is null, return.");
        } else {
            handleShowApiInvoke();
        }
    }
}
