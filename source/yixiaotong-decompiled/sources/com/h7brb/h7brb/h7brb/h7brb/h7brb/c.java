package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.kwad.sdk.api.KsNativeAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private KsNativeAd f3312a;

    public c(KsNativeAd ksNativeAd) {
        this.f3312a = ksNativeAd;
    }

    public void a() {
        KsNativeAd ksNativeAd = this.f3312a;
        if (ksNativeAd != null) {
            ksNativeAd.reportAdVideoPlayStart();
        }
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8165) {
            a();
            return null;
        }
        if (i != 8168) {
            return null;
        }
        b();
        return null;
    }

    public void b() {
        KsNativeAd ksNativeAd = this.f3312a;
        if (ksNativeAd != null) {
            ksNativeAd.reportAdVideoPlayEnd();
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
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
