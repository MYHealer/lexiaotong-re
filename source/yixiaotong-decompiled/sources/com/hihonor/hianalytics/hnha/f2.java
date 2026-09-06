package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.text.TextUtils;
import client.android.yixiaotong.util.TimeUtils;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class f2 {
    public static Long a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.valueOf(new SimpleDateFormat(TimeUtils.FORMATDATETIME1).parse(str).getTime());
        } catch (ParseException unused) {
            j2.g("V1Common", "timestampAdapter: convertBisdkTime failed to parse time");
            return -1L;
        }
    }

    public static boolean a(Context context) {
        return com.hihonor.hianalytics.util.p.a("global_v2", "v1cacheHandleFlag", false);
    }

    public static void b(Context context) throws IllegalAccessException, InvocationTargetException {
        com.hihonor.hianalytics.util.p.b("global_v2", "v1cacheHandleFlag", true);
    }
}
