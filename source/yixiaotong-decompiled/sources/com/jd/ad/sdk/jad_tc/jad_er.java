package com.jd.ad.sdk.jad_tc;

import com.jd.ad.sdk.jad_ra.jad_jw;
import com.jd.ad.sdk.jad_ra.jad_kx;
import com.jd.ad.sdk.jad_ra.jad_ly;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public final List<com.jd.ad.sdk.jad_sb.jad_cp> jad_an;
    public final com.jd.ad.sdk.jad_lu.jad_jt jad_bo;
    public final String jad_cp;
    public final long jad_dq;
    public final int jad_er;
    public final long jad_fs;
    public final List<com.jd.ad.sdk.jad_sb.jad_jt> jad_hu;
    public final jad_ly jad_iv;
    public final String jad_jt;
    public final int jad_jw;
    public final int jad_kx;
    public final int jad_ly;
    public final float jad_mz;
    public final float jad_na;
    public final int jad_ob;
    public final int jad_pc;
    public final jad_jw jad_qd;
    public final jad_kx jad_re;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_sf;
    public final List<com.jd.ad.sdk.jad_yh.jad_an<Float>> jad_tg;
    public final int jad_uh;
    public final boolean jad_vi;
    public final com.jd.ad.sdk.jad_sb.jad_an jad_wj;
    public final com.jd.ad.sdk.jad_ve.jad_jw jad_xk;

    /* JADX WARN: Incorrect types in method signature: (Ljava/util/List<Lcom/jd/ad/sdk/jad_sb/jad_cp;>;Lcom/jd/ad/sdk/jad_lu/jad_jt;Ljava/lang/String;JLjava/lang/Object;JLjava/lang/String;Ljava/util/List<Lcom/jd/ad/sdk/jad_sb/jad_jt;>;Lcom/jd/ad/sdk/jad_ra/jad_ly;IIIFFIILcom/jd/ad/sdk/jad_ra/jad_jw;Lcom/jd/ad/sdk/jad_ra/jad_kx;Ljava/util/List<Lcom/jd/ad/sdk/jad_yh/jad_an<Ljava/lang/Float;>;>;Ljava/lang/Object;Lcom/jd/ad/sdk/jad_ra/jad_bo;ZLcom/jd/ad/sdk/jad_sb/jad_an;Lcom/jd/ad/sdk/jad_ve/jad_jw;)V */
    public jad_er(List list, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar, String str, long j, int i, long j2, String str2, List list2, jad_ly jad_lyVar, int i2, int i3, int i4, float f, float f2, int i5, int i6, jad_jw jad_jwVar, jad_kx jad_kxVar, List list3, int i7, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, boolean z, com.jd.ad.sdk.jad_sb.jad_an jad_anVar, com.jd.ad.sdk.jad_ve.jad_jw jad_jwVar2) {
        this.jad_an = list;
        this.jad_bo = jad_jtVar;
        this.jad_cp = str;
        this.jad_dq = j;
        this.jad_er = i;
        this.jad_fs = j2;
        this.jad_jt = str2;
        this.jad_hu = list2;
        this.jad_iv = jad_lyVar;
        this.jad_jw = i2;
        this.jad_kx = i3;
        this.jad_ly = i4;
        this.jad_mz = f;
        this.jad_na = f2;
        this.jad_ob = i5;
        this.jad_pc = i6;
        this.jad_qd = jad_jwVar;
        this.jad_re = jad_kxVar;
        this.jad_tg = list3;
        this.jad_uh = i7;
        this.jad_sf = jad_boVar;
        this.jad_vi = z;
        this.jad_wj = jad_anVar;
        this.jad_xk = jad_jwVar2;
    }

    public com.jd.ad.sdk.jad_lu.jad_jt jad_an() {
        return this.jad_bo;
    }

    public long jad_bo() {
        return this.jad_dq;
    }

    public List<com.jd.ad.sdk.jad_sb.jad_jt> jad_cp() {
        return this.jad_hu;
    }

    public int jad_dq() {
        return this.jad_uh;
    }

    public String jad_er() {
        return this.jad_cp;
    }

    public long jad_fs() {
        return this.jad_fs;
    }

    public int jad_hu() {
        return this.jad_ly;
    }

    public jad_jw jad_iv() {
        return this.jad_qd;
    }

    public List<com.jd.ad.sdk.jad_sb.jad_cp> jad_jt() {
        return this.jad_an;
    }

    public jad_kx jad_jw() {
        return this.jad_re;
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_kx() {
        return this.jad_sf;
    }

    public jad_ly jad_ly() {
        return this.jad_iv;
    }

    public String toString() {
        return jad_an("");
    }

    public String jad_an(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(this.jad_cp).append(IOUtils.LINE_SEPARATOR_UNIX);
        jad_er jad_erVarJad_an = this.jad_bo.jad_an(this.jad_fs);
        if (jad_erVarJad_an != null) {
            sb.append("\t\tParents: ").append(jad_erVarJad_an.jad_cp);
            com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_bo;
            while (true) {
                jad_erVarJad_an = jad_jtVar.jad_an(jad_erVarJad_an.jad_fs);
                if (jad_erVarJad_an == null) {
                    break;
                }
                sb.append("->").append(jad_erVarJad_an.jad_cp);
                jad_jtVar = this.jad_bo;
            }
            sb.append(str).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (!this.jad_hu.isEmpty()) {
            sb.append(str).append("\tMasks: ").append(this.jad_hu.size()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.jad_jw != 0 && this.jad_kx != 0) {
            sb.append(str).append("\tBackground: ").append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(this.jad_jw), Integer.valueOf(this.jad_kx), Integer.valueOf(this.jad_ly)));
        }
        if (!this.jad_an.isEmpty()) {
            sb.append(str).append("\tShapes:\n");
            Iterator<com.jd.ad.sdk.jad_sb.jad_cp> it = this.jad_an.iterator();
            while (it.hasNext()) {
                sb.append(str).append("\t\t").append(it.next()).append(IOUtils.LINE_SEPARATOR_UNIX);
            }
        }
        return sb.toString();
    }
}
