package com.opos.mobad.ui.c;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.utils.AdHelper;
import com.opos.mobad.template.c.h;
import com.opos.mobad.template.c.i;
import com.opos.mobad.template.c.j;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f8308a;
    private final com.opos.mobad.d.a b;
    private com.opos.mobad.d.a c;
    private final j d;
    private com.opos.mobad.template.f e;

    public interface a {
        void a(int i, int i2);
    }

    /* JADX INFO: renamed from: com.opos.mobad.ui.c.b$b, reason: collision with other inner class name */
    private static final class C1031b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f8310a;
        private static final b b;

        static {
            f8310a = new b();
            b = new b();
        }
    }

    private b() {
        com.opos.mobad.d.a aVar = new com.opos.mobad.d.a() { // from class: com.opos.mobad.ui.c.b.1
            @Override // com.opos.mobad.d.a
            public void a(String str, String str2, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
                com.opos.mobad.f.e.a().a(str, str2, i, i2, interfaceC0955a);
            }

            @Override // com.opos.mobad.d.a
            public void a(String str, String str2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
                com.opos.mobad.f.e.a().a(str, str2, interfaceC0955a);
            }
        };
        this.b = aVar;
        this.c = aVar;
        this.d = a(-1).a();
    }

    private com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        return a(context, i, aVar, interfaceC1003a, 0);
    }

    private com.opos.mobad.template.a a(Context context, int i, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, int i2) {
        int iB = com.opos.mobad.service.b.b.a().b(i);
        com.opos.mobad.template.a aVarA = this.e.a(context, i, aVar, interfaceC1003a);
        if (aVarA != null) {
            return new c(context, aVarA, interfaceC1003a);
        }
        com.opos.cmn.an.f.a.b("AdTemplateFactoryWrapper", "createTemplate but null", Integer.valueOf(i), Integer.valueOf(iB));
        a aVar2 = this.f8308a;
        if (aVar2 == null) {
            return null;
        }
        aVar2.a(i, iB);
        return null;
    }

    private static j.a a(int i) {
        j.a aVar = new j.a();
        if (a(i, 1)) {
            aVar.a(new i());
        }
        if (a(i, 2)) {
            aVar.a(new com.opos.mobad.template.c.b());
        }
        if (a(i, 4)) {
            aVar.a(new com.opos.mobad.template.c.f());
        }
        if (a(i, 8)) {
            aVar.a(new h());
        }
        if (a(i, 16)) {
            aVar.a(new com.opos.mobad.template.c.g());
        }
        return aVar;
    }

    public static b a() {
        return C1031b.f8310a;
    }

    private static boolean a(int i, int i2) {
        return i == -1 || (i & i2) == i2;
    }

    private com.opos.mobad.template.a b(Context context, int i, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        return a(context, i, aVar, interfaceC1003a, 1);
    }

    /* JADX WARN: Code duplicated, block: B:69:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d6 A[PHI: r2
  0x00d6: PHI (r2v1 int) = (r2v0 int), (r2v0 int), (r2v5 int), (r2v5 int), (r2v6 int), (r2v6 int) binds: [B:80:0x00d4, B:71:0x00bc, B:61:0x00a2, B:57:0x0098, B:54:0x0091, B:50:0x0087] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:82:0x00d8  */
    public com.opos.mobad.template.a a(Activity activity, AdItemData adItemData, MaterialData materialData, Bundle bundle, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        int iB = materialData != null ? materialData.b() : 0;
        if (bundle != null && bundle.getInt("interstitial_scene") == com.opos.mobad.ad.c.e.b.INSTANT_EXIT.ordinal() && iB != 2155 && iB != 2154) {
            iB = materialData.a() ? 2154 : 2155;
        }
        com.opos.mobad.template.l.a aVarA = com.opos.mobad.j.b.c.a(adItemData.V());
        com.opos.mobad.template.a aVarA2 = a(activity, iB, aVarA, interfaceC1003a);
        if (aVarA2 != null) {
            return aVarA2;
        }
        int iZ = materialData.Z();
        int i = 2071;
        if (iZ != 1) {
            if (iZ != 2) {
                if (iZ == 3) {
                    iB = 2044;
                } else if (iZ == 5) {
                    iB = 48;
                } else if (iZ != 50) {
                    if (iZ == 60 || iZ == 63) {
                        if (materialData.a()) {
                            iB = 2030;
                        } else {
                            iB = 2029;
                        }
                    } else if (iZ != 71) {
                        i = 8;
                        if (iZ != 20) {
                            if (iZ != 21) {
                                i = 9;
                                if (iZ != 30) {
                                    if (iZ != 31) {
                                        if (iZ == 80 || iZ == 81) {
                                            if (materialData.a()) {
                                                iB = 2028;
                                            } else {
                                                iB = 2029;
                                            }
                                        }
                                    } else if (!materialData.a()) {
                                        iB = 52;
                                    }
                                } else if (!materialData.a()) {
                                    iB = 50;
                                }
                                iB = i;
                            } else if (materialData.a()) {
                                iB = i;
                            } else {
                                iB = 51;
                            }
                        } else if (materialData.a()) {
                            iB = i;
                        } else {
                            iB = 50;
                        }
                    } else if (materialData.a()) {
                        iB = 5;
                    } else {
                        iB = 50;
                    }
                } else if (materialData.a()) {
                    iB = i;
                } else {
                    iB = 2008;
                }
            } else if (materialData.a()) {
                iB = 7;
            } else {
                iB = 50;
            }
        } else if (materialData.a()) {
            iB = i;
        } else {
            iB = 50;
        }
        return a(activity, iB, aVarA, interfaceC1003a);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0047  */
    public com.opos.mobad.template.a a(Context context, int i, int i2, int i3, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        int i4;
        com.opos.mobad.template.l.a aVarA = com.opos.mobad.j.b.c.a(i3);
        com.opos.mobad.template.a aVarA2 = a(StubApp.getOrigApplicationContext(context.getApplicationContext()), i, aVarA, interfaceC1003a);
        if (aVarA2 != null) {
            return aVarA2;
        }
        if (i2 != 1) {
            i4 = 3;
            if (i2 != 2) {
                if (i2 != 3) {
                    i4 = 4;
                    if (i2 == 4) {
                        i4 = 2032;
                    } else if (i2 == 5) {
                        i4 = 2;
                    } else if (i2 == 20) {
                        i4 = 2045;
                    } else if (i2 != 21) {
                        if (i2 == 30 || i2 == 31) {
                            i4 = 53;
                        } else if (i2 != 34) {
                            i4 = i2 != 71 ? 0 : 2047;
                        } else {
                            i4 = 2;
                        }
                    }
                } else {
                    i4 = 2;
                }
            }
        } else {
            i4 = 2044;
        }
        return a(StubApp.getOrigApplicationContext(context.getApplicationContext()), i4, aVarA, interfaceC1003a);
    }

    public com.opos.mobad.template.a a(Context context, int i, int i2, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        int i3;
        com.opos.mobad.template.a aVarA = a(StubApp.getOrigApplicationContext(context.getApplicationContext()), i, aVar, interfaceC1003a);
        if (aVarA != null) {
            return aVarA;
        }
        if (i2 == 1) {
            i3 = 2127;
        } else if (i2 == 2) {
            i3 = 2128;
        } else if (i2 == 20) {
            i3 = 2132;
        } else if (i2 == 21) {
            i3 = 2143;
        } else if (i2 == 30) {
            i3 = 2094;
        } else if (i2 == 31) {
            i3 = 84;
        } else if (i2 == 50) {
            i3 = 2126;
        } else if (i2 == 60) {
            i3 = 2129;
        } else if (i2 != 63) {
            i3 = i2 != 71 ? 0 : 2124;
        } else {
            i3 = 2141;
        }
        return a(StubApp.getOrigApplicationContext(context.getApplicationContext()), i3, aVar, interfaceC1003a);
    }

    public com.opos.mobad.template.a a(Context context, MaterialData materialData, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        int i;
        com.opos.mobad.template.a aVarA = a(context, materialData.b(), aVar, interfaceC1003a);
        if (aVarA != null) {
            return aVarA;
        }
        int iZ = materialData.Z();
        if (iZ == 60 || iZ == 63) {
            i = materialData.a() ? 2030 : 2029;
        } else {
            i = 0;
        }
        return a(context, i, aVar, interfaceC1003a);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:40:0x0082  */
    public com.opos.mobad.template.a a(Context context, AdHelper.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.mobad.template.l.a aVarA = com.opos.mobad.j.b.c.a(aVar.c.V());
        com.opos.mobad.template.a aVarB = b(StubApp.getOrigApplicationContext(context.getApplicationContext()), aVar.d.b(), aVarA, interfaceC1003a);
        if (aVarB != null) {
            return aVarB;
        }
        int iZ = aVar.d.Z();
        int i = 62;
        if (iZ == 3 || iZ == 4) {
            if (!aVar.d.a()) {
                i = 68;
            }
        } else if (iZ != 5) {
            if (iZ != 34) {
                if (iZ == 51) {
                    i = 2041;
                } else if (iZ == 63) {
                    i = 25;
                } else if (iZ == 71) {
                    i = aVar.d.a() ? 2058 : 2061;
                } else if (iZ == 60) {
                    i = 76;
                } else if (iZ != 61) {
                    i = 0;
                } else {
                    i = 25;
                }
            } else if (!aVar.d.a()) {
                i = 2073;
            }
        } else if (aVar.d.a()) {
            i = 2026;
        } else {
            i = 68;
        }
        return b(StubApp.getOrigApplicationContext(context.getApplicationContext()), i, aVarA, interfaceC1003a);
    }

    public void a(a aVar) {
        this.f8308a = aVar;
        if (this.e == null) {
            this.e = new com.opos.mobad.template.f(this.d, this.c);
        }
    }

    public com.opos.mobad.template.a b(Context context, MaterialData materialData, com.opos.mobad.template.l.a aVar, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        int i;
        com.opos.mobad.template.a aVarA = a(context, materialData.b(), aVar, interfaceC1003a);
        if (aVarA != null) {
            return aVarA;
        }
        int iZ = materialData.Z();
        if (iZ == 60 || iZ == 63) {
            i = materialData.a() ? 2030 : 2029;
        } else {
            i = 0;
        }
        return a(context, i, aVar, interfaceC1003a);
    }
}
