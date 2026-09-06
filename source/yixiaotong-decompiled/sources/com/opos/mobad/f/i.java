package com.opos.mobad.f;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f6906a;

    public i(Context context) {
        this.f6906a = context;
    }

    @Override // com.opos.mobad.f.g
    public File a(String str) {
        if (this.f6906a == null || TextUtils.isEmpty(str) || !com.opos.cmn.an.e.b.a.a()) {
            return null;
        }
        String strA = com.opos.cmn.d.c.a(this.f6906a);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        File file = new File(strA);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        String strA2 = com.opos.cmn.d.c.a(str);
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        return new File(file, strA2);
    }

    @Override // com.opos.mobad.f.g
    public File a(String str, String str2) {
        if (this.f6906a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !com.opos.cmn.an.e.b.a.a()) {
            return null;
        }
        String strA = com.opos.cmn.d.c.a(this.f6906a);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        File file = new File(strA + File.separator + str2);
        if (!file.exists()) {
            file.mkdirs();
            return null;
        }
        String strA2 = com.opos.cmn.d.c.a(str);
        if (TextUtils.isEmpty(strA2)) {
            return null;
        }
        return new File(file, strA2);
    }
}
