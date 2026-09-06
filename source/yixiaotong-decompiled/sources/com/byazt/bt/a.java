package com.byazt.bt;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.dna.or;
import com.byazt.dna.qp;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 34})
public class a {
    public static int c;
    public static int tt;

    public static String c(com.byazt.dna.c cVar) {
        StringBuilder sb = new StringBuilder();
        try {
            if (c()) {
                sb.append("MIUI-");
            } else if (tt()) {
                sb.append("FLYME-");
            } else {
                String strTt = tt(cVar);
                if (c(strTt, cVar)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strTt)) {
                    sb.append(strTt).append(com.huawei.openalliance.ad.constant.x.A);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static boolean c() {
        if (c == 0) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    c = 1;
                } else {
                    c = 2;
                }
            } catch (Exception unused) {
            }
        }
        return c == 1;
    }

    public static boolean tt() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String tt(com.byazt.dna.c cVar) {
        return tt("ro.build.version.emui", cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String tt(String str, com.byazt.dna.c cVar) {
        String strVe;
        try {
            strVe = ve(cVar);
            try {
                if (TextUtils.isEmpty(strVe)) {
                    final com.byazt.bwm.a aVar = new com.byazt.bwm.a(new c(str, cVar), 5, 2);
                    ((qp) com.byazt.ut.uj.getService("thread_service")).getIoExecutor().execute(new com.byazt.bwm.sp("getSystemPropertyTask") { // from class: com.byazt.bt.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.run();
                        }
                    });
                    strVe = (String) aVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strVe = "";
        }
        return strVe == null ? "" : strVe;
    }

    private static String ve(com.byazt.dna.c cVar) {
        try {
            return x.c("rom_info", cVar).get("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 274, 464})
    public static class c implements Callable<String> {
        public String c;
        public com.byazt.dna.c tt;

        public c(String str, com.byazt.dna.c cVar) {
            this.c = str;
            this.tt = cVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            System.currentTimeMillis();
            String strC = a.c(this.c);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(strC)) {
                try {
                    x.c("rom_info", this.tt).put("rom_property_info", strC);
                } catch (Throwable unused) {
                }
            }
            return strC;
        }
    }

    public static String c(String str) {
        or orVar = (or) com.byazt.ut.uj.getService("system_info");
        return orVar != null ? orVar.get(str) : "";
    }

    public static String ve() {
        String str = Build.DISPLAY + "_" + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (c()) {
            return "miui_" + str;
        }
        if (uj()) {
            return "huawei_" + str;
        }
        if (str2.toLowerCase(Locale.ROOT).contains("oppo")) {
            return "oppo_" + str;
        }
        if (str2.toLowerCase(Locale.ROOT).contains("vivo")) {
            return "vivo_" + str;
        }
        return str2.toLowerCase(Locale.ROOT).contains("oneplus") ? "oneplus_" + str : str;
    }

    public static boolean uj() {
        if (tt == 0) {
            try {
                if (Class.forName("com.huawei.system.BuildEx") != null) {
                    tt = 1;
                } else {
                    tt = 2;
                }
            } catch (Exception unused) {
            }
        }
        return tt == 1;
    }

    public static boolean c(String str, com.byazt.dna.c cVar) {
        if (TextUtils.isEmpty(str)) {
            str = tt(cVar);
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || n();
    }

    public static boolean n() {
        try {
            return (!TextUtils.isEmpty(Build.BRAND) && Build.BRAND.toLowerCase().startsWith("huawei")) || (!TextUtils.isEmpty(Build.MANUFACTURER) && Build.MANUFACTURER.toLowerCase().startsWith("huawei"));
        } catch (Throwable unused) {
            return false;
        }
    }
}
