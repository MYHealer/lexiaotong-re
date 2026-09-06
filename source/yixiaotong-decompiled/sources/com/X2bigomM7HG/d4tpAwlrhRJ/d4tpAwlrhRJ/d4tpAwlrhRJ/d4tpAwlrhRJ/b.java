package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class b extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnifiedBannerView f980a;
    private ADSize b;
    private NativeExpressAD c;
    private a d;
    private Function<SparseArray<Object>, Object> e;
    private d f;
    private NativeUnifiedAD g;
    private final NativeExpressAD.NativeExpressADListener h = new NativeExpressAD.NativeExpressADListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.2
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            t.a("onADClicked nativeExpressADView = " + nativeExpressADView);
            if (b.this.f != null) {
                b.this.f.c();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            t.a("onADClosed nativeExpressADView = " + nativeExpressADView);
            if (b.this.f != null) {
                b.this.f.d();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            t.a("onADExposure nativeExpressADView = " + nativeExpressADView);
            if (b.this.f != null) {
                b.this.f.b();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
            t.a("onADClosed onADLeftApplication = " + nativeExpressADView);
            if (b.this.f != null) {
                b.this.f.a();
            }
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            t.a("onADLoaded express list = " + list + " list.size = " + (list != null ? list.size() : 0));
            b.this.a(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            t.a("onNoAD adError = " + adError);
            b.this.a(adError);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            t.a("onRenderFail nativeExpressADView = " + nativeExpressADView);
            b.this.a(new AdError(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "render fail"));
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            t.a("onRenderSuccess nativeExpressADView = " + nativeExpressADView);
            b.this.c();
        }
    };
    private final NativeADUnifiedListener i = new NativeADUnifiedListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.3
        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            t.a("onADLoaded native list = " + list + " list.size = " + (list != null ? list.size() : 0));
            b.this.b(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            t.a("onNoAD adError = " + adError);
            b.this.a(adError);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e != null) {
            b();
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60008);
            sparseArray.put(-99999985, null);
            sparseArray.put(50005, this.d);
            this.e.apply(sparseArray);
        }
    }

    private void a(int i) {
        t.a("createAdSize expressWidth = " + i);
        this.b = new ADSize(-1, -2);
        if (i > 0) {
            this.b = new ADSize(i, -2);
        }
    }

    private void a(Context context, String str) {
        t.a("createUnifiedBannerView context = " + context + " adnId = " + str);
        if (context instanceof Activity) {
            this.f980a = new UnifiedBannerView((Activity) context, str, new UnifiedBannerADListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.b.1
                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADClicked() {
                    t.a("onADClicked ");
                    if (b.this.d != null) {
                        b.this.d.b();
                    }
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADClosed() {
                    t.a("onADClosed ");
                    if (b.this.d != null) {
                        b.this.d.c();
                    }
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADExposure() {
                    t.a("onADExposure ");
                    if (b.this.d != null) {
                        b.this.d.a();
                    }
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADLeftApplication() {
                    t.a("onADLeftApplication ");
                    if (b.this.d != null) {
                        b.this.d.d();
                    }
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onADReceive() {
                    t.a("onADReceive");
                    b.this.a();
                }

                @Override // com.qq.e.ads.banner2.UnifiedBannerADListener
                public void onNoAD(AdError adError) {
                    t.a("onNoAD adError = " + adError);
                    b.this.a(adError);
                }
            });
            if (Thread.currentThread().getName().equals("gm_t_main")) {
                return;
            }
            com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.a(getClass().getName(), context);
        }
    }

    private void a(Context context, String str, String str2) {
        t.a("createNativeExpressAD context = " + context + " adnId = " + str + " adm = " + str2);
        if (TextUtils.isEmpty(str2)) {
            this.c = new NativeExpressAD(context, this.b, str, this.h);
        } else {
            this.c = new NativeExpressAD(context, this.b, str, this.h, str2);
        }
        if (Thread.currentThread().getName().equals("gm_t_main")) {
            return;
        }
        com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.a(getClass().getName(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError) {
        if (this.e != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(PtgErrorCode.SDK_CLICK_ERR));
            sparseArray.put(-99999985, null);
            sparseArray.put(50006, new h(adError));
            this.e.apply(sparseArray);
        }
    }

    private void a(Object obj) {
        t.a("loadAd = " + obj);
        if (this.f980a != null) {
            this.e = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.f980a.loadAD();
        }
    }

    private void a(Object obj, int i) {
        t.a("loadNativeExpressAd ad bridge = " + obj);
        if (this.c != null) {
            this.e = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.c.loadAD(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<NativeExpressADView> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f = new d(list.get(0));
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 60000);
        sparseArray.put(-99999985, null);
        sparseArray.put(50005, this.f);
        this.e.apply(sparseArray);
    }

    private void a(Map<String, Object> map) {
        t.a("setVideoOption map = " + map);
        VideoOption videoOptionBuild = new VideoOption.Builder().build();
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
            if (obj instanceof VideoOption) {
                videoOptionBuild = (VideoOption) obj;
            }
        }
        NativeExpressAD nativeExpressAD = this.c;
        if (nativeExpressAD != null) {
            nativeExpressAD.setVideoOption(videoOptionBuild);
        }
    }

    private void b() {
        if (this.f980a != null) {
            this.d = new a(this.f980a);
        }
    }

    private void b(Context context, String str, String str2) {
        t.a("createNativeUnifiedAD context = " + context + " adnId = " + str + " adm = " + str2);
        if (TextUtils.isEmpty(str2)) {
            this.g = new NativeUnifiedAD(context, str, this.i);
        } else {
            this.g = new NativeUnifiedAD(context, str, this.i, str2);
        }
        if (Thread.currentThread().getName().equals("gm_t_main")) {
            return;
        }
        com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.a(getClass().getName(), context);
    }

    private void b(Object obj, int i) {
        t.a("loadNativeData ad bridge = " + obj);
        if (this.g != null) {
            this.e = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.g.loadData(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<NativeUnifiedADData> list) {
        if (this.e == null || list == null || list.size() <= 0) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 60000);
        sparseArray.put(-99999985, null);
        sparseArray.put(50005, new c(list.get(0)));
        this.e.apply(sparseArray);
    }

    private void b(Map<String, Object> map) {
        int iIntValue;
        t.a("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) <= 0) {
                return;
            }
            NativeExpressAD nativeExpressAD = this.c;
            if (nativeExpressAD != null) {
                nativeExpressAD.setMaxVideoDuration(iIntValue);
            }
            NativeUnifiedAD nativeUnifiedAD = this.g;
            if (nativeUnifiedAD != null) {
                nativeUnifiedAD.setMaxVideoDuration(iIntValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.e != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60017);
            sparseArray.put(-99999985, null);
            this.e.apply(sparseArray);
        }
    }

    private void c(Map<String, Object> map) {
        int iIntValue;
        t.a("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) <= 0) {
                return;
            }
            NativeExpressAD nativeExpressAD = this.c;
            if (nativeExpressAD != null) {
                nativeExpressAD.setMinVideoDuration(iIntValue);
            }
            NativeUnifiedAD nativeUnifiedAD = this.g;
            if (nativeUnifiedAD != null) {
                nativeUnifiedAD.setMinVideoDuration(iIntValue);
            }
        }
    }

    private void d(Map<String, String> map) {
        t.a("setExtraUserData map = " + map);
        if (map != null) {
            GlobalSetting.setExtraUserData(map);
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40066) {
            a((Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50000), String.class, null));
        } else if (i == 40002) {
            a(MediationValueUtil.objectValue(sparseArray.get(10004), Object.class, null));
        } else if (i == 40067) {
            int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50022), Integer.class, 0)).intValue();
            t.a("setRefresh = " + iIntValue);
            UnifiedBannerView unifiedBannerView = this.f980a;
            if (unifiedBannerView != null) {
                unifiedBannerView.setRefresh(iIntValue);
            }
        } else if (i == 40031) {
            a(((Integer) MediationValueUtil.objectValue(sparseArray.get(50014), Integer.class, 0)).intValue());
        } else if (i == 40030) {
            a((Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50000), String.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50002), String.class, null));
        } else if (i == 40018) {
            a((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40019) {
            b((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40020) {
            c((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40068) {
            a(MediationValueUtil.objectValue(sparseArray.get(10004), Object.class, null), ((Integer) MediationValueUtil.objectValue(sparseArray.get(10013), Integer.class, 0)).intValue());
        } else if (i == 40036) {
            b((Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50000), String.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50002), String.class, null));
        } else if (i == 40037) {
            b(MediationValueUtil.objectValue(sparseArray.get(10004), Object.class, null), ((Integer) MediationValueUtil.objectValue(sparseArray.get(10013), Integer.class, 0)).intValue());
        } else if (i == 40025) {
            d((Map<String, String>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
