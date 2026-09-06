package com.opos.mobad.model.a;

import android.content.Context;
import android.content.pm.Signature;
import com.opos.mobad.b.a.ac;
import com.opos.mobad.b.a.ad;
import com.opos.mobad.b.a.ae;
import com.opos.mobad.b.a.af;
import com.opos.mobad.b.a.ag;
import com.opos.mobad.b.a.ak;
import com.opos.mobad.b.a.al;
import com.opos.mobad.b.a.n;
import com.opos.mobad.b.a.w;
import com.opos.mobad.b.a.z;
import com.stub.StubApp;
import com.tencent.mm.opensdk.constants.Build;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f implements com.opos.mobad.model.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<com.opos.mobad.b.a.f> f7155a;
    private Context b;
    private boolean c;

    public f(Context context) {
        if (context == null) {
            return;
        }
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.opos.cmn.an.i.e.a(new Runnable() { // from class: com.opos.mobad.model.a.f.1
            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                fVar.f7155a = fVar.a(fVar.b);
            }
        });
    }

    private ac.b a(int i) {
        ac.b bVar = ac.b.UNKNOWN;
        switch (i) {
            case 1:
                return ac.b.BANNER;
            case 2:
                return ac.b.POP_WINDOW;
            case 3:
            case 6:
                return ac.b.SPLASH_SCREEN;
            case 4:
                return ac.b.RAW;
            case 5:
                return ac.b.REWARD_VIDEO;
            default:
                return bVar;
        }
    }

    private List<com.opos.mobad.b.a.f> a() {
        List<com.opos.mobad.b.a.f> list = this.f7155a;
        if (list == null || list.size() <= 0) {
            this.f7155a = a(this.b);
        }
        return this.f7155a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.b.a.f> a(Context context) {
        String strA;
        ArrayList arrayList = null;
        if (context == null) {
            return null;
        }
        Signature[] signatureArrA = com.opos.cmn.i.l.a(context);
        if (signatureArrA != null && signatureArrA.length > 0) {
            arrayList = new ArrayList(signatureArrA.length);
            for (Signature signature : signatureArrA) {
                try {
                    strA = com.opos.cmn.i.l.a("sha1", signature);
                } catch (Exception unused) {
                    strA = "";
                }
                com.opos.cmn.an.f.a.a("FetchAdProtocolParser", "md5Sign=,sha1Sign=" + strA + ",sha256Sign=");
                arrayList.add(new com.opos.mobad.b.a.f("", strA, ""));
            }
        }
        return arrayList;
    }

    private ag b(int i) {
        if (i == 3) {
            return ag.SPLASH;
        }
        return i == 6 ? ag.HOT_SPLASH : ag.UNKNOWN;
    }

    private String b() {
        Object[] objArr = new Object[2];
        objArr[0] = "26";
        objArr[1] = this.c ? ", 30" : "";
        return String.format("%s%s", objArr);
    }

    private n c() {
        try {
            return com.opos.mobad.service.g.a.a(this.b);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("FetchAdProtocolParser", "getDevInfo:", th);
            return null;
        }
    }

    private ak d() {
        try {
            return new ak(Integer.valueOf(Build.SDK_INT), Integer.valueOf(com.opos.mobad.cmn.func.b.i.b(this.b)));
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("FetchAdProtocolParser", "getWxInfo:", th);
            return null;
        }
    }

    @Override // com.opos.mobad.model.b.c
    public com.opos.mobad.model.c.d a(byte[] bArr) throws IOException {
        com.opos.mobad.b.a.d dVarA = com.opos.mobad.b.a.d.c.a(bArr);
        if (dVarA == null) {
            return null;
        }
        com.opos.cmn.an.f.a.a("FetchAdProtocolParser", "parseResponse = ", dVarA);
        return new com.opos.mobad.model.c.d(dVarA);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:20:0x00fc  */
    @Override // com.opos.mobad.model.b.c
    public byte[] a(com.opos.mobad.b bVar, com.opos.mobad.model.c.c cVar) {
        af afVar;
        List<com.opos.mobad.b.a.f> listA;
        com.opos.cmn.an.f.a.b("FetchAdProtocolParser", "parseRequest() start");
        com.opos.mobad.b.a.h hVarA = com.opos.mobad.service.g.a.a(bVar.b(), bVar.d(), bVar.e(), bVar.f());
        ae aeVarE = com.opos.mobad.service.g.a.e();
        ac acVarB = new ac.a().a(cVar.d()).a(a(cVar.e())).a(new ad.a().a(Integer.valueOf(cVar.f())).b(Integer.valueOf(cVar.g())).b()).a(b(cVar.e())).a(Integer.valueOf(cVar.h())).b();
        n nVarB = c().c().a(Integer.valueOf(cVar.n())).b(Integer.valueOf(cVar.o())).c(Integer.valueOf(cVar.p())).b();
        z zVarB = com.opos.mobad.service.g.a.b(this.b);
        w wVarA = com.opos.mobad.service.g.a.a();
        al alVarB = com.opos.mobad.service.g.a.b();
        com.opos.mobad.b.a.c.a aVar = new com.opos.mobad.b.a.c.a();
        if (cVar.b() != 1) {
            if (cVar.b() == 2) {
                afVar = af.MODE_TWO;
            }
            listA = a();
            if (listA != null && listA.size() > 0) {
                aVar.a(listA);
            }
            aVar.a(com.opos.mobad.b.a.c.EnumC0941c.SDK);
            if (cVar.l() != null) {
                aVar.b(cVar.l());
            }
            this.c = cVar.e() == 5;
            com.opos.mobad.b.a.c cVarB = aVar.a(Integer.valueOf(cVar.c())).a(hVarA).a(aeVarE).a(acVarB).a(nVarB).a(com.opos.mobad.service.e.d.a().p()).a(zVarB).a(com.opos.mobad.service.g.a.c()).a(wVarA).a(alVarB).a(Boolean.valueOf(com.opos.mobad.service.d.a.a().k())).b(cVar.a()).b(Boolean.valueOf(com.opos.mobad.service.d.a.a().e())).c(com.opos.mobad.service.e.d.a().s()).a(Long.valueOf(bVar.n().d())).d(cVar.i()).e(bVar.a()).g(cVar.k()).f(cVar.j()).b(Long.valueOf(com.opos.mobad.service.e.b.n().r())).a(d()).h(b()).c(Boolean.valueOf(cVar.m())).b();
            com.opos.cmn.an.f.a.a("FetchAdProtocolParser", "FetchAdRequest = ", cVarB);
            return com.opos.mobad.b.a.c.c.b(cVarB);
        }
        afVar = af.MODE_ONE;
        aVar.a(afVar);
        listA = a();
        if (listA != null) {
            aVar.a(listA);
        }
        aVar.a(com.opos.mobad.b.a.c.EnumC0941c.SDK);
        if (cVar.l() != null) {
            aVar.b(cVar.l());
        }
        this.c = cVar.e() == 5;
        com.opos.mobad.b.a.c cVarB2 = aVar.a(Integer.valueOf(cVar.c())).a(hVarA).a(aeVarE).a(acVarB).a(nVarB).a(com.opos.mobad.service.e.d.a().p()).a(zVarB).a(com.opos.mobad.service.g.a.c()).a(wVarA).a(alVarB).a(Boolean.valueOf(com.opos.mobad.service.d.a.a().k())).b(cVar.a()).b(Boolean.valueOf(com.opos.mobad.service.d.a.a().e())).c(com.opos.mobad.service.e.d.a().s()).a(Long.valueOf(bVar.n().d())).d(cVar.i()).e(bVar.a()).g(cVar.k()).f(cVar.j()).b(Long.valueOf(com.opos.mobad.service.e.b.n().r())).a(d()).h(b()).c(Boolean.valueOf(cVar.m())).b();
        com.opos.cmn.an.f.a.a("FetchAdProtocolParser", "FetchAdRequest = ", cVarB2);
        return com.opos.mobad.b.a.c.c.b(cVarB2);
    }
}
