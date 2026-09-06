package com.jg.ids.b;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class a extends g {
    public a(Context context) {
        super(context);
        if (context instanceof Application) {
            this.f4599a = context;
        } else {
            this.f4599a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        try {
            b bVarA = c.a(iBinder);
            if (bVarA != null) {
                String strD = bVarA.d(this.f4599a.getPackageName());
                String strC = bVarA.c(this.f4599a.getPackageName());
                String strB = bVarA.b(this.f4599a.getPackageName());
                a(strD);
                b(strC);
                c(strB);
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
            return this.f4599a.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
