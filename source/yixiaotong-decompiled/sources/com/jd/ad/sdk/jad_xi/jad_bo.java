package com.jd.ad.sdk.jad_xi;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_bo implements com.jd.ad.sdk.jad_it.jad_an.InterfaceC0555jad_an {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_bo;

    public jad_bo(com.jd.ad.sdk.jad_ny.jad_er jad_erVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_boVar;
    }

    public byte[] jad_an(int i) {
        com.jd.ad.sdk.jad_ny.jad_bo jad_boVar = this.jad_bo;
        return jad_boVar == null ? new byte[i] : (byte[]) jad_boVar.jad_an(i, byte[].class);
    }
}
