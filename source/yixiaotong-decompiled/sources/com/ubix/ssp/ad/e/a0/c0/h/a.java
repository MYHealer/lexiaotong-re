package com.ubix.ssp.ad.e.a0.c0.h;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class a implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8639a;

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.c0.h.a$a, reason: collision with other inner class name */
    class C1065a implements m.a {
        C1065a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.m.a
        public String a(IBinder iBinder) {
            com.ubix.ssp.ad.e.a0.c0.i.a.a aVarA = com.ubix.ssp.ad.e.a0.c0.i.a.a.AbstractBinderC1069a.a(iBinder);
            if (aVarA == null) {
                throw new com.ubix.ssp.ad.e.a0.c0.e("IDidAidlInterface is null");
            }
            if (aVarA.f()) {
                return aVarA.a();
            }
            throw new com.ubix.ssp.ad.e.a0.c0.e("IDidAidlInterface#isSupport return false");
        }
    }

    public a(Context context) {
        this.f8639a = context;
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8639a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        m.a(this.f8639a, intent, cVar, new C1065a());
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        Context context = this.f8639a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            return false;
        }
    }
}
