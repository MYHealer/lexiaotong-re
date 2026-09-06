package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.DislikeEvent;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.INativeVideoListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.api.XNativeView;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.baidu.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.baidu.base.config.MediationViewBinder;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BaiduBannerLoader extends BaiduBaseLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationAdSlotValueSet f2980a;
    private Function<SparseArray<Object>, Object> b;
    private boolean c;
    private WeakReference<Context> d;
    private final BaiduNativeManager.ExpressAdListener e = new BaiduNativeManager.ExpressAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.1
        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onLpClosed() {
        }

        @JProtect
        public void onNativeFail(int i, String str) {
            BaiduBannerLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        @JProtect
        public void onNativeFail(int i, String str, ExpressResponse expressResponse) {
            BaiduBannerLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        @JProtect
        public void onNativeLoad(List<ExpressResponse> list) {
            if (list == null || list.size() <= 0) {
                BaiduBannerLoader.this.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功，但list为空");
                return;
            }
            for (ExpressResponse expressResponse : list) {
                if (expressResponse != null) {
                    BaiduBannerLoader.this.new BaiduNativeExpressAd(expressResponse).render();
                    return;
                }
            }
        }

        @JProtect
        public void onNoAd(int i, String str) {
            BaiduBannerLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        @JProtect
        public void onNoAd(int i, String str, ExpressResponse expressResponse) {
            BaiduBannerLoader.this.notifyAdFailed(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.ExpressAdListener
        public void onVideoDownloadSuccess() {
        }
    };

    class BaiduNativeAd extends MediationBaseAdBridge {
        private XAdNativeResponse b;
        private boolean c;

        BaiduNativeAd(XAdNativeResponse xAdNativeResponse, Context context) {
            double dDoubleValue;
            int i;
            int iValueOf;
            super(BaiduBannerLoader.this.f2980a, BaiduBannerLoader.this.b);
            this.c = false;
            this.b = xAdNativeResponse;
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(8045, xAdNativeResponse.getTitle());
            sparseArray.put(8046, xAdNativeResponse.getDesc());
            sparseArray.put(8047, Integer.valueOf((int) xAdNativeResponse.getAppSize()));
            sparseArray.put(8048, xAdNativeResponse.getIconUrl());
            sparseArray.put(8049, xAdNativeResponse.getBrandName());
            sparseArray.put(8050, xAdNativeResponse.getImageUrl());
            sparseArray.put(8051, Integer.valueOf(xAdNativeResponse.getMainPicHeight()));
            sparseArray.put(8052, Integer.valueOf(xAdNativeResponse.getMainPicWidth()));
            sparseArray.put(8053, xAdNativeResponse.getMultiPicUrls());
            sparseArray.put(8054, xAdNativeResponse.getAppPackage());
            sparseArray.put(8055, Boolean.valueOf(BaiduAdapterUtil.isDownloadAd(xAdNativeResponse)));
            sparseArray.put(8056, xAdNativeResponse.getBrandName());
            sparseArray.put(8057, xAdNativeResponse.getPublisher());
            sparseArray.put(8079, xAdNativeResponse.getAppPermissionLink());
            sparseArray.put(8080, xAdNativeResponse.getAppPrivacyLink());
            try {
                sparseArray.put(8551, xAdNativeResponse.getAppFunctionLink());
            } catch (Throwable unused) {
            }
            sparseArray.put(8078, Long.valueOf(xAdNativeResponse.getAppSize()));
            List<DislikeEvent> dislikeList = xAdNativeResponse.getDislikeList();
            if (dislikeList != null && dislikeList.size() > 0) {
                sparseArray.put(8036, dislikeList);
            }
            if (BaiduBannerLoader.this.isClientBidding()) {
                try {
                    dDoubleValue = Double.valueOf(xAdNativeResponse.getECPMLevel()).doubleValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    dDoubleValue = 0.0d;
                }
                sparseArray.put(8016, Double.valueOf(dDoubleValue));
            } else if (BaiduBannerLoader.this.isMultiBidding()) {
                sparseArray.put(8058, xAdNativeResponse.getECPMLevel());
            }
            sparseArray.put(8059, Integer.valueOf(BaiduAdapterUtil.getinteractionType(xAdNativeResponse.getAdActionType())));
            sparseArray.put(8033, false);
            if (xAdNativeResponse.getMultiPicUrls() == null || xAdNativeResponse.getMultiPicUrls().size() != 3) {
                if (!TextUtils.isEmpty(xAdNativeResponse.getVideoUrl()) || xAdNativeResponse.getMaterialType() == NativeResponse.MaterialType.VIDEO || xAdNativeResponse.getMaterialType() == NativeResponse.MaterialType.LIVE) {
                    i = 5;
                } else {
                    iValueOf = 3;
                }
                sparseArray.put(8060, iValueOf);
                sparseArray.put(-99999987, 8140);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
                this.b.setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.1
                    public void onDislikeClick() {
                        if (BaiduNativeAd.this.mGMAd != null) {
                            SparseArray<Object> sparseArray2 = new SparseArray<>();
                            sparseArray2.put(-99999987, 1014);
                            sparseArray2.put(-99999985, Void.class);
                            BaiduNativeAd.this.mGMAd.apply(sparseArray2);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                    public void onDislikeItemClick(String str) {
                        if (BaiduNativeAd.this.mGMAd != null) {
                            SparseArray<Object> sparseArray2 = new SparseArray<>();
                            sparseArray2.put(-99999987, 1014);
                            sparseArray2.put(-99999985, Void.class);
                            BaiduNativeAd.this.mGMAd.apply(sparseArray2);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                    public void onDislikeWindowClose() {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                    public void onDislikeWindowShow() {
                    }
                });
            }
            i = 4;
            iValueOf = Integer.valueOf(i);
            sparseArray.put(8060, iValueOf);
            sparseArray.put(-99999987, 8140);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
            this.b.setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.1
                public void onDislikeClick() {
                    if (BaiduNativeAd.this.mGMAd != null) {
                        SparseArray<Object> sparseArray2 = new SparseArray<>();
                        sparseArray2.put(-99999987, 1014);
                        sparseArray2.put(-99999985, Void.class);
                        BaiduNativeAd.this.mGMAd.apply(sparseArray2);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                public void onDislikeItemClick(String str) {
                    if (BaiduNativeAd.this.mGMAd != null) {
                        SparseArray<Object> sparseArray2 = new SparseArray<>();
                        sparseArray2.put(-99999987, 1014);
                        sparseArray2.put(-99999985, Void.class);
                        BaiduNativeAd.this.mGMAd.apply(sparseArray2);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                public void onDislikeWindowClose() {
                }

                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                public void onDislikeWindowShow() {
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1008);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        private String b() {
            try {
                XAdNativeResponse xAdNativeResponse = this.b;
                if (xAdNativeResponse != null) {
                    return (String) xAdNativeResponse.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.util.HashMap, java.util.Map] */
        @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            XAdNativeResponse xAdNativeResponse;
            Map<? extends String, ? extends Object> map;
            Map<? extends String, ? extends Object> map2;
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8159) {
                Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(8067), ViewGroup.class, null);
                List<View> list = (List) MediationValueUtil.objectValue(sparseArray.get(8068), List.class, null);
                List<View> list2 = (List) MediationValueUtil.objectValue(sparseArray.get(8069), List.class, null);
                registerView(activity, viewGroup, list, list2, BaiduAdapterUtil.buildViewBinder(AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8071), Object.class, null))));
            } else if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8147) {
                    return (T) b();
                }
                if (i == 8142) {
                    if (BaiduAdapterUtil.hasMethodBiddingSuccess(this.b) && (map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null)) != null) {
                        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                        linkedHashMap.putAll(map2);
                        XAdNativeResponse xAdNativeResponse2 = this.b;
                        if (xAdNativeResponse2 != null) {
                            xAdNativeResponse2.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.7
                                @Override // com.baidu.mobads.sdk.api.BiddingListener
                                public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                    MediationApiLog.i("baidu-onBiddingResult-win: " + z + "msg: " + str);
                                }
                            });
                        }
                    }
                } else if (i == 8144) {
                    if (BaiduAdapterUtil.hasMethodBiddingFail(this.b) && (map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null)) != null) {
                        LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                        linkedHashMap2.putAll(map);
                        XAdNativeResponse xAdNativeResponse3 = this.b;
                        if (xAdNativeResponse3 != null) {
                            xAdNativeResponse3.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.8
                                @Override // com.baidu.mobads.sdk.api.BiddingListener
                                public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                    MediationApiLog.i("baidu-onBiddingResult-loss: " + z + "msg: " + str);
                                }
                            });
                        }
                    }
                } else if (i == 8239 && (xAdNativeResponse = this.b) != null) {
                    try {
                        Object adDataForKey = xAdNativeResponse.getAdDataForKey("act_url");
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

        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.util.HashMap, java.util.Map] */
        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            XAdNativeResponse xAdNativeResponse;
            Map<? extends String, ? extends Object> map;
            Map<? extends String, ? extends Object> map2;
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), valueSet, cls);
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8159) {
                Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                ViewGroup viewGroup = (ViewGroup) valueSet.objectValue(8067, ViewGroup.class);
                List<View> list = (List) valueSet.objectValue(8068, List.class);
                List<View> list2 = (List) valueSet.objectValue(8069, List.class);
                registerView(activity, viewGroup, list, list2, BaiduAdapterUtil.buildViewBinder(AdnAdapterBridgeWrapper.covertToFunction((Bridge) valueSet.objectValue(8071, Bridge.class))));
            } else if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8147) {
                    return (T) b();
                }
                if (i == 8142) {
                    if (BaiduAdapterUtil.hasMethodBiddingSuccess(this.b) && (map2 = (Map) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class)) != null) {
                        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                        linkedHashMap.putAll(map2);
                        XAdNativeResponse xAdNativeResponse2 = this.b;
                        if (xAdNativeResponse2 != null) {
                            xAdNativeResponse2.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.5
                                @Override // com.baidu.mobads.sdk.api.BiddingListener
                                public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                    MediationApiLog.i("baidu-onBiddingResult-win: " + z + "msg: " + str);
                                }
                            });
                        }
                    }
                } else if (i == 8144) {
                    if (BaiduAdapterUtil.hasMethodBiddingFail(this.b) && (map = (Map) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, Map.class)) != null) {
                        LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                        linkedHashMap2.putAll(map);
                        XAdNativeResponse xAdNativeResponse3 = this.b;
                        if (xAdNativeResponse3 != null) {
                            xAdNativeResponse3.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.6
                                @Override // com.baidu.mobads.sdk.api.BiddingListener
                                public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                    MediationApiLog.i("baidu-onBiddingResult-loss: " + z + "msg: " + str);
                                }
                            });
                        }
                    }
                } else if (i == 8239 && (xAdNativeResponse = this.b) != null) {
                    try {
                        Object adDataForKey = xAdNativeResponse.getAdDataForKey("act_url");
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

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.c;
        }

        public boolean hasDislike() {
            return false;
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            Context context = BaiduBannerLoader.this.d != null ? (Context) BaiduBannerLoader.this.d.get() : null;
            XAdNativeResponse xAdNativeResponse = this.b;
            return Integer.valueOf((xAdNativeResponse == null || !xAdNativeResponse.isAdAvailable(context)) ? 4 : 2);
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            this.c = true;
        }

        @JProtect
        public void registerView(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, MediationViewBinder mediationViewBinder) {
            if (this.b != null) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.logoLayoutId);
                if (viewGroup2 != null) {
                    viewGroup2.setVisibility(0);
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setGravity(17);
                    linearLayout.setOrientation(0);
                    linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                    ImageView imageView = new ImageView(context);
                    imageView.setLayoutParams(new LinearLayout.LayoutParams(BaiduAdapterUtil.dp2px(context, 15.0f), BaiduAdapterUtil.dp2px(context, 15.0f)));
                    linearLayout.addView(imageView);
                    ImageView imageView2 = new ImageView(context);
                    imageView2.setLayoutParams(new LinearLayout.LayoutParams(BaiduAdapterUtil.dp2px(context, 25.0f), BaiduAdapterUtil.dp2px(context, 13.0f)));
                    linearLayout.addView(imageView2);
                    new DownloadImageTask(imageView).execute(this.b.getBaiduLogoUrl());
                    new DownloadImageTask(imageView2).execute(this.b.getAdLogoUrl());
                    viewGroup2.removeAllViews();
                    ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                    layoutParams.width = BaiduAdapterUtil.dp2px(context, 38.0f);
                    layoutParams.height = BaiduAdapterUtil.dp2px(context, 13.0f);
                    viewGroup2.setLayoutParams(layoutParams);
                    viewGroup2.addView(linearLayout, -1, -1);
                }
                ViewGroup viewGroup3 = (ViewGroup) viewGroup.findViewById(mediationViewBinder.mediaViewId);
                if (viewGroup3 != null && (this.b.getStyleType() == 37 || this.b.getMaterialType() == NativeResponse.MaterialType.VIDEO || this.b.getMaterialType() == NativeResponse.MaterialType.LIVE)) {
                    XNativeView xNativeView = new XNativeView(context);
                    xNativeView.setNativeItem(this.b);
                    xNativeView.setVideoMute(BaiduBannerLoader.this.c);
                    xNativeView.setNativeVideoListener(new INativeVideoListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.2
                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onCompletion() {
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onError() {
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onPause() {
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onRenderingStart() {
                        }

                        @Override // com.baidu.mobads.sdk.api.INativeVideoListener
                        public void onResume() {
                        }
                    });
                    viewGroup3.removeAllViews();
                    viewGroup3.addView(xNativeView, -1, -1);
                    xNativeView.setNativeViewClickListener(new XNativeView.INativeViewClickListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.3
                        @Override // com.baidu.mobads.sdk.api.XNativeView.INativeViewClickListener
                        public void onNativeViewClick(XNativeView xNativeView2) {
                        }
                    });
                    xNativeView.render();
                }
                this.b.registerViewForInteraction(viewGroup, list, list2, new NativeResponse.AdInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeAd.4
                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void adActReward(int i) {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void adActRewardSuccess() {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADExposed() {
                        BaiduNativeAd.this.a();
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADExposureFailed(int i) {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onADStatusChanged() {
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onAdClick() {
                        if (BaiduNativeAd.this.mGMAd != null) {
                            SparseArray<Object> sparseArray = new SparseArray<>();
                            sparseArray.put(-99999987, 1009);
                            sparseArray.put(-99999985, Void.TYPE);
                            BaiduNativeAd.this.mGMAd.apply(sparseArray);
                        }
                    }

                    @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
                    public void onAdUnionClick() {
                    }
                });
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    class BaiduNativeExpressAd extends MediationBaseAdBridge {
        private final ExpressResponse b;
        private boolean c;

        BaiduNativeExpressAd(ExpressResponse expressResponse) {
            double dDoubleValue;
            super(BaiduBannerLoader.this.f2980a, BaiduBannerLoader.this.b);
            this.c = false;
            this.b = expressResponse;
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8140);
            sparseArray.put(-99999985, Void.class);
            if (BaiduBannerLoader.this.isClientBidding()) {
                try {
                    dDoubleValue = Double.valueOf(expressResponse.getECPMLevel()).doubleValue();
                } catch (Exception e) {
                    e.printStackTrace();
                    dDoubleValue = 0.0d;
                }
                sparseArray.put(8016, Double.valueOf(dDoubleValue));
            } else if (BaiduBannerLoader.this.isMultiBidding()) {
                sparseArray.put(8058, expressResponse.getECPMLevel());
            }
            sparseArray.put(8033, true);
            sparseArray.put(8055, Boolean.valueOf(BaiduAdapterUtil.isDownloadAd(expressResponse)));
            sparseArray.put(8059, Integer.valueOf(BaiduAdapterUtil.getinteractionType(expressResponse.getAdActionType())));
            this.mGMAd.apply(sparseArray);
            this.b.setInteractionListener(new ExpressResponse.ExpressInteractionListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeExpressAd.1
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdClick() {
                    if (BaiduNativeExpressAd.this.mGMAd != null) {
                        SparseArray<Object> sparseArray2 = new SparseArray<>();
                        sparseArray2.put(-99999987, 1009);
                        sparseArray2.put(-99999985, Void.class);
                        BaiduNativeExpressAd.this.mGMAd.apply(sparseArray2);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdExposed() {
                    if (BaiduNativeExpressAd.this.mGMAd != null) {
                        SparseArray<Object> sparseArray2 = new SparseArray<>();
                        sparseArray2.put(-99999987, 1008);
                        sparseArray2.put(-99999985, Void.class);
                        BaiduNativeExpressAd.this.mGMAd.apply(sparseArray2);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderFail(View view, String str, int i) {
                    BaiduBannerLoader.this.notifyAdFailed(i, str);
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdRenderSuccess(View view, float f, float f2) {
                    BaiduBannerLoader baiduBannerLoader = BaiduBannerLoader.this;
                    BaiduNativeExpressAd baiduNativeExpressAd = BaiduNativeExpressAd.this;
                    baiduBannerLoader.notifyAdSuccess(baiduNativeExpressAd, baiduNativeExpressAd.mGMAd);
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressInteractionListener
                public void onAdUnionClick() {
                }
            });
            this.b.setAdDislikeListener(new ExpressResponse.ExpressDislikeListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeExpressAd.2
                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeItemClick(String str) {
                    if (BaiduNativeExpressAd.this.mGMAd != null) {
                        SparseArray<Object> sparseArray2 = new SparseArray<>();
                        sparseArray2.put(-99999987, 1014);
                        sparseArray2.put(-99999985, Void.class);
                        BaiduNativeExpressAd.this.mGMAd.apply(sparseArray2);
                    }
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeWindowClose() {
                }

                @Override // com.baidu.mobads.sdk.api.ExpressResponse.ExpressDislikeListener
                public void onDislikeWindowShow() {
                }
            });
        }

        private String a() {
            try {
                ExpressResponse expressResponse = this.b;
                if (expressResponse != null) {
                    return (String) expressResponse.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.util.HashMap, java.util.Map] */
        @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            ExpressResponse expressResponse;
            if (i == 6081) {
                return (T) getAdView();
            }
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8109) {
                onDestroy();
            } else {
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
                            ExpressResponse expressResponse2 = this.b;
                            if (expressResponse2 != null) {
                                expressResponse2.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeExpressAd.3
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
                            ExpressResponse expressResponse3 = this.b;
                            if (expressResponse3 != null) {
                                expressResponse3.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.BaiduNativeExpressAd.4
                                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                                    public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                        MediationApiLog.i("baidu-onBiddingResult-loss: " + z + "msg: " + str);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 8239 && (expressResponse = this.b) != null) {
                    try {
                        Object adDataForKey = expressResponse.getAdDataForKey("act_url");
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

        @JProtect
        public View getAdView() {
            ExpressResponse expressResponse = this.b;
            if (expressResponse != null) {
                return expressResponse.getExpressAdView();
            }
            return null;
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.c;
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            ExpressResponse expressResponse = this.b;
            return Integer.valueOf((expressResponse == null || !expressResponse.isAdAvailable()) ? 4 : 2);
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            this.c = true;
        }

        @JProtect
        public void render() {
            ExpressResponse expressResponse = this.b;
            if (expressResponse != null) {
                expressResponse.render();
            } else {
                BaiduBannerLoader.this.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "render fail, mExpressResponse is null");
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    private void a(Context context) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, getAdnId());
        String baiduAppSid = this.f2980a.getBaiduAppSid();
        if (!TextUtils.isEmpty(baiduAppSid)) {
            baiduNativeManager.setAppSid(baiduAppSid);
        }
        this.c = this.f2980a.isMuted();
        RequestParameters requestParametersBuild = new RequestParameters.Builder().build();
        setBiddingResult(getAdnId(), isClientBidding(), requestParametersBuild);
        if (this.f2980a.getBaiduRequestParameters() instanceof RequestParameters) {
            requestParametersBuild = (RequestParameters) this.f2980a.getBaiduRequestParameters();
        }
        baiduNativeManager.setCacheVideoOnlyWifi(this.f2980a.getBaiduCacheVideoOnlyWifi());
        baiduNativeManager.loadExpressAd(requestParametersBuild, this.e);
    }

    private void b(final Context context) {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(context, getAdnId());
        String baiduAppSid = this.f2980a.getBaiduAppSid();
        if (!TextUtils.isEmpty(baiduAppSid)) {
            baiduNativeManager.setAppSid(baiduAppSid);
        }
        this.c = this.f2980a.isMuted();
        RequestParameters requestParametersBuild = new RequestParameters.Builder().build();
        if (this.f2980a.getBaiduRequestParameters() instanceof RequestParameters) {
            requestParametersBuild = (RequestParameters) this.f2980a.getBaiduRequestParameters();
        }
        setBiddingResult(getAdnId(), isClientBidding(), requestParametersBuild);
        baiduNativeManager.setCacheVideoOnlyWifi(this.f2980a.getBaiduCacheVideoOnlyWifi());
        baiduNativeManager.loadFeedAd(requestParametersBuild, new BaiduNativeManager.FeedAdListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduBannerLoader.2
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @JProtect
            public void onNativeFail(int i, String str) {
                BaiduBannerLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
                BaiduBannerLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.size() <= 0) {
                    BaiduBannerLoader.this.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功，但list为空");
                    return;
                }
                BaiduNativeAd baiduNativeAd = BaiduBannerLoader.this.new BaiduNativeAd((XAdNativeResponse) list.get(0), context);
                BaiduBannerLoader baiduBannerLoader = BaiduBannerLoader.this;
                baiduBannerLoader.notifyAdSuccess(baiduNativeAd, baiduBannerLoader.b);
            }

            @JProtect
            public void onNoAd(int i, String str) {
                BaiduBannerLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            @JProtect
            public void onNoAd(int i, String str, NativeResponse nativeResponse) {
                BaiduBannerLoader.this.notifyAdFailed(i, str);
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }
        });
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        String str;
        if (!(context instanceof Activity)) {
            notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_CONTEXT, "context type error, context need activity");
            return;
        }
        if (mediationAdSlotValueSet != null) {
            this.d = new WeakReference<>(context);
            this.f2980a = mediationAdSlotValueSet;
            this.b = getGMBridge();
            int originType = mediationAdSlotValueSet.getOriginType();
            if (originType == 1 || originType == 2) {
                b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                return;
            } else {
                if (originType == 3) {
                    a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                    return;
                }
                str = "originType类型错误";
            }
        } else {
            str = "context is null or adSlotValueSet is null";
        }
        notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, str);
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
