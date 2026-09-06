package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.h.aa;
import com.opos.mobad.template.h.v;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h implements d {
    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.a aVarA;
        if (i == 27) {
            aVarA = aa.a(context, i, aVar.a(context), aVar2);
        } else if (i == 28) {
            aVarA = aa.b(context, i, aVar.a(context), aVar2);
        } else if (i == 2082) {
            aVarA = v.e(context, i, aVar.a(context), aVar2);
        } else if (i == 2102) {
            aVarA = v.j(context, i, aVar.a(context), aVar2);
        } else if (i == 2114) {
            aVarA = com.opos.mobad.template.h.c.a(context, i, aVar.a(context), aVar2);
        } else if (i != 2115) {
            switch (i) {
                case 2028:
                    aVarA = v.a(context, i, aVar.a(context), aVar2);
                    break;
                case 2029:
                    aVarA = v.c(context, i, aVar.a(context), aVar2);
                    break;
                case 2030:
                    aVarA = v.b(context, i, aVar.a(context), aVar2);
                    break;
                case 2031:
                    aVarA = v.d(context, i, aVar.a(context), aVar2);
                    break;
                default:
                    switch (i) {
                        case 2084:
                            aVarA = v.f(context, i, aVar.a(context), aVar2);
                            break;
                        case 2085:
                            aVarA = v.g(context, i, aVar.a(context), aVar2);
                            break;
                        case 2086:
                            aVarA = v.h(context, i, aVar.a(context), aVar2);
                            break;
                        case 2087:
                            aVarA = v.i(context, i, aVar.a(context), aVar2);
                            break;
                        default:
                            return null;
                    }
                    break;
            }
        } else {
            aVarA = com.opos.mobad.template.h.c.b(context, i, aVar.a(context), aVar2);
        }
        aVarA.a(interfaceC1003a);
        return aVarA;
    }
}
