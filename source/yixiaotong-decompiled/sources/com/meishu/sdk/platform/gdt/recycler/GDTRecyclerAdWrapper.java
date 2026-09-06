package com.meishu.sdk.platform.gdt.recycler;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.google.gson.Gson;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.g0;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import com.qq.e.ads.cfg.DownAPPConfirmPolicy;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTRecyclerAdWrapper extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private GDTExpressAdListenerAdapter gdtExpressAdapter;
    private GDTNativeUnifiedAdListenerAdapter gdtNativeAdapter;
    private boolean isPreRender;
    private NativeExpressAD nativeExpressAD;
    private NativeUnifiedAD nativeUnifiedAD;

    public GDTRecyclerAdWrapper(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
        this.isPreRender = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNativeExpressAD(int i) {
        try {
            DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(this.context.getApplicationContext()).getResources().getDisplayMetrics();
            float fIntValue = (getAdLoader().getAccept_ad_width() == null || getAdLoader().getAccept_ad_width().intValue() <= 0) ? -1.0f : getAdLoader().getAccept_ad_width().intValue() / displayMetrics.density;
            if (getAdLoader().getAccept_ad_height() != null && getAdLoader().getAccept_ad_height().intValue() > 0) {
                getAdLoader().getAccept_ad_height().intValue();
                float f = displayMetrics.density;
            }
            ADSize aDSize = new ADSize((int) fIntValue, -2);
            this.gdtExpressAdapter = new GDTExpressAdListenerAdapter(this);
            if (!TextUtils.isEmpty(this.sdkAdInfo.getS2sb())) {
                try {
                    this.nativeExpressAD = new NativeExpressAD(getContext(), aDSize, this.sdkAdInfo.getPid(), this.gdtExpressAdapter, ((S2sbResultBean) new Gson().fromJson(this.sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.nativeExpressAD == null) {
                this.nativeExpressAD = new NativeExpressAD(getContext(), aDSize, this.sdkAdInfo.getPid(), this.gdtExpressAdapter);
            }
            setDownAPPConfirmPolicy(this.nativeExpressAD);
            this.nativeExpressAD.setVideoOption(new VideoOption.Builder().setAutoPlayPolicy(getAdLoader().getIsVideoAutoPlay() ? 1 : 0).build());
            this.nativeExpressAD.loadAD(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNativeUnifiedAD(int i) {
        this.gdtNativeAdapter = new GDTNativeUnifiedAdListenerAdapter(this);
        if (!TextUtils.isEmpty(this.sdkAdInfo.getS2sb())) {
            try {
                this.nativeUnifiedAD = new NativeUnifiedAD(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), this.sdkAdInfo.getPid(), this.gdtNativeAdapter, ((S2sbResultBean) new Gson().fromJson(this.sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.nativeUnifiedAD == null) {
            this.nativeUnifiedAD = new NativeUnifiedAD(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), this.sdkAdInfo.getPid(), this.gdtNativeAdapter);
        }
        setDownAPPConfirmPolicy(this.nativeUnifiedAD);
        this.nativeUnifiedAD.loadData(i);
    }

    private void setDownAPPConfirmPolicy(Object obj) {
        try {
            Method method = obj.getClass().getMethod("setDownAPPConfirmPolicy", DownAPPConfirmPolicy.class);
            if (AdSdk.adConfig().downloadConfirm() == 2) {
                method.invoke(obj, DownAPPConfirmPolicy.NOConfirm);
            } else {
                method.invoke(obj, DownAPPConfirmPolicy.Default);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        ExecutorService executorService = g0.f4905a;
        g0.b.f4906a.a(new l() { // from class: com.meishu.sdk.platform.gdt.recycler.GDTRecyclerAdWrapper.1
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    z.a(StubApp.getOrigApplicationContext(GDTRecyclerAdWrapper.this.getContext().getApplicationContext()), h0.a(GDTRecyclerAdWrapper.this.getSdkAdInfo().getReq()), new i());
                    int fetchCount = ((RecyclerMixAdLoader) GDTRecyclerAdWrapper.this.adLoader).getFetchCount() <= 0 ? 1 : ((RecyclerMixAdLoader) GDTRecyclerAdWrapper.this.adLoader).getFetchCount();
                    int adPatternType = GDTRecyclerAdWrapper.this.getAdLoader().getAdPatternType();
                    if (adPatternType == 200000) {
                        int drawing = GDTRecyclerAdWrapper.this.getSdkAdInfo().getDrawing();
                        if (drawing == 1) {
                            GDTRecyclerAdWrapper.this.isPreRender = false;
                        } else {
                            if (drawing != 2) {
                                new CSJPlatformError("信息流模式不支持", -1, GDTRecyclerAdWrapper.this.getSdkAdInfo()).post(GDTRecyclerAdWrapper.this.loadListener);
                                return;
                            }
                            GDTRecyclerAdWrapper.this.isPreRender = true;
                        }
                    } else if (adPatternType == 100000) {
                        GDTRecyclerAdWrapper.this.isPreRender = true;
                    }
                    if (GDTRecyclerAdWrapper.this.isPreRender) {
                        GDTRecyclerAdWrapper.this.loadNativeExpressAD(fetchCount);
                    } else {
                        GDTRecyclerAdWrapper.this.loadNativeUnifiedAD(fetchCount);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        try {
            GDTExpressAdListenerAdapter gDTExpressAdListenerAdapter = this.gdtExpressAdapter;
            if (gDTExpressAdListenerAdapter != null) {
                gDTExpressAdListenerAdapter.destroy();
                this.gdtExpressAdapter = null;
            }
            this.gdtNativeAdapter = null;
            this.nativeExpressAD = null;
            this.nativeUnifiedAD = null;
            this.context = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.isPreRender) {
                GDTExpressAdListenerAdapter gDTExpressAdListenerAdapter = this.gdtExpressAdapter;
                if (gDTExpressAdListenerAdapter == null || gDTExpressAdListenerAdapter.getAdList() == null) {
                    return;
                }
                for (NativeExpressADView nativeExpressADView : this.gdtExpressAdapter.getAdList()) {
                    if (z) {
                        HashMap map = new HashMap();
                        map.put("expectCostPrice", Integer.valueOf(nativeExpressADView.getECPM()));
                        map.put("highestLossPrice", Integer.valueOf(i));
                        nativeExpressADView.sendWinNotification(map);
                    } else {
                        HashMap map2 = new HashMap();
                        map2.put("winPrice", Integer.valueOf(i));
                        map2.put("lossReason", 1);
                        map2.put("adnId", "2");
                        nativeExpressADView.sendLossNotification(map2);
                    }
                }
                return;
            }
            GDTNativeUnifiedAdListenerAdapter gDTNativeUnifiedAdListenerAdapter = this.gdtNativeAdapter;
            if (gDTNativeUnifiedAdListenerAdapter == null || gDTNativeUnifiedAdListenerAdapter.getAdList() == null) {
                return;
            }
            for (NativeUnifiedADData nativeUnifiedADData : this.gdtNativeAdapter.getAdList()) {
                if (z) {
                    HashMap map3 = new HashMap();
                    map3.put("expectCostPrice", Integer.valueOf(nativeUnifiedADData.getECPM()));
                    map3.put("highestLossPrice", Integer.valueOf(t0.a(nativeUnifiedADData.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    nativeUnifiedADData.sendWinNotification(map3);
                } else {
                    HashMap map4 = new HashMap();
                    map4.put("winPrice", Integer.valueOf(i));
                    map4.put("lossReason", 1);
                    map4.put("adnId", "2");
                    nativeUnifiedADData.sendLossNotification(map4);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
