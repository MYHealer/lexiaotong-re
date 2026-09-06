package com.gnete.upbc.cashier.e;

import android.app.Activity;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.GnetePayRequest;
import com.gnete.upbc.cashier.b.j;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: CASHIERHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class c extends b {

    /* JADX INFO: compiled from: CASHIERHandler.java */
    class a implements Comparator<com.gnete.upbc.cashier.b.f> {
        a(c cVar) {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(com.gnete.upbc.cashier.b.f fVar, com.gnete.upbc.cashier.b.f fVar2) {
            int iC = fVar.c();
            int iC2 = fVar2.c();
            if (iC > iC2) {
                return 1;
            }
            return iC < iC2 ? -1 : 0;
        }
    }

    public c(Activity activity, GnetePayRequest gnetePayRequest, GnetePayListener gnetePayListener) {
        super(activity, gnetePayRequest, gnetePayListener);
    }

    @Override // com.gnete.upbc.cashier.e.b
    public void a(j jVar, b.InterfaceC0387b interfaceC0387b) {
    }

    @Override // com.gnete.upbc.cashier.e.b
    protected void b() {
        List<com.gnete.upbc.cashier.b.f> listB = this.b.e().b();
        if (listB.size() == 1) {
            this.b.a(listB.get(0).d());
            Activity activity = this.f3290a;
            com.gnete.upbc.cashier.b.b bVar = this.b;
            f.a(activity, bVar.a(bVar.e()), this.c).d();
            return;
        }
        com.gnete.upbc.cashier.d.a aVar = new com.gnete.upbc.cashier.d.a();
        aVar.a(this.b);
        aVar.a(this.c);
        aVar.show(this.f3290a.getFragmentManager(), "GNETE_CASHIER");
    }

    @Override // com.gnete.upbc.cashier.e.b
    protected void e() {
        Collections.sort(this.b.e().b(), new a(this));
    }
}
