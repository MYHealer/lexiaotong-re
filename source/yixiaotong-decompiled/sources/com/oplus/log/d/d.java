package com.oplus.log.d;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ml.camera.CountryCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f5817a = {null, null, null, null, null, null, null, null, null, null, "9.0", "9.5", "10.0", "10.5", null};

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f5818a = d.b("ro.rom.version");
    }

    public static int a() {
        Log.v("BrandPBuild", " getOSVERSION " + a.f5818a);
        for (int length = f5817a.length - 2; length >= 0; length--) {
            StringBuilder sbAppend = new StringBuilder(" VERSIONS[ ").append(length).append("]");
            String[] strArr = f5817a;
            Log.v("BrandPBuild", sbAppend.append(strArr[length]).toString());
            if (!TextUtils.isEmpty(a.f5818a) && !TextUtils.isEmpty(strArr[length]) && (a.f5818a.startsWith(strArr[length]) || a.f5818a.startsWith(g.o + strArr[length]) || a.f5818a.startsWith(g.p + strArr[length]))) {
                return length + 1;
            }
        }
        return 0;
    }

    public static String b() {
        return b("ro.rom.version");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception e) {
            if (!com.oplus.log.b.c()) {
                return "unknown";
            }
            e.printStackTrace();
            return "unknown";
        }
    }
}
