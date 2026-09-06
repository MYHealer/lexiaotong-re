package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.ks.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private KsDrawAd f3308a;
    private View b;
    private MediationAdSlotValueSet c;
    private boolean d;
    private WeakReference<Context> e;

    public b(Context context, MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction, Function function, KsDrawAd ksDrawAd, MediationAdSlotValueSet mediationAdSlotValueSet, boolean z) {
        super(mediationAdLoaderBaseFunction, function);
        this.e = new WeakReference<>(context);
        this.f3308a = ksDrawAd;
        this.c = mediationAdSlotValueSet;
        this.d = z;
        a();
    }

    private void a() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(8055, Boolean.valueOf(this.f3308a.getInteractionType() == 1));
        sparseArray.put(8059, Integer.valueOf(p.a(this.f3308a.getInteractionType())));
        if (isClientBidding()) {
            sparseArray.put(8016, Double.valueOf(Math.max(this.f3308a.getECPM(), 0.0d)));
        }
        sparseArray.put(8033, true);
        notifyNativeValue(sparseArray);
        this.f3308a.setAdInteractionListener(new KsDrawAd.AdInteractionListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.b.1
            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdClicked() {
                b.this.notifyOnClickAd();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onAdShow() {
                b.this.notifyOnShowAd();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayEnd() {
                b.this.notifyOnVideoComplete();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayError() {
                b.this.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "no msg");
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayPause() {
                b.this.notifyOnVideoPause();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayResume() {
                b.this.notifyOnVideoResume();
            }

            @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
            public void onVideoPlayStart() {
                b.this.notifyOnVideoStart();
            }
        });
    }

    private String b() {
        return this.d ? c() : d();
    }

    private String c() {
        try {
            return (String) o.a(new Callable<String>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.b.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return b.this.d();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d() {
        Object obj;
        try {
            KsDrawAd ksDrawAd = this.f3308a;
            if (ksDrawAd == null || (obj = ksDrawAd.getMediaExtraInfo().get(KSUtil.REQUEST_ID)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        MediationAdSlotValueSet mediationAdSlotValueSet;
        KsDrawAd ksDrawAd;
        Context context;
        if (i != 6083) {
            if (i == 6081) {
                if (p.a("3.3.69") && (mediationAdSlotValueSet = this.c) != null && (ksDrawAd = this.f3308a) != null) {
                    ksDrawAd.setVideoSoundEnable(!mediationAdSlotValueSet.isMuted());
                }
                return (T) this.b;
            }
            if (i == 8120) {
                return (T) Boolean.valueOf(this.f3308a == null);
            }
            if (i == 8109) {
                this.f3308a = null;
            } else {
                if (i == 8147) {
                    return (T) b();
                }
                if (i == 8142) {
                    if (p.a(this.f3308a)) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                        if (map != null) {
                            long jA = p.a((Map<String, Object>) map);
                            long jB = p.b((Map<String, Object>) map);
                            MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                            KsDrawAd ksDrawAd2 = this.f3308a;
                            if (ksDrawAd2 != null) {
                                ksDrawAd2.setBidEcpm(jA, jB);
                            }
                        }
                    }
                } else if (i == 8144 && p.b(this.f3308a)) {
                    Map map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                    if (map2 != null) {
                        int iC = p.c(map2);
                        int iD = p.d(map2);
                        int iE = p.e(map2);
                        String strF = p.f(map2);
                        MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + iD + " failureCode = " + iC);
                        if (this.f3308a != null) {
                            AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                            adExposureFailedReason.setWinEcpm(iD);
                            adExposureFailedReason.setAdnType(iE);
                            adExposureFailedReason.setAdnName(strF);
                            this.f3308a.reportAdExposureFailed(iC, adExposureFailedReason);
                        }
                    }
                }
            }
        } else if (this.d) {
            o.b(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.b.3
                @Override // java.lang.Runnable
                public void run() {
                    Context context2;
                    if (b.this.f3308a == null || (context2 = (Context) b.this.e.get()) == null) {
                        return;
                    }
                    b bVar = b.this;
                    bVar.b = bVar.f3308a.getDrawView(context2);
                    b bVar2 = b.this;
                    bVar2.notifyRenderSuccess(bVar2.c.getWidth(), b.this.c.getHeight());
                }
            });
        } else if (this.f3308a != null && (context = this.e.get()) != null) {
            this.b = this.f3308a.getDrawView(context);
            notifyRenderSuccess(this.c.getWidth(), this.c.getHeight());
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.msdk.adapter.ks.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }
}
