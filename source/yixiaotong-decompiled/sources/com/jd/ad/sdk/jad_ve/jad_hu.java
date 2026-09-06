package com.jd.ad.sdk.jad_ve;

import android.graphics.Path;
import android.graphics.PointF;
import com.alipay.sdk.sys.a;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_hu {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an(a.g, t.t);

    /* JADX WARN: Code duplicated, block: B:396:0x070c A[LOOP:1: B:394:0x0706->B:396:0x070c, LOOP_END] */
    public static com.jd.ad.sdk.jad_sb.jad_cp jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar;
        String strJad_ly;
        com.jd.ad.sdk.jad_sb.jad_cp jad_boVar;
        com.jd.ad.sdk.jad_ra.jad_dq jad_dqVarJad_bo;
        String strJad_ly2;
        com.jd.ad.sdk.jad_sb.jad_cp jad_pcVar;
        String strJad_ly3;
        String strJad_ly4;
        jad_cpVar.jad_cp();
        int iJad_jw = 2;
        while (true) {
            jad_dqVar = null;
            jad_boVar = null;
            strJad_ly4 = null;
            strJad_ly3 = null;
            strJad_ly2 = null;
            jad_dqVarJad_bo = null;
            if (!jad_cpVar.jad_jt()) {
                strJad_ly = null;
                break;
            }
            int iJad_an = jad_cpVar.jad_an(jad_an);
            if (iJad_an == 0) {
                strJad_ly = jad_cpVar.jad_ly();
                break;
            }
            if (iJad_an != 1) {
                jad_cpVar.jad_na();
                jad_cpVar.jad_ob();
            } else {
                iJad_jw = jad_cpVar.jad_jw();
            }
        }
        if (strJad_ly == null) {
            return null;
        }
        strJad_ly.hashCode();
        boolean zJad_hu = false;
        int i = 0;
        switch (strJad_ly) {
            case "el":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar = jad_fs.jad_an;
                boolean z = iJad_jw == 3;
                String strJad_ly5 = null;
                com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_mzVarJad_bo = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVarJad_cp = null;
                boolean zJad_hu2 = false;
                while (jad_cpVar.jad_jt()) {
                    int iJad_an2 = jad_cpVar.jad_an(jad_fs.jad_an);
                    if (iJad_an2 == 0) {
                        strJad_ly5 = jad_cpVar.jad_ly();
                    } else if (iJad_an2 == 1) {
                        jad_mzVarJad_bo = jad_an.jad_bo(jad_cpVar, jad_jtVar);
                    } else if (iJad_an2 == 2) {
                        jad_fsVarJad_cp = jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                    } else if (iJad_an2 == 3) {
                        zJad_hu2 = jad_cpVar.jad_hu();
                    } else if (iJad_an2 != 4) {
                        jad_cpVar.jad_na();
                        jad_cpVar.jad_ob();
                    } else {
                        z = jad_cpVar.jad_jw() == 3;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_bo(strJad_ly5, jad_mzVarJad_bo, jad_fsVarJad_cp, z, zJad_hu2);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "fl":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar2 = jad_hs.jad_an;
                int iJad_jw2 = 1;
                String strJad_ly6 = null;
                com.jd.ad.sdk.jad_ra.jad_an jad_anVarJad_an = null;
                boolean zJad_hu3 = false;
                boolean zJad_hu4 = false;
                while (jad_cpVar.jad_jt()) {
                    int iJad_an3 = jad_cpVar.jad_an(jad_hs.jad_an);
                    if (iJad_an3 == 0) {
                        strJad_ly6 = jad_cpVar.jad_ly();
                    } else if (iJad_an3 == 1) {
                        jad_anVarJad_an = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                    } else if (iJad_an3 == 2) {
                        jad_dqVar = jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                    } else if (iJad_an3 == 3) {
                        zJad_hu3 = jad_cpVar.jad_hu();
                    } else if (iJad_an3 == 4) {
                        iJad_jw2 = jad_cpVar.jad_jw();
                    } else if (iJad_an3 != 5) {
                        jad_cpVar.jad_na();
                        jad_cpVar.jad_ob();
                    } else {
                        zJad_hu4 = jad_cpVar.jad_hu();
                    }
                }
                if (jad_dqVar == null) {
                    jad_dqVar = new com.jd.ad.sdk.jad_ra.jad_dq(Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(100)));
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_ob(strJad_ly6, zJad_hu3, iJad_jw2 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, jad_anVarJad_an, jad_dqVar, zJad_hu4);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "gf":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar3 = jad_pc.jad_an;
                Path.FillType fillType = Path.FillType.WINDING;
                String strJad_ly7 = null;
                com.jd.ad.sdk.jad_ra.jad_cp jad_cpVar2 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVarJad_cp2 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVarJad_cp3 = null;
                int i2 = 0;
                boolean zJad_hu5 = false;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(jad_pc.jad_an)) {
                        case 0:
                            strJad_ly7 = jad_cpVar.jad_ly();
                            break;
                        case 1:
                            jad_cpVar.jad_cp();
                            int iJad_jw3 = -1;
                            while (jad_cpVar.jad_jt()) {
                                int iJad_an4 = jad_cpVar.jad_an(jad_pc.jad_bo);
                                if (iJad_an4 == 0) {
                                    iJad_jw3 = jad_cpVar.jad_jw();
                                } else if (iJad_an4 != 1) {
                                    jad_cpVar.jad_na();
                                    jad_cpVar.jad_ob();
                                } else {
                                    jad_cpVar2 = new com.jd.ad.sdk.jad_ra.jad_cp(jad_dq.jad_an(jad_cpVar, jad_jtVar, new jad_ob(iJad_jw3)));
                                }
                            }
                            jad_cpVar.jad_er();
                            break;
                        case 2:
                            jad_dqVarJad_bo = jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                            break;
                        case 3:
                            i2 = jad_cpVar.jad_jw() != 1 ? 2 : 1;
                            break;
                        case 4:
                            jad_fsVarJad_cp2 = jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                            break;
                        case 5:
                            jad_fsVarJad_cp3 = jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                            break;
                        case 6:
                            fillType = jad_cpVar.jad_jw() != 1 ? Path.FillType.EVEN_ODD : Path.FillType.WINDING;
                            break;
                        case 7:
                            zJad_hu5 = jad_cpVar.jad_hu();
                            break;
                        default:
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_er(strJad_ly7, i2, fillType, jad_cpVar2, jad_dqVarJad_bo == null ? new com.jd.ad.sdk.jad_ra.jad_dq(Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(100))) : jad_dqVarJad_bo, jad_fsVarJad_cp2, jad_fsVarJad_cp3, null, null, zJad_hu5);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "gr":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar4 = jad_it.jad_an;
                ArrayList arrayList = new ArrayList();
                while (jad_cpVar.jad_jt()) {
                    int iJad_an5 = jad_cpVar.jad_an(jad_it.jad_an);
                    if (iJad_an5 == 0) {
                        strJad_ly2 = jad_cpVar.jad_ly();
                    } else if (iJad_an5 == 1) {
                        zJad_hu = jad_cpVar.jad_hu();
                    } else if (iJad_an5 != 2) {
                        jad_cpVar.jad_ob();
                    } else {
                        jad_cpVar.jad_bo();
                        while (jad_cpVar.jad_jt()) {
                            com.jd.ad.sdk.jad_sb.jad_cp jad_cpVarJad_an = jad_an(jad_cpVar, jad_jtVar);
                            if (jad_cpVarJad_an != null) {
                                arrayList.add(jad_cpVarJad_an);
                            }
                        }
                        jad_cpVar.jad_dq();
                    }
                }
                jad_pcVar = new com.jd.ad.sdk.jad_sb.jad_pc(strJad_ly2, arrayList, zJad_hu);
                jad_boVar = jad_pcVar;
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "gs":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar5 = jad_qd.jad_an;
                ArrayList arrayList2 = new ArrayList();
                com.jd.ad.sdk.jad_ra.jad_dq jad_dqVarJad_bo2 = null;
                String strJad_ly8 = null;
                com.jd.ad.sdk.jad_ra.jad_cp jad_cpVar3 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVarJad_cp4 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVarJad_cp5 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2 = null;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                boolean zJad_hu6 = false;
                float fJad_iv = 0.0f;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(jad_qd.jad_an)) {
                        case 0:
                            strJad_ly8 = jad_cpVar.jad_ly();
                            break;
                        case 1:
                            jad_cpVar.jad_cp();
                            int iJad_jw4 = -1;
                            while (jad_cpVar.jad_jt()) {
                                int iJad_an6 = jad_cpVar.jad_an(jad_qd.jad_bo);
                                if (iJad_an6 == 0) {
                                    iJad_jw4 = jad_cpVar.jad_jw();
                                } else if (iJad_an6 != 1) {
                                    jad_cpVar.jad_na();
                                    jad_cpVar.jad_ob();
                                } else {
                                    jad_cpVar3 = new com.jd.ad.sdk.jad_ra.jad_cp(jad_dq.jad_an(jad_cpVar, jad_jtVar, new jad_ob(iJad_jw4)));
                                }
                            }
                            jad_cpVar.jad_er();
                            break;
                        case 2:
                            jad_dqVarJad_bo2 = jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                            break;
                        case 3:
                            i3 = jad_cpVar.jad_jw() != 1 ? 2 : 1;
                            break;
                        case 4:
                            jad_fsVarJad_cp4 = jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                            break;
                        case 5:
                            jad_fsVarJad_cp5 = jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                            break;
                        case 6:
                            jad_boVarJad_an = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                            break;
                        case 7:
                            i4 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_cpVar.jad_jw() - 1];
                            break;
                        case 8:
                            i5 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_cpVar.jad_jw() - 1];
                            break;
                        case 9:
                            fJad_iv = (float) jad_cpVar.jad_iv();
                            break;
                        case 10:
                            zJad_hu6 = jad_cpVar.jad_hu();
                            break;
                        case 11:
                            jad_cpVar.jad_bo();
                            while (jad_cpVar.jad_jt()) {
                                jad_cpVar.jad_cp();
                                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an2 = null;
                                String strJad_ly9 = null;
                                while (jad_cpVar.jad_jt()) {
                                    int iJad_an7 = jad_cpVar.jad_an(jad_qd.jad_cp);
                                    if (iJad_an7 == 0) {
                                        strJad_ly9 = jad_cpVar.jad_ly();
                                    } else if (iJad_an7 != 1) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_boVarJad_an2 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                    }
                                }
                                jad_cpVar.jad_er();
                                if (strJad_ly9.equals("o")) {
                                    jad_boVar2 = jad_boVarJad_an2;
                                } else if (strJad_ly9.equals(t.t) || strJad_ly9.equals(OapsKey.KEY_GRADE)) {
                                    jad_jtVar.jad_na = true;
                                    arrayList2.add(jad_boVarJad_an2);
                                }
                            }
                            jad_cpVar.jad_dq();
                            if (arrayList2.size() == 1) {
                                arrayList2.add((com.jd.ad.sdk.jad_ra.jad_bo) arrayList2.get(0));
                            }
                            break;
                        default:
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_fs(strJad_ly8, i3, jad_cpVar3, jad_dqVarJad_bo2 == null ? new com.jd.ad.sdk.jad_ra.jad_dq(Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(100))) : jad_dqVarJad_bo2, jad_fsVarJad_cp4, jad_fsVarJad_cp5, jad_boVarJad_an, i4, i5, fJad_iv, arrayList2, jad_boVar2, zJad_hu6);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "mm":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar6 = jad_xk.jad_an;
                boolean zJad_hu7 = false;
                while (jad_cpVar.jad_jt()) {
                    int iJad_an8 = jad_cpVar.jad_an(jad_xk.jad_an);
                    if (iJad_an8 == 0) {
                        strJad_ly3 = jad_cpVar.jad_ly();
                    } else if (iJad_an8 == 1) {
                        int iJad_jw5 = jad_cpVar.jad_jw();
                        if (iJad_jw5 == 2) {
                            i = 2;
                        } else if (iJad_jw5 == 3) {
                            i = 3;
                        } else if (iJad_jw5 != 4) {
                            i = iJad_jw5 != 5 ? 1 : 5;
                        } else {
                            i = 4;
                        }
                    } else if (iJad_an8 != 2) {
                        jad_cpVar.jad_na();
                        jad_cpVar.jad_ob();
                    } else {
                        zJad_hu7 = jad_cpVar.jad_hu();
                    }
                }
                com.jd.ad.sdk.jad_sb.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_sb.jad_iv(strJad_ly3, i, zJad_hu7);
                jad_jtVar.jad_an("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                jad_boVar = jad_ivVar;
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "rc":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar7 = jad_do.jad_an;
                String strJad_ly10 = null;
                com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_mzVarJad_bo2 = null;
                com.jd.ad.sdk.jad_ra.jad_fs jad_fsVarJad_cp6 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an3 = null;
                boolean zJad_hu8 = false;
                while (jad_cpVar.jad_jt()) {
                    int iJad_an9 = jad_cpVar.jad_an(jad_do.jad_an);
                    if (iJad_an9 == 0) {
                        strJad_ly10 = jad_cpVar.jad_ly();
                    } else if (iJad_an9 == 1) {
                        jad_mzVarJad_bo2 = jad_an.jad_bo(jad_cpVar, jad_jtVar);
                    } else if (iJad_an9 == 2) {
                        jad_fsVarJad_cp6 = jad_dq.jad_cp(jad_cpVar, jad_jtVar);
                    } else if (iJad_an9 == 3) {
                        jad_boVarJad_an3 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                    } else if (iJad_an9 != 4) {
                        jad_cpVar.jad_ob();
                    } else {
                        zJad_hu8 = jad_cpVar.jad_hu();
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_ly(strJad_ly10, jad_mzVarJad_bo2, jad_fsVarJad_cp6, jad_boVarJad_an3, zJad_hu8);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "rp":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar8 = jad_ep.jad_an;
                String strJad_ly11 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an4 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an5 = null;
                com.jd.ad.sdk.jad_ra.jad_ly jad_lyVarJad_an = null;
                boolean zJad_hu9 = false;
                while (jad_cpVar.jad_jt()) {
                    int iJad_an10 = jad_cpVar.jad_an(jad_ep.jad_an);
                    if (iJad_an10 == 0) {
                        strJad_ly11 = jad_cpVar.jad_ly();
                    } else if (iJad_an10 == 1) {
                        jad_boVarJad_an4 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (iJad_an10 == 2) {
                        jad_boVarJad_an5 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (iJad_an10 == 3) {
                        jad_lyVarJad_an = jad_cp.jad_an(jad_cpVar, jad_jtVar);
                    } else if (iJad_an10 != 4) {
                        jad_cpVar.jad_ob();
                    } else {
                        zJad_hu9 = jad_cpVar.jad_hu();
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_mz(strJad_ly11, jad_boVarJad_an4, jad_boVarJad_an5, jad_lyVarJad_an, zJad_hu9);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "sh":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar9 = jad_ju.jad_an;
                com.jd.ad.sdk.jad_ra.jad_hu jad_huVar = null;
                int iJad_jw6 = 0;
                boolean zJad_hu10 = false;
                while (jad_cpVar.jad_jt()) {
                    int iJad_an11 = jad_cpVar.jad_an(jad_ju.jad_an);
                    if (iJad_an11 == 0) {
                        strJad_ly4 = jad_cpVar.jad_ly();
                    } else if (iJad_an11 == 1) {
                        iJad_jw6 = jad_cpVar.jad_jw();
                    } else if (iJad_an11 == 2) {
                        jad_huVar = new com.jd.ad.sdk.jad_ra.jad_hu(jad_uh.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_xg.jad_hu.jad_an(), jad_gr.jad_an, false));
                    } else if (iJad_an11 != 3) {
                        jad_cpVar.jad_ob();
                    } else {
                        zJad_hu10 = jad_cpVar.jad_hu();
                    }
                }
                jad_pcVar = new com.jd.ad.sdk.jad_sb.jad_qd(strJad_ly4, iJad_jw6, jad_huVar, zJad_hu10);
                jad_boVar = jad_pcVar;
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "sr":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar10 = jad_cn.jad_an;
                String strJad_ly12 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an6 = null;
                com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_mzVarJad_bo3 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an7 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an8 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an9 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an10 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an11 = null;
                int i6 = 0;
                boolean zJad_hu11 = false;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(jad_cn.jad_an)) {
                        case 0:
                            strJad_ly12 = jad_cpVar.jad_ly();
                            break;
                        case 1:
                            int iJad_jw7 = jad_cpVar.jad_jw();
                            int[] iArrJad_bo = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(2);
                            int length = iArrJad_bo.length;
                            int i7 = 0;
                            while (true) {
                                if (i7 >= length) {
                                    i6 = 0;
                                }
                                i6 = iArrJad_bo[i7];
                                if (com.jd.ad.sdk.jad_sb.jad_jw.jad_an(i6) == iJad_jw7) {
                                }
                                i7++;
                                break;
                                break;
                            }
                            break;
                        case 2:
                            jad_boVarJad_an6 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                            break;
                        case 3:
                            jad_mzVarJad_bo3 = jad_an.jad_bo(jad_cpVar, jad_jtVar);
                            break;
                        case 4:
                            jad_boVarJad_an7 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                            break;
                        case 5:
                            jad_boVarJad_an9 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                            break;
                        case 6:
                            jad_boVarJad_an11 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                            break;
                        case 7:
                            jad_boVarJad_an8 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                            break;
                        case 8:
                            jad_boVarJad_an10 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                            break;
                        case 9:
                            zJad_hu11 = jad_cpVar.jad_hu();
                            break;
                        default:
                            jad_cpVar.jad_na();
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_kx(strJad_ly12, i6, jad_boVarJad_an6, jad_mzVarJad_bo3, jad_boVarJad_an7, jad_boVarJad_an8, jad_boVarJad_an9, jad_boVarJad_an10, jad_boVarJad_an11, zJad_hu11);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "st":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar11 = jad_kv.jad_an;
                ArrayList arrayList3 = new ArrayList();
                com.jd.ad.sdk.jad_ra.jad_dq jad_dqVarJad_bo3 = null;
                String strJad_ly13 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVar3 = null;
                com.jd.ad.sdk.jad_ra.jad_an jad_anVarJad_an2 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an12 = null;
                int i8 = 0;
                int i9 = 0;
                boolean zJad_hu12 = false;
                float fJad_iv2 = 0.0f;
                while (jad_cpVar.jad_jt()) {
                    switch (jad_cpVar.jad_an(jad_kv.jad_an)) {
                        case 0:
                            strJad_ly13 = jad_cpVar.jad_ly();
                            break;
                        case 1:
                            jad_anVarJad_an2 = jad_dq.jad_an(jad_cpVar, jad_jtVar);
                            break;
                        case 2:
                            jad_boVarJad_an12 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                            break;
                        case 3:
                            jad_dqVarJad_bo3 = jad_dq.jad_bo(jad_cpVar, jad_jtVar);
                            break;
                        case 4:
                            i8 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_cpVar.jad_jw() - 1];
                            break;
                        case 5:
                            i9 = com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(3)[jad_cpVar.jad_jw() - 1];
                            break;
                        case 6:
                            fJad_iv2 = (float) jad_cpVar.jad_iv();
                            break;
                        case 7:
                            zJad_hu12 = jad_cpVar.jad_hu();
                            break;
                        case 8:
                            jad_cpVar.jad_bo();
                            while (jad_cpVar.jad_jt()) {
                                jad_cpVar.jad_cp();
                                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an13 = null;
                                String strJad_ly14 = null;
                                while (jad_cpVar.jad_jt()) {
                                    int iJad_an12 = jad_cpVar.jad_an(jad_kv.jad_bo);
                                    if (iJad_an12 == 0) {
                                        strJad_ly14 = jad_cpVar.jad_ly();
                                    } else if (iJad_an12 != 1) {
                                        jad_cpVar.jad_na();
                                        jad_cpVar.jad_ob();
                                    } else {
                                        jad_boVarJad_an13 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                                    }
                                }
                                jad_cpVar.jad_er();
                                strJad_ly14.getClass();
                                strJad_ly14.hashCode();
                                switch (strJad_ly14) {
                                    case "d":
                                    case "g":
                                        jad_jtVar.jad_na = true;
                                        arrayList3.add(jad_boVarJad_an13);
                                        break;
                                    case "o":
                                        jad_boVar3 = jad_boVarJad_an13;
                                        break;
                                }
                            }
                            jad_cpVar.jad_dq();
                            if (arrayList3.size() == 1) {
                                arrayList3.add((com.jd.ad.sdk.jad_ra.jad_bo) arrayList3.get(0));
                            }
                            break;
                        default:
                            jad_cpVar.jad_ob();
                            break;
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_re(strJad_ly13, jad_boVar3, arrayList3, jad_anVarJad_an2, jad_dqVarJad_bo3 == null ? new com.jd.ad.sdk.jad_ra.jad_dq(Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(100))) : jad_dqVarJad_bo3, jad_boVarJad_an12, i8, i9, fJad_iv2, zJad_hu12);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "tm":
                com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_anVar12 = jad_lw.jad_an;
                String strJad_ly15 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an14 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an15 = null;
                com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an16 = null;
                int i10 = 0;
                boolean zJad_hu13 = false;
                while (jad_cpVar.jad_jt()) {
                    int iJad_an13 = jad_cpVar.jad_an(jad_lw.jad_an);
                    if (iJad_an13 == 0) {
                        jad_boVarJad_an14 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (iJad_an13 == 1) {
                        jad_boVarJad_an15 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (iJad_an13 == 2) {
                        jad_boVarJad_an16 = jad_dq.jad_an(jad_cpVar, jad_jtVar, false);
                    } else if (iJad_an13 == 3) {
                        strJad_ly15 = jad_cpVar.jad_ly();
                    } else if (iJad_an13 == 4) {
                        int iJad_jw8 = jad_cpVar.jad_jw();
                        if (iJad_jw8 == 1) {
                            i10 = 1;
                        } else {
                            if (iJad_jw8 != 2) {
                                throw new IllegalArgumentException("Unknown trim path type " + iJad_jw8);
                            }
                            i10 = 2;
                        }
                    } else if (iJad_an13 != 5) {
                        jad_cpVar.jad_ob();
                    } else {
                        zJad_hu13 = jad_cpVar.jad_hu();
                    }
                }
                jad_boVar = new com.jd.ad.sdk.jad_sb.jad_uh(strJad_ly15, i10, jad_boVarJad_an14, jad_boVarJad_an15, jad_boVarJad_an16, zJad_hu13);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            case "tr":
                jad_boVar = jad_cp.jad_an(jad_cpVar, jad_jtVar);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
            default:
                com.jd.ad.sdk.jad_xg.jad_dq.jad_an("Unknown shape type " + strJad_ly);
                while (jad_cpVar.jad_jt()) {
                    jad_cpVar.jad_ob();
                }
                jad_cpVar.jad_er();
                return jad_boVar;
        }
    }
}
