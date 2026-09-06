package com.opos.mobad.template.cmn;

import android.graphics.Bitmap;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j {

    public interface a {
        void a(int i, Bitmap bitmap);

        void a(Bitmap bitmap);
    }

    public interface b {
        boolean a();
    }

    public interface c {
        void a(int i);

        void a(Bitmap bitmap);
    }

    public static final void a(String str, String str2, int i, int i2, com.opos.mobad.d.a aVar, a aVar2, b bVar) {
        a(str, str2, Integer.valueOf(i), Integer.valueOf(i2), aVar, aVar2, bVar);
    }

    public static final void a(String str, String str2, int i, int i2, com.opos.mobad.d.a aVar, c cVar, b bVar) {
        a(str, str2, Integer.valueOf(i), Integer.valueOf(i2), aVar, cVar, bVar);
    }

    public static final void a(String str, String str2, com.opos.mobad.d.a aVar, a aVar2, b bVar) {
        a(str, str2, (Integer) null, (Integer) null, aVar, aVar2, bVar);
    }

    public static final void a(String str, String str2, com.opos.mobad.d.a aVar, c cVar, b bVar) {
        a(str, str2, (Integer) null, (Integer) null, aVar, cVar, bVar);
    }

    private static final void a(String str, String str2, Integer num, Integer num2, com.opos.mobad.d.a aVar, final a aVar2, final b bVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            aVar2.a(-1000, null);
            return;
        }
        com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a = new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.template.cmn.j.2
            @Override // com.opos.mobad.d.a.InterfaceC0955a
            public void a(final int i, final Bitmap bitmap) {
                b bVar2 = bVar;
                if (bVar2 == null || !bVar2.a()) {
                    if (i == 0 || i == 1) {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.cmn.j.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (bVar == null || !bVar.a()) {
                                    Bitmap bitmap2 = bitmap;
                                    if (bitmap2 == null || bitmap2.isRecycled()) {
                                        aVar2.a(-1000, null);
                                    } else if (i == 1) {
                                        aVar2.a(i, bitmap);
                                    } else {
                                        aVar2.a(bitmap);
                                    }
                                }
                            }
                        });
                    } else {
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.cmn.j.2.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (bVar == null || !bVar.a()) {
                                    aVar2.a(i, null);
                                }
                            }
                        });
                    }
                }
            }
        };
        if (num == null || num2 == null) {
            aVar.a(str, str2, interfaceC0955a);
        } else {
            aVar.a(str, str2, num.intValue(), num2.intValue(), interfaceC0955a);
        }
    }

    private static final void a(String str, String str2, Integer num, Integer num2, com.opos.mobad.d.a aVar, final c cVar, final b bVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            cVar.a(-1000);
            return;
        }
        com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a = new com.opos.mobad.d.a.InterfaceC0955a() { // from class: com.opos.mobad.template.cmn.j.1
            @Override // com.opos.mobad.d.a.InterfaceC0955a
            public void a(final int i, final Bitmap bitmap) {
                b bVar2 = bVar;
                if (bVar2 == null || !bVar2.a()) {
                    if (i == 0 || i == 1) {
                        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.cmn.j.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (i == 1) {
                                    cVar.a(i);
                                }
                                if (bVar == null || !bVar.a()) {
                                    Bitmap bitmap2 = bitmap;
                                    if (bitmap2 == null || bitmap2.isRecycled()) {
                                        cVar.a(-1000);
                                    } else {
                                        cVar.a(bitmap);
                                    }
                                }
                            }
                        });
                    } else {
                        com.opos.mobad.d.c.c.c(new Runnable() { // from class: com.opos.mobad.template.cmn.j.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (bVar == null || !bVar.a()) {
                                    cVar.a(i);
                                }
                            }
                        });
                    }
                }
            }
        };
        if (num == null || num2 == null) {
            aVar.a(str, str2, interfaceC0955a);
        } else {
            aVar.a(str, str2, num.intValue(), num2.intValue(), interfaceC0955a);
        }
    }
}
