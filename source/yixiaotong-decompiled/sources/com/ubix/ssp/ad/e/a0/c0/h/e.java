package com.ubix.ssp.ad.e.a0.c0.h;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8644a;

    class a implements m.a {
        a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.m.a
        public String a(IBinder iBinder) {
            com.ubix.ssp.ad.e.a0.c0.i.c.a aVarA = com.ubix.ssp.ad.e.a0.c0.i.c.a.AbstractBinderC1073a.a(iBinder);
            if (aVarA != null) {
                return aVarA.a();
            }
            throw new com.ubix.ssp.ad.e.a0.c0.e("IdsSupplier is null");
        }
    }

    public e(Context context) {
        this.f8644a = context;
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8644a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        m.a(this.f8644a, intent, cVar, new a());
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        Context context = this.f8644a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            return false;
        }
    }
}
