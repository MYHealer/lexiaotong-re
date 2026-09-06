package com.yfanads.ads.chanel.ylh;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import com.yfanads.ads.chanel.ylh.utils.YlhUtil;
import com.yfanads.android.core.roll.YFRollAdsSetting;
import com.yfanads.android.custom.RollCustomAdapter;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YlhRollAdapter extends RollCustomAdapter {
    List<NativeExpressADView> nativeAds;

    public YlhRollAdapter(YFRollAdsSetting yFRollAdsSetting) {
        super(yFRollAdsSetting);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public int getAdnId() {
        return YFAdsConst.ReportAdnIdValue.YLH.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public void m1208x201b9c1d(final Context context) {
        YlhUtil.initAD(this.tag, this.sdkSupplier, context, getInitBean(), new InitUtils.InitListener() { // from class: com.yfanads.ads.chanel.ylh.YlhRollAdapter.1
            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void success() {
                YlhRollAdapter.this.startLoadAD(context);
            }

            @Override // com.yfanads.android.utils.InitUtils.InitListener
            public void fail(String str, String str2) {
                YlhRollAdapter.this.handleFailed(str, str2);
            }
        });
        sendInterruptMsg();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        if (this.isDestroy || this.setting == null) {
            YFLog.error(this.tag + " isDestroy or setting null");
        } else {
            loadTemplate(context);
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isReady() {
        if (this.setting == null) {
            return super.isReady();
        }
        int readyIndex = this.setting.getReadyIndex();
        List<NativeExpressADView> list = this.nativeAds;
        return (list == null || list.get(readyIndex) == null || !this.nativeAds.get(readyIndex).isValid()) ? false : true;
    }

    private void loadTemplate(Context context) {
        NativeExpressAD nativeExpressAD = new NativeExpressAD(context, new ADSize(-1, -2), this.sdkSupplier.getPotId(), new NativeExpressAD.NativeExpressADListener() { // from class: com.yfanads.ads.chanel.ylh.YlhRollAdapter.2
            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADLoaded(List<NativeExpressADView> list) {
                YlhRollAdapter.this.onADLoadedEV(list);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderFail(NativeExpressADView nativeExpressADView) {
                YlhRollAdapter.this.onRenderFailEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
                YlhRollAdapter.this.onRenderSuccessEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADExposure(NativeExpressADView nativeExpressADView) {
                YlhRollAdapter.this.onADExposureEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClicked(NativeExpressADView nativeExpressADView) {
                YlhRollAdapter.this.onADClickedEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
            public void onADClosed(NativeExpressADView nativeExpressADView) {
                YlhRollAdapter.this.onADClosedEV(nativeExpressADView);
            }

            @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
            public void onNoAD(AdError adError) {
                YlhRollAdapter.this.onNoADDel(adError);
            }
        });
        nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayMuted(this.sdkSupplier.isMuted()).build());
        nativeExpressAD.loadAD(this.setting.getAdsNumbers());
    }

    @Override // com.yfanads.android.custom.RollCustomAdapter, com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        super.doDestroy();
    }

    @Override // com.yfanads.android.custom.RollCustomAdapter
    public void doShowAD(Activity activity) {
        YFLog.high(this.tag + " doShowAD ");
        doShowTemplateAd();
    }

    private void doShowTemplateAd() {
        try {
            List<NativeExpressADView> list = this.nativeAds;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (NativeExpressADView nativeExpressADView : this.nativeAds) {
                    arrayList.add(nativeExpressADView.getRootView());
                    nativeExpressADView.render();
                }
                if (this.setting != null) {
                    this.setting.adapterRenderSuccess(this.sdkSupplier, arrayList);
                    return;
                }
                return;
            }
            handleShowFailed();
        } catch (Throwable th) {
            th.printStackTrace();
            handleShowFailed();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public String getAdReqId(int i) {
        NativeExpressADView nativeExpressADView;
        return (YFListUtils.isEmpty(this.nativeAds) || (nativeExpressADView = this.nativeAds.get(0)) == null) ? "" : YlhUtil.getReqId(nativeExpressADView.getExtraInfo());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendSucBiddingResult(SdkSupplier sdkSupplier) {
        if (YFListUtils.isEmpty(this.nativeAds)) {
            return;
        }
        for (NativeExpressADView nativeExpressADView : this.nativeAds) {
            nativeExpressADView.sendWinNotification(YlhUtil.getWindBiddingMap(nativeExpressADView.getECPM(), sdkSupplier != null ? (int) sdkSupplier.ecpm : 0));
        }
        String shortString = "";
        StringBuilder sbAppend = new StringBuilder().append(this.tag).append(" sendBiddingSucResult size=").append(this.nativeAds.size()).append(" current=").append(this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "").append("  loss=");
        if (UrlConst.isTestEnv() && sdkSupplier != null) {
            shortString = sdkSupplier.toShortString();
        }
        YFLog.high(sbAppend.append(shortString).toString());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void sendLossBiddingResult(SdkSupplier sdkSupplier, SdkSupplier sdkSupplier2) {
        if (YFListUtils.isEmpty(this.nativeAds) || sdkSupplier == null) {
            return;
        }
        int adnId = YlhUtil.getAdnId(isBidding(), sdkSupplier, getSDKSupplier());
        Iterator<NativeExpressADView> it = this.nativeAds.iterator();
        while (it.hasNext()) {
            it.next().sendLossNotification(YlhUtil.getLossBiddingMap((int) sdkSupplier.ecpm, adnId));
        }
        YFLog.high(this.tag + " sendBiddingLossResult size=" + this.nativeAds.size() + " current=" + (this.sdkSupplier != null ? this.sdkSupplier.toShortString() : "") + " win=" + (UrlConst.isTestEnv() ? sdkSupplier.toShortString() : ""));
    }

    public void onADLoadedEV(List<NativeExpressADView> list) {
        boolean z;
        YFLog.high(this.tag + "onADLoadedEV");
        if (list == null || list.isEmpty()) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
            return;
        }
        Iterator<NativeExpressADView> it = list.iterator();
        loop0: while (true) {
            z = true;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                NativeExpressADView next = it.next();
                if (!z || next != null) {
                    z = false;
                }
            }
        }
        if (z) {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
            return;
        }
        this.nativeAds = list;
        setEcpm(list.get(0).getECPM());
        handleSucceed();
    }

    public void onRenderFailEV(View view) {
        YFLog.high(this.tag + "onRenderFailEV " + view);
        handleRenderFailed();
    }

    public void onRenderSuccessEV(View view) {
        YFLog.high(this.tag + "onRenderSuccessEV");
    }

    public void onADExposureEV(View view) {
        YFLog.high(this.tag + "onADExposureEV");
        handleExposure();
    }

    public void onADClickedEV(View view) {
        YFLog.high(this.tag + "onADClickedEV");
        handleClick();
    }

    public void onADClosedEV(View view) {
        YFLog.high(this.tag + "onADClosedEV");
        handleClose();
    }

    public void onNoADDel(AdError adError) {
        int errorCode;
        String errorMsg;
        YFLog.high(this.tag + "onNoADEV");
        if (adError != null) {
            errorCode = adError.getErrorCode();
            errorMsg = adError.getErrorMsg();
        } else {
            errorCode = -1;
            errorMsg = "default onNoAD";
        }
        handleFailed(errorCode, errorMsg);
    }
}
