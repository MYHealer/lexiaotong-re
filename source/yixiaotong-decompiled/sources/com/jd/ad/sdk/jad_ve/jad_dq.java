package com.jd.ad.sdk.jad_ve;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq {
    public static com.jd.ad.sdk.jad_ra.jad_an jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        return new com.jd.ad.sdk.jad_ra.jad_an(jad_an(jad_cpVar, jad_jtVar, jad_jt.jad_an));
    }

    public static com.jd.ad.sdk.jad_ra.jad_bo jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar, boolean z) {
        return new com.jd.ad.sdk.jad_ra.jad_bo(jad_uh.jad_an(jad_cpVar, jad_jtVar, z ? com.jd.ad.sdk.jad_xg.jad_hu.jad_an() : 1.0f, jad_ly.jad_an, false));
    }

    public static <T> List<com.jd.ad.sdk.jad_yh.jad_an<T>> jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar, jad_mx<T> jad_mxVar) {
        return jad_uh.jad_an(jad_cpVar, jad_jtVar, 1.0f, jad_mxVar, false);
    }

    public static com.jd.ad.sdk.jad_ra.jad_dq jad_bo(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        return new com.jd.ad.sdk.jad_ra.jad_dq(jad_an(jad_cpVar, jad_jtVar, jad_re.jad_an));
    }

    public static com.jd.ad.sdk.jad_ra.jad_fs jad_cp(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        return new com.jd.ad.sdk.jad_ra.jad_fs(jad_uh.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_xg.jad_hu.jad_an(), jad_zm.jad_an, true));
    }
}
