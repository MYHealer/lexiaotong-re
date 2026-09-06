package com.opos.cmn.biz.web.c.a.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.byazt.tk.AdBaseConstants;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a {
    public static int a() {
        return 201;
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return com.opos.cmn.an.h.c.a.d(context) ? com.opos.cmn.an.h.c.a.h(context) : "nonet";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("JSUtils", "", e);
            return "";
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            if (com.opos.cmn.an.d.a.a(str)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.parse(str), AdBaseConstants.MIME_APK);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("JSUtils", "", e);
            return false;
        }
    }
}
