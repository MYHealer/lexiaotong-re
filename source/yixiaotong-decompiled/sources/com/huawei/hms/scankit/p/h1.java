package com.huawei.hms.scankit.p;

import android.util.Log;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DecodeProcessor.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private y3 f4267a;
    private p b;
    private p c;
    private p d;
    private boolean e = false;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float j = 1.778f;
    private int k = 0;
    private int l = 0;
    public v3 i = new v3();

    h1(y3 y3Var) {
        this.f4267a = y3Var;
        this.b = new p(new a3(this.f4267a));
        this.c = new p(new n3(this.f4267a));
    }

    static w5 a(List<y1> list, h1 h1Var) {
        for (y1 y1Var : list) {
            if (b3.b || y1Var.h() > 0.4d) {
                int iJ = (int) y1Var.j();
                int iK = (int) y1Var.k();
                if (iJ > h1Var.f4267a.c() / 3 && iJ < (h1Var.f4267a.c() * 2) / 3 && iK > h1Var.f4267a.a() / 3 && iK < (h1Var.f4267a.a() * 2) / 3) {
                    float fC = h1Var.c(h1Var.d);
                    w5 w5Var = new w5(1.0f);
                    w5Var.a(fC);
                    w5Var.a(y1Var);
                    return w5Var;
                }
            }
        }
        return null;
    }

    public p a() {
        return this.b;
    }

    public w5 b(List<BarcodeFormat> list, y1 y1Var) {
        w5 w5VarA;
        i4 i4Var = new i4();
        HashMap map = new HashMap();
        map.put(f1.POSSIBLE_FORMATS, list);
        try {
            w5VarA = y1Var != null ? i4Var.a(this.b, this.c, this.d, map, this.i, y1Var) : i4Var.a(this.b, this.c, null, map, this.i, null);
            try {
                if (!b3.c && w5VarA != null && w5VarA.k() == null && w5VarA.j() != null && w5VarA.j().length >= 3) {
                    float fB = i7.b(this.f4267a.c(), this.f4267a.a(), w5VarA.j());
                    if (Math.abs(1.0f - fB) > 0.001d) {
                        this.h = fB;
                        this.e = true;
                    }
                }
            } catch (a unused) {
                Log.e("DecodeProcessor", "decode2d AIScanException");
            }
        } catch (a unused2) {
            w5VarA = null;
        }
        return w5VarA;
    }

    public boolean b() {
        return this.e;
    }

    public float c() {
        return this.f;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00ee A[Catch: a -> 0x00f6, TRY_ENTER, TRY_LEAVE, TryCatch #1 {a -> 0x00f6, blocks: (B:10:0x0039, B:39:0x00ee, B:18:0x005d, B:20:0x006b, B:26:0x0085, B:28:0x008f, B:33:0x009d, B:31:0x0097, B:17:0x0058, B:13:0x0047, B:15:0x004b), top: B:60:0x0039, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00f8  */
    public w5 c(List<BarcodeFormat> list, y1 y1Var) {
        w5 w5VarA;
        w5 w5VarA2;
        float fMin;
        float f;
        i4 i4Var = new i4();
        HashMap map = new HashMap();
        map.put(f1.POSSIBLE_FORMATS, list);
        w5 w5VarA3 = null;
        float f2 = 1.0f;
        try {
            if (y1Var != null) {
                p pVar = this.d;
                if (pVar != null) {
                    fMin = Math.min(pVar.e(), this.d.c()) / 800.0f;
                    if (fMin < 1.25f) {
                        fMin = 1.0f;
                    }
                    try {
                        p pVarH = this.i.h(this.d, fMin);
                        try {
                            try {
                                w5VarA2 = i4Var.a(pVarH, map);
                            } catch (a unused) {
                                if (b3.m) {
                                    w5VarA3 = i4Var.a(this.i.g(this.d, fMin), map);
                                }
                                float fI = (y1Var.i() + 180.0f) % 90.0f;
                                if (!b3.c && y1Var.h() > 0.8d && (fI < 3.0f || fI > 87.0f)) {
                                    y3 y3VarC = pVarH.a().c();
                                    if (fI < 3.0f) {
                                        f = fI * (-2.0f);
                                    } else {
                                        f = fI > 87.0f ? 2.0f * (90.0f - fI) : 0.0f;
                                    }
                                    w5VarA2 = i4Var.a(new p(new n3(new j5(LoadOpencvJNIUtil.imageRotate(y3VarC.b(), y3VarC.a(), y3VarC.c(), y3VarC.a(), y3VarC.c(), f, 1.0d), y3VarC.c(), y3VarC.a(), 0, 0, y3VarC.c(), y3VarC.a(), false))), map);
                                    w5VarA3 = w5VarA2;
                                    if (w5VarA3 != null) {
                                        a2.a(w5VarA3.j(), fMin, y1Var);
                                    } else {
                                        f2 = fMin;
                                    }
                                } else if (w5VarA3 != null) {
                                    a2.a(w5VarA3.j(), fMin, y1Var);
                                } else {
                                    f2 = fMin;
                                }
                                return a(w5VarA3, f2, 0, 0);
                            }
                        } catch (a unused2) {
                            Log.e("DecodeProcessor", "decodePdf417  AIScanException");
                            float fI2 = (y1Var.i() + 180.0f) % 90.0f;
                            if (!b3.c) {
                            }
                            if (w5VarA3 != null) {
                                a2.a(w5VarA3.j(), fMin, y1Var);
                            } else {
                                f2 = fMin;
                            }
                            return a(w5VarA3, f2, 0, 0);
                        }
                    } catch (a unused3) {
                        f2 = fMin;
                        Log.e("DecodeProcessor", "decodePdf417 AIScanException");
                    }
                } else {
                    w5VarA2 = i4Var.a(this.b, map);
                    fMin = 1.0f;
                }
                w5VarA3 = w5VarA2;
                if (w5VarA3 != null) {
                    a2.a(w5VarA3.j(), fMin, y1Var);
                } else {
                    f2 = fMin;
                }
            } else {
                int iMin = Math.min(this.b.e(), this.b.c());
                if (iMin > 1080) {
                    float f3 = iMin / 1080.0f;
                    if (f3 >= 1.25f) {
                        f2 = f3;
                    }
                }
                try {
                    w5VarA = i4Var.a(this.i.a(this.b, f2), map);
                } catch (a unused4) {
                    w5VarA = i4Var.a(this.i.b(this.c, f2), map);
                }
                w5VarA3 = w5VarA;
            }
        } catch (a unused5) {
            Log.e("DecodeProcessor", "decodePdf417 AIScanException");
        }
        return a(w5VarA3, f2, 0, 0);
    }

    public float d() {
        return this.h;
    }

    public w5 d(List<BarcodeFormat> list, y1 y1Var) {
        HashMap map = new HashMap();
        map.put(f1.POSSIBLE_FORMATS, list);
        if (y1Var == null) {
            w5 w5VarA = a(map);
            if (w5VarA != null && w5VarA.k() == null && b3.m) {
                b3.i = true;
                w5VarA = a(map);
                b3.i = false;
            }
            w5 w5Var = w5VarA;
            if (w5Var == null || w5Var.k() != null || !b3.n) {
                return w5Var;
            }
            b3.j = true;
            w5 w5VarA2 = a(map);
            b3.j = false;
            return w5VarA2;
        }
        b3.h = true;
        w5 w5VarA3 = a(map, y1Var);
        b3.h = false;
        if (w5VarA3 != null && w5VarA3.k() == null && b3.l) {
            b3.i = true;
            w5VarA3 = f(list, y1Var);
            b3.i = false;
        }
        if (w5VarA3 != null && w5VarA3.k() == null && b3.m) {
            b3.j = true;
            w5VarA3 = a(map, y1Var);
            b3.j = false;
        }
        if ((w5VarA3 != null && w5VarA3.k() != null) || !b3.n) {
            return w5VarA3;
        }
        b3.k = true;
        w5 w5VarA4 = a(map, y1Var);
        b3.k = false;
        return w5VarA4;
    }

    public float e() {
        return this.g;
    }

    public w5 e(List<BarcodeFormat> list, y1 y1Var) {
        float fE;
        p pVar;
        HashMap map = new HashMap();
        map.put(f1.POSSIBLE_FORMATS, list);
        try {
            y3 y3VarC = y1Var != null ? this.d.a().c() : this.f4267a;
            if (!b3.f4215a || (this.b.e() <= 800 && this.b.c() <= 800)) {
                fE = 1.0f;
            } else {
                fE = (this.b.e() > this.b.c() ? this.b.e() : this.b.c()) / 800.0f;
                y3VarC = this.i.h(new p(new a3(y3VarC)), fE).a().c();
            }
            y3 y3Var = y3VarC;
            float f = fE;
            if (y3Var == null) {
                throw a.a();
            }
            if (!b3.f4215a || b3.b) {
                pVar = new p(new a3(y3Var));
            } else {
                s sVarA = a(y3Var.b(), y3Var.c(), y3Var.a());
                pVar = new p(new a3(y3Var));
                pVar.a(sVarA);
            }
            i4 i4Var = new i4();
            try {
                w5 w5VarA = i4Var.a(pVar, map);
                if (w5VarA == null || w5VarA.k() == null) {
                    throw a.a();
                }
                a2.a(w5VarA.j(), f, y1Var);
                return w5VarA;
            } catch (a unused) {
                return a(i4Var, y3Var, pVar, map, f, y1Var);
            }
        } catch (a unused2) {
            Log.e("DecodeProcessor", "decodeQRMulti AIScanException");
            return null;
        }
    }

    public w5 f(List<BarcodeFormat> list, y1 y1Var) {
        p pVarG;
        p pVar;
        w5 w5VarA;
        i4 i4Var = new i4();
        HashMap map = new HashMap();
        map.put(f1.POSSIBLE_FORMATS, list);
        float fE = 1.0f;
        if (y1Var == null) {
            if (!b3.f4215a || (this.b.e() <= 500 && this.b.c() <= 500)) {
                pVarG = this.b;
            } else {
                fE = (this.b.e() > this.b.c() ? this.b.e() : this.b.c()) / 500.0f;
                pVarG = this.i.c(this.b, fE);
            }
        } else if (!b3.f4215a || (pVar = this.d) == null || (pVar.e() <= 500 && this.d.c() <= 500)) {
            pVarG = this.d;
        } else {
            fE = (this.d.e() > this.d.c() ? this.d.e() : this.d.c()) / 500.0f;
            pVarG = this.i.g(this.d, fE);
        }
        try {
            w5VarA = i4Var.a(pVarG, map);
            if (w5VarA != null) {
                try {
                    if (w5VarA.k() != null) {
                        a2.a(w5VarA.j(), fE, y1Var);
                        return w5VarA;
                    }
                } catch (a unused) {
                    Log.e("DecodeProcessor", "decodeQRSimple AIScanException");
                }
            }
        } catch (a unused2) {
            w5VarA = null;
        }
        return w5VarA;
    }

    static w5 a(h1 h1Var) {
        float fC = h1Var.c(h1Var.b);
        w5 w5Var = new w5(1.0f);
        w5Var.b(fC);
        w5Var.b(new y1(false, 0.0f, 0.0f, h1Var.b.e(), h1Var.b.e(), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        return w5Var;
    }

    private p b(p pVar) {
        int iE = pVar.e();
        int iC = pVar.c();
        if (iE < iC) {
            if (iC / iE <= 1.2d) {
                return pVar;
            }
            int i = (int) (((double) iE) * 1.2d);
            int i2 = (iC - i) / 2;
            this.l = i2;
            return pVar.a(0, i2, iE, i);
        }
        if (iE / iC <= 1.2d) {
            return pVar;
        }
        int i3 = (int) (((double) iC) * 1.2d);
        int i4 = (iE - i3) / 2;
        this.k = i4;
        return pVar.a(i4, 0, i3, iC);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:61:0x0101  */
    public w5 a(Map<f1, Object> map, y1 y1Var) {
        p pVar;
        float f;
        w5 w5Var;
        w5 w5Var2;
        p pVar2;
        w5 w5VarA;
        float fA;
        i4 i4Var = new i4();
        p pVar3 = this.d;
        w5 w5Var3 = null;
        if (pVar3 == null) {
            return null;
        }
        b3.d = true;
        int iE = pVar3.e() > this.d.c() ? this.d.e() : this.d.c();
        if (!b3.f4215a || iE <= 500) {
            pVar = this.d;
            f = 1.0f;
        } else {
            float f2 = iE / 500.0f;
            if (f2 < 1.0f) {
                f2 = 1.0f;
            }
            pVar = this.i.g(this.d, f2);
            f = f2;
        }
        try {
            if (b3.k) {
                pVar = new p(new a3(l6.b(pVar.a().c())));
            }
            w5 w5VarA2 = i4Var.a(pVar, map);
            if (w5VarA2 != null) {
                try {
                    if (w5VarA2.k() != null || w5VarA2.j() == null || w5VarA2.j().length < 3) {
                        w5Var = null;
                    } else {
                        w5Var = new w5(null, null, w5VarA2.j(), BarcodeFormat.QR_CODE);
                        try {
                            w5VarA2 = a(pVar, map, w5VarA2, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d});
                        } catch (a unused) {
                            pVar2 = pVar;
                            w5Var2 = w5VarA2;
                            w5VarA = a(pVar2, w5Var2, w5Var, i4Var, map, f, y1Var);
                            if ((w5VarA != null || w5VarA.k() == null) && !b3.c && w5VarA != null && w5VarA.j() != null && w5VarA.j().length >= 3) {
                                a2.a(w5VarA.j(), f, y1Var);
                                fA = i7.a(this.f4267a.c(), this.f4267a.a(), w5VarA.j());
                                if (Math.abs(1.0f - fA) > 0.001d) {
                                    this.f = fA;
                                    this.e = true;
                                }
                            }
                            return w5VarA;
                        }
                    }
                } catch (a unused2) {
                    w5Var = null;
                    w5Var3 = w5VarA2;
                    p pVar4 = pVar;
                    w5Var2 = w5Var3;
                    pVar2 = pVar4;
                    w5VarA = a(pVar2, w5Var2, w5Var, i4Var, map, f, y1Var);
                    if (w5VarA != null) {
                    }
                    a2.a(w5VarA.j(), f, y1Var);
                    fA = i7.a(this.f4267a.c(), this.f4267a.a(), w5VarA.j());
                    if (Math.abs(1.0f - fA) > 0.001d) {
                        this.f = fA;
                        this.e = true;
                    }
                    return w5VarA;
                }
            } else {
                w5Var = null;
            }
            w5Var3 = w5VarA2;
            if (w5Var3 != null) {
                try {
                    if (w5Var3.k() != null) {
                        a2.a(w5Var3.j(), f, y1Var);
                        return w5Var3;
                    }
                } catch (a unused3) {
                    p pVar5 = pVar;
                    w5Var2 = w5Var3;
                    pVar2 = pVar5;
                    w5VarA = a(pVar2, w5Var2, w5Var, i4Var, map, f, y1Var);
                    if (w5VarA != null) {
                    }
                    a2.a(w5VarA.j(), f, y1Var);
                    fA = i7.a(this.f4267a.c(), this.f4267a.a(), w5VarA.j());
                    if (Math.abs(1.0f - fA) > 0.001d) {
                        this.f = fA;
                        this.e = true;
                    }
                    return w5VarA;
                }
            }
            throw a.a();
        } catch (a unused4) {
            w5Var = null;
        }
    }

    public boolean b(List<y1> list) {
        int i;
        for (y1 y1Var : list) {
            boolean z = y1Var.g() == 1.0f && ((double) y1Var.h()) > 0.7d;
            boolean z2 = y1Var.g() == 1.0f && ((double) y1Var.h()) > 0.4d;
            boolean z3 = y1Var.g() == 2.0f && ((double) y1Var.h()) > 0.7d;
            boolean z4 = y1Var.g() == 3.0f && ((double) y1Var.h()) > 0.7d;
            if (z2 || z3 || z4) {
                if (!z && !a(this.b, y1Var) && (i = b3.g) <= 4) {
                    b3.g = i + 2;
                } else {
                    b3.g = 0;
                    float fB = i7.b(this.f4267a.c(), this.f4267a.a(), new y5[]{new y5(y1Var.d(), y1Var.e()), new y5(y1Var.d() + y1Var.f(), y1Var.e()), new y5(y1Var.d(), y1Var.e() + y1Var.c())});
                    if (fB > 1.001f) {
                        this.g = fB;
                        this.e = true;
                    }
                }
            }
        }
        return this.e;
    }

    public float c(p pVar) {
        byte[] bArrB = (pVar == null || (pVar.a() == null && pVar.a().c() == null)) ? null : pVar.a().c().b();
        if (bArrB == null) {
            return 1.0f;
        }
        int iE = pVar.e();
        int iC = pVar.c();
        long j = 0;
        for (int i = iC / 4; i < (iC * 3) / 4; i++) {
            for (int i2 = iE / 4; i2 < (iE * 3) / 4; i2++) {
                j += (long) (bArrB[(i * iE) + i2] & 255);
            }
        }
        return (j / ((long) bArrB.length)) * 4;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00ed A[Catch: a -> 0x012c, TryCatch #2 {a -> 0x012c, blocks: (B:47:0x00a3, B:49:0x00ed, B:51:0x0106, B:53:0x010c, B:55:0x0112, B:56:0x0128), top: B:64:0x00a3 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x0106 A[Catch: a -> 0x012c, TryCatch #2 {a -> 0x012c, blocks: (B:47:0x00a3, B:49:0x00ed, B:51:0x0106, B:53:0x010c, B:55:0x0112, B:56:0x0128), top: B:64:0x00a3 }] */
    /* JADX WARN: Code duplicated, block: B:55:0x0112 A[Catch: a -> 0x012c, LOOP:0: B:54:0x0110->B:55:0x0112, LOOP_END, TryCatch #2 {a -> 0x012c, blocks: (B:47:0x00a3, B:49:0x00ed, B:51:0x0106, B:53:0x010c, B:55:0x0112, B:56:0x0128), top: B:64:0x00a3 }] */
    private w5 a(p pVar, w5 w5Var, w5 w5Var2, i4 i4Var, Map<f1, Object> map, float f, y1 y1Var) {
        w5 w5Var3;
        int iMax;
        int iMax2;
        float[] fArr;
        byte[] bArrQRCornerDetect;
        w5 w5VarA;
        y5[] y5VarArr;
        int i;
        try {
            if (b3.f4215a) {
                pVar.a(a(pVar.d(), pVar.e(), pVar.c()));
                w5Var = i4Var.a(pVar, map);
                if (w5Var != null && w5Var.k() == null && w5Var.j() != null && w5Var.j().length >= 3) {
                    w5Var3 = new w5(null, null, w5Var.j(), BarcodeFormat.QR_CODE);
                    try {
                        w5Var = a(pVar, map, w5Var, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d});
                    } catch (a unused) {
                        if (w5Var == null && (b3.t || (!b3.c && b3.m))) {
                            try {
                                pVar.a(pVar.b().d());
                                w5 w5VarA2 = i4Var.a(pVar, map);
                                if (w5VarA2 != null && w5VarA2.k() != null) {
                                    a2.a(w5VarA2.j(), f, y1Var);
                                    return w5VarA2;
                                }
                                throw a.a();
                            } catch (a unused2) {
                                Log.e("DecodeProcessor", "decodeQRUseDetResHard AIScanException");
                                if ((w5Var != null || w5Var.k() == null) && b3.h) {
                                    try {
                                        iMax = (int) Math.max(y1Var.d(), 0.0f);
                                        iMax2 = (int) Math.max(y1Var.e(), 0.0f);
                                        int iMin = (int) Math.min(y1Var.f(), this.f4267a.c() - iMax);
                                        int iMin2 = (int) Math.min(y1Var.c(), this.f4267a.a() - iMax2);
                                        fArr = new float[8];
                                        bArrQRCornerDetect = LoadOpencvJNIUtil.QRCornerDetect(this.f4267a.a(iMax, iMax2, iMin, iMin2).b(), iMin, iMin2, fArr);
                                        if (bArrQRCornerDetect.length != 0) {
                                            s sVarA = a(bArrQRCornerDetect, 256, 256);
                                            p pVar2 = new p(new a3(null));
                                            pVar2.a(sVarA);
                                            w5VarA = i4Var.a(pVar2, map);
                                            if (w5VarA != null && w5VarA.k() != null) {
                                                y5VarArr = new y5[4];
                                                for (i = 0; i < 4; i++) {
                                                    int i2 = i * 2;
                                                    y5VarArr[i] = new y5(fArr[i2] + iMax, fArr[i2 + 1] + iMax2);
                                                }
                                                w5VarA.b(y5VarArr);
                                                return w5VarA;
                                            }
                                        }
                                    } catch (a unused3) {
                                        Log.e("DecodeProcessor", "decodeQRUseDetResHard AIScanException");
                                    }
                                }
                                return w5Var3;
                            }
                        }
                        if (w5Var != null) {
                            iMax = (int) Math.max(y1Var.d(), 0.0f);
                            iMax2 = (int) Math.max(y1Var.e(), 0.0f);
                            int iMin3 = (int) Math.min(y1Var.f(), this.f4267a.c() - iMax);
                            int iMin4 = (int) Math.min(y1Var.c(), this.f4267a.a() - iMax2);
                            fArr = new float[8];
                            bArrQRCornerDetect = LoadOpencvJNIUtil.QRCornerDetect(this.f4267a.a(iMax, iMax2, iMin3, iMin4).b(), iMin3, iMin4, fArr);
                            if (bArrQRCornerDetect.length != 0) {
                                s sVarA2 = a(bArrQRCornerDetect, 256, 256);
                                p pVar3 = new p(new a3(null));
                                pVar3.a(sVarA2);
                                w5VarA = i4Var.a(pVar3, map);
                                if (w5VarA != null) {
                                    y5VarArr = new y5[4];
                                    while (i < 4) {
                                        int i3 = i * 2;
                                        y5VarArr[i] = new y5(fArr[i3] + iMax, fArr[i3 + 1] + iMax2);
                                    }
                                    w5VarA.b(y5VarArr);
                                    return w5VarA;
                                }
                            }
                        } else {
                            iMax = (int) Math.max(y1Var.d(), 0.0f);
                            iMax2 = (int) Math.max(y1Var.e(), 0.0f);
                            int iMin5 = (int) Math.min(y1Var.f(), this.f4267a.c() - iMax);
                            int iMin6 = (int) Math.min(y1Var.c(), this.f4267a.a() - iMax2);
                            fArr = new float[8];
                            bArrQRCornerDetect = LoadOpencvJNIUtil.QRCornerDetect(this.f4267a.a(iMax, iMax2, iMin5, iMin6).b(), iMin5, iMin6, fArr);
                            if (bArrQRCornerDetect.length != 0) {
                                s sVarA3 = a(bArrQRCornerDetect, 256, 256);
                                p pVar4 = new p(new a3(null));
                                pVar4.a(sVarA3);
                                w5VarA = i4Var.a(pVar4, map);
                                if (w5VarA != null) {
                                    y5VarArr = new y5[4];
                                    while (i < 4) {
                                        int i4 = i * 2;
                                        y5VarArr[i] = new y5(fArr[i4] + iMax, fArr[i4 + 1] + iMax2);
                                    }
                                    w5VarA.b(y5VarArr);
                                    return w5VarA;
                                }
                            }
                        }
                        return w5Var3;
                    }
                }
                if (w5Var != null && w5Var.k() != null) {
                    a2.a(w5Var.j(), f, y1Var);
                    return w5Var;
                }
            }
            throw a.a();
        } catch (a unused4) {
            w5Var3 = w5Var2;
        }
    }

    public w5 a(Map<f1, Object> map) {
        y3 y3VarC;
        float f;
        i4 i4Var = new i4();
        y3 y3Var = this.f4267a;
        if (!b3.f4215a || (this.b.e() <= 800 && this.b.c() <= 800)) {
            y3VarC = y3Var;
            f = 1.0f;
        } else {
            float fMax = Math.max(this.b.e(), this.b.c()) / 800.0f;
            if (b3.c && (this.b.e() > this.b.c() * this.j || this.b.c() > this.b.e() * this.j)) {
                fMax = Math.min(this.b.e(), this.b.c()) / 860.0f;
            }
            y3VarC = this.i.d(this.b, fMax).a().c();
            f = fMax;
        }
        if (y3VarC == null) {
            return null;
        }
        p pVar = new p(new a3(y3VarC));
        o5.a(this.f4267a);
        try {
            if (b3.f4215a) {
                pVar.a(a(y3VarC.b(), y3VarC.c(), y3VarC.a()));
            }
            w5 w5VarA = i4Var.a(pVar, map);
            if (w5VarA != null && w5VarA.k() != null) {
                return a(w5VarA, f, 0, 0);
            }
            w5 w5Var = (w5VarA == null || w5VarA.j() == null || w5VarA.j().length < 3) ? null : new w5(null, null, w5VarA.j(), BarcodeFormat.QR_CODE);
            w5 w5Var2 = w5Var == null ? new w5(null, null, null, BarcodeFormat.QR_CODE) : w5Var;
            if (b3.c) {
                w5Var2 = a(i4Var, y3VarC, w5Var2, map, f, 0, 0);
            }
            if (w5Var2 != null && w5Var2.k() != null) {
                return w5Var2;
            }
            if (w5Var2 != null && w5Var2.j() != null) {
                w5Var = w5Var2;
            }
            if (!b3.c && w5Var != null && w5Var.j() != null && w5Var.j().length >= 3) {
                a(w5Var, f, 0, 0);
                float fA = i7.a(this.f4267a.c(), this.f4267a.a(), w5Var.j());
                if (Math.abs(1.0f - fA) > 0.001d) {
                    this.f = fA;
                    this.e = true;
                }
            }
            return w5Var;
        } catch (a unused) {
            Log.e("DecodeProcessor", "decodeQRUseFullImg AIScanException");
        }
    }

    private w5 a(i4 i4Var, y3 y3Var, w5 w5Var, Map<f1, Object> map, float f, int i, int i2) {
        w5 w5VarA;
        p pVar = null;
        if (!b3.f4215a) {
            return null;
        }
        try {
            try {
                p pVar2 = new p(new a3(y3Var));
                try {
                    w5 w5VarA2 = i4Var.a(pVar2, map);
                    if (w5VarA2 != null && w5VarA2.k() != null) {
                        return a(w5VarA2, f, i, i2);
                    }
                    if (w5VarA2 != null && w5VarA2.j() != null && w5VarA2.j().length >= 3) {
                        w5Var.b(w5VarA2.j());
                    }
                    pVar = pVar2;
                    if (w5Var != null) {
                        try {
                            if (w5Var.j() != null && w5Var.j().length >= 3 && !b3.i && (w5VarA = a(pVar, map, w5Var, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d})) != null && w5VarA.k() != null) {
                                return a(w5VarA, f, i, i2);
                            }
                        } catch (a unused) {
                            Log.e("DecodeProcessor", "decodeQRUseFullImgTryHard AIScanException");
                        }
                    }
                    return a(pVar, i4Var, y3Var, w5Var, map, f);
                } catch (a unused2) {
                    pVar = pVar2;
                    Log.e("DecodeProcessor", "decodeQRUseFullImgTryHard AIScanException");
                }
            } catch (a unused3) {
            }
        } catch (a unused4) {
        }
    }

    private w5 a(p pVar, i4 i4Var, y3 y3Var, w5 w5Var, Map<f1, Object> map, float f) {
        w5 w5VarA = null;
        try {
            o5.a(this.f4267a, w5Var);
            if (b3.c && b3.r[1]) {
                b3.o = true;
                w5VarA = i4Var.a(this.b, map);
                b3.o = false;
                if (w5VarA != null && w5VarA.k() != null) {
                    return a(w5VarA, f, 0, 0);
                }
            }
        } catch (a unused) {
            b3.o = false;
        }
        float fE = pVar.e() / pVar.c();
        if (fE < 1.0f) {
            fE = 1.0f / fE;
        }
        if (!b3.i && !b3.j) {
            double d = fE;
            if (d > 1.27d && d < 1.272d) {
                b3.q = true;
                try {
                    w5VarA = i4Var.a(new p(new n3(y3Var)), map);
                    if (w5VarA != null && w5VarA.k() != null) {
                        return a(w5VarA, f, 0, 0);
                    }
                } catch (a unused2) {
                    Log.e("DecodeProcessor", "decodeQRUseFullImgTryHardSpecialCase AIScanException");
                }
                b3.q = false;
            }
        }
        return w5VarA;
    }

    private w5 a(i4 i4Var, y3 y3Var, p pVar, Map<f1, Object> map, float f, y1 y1Var) throws a {
        p pVar2;
        w5 w5VarA = null;
        if (b3.f4215a && !b3.b) {
            try {
                pVar2 = new p(new a3(y3Var));
                try {
                    w5 w5VarA2 = i4Var.a(pVar2, map);
                    if (w5VarA2 != null) {
                        try {
                            if (w5VarA2.k() != null) {
                                a2.a(w5VarA2.j(), f, y1Var);
                                return w5VarA2;
                            }
                        } catch (a unused) {
                            w5VarA = w5VarA2;
                            pVar = pVar2;
                            Log.e("DecodeProcessor", "decodeQRMultiHard AIScanException");
                            pVar2 = pVar;
                        }
                    }
                    w5VarA = w5VarA2;
                } catch (a unused2) {
                }
            } catch (a unused3) {
            }
            if (w5VarA != null && w5VarA.j() != null && w5VarA.j().length >= 3) {
                try {
                    w5VarA = a(pVar2, map, w5VarA, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d});
                    if (w5VarA != null && w5VarA.k() != null) {
                        a2.a(w5VarA.j(), f, y1Var);
                        return w5VarA;
                    }
                } catch (a unused4) {
                    Log.e("DecodeProcessor", "decodeQRMultiHard AIScanException");
                }
            }
        }
        p pVar3 = new p(new n3(y3Var));
        try {
            w5 w5VarA3 = i4Var.a(pVar3, map);
            if (w5VarA3 != null && w5VarA3.k() != null) {
                a2.a(w5VarA3.j(), f, y1Var);
                return w5VarA3;
            }
            throw a.a();
        } catch (a unused5) {
            if (b3.f4215a && !b3.b && w5VarA != null && w5VarA.j() != null && w5VarA.j().length >= 3 && (w5VarA = a(pVar3, map, w5VarA, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d})) != null && w5VarA.k() != null) {
                a2.a(w5VarA.j(), f, y1Var);
            }
            return w5VarA;
        }
    }

    public w5 a(List<BarcodeFormat> list, y1 y1Var) {
        w5 w5VarA;
        i4 i4Var = new i4();
        HashMap map = new HashMap();
        map.put(f1.POSSIBLE_FORMATS, list);
        if (b3.c) {
            map.put(f1.PHOTO_MODE, Boolean.valueOf(b3.c));
        }
        try {
            if (y1Var != null) {
                w5VarA = i4Var.a(this.b, this.d, map, this.i, y1Var);
            } else {
                w5VarA = i4Var.a(this.b, (p) null, map, this.i, (y1) null);
            }
        } catch (a unused) {
            Log.e("DecodeProcessor", "decode1d AIScanException");
            w5VarA = null;
        }
        w5 w5Var = w5VarA;
        if (w5Var != null || b3.b || y1Var == null || !b3.c || y1Var.h() >= 0.8d) {
            return w5Var;
        }
        float fI = y1Var.i() % 180.0f;
        boolean z = true;
        boolean z2 = ((double) y1Var.c()) > ((double) this.b.c()) * 0.97d && ((fI < 5.0f && fI > -5.0f) || fI < -175.0f || fI > 175.0f);
        if (y1Var.b() <= ((double) this.b.e()) * 0.97d || ((fI >= 95.0f || fI <= 85.0f) && (fI >= -85.0f || fI <= -95.0f))) {
            z = false;
        }
        if (!z2 && !z) {
            return w5Var;
        }
        this.i.a();
        try {
            return i4Var.a(this.b, (p) null, map, this.i, (y1) null);
        } catch (a unused2) {
            Log.e("DecodeProcessor", "decode1d AIScanException");
            return w5Var;
        }
    }

    public List<y1> a(int i, boolean z) {
        List<y1> listA;
        p pVar;
        ArrayList arrayList = new ArrayList();
        if (!b3.f4215a) {
            return arrayList;
        }
        boolean z2 = b3.b;
        if (!z2) {
            byte[] bArrC = g4.c();
            byte[] bArrA = g4.a();
            byte[] bArrB = g4.b();
            LoadOpencvJNIUtil.setModel(bArrC, bArrC.length, bArrA, bArrA.length, bArrB, bArrB.length);
            p pVarA = this.b;
            long jCurrentTimeMillis = System.currentTimeMillis() % 10;
            boolean z3 = jCurrentTimeMillis % 2 == 0;
            boolean z4 = jCurrentTimeMillis % 3 == 0;
            if (i == 0 && !b3.c && z3) {
                pVarA = b(this.b);
            } else if (i == 0 && !b3.c && z4) {
                pVarA = a(b(this.b));
            } else {
                float fA = this.f4267a.a() / this.f4267a.c();
                if (fA > 1.35d) {
                    int iA = (int) (this.f4267a.a() / 1.3f);
                    this.l = 0;
                    this.k = (-(iA - this.f4267a.c())) / 2;
                    y3 y3Var = this.f4267a;
                    pVar = new p(new a3(y3Var.b(iA, y3Var.a(), -this.k, -this.l)));
                } else if (1.0f / fA > 1.35d) {
                    int iC = (int) (this.f4267a.c() / 1.3f);
                    this.l = (-(iC - this.f4267a.a())) / 2;
                    this.k = 0;
                    y3 y3Var2 = this.f4267a;
                    pVar = new p(new a3(y3Var2.b(y3Var2.c(), iC, -this.k, -this.l)));
                }
                pVarA = pVar;
            }
            listA = a2.a(b3.b, pVarA, i, z);
        } else {
            listA = a2.a(z2, this.b, i, z);
        }
        List<y1> list = listA;
        a(list);
        return list;
    }

    private p a(p pVar) {
        int iE = pVar.e();
        int iC = pVar.c();
        int i = (int) (((double) iE) * 0.75d);
        int i2 = (int) (((double) iC) * 0.75d);
        int i3 = (iE - i) / 2;
        this.k += i3;
        int i4 = (iC - i2) / 2;
        this.l += i4;
        return pVar.a(i3, i4, i, i2);
    }

    private void a(List<y1> list) {
        for (y1 y1Var : list) {
            y1Var.a(this.f4267a.c(), this.f4267a.a(), this.k, this.l);
            float fMin = Math.min(Math.abs(y1Var.i() % 90.0f), 90.0f - Math.abs(y1Var.i() % 90.0f));
            if (y1Var.c() * y1Var.f() > this.f4267a.a() * 0.9f * this.f4267a.c() && fMin < 5.0f) {
                y1Var.b(this.f4267a.c(), this.f4267a.a());
            }
        }
    }

    public void a(y1 y1Var) {
        try {
            if (b3.f4215a) {
                a2.a(b3.b, this.b, y1Var);
                this.d = y1Var.l;
            }
        } catch (a unused) {
            Log.e("DecodeProcessor", "cropAndRotate AIScanException");
        }
    }

    private w5 a(p pVar, Map<f1, Object> map, w5 w5Var, double[] dArr) throws a {
        w5 w5VarA;
        if (pVar == null) {
            return null;
        }
        i4 i4Var = new i4();
        int[] iArr = {0, 0};
        byte[] bArrA = m6.a(pVar, map, w5Var, iArr, dArr);
        int i = iArr[0];
        int i2 = iArr[1];
        j5 j5Var = new j5(bArrA, i, i2, 0, 0, i, i2, false);
        try {
            w5VarA = i4Var.a(new p(new a3(j5Var)), map);
            if (w5VarA != null) {
                try {
                    if (w5VarA.k() != null) {
                        y5[] y5VarArrA = m6.a(w5VarA.j(), pVar.e(), pVar.c(), dArr);
                        w5VarA.a();
                        w5VarA.b(y5VarArrA);
                        return w5VarA;
                    }
                } catch (a unused) {
                    p pVar2 = new p(new n3(j5Var));
                    try {
                        w5 w5VarA2 = i4Var.a(pVar2, map);
                        if (w5VarA2 != null && w5VarA2.k() != null) {
                            y5[] y5VarArrA2 = m6.a(w5VarA2.j(), pVar.e(), pVar.c(), dArr);
                            w5VarA2.a();
                            w5VarA2.b(y5VarArrA2);
                            return w5VarA2;
                        }
                        throw a.a();
                    } catch (a unused2) {
                        pVar2.a(a(j5Var.b(), j5Var.c(), j5Var.a()));
                        try {
                            w5 w5VarA3 = i4Var.a(pVar2, map);
                            if (w5VarA3 != null && w5VarA3.k() != null) {
                                y5[] y5VarArrA3 = m6.a(w5VarA3.j(), pVar.e(), pVar.c(), dArr);
                                w5VarA3.a();
                                w5VarA3.b(y5VarArrA3);
                                return w5VarA3;
                            }
                            throw a.a();
                        } catch (a unused3) {
                            Log.e("DecodeProcessor", "rotatedQRBinarizer  AIScanException");
                            return w5VarA;
                        }
                    }
                }
            }
            throw a.a();
        } catch (a unused4) {
            w5VarA = w5Var;
        }
    }

    private w5 a(w5 w5Var, float f, int i, int i2) {
        if (w5Var != null && w5Var.j().length == 4 && (Math.abs(f - 1.0f) >= 1.0E-6f || i != 0 || i2 != 0)) {
            y5[] y5VarArr = new y5[4];
            for (int i3 = 0; i3 < 4; i3++) {
                y5VarArr[i3] = new y5((w5Var.j()[i3].b() * f) + i, (w5Var.j()[i3].c() * f) + i2);
            }
            w5Var.a();
            w5Var.a(y5VarArr);
        }
        return w5Var;
    }

    public static s a(byte[] bArr, int i, int i2) throws a {
        byte[] bArrAdaptivebinary = LoadOpencvJNIUtil.adaptivebinary(bArr, i2, i, 45);
        if (bArrAdaptivebinary != null) {
            s sVar = new s(i, i2);
            for (int i3 = 0; i3 < i2; i3++) {
                for (int i4 = 0; i4 < i; i4++) {
                    if (bArrAdaptivebinary[(i3 * i) + i4] == 0) {
                        sVar.c(i4, i3);
                    }
                }
            }
            return sVar;
        }
        throw a.a();
    }

    private static boolean a(p pVar, y1 y1Var) {
        if (b3.f4215a && !b3.b) {
            float fD = y1Var.d();
            float fE = y1Var.e();
            float f = y1Var.f();
            float fC = y1Var.c();
            float f2 = fD - ((f * 0.2f) / 2.0f);
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            float f3 = fE - ((0.2f * fC) / 2.0f);
            float f4 = f3 >= 0.0f ? f3 : 0.0f;
            float fE2 = (f * 1.2f) + f2;
            if (fE2 > pVar.e()) {
                fE2 = pVar.e();
            }
            float fC2 = (fC * 1.2f) + f4;
            if (fC2 > pVar.c()) {
                fC2 = pVar.c();
            }
            float f5 = fE2 - f2;
            float f6 = fC2 - f4;
            if (f5 < pVar.e() / 2.0f && f6 < pVar.c() / 2.0f) {
                for (y1 y1Var2 : a2.a(b3.b, pVar.a((int) f2, (int) f4, (int) f5, (int) f6), 0, true)) {
                    boolean z = y1Var2.g() == 1.0f && ((double) y1Var2.h()) > 0.5d;
                    boolean z2 = y1Var.g() == 2.0f && y1Var2.g() == 2.0f && ((double) y1Var2.h()) > 0.7d;
                    boolean z3 = y1Var.g() == 3.0f && y1Var2.g() == 3.0f && ((double) y1Var2.h()) > 0.7d;
                    if (z || z2 || z3) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}
