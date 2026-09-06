package com.jg.ids.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.jg.ids.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class a extends g {
    private String b;

    public a(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.b);
        return intent;
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        if (this.f4599a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    String string = Settings.Global.getString(this.f4599a.getContentResolver(), "pps_oaid");
                    if (!TextUtils.isEmpty(string)) {
                        c(string);
                        return;
                    }
                }
                b bVarA = c.a(iBinder);
                if (!bVarA.b()) {
                    String strA = bVarA.a();
                    if (!TextUtils.isEmpty(strA)) {
                        c(strA);
                    }
                }
                b();
            } catch (Exception e) {
            }
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        boolean z = true;
        if (this.f4599a == null) {
            return false;
        }
        try {
            PackageManager packageManager = this.f4599a.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.b = "com.huawei.hwid.tv";
            } else {
                this.b = "com.huawei.hms";
                if (packageManager.getPackageInfo(this.b, 0) == null) {
                    z = false;
                }
            }
        } catch (Exception e) {
            z = false;
        }
        return z;
    }

    @Override // com.jg.ids.f
    protected final boolean c() {
        return TextUtils.isEmpty(a(this.f4599a));
    }
}
