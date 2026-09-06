package com.opos.mobad.p;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.R;
import com.huawei.openalliance.ad.constant.br;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class b extends com.opos.mobad.m.f {
    private final com.opos.mobad.b f;
    private f.a g;
    private boolean h;
    private com.opos.mobad.template.a i;
    private String j;
    private Activity k;
    private com.opos.mobad.cmn.a.d l;
    private Dialog m;
    private final long n;

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, d dVar) {
        this(bVar, str, aVar, dVar, null);
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, d dVar, com.opos.mobad.cmn.a.b bVar2) {
        super(bVar, str, aVar, null, dVar);
        this.g = null;
        this.h = false;
        this.n = 500L;
        this.f = bVar.c();
        this.j = str;
        if (bVar2 != null) {
            this.l = new com.opos.mobad.cmn.a.d(bVar2);
        }
    }

    private void a(Activity activity, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.a("InterSplash$Presenter", "illegal url");
            return;
        }
        this.i.a();
        c();
        this.m = com.opos.mobad.ui.b.e.a(activity, activity.getString(i), str, new com.opos.mobad.ui.b.e.b() { // from class: com.opos.mobad.p.b.2
            @Override // com.opos.mobad.ui.b.e.b
            public void a() {
                if (b.this.h) {
                    return;
                }
                b.this.i.b();
            }
        });
    }

    private void a(com.opos.mobad.cmn.a.d dVar, int i) {
        ComplianceInfo complianceInfoA = com.opos.mobad.cmn.func.b.a(this.g.b.c);
        this.i.a();
        dVar.a(this.f.b(), i, complianceInfoA, new com.opos.mobad.ad.privacy.b.a() { // from class: com.opos.mobad.p.b.3
            @Override // com.opos.mobad.ad.privacy.b.a
            public void a() {
                if (b.this.h) {
                    return;
                }
                b.this.i.b();
            }
        });
    }

    private void c() {
        Activity activity;
        Dialog dialog = this.m;
        if (dialog == null || !dialog.isShowing() || (activity = this.k) == null || activity.isFinishing() || this.k.isDestroyed()) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "dialog not dismiss for finishing");
        } else {
            this.m.dismiss();
        }
    }

    private void f() {
        c();
        com.opos.mobad.cmn.a.d dVar = this.l;
        if (dVar != null) {
            dVar.a();
            this.l = null;
        }
    }

    public View a() {
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "getSplashView" + this.i);
        com.opos.mobad.template.a aVar = this.i;
        if (aVar == null) {
            return null;
        }
        return aVar.c();
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void a(long j, long j2) {
        this.b.a(j2);
        this.f7144a.b(false, null, this.d);
    }

    public void a(Activity activity) {
        this.k = activity;
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(View view, int[] iArr) {
    }

    public void a(f.a aVar, com.opos.mobad.template.a aVar2, com.opos.mobad.template.e eVar, com.opos.mobad.template.d dVar, String str) {
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "createSplash");
        if (aVar == null) {
            com.opos.cmn.an.f.a.c("InterSplash$Presenter", "create splash failed,splashVo Data is null!");
            return;
        }
        if (aVar2 == null) {
            com.opos.cmn.an.f.a.c("InterSplash$Presenter", "create splash failed,ad template is null!");
            return;
        }
        this.i = aVar2;
        aVar2.a(this);
        this.g = aVar;
        a(aVar.b.c, aVar.b.d, aVar.a(), this.i.e(), str);
        this.i.a(f.a(this.f, aVar, eVar, dVar, this.i.e()));
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void a(Map<String, String> map) {
        super.a(this.i.c(), map);
    }

    @Override // com.opos.mobad.m.f
    protected boolean a(View view, final int[] iArr, com.opos.mobad.cmn.func.b.a aVar) {
        boolean zA = super.a(view, iArr, aVar);
        if (zA) {
            com.opos.mobad.template.a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a();
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.p.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.f7144a.b(false, iArr, b.this.d);
                }
            }, 100L);
        }
        return zA;
    }

    @Override // com.opos.mobad.m.f
    public void b() {
        if (this.h) {
            return;
        }
        synchronized (b.class) {
            super.b();
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "destroy");
            com.opos.mobad.template.a aVar = this.i;
            if (aVar != null) {
                aVar.d();
            }
            f();
            this.k = null;
            this.h = true;
        }
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void b(View view, int[] iArr) {
        ComplianceInfo complianceInfoA = com.opos.mobad.cmn.func.b.a(this.g.b.c);
        if (complianceInfoA == null) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "show pri but null data");
            return;
        }
        Activity activity = this.k;
        if (activity != null && !activity.isFinishing()) {
            a(this.k, complianceInfoA.a(), R.string.opos_mob_privacy_title);
            return;
        }
        com.opos.mobad.cmn.a.d dVar = this.l;
        if (dVar != null) {
            a(dVar, 0);
        } else {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "error activity");
        }
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void b(Map<String, String> map) {
        int i;
        super.b(map);
        try {
            i = Integer.parseInt(map.get(br.f.m));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("InterSplash$Presenter", "onError", e);
            i = 0;
        }
        a(i);
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void c(View view, int[] iArr) {
        ComplianceInfo complianceInfoA = com.opos.mobad.cmn.func.b.a(this.g.b.c);
        if (complianceInfoA == null) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "show per but null data");
            return;
        }
        Activity activity = this.k;
        if (activity != null && !activity.isFinishing()) {
            a(this.k, complianceInfoA.b(), R.string.opos_mob_permission_title);
            return;
        }
        com.opos.mobad.cmn.a.d dVar = this.l;
        if (dVar != null) {
            a(dVar, 1);
        } else {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "error activity");
        }
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void d(long j, long j2) {
        long jA = this.g.a();
        if (j2 > 0) {
            jA = Math.min(j2, this.g.a());
        }
        super.d(j, jA);
        if (j2 <= this.g.a() + 500 || this.g.c) {
            return;
        }
        com.opos.cmn.an.f.a.b("InterSplash$Presenter", "report material video over time " + (this.g.a() + 500));
        this.g.c = true;
        this.f.i().a(this.g.b.d.X());
    }

    @Override // com.opos.mobad.template.a.InterfaceC1003a
    public void d(View view, int[] iArr) {
        ComplianceInfo complianceInfoA = com.opos.mobad.cmn.func.b.a(this.g.b.c);
        if (complianceInfoA == null) {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "show desc but null data");
            return;
        }
        Activity activity = this.k;
        if (activity != null && !activity.isFinishing()) {
            a(this.k, complianceInfoA.c(), R.string.opos_mob_app_desc_title);
            return;
        }
        com.opos.mobad.cmn.a.d dVar = this.l;
        if (dVar != null) {
            a(dVar, 2);
        } else {
            com.opos.cmn.an.f.a.b("InterSplash$Presenter", "error activity");
        }
    }

    @Override // com.opos.mobad.m.f, com.opos.mobad.template.a.InterfaceC1003a
    public void e(View view, int[] iArr) {
        this.f7144a.b(true, iArr, this.d);
    }
}
