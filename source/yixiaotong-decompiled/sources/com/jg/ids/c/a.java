package com.jg.ids.c;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class a extends g {
    private KeyguardManager b;

    public a(Context context) {
        super(context);
        if (this.f4599a != null) {
            this.b = (KeyguardManager) this.f4599a.getSystemService("keyguard");
            if (d()) {
                try {
                    Object objInvoke = this.b.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
                    if (objInvoke != null) {
                        c(objInvoke.toString());
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        return new Intent();
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f4599a != null && this.b != null) {
            try {
                return ((Boolean) Objects.requireNonNull(this.b.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]))).booleanValue();
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
}
