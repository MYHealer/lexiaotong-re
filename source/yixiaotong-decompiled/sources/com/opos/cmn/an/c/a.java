package com.opos.cmn.an.c;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f5876a;

    public static String a(Context context) {
        return !TextUtils.isEmpty(f5876a) ? f5876a : com.opos.cmn.biz.a.b.a(context);
    }

    public static void a(final Context context, final String str) {
        f5876a = str;
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.cmn.an.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.biz.a.b.a(context, str);
            }
        });
        com.opos.cmn.an.f.a.c("BrandTool", "Mobile brand : " + str);
    }
}
