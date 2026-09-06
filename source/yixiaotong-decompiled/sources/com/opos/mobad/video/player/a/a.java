package com.opos.mobad.video.player.a;

import com.opos.mobad.ad.f;
import com.opos.mobad.o.b;
import com.opos.mobad.o.c;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.opos.mobad.video.player.f.a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.o.a f8332a;
    private final b b;
    private boolean c = false;

    public a(com.opos.mobad.o.a aVar, b bVar) {
        this.f8332a = aVar;
        this.b = bVar;
    }

    @Override // com.opos.mobad.m.a.InterfaceC0974a
    public void a() {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.b();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onRenderSuccess fail", e);
            }
        }
    }

    @Override // com.opos.mobad.cmn.func.a.a.b
    public void a(int i, String str) {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.a(i, str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onShowFailed fail", e);
            }
        }
    }

    @Override // com.opos.mobad.ad.l.b
    public void a(long j) {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.a(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onAdClick fail", e);
            }
        }
    }

    @Override // com.opos.mobad.video.player.f.d
    public void a(c cVar) {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.a(cVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "getFallbackAd fail", e);
            }
        }
    }

    @Override // com.opos.mobad.ad.l.b
    public void a(String str) {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.a(str, this.b);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onAdShow fail", e);
            }
        }
    }

    @Override // com.opos.mobad.ad.f
    public void a(Map<String, String> map) {
        com.opos.cmn.an.f.a.b("ad_show", "onDlClick info=", map);
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.a(map);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onDlClick fail", e);
            }
        }
    }

    @Override // com.opos.mobad.ad.j
    public void a(Object... objArr) {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onReward fail", e);
            }
        }
    }

    @Override // com.opos.mobad.m.d.a
    public void b() {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.d();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onProcessStart fail", e);
            }
        }
    }

    @Override // com.opos.mobad.m.d.a
    public void b(long j) {
        com.opos.cmn.an.f.a.b("ad_show", "onProcessClose currentPos=", Long.valueOf(j));
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.a(j, !this.c);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onProcessClose fail", e);
            }
        }
    }

    @Override // com.opos.mobad.m.d.a
    public void b(String str) {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.a(str);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onProcessError fail", e);
            }
        }
    }

    @Override // com.opos.mobad.video.player.f.a, com.opos.mobad.ad.b.a
    public void c() {
        com.opos.cmn.an.f.a.b("ad_show", "onInstantExit()");
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.f();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onInstantExit()", e);
            }
        }
    }

    @Override // com.opos.mobad.cmn.func.a.a.b
    public void d() {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.c();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onClose fail", e);
            }
        }
    }

    @Override // com.opos.mobad.video.player.f.d
    public void e() {
        this.c = true;
    }

    @Override // com.opos.mobad.m.d.a
    public void g_() {
        com.opos.mobad.o.a aVar = this.f8332a;
        if (aVar != null) {
            try {
                aVar.e();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("ad_show", "onProcessComplete fail", e);
            }
        }
    }
}
