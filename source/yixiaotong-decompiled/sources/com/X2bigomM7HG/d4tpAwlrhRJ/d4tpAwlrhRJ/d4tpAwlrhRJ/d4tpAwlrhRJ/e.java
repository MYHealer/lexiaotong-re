package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.managers.setting.GlobalSetting;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class e extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeUnifiedAD f989a;
    private Function<SparseArray<Object>, Object> b;
    private final NativeADUnifiedListener c = new NativeADUnifiedListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.e.1
        @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
        public void onADLoaded(List<NativeUnifiedADData> list) {
            t.a("onADLoaded native list = " + list + " list.size = " + (list != null ? list.size() : 0));
            e.this.a(list);
        }

        @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
        public void onNoAD(AdError adError) {
            t.a("onNoAD adError = " + adError);
            e.this.a(adError);
        }
    };

    private void a(Context context, String str) {
        t.a("createNativeUnifiedAD context = " + context + " adnId = " + str);
        this.f989a = new NativeUnifiedAD(context, str, this.c);
        if (Thread.currentThread().getName().equals("gm_t_main")) {
            return;
        }
        com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.a(getClass().getName(), context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError) {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(PtgErrorCode.SDK_CLICK_ERR));
            sparseArray.put(-99999985, null);
            sparseArray.put(50006, new h(adError));
            this.b.apply(sparseArray);
        }
    }

    private void a(Object obj, int i) {
        t.a("loadData ad bridge = " + obj);
        if (this.f989a != null) {
            this.b = AdnAdapterBridgeWrapper.covertToFunction(obj);
            this.f989a.loadData(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<NativeUnifiedADData> list) {
        if (this.b == null || list == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 60000);
        sparseArray.put(-99999985, null);
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<NativeUnifiedADData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new f(it.next()));
        }
        sparseArray.put(50015, arrayList);
        this.b.apply(sparseArray);
    }

    private void a(Map<String, Object> map) {
        int iIntValue;
        NativeUnifiedAD nativeUnifiedAD;
        t.a("setMaxVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) <= 0 || (nativeUnifiedAD = this.f989a) == null) {
                return;
            }
            nativeUnifiedAD.setMaxVideoDuration(iIntValue);
        }
    }

    private void b(Map<String, Object> map) {
        int iIntValue;
        NativeUnifiedAD nativeUnifiedAD;
        t.a("setMinVideoDuration map = " + map);
        if (map != null) {
            Object obj = map.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
            if (!(obj instanceof Integer) || (iIntValue = ((Integer) obj).intValue()) <= 0 || (nativeUnifiedAD = this.f989a) == null) {
                return;
            }
            nativeUnifiedAD.setMinVideoDuration(iIntValue);
        }
    }

    private void c(Map<String, String> map) {
        t.a("setExtraUserData map = " + map);
        if (map != null) {
            GlobalSetting.setExtraUserData(map);
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40036) {
            a((Context) MediationValueUtil.objectValue(sparseArray.get(10000), Context.class, null), (String) MediationValueUtil.objectValue(sparseArray.get(50000), String.class, null));
        } else if (i == 40019) {
            a((Map<String, Object>) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40020) {
            b((Map) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
        } else if (i == 40037) {
            a(MediationValueUtil.objectValue(sparseArray.get(10004), Object.class, null), ((Integer) MediationValueUtil.objectValue(sparseArray.get(10013), Integer.class, 0)).intValue());
        } else if (i == 40025) {
            c((Map) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null));
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
