package com.jd.ad.sdk.jad_nw;

import com.jd.ad.sdk.jad_sb.jad_uh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_sf implements jad_cp, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an {
    public final String jad_an;
    public final boolean jad_bo;
    public final List<com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an> jad_cp = new ArrayList();
    public final int jad_dq;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_er;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_jt;

    public jad_sf(com.jd.ad.sdk.jad_tc.jad_an jad_anVar, jad_uh jad_uhVar) {
        this.jad_an = jad_uhVar.jad_bo();
        this.jad_bo = jad_uhVar.jad_fs();
        this.jad_dq = jad_uhVar.jad_er();
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an = jad_uhVar.jad_dq().jad_an();
        this.jad_er = jad_anVarJad_an;
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an2 = jad_uhVar.jad_an().jad_an();
        this.jad_fs = jad_anVarJad_an2;
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an3 = jad_uhVar.jad_cp().jad_an();
        this.jad_jt = jad_anVarJad_an3;
        jad_anVar.jad_an(jad_anVarJad_an);
        jad_anVar.jad_an(jad_anVarJad_an2);
        jad_anVar.jad_an(jad_anVarJad_an3);
        jad_anVarJad_an.jad_an(this);
        jad_anVarJad_an2.jad_an(this);
        jad_anVarJad_an3.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an
    public void jad_an() {
        for (int i = 0; i < this.jad_cp.size(); i++) {
            this.jad_cp.get(i).jad_an();
        }
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_an;
    }
}
