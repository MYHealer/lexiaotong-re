package com.opos.mobad.template.i;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b implements com.opos.mobad.template.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.template.e.a f8161a;

    public b(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.b.1
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    if (b.this.f8161a != null) {
                        b.this.f8161a.a(view2, iArr);
                    }
                }
            };
            view.setOnClickListener(pVar);
            view.setOnTouchListener(pVar);
        }
    }

    @Override // com.opos.mobad.template.e
    public void a(com.opos.mobad.template.e.a aVar) {
        this.f8161a = aVar;
    }
}
