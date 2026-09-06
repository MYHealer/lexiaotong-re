package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsFullVideoLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KsFullVideoLoader f3350a;
    private boolean b;

    class a extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        KsLoadManager.FullScreenVideoAdListener f3352a;
        private KsFullScreenVideoAd c;

        public a(MediationAdSlotValueSet mediationAdSlotValueSet, Function function) {
            super(mediationAdSlotValueSet, function);
            this.f3352a = new KsLoadManager.FullScreenVideoAdListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.i.a.4
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                @JProtect
                public void onError(int i, String str) {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onError");
                    i.this.f3350a.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                @JProtect
                public void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
                    MediationApiLog.i("TMe", "ks_KsFullVideoLoader onFullScreenVideoAdLoad");
                    if (list == null || list.size() == 0 || list.get(0) == null) {
                        i.this.f3350a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "暂无广告");
                        return;
                    }
                    a.this.c = list.get(0);
                    if (i.this.f3350a.isClientBidding()) {
                        double ecpm = a.this.c.getECPM();
                        a aVar = a.this;
                        if (ecpm <= 0.0d) {
                            ecpm = 0.0d;
                        }
                        aVar.setCpm(ecpm);
                    }
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 8140);
                        sparseArray.put(-99999985, Void.class);
                        sparseArray.put(8059, Integer.valueOf(p.a(a.this.c.getInteractionType())));
                        a.this.mGMAd.apply(sparseArray);
                    }
                    a.this.setExpress();
                    a.this.c.setFullScreenVideoAdInteractionListener(new KsFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.i.a.4.1
                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdClicked() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onAdClicked");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1009);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onPageDismiss() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onPageDismiss");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1014);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onSkippedVideo() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onSkippedVideo");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1037);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoPlayEnd() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayEnd");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, Integer.valueOf(AnalyticsListener.EVENT_DRM_KEYS_REMOVED));
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoPlayError(int i, int i2) {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayError");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1021);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }

                        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoPlayStart() {
                            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onVideoPlayStart");
                            if (a.this.mGMAd != null) {
                                SparseArray<Object> sparseArray2 = new SparseArray<>();
                                sparseArray2.put(-99999987, 1008);
                                sparseArray2.put(-99999985, Void.class);
                                a.this.mGMAd.apply(sparseArray2);
                            }
                        }
                    });
                    KsFullVideoLoader ksFullVideoLoader = i.this.f3350a;
                    a aVar2 = a.this;
                    ksFullVideoLoader.notifyAdSuccess(aVar2, aVar2.mGMAd);
                    i.this.f3350a.notifyAdCache(a.this.mGMAd, MediationConstant.ErrorCode.ADN_AD_NO_CACHE, "没有cache回调");
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JProtect
        public void b(Activity activity) {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader showAd");
            if (activity == null || this.c == null) {
                return;
            }
            KsVideoPlayConfig.Builder builder = new KsVideoPlayConfig.Builder();
            boolean zIsMuted = isMuted();
            if (getOrientation() == 2) {
                builder.showLandscape(true);
            }
            builder.videoSoundEnable(!zIsMuted);
            this.c.showFullScreenVideoAd(activity, builder.build());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Integer c() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader isReadyStatus");
            KsFullScreenVideoAd ksFullScreenVideoAd = this.c;
            return Integer.valueOf((ksFullScreenVideoAd == null || !ksFullScreenVideoAd.isAdEnable()) ? 4 : 2);
        }

        private void c(final Activity activity) {
            o.b(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.b(activity);
                }
            });
        }

        private Integer d() {
            try {
                Integer num = (Integer) o.a(new Callable<Integer>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.i.a.2
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Integer call() {
                        return a.this.c();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    return num;
                }
                return 4;
            } catch (Exception e) {
                e.printStackTrace();
                return 4;
            }
        }

        private String e() {
            return i.this.b ? f() : g();
        }

        private String f() {
            try {
                return (String) o.a(new Callable<String>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.i.a.5
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String call() {
                        return a.this.g();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String g() {
            Object obj;
            try {
                KsFullScreenVideoAd ksFullScreenVideoAd = this.c;
                if (ksFullScreenVideoAd == null || (obj = ksFullScreenVideoAd.getMediaExtraInfo().get(KSUtil.REQUEST_ID)) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public void a() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader onDestroy");
            KsFullScreenVideoAd ksFullScreenVideoAd = this.c;
            if (ksFullScreenVideoAd != null) {
                ksFullScreenVideoAd.setFullScreenVideoAdInteractionListener(null);
                this.c = null;
            }
        }

        public void a(Activity activity) {
            if (i.this.b) {
                c(activity);
            } else {
                b(activity);
            }
        }

        @JProtect
        public void a(KsScene ksScene) {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader loadAd");
            KsAdSDK.getLoadManager().loadFullScreenVideoAd(ksScene, this.f3352a);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 8113) {
                MediationApiLog.i("TMe", "ks_KsFullVideoLoader showAd");
                Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                if (activity != null) {
                    a(activity);
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
                    return (T) e();
                }
                if (i == 8142) {
                    if (p.a(this.c)) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long jA = p.a((Map<String, Object>) map);
                            long jB = p.b((Map<String, Object>) map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                            KsFullScreenVideoAd ksFullScreenVideoAd = this.c;
                            if (ksFullScreenVideoAd != null) {
                                ksFullScreenVideoAd.setBidEcpm(jA, jB);
                            }
                        }
                    }
                } else if (i == 8144 && p.b(this.c)) {
                    Map map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int iC = p.c(map2);
                        int iD = p.d(map2);
                        int iE = p.e(map2);
                        String strF = p.f(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + iD + " failureCode = " + iC);
                        if (this.c != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(iD);
                            adExposureFailedReason.setAdnType(iE);
                            adExposureFailedReason.setAdnName(strF);
                            this.c.reportAdExposureFailed(iC, adExposureFailedReason);
                        }
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        public void b() {
            o.b(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.i.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.a();
                }
            });
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            MediationApiLog.i("TMe", "ks_KsFullVideoLoader hasDestroyed");
            return this.c == null;
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            return i.this.b ? d() : c();
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            if (i.this.b) {
                b();
            } else {
                a();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    public i(KsFullVideoLoader ksFullVideoLoader) {
        this.f3350a = ksFullVideoLoader;
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean zA = p.a(this.f3350a, mediationAdSlotValueSet);
        this.b = zA;
        if (zA) {
            o.a(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.this.a(mediationAdSlotValueSet);
                    o.a(getClass().getName(), context);
                }
            });
        } else {
            a(mediationAdSlotValueSet);
        }
    }

    public void a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        try {
            KsScene.Builder builder = new KsScene.Builder(Long.valueOf(this.f3350a.getAdnId()).longValue());
            f.a(builder, mediationAdSlotValueSet, "FULL_VIDEO");
            new a(mediationAdSlotValueSet, this.f3350a.getGMBridge()).a(builder.build());
        } catch (Exception unused) {
            this.f3350a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "代码位不合法");
        }
    }
}
