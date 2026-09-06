package com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtSplashLoader;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class m extends MediationBaseAdBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    SplashADListener f3254a;
    private SplashAD b;
    private final GdtSplashLoader c;
    private int d;
    private final boolean e;
    private Map f;

    public m(MediationAdSlotValueSet mediationAdSlotValueSet, Function function, Context context, GdtSplashLoader gdtSplashLoader) {
        super(mediationAdSlotValueSet, function);
        this.d = 2;
        this.f = null;
        this.f3254a = new SplashADListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public long f3259a;

            @Override // com.qq.e.ads.splash.SplashADListener
            @JProtect
            public void onADClicked() {
                MediationApiLog.i("TMe", "GdtSplashLoader onADClicked");
                if (m.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1009);
                    sparseArray.put(-99999985, Void.class);
                    m.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADDismissed() {
                MediationApiLog.i("TMe", "GdtSplashLoader onADDismissed");
                if (m.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1011);
                    sparseArray.put(-99999985, Void.class);
                    m.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            @JProtect
            public void onADExposure() {
                MediationApiLog.i("TMe", "GdtSplashLoader onADExposure");
                if (m.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1008);
                    sparseArray.put(-99999985, Void.class);
                    m.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            @JProtect
            public void onADLoaded(long j) {
                StringBuilder sbAppend;
                MediationApiLog.i("TMe", "GdtSplashLoader onADLoaded");
                long jElapsedRealtime = j - SystemClock.elapsedRealtime();
                if (m.this.b == null || jElapsedRealtime <= 1000) {
                    m.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "暂无广告");
                    return;
                }
                if (!m.this.c.isClientBidding()) {
                    if (m.this.c.isMultiBidding()) {
                        m mVar = m.this;
                        mVar.setLevelTag(mVar.b.getECPMLevel());
                        sbAppend = new StringBuilder("GdtSplashLoader GDT_多阶底价 splash 返回的 价格标签：").append(m.this.b.getECPMLevel());
                    }
                    GdtSplashLoader gdtSplashLoader2 = m.this.c;
                    m mVar2 = m.this;
                    gdtSplashLoader2.notifyAdSuccess(mVar2, mVar2.mGMAd);
                }
                m mVar3 = m.this;
                mVar3.setCpm(mVar3.b.getECPM() != -1 ? m.this.b.getECPM() : 0.0d);
                sbAppend = new StringBuilder("GdtSplashLoader GDT_clientBidding splash 返回的 cpm价格：").append(m.this.b.getECPM());
                MediationApiLog.i("TMe", sbAppend.toString());
                GdtSplashLoader gdtSplashLoader3 = m.this.c;
                m mVar4 = m.this;
                gdtSplashLoader3.notifyAdSuccess(mVar4, mVar4.mGMAd);
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADPresent() {
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            public void onADTick(long j) {
                MediationApiLog.i("TMe", "GdtSplashLoader onADTick");
                this.f3259a = j;
            }

            @Override // com.qq.e.ads.splash.SplashADListener
            @JProtect
            public void onNoAD(AdError adError) {
                if (adError == null) {
                    MediationApiLog.i("TMe", "GdtSplashLoader onNoAD ");
                    m.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "暂无广告");
                    return;
                }
                MediationApiLog.i("TMe", "GdtSplashLoader onNoAD err_code:" + adError.getErrorCode() + "  msg:" + adError.getErrorMsg());
                if (adError.getErrorCode() != 4004 && adError.getErrorCode() != 4005) {
                    m.this.c.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
                    return;
                }
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1017);
                sparseArray.put(-99999985, Void.class);
                sparseArray.put(8014, Integer.valueOf(adError.getErrorCode()));
                sparseArray.put(8015, adError.getErrorMsg());
                m.this.mGMAd.apply(sparseArray);
            }
        };
        this.c = gdtSplashLoader;
        this.e = a.a(gdtSplashLoader, mediationAdSlotValueSet);
        this.d = mediationAdSlotValueSet.getOriginType();
        this.f = mediationAdSlotValueSet.getExtraObject();
        int i = this.d;
        if (i == 0 || i == 1 || i == 2) {
            return;
        }
        this.d = 2;
    }

    private void a(Object obj) {
        final int iA = a.a(obj);
        if (iA == -1) {
            return;
        }
        if (this.e) {
            n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.7
                @Override // java.lang.Runnable
                public void run() {
                    m.this.b.sendLossNotification(0, iA, null);
                }
            });
        } else {
            this.b.sendLossNotification(0, iA, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void b(Context context, int i, boolean z) {
        if (context instanceof Activity) {
            if (i < 0) {
                i = 3000;
            } else if (i > 5000) {
                i = 5000;
            }
            SplashAD splashAD = new SplashAD(context, this.c.getAdnId(), this.f3254a, i);
            this.b = splashAD;
            if (z) {
                splashAD.preLoad();
            }
            int i2 = this.d;
            if (i2 == 2) {
                this.b.fetchAdOnly();
            } else if (i2 == 0 || i2 == 1) {
                this.b.fetchFullScreenAdOnly();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ViewGroup viewGroup) {
        if (this.b == null || viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        Context context = viewGroup.getContext();
        if (context instanceof Activity) {
            ViewGroup viewGroup2 = (ViewGroup) ((Activity) context).findViewById(R.id.content);
            if (viewGroup.getParent() == null) {
                if (viewGroup2 != null) {
                    viewGroup.setAlpha(0.0f);
                    viewGroup2.addView(viewGroup);
                }
                d(viewGroup);
                if (viewGroup2 != null) {
                    viewGroup2.removeView(viewGroup);
                    viewGroup.setAlpha(1.0f);
                    return;
                }
                return;
            }
        }
        d(viewGroup);
    }

    private void c(final Context context, final int i, final boolean z) {
        n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.1
            @Override // java.lang.Runnable
            public void run() {
                m.this.b(context, i, z);
                n.a(getClass().getName(), context);
            }
        });
    }

    private void c(final ViewGroup viewGroup) {
        n.b(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.2
            @Override // java.lang.Runnable
            public void run() {
                m.this.b(viewGroup);
            }
        });
    }

    private void d(ViewGroup viewGroup) {
        int i = this.d;
        if (i == 2) {
            this.b.showAd(viewGroup);
        } else if (i == 0 || i == 1) {
            this.b.showFullScreenAd(viewGroup);
        }
    }

    private String g() {
        return this.e ? h() : i();
    }

    private String h() {
        try {
            return (String) n.a(new Callable<String>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.8
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return m.this.i();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String i() {
        Object obj;
        try {
            SplashAD splashAD = this.b;
            if (splashAD == null || (obj = splashAD.getExtraInfo().get("request_id")) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public Integer a() {
        SplashAD splashAD = this.b;
        return Integer.valueOf((splashAD == null || !splashAD.isValid() || this.c.hasNotifyFail()) ? 4 : 2);
    }

    public void a(Context context, int i, boolean z) {
        a.a(this.f, this.c.getSplashShakeButton());
        if (this.e) {
            c(context, i, z);
        } else {
            b(context, i, z);
        }
    }

    public void a(ViewGroup viewGroup) {
        c(viewGroup);
    }

    public void a(Map<String, Object> map) {
        SplashAD splashAD;
        if (this.c.isClientBidding() && (splashAD = this.b) != null) {
            try {
                if (this.e) {
                    n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.6
                        @Override // java.lang.Runnable
                        public void run() {
                            m.this.b.sendWinNotification((int) m.this.getCpm());
                        }
                    });
                } else {
                    splashAD.sendWinNotification((int) getCpm());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 6162) {
            MediationApiLog.i("TMe", "GdtSplashLoader splashMinWindowAnimationFinish");
            if (this.e) {
                n.b(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.9
                    @Override // java.lang.Runnable
                    public void run() {
                        m.this.c();
                    }
                });
            } else {
                c();
            }
        } else {
            if (i == 6163) {
                MediationApiLog.i("TMe", "GdtSplashLoader getSplashBitMap");
                return (T) f();
            }
            if (i == 8142) {
                MediationApiLog.i("TMe", "GdtSplashLoader bidWinNotify");
                Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map != null) {
                    a(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i("TMe", "GdtSplashLoader bidLoseNotify");
                Map<String, Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map2 != null) {
                    b(map2);
                }
            } else if (i == 6152) {
                MediationApiLog.i("TMe", "GdtSplashLoader showSplashAd");
                ViewGroup viewGroup = (ViewGroup) MediationValueUtil.objectValue(sparseArray.get(20060), ViewGroup.class, null);
                if (viewGroup != null) {
                    a(viewGroup);
                }
            } else if (i != 6154 && i != 6161) {
                if (i == 8109) {
                    onDestroy();
                } else {
                    if (i == 8120) {
                        return (T) Boolean.valueOf(hasDestroyed());
                    }
                    if (i == 8121) {
                        return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
                    }
                    if (i == 8147) {
                        return (T) g();
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public Integer b() {
        try {
            Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.3
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return m.this.a();
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

    public void b(Map<String, Object> map) {
        if (!this.c.isClientBidding() || this.b == null || map == null) {
            return;
        }
        try {
            a(map.get(MediationConstant.BIDDING_LOSE_REASON));
        } catch (Exception unused) {
        }
    }

    public void c() {
        SplashAD splashAD = this.b;
        if (splashAD != null) {
            splashAD.zoomOutAnimationFinish();
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public Bitmap d() {
        SplashAD splashAD = this.b;
        if (splashAD == null) {
            return null;
        }
        splashAD.getZoomOutBitmap();
        return null;
    }

    public Bitmap e() {
        try {
            Bitmap bitmap = (Bitmap) n.a(new Callable<Bitmap>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.m.4
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Bitmap call() {
                    return m.this.d();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (bitmap != null) {
                return bitmap;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Bitmap f() {
        return this.e ? e() : d();
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public boolean hasDestroyed() {
        return this.b == null;
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public Integer isReadyStatus() {
        return this.e ? b() : a();
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public void onDestroy() {
        this.b = null;
        this.f3254a = null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
