package com.unionpay;

import com.unionpay.utils.UPUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class r implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9332a;

    r(UPPayWapActivity uPPayWapActivity) {
        this.f9332a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                UPUtils.a(this.f9332a, jSONObject.getString(next), next);
            }
            if (abVar != null) {
                abVar.a(UPPayWapActivity.b("0", "success", (String) null));
            }
        } catch (Exception e) {
            if (abVar != null) {
                abVar.a(UPPayWapActivity.b("1", e.getMessage(), (String) null));
            }
        }
    }
}
