package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.baidu.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BaiduNativeExpressAd extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExpressResponse f3023a;
    private boolean b;

    public BaiduNativeExpressAd(Context context, ExpressResponse expressResponse, MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction, Function<SparseArray<Object>, Object> function) {
        super(mediationAdLoaderBaseFunction, function);
        this.b = false;
        this.f3023a = expressResponse;
        a();
    }

    private void a() {
        Object eCPMLevel;
        int i;
        double dDoubleValue;
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (!isClientBidding()) {
            if (isMultiBidding()) {
                eCPMLevel = this.f3023a.getECPMLevel();
                i = 8058;
            }
            sparseArray.put(8055, Boolean.valueOf(BaiduAdapterUtil.isDownloadAd(this.f3023a)));
            sparseArray.put(8059, Integer.valueOf(BaiduAdapterUtil.getinteractionType(this.f3023a.getAdActionType())));
            sparseArray.put(8033, true);
            notifyNativeValue(sparseArray);
            this.f3023a.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeExpressAd.1
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdClick() {
                    BaiduNativeExpressAd.this.notifyOnClickAd();
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdExposed() {
                    BaiduNativeExpressAd.this.notifyOnShowAd();
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderFail(View view, String str, int i2) {
                    BaiduNativeExpressAd.this.notifyRenderFail(view, i2, str);
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderSuccess(View view, float f, float f2) {
                    BaiduNativeExpressAd.this.notifyRenderSuccess(f, f2);
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdUnionClick() {
                }
            });
        }
        try {
            dDoubleValue = Double.valueOf(this.f3023a.getECPMLevel()).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            dDoubleValue = 0.0d;
        }
        eCPMLevel = Double.valueOf(Math.max(dDoubleValue, 0.0d));
        i = 8016;
        sparseArray.put(i, eCPMLevel);
        sparseArray.put(8055, Boolean.valueOf(BaiduAdapterUtil.isDownloadAd(this.f3023a)));
        sparseArray.put(8059, Integer.valueOf(BaiduAdapterUtil.getinteractionType(this.f3023a.getAdActionType())));
        sparseArray.put(8033, true);
        notifyNativeValue(sparseArray);
        this.f3023a.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeExpressAd.1
            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdClick() {
                BaiduNativeExpressAd.this.notifyOnClickAd();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdExposed() {
                BaiduNativeExpressAd.this.notifyOnShowAd();
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderFail(View view, String str, int i2) {
                BaiduNativeExpressAd.this.notifyRenderFail(view, i2, str);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdRenderSuccess(View view, float f, float f2) {
                BaiduNativeExpressAd.this.notifyRenderSuccess(f, f2);
            }

            @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
            public void onAdUnionClick() {
            }
        });
    }

    private String b() {
        try {
            ExpressResponse expressResponse = this.f3023a;
            if (expressResponse != null) {
                return (String) expressResponse.getAdDataForKey("request_id");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v10, types: [T, java.util.HashMap, java.util.Map] */
    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        ExpressResponse expressResponse;
        if (i == 8121) {
            return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
        }
        if (i == 6083) {
            ExpressResponse expressResponse2 = this.f3023a;
            if (expressResponse2 != null) {
                expressResponse2.render();
            } else {
                notifyRenderFail(null, MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, "物料错误");
            }
        } else {
            if (i == 8135) {
                return (T) true;
            }
            if (i == 6081) {
                ExpressResponse expressResponse3 = this.f3023a;
                if (expressResponse3 != null) {
                    return (T) expressResponse3.getExpressAdView();
                }
            } else if (i == 8109) {
                this.b = true;
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.b);
                }
                if (i == 6085) {
                    this.f3023a.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeExpressAd.2
                        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                        public void onDislikeItemClick(String str) {
                            BaiduNativeExpressAd.this.notifyDislikeClick("百度智能优选dislike接口无关闭原因", null);
                            BaiduNativeExpressAd.this.notifyDislikeSelect(0, "百度智能优选dislike接口无关闭原因");
                        }

                        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                        public void onDislikeWindowClose() {
                        }

                        @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                        public void onDislikeWindowShow() {
                        }
                    });
                } else {
                    if (i == 8147) {
                        return (T) b();
                    }
                    if (i == 8142) {
                        if (BaiduAdapterUtil.hasMethodBiddingSuccess(this.f3023a)) {
                            Map<? extends String, ? extends Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                            MediationApiLog.i("-------baidu_bid_win --------- map = " + map);
                            if (map != null) {
                                LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                                linkedHashMap.putAll(map);
                                ExpressResponse expressResponse4 = this.f3023a;
                                if (expressResponse4 != null) {
                                    expressResponse4.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeExpressAd.3
                                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                                        public void onBiddingResult(boolean z, String str, HashMap<String, Object> map2) {
                                            MediationApiLog.i("baidu-onBiddingResult-win: " + z + "msg: " + str);
                                        }
                                    });
                                }
                            }
                        }
                    } else if (i == 8144) {
                        if (BaiduAdapterUtil.hasMethodBiddingFail(this.f3023a)) {
                            Map<? extends String, ? extends Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                            MediationApiLog.i("-------baidu_bid_lose --------- map = " + map2);
                            if (map2 != null) {
                                LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                                linkedHashMap2.putAll(map2);
                                ExpressResponse expressResponse5 = this.f3023a;
                                if (expressResponse5 != null) {
                                    expressResponse5.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduNativeExpressAd.4
                                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                                        public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                            MediationApiLog.i("baidu-onBiddingResult-loss: " + z + "msg: " + str);
                                        }
                                    });
                                }
                            }
                        }
                    } else if (i == 8239 && (expressResponse = this.f3023a) != null) {
                        try {
                            Object adDataForKey = expressResponse.getAdDataForKey("act_url");
                            Object adDataForKey2 = this.f3023a.getAdDataForKey(OapsKey.KEY_PAGEKEY);
                            ?? r2 = (T) new HashMap();
                            r2.put("act_url", adDataForKey);
                            r2.put(OapsKey.KEY_PAGEKEY, adDataForKey2);
                            return r2;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public Integer isReadyStatus() {
        ExpressResponse expressResponse = this.f3023a;
        return Integer.valueOf((expressResponse == null || !expressResponse.isAdAvailable()) ? 4 : 2);
    }
}
