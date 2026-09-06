package com.jd.ad.sdk.jad_ox;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.jd.ad.sdk.jad_lu.jad_re;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_pc {
    public final Matrix jad_an = new Matrix();
    public final Matrix jad_bo;
    public final Matrix jad_cp;
    public final Matrix jad_dq;
    public final float[] jad_er;
    public jad_an<PointF, PointF> jad_fs;
    public jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_hu;
    public jad_an<Float, Float> jad_iv;
    public jad_an<?, PointF> jad_jt;
    public jad_an<Integer, Integer> jad_jw;
    public jad_dq jad_kx;
    public jad_dq jad_ly;
    public jad_an<?, Float> jad_mz;
    public jad_an<?, Float> jad_na;

    public jad_pc(com.jd.ad.sdk.jad_ra.jad_ly jad_lyVar) {
        this.jad_fs = jad_lyVar.jad_bo() == null ? null : jad_lyVar.jad_bo().jad_an();
        this.jad_jt = jad_lyVar.jad_er() == null ? null : jad_lyVar.jad_er().jad_an();
        this.jad_hu = jad_lyVar.jad_jt() == null ? null : jad_lyVar.jad_jt().jad_an();
        this.jad_iv = jad_lyVar.jad_fs() == null ? null : jad_lyVar.jad_fs().jad_an();
        jad_dq jad_dqVar = jad_lyVar.jad_hu() == null ? null : (jad_dq) jad_lyVar.jad_hu().jad_an();
        this.jad_kx = jad_dqVar;
        if (jad_dqVar != null) {
            this.jad_bo = new Matrix();
            this.jad_cp = new Matrix();
            this.jad_dq = new Matrix();
            this.jad_er = new float[9];
        } else {
            this.jad_bo = null;
            this.jad_cp = null;
            this.jad_dq = null;
            this.jad_er = null;
        }
        this.jad_ly = jad_lyVar.jad_iv() == null ? null : (jad_dq) jad_lyVar.jad_iv().jad_an();
        if (jad_lyVar.jad_dq() != null) {
            this.jad_jw = jad_lyVar.jad_dq().jad_an();
        }
        if (jad_lyVar.jad_jw() != null) {
            this.jad_mz = jad_lyVar.jad_jw().jad_an();
        } else {
            this.jad_mz = null;
        }
        if (jad_lyVar.jad_cp() != null) {
            this.jad_na = jad_lyVar.jad_cp().jad_an();
        } else {
            this.jad_na = null;
        }
    }

    public final void jad_an() {
        for (int i = 0; i < 9; i++) {
            this.jad_er[i] = 0.0f;
        }
    }

    public void jad_an(jad_an.InterfaceC0570jad_an interfaceC0570jad_an) {
        jad_an<Integer, Integer> jad_anVar = this.jad_jw;
        if (jad_anVar != null) {
            jad_anVar.jad_an.add(interfaceC0570jad_an);
        }
        jad_an<?, Float> jad_anVar2 = this.jad_mz;
        if (jad_anVar2 != null) {
            jad_anVar2.jad_an.add(interfaceC0570jad_an);
        }
        jad_an<?, Float> jad_anVar3 = this.jad_na;
        if (jad_anVar3 != null) {
            jad_anVar3.jad_an.add(interfaceC0570jad_an);
        }
        jad_an<PointF, PointF> jad_anVar4 = this.jad_fs;
        if (jad_anVar4 != null) {
            jad_anVar4.jad_an.add(interfaceC0570jad_an);
        }
        jad_an<?, PointF> jad_anVar5 = this.jad_jt;
        if (jad_anVar5 != null) {
            jad_anVar5.jad_an.add(interfaceC0570jad_an);
        }
        jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_anVar6 = this.jad_hu;
        if (jad_anVar6 != null) {
            jad_anVar6.jad_an.add(interfaceC0570jad_an);
        }
        jad_an<Float, Float> jad_anVar7 = this.jad_iv;
        if (jad_anVar7 != null) {
            jad_anVar7.jad_an.add(interfaceC0570jad_an);
        }
        jad_dq jad_dqVar = this.jad_kx;
        if (jad_dqVar != null) {
            jad_dqVar.jad_an.add(interfaceC0570jad_an);
        }
        jad_dq jad_dqVar2 = this.jad_ly;
        if (jad_dqVar2 != null) {
            jad_dqVar2.jad_an.add(interfaceC0570jad_an);
        }
    }

    public void jad_an(com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        jad_anVar.jad_an(this.jad_jw);
        jad_anVar.jad_an(this.jad_mz);
        jad_anVar.jad_an(this.jad_na);
        jad_anVar.jad_an(this.jad_fs);
        jad_anVar.jad_an(this.jad_jt);
        jad_anVar.jad_an(this.jad_hu);
        jad_anVar.jad_an(this.jad_iv);
        jad_anVar.jad_an(this.jad_kx);
        jad_anVar.jad_an(this.jad_ly);
    }

    public Matrix jad_bo() {
        this.jad_an.reset();
        jad_an<?, PointF> jad_anVar = this.jad_jt;
        if (jad_anVar != null) {
            PointF pointFJad_fs = jad_anVar.jad_fs();
            float f = pointFJad_fs.x;
            if (f != 0.0f || pointFJad_fs.y != 0.0f) {
                this.jad_an.preTranslate(f, pointFJad_fs.y);
            }
        }
        jad_an<Float, Float> jad_anVar2 = this.jad_iv;
        if (jad_anVar2 != null) {
            float fFloatValue = jad_anVar2 instanceof jad_qd ? jad_anVar2.jad_fs().floatValue() : ((jad_dq) jad_anVar2).jad_hu();
            if (fFloatValue != 0.0f) {
                this.jad_an.preRotate(fFloatValue);
            }
        }
        jad_dq jad_dqVar = this.jad_kx;
        if (jad_dqVar != null) {
            jad_dq jad_dqVar2 = this.jad_ly;
            float fCos = jad_dqVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-jad_dqVar2.jad_hu()) + 90.0f));
            jad_dq jad_dqVar3 = this.jad_ly;
            float fSin = jad_dqVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-jad_dqVar3.jad_hu()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(jad_dqVar.jad_hu()));
            jad_an();
            float[] fArr = this.jad_er;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.jad_bo.setValues(fArr);
            jad_an();
            float[] fArr2 = this.jad_er;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.jad_cp.setValues(fArr2);
            jad_an();
            float[] fArr3 = this.jad_er;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.jad_dq.setValues(fArr3);
            this.jad_cp.preConcat(this.jad_bo);
            this.jad_dq.preConcat(this.jad_cp);
            this.jad_an.preConcat(this.jad_dq);
        }
        jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_anVar3 = this.jad_hu;
        if (jad_anVar3 != null) {
            com.jd.ad.sdk.jad_yh.jad_dq jad_dqVarJad_fs = jad_anVar3.jad_fs();
            float f3 = jad_dqVarJad_fs.jad_an;
            if (f3 != 1.0f || jad_dqVarJad_fs.jad_bo != 1.0f) {
                this.jad_an.preScale(f3, jad_dqVarJad_fs.jad_bo);
            }
        }
        jad_an<PointF, PointF> jad_anVar4 = this.jad_fs;
        if (jad_anVar4 != null) {
            PointF pointFJad_fs2 = jad_anVar4.jad_fs();
            float f4 = pointFJad_fs2.x;
            if (f4 != 0.0f || pointFJad_fs2.y != 0.0f) {
                this.jad_an.preTranslate(-f4, -pointFJad_fs2.y);
            }
        }
        return this.jad_an;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> boolean jad_an(T t, com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        jad_dq jad_dqVar;
        jad_an jad_anVar;
        if (t == jad_re.jad_fs) {
            jad_anVar = this.jad_fs;
            if (jad_anVar == null) {
                this.jad_fs = new jad_qd(jad_cpVar, new PointF());
                return true;
            }
        } else if (t == jad_re.jad_jt) {
            jad_anVar = this.jad_jt;
            if (jad_anVar == null) {
                this.jad_jt = new jad_qd(jad_cpVar, new PointF());
                return true;
            }
        } else {
            if (t == jad_re.jad_hu) {
                jad_an<?, PointF> jad_anVar2 = this.jad_jt;
                if (jad_anVar2 instanceof jad_na) {
                    ((jad_na) jad_anVar2).jad_mz = jad_cpVar;
                    return true;
                }
            }
            if (t == jad_re.jad_iv) {
                jad_an<?, PointF> jad_anVar3 = this.jad_jt;
                if (jad_anVar3 instanceof jad_na) {
                    ((jad_na) jad_anVar3).jad_na = jad_cpVar;
                    return true;
                }
            }
            if (t == jad_re.jad_ob) {
                jad_anVar = this.jad_hu;
                if (jad_anVar == null) {
                    this.jad_hu = new jad_qd(jad_cpVar, new com.jd.ad.sdk.jad_yh.jad_dq());
                    return true;
                }
            } else if (t == jad_re.jad_pc) {
                jad_anVar = this.jad_iv;
                if (jad_anVar == null) {
                    this.jad_iv = new jad_qd(jad_cpVar, Float.valueOf(0.0f));
                    return true;
                }
            } else if (t == jad_re.jad_cp) {
                jad_anVar = this.jad_jw;
                if (jad_anVar == null) {
                    this.jad_jw = new jad_qd(jad_cpVar, 100);
                    return true;
                }
            } else if (t == jad_re.jad_ep) {
                jad_anVar = this.jad_mz;
                if (jad_anVar == null) {
                    this.jad_mz = new jad_qd(jad_cpVar, Float.valueOf(100.0f));
                    return true;
                }
            } else {
                if (t != jad_re.jad_fq) {
                    if (t == jad_re.jad_qd) {
                        if (this.jad_kx == null) {
                            this.jad_kx = new jad_dq(Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(Float.valueOf(0.0f))));
                        }
                        jad_dqVar = this.jad_kx;
                    } else {
                        if (t != jad_re.jad_re) {
                            return false;
                        }
                        if (this.jad_ly == null) {
                            this.jad_ly = new jad_dq(Collections.singletonList(new com.jd.ad.sdk.jad_yh.jad_an(Float.valueOf(0.0f))));
                        }
                        jad_dqVar = this.jad_ly;
                    }
                    jad_dqVar.jad_er = jad_cpVar;
                    return true;
                }
                jad_anVar = this.jad_na;
                if (jad_anVar == null) {
                    this.jad_na = new jad_qd(jad_cpVar, Float.valueOf(100.0f));
                    return true;
                }
            }
        }
        jad_anVar.jad_er = jad_cpVar;
        return true;
    }

    public Matrix jad_an(float f) {
        jad_an<?, PointF> jad_anVar = this.jad_jt;
        PointF pointFJad_fs = jad_anVar == null ? null : jad_anVar.jad_fs();
        jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_anVar2 = this.jad_hu;
        com.jd.ad.sdk.jad_yh.jad_dq jad_dqVarJad_fs = jad_anVar2 == null ? null : jad_anVar2.jad_fs();
        this.jad_an.reset();
        if (pointFJad_fs != null) {
            this.jad_an.preTranslate(pointFJad_fs.x * f, pointFJad_fs.y * f);
        }
        if (jad_dqVarJad_fs != null) {
            double d = f;
            this.jad_an.preScale((float) Math.pow(jad_dqVarJad_fs.jad_an, d), (float) Math.pow(jad_dqVarJad_fs.jad_bo, d));
        }
        jad_an<Float, Float> jad_anVar3 = this.jad_iv;
        if (jad_anVar3 != null) {
            float fFloatValue = jad_anVar3.jad_fs().floatValue();
            jad_an<PointF, PointF> jad_anVar4 = this.jad_fs;
            PointF pointFJad_fs2 = jad_anVar4 != null ? jad_anVar4.jad_fs() : null;
            this.jad_an.preRotate(fFloatValue * f, pointFJad_fs2 == null ? 0.0f : pointFJad_fs2.x, pointFJad_fs2 != null ? pointFJad_fs2.y : 0.0f);
        }
        return this.jad_an;
    }
}
