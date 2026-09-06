package com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.GdtDrawLoader;
import com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class b extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeExpressADView f3138a;
    private volatile boolean b;
    private g c;
    private boolean d;
    private NativeExpressMediaListener e;

    public b(g gVar, GdtDrawLoader gdtDrawLoader, Function<SparseArray<Object>, Object> function, NativeExpressADView nativeExpressADView, boolean z) {
        super(gdtDrawLoader, function);
        this.b = false;
        this.e = new NativeExpressMediaListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.1
            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoCached(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                b.this.notifyOnVideoComplete();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                b bVar = b.this;
                if (adError != null) {
                    bVar.notifyOnVideoError(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    bVar.notifyOnVideoError(MediationConstant.ErrorCode.ADN_AD_VIDEO_ERROR, "aderror is null");
                }
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoInit(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                b.this.notifyOnVideoPause();
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoReady(NativeExpressADView nativeExpressADView2, long j) {
            }

            @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
            public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                b.this.notifyOnVideoStart();
            }
        };
        this.f3138a = nativeExpressADView;
        this.c = gVar;
        this.d = z;
        b();
    }

    private void a(Object obj) {
        final int iA = a.a(obj);
        if (iA == -1) {
            return;
        }
        if (this.d) {
            n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.6
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f3138a.sendLossNotification(0, iA, null);
                }
            });
        } else {
            this.f3138a.sendLossNotification(0, iA, null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x006c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0081  */
    /* JADX WARN: Code duplicated, block: B:21:0x0087  */
    private void b() {
        int i;
        int i2;
        Object eCPMLevel;
        SparseArray<Object> sparseArray = new SparseArray<>();
        AdData boundData = this.f3138a.getBoundData();
        if (boundData.getAdPatternType() != 2) {
            if (boundData.getAdPatternType() == 4 || boundData.getAdPatternType() == 1 || boundData.getAdPatternType() != 3) {
                sparseArray.put(8060, 3);
            } else {
                i = 4;
            }
            sparseArray.put(8033, true);
            sparseArray.put(8045, boundData.getTitle());
            sparseArray.put(8046, boundData.getDesc());
            sparseArray.put(8059, 3);
            if (isClientBidding()) {
                if (isMultiBidding()) {
                    i2 = 8058;
                    eCPMLevel = boundData.getECPMLevel();
                }
                sparseArray.put(8033, true);
                notifyNativeValue(sparseArray);
            }
            eCPMLevel = Double.valueOf(Math.max(boundData.getECPM(), 0.0d));
            i2 = 8016;
            sparseArray.put(i2, eCPMLevel);
            sparseArray.put(8033, true);
            notifyNativeValue(sparseArray);
        }
        this.f3138a.setMediaListener(this.e);
        i = 5;
        sparseArray.put(8060, i);
        sparseArray.put(8033, true);
        sparseArray.put(8045, boundData.getTitle());
        sparseArray.put(8046, boundData.getDesc());
        sparseArray.put(8059, 3);
        if (isClientBidding()) {
            if (isMultiBidding()) {
                i2 = 8058;
                eCPMLevel = boundData.getECPMLevel();
            }
            sparseArray.put(8033, true);
            notifyNativeValue(sparseArray);
        }
        eCPMLevel = Double.valueOf(Math.max(boundData.getECPM(), 0.0d));
        i2 = 8016;
        sparseArray.put(i2, eCPMLevel);
        sparseArray.put(8033, true);
        notifyNativeValue(sparseArray);
    }

    private String c() {
        return this.d ? d() : e();
    }

    private String d() {
        try {
            return (String) n.a(new Callable<String>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return b.this.e();
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
            NativeExpressADView nativeExpressADView = this.f3138a;
            if (nativeExpressADView == null || (obj = nativeExpressADView.getExtraInfo().get("request_id")) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        notifyDislikeClick("gdt信息流模板dislike接口无关闭原因", new HashMap());
        notifyDislikeSelect(-1, "gdt信息流模板dislike接口无关闭原因");
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 6083) {
            if (this.d) {
                n.b(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f3138a != null) {
                            b.this.f3138a.render();
                        }
                    }
                });
            } else {
                NativeExpressADView nativeExpressADView = this.f3138a;
                if (nativeExpressADView != null) {
                    nativeExpressADView.render();
                }
            }
        } else {
            if (i == 6081) {
                if (isServerBidding()) {
                    NativeExpressADView nativeExpressADView2 = this.f3138a;
                    nativeExpressADView2.setBidECPM(nativeExpressADView2.getECPM());
                }
                return (T) this.f3138a;
            }
            if (i == 8135) {
                return (T) true;
            }
            if (i == 8109) {
                this.b = true;
                if (this.c.a() != null) {
                    this.c.a().remove(this.f3138a);
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (b.this.f3138a != null) {
                            b.this.f3138a.destroy();
                        }
                    }
                });
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(this.b);
                }
                try {
                    if (i == 8142) {
                        NativeExpressADView nativeExpressADView3 = this.f3138a;
                        if (nativeExpressADView3 != null) {
                            if (this.d) {
                                n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.5
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        b.this.f3138a.sendWinNotification((int) b.this.getCpm());
                                    }
                                });
                            } else {
                                nativeExpressADView3.sendWinNotification((int) getCpm());
                            }
                        }
                    } else if (i == 8144) {
                        Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        if (map != null && this.f3138a != null) {
                            a(map.get(MediationConstant.BIDDING_LOSE_REASON));
                        }
                    } else if (i == 8147) {
                        return (T) c();
                    }
                } catch (Exception unused) {
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
