package com.opos.mobad.video.player.d;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.template.d.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.mobad.template.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f8368a;
    private com.opos.mobad.template.a.InterfaceC1003a b;
    private AdItemData c;
    private MaterialData d;
    private com.opos.mobad.template.a e;
    private FrameLayout f;

    public b(Activity activity, AdItemData adItemData, com.opos.mobad.template.a aVar) {
        this.f8368a = activity;
        this.f = new FrameLayout(activity);
        this.c = adItemData;
        this.d = adItemData.i().get(0);
        this.e = aVar;
    }

    @Override // com.opos.mobad.template.a
    public void a() {
        com.opos.mobad.template.a aVar = this.e;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.template.a
    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.b = interfaceC1003a;
        this.e.a(interfaceC1003a);
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.cmn.an.f.a.b("InterstitialWidgetImpl", "getRenderView ");
        if (this.c == null || this.d == null) {
            return;
        }
        com.opos.mobad.template.a aVar = this.e;
        if (aVar == null) {
            com.opos.cmn.an.f.a.d("InterstitialWidgetImpl", "unknow creativeType, please check if your creativeType is video or template");
            com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a = this.b;
            if (interfaceC1003a != null) {
                interfaceC1003a.a(1);
                return;
            }
            return;
        }
        aVar.a(fVar);
        View viewC = this.e.c();
        if (this.f.indexOfChild(viewC) < 0) {
            this.f.removeAllViews();
            this.f.addView(viewC, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @Override // com.opos.mobad.template.a
    public void b() {
        com.opos.mobad.template.a aVar = this.e;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.template.a
    public View c() {
        return this.f;
    }

    @Override // com.opos.mobad.template.a
    public void d() {
        try {
            com.opos.mobad.template.a aVar = this.e;
            if (aVar != null) {
                aVar.d();
            }
            this.f.removeAllViews();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("InterstitialWidgetImpl", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.template.a
    public int e() {
        com.opos.mobad.template.a aVar = this.e;
        if (aVar == null) {
            return 0;
        }
        return aVar.e();
    }
}
