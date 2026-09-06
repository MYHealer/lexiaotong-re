package com.byazt.th;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.byazt.bog.a;
import com.byazt.uk.i;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 78, 54})
public class ve {
    public static File c;
    public static File tt;
    public static File ve;

    private static void n() {
        if (c == null) {
            File file = new File(Zeus.getAppApplication().getFilesDir(), MediationConstant.ADN_PANGLE + i.ve);
            c = file;
            c(file);
        }
    }

    public static String c(File file) {
        if (file == null) {
            return null;
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }

    private static String c(String... strArr) {
        n();
        File file = c;
        if (strArr != null && strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return c(file);
    }

    public static String c() {
        n();
        return c.getPath();
    }

    public static String tt() {
        Application appApplication = Zeus.getAppApplication();
        if (tt == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                downloadDir = new File(appApplication.getFilesDir(), ".pangle" + i.tt);
            }
            tt = downloadDir;
        }
        return c(tt);
    }

    public static String ve() {
        Application appApplication = Zeus.getAppApplication();
        if (ve == null) {
            ve = new File(appApplication.getFilesDir(), ".pangle" + i.c);
        }
        return c(ve);
    }

    public static String uj() {
        File externalFilesDir;
        Application appApplication = Zeus.getAppApplication();
        try {
            if (!"mounted".equals(Environment.getExternalStorageState()) || (externalFilesDir = appApplication.getExternalFilesDir(".pangle" + i.tt)) == null) {
                return null;
            }
            return c(externalFilesDir);
        } catch (Exception e) {
            a.c(e);
            return null;
        }
    }

    public static String c(String str, int i) {
        n();
        File file = c;
        String[] strArr = {str, "version-".concat(String.valueOf(i))};
        for (int i2 = 0; i2 < 2; i2++) {
            String str2 = strArr[i2];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String c(String str) {
        return c(str);
    }

    public static String tt(String str, int i) {
        return new File(c(str, "version-".concat(String.valueOf(i)), "apk"), "base-1.apk").getPath();
    }

    public static String ve(String str, int i) {
        if (com.byazt.uq.i.u()) {
            return c(str, "version-".concat(String.valueOf(i)), "apk", "oat", com.byazt.xe.tt.c());
        }
        return c(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static String uj(String str, int i) {
        return c(str, "version-".concat(String.valueOf(i)), "lib");
    }

    public static String n(String str, int i) {
        return new File(c(str, "version-".concat(String.valueOf(i)), "apk", "temp"), "base-1.apk").getPath();
    }

    public static String a(String str, int i) {
        return new File(c(str, "version-".concat(String.valueOf(i)), "apk")).getPath();
    }

    public static String sp(String str, int i) {
        return new File(c(str, "version-".concat(String.valueOf(i)), "apk", "temp")).getPath();
    }

    public static String x(String str, int i) {
        if (com.byazt.uq.i.u()) {
            return c(str, "version-".concat(String.valueOf(i)), "apk", "temp", "oat", com.byazt.xe.tt.c());
        }
        return c(str, "version-".concat(String.valueOf(i)), "dalvik-cache");
    }

    public static boolean i(String str, int i) {
        return new File(c() + File.separator + str + File.separator + "version-" + i).exists();
    }

    public static String c(String str, int i, String str2) {
        return new File(c(str, "version-".concat(String.valueOf(i)), "dex"), str2).getPath();
    }

    public static File[] da(String str, int i) {
        String strC = c(str, "version-".concat(String.valueOf(i)), "dex");
        if (TextUtils.isEmpty(strC)) {
            return null;
        }
        return new File(strC).listFiles(new FileFilter() { // from class: com.byazt.th.ve.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return file.isFile() && file.getName().endsWith(".dex");
            }
        });
    }

    public static String sl(String str, int i) {
        return new File(c(str, "version-".concat(String.valueOf(i)), "config"), "config.json").getPath();
    }
}
