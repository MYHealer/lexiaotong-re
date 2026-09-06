package com.meishu.sdk.platform.bd.recycler;

import android.util.DisplayMetrics;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.bd.BDPlatformError;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDRecyclerLoader extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private static final String TAG = "BDRecyclerLoader";
    private BDRecyclerExpressListener bdRecyclerExpressListener;
    private BDRecyclerListener bdRecyclerListener;
    private boolean isPreRender;
    private BaiduNativeManager nativeManager;

    public BDRecyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
        this.isPreRender = false;
    }

    private void expressBiddingResult(boolean z, int i, ExpressResponse expressResponse) {
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.ExpressResponse");
            if (z) {
                cls.getDeclaredMethod("biddingSuccess", String.class).invoke(expressResponse, String.valueOf(t0.a(Integer.parseInt(expressResponse.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(expressResponse, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                    linkedHashMap.put("ecpm", Integer.valueOf(t0.a(Integer.parseInt(expressResponse.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    expressResponse.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerLoader.1
                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                } else {
                    LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                    linkedHashMap2.put("ecpm", Integer.valueOf(i));
                    int iNextInt = new Random().nextInt(10);
                    if (iNextInt != 0) {
                        i2 = iNextInt;
                    }
                    linkedHashMap2.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(i2));
                    linkedHashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap2.put("bid_t", 3);
                    linkedHashMap2.put("reason", "203");
                    expressResponse.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerLoader.2
                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void loadNativeAd() {
        RequestParameters requestParametersBuild = new RequestParameters.Builder().downloadAppConfirmPolicy(3).build();
        BDRecyclerListener bDRecyclerListener = new BDRecyclerListener((a) this.loadListener, this, getAdLoader().getFetchCount());
        this.bdRecyclerListener = bDRecyclerListener;
        this.nativeManager.loadFeedAd(requestParametersBuild, bDRecyclerListener);
    }

    private void nativeBiddingResult(boolean z, int i, NativeResponse nativeResponse) {
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.NativeResponse");
            if (z) {
                cls.getDeclaredMethod("biddingSuccess", String.class).invoke(nativeResponse, String.valueOf(t0.a(Integer.parseInt(nativeResponse.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(nativeResponse, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                    linkedHashMap.put("ecpm", Integer.valueOf(t0.a(Integer.parseInt(nativeResponse.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    nativeResponse.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerLoader.3
                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                } else {
                    LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                    linkedHashMap2.put("ecpm", Integer.valueOf(i));
                    int iNextInt = new Random().nextInt(10);
                    if (iNextInt != 0) {
                        i2 = iNextInt;
                    }
                    linkedHashMap2.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(i2));
                    linkedHashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap2.put("bid_t", 3);
                    linkedHashMap2.put("reason", "203");
                    nativeResponse.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerLoader.4
                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                }
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        this.context = null;
        if (this.nativeManager != null) {
            this.nativeManager = null;
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            String pid = getSdkAdInfo().getPid();
            z.a(getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            BaiduNativeManager baiduNativeManager = new BaiduNativeManager(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), pid);
            this.nativeManager = baiduNativeManager;
            baiduNativeManager.setAppSid(this.sdkAdInfo.getApp_id());
            this.nativeManager.setCacheVideoOnlyWifi(true);
            if (getAdLoader().getAdPatternType() != 200000) {
                loadNativeAd();
                return;
            }
            int drawing = getSdkAdInfo().getDrawing();
            if (drawing == 11) {
                loadExpressAd();
                return;
            }
            if (drawing != 2 && drawing != 1) {
                new BDPlatformError("信息流模式不支持", getSdkAdInfo()).post(this.loadListener);
                return;
            }
            loadNativeAd();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void loadExpressAd() {
        float fIntValue;
        float f;
        this.isPreRender = true;
        DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(this.context.getApplicationContext()).getResources().getDisplayMetrics();
        if (getAdLoader().getAccept_ad_width() == null || getAdLoader().getAccept_ad_width().intValue() <= 0) {
            fIntValue = displayMetrics.widthPixels;
            f = displayMetrics.density;
        } else {
            fIntValue = getAdLoader().getAccept_ad_width().intValue();
            f = displayMetrics.density;
        }
        RequestParameters requestParametersBuild = new RequestParameters.Builder().setWidth((int) ((fIntValue / f) * displayMetrics.density)).setHeight((int) (((getAdLoader().getAccept_ad_height() == null || getAdLoader().getAccept_ad_height().intValue() <= 0) ? 0.0f : getAdLoader().getAccept_ad_height().intValue() / displayMetrics.density) * displayMetrics.density)).downloadAppConfirmPolicy(2).build();
        BDRecyclerExpressListener bDRecyclerExpressListener = new BDRecyclerExpressListener(this, (a) this.loadListener);
        this.bdRecyclerExpressListener = bDRecyclerExpressListener;
        this.nativeManager.loadExpressAd(requestParametersBuild, bDRecyclerExpressListener);
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.isPreRender) {
                BDRecyclerExpressListener bDRecyclerExpressListener = this.bdRecyclerExpressListener;
                if (bDRecyclerExpressListener == null || bDRecyclerExpressListener.getList() == null) {
                    return;
                }
                Iterator<ExpressResponse> it = this.bdRecyclerExpressListener.getList().iterator();
                while (it.hasNext()) {
                    expressBiddingResult(z, i, it.next());
                }
                return;
            }
            BDRecyclerListener bDRecyclerListener = this.bdRecyclerListener;
            if (bDRecyclerListener == null || bDRecyclerListener.getList() == null) {
                return;
            }
            Iterator<NativeResponse> it2 = this.bdRecyclerListener.getList().iterator();
            while (it2.hasNext()) {
                nativeBiddingResult(z, i, it2.next());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
