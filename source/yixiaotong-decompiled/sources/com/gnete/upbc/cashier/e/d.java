package com.gnete.upbc.cashier.e;

import android.app.Activity;
import android.text.TextUtils;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.GnetePayRequest;
import com.gnete.upbc.cashier.b.j;
import com.unionpay.UPPayAssistEx;

/* JADX INFO: compiled from: CUPPAYHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class d extends com.gnete.upbc.cashier.e.b {

    /* JADX INFO: compiled from: CUPPAYHandler.java */
    class a implements com.gnete.upbc.cashier.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.gnete.upbc.cashier.f.b f3292a;

        /* JADX INFO: renamed from: com.gnete.upbc.cashier.e.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CUPPAYHandler.java */
        class C0388a implements com.gnete.upbc.cashier.e.b.InterfaceC0387b {
            C0388a() {
            }

            @Override // com.gnete.upbc.cashier.e.b.InterfaceC0387b
            public void a() {
                com.gnete.upbc.cashier.g.b.a(GnetePayChannel.CUPPAY, d.this.c);
            }

            @Override // com.gnete.upbc.cashier.e.b.InterfaceC0387b
            public void a(String str, Throwable th) {
                d dVar = d.this;
                com.gnete.upbc.cashier.g.b.a(dVar.f3290a, dVar.b, str, th, dVar.c);
            }
        }

        a(com.gnete.upbc.cashier.f.b bVar) {
            this.f3292a = bVar;
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(com.gnete.upbc.cashier.b.a aVar) {
            d.this.a(aVar.b(), new C0388a());
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(String str, Throwable th) {
            d dVar = d.this;
            com.gnete.upbc.cashier.g.b.a(dVar.f3290a, dVar.b, str, th, dVar.c);
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a() {
            this.f3292a.dismissAllowingStateLoss();
        }
    }

    /* JADX INFO: compiled from: CUPPAYHandler.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3294a;

        b(String str) {
            this.f3294a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            UPPayAssistEx.startPay(d.this.f3290a, null, null, this.f3294a, "00");
        }
    }

    public d(Activity activity, GnetePayRequest gnetePayRequest, GnetePayListener gnetePayListener) {
        super(activity, gnetePayRequest, gnetePayListener);
    }

    @Override // com.gnete.upbc.cashier.e.b
    public void a(j jVar, com.gnete.upbc.cashier.e.b.InterfaceC0387b interfaceC0387b) {
        String strG = jVar.g();
        if (TextUtils.isEmpty(strG)) {
            interfaceC0387b.a("参数缺失[prepayId]", null);
        } else {
            this.f3290a.runOnUiThread(new b(strG));
            interfaceC0387b.a();
        }
    }

    @Override // com.gnete.upbc.cashier.e.b
    protected void b() {
        com.gnete.upbc.cashier.f.b bVar = new com.gnete.upbc.cashier.f.b();
        bVar.show(this.f3290a.getFragmentManager(), "CUPPAY_LOADING");
        com.gnete.upbc.cashier.a.g.a(this.b.a()).a(new a(bVar));
    }

    @Override // com.gnete.upbc.cashier.e.b
    protected void e() {
        if (this.b.e().b().contains(com.gnete.upbc.cashier.b.f.CUPPAY)) {
            return;
        }
        com.gnete.upbc.cashier.g.b.a(this.f3290a, this.b, "订单不支持云闪付支付", (Throwable) null, this.c);
    }

    public d(Activity activity, com.gnete.upbc.cashier.b.b bVar, GnetePayListener gnetePayListener) {
        super(activity, bVar, gnetePayListener);
    }
}
