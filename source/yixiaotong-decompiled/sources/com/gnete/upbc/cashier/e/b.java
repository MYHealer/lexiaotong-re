package com.gnete.upbc.cashier.e;

import android.app.Activity;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.GnetePayRequest;
import com.gnete.upbc.cashier.b.j;

/* JADX INFO: compiled from: AbstractPayHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Activity f3290a;
    protected com.gnete.upbc.cashier.b.b b;
    protected GnetePayListener c;

    /* JADX INFO: renamed from: com.gnete.upbc.cashier.e.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AbstractPayHandler.java */
    public interface InterfaceC0387b {
        void a();

        void a(String str, Throwable th);
    }

    public b(Activity activity, GnetePayRequest gnetePayRequest, GnetePayListener gnetePayListener) {
        this(activity, com.gnete.upbc.cashier.b.b.a(gnetePayRequest.chnlUrl), gnetePayListener);
        this.b.a(gnetePayRequest.payChannel);
    }

    @Override // com.gnete.upbc.cashier.e.e
    public void a() {
        if (com.gnete.upbc.cashier.a.i()) {
            com.gnete.upbc.cashier.c.a.a().a(this.f3290a, this.b);
        }
        c();
    }

    public abstract void a(j jVar, InterfaceC0387b interfaceC0387b);

    protected abstract void b();

    protected void c() {
        com.gnete.upbc.cashier.f.b bVar = new com.gnete.upbc.cashier.f.b();
        bVar.show(this.f3290a.getFragmentManager(), "ORDER_INFO_QUERY_LOADING");
        com.gnete.upbc.cashier.a.g.b(this.b.a()).a(new a(bVar));
    }

    public void d() {
        e();
        b();
    }

    protected abstract void e();

    /* JADX INFO: compiled from: AbstractPayHandler.java */
    class a implements com.gnete.upbc.cashier.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.gnete.upbc.cashier.f.b f3291a;

        a(com.gnete.upbc.cashier.f.b bVar) {
            this.f3291a = bVar;
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(com.gnete.upbc.cashier.b.a aVar) {
            b.this.b.b(aVar.a());
            b.this.d();
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(String str, Throwable th) {
            b bVar = b.this;
            com.gnete.upbc.cashier.g.b.a(bVar.f3290a, bVar.b, str, th, bVar.c);
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a() {
            this.f3291a.dismissAllowingStateLoss();
        }
    }

    public b(Activity activity, com.gnete.upbc.cashier.b.b bVar, GnetePayListener gnetePayListener) {
        this.f3290a = activity;
        this.b = bVar;
        this.c = gnetePayListener;
    }
}
