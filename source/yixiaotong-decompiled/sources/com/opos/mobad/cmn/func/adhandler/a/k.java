package com.opos.mobad.cmn.func.adhandler.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6776a = com.opos.cmn.an.b.b.a("b2FwczovL21rL2R0P3BrZz0=");
    public final String b;

    public k(String str, String str2) {
        this.b = a(str, str2);
    }

    private static final String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        return f6776a + str + "&style=1&token=" + str2 + "&atd=true";
    }

    public boolean a() {
        return !TextUtils.isEmpty(this.b);
    }

    @Override // com.opos.mobad.cmn.func.adhandler.a.e
    public int b() {
        return 17;
    }
}
