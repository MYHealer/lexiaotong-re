package com.yfanads.android.utils;

import android.os.Process;
import android.util.Log;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.db.e;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.utils.log.DateFileNameGenerator;
import com.yfanads.android.utils.log.DateLogContentGenerator;
import com.yfanads.android.utils.log.LogFileBean;
import com.yfanads.android.utils.log.LogLevelInterceptImpl;
import com.yfanads.android.utils.log.printer.FilePrinter;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class YFLog {
    private static final String LOG = "YFAds";
    private static final String TRACE_TAG = "trace";
    static boolean isDebug;
    private static volatile FilePrinter mFilePrinter;

    private YFLog() {
    }

    public static void debug(String str) {
        log(str, 3);
    }

    public static void error(String str) {
        if (isDebug()) {
            log(str, 6);
            logWriterFile(str, 6);
        }
    }

    private static String getAppPackageName() {
        return Util.getAppPackageName(YFAdsManager.getInstance().getContext());
    }

    public static void high(String str) {
        if (isDebug()) {
            log(e.a("[H] ", str), 3);
            logWriterFile(e.a("[H] ", str), 3);
        }
    }

    public static void info(String str) {
        log(str, 4, true);
    }

    public static boolean isDebug() {
        return UrlConst.isTestEnv() || isDebug;
    }

    private static void log(String str, int i) {
        log(str, i, isDebug());
    }

    private static void log2File(int i, String str, String str2) {
        if (str2 == null) {
            return;
        }
        makeFilePrinter();
        if (mFilePrinter == null) {
            error("mFilePrinter is null, return.");
        } else {
            mFilePrinter.println(new LogFileBean(i, str, Process.myPid() + x.A + Thread.currentThread().getId() + PPSLabelView.Code + getAppPackageName() + PPSLabelView.Code + str2));
        }
    }

    private static void logPrint(int i, String str) {
        if (i == 2) {
            Log.v("YFAds", str);
            return;
        }
        if (i == 4) {
            Log.i("YFAds", str);
            return;
        }
        if (i == 5) {
            Log.w("YFAds", str);
        } else if (i != 6) {
            Log.d("YFAds", str);
        } else {
            Log.e("YFAds", str);
        }
    }

    private static void logWriterFile(String str, int i) {
        while (str.length() > 1024) {
            try {
                log2File(i, "YFAds\n", str);
                str = str.substring(1024);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        log2File(i, "YFAds", str);
    }

    public static void traceDebug(String str) {
        high("trace " + str, 4);
    }

    public static void warn(String str) {
        if (isDebug()) {
            log(str, 5);
            logWriterFile(str, 5);
        }
    }

    public static void enableUploadLogFile(boolean z) {
        if (mFilePrinter != null) {
            mFilePrinter.switchUploadLogFile(z);
        }
    }

    private static void log(String str, int i, boolean z) {
        if (z) {
            while (str.length() > 1024) {
                try {
                    logPrint(i, str.substring(0, 1024));
                    str = str.substring(1024);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            logPrint(i, str);
        }
    }

    public static void debug(Object obj) {
        if (obj == null) {
            obj = "<Def>";
        }
        log(obj.toString(), 3);
    }

    private static void makeFilePrinter() {
        if (mFilePrinter != null) {
            return;
        }
        mFilePrinter = new FilePrinter.Builder(YFAdsManager.getInstance().getContext().getCacheDir() + File.separator + "yflog").logMaxSize(CacheDataSink.DEFAULT_FRAGMENT_SIZE).logUploadIntervalTime(60000).logLevelIntercept(new LogLevelInterceptImpl(2)).logContentGenerator(new DateLogContentGenerator()).fileNameGenerator(new DateFileNameGenerator()).build();
    }

    public static void high(String str, int i) {
        if (isDebug()) {
            log(e.a("[H] ", str), i);
            logWriterFile(e.a("[H] ", str), i);
        }
    }
}
