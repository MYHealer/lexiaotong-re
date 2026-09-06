package com.opos.mobad.cmn.func.adhandler.a.a;

import android.content.Context;
import com.opos.cmn.i.f;
import com.opos.cmn.i.h;
import com.opos.mobad.cmn.func.adhandler.a.b;
import com.opos.mobad.cmn.func.adhandler.d;
import com.opos.mobad.cmn.func.b.e;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends b {
    private static String d = "AdHandler_InstallDeepLinkDataV2";
    public final String b;
    public final String c;

    public a(String str, String str2) {
        super(str);
        this.b = str2;
        this.c = f.a();
    }

    private void a(com.opos.mobad.cmn.func.adhandler.b.InterfaceC0949b interfaceC0949b, int i) {
        if (interfaceC0949b != null) {
            interfaceC0949b.a(new com.opos.mobad.cmn.func.adhandler.b.c(b(), i));
        }
    }

    private boolean a(com.opos.mobad.b bVar, d dVar) {
        String str;
        boolean zA;
        String strG;
        String strC = "";
        Context contextB = bVar != null ? bVar.b() : null;
        HashMap map = new HashMap();
        try {
            strG = dVar.a().g();
            try {
                strC = dVar.a().c();
                String strI = dVar.b.i();
                h.a(map, "dpUrl", this.f6768a);
                h.a(map, "dpToken", this.b);
                h.a(map, "reqId", strC);
                h.a(map, "appPackageName", strI);
                h.a(map, "dpRequestId", this.c);
                zA = com.opos.cmn.e.a.a().a(contextB, map);
            } catch (Exception e) {
                e = e;
                str = strC;
                strC = strG;
                com.opos.cmn.an.f.a.d(d, "executeDeeplink() fail", e);
                zA = false;
                strG = strC;
                strC = str;
            }
        } catch (Exception e2) {
            e = e2;
            str = "";
        }
        e.a(bVar, strG, strC, map);
        return zA;
    }

    public void a(com.opos.mobad.b bVar, d dVar, com.opos.mobad.cmn.func.adhandler.b.InterfaceC0949b interfaceC0949b) {
        String str;
        String str2;
        com.opos.cmn.an.f.a.b(d, "handle() dpRequestId=", this.c);
        try {
            if (!a()) {
                a(interfaceC0949b, -1);
                com.opos.cmn.an.f.a.b(d, "handle() fail because data is invalid.");
                return;
            }
            if (a(bVar, dVar)) {
                a(interfaceC0949b, 1);
                str = d;
                str2 = "handle() success. DeepLinkUrl=" + this.f6768a;
            } else {
                a(interfaceC0949b, -3);
                str = d;
                str2 = "handle() fail because jump result is false.";
            }
            com.opos.cmn.an.f.a.b(str, str2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d(d, "handle() fail", e);
            a(interfaceC0949b, -2);
        }
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 20;
    }
}
