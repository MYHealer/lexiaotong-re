package com.yfanads.android.utils;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import com.stub.StubApp;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.core.f;
import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.thirdpart.gson.reflect.TypeToken;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.qapp.Val;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFUtil extends Util {
    public static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    private YFUtil() {
    }

    public static boolean checkSelfPermission(Context context, String str, int i) {
        return context != null && ActivityCompat.checkSelfPermission(context, str) == i;
    }

    public static boolean deleteDirectory(String str) {
        File[] fileArrListFiles;
        try {
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
            File file = new File(str);
            if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
                return false;
            }
            boolean zDeleteFile = true;
            for (File file2 : fileArrListFiles) {
                zDeleteFile = file2.isFile() ? deleteFile(file2.getAbsolutePath()) : deleteDirectory(file2.getAbsolutePath());
                if (!zDeleteFile) {
                    break;
                }
            }
            if (zDeleteFile) {
                return file.delete();
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        return file.isFile() && file.exists() && file.delete();
    }

    public static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String extractDomain(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.startsWith("http://")) {
            lowerCase = lowerCase.substring(7);
        } else if (lowerCase.startsWith("https://")) {
            lowerCase = lowerCase.substring(8);
        }
        if (lowerCase.startsWith("www.")) {
            lowerCase = lowerCase.substring(4);
        }
        int iIndexOf = lowerCase.indexOf(47);
        if (iIndexOf != -1) {
            lowerCase = lowerCase.substring(0, iIndexOf);
        }
        int iIndexOf2 = lowerCase.indexOf(58);
        return iIndexOf2 != -1 ? lowerCase.substring(0, iIndexOf2) : lowerCase;
    }

    public static long getFileSize(File file) {
        try {
            if (file.exists()) {
                return new FileInputStream(file).available();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static boolean isFileExit(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static Map<String, Object> jsonToMap(String str) {
        return (Map) new Gson().fromJson(str, new TypeToken<Map<String, Object>>() { // from class: com.yfanads.android.utils.YFUtil.1
        }.getType());
    }

    public static Application recoverApplication() {
        try {
            Application application = (Application) Class.forName(Val.AT).getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            if (application != null) {
                YFLog.info("[init] Successfully recovered context from ActivityThread: " + StubApp.getOrigApplicationContext(application.getApplicationContext()));
                return application;
            }
        } catch (Exception e) {
            YFLog.info("[init] Failed to recover context from ActivityThread: " + e.getMessage());
        }
        return null;
    }

    @Deprecated
    public static void switchMainThread(BaseEnsureListener baseEnsureListener) {
        switchMainThread("default", baseEnsureListener);
    }

    public static void switchMainThreadDelay(BaseEnsureListener baseEnsureListener, long j) {
        try {
            YFLog.high("[switchMainThreadDelay] " + j + "ms later force to main thread");
            Handler handler = MAIN_HANDLER;
            Objects.requireNonNull(baseEnsureListener);
            handler.postDelayed(new YFUtil$$ExternalSyntheticLambda0(baseEnsureListener), j);
        } catch (Throwable th) {
            YFLog.error("switchMainThreadDelay " + th.getMessage());
        }
    }

    public static double toDouble(String str, double d) {
        if (TextUtils.isEmpty(str)) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (Exception e) {
            e.printStackTrace();
            return d;
        }
    }

    public static float toFloat(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            e.printStackTrace();
            return f;
        }
    }

    public static int toInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                return (int) Double.parseDouble(str.trim());
            } catch (NumberFormatException unused) {
                return i;
            }
        }
    }

    public static long toLong(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return j;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
            int iMin = Math.min(bigDecimal.scale(), 6);
            if (iMin < 0) {
                iMin = 0;
            }
            return bigDecimal.setScale(iMin, RoundingMode.HALF_UP).longValue();
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static void switchMainThread(String str, BaseEnsureListener baseEnsureListener) {
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                baseEnsureListener.ensure();
            } else {
                Handler handler = MAIN_HANDLER;
                Objects.requireNonNull(baseEnsureListener);
                handler.post(new YFUtil$$ExternalSyntheticLambda0(baseEnsureListener));
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder("switchMainThread "));
        }
    }

    public static String extractDomains(String[] strArr) {
        if (strArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    String strExtractDomain = extractDomain(str.trim());
                    if (!TextUtils.isEmpty(strExtractDomain)) {
                        sb.append(strExtractDomain).append("|");
                    }
                } catch (Exception e) {
                    Log.e(Util.TAG, "extractDomainsFromArray " + e.getMessage());
                }
            }
        }
        return sb.toString();
    }

    public static String formatSize(long j) {
        if (j <= 0) {
            return "0B";
        }
        try {
            double d = j;
            int iLog10 = (int) (Math.log10(d) / Math.log10(1024.0d));
            return String.format("%.2f %s", Double.valueOf(d / Math.pow(1024.0d, iLog10)), new String[]{"B", "KB", "MB", "GB", "TB"}[iLog10]);
        } catch (Exception unused) {
            return "0B";
        }
    }
}
