package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.baidu.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.baidu.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BaiduDrawExpressAd extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private XAdNativeResponse f2997a;
    private FeedPortraitVideoView b;
    private boolean c;
    private MediationAdSlotValueSet d;
    private WeakReference<Context> e;

    public BaiduDrawExpressAd(Context context, XAdNativeResponse xAdNativeResponse, MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction, Function function, MediationAdSlotValueSet mediationAdSlotValueSet) {
        super(mediationAdLoaderBaseFunction, function);
        this.c = false;
        this.e = new WeakReference<>(context);
        this.f2997a = xAdNativeResponse;
        this.d = mediationAdSlotValueSet;
        a(context, xAdNativeResponse);
    }

    private void a() {
        if (this.f2997a == null) {
            notifyRenderFail(this.b, MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, "物料错误");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        FeedPortraitVideoView feedPortraitVideoView = this.b;
        if (feedPortraitVideoView != null) {
            arrayList.add(feedPortraitVideoView);
        }
        this.f2997a.registerViewForInteraction(this.b, arrayList, arrayList2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawExpressAd.3
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                BaiduDrawExpressAd.this.notifyOnShowAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                BaiduDrawExpressAd.this.notifyOnClickAd();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
        this.b.setAdData(this.f2997a);
        this.b.play();
        notifyRenderSuccess(this.d.getWidth(), this.d.getHeight());
    }

    private void a(Context context, XAdNativeResponse xAdNativeResponse) {
        double dDoubleValue;
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (isClientBidding()) {
            try {
                dDoubleValue = Double.valueOf(xAdNativeResponse.getECPMLevel()).doubleValue();
            } catch (Exception unused) {
                dDoubleValue = 0.0d;
            }
            sparseArray.put(8016, Double.valueOf(Math.max(dDoubleValue, 0.0d)));
        } else if (isMultiBidding()) {
            sparseArray.put(8058, xAdNativeResponse.getECPMLevel());
        }
        sparseArray.put(8033, true);
        sparseArray.put(8059, Integer.valueOf(BaiduAdapterUtil.getinteractionType(xAdNativeResponse.getAdActionType())));
        notifyNativeValue(sparseArray);
        FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(context);
        this.b = feedPortraitVideoView;
        feedPortraitVideoView.setVideoMute(this.d.isMuted());
        this.f2997a.setAdPrivacyListener(new NativeResponse.AdDownloadWindowListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawExpressAd.1
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
            public void adDownloadWindowClose() {
                BaiduDrawExpressAd.this.b.resume();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDownloadWindowListener
            public void adDownloadWindowShow() {
                BaiduDrawExpressAd.this.b.pause();
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADFunctionClick() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPermissionClose() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPermissionShow() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdPrivacyListener
            public void onADPrivacyClick() {
            }
        });
        this.b.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawExpressAd.2
            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void pauseBtnClick() {
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playCompletion() {
                BaiduDrawExpressAd.this.notifyOnVideoComplete();
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playError() {
                BaiduDrawExpressAd.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "error is null");
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playPause() {
                BaiduDrawExpressAd.this.notifyOnVideoPause();
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playRenderingStart() {
                BaiduDrawExpressAd.this.notifyOnVideoStart();
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playResume() {
                BaiduDrawExpressAd.this.notifyOnVideoResume();
            }
        });
    }

    private String b() {
        try {
            XAdNativeResponse xAdNativeResponse = this.f2997a;
            if (xAdNativeResponse != null) {
                return (String) xAdNativeResponse.getAdDataForKey("request_id");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [T, java.util.HashMap, java.util.Map] */
    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        XAdNativeResponse xAdNativeResponse;
        if (i == 6083) {
            a();
        } else {
            if (i == 6081) {
                return (T) this.b;
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(this.c);
            }
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8109) {
                this.c = true;
            } else {
                if (i == 8147) {
                    return (T) b();
                }
                if (i == 8142) {
                    if (BaiduAdapterUtil.hasMethodBiddingSuccess(this.f2997a)) {
                        Map<? extends String, ? extends Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------baidu_bid_win --------- map = " + map);
                        if (map != null) {
                            LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                            linkedHashMap.putAll(map);
                            XAdNativeResponse xAdNativeResponse2 = this.f2997a;
                            if (xAdNativeResponse2 != null) {
                                xAdNativeResponse2.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawExpressAd.4
                                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                                    public void onBiddingResult(boolean z, String str, HashMap<String, Object> map2) {
                                        MediationApiLog.i("baidu-onBiddingResult-win: " + z + "msg: " + str);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 8144) {
                    if (BaiduAdapterUtil.hasMethodBiddingFail(this.f2997a)) {
                        Map<? extends String, ? extends Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------baidu_bid_lose --------- map = " + map2);
                        if (map2 != null) {
                            LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                            linkedHashMap2.putAll(map2);
                            XAdNativeResponse xAdNativeResponse3 = this.f2997a;
                            if (xAdNativeResponse3 != null) {
                                xAdNativeResponse3.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduDrawExpressAd.5
                                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                                    public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                        MediationApiLog.i("baidu-onBiddingResult-loss: " + z + "msg: " + str);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 8239 && (xAdNativeResponse = this.f2997a) != null) {
                    try {
                        Object adDataForKey = xAdNativeResponse.getAdDataForKey("act_url");
                        Object adDataForKey2 = this.f2997a.getAdDataForKey(OapsKey.KEY_PAGEKEY);
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
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public Integer isReadyStatus() {
        WeakReference<Context> weakReference = this.e;
        Context context = weakReference != null ? weakReference.get() : null;
        XAdNativeResponse xAdNativeResponse = this.f2997a;
        return Integer.valueOf((xAdNativeResponse == null || !xAdNativeResponse.isAdAvailable(context)) ? 4 : 2);
    }
}
