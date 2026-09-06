package com.yfanads.android.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.yfanads.android.utils.YFLog;
import java.util.Objects;

/* JADX INFO: compiled from: CooseaImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9657a;
    public final KeyguardManager b;

    public c(Context context) {
        this.f9657a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        KeyguardManager keyguardManager;
        if (this.f9657a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            return ((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]))).booleanValue();
        } catch (Exception e) {
            YFLog.debug("supported " + e.getMessage());
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9657a != null) {
            KeyguardManager keyguardManager = this.b;
            if (keyguardManager == null) {
                aVar.onOAIDGetFail(new com.yfanads.android.oaid.a("KeyguardManager not found"));
                return;
            }
            try {
                Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
                if (objInvoke != null) {
                    String string = objInvoke.toString();
                    YFLog.debug("OAID obtain success: " + string);
                    aVar.onOAIDGetSuccess(string);
                    return;
                }
                throw new com.yfanads.android.oaid.a("OAID obtain failed");
            } catch (Exception e) {
                YFLog.debug("" + e.getMessage());
            }
        }
    }
}
