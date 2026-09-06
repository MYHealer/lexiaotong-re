package com.byazt.qx;

import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 34})
public class a extends com.byazt.pct.n<JSONObject, JSONObject> {
    public WeakReference<com.byazt.omf.d> c;

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("changePlaySpeedRatio", (com.byazt.pct.n<?, ?>) new a(dVar));
    }

    public a(com.byazt.omf.d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        WeakReference<com.byazt.omf.d> weakReference = this.c;
        if (weakReference == null || weakReference.get() == null) {
            return new JSONObject();
        }
        float fOptDouble = (float) jSONObject.optDouble("ratio");
        if (fOptDouble > 0.0f && fOptDouble <= 3.0f) {
            this.c.get().c(fOptDouble);
        }
        return new JSONObject();
    }
}
