package com.opos.mobad.template.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ab extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RelativeLayout f8036a;
    private View b;
    private int c;
    private View d;
    private com.opos.mobad.d.d.a e;
    private boolean f;
    private com.opos.mobad.d.d.b g;
    private b h;

    private ab(Context context, com.opos.mobad.d.d.a aVar) {
        super(context);
        this.f = false;
        com.opos.mobad.d.d.b bVar = new com.opos.mobad.d.d.b() { // from class: com.opos.mobad.template.h.ab.3
            @Override // com.opos.mobad.d.d.b
            public void a(Map<String, String> map) {
                if (ab.this.h != null) {
                    ab.this.h.b(map);
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void c() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onPrepare");
                if (ab.this.h != null) {
                    ab.this.h.e();
                }
            }

            @Override // com.opos.mobad.d.d.b
            public void d() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onStart");
                if (ab.this.h != null) {
                    ab.this.h.d(0L, ab.this.e != null ? ab.this.e.c() : 0L);
                }
                ab.this.h();
            }

            @Override // com.opos.mobad.d.d.b
            public void e() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onComplete");
                if (ab.this.e == null || ab.this.h == null) {
                    return;
                }
                ab.this.h.a(ab.this.e.c(), ab.this.e.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void f() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onResume");
                ab.this.h();
                if (ab.this.h == null || ab.this.e == null) {
                    return;
                }
                ab.this.h.b(ab.this.e.d(), ab.this.e.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void g() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onPause");
                if (ab.this.h == null || ab.this.e == null) {
                    return;
                }
                ab.this.h.c(ab.this.e.d(), ab.this.e.c());
            }

            @Override // com.opos.mobad.d.d.b
            public void h() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingStart");
                ab.this.i();
            }

            @Override // com.opos.mobad.d.d.b
            public void i() {
                com.opos.cmn.an.f.a.b("RewardVideoView", "onBufferingEnd");
                ab.this.h();
            }

            @Override // com.opos.mobad.d.d.b
            public void j() {
                if (ab.this.h != null) {
                    ab.this.h.a();
                }
            }
        };
        this.g = bVar;
        this.e = aVar;
        aVar.a(bVar);
        a(context);
    }

    public static ab a(Context context, com.opos.mobad.d.d.a aVar) {
        return new ab(context, aVar);
    }

    private void a(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.c = View.generateViewId();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f8036a = relativeLayout;
        relativeLayout.setId(this.c);
        addView(this.f8036a, new RelativeLayout.LayoutParams(-1, -1));
        this.b = this.e.b();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f8036a.addView(this.b, layoutParams);
        com.opos.mobad.template.cmn.baseview.d dVar = new com.opos.mobad.template.cmn.baseview.d(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(7, this.c);
        layoutParams2.addRule(5, this.c);
        layoutParams2.addRule(6, this.c);
        layoutParams2.addRule(8, this.c);
        this.f8036a.addView(dVar, layoutParams2);
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.ab.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (ab.this.h != null) {
                    ab.this.h.f(view, iArr);
                }
            }
        };
        dVar.setOnTouchListener(pVar);
        dVar.setOnClickListener(pVar);
        dVar.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.h.ab.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("RewardVideoView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                if (ab.this.h != null) {
                    ab.this.h.a(view, i, z);
                }
            }
        });
        this.d = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(context, 20.0f), com.opos.cmn.an.h.f.a.a(context, 29.0f));
        layoutParams3.addRule(13);
        this.d.setVisibility(0);
        this.f8036a.addView(this.d, layoutParams3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.d.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        this.d.setVisibility(0);
    }

    public void a() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "stop mPlayer is null");
            return;
        }
        this.f = true;
        int i = aVar.i();
        com.opos.mobad.d.d.a aVar2 = this.e;
        if (i == 2) {
            aVar2.f();
        }
    }

    public void a(int i) {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            return;
        }
        aVar.a(i == 1 ? 1.0f : 0.0f);
    }

    public void a(com.opos.mobad.template.d.c cVar) {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "mPlayer is null");
        } else {
            aVar.a(cVar.M.f7535a, false);
            a(cVar.A);
        }
    }

    public void a(b bVar) {
        com.opos.cmn.an.f.a.b("RewardVideoView", "setListener " + bVar);
        this.h = bVar;
    }

    public com.opos.mobad.d.d.a b() {
        return this.e;
    }

    public void c() {
        if (this.e == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "stop mPlayer is null");
        } else {
            e();
        }
    }

    public void d() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar != null) {
            aVar.f();
            this.e.h();
            this.e = null;
        }
    }

    public void e() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.b("RewardVideoView", "mPlayer is null");
        } else if (aVar.i() != 5) {
            this.e.g();
        }
    }

    public int f() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            return 0;
        }
        try {
            return (int) aVar.d();
        } catch (Exception unused) {
            return 0;
        }
    }

    public int g() {
        com.opos.mobad.d.d.a aVar = this.e;
        if (aVar == null) {
            return 0;
        }
        try {
            return (int) aVar.c();
        } catch (Exception unused) {
            return 0;
        }
    }
}
