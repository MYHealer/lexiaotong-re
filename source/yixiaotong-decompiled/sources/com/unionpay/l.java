package com.unionpay;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class l implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9326a;

    l(UPPayWapActivity uPPayWapActivity) {
        this.f9326a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        try {
            this.f9326a.i = abVar;
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("packageName");
            String string2 = jSONObject.getString("type");
            String strOptString = jSONObject.optString("openParams");
            String strOptString2 = jSONObject.optString("tn");
            if ("0".equals(string2)) {
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(strOptString2)) {
                    if (abVar != null) {
                        abVar.a(UPPayWapActivity.b("1", "Parameter error", (String) null));
                        return;
                    }
                    return;
                } else {
                    Intent intent = new Intent();
                    intent.setClassName(string, "com.unionpay.uppay.PayActivity");
                    intent.putExtra("paydata", strOptString2);
                    intent.putExtra(UPPayWapActivity.f9303a, this.f9326a.f);
                    this.f9326a.startActivityForResult(intent, 1);
                    return;
                }
            }
            if (!"2".equals(string2)) {
                if (abVar != null) {
                    abVar.a(UPPayWapActivity.b("1", "Parameter error", (String) null));
                }
            } else if (TextUtils.isEmpty(strOptString)) {
                if (abVar != null) {
                    abVar.a(UPPayWapActivity.b("1", "Parameter error", (String) null));
                }
            } else {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(Uri.parse(strOptString));
                if (!TextUtils.isEmpty(string)) {
                    intent2.setPackage(string);
                }
                this.f9326a.startActivityForResult(intent2, 1);
            }
        } catch (Exception e) {
            if (abVar != null) {
                abVar.a(UPPayWapActivity.b("1", e.getMessage(), (String) null));
            }
        }
    }
}
