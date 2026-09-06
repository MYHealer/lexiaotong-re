package com.bytedance.msdk.adapter.baidu.base;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.baidu.base.config.AdapterResultBuilder;
import com.bytedance.msdk.adapter.baidu.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationValueUtil;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class MediationInitBaseFunction extends AdnAdapterBaseFunction implements Bridge {
    public MediationInitConfig mInitConfig;

    private void a() {
        Function<SparseArray<Object>, Object> initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8266);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(AVMDLDataLoader.KeyIsLiveContainerString, this);
            initCallback.apply(sparseArray);
        }
    }

    private void a(Context context, SparseArray<Object> sparseArray) {
        this.mInitConfig = MediationInitConfig.create(sparseArray);
        a();
        realInitAdn(context, this.mInitConfig);
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8240) {
            a((Context) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold), Context.class, null), AdnAdapterValueSetBuilder.converToSparseArray(MediationValueUtil.objectValue(sparseArray.get(8424), Object.class, null)));
        }
        return (T) callFunction(i, sparseArray, cls);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public <T> T callFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    public void notifyFail(int i, String str) {
        Function<SparseArray<Object>, Object> initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            AdapterResultBuilder adapterResultBuilderCreate = AdapterResultBuilder.create();
            adapterResultBuilderCreate.setSuccess(false);
            adapterResultBuilderCreate.setCode(i);
            adapterResultBuilderCreate.setMessage(str);
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(-999903, false);
            sparseArray.put(-999900, Integer.valueOf(i));
            sparseArray.put(-999901, str);
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(-99999987, 8123);
            sparseArray2.put(-99999985, Void.class);
            sparseArray2.put(8022, adapterResultBuilderCreate.build());
            sparseArray2.put(-999902, sparseArray);
            sparseArray2.put(-99999979, sparseArray);
            initCallback.apply(sparseArray2);
        }
    }

    public void notifyFail(String str) {
        notifyFail(80000, str);
    }

    public void notifyInitTime(int i, long j, long j2) {
        Function<SparseArray<Object>, Object> initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8270);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8557, Integer.valueOf(i));
            sparseArray.put(8555, Long.valueOf(j));
            sparseArray.put(8556, Long.valueOf(j2));
            initCallback.apply(sparseArray);
        }
    }

    public void notifySuccess() {
        Function<SparseArray<Object>, Object> initCallback = this.mInitConfig.getInitCallback();
        if (initCallback != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8122);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(AVMDLDataLoader.KeyIsLiveContainerString, this);
            initCallback.apply(sparseArray);
        }
    }

    public abstract void realInitAdn(Context context, MediationInitConfig mediationInitConfig);

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
