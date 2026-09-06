package com.opos.mobad.a.a;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.template.d.f;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.a.b f6574a;
    private Context b;
    private com.opos.mobad.template.a c;
    private com.opos.mobad.d.e.a d;

    public a(Context context, com.opos.mobad.template.a aVar) {
        this.b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.opos.mobad.d.e.a aVar2 = new com.opos.mobad.d.e.a(context);
        this.d = aVar2;
        aVar2.a(new com.opos.mobad.d.e.a.InterfaceC0958a() { // from class: com.opos.mobad.a.a.a.1
            @Override // com.opos.mobad.d.e.a.InterfaceC0958a
            public void a(boolean z) {
                if (a.this.f6574a != null) {
                    a.this.f6574a.a(z);
                }
            }
        });
        this.c = aVar;
        this.d.addView(aVar.c(), new RelativeLayout.LayoutParams(-1, -2));
        if (Build.VERSION.SDK_INT >= 29) {
            this.d.setForceDarkAllowed(false);
        }
    }

    @Override // com.opos.mobad.template.a
    public void a() {
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.f6574a = (com.opos.mobad.a.b) interfaceC1003a;
        this.c.a(interfaceC1003a);
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.mobad.template.a aVar;
        if (fVar != null && (aVar = this.c) != null) {
            aVar.a(fVar);
            return;
        }
        com.opos.cmn.an.f.a.b("BannerNewTemplate", "render fail for null =" + this.c);
        com.opos.mobad.a.b bVar = this.f6574a;
        if (bVar != null) {
            bVar.a(1);
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.d;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        com.opos.mobad.template.a aVar = this.c;
        if (aVar != null) {
            aVar.d();
        }
        this.d.removeAllViews();
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        com.opos.mobad.template.a aVar = this.c;
        if (aVar != null) {
            return aVar.e();
        }
        return 0;
    }
}
