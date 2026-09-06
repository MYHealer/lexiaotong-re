package com.jg.ids.d;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.jg.ids.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class a extends g {
    public a(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        try {
            b bVarA = c.a(iBinder);
            if (bVarA != null) {
                c(bVarA.b());
                b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f4599a == null) {
            return false;
        }
        try {
            return this.f4599a.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
