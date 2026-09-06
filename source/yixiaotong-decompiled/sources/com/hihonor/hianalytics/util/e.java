package com.hihonor.hianalytics.util;

import android.content.Context;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.u;
import com.hihonor.hianalytics.hnha.v1;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e {
    public static long a() throws IllegalAccessException, InvocationTargetException {
        Context contextE = SystemUtils.e();
        if (contextE == null) {
            j2.g("DirectBootUtils", "getDirectBootDataTotalSize protectedContext null");
            return -1L;
        }
        try {
            return v1.b(new File(contextE.getFilesDir().getCanonicalPath(), "../shared_prefs"), "sp_name_direct_boot_event");
        } catch (Exception e) {
            j2.b("DirectBootUtils", SystemUtils.getDesensitizedException(e));
            return -1L;
        }
    }

    public static String a(String str, int i) {
        return !"_default_config_tag".equals(str) ? str + x.A + i : str;
    }

    public static boolean a(String str) {
        return u.a("sp_name_direct_boot_event", true, str, (Object) null);
    }

    public static String b(String str) {
        return u.a("sp_name_direct_boot_event", true, str, "");
    }
}
