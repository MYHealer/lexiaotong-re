package com.byazt.qx;

import com.huawei.hms.ads.ClickAreaSource;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 158})
public class sl extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.ete.ic c;
    public com.byazt.omf.d tt;

    public static void c(com.byazt.pct.nu nuVar, com.byazt.ete.ic icVar, com.byazt.omf.d dVar) {
        nuVar.c("adViewInfo", (com.byazt.pct.n<?, ?>) new sl(icVar, dVar));
    }

    public sl(com.byazt.ete.ic icVar, com.byazt.omf.d dVar) {
        this.c = icVar;
        this.tt = dVar;
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("container", this.tt.c());
        jSONObject2.put(ClickAreaSource.CREATIVE, this.tt.tt());
        return jSONObject2;
    }
}
