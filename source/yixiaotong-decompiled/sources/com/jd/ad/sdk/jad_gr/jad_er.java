package com.jd.ad.sdk.jad_gr;

import android.content.Context;
import android.content.ContextWrapper;
import com.jd.ad.sdk.jad_mx.jad_mz;
import com.stub.StubApp;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er extends ContextWrapper {
    public static final jad_kx<?, ?> jad_jw = new jad_bo();
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;
    public final jad_hu jad_bo;
    public final jad_cp.jad_an jad_cp;
    public final List<com.jd.ad.sdk.jad_en.jad_jt<Object>> jad_dq;
    public final Map<Class<?>, jad_kx<?, ?>> jad_er;
    public final jad_mz jad_fs;
    public final int jad_hu;
    public com.jd.ad.sdk.jad_en.jad_hu jad_iv;
    public final jad_fs jad_jt;

    public jad_er(Context context, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar, jad_hu jad_huVar, com.jd.ad.sdk.jad_fo.jad_bo jad_boVar2, jad_cp.jad_an jad_anVar, Map<Class<?>, jad_kx<?, ?>> map, List<com.jd.ad.sdk.jad_en.jad_jt<Object>> list, jad_mz jad_mzVar, jad_fs jad_fsVar, int i) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.jad_an = jad_boVar;
        this.jad_bo = jad_huVar;
        this.jad_cp = jad_anVar;
        this.jad_dq = list;
        this.jad_er = map;
        this.jad_fs = jad_mzVar;
        this.jad_jt = jad_fsVar;
        this.jad_hu = i;
    }

    public List<com.jd.ad.sdk.jad_en.jad_jt<Object>> jad_an() {
        return this.jad_dq;
    }

    public synchronized com.jd.ad.sdk.jad_en.jad_hu jad_bo() {
        if (this.jad_iv == null) {
            ((jad_dq.jad_an) this.jad_cp).getClass();
            com.jd.ad.sdk.jad_en.jad_hu jad_huVar = new com.jd.ad.sdk.jad_en.jad_hu();
            jad_huVar.jad_tg = true;
            this.jad_iv = jad_huVar;
        }
        return this.jad_iv;
    }

    public jad_fs jad_cp() {
        return this.jad_jt;
    }
}
