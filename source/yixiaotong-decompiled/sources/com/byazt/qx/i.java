package com.byazt.qx;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 42})
public class i extends com.byazt.pct.uj<JSONObject, JSONObject> {
    public WeakReference<com.byazt.omf.d> c;

    @Override // com.byazt.pct.uj
    public void uj() {
    }

    public static void c(com.byazt.pct.nu nuVar, final com.byazt.omf.d dVar) {
        nuVar.c("newClickEvent", new com.byazt.pct.uj.tt() { // from class: com.byazt.qx.i.1
            @Override // com.byazt.pct.uj.tt
            public com.byazt.pct.uj c() {
                return new i(dVar);
            }
        });
    }

    public i(com.byazt.omf.d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    @Override // com.byazt.pct.uj
    public void c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.omf.d dVar = this.c.get();
        if (dVar == null) {
            ve();
        } else {
            dVar.x(jSONObject);
        }
    }
}
