package com.byazt.px;

import com.byazt.yf.sl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 690, 13})
public class tt {
    public static volatile tt ve;
    public sl c;
    public final Map<String, com.byazt.ly.uj> tt = new ConcurrentHashMap();

    public static tt c() {
        if (ve == null) {
            synchronized (tt.class) {
                if (ve == null) {
                    ve = new tt();
                }
            }
        }
        return ve;
    }

    private tt() {
    }

    public synchronized Map<String, com.byazt.ly.uj> tt() {
        return this.tt;
    }

    public Collection<com.byazt.ly.uj> ve() {
        return this.tt.values();
    }

    public com.byazt.ly.uj c(String str, sl slVar) {
        this.c = slVar;
        return c(str);
    }

    public synchronized com.byazt.ly.uj c(String str) {
        com.byazt.ly.uj ujVarTt;
        ujVarTt = tt(str);
        if (ujVarTt == null) {
            com.byazt.nbs.c cVarC = com.byazt.bp.tt.tt().c(str);
            if (cVarC == null && this.c != null) {
                cVarC = new com.byazt.nbs.c(this.c.n(), this.c.ve(), this.c.uj());
                this.c = null;
            }
            if (cVarC != null && !cVarC.n()) {
                ujVarTt = ve(str);
            }
            if (ujVarTt != null) {
                c(str, ujVarTt);
            }
        }
        return ujVarTt;
    }

    private com.byazt.ly.uj tt(String str) {
        if (str == null) {
            return null;
        }
        return this.tt.get(str);
    }

    private void c(String str, com.byazt.ly.uj ujVar) {
        if (str == null) {
            return;
        }
        this.tt.put(str, ujVar);
    }

    private com.byazt.ly.uj ve(String str) {
        if (MediationConstant.ADN_PANGLE.equalsIgnoreCase(str)) {
            return new com.byazt.xf.c();
        }
        return new uj();
    }
}
