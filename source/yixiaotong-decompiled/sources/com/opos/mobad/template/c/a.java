package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.i.v;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements d {
    private static final com.opos.mobad.template.i.j a(int i) {
        return i != 76 ? com.opos.mobad.template.i.j.NONE : com.opos.mobad.template.i.j.BREATH;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0064  */
    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.a aVarA;
        if (i == 21) {
            aVarA = com.opos.mobad.template.i.f.a(context, i, a(i), aVar2);
        } else if (i == 25) {
            aVarA = v.b(context, i, aVar.a(context), a(i), aVar2);
        } else if (i == 56) {
            aVarA = com.opos.mobad.template.i.f.a(context, i, a(i), aVar2);
        } else if (i == 59) {
            aVarA = com.opos.mobad.template.i.f.b(context, i, a(i), aVar2);
        } else if (i == 62) {
            aVarA = com.opos.mobad.template.i.f.c(context, i, a(i), aVar2);
        } else if (i == 68) {
            aVarA = com.opos.mobad.template.i.f.e(context, i, a(i), aVar2);
        } else if (i == 71) {
            aVarA = v.a(context, i, aVar.a(context), a(i), aVar2);
        } else {
            if (i != 76) {
                return null;
            }
            aVarA = v.c(context, i, aVar.a(context), a(i), aVar2);
        }
        aVarA.a(interfaceC1003a);
        return aVarA;
    }
}
