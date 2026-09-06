package com.opos.mobad.template.c;

import android.content.Context;
import com.opos.mobad.template.i.v;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f7464a = new a();

    private static final com.opos.mobad.template.i.j a(int i) {
        if (i != 63) {
            if (i != 64) {
                if (i != 66) {
                    if (i != 67) {
                        if (i != 69) {
                            if (i != 70) {
                                if (i != 72) {
                                    if (i != 2026) {
                                        if (i == 2042) {
                                            return com.opos.mobad.template.i.j.SLIDE_UP;
                                        }
                                        if (i != 2064 && i != 2075) {
                                            if (i != 2051) {
                                                if (i != 2052) {
                                                    return com.opos.mobad.template.i.j.NONE;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return com.opos.mobad.template.i.j.BREATH;
        }
        return com.opos.mobad.template.i.j.SPLASH;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x009d  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    @Override // com.opos.mobad.template.c.d
    public com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.d.a aVar2) {
        com.opos.mobad.template.a aVarC;
        if (i == 60) {
            aVarC = com.opos.mobad.template.i.f.c(context, i, a(i), aVar2);
        } else {
            if (i != 72) {
                if (i == 2024 || i == 2026) {
                    aVarC = com.opos.mobad.template.i.f.f(context, i, a(i), aVar2);
                } else if (i == 2058) {
                    aVarC = com.opos.mobad.template.i.f.h(context, i, a(i), aVar2);
                } else if (i == 2061 || i == 2064) {
                    aVarC = com.opos.mobad.template.i.f.i(context, i, a(i), aVar2);
                } else if (i == 2073 || i == 2075) {
                    aVarC = com.opos.mobad.template.i.f.j(context, i, a(i), aVar2);
                } else if (i == 63 || i == 64) {
                    aVarC = com.opos.mobad.template.i.f.d(context, i, a(i), aVar2);
                } else if (i == 66 || i == 67) {
                    aVarC = com.opos.mobad.template.i.f.e(context, i, a(i), aVar2);
                } else if (i == 69 || i == 70) {
                    aVarC = v.a(context, i, aVar.a(context), a(i), aVar2);
                } else if (i == 2041) {
                    aVarC = com.opos.mobad.template.i.f.d(context, i, a(i), aVar2);
                } else if (i != 2042) {
                    switch (i) {
                        case 2051:
                        case 2052:
                        case 2053:
                            aVarC = com.opos.mobad.template.i.f.g(context, i, a(i), aVar2);
                            break;
                        default:
                            switch (i) {
                                case 2120:
                                case 2122:
                                case 2123:
                                    aVarC = com.opos.mobad.template.i.f.f(context, i, a(i), aVar2);
                                    break;
                                case 2121:
                                    aVarC = com.opos.mobad.template.i.f.e(context, i, a(i), aVar2);
                                    break;
                                default:
                                    aVarC = null;
                                    break;
                            }
                            break;
                    }
                } else {
                    aVarC = v.c(context, i, aVar.a(context), a(i), aVar2);
                }
                if (aVarC == null) {
                    return this.f7464a.a(context, i, aVar, interfaceC1003a, aVar2);
                }
                return aVarC;
            }
            aVarC = v.b(context, i, aVar.a(context), a(i), aVar2);
        }
        aVarC.a(interfaceC1003a);
        if (aVarC == null) {
            return this.f7464a.a(context, i, aVar, interfaceC1003a, aVar2);
        }
        return aVarC;
    }
}
