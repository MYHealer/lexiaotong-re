package com.unionpay;

import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class h implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9322a;

    h(UPPayWapActivity uPPayWapActivity) {
        this.f9322a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        String str2;
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                str2 = (String) jSONObject.get(Constant.KEY_RESULT_CODE);
                try {
                    str3 = (String) jSONObject.get("resultData");
                } catch (Exception e) {
                    e = e;
                    if (abVar != null) {
                        abVar.a(UPPayWapActivity.b("1", e.getMessage(), (String) null));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                str2 = "";
            }
            this.f9322a.a(str2, str3);
            if (abVar != null) {
                abVar.a(UPPayWapActivity.b("0", "success", (String) null));
            }
        } catch (Exception e3) {
            if (abVar != null) {
                abVar.a(UPPayWapActivity.b("1", e3.getMessage(), (String) null));
            }
        }
    }
}
