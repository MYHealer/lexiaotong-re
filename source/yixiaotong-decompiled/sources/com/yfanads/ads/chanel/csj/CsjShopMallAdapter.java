package com.yfanads.ads.chanel.csj;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.yfanads.ads.chanel.csj.utils.CsjUtil;
import com.yfanads.android.core.shop.YFShopMallSetting;
import com.yfanads.android.custom.ShopMallCustomAdapter;
import com.yfanads.android.custom.view.AdShopMallHolder;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.template.ShopMallTemplateData;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class CsjShopMallAdapter extends ShopMallCustomAdapter implements TTAdNative.FullScreenVideoAdListener, TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
    public TTFullScreenVideoAd newVersionAd;

    public CsjShopMallAdapter(YFShopMallSetting yFShopMallSetting) {
        super(yFShopMallSetting);
    }

    @Override // com.yfanads.android.custom.ShopMallCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
        try {
            TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
            if (tTFullScreenVideoAd != null && tTFullScreenVideoAd.getMediationManager() != null) {
                this.newVersionAd.getMediationManager().destroy();
            }
            this.newVersionAd = null;
        } catch (Exception e) {
            YFLog.error(this.tag + " doDestroy " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.ShopMallCustomAdapter
    public void skipToFloatingMallPage(Activity activity, String str) {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
        if (tTFullScreenVideoAd != null && activity != null) {
            tTFullScreenVideoAd.showFullScreenVideoAd(activity);
        } else {
            handleShowFailed();
        }
        super.skipToFloatingMallPage(activity, str);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        CsjUtil.initCsj(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.csj.CsjShopMallAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                CsjShopMallAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                CsjShopMallAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.custom.ShopMallCustomAdapter
    public void doShowAD(Activity activity) {
        try {
            addView(activity);
        } catch (Exception e) {
            YFLog.error(this.tag + " updPrice " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.custom.ShopMallCustomAdapter
    public void bindData(Activity activity, ShopMallTemplateData shopMallTemplateData, AdShopMallHolder adShopMallHolder) {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
        if (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediaExtraInfo() == null) {
            return;
        }
        Object obj = this.newVersionAd.getMediaExtraInfo().get("mall_new_user_bonus");
        if (obj != null) {
            try {
                YFLog.high(this.tag + " bindData by mall_new_user_bonus " + obj);
                shopMallTemplateData.setAmount(1, (String) obj);
                return;
            } catch (Exception e) {
                YFLog.error(this.tag + " bindData0 " + e.getMessage());
            }
        }
        try {
            Object obj2 = this.newVersionAd.getMediaExtraInfo().get("mall_bonus");
            if (obj2 instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj2;
                String strOptString = jSONObject.optString("amount");
                int iOptInt = jSONObject.optInt("type");
                YFLog.high(this.tag + " bindData by mall_bonus " + iOptInt + "|" + strOptString);
                shopMallTemplateData.setAmount(iOptInt, strOptString);
                return;
            }
        } catch (Exception e2) {
            YFLog.error(this.tag + " bindData1 " + e2.getMessage());
        }
        try {
            Object obj3 = this.newVersionAd.getMediaExtraInfo().get("coupon");
            if (obj3 instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj3;
                boolean zOptBoolean = jSONObject2.optBoolean("has_coupon");
                Integer numValueOf = Integer.valueOf(jSONObject2.optInt("amount"));
                YFLog.high(this.tag + " bindData by coupon " + zOptBoolean + "|" + numValueOf);
                shopMallTemplateData.setAmount(3, String.valueOf(numValueOf));
                return;
            }
        } catch (Exception e3) {
            YFLog.error(this.tag + " bindData2 " + e3.getMessage());
        }
        getTestData(shopMallTemplateData);
    }

    private void getTestData(ShopMallTemplateData shopMallTemplateData) {
        if (UrlConst.isTestEnv()) {
            try {
                String amount = UrlConst.getAmount();
                if (!TextUtils.isEmpty(amount) && amount.contains("&")) {
                    String[] strArrSplit = amount.split("&");
                    shopMallTemplateData.setAmount(Integer.parseInt(strArrSplit[0]), strArrSplit[1]);
                }
            } catch (Exception e) {
                YFLog.error(this.tag + " bindData test custom " + e.getMessage());
            }
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
        return tTFullScreenVideoAd != null ? CsjUtil.getReqId(tTFullScreenVideoAd.getMediaExtraInfo()) : "";
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadInterstitialAd(context);
        }
    }

    private void loadInterstitialAd(Context context) {
        CsjUtil.getADManger().createAdNative(context).loadFullScreenVideoAd(new AdSlot.Builder().setCodeId(this.sdkSupplier.getPotId()).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(this.sdkSupplier.isMute()).setVolume(0.7f).build()).setSupportDeepLink(true).build(), this);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        TTFullScreenVideoAd tTFullScreenVideoAd = this.newVersionAd;
        return (tTFullScreenVideoAd == null || tTFullScreenVideoAd.getMediaExtraInfo() == null || !this.newVersionAd.getMediationManager().isReady()) ? false : true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.CSJ.getValue();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onError(int i, String str) {
        handleFailed(i, str);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
        try {
            YFLog.high(this.tag + "onFullScreenVideoAdLoad");
            this.newVersionAd = tTFullScreenVideoAd;
            if (tTFullScreenVideoAd == null) {
                handleFailed(YFAdError.ERROR_DATA_NULL, "new ints ad null");
            } else {
                tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(this);
                handleSucceed();
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + " onFullScreenVideoAdLoad " + th.getMessage());
            handleFailed(YFAdError.ERROR_EXCEPTION_LOAD, "");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached() {
        YFLog.high(this.tag + "onFullScreenVideoCached");
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
    public void onFullScreenVideoCached(TTFullScreenVideoAd tTFullScreenVideoAd) {
        String string = "";
        if (tTFullScreenVideoAd != null) {
            try {
                string = tTFullScreenVideoAd.toString();
            } catch (Throwable th) {
                YFLog.error(this.tag + " onFullScreenVideoCached " + th.getMessage());
                return;
            }
        }
        YFLog.high(this.tag + "onFullScreenVideoCached( " + string + ")");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isBidding() {
        return this.sdkSupplier != null && this.sdkSupplier.isBidding() && CsjUtil.isSupportBidding;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdShow() {
        YFLog.high(this.tag + "newVersionAd onAdShow");
        handleExposure();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdVideoBarClick() {
        YFLog.high(this.tag + "newVersionAd onAdVideoBarClick");
        handleClick();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onAdClose() {
        YFLog.high(this.tag + "newVersionAd onAdClose");
        closeAds();
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onVideoComplete() {
        YFLog.high(this.tag + "newVersionAd onVideoComplete");
    }

    @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
    public void onSkippedVideo() {
        YFLog.high(this.tag + "newVersionAd onSkippedVideo");
    }
}
