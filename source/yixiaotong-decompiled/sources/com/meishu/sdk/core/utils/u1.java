package com.meishu.sdk.core.utils;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meishu.sdk.core.loader.aac;

/* JADX INFO: compiled from: bq.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u1 {
    public static Intent a(String str, Context context) {
        String strB;
        String strB2;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Intent uri = Intent.parseUri(str, 0);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            uri.setSelector(null);
            uri.setFlags(268435456);
            if (context != null && uri.resolveActivity(context.getPackageManager()) == null) {
                return null;
            }
            ah ahVar = new ah();
            try {
                strB = f1.b(aac.dd);
            } catch (Exception e) {
                e.printStackTrace();
                strB = "";
            }
            ahVar.d(strB);
            try {
                strB2 = f1.b(aac.df);
            } catch (Exception e2) {
                e2.printStackTrace();
                strB2 = "";
            }
            return (Intent) ahVar.c(uri, strB2, "");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
