package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

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
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.ADSize;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeExpressAD f1008a;
    private NativeUnifiedAD b;
    private ADSize c;
    private Function<SparseArray<Object>, Object> d;
    private Map<NativeExpressADView, n> e;
    private final NativeExpressAD.NativeExpressADListener f = new NativeExpressAD.NativeExpressADListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.o.1
        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClicked(NativeExpressADView nativeExpressADView) {
            t.a("onADClicked nativeExpressADView = " + nativeExpressADView);
            o.this.c(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADClosed(NativeExpressADView nativeExpressADView) {
            t.a("onADClosed nativeExpressADView = " + nativeExpressADView);
            o.this.b(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADExposure(NativeExpressADView nativeExpressADView) {
            t.a("onADExposure nativeExpressADView = " + nativeExpressADView);
            o.this.d(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLeftApplication(NativeExpressADView nativeExpressADView) {
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onADLoaded(List<NativeExpressADView> list) {
            t.a("onADLoaded express list = " + list + " list.size = " + (list != null ? list.size() : 0));
            o.this.a(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            t.a("onNoAD adError = " + adError);
            o.this.a(adError);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderFail(NativeExpressADView nativeExpressADView) {
            t.a("onRenderFail nativeExpressADView = " + nativeExpressADView);
            o.this.f(nativeExpressADView);
        }

        @Override // com.qq.e.ads.nativ.NativeExpressAD.NativeExpressADListener
        public void onRenderSuccess(NativeExpressADView nativeExpressADView) {
            t.a("onRenderSuccess nativeExpressADView = " + nativeExpressADView);
            o.this.e(nativeExpressADView);
        }
    };
    private final NativeADUnifiedListener g = new NativeADUnifiedListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.o.2
        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            t.a("onADLoaded native list = " + list + " list.size = " + (list != null ? list.size() : 0));
            o.this.b(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            t.a("onNoAD adError = " + adError);
            o.this.a(adError);
        }
    };

    private void a(int i) {
        t.a("createAdSize expressWidth = " + i);
        this.c = new ADSize(-1, -2);
        if (i > 0) {
            this.c = new ADSize(i, -2);
        }
    }

    private void a(Context context, String str, String str2) {
        t.a("createNativeExpressAD context = " + context + " adnId = " + str + " adm = " + str2);
        if (TextUtils.isEmpty(str2)) {
            this.f1008a = new NativeExpressAD(context, this.c, str, this.f);
        } else {
            this.f1008a = new NativeExpressAD(context, this.c, str, this.f, str2);
        }
        if (Thread.currentThread().getName().equals("gm_t_main")) {
            return;
        }
        com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.a(getClass().getName(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError) {
        if (this.d != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(50006, new h(adError));
            sparseArray.put(-99999987, Integer.valueOf(PtgErrorCode.SDK_CLICK_ERR));
            sparseArray.put(-99999985, null);
            this.d.apply(sparseArray);
        }
    }

    private void a(Object obj, int i) {
        t.a("loadAd ad bridge = " + obj);
        if (this.f1008a != null) {
            this.d = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.f1008a.loadAD(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<NativeExpressADView> list) {
        if (this.d == null || list == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        ArrayList arrayList = new ArrayList(list.size());
        if (this.e == null) {
            this.e = new ConcurrentHashMap();
        }
        for (NativeExpressADView nativeExpressADView : list) {
            n nVar = new n(this, nativeExpressADView);
            arrayList.add(nVar);
            this.e.put(nativeExpressADView, nVar);
        }
        sparseArray.put(50015, arrayList);
        sparseArray.put(-99999987, 60000);
        sparseArray.put(-99999985, null);
        this.d.apply(sparseArray);
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
        NativeExpressAD nativeExpressAD = this.f1008a;
        if (nativeExpressAD != null) {
            nativeExpressAD.setVideoOption(videoOptionBuild);
        }
    }

    private void b(Context context, String str, String str2) {
        t.a("createNativeUnifiedAD context = " + context + " adnId = " + str + " adm = " + str2);
        if (TextUtils.isEmpty(str2)) {
            this.b = new NativeUnifiedAD(context, str, this.g);
        } else {
            this.b = new NativeUnifiedAD(context, str, this.g, str2);
        }
        if (Thread.currentThread().getName().equals("gm_t_main")) {
            return;
        }
        com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.a(getClass().getName(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(NativeExpressADView nativeExpressADView) {
        Map<NativeExpressADView, n> map = this.e;
        if (map != null) {
            n nVar = map.get(nativeExpressADView);
            if (nVar != null) {
                nVar.e();
            }
            this.e.remove(nativeExpressADView);
        }
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    private void b(Object obj, int i) {
        t.a("loadData ad bridge = " + obj);
        if (this.b != null) {
            this.d = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.b.loadData(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<NativeUnifiedADData> list) {
        if (this.d == null || list == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<NativeUnifiedADData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new m(it.next()));
        }
        sparseArray.put(50015, arrayList);
        sparseArray.put(-99999987, 60000);
        sparseArray.put(-99999985, null);
        this.d.apply(sparseArray);
    }

    private void b(Map<String, Object> map) {
        int iIntValue;
        t.a("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) <= 0) {
                return;
            }
            NativeExpressAD nativeExpressAD = this.f1008a;
            if (nativeExpressAD != null) {
                nativeExpressAD.setMaxVideoDuration(iIntValue);
            }
            NativeUnifiedAD nativeUnifiedAD = this.b;
            if (nativeUnifiedAD != null) {
                nativeUnifiedAD.setMaxVideoDuration(iIntValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NativeExpressADView nativeExpressADView) {
        n nVar;
        Map<NativeExpressADView, n> map = this.e;
        if (map == null || (nVar = map.get(nativeExpressADView)) == null) {
            return;
        }
        nVar.d();
    }

    private void c(Map<String, Object> map) {
        int iIntValue;
        t.a("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) <= 0) {
                return;
            }
            NativeExpressAD nativeExpressAD = this.f1008a;
            if (nativeExpressAD != null) {
                nativeExpressAD.setMinVideoDuration(iIntValue);
            }
            NativeUnifiedAD nativeUnifiedAD = this.b;
            if (nativeUnifiedAD != null) {
                nativeUnifiedAD.setMinVideoDuration(iIntValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(NativeExpressADView nativeExpressADView) {
        n nVar;
        Map<NativeExpressADView, n> map = this.e;
        if (map == null || (nVar = map.get(nativeExpressADView)) == null) {
            return;
        }
        nVar.c();
    }

    private void d(Map<String, String> map) {
        t.a("setExtraUserData map = " + map);
        if (map != null) {
            GlobalSetting.setExtraUserData(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(NativeExpressADView nativeExpressADView) {
        n nVar;
        Map<NativeExpressADView, n> map = this.e;
        if (map == null || (nVar = map.get(nativeExpressADView)) == null) {
            return;
        }
        nVar.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(NativeExpressADView nativeExpressADView) {
        n nVar;
        Map<NativeExpressADView, n> map = this.e;
        if (map == null || (nVar = map.get(nativeExpressADView)) == null) {
            return;
        }
        nVar.a();
    }

    public void a(NativeExpressADView nativeExpressADView) {
        Map<NativeExpressADView, n> map = this.e;
        if (map != null) {
            map.remove(nativeExpressADView);
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40031) {
            a(((Integer) MediationValueUtil.objectValue(sparseArray.get(50014), Integer.class, 0)).intValue());
        } else if (i == 40030) {
            a((Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50000), String.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50002), String.class, null));
        } else if (i == 40018) {
            a((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40019) {
            b((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40020) {
            c((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40002) {
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
