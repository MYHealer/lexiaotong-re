package com.meishu.sdk.core.utils;

import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: RewardTempUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4891a;
    public static final List<String> b = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: RewardTempUtil.java */
    public interface a {
        void a(boolean z);
    }

    public static File a() {
        try {
            File file = new File(AdSdk.getContext().getFilesDir(), "rwd_temps");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void b(String str) {
        try {
            String strA = a(str);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            File file = new File(a(), strA);
            if (file.exists()) {
                return;
            }
            List<String> list = b;
            if (list.contains(str)) {
                return;
            }
            list.add(str);
            File file2 = new File(a(), strA + "_temp");
            if (file2.exists()) {
                file2.delete();
            }
            z.a(str, (x) new b1(str, null, file2, file), false);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sbA = com.meishu.sdk.activity.a.a("([?&])");
        if (TextUtils.isEmpty(f4891a)) {
            f4891a = new String(f1.a("bXNfdXVpZA=="));
        }
        String string = sbA.append(f4891a).append("=[^&]*").toString();
        StringBuilder sbA2 = com.meishu.sdk.activity.a.a("$1");
        if (TextUtils.isEmpty(f4891a)) {
            f4891a = new String(f1.a("bXNfdXVpZA=="));
        }
        String strReplaceAll = str.replaceAll(string, sbA2.append(f4891a).append("=ABC").toString());
        if (TextUtils.isEmpty(strReplaceAll)) {
            return null;
        }
        return e0.a(strReplaceAll, "");
    }
}
