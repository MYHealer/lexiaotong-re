package com.opos.mobad.h;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.utils.AdHelper;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.video.player.b.b f7028a;
    private com.opos.mobad.video.player.e.a b;
    private com.opos.mobad.video.player.b.c c;
    private com.opos.mobad.template.a d;
    private AdHelper.AdHelperData e;
    private int f;
    private FrameLayout g;
    private boolean h = false;
    private com.opos.mobad.ui.feedback.a i;
    private Bundle j;
    private final com.opos.mobad.video.player.f.a k;

    public d(Activity activity, com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.adhandler.a aVar, com.opos.mobad.video.player.b.b bVar2, com.opos.mobad.video.player.b.c cVar, AdHelper.AdHelperData adHelperData, int i, Bundle bundle) {
        com.opos.mobad.video.player.f.a aVar2 = new com.opos.mobad.video.player.f.a() { // from class: com.opos.mobad.h.d.2
            @Override // com.opos.mobad.m.a.InterfaceC0974a
            public void a() {
                if (d.this.c != null) {
                    d.this.c.a();
                }
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void a(int i2, String str2) {
                if (d.this.c != null) {
                    d.this.c.a(i2, str2);
                }
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(long j) {
                if (d.this.c != null) {
                    d.this.c.a(j);
                }
            }

            @Override // com.opos.mobad.video.player.f.d
            public void a(com.opos.mobad.o.c cVar2) {
            }

            @Override // com.opos.mobad.ad.l.b
            public void a(String str2) {
                if (d.this.c != null) {
                    d.this.c.a(str2);
                }
            }

            @Override // com.opos.mobad.ad.j
            public void a(Object... objArr) {
            }

            @Override // com.opos.mobad.m.d.a
            public void b() {
            }

            @Override // com.opos.mobad.m.d.a
            public void b(long j) {
            }

            @Override // com.opos.mobad.m.d.a
            public void b(String str2) {
                if (d.this.c != null) {
                    d.this.c.a(-1, str2);
                }
            }

            @Override // com.opos.mobad.video.player.f.a, com.opos.mobad.ad.b.a
            public void c() {
                if (d.this.c instanceof com.opos.mobad.ad.b.a) {
                    ((com.opos.mobad.ad.b.a) d.this.c).c();
                }
            }

            @Override // com.opos.mobad.cmn.func.a.a.b
            public void d() {
                if (d.this.c != null) {
                    d.this.c.d();
                }
            }

            @Override // com.opos.mobad.video.player.f.d
            public void e() {
            }

            @Override // com.opos.mobad.m.d.a
            public void g_() {
                if (d.this.c != null) {
                    d.this.c.g_();
                }
            }
        };
        this.k = aVar2;
        this.f7028a = bVar2;
        this.c = cVar;
        this.e = adHelperData;
        this.f = i;
        this.i = new com.opos.mobad.ui.feedback.a(activity, null);
        this.j = bundle;
        this.d = com.opos.mobad.video.player.d.a.a(activity, adHelperData.c, adHelperData.d, bundle, null);
        com.opos.mobad.template.a aVarA = com.opos.mobad.video.player.g.b.a.a().a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), adHelperData.c, (com.opos.mobad.template.a.InterfaceC1003a) null);
        com.opos.mobad.template.a aVarA2 = com.opos.mobad.video.player.g.b.b.a().a(activity, adHelperData.d, null);
        this.b = new com.opos.mobad.video.player.e.a(activity, bVar, str, aVar, new com.opos.mobad.video.player.e.b.a(this.d, new com.opos.mobad.video.player.b(activity), this.i).a(aVarA).b(aVarA2).a(), new com.opos.mobad.video.player.f.b(aVar2), null, b());
        FrameLayout frameLayout = new FrameLayout(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
        this.g = frameLayout;
        frameLayout.addView(this.d.c());
        if (aVarA != null && aVarA.c() != null) {
            View viewC = aVarA.c();
            viewC.setVisibility(8);
            this.g.addView(viewC);
        }
        if (aVarA2 != null && aVarA2.c() != null) {
            View viewC2 = aVarA2.c();
            viewC2.setVisibility(8);
            this.g.addView(viewC2);
        }
        this.f7028a.a(new com.opos.mobad.video.player.b.a() { // from class: com.opos.mobad.h.d.1
            @Override // com.opos.mobad.video.player.b.a
            public void a() {
                d.this.b.d();
            }
        });
    }

    private int b() {
        Bundle bundle = this.j;
        return (bundle == null || bundle.getInt("interstitial_scene") != com.opos.mobad.ad.c.e.b.INSTANT_EXIT.ordinal()) ? 2 : 4;
    }

    @Override // com.opos.mobad.h.a
    public void a() {
        if (this.h) {
            return;
        }
        this.h = true;
        this.f7028a.a();
        this.b.b();
    }

    @Override // com.opos.mobad.h.a
    public boolean a(Activity activity, String str) {
        boolean zA = this.b.a(this.e.c, this.e.d, this.f, (com.opos.mobad.video.player.c) null);
        if (zA) {
            this.f7028a.a(activity, this.g);
            if (this.e.c != null && this.e.c.U() != null) {
                this.i.a(this.e.c.U());
            }
        }
        return zA;
    }
}
