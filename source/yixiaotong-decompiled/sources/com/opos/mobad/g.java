package com.opos.mobad;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.instant.router.callback.Callback;
import com.opos.mobad.activity.AdActivity;
import com.opos.mobad.model.data.AdItemData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g implements com.opos.mobad.cmn.func.a {
    @Override // com.opos.mobad.cmn.func.a
    public void a(Context context, String str, String str2, String str3, final com.opos.mobad.cmn.func.a.InterfaceC0945a interfaceC0945a, String str4) {
        int iIntValue;
        boolean zB = com.opos.mobad.cmn.func.b.c.b(context);
        com.opos.cmn.an.f.a.a("", "instant origin =" + str + ",secret =" + str2 + ",url =" + str3 + ",traceId =" + str4);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && zB) {
            com.opos.mobad.cmn.func.b.g.a(context, str, str2, str3, new Callback() { // from class: com.opos.mobad.g.1
                @Override // com.oplus.instant.router.callback.Callback
                public void onResponse(Callback.Response response) {
                    if (response.getCode() == 1) {
                        com.opos.cmn.an.f.a.a("", "instant jump success");
                        com.opos.mobad.cmn.func.a.InterfaceC0945a interfaceC0945a2 = interfaceC0945a;
                        if (interfaceC0945a2 != null) {
                            interfaceC0945a2.a();
                            return;
                        }
                        return;
                    }
                    com.opos.cmn.an.f.a.a("", "instant jump fail" + response.getCode());
                    com.opos.mobad.cmn.func.a.InterfaceC0945a interfaceC0945a3 = interfaceC0945a;
                    if (interfaceC0945a3 != null) {
                        interfaceC0945a3.a(response.getCode(), response.getMsg());
                    }
                }
            }, str4);
            return;
        }
        if (interfaceC0945a != null) {
            String str5 = !zB ? "instant not install" : "";
            try {
                iIntValue = Integer.valueOf("0").intValue();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("", "", e);
                iIntValue = 0;
            }
            interfaceC0945a.a(iIntValue, str5);
        }
        com.opos.cmn.an.f.a.a("", "executeInstant but fail");
    }

    @Override // com.opos.mobad.cmn.func.a
    public void a(Context context, String str, String str2, String str3, String str4) {
        com.opos.mobad.cmn.func.b.g.a(context, str, str2, str3, str4);
    }

    @Override // com.opos.mobad.cmn.func.a
    public void a(b bVar, String str, String str2, AdItemData adItemData, String str3, com.opos.mobad.t.a aVar) {
        AdActivity.a(bVar.b(), str, str2, adItemData, str3, aVar);
    }

    @Override // com.opos.mobad.cmn.func.a
    public void a(b bVar, String str, String str2, AdItemData adItemData, String str3, String str4, com.opos.mobad.t.a aVar, com.opos.mobad.t.c cVar, long j) {
        AdActivity.a(bVar.b(), str, str2, adItemData, str3, str4, aVar, cVar);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean a(Context context, String str) {
        return com.opos.mobad.cmn.func.b.g.a(context, str);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean a(Context context, String str, String str2, String str3) {
        return com.opos.mobad.cmn.func.b.i.a(context, str, str2, str3);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        com.opos.cmn.an.f.a.a("", "handleDLApk pkgName=" + str + ",posId=" + str2 + ",channelPkg=" + (str3 != null ? str3 : "null") + ",trackContent=" + (str5 != null ? str5 : "null") + ",trackReference=" + (str6 != null ? str6 : "null"));
        boolean zA = com.opos.mobad.cmn.func.b.d.a(context, str, str2, str3, str4, str5, str6, str7);
        com.opos.cmn.an.f.a.a("", "executeDownloadApp result = " + zA);
        return zA;
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean b(Context context, String str) {
        return com.opos.mobad.cmn.func.b.g.b(context, str);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean b(Context context, String str, String str2, String str3) {
        return com.opos.mobad.cmn.func.b.i.b(context, str, str2, str3);
    }

    @Override // com.opos.mobad.cmn.func.a
    public void c(Context context, String str) {
        com.opos.cmn.an.f.a.a("", "open browser =" + str);
        com.opos.cmn.biz.b.a.a(context, str);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean d(Context context, String str) {
        com.opos.cmn.an.f.a.a("", "handleDeeplinkApk downloadUrl=" + str);
        return com.opos.mobad.cmn.func.b.g.f(context, str);
    }

    @Override // com.opos.mobad.cmn.func.a
    public boolean e(Context context, String str) {
        com.opos.cmn.an.f.a.a("", "handleDeeplinkApk downloadUrl=" + str);
        return com.opos.cmn.g.b.b.a.a(context, str);
    }
}
