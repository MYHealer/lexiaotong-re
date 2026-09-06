package com.jd.ad.sdk.jad_nw;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.jd.ad.sdk.jad_sb.jad_tg;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_iv extends jad_an {
    public final com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_cn;
    public com.jd.ad.sdk.jad_ox.jad_qd jad_do;
    public final String jad_re;
    public final boolean jad_sf;
    public final LongSparseArray<LinearGradient> jad_tg;
    public final LongSparseArray<RadialGradient> jad_uh;
    public final RectF jad_vi;
    public final int jad_wj;
    public final int jad_xk;
    public final com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_dq, com.jd.ad.sdk.jad_sb.jad_dq> jad_yl;
    public final com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_zm;

    public jad_iv(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_fs jad_fsVar) {
        super(jad_mzVar, jad_anVar, com.jd.ad.sdk.jad_sb.jad_sf.jad_an(jad_fsVar.jad_an()), jad_tg.jad_an(jad_fsVar.jad_fs()), jad_fsVar.jad_hu(), jad_fsVar.jad_jw(), jad_fsVar.jad_ly(), jad_fsVar.jad_jt(), jad_fsVar.jad_bo());
        this.jad_tg = new LongSparseArray<>();
        this.jad_uh = new LongSparseArray<>();
        this.jad_vi = new RectF();
        this.jad_re = jad_fsVar.jad_iv();
        this.jad_wj = jad_fsVar.jad_er();
        this.jad_sf = jad_fsVar.jad_mz();
        this.jad_xk = (int) (jad_mzVar.jad_dq().jad_an() / 32.0f);
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_sb.jad_dq, com.jd.ad.sdk.jad_sb.jad_dq> jad_anVarJad_an = jad_fsVar.jad_dq().jad_an();
        this.jad_yl = jad_anVarJad_an;
        jad_anVarJad_an.jad_an(this);
        jad_anVar.jad_an(jad_anVarJad_an);
        com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_anVarJad_an2 = jad_fsVar.jad_kx().jad_an();
        this.jad_zm = jad_anVarJad_an2;
        jad_anVarJad_an2.jad_an(this);
        jad_anVar.jad_an(jad_anVarJad_an2);
        com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_anVarJad_an3 = jad_fsVar.jad_cp().jad_an();
        this.jad_cn = jad_anVarJad_an3;
        jad_anVarJad_an3.jad_an(this);
        jad_anVar.jad_an(jad_anVarJad_an3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_nw.jad_an, com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        super.jad_an(t, jad_cpVar);
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_ny) {
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = this.jad_do;
            if (jad_qdVar != null) {
                this.jad_fs.jad_uh.remove(jad_qdVar);
            }
            if (jad_cpVar == null) {
                this.jad_do = null;
                return;
            }
            com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar2 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
            this.jad_do = jad_qdVar2;
            jad_qdVar2.jad_an.add(this);
            this.jad_fs.jad_an(this.jad_do);
        }
    }

    public final int[] jad_an(int[] iArr) {
        com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = this.jad_do;
        if (jad_qdVar != null) {
            Integer[] numArr = (Integer[]) jad_qdVar.jad_fs();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_re;
    }

    public final int jad_dq() {
        int iRound = Math.round(this.jad_zm.jad_dq * this.jad_xk);
        int iRound2 = Math.round(this.jad_cn.jad_dq * this.jad_xk);
        int iRound3 = Math.round(this.jad_yl.jad_dq * this.jad_xk);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.jd.ad.sdk.jad_nw.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i) {
        RadialGradient radialGradient;
        if (this.jad_sf) {
            return;
        }
        jad_an(this.jad_vi, matrix, false);
        if (this.jad_wj == 1) {
            long jJad_dq = jad_dq();
            radialGradient = this.jad_tg.get(jJad_dq);
            if (radialGradient == null) {
                PointF pointFJad_fs = this.jad_zm.jad_fs();
                PointF pointFJad_fs2 = this.jad_cn.jad_fs();
                com.jd.ad.sdk.jad_sb.jad_dq jad_dqVarJad_fs = this.jad_yl.jad_fs();
                radialGradient = new LinearGradient(pointFJad_fs.x, pointFJad_fs.y, pointFJad_fs2.x, pointFJad_fs2.y, jad_an(jad_dqVarJad_fs.jad_bo), jad_dqVarJad_fs.jad_an, Shader.TileMode.CLAMP);
                this.jad_tg.put(jJad_dq, radialGradient);
            }
        } else {
            long jJad_dq2 = jad_dq();
            radialGradient = this.jad_uh.get(jJad_dq2);
            if (radialGradient == null) {
                PointF pointFJad_fs3 = this.jad_zm.jad_fs();
                PointF pointFJad_fs4 = this.jad_cn.jad_fs();
                com.jd.ad.sdk.jad_sb.jad_dq jad_dqVarJad_fs2 = this.jad_yl.jad_fs();
                int[] iArrJad_an = jad_an(jad_dqVarJad_fs2.jad_bo);
                float[] fArr = jad_dqVarJad_fs2.jad_an;
                float f = pointFJad_fs3.x;
                float f2 = pointFJad_fs3.y;
                radialGradient = new RadialGradient(f, f2, (float) Math.hypot(pointFJad_fs4.x - f, pointFJad_fs4.y - f2), iArrJad_an, fArr, Shader.TileMode.CLAMP);
                this.jad_uh.put(jJad_dq2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.jad_iv.setShader(radialGradient);
        super.jad_an(canvas, matrix, i);
    }
}
