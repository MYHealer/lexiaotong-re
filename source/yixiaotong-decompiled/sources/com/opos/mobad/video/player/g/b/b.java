package com.opos.mobad.video.player.g.b;

import android.app.Activity;
import com.opos.mobad.f.e;
import com.opos.mobad.j.b.c;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.template.f.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    private static volatile b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.opos.mobad.d.a f8413a = new com.opos.mobad.d.a() { // from class: com.opos.mobad.video.player.g.b.b.1
        @Override // com.opos.mobad.d.a
        public void a(String str, String str2, int i, int i2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
            e.a().a(str, str2, i, i2, interfaceC0955a);
        }

        @Override // com.opos.mobad.d.a
        public void a(String str, String str2, com.opos.mobad.d.a.InterfaceC0955a interfaceC0955a) {
            e.a().a(str, str2, interfaceC0955a);
        }
    };

    private b() {
    }

    public static b a() {
        b bVar = b;
        if (bVar == null) {
            synchronized (a.class) {
                bVar = b;
                if (bVar == null) {
                    bVar = new b();
                    b = bVar;
                }
            }
        }
        return bVar;
    }

    private boolean a(Activity activity, MaterialData materialData) {
        if (materialData == null) {
            return false;
        }
        int iB = materialData.b();
        return iB == 7 || iB == 12 || iB == 14 || iB == 2007;
    }

    public com.opos.mobad.template.a a(Activity activity, MaterialData materialData, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.mobad.d.d.a aVarA = c.a(activity, null);
        m mVarB = a(activity, materialData) ? m.b(activity, aVarA, b.f8413a, -10007) : m.a(activity, aVarA, b.f8413a, -10008);
        mVarB.a(interfaceC1003a);
        return mVarB;
    }
}
