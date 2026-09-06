package com.gnete.upbc.cashier.a;

import com.cdo.oaps.ad.OapsKey;
import com.gnete.upbc.cashier.b.j;
import org.json.JSONObject;

/* JADX INFO: compiled from: APIH5Create.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class c extends f {
    public c(com.gnete.upbc.cashier.b.b bVar) {
        super(bVar);
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected String a() {
        return "gnete.upbc.cashier.trade.h5Create";
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected JSONObject b() {
        com.gnete.upbc.cashier.g.a.C0391a c0391aG = this.b.g();
        com.gnete.upbc.cashier.b.f fVarA = com.gnete.upbc.cashier.b.f.a(this.b.f());
        if (fVarA != null) {
            c0391aG.b("merPayType", fVarA.e());
        }
        return c0391aG.a();
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void a(com.gnete.upbc.cashier.g.a.C0391a c0391a, b bVar) {
        com.gnete.upbc.cashier.b.a aVar = new com.gnete.upbc.cashier.b.a();
        j jVar = new j();
        aVar.a(jVar);
        com.gnete.upbc.cashier.g.a.C0391a c0391aB = c0391a.b("wcPayData");
        jVar.h(c0391a.a("qrCode", ""));
        jVar.c(c0391aB.a("miniuser", ""));
        jVar.b(c0391aB.a("minipath", ""));
        jVar.a(c0391aB.a("appScheme", ""));
        jVar.d(c0391aB.a("msgType", ""));
        jVar.f(c0391aB.a(OapsKey.KEY_PKG, ""));
        jVar.i(c0391aB.a("sign", ""));
        jVar.g(c0391aB.a("prepayId", ""));
        jVar.e(c0391aB.a("nonceStr", ""));
        jVar.j(c0391aB.a("timeStamp", ""));
        bVar.a(aVar);
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void b(b bVar) {
        bVar.a();
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void a(String str, Throwable th, b bVar) {
        bVar.a(String.format("下单失败[%s]", str), th);
    }
}
