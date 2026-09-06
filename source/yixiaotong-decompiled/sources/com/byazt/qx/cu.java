package com.byazt.qx;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 121})
public class cu extends com.byazt.pct.uj<JSONObject, JSONObject> {
    public WeakReference<com.byazt.omf.d> c;
    public com.byazt.ete.ic tt;
    public long uj;
    public com.byazt.at.a ve;

    @Override // com.byazt.pct.uj
    public void uj() {
    }

    public static void c(com.byazt.pct.nu nuVar, final com.byazt.omf.d dVar, final com.byazt.ete.ic icVar) {
        nuVar.c("requestVideoDelayCallback", new com.byazt.pct.uj.tt() { // from class: com.byazt.qx.cu.1
            @Override // com.byazt.pct.uj.tt
            public com.byazt.pct.uj c() {
                return new cu(dVar, icVar);
            }
        });
    }

    public cu(com.byazt.omf.d dVar, com.byazt.ete.ic icVar) {
        this.c = new WeakReference<>(dVar);
        this.tt = icVar;
    }

    @Override // com.byazt.pct.uj
    public void c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.omf.d dVar = this.c.get();
        if (dVar == null || jSONObject == null) {
            ve();
            return;
        }
        this.ve = new com.byazt.at.a() { // from class: com.byazt.qx.cu.2
            @Override // com.byazt.at.a
            public void c() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.byazt.qx.cu.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            cu.this.c(new JSONObject());
                        } catch (Exception e) {
                            com.byazt.nr.m.uj("requestVideoDelay", e.getMessage());
                        }
                    }
                }, cu.this.uj);
            }
        };
        int iOptInt = jSONObject.optInt("delay", -1);
        if (iOptInt < 0) {
            return;
        }
        this.uj = iOptInt;
        if (dVar.ve() != null && dVar.ve().K_()) {
            this.ve.c();
        } else {
            dVar.c(this.ve);
        }
    }
}
