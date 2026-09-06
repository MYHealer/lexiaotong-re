package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import com.opos.mobad.cmn.func.adhandler.UnlockHandler;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f6619a;
    private c b;
    private WebDataHepler c;
    private Activity d;
    private com.opos.mobad.b e;
    private C0935b f;
    private com.opos.mobad.activity.a g;
    private a h;

    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: com.opos.mobad.activity.webview.b$b, reason: collision with other inner class name */
    private static class C0935b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.opos.mobad.cmn.func.a f6620a;
        public final com.opos.mobad.activity.webview.a.a b;
        public final com.opos.mobad.activity.webview.a.b c;

        private C0935b(com.opos.mobad.activity.webview.a.b bVar, com.opos.mobad.activity.webview.a.a aVar, com.opos.mobad.cmn.func.a aVar2) {
            this.f6620a = aVar2;
            this.b = aVar;
            this.c = bVar;
        }

        public static C0935b a(Activity activity, com.opos.mobad.b bVar, String str) {
            com.opos.mobad.cmn.func.a aVarB;
            com.opos.mobad.activity.webview.a.a aVar;
            com.opos.mobad.activity.webview.a.b bVarA;
            com.opos.mobad.activity.webview.a aVarC = com.opos.mobad.cmn.service.a.a().c();
            if (aVarC == null || (aVarB = com.opos.mobad.cmn.service.a.a().b()) == null || (bVarA = aVarC.a(activity, new com.opos.cmn.biz.web.c.b.c.a().b("ad_mob").a(true).a(str).a(), (aVar = new com.opos.mobad.activity.webview.a.a(bVar, new UnlockHandler(activity))))) == null) {
                return null;
            }
            return new C0935b(bVarA, aVar, aVarB);
        }

        public void a() {
            com.opos.mobad.activity.webview.a.b bVar = this.c;
            if (bVar != null) {
                bVar.a();
            }
            com.opos.mobad.activity.webview.a.a aVar = this.b;
            if (aVar != null) {
                aVar.f();
            }
        }
    }

    public b(Activity activity, com.opos.mobad.b bVar, WebDataHepler webDataHepler) {
        this.d = activity;
        this.e = bVar.c();
        this.c = webDataHepler;
        this.f = C0935b.a(activity, bVar, webDataHepler.c());
    }

    private void a(C0935b c0935b) {
        if (this.f6619a != null) {
            return;
        }
        HashMap map = new HashMap();
        if (c0935b != null) {
            map.put("mixad", c0935b.c);
        } else {
            com.opos.cmn.an.f.a.b("WebPresenter", "null jsEngine");
        }
        this.b = new c(this.d, this.e, new d(map, this.c.f(), this.c.h(), this.c.i()));
        e eVar = new e(this.d, this.e, this.b);
        this.f6619a = eVar;
        com.opos.mobad.activity.a aVar = this.g;
        if (aVar != null) {
            eVar.a((com.opos.mobad.activity.webview.b.c) aVar);
            this.f6619a.a((com.opos.mobad.activity.webview.b.d) this.g);
        }
        a aVar2 = this.h;
        if (aVar2 != null) {
            this.f6619a.a(aVar2);
        }
        if (c0935b != null) {
            c0935b.b.a(this.f6619a, this.c, c0935b.f6620a);
            c0935b.b.a(this.h);
        }
    }

    public void a() {
        com.opos.cmn.an.f.a.b("WebPresenter", "render");
        if (this.f6619a != null) {
            return;
        }
        a(this.f);
        this.f6619a.a(this.c);
    }

    public void a(com.opos.mobad.activity.a aVar) {
        this.g = aVar;
        e eVar = this.f6619a;
        if (eVar != null) {
            eVar.a((com.opos.mobad.activity.webview.b.c) aVar);
            this.f6619a.a((com.opos.mobad.activity.webview.b.d) aVar);
        }
    }

    public void a(a aVar) {
        this.h = aVar;
        C0935b c0935b = this.f;
        if (c0935b != null) {
            c0935b.b.a(aVar);
        }
        e eVar = this.f6619a;
        if (eVar != null) {
            eVar.a(aVar);
        }
    }

    public void a(com.opos.mobad.t.a aVar) {
        C0935b c0935b = this.f;
        if (c0935b != null) {
            c0935b.b.a(aVar);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        e eVar = this.f6619a;
        return eVar != null && eVar.a(i, keyEvent);
    }

    public void b() {
        c cVar = this.b;
        if (cVar == null) {
            return;
        }
        cVar.e();
    }

    public View c() {
        c cVar = this.b;
        if (cVar == null) {
            return null;
        }
        return cVar.d();
    }

    public void d() {
        C0935b c0935b = this.f;
        if (c0935b != null) {
            c0935b.a();
        }
        e eVar = this.f6619a;
        if (eVar != null) {
            eVar.b();
        }
    }
}
