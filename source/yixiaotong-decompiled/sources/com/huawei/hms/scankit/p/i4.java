package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatReader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class i4 implements s5 {
    public static boolean a(w5 w5Var, float f, float f2) {
        double dAbs = Math.abs(w5Var.j()[0].b() - w5Var.j()[1].b()) / f;
        return (dAbs < 0.55d && ((double) f2) > 1.5d) || dAbs < 0.3d;
    }

    @Override // com.huawei.hms.scankit.p.s5
    public w5 a(p pVar, Map<f1, ?> map) throws a {
        return a(pVar, a(map), map);
    }

    public s5[] a(Map<f1, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(f1.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new h4(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new o5());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new b1());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new h());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new x4());
            }
        }
        return (s5[]) arrayList.toArray(new s5[arrayList.size()]);
    }

    private w5 a(p pVar, s5[] s5VarArr, Map<f1, ?> map) throws a {
        if (s5VarArr != null) {
            for (s5 s5Var : s5VarArr) {
                try {
                    w5 w5VarA = s5Var.a(pVar, map);
                    if (w5VarA != null && w5VarA.j() != null) {
                        int i = 0;
                        for (y5 y5Var : w5VarA.j()) {
                            if (y5Var != null) {
                                i++;
                            }
                        }
                        if (i == 0 && w5VarA.c() == BarcodeFormat.PDF_417) {
                            throw a.a();
                        }
                    }
                    return w5VarA;
                } catch (a unused) {
                }
            }
        }
        throw a.a();
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    /* JADX WARN: Code duplicated, block: B:20:0x003e  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0060  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c A[SYNTHETIC] */
    public w5 a(p pVar, p pVar2, Map<f1, Object> map, v3 v3Var, y1 y1Var) throws a {
        w5 w5VarA;
        boolean z;
        y5[] y5VarArrJ;
        boolean zContainsKey = map.containsKey(f1.PHOTO_MODE);
        float[] fArr = {1.0f, 0.0f};
        if (pVar2 != null) {
            w5VarA = a(pVar2, v3Var, map, fArr, y1Var);
        } else {
            if (zContainsKey || !b3.f4215a) {
                w5VarA = a(pVar, v3Var, map, fArr);
                z = fArr[1] > 1.0f;
                if (w5VarA != null) {
                    throw a.a();
                }
                if (z && (y5VarArrJ = w5VarA.j()) != null) {
                    for (int i = 0; i < y5VarArrJ.length; i++) {
                        if (y5VarArrJ[i] != null) {
                            y5VarArrJ[i] = new y5(y5VarArrJ[i].c(), (pVar.c() - 1) - y5VarArrJ[i].b());
                        }
                    }
                }
                return w5VarA;
            }
            w5VarA = null;
        }
        if (w5VarA != null) {
            throw a.a();
        }
        if (z) {
            while (i < y5VarArrJ.length) {
                if (y5VarArrJ[i] != null) {
                    y5VarArrJ[i] = new y5(y5VarArrJ[i].c(), (pVar.c() - 1) - y5VarArrJ[i].b());
                }
            }
        }
        return w5VarA;
    }

    private w5 a(p pVar, v3 v3Var, Map<f1, Object> map, float[] fArr, y1 y1Var) throws a {
        w5 w5VarA;
        float fN = y1Var.n();
        float fE = pVar.e() < pVar.c() ? pVar.e() : pVar.c();
        float f = fE / 500.0f;
        if (f < 1.0f) {
            f = 1.0f;
        }
        p pVarG = v3Var.g(pVar, f);
        s5[] s5VarArrA = a(map);
        float fB = y1Var.a() > 0.0f ? y1Var.b() / y1Var.a() : 1.0f;
        w5 w5Var = null;
        try {
            w5VarA = a(pVarG, s5VarArrA, (Map<f1, ?>) map);
            try {
                if (a(w5VarA, fN / f, fB)) {
                    throw a.a();
                }
            } catch (a unused) {
                w5Var = w5VarA;
                if (b3.l) {
                    float f2 = fE / 250.0f;
                    float f3 = f2 >= 1.0f ? f2 : 1.0f;
                    pVarG = v3Var.f(pVar, f3);
                    try {
                        map.put(f1.PHOTO_MODE_NUM, 2);
                        w5VarA = a(v3Var.e(pVarG), s5VarArrA, (Map<f1, ?>) map);
                        if (a(w5VarA, fN / f3, fB)) {
                            throw a.a();
                        }
                    } catch (a unused2) {
                        map.put(f1.PHOTO_MODE_NUM, 1);
                        w5VarA = a(v3Var.f(pVarG), s5VarArrA, (Map<f1, ?>) map);
                        if (a(w5VarA, fN / f3, fB)) {
                            throw a.a();
                        }
                    }
                    f = f3;
                } else {
                    w5VarA = w5Var;
                }
            }
        } catch (a unused3) {
        }
        fArr[0] = f;
        if (w5VarA != null) {
            a2.a(pVarG.b(), w5VarA, f, y1Var);
        }
        return w5VarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1, types: [com.huawei.hms.scankit.p.v3] */
    /* JADX WARN: Type inference failed for: r10v10, types: [com.huawei.hms.scankit.p.w5] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.huawei.hms.scankit.p.w5] */
    private w5 a(p pVar, v3 v3Var, Map<f1, Object> map, float[] fArr) throws a {
        p pVarA;
        w5 w5VarA;
        float fMin = (Math.min(pVar.c(), pVar.e()) * 1.0f) / 1080.0f;
        if (b3.f4215a) {
            pVarA = v3Var.a(pVar, fMin);
        } else {
            float f = fMin > 1.5f ? fMin : 1.0f;
            pVarA = v3Var.a(pVar, f);
            fMin = f;
        }
        s5[] s5VarArrA = a(map);
        if (b3.b || !b3.f4215a) {
            int i = 0;
            w5 w5VarA2 = null;
            w5VarA = v3Var;
            while (true) {
                if (i < 2) {
                    if (i == 1) {
                        w5VarA2 = a(w5VarA.c(u3.a(pVarA)), s5VarArrA, (Map<f1, ?>) map);
                        fArr[1] = 2.0f;
                    } else {
                        try {
                            try {
                                w5VarA = a(w5VarA.b(pVarA), s5VarArrA, (Map<f1, ?>) map);
                                break;
                            } catch (a unused) {
                                if (b3.l) {
                                    map.put(f1.PHOTO_MODE_NUM, 1);
                                    w5VarA = a(w5VarA.d(pVarA), s5VarArrA, (Map<f1, ?>) map);
                                    break;
                                }
                                i++;
                                w5VarA = w5VarA;
                            }
                        } catch (a unused2) {
                            i++;
                            w5VarA = w5VarA;
                        }
                    }
                }
                w5VarA = w5VarA2;
                i++;
                w5VarA = w5VarA;
            }
        } else {
            map.put(f1.PHOTO_MODE_NUM, 0);
            w5VarA = a(pVarA, s5VarArrA, (Map<f1, ?>) map);
        }
        if (w5VarA != 0) {
            a2.a(pVarA.b(), w5VarA, fMin, (y1) null);
        }
        fArr[0] = fMin;
        return w5VarA;
    }

    public w5 a(p pVar, p pVar2, p pVar3, Map<f1, ?> map, v3 v3Var, y1 y1Var) throws a {
        if (pVar3 != null) {
            return a(pVar3, v3Var, map, y1Var);
        }
        return a(pVar, pVar2, v3Var, map);
    }

    public w5 a(p pVar, v3 v3Var, Map<f1, ?> map, y1 y1Var) throws a {
        int iE = pVar.e();
        int iC = pVar.c();
        int i = iE < iC ? iE : iC;
        float f = i * 1.0f;
        float f2 = f / 128.0f;
        if (f2 < 1.0f && b3.c) {
            pVar = v3Var.e(pVar, f2);
        }
        p pVar2 = pVar;
        float f3 = f / 500.0f;
        float f4 = f3 >= 1.0f ? f3 : 1.0f;
        try {
            w5 w5VarA = a(v3Var.g(pVar2, f4), a(map), map);
            if (w5VarA != null && w5VarA.k() != null) {
                a2.a(w5VarA.j(), f4, y1Var);
                return w5VarA;
            }
            if (!b3.c && w5VarA != null && w5VarA.k() == null && w5VarA.j().length >= 3) {
            }
            throw a.a();
        } catch (a unused) {
            w5 w5VarA2 = a(i, pVar2, v3Var, map, y1Var);
            if (w5VarA2 == null) {
                throw a.a();
            }
            if (0 != 0) {
                w5VarA2.a();
                w5VarA2.b((y5[]) null);
                a2.a(w5VarA2.j(), f4, y1Var);
            }
            return w5VarA2;
        }
    }

    private w5 a(int i, p pVar, v3 v3Var, Map<f1, ?> map, y1 y1Var) throws a {
        float f = (i * 1.0f) / 250.0f;
        if (f < 1.0f) {
            f = 1.0f;
        }
        p pVarF = v3Var.f(pVar, f);
        s5[] s5VarArrA = a(map);
        try {
            try {
                w5 w5VarA = a(v3Var.e(pVarF), s5VarArrA, map);
                if (w5VarA != null && w5VarA.k() != null) {
                    a2.a(w5VarA.j(), f, y1Var);
                    return w5VarA;
                }
                throw a.a();
            } catch (a unused) {
                w5 w5VarA2 = a(new p(new n3(pVar.a().c())), s5VarArrA, map);
                if (w5VarA2 != null && w5VarA2.k() != null) {
                    a2.a(w5VarA2.j(), 1.0f, y1Var);
                }
                return w5VarA2;
            }
        } catch (a unused2) {
            w5 w5VarA3 = a(v3Var.f(pVarF), s5VarArrA, map);
            if (w5VarA3 != null && w5VarA3.k() != null) {
                a2.a(w5VarA3.j(), f, y1Var);
                return w5VarA3;
            }
            throw a.a();
        }
    }

    public w5 a(p pVar, p pVar2, v3 v3Var, Map<f1, ?> map) throws a {
        p pVarA;
        int iE = pVar.e();
        int iC = pVar.c();
        int i = iE < iC ? iE : iC;
        float f = (i * 1.0f) / 1080.0f;
        if (f <= 1.0f) {
            f = 1.0f;
        }
        if (b3.f4215a) {
            pVarA = v3Var.a(pVar, f);
        } else {
            float f2 = f > 1.5f ? f : 1.0f;
            float f3 = f2;
            pVarA = v3Var.a(pVar, f2);
            f = f3;
        }
        try {
            w5 w5VarA = a(pVarA, a(map), map);
            if (w5VarA != null && w5VarA.k() != null) {
                a2.a(w5VarA.j(), f, (y1) null);
                return w5VarA;
            }
            if (!b3.c && w5VarA != null && w5VarA.k() == null && w5VarA.j().length >= 3) {
            }
            throw a.a();
        } catch (a unused) {
            w5 w5VarA2 = a(i, v3Var, pVar, pVar2, map);
            if (w5VarA2 == null) {
                throw a.a();
            }
            if (0 != 0) {
                w5VarA2.a();
                w5VarA2.b((y5[]) null);
            }
            return w5VarA2;
        }
    }

    private w5 a(int i, v3 v3Var, p pVar, p pVar2, Map<f1, ?> map) throws a {
        s5[] s5VarArrA = a(map);
        try {
            if (b3.f4215a) {
                float f = (i * 1.0f) / 500.0f;
                if (f <= 1.0f) {
                    f = 1.0f;
                }
                w5 w5VarA = a(v3Var.g(v3Var.g(pVar, f)), s5VarArrA, map);
                if (w5VarA != null && w5VarA.k() != null) {
                    a2.a(w5VarA.j(), f, (y1) null);
                    return w5VarA;
                }
            }
            throw a.a();
        } catch (a unused) {
            float f2 = (i * 1.0f) / 1080.0f;
            float f3 = f2 > 1.0f ? f2 : 1.0f;
            w5 w5VarA2 = a(v3Var.b(pVar2, f3), s5VarArrA, map);
            if (w5VarA2 != null && w5VarA2.k() != null) {
                a2.a(w5VarA2.j(), f3, (y1) null);
            }
            return w5VarA2;
        }
    }
}
