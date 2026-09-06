package com.yfanads.android.custom;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.core.draw.YFDrawSetting;
import com.yfanads.android.core.e;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class DrawCustomAdapter extends BaseChanelAdapter {
    public YFDrawSetting mDrawSetting;

    public DrawCustomAdapter(YFDrawSetting yFDrawSetting) {
        super(yFDrawSetting);
        this.mDrawSetting = yFDrawSetting;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.mDrawSetting != null) {
            this.mDrawSetting = null;
        }
    }

    public void doShowAD(Activity activity) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        doShowAD(activity);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isUpdStatus() {
        return false;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFDrawSetting) {
            this.mDrawSetting = (YFDrawSetting) baseAdapterEvent;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0054  */
    /* JADX WARN: Code duplicated, block: B:19:0x0062  */
    public boolean addADView(View view, ViewGroup viewGroup) {
        boolean z;
        ViewParent parent;
        try {
            if (this.mDrawSetting != null) {
                if (viewGroup != null) {
                    viewGroup.removeAllViews();
                    if (view != null && (parent = view.getParent()) != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    viewGroup.addView(view);
                    z = true;
                } else {
                    YFLog.error(this.tag + "无法展示广告，原因：未设置广告承载布局，请检查 setAdContainer(ViewGroup adContainer) 方法是否有赋值");
                }
                if (!z) {
                    handleRenderFailed(YFUtil.toInt(YFAdError.ERROR_EXCEPTION_RENDER, 9904), "添加广告视图操作失败");
                } else {
                    e.a(new StringBuilder(), this.tag, " ADView has Added");
                }
                return z;
            }
            YFLog.error(this.tag + "无法展示广告，原因：内部处理异常，mDrawSetting 为空");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        z = false;
        if (!z) {
            handleRenderFailed(YFUtil.toInt(YFAdError.ERROR_EXCEPTION_RENDER, 9904), "添加广告视图操作失败");
        } else {
            e.a(new StringBuilder(), this.tag, " ADView has Added");
        }
        return z;
    }
}
