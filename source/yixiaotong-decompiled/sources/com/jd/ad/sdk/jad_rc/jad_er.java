package com.jd.ad.sdk.jad_rc;

import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_qb.jad_hu;
import com.jd.ad.sdk.jad_qb.jad_jt;
import com.jd.ad.sdk.jad_qb.jad_na;
import com.jd.ad.sdk.jad_qb.jad_ob;
import com.jd.ad.sdk.jad_qb.jad_re;
import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er implements jad_na<URL, InputStream> {
    public final jad_na<jad_jt, InputStream> jad_an;

    public static class jad_an implements jad_ob<URL, InputStream> {
        @Override // com.jd.ad.sdk.jad_qb.jad_ob
        public jad_na<URL, InputStream> jad_an(jad_re jad_reVar) {
            return new jad_er(jad_reVar.jad_an(jad_jt.class, InputStream.class));
        }
    }

    public jad_er(jad_na<jad_jt, InputStream> jad_naVar) {
        this.jad_an = jad_naVar;
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public jad_na.jad_an<InputStream> jad_an(URL url, int i, int i2, jad_jw jad_jwVar) {
        return this.jad_an.jad_an(new jad_jt(url, jad_hu.jad_an), i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_qb.jad_na
    public /* bridge */ /* synthetic */ boolean jad_an(URL url) {
        return true;
    }
}
