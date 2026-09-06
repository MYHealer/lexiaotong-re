package com.byazt.qx;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 155})
public class lr extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.sgn.sp.c c;

    public static void c(com.byazt.pct.nu nuVar, com.byazt.sgn.sp.c cVar) {
        nuVar.c("UgenDownloadDialogInteraction", (com.byazt.pct.n<?, ?>) new lr(cVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        c(jSONObject);
        return ve();
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null || this.c == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("InteractionType");
        if (iOptInt == 1) {
            this.c.ve(null);
            return;
        }
        if (iOptInt == 2) {
            this.c.c(null);
            return;
        }
        if (iOptInt == 3) {
            this.c.c();
        } else if (iOptInt == 4) {
            this.c.tt(null);
        } else {
            if (iOptInt != 5) {
                return;
            }
            this.c.uj(null);
        }
    }

    public lr(com.byazt.sgn.sp.c cVar) {
        this.c = cVar;
    }

    public JSONObject ve() {
        return new JSONObject();
    }
}
