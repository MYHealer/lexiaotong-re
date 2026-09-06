package com.opos.mobad.template.c;

import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.a f7462a;
    private com.opos.mobad.template.f.e b;
    private com.opos.mobad.template.a.InterfaceC1003a d;
    private boolean c = false;
    private com.opos.mobad.template.a.InterfaceC1003a e = new com.opos.mobad.template.a.InterfaceC1003a() { // from class: com.opos.mobad.template.c.e.1
        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(int i) {
            if (e.this.c) {
                return;
            }
            e.this.c = true;
            if (e.this.b != null && e.this.b.a() != null) {
                e.this.b.a().setVisibility(8);
            }
            if (e.this.d != null) {
                e.this.d.a(i);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(int i, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.a(i, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(long j, long j2) {
            if (e.this.d != null) {
                e.this.d.a(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(View view, int i, boolean z) {
            com.opos.cmn.an.f.a.a("InterstitialProxy", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
            if (e.this.d != null) {
                e.this.d.a(view, i, z);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.a(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(View view, int[] iArr, boolean z) {
            if (e.this.d != null) {
                e.this.d.a(view, iArr, z);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(Map<String, String> map) {
            if (e.this.d != null) {
                e.this.d.a(map);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void a(int[] iArr) {
            if (e.this.d != null) {
                e.this.d.a(iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void b(long j, long j2) {
            if (e.this.d != null) {
                e.this.d.b(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void b(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.b(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void b(Map<String, String> map) {
            if (e.this.d != null) {
                e.this.d.b(map);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void b(int[] iArr) {
            if (e.this.d != null) {
                e.this.d.b(iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void c(int i) {
            if (e.this.d != null) {
                e.this.d.c(i);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void c(long j, long j2) {
            if (e.this.d != null) {
                e.this.d.c(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void c(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.c(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void d(long j, long j2) {
            if (e.this.d != null) {
                e.this.d.d(j, j2);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void d(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.d(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void e() {
            if (e.this.d != null) {
                e.this.d.e();
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void e(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.e(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void f(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.f(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void g(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.g(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void h(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.h(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void i(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.i(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void j(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.j(view, iArr);
            }
        }

        @Override // com.opos.mobad.template.a.InterfaceC1003a
        public void l(View view, int[] iArr) {
            if (e.this.d != null) {
                e.this.d.l(view, iArr);
            }
        }
    };

    public e(com.opos.mobad.template.a aVar, com.opos.mobad.template.f.e eVar) {
        this.f7462a = aVar;
        this.b = eVar;
        eVar.a(aVar.c());
        this.f7462a.a(this.e);
        this.b.a(this.e);
    }

    private boolean f() {
        return this.f7462a == null || this.b == null;
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        if (f()) {
            return;
        }
        this.f7462a.a();
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        if (f()) {
            return;
        }
        this.d = interfaceC1003a;
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.d.f fVar) {
        if (f()) {
            return;
        }
        this.f7462a.a(fVar);
        this.b.a(fVar);
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        if (f()) {
            return;
        }
        this.f7462a.b();
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        if (f()) {
            return null;
        }
        return this.b.a();
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        if (f()) {
            return;
        }
        this.b.b();
        this.f7462a.d();
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        if (f()) {
            return 0;
        }
        return this.f7462a.e();
    }
}
