package com.ubix.ssp.ad.e.a0.c0.h;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8643a;
    private final KeyguardManager b;

    public c(Context context) {
        this.f8643a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8643a == null || cVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            cVar.a(new com.ubix.ssp.ad.e.a0.c0.e("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke == null) {
                throw new com.ubix.ssp.ad.e.a0.c0.e("OAID obtain failed");
            }
            String string = objInvoke.toString();
            com.ubix.ssp.ad.e.a0.c0.f.a("OAID obtain success: " + string);
            cVar.a(string);
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
        }
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f8643a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            return ((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]))).booleanValue();
        } catch (Throwable th) {
            com.ubix.ssp.ad.e.a0.c0.f.a(th);
            return false;
        }
    }
}
