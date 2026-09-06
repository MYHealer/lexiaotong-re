package com.adprof.sdk;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class c7 implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyguardManager f1103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f171a;

    public c7(Context context) {
        this.f171a = context;
        this.f1103a = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f171a == null || ebVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f1103a;
        if (keyguardManager == null) {
            ebVar.a(new mg("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f1103a, new Object[0]);
            if (objInvoke == null) {
                throw new mg("OAID obtain failed");
            }
            ebVar.a(objInvoke.toString());
        } catch (Exception unused) {
        }
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f171a == null || (keyguardManager = this.f1103a) == null) {
            return false;
        }
        try {
            return ((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f1103a, new Object[0]))).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }
}
