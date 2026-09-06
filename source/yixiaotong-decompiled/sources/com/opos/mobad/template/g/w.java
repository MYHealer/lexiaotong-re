package com.opos.mobad.template.g;

import android.view.View;
import android.widget.RelativeLayout;
import com.opos.mobad.template.cmn.CarouselViewPager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class w extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CarouselViewPager f7990a;
    private com.opos.mobad.template.a.InterfaceC1003a b;

    public void a(final com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.cmn.an.f.a.b("BlockListImgHorizontalView", "setListener " + interfaceC1003a);
        this.b = interfaceC1003a;
        this.f7990a.a(new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.g.w.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (w.this.b != null) {
                    w.this.b.h(view, iArr);
                }
            }
        });
        this.f7990a.a(new com.opos.mobad.template.cmn.baseview.f() { // from class: com.opos.mobad.template.g.w.2
            @Override // com.opos.mobad.template.cmn.baseview.f
            public void a(View view, int i, boolean z) {
                com.opos.cmn.an.f.a.a("BlockListImgHorizontalView", "onMockEventIntercepted->clickMockEvent:" + i + ";disAllowClick:" + z + ";view:" + view.getClass().getName());
                com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a2 = interfaceC1003a;
                if (interfaceC1003a2 != null) {
                    interfaceC1003a2.a(view, i, z);
                }
            }
        });
    }
}
