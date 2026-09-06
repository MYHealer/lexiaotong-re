package com.meishu.sdk.core.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.meishu.sdk.core.oaid.OAIDException;
import java.util.Objects;

/* JADX INFO: compiled from: CooseaImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4829a;
    public final KeyguardManager b;

    public c(Context context) {
        this.f4829a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f4829a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            return ((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]))).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4829a == null || aVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            ((com.meishu.sdk.core.utils.l) aVar).a(new OAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke != null) {
                ((com.meishu.sdk.core.utils.l) aVar).a(objInvoke.toString());
                return;
            }
            throw new OAIDException("OAID obtain failed");
        } catch (Exception unused) {
        }
    }
}
