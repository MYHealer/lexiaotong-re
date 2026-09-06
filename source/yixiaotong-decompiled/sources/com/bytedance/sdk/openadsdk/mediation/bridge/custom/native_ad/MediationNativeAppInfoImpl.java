package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.util.SparseArray;
import com.byazt.zqa.c;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 83, 265, 266, 1469, 1594})
public class MediationNativeAppInfoImpl extends com.byazt.op.c {
    private MediationNativeAdAppInfo c;
    private SparseArray<Object> tt = new SparseArray<>();

    public MediationNativeAppInfoImpl(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.c = mediationNativeAdAppInfo;
    }

    public SparseArray<Object> values() {
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.c;
        if (mediationNativeAdAppInfo != null) {
            this.tt.put(8505, mediationNativeAdAppInfo.getAppName());
            this.tt.put(8506, this.c.getAuthorName());
            this.tt.put(8507, Long.valueOf(this.c.getPackageSizeBytes()));
            this.tt.put(8508, this.c.getPermissionsUrl());
            this.tt.put(8509, this.c.getPermissionsMap());
            this.tt.put(8510, this.c.getPrivacyAgreement());
            this.tt.put(8511, this.c.getVersionName());
            this.tt.put(8512, this.c.getAppInfoExtra());
            this.tt.put(8551, this.c.getFunctionDescUrl());
            this.tt.put(8559, this.c.getRegUrl());
        }
        return this.tt;
    }

    @Override // com.byazt.op.c
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) values();
        }
        return null;
    }

    @Override // com.byazt.op.c
    public SparseArray<Object> get() {
        SparseArray<Object> sparseArrayValues = values();
        if (sparseArrayValues != null) {
            return sparseArrayValues;
        }
        return null;
    }
}
