package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.baidu.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BaiduInterstitialLoader extends MediationAdLoaderBaseFunction {

    class BaiduExpressInterstitialAd extends MediationBaseAdBridge implements ExpressInterstitialListener {
        private ExpressInterstitialAd b;

        public BaiduExpressInterstitialAd(MediationAdSlotValueSet mediationAdSlotValueSet, Function<SparseArray<Object>, Object> function) {
            super(mediationAdSlotValueSet, function);
        }

        private String a() {
            try {
                ExpressInterstitialAd expressInterstitialAd = this.b;
                if (expressInterstitialAd != null) {
                    return (String) expressInterstitialAd.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @JProtect
        void a(Context context) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd load adnId:" + BaiduInterstitialLoader.this.getAdnId());
            ExpressInterstitialAd expressInterstitialAd = new ExpressInterstitialAd(StubApp.getOrigApplicationContext(context.getApplicationContext()), BaiduInterstitialLoader.this.getAdnId());
            this.b = expressInterstitialAd;
            expressInterstitialAd.setLoadListener(this);
            this.b.load();
        }

        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.util.HashMap, java.util.Map] */
        @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            ExpressInterstitialAd expressInterstitialAd;
            if (i == 8113) {
                MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd showAd");
                Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                if (activity != null) {
                    showAd(activity);
                }
            } else if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(hasDestroyed());
                }
                if (i == 8121) {
                    return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
                }
                if (i == 8147) {
                    return (T) a();
                }
                if (i == 8142) {
                    if (BaiduAdapterUtil.hasMethodBiddingSuccess(this.b)) {
                        Map<? extends String, ? extends Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------baidu_bid_win --------- map = " + map);
                        if (map != null) {
                            LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                            linkedHashMap.putAll(map);
                            ExpressInterstitialAd expressInterstitialAd2 = this.b;
                            if (expressInterstitialAd2 != null) {
                                expressInterstitialAd2.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduInterstitialLoader.BaiduExpressInterstitialAd.1
                                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                                    public void onBiddingResult(boolean z, String str, HashMap<String, Object> map2) {
                                        MediationApiLog.i("baidu-onBiddingResult-win: " + z + "msg: " + str);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 8144) {
                    if (BaiduAdapterUtil.hasMethodBiddingFail(this.b)) {
                        Map<? extends String, ? extends Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------baidu_bid_lose --------- map = " + map2);
                        if (map2 != null) {
                            LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                            linkedHashMap2.putAll(map2);
                            ExpressInterstitialAd expressInterstitialAd3 = this.b;
                            if (expressInterstitialAd3 != null) {
                                expressInterstitialAd3.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduInterstitialLoader.BaiduExpressInterstitialAd.2
                                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                                    public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                        MediationApiLog.i("baidu-onBiddingResult-loss: " + z + "msg: " + str);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 8239 && (expressInterstitialAd = this.b) != null) {
                    try {
                        Object adDataForKey = expressInterstitialAd.getAdDataForKey("act_url");
                        Object adDataForKey2 = this.b.getAdDataForKey(OapsKey.KEY_PAGEKEY);
                        ?? r2 = (T) new HashMap();
                        r2.put("act_url", adDataForKey);
                        r2.put(OapsKey.KEY_PAGEKEY, adDataForKey2);
                        return r2;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.b == null;
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onADExposed() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onADExposed  ");
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1008);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onADExposureFailed() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onADExposureFailed  ");
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1017);
                sparseArray.put(-99999985, Void.class);
                sparseArray.put(8014, 0);
                sparseArray.put(8015, "广告展示失败");
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onADLoaded() {
            double dDoubleValue;
            StringBuilder sb;
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onADLoaded ");
            if (this.b != null) {
                if (BaiduInterstitialLoader.this.isClientBidding()) {
                    try {
                        dDoubleValue = Double.valueOf(this.b.getECPMLevel()).doubleValue();
                    } catch (Exception e) {
                        e.printStackTrace();
                        dDoubleValue = 0.0d;
                    }
                    setCpm(dDoubleValue);
                    sb = new StringBuilder("BaiduInterstitialLoader Baidu_cientBidding full 返回的 cpm价格：");
                } else if (BaiduInterstitialLoader.this.isMultiBidding()) {
                    setLevelTag(this.b.getECPMLevel());
                    sb = new StringBuilder("BaiduInterstitialLoader Baidu_多阶底价 full 返回的 价格标签：");
                }
                MediationApiLog.i("TTMediationSDK", sb.append(this.b.getECPMLevel()).toString());
            }
            BaiduInterstitialLoader.this.notifyAdSuccess(this, this.mGMAd);
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdCacheFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdCacheSuccess() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onAdCacheSuccess ");
            BaiduInterstitialLoader.this.notifyAdCache(this.mGMAd, -1, "");
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdClick() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onAdClick ");
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1009);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdClose() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onAdClose ");
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1014);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onAdFailed(int i, String str) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onAdFailed errCode:" + i + "  s:" + str);
            BaiduInterstitialLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            if (this.b != null) {
                this.b = null;
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onLpClosed() {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onLpClosed ");
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1016);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.ExpressInterstitialListener
        @JProtect
        public void onNoAd(int i, String str) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader BaiduExpressInterstitialAd onNoAd  errCode:" + i + "  s:" + str);
            BaiduInterstitialLoader.this.notifyAdFailed(i, str);
        }

        @JProtect
        @Deprecated
        public void onVideoDownloadFailed() {
        }

        @JProtect
        @Deprecated
        public void onVideoDownloadSuccess() {
        }

        @JProtect
        public void showAd(Activity activity) {
            ExpressInterstitialAd expressInterstitialAd = this.b;
            if (expressInterstitialAd != null) {
                expressInterstitialAd.show(activity);
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    @JProtect
    private void a(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        new BaiduExpressInterstitialAd(mediationAdSlotValueSet, getGMBridge()).a(context);
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context != null) {
            MediationApiLog.i("TTMediationSDK", "BaiduInterstitialLoader realLoader adnId:" + getAdnId());
            int originType = getOriginType();
            if (originType == 1 || originType == 2) {
                a(StubApp.getOrigApplicationContext(context.getApplicationContext()), mediationAdSlotValueSet);
            } else if (originType == 3) {
                notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "类型有误");
            } else {
                a(StubApp.getOrigApplicationContext(context.getApplicationContext()), mediationAdSlotValueSet);
            }
        }
    }
}
