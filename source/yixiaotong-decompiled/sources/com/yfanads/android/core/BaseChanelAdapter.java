package com.yfanads.android.core;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.byazt.dyf.tt;
import com.google.android.exoplayer2.ExoPlayer;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.ads.R;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.callback.AdAdapterAction;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.callback.UnionSdkResultListener;
import com.yfanads.android.custom.view.FeedbackDialog;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.EventData;
import com.yfanads.android.model.FeedBean;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.InitBean;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.RouterMgr;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFConfigUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.io.Serializable;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class BaseChanelAdapter implements AdAdapterAction, Serializable {
    private static final long IS_EXPIRATION_DATE = 1800000;
    protected BaseAdapterEvent adsSpotListener;
    private boolean didSuccess;
    private String errorSource;
    protected long exposureStartTime;
    protected FeedBean feedBean;
    protected volatile boolean hasCallBack;
    protected volatile boolean hasCallBackCacheFail;
    protected boolean hasClose;
    protected boolean hasExposure;
    private boolean isFrequencyTime;
    protected SdkSupplier sdkSupplier;
    protected long sucStartTime;
    long timeoutSetTime;
    protected UnionSdkResultListener unionSdkResultListener;
    public String tag = "[" + getClass().getSimpleName() + "] ";
    protected boolean isDestroy = false;
    private Handler mInterruptHandler = null;
    private final Runnable runnable = new a();
    protected final boolean isSupportShake = YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (!BaseChanelAdapter.this.sdkSupplier.isLoading()) {
                d.a(new StringBuilder(), BaseChanelAdapter.this.tag, " sendInterruptMsg has result, return");
            } else {
                BaseChanelAdapter.this.sdkSupplier.setAdStatus(4);
                BaseChanelAdapter.this.handleTimeOut();
            }
        }
    }

    public class b implements OnFeedClickListener {
        public b() {
        }

        @Override // com.yfanads.android.custom.view.OnFeedClickListener
        public final void onDismiss() {
        }

        @Override // com.yfanads.android.custom.view.OnFeedClickListener
        public final void onTraceFeed() {
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            String appId = yFAdsConfig != null ? yFAdsConfig.getAppId() : "";
            SdkSupplier sdkSupplier = BaseChanelAdapter.this.sdkSupplier;
            new RouterMgr().routerWebView(BaseChanelAdapter.this.getContext(), BaseChanelAdapter.this.feedBean, new FeedCom(appId, sdkSupplier != null ? sdkSupplier.getAdId() : "", BaseChanelAdapter.this.getRequestId()));
        }
    }

    public BaseChanelAdapter(BaseAdapterEvent baseAdapterEvent) {
        this.adsSpotListener = baseAdapterEvent;
        try {
            this.tag += "|H" + hashCode() + "|>>";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isDidClicked() {
        try {
            SdkSupplier sdkSupplier = this.sdkSupplier;
            if (sdkSupplier != null && sdkSupplier.isControlClickChannel()) {
                int clickRatio = InitUtils.getClickRatio(this.sdkSupplier);
                String str = this.tag + " cr: " + clickRatio;
                if (clickRatio >= 100) {
                    YFLog.debug(str + ", return.");
                    return true;
                }
                float fNextInt = new Random().nextInt(100);
                YFLog.debug(str + "|rd:" + fNextInt);
                return fNextInt <= ((float) clickRatio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean isYFAds() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.getChannel() == 12;
    }

    private boolean needAdapterReqId(int i) {
        return i == YFAdsConst.ReportETypeValue.SDK_SHOW.getValue() || i == YFAdsConst.ReportETypeValue.SDK_CLICK.getValue() || i == YFAdsConst.ReportETypeValue.SDK_SHOW_RT.getValue() || i == YFAdsConst.ReportETypeValue.SDK_CLICK_RT.getValue() || i == YFAdsConst.ReportETypeValue.SDK_SHOW_API.getValue() || i == YFAdsConst.ReportETypeValue.SDK_SHOW_API_REAL.getValue() || i == YFAdsConst.ReportETypeValue.SHOW_API.getValue() || i == YFAdsConst.ReportETypeValue.SDK_PADDING.getValue() || i == YFAdsConst.ReportETypeValue.SDK_PADDING_LOW.getValue();
    }

    private void reportClickRT(YFAdsConst.ReportETypeValue reportETypeValue, int i) {
        int value = reportETypeValue.getValue();
        if (InitUtils.isRTReport(value)) {
            reportSdk(value, true, i);
        }
    }

    private void reportData(boolean z) {
        if (z) {
            SdkSupplier sdkSupplier = this.sdkSupplier;
            reportSdk((sdkSupplier == null || sdkSupplier.isOverPrice()) ? YFAdsConst.ReportETypeValue.SDK_PADDING.getValue() : YFAdsConst.ReportETypeValue.SDK_PADDING_LOW.getValue());
            if (getCType() == YFAdType.FULL.getValue() || getCType() == YFAdType.REWARD.getValue()) {
                reportSdk(YFAdsConst.ReportETypeValue.VIDEO_READY.getValue());
            }
        }
    }

    private void reportFailed(YFAdError yFAdError) {
        if (yFAdError != null) {
            YFLog.high(this.tag + " handleFailed , index = " + this.sdkSupplier.index + ", " + yFAdError);
            reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), yFAdError.code, getAType());
        }
    }

    private void reportTOData(boolean z) {
        if (z) {
            SdkSupplier sdkSupplier = this.sdkSupplier;
            reportSdk((sdkSupplier == null || sdkSupplier.isOverPrice()) ? YFAdsConst.ReportETypeValue.SDK_PADDING.getValue() : YFAdsConst.ReportETypeValue.SDK_PADDING_LOW.getValue(), YFAdsConst.ReportECodeValue.TIME_OUT.getValueStr(), getAType());
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003d  */
    private void showAds(final Activity activity, final ViewGroup viewGroup, int... iArr) {
        boolean z;
        try {
            if (isUpdStatus() && !this.sdkSupplier.isLoadSuccess()) {
                YFLog.error(this.tag + " 广告尚未获取到，暂无法执行展示，请耐心等待，SDK会在收到广告后，立即执行广告展示。若广告一直未展示，请检查广告失败回调和对应log信息，了解展示失败原因，status：" + this.sdkSupplier.getAdStatus());
                return;
            }
            if (iArr == null || iArr.length <= 0) {
                z = false;
            } else {
                z = true;
                if (iArr[0] != 1) {
                    z = false;
                }
            }
            this.isFrequencyTime = z;
            YFLog.debug(this.tag + " showAds isFrequencyTime = " + this.isFrequencyTime);
            this.sdkSupplier.setBidSuccess(false);
            this.sdkSupplier.setAdStatus(3);
            YFUtil.switchMainThread("doShowAD", new BaseEnsureListener() { // from class: com.yfanads.android.core.BaseChanelAdapter$$ExternalSyntheticLambda6
                @Override // com.yfanads.android.callback.BaseEnsureListener
                public final void ensure() {
                    this.f$0.m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(activity, viewGroup);
                }
            });
        } catch (Throwable th) {
            YFLog.error(this.tag + th.getMessage());
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_SHOW, "BaseSupplierAdapter show Throwable"));
        }
    }

    private void updateStatue() {
        revertInterrupt();
        this.sdkSupplier.setAdStatus(1);
        if (!this.sdkSupplier.isFromCache() || this.sdkSupplier.hasNoLastLoadTime()) {
            this.sdkSupplier.updLastLoadTime();
        }
    }

    public void closeAds() {
    }

    public void didSuccess() {
        this.didSuccess = true;
    }

    public abstract void doDestroy();

    /* JADX INFO: renamed from: doLoadAD, reason: merged with bridge method [inline-methods] */
    public abstract void m1208x201b9c1d(Context context);

    /* JADX INFO: renamed from: doShowAD, reason: merged with bridge method [inline-methods] */
    public abstract void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup);

    public void downLoadToast() {
        try {
            Context context = getContext();
            Toast.makeText(context, context.getString(R.string.yf_download_toast), 0).show();
        } catch (Exception e) {
            f.a(e, new StringBuilder().append(this.tag).append(" downLoadToast error"));
        }
    }

    public AdInfo getAdInfo() {
        return null;
    }

    public String getAdReqId(int i) {
        return "";
    }

    public abstract int getAdnId();

    public String getAppID() {
        SdkSupplier.NetworkDTO networkDTO;
        SdkSupplier.NetworkDTO.ParamDTO paramDTO;
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return (sdkSupplier == null || (networkDTO = sdkSupplier.network) == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.appId;
    }

    public String getAppKey() {
        SdkSupplier.NetworkDTO networkDTO;
        SdkSupplier.NetworkDTO.ParamDTO paramDTO;
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return (sdkSupplier == null || (networkDTO = sdkSupplier.network) == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.appKey;
    }

    public Context getContext() {
        return YFAdsManager.getInstance().getContext();
    }

    public long getEcpm() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        if (sdkSupplier != null) {
            return sdkSupplier.ecpm;
        }
        return 0L;
    }

    public String getErrorSource() {
        return this.errorSource;
    }

    public InitBean getInitBean() {
        SdkSupplier.NetworkDTO networkDTO;
        SdkSupplier.NetworkDTO.ParamDTO paramDTO;
        InitBean initBean = new InitBean();
        SdkSupplier sdkSupplier = this.sdkSupplier;
        if (sdkSupplier != null && (networkDTO = sdkSupplier.network) != null && (paramDTO = networkDTO.param) != null) {
            initBean.appId = paramDTO.appId;
            initBean.addKey = paramDTO.appKey;
            initBean.wxAppId = paramDTO.wxAppId;
            initBean.appSecret = paramDTO.appSecret;
            initBean.appToken = paramDTO.appToken;
            YFLog.debug("getInitBean " + initBean);
        }
        return initBean;
    }

    public long getLogTime() {
        if (this.sdkSupplier != null) {
            return System.currentTimeMillis() - this.sdkSupplier.getWaterfallTime();
        }
        return -1L;
    }

    public String getPotID() {
        SdkSupplier.NetworkDTO networkDTO;
        SdkSupplier.NetworkDTO.ParamDTO paramDTO;
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return (sdkSupplier == null || (networkDTO = sdkSupplier.network) == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.potId;
    }

    public String getRequestId() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null ? sdkSupplier.getReqId() : "";
    }

    public SdkSupplier getSDKSupplier() {
        return this.sdkSupplier;
    }

    public String getWixAppId() {
        SdkSupplier.NetworkDTO networkDTO;
        SdkSupplier.NetworkDTO.ParamDTO paramDTO;
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return (sdkSupplier == null || (networkDTO = sdkSupplier.network) == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.wxAppId;
    }

    public void handleApiExposure() {
        try {
            reportSdk(YFAdsConst.ReportETypeValue.SDK_SHOW_API.getValue());
        } catch (Throwable th) {
            YFLog.error(this.tag + PPSLabelView.Code + th.getMessage());
        }
    }

    public void handleClick(boolean z) {
        handleClickByIndex(z, 0);
    }

    public void handleClickByIndex(boolean z, int i) {
        try {
            if (!this.hasExposure && getAdnId() == YFAdsConst.ReportAdnIdValue.ADX.getValue()) {
                handleExposureWithCode(YFAdError.ERROR_ADX_REPLENISH_EXPOSURE);
            }
            reportSdk(z ? YFAdsConst.ReportETypeValue.SDK_AUTO_CLICK.getValue() : YFAdsConst.ReportETypeValue.SDK_CLICK.getValue(), i);
            reportClickRT(YFAdsConst.ReportETypeValue.SDK_CLICK_RT, i);
            if (!z) {
                if (this.adsSpotListener != null) {
                    YFUtil.switchMainThread("handleClick", new BaseEnsureListener() { // from class: com.yfanads.android.core.BaseChanelAdapter$$ExternalSyntheticLambda1
                        @Override // com.yfanads.android.callback.BaseEnsureListener
                        public final void ensure() {
                            this.f$0.m1202xb5f28c75();
                        }
                    });
                }
            } else {
                YFLog.high(this.tag + " auto click ");
                if (this.adsSpotListener != null) {
                    YFUtil.switchMainThread("handleClick", new BaseEnsureListener() { // from class: com.yfanads.android.core.BaseChanelAdapter$$ExternalSyntheticLambda0
                        @Override // com.yfanads.android.callback.BaseEnsureListener
                        public final void ensure() {
                            this.f$0.m1201xf3062316();
                        }
                    });
                }
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + th.getMessage());
        }
    }

    public void handleExposure() {
        handleExposureByIndex(0, "");
    }

    public void handleExposureByIndex(int i) {
        handleExposureByIndex(i, "");
    }

    public void handleExposureWithCode(String str) {
        handleExposureByIndex(0, str);
    }

    public void handleFailed(int i, String str) {
        handleFailed(i + "", str);
    }

    public void handleRenderFailed() {
        handleRenderFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_RENDER, "show render fail"), 9904);
    }

    public void handleShowApiInvoke() {
        try {
            YFLog.debug(this.tag + " handleShowApiInvoke reportSdk 18");
            reportSdk(YFAdsConst.ReportETypeValue.SHOW_API.getValue());
        } catch (Throwable th) {
            YFLog.error(this.tag + PPSLabelView.Code + th.getMessage());
        }
    }

    public void handleShowFailed() {
        handleShowFailed("show code error");
    }

    public void handleSucceed() {
        handleSucceed(true);
    }

    public void handleTimeOut() {
        YFLog.high(this.tag + " 单层请求超时:handleTimeOut " + this.sdkSupplier + " delay:" + (System.currentTimeMillis() - this.timeoutSetTime) + "ms");
        if (!this.sdkSupplier.isTimeOut()) {
            h.a(new StringBuilder(), this.tag, " current is not timeout, return");
        } else {
            reportSdk(YFAdsConst.ReportETypeValue.FLOW_FAIL.getValue(), "1004", getAType());
            callUnionResult("timeout", false, this, YFAdError.parseErr("1004", ""));
        }
    }

    public boolean isBanner() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.isBanner();
    }

    public boolean isBidSuccess() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.isBidSuccess();
    }

    public boolean isBidding() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.isBidding();
    }

    public boolean isDestroy() {
        return this.isDestroy;
    }

    public boolean isDevelop() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.isDevelop();
    }

    public boolean isDidSuccess() {
        return this.didSuccess;
    }

    public boolean isExposure() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.isAdStatus(5);
    }

    public boolean isHasClose() {
        return this.hasClose;
    }

    public boolean isInMaxLength(int i, int i2, int i3) {
        return i >= 0 && i + i2 <= i3;
    }

    public boolean isListPackage() {
        return InitUtils.isQueryAllPackage();
    }

    public boolean isNative() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.isNative();
    }

    public boolean isReady() {
        SdkSupplier sdkSupplier;
        boolean z = this.sucStartTime > 0 && System.currentTimeMillis() - this.sucStartTime < 1800000;
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" isReady ").append(z).append(PPSLabelView.Code);
        SdkSupplier sdkSupplier2 = this.sdkSupplier;
        YFLog.high(sbAppend.append(sdkSupplier2 != null ? Integer.valueOf(sdkSupplier2.getAdStatus()) : "null").toString());
        return z && (sdkSupplier = this.sdkSupplier) != null && sdkSupplier.isAdStatus(1);
    }

    public boolean isStartShow() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.isAdStatus(3);
    }

    public boolean isSupportCache() {
        return false;
    }

    public boolean isTemplate() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null && sdkSupplier.isTemplate();
    }

    public boolean isUpdStatus() {
        return true;
    }

    /* JADX INFO: renamed from: lambda$handleClickByIndex$2$com-yfanads-android-core-BaseChanelAdapter, reason: not valid java name */
    /* synthetic */ void m1201xf3062316() {
        this.adsSpotListener.adapterDidClicked(this.sdkSupplier, false);
    }

    /* JADX INFO: renamed from: lambda$handleClickByIndex$3$com-yfanads-android-core-BaseChanelAdapter, reason: not valid java name */
    /* synthetic */ void m1202xb5f28c75() {
        this.adsSpotListener.adapterDidClicked(this.sdkSupplier, isDidClicked());
    }

    /* JADX INFO: renamed from: lambda$handleClose$5$com-yfanads-android-core-BaseChanelAdapter, reason: not valid java name */
    /* synthetic */ void m1203lambda$handleClose$5$comyfanadsandroidcoreBaseChanelAdapter() {
        this.adsSpotListener.adapterDidClosed(this.sdkSupplier);
    }

    /* JADX INFO: renamed from: lambda$handleExposureByIndex$7$com-yfanads-android-core-BaseChanelAdapter, reason: not valid java name */
    /* synthetic */ void m1204xd535fa5a() {
        this.adsSpotListener.adapterDidExposure(this.sdkSupplier);
    }

    /* JADX INFO: renamed from: lambda$handleRenderFailed$4$com-yfanads-android-core-BaseChanelAdapter, reason: not valid java name */
    /* synthetic */ void m1205x5c8bcc74() {
        this.adsSpotListener.adapterRenderFailed(this.sdkSupplier);
    }

    /* JADX INFO: renamed from: lambda$handleSucceed$6$com-yfanads-android-core-BaseChanelAdapter, reason: not valid java name */
    /* synthetic */ void m1206x3ec8b62d() {
        callUnionResult("handleSucceed", true, this, null);
    }

    @Override // com.yfanads.android.callback.AdAdapterAction
    public void loadOnly(Context context) {
        startAdapterADLoad(context);
    }

    public void reportSdk(int i) {
        reportSdk(i, false, 0);
    }

    public void reportSdkWithCode(int i, String str, int i2) {
        reportSdk(i, str, getAType(), false, i2);
    }

    public void resetCallBack() {
        d.a(new StringBuilder(), this.tag, "resetCallBack");
        this.hasCallBack = false;
        this.hasCallBackCacheFail = false;
    }

    public void revertInterrupt() {
        d.a(new StringBuilder(), this.tag, " stop requestTimeout");
        Handler handler = this.mInterruptHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(this.runnable);
            this.mInterruptHandler = null;
        }
    }

    public boolean sendBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        try {
            SdkSupplier sDKSupplier = getSDKSupplier();
            if (isBidding()) {
                if (sDKSupplier == null || !sDKSupplier.equals(sdkSupplier)) {
                    sendLossBiddingResult(sdkSupplier, sdkSupplier2);
                    return true;
                }
                sendSucBiddingResult(sdkSupplier2);
                return true;
            }
            if (!isYFAds() || sDKSupplier == null || !sDKSupplier.equals(sdkSupplier)) {
                return false;
            }
            sendSucBiddingResult(sdkSupplier2);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendInterruptMsg() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        if (sdkSupplier == null || sdkSupplier.getAdStatus() == 2) {
            StringBuilder sb = new StringBuilder("sendInterruptMsg not post, It's ad statues = ");
            SdkSupplier sdkSupplier2 = this.sdkSupplier;
            YFLog.warn(sb.append(sdkSupplier2 != null ? Integer.valueOf(sdkSupplier2.getAdStatus()) : "-1").toString());
            return;
        }
        long j = this.sdkSupplier.requestTimeout;
        if (j == 0) {
            j = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
        }
        Handler handler = this.mInterruptHandler;
        if (handler == null) {
            this.mInterruptHandler = new Handler(Looper.getMainLooper());
        } else {
            handler.removeCallbacks(this.runnable);
        }
        this.timeoutSetTime = System.currentTimeMillis();
        YFLog.debug(this.tag + " start requestTimeout = " + this.sdkSupplier.requestTimeout + " timeStart = " + this.timeoutSetTime);
        this.mInterruptHandler.postDelayed(this.runnable, j);
    }

    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
    }

    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
    }

    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        this.adsSpotListener = baseAdapterEvent;
    }

    public void setUnionSdkResultListener(UnionSdkResultListener unionSdkResultListener) {
        this.unionSdkResultListener = unionSdkResultListener;
    }

    @Override // com.yfanads.android.callback.AdAdapterAction
    public void show(Activity activity, ViewGroup viewGroup) {
        showAds(activity, viewGroup, 0);
    }

    public void showFeedBackDialog(FragmentManager fragmentManager, String str, OnFeedClickListener onFeedClickListener) {
        FeedbackDialog feedbackDialog = new FeedbackDialog();
        feedbackDialog.setOnFeedClickListener(onFeedClickListener);
        feedbackDialog.show(fragmentManager, str);
    }

    public void startLoadAD(Context context) {
        d.a(new StringBuilder(), this.tag, " startLoad ad ");
    }

    public String toString() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null ? sdkSupplier.toString() : "";
    }

    public void updateMaterialArea(View view, int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        if (i2 == 0) {
            i2 = 1;
        }
        if ((i * 100) / i2 > (i3 * 100) / i4) {
            ViewUtils.setViewSize(view, (int) ((((double) i3) / ((double) i4)) * ((double) i2)), i2);
        } else {
            ViewUtils.setViewSize(view, i, (int) ((((double) i4) / ((double) i3)) * ((double) i)));
        }
    }

    public void callUnionResult(String str, boolean z, BaseChanelAdapter baseChanelAdapter, YFAdError yFAdError) {
        UnionSdkResultListener unionSdkResultListener = this.unionSdkResultListener;
        if (unionSdkResultListener == null) {
            h.a(new StringBuilder(), this.tag, " callSdkSupplierResult error, mSdkSupplierResultListener is null, return");
            return;
        }
        this.errorSource = str;
        if (z) {
            unionSdkResultListener.onResultSuccess(baseChanelAdapter);
        } else {
            unionSdkResultListener.onResultFailed(baseChanelAdapter, yFAdError);
        }
    }

    public int getAType() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null ? sdkSupplier.adType : YFAdType.NONE.getValue();
    }

    public int getCType() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        return sdkSupplier != null ? sdkSupplier.getCType() : YFAdType.NONE.getValue();
    }

    public void handleClick() {
        handleClick(false);
    }

    public void handleClose() {
        try {
            if (this.isDestroy) {
                YFLog.high(this.tag + "handleClose hasDestroy already, return.");
                return;
            }
            if (this.hasClose) {
                YFLog.high(this.tag + "handleClose hasClose already, return.");
                return;
            }
            this.hasClose = true;
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.exposureStartTime);
            boolean z = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.a(this.sdkSupplier, YFAdsConst.ReportETypeValue.CLOSE.getValue(), iCurrentTimeMillis);
            if (this.adsSpotListener != null) {
                YFUtil.switchMainThread("handleClose", new BaseEnsureListener() { // from class: com.yfanads.android.core.BaseChanelAdapter$$ExternalSyntheticLambda7
                    @Override // com.yfanads.android.callback.BaseEnsureListener
                    public final void ensure() {
                        this.f$0.m1203lambda$handleClose$5$comyfanadsandroidcoreBaseChanelAdapter();
                    }
                });
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + th.getMessage());
        }
    }

    public void handleExposureByIndex(int i, String str) {
        try {
            YFLog.high(this.tag + " handleExposure");
            if (this.hasExposure) {
                YFLog.debug(this.tag + " handleExposure this adapter has exposure return.");
                return;
            }
            this.exposureStartTime = System.currentTimeMillis();
            this.hasClose = false;
            this.hasExposure = true;
            SdkSupplier sdkSupplier = this.sdkSupplier;
            if (sdkSupplier != null) {
                sdkSupplier.setAdStatus(5);
                if (!this.isFrequencyTime) {
                    com.yfanads.android.db.d dVar = com.yfanads.android.db.d.a.f9643a;
                    Context context = getContext();
                    String sessionId = this.sdkSupplier.getSessionId();
                    dVar.getClass();
                    com.yfanads.android.db.f.a(context, sessionId);
                    YFLog.debug(this.tag + " handleExposure updateFrequencyTime success " + this.sdkSupplier.getSessionId());
                }
            }
            if (TextUtils.isEmpty(str)) {
                reportSdk(YFAdsConst.ReportETypeValue.SDK_SHOW.getValue(), i);
            } else {
                reportSdkWithCode(YFAdsConst.ReportETypeValue.SDK_SHOW.getValue(), str, i);
            }
            if (this.adsSpotListener != null) {
                YFUtil.switchMainThread("handleExposure", new BaseEnsureListener() { // from class: com.yfanads.android.core.BaseChanelAdapter$$ExternalSyntheticLambda4
                    @Override // com.yfanads.android.callback.BaseEnsureListener
                    public final void ensure() {
                        this.f$0.m1204xd535fa5a();
                    }
                });
            }
            reportClickRT(YFAdsConst.ReportETypeValue.SDK_SHOW_RT, i);
        } catch (Throwable th) {
            YFLog.error(this.tag + th.getMessage());
        }
    }

    public void handleFailed(String str, String str2) {
        handleFailed(YFAdError.parseErr(str, str2));
    }

    public void handleRenderFailed(int i, String str) {
        handleRenderFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_RENDER, str), i);
    }

    public void handleShowFailed(String str) {
        handleRenderFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_SHOW, str), 9903);
    }

    public void handleSucceed(boolean z) {
        try {
            this.sucStartTime = System.currentTimeMillis();
            YFLog.high(this.tag + " handleSucceed " + this.sdkSupplier);
            if (this.sdkSupplier.isTimeOut()) {
                YFLog.warn(this.tag + " handleSucceed this adapter is timeout isNeedReport = " + z + " , return.");
                reportTOData(z);
                onTimeoutSuccess();
            } else {
                updateStatue();
                reportData(z);
                YFUtil.switchMainThread("handleSucceed", new BaseEnsureListener() { // from class: com.yfanads.android.core.BaseChanelAdapter$$ExternalSyntheticLambda5
                    @Override // com.yfanads.android.callback.BaseEnsureListener
                    public final void ensure() {
                        this.f$0.m1206x3ec8b62d();
                    }
                });
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + th.getMessage());
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD));
        }
    }

    public void onTimeoutSuccess() {
        SdkSupplier sdkSupplier;
        if (this.unionSdkResultListener == null || (sdkSupplier = this.sdkSupplier) == null) {
            return;
        }
        if (!sdkSupplier.isFromCache() || this.sdkSupplier.hasNoLastLoadTime()) {
            this.sdkSupplier.updLastLoadTime();
        }
        this.unionSdkResultListener.onTimeoutSuccess(this);
    }

    public void reportSdk(int i, int i2) {
        reportSdk(i, false, i2);
    }

    public void setEcpm(long j) {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        if (sdkSupplier == null || !sdkSupplier.isBidding()) {
            return;
        }
        SdkSupplier sdkSupplier2 = this.sdkSupplier;
        sdkSupplier2.setEcpm(sdkSupplier2.ecpm, j);
    }

    public void setEcpmByStr(String str) {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        if (sdkSupplier == null || !sdkSupplier.isBidding()) {
            return;
        }
        long j = YFUtil.toLong(str, 0L);
        SdkSupplier sdkSupplier2 = this.sdkSupplier;
        sdkSupplier2.setEcpm(sdkSupplier2.ecpm, j);
        YFLog.high("set bidding string ecpm " + str);
    }

    public void setSDKSupplier(SdkSupplier sdkSupplier) {
        try {
            this.sdkSupplier = sdkSupplier;
            YFLog.high(this.tag + " start method setSDKSupplier and index is " + sdkSupplier.index);
        } catch (Exception e) {
            f.a(e, new StringBuilder().append(this.tag).append(" setSDKSupplier exception - "));
        }
    }

    @Override // com.yfanads.android.callback.AdAdapterAction
    public void show(Activity activity, int... iArr) {
        showAds(activity, null, iArr);
    }

    public void startAdapterADLoad(final Context context) {
        try {
            if (this.sdkSupplier != null) {
                YFLog.debug(this.tag + " start load ad " + this.sdkSupplier.getSourceByLog());
                reportSdk(YFAdsConst.ReportETypeValue.SDK_REQ.getValue());
                this.sdkSupplier.setAdStatus(0);
                YFUtil.switchMainThread("doLoadAD", new BaseEnsureListener() { // from class: com.yfanads.android.core.BaseChanelAdapter$$ExternalSyntheticLambda2
                    @Override // com.yfanads.android.callback.BaseEnsureListener
                    public final void ensure() {
                        this.f$0.m1208x201b9c1d(context);
                    }
                });
            } else {
                YFLog.error(this.tag + " start load ad but sdkSupplier is empty, return.");
                handleFailed(YFAdError.parseErr(YFAdError.ERROR_EMPTY, " start load ad but sdkSupplier is empty, return."));
            }
        } catch (Exception e) {
            YFLog.error(this.tag + " start load " + this.sdkSupplier + " exception " + e.getMessage());
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_EXCEPTION_LOAD, " start load exception "));
        }
    }

    public void updateAdInfos() {
        SdkSupplier sdkSupplier = this.sdkSupplier;
        if (sdkSupplier != null) {
            sdkSupplier.setAdInfo(getAdInfo());
        }
    }

    public void handleRenderFailed(YFAdError yFAdError, int i) {
        try {
            YFLog.high(this.tag + " handleRenderFailed " + i);
            reportFailed(yFAdError);
            if (this.adsSpotListener != null) {
                YFUtil.switchMainThread("handleRenderFailed", new BaseEnsureListener() { // from class: com.yfanads.android.core.BaseChanelAdapter$$ExternalSyntheticLambda3
                    @Override // com.yfanads.android.callback.BaseEnsureListener
                    public final void ensure() {
                        this.f$0.m1205x5c8bcc74();
                    }
                });
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + th.getMessage());
        }
    }

    public void reportSdk(int i, boolean z) {
        reportSdk(i, "", getAType(), z, 0);
    }

    @Override // com.yfanads.android.callback.AdAdapterAction
    public void destroy(String str) {
        try {
            if (this.isDestroy) {
                return;
            }
            YFLog.high(this.tag + " source=" + str + " start destroy " + this.sdkSupplier);
            this.isDestroy = true;
            this.isFrequencyTime = false;
            SdkSupplier sdkSupplier = this.sdkSupplier;
            if (sdkSupplier != null) {
                sdkSupplier.setAdStatus(-1);
                this.sdkSupplier.setBidSuccess(false);
            }
            if (this.unionSdkResultListener != null) {
                this.unionSdkResultListener = null;
            }
            if (this.adsSpotListener != null) {
                this.adsSpotListener = null;
            }
            if (this.feedBean != null) {
                this.feedBean = null;
            }
            this.didSuccess = false;
            this.hasClose = false;
            doDestroy();
            YFLog.high(this.tag + " source=" + str + " end destroy ");
        } catch (Throwable th) {
            YFLog.error(this.tag + " destroy exception " + th.getMessage());
        }
    }

    public void handleFailed(YFAdError yFAdError) {
        try {
            SdkSupplier sdkSupplier = this.sdkSupplier;
            if (sdkSupplier == null) {
                YFLog.error(this.tag + " handleFailed this adapter sdkSupplier is null, return.");
                callUnionResult("handleFailed", false, this, yFAdError);
            } else {
                if (sdkSupplier.isTimeOut()) {
                    YFLog.warn(this.tag + " handleFailed this adapter is timeout, return.");
                    reportFailed(yFAdError);
                    return;
                }
                revertInterrupt();
                this.sdkSupplier.setAdStatus(2);
                reportFailed(yFAdError);
                callUnionResult("handleFailed", false, this, yFAdError);
                destroy("handleFailed");
            }
        } catch (Exception e) {
            YFLog.warn(this.tag + " handleFailed exception");
            e.printStackTrace();
        }
    }

    public void reportSdk(int i, boolean z, int i2) {
        reportSdk(i, "", getAType(), z, i2);
    }

    public void showFeedBackDialog(FragmentManager fragmentManager, String str) {
        showFeedBackDialog(fragmentManager, tt.AD_TAG_DISLIKE, new b());
    }

    public void reportSdk(int i, String str, int i2) {
        reportSdk(i, str, i2, false, 0);
    }

    public void reportSdk(int i, String str, int i2, int i3) {
        reportSdk(i, str, i2, false, i3);
    }

    public void reportSdk(int i, String str, int i2, boolean z, int i3) {
        boolean z2 = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b bVar = com.yfanads.android.upload.b.a.f9685a;
        bVar.getClass();
        if (!com.yfanads.android.upload.b.a(i) || z) {
            EventData eventData = new EventData();
            eventData.eId = Util.getRandomUuid();
            eventData.eType = i;
            eventData.t = Util.getCurrentTime();
            eventData.aType = i2;
            eventData.adnId = getAdnId();
            if (!TextUtils.isEmpty(str)) {
                eventData.cd = str;
            }
            if (needAdapterReqId(i)) {
                String adReqId = getAdReqId(i3);
                if (TextUtils.isEmpty(adReqId)) {
                    adReqId = "";
                }
                eventData.msg = adReqId;
            }
            SdkSupplier sdkSupplier = this.sdkSupplier;
            if (sdkSupplier != null) {
                eventData.isBid = sdkSupplier.isBidding() ? 1 : 0;
                if (i == YFAdsConst.ReportETypeValue.SDK_PADDING.getValue() || i == YFAdsConst.ReportETypeValue.SDK_PADDING_LOW.getValue()) {
                    eventData.tCost = (int) (System.currentTimeMillis() - this.sdkSupplier.getWaterfallTime());
                }
                if (i == YFAdsConst.ReportETypeValue.FLOW_PADDING.getValue() || i == YFAdsConst.ReportETypeValue.FLOW_PADDING_RT.getValue()) {
                    eventData.tCost = (int) (System.currentTimeMillis() - this.sdkSupplier.getFlowTime());
                }
                this.sdkSupplier.getReport(eventData);
            }
            if (z) {
                try {
                    bVar.b();
                    bVar.f9684a.d(eventData);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            bVar.a(eventData);
        }
    }
}
