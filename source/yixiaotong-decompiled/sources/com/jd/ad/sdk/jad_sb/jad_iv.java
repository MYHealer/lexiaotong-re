package com.jd.ad.sdk.jad_sb;

import com.jd.ad.sdk.jad_lu.jad_zm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv implements jad_cp {
    public final String jad_an;
    public final int jad_bo;
    public final boolean jad_cp;

    public jad_iv(String str, int i, boolean z) {
        this.jad_an = str;
        this.jad_bo = i;
        this.jad_cp = z;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        if (jad_mzVar.jad_na) {
            return new com.jd.ad.sdk.jad_nw.jad_ly(this);
        }
        com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String jad_an() {
        return this.jad_an;
    }

    public String toString() {
        return jad_zm.jad_an("MergePaths{mode=").append(jad_hu.jad_an(this.jad_bo)).append('}').toString();
    }
}
