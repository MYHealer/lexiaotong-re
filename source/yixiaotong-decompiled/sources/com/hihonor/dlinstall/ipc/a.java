package com.hihonor.dlinstall.ipc;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class a extends n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f3591a;
    public final m b;

    /* JADX INFO: renamed from: com.hihonor.dlinstall.ipc.a$a, reason: collision with other inner class name */
    public static class C0475a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3592a;
        public String b;

        public C0475a(int i, String str) {
            this.f3592a = i;
            this.b = str;
        }
    }

    public a(m mVar, b bVar) {
        this.b = mVar;
        this.f3591a = bVar;
    }

    public final C0475a a(String str, Bundle bundle) {
        long j = bundle.getLong("key_service_version");
        int i = bundle.getInt("key_channel");
        String string = bundle.getString("key_package_name");
        if (TextUtils.isEmpty(string)) {
            com.hihonor.dlinstall.page.a.b("BnDlInstallListener", "getBaseInfo: pkgName is null, from is " + str);
            return null;
        }
        String str2 = "getBaseInfo: pkgName is " + string + ",channel is " + i + ",serviceVersion is " + j + ",from is " + str;
        return new C0475a(i, string);
    }
}
