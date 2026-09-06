package com.jd.ad.sdk.jad_fq;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_kx {
    public static final String[] jad_an = {"huawei"};
    public static final String[] jad_bo = {MediationConstant.ADN_XIAOMI};
    public static final String[] jad_cp = {"oppo"};
    public static final String[] jad_dq = {"oneplus"};
    public static final String[] jad_er = {"meizu"};

    public static boolean jad_an() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Exception unused) {
            return false;
        }
    }
}
