package com.byazt.xe;

import android.content.Context;
import android.content.SharedPreferences;
import com.byazt.uq.i;
import com.bytedance.pangle.util.MethodUtils;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1093, 13})
public class tt {
    public static int c = 1;
    public static int tt = 2;

    public static SharedPreferences c(Context context) {
        return com.byazt.ut.a.getKVStore(StubApp.getOrigApplicationContext(context.getApplicationContext()), "plugin_oat_info", 0);
    }

    public static String[] c(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("dex2oat");
        arrayList.add("--runtime-arg");
        arrayList.add("-classpath");
        arrayList.add("--runtime-arg");
        arrayList.add("&");
        arrayList.add("--instruction-set=" + c());
        if (i == c) {
            if (i.u()) {
                arrayList.add("--compiler-filter=quicken");
            } else {
                arrayList.add("--compiler-filter=interpret-only");
            }
        } else if (i == tt) {
            arrayList.add("--compiler-filter=speed");
        }
        arrayList.add("--dex-file=".concat(String.valueOf(str)));
        arrayList.add("--oat-file=".concat(String.valueOf(str2)));
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String c() {
        try {
            return (String) MethodUtils.invokeStaticMethod(Class.forName("dalvik.system.VMRuntime"), "getCurrentInstructionSet", new Object[0]);
        } catch (Exception e) {
            com.byazt.bog.a.c(e);
            return null;
        }
    }

    public static String c(String str) {
        String strSubstring = str.substring(str.lastIndexOf("/") + 1);
        String strSubstring2 = strSubstring.substring(strSubstring.lastIndexOf("."));
        if (".dex".equals(strSubstring2)) {
            return strSubstring;
        }
        if (".zip".equals(strSubstring2) || ".apk".equals(strSubstring2)) {
            return strSubstring.replace(strSubstring2, ".odex");
        }
        return strSubstring + ".odex";
    }

    public static String tt(String str) {
        String strSubstring = str.substring(str.lastIndexOf("."));
        if (".dex".equals(strSubstring)) {
            return strSubstring;
        }
        return (".zip".equals(strSubstring) || ".apk".equals(strSubstring)) ? ".odex" : str + ".odex";
    }

    public static boolean c(String str, String str2) {
        return c.c(c(str, str2, c));
    }

    public static boolean c(String... strArr) {
        for (String str : strArr) {
            File file = new File(str);
            if (!file.exists() || !a.c(file)) {
                return false;
            }
        }
        return true;
    }
}
