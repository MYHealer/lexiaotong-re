package com.opos.mobad.activity;

import com.opos.mobad.activity.webview.b.d;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.mobad.activity.webview.b.c, d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.t.a f6592a;
    private com.opos.mobad.t.c b;
    private com.opos.mobad.t.b c;

    public a(com.opos.mobad.t.a aVar, com.opos.mobad.t.b bVar, com.opos.mobad.t.c cVar) {
        this.f6592a = aVar;
        this.c = bVar;
        this.b = cVar;
    }

    @Override // com.opos.mobad.activity.webview.b.c
    public void a() {
        com.opos.mobad.t.a aVar = this.f6592a;
        if (aVar != null) {
            try {
                aVar.a(this.c);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on show fail", e);
            }
        }
    }

    @Override // com.opos.mobad.activity.webview.b.d
    public void a(long j) {
        com.opos.mobad.t.c cVar = this.b;
        if (cVar != null) {
            try {
                cVar.a(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on video progress fail", e);
            }
        }
    }

    @Override // com.opos.mobad.activity.webview.b.d
    public void a(Map<String, String> map) {
        if (this.b != null) {
            try {
                this.b.a(com.opos.mobad.model.utils.c.a(map));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on video fail", e);
            }
        }
    }

    @Override // com.opos.mobad.activity.webview.b.c
    public void b() {
        com.opos.mobad.t.a aVar = this.f6592a;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on close fail", e);
            }
        }
    }

    @Override // com.opos.mobad.activity.webview.b.d
    public void b(long j) {
        com.opos.mobad.t.c cVar = this.b;
        if (cVar != null) {
            try {
                cVar.b(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on video pause fail", e);
            }
        }
    }

    @Override // com.opos.mobad.activity.webview.b.d
    public void c() {
        com.opos.mobad.t.c cVar = this.b;
        if (cVar != null) {
            try {
                cVar.a();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on video close fail", e);
            }
        }
    }

    @Override // com.opos.mobad.activity.webview.b.d
    public void c(long j) {
        com.opos.mobad.t.c cVar = this.b;
        if (cVar != null) {
            try {
                cVar.c(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on pause fail", e);
            }
        }
    }

    @Override // com.opos.mobad.activity.webview.b.d
    public void d() {
        com.opos.mobad.t.c cVar = this.b;
        if (cVar != null) {
            try {
                cVar.b();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on video start fail", e);
            }
        }
    }

    @Override // com.opos.mobad.activity.webview.b.d
    public void e() {
        com.opos.mobad.t.c cVar = this.b;
        if (cVar != null) {
            try {
                cVar.c();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("web_tag", "on video complete fail", e);
            }
        }
    }
}
