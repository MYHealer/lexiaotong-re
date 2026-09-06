package com.jd.ad.sdk.jad_ve;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_wj {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an(IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    public static com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_bo = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("id", "layers", IAdInterListener.AdReqParam.WIDTH, IAdInterListener.AdReqParam.HEIGHT, "p", "u");
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_cp = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("list");
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_dq = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("cm", "tm", "dr");

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0046. Please report as an issue. */
    public static com.jd.ad.sdk.jad_lu.jad_jt jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar) {
        ArrayList arrayList;
        float f;
        float f2;
        float fJad_an = com.jd.ad.sdk.jad_xg.jad_hu.jad_an();
        LongSparseArray<com.jd.ad.sdk.jad_tc.jad_er> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat<com.jd.ad.sdk.jad_qz.jad_dq> sparseArrayCompat = new SparseArrayCompat<>();
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = new com.jd.ad.sdk.jad_lu.jad_jt();
        jad_cpVar.jad_cp();
        int iJad_jw = 0;
        float fJad_iv = 0.0f;
        float fJad_iv2 = 0.0f;
        float fJad_iv3 = 0.0f;
        int iJad_jw2 = 0;
        while (jad_cpVar.jad_jt()) {
            float f3 = fJad_iv;
            switch (jad_cpVar.jad_an(jad_an)) {
                case 0:
                    iJad_jw = jad_cpVar.jad_jw();
                    fJad_iv = f3;
                    break;
                case 1:
                    iJad_jw2 = jad_cpVar.jad_jw();
                    fJad_iv = f3;
                    break;
                case 2:
                    fJad_iv3 = (float) jad_cpVar.jad_iv();
                    fJad_iv = f3;
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 3:
                    fJad_iv2 = ((float) jad_cpVar.jad_iv()) - 0.01f;
                    fJad_iv = f3;
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 4:
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fJad_iv = (float) jad_cpVar.jad_iv();
                    arrayList3 = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 5:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fJad_iv2;
                    f2 = fJad_iv3;
                    String[] strArrSplit = jad_cpVar.jad_ly().split("\\.");
                    int i = Integer.parseInt(strArrSplit[0]);
                    int i2 = Integer.parseInt(strArrSplit[1]);
                    int i3 = Integer.parseInt(strArrSplit[2]);
                    if (i < 4 || (i <= 4 && (i2 < 4 || (i2 <= 4 && i3 < 0)))) {
                        jad_jtVar.jad_an("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fJad_iv = f3;
                    fJad_iv3 = f2;
                    arrayList3 = arrayList;
                    fJad_iv2 = f;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 6:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fJad_iv2;
                    f2 = fJad_iv3;
                    jad_cpVar.jad_bo();
                    int i4 = 0;
                    while (jad_cpVar.jad_jt()) {
                        com.jd.ad.sdk.jad_tc.jad_er jad_erVarJad_an = jad_vi.jad_an(jad_cpVar, jad_jtVar);
                        if (jad_erVarJad_an.jad_er == 3) {
                            i4++;
                        }
                        arrayList2.add(jad_erVarJad_an);
                        longSparseArray.put(jad_erVarJad_an.jad_dq, jad_erVarJad_an);
                        if (i4 > 4) {
                            com.jd.ad.sdk.jad_xg.jad_dq.jad_an("You have " + i4 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    jad_cpVar.jad_dq();
                    fJad_iv = f3;
                    fJad_iv3 = f2;
                    arrayList3 = arrayList;
                    fJad_iv2 = f;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 7:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fJad_iv2;
                    f2 = fJad_iv3;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        ArrayList arrayList4 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        jad_cpVar.jad_cp();
                        String strJad_ly = null;
                        String strJad_ly2 = null;
                        String strJad_ly3 = null;
                        int iJad_jw3 = 0;
                        int iJad_jw4 = 0;
                        while (jad_cpVar.jad_jt()) {
                            int iJad_an = jad_cpVar.jad_an(jad_bo);
                            if (iJad_an == 0) {
                                strJad_ly = jad_cpVar.jad_ly();
                            } else if (iJad_an == 1) {
                                jad_cpVar.jad_bo();
                                while (jad_cpVar.jad_jt()) {
                                    com.jd.ad.sdk.jad_tc.jad_er jad_erVarJad_an2 = jad_vi.jad_an(jad_cpVar, jad_jtVar);
                                    longSparseArray2.put(jad_erVarJad_an2.jad_dq, jad_erVarJad_an2);
                                    arrayList4.add(jad_erVarJad_an2);
                                }
                                jad_cpVar.jad_dq();
                            } else if (iJad_an == 2) {
                                iJad_jw3 = jad_cpVar.jad_jw();
                            } else if (iJad_an == 3) {
                                iJad_jw4 = jad_cpVar.jad_jw();
                            } else if (iJad_an == 4) {
                                strJad_ly2 = jad_cpVar.jad_ly();
                            } else if (iJad_an != 5) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                strJad_ly3 = jad_cpVar.jad_ly();
                            }
                        }
                        jad_cpVar.jad_er();
                        if (strJad_ly2 != null) {
                            map2.put(strJad_ly, new com.jd.ad.sdk.jad_lu.jad_na(iJad_jw3, iJad_jw4, strJad_ly, strJad_ly2, strJad_ly3));
                        } else {
                            map.put(strJad_ly, arrayList4);
                        }
                    }
                    jad_cpVar.jad_dq();
                    fJad_iv = f3;
                    fJad_iv3 = f2;
                    arrayList3 = arrayList;
                    fJad_iv2 = f;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 8:
                    f = fJad_iv2;
                    f2 = fJad_iv3;
                    jad_cpVar.jad_cp();
                    while (jad_cpVar.jad_jt()) {
                        if (jad_cpVar.jad_an(jad_cp) != 0) {
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                        } else {
                            jad_cpVar.jad_bo();
                            while (jad_cpVar.jad_jt()) {
                                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar = jad_na.jad_an;
                                jad_cpVar.jad_cp();
                                String strJad_ly4 = null;
                                String strJad_ly5 = null;
                                String strJad_ly6 = null;
                                float fJad_iv4 = 0.0f;
                                while (true) {
                                    arrayList3 = arrayList3;
                                    if (jad_cpVar.jad_jt()) {
                                        int iJad_an2 = jad_cpVar.jad_an(jad_na.jad_an);
                                        SparseArrayCompat<com.jd.ad.sdk.jad_qz.jad_dq> sparseArrayCompat2 = sparseArrayCompat;
                                        if (iJad_an2 != 0) {
                                            if (iJad_an2 == 1) {
                                                strJad_ly5 = jad_cpVar.jad_ly();
                                            } else if (iJad_an2 == 2) {
                                                strJad_ly6 = jad_cpVar.jad_ly();
                                            } else if (iJad_an2 != 3) {
                                                jad_cpVar.jad_na();
                                                jad_cpVar.jad_ob();
                                            } else {
                                                fJad_iv4 = (float) jad_cpVar.jad_iv();
                                            }
                                            sparseArrayCompat = sparseArrayCompat2;
                                        } else {
                                            strJad_ly4 = jad_cpVar.jad_ly();
                                        }
                                    }
                                }
                                jad_cpVar.jad_er();
                                map3.put(strJad_ly5, new com.jd.ad.sdk.jad_qz.jad_cp(strJad_ly4, strJad_ly5, strJad_ly6, fJad_iv4));
                                arrayList3 = arrayList3;
                            }
                            jad_cpVar.jad_dq();
                        }
                    }
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    jad_cpVar.jad_er();
                    fJad_iv = f3;
                    fJad_iv3 = f2;
                    arrayList3 = arrayList;
                    fJad_iv2 = f;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 9:
                    f = fJad_iv2;
                    f2 = fJad_iv3;
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar2 = jad_mz.jad_an;
                        ArrayList arrayList5 = new ArrayList();
                        jad_cpVar.jad_cp();
                        double dJad_iv = 0.0d;
                        double dJad_iv2 = 0.0d;
                        String strJad_ly7 = null;
                        String strJad_ly8 = null;
                        char cCharAt = 0;
                        while (jad_cpVar.jad_jt()) {
                            int iJad_an3 = jad_cpVar.jad_an(jad_mz.jad_an);
                            if (iJad_an3 == 0) {
                                cCharAt = jad_cpVar.jad_ly().charAt(0);
                            } else if (iJad_an3 == 1) {
                                dJad_iv = jad_cpVar.jad_iv();
                            } else if (iJad_an3 == 2) {
                                dJad_iv2 = jad_cpVar.jad_iv();
                            } else if (iJad_an3 == 3) {
                                strJad_ly7 = jad_cpVar.jad_ly();
                            } else if (iJad_an3 == 4) {
                                strJad_ly8 = jad_cpVar.jad_ly();
                            } else if (iJad_an3 != 5) {
                                jad_cpVar.jad_na();
                                jad_cpVar.jad_ob();
                            } else {
                                jad_cpVar.jad_cp();
                                while (jad_cpVar.jad_jt()) {
                                    if (jad_cpVar.jad_an(jad_mz.jad_bo) != 0) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_cpVar.jad_bo();
                                        while (jad_cpVar.jad_jt()) {
                                            arrayList5.add((com.jd.ad.sdk.jad_sb.jad_pc) jad_hu.jad_an(jad_cpVar, jad_jtVar));
                                        }
                                        jad_cpVar.jad_dq();
                                    }
                                }
                                jad_cpVar.jad_er();
                            }
                        }
                        jad_cpVar.jad_er();
                        com.jd.ad.sdk.jad_qz.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_qz.jad_dq(arrayList5, cCharAt, dJad_iv, dJad_iv2, strJad_ly7, strJad_ly8);
                        sparseArrayCompat.put(jad_dqVar.hashCode(), jad_dqVar);
                    }
                    jad_cpVar.jad_dq();
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fJad_iv = f3;
                    fJad_iv3 = f2;
                    arrayList3 = arrayList;
                    fJad_iv2 = f;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                case 10:
                    jad_cpVar.jad_bo();
                    while (jad_cpVar.jad_jt()) {
                        jad_cpVar.jad_cp();
                        String strJad_ly9 = null;
                        float fJad_iv5 = 0.0f;
                        float fJad_iv6 = 0.0f;
                        while (jad_cpVar.jad_jt()) {
                            int iJad_an4 = jad_cpVar.jad_an(jad_dq);
                            float f4 = fJad_iv2;
                            if (iJad_an4 != 0) {
                                if (iJad_an4 == 1) {
                                    fJad_iv5 = (float) jad_cpVar.jad_iv();
                                } else if (iJad_an4 != 2) {
                                    jad_cpVar.jad_na();
                                    jad_cpVar.jad_ob();
                                } else {
                                    fJad_iv6 = (float) jad_cpVar.jad_iv();
                                }
                                fJad_iv2 = f4;
                            } else {
                                strJad_ly9 = jad_cpVar.jad_ly();
                            }
                        }
                        float f5 = fJad_iv2;
                        jad_cpVar.jad_er();
                        arrayList3.add(new com.jd.ad.sdk.jad_qz.jad_hu(strJad_ly9, fJad_iv5, fJad_iv6));
                        fJad_iv3 = fJad_iv3;
                        fJad_iv2 = f5;
                    }
                    f = fJad_iv2;
                    f2 = fJad_iv3;
                    jad_cpVar.jad_dq();
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    fJad_iv = f3;
                    fJad_iv3 = f2;
                    arrayList3 = arrayList;
                    fJad_iv2 = f;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
                default:
                    arrayList = arrayList3;
                    sparseArrayCompat = sparseArrayCompat;
                    f = fJad_iv2;
                    f2 = fJad_iv3;
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                    fJad_iv = f3;
                    fJad_iv3 = f2;
                    arrayList3 = arrayList;
                    fJad_iv2 = f;
                    sparseArrayCompat = sparseArrayCompat;
                    break;
            }
        }
        jad_jtVar.jad_jw = new Rect(0, 0, (int) (iJad_jw * fJad_an), (int) (iJad_jw2 * fJad_an));
        jad_jtVar.jad_kx = fJad_iv3;
        jad_jtVar.jad_ly = fJad_iv2;
        jad_jtVar.jad_mz = fJad_iv;
        jad_jtVar.jad_iv = arrayList2;
        jad_jtVar.jad_hu = longSparseArray;
        jad_jtVar.jad_cp = map;
        jad_jtVar.jad_dq = map2;
        jad_jtVar.jad_jt = sparseArrayCompat;
        jad_jtVar.jad_er = map3;
        jad_jtVar.jad_fs = arrayList3;
        return jad_jtVar;
    }
}
