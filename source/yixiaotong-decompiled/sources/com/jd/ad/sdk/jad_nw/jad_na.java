package com.jd.ad.sdk.jad_nw;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_na implements jad_mz, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an, jad_kx {
    public final String jad_bo;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_cp;
    public final int jad_dq;
    public final boolean jad_er;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_hu;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_iv;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, PointF> jad_jt;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_jw;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_kx;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_ly;
    public boolean jad_na;
    public final Path jad_an = new Path();
    public final jad_bo jad_mz = new jad_bo();

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(2).length];
            jad_an = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public jad_na(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_kx jad_kxVar) {
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an;
        this.jad_cp = jad_mzVar;
        this.jad_bo = jad_kxVar.jad_cp();
        int iJad_iv = jad_kxVar.jad_iv();
        this.jad_dq = iJad_iv;
        this.jad_er = jad_kxVar.jad_jw();
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an2 = jad_kxVar.jad_fs().jad_an();
        this.jad_fs = jad_anVarJad_an2;
        com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_anVarJad_an3 = jad_kxVar.jad_jt().jad_an();
        this.jad_jt = jad_anVarJad_an3;
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an4 = jad_kxVar.jad_hu().jad_an();
        this.jad_hu = jad_anVarJad_an4;
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an5 = jad_kxVar.jad_dq().jad_an();
        this.jad_jw = jad_anVarJad_an5;
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an6 = jad_kxVar.jad_er().jad_an();
        this.jad_ly = jad_anVarJad_an6;
        if (iJad_iv == 1) {
            this.jad_iv = jad_kxVar.jad_an().jad_an();
            jad_anVarJad_an = jad_kxVar.jad_bo().jad_an();
        } else {
            jad_anVarJad_an = null;
            this.jad_iv = null;
        }
        this.jad_kx = jad_anVarJad_an;
        jad_anVar.jad_an(jad_anVarJad_an2);
        jad_anVar.jad_an(jad_anVarJad_an3);
        jad_anVar.jad_an(jad_anVarJad_an4);
        jad_anVar.jad_an(jad_anVarJad_an5);
        jad_anVar.jad_an(jad_anVarJad_an6);
        if (iJad_iv == 1) {
            jad_anVar.jad_an(this.jad_iv);
            jad_anVar.jad_an(this.jad_kx);
        }
        jad_anVarJad_an2.jad_an(this);
        jad_anVarJad_an3.jad_an(this);
        jad_anVarJad_an4.jad_an(this);
        jad_anVarJad_an5.jad_an(this);
        jad_anVarJad_an6.jad_an(this);
        if (iJad_iv == 1) {
            this.jad_iv.jad_an(this);
            this.jad_kx.jad_an(this);
        }
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_an jad_anVar;
        com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar2;
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_wj) {
            jad_anVar = this.jad_fs;
        } else if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_xk) {
            jad_anVar = this.jad_hu;
        } else {
            if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_na) {
                if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_yl || (jad_anVar2 = this.jad_iv) == null) {
                    if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_zm) {
                        jad_anVar = this.jad_jw;
                    } else if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_cn || (jad_anVar2 = this.jad_kx) == null) {
                        if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_do) {
                            return;
                        } else {
                            jad_anVar = this.jad_ly;
                        }
                    }
                }
                jad_anVar2.jad_er = jad_cpVar;
                return;
            }
            jad_anVar = this.jad_jt;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public Path jad_bo() {
        float fSin;
        float f;
        double d;
        float fCos;
        float f2;
        float f3;
        float f4;
        float f5;
        if (this.jad_na) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (this.jad_er) {
            this.jad_na = true;
            return this.jad_an;
        }
        int i = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(this.jad_dq)];
        float f6 = 0.0f;
        if (i == 1) {
            float fFloatValue = this.jad_fs.jad_fs().floatValue();
            com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar = this.jad_hu;
            double radians = Math.toRadians((jad_anVar != null ? jad_anVar.jad_fs().floatValue() : 0.0d) - 90.0d);
            double d2 = fFloatValue;
            float f7 = (float) (6.283185307179586d / d2);
            float f8 = f7 / 2.0f;
            float f9 = fFloatValue - ((int) fFloatValue);
            if (f9 != 0.0f) {
                radians += (double) ((1.0f - f9) * f8);
            }
            float fFloatValue2 = this.jad_jw.jad_fs().floatValue();
            float fFloatValue3 = this.jad_iv.jad_fs().floatValue();
            com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar2 = this.jad_kx;
            float fFloatValue4 = jad_anVar2 != null ? jad_anVar2.jad_fs().floatValue() / 100.0f : 0.0f;
            com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar3 = this.jad_ly;
            float fFloatValue5 = jad_anVar3 != null ? jad_anVar3.jad_fs().floatValue() / 100.0f : 0.0f;
            if (f9 != 0.0f) {
                float f10 = ((fFloatValue2 - fFloatValue3) * f9) + fFloatValue3;
                double d3 = f10;
                f2 = f10;
                fCos = (float) (Math.cos(radians) * d3);
                float fSin2 = (float) (d3 * Math.sin(radians));
                this.jad_an.moveTo(fCos, fSin2);
                d = radians + ((double) ((f7 * f9) / 2.0f));
                f = f8;
                fSin = fSin2;
            } else {
                double d4 = fFloatValue2;
                float fCos2 = (float) (Math.cos(radians) * d4);
                fSin = (float) (d4 * Math.sin(radians));
                this.jad_an.moveTo(fCos2, fSin);
                f = f8;
                d = radians + ((double) f);
                fCos = fCos2;
                f2 = 0.0f;
            }
            double dCeil = Math.ceil(d2) * 2.0d;
            float f11 = fCos;
            int i2 = 0;
            boolean z = false;
            while (true) {
                double d5 = i2;
                if (d5 >= dCeil) {
                    break;
                }
                float f12 = z ? fFloatValue2 : fFloatValue3;
                float f13 = (f2 == 0.0f || d5 != dCeil - 2.0d) ? f : (f7 * f9) / 2.0f;
                double d6 = (f2 == 0.0f || d5 != dCeil - 1.0d) ? f12 : f2;
                double d7 = dCeil;
                float fCos3 = (float) (Math.cos(d) * d6);
                float fSin3 = (float) (Math.sin(d) * d6);
                if (fFloatValue4 == 0.0f && fFloatValue5 == 0.0f) {
                    this.jad_an.lineTo(fCos3, fSin3);
                    f3 = fFloatValue2;
                    f4 = fFloatValue5;
                    f5 = fFloatValue4;
                } else {
                    f3 = fFloatValue2;
                    double dAtan2 = (float) (Math.atan2(fSin, f11) - 1.5707963267948966d);
                    float fCos4 = (float) Math.cos(dAtan2);
                    float fSin4 = (float) Math.sin(dAtan2);
                    f4 = fFloatValue5;
                    f5 = fFloatValue4;
                    double dAtan3 = (float) (Math.atan2(fSin3, fCos3) - 1.5707963267948966d);
                    float fCos5 = (float) Math.cos(dAtan3);
                    float fSin5 = (float) Math.sin(dAtan3);
                    float f14 = z ? f5 : f4;
                    float f15 = z ? f4 : f5;
                    float f16 = (z ? fFloatValue3 : f3) * f14 * 0.47829f;
                    float f17 = fCos4 * f16;
                    float f18 = f16 * fSin4;
                    float f19 = (z ? f3 : fFloatValue3) * f15 * 0.47829f;
                    float f20 = fCos5 * f19;
                    float f21 = f19 * fSin5;
                    if (f9 != 0.0f) {
                        if (i2 == 0) {
                            f17 *= f9;
                            f18 *= f9;
                        } else if (d5 == d7 - 1.0d) {
                            f20 *= f9;
                            f21 *= f9;
                        }
                    }
                    this.jad_an.cubicTo(f11 - f17, fSin - f18, fCos3 + f20, fSin3 + f21, fCos3, fSin3);
                }
                d += (double) f13;
                z = !z;
                i2++;
                f11 = fCos3;
                fSin = fSin3;
                fFloatValue2 = f3;
                f7 = f7;
                f = f;
                fFloatValue4 = f5;
                fFloatValue5 = f4;
                dCeil = d7;
            }
            PointF pointFJad_fs = this.jad_jt.jad_fs();
            this.jad_an.offset(pointFJad_fs.x, pointFJad_fs.y);
            this.jad_an.close();
        } else if (i == 2) {
            int iFloor = (int) Math.floor(this.jad_fs.jad_fs().floatValue());
            com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar4 = this.jad_hu;
            double radians2 = Math.toRadians((jad_anVar4 != null ? jad_anVar4.jad_fs().floatValue() : 0.0d) - 90.0d);
            double d8 = iFloor;
            float fFloatValue6 = this.jad_ly.jad_fs().floatValue() / 100.0f;
            float fFloatValue7 = this.jad_jw.jad_fs().floatValue();
            double d9 = fFloatValue7;
            float fCos6 = (float) (Math.cos(radians2) * d9);
            float fSin6 = (float) (Math.sin(radians2) * d9);
            this.jad_an.moveTo(fCos6, fSin6);
            double d10 = (float) (6.283185307179586d / d8);
            double d11 = radians2 + d10;
            double dCeil2 = Math.ceil(d8);
            float f22 = fCos6;
            int i3 = 0;
            while (i3 < dCeil2) {
                float fCos7 = (float) (Math.cos(d11) * d9);
                double d12 = dCeil2;
                float fSin7 = (float) (Math.sin(d11) * d9);
                if (fFloatValue6 != f6) {
                    double dAtan4 = (float) (Math.atan2(fSin6, f22) - 1.5707963267948966d);
                    float fCos8 = (float) Math.cos(dAtan4);
                    float fSin8 = (float) Math.sin(dAtan4);
                    double dAtan5 = (float) (Math.atan2(fSin7, fCos7) - 1.5707963267948966d);
                    float f23 = fFloatValue7 * fFloatValue6 * 0.25f;
                    this.jad_an.cubicTo(f22 - (fCos8 * f23), fSin6 - (fSin8 * f23), fCos7 + (((float) Math.cos(dAtan5)) * f23), fSin7 + (f23 * ((float) Math.sin(dAtan5))), fCos7, fSin7);
                } else {
                    this.jad_an.lineTo(fCos7, fSin7);
                }
                d11 += d10;
                i3++;
                f22 = fCos7;
                fSin6 = fSin7;
                dCeil2 = d12;
                d9 = d9;
                f6 = 0.0f;
            }
            PointF pointFJad_fs2 = this.jad_jt.jad_fs();
            this.jad_an.offset(pointFJad_fs2.x, pointFJad_fs2.y);
            this.jad_an.close();
        }
        this.jad_an.close();
        this.jad_mz.jad_an(this.jad_an);
        this.jad_na = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an
    public void jad_an() {
        this.jad_na = false;
        this.jad_cp.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i = 0; i < list.size(); i++) {
            jad_cp jad_cpVar = list.get(i);
            if (jad_cpVar instanceof jad_sf) {
                jad_sf jad_sfVar = (jad_sf) jad_cpVar;
                if (jad_sfVar.jad_dq == 1) {
                    this.jad_mz.jad_an.add(jad_sfVar);
                    jad_sfVar.jad_cp.add(this);
                }
            }
        }
    }
}
