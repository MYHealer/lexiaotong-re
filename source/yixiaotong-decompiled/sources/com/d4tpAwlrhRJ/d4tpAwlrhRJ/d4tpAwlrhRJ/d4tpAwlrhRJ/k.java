package com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.content.Context;
import android.util.SparseArray;
import android.widget.FrameLayout;
import com.bytedance.msdk.adapter.gdt.GdtNativeLoader;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<NativeExpressADView, e> f3242a = new HashMap();
    private MediationAdSlotValueSet b;
    private final GdtNativeLoader c;
    private boolean d;
    private WeakReference<Context> e;
    private final NativeExpressAD.NativeExpressADListener f = new NativeExpressAD.NativeExpressADListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.k.2
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            e eVar;
            if (k.f3242a == null || (eVar = (e) k.f3242a.get(nativeExpressADView)) == null) {
                return;
            }
            eVar.notifyOnClickAd();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            if (k.f3242a != null) {
                e eVar = (e) k.f3242a.get(nativeExpressADView);
                if (eVar != null) {
                    eVar.a();
                }
                k.f3242a.remove(nativeExpressADView);
            }
            if (nativeExpressADView != null) {
                nativeExpressADView.destroy();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            e eVar;
            if (k.f3242a == null || (eVar = (e) k.f3242a.get(nativeExpressADView)) == null) {
                return;
            }
            eVar.notifyOnShowAd();
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            if (list == null || list.size() == 0) {
                k.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "list is empty");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeExpressADView nativeExpressADView : list) {
                if (nativeExpressADView != null && nativeExpressADView.getBoundData() != null) {
                    Function<SparseArray<Object>, Object> gMBridge = k.this.c.getGMBridge();
                    Map map = k.f3242a;
                    k kVar = k.this;
                    map.put(nativeExpressADView, new e(kVar, kVar.c, gMBridge, nativeExpressADView, k.this.d));
                    arrayList.add(gMBridge);
                }
            }
            k.this.c.notifyAdSuccess(arrayList);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                k.this.c.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                k.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "adError is null");
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            e eVar;
            if (k.f3242a == null || (eVar = (e) k.f3242a.get(nativeExpressADView)) == null) {
                return;
            }
            eVar.notifyRenderFail(nativeExpressADView, MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, "渲染失败");
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            e eVar;
            if (k.f3242a == null || (eVar = (e) k.f3242a.get(nativeExpressADView)) == null) {
                return;
            }
            eVar.notifyRenderSuccess(-1.0f, -2.0f);
        }
    };
    private final NativeADUnifiedListener g = new NativeADUnifiedListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.k.3
        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            if (list == null || list.size() <= 0) {
                k.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求成功，但无广告可用");
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (NativeUnifiedADData nativeUnifiedADData : list) {
                if (nativeUnifiedADData != null) {
                    Function<SparseArray<Object>, Object> gMBridge = k.this.c.getGMBridge();
                    VideoOption videoOptionBuild = new VideoOption.Builder().build();
                    FrameLayout.LayoutParams layoutParams = null;
                    if (k.this.b != null) {
                        Object gdtNativeLogoParams = k.this.b.getGdtNativeLogoParams();
                        layoutParams = gdtNativeLogoParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) gdtNativeLogoParams : null;
                        if (k.this.b.getGdtVideoOption() instanceof VideoOption) {
                            videoOptionBuild = (VideoOption) k.this.b.getGdtVideoOption();
                        }
                    }
                    new d(k.this.c(), k.this.c, gMBridge, nativeUnifiedADData, layoutParams, videoOptionBuild, k.this.d);
                    arrayList.add(gMBridge);
                }
            }
            k.this.c.notifyAdSuccess(arrayList);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            if (adError != null) {
                k.this.c.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
            } else {
                k.this.c.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "请求失败");
            }
        }
    };

    public k(GdtNativeLoader gdtNativeLoader) {
        this.c = gdtNativeLoader;
    }

    private ADSize a(MediationAdSlotValueSet mediationAdSlotValueSet) {
        return mediationAdSlotValueSet.getExpressWidth() > 0.0f ? new ADSize((int) mediationAdSlotValueSet.getExpressWidth(), -2) : new ADSize(-1, -2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.b = mediationAdSlotValueSet;
        boolean zIsExpress = mediationAdSlotValueSet.isExpress();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (zIsExpress) {
            c(origApplicationContext, mediationAdSlotValueSet);
        } else {
            d(origApplicationContext, mediationAdSlotValueSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context c() {
        WeakReference<Context> weakReference = this.e;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private void c(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        NativeExpressAD nativeExpressAD = this.c.isServerBidding() ? new NativeExpressAD(context, a(mediationAdSlotValueSet), mediationAdSlotValueSet.getADNId(), this.f, this.c.getAdm()) : new NativeExpressAD(context, a(mediationAdSlotValueSet), mediationAdSlotValueSet.getADNId(), this.f);
        int gdtMaxVideoDuration = mediationAdSlotValueSet.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = mediationAdSlotValueSet.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeExpressAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeExpressAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        nativeExpressAD.setVideoOption(mediationAdSlotValueSet.getGdtVideoOption() instanceof VideoOption ? (VideoOption) mediationAdSlotValueSet.getGdtVideoOption() : new VideoOption.Builder().build());
        nativeExpressAD.loadAD(mediationAdSlotValueSet.getAdCount());
    }

    private void d(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        NativeUnifiedAD nativeUnifiedAD = this.c.isServerBidding() ? new NativeUnifiedAD(context, this.c.getAdnId(), this.g, this.c.getAdm()) : new NativeUnifiedAD(context, this.c.getAdnId(), this.g);
        int gdtMaxVideoDuration = mediationAdSlotValueSet.getGdtMaxVideoDuration();
        int gdtMinVideoDuration = mediationAdSlotValueSet.getGdtMinVideoDuration();
        if (gdtMinVideoDuration > 0) {
            nativeUnifiedAD.setMinVideoDuration(gdtMinVideoDuration);
        }
        if (gdtMaxVideoDuration > 0) {
            nativeUnifiedAD.setMaxVideoDuration(gdtMaxVideoDuration);
        }
        nativeUnifiedAD.loadData(mediationAdSlotValueSet.getAdCount());
    }

    public Map<NativeExpressADView, e> a() {
        return f3242a;
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet) {
        a.a((Map) mediationAdSlotValueSet.getExtraObject());
        this.e = new WeakReference<>(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        boolean zA = a.a(this.c, mediationAdSlotValueSet);
        this.d = zA;
        if (zA) {
            n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.k.1
                @Override // java.lang.Runnable
                public void run() {
                    k.this.b(context, mediationAdSlotValueSet);
                    n.a(getClass().getName(), context);
                }
            });
        } else {
            b(context, mediationAdSlotValueSet);
        }
    }
}
