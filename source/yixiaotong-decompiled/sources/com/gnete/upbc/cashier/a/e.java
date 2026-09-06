package com.gnete.upbc.cashier.a;

import com.huawei.openalliance.ad.constant.br;
import org.json.JSONObject;

/* JADX INFO: compiled from: APISdkLog.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class e extends f {

    /* JADX INFO: compiled from: APISdkLog.java */
    class a extends Thread {

        /* JADX INFO: renamed from: com.gnete.upbc.cashier.a.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: APISdkLog.java */
        class C0381a implements f.b {
            C0381a(a aVar) {
            }

            @Override // com.gnete.upbc.cashier.a.f.b
            public void a() {
            }

            @Override // com.gnete.upbc.cashier.a.f.b
            public void a(String str) {
            }

            @Override // com.gnete.upbc.cashier.a.f.b
            public void a(String str, Throwable th) {
            }
        }

        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            e.this.a(com.gnete.upbc.cashier.a.d(), e.this.c(), new C0381a(this));
        }
    }

    public e(com.gnete.upbc.cashier.b.b bVar) {
        super(bVar);
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected String a() {
        return "gnete.upbc.cashier.trade.sdkLog";
    }

    @Override // com.gnete.upbc.cashier.a.f, com.gnete.upbc.cashier.a.a
    public void a(b bVar) {
        com.gnete.upbc.cashier.b.g gVarH = this.b.d().h();
        if ((gVarH == com.gnete.upbc.cashier.b.g.NORMAL && com.gnete.upbc.cashier.a.h()) || ((gVarH == com.gnete.upbc.cashier.b.g.LOG && com.gnete.upbc.cashier.a.j()) || (gVarH == com.gnete.upbc.cashier.b.g.CRASH && com.gnete.upbc.cashier.a.i()))) {
            new a().start();
        }
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void a(com.gnete.upbc.cashier.g.a.C0391a c0391a, b bVar) {
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void a(String str, Throwable th, b bVar) {
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected JSONObject b() {
        com.gnete.upbc.cashier.g.a.C0391a c0391aG = this.b.g();
        com.gnete.upbc.cashier.b.e eVarD = this.b.d();
        c0391aG.b("merPayType", eVarD.g()).a("sdkLogInf", com.gnete.upbc.cashier.g.a.b().b("sdkVersion", eVarD.i()).b("appPackageName", eVarD.a()).b("appVersion", eVarD.b()).b("deviceModel", eVarD.d()).b("deviceSystemVersion", eVarD.f()).b("deviceNetworkType", eVarD.e()).a(br.f.J, eVarD.h()).b("exceptionDesc", eVarD.c()).b("exceptionStack", eVarD.j()).a());
        return c0391aG.a();
    }

    @Override // com.gnete.upbc.cashier.a.f
    protected void b(b bVar) {
    }
}
