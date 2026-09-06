package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ka implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1264a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f424a;

    public ka(Context context) {
        this.f1264a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        Context context = this.f1264a;
        if (context == null || ebVar == null) {
            return;
        }
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String str = "00000000-0000-0000-0000-000000000000";
            if (!Boolean.parseBoolean(Settings.Global.getString(this.f1264a.getContentResolver(), "pps_track_limit"))) {
                if (!TextUtils.isEmpty(string) && !string.equals("00000000-0000-0000-0000-000000000000")) {
                    ebVar.a(string);
                    return;
                }
                b3 b3VarA = d3.a(this.f1264a);
                if (b3VarA != null) {
                    str = b3VarA.f1064a;
                }
            }
            ebVar.a(str);
        } catch (Exception unused) {
            if (TextUtils.isEmpty(this.f424a) && !a()) {
                ebVar.a(new mg("Huawei Advertising ID not available"));
                return;
            }
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage(this.f424a);
            qg.a(this.f1264a, intent, ebVar, new ja(this));
        }
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        String str = "com.huawei.hwid.tv";
        Context context = this.f1264a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null) {
                if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                    this.f424a = "com.huawei.hms";
                    if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                        return false;
                    }
                }
                return true;
            }
            str = "com.huawei.hwid";
            this.f424a = str;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
