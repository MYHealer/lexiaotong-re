package com.opos.mobad.i;

import android.os.RemoteException;
import android.text.TextUtils;
import com.opos.mobad.ad.f;
import com.opos.mobad.cmn.func.b.e;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.video.player.d;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.mobad.cmn.func.a.a.InterfaceC0946a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f7038a;
    private String b;
    private AdHelper.AdHelperData c;
    private com.opos.mobad.cmn.func.adhandler.a d;
    private a e;
    private com.opos.mobad.cmn.func.a.a.b f;
    private d g;
    private BinderC0969b h;
    private c i;
    private volatile boolean j;

    /* JADX INFO: renamed from: com.opos.mobad.i.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface a {
        void a();

        void b();

        void c();
    }

    /* JADX INFO: renamed from: com.opos.mobad.i.b$b, reason: collision with other inner class name */
    private class BinderC0969b extends com.opos.mobad.o.a.AbstractBinderC0977a {
        private boolean b;

        private BinderC0969b() {
            this.b = false;
        }

        /* synthetic */ BinderC0969b(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.mobad.o.a
        public void a() {
        }

        @Override // com.opos.mobad.o.a
        public void a(int i, String str) {
        }

        @Override // com.opos.mobad.o.a
        public void a(long j) {
            if (b.this.j || b.this.e == null) {
                return;
            }
            b.this.e.a();
        }

        @Override // com.opos.mobad.o.a
        public void a(long j, boolean z) {
            if (!b.this.j && z) {
                b.this.f.d();
            }
        }

        @Override // com.opos.mobad.o.a
        public void a(com.opos.mobad.o.c cVar) throws RemoteException {
        }

        @Override // com.opos.mobad.o.a
        public void a(String str) {
            if (b.this.j) {
                return;
            }
            b.this.f.a(-1, str);
        }

        @Override // com.opos.mobad.o.a
        public void a(String str, com.opos.mobad.o.b bVar) {
        }

        @Override // com.opos.mobad.o.a
        public void a(Map map) throws RemoteException {
            if (b.this.e instanceof f) {
                ((f) b.this.e).a(map);
            }
        }

        @Override // com.opos.mobad.o.a
        public void b() {
        }

        @Override // com.opos.mobad.o.a
        public void c() {
        }

        @Override // com.opos.mobad.o.a
        public void d() {
            if (b.this.j) {
                return;
            }
            this.b = false;
            b.this.e.b();
        }

        @Override // com.opos.mobad.o.a
        public void e() {
            if (b.this.j) {
                return;
            }
            this.b = true;
            b.this.e.c();
        }

        @Override // com.opos.mobad.o.a
        public void f() throws RemoteException {
        }

        public void g() {
            this.b = false;
        }
    }

    private class c implements com.opos.mobad.activity.webview.b.c {
        private c() {
        }

        /* synthetic */ c(b bVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a() {
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b() {
            if (b.this.j) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.i.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.f != null) {
                        b.this.f.d();
                    }
                }
            });
        }
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, d dVar, a aVar2) {
        this.f7038a = bVar;
        this.b = str;
        this.e = aVar2;
        this.d = new com.opos.mobad.cmn.func.adhandler.a(this.f7038a, this.b, aVar);
        AnonymousClass1 anonymousClass1 = null;
        this.h = new BinderC0969b(this, anonymousClass1);
        this.i = new c(this, anonymousClass1);
        this.g = dVar;
    }

    private int a(AdHelper.AdHelperData adHelperData) {
        int iZ = adHelperData.d.Z();
        if (iZ != 60 && iZ != 62 && iZ != 63 && iZ != 80 && iZ != 81) {
            com.opos.cmn.an.f.a.b("InterstitialVideoPresenter", "illegal type");
            return 10409;
        }
        if (1 != adHelperData.c.t() && 2 != adHelperData.c.t()) {
            com.opos.cmn.an.f.a.b("InterstitialVideoPresenter", "illegal mode");
            return 10407;
        }
        if (adHelperData.c.t() == 1 && TextUtils.isEmpty(com.opos.cmn.d.d.a(this.f7038a.b(), adHelperData.e.a(), adHelperData.e.b()))) {
            com.opos.cmn.an.f.a.b("InterstitialVideoPresenter", "illegal cache url");
            return 10408;
        }
        if (!com.opos.cmn.an.h.c.a.d(this.f7038a.b())) {
            com.opos.cmn.an.f.a.b("InterstitialVideoPresenter", "no net");
            return 10403;
        }
        if (System.currentTimeMillis() <= adHelperData.c.u()) {
            return 10000;
        }
        com.opos.cmn.an.f.a.b("InterstitialVideoPresenter", "exp time");
        return 10404;
    }

    private void a(int i) {
        com.opos.mobad.cmn.func.a.a.b bVar = this.f;
        if (bVar != null) {
            bVar.a(i, com.opos.mobad.ad.a.a(i));
        }
    }

    private void a(int i, AdHelper.AdHelperData adHelperData, String str) {
        com.opos.mobad.b bVar;
        String strB;
        String str2;
        String str3;
        String strC;
        String strA;
        if (this.j) {
            return;
        }
        HashMap map = new HashMap();
        map.put("rsCode", "" + i);
        if (adHelperData == null) {
            bVar = this.f7038a;
            strB = "";
            str2 = this.b;
            str3 = "4";
            strC = "";
            strA = str;
        } else {
            map.put("clientTemplateId", String.valueOf(adHelperData.d.b()));
            bVar = this.f7038a;
            strB = adHelperData.c.b();
            str2 = this.b;
            str3 = "4";
            strC = adHelperData.c.c();
            strA = adHelperData.c.a();
        }
        e.a(bVar, strB, str2, str3, strC, strA, map);
        a(i);
    }

    private void a(String str) {
        a(10402, null, str);
    }

    public void a() {
        this.j = true;
        this.e = null;
    }

    public boolean a(AdHelper.AdHelperData adHelperData, int i, com.opos.mobad.cmn.func.a.a.b bVar, String str) {
        try {
            this.f = bVar;
            if (adHelperData == null) {
                a(str);
                return false;
            }
            int iA = a(adHelperData);
            if (10000 != iA) {
                a(iA, adHelperData, str);
                return false;
            }
            this.h.g();
            this.d.a(adHelperData.c);
            this.d.b(adHelperData.c);
            this.c = adHelperData;
            this.g.a(this.f7038a.b(), this.c, false, i, this.h, null, 3);
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterstitialVideoPresenter", "", (Throwable) e);
            return false;
        }
    }
}
