package com.opos.mobad.k.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.openalliance.ad.constant.br;
import com.opos.mobad.ad.d.q;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends com.opos.mobad.m.f {
    private com.opos.mobad.b f;
    private AdItemData g;
    private MaterialData h;
    private boolean i;
    private com.opos.mobad.cmn.func.adhandler.a j;
    private com.opos.mobad.ui.feedback.a k;
    private final com.opos.mobad.template.a l;
    private boolean m;
    private boolean n;
    private boolean o;
    private com.opos.mobad.ad.privacy.b p;
    private com.opos.mobad.template.l.a q;
    private String r;
    private boolean s;
    private boolean t;
    private boolean u;

    public f(com.opos.mobad.b bVar, AdItemData adItemData, MaterialData materialData, String str, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.ui.feedback.a aVar2, com.opos.mobad.template.a aVar3, com.opos.mobad.cmn.service.pkginstall.c.b bVar2, com.opos.mobad.m.f.a aVar4, com.opos.mobad.ad.privacy.b bVar3, com.opos.mobad.template.l.a aVar5) {
        super(bVar, str, aVar, bVar2, aVar4);
        this.i = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.t = true;
        this.u = false;
        this.f = bVar;
        this.g = adItemData;
        this.h = materialData;
        this.r = str;
        this.j = aVar;
        this.l = aVar3;
        aVar3.a(this);
        this.n = materialData.W();
        this.q = aVar5;
        a(adItemData, materialData, aVar3.e(), adItemData.a());
        this.k = aVar2;
        aVar2.a(new com.opos.mobad.ui.feedback.b() { // from class: com.opos.mobad.k.b.f.1
            @Override // com.opos.mobad.ui.feedback.b
            public void a(int i) {
                f.this.f7144a.b(i);
                f.this.n = i == com.opos.mobad.ui.feedback.a.a.TAG_BLOCK_CONTENT.a() || i == com.opos.mobad.ui.feedback.a.a.TAG_CONTENT_COMPLAINT.a();
                if (f.this.n || f.this.l == null) {
                    return;
                }
                f fVar = f.this;
                fVar.e(fVar.l.c(), null);
            }

            @Override // com.opos.mobad.ui.feedback.b
            public void a(boolean z) {
                if (z) {
                    f.this.n = false;
                    f.this.l.a(com.opos.mobad.model.a.a(f.this.f.b(), f.this.f, f.this.g, f.this.h, f.this.m, f.this.n, f.this.l.e(), f.this.t));
                }
            }

            @Override // com.opos.mobad.ui.feedback.b
            public void b(boolean z) {
                if (f.this.l != null) {
                    if (z) {
                        f.this.l.b();
                    } else {
                        f.this.l.a();
                    }
                }
            }
        });
        this.p = bVar3;
    }

    public static q a(int i, String str) {
        String str2;
        q qVar = new q(i, str);
        if (i != 1000) {
            if (i == 1001) {
                qVar.a(10301);
                str2 = "render ad failed,ad item data is null.";
            }
            return qVar;
        }
        qVar.a(10300);
        str2 = "render ad failed,now time over ad expire time.";
        qVar.a(str2);
        return qVar;
    }

    private ComplianceInfo a(AdItemData adItemData) {
        if (adItemData == null || adItemData.T() == null) {
            return null;
        }
        return com.opos.mobad.cmn.func.b.a(adItemData);
    }

    public void a() {
        if (this.i) {
            a(1000);
        } else {
            if (this.u) {
                return;
            }
            this.u = true;
            this.l.a(com.opos.mobad.model.a.a(this.f.b(), this.f, this.g, this.h, this.m, this.n, this.l.e(), this.t));
        }
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void a(long j, long j2) {
        super.a(j, j2);
        this.o = true;
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(View view, int[] iArr) {
        this.k.a(view);
    }

    public void a(String str) {
        com.opos.cmn.an.f.a.b("NativeTemplatePresenter", "notifyInstallCompletedEvent pkgname =" + str);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.h.i()) || !this.h.i().equals(str)) {
            return;
        }
        this.m = true;
        this.l.a(com.opos.mobad.model.a.a(this.f.b(), this.f, this.g, this.h, this.m, this.n, this.l.e(), this.t));
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(Map<String, String> map) {
        super.a(this.l.c(), map);
    }

    @Override // com.opos.mobad.m.f
    protected boolean a(View view, int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        boolean zA = super.a(view, iArr, aVar);
        if (zA) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.k.b.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.this.k(null, null);
                    com.opos.cmn.an.f.a.b("NativeTemplatePresenter", "close ad after click");
                }
            }, 500L);
        }
        return zA;
    }

    @Override // com.opos.mobad.m.f
    public void b() {
        super.b();
        com.opos.mobad.ad.privacy.b bVar = this.p;
        if (bVar != null) {
            bVar.a();
        }
        this.j = null;
        this.i = true;
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void b(long j, long j2) {
        super.b(j, j2);
        this.o = false;
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void b(View view, int[] iArr) {
        Context contextB = (view == null || !(view.getContext() instanceof Activity)) ? null : (Activity) view.getContext();
        com.opos.mobad.ad.privacy.b bVar = this.p;
        if (contextB == null) {
            contextB = this.f.b();
        }
        bVar.a(contextB, 0, a(this.g), null);
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void b(Map<String, String> map) {
        int i;
        super.b(map);
        try {
            i = Integer.parseInt(map.get(br.f.m));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("NativeTemplatePresenter", "onError", e);
            i = 0;
        }
        a(i);
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void c(long j, long j2) {
        super.b(j, j2);
        this.o = true;
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void c(View view, int[] iArr) {
        Context contextB = (view == null || !(view.getContext() instanceof Activity)) ? null : (Activity) view.getContext();
        com.opos.mobad.ad.privacy.b bVar = this.p;
        if (contextB == null) {
            contextB = this.f.b();
        }
        bVar.a(contextB, 1, a(this.g), null);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void d(View view, int[] iArr) {
        Context contextB = (view == null || !(view.getContext() instanceof Activity)) ? null : (Activity) view.getContext();
        com.opos.mobad.ad.privacy.b bVar = this.p;
        if (contextB == null) {
            contextB = this.f.b();
        }
        bVar.a(contextB, 2, a(this.g), null);
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void e(View view, int[] iArr) {
        super.e(view, iArr);
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void f(View view, int[] iArr) {
        if (a(view, iArr, com.opos.mobad.cmn.func.b.a.VIDEO)) {
            return;
        }
        if (this.o) {
            this.o = false;
            this.l.b();
        } else {
            this.o = true;
            this.l.a();
        }
        this.s = true;
    }
}
