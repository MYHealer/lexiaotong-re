package com.fancy;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c9 {
    public static String _a(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String _a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            stringBuffer.append(cArr[(b & 240) >> 4]);
            stringBuffer.append(cArr[b & 15]);
            if (i < length - 1) {
                stringBuffer.append(x.bQ);
            }
        }
        return stringBuffer.toString();
    }

    public static boolean _a(Context context, String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            return z;
        }
        try {
            return new File("storage/emulated/0/Android/data/" + str).exists();
        } catch (Exception unused2) {
            return false;
        }
    }
}
