package com.opos.mobad.service.b;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.f.g;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7338a;

    public f(Context context) {
        this.f7338a = context;
    }

    public static final File a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        File file2 = new File(b(context));
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return new File(file2, file.getName());
    }

    public static final String a(Context context) {
        if (context == null) {
            return null;
        }
        String strA = com.opos.cmn.d.c.a(context);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA + File.separator + ".dynamic";
    }

    public static final String b(Context context) {
        if (context == null) {
            return null;
        }
        return a(context) + File.separator + ".unzip";
    }

    @Override // com.opos.mobad.f.g
    public File a(String str) {
        if (this.f7338a == null || TextUtils.isEmpty(str) || !com.opos.cmn.an.e.b.a.a()) {
            return null;
        }
        String strA = a(this.f7338a);
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
        if (this.f7338a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !com.opos.cmn.an.e.b.a.a()) {
            return null;
        }
        String strA = a(this.f7338a);
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        File file = new File(strA + File.separator + ".dynamic");
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

    public String b(String str) {
        File fileA = a(str);
        if (fileA != null) {
            return fileA.getAbsolutePath();
        }
        return null;
    }
}
