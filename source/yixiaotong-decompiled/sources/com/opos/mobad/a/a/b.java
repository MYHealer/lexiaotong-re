package com.opos.mobad.a.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.dyf.tt;
import com.opos.mobad.template.d.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.d.e.a f6576a;
    private com.opos.mobad.template.a b;
    private com.opos.mobad.template.a.InterfaceC1003a c;

    public b(Context context) {
        this.f6576a = new com.opos.mobad.d.e.a(context);
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    public void a(int i) {
        com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.c;
        if (interfaceC1003a != null) {
            interfaceC1003a.a(i);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.mobad.template.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        aVar.a(interfaceC1003a);
        this.c = interfaceC1003a;
    }

    public void a(com.opos.mobad.template.a aVar) {
        this.b = aVar;
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.cmn.an.f.a.b(tt.AD_TAG_BANNER, "show :" + fVar + "," + this.b);
        com.opos.mobad.template.a aVar = this.b;
        if (aVar == null) {
            a(1);
            return;
        }
        aVar.a(fVar);
        View viewC = this.b.c();
        com.opos.cmn.an.f.a.b(tt.AD_TAG_BANNER, "show view:" + viewC);
        if (viewC == null) {
            a(1);
        } else if (this.f6576a.indexOfChild(viewC) < 0) {
            this.f6576a.removeAllViews();
            this.f6576a.addView(viewC, new FrameLayout.LayoutParams(-1, -2));
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f6576a;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.mobad.template.a aVar = this.b;
        if (aVar == null) {
            return;
        }
        this.c = null;
        aVar.d();
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        com.opos.mobad.template.a aVar = this.b;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }
}
