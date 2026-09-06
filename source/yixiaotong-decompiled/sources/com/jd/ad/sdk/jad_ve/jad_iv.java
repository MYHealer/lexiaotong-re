package com.jd.ad.sdk.jad_ve;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv implements jad_mx<com.jd.ad.sdk.jad_qz.jad_bo> {
    public static final jad_iv jad_an = new jad_iv();
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_bo = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public com.jd.ad.sdk.jad_qz.jad_bo jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        jad_cpVar.jad_cp();
        String strJad_ly = null;
        String strJad_ly2 = null;
        float fJad_iv = 0.0f;
        float fJad_iv2 = 0.0f;
        float fJad_iv3 = 0.0f;
        float fJad_iv4 = 0.0f;
        int i = 3;
        int iJad_jw = 0;
        int iJad_an = 0;
        int iJad_an2 = 0;
        boolean zJad_hu = true;
        while (jad_cpVar.jad_jt()) {
            switch (jad_cpVar.jad_an(jad_bo)) {
                case 0:
                    strJad_ly = jad_cpVar.jad_ly();
                    break;
                case 1:
                    strJad_ly2 = jad_cpVar.jad_ly();
                    break;
                case 2:
                    fJad_iv = (float) jad_cpVar.jad_iv();
                    break;
                case 3:
                    int iJad_jw2 = jad_cpVar.jad_jw();
                    i = (iJad_jw2 <= 2 && iJad_jw2 >= 0) ? com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[iJad_jw2] : 3;
                    break;
                case 4:
                    iJad_jw = jad_cpVar.jad_jw();
                    break;
                case 5:
                    fJad_iv2 = (float) jad_cpVar.jad_iv();
                    break;
                case 6:
                    fJad_iv3 = (float) jad_cpVar.jad_iv();
                    break;
                case 7:
                    iJad_an = jad_sf.jad_an(jad_cpVar);
                    break;
                case 8:
                    iJad_an2 = jad_sf.jad_an(jad_cpVar);
                    break;
                case 9:
                    fJad_iv4 = (float) jad_cpVar.jad_iv();
                    break;
                case 10:
                    zJad_hu = jad_cpVar.jad_hu();
                    break;
                default:
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    break;
            }
        }
        jad_cpVar.jad_er();
        return new com.jd.ad.sdk.jad_qz.jad_bo(strJad_ly, strJad_ly2, fJad_iv, i, iJad_jw, fJad_iv2, fJad_iv3, iJad_an, iJad_an2, fJad_iv4, zJad_hu);
    }
}
