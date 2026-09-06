package com.opos.mobad.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.stub.StubApp;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.a f8311a;
    private a b;
    private g c;
    private Context d;

    public class a implements com.opos.mobad.template.a.InterfaceC1003a {
        private com.opos.mobad.template.a.InterfaceC1003a b;

        public a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
            this.b = interfaceC1003a;
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(int i) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(i);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(int i, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(i, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(long j, long j2) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(View view, int i, boolean z) {
            com.opos.cmn.an.f.a.b("AdTemplateWrapper", "onViewMockEventIntercept->view:" + view.getClass().getName() + ";clickMockEvent:" + i + ";disAllowClick:" + z);
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(view, i, z);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(View view, int[] iArr, boolean z) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(view, c.this.c.a(), z);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(Map<String, String> map) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(map);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void b(long j, long j2) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.b(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void b(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.b(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void b(Map<String, String> map) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.b(map);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void b(int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.b(iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void c(int i) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.c(i);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void c(long j, long j2) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.c(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void c(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.c(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void d(long j, long j2) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.d(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void d(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.d(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void e() {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.e();
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void e(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.e(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void f(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.f(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void g(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.g(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void h(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.h(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void i(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.i(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void j(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.j(view, c.this.c.a());
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void l(View view, int[] iArr) {
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.l(view, c.this.c.a());
            }
        }
    }

    public c(Context context, com.opos.mobad.template.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.d = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f8311a = aVar;
        a aVar2 = new a(interfaceC1003a);
        this.b = aVar2;
        this.f8311a.a(aVar2);
    }

    private void f() {
        if (this.c != null) {
            return;
        }
        View viewC = this.f8311a.c();
        if (viewC == null) {
            com.opos.cmn.an.f.a.b("templateFactory", "target view null");
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewC.getLayoutParams();
        this.c = new g(this.d);
        if (layoutParams != null) {
            com.opos.cmn.an.f.a.b("templateFactory", "child params:" + layoutParams);
            this.c.setLayoutParams(layoutParams);
        }
        this.c.addView(this.f8311a.c(), new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        this.f8311a.a();
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.b.b = interfaceC1003a;
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        this.f8311a.a(fVar);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        this.f8311a.b();
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        f();
        return this.c;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        this.f8311a.d();
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        return this.f8311a.e();
    }
}
