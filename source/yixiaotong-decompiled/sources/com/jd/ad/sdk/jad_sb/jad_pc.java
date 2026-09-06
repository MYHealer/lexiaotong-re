package com.jd.ad.sdk.jad_sb;

import com.jd.ad.sdk.jad_lu.jad_zm;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_pc implements jad_cp {
    public final String jad_an;
    public final List<jad_cp> jad_bo;
    public final boolean jad_cp;

    public jad_pc(String str, List<jad_cp> list, boolean z) {
        this.jad_an = str;
        this.jad_bo = list;
        this.jad_cp = z;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_dq(jad_mzVar, jad_anVar, this);
    }

    public List<jad_cp> jad_an() {
        return this.jad_bo;
    }

    public String jad_bo() {
        return this.jad_an;
    }

    public boolean jad_cp() {
        return this.jad_cp;
    }

    public String toString() {
        return jad_zm.jad_an("ShapeGroup{name='").append(this.jad_an).append("' Shapes: ").append(Arrays.toString(this.jad_bo.toArray())).append('}').toString();
    }
}
