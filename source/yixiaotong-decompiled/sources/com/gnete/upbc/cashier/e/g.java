package com.gnete.upbc.cashier.e;

import android.app.Activity;
import android.text.TextUtils;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.GnetePayRequest;
import com.gnete.upbc.cashier.b.j;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;

/* JADX INFO: compiled from: WXPAYHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class g extends b {

    /* JADX INFO: compiled from: WXPAYHandler.java */
    class a implements com.gnete.upbc.cashier.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.gnete.upbc.cashier.f.b f3296a;

        /* JADX INFO: renamed from: com.gnete.upbc.cashier.e.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WXPAYHandler.java */
        class C0389a implements b.InterfaceC0387b {
            C0389a() {
            }

            @Override // com.gnete.upbc.cashier.e.b.InterfaceC0387b
            public void a() {
                com.gnete.upbc.cashier.g.b.a(GnetePayChannel.WXPAY, g.this.c);
            }

            @Override // com.gnete.upbc.cashier.e.b.InterfaceC0387b
            public void a(String str, Throwable th) {
                g gVar = g.this;
                com.gnete.upbc.cashier.g.b.a(gVar.f3290a, gVar.b, str, th, gVar.c);
            }
        }

        a(com.gnete.upbc.cashier.f.b bVar) {
            this.f3296a = bVar;
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(com.gnete.upbc.cashier.b.a aVar) {
            g.this.a(aVar.b(), new C0389a());
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(String str, Throwable th) {
            g gVar = g.this;
            com.gnete.upbc.cashier.g.b.a(gVar.f3290a, gVar.b, str, th, gVar.c);
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a() {
            this.f3296a.dismissAllowingStateLoss();
        }
    }

    public g(Activity activity, GnetePayRequest gnetePayRequest, GnetePayListener gnetePayListener) {
        super(activity, gnetePayRequest, gnetePayListener);
    }

    @Override // com.gnete.upbc.cashier.e.b
    public void a(j jVar, b.InterfaceC0387b interfaceC0387b) {
        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
        if (TextUtils.isEmpty(jVar.h())) {
            interfaceC0387b.a("参数缺失[username]", null);
            return;
        }
        req.userName = jVar.h();
        String strConcat = com.gnete.upbc.cashier.a.g().concat("?").concat(this.b.h()).concat("&showAmt=").concat(this.b.e().c()).concat("&env=").concat(com.gnete.upbc.cashier.a.b().name());
        if (com.gnete.upbc.cashier.a.h()) {
            strConcat = strConcat.concat("&monitor=true");
        }
        req.path = strConcat;
        req.miniprogramType = 0;
        if (com.gnete.upbc.cashier.a.c().sendReq(req)) {
            interfaceC0387b.a();
        } else {
            interfaceC0387b.a("跳转微信支付失败", null);
        }
    }

    @Override // com.gnete.upbc.cashier.e.b
    protected void b() {
        com.gnete.upbc.cashier.f.b bVar = new com.gnete.upbc.cashier.f.b();
        bVar.show(this.f3290a.getFragmentManager(), "WXPAY_LOADING");
        com.gnete.upbc.cashier.a.g.a(this.b.a()).a(new a(bVar));
    }

    @Override // com.gnete.upbc.cashier.e.b
    protected void e() {
        if (this.b.e().b().contains(com.gnete.upbc.cashier.b.f.WXPAY)) {
            return;
        }
        com.gnete.upbc.cashier.g.b.a(this.f3290a, this.b, "订单不支持微信支付", (Throwable) null, this.c);
    }

    public g(Activity activity, com.gnete.upbc.cashier.b.b bVar, GnetePayListener gnetePayListener) {
        super(activity, bVar, gnetePayListener);
    }
}
