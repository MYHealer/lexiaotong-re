package com.opos.mobad.template.c;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import com.opos.mobad.template.f.l;
import com.opos.mobad.template.f.q;
import com.opos.mobad.template.f.s;
import com.opos.mobad.template.f.t;
import com.opos.mobad.template.f.x;
import com.opos.mobad.template.h.aa;
import com.opos.mobad.template.h.v;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f implements d {
    /* JADX WARN: Code duplicated, block: B:30:0x0083  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:34:0x00b8  */
    private com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.template.a aVar, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.f.e eVarA;
        Context origApplicationContext;
        int i2;
        boolean z;
        boolean z2;
        int i3;
        if (i == 5) {
            eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 0, false, aVar2, true);
        } else if (i == 48) {
            eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 1, false, aVar2, true);
        } else if (i == 2071) {
            eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 0, 3, aVar2, true);
        } else if (i == 7) {
            eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 0, false, aVar2, true);
        } else if (i != 8 && i != 9) {
            if (i != 2154 && i != 2155) {
                switch (i) {
                    case 12:
                        origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                        i2 = 0;
                        z = true;
                        z2 = true;
                        i3 = 12;
                        eVarA = x.a(origApplicationContext, i2, z, aVar2, z2, i3);
                        break;
                    case 13:
                    case 15:
                        eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 1, true, aVar2, true);
                        break;
                    case 14:
                        origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                        i2 = 0;
                        z = true;
                        z2 = true;
                        i3 = 14;
                        eVarA = x.a(origApplicationContext, i2, z, aVar2, z2, i3);
                        break;
                    default:
                        switch (i) {
                            case 50:
                                eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 1, false, aVar2, true);
                                break;
                            case 51:
                            case 52:
                                eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 1, false, aVar2, i);
                                break;
                            default:
                                switch (i) {
                                    case 2007:
                                        eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 0, 2, aVar2, true);
                                        break;
                                    case 2008:
                                        eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 1, 2, aVar2, true);
                                        break;
                                    case 2009:
                                    case PluginError.ERROR_UPD_PLUGIN_CONNECTION /* 2010 */:
                                        eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                                        break;
                                    default:
                                        eVarA = null;
                                        break;
                                }
                                break;
                        }
                        break;
                }
            } else {
                eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
        } else {
            eVarA = x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), 0, false, aVar2, i);
        }
        if (eVarA == null) {
            if (aVar != null) {
                aVar.a(interfaceC1003a);
            }
            return aVar;
        }
        e eVar = new e(aVar, eVarA);
        eVar.a(interfaceC1003a);
        return eVar;
    }

    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.a aVarH;
        if (i == 5) {
            aVarH = l.h(context, i, aVar2);
        } else if (i == 48) {
            aVarH = l.d(context, i, aVar2);
        } else if (i == 2071) {
            aVarH = com.opos.mobad.template.f.f.a(context, i, aVar2);
        } else if (i == 2082) {
            aVarH = v.e(context, i, aVar.a(context), aVar2);
        } else if (i == 2102) {
            aVarH = v.j(context, i, aVar.a(context), aVar2);
        } else if (i == 7) {
            aVarH = l.f(context, i, aVar2);
        } else if (i == 8) {
            aVarH = l.e(context, i, aVar2);
        } else if (i == 9) {
            aVarH = l.g(context, i, aVar2);
        } else if (i == 27) {
            aVarH = aa.a(context, i, aVar.a(context), aVar2);
        } else if (i == 28) {
            aVarH = aa.b(context, i, aVar.a(context), aVar2);
        } else if (i == 2114) {
            aVarH = com.opos.mobad.template.h.c.a(context, i, aVar.a(context), aVar2);
        } else if (i == 2115) {
            aVarH = com.opos.mobad.template.h.c.b(context, i, aVar.a(context), aVar2);
        } else if (i == 2154) {
            aVarH = t.b(context, i, aVar2);
        } else if (i != 2155) {
            switch (i) {
                case 12:
                    aVarH = s.a(context, i, aVar.a(context), aVar2);
                    break;
                case 13:
                    aVarH = q.a(context, i, aVar.a(context), aVar2);
                    break;
                case 14:
                    aVarH = s.b(context, i, aVar.a(context), aVar2);
                    break;
                case 15:
                    aVarH = q.b(context, i, aVar.a(context), aVar2);
                    break;
                default:
                    switch (i) {
                        case 50:
                            aVarH = l.b(context, i, aVar2);
                            break;
                        case 51:
                            aVarH = l.a(context, i, aVar2);
                            break;
                        case 52:
                            aVarH = l.c(context, i, aVar2);
                            break;
                        default:
                            switch (i) {
                                case 2007:
                                    aVarH = com.opos.mobad.template.f.j.a(context, 2007, aVar2);
                                    break;
                                case 2008:
                                    aVarH = com.opos.mobad.template.f.j.b(context, 2008, aVar2);
                                    break;
                                case 2009:
                                    aVarH = com.opos.mobad.template.f.g.a(context, 2009, aVar2);
                                    break;
                                case PluginError.ERROR_UPD_PLUGIN_CONNECTION /* 2010 */:
                                    aVarH = com.opos.mobad.template.f.g.b(context, PluginError.ERROR_UPD_PLUGIN_CONNECTION, aVar2);
                                    break;
                                default:
                                    switch (i) {
                                        case 2028:
                                            aVarH = v.a(context, i, aVar.a(context), aVar2);
                                            break;
                                        case 2029:
                                            aVarH = v.c(context, i, aVar.a(context), aVar2);
                                            break;
                                        case 2030:
                                            aVarH = v.b(context, i, aVar.a(context), aVar2);
                                            break;
                                        case 2031:
                                            aVarH = v.d(context, i, aVar.a(context), aVar2);
                                            break;
                                        default:
                                            switch (i) {
                                                case 2084:
                                                    aVarH = v.f(context, i, aVar.a(context), aVar2);
                                                    break;
                                                case 2085:
                                                    aVarH = v.g(context, i, aVar.a(context), aVar2);
                                                    break;
                                                case 2086:
                                                    aVarH = v.h(context, i, aVar.a(context), aVar2);
                                                    break;
                                                case 2087:
                                                    aVarH = v.i(context, i, aVar.a(context), aVar2);
                                                    break;
                                                default:
                                                    aVarH = null;
                                                    break;
                                            }
                                            break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } else {
            aVarH = t.a(context, i, aVar2);
        }
        com.opos.mobad.template.a aVar3 = aVarH;
        return aVar3 != null ? a(context, i, interfaceC1003a, aVar3, aVar2) : aVar3;
    }
}
