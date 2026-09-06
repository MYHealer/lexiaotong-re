package com.baidu.passbqt.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.baidu.passbqt.NoProguard;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class PassUtil implements NoProguard {
    public static String a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return packageInfo.signatures.length > 0 ? SecurityUtil.a(packageInfo.signatures[0].toByteArray(), false) : "";
        } catch (Throwable th) {
            Log.a(th);
            return "";
        }
    }
}
