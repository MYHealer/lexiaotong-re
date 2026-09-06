package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.ks.KsSplashLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.stub.StubApp;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KsSplashLoader f3385a;
    private boolean b;

    class a extends MediationBaseAdBridge {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        KsLoadManager.SplashScreenAdListener f3387a;
        private KsSplashScreenAd c;

        public a(MediationAdSlotValueSet mediationAdSlotValueSet, Function function) {
            super(mediationAdSlotValueSet, function);
            this.f3387a = new KsLoadManager.SplashScreenAdListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.n.a.4
                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onError(int i, String str) {
                    MediationApiLog.i("TMe", "KsSplashLoader load  onError");
                    n.this.f3385a.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onRequestResult(int i) {
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                    MediationApiLog.i("TMe", "KsSplashLoader load  onSplashScreenAdLoad ksSplashScreenAd:" + ksSplashScreenAd);
                    if (ksSplashScreenAd == null) {
                        n.this.f3385a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "ksSplashScreenAd is null");
                        return;
                    }
                    a.this.c = ksSplashScreenAd;
                    if (n.this.f3385a.isClientBidding()) {
                        double ecpm = ksSplashScreenAd.getECPM();
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
                    MediationApiLog.i("KsRewardLoader", "load success");
                    KsSplashLoader ksSplashLoader = n.this.f3385a;
                    a aVar2 = a.this;
                    ksSplashLoader.notifyAdSuccess(aVar2, aVar2.mGMAd);
                }
            };
        }

        private void b(final ViewGroup viewGroup) {
            o.b(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.n.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.c(viewGroup);
                }
            });
        }

        private String c() {
            return n.this.b ? d() : e();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(ViewGroup viewGroup) {
            View view;
            KsSplashScreenAd ksSplashScreenAd = this.c;
            if (ksSplashScreenAd == null || viewGroup == null || (view = ksSplashScreenAd.getView(viewGroup.getContext(), new KsSplashScreenAd.SplashScreenAdInteractionListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.n.a.2
                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onAdClicked() {
                    MediationApiLog.i("TMe", "KsSplashLoader onAdClicked");
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1009);
                        sparseArray.put(-99999985, Void.class);
                        a.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onAdShowEnd() {
                    MediationApiLog.i("TMe", "KsSplashLoader onAdShowEnd");
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1011);
                        sparseArray.put(-99999985, Void.class);
                        a.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onAdShowError(int i, String str) {
                    MediationApiLog.i("TMe", "KsSplashLoader onAdShowError");
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1017);
                        sparseArray.put(-99999985, Void.class);
                        sparseArray.put(8014, Integer.valueOf(i));
                        sparseArray.put(8015, str);
                        a.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onAdShowStart() {
                    MediationApiLog.i("TMe", "KsSplashLoader onAdShowStart");
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1008);
                        sparseArray.put(-99999985, Void.class);
                        a.this.mGMAd.apply(sparseArray);
                    }
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onDownloadTipsDialogCancel() {
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onDownloadTipsDialogDismiss() {
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onDownloadTipsDialogShow() {
                }

                @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
                public void onSkippedAd() {
                    MediationApiLog.i("TMe", "KsSplashLoader onSkippedAd");
                    if (a.this.mGMAd != null) {
                        SparseArray<Object> sparseArray = new SparseArray<>();
                        sparseArray.put(-99999987, 1019);
                        sparseArray.put(-99999985, Void.class);
                        a.this.mGMAd.apply(sparseArray);
                    }
                }
            })) == null) {
                return;
            }
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            viewGroup.removeAllViews();
            viewGroup.addView(view);
        }

        private String d() {
            try {
                return (String) o.a(new Callable<String>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.n.a.5
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public String call() {
                        return a.this.e();
                    }
                }).get(500L, TimeUnit.MILLISECONDS);
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String e() {
            Object obj;
            try {
                KsSplashScreenAd ksSplashScreenAd = this.c;
                if (ksSplashScreenAd == null || (obj = ksSplashScreenAd.getMediaExtraInfo().get(KSUtil.REQUEST_ID)) == null) {
                    return null;
                }
                return obj.toString();
            } catch (Throwable unused) {
                return null;
            }
        }

        public Integer a() {
            KsSplashScreenAd ksSplashScreenAd = this.c;
            return Integer.valueOf((ksSplashScreenAd == null || !ksSplashScreenAd.isAdEnable()) ? 4 : 2);
        }

        public void a(Rect rect) {
        }

        public void a(ViewGroup viewGroup) {
            b(viewGroup);
        }

        @JProtect
        void a(KsScene ksScene) {
            MediationApiLog.i("TMe", "KsSplashLoader loadAd");
            KsAdSDK.getLoadManager().loadSplashScreenAd(ksScene, this.f3387a);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            if (i == 6152) {
                MediationApiLog.i("TMe", "KsSplashLoader showSplashAd");
                ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(20060), ViewGroup.class, null);
                if (viewGroup != null) {
                    a(viewGroup);
                }
            } else if (i != 6154) {
                if (i == 6161) {
                    MediationApiLog.i("TMe", "KsSplashLoader showMinWindow");
                    Rect rect = (Rect) MediationValueUtil.objectValue(sparseArray.get(20067), Rect.class, null);
                    if (rect != null) {
                        a(rect);
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
                        return (T) c();
                    }
                    if (i == 8142) {
                        if (p.a(this.c)) {
                            Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                            MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                            if (map != null) {
                                long jA = p.a((Map<String, Object>) map);
                                long jB = p.b((Map<String, Object>) map);
                                MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                                KsSplashScreenAd ksSplashScreenAd = this.c;
                                if (ksSplashScreenAd != null) {
                                    ksSplashScreenAd.setBidEcpm(jA, jB);
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
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        public Integer b() {
            try {
                Integer num = (Integer) o.a(new Callable<Integer>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.n.a.3
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Integer call() {
                        return a.this.a();
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

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.c == null;
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            return n.this.b ? b() : a();
        }

        @Override // com.bytedance.msdk.adapter.ks.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            if (this.c != null) {
                this.c = null;
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    public n(KsSplashLoader ksSplashLoader) {
        this.f3385a = ksSplashLoader;
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        boolean zA = p.a(this.f3385a, mediationAdSlotValueSet);
        this.b = zA;
        if (zA) {
            o.a(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.n.1
                @Override // java.lang.Runnable
                public void run() {
                    n.this.a(mediationAdSlotValueSet);
                    o.a(getClass().getName(), StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            });
        } else {
            a(mediationAdSlotValueSet);
        }
    }

    public void a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        MediationApiLog.i("TMe", "KsSplashLoader realLoader adnId:" + this.f3385a.getAdnId());
        try {
            KsScene.Builder builder = new KsScene.Builder(Long.valueOf(this.f3385a.getAdnId()).longValue());
            f.a(builder, mediationAdSlotValueSet, "SPLASH");
            new a(mediationAdSlotValueSet, this.f3385a.getGMBridge()).a(builder.build());
        } catch (Exception unused) {
            this.f3385a.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "代码位不合法");
        }
    }
}
