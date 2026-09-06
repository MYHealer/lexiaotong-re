package com.ubix.ssp.ad.e.a0.c0.h;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class j implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8655a;

    class a implements m.a {
        a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.m.a
        public String a(IBinder iBinder) {
            com.ubix.ssp.ad.e.a0.c0.i.f.a aVarA = com.ubix.ssp.ad.e.a0.c0.i.f.a.AbstractBinderC1080a.a(iBinder);
            if (aVarA == null) {
                throw new com.ubix.ssp.ad.e.a0.c0.e("MsaIdInterface is null");
            }
            if (aVarA.d()) {
                return aVarA.a();
            }
            throw new com.ubix.ssp.ad.e.a0.c0.e("MsaIdInterface#isSupported return false");
        }
    }

    public j(Context context) {
        this.f8655a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f8655a.getPackageName());
            this.f8655a.startForegroundService(intent);
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
        }
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8655a == null || cVar == null) {
            return;
        }
        b();
        Intent intent = new Intent("com.bun.msa.action.bindto.service");
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra("com.bun.msa.param.pkgname", this.f8655a.getPackageName());
        m.a(this.f8655a, intent, cVar, new a());
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        Context context = this.f8655a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            return false;
        }
    }
}
