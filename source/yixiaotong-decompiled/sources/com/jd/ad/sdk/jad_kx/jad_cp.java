package com.jd.ad.sdk.jad_kx;

/* JADX INFO: compiled from: PreloadAdData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp {
    public final int jad_an;
    public final String jad_bo;
    public final String jad_cp;
    public String jad_dq;
    public String jad_er;

    public jad_cp(int i, String str, String str2, String str3, String str4) {
        this.jad_an = i;
        this.jad_bo = str2;
        this.jad_cp = str;
        this.jad_dq = str3;
        this.jad_er = str4;
    }

    public String toString() {
        return com.jd.ad.sdk.jad_bo.jad_bo.jad_an("PreloadAdData{id=").append(this.jad_an).append(", rId='").append(this.jad_bo).append('\'').append(", appIdSlotId='").append(this.jad_cp).append('\'').append(", preloadAdJson='").append(this.jad_dq).append('\'').append(", preloadAdCacheTimeStamp='").append(this.jad_er).append('\'').append('}').toString();
    }
}
