package com.kwad.sdk.api.loader;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class j {
    private static File aIg;
    private static final String aIh;

    private static boolean Ev() {
        return Build.VERSION.SDK_INT == 30 || Build.VERSION.SDK_INT == 31 || Build.VERSION.SDK_INT == 32;
    }

    static {
        aIh = Ev() ? "dynamic_apk" : "dynamic.apk";
    }

    private static File i(File file) {
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        if (file.exists() && file.isDirectory()) {
            return file;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!(file.exists() && file.isDirectory()) && com.kwad.sdk.api.a.pe.booleanValue()) {
            throw new RuntimeException("Can not ensureDir:" + file);
        }
        return file;
    }

    private static File br(Context context) {
        if (aIg == null) {
            aIg = i(new File(context.getApplicationInfo().dataDir, "ksad_dynamic"));
        }
        return aIg;
    }

    static File v(Context context, String str) {
        return new File(br(context), "dynamic-" + System.currentTimeMillis() + com.huawei.openalliance.ad.constant.x.A + str + ".apk");
    }

    static String w(Context context, String str) {
        return i(new File(br(context), "apk-" + str)).getPath();
    }

    static File x(Context context, String str) {
        return i(new File(br(context), "apk-" + str));
    }

    static String y(Context context, String str) {
        return new File(w(context, str), aIh).getPath();
    }

    static String z(Context context, String str) {
        return i(new File(w(context, str), "dex")).getPath();
    }

    static String A(Context context, String str) {
        return i(new File(w(context, str), "libs")).getPath();
    }

    static void h(File file) {
        if (file == null) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null && fileArrListFiles.length > 0) {
            for (File file2 : fileArrListFiles) {
                h(file2);
            }
        }
        file.delete();
    }

    static void j(File file) {
        try {
            h(file);
        } catch (Exception unused) {
        }
    }

    static void B(final Context context, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.kwad.sdk.api.a.a.a(new com.kwad.sdk.api.a.b() { // from class: com.kwad.sdk.api.loader.j.1
            @Override // com.kwad.sdk.api.a.b
            public final void doTask() {
                try {
                    File[] fileArrListFiles = j.x(context, str).getParentFile().listFiles();
                    if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                        return;
                    }
                    for (File file : fileArrListFiles) {
                        if (i.N(str, file.getName().substring(file.getName().indexOf(com.huawei.openalliance.ad.constant.x.A) + 1))) {
                            j.h(file);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        });
    }
}
