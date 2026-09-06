package com.jg.ids.g;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class d extends g {
    public d(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        try {
            a aVarA = b.a(iBinder);
            if (aVarA != null) {
                String strA = aVarA.a(this.f4599a.getPackageName());
                String strB = aVarA.b(this.f4599a.getPackageName());
                String strA2 = aVarA.a();
                b(strA);
                a(strB);
                c(strA2);
            }
            b();
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f4599a == null) {
            return false;
        }
        try {
            return this.f4599a.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
