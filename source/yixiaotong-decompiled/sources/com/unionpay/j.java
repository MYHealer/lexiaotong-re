package com.unionpay;

import android.content.Intent;
import android.os.Bundle;
import com.opos.mobad.activity.VideoActivity;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class j implements aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f9324a;

    j(UPPayWapActivity uPPayWapActivity) {
        this.f9324a = uPPayWapActivity;
    }

    @Override // com.unionpay.aa
    public final void a(String str, ab abVar) {
        String str2;
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                str2 = (String) jSONObject.get("url");
                try {
                    str3 = (String) jSONObject.get("title");
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
            Bundle bundle = new Bundle();
            bundle.putString("waptype", "new_page");
            bundle.putString("magic_data", "949A1CC");
            bundle.putString("wapurl", str2);
            bundle.putString("waptitle", str3);
            bundle.putString(VideoActivity.EXTRA_KEY_ACTION_TYPE, this.f9324a.g);
            Intent intent = new Intent();
            intent.putExtras(bundle);
            intent.setClass(this.f9324a, UPPayWapActivity.class);
            this.f9324a.startActivity(intent);
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
