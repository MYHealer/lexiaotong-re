package com.unionpay;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class k implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9325a;

    k(UPPayWapActivity uPPayWapActivity) {
        this.f9325a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                if (abVar != null) {
                    abVar.a(UPPayWapActivity.b("1", "Parameter error", (String) null));
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            while (true) {
                String str2 = "0";
                if (i >= jSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("packageName");
                if (com.unionpay.utils.b.b(this.f9325a, string, jSONObject2.getString("packageSign"), jSONObject2.getString("supportVersion"))) {
                    str2 = "1";
                }
                jSONObject.put(string, str2);
                i++;
            }
            if (abVar != null) {
                abVar.a(UPPayWapActivity.b("0", "success", jSONObject));
            }
        } catch (Exception e) {
            if (abVar != null) {
                abVar.a(UPPayWapActivity.b("1", e.getMessage(), (String) null));
            }
        }
    }
}
