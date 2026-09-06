package com.jd.ad.sdk.jad_qb;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt implements com.jd.ad.sdk.jad_ju.jad_hu {
    public final jad_hu jad_bo;
    public final URL jad_cp;
    public final String jad_dq;
    public String jad_er;
    public URL jad_fs;
    public int jad_hu;
    public volatile byte[] jad_jt;

    public jad_jt(String str, jad_hu jad_huVar) {
        this.jad_cp = null;
        this.jad_dq = com.jd.ad.sdk.jad_ir.jad_kx.jad_an(str);
        this.jad_bo = (jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
    }

    public jad_jt(URL url, jad_hu jad_huVar) {
        this.jad_cp = (URL) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(url);
        this.jad_dq = null;
        this.jad_bo = (jad_hu) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(jad_huVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public boolean equals(Object obj) {
        if (!(obj instanceof jad_jt)) {
            return false;
        }
        jad_jt jad_jtVar = (jad_jt) obj;
        return jad_an().equals(jad_jtVar.jad_an()) && this.jad_bo.equals(jad_jtVar.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public int hashCode() {
        if (this.jad_hu == 0) {
            int iHashCode = jad_an().hashCode();
            this.jad_hu = iHashCode;
            this.jad_hu = this.jad_bo.hashCode() + (iHashCode * 31);
        }
        return this.jad_hu;
    }

    public String jad_an() {
        String str = this.jad_dq;
        return str != null ? str : ((URL) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_cp)).toString();
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_hu
    public void jad_an(MessageDigest messageDigest) {
        if (this.jad_jt == null) {
            this.jad_jt = jad_an().getBytes(com.jd.ad.sdk.jad_ju.jad_hu.jad_an);
        }
        messageDigest.update(this.jad_jt);
    }

    public URL jad_bo() {
        if (this.jad_fs == null) {
            if (TextUtils.isEmpty(this.jad_er)) {
                String string = this.jad_dq;
                if (TextUtils.isEmpty(string)) {
                    string = ((URL) com.jd.ad.sdk.jad_ir.jad_kx.jad_an(this.jad_cp)).toString();
                }
                this.jad_er = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.jad_fs = new URL(this.jad_er);
        }
        return this.jad_fs;
    }

    public String toString() {
        return jad_an();
    }
}
