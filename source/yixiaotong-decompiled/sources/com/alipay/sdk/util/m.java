package com.alipay.sdk.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1665a = "content://com.alipay.android.app.settings.data.ServerProvider/current_server";

    public static String a(Context context) {
        if (EnvUtils.isSandBox()) {
            return com.alipay.sdk.cons.a.b;
        }
        if (context == null) {
            return com.alipay.sdk.cons.a.f1630a;
        }
        String str = com.alipay.sdk.cons.a.f1630a;
        return TextUtils.isEmpty(str) ? com.alipay.sdk.cons.a.f1630a : str;
    }

    private static String b(Context context) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse(f1665a), null, null, null, null);
        String string = null;
        if (cursorQuery != null && cursorQuery.getCount() > 0) {
            string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex("url")) : null;
            cursorQuery.close();
        }
        return string;
    }
}
