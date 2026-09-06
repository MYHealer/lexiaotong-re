package com.gnete.upbc.cashier.a;

import android.text.TextUtils;
import com.gnete.upbc.cashier.b.i;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: APIOrderInfoQuery.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class d extends f {
    public d(com.gnete.upbc.cashier.b.b bVar) {
        super(bVar);
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected String a() {
        return "gnete.upbc.cashier.trade.orderInfoQuery";
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected JSONObject b() {
        return this.b.g().a();
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void a(com.gnete.upbc.cashier.g.a.C0391a c0391a, b bVar) {
        com.gnete.upbc.cashier.b.a aVar = new com.gnete.upbc.cashier.b.a();
        i iVar = new i();
        aVar.a(iVar);
        String strA = c0391a.a("tradeStatus", "");
        if (!TextUtils.equals("02", strA)) {
            bVar.a(String.format("订单状态失效，不允许支付(%s)", strA), null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArrayA = c0391a.a("merPayTypeDtl");
        if (jSONArrayA.length() > 0) {
            for (int i = 0; i < jSONArrayA.length(); i++) {
                com.gnete.upbc.cashier.g.a.C0391a c0391aA = com.gnete.upbc.cashier.g.a.a(jSONArrayA, i);
                String strA2 = c0391aA.a("merPayType", "");
                int iA = c0391aA.a("seq", 0);
                com.gnete.upbc.cashier.b.f fVarA = com.gnete.upbc.cashier.b.f.a(strA2);
                if (fVarA != null) {
                    if (!com.gnete.upbc.cashier.a.e().contains(fVarA.d())) {
                        fVarA.a(iA);
                        arrayList.add(fVarA);
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            bVar.a("无可用的支付方式", null);
            return;
        }
        iVar.a(arrayList);
        iVar.a(c0391a.a("busiMerName", ""));
        iVar.e(c0391a.a("trxCurr", ""));
        iVar.c(c0391a.a("quickAmt", ""));
        iVar.d(c0391a.a("subject", ""));
        iVar.b(c0391a.a("ordrDesc", ""));
        bVar.a(aVar);
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void b(b bVar) {
        bVar.a();
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void a(String str, Throwable th, b bVar) {
        bVar.a(String.format("查询失败[%s]", str), th);
    }
}
