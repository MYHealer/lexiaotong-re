package com.byazt.vgp;

import com.byazt.omf.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1713, 46})
public class n implements com.byazt.zb.ve {
    public d c;

    public n(d dVar) {
        this.c = dVar;
    }

    @Override // com.byazt.zb.ve
    public void c(String str, JSONObject jSONObject) {
        d dVar = this.c;
        if (dVar != null) {
            dVar.tt(str, jSONObject);
        }
    }
}
