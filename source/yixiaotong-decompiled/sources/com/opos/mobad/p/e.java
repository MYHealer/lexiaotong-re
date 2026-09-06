package com.opos.mobad.p;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e {
    public static final com.opos.mobad.template.e a(f.a aVar, Context context, final com.opos.mobad.ad.f.e eVar) {
        return (!f.a(aVar) || eVar == null || eVar.a() == null || eVar.b().size() <= 0) ? new com.opos.mobad.template.i.a(context) : new com.opos.mobad.template.i.b(eVar.b()) { // from class: com.opos.mobad.p.e.1
            @Override // com.opos.mobad.template.e
            public View a() {
                return eVar.a();
            }

            @Override // com.opos.mobad.template.e
            public void a(int i) {
                eVar.a(i);
            }
        };
    }
}
