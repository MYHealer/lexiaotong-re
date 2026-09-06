package com.byazt.axo;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1724, 13})
public class tt implements c {
    public c c;

    @Override // com.byazt.axo.c
    public void c(JSONObject jSONObject) throws JSONException {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
