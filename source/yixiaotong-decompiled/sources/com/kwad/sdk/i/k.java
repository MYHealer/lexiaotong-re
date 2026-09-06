package com.kwad.sdk.i;

import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class k implements b {
    public JSONObject biP = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return this.biP;
    }

    public k(String str, String str2, i iVar) {
        JSONObject jSONObjectRM = h.RQ().RU().RM();
        Iterator<String> itKeys = jSONObjectRM.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c.a(jSONObjectRM, next, jSONObjectRM.opt(next));
        }
        c.putValue(this.biP, "customKey", str);
        c.putValue(this.biP, "customValue", str2);
        c.putValue(this.biP, com.alipay.sdk.tid.b.f, iVar.biM);
        c.putValue(this.biP, "actionId", this.actionId);
    }

    public final String toString() {
        return this.biP.toString();
    }
}
