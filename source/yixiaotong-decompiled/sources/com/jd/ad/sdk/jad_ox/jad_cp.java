package com.jd.ad.sdk.jad_ox;

import android.graphics.Color;
import android.graphics.Paint;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp implements com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an {
    public final com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an jad_an;
    public final com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_bo;
    public final com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_cp;
    public final com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_dq;
    public final com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_er;
    public final com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_fs;
    public boolean jad_jt = true;

    public class jad_an extends com.jd.ad.sdk.jad_yh.jad_cp<Float> {
        public final /* synthetic */ com.jd.ad.sdk.jad_yh.jad_cp jad_cp;

        public jad_an(jad_cp jad_cpVar, com.jd.ad.sdk.jad_yh.jad_cp jad_cpVar2) {
            this.jad_cp = jad_cpVar2;
        }

        @Override // com.jd.ad.sdk.jad_yh.jad_cp
        public Float jad_an(com.jd.ad.sdk.jad_yh.jad_bo<Float> jad_boVar) {
            Float f = (Float) this.jad_cp.jad_an(jad_boVar);
            if (f == null) {
                return null;
            }
            return Float.valueOf(f.floatValue() * 2.55f);
        }
    }

    public jad_cp(com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an interfaceC0570jad_an, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_ve.jad_jw jad_jwVar) {
        this.jad_an = interfaceC0570jad_an;
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVarJad_an = jad_jwVar.jad_an().jad_an();
        this.jad_bo = jad_anVarJad_an;
        jad_anVarJad_an.jad_an(this);
        jad_anVar.jad_an(jad_anVarJad_an);
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an2 = jad_jwVar.jad_dq().jad_an();
        this.jad_cp = jad_anVarJad_an2;
        jad_anVarJad_an2.jad_an(this);
        jad_anVar.jad_an(jad_anVarJad_an2);
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an3 = jad_jwVar.jad_bo().jad_an();
        this.jad_dq = jad_anVarJad_an3;
        jad_anVarJad_an3.jad_an(this);
        jad_anVar.jad_an(jad_anVarJad_an3);
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an4 = jad_jwVar.jad_cp().jad_an();
        this.jad_er = jad_anVarJad_an4;
        jad_anVarJad_an4.jad_an(this);
        jad_anVar.jad_an(jad_anVarJad_an4);
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an5 = jad_jwVar.jad_er().jad_an();
        this.jad_fs = jad_anVarJad_an5;
        jad_anVarJad_an5.jad_an(this);
        jad_anVar.jad_an(jad_anVarJad_an5);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an
    public void jad_an() {
        this.jad_jt = true;
        this.jad_an.jad_an();
    }

    public void jad_an(Paint paint) {
        if (this.jad_jt) {
            this.jad_jt = false;
            double dFloatValue = ((double) this.jad_dq.jad_fs().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.jad_er.jad_fs().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.jad_bo.jad_fs().intValue();
            paint.setShadowLayer(this.jad_fs.jad_fs().floatValue(), fSin, fCos, Color.argb(Math.round(this.jad_cp.jad_fs().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }

    public void jad_an(com.jd.ad.sdk.jad_yh.jad_cp<Float> jad_cpVar) {
        if (jad_cpVar == null) {
            this.jad_cp.jad_er = null;
        } else {
            this.jad_cp.jad_er = new jad_an(this, jad_cpVar);
        }
    }
}
