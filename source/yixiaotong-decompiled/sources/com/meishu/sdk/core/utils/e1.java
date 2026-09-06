package com.meishu.sdk.core.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.meishu.sdk.core.AdSdk;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: SPEncryptUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f4901a = Charset.forName("UTF-8");

    public static String a(String str, String str2) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            string = AdSdk.getSharedPreferences().getString(str, null);
            try {
                if (!TextUtils.isEmpty(string)) {
                    string = new String(Base64.decode(string, 0), f4901a);
                }
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            string = null;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public static void b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            AdSdk.getSharedPreferences().edit().putString(str, Base64.encodeToString(str2.getBytes(f4901a), 0)).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
