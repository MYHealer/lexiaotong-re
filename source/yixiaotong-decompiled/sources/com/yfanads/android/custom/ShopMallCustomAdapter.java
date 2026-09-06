package com.yfanads.android.custom;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.ads.R;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.e;
import com.yfanads.android.core.f;
import com.yfanads.android.core.h;
import com.yfanads.android.core.k;
import com.yfanads.android.core.shop.YFShopMallSetting;
import com.yfanads.android.custom.view.AdShopMallHolder;
import com.yfanads.android.custom.view.CustomByDialog;
import com.yfanads.android.custom.view.FloatingIconDialog;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.ShopMallTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class ShopMallCustomAdapter extends k {
    private FloatingIconDialog floatingIconDialog;
    private boolean hasClose;
    private CustomByDialog redPocketDialog;
    public YFShopMallSetting setting;

    public ShopMallCustomAdapter(YFShopMallSetting yFShopMallSetting) {
        super(yFShopMallSetting);
        this.setting = yFShopMallSetting;
    }

    private void startFloatingView(final Activity activity, final ShopMallTemplateData shopMallTemplateData) {
        closeFloatingIconDialog();
        FloatingIconDialog floatingIconDialogBuild = new FloatingIconDialog.FloatingIconBuilder().setLayoutId(R.layout.yf_shop_floating_icon).setLocationType(shopMallTemplateData.getFloatingLoc()).build();
        this.floatingIconDialog = floatingIconDialogBuild;
        floatingIconDialogBuild.create(activity);
        this.floatingIconDialog.show();
        final AdShopMallHolder adShopMallHolder = new AdShopMallHolder(shopMallTemplateData.type, this.floatingIconDialog.getDialogView());
        bindData(activity, shopMallTemplateData, adShopMallHolder);
        this.floatingIconDialog.setOnIconClickListener(new FloatingIconDialog.OnIconClickListener() { // from class: com.yfanads.android.custom.ShopMallCustomAdapter.1
            @Override // com.yfanads.android.custom.view.FloatingIconDialog.OnIconClickListener
            public void onIconClick() {
                e.a(new StringBuilder(), ShopMallCustomAdapter.this.tag, "click floating icon by dialog");
                ShopMallCustomAdapter.this.skipToFloatingMallPage(activity, x.cL);
            }

            @Override // com.yfanads.android.custom.view.FloatingIconDialog.OnIconClickListener
            public void onLocationType(boolean z) {
                YFLog.high(ShopMallCustomAdapter.this.tag + "floating icon location type " + z);
                adShopMallHolder.updFloatingView(z);
            }
        });
        adShopMallHolder.getTargetView().setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.ShopMallCustomAdapter$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1227x519c951f(activity, view);
            }
        });
        adShopMallHolder.getFloatingCloseIV().setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.ShopMallCustomAdapter$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1228x43463b3e(adShopMallHolder, shopMallTemplateData, activity, view);
            }
        });
        adShopMallHolder.updFloatingIconView(getContext(), shopMallTemplateData, new AdShopMallHolder.FloatingCallback() { // from class: com.yfanads.android.custom.ShopMallCustomAdapter$$ExternalSyntheticLambda2
            @Override // com.yfanads.android.custom.view.AdShopMallHolder.FloatingCallback
            public final void draggingResult(boolean z) {
                this.f$0.m1229x34efe15d(z);
            }
        });
        addViewLister(adShopMallHolder.getRootView());
    }

    private void startRedPocketView(final Activity activity, final ShopMallTemplateData shopMallTemplateData) {
        closeRedPocketDialog();
        CustomByDialog customByDialogBuild = new CustomByDialog.CustomByDialogBuilder().setLayoutId(R.layout.yf_shop_dialog).build();
        this.redPocketDialog = customByDialogBuild;
        customByDialogBuild.create(activity);
        this.redPocketDialog.show();
        final AdShopMallHolder adShopMallHolder = new AdShopMallHolder(shopMallTemplateData.type, this.redPocketDialog.getDialogView());
        bindData(activity, shopMallTemplateData, adShopMallHolder);
        adShopMallHolder.getTargetView().setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.ShopMallCustomAdapter$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1230x91b3ddaa(activity, view);
            }
        });
        adShopMallHolder.getFloatingCloseIV().setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.ShopMallCustomAdapter$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m1231x835d83c9(adShopMallHolder, shopMallTemplateData, activity, view);
            }
        });
        adShopMallHolder.updRedPacketView(getContext(), shopMallTemplateData);
        addViewLister(adShopMallHolder.getRootView());
    }

    public boolean addView(Activity activity) {
        return addView(activity, null, 0);
    }

    public void bindData(Activity activity, ShopMallTemplateData shopMallTemplateData, AdShopMallHolder adShopMallHolder) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void closeAds() {
        super.closeAds();
        try {
            if (this.hasClose) {
                YFLog.debug(this.tag + " closeAds hasClose, return");
                return;
            }
            YFLog.debug(this.tag + " closeAds");
            this.hasClose = true;
            removeListener();
            handleClose();
        } catch (Exception e) {
            f.a(e, new StringBuilder().append(this.tag).append(" closeAds error "));
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
    public void handleExposure() {
        super.handleExposure();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    /* JADX INFO: renamed from: lambda$startFloatingView$2$com-yfanads-android-custom-ShopMallCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1227x519c951f(Activity activity, View view) {
        e.a(new StringBuilder(), this.tag, "click floating icon by dialog");
        skipToFloatingMallPage(activity, TypedValues.AttributesType.S_TARGET);
    }

    /* JADX INFO: renamed from: lambda$startFloatingView$3$com-yfanads-android-custom-ShopMallCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1228x43463b3e(AdShopMallHolder adShopMallHolder, ShopMallTemplateData shopMallTemplateData, Activity activity, View view) {
        YFLog.high(this.tag + "click floating icon close");
        if (System.currentTimeMillis() - adShopMallHolder.getFCloseShowTime() < shopMallTemplateData.getCloseDelay()) {
            e.a(new StringBuilder(), this.tag, "click floating icon close in delay");
            skipToFloatingMallPage(activity, "close");
        } else {
            removeListener();
            closeFloatingIconDialog();
            handleClose();
        }
    }

    /* JADX INFO: renamed from: lambda$startFloatingView$4$com-yfanads-android-custom-ShopMallCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1229x34efe15d(boolean z) {
        if (z) {
            e.a(new StringBuilder(), this.tag, " floating icon dragging");
            FloatingIconDialog floatingIconDialog = this.floatingIconDialog;
            if (floatingIconDialog != null) {
                floatingIconDialog.startDragging();
                return;
            }
            return;
        }
        e.a(new StringBuilder(), this.tag, " floating icon dragging end");
        FloatingIconDialog floatingIconDialog2 = this.floatingIconDialog;
        if (floatingIconDialog2 != null) {
            floatingIconDialog2.stopDragging();
        }
    }

    /* JADX INFO: renamed from: lambda$startRedPocketView$0$com-yfanads-android-custom-ShopMallCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1230x91b3ddaa(Activity activity, View view) {
        e.a(new StringBuilder(), this.tag, "click red packet by dialog");
        skipToFloatingMallPage(activity, TypedValues.AttributesType.S_TARGET);
    }

    /* JADX INFO: renamed from: lambda$startRedPocketView$1$com-yfanads-android-custom-ShopMallCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1231x835d83c9(AdShopMallHolder adShopMallHolder, ShopMallTemplateData shopMallTemplateData, Activity activity, View view) {
        YFLog.high(this.tag + "click red packet close");
        if (System.currentTimeMillis() - adShopMallHolder.getFCloseShowTime() < shopMallTemplateData.getCloseDelay()) {
            e.a(new StringBuilder(), this.tag, "click red packet close in delay");
            skipToFloatingMallPage(activity, "close");
        } else {
            removeListener();
            closeRedPocketDialog();
            handleClose();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFShopMallSetting) {
            this.setting = (YFShopMallSetting) baseAdapterEvent;
        }
    }

    public void skipToFloatingMallPage(Activity activity, String str) {
        closeFloatingIconDialog();
        closeRedPocketDialog();
    }

    private void closeFloatingIconDialog() {
        try {
            FloatingIconDialog floatingIconDialog = this.floatingIconDialog;
            if (floatingIconDialog != null) {
                floatingIconDialog.dismiss();
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder().append(this.tag).append(" closeFloatingIconDialog error "));
        }
    }

    private void closeRedPocketDialog() {
        try {
            CustomByDialog customByDialog = this.redPocketDialog;
            if (customByDialog != null) {
                customByDialog.dismiss();
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder().append(this.tag).append(" closeFloatingIconDialog error "));
        }
    }

    public boolean addView(Activity activity, ViewGroup viewGroup) {
        return addView(activity, viewGroup, 0);
    }

    public boolean addView(Activity activity, ViewGroup viewGroup, int... iArr) {
        String templateKey = this.sdkSupplier.getTemplateKey(TemplateRes.SHOP_MALL_RED_PACKET);
        if (TextUtils.isEmpty(templateKey)) {
            templateKey = TemplateRes.SHOP_MALL_RED_PACKET;
        }
        YFLog.debug(this.tag + " addView key " + templateKey);
        if (TemplateRes.getTemplate(templateKey) == 0) {
            handleRenderFailed(0, " addView error has no id");
            return false;
        }
        if (activity == null) {
            h.a(new StringBuilder(), this.tag, " addView activity null");
            reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), YFAdError.ERROR_SHOP_MALL_SHOW_FAILED, getAType());
            return false;
        }
        if (!activity.isFinishing() && !activity.isDestroyed()) {
            try {
                ShopMallTemplateData shopMallTemplateData = new ShopMallTemplateData(templateKey, this.sdkSupplier.getTemplateConf());
                if (TemplateRes.SHOP_MALL_RED_PACKET.equals(templateKey)) {
                    startRedPocketView(activity, shopMallTemplateData);
                } else if (TemplateRes.SHOP_MALL_FLOATING_ICON.equals(templateKey)) {
                    startFloatingView(activity, shopMallTemplateData);
                }
                handleApiExposure();
                return true;
            } catch (Exception e) {
                reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), YFAdError.ERROR_SHOP_MALL_SHOW_FAILED, getAType());
                YFLog.high(this.tag + " addView error " + e.getMessage());
                return true;
            }
        }
        YFLog.error(this.tag + " addView activity is finishing or destroyed " + activity.getLocalClassName());
        reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), YFAdError.ERROR_SHOP_MALL_SHOW_FAILED, getAType());
        return false;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.setting != null) {
            this.setting = null;
        }
        removeListener();
        closeFloatingIconDialog();
    }
}
