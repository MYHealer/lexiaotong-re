package com.ubixnow.ooooo;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class q implements j {
    private final Context OooO00o;
    private final KeyguardManager OooO0O0;

    public q(Context context) {
        this.OooO00o = context;
        this.OooO0O0 = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.ubixnow.ooooo.j
    public void OooO00o(i iVar) {
        if (this.OooO00o == null || iVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.OooO0O0;
        if (keyguardManager == null) {
            iVar.OooO00o(new k("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.OooO0O0, new Object[0]);
            if (objInvoke == null) {
                throw new k("OAID obtain failed");
            }
            String string = objInvoke.toString();
            l.OooO00o("OAID obtain success: " + string);
            iVar.OooO00o(string);
        } catch (Exception e) {
            l.OooO00o(e);
        }
    }

    @Override // com.ubixnow.ooooo.j
    public boolean OooO00o() {
        KeyguardManager keyguardManager;
        if (this.OooO00o == null || (keyguardManager = this.OooO0O0) == null) {
            return false;
        }
        try {
            return ((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.OooO0O0, new Object[0]))).booleanValue();
        } catch (Throwable th) {
            l.OooO00o(th);
            return false;
        }
    }
}
