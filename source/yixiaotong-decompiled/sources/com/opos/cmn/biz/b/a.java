package com.opos.cmn.biz.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.opos.cmn.biz.a.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f5965a = "a";

    public static final boolean a(Context context, String str) {
        if (context == null) {
            com.opos.cmn.an.f.a.b(f5965a, "executeBrowser with null context");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b(f5965a, "executeBrowserWeb with null url");
            return false;
        }
        String strB = c.b(context);
        com.opos.cmn.an.f.a.b(f5965a, "getBrowserName=" + strB);
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            intent.setClassName(strB, "com.android.browser.BrowserActivity");
            intent.addFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            Log.e(f5965a, "executeBrowserWeb fail", e);
            return false;
        }
    }
}
