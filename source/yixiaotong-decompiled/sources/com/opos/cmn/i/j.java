package com.opos.cmn.i;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j {
    public static boolean a(Context context, String[] strArr) {
        if (context != null && strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!com.opos.cmn.an.h.d.a.a(context, str)) {
                    StringBuilder sb = new StringBuilder("don't have permission=");
                    if (str == null) {
                        str = "null";
                    }
                    com.opos.cmn.an.f.a.c("PermissionUtils", sb.append(str).toString());
                    return false;
                }
            }
        }
        return true;
    }
}
