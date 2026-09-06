package com.yfanads.android.adx.utils;

import android.app.UiModeManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.byazt.tk.AdBaseConstants;
import com.yfanads.android.adx.components.base.e;
import com.yfanads.android.adx.download.DownloaderMgr;
import com.yfanads.android.adx.thirdpart.filedownload.util.FileDownloadUtils;
import com.yfanads.android.libs.utils.NamedThreadFactory;
import com.yfanads.android.libs.utils.RejectedExeHandler;
import java.io.File;
import java.net.URLEncoder;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AdxUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class b {
    public static long i;
    public static long j;
    public static final String[] c = {com.hihonor.adsdk.base.g.j.e.c.hnadsb, com.hihonor.adsdk.base.g.j.e.c.hnadsa, "__DENSITY__", "__DP_WIDTH__", "__DP_HEIGHT__", "__SCREEN_X__", "__SCREEN_Y__", "__TS__", "__TS_S__", "__EVENT_TIME_START__", "__EVENT_TIME_END__", "__IPV6LIST__"};
    public static final String[] d = {com.hihonor.adsdk.base.g.j.e.c.hnadsh, "__SHOW_TIME_SEC__", "__SHOW_DURATION__", "__MAX_SHOW_RATIO__"};
    public static final String[] e = {"__AD_W__", "__AD_H__", "__CLICK_TIME__", "__CLICK_TIME_SEC__", "__CLICK_DOWN_TIME__", "__DOWN_TS__", com.hihonor.adsdk.base.g.j.e.c.hnadsc, com.hihonor.adsdk.base.g.j.e.c.hnadsd, "__REL_DOWN_X__", "__REL_DOWN_Y__", "__DP_DOWN_X__", "__DP_DOWN_Y__", "__CLICK_UP_TIME__", "__UP_TS__", com.hihonor.adsdk.base.g.j.e.c.hnadse, com.hihonor.adsdk.base.g.j.e.c.hnadsf, "__REL_UP_X__", "__REL_UP_Y__", "__DP_UP_X__", "__DP_UP_Y__", "__DPLINK__", "__SLD__"};
    public static final String[] f = {"__X_MAX_ACC__", "__Y_MAX_ACC__", "__Z_MAX_ACC__", "__DPLINK__", "__SLD__"};
    public static final String[] g = {"__TURN_TIME__", "__TURN_X__", "__TURN_Y__", "__TURN_Z__", "__DPLINK__", "__SLD__"};
    public static final String[] h = {"__REASON__"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f9622a = new ThreadPoolExecutor(4, 8, 12, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new NamedThreadFactory("adx"), new RejectedExeHandler("adx"));
    public static final Handler b = new Handler(Looper.getMainLooper());

    public static boolean a(Context context, String str) {
        return context != null && ActivityCompat.checkSelfPermission(context, str) == 0;
    }

    public static boolean b() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = jCurrentTimeMillis - j;
        a.a("isAllowClick " + j2);
        boolean z = j2 > 1000;
        if (z) {
            j = jCurrentTimeMillis;
        }
        return z;
    }

    public static void c(String str) {
        if (str == null || str.isEmpty()) {
            a.b("apkSavePath is invalid");
            return;
        }
        Context context = com.yfanads.android.adx.service.d.b;
        if (context == null) {
            a.b("Context is null");
            return;
        }
        try {
            a.c("start install app");
            Intent intentB = b(context, str);
            if (intentB != null) {
                context.startActivity(intentB);
            } else {
                a.b("Failed to create install intent");
            }
        } catch (ActivityNotFoundException unused) {
            a.b("No activity found to handle install intent");
        }
    }

    public static String[] a(String[] strArr, String[] strArr2, ViewGroup viewGroup) {
        String strValueOf;
        String[] strArr3 = new String[22];
        if (viewGroup != null) {
            try {
                strValueOf = String.valueOf(viewGroup.getWidth());
            } catch (Exception e2) {
                e.a(e2, new StringBuilder("getClickValues exception "));
            }
        } else {
            strValueOf = "";
        }
        strArr3[0] = strValueOf;
        strArr3[1] = viewGroup != null ? String.valueOf(viewGroup.getHeight()) : "";
        long jCurrentTimeMillis = System.currentTimeMillis();
        strArr3[2] = String.valueOf(jCurrentTimeMillis);
        strArr3[3] = String.valueOf(jCurrentTimeMillis / 1000);
        int length = strArr.length;
        int length2 = strArr2.length;
        for (int i2 = 4; i2 < 22; i2++) {
            int i3 = i2 - 4;
            if (i3 < length) {
                strArr3[i2] = strArr[i3];
            } else {
                int i4 = i3 - length;
                if (i4 >= length2) {
                    break;
                }
                strArr3[i2] = strArr2[i4];
            }
        }
        return strArr3;
    }

    public static Intent b(Context context, String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setFlags(1);
            intent.setDataAndType(FileProvider.getUriForFile(context, context.getPackageName() + ".AdxFileProvider", file), AdBaseConstants.MIME_APK);
            intent.addFlags(268435456);
            return intent;
        }
        a.b("APK file does not exist or is not a file");
        return null;
    }

    public static String b(String str) {
        String strGenerateFileName = FileDownloadUtils.generateFileName(str);
        if (!TextUtils.isEmpty(strGenerateFileName) && !strGenerateFileName.endsWith(".apk")) {
            strGenerateFileName = strGenerateFileName.concat(".apk");
        }
        return FileDownloadUtils.generateFilePath(FileDownloadUtils.getDefaultSaveRootPath() + "/com/yfanads/ads/channel/adx", strGenerateFileName);
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public static boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - i > 1000;
        if (z) {
            i = jCurrentTimeMillis;
        }
        return z;
    }

    public static boolean a(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        return (uiModeManager != null && uiModeManager.getNightMode() == 2) || (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static boolean a(int i2, String str) {
        if (i2 == 1) {
            StringBuilder sb = new StringBuilder();
            ConcurrentHashMap concurrentHashMap = DownloaderMgr.b;
            DownloaderMgr.b.f9596a.getClass();
            String strGenerateFileName = FileDownloadUtils.generateFileName(str);
            if (!TextUtils.isEmpty(strGenerateFileName) && !strGenerateFileName.endsWith(".apk")) {
                strGenerateFileName = strGenerateFileName.concat(".apk");
            }
            return new File(sb.append(FileDownloadUtils.generateFilePath(FileDownloadUtils.getDefaultSaveRootPath() + "/com/yfanads/ads/channel/adx", strGenerateFileName)).append(".temp").toString()).exists();
        }
        if (i2 != 2) {
            return false;
        }
        ConcurrentHashMap concurrentHashMap2 = DownloaderMgr.b;
        DownloaderMgr.b.f9596a.getClass();
        String strGenerateFileName2 = FileDownloadUtils.generateFileName(str);
        if (!TextUtils.isEmpty(strGenerateFileName2) && !strGenerateFileName2.endsWith(".apk")) {
            strGenerateFileName2 = strGenerateFileName2.concat(".apk");
        }
        return new File(FileDownloadUtils.generateFilePath(FileDownloadUtils.getDefaultSaveRootPath() + "/com/yfanads/ads/channel/adx", strGenerateFileName2)).exists();
    }
}
